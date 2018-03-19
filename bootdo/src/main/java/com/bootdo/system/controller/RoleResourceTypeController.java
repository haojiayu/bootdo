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

import com.bootdo.system.domain.RoleResourceTypeDO;
import com.bootdo.system.service.RoleResourceTypeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 资源类型和角色对应表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-15 11:07:13
 */
 
@Controller
@RequestMapping("/sys/content_class")
public class RoleResourceTypeController {
	String prefix = "system/content_class";
	@Autowired
	private RoleResourceTypeService roleResourceTypeService;
	
	@GetMapping()
	@RequiresPermissions("system:roleResourceType:roleResourceType")
	String RoleResourceType(){
	    return prefix+"/menu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:roleResourceType:roleResourceType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RoleResourceTypeDO> roleResourceTypeList = roleResourceTypeService.list(query);
		int total = roleResourceTypeService.count(query);
		PageUtils pageUtils = new PageUtils(roleResourceTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:roleResourceType:add")
	String add(){
	    return "system/roleResourceType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:roleResourceType:edit")
	String edit(@PathVariable("id") Long id,Model model){
		RoleResourceTypeDO roleResourceType = roleResourceTypeService.get(id);
		model.addAttribute("roleResourceType", roleResourceType);
	    return "system/roleResourceType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:roleResourceType:add")
	public R save( RoleResourceTypeDO roleResourceType){
		if(roleResourceTypeService.save(roleResourceType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:roleResourceType:edit")
	public R update( RoleResourceTypeDO roleResourceType){
		roleResourceTypeService.update(roleResourceType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:roleResourceType:remove")
	public R remove( Long id){
		if(roleResourceTypeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:roleResourceType:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		roleResourceTypeService.batchRemove(ids);
		return R.ok();
	}
	
}
