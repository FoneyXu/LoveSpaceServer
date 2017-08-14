package org.foney.lovespace.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.foney.lovespace.model.Couple;
import org.foney.lovespace.util.Prompt;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CoupleDao extends GeneralDao<Couple>{
	
	public Couple findCoupleByFromOrToCustomerIdWithState(Integer fromCustomerId,Integer toCustomerId,Integer state) {
		String hql = "FROM couple WHERE (from_customer_id = ? AND to_customer_id = ? AND state = ?) OR (from_customer_id = ? AND to_customer_id = ? AND state = ?) ";
		return this.findBeanByHQL(hql, fromCustomerId,toCustomerId,state,toCustomerId,fromCustomerId,state);
	}
	
	/**
	 * 
	 * 名称：updateCoupleStateByIdWithReply 描述：回复时改变状态
	 * 创建人：xyz 创建时间：2017年7月30日下午9:44:10
	 * @param coupleId
	 * @param state
	 *
	 */
	public void updateCoupleStateByIdWithReply(Integer coupleId,Integer state) {
		String sql = "update couple set reply_time = now() and state = ? where id = ?";
		this.updateBySQL(sql, state,coupleId);
	}
	
	/**
	 * 
	 * 名称：updateCoupleStateByIdWithLeft 描述：分手时改变状态
	 * 创建人：xyz 创建时间：2017年7月30日下午9:45:42
	 * @param coupleId
	 *
	 */
	public void updateCoupleStateByIdWithLeft(Integer coupleId) {
		String sql = "update couple set left_time = now() and state = 3 where id = ?";
		this.updateBySQL(sql, coupleId);
	}
	
	public List<Map<String, Object>> findCoupleListByCustomerId(
			Integer customerId) {
		String sql = "SELECT cou.id,cou.from_customer_id,cusone.head_url AS fromcus_headurl, cou.to_customer_id,"
				+ "custwo.head_url AS tocus_headurl,cou.invite_time,cou.reply_time,cou.left_time,cou.state "
				+ "FROM couple cou "
				+ "INNER JOIN customer cusone ON cou.from_customer_id = cusone.id "
				+ "INNER JOIN customer custwo ON cou.to_customer_id = custwo.id "
				+ "WHERE cou.to_customer_id = ? OR cou.from_customer_id = ?";
		return this.getSession().createSQLQuery(sql).setParameter(0, customerId).setParameter(1, customerId)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}
	
	public Couple findCoupleById(Integer coupleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Couple where id =:coupleId";
		map.put("coupleId", coupleId);
		return (Couple) this.findUniqueResultWithMapParamByHQL(hql, map);
	}
}
