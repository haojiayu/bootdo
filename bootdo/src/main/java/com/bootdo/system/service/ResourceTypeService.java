package com.bootdo.system.service;

import com.bootdo.system.domain.ResourceTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-15 14:46:03
 */
public interface ResourceTypeService {
	
	ResourceTypeDO get(Long id);
	
	List<ResourceTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ResourceTypeDO resourceType);
	
	int update(ResourceTypeDO resourceType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
