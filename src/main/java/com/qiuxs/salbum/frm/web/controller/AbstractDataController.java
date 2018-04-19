package com.qiuxs.salbum.frm.web.controller;

import java.io.Serializable;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qiuxs.salbum.frm.persistent.dao.IBaseDao;
import com.qiuxs.salbum.frm.persistent.entiry.IBaseEntity;
import com.qiuxs.salbum.frm.persistent.service.AbstractDataService;

public abstract class AbstractDataController<PK extends Serializable, T extends IBaseEntity<PK>, D extends IBaseDao<PK, T>, S extends AbstractDataService<PK, T, D>> extends AbstractPropertyController<PK, T, S> {

	@PostMapping("/create")
	public String create(@RequestParam Map<String, String> params, @RequestParam(name = "jsonParam", required = false) String jsonParam) {
		return super.responseRes(params);
	}

}
