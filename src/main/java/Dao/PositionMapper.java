package Dao;

import Model.Portfolio;
import Model.Position;
import Model.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMapper {
    int createPosition(Position p);
    int deletePosition(int positionId);
    int updatePosition(Position p);
    List<Portfolio>  getPortfolios();
    Portfolio getPortfolio(int portfolioId);
}