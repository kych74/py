package org.zeroteam.core.test.todo;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zeroteam.core.todo.TodoCriteria;
import org.zeroteam.core.todo.TodoVO;
import org.zeroteam.core.todo.mapper.TodoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class TodoMapperTest {

	static Logger logger = Logger.getLogger(TodoMapperTest.class);
	
	@Inject
	TodoMapper mapper;
	
	@Test
	public void testCreate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		
		for(int i = 0; i < 100; i++){
			
			TodoVO vo  =  new TodoVO();
			vo.setTitle("테스트 데이터" + i);
			vo.setContent("테스트 내용" + i);
			vo.setDueDate(cal.getTime());
			
			
			mapper.createTodo(vo);
			
		}
	}
	
	@Test
	public void testList(){
		
		TodoCriteria cri = new TodoCriteria();
		
		List<TodoVO> list = mapper.listTodo(cri);
		
		logger.info(list);
		
	}	
}
