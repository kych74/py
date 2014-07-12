package org.zeroteam.core.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zeroteam.core.board.BoardCriteria;
import org.zeroteam.core.board.BoardVO;

public interface BoardMapper {

	public void createBoard(BoardVO vo )throws RuntimeException;
	
	public BoardVO readBoard(@Param("bno")Integer bno)throws RuntimeException;
	
	public List<BoardVO> listBoard(BoardCriteria cri)throws RuntimeException;
	
	public int listCountBoard(BoardCriteria cri)throws RuntimeException;
	
	public void updateBoard(BoardVO vo)throws RuntimeException;
	
	public void deleteBoard(@Param("bno")int bno)throws RuntimeException;
	
}
