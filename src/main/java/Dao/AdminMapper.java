package Dao;

import Model.Admin;

public interface AdminMapper {
    Admin getAdmin(int id);
    int updateAdmin(Admin admin);
}