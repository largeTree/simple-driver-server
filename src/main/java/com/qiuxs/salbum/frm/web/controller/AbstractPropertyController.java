package com.qiuxs.salbum.frm.web.controller;

import java.io.Serializable;

import com.qiuxs.salbum.frm.persistent.entiry.IBaseEntity;
import com.qiuxs.salbum.frm.persistent.service.AbstractPropertyService;

public abstract class AbstractPropertyController<PK extends Serializable, T extends IBaseEntity<PK>, S extends AbstractPropertyService<PK, T>> extends BaseController {

	protected abstract S getService();
}
