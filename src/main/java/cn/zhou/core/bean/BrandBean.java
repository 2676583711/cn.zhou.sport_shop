package cn.zhou.core.bean;

public class BrandBean {

	private Integer id; // 品牌id
	private String name; // 品牌名称
	private String description; // 品牌描述
	private String imageUrl; // 图片地址

	private String webSite;// 网页地址

	private Integer sort; // 排序
	private Integer isDisplay; // 是否显示，０否，１是

	private Integer pageNo; // 页号,当前的页面页数****
	private Integer totalPages; // 总页数，根据总记录数和每页显示的数计算得出的
	private Integer total; // 数据库数据的总记录数 ******
	private Integer limit = 5; // 每页需要显示的数据的条数,默认每次查询数据条数限制在５条
	private Integer startIndex; // 每页数据的第一条索引

	private Integer previousPage; // 当前页的前一页
	private Integer nextPage; // 当前页的下一页

	public BrandBean() {
		super();

	}

	public BrandBean(String name, String description, Integer sort, Integer isDisplay) {
		super();
		this.name = name;
		this.description = description;
		this.sort = sort;
		this.isDisplay = isDisplay;
	}

	public BrandBean(String name, String description, Integer sort, Integer isDisplay, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.sort = sort;
		this.isDisplay = isDisplay;
	}

	public BrandBean(Integer id, String name, String description, String imageUrl, String webSite, Integer sort,
			Integer isDisplay) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.webSite = webSite;
		this.sort = sort;
		this.isDisplay = isDisplay;
	}

	public void divide(Integer pageNo, Integer total) {

		this.totalPages = (int) Math.ceil(total / this.limit); // 通过总记录数和限制数计算总页数

		if (pageNo == null || pageNo <= 1) {// 判断当前页码数的合法性
			pageNo = 1;
		}

		if (pageNo >= this.totalPages) {
			pageNo = this.totalPages;

		}

		this.startIndex = (pageNo - 1) * this.limit; // 通过当前页码和限制数计算每页第一条记录的索引
		this.pageNo = pageNo;

		System.out.println("totalPages=" + this.totalPages);
	}

	public Integer getPreviousPage() {
		// return previousPage;

		if (this.pageNo == 1) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

	public void setPreviousPage(Integer previousPage) {
		if (this.pageNo == 1) {
			this.previousPage = pageNo;

		} else {
			this.previousPage = pageNo - 1;
		}
	}

	public Integer getNextPage() {

		if (pageNo >= this.totalPages) {
			return this.totalPages;

		} else

			return this.pageNo + 1;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getPageStart() {
		return startIndex;
	}

	public void setPageStart(Integer pageStart) {
		this.startIndex = pageStart;
	}

	public Integer getTotalPage() {
		return totalPages;
	}

	public void setTotalPage(Integer totalPage) {

		this.totalPages = totalPage;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {

		this.pageNo = pageNo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {

		this.total = total;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {

		this.totalPages = totalPages;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	@Override
	public String toString() {
		return "BrandBean [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", webSite=" + webSite + ", sort=" + sort + ", isDisplay=" + isDisplay + ", pageNo=" + pageNo
				+ ", totalPages=" + totalPages + ", total=" + total + ", limit=" + limit + ", startIndex=" + startIndex
				+ "]";
	}

}
