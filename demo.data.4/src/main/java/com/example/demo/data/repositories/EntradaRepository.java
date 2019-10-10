package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.models.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
}
