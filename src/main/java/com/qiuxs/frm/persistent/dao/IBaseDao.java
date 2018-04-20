package com.qiuxs.frm.persistent.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qiuxs.frm.persistent.entiry.IBaseEntity;

public interface IBaseDao<PK extends Serializable, T extends IBaseEntity<PK>> extends JpaRepository<T, PK> {

}
