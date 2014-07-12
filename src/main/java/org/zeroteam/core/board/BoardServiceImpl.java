package org.zeroteam.core.board;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zeroteam.core.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	BoardMapper mapper;
	
	
	

}
