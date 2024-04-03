package library.talabat.mvp.appfeedback;

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
import datamodels.AppFeedbackRM;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class AppFeedbackInteractor implements IAppFeedbackInteractor {
    /* access modifiers changed from: private */
    public AppFeedbackListener appFeedbackListener;
    private final AppVersionProvider appVersionProvider;

    public AppFeedbackInteractor(AppVersionProvider appVersionProvider2, AppFeedbackListener appFeedbackListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.appFeedbackListener = appFeedbackListener2;
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (!(volleyError instanceof ServerError)) {
                    if (volleyError instanceof NetworkError) {
                        if (AppFeedbackInteractor.this.appFeedbackListener != null) {
                            AppFeedbackInteractor.this.appFeedbackListener.onServerError(volleyError);
                        }
                    } else if (volleyError instanceof AuthFailureError) {
                        if (AppFeedbackInteractor.this.appFeedbackListener != null) {
                            AppFeedbackInteractor.this.appFeedbackListener.onDataError();
                        }
                    } else if (AppFeedbackInteractor.this.appFeedbackListener != null) {
                        AppFeedbackInteractor.this.appFeedbackListener.onServerError(volleyError);
                    }
                }
            }
        };
    }

    private Response.Listener<AppFeedbackRM> onRequestResponse() {
        return new Response.Listener<AppFeedbackRM>() {
            public void onResponse(AppFeedbackRM appFeedbackRM) {
                if (AppFeedbackInteractor.this.appFeedbackListener != null) {
                    AppFeedbackInteractor.this.appFeedbackListener.onFeedBackSubmitCompleted();
                }
            }
        };
    }

    public void sendFeedbackRequest(AppFeedbackRM appFeedbackRM) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) appFeedbackRM);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) appFeedbackRM);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.APP_FEEDBACK).setClazz(AppFeedbackRM.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.appFeedbackListener = null;
    }
}
