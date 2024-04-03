package library.talabat.mvp.informap;

import JsonModels.Request.InforMapRequest;
import JsonModels.Response.InforMapAddressRM;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.tracking.InforMapTracker;
import m10.a;
import org.json.JSONException;
import org.json.JSONObject;
import tracking.ScreenNames;

public class InforMapInetractor implements IInforMapInetractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public InforMapWebviewListener inforMapWebviewListener;

    public InforMapInetractor(AppVersionProvider appVersionProvider2, InforMapWebviewListener inforMapWebviewListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.inforMapWebviewListener = inforMapWebviewListener2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestError$0(InforMapRequest inforMapRequest, VolleyError volleyError) {
        InforMapTracker.trackInformapStoreApiError(ScreenNames.INFOR_MAP_SCREEN, inforMapRequest, volleyError);
        if (volleyError instanceof ServerError) {
            InforMapWebviewListener inforMapWebviewListener2 = this.inforMapWebviewListener;
            if (inforMapWebviewListener2 != null) {
                inforMapWebviewListener2.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            InforMapWebviewListener inforMapWebviewListener3 = this.inforMapWebviewListener;
            if (inforMapWebviewListener3 != null) {
                inforMapWebviewListener3.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            InforMapWebviewListener inforMapWebviewListener4 = this.inforMapWebviewListener;
            if (inforMapWebviewListener4 != null) {
                inforMapWebviewListener4.onDataError();
            }
        } else {
            LogManager.logException(volleyError);
        }
    }

    private Response.Listener<InforMapAddressRM> onInforMapAddressResponse() {
        return new Response.Listener<InforMapAddressRM>() {
            public void onResponse(InforMapAddressRM inforMapAddressRM) {
                if (inforMapAddressRM != null) {
                    InforMapInetractor.this.inforMapWebviewListener.convertAddressReceived(inforMapAddressRM.result);
                } else {
                    InforMapInetractor.this.inforMapWebviewListener.convertAddressFailed();
                }
            }
        };
    }

    public void mapInforMapAddressObjectConvertor(boolean z11, int i11, InforMapRequest inforMapRequest) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(inforMapRequest.getJson());
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.INFORMAP_ADDRESS_CONVERT_BRANCH_ID).setClazz(InforMapAddressRM.class).setRequestBody(jSONObject).setListener(onInforMapAddressResponse()).setErrorListener(onRequestError(inforMapRequest)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError(InforMapRequest inforMapRequest) {
        return new a(this, inforMapRequest);
    }

    public void unregister() {
        this.inforMapWebviewListener = null;
    }
}
