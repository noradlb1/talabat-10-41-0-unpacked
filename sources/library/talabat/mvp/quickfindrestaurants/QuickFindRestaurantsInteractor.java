package library.talabat.mvp.quickfindrestaurants;

import JsonModels.QuickFindRestaurantsResponse;
import JsonModels.Response.RestaurantDetailsWithDelAreasRM;
import JsonModels.RestaurantDetailsWithDelAreasResponseModel;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import datamodels.Restaurant;
import java.util.ArrayList;
import library.talabat.com.talabatlib.CreateApiUrl;

public class QuickFindRestaurantsInteractor implements IQuickFindRestaurantsInteractor {
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public QuickFindRestaruantsListener f26808b;

    public QuickFindRestaurantsInteractor(AppVersionProvider appVersionProvider2, QuickFindRestaruantsListener quickFindRestaruantsListener) {
        this.appVersionProvider = appVersionProvider2;
        this.f26808b = quickFindRestaruantsListener;
    }

    private Response.Listener<RestaurantDetailsWithDelAreasRM> onRestaurantInfoRecieved() {
        return new Response.Listener<RestaurantDetailsWithDelAreasRM>() {
            public void onResponse(RestaurantDetailsWithDelAreasRM restaurantDetailsWithDelAreasRM) {
                QuickFindRestaruantsListener quickFindRestaruantsListener = QuickFindRestaurantsInteractor.this.f26808b;
                if (quickFindRestaruantsListener != null) {
                    RestaurantDetailsWithDelAreasResponseModel restaurantDetailsWithDelAreasResponseModel = restaurantDetailsWithDelAreasRM.result;
                    quickFindRestaruantsListener.onRestaurantDetailsLoaded(restaurantDetailsWithDelAreasResponseModel.restaurant, restaurantDetailsWithDelAreasResponseModel.areas, restaurantDetailsWithDelAreasResponseModel.cities);
                }
            }
        };
    }

    private Response.Listener<QuickFindRestaurantsResponse> onResultRecieved() {
        return new Response.Listener<QuickFindRestaurantsResponse>() {
            public void onResponse(QuickFindRestaurantsResponse quickFindRestaurantsResponse) {
                QuickFindRestaruantsListener quickFindRestaruantsListener = QuickFindRestaurantsInteractor.this.f26808b;
                if (quickFindRestaruantsListener != null) {
                    quickFindRestaruantsListener.onRestaurantListLoaded(quickFindRestaurantsResponse.result);
                }
            }
        };
    }

    public ArrayList<Restaurant> getAllRestaurantsForCountry(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.QUICKFINDRESTAURANTS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(QuickFindRestaurantsResponse.class).setListener(onResultRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        return null;
    }

    public void getRestaurantDetails(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.RESTAURANT_DETAILS_WITH_DELAREAS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restaurantid}", "" + i11})).setClazz(RestaurantDetailsWithDelAreasRM.class).setListener(onRestaurantInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                QuickFindRestaruantsListener quickFindRestaruantsListener;
                QuickFindRestaruantsListener quickFindRestaruantsListener2;
                QuickFindRestaruantsListener quickFindRestaruantsListener3;
                if ((volleyError instanceof ServerError) && (quickFindRestaruantsListener3 = QuickFindRestaurantsInteractor.this.f26808b) != null) {
                    quickFindRestaruantsListener3.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && (quickFindRestaruantsListener2 = QuickFindRestaurantsInteractor.this.f26808b) != null) {
                    quickFindRestaruantsListener2.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && (quickFindRestaruantsListener = QuickFindRestaurantsInteractor.this.f26808b) != null) {
                    quickFindRestaruantsListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.f26808b = null;
    }
}
