package android.shinetech.com.tradereport.View;

import android.content.Intent;
import android.os.Bundle;
import android.shinetech.com.tradereport.Presenter.FilterPresenter;
import android.shinetech.com.tradereport.Presenter.SearchPresenter;
import android.shinetech.com.tradereport.R;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FilterActivity  extends BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
//        String report_id = getIntent().getStringExtra("report_id");
//        System.out.println("=========" + report_id + "==========");
        Init();
    }

    private void Init() {
        FilterPresenter presenter = new FilterPresenter(FilterActivity.this);
        presenter.initFilterContent();

        Button btn_search = FilterActivity.this.findViewById(R.id.btn_Search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchPresenter searchPresenter = new SearchPresenter(FilterActivity.this);
                String filterCondition =  searchPresenter.getSearchUrl();

                Intent i = new Intent(FilterActivity.this, ReportActivity.class);
                i.putExtra("url",filterCondition);
                startActivity(i);

            }
        });
    }

}
