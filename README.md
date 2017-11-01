# BeautyJavaSwingRobot
结合BeautyEye开源UI框架实现的较美观的Java桌面程序，主要功能就是图灵机器人和一个2345网站万年历的抓取。。。。
### 1，效果图：
####   主要界面图
![image](https://github.com/Snailclimb/BeautyJavaSwingRobot/blob/master/Images/%E4%B8%BB%E8%A6%81%E7%95%8C%E9%9D%A2%E6%95%88%E6%9E%9C%E5%9B%BE.png)
####   机器人效果图
![image](https://github.com/Snailclimb/BeautyJavaSwingRobot/blob/master/Images/%E6%9C%BA%E5%99%A8%E4%BA%BA%E6%95%88%E6%9E%9C%E5%9B%BE.png)
####   身份证查询效果图
![image](https://github.com/Snailclimb/BeautyJavaSwingRobot/blob/master/Images/%E8%BA%AB%E4%BB%BD%E8%AF%81%E6%9F%A5%E8%AF%A2%E6%95%88%E6%9E%9C%E5%9B%BE.png)
### 2，图形化界面万年历功能实现
### **使用工具**：
httpClient+jsoup
　　**简单介绍** ：HttpClient 是 Apache Jakarta Common 下的子项目，可以用来提供高效的、最新的、功能丰富的支持 HTTP 协议的客户端编程工具包，并且它支持 HTTP 协议最新的版本和建议。(来自360百科，维基百科没这个名词？尴尬).jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。(来自360百科)

###  **httpClient使用方法**：
（更多请参考博客：http://blog.csdn.net/wangpeng047/article/details/19624529/或者官网httpClient:http://hc.apache.org/httpcomponents-client-5.0.x/index.html）
使用HttpClient发送请求、接收响应很简单，一般需要如下几步即可。
1. 创建HttpClient对象。
2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。
3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。
4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。
5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。
6. 释放连接。无论执行方法是否成功，都必须释放连接
### **jsoup使用方法**：
请参考：
 jsoup开发指南,jsoup中文使用手册,jsoup中文文档 ：
  http://www.open-open.com/jsoup/
Jsoup解析Html教程 | xdemo.org
  http://www.xdemo.org/jsoup-html-parse/
Jsoup解析HTML实例及文档方法详解_java_脚本之家  http://www.jb51.net/article/43485.htm
### 2，机器人功能实现
　　图形界面我用JAVA SWING中的JDialog做的，本来是准备用android studio 做一个界面类似微信的聊天机器人的，因为之前嫌弃AS太占内存加上不想搞安卓了就卸载了，所以后面有时间再做，原理很简单，可以很方便移植到其他项目。
　　robot.java（机器人功能类）中有一段这样的代码.下面的API是我自己申请的，可以去图灵官网上申请创建一个属于自己的机器人。下面有申请方法。
```java
		// 接入机器人，输入问题
		String APIKEY = "401415ff3f1245e1a487a82974bb7307";
		String INFO = URLEncoder.encode(quesiton, "utf-8");// 这里可以输入问题
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();
```
先进入图灵官网
![image](https://github.com/Snailclimb/BeautyJavaSwingRobot/blob/master/Images/%E5%9B%BE%E7%81%B5%E5%AE%98%E7%BD%91.png)
