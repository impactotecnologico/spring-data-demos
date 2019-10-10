package com.example.demo.data;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.data.services.BlogServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Application.class);

		BlogServiceImpl bs = contexto.getBean(BlogServiceImpl.class);

		// bs.operate();

		bs.operateOrphanRemove();

		contexto.close();

	}

}
