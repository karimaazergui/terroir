package com.example.cooperatives.repositories;

import com.example.cooperatives.entite.AppRole;
import com.example.cooperatives.entite.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
  public AppRole findByRole(Role r);

}
