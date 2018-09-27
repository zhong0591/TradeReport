package android.shinetech.com.tradereport.Presenter;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.Report;
import android.shinetech.com.tradereport.MainActivity;
import android.shinetech.com.tradereport.Model.ReportModel;
import android.shinetech.com.tradereport.R;
import android.shinetech.com.tradereport.View.BaseView;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportPresenter {

    public BaseView view = null;
    public ReportModel reportModel = null;

    public ReportPresenter(BaseView view) {
        this.view = view;
    }

    public void SetData() {
        reportModel = new ReportModel();
        List<Report> reports = reportModel.getData();
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (Report report : reports) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            //  item.put("id", report.getCategoryId());
            item.put("name", report.getReportName());
            item.put("category", report.getCategoryName());
            item.put("description", report.getDescripation());
            data.add(item);
        }

        MainActivity mv = ((MainActivity) view);
        ListView listView = (ListView) mv.findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(mv.getBaseContext(), data, R.layout.item, new String[]{"category", "name", "description"}, new int[]{R.id.category, R.id.name, R.id.description});
        listView.setAdapter(adapter);

    }


}
