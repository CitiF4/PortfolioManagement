package Dao;

import Model.Fundmanager;
import Model.FundmanagerExample;
import java.util.List;

import Model.Portfolio;
import org.apache.ibatis.annotations.Param;

public interface FundmanagerMapper {
    int createFundmanager(Fundmanager f);
    int deleteFundmanager(int FmId);
    List<Fundmanager> getFundManagers();
    Fundmanager getFundManager(int FmId);
    Fundmanager getFundManagerByName(String name);
    int updateFundmanager(Fundmanager f);
    Fundmanager addPorfolioByfmId(int fmid);//set fundmanager.setPorfolioList()
    List<Portfolio> getPortfolio(int fmid);
    int getFundmanagerIdByName(String name);
}