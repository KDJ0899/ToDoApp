package com.kdj.ToDoApp.todoitem;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ToDoItem {
	
	@Id  
	private String id; //@Id를 추가 함으로써 DB에서 알아서 값을 생생해줌.
	private String title;
	private boolean done;
}
