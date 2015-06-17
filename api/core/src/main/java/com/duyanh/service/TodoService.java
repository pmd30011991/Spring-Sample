package com.duyanh.service;

import java.util.List;

import com.duyanh.dto.TodoDto;


public interface TodoService {

	List<TodoDto> getList();

	void add(TodoDto dto);

	void update(TodoDto dto);

	void remove(Long id);

	Object getById(Long id);
}
