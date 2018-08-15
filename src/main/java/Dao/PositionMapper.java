package Dao;

import Model.Information;
import Model.Portfolio;
import Model.Position;
import Model.PositionExample;
import java.util.List;

import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;

public interface PositionMapper {

    List<Information> queryForDistinctPositions();

    int createPosition(Position p);
    int createPositionWithoutID(Position p);
    int deletePosition(int positionId);
    int updatePosition(Position p);
    List<Portfolio>  getPortfolios();
    Portfolio getPortfolio(int portfolioId);

    List<Position> getSamePositionsFromPortfolio(@Param("symbol") String symbol,@Param("type")String type,@Param("portfolioID")int portfolioID);

    List<Position> queryForPositions(int pId);
}