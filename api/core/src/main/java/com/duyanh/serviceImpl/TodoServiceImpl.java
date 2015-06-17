package com.duyanh.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.duyanh.domain.Todo;
import com.duyanh.dto.TodoDto;
import com.duyanh.repository.TodoRepository;
import com.duyanh.service.TodoService;

@Service("todoService")
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	private List<TodoDto> convert(List<Todo> t){
		 List<TodoDto> r = new ArrayList<TodoDto>();
		for(Todo i : t){
			TodoDto d = new TodoDto();
			d.setDescription(i.getDescription());
			d.setName(i.getName());
			d.setId(i.getId());
			r.add(d);
		}
		return r;
	}
	
	public List<TodoDto> getList() {
		return convert(todoRepository.findAll());
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void add(TodoDto dto) {
		Todo td = new Todo();
		td.setName(dto.getName());
		td.setDescription(dto.getDescription());
		td.setUpdatedDate(new Date());
		todoRepository.saveAndFlush(td);
		
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(TodoDto dto) {
		Todo td = new Todo();
		td.setId(dto.getId());
		td.setName(dto.getName());
		td.setDescription(dto.getDescription());
		td.setUpdatedDate(new Date());
		todoRepository.save(td);
		
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		todoRepository.delete(id);
		
	}
	
	public TodoDto getById(Long id) {
		TodoDto dto = new TodoDto();
		Todo td = todoRepository.getById(id);
		dto.setId(td.getId());
		dto.setDescription(td.getDescription());
		dto.setName(td.getName());
		return dto;
		//todoRepository.getOne(id);
	}
}
