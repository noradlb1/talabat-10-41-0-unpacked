package library.talabat.mvp.talabatcreditvoucher;

import JsonModels.RedeemVoucherRM;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;

public class TalabatCreditVoucherInteractor implements ITalabatCreditVoucherInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public TalabatCreditVoucherListener listener;

    public TalabatCreditVoucherInteractor(AppVersionProvider appVersionProvider2, TalabatCreditVoucherListener talabatCreditVoucherListener) {
        this.appVersionProvider = appVersionProvider2;
        this.listener = talabatCreditVoucherListener;
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (TalabatCreditVoucherInteractor.this.listener != null) {
                        TalabatCreditVoucherInteractor.this.listener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (TalabatCreditVoucherInteractor.this.listener != null) {
                        TalabatCreditVoucherInteractor.this.listener.onNetworkError();
                    }
                } else if ((volleyError instanceof AuthFailureError) && TalabatCreditVoucherInteractor.this.listener != null) {
                    TalabatCreditVoucherInteractor.this.listener.onDataError();
                }
            }
        };
    }

    private Response.Listener<RedeemVoucherRM> onvoucherRedeemed() {
        return new Response.Listener<RedeemVoucherRM>() {
            public void onResponse(RedeemVoucherRM redeemVoucherRM) {
                if (TalabatCreditVoucherInteractor.this.listener != null) {
                    TalabatCreditVoucherInteractor.this.listener.onVoucherResponse(redeemVoucherRM.result);
                }
            }
        };
    }

    public void redeemVoucher(String str, int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.REDEEM_TALABATCREDIT_VOUCHER;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryId}", "" + i11, "{creditvoucher}", str})).setClazz(RedeemVoucherRM.class).setListener(onvoucherRedeemed()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.listener = null;
    }
}
