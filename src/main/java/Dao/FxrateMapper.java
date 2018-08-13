package Dao;

import Model.Fxrate;
import Model.FxrateExample;
import java.util.List;

import Model.Portfolio;
import org.apache.ibatis.annotations.Param;

public interface FxrateMapper {
    void updateFxRate(Fxrate fxrate);
    List<Fxrate> getFxRate();
}