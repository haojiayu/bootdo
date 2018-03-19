package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.ResourceTypeDO;
import com.bootdo.system.service.ResourceTypeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-15 14:46:03
 */
 
@Controller
@RequestMapping("/system/resourceType")
public class ResourceTypeController {
	@Autowired
	private ResourceTypeService resourceTypeService;
	
	@GetMapping()
	@RequiresPermissions("system:resourceType:resourceType")
	String ResourceType(){
	    return "system/resourceType/resourceType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:resourceType:resourceType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ResourceTypeDO> resourceTypeList = resourceTypeService.list(query);
		int total = resourceTypeService.count(query);
		PageUtils pageUtils = new PageUtils(resourceTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:resourceType:add")
	String add(){
	    return "system/resourceType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:resourceType:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ResourceTypeDO resourceType = resourceTypeService.get(id);
		model.addAttribute("resourceType", resourceType);
	    return "system/resourceType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:resourceType:add")
	public R save( ResourceTypeDO resourceType){
		if(resourceTypeService.save(resourceType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:resourceType:edit")
	public R update( ResourceTypeDO resourceType){
		resourceTypeService.update(resourceType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:resourceType:remove")
	public R remove( Long id){
		if(resourceTypeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:resourceType:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		resourceTypeService.batchRemove(ids);
		return R.ok();
	}
	
}
