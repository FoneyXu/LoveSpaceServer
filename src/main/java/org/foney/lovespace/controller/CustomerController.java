package org.foney.lovespace.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.foney.lovespace.model.Customer;
import org.foney.lovespace.service.CustomerService;
import org.foney.lovespace.util.DateUtil;
import org.foney.lovespace.util.Prompt;
import org.foney.lovespace.util.SysUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController{
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("uploadCustomerHead")
	public void uploadCustomerHead(HttpServletResponse response,String headImage,Integer customerId) {
		Prompt prompt = customerService.uploadCustomerHead(headImage, customerId);
		this.outPutJson(prompt, response);
	}
	
	
	@RequestMapping("findCustomerById")
	public void findCustomerById(HttpServletResponse response,Integer customerId) {
		Prompt prompt = Prompt.getInstance();
		Customer customer = customerService.findCustomerById(customerId);
		prompt.setData(customer);
		prompt.setResult(SysUtil.RESULT_TRUE);
		this.outPutJson(prompt, response);
	}
	
//	@RequestMapping("updateCustomerById")
//	public void updateCustomerById(HttpServletResponse response,Customer customer) {
//		Prompt prompt = customerService.updateCustomerById(customer);
//		this.outPutJson(prompt, response);
//	}
	
	@RequestMapping("updateCustomerInfoById")
	public void updateCustomerInfoById(HttpServletResponse response,Integer id,String name,String sex,String birthday) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setBirthday(DateUtil.parse(birthday));
		customer.setSex(sex);
		Prompt prompt = customerService.updateCustomerById(customer);
		this.outPutJson(prompt, response);
	}
	
	@RequestMapping("findCustomerByPhoneOrName")
	public void findCustomerByPhoneOrName(HttpServletResponse response, String phoneOrName) {
		List<Map<String, Object>> customers = this.customerService.findCustomerByPhoneOrName(phoneOrName);
		this.outPutJson(customers, response);
	}
	
	@RequestMapping("addCustomerWithInviteCouple")
	public void addCustomerWithInviteCouple(HttpServletResponse response,Integer fromCustomerId,
			Integer toCustomerId) {
		Prompt prompt = this.customerService.addCustomerWithInviteCouple(fromCustomerId, toCustomerId);
		this.outPutJson(prompt, response);
	}
	
}
