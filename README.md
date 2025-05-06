# sp817-springboot3-dubbo3-dependency

## 1. 使用说明

该项目主要基于 `JDK21` ，`SpringBoot3.4.2` ，`Dubbo3.3.4` ，`sa-token1.42.0` 搭建。

下载源码后打开使用 `mvn install` 打包到本地仓库在其他项目引入即可使用

## 2. 模块说明

 ```markdown
 basic-package          基础包
 dubbo-package          引入Dubbo以及Nacos，Nacos作为配置中心和注册中心
 redis-package          引入Redis，jedis作为连接池，使用jackson进行字段序列化
 sa-token-package       引入sa-token，redis持久化，jackson序列化，dubbo跨服务调用
 springboot-package     引入springboot
 web-package            引入web相关包，纯Dubbo需要排除该项
 mysql-fetch-plugin     用于连接mysql，使用hikari作为连接池，持久层框架mybatisplus
 service-core           包含所有package项
 langchain-plugin       用于与AI大模型进行交互
 ```

## 3. 依赖信息

```markdown
# basic 模块依赖
## 基础的工具包，被用于资源包，包含了常用的注解
org.projectlombok:lombok:1.18.36
com.alibaba.spring:spring-context-support:1.0.11
cn.hutool:hutool-all:5.8.8
org.apache.commons:commons-lang3:3.17.0
com.belerweb:pinyin4j:2.5.1
com.baomidou:mybatis-plus-annotation:3.5.10.1
com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:4.4.0
com.fasterxml.jackson.core:jackson-databind:2.18.2
com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.18.2
com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2
com.fasterxml.jackson.module:jackson-module-parameter-names:2.18.2
org.slf4j:slf4j-api:2.0.16
org.springframework.boot:spring-boot-starter-log4j2:3.4.2
# dubbo 模块依赖
## 使用dubbo微服务框架，配置存储于Nacos中
# 解决从nacos中获取json, yaml配置文件无法读取的问题
org.apache.dubbo:dubbo-spring-boot-starter:3.3.4
org.apache.dubbo:dubbo-nacos-spring-boot-starter:3.3.4
com.alibaba.boot:nacos-config-spring-boot-starter:0.3.0-RC
org.jetbrains.kotlin:kotlin-reflect:1.8.20
# redis 模块依赖
## 用于与redis进行交互，连接池使用jedis，使用jackson进行序列化操作
# 提供了封装的工具类
# 使用jackson进行字段的序列化
org.springframework.boot:spring-boot-starter-data-redis:3.4.2
redis.clients:jedis:5.2.0
com.fasterxml.jackson.core:jackson-databind:2.18.2
com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.18.2
com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2
com.fasterxml.jackson.module:jackson-module-parameter-names:2.18.2
org.projectlombok:lombok:1.18.36
# sa-token 模块依赖
## 用于服务的认证和鉴权
cn.dev33:sa-token-spring-boot-autoconfig:1.42.0
cn.dev33:sa-token-redis-template:1.42.0
cn.dev33:sa-token-jackson:1.42.0
cn.dev33:sa-token-dubbo3:1.42.0
# springboot 模块依赖
## 引入springboot
org.springframework.boot:spring-boot-starter:3.4.2
org.springframework.boot:spring-boot-starter-aop:3.4.2
org.springframework.boot:spring-boot-starter-test:3.4.2
org.springframework.boot:spring-boot-configuration-processor:3.4.2
org.slf4j:slf4j-api:2.0.16
org.springframework.boot:spring-boot-starter-log4j2:3.4.2
# web 模块依赖
## 引入springboot-web，纯dubbo服务可以排除该依赖
org.springframework.boot:spring-boot-starter-web:3.4.2
# mysql data fetch 模块依赖
## 用于从mysql中获取数据，连接池使用Hikari，持久层框架使用mybatis-plus
# 引入了分页查询的插件
mysql:mysql-connector-java:8.0.31
com.zaxxer:HikariCP:5.0.1
com.baomidou:mybatis-plus-spring-boot3-starter:3.5.10.1
com.baomidou:mybatis-plus-jsqlparser:3.5.10.1
com.baomidou:mybatis-plus-annotation:3.5.10.1
# langchain4j 模块依赖
## 用于与AI大模型进行交互
dev.langchain4j:langchain4j:1.0.0-beta3
dev.langchain4j:langchain4j-core:1.0.0-beta3
dev.langchain4j:langchain4j-community-dashscope-spring-boot-starter:1.0.0-beta3
dev.langchain4j:langchain4j-ollama-spring-boot-starter:1.0.0-beta3
dev.langchain4j:langchain4j-reactor:1.0.0-beta3
org.springframework.boot:spring-boot-starter-webflux:3.4.2
dev.langchain4j:langchain4j-mcp:1.0.0-beta3
dev.langchain4j:langchain4j-easy-rag:1.0.0-beta3
dev.langchain4j:langchain4j-milvus:1.0.0-beta3
dev.langchain4j:langchain4j-onnx-scoring:1.0.0-beta3
```

## 4. 后续目标

- 引入RabbitMQ，JavaMail邮件收发
- 引入easy-excel，七牛云SDK
- 引入Sentinel，SkyWalking