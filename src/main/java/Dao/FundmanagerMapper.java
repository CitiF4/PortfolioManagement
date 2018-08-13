package Dao;

import Model.Fundmanager;
import Model.FundmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundmanagerMapper {
    int createFundmanager(Fundmanager f);
    int deleteFundmanager(int FmId);
    List<Fundmanager> getFundManagers();
    Fundmanager getFundManager(int FmId);
    int updateFundmanager(Fundmanager f);
}