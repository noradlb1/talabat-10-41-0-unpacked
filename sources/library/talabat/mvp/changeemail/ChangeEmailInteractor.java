package library.talabat.mvp.changeemail;

import JsonModels.Request.ChangeEmailReq;
import JsonModels.Response.ChangeEmailResponse;
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
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ChangeEmailInteractor implements IChangeEmailInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public ChangeEmailListener changeEmailListener;

    public ChangeEmailInteractor(AppVersionProvider appVersionProvider2, ChangeEmailListener changeEmailListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.changeEmailListener = changeEmailListener2;
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (ChangeEmailInteractor.this.changeEmailListener != null) {
                        ChangeEmailInteractor.this.changeEmailListener.onEmailChangeFailed(volleyError.getMessage());
                        ChangeEmailInteractor.this.changeEmailListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (ChangeEmailInteractor.this.changeEmailListener != null) {
                        ChangeEmailInteractor.this.changeEmailListener.onEmailChangeFailed(volleyError.getMessage());
                        ChangeEmailInteractor.this.changeEmailListener.onNetworkError();
                    }
                } else if (volleyError instanceof AuthFailureError) {
                    if (ChangeEmailInteractor.this.changeEmailListener != null) {
                        ChangeEmailInteractor.this.changeEmailListener.onEmailChangeFailed(volleyError.getMessage());
                        ChangeEmailInteractor.this.changeEmailListener.onDataError();
                    }
                } else if (ChangeEmailInteractor.this.changeEmailListener != null) {
                    ChangeEmailInteractor.this.changeEmailListener.onEmailChangeFailed(volleyError.getMessage());
                }
            }
        };
    }

    private Response.Listener<ChangeEmailResponse> onRequestResponse() {
        return new Response.Listener<ChangeEmailResponse>() {
            public void onResponse(ChangeEmailResponse changeEmailResponse) {
                if (changeEmailResponse.status) {
                    ChangeEmailInteractor.this.changeEmailListener.onEmailRequestSuccess(changeEmailResponse.result);
                } else {
                    ChangeEmailInteractor.this.changeEmailListener.onEmailChangeFailed(changeEmailResponse.result);
                }
            }
        };
    }

    public void sendChangeEmailRequest(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        ChangeEmailReq changeEmailReq = new ChangeEmailReq();
        changeEmailReq.CurrentPassword = str2;
        changeEmailReq.NewEmail = str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) changeEmailReq);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) changeEmailReq);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.CHANGE_EMAIL).setClazz(ChangeEmailResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.changeEmailListener = null;
    }
}
