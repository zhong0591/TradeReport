package android.shinetech.com.tradereport.Presenter.FilterController;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.shinetech.com.tradereport.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CustomerTextFilter implements ICustomerFilter {
    @Override
    public void setFilter(Context context, LinearLayout layout , String filterName ,  List<String> Source ,String defaultValue) {
        LinearLayout filter_item = new LinearLayout(context);
        filter_item.setOrientation(LinearLayout.HORIZONTAL);
        filter_item.setTag(FilterTypeHelper.Filter_Type_Text);
        filter_item.setPadding(20,0,20,0);

        LinearLayout.LayoutParams pt = new LinearLayout.LayoutParams( 0,LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT);
        pt.weight = 1.0f;
        TextView filterText = new TextView(context);
        filterText.setText(filterName + ":");
        filterText.setLayoutParams(pt);

        LinearLayout.LayoutParams pc = new LinearLayout.LayoutParams( 0,LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.LEFT);
        pc.weight = 3.0f;
        EditText filterContent = new EditText(context);
        filterContent.setText(defaultValue);
        filterContent.setLayoutParams(pc);

        filter_item.addView(filterText);
        filter_item.addView(filterContent);

        layout.addView(filter_item);
    }
}
