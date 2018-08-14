package Service;
import java.util.Date;
import Dao.*;
import Model.*;
import Model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    public void createInformation(Information info){
        informationMapper.createInfomation(info);
    }

   /* public List<Information> queryForInformation(String type, String date){
        return informationMapper.queryForInformation(type,date);
    };*/

   public void updateInformation(Information info){
       informationMapper.updateInformation(info);
   }
    public List<Information> queryForInformation(String type){
        return informationMapper.queryForInformation(type);
    };

    public void deleteInformation(int infoId){
        informationMapper.deleteInformation(infoId);
    };
}
