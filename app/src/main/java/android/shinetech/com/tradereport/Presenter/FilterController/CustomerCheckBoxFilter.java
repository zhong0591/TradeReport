package android.shinetech.com.tradereport.Presenter.FilterController;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CustomerCheckBoxFilter implements ICustomerFilter {
    @Override
    public void setFilter(Context context, LinearLayout layout, String filterName, List<String> items, String defaultValue) {

        LinearLayout filter_item = new LinearLayout(context);
        filter_item.setOrientation(LinearLayout.HORIZONTAL);
        filter_item.setPadding(20,0,20,0);
        filter_item.setTag(FilterTypeHelper.Filter_Type_Checkbox);

        LinearLayout.LayoutParams pt = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT);
        pt.weight = 1.0f;
        TextView filterText = new TextView(context);
        filterText.setText(filterName + ":");
        filterText.setLayoutParams(pt);
        filter_item.addView(filterText);

        LinearLayout.LayoutParams pc = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.LEFT);
        for(int i = 0;i<items.size();i++){
            CheckBox checkBox = new CheckBox(context);
            checkBox.setText(items.get(i));
            filter_item.addView(checkBox);
        }

        layout.addView(filter_item);
    }
}
