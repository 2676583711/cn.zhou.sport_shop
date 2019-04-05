package cn.zhou.core.bean;

import cn.zhou.common.ImgServerUrl;

public class BrandBean {

	private Integer id; // 品牌id
	private String name; // 品牌名称
	private String description; // 品牌描述
	private String imageUrl; // 图片地址
	private String webSite;// 网页地址
	private Integer sort; // 排序
	private Integer isDisplay; // 是否显示，０否，１是

	// 使用static 关键字缓存数据
	private Integer pageCode;// 当前页码 static
	private Integer totalRecord;// 总记录数
	private Integer totalPages;// 总页数
	private Integer pageSize = 5;// 页面显示记录数
	private Integer startIndex; // 每页第一条数据的索引

	// 图片地址
	private String picUrl;

	public String getPicUrl() {
		return ImgServerUrl.URL + getImageUrl(); // picUrl
	}

//	public void setPicUrl(String picUrl) {
//		this.picUrl = picUrl;
//	}

	public Integer getStartIndex() {
		return (getPageCode() - 1) * getPageSize();
	}

//	public void setStartIndex(Integer startIndex) {
//		this.startIndex = startIndex;
//	}

	public Integer getPageCode() {

		return pageCode;
	}

	public void setPageCode(Integer pageCode) {

		if (pageCode == null || pageCode <= 0) {
			this.pageCode = 1;
		} else
			this.pageCode = pageCode;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPages() {

//		return this.totalRecord / this.pageSize == 0 ? this.totalRecord / this.pageSize
//				: this.totalRecord / this.pageSize + 1; // totalPages
		return getTotalRecord() / getPageSize() == 0 ? getTotalRecord() / getPageSize()
				: getTotalRecord() / getPageSize() + 1;
	}

//页面总数有总记录数和页面显示数记录得到
//	public void setTotalPages(Integer totalPages) {
//		this.totalPages = totalPages;
//	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

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
				+ ", webSite=" + webSite + ", sort=" + sort + ", isDisplay=" + isDisplay + ", pageCode=" + pageCode
				+ ", totalRecord=" + totalRecord + ", totalPages=" + totalPages + ", pageSize=" + pageSize
				+ ", startIndex=" + startIndex + "]";
	}

//	@Override
//	public String toString() {
//		return "BrandBean [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
//				+ ", webSite=" + webSite + ", sort=" + sort + ", isDisplay=" + isDisplay + "]";
//	}

}
