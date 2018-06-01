package com.snl.ashop.data;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;

import com.snl.ashop.model.UserInfo;

@Mapper
public interface Account_SQL {
	
	/**
	 * 신규 계정 등록
	 */
	int insert(UserInfo record);
	
	/**
	 * 계정 상세
	 */
	@ResultMap("AdminUserMap")
	UserInfo selectAccountDetail(String adminId);
	
	/**
	 * 계정 관리 목록
	 */
	int countAccount(HashMap<String, Object> paramMap);
	List<UserInfo> selectAccountList(HashMap<String, Object> paramMap);
	
	/**
	 * 계정 상세 내용
	 */
	UserInfo selectByPrimaryKey(String usrId);
	
	/**
	 * 계정 사용여부 갱신
	 */
	int updateAccountUseYn(UserInfo record);
	
}
