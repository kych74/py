package org.zeroteam.core.todo;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;


/*CREATE TABLE `tbl_todo` (
		  `bno` int(11) NOT NULL AUTO_INCREMENT,
		  `title` varchar(45) NOT NULL,
		  `content` text,
		  `duedate` datetime DEFAULT NULL,
		  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
		  `complete` char(1) DEFAULT 'N',
		  PRIMARY KEY (`bno`)
		) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
*/

public class TodoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int bno;
	
	@NotEmpty
	private String title;

	@NotEmpty
	private String content;

	private Date dueDate;
	

	private Date regDate;
	
	private boolean complete;
	
	public TodoVO(){
		
		this.dueDate = new Date();
	}
	
	
	
	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "TodoVO [bno=" + bno + ", title=" + title + ", content="
				+ content + ", dueDate=" + dueDate + ", regDate=" + regDate
				+ ", complete=" + complete + "]";
	}
	
		
}
