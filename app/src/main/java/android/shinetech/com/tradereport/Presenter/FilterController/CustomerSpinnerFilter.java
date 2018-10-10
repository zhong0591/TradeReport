package android.shinetech.com.tradereport.Presenter.FilterController;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.shinetech.com.tradereport.R;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CustomerSpinnerFilter implements ICustomerFilter {
    @Override
    public void setFilter(Context context, LinearLayout layout, String filterName, List<String> source, String defaultValue) {
        LinearLayout filter_item = new LinearLayout(context);
        filter_item.setOrientation(LinearLayout.HORIZONTAL);
        filter_item.setPadding(20,10,20,30);
        filter_item.setTag(FilterTypeHelper.Filter_Type_Spin);

        LinearLayout.LayoutParams pt = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT);
        pt.weight = 1.0f;
        TextView filterText = new TextView(context);
        filterText.setText(filterName + ":");
        filterText.setLayoutParams(pt);

        LinearLayout.LayoutParams pc = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.LEFT);
        pc.weight = 3.0f;
        Spinner spinner = new Spinner(context);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, source);
        spinner.setAdapter(adapter);
        spinner.setLayoutParams(pc);

        filter_item.addView(filterText);
        filter_item.addView(spinner);
        layout.addView(filter_item);
    }
}
