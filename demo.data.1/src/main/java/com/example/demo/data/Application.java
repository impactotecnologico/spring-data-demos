package com.example.demo.data;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.data.models.Blog;
import com.example.demo.data.repositories.BlogRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		
		AnnotationConfigApplicationContext contexto = new   AnnotationConfigApplicationContext(Application.class);

		BlogRepository br = contexto.getBean(BlogRepository.class);
		Blog b = new Blog(0,"Titulo","Aprendiendo Spring Data");

		Blog saved = br.save(b);

		System.out.println(saved);
		
		contexto.close();

	}

}
