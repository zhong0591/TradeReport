package android.shinetech.com.tradereport.Presenter.FilterController;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CustomerRadioFilter implements ICustomerFilter {
    @Override
    public void setFilter(Context context, LinearLayout layout, String filterName, List<String> items, String defaultValue) {
        LinearLayout filter_item = new LinearLayout(context);
        filter_item.setOrientation(LinearLayout.HORIZONTAL);
        filter_item.setTag(FilterTypeHelper.Filter_Type_Radio);
        filter_item.setPadding(20,0,20,0);
        LinearLayout.LayoutParams pt = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT);
        pt.weight = 1.0f;
        TextView filterText = new TextView(context);
        filterText.setText(filterName + ":");
        filterText.setLayoutParams(pt);

        LinearLayout.LayoutParams pc = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.LEFT);
        pc.weight = 3.0f;
        RadioGroup group = new RadioGroup(context);
        group.setLayoutParams(pc);

        for(int i = 0;i< items.size();i++){
            RadioButton rad = new RadioButton(context);
            rad.setId(i);
            rad.setText(items.get(i));
            if(items.get(i).equals(defaultValue) ){
                rad.setChecked(true);
                group.check(rad.getId());
            }
            group.addView(rad);
        }


        filter_item.addView(filterText);
        filter_item.addView(group);
        layout.addView(filter_item);
    }
}
