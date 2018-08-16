package Controller;

import Model.Information;
import Model.Portfolio;
import Service.AdminService;
import Service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by mandy on 2018/8/15.
 */
@Controller
@SessionAttributes("name")
public class FundmanagerController {

    @Autowired
    private FundManagerService fundManagerServiceImpl;

    @Autowired
    private AdminService adminServiceImpl;

    @RequestMapping("/getTypeInformation")
    @ResponseBody
    public List<Information> getProduct (@RequestParam (value = "type") String type) {
        System.out.println("the type is " + type);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowdayTime = dateFormat.format(new Date());
        List<Information> information = new ArrayList<Information>();
        try {
            Date nowDate = dateFormat.parse(nowdayTime);
            information = fundManagerServiceImpl.getInformation(type, nowDate);
            System.out.println(information.size());
        } catch (ParseException e) {

        }
        return information;


    }

    @RequestMapping(value = "/getTopTenAndWorst",method = RequestMethod.GET)
    @ResponseBody
    public List<Map> getTopAndWorst (HttpSession httpSession){
        String name = httpSession.getAttribute("name").toString();
        List<Map> list = new ArrayList<Map>();
        List<Portfolio> portfolios = fundManagerServiceImpl.getPortfoliosByName(name);
        fundManagerServiceImpl.getPortShowInfo(portfolios);
        adminServiceImpl.sortPortfolio(portfolios);

        for(int i = 0; i < portfolios.size(); i++){
            if(i<10 || i == portfolios.size() - 1){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("name",portfolios.get(i).getName());
                map.put("curCash", portfolios.get(i).getCurCash());
                map.put("initCash",portfolios.get(i).getInitCash());
                map.put("value",portfolios.get(i).getValue());
                map.put("rate",portfolios.get(i).getRate());
                list.add(map);

            }
        }
        return list;

    }
    @RequestMapping(value = "/toDisplayInformation",method = RequestMethod.GET)
    public String toDisplayInformation(){
        return "DisplayInformation";
    }

    @RequestMapping(value = "/toFundmanagerReport",method = RequestMethod.GET)
    public String toFundmanagerReport(){
        return "fundManageReport";
    }

}
