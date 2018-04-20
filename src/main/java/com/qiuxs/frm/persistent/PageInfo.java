package com.qiuxs.frm.persistent;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.qiuxs.frm.base.utils.BeanUtil;

public class PageInfo implements Pageable, Cloneable {

	/** 页码 */
	public static final String PAGE_NO = "pageNo";
	/** 每页行数 */
	public static final String PAGE_SIZE = "pageSize";
	/** 偏移量 */
	public static final String OFFSET = "offset";
	/** 排序字段 */
	public static final String ORDER_BY = "orderBy";
	/** 排序方向 */
	public static final String DIRECTION = "direction";

	/** 当前页 */
	private Integer pageNumber;
	/** 每页行数 */
	private Integer pageSize;
	/** 偏移量 */
	private Long offset;
	/** 排序对象 */
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
		PageInfo next = this.clone();
		next.pageNumber = this.getPageNumber() + 1;
		return next;
	}

	@Override
	public Pageable previousOrFirst() {
		PageInfo previous = this.clone();
		if (previous.getPageNumber() > 1) {
			previous.pageNumber = previous.getPageNumber() - 1;
		}
		return previous;
	}

	@Override
	public Pageable first() {
		PageInfo first = this.clone();
		first.pageNumber = 1;
		return first;
	}

	@Override
	public boolean hasPrevious() {
		return this.getPageNumber() > 1;
	}

	@Override
	public PageInfo clone() {
		PageInfo newPage = new PageInfo();
		BeanUtil.copyProperties(this, newPage);
		return newPage;
	}
}
