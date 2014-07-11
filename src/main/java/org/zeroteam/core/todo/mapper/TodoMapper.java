package org.zeroteam.core.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zeroteam.core.todo.TodoCriteria;
import org.zeroteam.core.todo.TodoVO;

public interface TodoMapper {

	public void createTodo(TodoVO vo )throws RuntimeException;
	
	public TodoVO readTodo(@Param("bno")Integer bno)throws RuntimeException;
	
	public List<TodoVO> listTodo(TodoCriteria cri)throws RuntimeException;
	
	public int listCountTodo(TodoCriteria cri)throws RuntimeException;
	
//	public void updateTodo(TodoVO vo)throws RuntimeException;
//	
//	public void deleteTodo(int bno)throws RuntimeException;
	
}
