package Dao;

import Model.Admin;
import Model.Portfolio;
import Model.Position;

import java.util.List;

public interface AdminMapper {
    Admin getAdmin(int id);
    int updateAdmin(Admin admin);
    Admin getAdminByName(String name);
    List<Portfolio> getPortfolios();
}