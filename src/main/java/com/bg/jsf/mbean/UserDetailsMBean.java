package com.bg.jsf.mbean;

import com.bg.hibernate.model.UserDetails;
import com.bg.spring.service.UserDetailsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserDetailsMBean implements Serializable {
    private static final long serialVersionUID = 1L;
    //inject spring bean via DI
    @ManagedProperty("#{userDetailsService}")
    private UserDetailsService userDetailsService;
    private UserDetails userDetails;
    private List<UserDetails> userDetailsList;

    public UserDetails getUserDetails() {
        if (userDetails == null) {
            int id = 7;// should come from UI
            userDetails = userDetailsService.getuserDetails(id);
        }
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<UserDetails> getUserDetailsList() {
        if (userDetailsList == null) {
            userDetailsList = userDetailsService.getAllUserDetails();
        }
        return userDetailsList;
    }

    public void setUserDetailsList(List<UserDetails> userDetailsList) {
        this.userDetailsList = userDetailsList;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
