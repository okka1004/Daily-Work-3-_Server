package com.cjon.book.dto;

public class BookDTO {

	private String btitle;
	private String bisbn;
	private String bauthor;
	private int bpice;
	private String bimgurl;
	
	public BookDTO() {

	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBpice() {
		return bpice;
	}

	public void setBpice(int bpice) {
		this.bpice = bpice;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}
	
}
