package library.talabat.mvp.giftvoucher;

import JsonModels.GiftVoucherPurchaseResponse;
import JsonModels.GiftVoucherThankyouResponse;
import library.talabat.mvp.IGlobalListener;

public interface GiftVoucherListener extends IGlobalListener {
    void onPurchaseCompleted(GiftVoucherPurchaseResponse giftVoucherPurchaseResponse);

    void onTransactionDetailsRecieved(GiftVoucherThankyouResponse giftVoucherThankyouResponse);
}
