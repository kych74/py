package org.zeroteam.core.board;

public class BoardCriteria {
	
	private int totalCount;
	private int pageno;
	
	private final static int perPage = 20;
	
	public BoardCriteria(){
		
		this.pageno = 1;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		if(pageno <= 0){
			this.pageno = 1;
			return;
		}
		
		this.pageno = pageno;
	}
	
	public int getStart(){
		
		return (this.pageno * perPage) - perPage;
	}
	
	
	public int getEnd(){
		
		return perPage; 
	}

	@Override
	public String toString() {
		return "TodoCriteria [totalCount=" + totalCount + ", pageno=" + pageno
				+ "]";
	}
	
	
	

}
