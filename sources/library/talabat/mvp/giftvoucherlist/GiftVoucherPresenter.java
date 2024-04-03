package library.talabat.mvp.giftvoucherlist;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.GiftVoucher;
import datamodels.GiftVoucherItem;

public class GiftVoucherPresenter implements IGiftVoucherPresenter, GiftVoucherListener {
    private IGiftVoucherInteractor giftVoucherInteractor;
    private GiftVoucherListView giftVoucherListView;

    public GiftVoucherPresenter(AppVersionProvider appVersionProvider, GiftVoucherListView giftVoucherListView2) {
        this.giftVoucherListView = giftVoucherListView2;
        this.giftVoucherInteractor = new GiftVoucherInteractor(appVersionProvider, this);
    }

    public void onDataError() {
        this.giftVoucherListView.onDataError();
    }

    public void onDestroy() {
        this.giftVoucherListView = null;
        IGiftVoucherInteractor iGiftVoucherInteractor = this.giftVoucherInteractor;
        if (iGiftVoucherInteractor != null) {
            iGiftVoucherInteractor.unregister();
        }
        this.giftVoucherInteractor = null;
    }

    public void onGiftVoucherLoaded(GiftVoucher giftVoucher) {
        this.giftVoucherListView.dismisLoading();
        this.giftVoucherListView.setDescription(giftVoucher.description);
        this.giftVoucherListView.setGiftVoucherItems(giftVoucher.giftVouchers);
    }

    public void onGiftVoucherSelected(GiftVoucherItem giftVoucherItem) {
        this.giftVoucherListView.onRedirectToGiftVoucherDetails(giftVoucherItem);
    }

    public void onNetworkError() {
        this.giftVoucherListView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.giftVoucherListView.onServerError(volleyError);
    }

    public void setUpViews() {
        this.giftVoucherListView.showLoading();
        this.giftVoucherInteractor.loadGiftVouchers(GlobalDataModel.SelectedCountryId);
    }
}
