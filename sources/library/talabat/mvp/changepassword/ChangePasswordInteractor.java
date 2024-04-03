package library.talabat.mvp.changepassword;

import JsonModels.Request.ChangePasswordReq;
import JsonModels.Response.ChangePasswordResponse;
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
public class ChangePasswordInteractor implements IChangePasswordInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public ChangePasswordListener changePasswordListener;

    public ChangePasswordInteractor(AppVersionProvider appVersionProvider2, ChangePasswordListener changePasswordListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.changePasswordListener = changePasswordListener2;
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (ChangePasswordInteractor.this.changePasswordListener != null) {
                        ChangePasswordInteractor.this.changePasswordListener.onPasswordChangeFailed(volleyError.getMessage());
                        ChangePasswordInteractor.this.changePasswordListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (ChangePasswordInteractor.this.changePasswordListener != null) {
                        ChangePasswordInteractor.this.changePasswordListener.onPasswordChangeFailed(volleyError.getMessage());
                        ChangePasswordInteractor.this.changePasswordListener.onNetworkError();
                    }
                } else if (volleyError instanceof AuthFailureError) {
                    if (ChangePasswordInteractor.this.changePasswordListener != null) {
                        ChangePasswordInteractor.this.changePasswordListener.onPasswordChangeFailed(volleyError.getMessage());
                        ChangePasswordInteractor.this.changePasswordListener.onDataError();
                    }
                } else if (ChangePasswordInteractor.this.changePasswordListener != null) {
                    ChangePasswordInteractor.this.changePasswordListener.onPasswordChangeFailed(volleyError.getMessage());
                }
            }
        };
    }

    private Response.Listener<ChangePasswordResponse> onRequestResponse() {
        return new Response.Listener<ChangePasswordResponse>() {
            public void onResponse(ChangePasswordResponse changePasswordResponse) {
                if (changePasswordResponse.status) {
                    ChangePasswordInteractor.this.changePasswordListener.onPasswordRequestSuccess(changePasswordResponse.result);
                } else {
                    ChangePasswordInteractor.this.changePasswordListener.onPasswordChangeFailed(changePasswordResponse.result);
                }
            }
        };
    }

    public void sendChangePasswordRequest(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        ChangePasswordReq changePasswordReq = new ChangePasswordReq();
        changePasswordReq.CurrentPassword = str;
        changePasswordReq.NewPassword = str2;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) changePasswordReq);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) changePasswordReq);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.CHANGE_PASSWORD).setClazz(ChangePasswordResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.changePasswordListener = null;
    }
}
