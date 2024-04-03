package library.talabat.mvp.talabatcreditstatement;

import JsonModels.TalabatCreditStatementResponse;
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

class TalabatCreditStatementInteractor implements ITalabatCreditStatementInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public TalabatCreditStatementListener listener;

    public TalabatCreditStatementInteractor(AppVersionProvider appVersionProvider2, TalabatCreditStatementListener talabatCreditStatementListener) {
        this.appVersionProvider = appVersionProvider2;
        this.listener = talabatCreditStatementListener;
    }

    private Response.Listener<TalabatCreditStatementResponse> onGiftVoucherRecieved() {
        return new Response.Listener<TalabatCreditStatementResponse>() {
            public void onResponse(TalabatCreditStatementResponse talabatCreditStatementResponse) {
                TalabatCreditStatementInteractor.this.listener.onCreditStatementRecieved(talabatCreditStatementResponse.result);
            }
        };
    }

    public void getTalabatCreditStatement(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_TALABATCREDIT_STATEMENT;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", "" + i11})).setClazz(TalabatCreditStatementResponse.class).setListener(onGiftVoucherRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && TalabatCreditStatementInteractor.this.listener != null) {
                    TalabatCreditStatementInteractor.this.listener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && TalabatCreditStatementInteractor.this.listener != null) {
                    TalabatCreditStatementInteractor.this.listener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && TalabatCreditStatementInteractor.this.listener != null) {
                    TalabatCreditStatementInteractor.this.listener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.listener = null;
    }
}
