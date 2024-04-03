package library.talabat.mvp.settings;

import datamodels.CustomerInfo;
import library.talabat.mvp.IGlobalListener;

public interface SettingsListener extends IGlobalListener {
    void onCustomerDetailsLoaded(CustomerInfo customerInfo);

    void onDataLoadingCompleted();

    void onLogout(boolean z11);
}
