## 蓝奏云直链获取工具

##### lanzou direct link Helper

#### 一开始是想找个解析工具放在Android app里用来更新的，但发现Java版本的最短的都一年没有更新了，还是自己摸个简单的能用就好。

- 依赖 okhttp3，jsoup
- 支持新旧两种蓝奏云页面，文件名、大小和直链
- 单Java类，拷走就能用  

如果这有帮助到你，请你点个 **Star** 让我知道吧 :)

##### Example：

```java
import LanzouHelper;

class Test {
    
    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList<>();
        //企业链接
        urls.add("https://macwk.lanzouo.com/iRH0wwq0m8d");
        //个人链接
        urls.add("https://vincentapps.lanzouo.com/i4uS3lmp56j");

        for (String url : urls) {
            System.out.println(LanzouHelper.getLanZouRealLink(url));
        }

        /**
         name='Karabiner-Elements_14.3.0_(最低11.0)__macwk.com.dmg'
         size='9.8 M'
         dlLink='https://developer.lanzoug.com/file/?UjQHOQw9Dj8DClFpVmMHawA/UGgHEwRnAXRWMVNtUjpXOQIwCSZTKlNAATsFNFM/U2xVPlN4VCVWDlFmUztSfVJhB34MYQ4FA31R4VaeB4YAvlDoB9YENwE3Vn5TP1J6VwgCCgk5U2ZTZgEgBTpTfFNqVT9TYVR4VjVROlNoUnVSNAc5DD0OPwMKUW5WZgc7AG9QYwduBD4BP1ZhUzhSYFdxAjMJJ1M6UzcBZwVmU2RTMVVmUzRUYFZ3USdTf1JuUmAHYAxjDmsDelE2VjMHKQBoUGQHdwQ0ATZWaVNsUjVXMwJjCTZTP1M1AW8FY1NlUztVYFM4VDJWNFFkUzhSYFIzB2QMNA47A21RNFZmBzYAPlBlBz4EKAFiVj1TaFJ1VyICJgkxU3VTbAEzBWxTalMwVWZTPFRlVmVRcVN7UjpSPwc1DDcOZwNkUTFWNgczAGpQZgdpBDYBM1ZoUyFSfVdxAjMJOFNwUzgBZgVnU2ZTPFVgUz5Ub1ZlUWJTPVJ1UicHIAwmDmcDZFExVjEHMQBuUGAHawQzATdWaVMpUiZXPgIlCWlTNlM0AWEFf1NgUz5VflM9VGJWZ1F5Uz5SZVJg'

         name='JDCookie.apk'
         size='2.6 M'
         dlLink='https://developer.lanzoug.com/file/?B2FVawg5BjdVXAI6BDECbgc4DzdVQAdBA0cAaVJhUDpSO1JgXS4FMAQiATwHdVQzVmVSO1JoUw4EagBiXD1UZgc/VTIIYAZqVTYCYQRpAiUHOw95VTcHNwMzADNSOVBpUmBSNV0mBSEEIgFqB2FUZVY+UmZSIlNhBDEAKVwxVGYHKFU1CGQGMVViAjcEMgJiB20POVUyBzUDMwAxUmxQYFJkUjJdMAVjBGoBNQdlVDBWO1JkUmtTZAQ1AGVcZFQwB2ZVLAg0BiJVaAJyBCUCcAc4D3hVYwdhAzkAMFI6UGJSZlIwXTcFdwQmAT4HPlQwVmpSalI8U2cENwAzXDBUZgc2VTIIYAZrVS0CegR2AmUHMQ99VTcHNAMyADJSO1BhUmBSN103BWIEYwFxByZUJVZ7UmpSPFNnBDIANVwyVGUHNVU3CGwGYFUlAiEEOQJzB2APO1U7BzMDKgA0UjlQf1JjUjFdNgV/BGMBYQdh'
         */
    }
}
```
