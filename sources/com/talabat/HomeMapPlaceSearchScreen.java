package com.talabat;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.huawei.hms.flutter.map.constants.Param;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.adapters.homeMap.GooglePlaceSearchAdapter;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.home.DaggerHomeMapPlaceSearchScreenComponent;
import com.talabat.domain.address.Address;
import com.talabat.fragments.DeliveryAreaFragment;
import com.talabat.helpers.DividerItemDecoration;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.Area;
import datamodels.DeliveryArea;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.homemap.HomeMapUtils;
import library.talabat.mvp.homemapsearch.GooglePlacePresenter;
import library.talabat.mvp.homemapsearch.GoogleSearchView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import ue.f8;
import ue.g8;
import ue.h8;

@Instrumented
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001|B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010D\u001a\u00020E2\u0006\u0010\u0018\u001a\u00020\u0012J\b\u0010F\u001a\u00020EH\u0016J\n\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u000206H\u0016J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u000208H\u0002J\b\u0010L\u001a\u00020EH\u0002J\u0006\u0010M\u001a\u00020EJ\u0010\u0010N\u001a\u00020E2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010O\u001a\u00020EH\u0016J\b\u0010P\u001a\u00020EH\u0016J\b\u0010Q\u001a\u00020EH\u0016J\u0010\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u000203H\u0016J\"\u0010T\u001a\u00020E2\u0006\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020C2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J\b\u0010Y\u001a\u00020EH\u0016J\u0012\u0010Z\u001a\u00020E2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\b\u0010]\u001a\u00020EH\u0016J\u001a\u0010^\u001a\u00020E2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u000206H\u0016J\b\u0010b\u001a\u00020EH\u0016J\u0010\u0010c\u001a\u00020E2\u0006\u0010d\u001a\u000206H\u0016J\u0010\u0010e\u001a\u00020E2\u0006\u0010f\u001a\u00020\u0012H\u0016J \u0010g\u001a\u00020E2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4H\u0016J\"\u0010h\u001a\u00020E2\u0006\u0010i\u001a\u0002062\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u000206H\u0002J\u0010\u0010m\u001a\u00020E2\u0006\u0010d\u001a\u000206H\u0002J\b\u0010n\u001a\u00020EH\u0002J\u0006\u0010o\u001a\u00020EJ\u0010\u0010p\u001a\u00020E2\u0006\u0010d\u001a\u000206H\u0002J\u000e\u0010q\u001a\u00020E2\u0006\u0010d\u001a\u000206J\b\u0010r\u001a\u000206H\u0002J\b\u0010s\u001a\u00020EH\u0002J\u0006\u0010t\u001a\u00020uJ\u0016\u0010v\u001a\u00020E2\u0006\u0010w\u001a\u00020x2\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010y\u001a\u00020E2\u0006\u0010z\u001a\u00020{R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u0016\u0012\u0004\u0012\u000203\u0018\u000102j\n\u0012\u0004\u0012\u000203\u0018\u0001`4X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/talabat/HomeMapPlaceSearchScreen;", "Lcom/talabat/helpers/TalabatBase;", "Llibrary/talabat/mvp/homemapsearch/GoogleSearchView;", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$onItemClickListener;", "()V", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "setAppVersionProvider", "(Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "deliveyAreaFragment", "Landroidx/fragment/app/Fragment;", "getDeliveyAreaFragment", "()Landroidx/fragment/app/Fragment;", "setDeliveyAreaFragment", "(Landroidx/fragment/app/Fragment;)V", "filterCities", "", "fm", "Landroidx/fragment/app/FragmentManager;", "forceFilterCities", "ft", "Landroidx/fragment/app/FragmentTransaction;", "isCurrentLocationAvail", "()Z", "setCurrentLocationAvail", "(Z)V", "isFromBrandOrReorder", "isFromCurrentLocationRequest", "setFromCurrentLocationRequest", "isFromReOrder", "isSearchRequestSend", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mGooglePlacePresenter", "Llibrary/talabat/mvp/homemapsearch/GooglePlacePresenter;", "mGooglePlaceSearchAdapter", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "placesSuggestionArrayList", "Ljava/util/ArrayList;", "LJsonModels/Response/PlacesSuggestionResponse;", "Lkotlin/collections/ArrayList;", "previousKeyword", "", "previousTime", "", "reorderResNam", "requestScheduled", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "sendNextRequest", "timeleft", "", "currentLocationAvail", "", "destroyPresenter", "getPresenter", "Llibrary/talabat/mvp/IGlobalPresenter;", "getScreenName", "getTimeDifference", "currentTime", "hideKeyBoard", "initView", "loadDeliveryAreas", "loadGooglePlaceSearch", "noDetailsFound", "noPlaceIdAvailable", "oSearchPlaceClicked", "placeRslt", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onLatLongRecieved", "result", "LJsonModels/Response/SuggestedPlaceDetails;", "placeName", "onNoSuggestionsFound", "onScheduleRequest", "keyword", "onSearchResultAvail", "isPlaceFound", "onSuggestionsLoaded", "onTrackGeoLocationRequested", "apiStatus", "address", "Lcom/talabat/domain/address/Address;", "errorMsg", "populateSearchBasedKey", "reloadAreaFragment", "removeSearchFocus", "requestPlaceSuggestions", "scheduleRequest", "screenType", "searchClearVisible", "searchFld", "Landroid/widget/EditText;", "setDeliveryAreaCurrentLocation", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "setDeliveryAreaResult", "area", "Ldatamodels/Area;", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapPlaceSearchScreen extends TalabatBase implements GoogleSearchView, GooglePlaceSearchAdapter.onItemClickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int GPSENABLE = 36;
    /* access modifiers changed from: private */
    public static final int PERMISSION_REQUEST_SEARCH_CODE = 501;
    private static final int REQUEST_CHECK_SETTINGS = 100;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public AppVersionProvider appVersionProvider;
    @Nullable
    private Fragment deliveyAreaFragment;
    private boolean filterCities;
    @Nullable

    /* renamed from: fm  reason: collision with root package name */
    private FragmentManager f54194fm;
    private boolean forceFilterCities;
    @Nullable

    /* renamed from: ft  reason: collision with root package name */
    private FragmentTransaction f54195ft;
    private boolean isCurrentLocationAvail;
    private boolean isFromBrandOrReorder;
    private boolean isFromCurrentLocationRequest;
    private boolean isFromReOrder;
    /* access modifiers changed from: private */
    public boolean isSearchRequestSend;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private GooglePlacePresenter mGooglePlacePresenter;
    /* access modifiers changed from: private */
    @Nullable
    public GooglePlaceSearchAdapter mGooglePlaceSearchAdapter;
    @Nullable
    private Handler mHandler;
    /* access modifiers changed from: private */
    @Nullable
    public ArrayList<PlacesSuggestionResponse> placesSuggestionArrayList;
    /* access modifiers changed from: private */
    @NotNull
    public String previousKeyword = "";
    private long previousTime;
    @NotNull
    private String reorderResNam = "";
    /* access modifiers changed from: private */
    public boolean requestScheduled;
    @Nullable
    private Runnable runnable;
    /* access modifiers changed from: private */
    public boolean sendNextRequest;
    /* access modifiers changed from: private */
    public int timeleft;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/HomeMapPlaceSearchScreen$Companion;", "", "()V", "GPSENABLE", "", "getGPSENABLE", "()I", "PERMISSION_REQUEST_SEARCH_CODE", "getPERMISSION_REQUEST_SEARCH_CODE", "REQUEST_CHECK_SETTINGS", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getGPSENABLE() {
            return HomeMapPlaceSearchScreen.GPSENABLE;
        }

        public final int getPERMISSION_REQUEST_SEARCH_CODE() {
            return HomeMapPlaceSearchScreen.PERMISSION_REQUEST_SEARCH_CODE;
        }
    }

    /* access modifiers changed from: private */
    public final boolean getTimeDifference(long j11) {
        return j11 - this.previousTime > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    /* access modifiers changed from: private */
    public final void hideKeyBoard() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(((MaterialEditText) _$_findCachedViewById(R.id.ed_search_location)).getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m9457initView$lambda2(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen, View view) {
        Intrinsics.checkNotNullParameter(homeMapPlaceSearchScreen, "this$0");
        MaterialEditText materialEditText = (MaterialEditText) homeMapPlaceSearchScreen._$_findCachedViewById(R.id.ed_search_location);
        if (materialEditText != null) {
            materialEditText.setText("");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m9458onCreate$lambda0(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen, View view) {
        Intrinsics.checkNotNullParameter(homeMapPlaceSearchScreen, "this$0");
        AppTracker.onMapSearchStarted(homeMapPlaceSearchScreen);
        homeMapPlaceSearchScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m9459onCreate$lambda1(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen, View view) {
        Intrinsics.checkNotNullParameter(homeMapPlaceSearchScreen, "this$0");
        AppTracker.onMapSearchComplete(homeMapPlaceSearchScreen, "searchAbandoned");
        homeMapPlaceSearchScreen.finish();
    }

    private final void onTrackGeoLocationRequested(String str, Address address, String str2) {
        Integer num;
        boolean z11;
        Address address2 = address;
        try {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            Integer num2 = null;
            if (address2 != null) {
                num = Integer.valueOf(address2.cityId);
            } else {
                num = null;
            }
            if (address2 != null) {
                num2 = Integer.valueOf(address2.areaId);
            }
            Integer num3 = num2;
            String screenType = screenType();
            String str3 = AppTracker.NotAvail;
            String screenName = getScreenName();
            String str4 = AppTracker.NotAvail;
            if (address2 != null) {
                z11 = false;
            } else {
                z11 = true;
            }
            try {
                AppTracker.onGeolocationRequested(this, trackingUtils.getTrackingAddressObject(this, false, address, num, num3, screenType, str3, screenName, str2, str4, str, str4, str4, str4, str4, str4, str4, str4, z11, str4));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    private final void populateSearchBasedKey(String str) {
        requestPlaceSuggestions(str);
    }

    /* access modifiers changed from: private */
    public final void reloadAreaFragment() {
        Fragment fragment;
        FragmentManager fragmentManager = this.f54194fm;
        if (fragmentManager != null) {
            fragment = fragmentManager.findFragmentByTag("DeliveryAreaFragment");
        } else {
            fragment = null;
        }
        DeliveryAreaFragment deliveryAreaFragment = (DeliveryAreaFragment) fragment;
        this.deliveyAreaFragment = deliveryAreaFragment;
        if (deliveryAreaFragment == null) {
            loadDeliveryAreas(false);
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.google_place_search_container);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.place_search_list);
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        ((FrameLayout) _$_findCachedViewById(R.id.choose_area_fragment)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void requestPlaceSuggestions(String str) {
        if (str != null && !Intrinsics.areEqual((Object) str, (Object) "") && !Intrinsics.areEqual((Object) this.previousKeyword, (Object) str)) {
            this.isSearchRequestSend = true;
            ((ProgressBar) _$_findCachedViewById(R.id.places_loading_indicator)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.search_clear_icon)).setVisibility(4);
            this.sendNextRequest = false;
            this.previousTime = System.currentTimeMillis();
            this.previousKeyword = str;
            GooglePlacePresenter googlePlacePresenter = this.mGooglePlacePresenter;
            if (googlePlacePresenter != null) {
                googlePlacePresenter.loadSuggestions(str);
            }
            this.requestScheduled = false;
        }
    }

    private final String screenType() {
        if (!this.isFromBrandOrReorder) {
            return "home";
        }
        if (this.isFromReOrder) {
            return ScreenNames.SCREEN_TYPE_REORDER;
        }
        return ScreenNames.SCREEN_TYPE_BRAND;
    }

    /* access modifiers changed from: private */
    public final void searchClearVisible() {
        if (String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.ed_search_location)).getText()).length() > 0) {
            ((RelativeLayout) _$_findCachedViewById(R.id.search_clear)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.search_clear_icon)).setVisibility(0);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void currentLocationAvail(boolean z11) {
        this.isCurrentLocationAvail = z11;
    }

    public void destroyPresenter() {
        this.mGooglePlacePresenter = null;
    }

    @NotNull
    public final AppVersionProvider getAppVersionProvider() {
        AppVersionProvider appVersionProvider2 = this.appVersionProvider;
        if (appVersionProvider2 != null) {
            return appVersionProvider2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appVersionProvider");
        return null;
    }

    @Nullable
    public final Fragment getDeliveyAreaFragment() {
        return this.deliveyAreaFragment;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @Nullable
    public final Handler getMHandler() {
        return this.mHandler;
    }

    @Nullable
    public IGlobalPresenter getPresenter() {
        return this.mGooglePlacePresenter;
    }

    @Nullable
    public final Runnable getRunnable() {
        return this.runnable;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.SCREEN_HOME_MAP_SEARCH;
    }

    public final void initView() {
        Editable editable;
        MaterialEditText materialEditText;
        int i11 = R.id.place_search_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) _$_findCachedViewById(i11)).addItemDecoration(new DividerItemDecoration(getContext(), 1));
        ((RecyclerView) _$_findCachedViewById(i11)).addOnScrollListener(new HomeMapPlaceSearchScreen$initView$1(this));
        this.mGooglePlacePresenter = new GooglePlacePresenter(getAppVersionProvider(), this);
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            MaterialEditText materialEditText2 = (MaterialEditText) _$_findCachedViewById(R.id.ed_search_location);
            if (materialEditText2 != null) {
                materialEditText2.setHint(getResources().getString(R.string.map_seach_hint));
            }
        } else {
            MaterialEditText materialEditText3 = (MaterialEditText) _$_findCachedViewById(R.id.ed_search_location);
            if (materialEditText3 != null) {
                materialEditText3.setHint(getResources().getString(R.string.map_seach_hint));
            }
        }
        if (!TalabatUtils.isNullOrEmpty(getIntent().getStringExtra("searchKey"))) {
            MaterialEditText materialEditText4 = (MaterialEditText) _$_findCachedViewById(R.id.ed_search_location);
            if (materialEditText4 != null) {
                materialEditText4.setText(getIntent().getStringExtra("searchKey"));
            }
            ((RelativeLayout) _$_findCachedViewById(R.id.search_clear)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.search_clear_icon)).setVisibility(0);
            String stringExtra = getIntent().getStringExtra("searchKey");
            if (stringExtra == null) {
                stringExtra = "";
            }
            populateSearchBasedKey(stringExtra);
        }
        int i12 = R.id.ed_search_location;
        if (!TalabatUtils.isNullOrEmpty(String.valueOf(((MaterialEditText) _$_findCachedViewById(i12)).getText())) && (materialEditText = (MaterialEditText) _$_findCachedViewById(i12)) != null) {
            materialEditText.setSelection(String.valueOf(((MaterialEditText) _$_findCachedViewById(i12)).getText()).length());
        }
        AppTracker.onMapSearchStarted(this);
        GooglePlacePresenter googlePlacePresenter = this.mGooglePlacePresenter;
        if (googlePlacePresenter != null) {
            MaterialEditText materialEditText5 = (MaterialEditText) _$_findCachedViewById(i12);
            if (materialEditText5 != null) {
                editable = materialEditText5.getText();
            } else {
                editable = null;
            }
            googlePlacePresenter.searchViewTypeHandler(String.valueOf(editable));
        }
        ((RelativeLayout) _$_findCachedViewById(R.id.search_clear)).setOnClickListener(new h8(this));
    }

    public final boolean isCurrentLocationAvail() {
        return this.isCurrentLocationAvail;
    }

    public final boolean isFromCurrentLocationRequest() {
        return this.isFromCurrentLocationRequest;
    }

    public void loadDeliveryAreas(boolean z11) {
        FragmentTransaction fragmentTransaction;
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.google_place_search_container);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.place_search_list);
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        ((FrameLayout) _$_findCachedViewById(R.id.choose_area_fragment)).setVisibility(0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("locationAvail", this.isCurrentLocationAvail);
        bundle.putBoolean("isFromCurrentLocationRequest", z11);
        bundle.putBoolean(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, this.isFromBrandOrReorder);
        bundle.putString(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME, this.reorderResNam);
        if (this.isFromBrandOrReorder && GlobalDataModel.restaurantDeliveryAreas != null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            DeliveryArea[] deliveryAreaArr = GlobalDataModel.restaurantDeliveryAreas;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) deliveryAreaArr);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) deliveryAreaArr);
            }
            bundle.putString("areas", str);
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f54194fm = supportFragmentManager;
        if (supportFragmentManager != null) {
            fragmentTransaction = supportFragmentManager.beginTransaction();
        } else {
            fragmentTransaction = null;
        }
        this.f54195ft = fragmentTransaction;
        DeliveryAreaFragment deliveryAreaFragment = new DeliveryAreaFragment();
        this.deliveyAreaFragment = deliveryAreaFragment;
        Intrinsics.checkNotNull(deliveryAreaFragment);
        if (!deliveryAreaFragment.isAdded()) {
            FragmentTransaction fragmentTransaction2 = this.f54195ft;
            if (fragmentTransaction2 != null) {
                Fragment fragment = this.deliveyAreaFragment;
                if (fragment != null) {
                    fragmentTransaction2.add((int) R.id.choose_area_fragment, (Fragment) (DeliveryAreaFragment) fragment, "DeliveryAreaFragment");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.fragments.DeliveryAreaFragment");
                }
            }
            Fragment fragment2 = this.deliveyAreaFragment;
            Intrinsics.checkNotNull(fragment2);
            fragment2.setArguments(bundle);
            FragmentTransaction fragmentTransaction3 = this.f54195ft;
            if (fragmentTransaction3 != null) {
                fragmentTransaction3.commit();
            }
        }
    }

    public void loadGooglePlaceSearch() {
        ((FrameLayout) _$_findCachedViewById(R.id.choose_area_fragment)).setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.google_place_search_container);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.place_search_list);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    public void noDetailsFound() {
        String string = getResources().getString(R.string.choose_no_result);
        Intrinsics.checkNotNullExpressionValue(string, "this.resources.getString….string.choose_no_result)");
        onTrackGeoLocationRequested("False", (Address) null, string);
    }

    public void noPlaceIdAvailable() {
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void oSearchPlaceClicked(@NotNull PlacesSuggestionResponse placesSuggestionResponse) {
        Intrinsics.checkNotNullParameter(placesSuggestionResponse, "placeRslt");
        int i11 = R.id.ed_search_location;
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNull(materialEditText);
        Editable text = materialEditText.getText();
        Intrinsics.checkNotNull(text);
        ((MaterialEditText) _$_findCachedViewById(i11)).setSelection(text.length());
        GooglePlacePresenter googlePlacePresenter = this.mGooglePlacePresenter;
        if (googlePlacePresenter != null) {
            String str = placesSuggestionResponse.placeId;
            String str2 = placesSuggestionResponse.f477name;
            Intrinsics.checkNotNullExpressionValue(str2, "placeRslt.name");
            googlePlacePresenter.getLatitudeAndLongitude(str, str2);
        }
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 != REQUEST_CHECK_SETTINGS) {
            return;
        }
        if (i12 == -1) {
            loadDeliveryAreas(true);
        } else {
            Toast.makeText(this, "Settings canceled", 1).show();
        }
    }

    public void onAuthError() {
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerHomeMapPlaceSearchScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_map_place_search);
        this.filterCities = getIntent().getBooleanExtra("filterCities", false);
        this.forceFilterCities = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.FORCEFILTERCITY, false);
        this.isCurrentLocationAvail = getIntent().getBooleanExtra("currentLocationAvail", false);
        this.isFromBrandOrReorder = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, false);
        this.isFromReOrder = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, false);
        String stringExtra = getIntent().getStringExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.reorderResNam = stringExtra;
        initView();
        int i11 = R.id.ed_search_location;
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(i11);
        if (materialEditText != null) {
            materialEditText.setOnClickListener(new f8(this));
        }
        MaterialEditText materialEditText2 = (MaterialEditText) _$_findCachedViewById(i11);
        if (materialEditText2 != null) {
            materialEditText2.addTextChangedListener(new HomeMapPlaceSearchScreen$onCreate$2(this));
        }
        ((ImageView) _$_findCachedViewById(R.id.back_btn)).setOnClickListener(new g8(this));
    }

    public void onError() {
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void onLatLongRecieved(@Nullable SuggestedPlaceDetails suggestedPlaceDetails, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "placeName");
        onTrackGeoLocationRequested("True", (Address) null, "");
        this.requestScheduled = false;
        Intrinsics.checkNotNull(suggestedPlaceDetails);
        if (suggestedPlaceDetails.latitude <= 0.0d || suggestedPlaceDetails.longitude <= 0.0d) {
            finish();
            return;
        }
        AppTracker.onMapSearchComplete(this, "searchResultSelected");
        Intent intent = new Intent();
        double d11 = suggestedPlaceDetails.latitude;
        double d12 = suggestedPlaceDetails.longitude;
        intent.putExtra("location", d11 + "," + d12);
        intent.putExtra("currentLocEnabled", this.isCurrentLocationAvail);
        intent.putExtra("DelAreaName", str);
        setResult(-1, intent);
        finish();
    }

    public void onNoSuggestionsFound() {
        searchClearVisible();
        ((ProgressBar) _$_findCachedViewById(R.id.places_loading_indicator)).setVisibility(8);
        if (String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.ed_search_location)).getText()).length() > 0) {
            ((RelativeLayout) _$_findCachedViewById(R.id.no_search_result_found)).setVisibility(0);
        } else {
            ((RelativeLayout) _$_findCachedViewById(R.id.no_search_result_found)).setVisibility(8);
        }
        this.requestScheduled = false;
        reloadAreaFragment();
    }

    public void onScheduleRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "keyword");
        try {
            if (!this.requestScheduled && !Intrinsics.areEqual((Object) this.previousKeyword, (Object) str)) {
                this.timeleft = 4 - (((int) ((System.currentTimeMillis() - this.previousTime) / ((long) 500))) % 60);
                this.mHandler = new Handler();
                HomeMapPlaceSearchScreen$onScheduleRequest$1 homeMapPlaceSearchScreen$onScheduleRequest$1 = new HomeMapPlaceSearchScreen$onScheduleRequest$1(this);
                this.runnable = homeMapPlaceSearchScreen$onScheduleRequest$1;
                homeMapPlaceSearchScreen$onScheduleRequest$1.run();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onSearchResultAvail(boolean z11) {
        if (z11) {
            GooglePlaceSearchAdapter googlePlaceSearchAdapter = this.mGooglePlaceSearchAdapter;
            if (googlePlaceSearchAdapter != null) {
                googlePlaceSearchAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        GooglePlaceSearchAdapter googlePlaceSearchAdapter2 = this.mGooglePlaceSearchAdapter;
        if (googlePlaceSearchAdapter2 != null) {
            googlePlaceSearchAdapter2.notifyDataSetChanged();
        }
    }

    public void onSuggestionsLoaded(@NotNull ArrayList<PlacesSuggestionResponse> arrayList) {
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(arrayList, "placesSuggestionArrayList");
        this.requestScheduled = false;
        this.isSearchRequestSend = false;
        String valueOf = String.valueOf(((MaterialEditText) _$_findCachedViewById(R.id.ed_search_location)).getText());
        int length = valueOf.length() - 1;
        int i12 = 0;
        boolean z12 = false;
        while (i12 <= length) {
            if (!z12) {
                i11 = i12;
            } else {
                i11 = length;
            }
            if (Intrinsics.compare((int) valueOf.charAt(i11), 32) <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z12) {
                if (!z11) {
                    z12 = true;
                } else {
                    i12++;
                }
            } else if (!z11) {
                break;
            } else {
                length--;
            }
        }
        if (!TalabatUtils.isNullOrEmpty(valueOf.subSequence(i12, length + 1).toString())) {
            ((RelativeLayout) _$_findCachedViewById(R.id.google_place_search_container)).setVisibility(0);
            ((RecyclerView) _$_findCachedViewById(R.id.place_search_list)).setVisibility(0);
            ((FrameLayout) _$_findCachedViewById(R.id.choose_area_fragment)).setVisibility(8);
        } else {
            ((RelativeLayout) _$_findCachedViewById(R.id.google_place_search_container)).setVisibility(8);
            ((FrameLayout) _$_findCachedViewById(R.id.choose_area_fragment)).setVisibility(0);
            ((RecyclerView) _$_findCachedViewById(R.id.place_search_list)).setVisibility(8);
        }
        int size = arrayList.size();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Activity - came here, ");
        sb2.append(size);
        ArrayList<PlacesSuggestionResponse> arrayList2 = this.placesSuggestionArrayList;
        if (arrayList2 == null) {
            this.placesSuggestionArrayList = new ArrayList<>();
        } else if (arrayList2 != null) {
            arrayList2.clear();
        }
        ((RelativeLayout) _$_findCachedViewById(R.id.no_search_result_found)).setVisibility(8);
        this.placesSuggestionArrayList = arrayList;
        this.mGooglePlaceSearchAdapter = new GooglePlaceSearchAdapter(this, arrayList, this);
        ((RecyclerView) _$_findCachedViewById(R.id.place_search_list)).setAdapter(this.mGooglePlaceSearchAdapter);
        GooglePlaceSearchAdapter googlePlaceSearchAdapter = this.mGooglePlaceSearchAdapter;
        Intrinsics.checkNotNull(googlePlaceSearchAdapter);
        googlePlaceSearchAdapter.notifyDataSetChanged();
        ((ProgressBar) _$_findCachedViewById(R.id.places_loading_indicator)).setVisibility(8);
        searchClearVisible();
    }

    public final void removeSearchFocus() {
        int i11 = R.id.ed_search_location;
        ((MaterialEditText) _$_findCachedViewById(i11)).setFocusableInTouchMode(false);
        ((MaterialEditText) _$_findCachedViewById(i11)).setFocusable(false);
        ((MaterialEditText) _$_findCachedViewById(i11)).setFocusableInTouchMode(true);
        ((MaterialEditText) _$_findCachedViewById(i11)).setFocusable(true);
    }

    public final void scheduleRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "keyword");
        try {
            if (!this.requestScheduled && !Intrinsics.areEqual((Object) this.previousKeyword, (Object) str)) {
                this.timeleft = 4 - (((int) ((System.currentTimeMillis() - this.previousTime) / ((long) 500))) % 60);
                this.mHandler = new Handler();
                HomeMapPlaceSearchScreen$scheduleRequest$1 homeMapPlaceSearchScreen$scheduleRequest$1 = new HomeMapPlaceSearchScreen$scheduleRequest$1(this);
                this.runnable = homeMapPlaceSearchScreen$scheduleRequest$1;
                homeMapPlaceSearchScreen$scheduleRequest$1.run();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    @NotNull
    public final EditText searchFld() {
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(R.id.ed_search_location);
        if (materialEditText != null) {
            return materialEditText;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
    }

    public final void setAppVersionProvider(@NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "<set-?>");
        this.appVersionProvider = appVersionProvider2;
    }

    public final void setCurrentLocationAvail(boolean z11) {
        this.isCurrentLocationAvail = z11;
    }

    public final void setDeliveryAreaCurrentLocation(@NotNull LatLng latLng, boolean z11) {
        Intrinsics.checkNotNullParameter(latLng, Param.LAT_LNG);
        if (latLng.latitude > 0.0d && latLng.longitude > 0.0d) {
            AppTracker.onMapSearchComplete(this, "currentLocation");
            Intent intent = new Intent();
            double d11 = latLng.latitude;
            double d12 = latLng.longitude;
            intent.putExtra("location", d11 + "," + d12);
            intent.putExtra("currentLocEnabled", z11);
            setResult(-1, intent);
            finish();
        }
    }

    public final void setDeliveryAreaResult(@NotNull Area area) {
        Double d11;
        Double d12;
        Intrinsics.checkNotNullParameter(area, "area");
        Intent intent = new Intent();
        if (this.isFromBrandOrReorder) {
            DeliveryArea[] deliveryAreaArr = GlobalDataModel.restaurantDeliveryAreas;
            Intrinsics.checkNotNullExpressionValue(deliveryAreaArr, "restaurantDeliveryAreas");
            int length = deliveryAreaArr.length;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                DeliveryArea deliveryArea = deliveryAreaArr[i12];
                if (deliveryArea.f13835id == area.f13835id) {
                    i11 = deliveryArea.branchId;
                    break;
                }
                i12++;
            }
            LatLng areaCenterLatLg = HomeMapUtils.INSTANCE.areaCenterLatLg(area.f13835id, getLocationConfigurationRepository());
            intent.putExtra("DeliveryAreaBranchId", i11);
            if (areaCenterLatLg != null) {
                intent.putExtra("location", areaCenterLatLg.latitude + "," + areaCenterLatLg.longitude);
            }
        } else {
            Double d13 = null;
            if (TalabatUtils.isNullOrEmpty(area.areCenterPoint)) {
                HomeMapUtils homeMapUtils = HomeMapUtils.INSTANCE;
                LatLng defaultCountryLatLang = homeMapUtils.defaultCountryLatLang();
                if (defaultCountryLatLang != null) {
                    d11 = Double.valueOf(defaultCountryLatLang.latitude);
                } else {
                    d11 = null;
                }
                LatLng defaultCountryLatLang2 = homeMapUtils.defaultCountryLatLang();
                if (defaultCountryLatLang2 != null) {
                    d13 = Double.valueOf(defaultCountryLatLang2.longitude);
                }
                intent.putExtra("location", d11 + "," + d13);
            } else if (area.getAreCenterPoint().latitude <= 0.0d || area.getAreCenterPoint().longitude <= 0.0d) {
                HomeMapUtils homeMapUtils2 = HomeMapUtils.INSTANCE;
                LatLng defaultCountryLatLang3 = homeMapUtils2.defaultCountryLatLang();
                if (defaultCountryLatLang3 != null) {
                    d12 = Double.valueOf(defaultCountryLatLang3.latitude);
                } else {
                    d12 = null;
                }
                LatLng defaultCountryLatLang4 = homeMapUtils2.defaultCountryLatLang();
                if (defaultCountryLatLang4 != null) {
                    d13 = Double.valueOf(defaultCountryLatLang4.longitude);
                }
                intent.putExtra("location", d12 + "," + d13);
            } else {
                intent.putExtra("location", area.getAreCenterPoint().latitude + "," + area.getAreCenterPoint().longitude);
            }
        }
        intent.putExtra("isAreaCenterCor", true);
        intent.putExtra("DelAreaName", area.areaName);
        setResult(-1, intent);
        AppTracker.onMapSearchComplete(this, "areaSelected");
        finish();
    }

    public final void setDeliveyAreaFragment(@Nullable Fragment fragment) {
        this.deliveyAreaFragment = fragment;
    }

    public final void setFromCurrentLocationRequest(boolean z11) {
        this.isFromCurrentLocationRequest = z11;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setMHandler(@Nullable Handler handler) {
        this.mHandler = handler;
    }

    public final void setRunnable(@Nullable Runnable runnable2) {
        this.runnable = runnable2;
    }
}
