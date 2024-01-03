package com.seongseobdang.model.dto;

public class Board {
	int location_id;
	int mountain_id;
	String id;
	int board_id;
	String title;
	String writer;
	String content;
	String reg_date;
	int view_cnt;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int location_id, int mountain_id, String id, int board_id, String title, String writer, String content,
			String reg_date, int view_cnt) {
		super();
		this.location_id = location_id;
		this.mountain_id = mountain_id;
		this.id = id;
		this.board_id = board_id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
		this.view_cnt = view_cnt;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public int getMountain_id() {
		return mountain_id;
	}
	public void setMountain_id(int mountain_id) {
		this.mountain_id = mountain_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	@Override
	public String toString() {
		return "Board [location_id=" + location_id + ", mountain_id=" + mountain_id + ", id=" + id + ", board_id="
				+ board_id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", reg_date="
				+ reg_date + ", view_cnt=" + view_cnt + "]";
	}
	
}
