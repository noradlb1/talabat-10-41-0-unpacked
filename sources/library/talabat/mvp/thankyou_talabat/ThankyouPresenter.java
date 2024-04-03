package library.talabat.mvp.thankyou_talabat;

import JsonModels.GiftVoucherThankyouResponse;
import buisnessmodels.TalabatFormatter;
import tracking.ScreenNames;

public class ThankyouPresenter implements IThankyouPresenter {

    /* renamed from: a  reason: collision with root package name */
    public final TalabatFormatter f26874a = TalabatFormatter.getInstance();
    private ThankyouView thankyouView;

    public ThankyouPresenter(ThankyouView thankyouView2) {
        this.thankyouView = thankyouView2;
    }

    public void homeButtonPressed() {
        this.thankyouView.goToHome();
    }

    public void onDestroy() {
        this.thankyouView = null;
    }

    public void setUpViews(String str, Object obj) {
        if (str.equals(ScreenNames.GIFT_VOUCHER_DETAILS)) {
            if (obj instanceof GiftVoucherThankyouResponse) {
                GiftVoucherThankyouResponse giftVoucherThankyouResponse = (GiftVoucherThankyouResponse) obj;
                this.thankyouView.setGiftVoucherThankyou(this.f26874a.getFormattedCurrency(giftVoucherThankyouResponse.amount));
                this.thankyouView.setVoucherTransactionDetails(giftVoucherThankyouResponse.result, giftVoucherThankyouResponse.ref, giftVoucherThankyouResponse.paymentId);
            }
        } else if (str.equals(ScreenNames.PURCHASE_TALABAT_CREDIT) && (obj instanceof GiftVoucherThankyouResponse)) {
            GiftVoucherThankyouResponse giftVoucherThankyouResponse2 = (GiftVoucherThankyouResponse) obj;
            this.thankyouView.setTalabatCreditThankyou(this.f26874a.getFormattedCurrency(giftVoucherThankyouResponse2.amount));
            this.thankyouView.setCreditTransactionDetails(giftVoucherThankyouResponse2.result, giftVoucherThankyouResponse2.ref, giftVoucherThankyouResponse2.paymentId);
        }
    }
}
