package org.zeroteam.core.board;

import java.util.List;


public interface BoardService{

	public void addBoard(BoardVO vo)throws RuntimeException;
	
	public List<BoardVO> listBoard(BoardCriteria cri)throws RuntimeException;

	public BoardVO viewBoard(Integer bno)throws RuntimeException;
	
	public void modifyBoard(BoardVO vo)throws RuntimeException;
	
	public void removeBoard(Integer bno)throws RuntimeException;
}
