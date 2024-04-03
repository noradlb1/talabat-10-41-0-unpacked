package library.talabat.mvp.giftvoucherlist;

import datamodels.GiftVoucher;
import library.talabat.mvp.IGlobalListener;

public interface GiftVoucherListener extends IGlobalListener {
    void onGiftVoucherLoaded(GiftVoucher giftVoucher);
}
