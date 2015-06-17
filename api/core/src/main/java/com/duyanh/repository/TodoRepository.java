package com.duyanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.duyanh.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	@Query("Select u From Todo u Where u.id = ?1")
	Todo getById(Long id);

}
