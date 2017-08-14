package org.foney.lovespace.service;

import java.util.List;
import java.util.Map;

import org.foney.lovespace.model.Customer;
import org.foney.lovespace.util.Prompt;

public interface CustomerService {
	
	/**
	 * 
	 * 名称：registCustomer 描述：注册用户
	 * 创建人：xyz 创建时间：2017年7月25日下午3:46:19
	 * @param customer
	 * @return
	 *
	 */
	Prompt registCustomer(Customer customer);
	
	/**
	 * 
	 * 名称：updateCustomerPassword 描述：修改密码
	 * 创建人：xyz 创建时间：2017年7月25日下午3:46:34
	 * @param newPassword
	 * @param validateCode
	 * @return
	 *
	 */
	Prompt updateCustomerPassword(String newPassword,String validateCode);
	
	/**
	 * 
	 * 名称：findCustomerById 描述：根据ID查询用户
	 * 创建人：xyz 创建时间：2017年7月25日下午3:55:51
	 * @param customerId
	 * @return
	 *
	 */
	Customer findCustomerById(Integer customerId);
	
	/**
	 * 
	 * 名称：findCustomerByPhoneAndPassword 描述：根据账号和密码查询用户
	 * 创建人：xyz 创建时间：2017年7月25日下午4:03:32
	 * @param phone
	 * @param password
	 * @return
	 *
	 */
	Customer findCustomerByPhoneAndPassword(String phone,String password);
	
	/**
	 * 
	 * 名称：findCustomerByPhone 描述：根据电话查询用户
	 * 创建人：xyz 创建时间：2017年7月25日下午4:05:14
	 * @param phone
	 * @return
	 *
	 */
	Customer findCustomerByPhone(String phone);
	
	/**
	 * 
	 * 名称：uploadCustomerHead 描述：上传头像
	 * 创建人：xyz 创建时间：2017年7月27日下午11:19:05
	 * @param headImage
	 * @param customerId
	 * @return
	 *
	 */
	Prompt uploadCustomerHead(String headImage,Integer customerId);
	
	/**
	 * 
	 * 名称：updateCustomerById 描述：更新用户信息
	 * 创建人：xyz 创建时间：2017年7月28日下午8:52:58
	 * @param customer
	 * @return
	 *
	 */
	Prompt updateCustomerById(Customer customer);
	
	/**
	 * 
	 * 名称：findCustomerByPhoneOrName 描述：根据账号或者姓名查找用户，并统计出用户感情经历总数
	 * 创建人：xyz 创建时间：2017年7月30日下午12:48:33
	 * @param phoneOrName
	 * @return
	 *
	 */
	List<Map<String, Object>> findCustomerByPhoneOrName(String phoneOrName);
	
	/**
	 * 
	 * 名称：addCustomerWithInviteCouple 描述：邀请用户为情侣
	 * 创建人：xyz 创建时间：2017年7月30日下午12:52:09
	 * @param fromCustomerId
	 * @param toCustomerId
	 * @return
	 *
	 */
	Prompt addCustomerWithInviteCouple(Integer fromCustomerId,Integer toCustomerId);
	
}
