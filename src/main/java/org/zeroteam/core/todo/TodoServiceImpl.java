package org.zeroteam.core.todo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zeroteam.core.todo.mapper.TodoMapper;

@Service
public class TodoServiceImpl implements TodoService {

	@Inject
	TodoMapper mapper;
	
	@Override
	public void addTodo(TodoVO vo) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoVO> listTodo(TodoCriteria cri) throws RuntimeException {
		// TODO Auto-generated method stub
		
		
		List<TodoVO> list = mapper.listTodo(cri);
		
		cri.setTotalCount(mapper.listCountTodo(cri));
		
		return list;
	}

	@Override
	public TodoVO view(Integer bno) throws RuntimeException {
		// TODO Auto-generated method stub
		
		return mapper.readTodo(bno);
	}

	
	
}
