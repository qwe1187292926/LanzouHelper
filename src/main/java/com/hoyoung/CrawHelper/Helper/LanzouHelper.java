package com.hoyoung.CrawHelper.Helper;

import com.hoyoung.CrawHelper.common.entity.LanzouCrawEntity;
import com.hoyoung.CrawHelper.common.utils.HeaderUtil;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 蓝奏下载直接链接获取工具
 * 调用 getResource() 即可
 *
 * @author Hoyoung
 */
public class LanzouHelper {
    static final Pattern mainHostRegex = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(?:com\\.cn|net\\.cn|org\\.cn|com|net|org|cn|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
    static final Pattern fullHostRegex = Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);

    private LanzouHelper() {
    }

    public static LanzouCrawEntity getResource(String url) {

        String fullHost = getFullHost(url);

        // 添加蓝奏云特有的header
        Headers headers = new HeaderUtil.Generator().set("Upgrade-Insecure-Requests", "1").setReferer(url).generate().build();

        String name = null, size = null;
        try {
            // 加载页面
            Document doc = Jsoup.connect(url).get();

            // 获取文件名和大小
            Elements title1 = doc.select("div[style=font-size: 30px;text-align: center;padding: 56px 0px 20px 0px;]");
            if (title1.size() != 0) {
                name = title1.get(0).html();
            } else {
                name = doc.select("#filenajax").html();
            }

            Elements size1 = doc.select("meta[name=description]");
            if (size1.size() != 0) {
                size = regex(size1.attr("content"), "\\d.\\d(?: )*[A-Za-z]+");
            }

            // 获取与拼接下载页（iframe）地址
            Elements realPage = doc.select("iframe");
            String realUrl = "https://" + fullHost + realPage.attr("src");
            doc = Jsoup.connect(realUrl).get();

            // 正则分析动态参数
            String js = doc.select("script[type=text/javascript]").get(1).html();
            String sign = getValue("sign", js);
            String action = getValue("action", js);
            String signs = getValue("ajaxdata", js);
            String webSignKey = getValue("cwebsignkeyc", js);
            String webSign = "";
            String apiUrl = "https://" + fullHost + getValue("url", js);

            // OkHttp 获取直链
            OkHttpClient client = new OkHttpClient();
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("sign", sign)
                    .add("action", action)
                    .add("signs", signs)
                    .add("websign", webSign)
                    .add("websignkey", webSignKey)
                    .add("ves", "1");
            RequestBody formBody = builder.build();
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .post(formBody)
                    .headers(headers)
                    .build();
            String dl;
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                String body = response.body().string();
                dl = getValue("dom", body).replace("\\/", "/") + "/file/" + getValue("url", body).replace("\\/", "/");
            }

            // 返回蓝奏云对象
            LanzouCrawEntity lanzouCrawEntity = new LanzouCrawEntity(name, size, dl);
            return lanzouCrawEntity;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 正则匹配js中设定值，或者匹配json
     * eg: var key = value;
     *
     * @param key
     * @param json
     * @return
     */
    private static String getValue(String key, String json) {
        return regex(json, "(?<=" + key + "['\"]?( )?[:=]( )?['\"]).+?(?=['\"])");
    }

    private static String getMainHost(String url) {
        Matcher matcher = mainHostRegex.matcher(url);
        if (matcher.find()) {
            return (matcher.group());
        }
        return null;
    }

    private static String regex(String words, String regex) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(words);
        if (matcher.find()) {
            return (matcher.group());
        }
        return null;
    }

    private static String getFullHost(String url) {
        Matcher matcher = fullHostRegex.matcher(url);
        if (matcher.find()) {
            return (matcher.group());
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList<>();
        //企业链接
        urls.add("https://macwk.lanzouo.com/iRH0wwq0m8d");
        //个人链接
        urls.add("https://vincentapps.lanzouo.com/i4uS3lmp56j");

        //输出
        urls.stream().map(LanzouHelper::getResource).forEach(System.out::println);
    }


}
