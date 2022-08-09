package common.utils;

import okhttp3.Headers;

/**
 * OkHttp3通用 随机UA 请求头生成
 * @author Hoyoung
 */
public class HeaderUtil {
     private Headers.Builder builder;

    /**
     * 默认Header
     */
    private HeaderUtil(){
        builder = new Headers.Builder();
        builder.set("Accept", "*/*");
        builder.set("Accept-Encoding", "gzip, deflate, br");
        builder.set("accept-language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6,ja;q=0.5");
    }

    public static class Generator{
        Headers.Builder builder = new HeaderUtil().builder;
        public Generator() {
            builder.set("User-Agent", UAGenerator.randomOneUA());
        }

        public Generator setUA(String ua){
            builder.set("User-Agent", ua);
            return this;
        }
        public Generator setReferer(String refer){
            builder.set("referer", refer);
            return this;
        }

        public Generator setContentType(String ct){
            builder.set("Content-Type", ct);
            return this;
        }

        public Generator set(String key, String value){
            builder.set(key, value);
            return this;
        }


        public Headers.Builder generate(){
            return builder;
        }
    }

}
