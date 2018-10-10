package android.shinetech.com.tradereport.View;

import android.shinetech.com.tradereport.Presenter.ReportPresenter;
import android.shinetech.com.tradereport.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReportActivity  extends BaseView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        String url = this.getIntent().getStringExtra("url");
        ReportPresenter presenter = new ReportPresenter(ReportActivity.this);
        presenter.SetData();
    }
}
