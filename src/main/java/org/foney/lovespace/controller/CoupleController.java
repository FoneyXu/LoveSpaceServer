package org.foney.lovespace.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.foney.lovespace.service.CoupleService;
import org.foney.lovespace.util.Prompt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoupleController extends BaseController{
	
	@Resource
	private CoupleService coupleService;
	
	/**
	 * 
	 * 名称：updateCoupleStateById 描述：分手，同意，拒绝情侣邀请请求
	 * 创建人：xyz 创建时间：2017年7月30日下午10:29:24
	 * @param response
	 * @param coupleId
	 * @param state
	 *
	 */
	@RequestMapping("updateCoupleStateById")
	public void updateCoupleStateById(HttpServletResponse response,Integer coupleId,Integer state) {
		Prompt prompt = coupleService.updateCoupleStateById(coupleId, state);
		this.outPutJson(prompt, response);
	}
	
	/**
	 * 
	 * 名称：findCoupleListByCustomerId 描述：根据用户查询该用户下的所有情侣关系信息
	 * 创建人：xyz 创建时间：2017年7月30日下午10:32:49
	 * @param response
	 * @param customerId
	 *
	 */
	@RequestMapping("findCoupleListByCustomerId")
	public void findCoupleListByCustomerId(HttpServletResponse response,Integer customerId) {
		List<Map<String, Object>> couples = coupleService.findCoupleListByCustomerId(customerId);
		this.outPutJson(couples, response);
	}
	
}
