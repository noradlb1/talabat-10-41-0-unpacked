package library.talabat.mvp.rateorder;

import JsonModels.Response.RateOrderResponse;
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
import datamodels.RateOrderReq;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
class RateOderInteractor implements IRateOderInteractor {
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26812b = false;
    /* access modifiers changed from: private */
    public RateOrderListener listener;

    public RateOderInteractor(AppVersionProvider appVersionProvider2, RateOrderListener rateOrderListener) {
        this.appVersionProvider = appVersionProvider2;
        this.listener = rateOrderListener;
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (RateOderInteractor.this.listener != null) {
                        RateOderInteractor.this.listener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (RateOderInteractor.this.listener != null) {
                        RateOderInteractor.this.listener.onNetworkError();
                    }
                } else if ((volleyError instanceof AuthFailureError) && RateOderInteractor.this.listener != null) {
                    RateOderInteractor.this.listener.onDataError();
                }
            }
        };
    }

    private Response.Listener<RateOrderResponse> onRequestResponse() {
        return new Response.Listener<RateOrderResponse>() {
            public void onResponse(RateOrderResponse rateOrderResponse) {
                if (rateOrderResponse.result.totalRating >= 0.0f) {
                    RateOderInteractor.this.f26812b = true;
                }
                if (RateOderInteractor.this.listener != null) {
                    RateOderInteractor.this.listener.onOrderRatedSuccussfully(RateOderInteractor.this.f26812b, rateOrderResponse.result.totalRating);
                }
            }
        };
    }

    public void submitRating(RateOrderReq rateOrderReq) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) rateOrderReq);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) rateOrderReq);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.RATEORDER, new String[]{"{encryptedOrderId}", rateOrderReq.ordId})).setClazz(RateOrderResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.listener = null;
    }
}
