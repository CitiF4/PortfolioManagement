package Dao;

import Model.Portfolio;
import Model.PortfolioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PortfolioMapper {
    int createPortfolio(Portfolio p); //insert
    int deletePortfolio(int portfolioId);
    int updatePortfolio(Portfolio p);
    List<Portfolio>  getPortfolios();
    Portfolio getPorfolio(int portfolioId);
}