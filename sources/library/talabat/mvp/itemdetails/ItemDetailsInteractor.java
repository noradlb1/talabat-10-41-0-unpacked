package library.talabat.mvp.itemdetails;

import JsonModels.Request.ThirdLevelChoiceRequest;
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
import datamodels.Restaurant;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ItemDetailsInteractor implements IItemDetailsInteractor {
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public ItemDetailsListener f26739b;

    public ItemDetailsInteractor(AppVersionProvider appVersionProvider2, ItemDetailsListener itemDetailsListener) {
        this.appVersionProvider = appVersionProvider2;
        this.f26739b = itemDetailsListener;
    }

    private Response.Listener<SplitChoiceRM> onThirdLevelChoicesReceived() {
        return new Response.Listener<SplitChoiceRM>() {
            public void onResponse(SplitChoiceRM splitChoiceRM) {
                ItemDetailsInteractor.this.f26739b.onThirdLevelChoicesReceived(splitChoiceRM.result);
            }
        };
    }

    public void callThirdLevelChoice(String str) {
        String str2;
        JSONObject jSONObject;
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        ThirdLevelChoiceRequest thirdLevelChoiceRequest = new ThirdLevelChoiceRequest(restaurant.branchId, str, restaurant.getId());
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str2 = gson.toJson((Object) thirdLevelChoiceRequest);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) thirdLevelChoiceRequest);
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.SPLIT_RESTAURANT_THIRD_CHOICE).setClazz(SplitChoiceRM.class).setRequestBody(jSONObject).setListener(onThirdLevelChoicesReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                ItemDetailsListener itemDetailsListener;
                ItemDetailsListener itemDetailsListener2;
                ItemDetailsListener itemDetailsListener3;
                if ((volleyError instanceof ServerError) && (itemDetailsListener3 = ItemDetailsInteractor.this.f26739b) != null) {
                    itemDetailsListener3.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && (itemDetailsListener2 = ItemDetailsInteractor.this.f26739b) != null) {
                    itemDetailsListener2.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && (itemDetailsListener = ItemDetailsInteractor.this.f26739b) != null) {
                    itemDetailsListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.f26739b = null;
    }
}
