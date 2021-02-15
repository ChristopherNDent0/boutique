package com.bg.spring.service;

import java.util.List;
import com.bg.hibernate.model.UserDetails;
public interface UserDetailsService {
	public UserDetails getuserDetails(int id);
	public List<UserDetails> getAllUserDetails();
}
