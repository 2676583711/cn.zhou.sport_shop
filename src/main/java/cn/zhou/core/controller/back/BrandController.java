package cn.zhou.core.controller.back;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhou.common.ImgServerUrl;
import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.service.BrandService;
import division_page.DividePage;

/*
 * 品牌
 */
@Controller
@RequestMapping(value = "/admin")
public class BrandController {

	@Resource
	BrandService brandService;

	/*
	 * @RequestParam(value = "img", required = false)
	 * value是html/jsp中的上传表单的name,required表示是否必须上传图片
	 */

	@RequestMapping(value = "/brand/add.do")
	public String brandAdd(String name, String description, Integer sort, Integer isDisplay, String imageUrl) { // frame/product_main.do

		BrandBean brandBean = new BrandBean(name, description, sort, isDisplay, imageUrl);
		brandService.add(brandBean);

		brandBean.toString();
		return "/brand/add";
	}

	/*
	 * 跳转修改页面
	 */
	@RequestMapping(value = "/brand/edit.do")
	public String brandEdit(Integer id, Model map) {// frame/product_main.do

		map.addAttribute("brandBean", brandService.queryById(id));
		// map.addAttribute("serverUrl", ImgServerUrl.URL); // 返回服务器地址

		return "/brand/edit";
	}

	// Integer id, String name, String description, String image_url, String
	// web_site, Integer sort,
	// Integer is_display
	// 修改品牌信息
	@RequestMapping(value = "/brand/update.do")
	public String update(Integer id, String name, String imageUrl, String description, Integer sort,
			Integer isDisplay) {

		BrandBean brandBean = new BrandBean();
		brandBean.setId(id);
		brandBean.setName(name);
		brandBean.setImageUrl(imageUrl);
		brandBean.setDescription(description);
		brandBean.setSort(sort);
		brandBean.setIsDisplay(isDisplay);

		brandService.updateById(brandBean);

		return "/brand/list";// edit
	}

	/*
	 * 查询品牌数据
	 */
	@RequestMapping(value = "/brand/list.do")
	public String brandList(Integer id, String name, Integer isDisplay, Integer pageNo, Model model) {// brand/list.jsp

		if (name != null & isDisplay != null) {
			model.addAttribute("name", name);
			model.addAttribute("isDisplay", isDisplay);

		}
		// 返回服务器地址
		model.addAttribute("serverUrl", ImgServerUrl.URL);

		// 查询品牌数据并返回数据, pageNo, brandService.queryTotal()
		BrandBean brandBean = new BrandBean();
		brandBean.setId(id);
		brandBean.setName(name);
		brandBean.setIsDisplay(isDisplay);
		brandBean.setPageCode(pageNo);
		brandBean.setTotalRecord(brandService.queryTotal());

		// 查询品牌数据并返回数据
		model.addAttribute("brandBean", brandService.query(brandBean));

		return "/brand/list";
	}

	// divide

	/*
	 * 查询品牌数据
	 * 
	 * 分页查询
	 * 
	 * 
	 */

	@RequestMapping(value = "/brand/divide.do")
	public String divide(Integer id, String name, Integer isDisplay, Integer pageNo, Model model) {// brand/list.jsp

		System.out.println("************id,   name,   isDisplay\n" + id + "\n" + name + "\n" + isDisplay);

		if (name != null & isDisplay != null) {
			model.addAttribute("name", name);
			model.addAttribute("isDisplay", isDisplay);
		}
		// 返回服务器地址
		model.addAttribute("serverUrl", ImgServerUrl.URL);

		// 设置品牌查询条件

		BrandBean brandBean = new BrandBean();
		brandBean.setId(id);
		brandBean.setName(name);
		brandBean.setIsDisplay(isDisplay);
		brandBean.setPageCode(pageNo);
		brandBean.setTotalRecord(brandService.queryTotal());

		// 查询品牌数据并返回数据
		// model.addAttribute("brandBean", brandService.query(brandBean));

		model.addAttribute("pageBean",
				DividePage.getPageBean(pageNo, brandService.query(brandBean), brandService.queryTotal()));

		// 返回分页显示所需的条件
		// model.addAttribute("divisionPage", divisionPage);

		return "/brand/list";
	}

	/*
	 * 删除品牌
	 */

	@RequestMapping(value = "/brand/delete.do")
	public String delete(Integer id, String name, Integer isDisplay, ModelMap map) {

		if (name != null || !name.isEmpty() || !name.equals(" ")) {
			map.addAttribute("name", name);
		}

		if (isDisplay != null) {
			map.addAttribute("isDisplay", isDisplay);
		}

		System.out.println("id=" + id);
		System.out.println("name=" + name);
		System.out.println("isDisplay=" + isDisplay);

		brandService.deleteById(id);

		return "/brand/list";

	}

	/*
	 * 多个删除
	 */
	@RequestMapping(value = "/brand/deletes.do")
	public String deletes(Integer[] ids, String name, Integer isDisplay, ModelMap map) {

		if (name != null || !name.isEmpty()) {
			map.addAttribute("name", name);
		}

		if (isDisplay != null) {
			map.addAttribute("isDisplay", isDisplay);
		}

		brandService.deleteByIds(ids);

		System.out.println("******************************ids[]=\n" + ids[0] + "\n" + ids[1]);
		return "redirect:/admin/brand/list.do";
	}

}
