package cn.zhou.core.controller.back;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhou.common.ImgServerUrl;
import cn.zhou.core.bean.BrandBean;
import cn.zhou.core.service.BrandService;

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

	@RequestMapping(value = "/brand/edit.do")
	public String brandEdit() {// frame/product_main.do

		return "/brand/edit";
	}

	/*
	 * 查询品牌数据
	 */
	@RequestMapping(value = "/brand/list.do")
	public String brandList(Integer isDisplay, Integer pageNo, String name, Model model) {// brand/list.jsp

		BrandBean brandBean = new BrandBean();
		brandBean.setName(name);
		brandBean.setIsDisplay(isDisplay);

		brandBean.divide(pageNo, brandService.queryTotal());

		if (name != null & isDisplay != null) {
			model.addAttribute("name", name);
			model.addAttribute("isDisplay", isDisplay);

		}

		model.addAttribute("serverUrl", ImgServerUrl.URL); // 返回服务器地址

		// 查询品牌数据并返回数据
		model.addAttribute("brandBean", brandService.query(brandBean));

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

		return "redirect:/admin/brand/list.do";

	}

	@RequestMapping(value = "/brand/deletes.do")
	public void deletes(Integer id) {
		brandService.deleteById(id);
	}

	@RequestMapping(value = "/brand/update.do")
	public void update(Integer id, String name, String description, String image_url, String web_site, Integer sort,
			Integer is_display) {

		brandService.updateById(new BrandBean(id, name, description, image_url, web_site, sort, is_display));
	}
}
