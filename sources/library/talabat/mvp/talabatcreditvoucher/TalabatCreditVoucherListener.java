package library.talabat.mvp.talabatcreditvoucher;

import JsonModels.Response.RedeemVoucherResponse;
import library.talabat.mvp.IGlobalListener;

public interface TalabatCreditVoucherListener extends IGlobalListener {
    void onVoucherResponse(RedeemVoucherResponse redeemVoucherResponse);
}
