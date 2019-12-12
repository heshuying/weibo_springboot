#spring boot环境搭建步骤：
1、创建maven的javase工程
2、pom文件中增加：
   <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>2.1.8.RELEASE</version>
     </parent>
     
    依赖中增加：
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
3、增加mybatis-plug支持
   参考文章地址：https://mp.baomidou.com/guide/quick-start.html#%E5%BC%80%E5%A7%8B%E4%BD%BF%E7%94%A8
   示例源码git地址：https://github.com/baomidou/mybatis-plus-samples
