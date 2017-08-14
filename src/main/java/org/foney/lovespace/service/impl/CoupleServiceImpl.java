package org.foney.lovespace.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.foney.lovespace.dao.CoupleDao;
import org.foney.lovespace.dao.CustomerDao;
import org.foney.lovespace.model.Couple;
import org.foney.lovespace.service.CoupleService;
import org.foney.lovespace.util.Prompt;
import org.foney.lovespace.util.SysUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoupleServiceImpl implements CoupleService{
	
	@Resource
	private CoupleDao coupleDao;
	@Resource
	private CustomerDao customerDao;
	
	@Override
	public Couple findCoupleByFromOrToCustomerId(Integer fromCustomerId,
			Integer toCustomerId) {
		return coupleDao.findCoupleByFromOrToCustomerIdWithState(fromCustomerId, toCustomerId, 0);
	}

	@Override
	public Prompt updateCoupleStateById(Integer coupleId, Integer state) {
		Prompt prompt = Prompt.getInstance();
		prompt.setResult(SysUtil.RESULT_TRUE);
		Couple couple = coupleDao.findCoupleById(coupleId);
		//回复：为同意，更新情侣关系，更新用户信息
		try {
			if(state == 1) {
				coupleDao.updateCoupleStateByIdWithReply(coupleId, state);
				customerDao.updateCustomerCoupleStateOneById(couple.getFromCustomerId(), couple.getToCustomerId(),couple.getId());
				customerDao.updateCustomerCoupleStateOneById(couple.getToCustomerId(), couple.getFromCustomerId(),couple.getId());
			}
			//回复：更新情侣关系为已拒绝
			if(state == 2) {
				coupleDao.updateCoupleStateByIdWithReply(coupleId, state);
			}
			//分手：更新情侣关系表，更新用户信息
			if(state == 3) {
				coupleDao.updateCoupleStateByIdWithLeft(coupleId);
				customerDao.updateCustomerCoupleStateZeroById(couple.getFromCustomerId());
				customerDao.updateCustomerCoupleStateZeroById(couple.getToCustomerId());
			}
		} catch (Exception e) {
			prompt.setResult(SysUtil.RESULT_FALSE);
			prompt.setMsg("更新情侣关系异常");
			e.printStackTrace();
		}
		return prompt;
	}

	@Override
	public List<Map<String, Object>> findCoupleListByCustomerId(
			Integer customerId) {
		return this.coupleDao.findCoupleListByCustomerId(customerId);
	}

}
