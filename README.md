# Java安全

## Commons Collection

环境:JDK1.7(推荐)

Maven:

```xml
<dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>3.2</version>
        </dependency>
```

## tomcat内存马

2021/7/30

环境:tomcat7

运行时需要注意的

### 一、filter

在测试恶意的index.jsp时，请注释掉web.xml关于FilterDemo所有的filter-mapping，因为两个自定义的filter都直接返回响应体，index.jsp此时无法接收这样的响应体，所以会报错

### 二、导包

```java
Field req = request.getClass().getDeclaredField("request");
    req.setAccessible(true);
    Request request1 = (Request) req.get(request);
    StandardContext context = (StandardContext) request1.getContext();
```

由于Request类是在tomcat中的lib库中，所以，你需要手动导包

![](https://github.com/Kyo-w/javaAduit/blob/master/image/info.png)

还在努力中。。。

## Spring Data Rest



请根据系统版本修改active
