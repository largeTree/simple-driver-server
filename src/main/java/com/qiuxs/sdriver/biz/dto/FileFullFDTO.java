package com.qiuxs.sdriver.biz.dto;

import java.util.Map;

import com.qiuxs.sdriver.biz.entity.File;

public class FileFullFDTO {

	private File file;
	private Map<Long, IBaseFileExtDTO> extMap;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Map<Long, IBaseFileExtDTO> getExtMap() {
		return extMap;
	}

	public void setExtMap(Map<Long, IBaseFileExtDTO> extMap) {
		this.extMap = extMap;
	}

}
