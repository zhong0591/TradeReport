package android.shinetech.com.tradereport.Presenter;

import android.shinetech.com.tradereport.Bean.FilterTypeHelper;
import android.shinetech.com.tradereport.R;
import android.shinetech.com.tradereport.View.BaseView;
import android.shinetech.com.tradereport.View.FilterActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class SearchPresenter {
    public BaseView view = null;
    FilterActivity filterActivity;

    public SearchPresenter(BaseView view) {
        this.view = view;
        filterActivity = (FilterActivity) view;
    }


    public String getSearchUrl() {

        LinearLayout ll = filterActivity.findViewById(R.id.ll_filter);
        int count = ll.getChildCount();
        String filterCondition = "";
        for (int i = 1; i < count; i++) {
            LinearLayout line = (LinearLayout) ll.getChildAt(i);
            if (line.getTag() != null) {
                String searchType = line.getTag().toString();
                String searchValue =  getSearchValue(searchType, line);

                filterCondition += line.getTag() +"=" + searchValue + "&";
            }
        }
        filterCondition = filterCondition == ""? "" : filterCondition.substring(0, filterCondition.length() - 1);
        return filterCondition;
    }

    private String getSearchValue(String type, LinearLayout line) {
        String searchValue = "";
        View searchController = line.getChildAt(1);
        switch (type) {
            case FilterTypeHelper.Filter_Type_Canlendar:
                DatePicker datePicker = (DatePicker) searchController;
                int month = datePicker.getMonth() + 1;
                searchValue  =   datePicker.getYear() + "-" +  month + "-" +datePicker.getDayOfMonth();
                break;
            case FilterTypeHelper.Filter_Type_Radio:
                RadioGroup radioGroup = (RadioGroup) searchController;
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) filterActivity.findViewById(radioGroup.getCheckedRadioButtonId());
                searchValue = radioButton.getText().toString();
                break;
            case FilterTypeHelper.Filter_Type_Spin:
                Spinner spinner = (Spinner) searchController;
                searchValue = spinner.getSelectedItem().toString();
                break;
            case FilterTypeHelper.Filter_Type_Checkbox:

                //searchValue = checkBox.ge().toString();
                String checkedValues = "";
                int allViews =   line.getChildCount();
                for(int index = 1;index < allViews; index ++){
                    CheckBox checkBox = (CheckBox) line.getChildAt(index);
                    if(checkBox.isChecked()){
                        checkedValues += checkBox.getText() + "|";
                    }
                }
                if(checkedValues != ""){
                    searchValue = checkedValues.substring(0, checkedValues.length() -1);
                }
                break;
            case FilterTypeHelper.Filter_Type_Text:
                EditText text = (EditText) searchController;
                searchValue = text.getText().toString();
                break;
            default:
                break;

        }
        System.out.println("===============" + searchValue + "++++++++++++++++++++");
        return searchValue;
    }


}
