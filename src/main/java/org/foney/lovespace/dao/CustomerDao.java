package org.foney.lovespace.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.foney.lovespace.model.Customer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends GeneralDao<Customer>{
	
	public Customer findCustomerById(Integer customerId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerId", customerId);
		String hql = "from Customer where id =:customerId";
		return (Customer) this.findUniqueResultWithMapParamByHQL(hql, map);
	}

	public Customer findCustomerByPhoneAndPassword(String phone, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("password", password);
		String hql = "from Customer where phone =:phone and password =:password";
		return (Customer) this.findUniqueResultWithMapParamByHQL(hql, map);
	}

	public Customer findCustomerByPhone(String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		String hql = "from Customer where phone =:phone";
		return (Customer) this.findUniqueResultWithMapParamByHQL(hql, map);
	}
	
	public void updateCustomerHead(String headUrl,Integer customerId) {
		String sql = "update customer set head_url = ? where id = ?";
		this.updateBySQL(sql, headUrl,customerId);
	}
	
	public void updateCustomerById(Customer customer) {
		String sql = "update customer set name = ?,sex = ?,birthday = ? where id = ?";
		this.updateBySQL(sql, customer.getName(),customer.getSex(),customer.getBirthday(),customer.getId());
	}
	
	public List<Map<String, Object>> findCustomerByPhoneOrName(String phoneOrName) {
		String sql = "SELECT cus.id,cus.head_url,IFNULL(cus.name,'') AS name,IFNULL(cus.sex,'') AS sex,IFNULL(cus.birthday,'') AS birthday,cus.phone,COUNT(cou.id) coupleCount "
					+"FROM (SELECT * FROM customer "
					+"WHERE (NAME LIKE ? OR phone = ?) AND couple_state = 0) cus "
					+"LEFT JOIN couple cou "
					+"ON (cou.from_customer_id = cus.id OR cou.to_customer_id = cus.id) AND cou.state = 3 "
					+"GROUP BY cus.id,cus.name,cus.sex,cus.birthday,cus.phone";
		return this.getSession().createSQLQuery(sql).setParameter(0, "%"+phoneOrName+"%").setParameter(1, phoneOrName)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}
	
	/**
	 * 
	 * 名称：updateCustomerCoupleStateZeroById 描述：更新用户情侣状态为单身
	 * 创建人：xyz 创建时间：2017年7月30日下午10:02:36
	 * @param customerId
	 * @param coupleState
	 *
	 */
	public void updateCustomerCoupleStateZeroById(Integer customerId) {
		String sql = "update customer set couple_customer_id = '' and couple_id = '' and couple_state = 0 where id = ?";
		this.updateBySQL(sql, customerId);
	}
	
	/**
	 * 
	 * 名称：updateCustomerCoupleStateOneById 描述：更新用户情侣状态为热恋中
	 * 创建人：xyz 创建时间：2017年7月30日下午10:05:14
	 * @param customerId
	 * @param coupleCustomerId
	 * @param coupleId
	 *
	 */
	public void updateCustomerCoupleStateOneById(Integer customerId,Integer coupleCustomerId,Integer coupleId) {
		String sql = "update customer set couple_customer_id = ? and couple_id = ? and couple_state = 1 where id = ?";
		this.updateBySQL(sql, coupleCustomerId,coupleId,customerId);
	}
	
}
