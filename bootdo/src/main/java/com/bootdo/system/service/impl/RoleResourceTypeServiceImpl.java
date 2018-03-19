package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.RoleResourceTypeDao;
import com.bootdo.system.domain.RoleResourceTypeDO;
import com.bootdo.system.service.RoleResourceTypeService;



@Service
public class RoleResourceTypeServiceImpl implements RoleResourceTypeService {
	@Autowired
	private RoleResourceTypeDao roleResourceTypeDao;
	
	@Override
	public RoleResourceTypeDO get(Long id){
		return roleResourceTypeDao.get(id);
	}
	
	@Override
	public List<RoleResourceTypeDO> list(Map<String, Object> map){
		return roleResourceTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return roleResourceTypeDao.count(map);
	}
	
	@Override
	public int save(RoleResourceTypeDO roleResourceType){
		return roleResourceTypeDao.save(roleResourceType);
	}
	
	@Override
	public int update(RoleResourceTypeDO roleResourceType){
		return roleResourceTypeDao.update(roleResourceType);
	}
	
	@Override
	public int remove(Long id){
		return roleResourceTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return roleResourceTypeDao.batchRemove(ids);
	}
	
}
