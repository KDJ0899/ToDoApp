package com.kdj.ToDoApp.todoitem;

import java.util.List;

public class ToDoItemAdapter {
	
	public static ToDoItemResponse toToDoItemResoponse(final ToDoItem toDoItem, final List<String> errors) {
		
		return ToDoItemResponse.builder().toDoItem(toDoItem).errors(errors).build();
	}

}
