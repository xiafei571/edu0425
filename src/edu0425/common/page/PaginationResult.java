package edu0425.common.page;


public class PaginationResult<T> {//rs

	private Pagination pagination;
	
	private T pageData;

	public PaginationResult(Pagination pagination, T pageData) {
		super();
		this.pagination = pagination;
		this.pageData = pageData;
	}
	
	public PaginationResult() {
		
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public T getPageData() {
		return pageData;
	}

	public void setPageData(T pageData) {
		this.pageData = pageData;
	}
}
