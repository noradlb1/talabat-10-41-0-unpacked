package library.talabat.mvp.giftvoucher;

import JsonModels.Request.GiftVoucherReq;
import library.talabat.mvp.IGlobalInteractor;

public interface IGiftVoucherInteractor extends IGlobalInteractor {
    void buyGiftVoucher(GiftVoucherReq giftVoucherReq, int i11);

    void getTransactionDetails(String str, int i11);
}
