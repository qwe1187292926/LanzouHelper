## 蓝奏云直链获取工具

##### lanzou direct link Helper

~~一开始是想找个解析工具放在Android app里用来更新的，但发现Java版本的最短的都一年没有更新了，还是自己摸个简单的能用就好。单Java类，拷走就能用~~  
  
该项目正无人期待的火热重写中~  
之前单Java类是方便了，但实在是十分耦合，结构不堪入目，刚开始工作，边学习边重写一下项目结构ing
改成jar包的形式发布，可直接下载target下的jar包食用，也可以自己folk打包
- 依赖 okhttp3，jsoup
- 支持新旧两种蓝奏云页面，文件名、大小和直链

如果这有帮助到你，请你点个 **Star** 让我知道吧 :)

**Example：**

```java
class Test {

    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList<>();
        //企业链接
        urls.add("https://macwk.lanzouo.com/iRH0wwq0m8d");
        //个人链接
        urls.add("https://vincentapps.lanzouo.com/i4uS3lmp56j");

        //输出
        urls.stream().map(LanzouHelper::getLink).forEach(System.out::println);

        /**
         * LanzouEntity{name='Karabiner-Elements_14.3.0_(最低11.0)__macwk.com.dmg', size='9.8 M'} , {dlLinks=[https://develope.lanzoug.com/file/?AWdSbFprVGVUXQA4V2JUOFZpBj4FEQdkAXRbPFFvWjIHaVtpDSIBeAUWBD4ENV0xUG9TOAUuBndVDVBnAWlbdAEyUitaN1RfVCoAsFefVNVW6Aa+BdQHNAE3W3NRPVpyB1hbUw09ATQFMAQlBDtdclBpUzkFNwYqVTZQOwE6W3wBZ1JsWmtUZVRdAD9XZ1RoVjkGNQVsBz0BP1tsUTpaaAchW2oNIwFoBWEEYgRnXWpQMlNgBWIGMlV0UCYBLVtnATNSNVo1VDFULQBnVzJUelY+BjIFdQc3ATZbZFFuWj0HY1s6DTIBbQVjBGoEYl1rUDhTZgVuBmBVN1BlAWpbaQFgUjFaYlRhVDoAZVdnVGVWaAYzBTwHKwFiWzBRalp9B3Jbfw01AScFOgQ2BG1dZFAzU2AFagY3VWZQcAEpWzMBbFJgWmFUPVQzAGBXNVRlVjwGOgVvBzABN1trUSNadQchW2oNPAEiBW4EYwRmXWlQM1NvBW4GPVVgUG8BZFt8AXRSdVpwVD1UMwBgVzBUYlY4BjYFaQcwATdbZFErWi4Hblt8DW0BZAVnBHwEYl1qUCRTZwVsBipVa1Bi]}
         * LanzouEntity{name='JDCookie.apk', size='2.6 M'} , {dlLinks=[https://develope.lanzoug.com/file/?UDZSbF5vAjMGD1FpBzJdMVNsV29RRFQSC09QOVRnVz0BaFFjAXICNwQiUG0HdVYxAzBUPV5kBVhWOFU3AWAHNVBoUjVeNgJuBmVRMgdqXXpTb1chUTNUZAs7UGNUP1duATNRNgF6AiYEIlA7B2FWZwNrVGBeLgU3VmNVfAFsBzVQf1IyXjICNQYxUWQHMV09UzlXYVE2VGYLO1BhVGpXZwE3UTEBbAJkBGpQZAdlVjIDblRiXmcFMlZnVTABOQdjUDFSK15iAiYGO1EhByZdL1NsVyBRZ1QyCzFQYFQ8V2UBNVEzAWsCcAQmUG8HPlYyAz9UbF4wBTFWZ1VjAW0HP1BlUjBeMgJhBn5RKQd1XTpTZVclUTNUZws6UGBUOFdmATBRMgFoAmEEZVAgByZWJwMuVGxeMAUxVmBVYAFvBzZQYlIwXjoCZAZ2UXIHOl0sUzRXY1E6VHgLPlBgVCZXZwE3USgBZQJi]}
         */
    }
}
```
