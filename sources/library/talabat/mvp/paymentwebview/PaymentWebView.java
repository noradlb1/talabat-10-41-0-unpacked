package library.talabat.mvp.paymentwebview;

import com.talabat.helpers.Talabat;

public interface PaymentWebView extends Talabat {
    void dismissLoadingPopup();

    void dismissProgressBarOnView();

    void onNavigationToGiftVoucherThankyouPage();

    void onNavigationToOrderThankyouPage();

    void onNavigationToPaymentError(String str, int i11, boolean z11, String str2);

    void onNavigationToTalabatCreditThankyouPage();

    void setPaymentUrl(String str);
}
