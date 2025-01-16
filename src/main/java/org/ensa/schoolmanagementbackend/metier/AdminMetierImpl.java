package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.ensa.schoolmanagementbackend.dao.impl.AdminDaoImpl;
import org.ensa.schoolmanagementbackend.dao.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMetierImpl implements  AdminMetier {

    @Autowired
    private AdminDaoImpl adminDao;
    @Autowired
    private AdminRepository adminRepository;


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
    @Override
    public boolean verifyAdmin(Admin admin) {
        Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin != null && existingAdmin.getPassword().equals(admin.getPassword())) {
            return true;
        }
        return false;
}

}
