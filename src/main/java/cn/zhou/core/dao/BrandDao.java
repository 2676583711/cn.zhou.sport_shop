package cn.zhou.core.dao;

import java.util.List;

import cn.zhou.core.bean.BrandBean;
import division_page.PageBean;

/*
 * 品牌数据访问接口
 * 
 */

public interface BrandDao {

	// 添加品牌
	public void add(BrandBean brandBean);

	// 查询品牌信息
	public List<BrandBean> query(BrandBean brandBean);

	// 查询品牌数据总记录数
	public Integer queryTotal();

	// 根据id查询品牌数据List<BrandBean>
	public BrandBean queryById(Integer id);

	// 根据品牌名称查询品牌数据
	public List<BrandBean> queryByName(String name);

	// 根据品牌id删除品牌数据
	public void deleteById(Integer id);

	// 批量删除品牌数据，根据多个id
	public void deleteByIds(Integer[] ids);

	// 根据品牌id修改数据
	public void updateById(BrandBean brandBean);
}
