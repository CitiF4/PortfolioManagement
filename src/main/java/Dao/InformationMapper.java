package Dao;

import Model.Information;
import Model.InformationExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationMapper {

   // List<Information> queryForInformation(String type, String date);

    List<Information> queryForInformation(String type);

    int createInfomation(Information info);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    int countByExample(InformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    int deleteByExample(InformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    int insert(Information record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    int insertSelective(Information record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    List<Information> selectByExample(InformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table information
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);
}