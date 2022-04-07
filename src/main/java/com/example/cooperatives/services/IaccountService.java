package com.example.cooperatives.services;

import com.example.cooperatives.entite.AppRole;
import com.example.cooperatives.entite.AppUser;
import com.example.cooperatives.entite.Role;


public interface IaccountService {
    public AppUser findUserByUsername(String username);
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole r);
    public void addRoleToUser(String username, Role r);



}
