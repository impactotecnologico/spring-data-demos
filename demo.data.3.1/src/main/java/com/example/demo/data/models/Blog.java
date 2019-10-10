package com.example.demo.data.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Blog {

	@GeneratedValue
	@Id
	private int id;

	private String titulo;

	@OneToMany(cascade = CascadeType.PERSIST)
	private Set<Entrada> entradas;

	@CreationTimestamp
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Blog(int id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public void addEntradas(Entrada e) {
		if (entradas == null) {
			entradas = new HashSet<Entrada>();
		}
		entradas.add(e);
	}

}
