package library.talabat.mvp.giftvoucherlist;

import datamodels.GiftVoucherItem;
import library.talabat.mvp.IGlobalPresenter;

public interface IGiftVoucherPresenter extends IGlobalPresenter {
    void onGiftVoucherSelected(GiftVoucherItem giftVoucherItem);

    void setUpViews();
}
