package io.github.jack92w.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class TodoAppSpringTrainingApplication {

	public static void main(String[] args) {SpringApplication.run(TodoAppSpringTrainingApplication.class, args);
	}
	@Bean
	Validator validator(){return new LocalValidatorFactoryBean();
	}

}

