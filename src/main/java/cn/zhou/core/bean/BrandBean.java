package cn.zhou.core.bean;

public class BrandBean {

	private Integer id; // 品牌id
	private String name; // 品牌名称
	private String description; // 品牌描述
	private String imageUrl; // 图片地址
	private String webSite;// 网页地址
	private Integer sort; // 排序
	private Integer isDisplay; // 是否显示，０否，１是

	/// 分页数据
	private static Integer pageNo; // 页号,当前的页面页数****
	private static Integer totalPages; // 总页数，根据总记录数和每页显示的数计算得出的
	private static Integer total; // 数据库数据的总记录数 ******
	private static Integer limit = 5; // 每页需要显示的数据的条数,默认每次查询数据条数限制在５条

	private static Integer startIndex; // 每页数据的第一条索引
	private static Integer previousPage; // 当前页的前一页
	private static Integer nextPage; // 当前页的下一页

	public BrandBean() {
		super();

	}

	public BrandBean(Integer id, String name, Integer isDisplay) {
		super();
		this.id = id;
		this.name = name;
		this.isDisplay = isDisplay;
	}

	public BrandBean(String name, String description, Integer sort, Integer isDisplay) {
		super();
		this.name = name;
		this.description = description;
		this.sort = sort;
		this.isDisplay = isDisplay;
	}

	public BrandBean(Integer id, String name, String description, String imageUrl, Integer sort, Integer isDisplay) {
		super();
		this.id = id;
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

	// 分页构造器
	public BrandBean(Integer id, String name, Integer isDisplay, Integer pageNo, Integer total) {
		super();
		this.id = id;
		this.name = name;
		this.isDisplay = isDisplay;
		this.pageNo = pageNo;
		this.total = total;

		// 调用分页数据处理的方法
		divide(pageNo, total);
	}

	// 分页构造器
	public BrandBean(Integer id, String name, String description, String imageUrl, String webSite, Integer sort,
			Integer isDisplay, Integer pageNo, Integer total) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.webSite = webSite;
		this.sort = sort;
		this.isDisplay = isDisplay;
		this.pageNo = pageNo;
		this.total = total;

		// 调用分页数据处理的方法
		divide(pageNo, total);
	}

	// 分页构造器
	public BrandBean(Integer id, String name, String description, String imageUrl, String webSite, Integer sort,
			Integer isDisplay, Integer pageNo, Integer total, Integer limit) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.webSite = webSite;
		this.sort = sort;
		this.isDisplay = isDisplay;
		this.pageNo = pageNo;
		this.total = total;
		this.limit = limit;

		// 调用分页数据处理的方法
		divide(pageNo, total);
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

	// 分页数据getter setter
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	// 分页数据的处理
	public static void divide(Integer pageNo, Integer total) {

		totalPages = (int) Math.ceil(total / limit); // 通过总记录数和限制数计算总页数

		if (pageNo == null || pageNo <= 1) {// 判断当前页码数的合法性 pageNo = 1; }
			pageNo = 1; // 如果pageNo为空或者为零就使其为1

			if (pageNo >= totalPages) {
				pageNo = totalPages;

			}

			startIndex = (pageNo - 1) * limit; // 通过当前页码和限制数计算每页第一条记录的索引
			// this.pageNo = pageNo;
			System.out.println("*****totalPages=" + totalPages);
			System.out.println("*****totalPages=" + startIndex);
		}
	}

	@Override
	public String toString() {
		return "BrandBean [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", webSite=" + webSite + ", sort=" + sort + ", isDisplay=" + isDisplay + "]";
	}

}
