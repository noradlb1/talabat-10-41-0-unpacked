package library.talabat.mvp.purchasetalabatcredit;

import JsonModels.GiftVoucherThankyouResponse;
import com.talabat.helpers.Talabat;

public interface PurchaseTalabatCreditView extends Talabat {
    void dismisLoading();

    void displayAmount(String str, int i11, float f11);

    void onRedirectToPaymentPage(String str, String str2);

    void onRedirectToThankyouPage(GiftVoucherThankyouResponse giftVoucherThankyouResponse);

    void setDescription(String str);

    void showLoading();

    void showLoadingPopup();
}
