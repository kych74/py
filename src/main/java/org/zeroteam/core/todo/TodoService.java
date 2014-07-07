package org.zeroteam.core.todo;

import java.util.List;

public interface TodoService {

	public void addTodo(TodoVO vo)throws RuntimeException;
	
	
	public List<TodoVO> listTodo(TodoCriteria cri)throws RuntimeException;
	
}
