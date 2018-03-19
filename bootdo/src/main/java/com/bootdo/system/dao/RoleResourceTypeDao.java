package com.bootdo.system.dao;

import com.bootdo.system.domain.RoleResourceTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 资源类型和角色对应表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-15 11:07:13
 */
@Mapper
public interface RoleResourceTypeDao {

	RoleResourceTypeDO get(Long id);
	
	List<RoleResourceTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleResourceTypeDO roleResourceType);
	
	int update(RoleResourceTypeDO roleResourceType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
