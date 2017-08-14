package org.foney.lovespace.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.foney.lovespace.model.Customer;
import org.foney.lovespace.service.CustomerService;
import org.foney.lovespace.service.LoginService;
import org.foney.lovespace.util.Prompt;
import org.foney.lovespace.util.SysUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("login")
public class LoginController extends BaseController{
	
	@Resource
	private LoginService loginService;
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("loginIn")
	public void loginIn(HttpServletRequest request,HttpServletResponse response,String phone, String password) {
		Prompt prompt = loginService.loginIn(request, phone, password);
		this.outPutJson(prompt, response);
	}
	
	@RequestMapping("loginOut")
	public void loginOut(HttpServletRequest request,HttpServletResponse response,String phone) {
		Prompt prompt = loginService.loginOut(request, phone);
		this.outPutJson(prompt, response);
	}
	
	@RequestMapping("registCustomer")
	public void registCustomer(HttpServletRequest request,HttpServletResponse response,Customer customer,String validateCode) {
		Prompt prompt = customerService.registCustomer(customer);
		this.outPutJson(prompt, response);
	}
	
	@RequestMapping("getValidateCode")
	public void getValidateCode(HttpServletRequest request,HttpServletResponse response,String phone) {
		Customer customer = customerService.findCustomerByPhone(phone);
		Prompt prompt= Prompt.getInstance();
		if(customer != null) {
			//该账号已被注册
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("电话号码已被注册");
		}else {
			String validateCode = SysUtil.getValidateCode();
			System.out.println(validateCode);
			prompt.setResult(SysUtil.RESULT_TRUE);
			prompt.setData(validateCode);
		}
		this.outPutJson(prompt, response);
	}
	
}
