package org.ensa.schoolmanagementbackend.metier;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;

import java.util.List;

public interface AdminMetier {

    public List<Admin> getAdmins();
    public void addAdmin(Admin admin);
    public void updateAdmin(Admin admin);
    public void deleteAdmin(Admin admin);
}
