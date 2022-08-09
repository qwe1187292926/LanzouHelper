package utils;

import okhttp3.Headers;

public class HeaderUtil {
     private Headers.Builder builder;

    /**
     * 默认Header
     */
    private HeaderUtil(){
        builder = new Headers.Builder();
        builder.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        builder.add("Accept-Encoding", "gzip, deflate");
        builder.add("Upgrade-Insecure-Requests", "1");
        builder.add("accept-language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6,ja;q=0.5");
    }

    public static class Generator{
        Headers.Builder builder = new HeaderUtil().builder;
        public Generator() {
            builder.add("User-Agent", UAGenerator.randomOneUA());
        }

        public Generator setUA(String ua){
            builder.set("User-Agent", ua);
            return this;
        }

        public Headers.Builder generate(){
            return builder;
        }
    }

}
