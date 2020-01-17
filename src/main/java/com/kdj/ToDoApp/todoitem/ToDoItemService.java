package com.kdj.ToDoApp.todoitem;

import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {

	public ToDoItem get(final String id) {
		
		return ToDoItem.builder()
				.title("Add an id validation")
				.build();
	}
}
