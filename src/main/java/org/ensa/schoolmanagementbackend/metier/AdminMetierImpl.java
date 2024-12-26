package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.ensa.schoolmanagementbackend.dao.impl.AdminDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMetierImpl implements  AdminMetier {

    @Autowired
    private AdminDaoImpl adminDao;

    @Override
    public List<Admin> getAdmins() {
        return adminDao.getAdmins();
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDao.addAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDao.deleteAdmin(admin);
    }
}
