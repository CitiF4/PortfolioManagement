package Dao;

import Model.Fxrate;
import Model.FxrateExample;

import java.util.Date;
import java.util.List;

import Model.Portfolio;
import org.apache.ibatis.annotations.Param;

public interface FxrateMapper {
    void updateFxRate(Fxrate fxrate);
    List<Fxrate> getFxRates();


    void uploadFXrate(@Param("base")String base,@Param("term")String term,@Param("rate")double rate,@Param("date")Date date);
    List<Fxrate> queryForDistinctFXrate();
//    Fxrate getFxRate(String d);
}