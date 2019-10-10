package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.models.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
}
