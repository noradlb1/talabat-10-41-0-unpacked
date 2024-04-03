package library.talabat.mvp.forgotpassword;

import JsonModels.Request.PasswordReq;
import JsonModels.Response.PasswordResponse;
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
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import e10.a;
import e10.b;
import java.util.HashMap;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ForgotPasswordInteractor implements IForgotPasswordInteractor {
    private final AppVersionProvider appVersionProvider;
    private ForgotPasswordListener forgotPasswordListener;

    public ForgotPasswordInteractor(AppVersionProvider appVersionProvider2) {
        this.appVersionProvider = appVersionProvider2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestError$0(VolleyError volleyError) {
        ForgotPasswordListener forgotPasswordListener2;
        ForgotPasswordListener forgotPasswordListener3;
        ForgotPasswordListener forgotPasswordListener4;
        if ((volleyError instanceof ServerError) && (forgotPasswordListener4 = this.forgotPasswordListener) != null) {
            forgotPasswordListener4.onServerError(volleyError);
        } else if ((volleyError instanceof NetworkError) && (forgotPasswordListener3 = this.forgotPasswordListener) != null) {
            forgotPasswordListener3.onNetworkError();
        } else if ((volleyError instanceof AuthFailureError) && (forgotPasswordListener2 = this.forgotPasswordListener) != null) {
            forgotPasswordListener2.onDataError();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestResponse$1(PasswordResponse passwordResponse) {
        ForgotPasswordListener forgotPasswordListener2 = this.forgotPasswordListener;
        if (forgotPasswordListener2 != null) {
            forgotPasswordListener2.onRequestPasswordSuccess(passwordResponse);
        }
    }

    private Response.Listener<PasswordResponse> onRequestResponse() {
        return new a(this);
    }

    private void sendRequest(PasswordReq passwordReq) {
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) passwordReq);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) passwordReq);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = AppUrls.FORGOT_PASSWORD_TALABAT;
            TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(PasswordResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException e11) {
            LogManager.logException(e11);
            trackCrash("ForgotPasswordMalformedJSON", e11);
        }
    }

    private void trackCrash(String str, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", exc.getMessage());
        ObservabilityManager.trackUnExpectedScenario(str, hashMap);
    }

    public Response.ErrorListener onRequestError() {
        return new b(this);
    }

    public void sendPasswordRequest(String str) {
        PasswordReq passwordReq = new PasswordReq();
        passwordReq.email = str;
        sendRequest(passwordReq);
    }

    public void sendPasswordRequestForMobileNumber(@NotNull String str) {
        PasswordReq passwordReq = new PasswordReq();
        passwordReq.email = str;
        passwordReq.mobileNumber = str;
        passwordReq.mobileCountryCode = GlobalConstants.IRAQ_COUNTRY_CODE;
        sendRequest(passwordReq);
    }

    public void setForgotPasswordListener(ForgotPasswordListener forgotPasswordListener2) {
        this.forgotPasswordListener = forgotPasswordListener2;
    }

    public void unregister() {
        this.forgotPasswordListener = null;
    }
}
