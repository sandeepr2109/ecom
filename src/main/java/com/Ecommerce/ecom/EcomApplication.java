package com.Ecommerce.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.Ecommerce.ecom"})
@EntityScan({"com.Ecommerce.entity"})
@EnableJpaRepositories({"com.Ecommerce.Repo"})
@Configuration*/
@EnableAutoConfiguration()
@ComponentScan(basePackages= {"com"})
@EntityScan(basePackages= {"com.Ecommerce.entity"})
@EnableJpaRepositories(basePackages= {"com.Ecommerce.Repo"})
@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}

}
