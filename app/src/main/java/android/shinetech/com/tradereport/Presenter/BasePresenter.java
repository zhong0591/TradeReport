package android.shinetech.com.tradereport.Presenter;

import android.shinetech.com.tradereport.View.BaseView;

public abstract class BasePresenter {
    public BaseView view;
    public BasePresenter(BaseView view ){
        this.view = view;
    }

}
