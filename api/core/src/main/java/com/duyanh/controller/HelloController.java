package com.duyanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duyanh.domain.Todo;
import com.duyanh.dto.TodoDto;
import com.duyanh.service.TodoService;

@Controller
@RequestMapping("/todo")
public class HelloController {
	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/getList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TodoDto> getList() {
		return todoService.getList();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute("todo") Todo todo,
            ModelMap model) {
		
		model.put("toto", new TodoDto());
		model.put("listTodo", todoService.getList());
		return "todo";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("todo") TodoDto dto) {

		if (dto.getId() == null) {
			// new person, add it
			todoService.add(dto);
		} else {
			// existing person, call update
			todoService.update(dto);
		}
		return "redirect:/todo/";
	}
	
	 @RequestMapping("/remove/{id}")
	    public String remove(@PathVariable("id") Long id){
	         
	        todoService.remove(id);
	        return "redirect:/todo/";
	    }
	  
	    @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model){
	        model.addAttribute("todo", todoService.getById(id));
	        model.addAttribute("listTodo", todoService.getList());
	        return "todo";
	    }

}
