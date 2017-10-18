package com.cas.authority.service;

import java.util.List;

import com.cas.authority.model.Record;
import com.cas.authority.model.RecordDetail;
import com.cas.authority.model.UserRegistEntity;

/**
 * Created by CodeGenerator on 2017/10/13.
 */
public interface RecordService extends Service<Record> {
	RecordDetail findDetailBy(Integer id);

	List<RecordDetail> findAllDetail();

	UserRegistEntity findRecord(String code, String customName);
}
