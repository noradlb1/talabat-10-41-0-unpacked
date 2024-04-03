package library.talabat.mvp.offerslist;

import JsonModels.Response.OffersListRM;
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
import library.talabat.com.talabatlib.CreateApiUrl;

public class OffersInteractor implements IOffersInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public OffersListener offersListener;

    public OffersInteractor(AppVersionProvider appVersionProvider2, OffersListener offersListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.offersListener = offersListener2;
    }

    private Response.Listener<OffersListRM> onOrderListRecieved() {
        return new Response.Listener<OffersListRM>() {
            public void onResponse(OffersListRM offersListRM) {
                if (OffersInteractor.this.offersListener != null) {
                    OffersInteractor.this.offersListener.onOffersListLoaded(offersListRM.result.promotions);
                }
            }
        };
    }

    private Response.Listener<RestaurantDetailsWithDelAreasRM> onRestaurantInfoRecieved() {
        return new Response.Listener<RestaurantDetailsWithDelAreasRM>() {
            public void onResponse(RestaurantDetailsWithDelAreasRM restaurantDetailsWithDelAreasRM) {
                if (OffersInteractor.this.offersListener != null) {
                    OffersListener a11 = OffersInteractor.this.offersListener;
                    RestaurantDetailsWithDelAreasResponseModel restaurantDetailsWithDelAreasResponseModel = restaurantDetailsWithDelAreasRM.result;
                    a11.onRestaurantDetailsLoaded(restaurantDetailsWithDelAreasResponseModel.restaurant, restaurantDetailsWithDelAreasResponseModel.areas, restaurantDetailsWithDelAreasResponseModel.cities);
                }
            }
        };
    }

    public void getRestaurantDetails(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.RESTAURANT_DETAILS_WITH_DELAREAS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restaurantid}", "" + i11})).setClazz(RestaurantDetailsWithDelAreasRM.class).setListener(onRestaurantInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadOffersforCountry(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.OFFERSLIST;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(OffersListRM.class).setListener(onOrderListRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && OffersInteractor.this.offersListener != null) {
                    OffersInteractor.this.offersListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && OffersInteractor.this.offersListener != null) {
                    OffersInteractor.this.offersListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && OffersInteractor.this.offersListener != null) {
                    OffersInteractor.this.offersListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.offersListener = null;
    }
}
