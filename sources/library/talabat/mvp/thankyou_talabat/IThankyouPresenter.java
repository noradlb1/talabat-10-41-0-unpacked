package library.talabat.mvp.thankyou_talabat;

import library.talabat.mvp.IGlobalPresenter;

public interface IThankyouPresenter extends IGlobalPresenter {
    void homeButtonPressed();

    void setUpViews(String str, Object obj);
}
