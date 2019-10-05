package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ChatMessageDto;

@Controller
public class ChatController {
	private List<ChatMessageDto> messages;

	ChatController() {
		messages = new ArrayList<>();
	}

	@RequestMapping("/chat/main")
	public String showMain() {
		return "chat/main";
	}

	@RequestMapping("/chat/addMessage")
	@ResponseBody
	public Map addMessage(String writer, String body) {
		long id = messages.size() + 1;
		messages.add(new ChatMessageDto(id, writer, body));

		Map<String, Object> rs = new HashMap<>();

		rs.put("msg", "채팅 메세지가 추가되었습니다.");
		rs.put("resultCode", "S-1");

		return rs;
	}

	@RequestMapping("/chat/getAllMessages")
	@ResponseBody
	public List<ChatMessageDto> getAllMessages() {
		return messages;
	}
}