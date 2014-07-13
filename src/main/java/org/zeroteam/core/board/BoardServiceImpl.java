package org.zeroteam.core.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zeroteam.core.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	BoardMapper mapper;

	@Override
	public void addBoard(BoardVO vo) throws RuntimeException {
		// TODO Auto-generated method stub
		
		
		mapper.createBoard(vo);
		
	}

	@Override
	public List<BoardVO> listBoard(BoardCriteria cri) throws RuntimeException {
		// TODO Auto-generated method stub
		
		cri.setTotalCount(mapper.listCountBoard(cri));
		
		return mapper.listBoard(cri);
	}

	@Override
	public BoardVO viewBoard(Integer bno) throws RuntimeException {
		// TODO Auto-generated method stub
		return mapper.readBoard(bno);
	}

	@Override
	public void modifyBoard(BoardVO vo) throws RuntimeException {
		// TODO Auto-generated method stub
		mapper.updateBoard(vo);
	}

	@Override
	public void removeBoard(Integer bno) throws RuntimeException {
		// TODO Auto-generated method stub
		mapper.deleteBoard(bno);
	}
}
