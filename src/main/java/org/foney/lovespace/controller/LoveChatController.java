package org.foney.lovespace.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.foney.lovespace.service.LoveChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loveChat")
public class LoveChatController extends BaseController{
	
	@Resource
	private LoveChatService loveChatService;
	
	@RequestMapping("findLoveChatByCoupleId")
	public void findLoveChatByCoupleId(HttpServletResponse response,Integer coupleId) {
		Map<String, Object> map = loveChatService.findLoveChatByCoupleIdWith50(coupleId);
		this.outPutJson(map, response);
	}
	
}
