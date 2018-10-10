package android.shinetech.com.tradereport.Presenter;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.FilterType;
import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.shinetech.com.tradereport.Bean.JsonReport;
import android.shinetech.com.tradereport.Bean.Report;
import android.shinetech.com.tradereport.Model.ReportModel;
import android.shinetech.com.tradereport.Presenter.FilterController.CustomerCalendarFilter;
import android.shinetech.com.tradereport.Presenter.FilterController.CustomerCheckBoxFilter;
import android.shinetech.com.tradereport.Presenter.FilterController.CustomerRadioFilter;
import android.shinetech.com.tradereport.Presenter.FilterController.CustomerSpinnerFilter;
import android.shinetech.com.tradereport.Presenter.FilterController.CustomerTextFilter;
import android.shinetech.com.tradereport.Presenter.FilterController.ICustomerFilter;
import android.shinetech.com.tradereport.R;
import android.shinetech.com.tradereport.View.BaseView;
import android.shinetech.com.tradereport.View.FilterActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FilterPresenter {
    public BaseView view = null;
    FilterActivity filterActivity;

    public FilterPresenter(BaseView view) {
        this.view = view;
        filterActivity = (FilterActivity) view;
    }

    public void initFilterContent() {
        getRemoteData();
    }


    private void BindFilter(List<FilterType> filterTypes) {

        LinearLayout layout = (LinearLayout) filterActivity.findViewById(R.id.ll_filter);
        Context context = filterActivity.getBaseContext();
        //mock data
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item" + i);
        }
        //mock radio data
       List<String> radioOptions = new ArrayList<String>();
        radioOptions.add("Male");
        radioOptions.add("FeMale");

        //mock checkbox data
        List<String> checkboxes = new ArrayList<String>();
        checkboxes.add("Trade");
        checkboxes.add("Monthly");
        checkboxes.add("Yearly");

        for (FilterType type : filterTypes) {
            ICustomerFilter filter ;
            switch (type.filterType) {

                case FilterTypeHelper.Filter_Type_Text:
                    filter = new CustomerTextFilter();
                    filter.setFilter(context, layout, type.filterName, null, "");
                    break;
                case FilterTypeHelper.Filter_Type_Spin:
                    filter = new CustomerSpinnerFilter();
                    filter.setFilter(context, layout, type.filterName, list, "");
                    break;
                case FilterTypeHelper.Filter_Type_Radio:
                    filter = new CustomerRadioFilter();
                    filter.setFilter(context, layout, type.filterName, radioOptions, radioOptions.get(1));
                    break;
                case FilterTypeHelper.Filter_Type_Checkbox:
                    filter = new CustomerCheckBoxFilter();
                    filter.setFilter(context, layout, type.filterName,  checkboxes, checkboxes.get(1));
                    break;
                case FilterTypeHelper.Filter_Type_Canlendar:
                    filter = new CustomerCalendarFilter();
                    filter.setFilter(context, layout, type.filterName, null, null);
                    break;
                default:
                    break;
            }
        }

        ProgressBar pb = (ProgressBar) filterActivity.findViewById(R.id.pb_filter);
        pb.setVisibility(View.INVISIBLE);
        Button btnSearch = (Button) filterActivity.findViewById(R.id.btn_Search);
        btnSearch.setEnabled(true);
    }


    public void getRemoteData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build();

        String URL = "https://raw.github.com/square/okhttp/master/README.md";
        //RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8") );
        Request request = new Request.Builder().url(URL)
                // .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("connected failed.");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                filterActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String json = response.body().toString();  //异步返回值
                        System.out.println("=========Response Body:========" + json + "=======================");
                        json = "{filterTypes:[{'filterName':'name','filterType':'text','defaultValue':'eee' },{'filterName':'report type','filterType':'checkbox','defaultValue':'trade' },{'filterName':'category','filterType':'spinner','defaultValue':'1' },{'filterName':'report date','filterType':'calendar','defaultValue':'1' },{'filterName':'sex','filterType':'radio','defaultValue':'1' }] ,reports:[{'id':1,'categoryId':'1','categoryName':'aaa','reportName':'bbb','description':'ccc'},{'id':1,'categoryId':'1','categoryName':'aaa','reportName':'bbb','description':'ccc'},{'id':1,'sexId':'1','sex':'aaa','reportName':'bbb','description':'ccc'}]}";

                        if (!json.isEmpty()) {
                            Gson gson = new Gson();
                            JsonReport r = gson.fromJson(json, JsonReport.class);
                            BindFilter(r.filterTypes);
                        }
                    }
                });
            }
        });
    }

}
