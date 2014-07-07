package org.zeroteam.core.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

	@Override
	public void addTodo(TodoVO vo) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoVO> listTodo(TodoCriteria cri) throws RuntimeException {
		// TODO Auto-generated method stub
		
		
		List<TodoVO> list = new ArrayList<TodoVO>();
		
		for(int i = 0; i < 10; i++){
			
			TodoVO vo = new TodoVO();
			vo.setJobno(i);
			vo.setTitle("test" + i);
			vo.setContent("aaaa"+i);
			list.add(vo);
		}
		
		cri.setTotalCount(123);
		
		return list;
	}

}
