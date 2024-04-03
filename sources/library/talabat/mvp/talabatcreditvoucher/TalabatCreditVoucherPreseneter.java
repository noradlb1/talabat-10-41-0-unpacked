package library.talabat.mvp.talabatcreditvoucher;

import JsonModels.Response.RedeemVoucherResponse;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;

public class TalabatCreditVoucherPreseneter implements ITalabatCreditVoucherPreseneter, TalabatCreditVoucherListener {
    private ITalabatCreditVoucherInteractor italabatCreditVoucherInteractor;
    private TalabatCreditVoucherView talabatCreditVoucherView;

    public TalabatCreditVoucherPreseneter(AppVersionProvider appVersionProvider, TalabatCreditVoucherView talabatCreditVoucherView2) {
        this.italabatCreditVoucherInteractor = new TalabatCreditVoucherInteractor(appVersionProvider, this);
        this.talabatCreditVoucherView = talabatCreditVoucherView2;
    }

    public void onDataError() {
        this.talabatCreditVoucherView.onDataError();
    }

    public void onDestroy() {
        this.talabatCreditVoucherView = null;
        ITalabatCreditVoucherInteractor iTalabatCreditVoucherInteractor = this.italabatCreditVoucherInteractor;
        if (iTalabatCreditVoucherInteractor != null) {
            iTalabatCreditVoucherInteractor.unregister();
        }
        this.italabatCreditVoucherInteractor = null;
    }

    public void onNetworkError() {
        this.talabatCreditVoucherView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.talabatCreditVoucherView.onServerError(volleyError);
    }

    public void onVoucherResponse(RedeemVoucherResponse redeemVoucherResponse) {
        this.talabatCreditVoucherView.onVoucherApplied(redeemVoucherResponse.msg, redeemVoucherResponse.amount);
        try {
            if (Customer.getInstance() != null) {
                Customer.getInstance().getCustomerInfo().talabatCredit += redeemVoucherResponse.amount;
            }
        } catch (Exception unused) {
        }
    }

    public void validateAndContinue() {
        String voucherCode = this.talabatCreditVoucherView.getVoucherCode();
        if (voucherCode.equals("")) {
            this.talabatCreditVoucherView.onLocalValidationFailed(70);
            return;
        }
        this.talabatCreditVoucherView.onValidationSuccess();
        this.italabatCreditVoucherInteractor.redeemVoucher(voucherCode, GlobalDataModel.SelectedCountryId);
    }
}
