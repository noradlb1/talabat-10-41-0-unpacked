package library.talabat.mvp.homemap;

import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.RestGeoAddressResult;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import buisnessmodels.Cart;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import datamodels.Area;
import datamodels.Country;
import datamodels.DeliveryArea;
import datamodels.SmsVerificationInstance;
import datamodels.mappers.AreaToOldAreaMapper;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import io.reactivex.Scheduler;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tracking.AppTracker;

@Instrumented
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002:\u0002¥\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u001f\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020@2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016¢\u0006\u0002\u0010_J5\u0010`\u001a\u00020[2\b\u0010a\u001a\u0004\u0018\u00010@2\b\u0010b\u001a\u0004\u0018\u00010@2\b\u0010c\u001a\u0004\u0018\u00010^2\b\u0010d\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0002\u0010eJ\u0018\u0010f\u001a\u00020[2\u0006\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020\u0015H\u0016J\"\u0010i\u001a\u00020[2\u0006\u0010j\u001a\u00020\u00152\b\u0010k\u001a\u0004\u0018\u00010@2\u0006\u0010l\u001a\u00020\u0015H\u0016J*\u0010m\u001a\u00020[2\u0006\u0010n\u001a\u00020\u00152\b\u0010k\u001a\u0004\u0018\u00010@2\u0006\u0010o\u001a\u00020F2\u0006\u0010p\u001a\u00020LH\u0016J\u0010\u0010q\u001a\u00020[2\u0006\u0010p\u001a\u00020LH\u0016J\u0010\u0010r\u001a\u00020[2\u0006\u0010s\u001a\u00020FH\u0002J\u0012\u0010t\u001a\u00020[2\b\u0010k\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010u\u001a\u00020[2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001c\u0010v\u001a\u0004\u0018\u00010F2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010w\u001a\u00020FH\u0002J\u0010\u0010x\u001a\u00020[2\u0006\u0010y\u001a\u00020FH\u0016J&\u0010z\u001a\u00020[2\b\u0010{\u001a\u0004\u0018\u00010F2\b\u0010|\u001a\u0004\u0018\u00010(2\b\u0010}\u001a\u0004\u0018\u00010~H\u0016J2\u0010\u001a\u00020[2\u0006\u00109\u001a\u00020\u00152\u0006\u0010W\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020F2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020[H\u0016J\t\u0010\u0001\u001a\u00020[H\u0016J\t\u0010\u0001\u001a\u00020[H\u0016J\t\u0010\u0001\u001a\u00020[H\u0016J$\u0010\u0001\u001a\u00020[2\u0013\u0010\u0001\u001a\u000e\u0012\u0007\b\u0001\u0012\u00030\u0001\u0018\u00010\u0001H\u0016¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001b\u0010\u0001\u001a\u00020[2\u0006\u0010n\u001a\u00020\u00152\b\u0010k\u001a\u0004\u0018\u00010@H\u0016J\t\u0010\u0001\u001a\u00020[H\u0016J\u0015\u0010\u0001\u001a\u00020[2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J\u0011\u0010\u0001\u001a\u00020[2\u0006\u00109\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020[H\u0002J\u0012\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J\u0007\u0010\u0001\u001a\u00020[J\u001c\u0010\u0001\u001a\u00020[2\b\u0010k\u001a\u0004\u0018\u00010@2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010\u0001\u001a\u00020[2\t\u0010\u0001\u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020L2\b\u0010o\u001a\u0004\u0018\u00010FH\u0016J\"\u0010\u0001\u001a\u00020[2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010p\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020FH\u0002J\u0012\u0010 \u0001\u001a\u00020[2\u0007\u0010¡\u0001\u001a\u00020(H\u0016J\u0011\u0010¢\u0001\u001a\u00020[2\u0006\u0010;\u001a\u00020\u0015H\u0016J\"\u0010£\u0001\u001a\u00020[2\u0007\u0010¤\u0001\u001a\u00020\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010K\u001a\u00020LH\u0016R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u001a\u00109\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R\u001a\u0010;\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010\u0019R\u001a\u0010=\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010H\"\u0004\bY\u0010J¨\u0006¦\u0001"}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapPresenter;", "Llibrary/talabat/mvp/homemap/IHomeMapPresenter;", "Llibrary/talabat/mvp/homemap/HomeMapListener;", "homeMapView", "Llibrary/talabat/mvp/homemap/HomeMapView;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "appInfoRepository", "Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "talabFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatExperiments", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "(Llibrary/talabat/mvp/homemap/HomeMapView;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/configuration/MutableConfigurationLocalRepository;)V", "IsFromReOrder", "", "getIsFromReOrder", "()Z", "setIsFromReOrder", "(Z)V", "IsIgnoreSaveLoc", "getIsIgnoreSaveLoc", "setIsIgnoreSaveLoc", "cityToOldCityMapper", "Ldatamodels/mappers/CityToOldCityMapper;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "countryToOldCountryMapper", "Ldatamodels/mappers/CountryToOldCountryMapper;", "geoAddress", "Lcom/talabat/domain/address/Address;", "getGeoAddress", "()Lcom/talabat/domain/address/Address;", "setGeoAddress", "(Lcom/talabat/domain/address/Address;)V", "homeMapInteractor", "Llibrary/talabat/mvp/homemap/IHomeMapInteractor;", "getHomeMapInteractor", "()Llibrary/talabat/mvp/homemap/IHomeMapInteractor;", "setHomeMapInteractor", "(Llibrary/talabat/mvp/homemap/IHomeMapInteractor;)V", "getHomeMapView", "()Llibrary/talabat/mvp/homemap/HomeMapView;", "setHomeMapView", "(Llibrary/talabat/mvp/homemap/HomeMapView;)V", "isGpsStatusTiggered", "setGpsStatusTiggered", "isIgnoreCurrentLocation", "setIgnoreCurrentLocation", "isMapCameraMoving", "setMapCameraMoving", "isPreLocationfetch", "setPreLocationfetch", "mainLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "getMainLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "setMainLatLng", "(Lcom/google/android/gms/maps/model/LatLng;)V", "reorderId", "", "getReorderId", "()Ljava/lang/String;", "setReorderId", "(Ljava/lang/String;)V", "reorderResId", "", "getReorderResId", "()I", "setReorderResId", "(I)V", "selectedCountry", "Ldatamodels/Country;", "getSelectedCountry", "()Ldatamodels/Country;", "setSelectedCountry", "(Ldatamodels/Country;)V", "userSelectedAddress", "getUserSelectedAddress", "setUserSelectedAddress", "FromCurrentLocationClick", "", "latLng", "mZoomLevel", "", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Float;)V", "LocationReceived", "currentLatLng", "userSavedTempLocation", "userSavedTempZoomLevel", "areaCenterLatLng", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Float;Lcom/google/android/gms/maps/model/LatLng;)V", "brandDeliverHereDecisionHandler", "restBranchId", "franchiseRes", "cameraAnimationFinished", "isCameraAnimFinished", "mMainLatLng", "fromBrandOrReorder", "changeCountryPrompt", "mapCameraFinished", "selectedCountryName", "countryId", "changeUserCountry", "checkpreflocationAvail", "areaLatLng", "convertLocationToArea", "loadCountryPolygon", "loadJSONFromAsset", "name", "loadReOrderDeliveryArea", "orderId", "locationToAddressResult", "msg", "address", "area", "Ldatamodels/Area;", "mapDecesionHandler", "userSelectedAdressAreaId", "selectedAreaCenterCordinate", "onCountrySpecificDataLoaded", "onDataError", "onDestroy", "onNetworkError", "onReorderAreasRecieved", "result", "", "Ldatamodels/DeliveryArea;", "([Ldatamodels/DeliveryArea;)V", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "outofService", "resBasereverseGeocodingError", "resBasereverseGeocodingResult", "LJsonModels/RestGeoAddressResult;", "resetGpsStatusTracker", "isGpsStatusTrigger", "resetIgnoreCurrentLocation", "resetMenuSection", "resetPreLocation", "isPrelocationFetch", "restaurantChanged", "reverseGeoAdressConvert", "showGeoAddLoading", "reverseGeocodingResult", "saveCountryInPrefs", "selectedCountryId", "saveSelectedCountry", "countryName", "updateAddress", "userSelectedAddressCp", "updateMapCameraMoved", "updateResInfoFromReOrder", "fromReOrder", "DrawAllCountryPolyGon", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapPresenter implements IHomeMapPresenter, HomeMapListener {
    private boolean IsFromReOrder;
    private boolean IsIgnoreSaveLoc;
    @NotNull
    private final CityToOldCityMapper cityToOldCityMapper;
    @Nullable
    private Context context;
    @NotNull
    private final CountryToOldCountryMapper countryToOldCountryMapper;
    @Nullable
    private Address geoAddress;
    @Nullable
    private IHomeMapInteractor homeMapInteractor;
    @Nullable
    private HomeMapView homeMapView;
    private boolean isGpsStatusTiggered;
    private boolean isIgnoreCurrentLocation;
    private boolean isMapCameraMoving;
    private boolean isPreLocationfetch;
    /* access modifiers changed from: private */
    @NotNull
    public final LocationConfigurationRepository locationConfigRepository;
    @Nullable
    private LatLng mainLatLng;
    @NotNull
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @NotNull
    private String reorderId = "";
    private int reorderResId;
    @Nullable
    private Country selectedCountry;
    @NotNull
    private String userSelectedAddress = "";

    @Instrumented
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J3\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\"\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0014¨\u0006\u0013"}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapPresenter$DrawAllCountryPolyGon;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Ljava/util/ArrayList;", "Llibrary/talabat/mvp/homemap/AllCountryPolygonRM;", "Lkotlin/collections/ArrayList;", "", "countryID", "", "canDrawCountryPolygon", "", "voids", "a", "([Ljava/lang/Void;)Ljava/util/ArrayList;", "points", "", "b", "<init>", "(Llibrary/talabat/mvp/homemap/HomeMapPresenter;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0})
    public final class DrawAllCountryPolyGon extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;

        public DrawAllCountryPolyGon() {
        }

        private final boolean canDrawCountryPolygon(int i11) {
            LocationConfigurationRepository access$getLocationConfigRepository$p = HomeMapPresenter.this.locationConfigRepository;
            com.talabat.configuration.country.Country country = com.talabat.configuration.country.Country.IRAQ;
            boolean shouldEnableCountry = access$getLocationConfigRepository$p.shouldEnableCountry(country);
            if (i11 != country.getCountryId() || shouldEnableCountry) {
                return true;
            }
            return false;
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        @NotNull
        public ArrayList<AllCountryPolygonRM> a(@NotNull Void... voidArr) {
            Context context;
            boolean z11;
            int i11;
            DrawAllCountryPolyGon drawAllCountryPolyGon = this;
            Intrinsics.checkNotNullParameter(voidArr, "voids");
            ArrayList<AllCountryPolygonRM> arrayList = new ArrayList<>();
            try {
                HomeMapPresenter homeMapPresenter = HomeMapPresenter.this;
                HomeMapView homeMapView = homeMapPresenter.getHomeMapView();
                if (homeMapView != null) {
                    context = homeMapView.getContext();
                } else {
                    context = null;
                }
                String access$loadJSONFromAsset = homeMapPresenter.loadJSONFromAsset(context, "allcountirespolygon.json");
                if (!TalabatUtils.isNullOrEmpty(access$loadJSONFromAsset)) {
                    Intrinsics.checkNotNull(access$loadJSONFromAsset);
                    if (access$loadJSONFromAsset.length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        JSONArray jSONArray = new JSONArray(access$loadJSONFromAsset);
                        int length = jSONArray.length();
                        int i12 = 0;
                        while (i12 < length) {
                            ArrayList arrayList2 = new ArrayList();
                            JSONObject jSONObject = jSONArray.getJSONObject(i12);
                            String optString = jSONObject.optString("countryId");
                            Intrinsics.checkNotNullExpressionValue(optString, "countryID");
                            if (drawAllCountryPolyGon.canDrawCountryPolygon(Integer.parseInt(optString))) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("coordinates");
                                int length2 = jSONArray2.length();
                                int i13 = 0;
                                while (i13 < length2) {
                                    JSONArray jSONArray3 = jSONArray2.getJSONArray(i13);
                                    arrayList2.add(new LatLng(jSONArray3.getDouble(1), jSONArray3.getDouble(0)));
                                    i13++;
                                    length = length;
                                }
                                i11 = length;
                                arrayList.add(new AllCountryPolygonRM(arrayList2, optString));
                            } else {
                                i11 = length;
                            }
                            i12++;
                            drawAllCountryPolyGon = this;
                            length = i11;
                        }
                    }
                }
            } catch (Exception e11) {
                Log.e("exepppp", e11.toString());
            }
            return arrayList;
        }

        public void b(@Nullable ArrayList<AllCountryPolygonRM> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList != null && arrayList.size() > 0) {
                GlobalDataModel.GEO_CORDINATES.allCountryPolygonRMS = arrayList;
                HomeMapView homeMapView = HomeMapPresenter.this.getHomeMapView();
                if (homeMapView != null) {
                    homeMapView.countryPolygonLoaded();
                }
            }
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "HomeMapPresenter$DrawAllCountryPolyGon#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "HomeMapPresenter$DrawAllCountryPolyGon#doInBackground", (ArrayList<String>) null);
            }
            ArrayList<AllCountryPolygonRM> a11 = a((Void[]) objArr);
            TraceMachine.exitMethod();
            return a11;
        }

        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "HomeMapPresenter$DrawAllCountryPolyGon#onPostExecute", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "HomeMapPresenter$DrawAllCountryPolyGon#onPostExecute", (ArrayList<String>) null);
            }
            b((ArrayList) obj);
            TraceMachine.exitMethod();
        }
    }

    public HomeMapPresenter(@NotNull HomeMapView homeMapView2, @NotNull CustomerAddressesRepository customerAddressesRepository, @NotNull AppInfoRepository appInfoRepository, @NotNull AppVersionProvider appVersionProvider, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2) {
        HomeMapView homeMapView3 = homeMapView2;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        MutableConfigurationLocalRepository mutableConfigurationLocalRepository3 = mutableConfigurationLocalRepository2;
        Intrinsics.checkNotNullParameter(homeMapView3, "homeMapView");
        CustomerAddressesRepository customerAddressesRepository2 = customerAddressesRepository;
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        AppInfoRepository appInfoRepository2 = appInfoRepository;
        Intrinsics.checkNotNullParameter(appInfoRepository2, "appInfoRepository");
        AppVersionProvider appVersionProvider2 = appVersionProvider;
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigRepository");
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "talabFeatureFlag");
        ITalabatExperiment iTalabatExperiment2 = iTalabatExperiment;
        Intrinsics.checkNotNullParameter(iTalabatExperiment2, "talabatExperiments");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository3, "mutableConfigurationLocalRepository");
        this.locationConfigRepository = locationConfigurationRepository2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository3;
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.homeMapInteractor = new HomeMapInteractor(this, customerAddressesRepository2, (Scheduler) null, (Scheduler) null, appInfoRepository2, iTalabatFeatureFlag2, iTalabatExperiment2, appVersionProvider2, locationConfigurationRepository2, mutableConfigurationLocalRepository3, 12, (DefaultConstructorMarker) null);
        this.homeMapView = homeMapView3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkpreflocationAvail(java.lang.String r8) {
        /*
            r7 = this;
            library.talabat.mvp.homemap.HomeMapTemp r0 = library.talabat.mvp.homemap.HomeMapTemp.INSTANCE
            com.google.android.gms.maps.model.LatLng r1 = r0.getHomeMapSavedLatLng()
            if (r1 == 0) goto L_0x0019
            library.talabat.mvp.homemap.HomeMapView r8 = r7.homeMapView
            if (r8 == 0) goto L_0x0092
            com.google.android.gms.maps.model.LatLng r1 = r0.getHomeMapSavedLatLng()
            java.lang.Float r0 = r0.getHomeMapSavedZooLevel()
            r8.updateUserSavedTempLocation(r1, r0)
            goto L_0x0092
        L_0x0019:
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r8)
            if (r0 != 0) goto L_0x0092
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r1 = ","
            r0.<init>((java.lang.String) r1)
            r1 = 0
            java.util.List r8 = r0.split(r8, r1)
            r0 = 0
            r2 = 1
            if (r8 == 0) goto L_0x0076
            boolean r3 = r8.isEmpty()
            if (r3 != 0) goto L_0x0060
            int r3 = r8.size()
            java.util.ListIterator r3 = r8.listIterator(r3)
        L_0x003d:
            boolean r4 = r3.hasPrevious()
            if (r4 == 0) goto L_0x0060
            java.lang.Object r4 = r3.previous()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0051
            r4 = r2
            goto L_0x0052
        L_0x0051:
            r4 = r1
        L_0x0052:
            if (r4 != 0) goto L_0x003d
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            int r3 = r3.nextIndex()
            int r3 = r3 + r2
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.take(r8, r3)
            goto L_0x0064
        L_0x0060:
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0064:
            if (r8 == 0) goto L_0x0076
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.Object[] r8 = r8.toArray(r3)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r3)
            java.lang.String[] r8 = (java.lang.String[]) r8
            goto L_0x0077
        L_0x0076:
            r8 = r0
        L_0x0077:
            library.talabat.mvp.homemap.HomeMapView r3 = r7.homeMapView
            if (r3 == 0) goto L_0x0092
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r1 = r8[r1]
            double r5 = java.lang.Double.parseDouble(r1)
            r8 = r8[r2]
            double r1 = java.lang.Double.parseDouble(r8)
            r4.<init>(r5, r1)
            r3.updateAreaLocation(r4, r0)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.homemap.HomeMapPresenter.checkpreflocationAvail(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final String loadJSONFromAsset(Context context2, String str) {
        AssetManager assetManager;
        BufferedReader bufferedReader;
        String str2 = null;
        if (context2 != null) {
            try {
                assetManager = context2.getAssets();
            } catch (Exception unused) {
                return str2;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        } else {
            assetManager = null;
        }
        Intrinsics.checkNotNull(assetManager);
        InputStream open = assetManager.open(str);
        Intrinsics.checkNotNullExpressionValue(open, "context?.assets!!.open(name)");
        InputStreamReader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
        if (inputStreamReader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) inputStreamReader;
        } else {
            bufferedReader = new BufferedReader(inputStreamReader, 8192);
        }
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            try {
                Unit unit = Unit.INSTANCE;
                try {
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                    return readText;
                } catch (Exception unused2) {
                    str2 = readText;
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = readText;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
    }

    private final void resetMenuSection() {
        GlobalDataModel.JSON.sideMenuSection = null;
        GlobalDataModel.JSON.sideMenuSectionLinks = null;
        SmsVerificationInstance.resetInstance();
        GlobalDataModel.GEO_CORDINATES.polyGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
    }

    private final void saveSelectedCountry(Context context2, int i11, String str) {
        GlobalDataModel.SelectedAreaId = 0;
        GlobalDataModel.SelectedAreaName = "";
        GlobalDataModel.SelectedCityId = 0;
        GlobalDataModel.SelectedCityName = "";
        this.mutableConfigurationLocalRepository.setSelectedCountry(i11);
        GlobalDataModel.launchRxNextEventOnCountryId(i11);
        GlobalDataModel.SelectedCountryName = str;
        GlobalDataModel.areas = null;
        GlobalDataModel.cuisines = null;
        GlobalDataModel.filterEngine = null;
        SharedPreferences.Editor edit = context2.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, i11);
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, str);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, "");
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.apply();
    }

    public void FromCurrentLocationClick(@NotNull LatLng latLng, @Nullable Float f11) {
        Intrinsics.checkNotNullParameter(latLng, Param.LAT_LNG);
        this.mainLatLng = latLng;
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.animateMapCammera(latLng, f11);
        }
    }

    public void LocationReceived(@Nullable LatLng latLng, @Nullable LatLng latLng2, @Nullable Float f11, @Nullable LatLng latLng3) {
        Context context2;
        Float f12;
        HomeMapView homeMapView2;
        HomeMapView homeMapView3;
        Float f13;
        Log.e("location Received", "location received");
        if (latLng2 == null || this.IsIgnoreSaveLoc) {
            boolean z11 = false;
            if (this.isIgnoreCurrentLocation) {
                HomeMapView homeMapView4 = this.homeMapView;
                if (homeMapView4 != null) {
                    homeMapView4.mapAnimatedtoLocation(false);
                }
                if (latLng3 == null) {
                    latLng2 = HomeMapUtils.INSTANCE.defaultCountryLatLang();
                } else {
                    latLng2 = latLng3;
                }
                if (latLng3 != null) {
                    f13 = Float.valueOf(15.0f);
                } else {
                    f13 = Float.valueOf(10.0f);
                }
                this.isPreLocationfetch = false;
                HomeMapView homeMapView5 = this.homeMapView;
                if (homeMapView5 != null) {
                    homeMapView5.animateMapCammera(latLng2, f13);
                }
            } else if (GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME != null) {
                HomeMapView homeMapView6 = this.homeMapView;
                if (homeMapView6 != null) {
                    homeMapView6.mapAnimatedtoLocation(false);
                }
                latLng2 = GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME;
                this.isPreLocationfetch = true;
                Float valueOf = Float.valueOf(18.0f);
                if (!(GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME == null || (homeMapView3 = this.homeMapView) == null)) {
                    homeMapView3.hideMapTutorial();
                }
                HomeMapView homeMapView7 = this.homeMapView;
                if (homeMapView7 != null) {
                    homeMapView7.animateMapCammera(latLng2, valueOf);
                }
            } else {
                HomeMapView homeMapView8 = this.homeMapView;
                if (homeMapView8 != null) {
                    homeMapView8.mapAnimatedtoLocation(false);
                }
                if (latLng == null) {
                    r4 = HomeMapUtils.INSTANCE.defaultCountryLatLang();
                } else {
                    r4 = latLng;
                }
                if (latLng != null) {
                    f12 = Float.valueOf(18.0f);
                } else {
                    f12 = Float.valueOf(10.0f);
                }
                if (latLng != null) {
                    z11 = true;
                }
                this.isPreLocationfetch = z11;
                if (!(latLng == null || (homeMapView2 = this.homeMapView) == null)) {
                    homeMapView2.hideMapTutorial();
                }
                HomeMapView homeMapView9 = this.homeMapView;
                if (homeMapView9 != null) {
                    homeMapView9.animateMapCammera(latLng2, f12);
                }
            }
        } else {
            this.isPreLocationfetch = true;
            HomeMapView homeMapView10 = this.homeMapView;
            if (homeMapView10 != null) {
                homeMapView10.mapAnimatedtoLocation(true);
            }
            HomeMapView homeMapView11 = this.homeMapView;
            if (homeMapView11 != null) {
                homeMapView11.animateMapCammera(latLng2, f11);
            }
        }
        this.mainLatLng = latLng2;
        if (!this.isGpsStatusTiggered) {
            try {
                HomeMapView homeMapView12 = this.homeMapView;
                if (homeMapView12 != null) {
                    context2 = homeMapView12.getContext();
                } else {
                    context2 = null;
                }
                HomeMapView homeMapView13 = this.homeMapView;
                Intrinsics.checkNotNull(homeMapView13);
                boolean checkPermission = homeMapView13.checkPermission();
                HomeMapView homeMapView14 = this.homeMapView;
                Intrinsics.checkNotNull(homeMapView14);
                AppTracker.gpsStatus(context2, checkPermission, homeMapView14.deviceGpsStatus(), "MapFirstHome");
                this.isGpsStatusTiggered = true;
            } catch (Exception unused) {
            }
        }
    }

    public void brandDeliverHereDecisionHandler(int i11, boolean z11) {
        Area area;
        Object obj;
        boolean z12;
        if (Cart.getInstance().hasItems()) {
            Address address = this.geoAddress;
            Intrinsics.checkNotNull(address);
            int i12 = address.areaId;
            AreaToOldAreaMapper areaToOldAreaMapper = new AreaToOldAreaMapper();
            Iterator it = this.locationConfigRepository.areas().iterator();
            while (true) {
                area = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((com.talabat.configuration.location.Area) obj).getId() == i12) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            com.talabat.configuration.location.Area area2 = (com.talabat.configuration.location.Area) obj;
            if (area2 != null) {
                area = areaToOldAreaMapper.apply(area2);
            }
            HomeMapView homeMapView2 = this.homeMapView;
            if (homeMapView2 != null) {
                homeMapView2.clearCartchangeLocation(this.geoAddress, area, this.userSelectedAddress);
                return;
            }
            return;
        }
        HomeMapView homeMapView3 = this.homeMapView;
        if (homeMapView3 != null) {
            homeMapView3.loadRestaurantMenuScreen(i11, this.geoAddress, this.userSelectedAddress, z11);
        }
    }

    public void cameraAnimationFinished(boolean z11, @Nullable LatLng latLng, boolean z12) {
        int i11;
        if (this.mainLatLng == null || !this.isPreLocationfetch) {
            HomeMapView homeMapView2 = this.homeMapView;
            if (homeMapView2 != null) {
                homeMapView2.preLocationLocationContainer(false, false);
            }
            HomeMapView homeMapView3 = this.homeMapView;
            if (homeMapView3 != null) {
                homeMapView3.enableDeliverHereButton(false);
                return;
            }
            return;
        }
        HomeMapView homeMapView4 = this.homeMapView;
        if (homeMapView4 != null) {
            homeMapView4.detectingLocationProgress();
        }
        LatLng latLng2 = null;
        if (z12) {
            if (this.IsFromReOrder) {
                i11 = this.reorderResId;
            } else {
                i11 = GlobalDataModel.SELECTED.restaurant.f13872id;
            }
            int i12 = i11;
            int i13 = GlobalDataModel.SelectedCountryId;
            HomeMapView homeMapView5 = this.homeMapView;
            if (homeMapView5 != null) {
                latLng2 = homeMapView5.getMainLatLng();
            }
            Intrinsics.checkNotNull(latLng2);
            double d11 = latLng2.longitude;
            HomeMapView homeMapView6 = this.homeMapView;
            Intrinsics.checkNotNull(homeMapView6);
            LatLng mainLatLng2 = homeMapView6.getMainLatLng();
            Intrinsics.checkNotNull(mainLatLng2);
            RestGeoReverseCodingRequest restGeoReverseCodingRequest = new RestGeoReverseCodingRequest(i12, i13, d11, mainLatLng2.latitude, 0);
            IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
            if (iHomeMapInteractor != null) {
                iHomeMapInteractor.reverseGeoCodingBasedRestaurant(restGeoReverseCodingRequest);
                return;
            }
            return;
        }
        IHomeMapInteractor iHomeMapInteractor2 = this.homeMapInteractor;
        if (iHomeMapInteractor2 != null) {
            HomeMapView homeMapView7 = this.homeMapView;
            if (homeMapView7 != null) {
                latLng2 = homeMapView7.getMainLatLng();
            }
            iHomeMapInteractor2.reverseGeoCoding(latLng2);
        }
    }

    public void changeCountryPrompt(boolean z11, @Nullable LatLng latLng, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "selectedCountryName");
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.changecountryPrompt(latLng, str, i11);
        }
    }

    public void changeUserCountry(int i11) {
        resetMenuSection();
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.startLodingPopup();
        }
        try {
            List<com.talabat.configuration.location.Country> countries = this.locationConfigRepository.countries();
            if (!countries.isEmpty()) {
                Iterator<com.talabat.configuration.location.Country> it = countries.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.talabat.configuration.location.Country next = it.next();
                    if (next.getCountry().getCountryId() == i11) {
                        Country apply = this.countryToOldCountryMapper.apply(next);
                        this.selectedCountry = apply;
                        MutableConfigurationLocalRepository mutableConfigurationLocalRepository2 = this.mutableConfigurationLocalRepository;
                        Intrinsics.checkNotNull(apply);
                        mutableConfigurationLocalRepository2.setSelectedCountry(apply.f13845id);
                        Country country = this.selectedCountry;
                        Intrinsics.checkNotNull(country);
                        GlobalDataModel.SelectedCountryName = country.f13846name;
                        HomeMapView homeMapView3 = this.homeMapView;
                        Intrinsics.checkNotNull(homeMapView3);
                        saveSelectedCountry(homeMapView3.getContext(), next.getCountry().getCountryId(), next.getCountry().getCountryName());
                        break;
                    }
                }
                IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
                if (iHomeMapInteractor != null) {
                    iHomeMapInteractor.loadAppinitCountrySpecficData(this.selectedCountry);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void convertLocationToArea(@Nullable LatLng latLng) {
        IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
        if (iHomeMapInteractor != null) {
            iHomeMapInteractor.locationToArea(latLng);
        }
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Address getGeoAddress() {
        return this.geoAddress;
    }

    @Nullable
    public final IHomeMapInteractor getHomeMapInteractor() {
        return this.homeMapInteractor;
    }

    @Nullable
    public final HomeMapView getHomeMapView() {
        return this.homeMapView;
    }

    public final boolean getIsFromReOrder() {
        return this.IsFromReOrder;
    }

    public final boolean getIsIgnoreSaveLoc() {
        return this.IsIgnoreSaveLoc;
    }

    @Nullable
    public final LatLng getMainLatLng() {
        return this.mainLatLng;
    }

    @NotNull
    public final String getReorderId() {
        return this.reorderId;
    }

    public final int getReorderResId() {
        return this.reorderResId;
    }

    @Nullable
    public final Country getSelectedCountry() {
        return this.selectedCountry;
    }

    @NotNull
    public final String getUserSelectedAddress() {
        return this.userSelectedAddress;
    }

    public final boolean isGpsStatusTiggered() {
        return this.isGpsStatusTiggered;
    }

    public final boolean isIgnoreCurrentLocation() {
        return this.isIgnoreCurrentLocation;
    }

    public final boolean isMapCameraMoving() {
        return this.isMapCameraMoving;
    }

    public final boolean isPreLocationfetch() {
        return this.isPreLocationfetch;
    }

    public void loadCountryPolygon(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        AsyncTaskInstrumentation.execute(new DrawAllCountryPolyGon(), new Void[0]);
    }

    public void loadReOrderDeliveryArea(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
        if (iHomeMapInteractor != null) {
            iHomeMapInteractor.getReoderAreas(str, this.reorderResId);
        }
    }

    public void locationToAddressResult(@Nullable String str, @Nullable Address address, @Nullable Area area) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            HomeMapView homeMapView2 = this.homeMapView;
            if (homeMapView2 != null) {
                homeMapView2.locationError(str);
            }
        } else if (Cart.getInstance().hasItems()) {
            HomeMapView homeMapView3 = this.homeMapView;
            if (homeMapView3 != null) {
                homeMapView3.clearCartchangeLocation(this.geoAddress, area, this.userSelectedAddress);
            }
        } else {
            HomeMapView homeMapView4 = this.homeMapView;
            if (homeMapView4 != null) {
                homeMapView4.loadRestaurantListScreen(str, this.geoAddress, area, this.userSelectedAddress);
            }
        }
    }

    public void mapDecesionHandler(boolean z11, @NotNull String str, int i11, @NotNull String str2, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "userSelectedAddress");
        Intrinsics.checkNotNullParameter(str2, "selectedAreaCenterCordinate");
        this.isIgnoreCurrentLocation = z11;
        this.IsIgnoreSaveLoc = z12;
        this.userSelectedAddress = str;
        if (!z12) {
            checkpreflocationAvail(str2);
        }
    }

    public void onCountrySpecificDataLoaded() {
        Integer num;
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            Country country = this.selectedCountry;
            if (country != null) {
                num = Integer.valueOf(country.f13845id);
            } else {
                num = null;
            }
            homeMapView2.onCountryDataLoaded(num);
        }
        Country country2 = this.selectedCountry;
        if (country2 != null) {
            TalabatFormatter.getInstance().setFormat(country2.currencySymbol, country2.numOfDecimalPlaces, country2.f13845id);
        }
    }

    public void onDataError() {
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.onDataError();
        }
    }

    public void onDestroy() {
        this.homeMapView = null;
        IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
        if (!(iHomeMapInteractor == null || iHomeMapInteractor == null)) {
            iHomeMapInteractor.unregister();
        }
        this.homeMapInteractor = null;
    }

    public void onNetworkError() {
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.onNetworkError();
        }
    }

    public void onReorderAreasRecieved(@Nullable DeliveryArea[] deliveryAreaArr) {
        restaurantChanged();
        Intrinsics.checkNotNull(deliveryAreaArr);
        int[] iArr = new int[deliveryAreaArr.length];
        int length = deliveryAreaArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = deliveryAreaArr[i11].getId();
        }
        GlobalDataModel.restaurantDeliveryAreas = deliveryAreaArr;
    }

    public void onServerError(@NotNull VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(volleyError, "volleyError");
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.onServerError(volleyError);
        }
    }

    public void outofService(boolean z11, @Nullable LatLng latLng) {
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.outofService(latLng);
        }
    }

    public void resBasereverseGeocodingError() {
    }

    public void resBasereverseGeocodingResult(@Nullable RestGeoAddressResult restGeoAddressResult) {
        HomeMapView homeMapView2;
        HomeMapView homeMapView3;
        HomeMapView homeMapView4;
        FranchiseBranchList[] franchiseBranchListArr;
        if (restGeoAddressResult != null) {
            if (restGeoAddressResult.branchInfo != null) {
                if (!this.IsFromReOrder && restGeoAddressResult.iSGroupRestaurant && (franchiseBranchListArr = restGeoAddressResult.franchiseBranchList) != null) {
                    if (franchiseBranchListArr.length > 1) {
                        HomeMapView homeMapView5 = this.homeMapView;
                        if (homeMapView5 != null) {
                            homeMapView5.updateIsFrachiseRestaurant(true);
                        }
                        HomeMapView homeMapView6 = this.homeMapView;
                        if (homeMapView6 != null) {
                            homeMapView6.updateRestGrpId(restGeoAddressResult.branchInfo.restGrpId);
                        }
                    } else {
                        HomeMapView homeMapView7 = this.homeMapView;
                        if (homeMapView7 != null) {
                            homeMapView7.updateIsFrachiseRestaurant(false);
                        }
                    }
                }
                HomeMapView homeMapView8 = this.homeMapView;
                if (homeMapView8 != null) {
                    homeMapView8.updateBranchId(restGeoAddressResult.branchInfo.branchId);
                }
            }
            Address address = restGeoAddressResult.reverseAddress;
            if (address != null) {
                this.geoAddress = address;
                if (!this.isMapCameraMoving && (homeMapView4 = this.homeMapView) != null) {
                    homeMapView4.geocodingReceived(true, true, address);
                }
            } else if (!this.isMapCameraMoving && (homeMapView3 = this.homeMapView) != null) {
                homeMapView3.geocodingReceived(false, false, address);
            }
        } else if (!this.isMapCameraMoving && (homeMapView2 = this.homeMapView) != null) {
            homeMapView2.geocodingReceived(false, false, (Address) null);
        }
    }

    public void resetGpsStatusTracker(boolean z11) {
        this.isGpsStatusTiggered = z11;
    }

    public void resetIgnoreCurrentLocation(boolean z11) {
        this.isIgnoreCurrentLocation = z11;
    }

    public void resetPreLocation(boolean z11) {
        this.isPreLocationfetch = true;
    }

    public final void restaurantChanged() {
        GlobalDataModel.restaurantDeliveryAreas = null;
        GlobalDataModel.JSON.menuItemsResponseModel = null;
    }

    public void reverseGeoAdressConvert(@Nullable LatLng latLng, boolean z11) {
        this.mainLatLng = latLng;
        HomeMapView homeMapView2 = this.homeMapView;
        if (homeMapView2 != null) {
            homeMapView2.showGeoAddressLoading();
        }
        IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
        if (iHomeMapInteractor != null) {
            iHomeMapInteractor.reverseGeoCoding(this.mainLatLng);
        }
    }

    public void reverseGeocodingResult(@Nullable Address address) {
        if (this.isMapCameraMoving) {
            return;
        }
        if (address == null) {
            HomeMapView homeMapView2 = this.homeMapView;
            if (homeMapView2 != null) {
                homeMapView2.geocodingReceived(false, false, address);
            }
        } else if (address.areaId > 0) {
            this.geoAddress = address;
            HomeMapView homeMapView3 = this.homeMapView;
            if (homeMapView3 != null) {
                homeMapView3.geocodingReceived(true, true, address);
            }
        } else {
            HomeMapView homeMapView4 = this.homeMapView;
            if (homeMapView4 != null) {
                homeMapView4.geocodingReceived(false, false, address);
            }
        }
    }

    public void saveCountryInPrefs(int i11, @Nullable String str) {
        HomeMapView homeMapView2 = this.homeMapView;
        Intrinsics.checkNotNull(homeMapView2);
        Context context2 = homeMapView2.getContext();
        Intrinsics.checkNotNull(str);
        saveSelectedCountry(context2, i11, str);
    }

    public final void setContext(@Nullable Context context2) {
        this.context = context2;
    }

    public final void setGeoAddress(@Nullable Address address) {
        this.geoAddress = address;
    }

    public final void setGpsStatusTiggered(boolean z11) {
        this.isGpsStatusTiggered = z11;
    }

    public final void setHomeMapInteractor(@Nullable IHomeMapInteractor iHomeMapInteractor) {
        this.homeMapInteractor = iHomeMapInteractor;
    }

    public final void setHomeMapView(@Nullable HomeMapView homeMapView2) {
        this.homeMapView = homeMapView2;
    }

    public final void setIgnoreCurrentLocation(boolean z11) {
        this.isIgnoreCurrentLocation = z11;
    }

    public final void setIsFromReOrder(boolean z11) {
        this.IsFromReOrder = z11;
    }

    public final void setIsIgnoreSaveLoc(boolean z11) {
        this.IsIgnoreSaveLoc = z11;
    }

    public final void setMainLatLng(@Nullable LatLng latLng) {
        this.mainLatLng = latLng;
    }

    public final void setMapCameraMoving(boolean z11) {
        this.isMapCameraMoving = z11;
    }

    public final void setPreLocationfetch(boolean z11) {
        this.isPreLocationfetch = z11;
    }

    public final void setReorderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reorderId = str;
    }

    public final void setReorderResId(int i11) {
        this.reorderResId = i11;
    }

    public final void setSelectedCountry(@Nullable Country country) {
        this.selectedCountry = country;
    }

    public final void setUserSelectedAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userSelectedAddress = str;
    }

    public void updateAddress(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "userSelectedAddressCp");
        IHomeMapInteractor iHomeMapInteractor = this.homeMapInteractor;
        if (iHomeMapInteractor != null) {
            iHomeMapInteractor.updateAddressBackGround(address);
        }
    }

    public void updateMapCameraMoved(boolean z11) {
        this.isMapCameraMoving = z11;
    }

    public void updateResInfoFromReOrder(boolean z11, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "reorderId");
        this.IsFromReOrder = z11;
        this.reorderId = str;
        this.reorderResId = i11;
    }
}
