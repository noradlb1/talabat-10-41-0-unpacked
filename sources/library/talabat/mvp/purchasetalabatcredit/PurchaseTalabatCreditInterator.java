package library.talabat.mvp.purchasetalabatcredit;

import JsonModels.CreditListResponse;
import JsonModels.Request.PurchaseCreditReq;
import JsonModels.Response.GiftVoucherThankyouRM;
import JsonModels.Response.PurchaseCreditRM;
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
public class PurchaseTalabatCreditInterator implements IPurchaseTalabatCreditInterator {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public PurchaseTalabatCreditListener purchaseTalabatCreditListener;

    public PurchaseTalabatCreditInterator(AppVersionProvider appVersionProvider2, PurchaseTalabatCreditListener purchaseTalabatCreditListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.purchaseTalabatCreditListener = purchaseTalabatCreditListener2;
    }

    private Response.Listener<CreditListResponse> onCreditListRecieved() {
        return new Response.Listener<CreditListResponse>() {
            public void onResponse(CreditListResponse creditListResponse) {
                if (PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener != null) {
                    PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener.onCreditListLoaded(creditListResponse.result);
                }
            }
        };
    }

    private Response.Listener<GiftVoucherThankyouRM> onCreditPurchased() {
        return new Response.Listener<GiftVoucherThankyouRM>() {
            public void onResponse(GiftVoucherThankyouRM giftVoucherThankyouRM) {
                if (PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener != null) {
                    PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener.onTransactionDetailsRecieved(giftVoucherThankyouRM.result);
                }
            }
        };
    }

    private Response.Listener<PurchaseCreditRM> onPurchaseResponse() {
        return new Response.Listener<PurchaseCreditRM>() {
            public void onResponse(PurchaseCreditRM purchaseCreditRM) {
                if (PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener != null) {
                    PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener.onPurchaseInitialised(purchaseCreditRM.result);
                }
            }
        };
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener != null) {
                        PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener != null) {
                        PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener.onNetworkError();
                    }
                } else if ((volleyError instanceof AuthFailureError) && PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener != null) {
                    PurchaseTalabatCreditInterator.this.purchaseTalabatCreditListener.onDataError();
                }
            }
        };
    }

    public void buyTalabatCredit(PurchaseCreditReq purchaseCreditReq, int i11) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) purchaseCreditReq);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) purchaseCreditReq);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
        String str2 = AppUrls.PURCHASE_TALABAT_CREDIT;
        TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryId}", "" + i11})).setClazz(PurchaseCreditRM.class).setRequestBody(jSONObject).setListener(onPurchaseResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getTransactionDetails(String str, int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.GET_TALABAT_CREDIT_TRANSACTION_DETAILS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryid}", "" + i11, "{transid}", str})).setClazz(GiftVoucherThankyouRM.class).setListener(onCreditPurchased()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadCreditList(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_CREDIT_LIST;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + i11})).setClazz(CreditListResponse.class).setListener(onCreditListRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.purchaseTalabatCreditListener = null;
    }
}
