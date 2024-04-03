package library.talabat.mvp.paymentwebview;

import library.talabat.mvp.IGlobalPresenter;

public interface IPaymentWebViewPresenter extends IGlobalPresenter {
    void onUrlChanged(String str);

    void setTransatcionId(String str);

    void setUpViews(String str);
}
