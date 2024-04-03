package library.talabat.mvp.giftvoucher;

import JsonModels.GiftVoucherPurchaseResponse;
import JsonModels.GiftVoucherThankyouResponse;
import JsonModels.Request.GiftVoucherReq;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;

public class GiftVoucherPresenter implements IGiftVoucherPresenter, GiftVoucherListener {
    private GiftVoucherView giftVoucherView;
    private IGiftVoucherInteractor iGiftVoucherInteractor;
    private GiftVoucherPurchaseResponse response;

    public GiftVoucherPresenter(AppVersionProvider appVersionProvider, GiftVoucherView giftVoucherView2) {
        this.giftVoucherView = giftVoucherView2;
        this.iGiftVoucherInteractor = new GiftVoucherInteractor(appVersionProvider, this);
    }

    public void onDataError() {
        this.giftVoucherView.onDataError();
    }

    public void onDestroy() {
        this.giftVoucherView = null;
        IGiftVoucherInteractor iGiftVoucherInteractor2 = this.iGiftVoucherInteractor;
        if (iGiftVoucherInteractor2 != null) {
            iGiftVoucherInteractor2.unregister();
        }
        this.iGiftVoucherInteractor = null;
    }

    public void onNetworkError() {
        this.giftVoucherView.onNetworkError();
    }

    public void onPaymentCompleted() {
        this.iGiftVoucherInteractor.getTransactionDetails(this.response.transId, GlobalDataModel.SelectedCountryId);
    }

    public void onPurchaseCompleted(GiftVoucherPurchaseResponse giftVoucherPurchaseResponse) {
        this.response = giftVoucherPurchaseResponse;
        this.giftVoucherView.onRedirectionToPaymentPage(giftVoucherPurchaseResponse.redirectURL, giftVoucherPurchaseResponse.transId);
    }

    public void onServerError(VolleyError volleyError) {
        this.giftVoucherView.onServerError(volleyError);
    }

    public void onTransactionDetailsRecieved(GiftVoucherThankyouResponse giftVoucherThankyouResponse) {
        this.giftVoucherView.onRedirectionToThanyouPage(giftVoucherThankyouResponse);
    }

    public void setUpViews() {
    }

    public void validateFields() {
        boolean z11;
        String reciepientEmail = this.giftVoucherView.getReciepientEmail();
        String reciepientName = this.giftVoucherView.getReciepientName();
        this.giftVoucherView.getGiftVoucherId();
        boolean z12 = false;
        if (reciepientName.equals("")) {
            this.giftVoucherView.onValidationError(61);
            z11 = false;
        } else {
            z11 = true;
        }
        if (reciepientEmail.equals("")) {
            this.giftVoucherView.onValidationError(60);
        } else {
            z12 = z11;
        }
        if (!z12) {
            return;
        }
        if (!TalabatUtils.isValidEmail(reciepientEmail)) {
            this.giftVoucherView.onValidationError(62);
            return;
        }
        this.giftVoucherView.onValidationSuccess();
        GiftVoucherReq giftVoucherReq = new GiftVoucherReq();
        giftVoucherReq.f473id = this.giftVoucherView.getGiftVoucherId();
        giftVoucherReq.GiftMessage = this.giftVoucherView.getMessage();
        giftVoucherReq.RecipientEmail = this.giftVoucherView.getReciepientEmail();
        giftVoucherReq.RecipientName = this.giftVoucherView.getReciepientName();
        this.iGiftVoucherInteractor.buyGiftVoucher(giftVoucherReq, GlobalDataModel.SelectedCountryId);
    }
}
