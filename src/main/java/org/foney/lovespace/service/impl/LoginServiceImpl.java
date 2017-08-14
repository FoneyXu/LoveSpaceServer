package org.foney.lovespace.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.foney.lovespace.model.CustomerSession;
import org.foney.lovespace.model.Customer;
import org.foney.lovespace.service.CustomerService;
import org.foney.lovespace.service.LoginService;
import org.foney.lovespace.util.MD5Util;
import org.foney.lovespace.util.Prompt;
import org.foney.lovespace.util.SysUtil;
import org.foney.lovespace.util.WebUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private CustomerService customerService;
	
	@Override
	public Prompt loginIn(HttpServletRequest request,String phone, String password) {
		Prompt prompt = Prompt.getInstance();
		if(customerService.findCustomerByPhone(phone) == null) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("账号不存在");
			return prompt;
		}
		password = MD5Util.MD5Encode(password);
		Customer customer = customerService.findCustomerByPhoneAndPassword(phone, password);
		if(customer == null) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("账号或密码错误");
			return prompt;
		}
		CustomerSession customerSession = new CustomerSession();
		customerSession.setId(customer.getId());
		customerSession.setName(customer.getName());
		customerSession.setNickname(customer.getNickname());
		customerSession.setPhone(customer.getPhone());
		WebUtil.setCustomerSession(request.getSession(), customerSession);
		customer.setHeadUrl(SysUtil.REQUEST_PRO_PREFIX + customer.getHeadUrl());
		prompt.setResult(SysUtil.RESULT_TRUE);
		prompt.setMsg("登录成功");
		prompt.setData(customer);
		return prompt;
	}

	@Override
	public Prompt loginOut(HttpServletRequest request,String phone) {
		Prompt prompt = Prompt.getInstance();
		WebUtil.destroyCustomerSession(request);
		prompt.setResult(SysUtil.RESULT_TRUE);
		prompt.setMsg("退出成功");
		return null;
	}


}
