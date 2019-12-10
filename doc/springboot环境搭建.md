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
