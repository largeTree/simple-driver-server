package com.qiuxs.salbum.frm.persistent;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageInfo implements Pageable {

	private Integer pageNumber;
	private Integer pageSize;
	private Long offset;
	private Sort sort;

	@Override
	public int getPageNumber() {
		if (this.pageNumber == null) {
			this.pageNumber = 1;
		}
		return this.pageNumber.intValue();
	}

	@Override
	public int getPageSize() {
		if (this.pageSize == null) {
			this.pageSize = 15;
		}
		return this.pageSize.intValue();
	}

	@Override
	public long getOffset() {
		if (this.offset == null) {
			this.offset = 0L;
		}
		return this.offset.longValue();
	}

	@Override
	public Sort getSort() {
		return this.sort;
	}

	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

}
