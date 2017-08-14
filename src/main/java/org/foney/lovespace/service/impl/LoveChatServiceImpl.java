package org.foney.lovespace.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.foney.lovespace.dao.LoveChatDao;
import org.foney.lovespace.model.LoveChat;
import org.foney.lovespace.service.LoveChatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loveChatService")
@Transactional
public class LoveChatServiceImpl implements LoveChatService{
	
	@Resource
	private LoveChatDao loveChatDao;
	
	@Override
	public void saveLoveChat(LoveChat loveChat) {
		loveChatDao.save(loveChat);
	}

	@Override
	public void updateLoveChatState(Integer loveChatId,Integer loveChatState) {
		loveChatDao.updateLoveChatState(loveChatId, loveChatState);
	}

	@Override
	public List<LoveChat> findLoveChatByStateAndCustomerId(Integer customerId,
			Integer loveChatState) {
		return loveChatDao.findLoveChatByStateAndCustomerId(customerId, loveChatState);
	}

	@Override
	public List<LoveChat> findLoveChatByStateAndCoupleId(Integer loveChatState,
			Integer coupleId) {
		return loveChatDao.findLoveChatByStateAndCoupleId(loveChatState, coupleId);
	}

	@Override
	public Map<String, Object> findLoveChatByCoupleIdWith50(Integer coupleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LoveChat> loveChats = loveChatDao.findLoveChatByCoupleIdWith50(coupleId);
		Long count = loveChatDao.findLoveChatCountByCoupleId(coupleId);
		map.put("loveChats", loveChats);
		map.put("count", count);
		return map;
		
	}
	

}
