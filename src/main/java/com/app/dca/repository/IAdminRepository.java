package com.app.dca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dca.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}