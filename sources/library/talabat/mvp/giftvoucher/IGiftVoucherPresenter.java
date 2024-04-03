package library.talabat.mvp.giftvoucher;

import library.talabat.mvp.IGlobalPresenter;

public interface IGiftVoucherPresenter extends IGlobalPresenter {
    void onPaymentCompleted();

    void setUpViews();

    void validateFields();
}
