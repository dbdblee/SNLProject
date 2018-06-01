package com.snl.ashop.account;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.snl.ashop.model.User;
import com.snl.ashop.model.UserInfo;
import com.snl.ashop.service.AccountService;

@Service
public class UserService implements UserDetailsService {
	private static final Log log = LogFactory.getLog(UserService.class);

	@Autowired
	AccountService accountService;
	
	@Override
	public User loadUserByUsername(final String username) {
		
		User user = new User();
		try {
			//회원정보 dao에서 데이터를 읽어 옴.
			log.info("username : " + username);
			
			UserInfo userInfo = accountService.getAccountDetail(username);
			user.setUsername(username);
			user.setPassword(userInfo.getUser_pw());
			user.setUserInfo(userInfo);
			//role 세팅
			Role role = new Role();
			role.setName("ROLE_USER");
			
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setAuthorities(roles);
			
		} catch (Exception e) {
			//throw new ServiceException("사용자 정보를 찾을 수 없습니다.");
			throw new UsernameNotFoundException(e +"  사용자 정보를 찾을 수 없습니다.");
		}
		
		return user;
	}
}
