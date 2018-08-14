package Dao;

import Model.Portfolio;
import Model.PortfolioExample;

import java.util.Date;
import java.util.List;

import Model.Position;
import org.apache.ibatis.annotations.Param;

public interface PortfolioMapper {
    int createPortfolio(Portfolio p); //insert
    int createPortfolioByName(@Param("name") String name, @Param("cash") double cash, @Param("fmId") int fmId, @Param("date")Date date);

    int updatePortfolioById(@Param("id")int id,@Param("name")String name);
    //List<Position> queryForPositions(int pId);

    int deletePortfolio(int portfolioId);
    int updatePortfolio(Portfolio p);
    List<Portfolio>  getPortfolios();
    Portfolio getPorfolio(int portfolioId);
}