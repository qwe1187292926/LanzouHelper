import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanzouHelper {
    // 公用标准请求头
    static Headers.Builder builder = new Headers.Builder();
    static {
        builder.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        builder.add("Accept-Encoding", "gzip, deflate");
        builder.add("Upgrade-Insecure-Requests", "1");
        builder.add("accept-language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6,ja;q=0.5");
        builder.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
    }


    public static Lanzou getLanZouRealLink(String url) {
        String fullHost = getFullHost(url);

        // 添加蓝奏云特有的header
        Headers headers = builder.set("referer", url).build();

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
            String sign = getJsonValue("sign", js);
            String action = getJsonValue("action", js);
            String signs = getJsonValue("ajaxdata", js);
            String webSignKey = getJsonValue("websignkey", js);
            String webSign = "";
            String apiUrl = "https://" + fullHost + getJsonValue("url",js);


            // OkHttp 获取直链
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("sign", sign)
                    .add("action", action)
                    .add("signs", signs)
                    .add("websign", webSign)
                    .add("websignkey", webSignKey)
                    .add("ves", "1")
                    .build();
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .post(formBody)
                    .headers(headers)
                    .build();
            String dl;
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                String body = response.body().string();
                dl = getJsonValue("dom", body).replace("\\/", "/") + "/file/" + getJsonValue("url", body).replace("\\/", "/");
            }

            // 返回蓝奏云对象
            return new Lanzou(name, size, dl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getJsonValue(String key, String json) {
        return regex(json, "(?<=" + key + "['\"]?( )?[:=]( )?['\"]).+?(?=['\"])");
    }

    private static String getMainHost(String url) {
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(?:com\\.cn|net\\.cn|org\\.cn|com|net|org|cn|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        if (matcher.find()) return (matcher.group());
        return null;
    }

    private static String regex(String words, String regex) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(words);
        if (matcher.find()) return (matcher.group());
        return null;
    }

    private static String getFullHost(String url) {
        Pattern p = Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        if (matcher.find()) return (matcher.group());
        return null;
    }

    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList<>();
        //企业链接
        urls.add("https://macwk.lanzouo.com/iRH0wwq0m8d");
        //个人链接
        urls.add("https://vincentapps.lanzouo.com/i4uS3lmp56j");
        for (String url :
                urls) {
            System.out.println(getLanZouRealLink(url));
        }
    }

    public static class Lanzou {
        String name;
        String size;
        String dlLink;

        public Lanzou(String name, String size, String dlLink) {
            this.name = name;
            this.size = size;
            this.dlLink = dlLink;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' + '\n' +
                    ", size='" + size + '\'' + '\n' +
                    ", dlLink='" + dlLink + '\'' + '\n';
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }

        public String getDlLink() {
            return dlLink;
        }
    }
}
