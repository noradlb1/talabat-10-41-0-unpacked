package library.talabat.choiceLoader;

import JsonModels.Request.SplitRestaurantApiRequest.AllChoiceRequest;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
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
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ChoiceLoaderInteractor implements IChoiceLoaderInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public ChoiceLoaderListener choiceLoaderListener;

    public ChoiceLoaderInteractor(AppVersionProvider appVersionProvider2, ChoiceLoaderListener choiceLoaderListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.choiceLoaderListener = choiceLoaderListener2;
    }

    private Response.Listener<SplitChoiceRM> onAllChoicesReceived() {
        return new Response.Listener<SplitChoiceRM>() {
            public void onResponse(SplitChoiceRM splitChoiceRM) {
                if (ChoiceLoaderInteractor.this.choiceLoaderListener != null && !GlobalDataModel.MENU.doNotLoad) {
                    if (splitChoiceRM.result.items.length > 0) {
                        ChoiceLoaderInteractor.this.choiceLoaderListener.onChoiceReceived(splitChoiceRM.result.items);
                    } else {
                        ChoiceLoaderInteractor.this.choiceLoaderListener.onNoChoiceAvailable();
                    }
                }
            }
        };
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && ChoiceLoaderInteractor.this.choiceLoaderListener != null) {
                    ChoiceLoaderInteractor.this.choiceLoaderListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && ChoiceLoaderInteractor.this.choiceLoaderListener != null) {
                    ChoiceLoaderInteractor.this.choiceLoaderListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && ChoiceLoaderInteractor.this.choiceLoaderListener != null) {
                    ChoiceLoaderInteractor.this.choiceLoaderListener.onDataError();
                }
            }
        };
    }

    public void getAllChoicesForVisibleMenuSection(int i11, String str) {
        String str2;
        JSONObject jSONObject;
        GlobalDataModel.MENU.ChoicesForBranch = i11;
        AllChoiceRequest allChoiceRequest = new AllChoiceRequest(str);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str2 = gson.toJson((Object) allChoiceRequest);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) allChoiceRequest);
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (!GlobalDataModel.MENU.doNotLoad) {
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            String str3 = AppUrls.SPLIT_RESTAURANT_ALL_CHOICE;
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str3, new String[]{"{branchId}", "" + i11})).setClazz(SplitChoiceRM.class).setRequestBody(jSONObject).setListener(onAllChoicesReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        }
    }

    public void unregister() {
        this.choiceLoaderListener = null;
    }
}
