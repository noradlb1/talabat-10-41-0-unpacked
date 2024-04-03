package library.talabat.mvp.home;

import JsonModels.GeoAddressRequest;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;

public class HomeInteractor implements IHomeInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public HomeScreenListener homeScreenListener;
    /* access modifiers changed from: private */
    public LatLng latLng;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public HomeInteractor(HomeScreenListener homeScreenListener2, ITalabatFeatureFlag iTalabatFeatureFlag, AppVersionProvider appVersionProvider2) {
        this.homeScreenListener = homeScreenListener2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.appVersionProvider = appVersionProvider2;
    }

    private Response.Listener<GeoAddressRequest> onGeoAddressRecieved() {
        return new Response.Listener<GeoAddressRequest>() {
            public void onResponse(GeoAddressRequest geoAddressRequest) {
                if (HomeInteractor.this.homeScreenListener != null && geoAddressRequest != null) {
                    if (geoAddressRequest.result != null) {
                        HomeInteractor.this.homeScreenListener.onGeoAddressReceieved(geoAddressRequest.result, HomeInteractor.this.latLng);
                    } else {
                        HomeInteractor.this.homeScreenListener.onReverseGeoAddressError();
                    }
                }
            }
        };
    }

    public void fetchAddressBasedOnLatLng(LatLng latLng2) {
        String str;
        this.latLng = latLng2;
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESSV2;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", "" + latLng2.latitude, "{longitude}", "" + latLng2.longitude, "{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(GeoAddressRequest.class).setListener(onGeoAddressRecieved()).setErrorListener(onCurrenLocationRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onCurrenLocationRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onReverseGeoAddressError();
                }
                if ((volleyError instanceof ServerError) && HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onDataError();
                }
            }
        };
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && HomeInteractor.this.homeScreenListener != null) {
                    HomeInteractor.this.homeScreenListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.homeScreenListener = null;
    }
}
