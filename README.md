﻿# springboot3-jdk17-soap-demo
# springboot3-jdk17-soap-demo
Spring Boot 3 JDK 17 SOAP Demo
项目简介
这是一个基于 Spring Boot 3 和 JDK 17 的 SOAP 服务示例项目，展示了如何创建和消费 SOAP Web 服务。

功能
SOAP 服务器：提供一个简单的 SOAP Web 服务接口。
SOAP 客户端：演示如何调用 SOAP Web 服务并处理响应。
环境要求
JDK 17
Maven 3.x
安装和运行
克隆仓库：

bash
复制代码
git clone https://github.com/tianliu94321/springboot3-jdk17-soap-demo.git
cd springboot3-jdk17-soap-demo
构建项目：

bash
复制代码
mvn clean install
运行项目：

bash
复制代码
mvn spring-boot:run
使用
SOAP 服务器
服务启动后，SOAP 服务接口可以通过以下 WSDL 访问：

bash
复制代码
http://localhost:8080/ws/your-service.wsdl
SOAP 客户端
客户端代码演示了如何调用上述 SOAP 服务并处理响应。

目录结构
bash
复制代码
springboot3-jdk17-soap-demo
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── soapdemo
│   │   │               ├── config      # 配置文件
│   │   │               ├── controller  # 控制器
│   │   │               ├── service     # 服务层
│   │   │               └── model       # 数据模型
│   │   └── resources
│   │       ├── application.yml  # 配置文件
│   │       └── wsdl             # WSDL 文件
└── pom.xml
