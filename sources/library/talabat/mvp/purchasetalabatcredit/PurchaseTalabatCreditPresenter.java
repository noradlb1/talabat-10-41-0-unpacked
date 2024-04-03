package library.talabat.mvp.purchasetalabatcredit;

import JsonModels.GiftVoucherThankyouResponse;
import JsonModels.PurchaseCreditResponse;
import JsonModels.Request.PurchaseCreditReq;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.PurchaseCredit;
import datamodels.PurchaseCreditItem;

public class PurchaseTalabatCreditPresenter implements IPurchaseTalabatCreditPresenter, PurchaseTalabatCreditListener {

    /* renamed from: a  reason: collision with root package name */
    public final TalabatFormatter f26807a = TalabatFormatter.getInstance();
    private int currentId;
    private IPurchaseTalabatCreditInterator iPurchaseTalabatCreditInterator;
    private PurchaseCredit purchaseCredit;
    private PurchaseCreditItem[] purchaseCreditItems;
    private PurchaseCreditResponse purchaseCreditResponse;
    private PurchaseTalabatCreditView purchaseTalabatCreditView;

    public PurchaseTalabatCreditPresenter(AppVersionProvider appVersionProvider, PurchaseTalabatCreditView purchaseTalabatCreditView2) {
        this.purchaseTalabatCreditView = purchaseTalabatCreditView2;
        this.iPurchaseTalabatCreditInterator = new PurchaseTalabatCreditInterator(appVersionProvider, this);
    }

    public void buyTalabatCredit() {
        PurchaseCreditReq purchaseCreditReq = new PurchaseCreditReq();
        purchaseCreditReq.f475id = this.currentId;
        this.purchaseTalabatCreditView.showLoadingPopup();
        this.iPurchaseTalabatCreditInterator.buyTalabatCredit(purchaseCreditReq, GlobalDataModel.SelectedCountryId);
    }

    public void completedPayment() {
        this.iPurchaseTalabatCreditInterator.getTransactionDetails(this.purchaseCreditResponse.transId, GlobalDataModel.SelectedCountryId);
    }

    public void decreaseAmount(int i11) {
        if (this.purchaseCreditItems.length > 0) {
            int i12 = 0;
            while (true) {
                PurchaseCreditItem[] purchaseCreditItemArr = this.purchaseCreditItems;
                if (i12 < purchaseCreditItemArr.length) {
                    if (i12 == i11 && i12 > 0) {
                        int i13 = i12 - 1;
                        this.purchaseTalabatCreditView.displayAmount(this.f26807a.getFormattedCurrency(purchaseCreditItemArr[i13].amount), i13, this.purchaseCreditItems[i13].amount);
                        this.currentId = this.purchaseCreditItems[i13].f13867id;
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public void increaseAmount(int i11) {
        if (this.purchaseCreditItems.length > 0) {
            int i12 = 0;
            while (true) {
                PurchaseCreditItem[] purchaseCreditItemArr = this.purchaseCreditItems;
                if (i12 < purchaseCreditItemArr.length) {
                    if (i12 == i11 && i12 < purchaseCreditItemArr.length - 1) {
                        int i13 = i12 + 1;
                        this.purchaseTalabatCreditView.displayAmount(this.f26807a.getFormattedCurrency(purchaseCreditItemArr[i13].amount), i13, this.purchaseCreditItems[i13].amount);
                        this.currentId = this.purchaseCreditItems[i13].f13867id;
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public void onCreditListLoaded(PurchaseCredit purchaseCredit2) {
        this.purchaseTalabatCreditView.dismisLoading();
        this.purchaseCredit = purchaseCredit2;
        this.purchaseCreditItems = purchaseCredit2.talabatCredits;
        this.purchaseTalabatCreditView.setDescription(purchaseCredit2.description);
        PurchaseCreditItem[] purchaseCreditItemArr = this.purchaseCreditItems;
        if (purchaseCreditItemArr.length > 0) {
            PurchaseCreditItem purchaseCreditItem = purchaseCreditItemArr[0];
            this.purchaseTalabatCreditView.displayAmount(this.f26807a.getFormattedCurrency(purchaseCreditItem.amount), 0, purchaseCreditItem.amount);
            this.currentId = purchaseCreditItem.f13867id;
        }
    }

    public void onDataError() {
        this.purchaseTalabatCreditView.onDataError();
    }

    public void onDestroy() {
        this.purchaseTalabatCreditView = null;
        IPurchaseTalabatCreditInterator iPurchaseTalabatCreditInterator2 = this.iPurchaseTalabatCreditInterator;
        if (iPurchaseTalabatCreditInterator2 != null) {
            iPurchaseTalabatCreditInterator2.unregister();
        }
        this.iPurchaseTalabatCreditInterator = null;
    }

    public void onNetworkError() {
        this.purchaseTalabatCreditView.onNetworkError();
    }

    public void onPurchaseInitialised(PurchaseCreditResponse purchaseCreditResponse2) {
        this.purchaseCreditResponse = purchaseCreditResponse2;
        this.purchaseTalabatCreditView.onRedirectToPaymentPage(purchaseCreditResponse2.redirectURL, purchaseCreditResponse2.transId);
    }

    public void onServerError(VolleyError volleyError) {
        this.purchaseTalabatCreditView.onServerError(volleyError);
    }

    public void onTransactionDetailsRecieved(GiftVoucherThankyouResponse giftVoucherThankyouResponse) {
        this.purchaseTalabatCreditView.onRedirectToThankyouPage(giftVoucherThankyouResponse);
    }

    public void setUpViews() {
        this.purchaseTalabatCreditView.showLoading();
        this.iPurchaseTalabatCreditInterator.loadCreditList(GlobalDataModel.SelectedCountryId);
    }
}
