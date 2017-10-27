package com.cas.authority.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cas.authority.model.Regist;
import com.cas.authority.service.AbstractService;
import com.cas.authority.service.RegistService;

@Service
@Transactional
public class RegistServiceImpl extends AbstractService<Regist> implements RegistService {
	@Override
	public void save(Regist model) {
		Integer amount = model.getAmount();
		if (amount == 0) {
			return;
		}
		// 生成注册码
		model.setCode(UUID.randomUUID().toString());

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(model.getDate_start());
		gc.add(Calendar.MONTH, model.getValidity());
		model.setDate_end(gc.getTime());

		model.setUsed(0);
		if (amount > 1) {
//			以model为模板 再生成amount-1数量的注册码
			List<Regist> regList = new ArrayList<Regist>();
			regList.add(model);
			for (int i = 1; i < amount; i++) {
				Regist reg = new Regist();
				reg.setCode(UUID.randomUUID().toString());
				reg.setDate_start(model.getDate_start());
				reg.setDate_end(model.getDate_end());
				reg.setNode(model.getNode());
				reg.setUsed(model.getUsed());
				reg.setRecord_id(model.getRecord_id());
				regList.add(reg);
			}
			super.save(regList);
		} else {
			super.save(model);
		}
	}
}
