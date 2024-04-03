package library.talabat.mvp.accountinfo;

import JsonModels.Request.AccountInfoReq;
import JsonModels.Response.AccountInfoRM;
import JsonModels.Response.AccountInfoRst;
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
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class AccountInteractor implements IAccountInteractor {
    public static final int ERROR_KURDISH_CHARACTERS_IN_NAME = -19;
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public final ITalabatFeatureFlag featureFlag;
    /* access modifiers changed from: private */
    @Nullable
    public AccountListener listener;

    public AccountInteractor(AppVersionProvider appVersionProvider2, ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.appVersionProvider = appVersionProvider2;
        this.featureFlag = iTalabatFeatureFlag;
    }

    private Response.Listener<AccountInfoRM> onCompleted() {
        return new Response.Listener<AccountInfoRM>() {
            public void onResponse(AccountInfoRM accountInfoRM) {
                AccountInfoRst accountInfoRst = accountInfoRM.result.rst;
                int i11 = accountInfoRst.statusCode;
                String str = accountInfoRst.msg;
                if (AccountInteractor.this.listener == null) {
                    return;
                }
                if (i11 == 1) {
                    AccountInteractor.this.listener.onAccountUpdated(accountInfoRM);
                } else if (i11 == 4) {
                    AccountInteractor.this.listener.onAccountUpdatingFailed(i11, str);
                } else if (i11 == 5) {
                    AccountInteractor.this.listener.onAccountUpdatingFailed(i11, str);
                } else if (!AccountInteractor.this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.BLOCK_KURDISH_NAMES, false) || i11 != -19) {
                    AccountInteractor.this.listener.onAccountUpdatingFailed(i11, str);
                } else {
                    AccountInteractor.this.listener.onKurdishNamesBlocked(str);
                }
            }
        };
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (AccountInteractor.this.listener != null) {
                        AccountInteractor.this.listener.onAccountUpdatingFailed(-2, volleyError.getMessage());
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (AccountInteractor.this.listener != null) {
                        AccountInteractor.this.listener.onAccountUpdatingFailed(-2, volleyError.getMessage());
                        AccountInteractor.this.listener.onNetworkError();
                    }
                } else if (volleyError instanceof AuthFailureError) {
                    if (AccountInteractor.this.listener != null) {
                        AccountInteractor.this.listener.onAccountUpdatingFailed(-2, volleyError.getMessage());
                    }
                } else if (AccountInteractor.this.listener != null) {
                    AccountInteractor.this.listener.onAccountUpdatingFailed(-2, volleyError.getMessage());
                }
            }
        };
    }

    public void setAccountListener(@Nullable AccountListener accountListener) {
        this.listener = accountListener;
    }

    public void unregister() {
        this.listener = null;
    }

    public void updateCustomerInfo(AccountInfoReq accountInfoReq) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) accountInfoReq);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) accountInfoReq);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e11) {
            ObservabilityManager.trackUnExpectedScenario("UpdateCustomerInfoMalformedJSON", new HashMap());
            LogManager.logException(e11);
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.ACCOUNT_INFO).setClazz(AccountInfoRM.class).setRequestBody(jSONObject).setListener(onCompleted()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }
}
