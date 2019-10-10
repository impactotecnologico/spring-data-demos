package com.example.demo.data;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.data.models.Blog;
import com.example.demo.data.models.Entrada;
import com.example.demo.data.repositories.BlogRepository;
import com.example.demo.data.repositories.EntradaRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Application.class);

		EntradaRepository er = contexto.getBean(EntradaRepository.class);
		BlogRepository br = contexto.getBean(BlogRepository.class);

		Entrada e = new Entrada();
		e.setTitulo("Titulo de entrada");
		e.setContenido("Contenido de Entrada");
		er.save(e);

		Blog b = new Blog(0, "Titulo");
		b.addEntradas(e);

		Blog saved = br.save(b);
		System.out.println(saved);

		contexto.close();

	}

}
