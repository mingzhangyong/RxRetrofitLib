# RxRetrofitLib
rxJava, rxAndroid, Retrofit2.0的整合库。
RxRetrofitLib实现了Android客户端与服务器的网络交互并且避免了rxAndroid带来的内存泄露问题

>使用方法：

* 引入依赖

  修改project gradle
  ```
  repositories {
        ... ...
        maven { url 'https://www.jitpack.io' }
    }
  ```
  
  
  修改app gradle
  ```
  dependencies {
    ... ...
    compile 'com.github.mingzhangyong:RxRetrofitLib:1.0'
  }
```
* 定义自己的model类和对应的api类,示例如下
