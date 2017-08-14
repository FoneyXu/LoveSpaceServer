package org.foney.lovespace.dao;

import java.util.List;

import org.foney.lovespace.model.LoveChat;
import org.springframework.stereotype.Repository;

@Repository("loveChatDao")
public class LoveChatDao extends GeneralDao<LoveChat>{
	
	public void updateLoveChatState(Integer loveChatId,Integer loveChatState) {
		String hql = "update LoveChat set state = ? where id = ?";
		this.updateByHQL(hql, loveChatState,loveChatId);
	}
	
	public List<LoveChat> findLoveChatByStateAndCustomerId(Integer customerId,
			Integer loveChatState) {
		return null;
	}
	
	public List<LoveChat> findLoveChatByStateAndCoupleId(Integer loveChatState,
			Integer coupleId) {
		String hql = "from LoveChat where coupleId = ? and state = ?";
		return this.findListByHQL(hql, coupleId,loveChatState);
	}
	
	
	public List<LoveChat> findLoveChatByCoupleIdWith50(Integer coupleId) {
		String sql = "SELECT * FROM"
				+"(SELECT * FROM love_chat WHERE couple_id = ? ORDER BY create_time DESC LIMIT 0,30) a "
				+"ORDER BY a.create_time ASC";
		return this.findListBySQL(sql, LoveChat.class, coupleId);
	}
	
	public Long findLoveChatCountByCoupleId(Integer coupleId) {
		String sql = "select count(1) from love_chat where couple_id = ?";
		return (long)this.countBySql_o(sql, coupleId);
	}
}
