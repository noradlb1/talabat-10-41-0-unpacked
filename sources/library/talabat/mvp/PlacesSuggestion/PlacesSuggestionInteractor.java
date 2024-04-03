package library.talabat.mvp.PlacesSuggestion;

import JsonModels.Request.PlacesSuggestionRequest;
import JsonModels.Response.PlacesSuggestionDetailsRM;
import JsonModels.Response.PlacesSuggestionRM;
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
public class PlacesSuggestionInteractor implements IPlacesSuggestionInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public PlacesSuggestionListener placesSuggestionListener;

    public PlacesSuggestionInteractor(AppVersionProvider appVersionProvider2, PlacesSuggestionListener placesSuggestionListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.placesSuggestionListener = placesSuggestionListener2;
    }

    private Response.Listener<PlacesSuggestionDetailsRM> onPlaceDetailsRecieved() {
        return new Response.Listener<PlacesSuggestionDetailsRM>() {
            public void onResponse(PlacesSuggestionDetailsRM placesSuggestionDetailsRM) {
                if (PlacesSuggestionInteractor.this.placesSuggestionListener == null) {
                    return;
                }
                if (placesSuggestionDetailsRM.result != null) {
                    PlacesSuggestionInteractor.this.placesSuggestionListener.onSuggestionDetailsRecieved(placesSuggestionDetailsRM.result);
                } else {
                    PlacesSuggestionInteractor.this.placesSuggestionListener.noDetailsFound();
                }
            }
        };
    }

    private Response.Listener<PlacesSuggestionRM> onSuggestionListReceived() {
        return new Response.Listener<PlacesSuggestionRM>() {
            public void onResponse(PlacesSuggestionRM placesSuggestionRM) {
                if (PlacesSuggestionInteractor.this.placesSuggestionListener == null) {
                    return;
                }
                if (placesSuggestionRM.result.length > 0) {
                    PlacesSuggestionInteractor.this.placesSuggestionListener.onSuggestionRecieved(placesSuggestionRM.result);
                } else {
                    PlacesSuggestionInteractor.this.placesSuggestionListener.onNoSuggestionsRecieved();
                }
            }
        };
    }

    public void getLatLong(String str) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.GETLATLONGFROMSUGGESTION;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{placeid}", "" + str})).setClazz(PlacesSuggestionDetailsRM.class).setListener(onPlaceDetailsRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadPlacesifAvailable(String str) {
        String str2;
        try {
            PlacesSuggestionRequest placesSuggestionRequest = new PlacesSuggestionRequest();
            placesSuggestionRequest.searchText = str;
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) placesSuggestionRequest);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) placesSuggestionRequest);
            }
            JSONObject jSONObject = new JSONObject(str2);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            String str3 = AppUrls.GETPLACESSUGGESTION;
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str3, new String[]{"{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(PlacesSuggestionRM.class).setRequestBody(jSONObject).setListener(onSuggestionListReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (PlacesSuggestionInteractor.this.placesSuggestionListener != null) {
                        PlacesSuggestionInteractor.this.placesSuggestionListener.onServerError(volleyError);
                        if (PlacesSuggestionInteractor.this.placesSuggestionListener != null) {
                            PlacesSuggestionInteractor.this.placesSuggestionListener.onNoSuggestionsRecieved();
                        }
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (PlacesSuggestionInteractor.this.placesSuggestionListener != null) {
                        PlacesSuggestionInteractor.this.placesSuggestionListener.onNetworkError();
                        if (PlacesSuggestionInteractor.this.placesSuggestionListener != null) {
                            PlacesSuggestionInteractor.this.placesSuggestionListener.onNoSuggestionsRecieved();
                        }
                    }
                } else if ((volleyError instanceof AuthFailureError) && PlacesSuggestionInteractor.this.placesSuggestionListener != null) {
                    PlacesSuggestionInteractor.this.placesSuggestionListener.onDataError();
                    if (PlacesSuggestionInteractor.this.placesSuggestionListener != null) {
                        PlacesSuggestionInteractor.this.placesSuggestionListener.onNoSuggestionsRecieved();
                    }
                }
            }
        };
    }

    public void unregister() {
        this.placesSuggestionListener = null;
    }
}
