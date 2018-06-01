package com.snl.ashop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.snl.ashop.model.UserInfo;

@Service
public interface AccountService {

	int insertAdminUser(UserInfo record);
	
	UserInfo getAccountDetail(String adminId);
	
	int countAccount(HashMap<String, Object> paramMap);
	
	List<UserInfo> selectAccountList(HashMap<String, Object> paramMap);
	
	int updateAccountUseYn(UserInfo record);
}
