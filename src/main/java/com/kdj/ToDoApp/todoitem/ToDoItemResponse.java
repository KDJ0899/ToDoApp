package com.kdj.ToDoApp.todoitem;

import java.util.List;

import com.kdj.ToDoApp.apiresponse.ApiResponse;

import lombok.Builder;

public class ToDoItemResponse extends ApiResponse<ToDoItem>{
	
	@Builder
	public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
		super(toDoItem);
		this.setErrors(errors);
	}

}
