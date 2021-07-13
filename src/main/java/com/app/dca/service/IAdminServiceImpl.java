package com.app.dca.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Admin;
import com.app.dca.exception.AdminNotFoundException;
import com.app.dca.repository.IAdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {

	Logger logger = Logger.getLogger(IAdminServiceImpl.class.getName());
	
	@Autowired
	IAdminRepository repository;

	public IAdminServiceImpl(IAdminRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Admin addAdmin(Admin admin) {

		Admin savedAdmin = null;
		try {
			savedAdmin = repository.save(admin);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return savedAdmin;

	}

	@Override
	@Transactional
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {

		Optional<Admin> optional = repository.findById(admin.getUserId());
		if (optional.isPresent()) {
			repository.save(admin);
			return optional.get();
		} else {
			throw new AdminNotFoundException("Admin not found for updation!");
		}

	}

	@Override
	public Admin viewAdmin(Admin admin) throws AdminNotFoundException {

		Optional<Admin> optional = repository.findById(admin.getUserId());
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new AdminNotFoundException("Admin not found!");
		}

	}

	@Override
	@Transactional
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException {

		Optional<Admin> optional = repository.findById(adminId);
		if (optional.isPresent()) {
			repository.deleteById(adminId);
			return optional.get();
		} else {
			throw new AdminNotFoundException("Admin not found for deletion!");
		}

	}

	@Override
	public List<Admin> showAllAdmins() {

		List<Admin> adminList = null;
		try {
			adminList = repository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return adminList;
	}
}
