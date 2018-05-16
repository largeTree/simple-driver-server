package com.qiuxs.frm.persistent;

import org.apache.ibatis.session.RowBounds;

import com.qiuxs.frm.base.utils.BeanUtil;

public class PageInfo extends RowBounds implements Cloneable {

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

	@Override
	public PageInfo clone() {
		PageInfo newPage = new PageInfo();
		BeanUtil.copyProperties(this, newPage);
		return newPage;
	}
}
