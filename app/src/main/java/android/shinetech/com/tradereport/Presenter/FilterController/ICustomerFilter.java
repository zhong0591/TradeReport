package android.shinetech.com.tradereport.Presenter.FilterController;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.List;

public interface ICustomerFilter {
      void setFilter(Context context, LinearLayout layout, String name, List<String> items,String defaultValue);
}
