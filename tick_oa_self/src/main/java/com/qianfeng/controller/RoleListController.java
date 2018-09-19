package com.qianfeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.RoleList;
import com.qianfeng.service.IRoleListService;
import com.qianfeng.vo.JsonBean;

@Controller
public class RoleListController {
	
	@Autowired
	private IRoleListService rlService;
	
	@RequestMapping(value="/usermenu",method=RequestMethod.GET)
	@ResponseBody
	public JsonBean findUserMenu(RoleList roleList) {
		JsonBean bean = new JsonBean();
		try {
			
			List<RoleList> list = rlService.findRoleListByNo();
			bean.setCode(1);
			bean.setMsg(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		return bean;
	
		
		
		
	}
}
