package org.foney.lovespace.service;

import javax.servlet.http.HttpServletRequest;

import org.foney.lovespace.util.Prompt;

public interface LoginService {
	
	/**
	 * 
	 * 名称：loginIn 描述：登录
	 * 创建人：xyz 创建时间：2017年7月25日下午3:59:00
	 * @param phone 账号
	 * @param password 密码
	 * @return
	 *
	 */
	Prompt loginIn(HttpServletRequest request,String phone, String password);
	
	/**
	 * 
	 * 名称：loginOut 描述：退出
	 * 创建人：xyz 创建时间：2017年7月25日下午3:59:23
	 * @param phone
	 * @return
	 *
	 */
	Prompt loginOut(HttpServletRequest request,String phone);
	
}
