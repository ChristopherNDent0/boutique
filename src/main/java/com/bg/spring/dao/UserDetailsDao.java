package com.bg.spring.dao;

import com.bg.hibernate.model.UserDetails;

import java.util.List;

public interface UserDetailsDao {
    UserDetails getuserDetails(int id);

    List<UserDetails> getAllUserDetails();
}

