package com.bg.spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bg.hibernate.model.UserDetails;
import com.bg.spring.dao.UserDetailsDao;
import com.bg.spring.service.UserDetailsService;
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsDao userDetailsDao;
    @Override
    public UserDetails getuserDetails(int id) {
        return userDetailsDao.getuserDetails(id);
    }
    @Override
    public List<UserDetails> getAllUserDetails() {
        return userDetailsDao.getAllUserDetails();
    }
    public UserDetailsDao getUserDetailsDao() {
        return userDetailsDao;
    }
}
