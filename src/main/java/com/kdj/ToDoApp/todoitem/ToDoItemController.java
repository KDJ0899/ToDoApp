package com.kdj.ToDoApp.todoitem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoItemController {
	
	@Autowired
	private ToDoItemService toDoItemService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody ToDoItemResponse get(@PathVariable(value = "id") String id) {
		
		List<String> errors = new ArrayList<String>();
		ToDoItem toDoItem = null;
		
		try {
			toDoItem = toDoItemService.get(id);
		}catch (final Exception e) {
			errors.add(e.getMessage());
		}
		
		return ToDoItemAdapter.toToDoItemResoponse(toDoItem, errors);
	}

}
