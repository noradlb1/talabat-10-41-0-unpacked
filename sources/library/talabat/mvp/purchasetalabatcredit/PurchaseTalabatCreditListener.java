package library.talabat.mvp.purchasetalabatcredit;

import JsonModels.GiftVoucherThankyouResponse;
import JsonModels.PurchaseCreditResponse;
import datamodels.PurchaseCredit;
import library.talabat.mvp.IGlobalListener;

public interface PurchaseTalabatCreditListener extends IGlobalListener {
    void onCreditListLoaded(PurchaseCredit purchaseCredit);

    void onPurchaseInitialised(PurchaseCreditResponse purchaseCreditResponse);

    void onTransactionDetailsRecieved(GiftVoucherThankyouResponse giftVoucherThankyouResponse);
}
