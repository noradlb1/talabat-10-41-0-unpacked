package library.talabat.mvp.paymentwebview;

import com.talabat.helpers.AppUrls;

public class PaymentWebViewPresenter implements IPaymentWebViewPresenter {
    private String intitialUrl;
    private PaymentWebView paymentWebView;
    private String transactionId;

    public PaymentWebViewPresenter(PaymentWebView paymentWebView2) {
        this.paymentWebView = paymentWebView2;
    }

    public void onDestroy() {
        this.paymentWebView = null;
    }

    public void onUrlChanged(String str) {
        String str2;
        boolean z11;
        if (str.toLowerCase().contains("thankyou-talabat-credit") || str.toLowerCase().contains("thankyou6alabatcredit")) {
            this.paymentWebView.onNavigationToTalabatCreditThankyouPage();
            this.paymentWebView.dismissLoadingPopup();
        } else if (str.toLowerCase().contains("thankyou-gift-voucher") || str.toLowerCase().contains("thankyougiftvoucher") || str.toLowerCase().contains("thankyou-gift")) {
            this.paymentWebView.onNavigationToGiftVoucherThankyouPage();
            this.paymentWebView.dismissLoadingPopup();
        } else if (str.toLowerCase().contains(AppUrls.TRANSACTION_THANK_YOU_SEGMENT)) {
            this.paymentWebView.onNavigationToOrderThankyouPage();
            this.paymentWebView.dismissLoadingPopup();
        } else if (str.toLowerCase().contains("default")) {
            this.paymentWebView.onNavigationToPaymentError(this.intitialUrl, 1, false, (String) null);
            this.paymentWebView.dismissLoadingPopup();
        } else if (str.toLowerCase().contains("paymenterror")) {
            try {
                z11 = str.substring(str.indexOf("pgd=")).startsWith("1");
                str2 = "";
            } catch (Exception unused) {
                str2 = this.transactionId + "/0";
                z11 = false;
            }
            if (!z11) {
                try {
                    String[] split = str.substring(str.indexOf("paymenterror") + 12 + 1).split("/");
                    str2 = split[1] + "/" + split[0];
                } catch (Exception unused2) {
                    if (!z11) {
                        str2 = this.transactionId + "/0";
                    }
                }
            }
            this.paymentWebView.onNavigationToPaymentError(this.intitialUrl, 1, z11, str2);
        }
    }

    public void setTransatcionId(String str) {
        this.transactionId = str;
    }

    public void setUpViews(String str) {
        this.intitialUrl = str;
        this.paymentWebView.setPaymentUrl(str);
    }
}
