package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {

	@Override
	public String toString() {
		return "ChatMessageDto [id=" + id + ", writer=" + writer + ", body=" + body + "]";
	}

	public ChatMessageDto(long id, String writer, String body) {
		super();
		this.id = id;
		this.writer = writer;
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	private long id;
	private String writer;
	private String body;
}