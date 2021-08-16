package com.deneme.deneme.requests;
import lombok.Data;

@Data
public class TodoUpdateRequest {

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	String title;
	String text;
}
