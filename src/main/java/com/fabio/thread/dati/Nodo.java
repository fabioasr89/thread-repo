package com.fabio.thread.dati;

public class Nodo{
	
	private Object content;
	private String id;
	
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("id:%s",id);
	}
	
	
}
