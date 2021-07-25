package com.board.demo.controller;

import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.demo.domain.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@ResponseBody
	@GetMapping(value="/list")
	public HashMap<String, Object> selectBoardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String schType = request.getParameter("schType");
	    String schVal = request.getParameter("schVal");
	    int rows = Integer.parseInt(request.getParameter("rows"));
	    int page = Integer.parseInt(request.getParameter("page"));
	    String[] sort = URLDecoder.decode(request.getParameter("sort"), "UTF-8").split(",");
	    
	    BoardVO vo = new BoardVO();
	    vo.setSchType(schType);
	    vo.setSchVal(schVal);
	    vo.setStartNo(((page * rows) - rows) + 1);
	    vo.setEndNo(page * rows);
	    vo.setSort(sort);
	    
		return null;
	}
}
