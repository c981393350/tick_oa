package com.qianfeng.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.qianfeng.dao.IUserDao;
import com.qianfeng.entity.User;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	private IUserDao userDao;
	
//	@Autowired
//	private IResourcesDao resDao;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
		// TODO Auto-generated method stub
		// 获取输入的用户名
//		String name = (String)principals.getPrimaryPrincipal();
//		// 从数据库获取用户的角色和权限列表
//		
//		List<String> roleList = resDao.findRoleByUname(name);
//		List<String> permitList = resDao.findPermitByUname(name);
//		
//		Set<String> roleSet = new HashSet<>(roleList);
//		Set<String> perSet = new HashSet<>(permitList);
//				
//		// 授权信息的对象
//		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
//		// 设置用户对应的角色
//		info.setRoles(roleSet);
//		// 设置对应的权限
//		info.setStringPermissions(perSet);
//		
//		return info;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		// 获取token中的用户名
		String no = (String)token.getPrincipal();
		
		// 从数据库中根据用户名获取密码信息
		User user = userDao.findByName(no);
		if(user == null){ 
			throw new UnknownAccountException();
		}
		String password = user.getPassword();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(no, password, this.getName());
		
		return info;
	}

}
