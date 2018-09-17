# Xbird DataSource for MyBatis Generator

在 Spring Boot 项目中使用 [MyBatis Generator](http://www.mybatis.org/generator/) 自动生成代码。

## 快速开始

第1步：在你的 Spring Boot 项目中，添加 MyBatis Generator 相关插件和依赖：

```
<plugin>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-maven-plugin</artifactId>
	<version>1.3.2</version>
	<executions>
		<execution>
			<id>Generate MyBatis Artifacts</id>
			<phase>deploy</phase>
			<goals>
				<goal>generate</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<!-- 指定配置文件 -->
		<configurationFile>src/main/resources/mybatis-generator/generatorConfig.xml</configurationFile>
		<verbose>true</verbose>
		<overwrite>true</overwrite>
	</configuration>
	<dependencies>
		<dependency>
			<groupId>org.mybatis.generator</groupId>
			<artifactId>mybatis-generator-core</artifactId>
			<version>1.3.2</version>
		</dependency>
		<!-- 指定数据库驱动，本项目以MySQL为例 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.47</version>
		</dependency>
	</dependencies>
</plugin>
```

第2步：插件中指定了 MyBatis Generator 的配置文件，在这个位置创建 generatorConfig.xml 配置文件，并添加以下内容：

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<!-- 配置详解：https://www.jianshu.com/p/e09d2370b796 -->
<generatorConfiguration>
	<!-- 加载配置文件，可使用${propertyKey}的方式来引用配置项 -->
	<properties resource="mybatis-generator/mybatis.properties" />

	<context id="mysql" targetRuntime="MyBatis3Simple">
		<property name="autoDelimitKeywords" value="true" />
		<property name="javaFileEncoding" value="UTF-8" />

		<commentGenerator>
			<!-- 关闭注释 -->
			<property name="suppressAllComments" value="true" />
		</commentGenerator>

		<!-- 数据库连接 -->
		<jdbcConnection driverClass="${jdbc.driver}"
			connectionURL="${jdbc.url}" userId="${jdbc.user}"
			password="${jdbc.password}" />

		<!-- 类型处理器 -->
		<javaTypeResolver>
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>

		<!-- 实体类生成地址 -->
		<javaModelGenerator
			targetPackage="${model.targetPackage}"
			targetProject="${model.targetProject}">
			<property name="enableSubPackages" value="false" />
			<property name="trimStrings" value="true" />
		</javaModelGenerator>

		<!-- XML文件生成地址 -->
		<sqlMapGenerator
			targetPackage="${sqlmap.targetPackage}"
			targetProject="${sqlmap.targetProject}">
			<property name="enableSubPackages" value="false" />
		</sqlMapGenerator>

		<!-- 接口类生成地址 -->
		<javaClientGenerator
			targetPackage="${mapper.targetPackage}"
			targetProject="${mapper.targetProject}" type="${mapper.type}">
			<property name="enableSubPackages" value="false" />
		</javaClientGenerator>

		<!-- 指定要生成的表和对应的实体名，支持一个或多个 -->
		<table tableName="audit" domainObjectName="Audit" />
	</context>
</generatorConfiguration>
```

第3步：在同目录下创建 mybatis.properties 属性文件：

```
## JDBC
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/apolloconfigdb
jdbc.user=apollo
jdbc.password=apollo

## Model
model.targetPackage=xbird.datasource.mybatis.generator.model
model.targetProject=src/main/java

## SqlMap
sqlmap.targetPackage=mapper
sqlmap.targetProject=src/main/resources

## Mapper
mapper.targetPackage=xbird.datasource.mybatis.generator.mapper
mapper.targetProject=src/main/java
mapper.type=XMLMAPPER
```

到此，使用 MyBatis Generator 工具自动生成代码的相关配置就完成了。最后，只需在 pom.xml文件所在的目录下执行插件命令即可自动生成代码：

```
mvn mybatis-generator:generate
```

## 参考

- [Mybatis Generator最完整配置详解](https://www.jianshu.com/p/e09d2370b796)