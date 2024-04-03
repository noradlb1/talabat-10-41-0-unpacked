package library.talabat.mvp.addressV2;

import JsonModels.AreaPreoloadResponse;
import JsonModels.AreaResponseModel;
import JsonModels.GeoAddressRequest;
import JsonModels.GeoPolygonResponse;
import JsonModels.Response.GeoPolygonRM;
import androidx.annotation.NonNull;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import datamodels.Area;
import datamodels.mappers.OldAreaToAreaMapper;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.com.talabatlib.CreateApiUrl;
import service.ApiHandler;
import x00.a;
import x00.b;
import x00.c;
import x00.d;
import x00.e;
import x00.f;
import x00.g;
import x00.h;
import x00.i;
import x00.j;
import x00.k;
import x00.l;

public class AddressInteractor implements IAddressInteractor {
    private static final String OBSERVABILITY_ATTRIBUTE_ERROR_MESSAGE = "errorMessage";
    private Address address;
    private String addressId;
    /* access modifiers changed from: private */
    public AddressListener addressListener;
    private final AppVersionProvider appVersionProvider;
    private int cityId;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final Scheduler ioScheduler;
    private final LatLngFactory latLngFactory;
    private final MutableLocationConfigurationRepository locationConfigRepository;
    private final Scheduler mainScheduler;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public AddressInteractor(AddressListener addressListener2, CustomerAddressesRepository customerAddressesRepository2, Scheduler scheduler, Scheduler scheduler2, AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, ITalabatFeatureFlag iTalabatFeatureFlag, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, LatLngFactory latLngFactory2) {
        this.addressListener = addressListener2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.locationConfigRepository = mutableLocationConfigurationRepository;
        this.latLngFactory = latLngFactory2;
    }

    private void addAddress(Address address2) {
        this.disposables.add(this.customerAddressesRepository.addAddress(address2).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new i(this), new j(this)));
    }

    private void callAddAddressMicroservice(Address address2) {
        String str = address2.f58343id;
        if (str == null || str.isEmpty()) {
            addAddress(address2);
        } else {
            updateAddress(address2);
        }
    }

    private void callDeleteAddressMicroservice(String str, Function0<Unit> function0) {
        this.disposables.add(this.customerAddressesRepository.deleteAddress(str).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new b(this, function0), new c(this)));
    }

    private LatLng getRecentSelectedLatLng() {
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            if (instance.isLoggedIn() && instance.isLoggedIn() && instance.hasAddresses() && instance.getSelectedCustomerAddress() != null) {
                return this.latLngFactory.createLatLng(instance.getSelectedCustomerAddress().latitude, instance.getSelectedCustomerAddress().longitude);
            }
        }
        return null;
    }

    private void handleDeleteAddressSuccess() {
        AddressListener addressListener2 = this.addressListener;
        if (addressListener2 != null) {
            addressListener2.onAddressDeleted(this.addressId);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addAddress$1(Throwable th2) throws Exception {
        LogManager.logException(th2);
        observeAddAddressMicroserviceFailure(th2);
        AddressListener addressListener2 = this.addressListener;
        if (addressListener2 != null) {
            addressListener2.onAddressMicroserviceError();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$callDeleteAddressMicroservice$5(Function0 function0) throws Exception {
        function0.invoke();
        handleDeleteAddressSuccess();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$callDeleteAddressMicroservice$6(Throwable th2) throws Exception {
        LogManager.logException(th2);
        observeDeleteAddressMicroserviceFailure(th2);
        AddressListener addressListener2 = this.addressListener;
        if (addressListener2 != null) {
            addressListener2.onAddressMicroserviceError();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAreaGeoPolyGonDataReceived$9(GeoPolygonRM geoPolygonRM) {
        String str;
        AddressListener addressListener2 = this.addressListener;
        if (addressListener2 == null) {
            return;
        }
        if (geoPolygonRM.result != null) {
            ArrayList<LatLng> updateGeoPolygon = updateGeoPolygon(geoPolygonRM);
            if (!TalabatUtils.isNullOrEmpty(geoPolygonRM.result.geoCenterPoint)) {
                str = geoPolygonRM.result.geoCenterPoint;
            } else {
                str = "";
            }
            addressListener2.onAreGeoPolyGonCoOrdinatesReceived(updateGeoPolygon, str, validateWithPolygon(geoPolygonRM));
            return;
        }
        addressListener2.onAreGeoPolyGonFailed(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAreaRecieved$2(AreaResponseModel areaResponseModel) {
        ArrayList arrayList = new ArrayList();
        if (this.cityId > 0) {
            for (Area area : areaResponseModel.result.area) {
                if (area.cityId == this.cityId) {
                    arrayList.add(area);
                }
            }
            Area[] areaArr = new Area[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                areaArr[i11] = (Area) arrayList.get(i11);
            }
            AddressListener addressListener2 = this.addressListener;
            if (addressListener2 != null) {
                addressListener2.onAreaReceived(areaArr);
                return;
            }
            return;
        }
        AddressListener addressListener3 = this.addressListener;
        if (addressListener3 != null) {
            addressListener3.onAreaReceived(areaResponseModel.result.area);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGeoAddressRecieved$7(GeoAddressRequest geoAddressRequest) {
        this.addressListener.onGeoAddressRecieved(geoAddressRequest.result);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreloadAreaRecieved$3(AreaPreoloadResponse areaPreoloadResponse) {
        LocationConfig config = this.locationConfigRepository.config();
        OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
        ArrayList arrayList = new ArrayList();
        for (Area apply : areaPreoloadResponse.result) {
            arrayList.add(oldAreaToAreaMapper.apply(apply));
        }
        this.locationConfigRepository.setConfig(config.copy(config.getAddresses(), arrayList, config.getCountry(), config.getCountries(), config.isAddressMicroServiceEnabled(), config.getMetersOfLocationAwareness()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestError$8(VolleyError volleyError) {
        if (volleyError instanceof ServerError) {
            AddressListener addressListener2 = this.addressListener;
            if (addressListener2 != null) {
                addressListener2.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            AddressListener addressListener3 = this.addressListener;
            if (addressListener3 != null) {
                addressListener3.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            AddressListener addressListener4 = this.addressListener;
            if (addressListener4 != null) {
                addressListener4.onDataError();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAddress$0(Throwable th2) throws Exception {
        LogManager.logException(th2);
        observeUpdateAddressMicroserviceFailure(th2);
        AddressListener addressListener2 = this.addressListener;
        if (addressListener2 != null) {
            addressListener2.onAddressMicroserviceError();
        }
    }

    private void observeAddAddressMicroserviceFailure(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", th2.getMessage());
        ObservabilityManager.trackUnExpectedScenario("AddressInteractorAddAddressMicroserviceError", hashMap);
    }

    private void observeDeleteAddressMicroserviceFailure(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", th2.getMessage());
        ObservabilityManager.trackUnExpectedScenario("AddressInteractorDeleteAddressMicroserviceError", hashMap);
    }

    private void observeUpdateAddressMicroserviceFailure(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", th2.getMessage());
        ObservabilityManager.trackUnExpectedScenario("AddressInteractorUpdateAddressMicroserviceError", hashMap);
    }

    /* access modifiers changed from: private */
    public void onAddAddressResult(CustomerAddressesRepository.Result result) {
        if (result instanceof CustomerAddressesRepository.Result.Success) {
            Address address2 = result.getAddress();
            Address address3 = this.address;
            address3.f58343id = address2.f58343id;
            address3.isOldAddreses = address2.isOldAddreses;
            AddressListener addressListener2 = this.addressListener;
            if (addressListener2 != null) {
                addressListener2.onAddressAddSuccess(address2);
            }
        } else if (result instanceof CustomerAddressesRepository.Result.Failed) {
            CustomerAddressesRepository.Result.Failed failed = (CustomerAddressesRepository.Result.Failed) result;
            AddressListener addressListener3 = this.addressListener;
            if (addressListener3 != null) {
                addressListener3.onAddressAddFailed(failed.getResultCode(), failed.getMessage(), failed.getAddress());
            }
        }
    }

    private Response.Listener<GeoPolygonRM> onAreaGeoPolyGonDataReceived() {
        return new f(this);
    }

    private Response.Listener<AreaResponseModel> onAreaRecieved() {
        return new h(this);
    }

    private Response.Listener<GeoAddressRequest> onGeoAddressRecieved() {
        return new a(this);
    }

    private Response.Listener<AreaPreoloadResponse> onPreloadAreaRecieved() {
        if (this.talabatFeatureFlag.getFeatureFlag(LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false)) {
            return new k(this);
        }
        return new l();
    }

    /* access modifiers changed from: private */
    public void onUpdateAddressResult(CustomerAddressesRepository.Result result) {
        if (result instanceof CustomerAddressesRepository.Result.Success) {
            Address address2 = result.getAddress();
            this.address.isOldAddreses = address2.isOldAddreses;
            AddressListener addressListener2 = this.addressListener;
            if (addressListener2 != null) {
                addressListener2.onAddressEditSuccess(address2);
            }
        } else if (result instanceof CustomerAddressesRepository.Result.Failed) {
            CustomerAddressesRepository.Result.Failed failed = (CustomerAddressesRepository.Result.Failed) result;
            AddressListener addressListener3 = this.addressListener;
            if (addressListener3 != null) {
                addressListener3.onAddressEditFailed(failed.getResultCode(), failed.getMessage(), failed.getAddress());
            }
        }
    }

    private void updateAddress(Address address2) {
        this.disposables.add(this.customerAddressesRepository.updateAddress(address2).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new d(this), new e(this)));
    }

    /* access modifiers changed from: private */
    public ArrayList<LatLng> updateGeoPolygon(GeoPolygonRM geoPolygonRM) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Double[][] dArr = geoPolygonRM.result.polygonCoordinates;
        if (dArr != null) {
            for (Double[] dArr2 : dArr) {
                arrayList.add(this.latLngFactory.createLatLng(dArr2[1].doubleValue(), dArr2[0].doubleValue()));
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

    public void autoFillAddress(double d11, double d12) {
        String str;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESS;
        }
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", "" + d11, "{longitude}", "" + d12, "{countryid}", "" + this.configurationLocalRepository.selectedCountry().getCountryId()})).setClazz(GeoAddressRequest.class).setListener(onGeoAddressRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void deleteAddress(String str, Function0<Unit> function0) {
        this.addressId = str;
        callDeleteAddressMicroservice(str, function0);
    }

    public void fetchAreaPolygonJson(int i11, int i12) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.AREA_POLYGON;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{areaId}", "" + i11})).setClazz(GeoPolygonRM.class).setListener(onAreaGeoPolyGonDataReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void fetchRestaurantPolygonJson(int i11, int i12) {
        Cart instance = Cart.getInstance();
        if (instance.getRestaurant() != null) {
            ApiHandler.Services callApi = ApiHandler.callApi();
            String str = AppUrls.RESTAURANT_POLYGON;
            callApi.getRestaurantPolygon(CreateApiUrl.createWithParameters(str, new String[]{"{vendorid}", "" + instance.getRestaurant().branchId, "{latitude}", "" + getRecentSelectedLatLng().getLatitude(), "{longitude}", "" + getRecentSelectedLatLng().getLongitude()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<GeoPolygonRM>() {
                public void onComplete() {
                }

                public void onError(@NonNull Throwable th2) {
                }

                public void onNext(@NonNull GeoPolygonRM geoPolygonRM) {
                    if (AddressInteractor.this.addressListener == null) {
                        return;
                    }
                    if (geoPolygonRM.result != null) {
                        AddressInteractor.this.addressListener.onAreGeoPolyGonCoOrdinatesReceived(AddressInteractor.this.updateGeoPolygon(geoPolygonRM), !TalabatUtils.isNullOrEmpty(geoPolygonRM.result.geoCenterPoint) ? geoPolygonRM.result.geoCenterPoint : "", AddressInteractor.this.validateWithPolygon(geoPolygonRM));
                    } else {
                        AddressInteractor.this.addressListener.onAreGeoPolyGonFailed(false);
                    }
                }
            });
        }
    }

    public void loadAreas(int i11) {
        this.cityId = i11;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETAREAS + this.configurationLocalRepository.selectedCountry().getCountryId() + "/" + i11).setClazz(AreaResponseModel.class).setListener(onAreaRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadAreasForCountry(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETCOUNTRYAREAS + this.configurationLocalRepository.selectedCountry().getCountryId()).setClazz(AreaPreoloadResponse.class).setListener(onPreloadAreaRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new g(this);
    }

    public void postAddress(Address address2) {
        this.address = address2;
        callAddAddressMicroservice(address2);
    }

    public void unregister() {
        this.addressListener = null;
        this.disposables.dispose();
    }
}
