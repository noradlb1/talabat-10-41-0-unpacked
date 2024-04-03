package library.talabat.mvp.giftvoucher;

import JsonModels.Request.GiftVoucherReq;
import JsonModels.Response.GiftVoucherPurchaseRM;
import JsonModels.Response.GiftVoucherThankyouRM;
import JsonModels.parser.UniversalGson;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class GiftVoucherInteractor implements IGiftVoucherInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public GiftVoucherListener giftVoucherListener;

    public GiftVoucherInteractor(AppVersionProvider appVersionProvider2, GiftVoucherListener giftVoucherListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.giftVoucherListener = giftVoucherListener2;
    }

    private Response.Listener<GiftVoucherThankyouRM> onGiftVoucherRecieved() {
        return new Response.Listener<GiftVoucherThankyouRM>() {
            public void onResponse(GiftVoucherThankyouRM giftVoucherThankyouRM) {
                if (GiftVoucherInteractor.this.giftVoucherListener != null) {
                    GiftVoucherInteractor.this.giftVoucherListener.onTransactionDetailsRecieved(giftVoucherThankyouRM.result);
                }
            }
        };
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (GiftVoucherInteractor.this.giftVoucherListener != null) {
                        GiftVoucherInteractor.this.giftVoucherListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (GiftVoucherInteractor.this.giftVoucherListener != null) {
                        GiftVoucherInteractor.this.giftVoucherListener.onNetworkError();
                    }
                } else if ((volleyError instanceof AuthFailureError) && GiftVoucherInteractor.this.giftVoucherListener != null) {
                    GiftVoucherInteractor.this.giftVoucherListener.onDataError();
                }
            }
        };
    }

    private Response.Listener<GiftVoucherPurchaseRM> onRequestResponse() {
        return new Response.Listener<GiftVoucherPurchaseRM>() {
            public void onResponse(GiftVoucherPurchaseRM giftVoucherPurchaseRM) {
                GiftVoucherInteractor.this.giftVoucherListener.onPurchaseCompleted(giftVoucherPurchaseRM.result);
            }
        };
    }

    public void buyGiftVoucher(GiftVoucherReq giftVoucherReq, int i11) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) giftVoucherReq);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) giftVoucherReq);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
        String str2 = AppUrls.GET_GIFTVOUCHER;
        TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryid}", "" + i11})).setClazz(GiftVoucherPurchaseRM.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getTransactionDetails(String str, int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.GET_GIFTVOUCHER_TRANSACTION_DETAILS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryid}", "" + i11, "{transid}", str})).setClazz(GiftVoucherThankyouRM.class).setListener(onGiftVoucherRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.giftVoucherListener = null;
    }
}
