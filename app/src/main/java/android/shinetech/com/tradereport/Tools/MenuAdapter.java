package android.shinetech.com.tradereport.Tools;

import android.content.Context;
import android.shinetech.com.tradereport.Bean.ReportMenu;
import android.shinetech.com.tradereport.R;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends ArrayAdapter {

    public final int resourceId;

    public MenuAdapter(Context context, int textViewResourceId, List<ReportMenu> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReportMenu reportMenu = (ReportMenu) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView menuView = (ImageView) view.findViewById(R.id.menu_image);
        TextView menuName = (TextView) view.findViewById(R.id.menu_name);
        TextView menuId = (TextView) view.findViewById(R.id.menu_id);
        menuView.setImageResource(reportMenu.getImage());
        menuName.setText(reportMenu.getName());
        return view;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }
}
