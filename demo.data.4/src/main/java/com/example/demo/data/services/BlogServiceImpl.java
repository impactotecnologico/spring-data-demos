package com.example.demo.data.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.data.models.Blog;
import com.example.demo.data.models.Entrada;
import com.example.demo.data.repositories.BlogRepository;
import com.example.demo.data.repositories.EntradaRepository;

@Service
public class BlogServiceImpl {

	EntradaRepository er;
	BlogRepository br;

	public BlogServiceImpl(EntradaRepository er, BlogRepository br) {
		super();
		this.er = er;
		this.br = br;
	}

	@Transactional
	public void operate() {
		Entrada e = new Entrada();
		e.setTitulo("Titulo de entrada");
		e.setContenido("Contenido de Entrada");

		Blog b = new Blog(0, "Titulo");
		b.addEntradas(e);

		Blog saved = br.save(b);
		System.out.println(saved);

		List<Blog> blogs = br.findAll();
		System.out.println("------- Termino");

		for (Blog blog : blogs) {
			System.out.println(blog.getEntradas().size());
		}
		System.out.println("------- TERMINO 2 ***************");

	}

	public void operateOrphanRemove() {

		Entrada e = new Entrada();
		e.setTitulo("Titulo de entrada");
		e.setContenido("Contenido de Entrada");

		Blog b = new Blog(0, "Titulo");
		b.addEntradas(e);

		Blog saved = br.saveAndFlush(b);
		System.out.println(saved);
		System.out.println("Entradas: " + er.count());

		saved.getEntradas().remove(saved.getEntradas().iterator().next());

		br.flush();

		System.out.println("Entradas: " + er.count());

	}

	public EntradaRepository getEr() {
		return er;
	}

	public void setEr(EntradaRepository er) {
		this.er = er;
	}

	public BlogRepository getBr() {
		return br;
	}

	public void setBr(BlogRepository br) {
		this.br = br;
	}

}
