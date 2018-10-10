package android.shinetech.com.tradereport.Presenter.FilterController;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.view.Gravity;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

public class CustomerCalendarFilter implements ICustomerFilter {
    @Override
    public void setFilter(Context context, LinearLayout layout, String filterName, List<String> items, String defaultValue) {

        LinearLayout filter_item = new LinearLayout(context);
        filter_item.setOrientation(LinearLayout.HORIZONTAL);
        filter_item.setPadding(20,30,20,0);
        filter_item.setTag(FilterTypeHelper.Filter_Type_Canlendar);

        LinearLayout.LayoutParams pt = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT);
        pt.weight = 1.0f;
        TextView filterText = new TextView(context);
        filterText.setText(filterName + ":");
        filterText.setLayoutParams(pt);

        LinearLayout.LayoutParams pc = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.LEFT);
        pc.weight = 3.0f;
        DatePicker dp = new DatePicker(context);
        dp.setLayoutParams(pc);
        filter_item.addView(filterText);
        filter_item.addView(dp);
        layout.addView(filter_item);
    }
}
