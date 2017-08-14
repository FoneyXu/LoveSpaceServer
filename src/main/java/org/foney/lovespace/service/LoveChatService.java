package org.foney.lovespace.service;

import java.util.List;
import java.util.Map;

import org.foney.lovespace.model.LoveChat;

public interface LoveChatService {
	
	/**
	 * 
	 * 名称：saveLoveChat 描述：保存蜜语
	 * 创建人：xyz 创建时间：2017年7月26日下午2:39:59
	 * @param loveChat
	 *
	 */
	void saveLoveChat(LoveChat loveChat);
	
	/**
	 * 
	 * 名称：updateLoveChatState 描述：改变蜜语状态
	 * 创建人：xyz 创建时间：2017年7月26日下午2:39:28
	 * @param loveChatId
	 *
	 */
	void updateLoveChatState(Integer loveChatId,Integer loveChatState);
	
	/**
	 * 
	 * 名称：findLoveChatByStateAndCustomerId 描述：根据用户编号和蜜语状态查询蜜语
	 * 创建人：xyz 创建时间：2017年7月26日下午2:41:56
	 * @param customerId
	 * @param loveChatState
	 * @return
	 *
	 */
	List<LoveChat> findLoveChatByStateAndCustomerId(Integer customerId, Integer loveChatState);
	
	/**
	 * 
	 * 名称：findLoveChatByStateAndCoupleId 描述：根据情侣编号和状态查询
	 * 创建人：xyz 创建时间：2017年7月26日下午2:50:58
	 * @param loveChatState
	 * @param coupleId
	 * @return
	 *
	 */
	List<LoveChat> findLoveChatByStateAndCoupleId(Integer loveChatState, Integer coupleId);
	
	/**
	 * 
	 * 名称：findLoveChatByCoupleId 描述：根据情侣编号查询最近蜜语count条，按时间升序排序,包含蜜语总数
	 * 创建人：xyz 创建时间：2017年7月26日下午6:23:48
	 * @param coupleId
	 * @return
	 *
	 */
	Map<String, Object> findLoveChatByCoupleIdWith50(Integer coupleId);
	
}
