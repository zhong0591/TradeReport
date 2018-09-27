package android.shinetech.com.tradereport.Model;

import android.shinetech.com.tradereport.Bean.Report;

import java.util.ArrayList;
import java.util.List;

public class ReportModel {

    List<Report> reports = null;
    public  List<Report> getData(){
        reports = new ArrayList<Report>() ;
        for(int i = 0;i<10;i++){
            reports.add(new Report(i+1,i+1, "Class" + i,  "Report Name" + i ,"Report Descripation" + i ));
        }
        return  reports;
    }


}
