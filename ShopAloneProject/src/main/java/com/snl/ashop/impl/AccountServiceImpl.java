package com.snl.ashop.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restexpress.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.snl.ashop.data.Account_SQL;
import com.snl.ashop.model.UserInfo;
import com.snl.ashop.service.AccountService;

@Repository
public class AccountServiceImpl implements AccountService {

	protected final Log log = LogFactory.getLog(this.getClass());

	@Autowired
	Account_SQL accountMapper;

	@Autowired
	Configuration configuration;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kt.its.service.AccountService#insertAdminUser(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public int insertAdminUser(UserInfo record) {
		int result = 0;

		try {
			// 0. 비밀번호 인코딩
			String pwd = record.getUser_pw();
			String bCryptPwd = passwordEncoder.encode(pwd);
			record.setUser_pw(bCryptPwd);

			result = accountMapper.insert(record);
			/*
			 * if (result > 0) {
			 * 
			 * } else { throw new ServiceException("신규 계정을 저장하는 중에 오류가 발생하였습니다."); }
			 */
		} catch (Exception e) {
			log.error(e);
			throw new ServiceException("신규 계정을 저장하는 중에 오류가 발생하였습니다.");
		}

		return result;
	}

	/**
	 * 
	 * @param nowDate
	 * @param count
	 * @return
	 * 
	 * 		채널 아이디 생성
	 */
	private String getChannelChIdFormat(Date nowDate, int count) {
		return "H" + getCurrentTimetamp(nowDate) + String.format("%03d", count + 1);
	}

	private String getCurrentTimetamp(Date nowDate) {
		return new SimpleDateFormat("yyyyMMdd").format(nowDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kt.its.service.AccountService#selectAdminUserDetail(java.lang.String)
	 */
	@Override
	public UserInfo getAccountDetail(String adminId) {
		UserInfo result = null;

		try {
			result = accountMapper.selectAccountDetail(adminId);

			log.debug("사용자정보!! " + result);

		} catch (Exception e) {
			log.error(e);
			throw new ServiceException("신규 계정을 저장하는 중에 오류가 발생하였습니다.");
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kt.its.service.AccountService#countAccount(java.util.HashMap)
	 */
	@Override
	public int countAccount(HashMap<String, Object> paramMap) {
		int result = 0;

		try {
			result = accountMapper.countAccount(paramMap);

		} catch (Exception e) {
			log.error(e);
			throw new ServiceException("계정 데이터를 로드하는 중에 오류가 발생하였습니다.");
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kt.its.service.AccountService#selectAccountList(java.util.HashMap)
	 */
	@Override
	public List<UserInfo> selectAccountList(HashMap<String, Object> paramMap) {
		List<UserInfo> resultList = null;

		try {
			resultList = accountMapper.selectAccountList(paramMap);

		} catch (Exception e) {
			log.error(e);
			throw new ServiceException("계정 데이터를 로드하는 중에 오류가 발생하였습니다.");
		}

		return resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kt.its.service.AccountService#updateAccountUseYn(com.kt.its.model.
	 * AdminUser)
	 */
	@Override
	public int updateAccountUseYn(UserInfo record) {
		int result = 0;

		try {
			result = accountMapper.updateAccountUseYn(record);

		} catch (Exception e) {
			log.error(e);
			throw new ServiceException("계정 데이터를 저장하는 중에 오류가 발생하였습니다.");
		}

		return result;
	}
}
