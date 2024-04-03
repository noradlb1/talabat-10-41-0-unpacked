package library.talabat.mvp.googlemaps;

import JsonModels.GeoAddressRequest;
import JsonModels.GeoPolygonResponse;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.McdMapAddressRequest;
import JsonModels.Response.GeoPolygonRM;
import JsonModels.Response.McdBlockAddressRM;
import JsonModels.Response.McdStoresRM;
import JsonModels.Response.McdStreetAddressRM;
import JsonModels.parser.UniversalGson;
import buisnessmodels.Cart;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;

@Instrumented
public class TalabatMapInteractor implements ITalabatMapInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public TalabatMapListener mapListener;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public TalabatMapInteractor(AppVersionProvider appVersionProvider2, TalabatMapListener talabatMapListener, ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.appVersionProvider = appVersionProvider2;
        this.mapListener = talabatMapListener;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private Response.Listener<GeoPolygonRM> onAreaGeoPolyGonDataReceived() {
        return new Response.Listener<GeoPolygonRM>() {
            public void onResponse(GeoPolygonRM geoPolygonRM) {
                if (TalabatMapInteractor.this.mapListener == null) {
                    return;
                }
                if (geoPolygonRM == null) {
                    TalabatMapInteractor.this.mapListener.onAreGeoPolyGonFailed(false);
                } else if (geoPolygonRM.result != null) {
                    TalabatMapInteractor.this.mapListener.onAreGeoPolyGonCoOrdinatesReceived(TalabatMapInteractor.this.updateGeoPolygon(geoPolygonRM), !TalabatUtils.isNullOrEmpty(geoPolygonRM.result.geoCenterPoint) ? geoPolygonRM.result.geoCenterPoint : "", TalabatMapInteractor.this.validateWithPolygon(geoPolygonRM));
                } else {
                    TalabatMapInteractor.this.mapListener.onAreGeoPolyGonFailed(false);
                }
            }
        };
    }

    private Response.Listener<GeoAddressRequest> onGeoAddressRecieved() {
        return new Response.Listener<GeoAddressRequest>() {
            public void onResponse(GeoAddressRequest geoAddressRequest) {
                if (TalabatMapInteractor.this.mapListener != null) {
                    TalabatMapInteractor.this.mapListener.onGeoAddressRecieved(geoAddressRequest.result);
                }
            }
        };
    }

    private Response.Listener<GeoAddressRequest> onGeoUpdateAddressReceived() {
        return new Response.Listener<GeoAddressRequest>() {
            public void onResponse(GeoAddressRequest geoAddressRequest) {
                if (TalabatMapInteractor.this.mapListener != null) {
                    TalabatMapInteractor.this.mapListener.onUpdateGeoAddressRecieved(geoAddressRequest.result);
                }
            }
        };
    }

    private Response.Listener<McdStreetAddressRM> onMcdAddressConvertReceived() {
        return new Response.Listener<McdStreetAddressRM>() {
            public void onResponse(McdStreetAddressRM mcdStreetAddressRM) {
                if (TalabatMapInteractor.this.mapListener == null) {
                    return;
                }
                if (mcdStreetAddressRM == null) {
                    TalabatMapInteractor.this.mapListener.onMcdKsAddressFailed();
                } else if (mcdStreetAddressRM.result != null) {
                    TalabatMapInteractor.this.mapListener.onMcdKsAddressReceived(mcdStreetAddressRM.result);
                } else {
                    TalabatMapInteractor.this.mapListener.onMcdKsAddressFailed();
                }
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdBlockBranchReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (mcdStoresRM == null) {
                    TalabatMapInteractor.this.mapListener.mcdBranchFailed();
                } else if (mcdStoresRM.result != null) {
                    TalabatMapInteractor.this.mapListener.mcdBranchReceived(mcdStoresRM.result);
                } else {
                    TalabatMapInteractor.this.mapListener.mcdBranchFailed();
                }
            }
        };
    }

    private Response.Listener<McdBlockAddressRM> onMcdBlockReceived() {
        return new Response.Listener<McdBlockAddressRM>() {
            public void onResponse(McdBlockAddressRM mcdBlockAddressRM) {
                if (TalabatMapInteractor.this.mapListener == null) {
                    return;
                }
                if (mcdBlockAddressRM == null) {
                    TalabatMapInteractor.this.mapListener.onMcdBlockFailed();
                } else if (mcdBlockAddressRM.result != null) {
                    TalabatMapInteractor.this.mapListener.onMcdBlockReceived(mcdBlockAddressRM.result);
                } else {
                    TalabatMapInteractor.this.mapListener.onMcdBlockFailed();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public ArrayList<LatLng> updateGeoPolygon(GeoPolygonRM geoPolygonRM) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Double[][] dArr = geoPolygonRM.result.polygonCoordinates;
        if (dArr != null) {
            for (Double[] dArr2 : dArr) {
                arrayList.add(new LatLng(dArr2[1].doubleValue(), dArr2[0].doubleValue()));
            }
            List<LatLng> list = GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints;
            if (list != null && list.size() > 0) {
                GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.clear();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public boolean validateWithPolygon(GeoPolygonRM geoPolygonRM) {
        GeoPolygonResponse geoPolygonResponse = geoPolygonRM.result;
        Double[][] dArr = geoPolygonResponse.polygonCoordinates;
        if (dArr == null) {
            boolean z11 = geoPolygonResponse.validateWithPolygon;
            if (z11) {
                return false;
            }
            return z11;
        } else if (dArr.length > 0) {
            return geoPolygonResponse.validateWithPolygon;
        } else {
            return false;
        }
    }

    public void autoFillAddress(LatLng latLng) {
        String str;
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESSV2;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", "" + latLng.latitude, "{longitude}", "" + latLng.longitude, "{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(GeoAddressRequest.class).setListener(onGeoAddressRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void autoFillAddressGeoUpdate(LatLng latLng) {
        String str;
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESSV2;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", "" + latLng.latitude, "{longitude}", "" + latLng.longitude, "{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(GeoAddressRequest.class).setListener(onGeoUpdateAddressReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void fetchAreaPolygonJsonGeoCenterPoint(int i11, int i12, boolean z11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.AREA_POLYGON;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{areaId}", "" + i11})).setClazz(GeoPolygonRM.class).setListener(onAreaGeoPolyGonDataReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void fetchRestaurantPolygonJson(int i11, int i12, boolean z11) {
        Cart instance = Cart.getInstance();
        if (instance.getRestaurant() != null) {
            ApiHandler.Services callApi = ApiHandler.callApi();
            String str = AppUrls.RESTAURANT_POLYGON;
            callApi.getRestaurantPolygon(CreateApiUrl.createWithParameters(str, new String[]{"{vendorid}", "" + instance.getRestaurant().branchId, "{latitude}", "" + GlobalDataModel.RECENT_LATLONG.getLatitude(), "{longitude}", "" + GlobalDataModel.RECENT_LATLONG.getLongitude()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<GeoPolygonRM>() {
                public void onComplete() {
                }

                public void onError(Throwable th2) {
                    if (TalabatMapInteractor.this.mapListener != null) {
                        TalabatMapInteractor.this.mapListener.onAreGeoPolyGonFailed(false);
                    }
                }

                public void onNext(GeoPolygonRM geoPolygonRM) {
                    if (TalabatMapInteractor.this.mapListener == null) {
                        return;
                    }
                    if (geoPolygonRM == null) {
                        TalabatMapInteractor.this.mapListener.onAreGeoPolyGonFailed(false);
                    } else if (geoPolygonRM.result != null) {
                        TalabatMapInteractor.this.mapListener.onAreGeoPolyGonCoOrdinatesReceived(TalabatMapInteractor.this.updateGeoPolygon(geoPolygonRM), !TalabatUtils.isNullOrEmpty(geoPolygonRM.result.geoCenterPoint) ? geoPolygonRM.result.geoCenterPoint : "", TalabatMapInteractor.this.validateWithPolygon(geoPolygonRM));
                    } else {
                        TalabatMapInteractor.this.mapListener.onAreGeoPolyGonFailed(false);
                    }
                }
            });
        }
    }

    public void getBranchIdFromBlock(McdBranchRequest mcdBranchRequest) {
        String str;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) mcdBranchRequest);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) mcdBranchRequest);
            }
            JSONObject jSONObject = new JSONObject(str);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            String str2 = AppUrls.MCD_BAHRAIN_GET_BRANCH_ID;
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdBlockBranchReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getBranchIdFromStreet(McdBranchRequest mcdBranchRequest) {
        String str;
        String str2;
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            str = AppUrls.MCD_KSA_GET_BRANCH_ID;
        } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
            str = AppUrls.MCD_JORDAN_GET_BRANCH_ID;
        } else {
            str = "";
        }
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) mcdBranchRequest);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) mcdBranchRequest);
            }
            JSONObject jSONObject = new JSONObject(str2);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdBlockBranchReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getMcdBhBlockDetails(McdMapAddressRequest mcdMapAddressRequest) {
        String str;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) mcdMapAddressRequest);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) mcdMapAddressRequest);
            }
            JSONObject jSONObject = new JSONObject(str);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            String str2 = AppUrls.MCD_BAHRAIN_GET_BLOCKS;
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdBlockAddressRM.class).setRequestBody(jSONObject).setListener(onMcdBlockReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getMcdLatLngAddressDetails(McdMapAddressRequest mcdMapAddressRequest) {
        String str;
        String str2;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
                str = AppUrls.MCD_KSA_CONVERT_TO_ADDRESS;
            } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                str = AppUrls.MCD_KSA_CONVERT_TO_ADDRESS_JORDAN;
            } else {
                str = "";
            }
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) mcdMapAddressRequest);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) mcdMapAddressRequest);
            }
            JSONObject jSONObject = new JSONObject(str2);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStreetAddressRM.class).setRequestBody(jSONObject).setListener(onMcdAddressConvertReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && TalabatMapInteractor.this.mapListener != null) {
                    TalabatMapInteractor.this.mapListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && TalabatMapInteractor.this.mapListener != null) {
                    TalabatMapInteractor.this.mapListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && TalabatMapInteractor.this.mapListener != null) {
                    TalabatMapInteractor.this.mapListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.mapListener = null;
    }
}
