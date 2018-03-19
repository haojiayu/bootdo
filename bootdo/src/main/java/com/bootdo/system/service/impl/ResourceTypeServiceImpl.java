package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ResourceTypeDao;
import com.bootdo.system.domain.ResourceTypeDO;
import com.bootdo.system.service.ResourceTypeService;



@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {
	@Autowired
	private ResourceTypeDao resourceTypeDao;
	
	@Override
	public ResourceTypeDO get(Long id){
		return resourceTypeDao.get(id);
	}
	
	@Override
	public List<ResourceTypeDO> list(Map<String, Object> map){
		return resourceTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return resourceTypeDao.count(map);
	}
	
	@Override
	public int save(ResourceTypeDO resourceType){
		return resourceTypeDao.save(resourceType);
	}
	
	@Override
	public int update(ResourceTypeDO resourceType){
		return resourceTypeDao.update(resourceType);
	}
	
	@Override
	public int remove(Long id){
		return resourceTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return resourceTypeDao.batchRemove(ids);
	}
	
}
