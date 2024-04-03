package library.talabat.mvp.homemap;

import JsonModels.GeoAddressRequest;
import JsonModels.GoogleAreaResponse;
import JsonModels.ReorderAreasResponse;
import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.Response.AddAddressRM;
import JsonModels.Response.GoogleAreaRM;
import JsonModels.parser.UniversalGson;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepositoryKt;
import datamodels.Country;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import j10.a;
import j10.b;
import j10.c;
import j10.d;
import j10.e;
import j10.f;
import j10.g;
import j10.h;
import j10.i;
import j10.j;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.extensions.DisposableKt;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;

@Instrumented
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\u001eJ\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0+H\u0002J\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002020+H\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002040+H\u0002J\u0012\u00105\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u001eH\u0016J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020<H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Llibrary/talabat/mvp/homemap/IHomeMapInteractor;", "homeMapListener", "Llibrary/talabat/mvp/homemap/HomeMapListener;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "appInfoRepository", "Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatExperiments", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "(Llibrary/talabat/mvp/homemap/HomeMapListener;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationLocalRepository;)V", "cityToOldCityMapper", "Ldatamodels/mappers/CityToOldCityMapper;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "countryToOldCountryMapper", "Ldatamodels/mappers/CountryToOldCountryMapper;", "getReoderAreas", "", "orderId", "", "reorderResId", "", "initialiseCountryPreferences", "loadAppinitCountrySpecficData", "selectedCountry", "Ldatamodels/Country;", "locationToArea", "latlng", "Lcom/google/android/gms/maps/model/LatLng;", "onGoogleAreaReceived", "Lcom/android/volley/Response$Listener;", "LJsonModels/Response/GoogleAreaRM;", "onReorderAreasRecieved", "LJsonModels/ReorderAreasResponse;", "onRequestError", "Lcom/android/volley/Response$ErrorListener;", "onReverseGeoAreaReceived", "LJsonModels/GeoAddressRequest;", "onUpdateResponse", "LJsonModels/Response/AddAddressRM;", "reverseGeoCoding", "reverseGeoCodingBasedRestaurant", "restGeoReverseCodingRequest", "LJsonModels/Request/RestGeoReverseCodingRequest;", "unregister", "updateAddress", "userSelectedAddressCp", "Lcom/talabat/domain/address/Address;", "updateAddressBackGround", "updateAddressLegacy", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapInteractor implements IGlobalInteractor, IHomeMapInteractor {
    @NotNull
    private final AppInfoRepository appInfoRepository;
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final CityToOldCityMapper cityToOldCityMapper;
    @NotNull
    private final CompositeDisposable compositeDisposable;
    @NotNull
    private final CountryToOldCountryMapper countryToOldCountryMapper;
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    /* access modifiers changed from: private */
    @Nullable
    public HomeMapListener homeMapListener;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final Scheduler mainScheduler;
    @NotNull
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @NotNull
    private final ITalabatExperiment talabatExperiments;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public HomeMapInteractor(@NotNull HomeMapListener homeMapListener2, @NotNull CustomerAddressesRepository customerAddressesRepository2, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull AppInfoRepository appInfoRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull AppVersionProvider appVersionProvider2, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(homeMapListener2, "homeMapListener");
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        Intrinsics.checkNotNullParameter(appInfoRepository2, "appInfoRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiments");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository2, "mutableConfigurationLocalRepository");
        this.customerAddressesRepository = customerAddressesRepository2;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.appInfoRepository = appInfoRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.talabatExperiments = iTalabatExperiment;
        this.appVersionProvider = appVersionProvider2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.compositeDisposable = new CompositeDisposable();
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.homeMapListener = homeMapListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppinitCountrySpecficData$lambda-3  reason: not valid java name */
    public static final void m7885loadAppinitCountrySpecficData$lambda3(HomeMapInteractor homeMapInteractor) {
        Intrinsics.checkNotNullParameter(homeMapInteractor, "this$0");
        homeMapInteractor.initialiseCountryPreferences();
        HomeMapListener homeMapListener2 = homeMapInteractor.homeMapListener;
        if (homeMapListener2 != null) {
            homeMapListener2.onCountrySpecificDataLoaded();
        }
        LogManager.info("HomeMapInteractor - AppInfo Success");
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppinitCountrySpecficData$lambda-4  reason: not valid java name */
    public static final void m7886loadAppinitCountrySpecficData$lambda4(HomeMapInteractor homeMapInteractor, Throwable th2) {
        Intrinsics.checkNotNullParameter(homeMapInteractor, "this$0");
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("HomeMapInteractorAppInfoError", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
        HomeMapListener homeMapListener2 = homeMapInteractor.homeMapListener;
        if (homeMapListener2 != null) {
            homeMapListener2.onNetworkError();
        }
    }

    private final Response.Listener<GoogleAreaRM> onGoogleAreaReceived() {
        return new i(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onGoogleAreaReceived$lambda-0  reason: not valid java name */
    public static final void m7887onGoogleAreaReceived$lambda0(HomeMapInteractor homeMapInteractor, GoogleAreaRM googleAreaRM) {
        Intrinsics.checkNotNullParameter(homeMapInteractor, "this$0");
        HomeMapListener homeMapListener2 = homeMapInteractor.homeMapListener;
        if (homeMapListener2 != null) {
            GoogleAreaResponse googleAreaResponse = googleAreaRM.result;
            homeMapListener2.locationToAddressResult(googleAreaResponse.msg, googleAreaResponse.address, googleAreaResponse.area);
        }
    }

    private final Response.Listener<ReorderAreasResponse> onReorderAreasRecieved() {
        return new e(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onReorderAreasRecieved$lambda-2  reason: not valid java name */
    public static final void m7888onReorderAreasRecieved$lambda2(HomeMapInteractor homeMapInteractor, ReorderAreasResponse reorderAreasResponse) {
        Intrinsics.checkNotNullParameter(homeMapInteractor, "this$0");
        HomeMapListener homeMapListener2 = homeMapInteractor.homeMapListener;
        if (homeMapListener2 != null && homeMapListener2 != null) {
            homeMapListener2.onReorderAreasRecieved(reorderAreasResponse.result);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestError$lambda-8  reason: not valid java name */
    public static final void m7889onRequestError$lambda8(HomeMapInteractor homeMapInteractor, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(homeMapInteractor, "this$0");
        if (volleyError instanceof ServerError) {
            HomeMapListener homeMapListener2 = homeMapInteractor.homeMapListener;
            if (homeMapListener2 != null) {
                homeMapListener2.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            HomeMapListener homeMapListener3 = homeMapInteractor.homeMapListener;
            if (homeMapListener3 != null) {
                homeMapListener3.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            HomeMapListener homeMapListener4 = homeMapInteractor.homeMapListener;
            if (homeMapListener4 != null) {
                homeMapListener4.onDataError();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    private final Response.Listener<GeoAddressRequest> onReverseGeoAreaReceived() {
        return new c(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onReverseGeoAreaReceived$lambda-1  reason: not valid java name */
    public static final void m7890onReverseGeoAreaReceived$lambda1(HomeMapInteractor homeMapInteractor, GeoAddressRequest geoAddressRequest) {
        Intrinsics.checkNotNullParameter(homeMapInteractor, "this$0");
        HomeMapListener homeMapListener2 = homeMapInteractor.homeMapListener;
        if (homeMapListener2 != null) {
            homeMapListener2.reverseGeocodingResult(geoAddressRequest.result);
        }
    }

    private final Response.Listener<AddAddressRM> onUpdateResponse() {
        return new j();
    }

    /* access modifiers changed from: private */
    /* renamed from: onUpdateResponse$lambda-9  reason: not valid java name */
    public static final void m7891onUpdateResponse$lambda9(AddAddressRM addAddressRM) {
    }

    private final void updateAddress(Address address) {
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        Disposable subscribe = this.customerAddressesRepository.updateAddress(address).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).doOnError(new f()).subscribe(new g(), new h());
        Intrinsics.checkNotNullExpressionValue(subscribe, "customerAddressesReposit…ption(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-5  reason: not valid java name */
    public static final void m7892updateAddress$lambda5(Throwable th2) {
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("HomeMapInteractorUpdateAddressBackGroundError", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-6  reason: not valid java name */
    public static final void m7893updateAddress$lambda6(CustomerAddressesRepository.Result result) {
        LogManager.debug("Address update in background successful");
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-7  reason: not valid java name */
    public static final void m7894updateAddress$lambda7(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    private final void updateAddressLegacy(Address address) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e11) {
            LogManager.logException(e11);
            jSONObject = null;
        }
        GsonRequest.Builder<AddAddressRM> errorListener = new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.UPDATE_ADDRESS_WITH_LAT_LNG).setClazz(AddAddressRM.class).setRequestBody(jSONObject).setListener(onUpdateResponse()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    public void getReoderAreas(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        GsonRequest.Builder<ReorderAreasResponse> errorListener = new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.REORDERARES, new String[]{"{orderid}", str})).setClazz(ReorderAreasResponse.class).setListener(onReorderAreasRecieved()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialiseCountryPreferences() {
        /*
            r5 = this;
            com.talabat.configuration.location.LocationConfigurationRepository r0 = r5.locationConfigRepository
            java.util.List r0 = r0.countries()
            com.talabat.configuration.MutableConfigurationLocalRepository r1 = r5.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()
            int r2 = r1.getCountryId()
            if (r2 <= 0) goto L_0x0037
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008e
            java.lang.Object r2 = r0.next()
            com.talabat.configuration.location.Country r2 = (com.talabat.configuration.location.Country) r2
            com.talabat.configuration.country.Country r3 = r2.getCountry()
            int r3 = r3.getCountryId()
            int r4 = r1.getCountryId()
            if (r3 != r4) goto L_0x0016
            datamodels.mappers.CountryToOldCountryMapper r0 = r5.countryToOldCountryMapper
            datamodels.Country r0 = r0.apply((com.talabat.configuration.location.Country) r2)
            goto L_0x008f
        L_0x0037:
            com.talabat.configuration.location.LocationConfigurationRepository r2 = r5.locationConfigRepository
            com.talabat.configuration.location.LocationConfig r2 = r2.config()
            com.talabat.configuration.country.Country r2 = r2.getCountry()
            int r2 = r2.getCountryId()
            if (r2 <= 0) goto L_0x008e
            java.util.Iterator r0 = r0.iterator()
        L_0x004b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x008e
            java.lang.Object r3 = r0.next()
            com.talabat.configuration.location.Country r3 = (com.talabat.configuration.location.Country) r3
            com.talabat.configuration.country.Country r4 = r3.getCountry()
            int r4 = r4.getCountryId()
            if (r4 != r2) goto L_0x004b
            datamodels.mappers.CountryToOldCountryMapper r0 = r5.countryToOldCountryMapper
            datamodels.Country r0 = r0.apply((com.talabat.configuration.location.Country) r3)
            com.talabat.configuration.MutableConfigurationLocalRepository r2 = r5.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r4 = r3.getCountry()
            int r4 = r4.getCountryId()
            r2.setSelectedCountry(r4)
            com.talabat.configuration.country.Country r2 = r3.getCountry()
            java.lang.String r2 = r2.getCountryName()
            com.talabat.helpers.GlobalDataModel.SelectedCountryName = r2
            library.talabat.mvp.homemap.HomeMapListener r2 = r5.homeMapListener
            if (r2 == 0) goto L_0x008f
            if (r2 == 0) goto L_0x008f
            int r1 = r1.getCountryId()
            java.lang.String r3 = com.talabat.helpers.GlobalDataModel.SelectedCountryName
            r2.saveCountryInPrefs(r1, r3)
            goto L_0x008f
        L_0x008e:
            r0 = 0
        L_0x008f:
            if (r0 == 0) goto L_0x009e
            buisnessmodels.TalabatFormatter r1 = buisnessmodels.TalabatFormatter.getInstance()
            java.lang.String r2 = r0.currencySymbol
            int r3 = r0.numOfDecimalPlaces
            int r0 = r0.f13845id
            r1.setFormat(r2, r3, r0)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.homemap.HomeMapInteractor.initialiseCountryPreferences():void");
    }

    public void loadAppinitCountrySpecficData(@Nullable Country country) {
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        Disposable subscribe = AppInfoRepositoryKt.fetchAppInfoCompletable(this.appInfoRepository, GlobalDataModel.SelectedCountryId).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "appInfoRepository\n      …workError()\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
    }

    public void locationToArea(@Nullable LatLng latLng) {
        Double d11;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETAREAFROMCODINATES;
        String[] strArr = new String[6];
        strArr[0] = "{latitude}";
        Double d12 = null;
        if (latLng != null) {
            d11 = Double.valueOf(latLng.latitude);
        } else {
            d11 = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d11);
        strArr[1] = sb2.toString();
        strArr[2] = "{longitude}";
        if (latLng != null) {
            d12 = Double.valueOf(latLng.longitude);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(d12);
        strArr[3] = sb3.toString();
        strArr[4] = "{countryid}";
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i11);
        strArr[5] = sb4.toString();
        GsonRequest.Builder<GoogleAreaRM> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, strArr)).setClazz(GoogleAreaRM.class).setListener(onGoogleAreaReceived()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    @NotNull
    public final Response.ErrorListener onRequestError() {
        return new d(this);
    }

    public void reverseGeoCoding(@Nullable LatLng latLng) {
        String str;
        Double d11;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESSV2;
        }
        String[] strArr = new String[6];
        strArr[0] = "{latitude}";
        Double d12 = null;
        if (latLng != null) {
            d11 = Double.valueOf(latLng.latitude);
        } else {
            d11 = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d11);
        strArr[1] = sb2.toString();
        strArr[2] = "{longitude}";
        if (latLng != null) {
            d12 = Double.valueOf(latLng.longitude);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(d12);
        strArr[3] = sb3.toString();
        strArr[4] = "{countryid}";
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i11);
        strArr[5] = sb4.toString();
        GsonRequest.Builder<GeoAddressRequest> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, strArr)).setClazz(GeoAddressRequest.class).setListener(onReverseGeoAreaReceived()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    public void reverseGeoCodingBasedRestaurant(@NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest) {
        Intrinsics.checkNotNullParameter(restGeoReverseCodingRequest, "restGeoReverseCodingRequest");
        ApiHandler.callApi().getResBasedGeoReverseCoding(AppUrls.GET_GEO_ADDRESS_BASED_RES_BRANCH, restGeoReverseCodingRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new HomeMapInteractor$reverseGeoCodingBasedRestaurant$1(this));
    }

    public void unregister() {
        this.compositeDisposable.dispose();
        this.homeMapListener = null;
    }

    public void updateAddressBackGround(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "userSelectedAddressCp");
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(this.talabatExperiments, TalabatExperimentConstants.CAN_USE_NEW_MICRO_SERVICE_FOR_ADDRESS_ACTIONS, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            updateAddress(address);
        } else {
            updateAddressLegacy(address);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeMapInteractor(library.talabat.mvp.homemap.HomeMapListener r14, com.talabat.user.address.domain.repository.CustomerAddressesRepository r15, io.reactivex.Scheduler r16, io.reactivex.Scheduler r17, com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository r18, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r19, com.talabat.core.experiment.domain.ITalabatExperiment r20, com.talabat.configuration.discovery.AppVersionProvider r21, com.talabat.configuration.location.LocationConfigurationRepository r22, com.talabat.configuration.MutableConfigurationLocalRepository r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24 & 4
            if (r0 == 0) goto L_0x000f
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r1 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            goto L_0x0011
        L_0x000f:
            r5 = r16
        L_0x0011:
            r0 = r24 & 8
            if (r0 == 0) goto L_0x0020
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6 = r0
            goto L_0x0022
        L_0x0020:
            r6 = r17
        L_0x0022:
            r2 = r13
            r3 = r14
            r4 = r15
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.homemap.HomeMapInteractor.<init>(library.talabat.mvp.homemap.HomeMapListener, com.talabat.user.address.domain.repository.CustomerAddressesRepository, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.core.experiment.domain.ITalabatExperiment, com.talabat.configuration.discovery.AppVersionProvider, com.talabat.configuration.location.LocationConfigurationRepository, com.talabat.configuration.MutableConfigurationLocalRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
