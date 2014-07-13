package org.zeroteam.core.board;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/*CREATE TABLE `tbl_board` (
		  `bno` int(11) NOT NULL AUTO_INCREMENT,
		  `title` varchar(200) NOT NULL,
		  `content` text NOT NULL,
		  `regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
		  `moddate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
		  `viewcnt` int(11) DEFAULT '0',
		  `replycnt` int(11) DEFAULT '0',
		  `writer` varchar(45) NOT NULL,
		  `delflag` char(1) DEFAULT 'N',
		  PRIMARY KEY (`bno`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
public class BoardVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int bno;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String content;
	private Date regDate;
	private Date modDate;
	private int viewcnt;
	private int replycnt;
	
	@NotEmpty
	private String writer;
	
	private String delflag;
	
	
	
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + ", modDate=" + modDate
				+ ", viewcnt=" + viewcnt + ", writer=" + writer + ", delflag="
				+ delflag + "]";
	}
	
	
	
}
