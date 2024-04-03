package library.talabat.mvp.purchasetalabatcredit;

import library.talabat.mvp.IGlobalPresenter;

public interface IPurchaseTalabatCreditPresenter extends IGlobalPresenter {
    void buyTalabatCredit();

    void completedPayment();

    void decreaseAmount(int i11);

    void increaseAmount(int i11);

    void setUpViews();
}
