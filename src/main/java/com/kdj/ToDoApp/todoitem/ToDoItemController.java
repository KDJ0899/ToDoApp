package com.kdj.ToDoApp.todoitem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody ToDoItemResponse get(@PathVariable(value = "id") String id) { //@ResopnseBody 리턴을 JSON형식으로 해줌.
		
		List<String> errors = new ArrayList<String>();
		ToDoItem toDoItem = null;
		
		try {
			toDoItem = toDoItemService.get(id);
		}catch (final Exception e) {
			errors.add(e.getMessage());
		}
		
		return ToDoItemAdapter.toToDoItemResoponse(toDoItem, errors);
	}
	
	@RequestMapping (method = RequestMethod.GET)
	public @ResponseBody List<ToDoItemResponse> getAll(){
		
		List<String> errors = new ArrayList<String>();
		List<ToDoItem> toDoItems = toDoItemService.getAll();
		List<ToDoItemResponse> toDoItemResponses = new ArrayList<ToDoItemResponse>();
		
		toDoItems.stream().forEach(toDoItem ->{
			toDoItemResponses.add(ToDoItemAdapter.toToDoItemResoponse(toDoItem, errors));
		});
		
		return toDoItemResponses;
		
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public @ResponseBody ToDoItemResponse create(@RequestBody final ToDoItemRequest toDoItemRequest) {
		List<String> errors = new ArrayList<String>();
		ToDoItem toDoItem = ToDoItemAdapter.toToDoItem(toDoItemRequest);
		try {
			toDoItem = toDoItemService.create(toDoItem);
		} catch (final Exception e) {
			errors.add(e.getMessage());
			e.printStackTrace();
		}
		
		return ToDoItemAdapter.toToDoItemResoponse(toDoItem, errors);
		
	}
	
	@RequestMapping (method = RequestMethod.PUT)
	public @ResponseBody ToDoItemResponse update(@RequestBody final ToDoItemRequest toDoItemRequest) {
		
		List<String> errors = new ArrayList<String>();
		ToDoItem toDoItem = ToDoItemAdapter.toToDoItem(toDoItemRequest);
		
		try {
			toDoItem = toDoItemService.update(toDoItem);
		}catch (final Exception e) {
			errors.add(e.getMessage());
			e.printStackTrace();
		}
		
		return ToDoItemAdapter.toToDoItemResoponse(toDoItem, errors);
	}
	
	

}
