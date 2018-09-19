package com.qianfeng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IRoleListDao;
import com.qianfeng.entity.RoleList;
import com.qianfeng.service.IRoleListService;
@Service
public class RoleListService implements IRoleListService{

	@Autowired
	private IRoleListDao rlDao;
	
	@Override
	public Map<String, Object> findRoleListByNo() {
		// TODO Auto-generated method stub
		List<RoleList> list = null;
		list = rlDao.findRoleByNo();
		return list;
	}

}
