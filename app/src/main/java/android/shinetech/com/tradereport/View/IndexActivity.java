package android.shinetech.com.tradereport.View;

import android.content.Intent;
import android.os.Bundle;
import android.shinetech.com.tradereport.Bean.ReportMenu;
import android.shinetech.com.tradereport.R;
import android.shinetech.com.tradereport.Tools.MenuAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    private List<ReportMenu> menu = new ArrayList<ReportMenu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        InitMenu();
    }

    private void InitMenu() {
        menu.add(new ReportMenu("1", "Trade Report", R.drawable.report));
        menu.add(new ReportMenu("2", "Sales Report", R.drawable.report));
        menu.add(new ReportMenu("3", "Monthly Sales Report", R.drawable.report));
        menu.add(new ReportMenu("4", "Yearly Report", R.drawable.report));
        menu.add(new ReportMenu("5", "Company Report", R.drawable.report));

        MenuAdapter adapter = new MenuAdapter(IndexActivity.this, R.layout.menu_item, menu);
        final ListView listView = (ListView) findViewById(R.id.menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ReportMenu menu = (ReportMenu) parent.getItemAtPosition(position);
                switch (menu.id) {
                    case "1":
                        Intent intent = new Intent(IndexActivity.this, FilterActivity.class);
                        intent.putExtra("report_id", menu.id);
                        startActivity(intent);
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
