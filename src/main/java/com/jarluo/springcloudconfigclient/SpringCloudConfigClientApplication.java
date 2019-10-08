package com.jarluo.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringCloudConfigClientApplication.class);
		application.setWebEnvironment(true);
		application.run(args);
//		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	/**
	 * @desc 自定义Bootstrap配置属性资源 --jarluo
	 */
	/*@Configuration
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public static class MyPropertySourceLocator implements PropertySourceLocator {

		@Override
		public PropertySource<?> locate(Environment environment) {
			Map<String,Object> source = new HashMap();
			source.put("server.port","9098");
			MapPropertySource propertySource = new MapPropertySource("my-property-source",source);
			return propertySource;
		}
	}*/
	/**
	 * @desc 自定义Bootstrap配置属性资源 --官网实现
	 */
	/*@Configuration
	public class CustomPropertySourceLocator implements PropertySourceLocator {

		@Override
		public PropertySource<?> locate(Environment environment) {
			return new MapPropertySource("customProperty",
					Collections.singletonMap("property.from.sample.custom.source", "worked as intended"));
		}

	}*/
}
