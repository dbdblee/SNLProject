package com.snl.ashop.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.snl.ashop.account.Role;

public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	private UserInfo userInfo;
	
	//추가적인 회원정보 항목 추가
	private List<Role> authorities;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
		
	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
//	private String firstname;
//	private String lastname;
//	private String address;
//	private String email;
//	
//	public String getFirstname() {
//		return firstname;
//	}
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	public String getLastname() {
//		return lastname;
//	}
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
	
	
}
