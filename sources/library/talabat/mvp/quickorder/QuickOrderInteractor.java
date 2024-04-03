package library.talabat.mvp.quickorder;

import JsonModels.AddAddressResult;
import JsonModels.Response.AddAddressRM;
import JsonModels.parser.UniversalGson;
import androidx.annotation.VisibleForTesting;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.QuickOrderUserInfo;
import org.json.JSONException;
import org.json.JSONObject;
import x10.a;
import x10.b;

@Instrumented
public class QuickOrderInteractor implements IQuickOrderInteractor {
    private final AppVersionProvider appVersionProvider;
    public QuickOrderListener listener;
    public OnQuickOrderValidated onQuickOrderValidatedListener;

    public QuickOrderInteractor(AppVersionProvider appVersionProvider2, QuickOrderListener quickOrderListener, OnQuickOrderValidated onQuickOrderValidated) {
        this.appVersionProvider = appVersionProvider2;
        this.listener = quickOrderListener;
        this.onQuickOrderValidatedListener = onQuickOrderValidated;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddressValidation$0(QuickOrderUserInfo quickOrderUserInfo, AddAddressRM addAddressRM) {
        OnQuickOrderValidated onQuickOrderValidated;
        AddAddressResult addAddressResult = addAddressRM.result.rst;
        int i11 = addAddressResult.statusCode;
        if (i11 == 0) {
            QuickOrderListener quickOrderListener = this.listener;
            if (quickOrderListener != null && (onQuickOrderValidated = this.onQuickOrderValidatedListener) != null) {
                onQuickOrderValidated.onResponse(quickOrderListener, quickOrderUserInfo, addAddressRM);
                return;
            }
            return;
        }
        QuickOrderListener quickOrderListener2 = this.listener;
        if (quickOrderListener2 != null) {
            quickOrderListener2.onAddressValidationFailed(i11, addAddressResult.msg);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestError$1(VolleyError volleyError) {
        if (volleyError instanceof ServerError) {
            QuickOrderListener quickOrderListener = this.listener;
            if (quickOrderListener != null) {
                quickOrderListener.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            QuickOrderListener quickOrderListener2 = this.listener;
            if (quickOrderListener2 != null) {
                quickOrderListener2.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            QuickOrderListener quickOrderListener3 = this.listener;
            if (quickOrderListener3 != null) {
                quickOrderListener3.onDataError();
            }
        } else {
            this.listener.onUnexpectedError(volleyError);
            LogManager.logException(volleyError);
        }
    }

    @VisibleForTesting
    public Response.Listener<AddAddressRM> c(QuickOrderUserInfo quickOrderUserInfo) {
        return new b(this, quickOrderUserInfo);
    }

    public Response.ErrorListener onRequestError() {
        return new a(this);
    }

    public void unregister() {
        this.listener = null;
    }

    public void validateAddress(Address address, QuickOrderUserInfo quickOrderUserInfo) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e11) {
            e11.printStackTrace();
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.VALIDATEADDRESS).setClazz(AddAddressRM.class).setRequestBody(jSONObject).setListener(c(quickOrderUserInfo)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }
}
