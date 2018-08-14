package Service;

import Model.Information;

import java.util.Date;
import java.util.List;

public interface InformationService {
    void createInformation(Information info);
    /*
    */
//    List<Information> queryForInformation(String type, String date);
    List<Information> queryForInformation(String type);
    void updateInformation(Information info);
    void deleteInformation(int infoId);
}
