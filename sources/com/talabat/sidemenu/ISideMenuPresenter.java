package com.talabat.sidemenu;

public interface ISideMenuPresenter {
    void checkUserBNPLEligible();

    void loadBnplOverdues();

    void onLoadRafSenderVoucherLabel();

    void onLoadTalabatCreditBalance();

    void onLoadUserActiveVouchersCount();

    void onSidemenuItemClicked(String str);

    void onSidemenuLinkClicked(String str, String str2);

    void reloadBnplOverdue();

    void setSideMenu();
}
