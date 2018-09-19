package com.qianfeng.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.vo.JsonBean;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	@ResponseBody
	public JsonBean login(String no, String password){
		
		UsernamePasswordToken token = new UsernamePasswordToken(no, password);
		// 设置 记住我=true，不使用配置也可以生效（生成cookie）
//		if(rememberMe != null && rememberMe == true){
//			// 不使用配置，有效期默认1年，使用配置，可以设置有效期，加密算法等操作
//			token.setRememberMe(true);
//		}
		Subject subject = SecurityUtils.getSubject();

		JsonBean bean = new JsonBean();
		try {
			subject.login(token); 
			bean.setCode(1);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		return bean;
		
	}
}






