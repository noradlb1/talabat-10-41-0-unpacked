package library.talabat.mvp.paymenterror;

import JsonModels.Response.PaymentErrorResult;
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

public class PaymentErrorInteractor implements IPaymentErrorInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public PaymentErrorListener listener;

    public PaymentErrorInteractor(AppVersionProvider appVersionProvider2, PaymentErrorListener paymentErrorListener) {
        this.appVersionProvider = appVersionProvider2;
        this.listener = paymentErrorListener;
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (PaymentErrorInteractor.this.listener != null) {
                        PaymentErrorInteractor.this.listener.onServerError(volleyError);
                        PaymentErrorInteractor.this.listener.onPaymentGateDownException(true);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (PaymentErrorInteractor.this.listener != null) {
                        PaymentErrorInteractor.this.listener.onNetworkError();
                    }
                } else if ((volleyError instanceof AuthFailureError) && PaymentErrorInteractor.this.listener != null) {
                    PaymentErrorInteractor.this.listener.onDataError();
                    PaymentErrorInteractor.this.listener.onPaymentGateDownException(true);
                }
            }
        };
    }

    private Response.Listener<PaymentErrorResult> onRequestResponse() {
        return new Response.Listener<PaymentErrorResult>() {
            public void onResponse(PaymentErrorResult paymentErrorResult) {
                if (PaymentErrorInteractor.this.listener != null) {
                    PaymentErrorInteractor.this.listener.onPaymentDetailsReceived(paymentErrorResult.result.paymentErrorPage);
                }
            }
        };
    }

    private Response.Listener<Object> onUpdateRequestResponse() {
        return new Response.Listener<Object>() {
            public void onResponse(Object obj) {
            }
        };
    }

    public void loadTransactionDetails(String str) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.PAYMENT_ERROR;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{errorSlug}", "" + str})).setClazz(PaymentErrorResult.class).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.listener = null;
    }
}
