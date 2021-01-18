package com.sanket.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCassandraRepositories(basePackages="com.sanket.app.ws.Repository")
//@EnableAutoConfiguration
@EnableJpaRepositories
@AutoConfigurationPackage
@SpringBootApplication
public class SpringCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudExampleApplication.class, args);
	}

}
