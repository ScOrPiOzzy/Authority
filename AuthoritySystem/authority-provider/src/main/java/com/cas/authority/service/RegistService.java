package com.cas.authority.service;

import java.util.List;

import com.cas.authority.model.Regist;

public interface RegistService {
	void insert(Regist regist);

	void insert(List<Regist> regist);

	void update(Regist regist);
}
