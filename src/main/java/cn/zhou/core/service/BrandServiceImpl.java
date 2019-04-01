package cn.zhou.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.dao.BrandDao;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Resource
	BrandDao brandDao;

	@Override
	public void add(BrandBean brandBean) {
		brandDao.add(brandBean);
	}

	@Override
	public List<BrandBean> query(BrandBean brandBean) {

		return brandDao.query(brandBean);
	}

	@Override
	public BrandBean queryById(Integer id) {
		return brandDao.queryById(id);
	}

	@Override
	public List<BrandBean> queryByName(String name) {

		return brandDao.queryByName(name);
	}

	@Override
	public int queryTotal() {
		return brandDao.queryTotal();
	}

	// 根据品牌id删除数据
	@Override
	public void deleteById(Integer id) {
		brandDao.deleteById(id);
	}

	// 根据多个id删除数据
	@Override
	public void deleteByIds(Integer[] ids) {
		brandDao.deleteByIds(ids);
	}

	// 根据id修改数据
	@Override
	public void updateById(BrandBean brandBean) {
		brandDao.updateById(brandBean);
	}

}
