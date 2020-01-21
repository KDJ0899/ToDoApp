package com.kdj.ToDoApp.todoitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {
	
	@Autowired
	private ToDoItemRepository toDoItemRepository;

	public ToDoItem get(final String id) {
		
		return toDoItemRepository.findById(id).orElse(null);
	}
	
	public List<ToDoItem> getAll(){
		return toDoItemRepository.findAll();
	}
	
	public ToDoItem create(final ToDoItem toDoItem) {
		if(toDoItem == null) {
			throw new NullPointerException("To Do Item cannot be null.");
		}
		
		return toDoItemRepository.insert(toDoItem);
	}
	
	
	
	public ToDoItem update(final ToDoItem toDoItem) {
		if(toDoItem == null) {
			throw new NullPointerException("To Do Item cannot be null");
		}
		
		final ToDoItem original = toDoItemRepository.findById(toDoItem.getId())
				.orElseThrow(() -> new RuntimeException("Entry Not Found"));
		
		original.setTitle(toDoItem.getTitle());
		original.setDone(toDoItem.isDone());
		return toDoItemRepository.save(original);
		
	}
}
