package library.talabat.mvp.homemapsearch;

import JsonModels.Request.PlacesSuggestionRequest;
import JsonModels.Response.PlacesSuggestionDetailsRM;
import JsonModels.Response.PlacesSuggestionRM;
import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
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
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l10.a;
import l10.b;
import l10.c;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Llibrary/talabat/mvp/homemapsearch/GooglePlaceInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Llibrary/talabat/mvp/homemapsearch/IGooglePlaceInteractor;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "googlePlaceListener", "Llibrary/talabat/mvp/homemapsearch/GooglePlaceListener;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Llibrary/talabat/mvp/homemapsearch/GooglePlaceListener;)V", "placeName", "", "getLatLong", "", "placeId", "loadPlacesifAvailable", "keyword", "onPlaceDetailsRecieved", "Lcom/android/volley/Response$Listener;", "LJsonModels/Response/PlacesSuggestionDetailsRM;", "onRequestError", "Lcom/android/volley/Response$ErrorListener;", "onSuggestionListReceived", "LJsonModels/Response/PlacesSuggestionRM;", "unregister", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GooglePlaceInteractor implements IGlobalInteractor, IGooglePlaceInteractor {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @Nullable
    private GooglePlaceListener googlePlaceListener;
    @NotNull
    private String placeName = "";

    public GooglePlaceInteractor(@NotNull AppVersionProvider appVersionProvider2, @NotNull GooglePlaceListener googlePlaceListener2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(googlePlaceListener2, "googlePlaceListener");
        this.appVersionProvider = appVersionProvider2;
        this.googlePlaceListener = googlePlaceListener2;
    }

    private final Response.Listener<PlacesSuggestionDetailsRM> onPlaceDetailsRecieved() {
        return new b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onPlaceDetailsRecieved$lambda-1  reason: not valid java name */
    public static final void m7896onPlaceDetailsRecieved$lambda1(GooglePlaceInteractor googlePlaceInteractor, PlacesSuggestionDetailsRM placesSuggestionDetailsRM) {
        Intrinsics.checkNotNullParameter(googlePlaceInteractor, "this$0");
        SuggestedPlaceDetails suggestedPlaceDetails = placesSuggestionDetailsRM.result;
        if (suggestedPlaceDetails != null) {
            GooglePlaceListener googlePlaceListener2 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener2 != null) {
                googlePlaceListener2.onSuggestionDetailsRecieved(suggestedPlaceDetails, googlePlaceInteractor.placeName);
                return;
            }
            return;
        }
        GooglePlaceListener googlePlaceListener3 = googlePlaceInteractor.googlePlaceListener;
        if (googlePlaceListener3 != null) {
            googlePlaceListener3.noDetailsFound();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestError$lambda-2  reason: not valid java name */
    public static final void m7897onRequestError$lambda2(GooglePlaceInteractor googlePlaceInteractor, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(googlePlaceInteractor, "this$0");
        if (volleyError instanceof ServerError) {
            GooglePlaceListener googlePlaceListener2 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener2 != null) {
                googlePlaceListener2.onServerError(volleyError);
            }
            GooglePlaceListener googlePlaceListener3 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener3 != null) {
                googlePlaceListener3.onNoSuggestionsRecieved();
            }
        } else if (volleyError instanceof NetworkError) {
            GooglePlaceListener googlePlaceListener4 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener4 != null) {
                googlePlaceListener4.onNetworkError();
            }
            GooglePlaceListener googlePlaceListener5 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener5 != null) {
                googlePlaceListener5.onNoSuggestionsRecieved();
            }
        } else if (volleyError instanceof AuthFailureError) {
            GooglePlaceListener googlePlaceListener6 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener6 != null) {
                googlePlaceListener6.onDataError();
            }
            GooglePlaceListener googlePlaceListener7 = googlePlaceInteractor.googlePlaceListener;
            if (googlePlaceListener7 != null) {
                googlePlaceListener7.onNoSuggestionsRecieved();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    private final Response.Listener<PlacesSuggestionRM> onSuggestionListReceived() {
        return new c(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuggestionListReceived$lambda-0  reason: not valid java name */
    public static final void m7898onSuggestionListReceived$lambda0(GooglePlaceInteractor googlePlaceInteractor, PlacesSuggestionRM placesSuggestionRM) {
        Intrinsics.checkNotNullParameter(googlePlaceInteractor, "this$0");
        GooglePlaceListener googlePlaceListener2 = googlePlaceInteractor.googlePlaceListener;
        if (googlePlaceListener2 != null) {
            PlacesSuggestionResponse[] placesSuggestionResponseArr = placesSuggestionRM.result;
            if (placesSuggestionResponseArr.length > 0) {
                if (googlePlaceListener2 != null) {
                    Intrinsics.checkNotNullExpressionValue(placesSuggestionResponseArr, "response.result");
                    googlePlaceListener2.onSuggestionRecieved(placesSuggestionResponseArr);
                }
            } else if (googlePlaceListener2 != null) {
                googlePlaceListener2.onNoSuggestionsRecieved();
            }
        }
    }

    public void getLatLong(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "placeName");
        this.placeName = str2;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str3 = AppUrls.GETLATLONGFROMSUGGESTION;
        GsonRequest.Builder<PlacesSuggestionDetailsRM> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str3, new String[]{"{placeid}", str})).setClazz(PlacesSuggestionDetailsRM.class).setListener(onPlaceDetailsRecieved()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    public void loadPlacesifAvailable(@NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "keyword");
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
            int i11 = GlobalDataModel.SelectedCountryId;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i11);
            GsonRequest.Builder<PlacesSuggestionRM> errorListener = method.setUrl(CreateApiUrl.createWithParameters(str3, new String[]{"{countryid}", sb2.toString()})).setClazz(PlacesSuggestionRM.class).setRequestBody(jSONObject).setListener(onSuggestionListReceived()).setErrorListener(onRequestError());
            String appVersion = this.appVersionProvider.appVersion();
            if (appVersion == null) {
                appVersion = "";
            }
            TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
        } catch (JSONException e11) {
            e11.printStackTrace();
        } catch (UnsupportedEncodingException e12) {
            e12.printStackTrace();
        }
    }

    @NotNull
    public final Response.ErrorListener onRequestError() {
        return new a(this);
    }

    public void unregister() {
        this.googlePlaceListener = null;
    }
}
