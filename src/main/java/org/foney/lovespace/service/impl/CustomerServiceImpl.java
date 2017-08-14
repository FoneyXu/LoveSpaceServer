package org.foney.lovespace.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.foney.lovespace.dao.CoupleDao;
import org.foney.lovespace.dao.CustomerDao;
import org.foney.lovespace.model.Couple;
import org.foney.lovespace.model.Customer;
import org.foney.lovespace.model.CustomerSession;
import org.foney.lovespace.service.CustomerService;
import org.foney.lovespace.util.MD5Util;
import org.foney.lovespace.util.Prompt;
import org.foney.lovespace.util.SysUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerDao customerDao;
	@Resource
	private CoupleDao coupleDao;
	
	@Override
	public Prompt registCustomer(Customer customer) {
		Prompt prompt = Prompt.getInstance();
		//判断电话号码是否已被注册
		if(findCustomerByPhone(customer.getPhone()) != null) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("电话号码已被注册");
			return prompt;
		}
		//二次加密密码
		customer.setPassword(MD5Util.MD5Encode(customer.getPassword()));
		customer.setCoupleState(0);
		customer.setRegisterTime(new Date());
		customerDao.save(customer);
		prompt.setResult(SysUtil.RESULT_TRUE);
		prompt.setMsg("注册成功");
		return prompt;
	}

	@Override
	public Prompt updateCustomerPassword(String newPassword, String validateCode) {
		return null;
	}

	@Override
	public Customer findCustomerById(Integer customerId) {
		return customerDao.findCustomerById(customerId);
	}

	@Override
	public Customer findCustomerByPhoneAndPassword(String phone, String password) {
		return customerDao.findCustomerByPhoneAndPassword(phone, password);
	}

	@Override
	public Customer findCustomerByPhone(String phone) {
		return customerDao.findCustomerByPhone(phone);
	}

	@Override
	public Prompt uploadCustomerHead(String headImage, Integer customerId) {
		Prompt prompt = Prompt.getInstance();
		//头像名称
		String headName = "head" + customerId + ".png";
		//头像保存至本地
		try {
			SysUtil.parseBase64StrToImage(headImage,  SysUtil.HEAD_UPLOAD_URL + headName);
		} catch (IOException e) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("头像上传失败");
			e.printStackTrace();
		}
		//修改数据库头像地址链接
		customerDao.updateCustomerHead(SysUtil.REQUEST_HEAD_URL + headName, customerId);
		prompt.setResult(SysUtil.RESULT_TRUE);
		prompt.setMsg("上传成功");
		return prompt;
	}

	@Override
	public Prompt updateCustomerById(Customer customer) {
		Prompt prompt = Prompt.getInstance();
		try {
			customerDao.updateCustomerById(customer);
		} catch (Exception e) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("更新用户信息失败");
		}
		prompt.setResult(SysUtil.RESULT_TRUE);
		return prompt;
	}

	@Override
	public List<Map<String, Object>> findCustomerByPhoneOrName(
			String phoneOrName) {
		List<Map<String, Object>> customers = this.customerDao.findCustomerByPhoneOrName(phoneOrName);
		for (Map<String, Object> map : customers) {
			map.put("head_url", SysUtil.REQUEST_PRO_PREFIX + map.get("head_url"));
		}
		return customers;
	}

	@Override
	public Prompt addCustomerWithInviteCouple(Integer fromCustomerId,
			Integer toCustomerId) {
		Prompt prompt = Prompt.getInstance();
		Customer formCustomer = customerDao.findCustomerById(fromCustomerId);
		if(formCustomer.getCoupleState() == 1) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("您当前正处于热恋中，不能邀请");
			return prompt;
		}
		Customer toCustomer = customerDao.findCustomerById(toCustomerId);
		if(toCustomer.getCoupleState() == 1){
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("您心仪的对象已处于热恋中，不能被邀请");
			return prompt;
		}
		//判断相互之间是否已经存在邀请关系
		Couple checkCouple = coupleDao.findCoupleByFromOrToCustomerIdWithState(fromCustomerId, toCustomerId, 0);
		if(checkCouple != null) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("你们之间已存在邀请关系，不能重复邀请");
			return prompt;
		}
		//创建情侣关系
		Couple couple = new Couple();
		couple.setFromCustomerId(fromCustomerId);
		couple.setToCustomerId(toCustomerId);
		couple.setInviteTime(new Date());
		couple.setState(0);
		try {
			coupleDao.save(couple);
		} catch (Exception e) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("邀请失败");
			e.printStackTrace();
		}
		prompt.setResult(SysUtil.RESULT_TRUE);
		return prompt;
	}
	
}
