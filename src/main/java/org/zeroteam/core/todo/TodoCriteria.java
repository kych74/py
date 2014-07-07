package org.zeroteam.core.todo;

public class TodoCriteria {
	
	private int totalCount;
	private int pageno;
	
	private final static int perPage = 10; 
	
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
		this.pageno = pageno;
	}
	
	public int getStart(){
		
		return (this.pageno * perPage) - perPage;
	}
	
	
	public int getEnd(){
		
		return (this.pageno * perPage); 
	}
	
}
