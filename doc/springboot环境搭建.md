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
   
4、mybatis-plug表结构对应代码生成
   参考文章地址：https://mp.baomidou.com/guide/generator.html#%E6%B7%BB%E5%8A%A0%E4%BE%9D%E8%B5%96
   pom依赖中添加：
     <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-generator</artifactId>
       <version>3.3.0</version>
     </dependency>
     <dependency>
       <groupId>org.apache.velocity</groupId>
       <artifactId>velocity-engine-core</artifactId>
       <version>2.1</version>
     </dependency>
   生成代码具体见类：MyBatisPlusGenerator
   
5、swaggerui支持
   参考文档地址：https://www.jianshu.com/p/a0caf58b3653
   pom依赖中添加：
     <dependency>
       <groupId>io.springfox</groupId>
       <artifactId>springfox-swagger2</artifactId>
       <version>${swagger.version}</version>
     </dependency>
     <dependency>
       <groupId>io.springfox</groupId>
       <artifactId>springfox-swagger-ui</artifactId>
       <version>${swagger.version}</version>
     </dependency>
   添加swagger配置文件：
     swagger:
       enable: true
       basePackage: com.eyesfree.weibo
       info:
         title: API文档
         description: API文档
         version: 1.0
         serviceUrl: http://zzfx.hoptest.haier.net

6、整合ali数据源
   pom中添加依赖：
       <dependency>
         <groupId>com.alibaba</groupId>
         <artifactId>druid-spring-boot-starter</artifactId>
         <version>${druid.version}</version>
       </dependency>
   配置文件中配置数据源、数据库连接信息
   
7、整合logback日志
   配置文件中添加日志文件地址配置
       logging:
         config: classpath:log/log-config-dev.xml
         
8、添加springboot定时任务
   添加定时任务类，方法上增加注解 @Scheduled(cron="0 26 09 * * ?")，并让定时任务类纳入spring容器管理
   启动类增加开启定时任务的注解：@EnableScheduling