package library.talabat.gemengine;

import JsonModels.Request.GEMRequests.GemOfferRequest;
import JsonModels.Response.GEMResponse.GemAcceptRM;
import JsonModels.Response.GEMResponse.GemOfferRM;
import JsonModels.Response.GEMResponse.GemRejectRM;
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
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class GemInteractor implements IGemInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public GemListener gemListener;

    public GemInteractor(AppVersionProvider appVersionProvider2, GemListener gemListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.gemListener = gemListener2;
    }

    private Response.Listener<GemAcceptRM> onAcceptGemResultReceived() {
        return new Response.Listener<GemAcceptRM>() {
            public void onResponse(GemAcceptRM gemAcceptRM) {
                if (GemInteractor.this.gemListener != null && gemAcceptRM != null && gemAcceptRM.result != null) {
                    GemInteractor.this.gemListener.onAcceptGemReceived(gemAcceptRM.result);
                }
            }
        };
    }

    private Response.Listener<GemRejectRM> onCancelGemResultReceived() {
        return new Response.Listener<GemRejectRM>() {
            public void onResponse(GemRejectRM gemRejectRM) {
                if (GemInteractor.this.gemListener != null && gemRejectRM.result != null) {
                    GemInteractor.this.gemListener.onCancelGemResult(gemRejectRM.result);
                }
            }
        };
    }

    private Response.Listener<GemOfferRM> onGemOfferReceived() {
        return new Response.Listener<GemOfferRM>() {
            public void onResponse(GemOfferRM gemOfferRM) {
                if (!GlobalDataModel.GEMCONSTANTS.isGemBlocked && GemInteractor.this.gemListener != null && gemOfferRM != null && gemOfferRM.result != null) {
                    GemInteractor.this.gemListener.onGemOfferReceived(gemOfferRM.result, !TalabatUtils.isNullOrEmpty(gemOfferRM.baseUrl) ? gemOfferRM.baseUrl : "");
                }
            }
        };
    }

    private Response.Listener<GemRejectRM> onRejectGemResultReceived() {
        return new Response.Listener<GemRejectRM>() {
            public void onResponse(GemRejectRM gemRejectRM) {
                if (GemInteractor.this.gemListener != null && gemRejectRM.result != null) {
                    GemInteractor.this.gemListener.onRejectGemResult(gemRejectRM.result);
                }
            }
        };
    }

    public void acceptGem(String str, long j11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.ACCEPT_GEM_URL;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countrySlug}", "" + GlobalDataModel.SelectedCountryId, "{offerId}", str, "{reservationCode}", "" + j11})).setClazz(GemAcceptRM.class).setListener(onAcceptGemResultReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void cancelGem(String str) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.CANCEL_GEM_URL;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countrySlug}", "" + GlobalDataModel.SelectedCountryId, "{offerId}", "" + str})).setClazz(GemRejectRM.class).setListener(onCancelGemResultReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGemOffers(int i11, String str, String str2) {
        String str3;
        JSONObject jSONObject;
        GemOfferRequest gemOfferRequest = new GemOfferRequest("" + i11, str, str2);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) gemOfferRequest);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) gemOfferRequest);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_GEM_OFFERS).setClazz(GemOfferRM.class).setRequestBody(jSONObject).setListener(onGemOfferReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && GemInteractor.this.gemListener != null) {
                    GemInteractor.this.gemListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && GemInteractor.this.gemListener != null) {
                    GemInteractor.this.gemListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && GemInteractor.this.gemListener != null) {
                    GemInteractor.this.gemListener.onDataError();
                }
            }
        };
    }

    public void rejectGem(String str) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.REJECT_GEM_URL;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countrySlug}", "" + GlobalDataModel.SelectedCountryId, "{offerId}", "" + str})).setClazz(GemRejectRM.class).setListener(onRejectGemResultReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.gemListener = null;
    }
}
