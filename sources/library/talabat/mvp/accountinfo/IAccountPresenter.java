package library.talabat.mvp.accountinfo;

import datamodels.CustomerInfo;
import library.talabat.mvp.IGlobalPresenter;

public interface IAccountPresenter extends IGlobalPresenter {
    void setUpViews(CustomerInfo customerInfo);

    void setUpViewsForEditing();

    void updateCustomerInfo();
}
