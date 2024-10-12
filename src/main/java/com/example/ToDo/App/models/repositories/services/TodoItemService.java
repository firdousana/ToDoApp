package com.example.ToDo.App.models.repositories.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDo.App.models.TodoItem;
import com.example.ToDo.App.models.repositories.TodoItemRepository;

@Service
public class TodoItemService {
	
	@Autowired
	private TodoItemRepository todoItemRepository;
	
	public Iterable<TodoItem> getAll(){
		return todoItemRepository.findAll();
	}
	
	public Optional<TodoItem> getById(Long id){
		return todoItemRepository.findById(id);
	}
	
	public TodoItem save(TodoItem todoItem) {
		if(todoItem.getId()==null) {
			todoItem.setCreatedAt(Instant.now());
		}
		todoItem.setUpdatedAt(Instant.now());
		return todoItemRepository.save(todoItem);
	}
	public void delete(TodoItem todoitem) {
		todoItemRepository.delete(todoitem);
	}

}
