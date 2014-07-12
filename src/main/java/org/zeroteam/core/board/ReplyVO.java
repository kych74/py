package org.zeroteam.core.board;

import java.io.Serializable;
import java.util.Date;

/*CREATE TABLE `tbl_reply` (
		  `replyno` INT NOT NULL AUTO_INCREMENT,
		  `bno` INT NOT NULL,
		  `reply` VARCHAR(500) NOT NULL,
		  `replyDate` TIMESTAMP NULL DEFAULT now(),
		  `replyer` VARCHAR(45) NULL,
		  PRIMARY KEY (`replyno`));
*/

public class ReplyVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int replyno;
	private int bno;
	private String reply;
	private Date replyDate;
	private String replyer;
	
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyno=" + replyno + ", bno=" + bno + ", reply="
				+ reply + ", replyDate=" + replyDate + ", replyer=" + replyer
				+ "]";
	}
	
	
	
	
}
