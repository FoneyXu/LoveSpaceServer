package org.foney.lovespace.service;

import java.util.List;
import java.util.Map;

import org.foney.lovespace.model.Couple;
import org.foney.lovespace.util.Prompt;

public interface CoupleService {
	
	/**
	 * 
	 * 名称：findCoupleByFromOrToCustomerId 描述：根据发送人或者接受人查询邀请信息是否存在，两个人之间只能存在一条邀请中的邀请
	 * 创建人：xyz 创建时间：2017年7月30日下午6:00:09
	 * @param fromCustomerId
	 * @param toCustomerId
	 * @return
	 *
	 */
	Couple findCoupleByFromOrToCustomerId(Integer fromCustomerId,Integer toCustomerId);
	
	/**
	 * 
	 * 名称：updateCoupleStateById 描述：更新情侣关系状态，回复，拒绝时使用
	 * 创建人：xyz 创建时间：2017年7月30日下午6:32:14
	 * @param coupleId
	 * @param state
	 * @return
	 *
	 */
	Prompt updateCoupleStateById(Integer coupleId,Integer state);
	
	/**
	 * 
	 * 名称：findCoupleListByCustomerId 描述：根据用户编号查询情侣关系信息
	 * 创建人：xyz 创建时间：2017年7月30日下午6:32:51
	 * @param customerId
	 * @return
	 *
	 */
	List<Map<String, Object>> findCoupleListByCustomerId(Integer customerId);
}
