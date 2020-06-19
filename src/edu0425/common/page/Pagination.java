package edu0425.common.page;

public class Pagination {
	// 1. 页码
	private Integer pageIndex;
	// 2. 每页数量
	private Integer pageSize;
	// 3. 一共多少条数据
	private Integer totalCount;
	// 4. 一共多少页  = (totalCount + pageSize - 1)/pageSize  (10 + 3-1)/3 = 4
	private Integer totalCountPage;
	// 5. 当前页数据数量 list.size()
	private Integer currentPageCount;
	// 6. 游标开始 (pageIndex-1) * pageSize
	private Integer cursor;
	// 7.每页数量 = pageSize
	private Integer offset;
	
	public Pagination(Integer pageIndex, Integer pageSize) {
		if(null == pageIndex || null == pageSize) {
			this.pageIndex = 1;
			this.pageSize = 10;
		}else {
			this.pageIndex = pageIndex;
			this.pageSize = pageSize;
		}
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalCountPage() {
		if(null == totalCountPage) {
			totalCountPage = (totalCount + pageSize - 1) / pageSize;
		}
		
		return totalCountPage;
	}

	public void setTotalCountPage(Integer totalCountPage) {
		this.totalCountPage = totalCountPage;
	}

	public Integer getCurrentPageCount() {
		return currentPageCount;
	}

	public void setCurrentPageCount(Integer currentPageCount) {
		this.currentPageCount = currentPageCount;
	}

	public Integer getCursor() {
		if(null == cursor) {
			cursor = (pageIndex - 1) * pageSize;
		}
		return cursor;
	}

	public void setCursor(Integer cursor) {
		this.cursor = cursor;
	}

	public Integer getOffset() {
		if(null == offset) {
			offset = pageSize;
		}
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}
