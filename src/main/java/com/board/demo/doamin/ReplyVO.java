package com.board.demo.doamin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	private int replyNo;
	private int docNo;
	private String writer;
	private String content;
	private String regDttm;
}
