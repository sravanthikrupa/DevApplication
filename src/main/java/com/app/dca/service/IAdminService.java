package com.app.dca.service;

import java.util.List;

import com.app.dca.entity.Admin;
import com.app.dca.exception.AdminNotFoundException;

public interface IAdminService {

	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;

	public Admin viewAdmin(Admin admin) throws AdminNotFoundException;

	public Admin deleteAdmin(int adminId) throws AdminNotFoundException;

	public List<Admin> showAllAdmins();
}

