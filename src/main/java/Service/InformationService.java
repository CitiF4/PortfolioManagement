package Service;

import Model.Information;

import java.util.Date;
import java.util.List;

public interface InformationService {
    void createInformation(Information info);
    /*void deleteInformation(int infoId);
    void updateInformation(Information info);*/
//    List<Information> queryForInformation(String type, String date);
    List<Information> queryForInformation(String type);
}
