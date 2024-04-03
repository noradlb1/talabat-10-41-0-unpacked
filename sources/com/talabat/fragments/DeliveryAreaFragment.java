package com.talabat.fragments;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.HomeMapPlaceSearchScreen;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.adapters.homeMap.HomeMapSearchAreaAdapter;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.delivery.DaggerDeliveryAreaFragmentComponent;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatFragment;
import com.talabat.helpers.TalabatUtils;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.maputils.CurrentLocHelper;
import datamodels.Area;
import datamodels.AreaExpandableListViewModel;
import datamodels.Restaurant;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import datamodels.mappers.AreaToOldAreaMapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemapsearch.DeliveryAreaView;
import mq.d;
import mq.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;

@Instrumented
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020BH\u0002J\b\u0010L\u001a\u00020BH\u0002J\u0006\u0010M\u001a\u00020\u0015J\u0018\u0010N\u001a\u00020B2\u0006\u0010N\u001a\u00020\u00152\u0006\u0010I\u001a\u00020JH\u0016J8\u0010O\u001a\u00020B2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0002J\u0010\u0010P\u001a\u00020B2\u0006\u0010Q\u001a\u00020\u0015H\u0002J\u0016\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u0015J\u0016\u0010U\u001a\u00020B2\u0006\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u0015J\u0010\u0010V\u001a\u00020B2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010W\u001a\u00020B2\u0006\u0010X\u001a\u00020\fH\u0016J\u0010\u0010Y\u001a\u00020B2\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010Z\u001a\u00020B2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J&\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\"\u0010c\u001a\u00020B2\b\u0010d\u001a\u0004\u0018\u00010J2\u0006\u0010e\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u00020B2\u0006\u0010I\u001a\u00020J2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0015H\u0016J\u0010\u0010k\u001a\u00020B2\u0006\u0010l\u001a\u00020\u0015H\u0002J\b\u0010m\u001a\u00020BH\u0016J\u0006\u0010n\u001a\u00020BR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/talabat/fragments/DeliveryAreaFragment;", "Lcom/talabat/helpers/TalabatFragment;", "Llibrary/talabat/mvp/homemapsearch/DeliveryAreaView;", "Lcom/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$onItemClickListener;", "Lcom/talabat/homemaphelper/CurrentLocationListener;", "()V", "addressTitle", "Lcom/talabat/TalabatTextView;", "areaToOldAreaMapper", "Ldatamodels/mappers/AreaToOldAreaMapper;", "areas", "", "Ldatamodels/Area;", "[Ldatamodels/Area;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "currentLocationAvail", "", "currentLocationContainer", "Landroid/widget/RelativeLayout;", "currentLocationFetch", "Lcom/talabat/homemaphelper/CurrentLocationFetch;", "currentLoctionImg", "Landroid/widget/ImageView;", "curretnLocationTxt", "data", "Ljava/util/ArrayList;", "Ldatamodels/AreaExpandableListViewModel;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "displayData", "getDisplayData", "setDisplayData", "enableLocationProgress", "Landroid/widget/ProgressBar;", "explistView", "Landroid/widget/ExpandableListView;", "filterCities", "filterCityId", "", "forceFilterCities", "gpsEnableBtn", "Landroid/widget/Button;", "isFromBrandOrReorder", "isFromCurrentLocationRequest", "keyBoardHidden", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mActivity", "Landroid/app/Activity;", "mLocationManager", "Landroid/location/LocationManager;", "reOrderResName", "", "OnCurrentLocationPermissionStatus", "", "response", "Lcom/karumi/dexter/listener/PermissionDeniedResponse;", "checkPermission", "context", "Landroid/content/Context;", "deliverToCLRecived", "currentLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "fetchFusedCurrentLocation", "hideKeyBoard", "isLocationServiceEnabled", "isRefreshMap", "loadAreaAdapter", "loadCurrentLocationView", "isCheckLocation", "loadListDeliveryAddressList", "filterCity", "forceFilterCity", "loadRestaurantDeliveryAreas", "mapCurrentLocReceived", "onAreaSelected", "area", "onAttach", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCurrentLocationReceived", "location", "isShowLocationInAccurateAlert", "lococaccuracy", "", "onCurrentLocationReceivedWithLowAccuracy", "onGeoLocationDialogAccepted", "locationRequestStatus", "onLocationDialogAccepted", "locationEnabled", "onResume", "resetKeyBord", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryAreaFragment extends TalabatFragment implements DeliveryAreaView, HomeMapSearchAreaAdapter.onItemClickListener, CurrentLocationListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private TalabatTextView addressTitle;
    @NotNull
    private final AreaToOldAreaMapper areaToOldAreaMapper = new AreaToOldAreaMapper();
    @Nullable
    private Area[] areas;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private boolean currentLocationAvail;
    @Nullable
    private RelativeLayout currentLocationContainer;
    @Nullable
    private CurrentLocationFetch currentLocationFetch;
    @Nullable
    private ImageView currentLoctionImg;
    @Nullable
    private TalabatTextView curretnLocationTxt;
    public ArrayList<AreaExpandableListViewModel> data;
    public ArrayList<AreaExpandableListViewModel> displayData;
    @Nullable
    private ProgressBar enableLocationProgress;
    @Nullable
    private ExpandableListView explistView;
    private boolean filterCities;
    private int filterCityId;
    private boolean forceFilterCities;
    @Nullable
    private Button gpsEnableBtn;
    private boolean isFromBrandOrReorder;
    private boolean isFromCurrentLocationRequest;
    private boolean keyBoardHidden;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private Activity mActivity;
    @Nullable
    private LocationManager mLocationManager;
    @NotNull
    private String reOrderResName = "";

    private final boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private final void fetchFusedCurrentLocation() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.currentLocationFetch = new CurrentLocationFetch(this, activity);
            ProgressBar progressBar = this.enableLocationProgress;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            CurrentLocationFetch currentLocationFetch2 = this.currentLocationFetch;
            if (currentLocationFetch2 != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    currentLocationFetch2.initLocationRequest(activity2, CurrentLocHelper.INSTANCE.getIS_IGNORE());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
            }
            CurrentLocationFetch currentLocationFetch3 = this.currentLocationFetch;
            if (currentLocationFetch3 != null) {
                currentLocationFetch3.fetchCurrentLocation();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    private final void hideKeyBoard() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                inputMethodManager.hideSoftInputFromWindow(((HomeMapPlaceSearchScreen) activity).searchFld().getWindowToken(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.HomeMapPlaceSearchScreen");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void loadAreaAdapter(ArrayList<AreaExpandableListViewModel> arrayList, ArrayList<AreaExpandableListViewModel> arrayList2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HomeMapSearchAreaAdapter homeMapSearchAreaAdapter = new HomeMapSearchAreaAdapter(activity, arrayList, arrayList2, this);
            ExpandableListView expandableListView = this.explistView;
            if (expandableListView != null) {
                expandableListView.setAdapter(homeMapSearchAreaAdapter);
            }
            if (arrayList2.size() == 1) {
                int groupCount = homeMapSearchAreaAdapter.getGroupCount();
                for (int i11 = 0; i11 < groupCount; i11++) {
                    ExpandableListView expandableListView2 = this.explistView;
                    if (expandableListView2 != null) {
                        expandableListView2.expandGroup(i11);
                    }
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    private final void loadCurrentLocationView(boolean z11) {
        ProgressBar progressBar = this.enableLocationProgress;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (isLocationServiceEnabled()) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            } else if (checkPermission(activity)) {
                ImageView imageView = this.currentLoctionImg;
                if (imageView != null) {
                    Context context = getContext();
                    Intrinsics.checkNotNull(context);
                    imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_m_gps_on));
                }
                TalabatTextView talabatTextView = this.curretnLocationTxt;
                if (talabatTextView != null) {
                    talabatTextView.setText(getResources().getString(R.string.current_gps_location));
                }
                TalabatTextView talabatTextView2 = this.curretnLocationTxt;
                if (talabatTextView2 != null) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNull(context2);
                    talabatTextView2.setTextColor(ContextCompat.getColor(context2, R.color.colorSecondary));
                }
            } else {
                ImageView imageView2 = this.currentLoctionImg;
                if (imageView2 != null) {
                    Context context3 = getContext();
                    Intrinsics.checkNotNull(context3);
                    imageView2.setImageDrawable(ContextCompat.getDrawable(context3, R.drawable.ic_m_gps_off));
                }
                TalabatTextView talabatTextView3 = this.curretnLocationTxt;
                if (talabatTextView3 != null) {
                    talabatTextView3.setText(getResources().getString(R.string.gps_off_title));
                }
                TalabatTextView talabatTextView4 = this.curretnLocationTxt;
                if (talabatTextView4 != null) {
                    Context context4 = getContext();
                    Intrinsics.checkNotNull(context4);
                    talabatTextView4.setTextColor(ContextCompat.getColor(context4, R.color.text_black));
                }
            }
        } else {
            ImageView imageView3 = this.currentLoctionImg;
            if (imageView3 != null) {
                Context context5 = getContext();
                Intrinsics.checkNotNull(context5);
                imageView3.setImageDrawable(ContextCompat.getDrawable(context5, R.drawable.ic_m_gps_off));
            }
            TalabatTextView talabatTextView5 = this.curretnLocationTxt;
            if (talabatTextView5 != null) {
                talabatTextView5.setText(getResources().getString(R.string.gps_off_title));
            }
            TalabatTextView talabatTextView6 = this.curretnLocationTxt;
            if (talabatTextView6 != null) {
                Context context6 = getContext();
                Intrinsics.checkNotNull(context6);
                talabatTextView6.setTextColor(ContextCompat.getColor(context6, R.color.text_black));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final boolean m10482onCreateView$lambda0(DeliveryAreaFragment deliveryAreaFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(deliveryAreaFragment, "this$0");
        if (deliveryAreaFragment.keyBoardHidden) {
            return false;
        }
        deliveryAreaFragment.hideKeyBoard();
        FragmentActivity activity = deliveryAreaFragment.getActivity();
        if (activity != null) {
            ((HomeMapPlaceSearchScreen) activity).removeSearchFocus();
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.HomeMapPlaceSearchScreen");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m10483onCreateView$lambda1(DeliveryAreaFragment deliveryAreaFragment, View view) {
        Intrinsics.checkNotNullParameter(deliveryAreaFragment, "this$0");
        deliveryAreaFragment.fetchFusedCurrentLocation();
    }

    private final void onLocationDialogAccepted(boolean z11) {
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        String str = AppTracker.NotAvail;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z11);
        String sb3 = sb2.toString();
        String locationPromptType = trackingUtils.getLocationPromptType();
        String str2 = AppTracker.NotAvail;
        AddressAnalyticsTracker trackingAddressObject = trackingUtils.getTrackingAddressObject(context, true, (Address) null, (Integer) null, 0, str, str, ScreenNames.HOME_MAP_PLACE_SEARCH_SCREEN, str, str, str, str, sb3, locationPromptType, str2, str2, str2, str2, true, str2);
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        AppTracker.onGeoLocationDialogAccepted(context2, trackingAddressObject);
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        Intrinsics.checkNotNullParameter(permissionDeniedResponse, "response");
        ProgressBar progressBar = this.enableLocationProgress;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this.currentLocationAvail = false;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void deliverToCLRecived(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final ArrayList<AreaExpandableListViewModel> getData() {
        ArrayList<AreaExpandableListViewModel> arrayList = this.data;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    @NotNull
    public final ArrayList<AreaExpandableListViewModel> getDisplayData() {
        ArrayList<AreaExpandableListViewModel> arrayList = this.displayData;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("displayData");
        return null;
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

    public final boolean isLocationServiceEnabled() {
        Object obj;
        if (this.mLocationManager == null) {
            Context context = getContext();
            if (context != null) {
                obj = context.getSystemService("location");
            } else {
                obj = null;
            }
            if (obj != null) {
                this.mLocationManager = (LocationManager) obj;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
            }
        }
        try {
            LocationManager locationManager = this.mLocationManager;
            Intrinsics.checkNotNull(locationManager);
            return locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public void isRefreshMap(boolean z11, @NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0062, code lost:
        if (r2 == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005e, code lost:
        if (r1.isCityInAddress == true) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadListDeliveryAddressList(boolean r11, boolean r12) {
        /*
            r10 = this;
            com.talabat.configuration.location.LocationConfigurationRepository r0 = r10.getLocationConfigurationRepository()
            com.talabat.configuration.location.LocationConfig r0 = r0.config()
            java.util.List r0 = r0.getAreas()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            datamodels.mappers.AreaToOldAreaMapper r1 = r10.areaToOldAreaMapper
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r0.next()
            com.talabat.configuration.location.Area r3 = (com.talabat.configuration.location.Area) r3
            datamodels.Area r3 = r1.apply((com.talabat.configuration.location.Area) r3)
            r2.add(r3)
            goto L_0x001f
        L_0x0033:
            r0 = 0
            datamodels.Area[] r1 = new datamodels.Area[r0]
            java.lang.Object[] r1 = r2.toArray(r1)
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            datamodels.Area[] r1 = (datamodels.Area[]) r1
            r10.areas = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r10.setData(r1)
            com.talabat.configuration.ConfigurationLocalRepository r1 = r10.getConfigurationLocalRepository()
            com.talabat.configuration.location.LocationConfigurationRepository r2 = r10.getLocationConfigurationRepository()
            datamodels.Country r1 = com.talabat.helpers.TalabatUtils.getSelectedCountry(r1, r2)
            if (r11 == 0) goto L_0x0064
            if (r1 == 0) goto L_0x0061
            boolean r11 = r1.isCityInAddress
            r2 = 1
            if (r11 != r2) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r2 = r0
        L_0x0062:
            if (r2 != 0) goto L_0x0066
        L_0x0064:
            if (r12 == 0) goto L_0x00aa
        L_0x0066:
            datamodels.AreaExpandableListViewModel r11 = new datamodels.AreaExpandableListViewModel
            r11.<init>()
            java.lang.String r12 = com.talabat.helpers.GlobalDataModel.SelectedCityName
            r11.setCityName(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r11.setAreas(r12)
            datamodels.Area[] r12 = r10.areas
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            int r1 = r12.length
        L_0x007e:
            if (r0 >= r1) goto L_0x0095
            r2 = r12[r0]
            int r3 = r2.cityId
            int r4 = r10.filterCityId
            if (r3 != r4) goto L_0x0092
            java.util.ArrayList r3 = r11.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.add(r2)
        L_0x0092:
            int r0 = r0 + 1
            goto L_0x007e
        L_0x0095:
            java.util.ArrayList r12 = r11.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            int r12 = r12.size()
            if (r12 <= 0) goto L_0x0103
            java.util.ArrayList r12 = r10.getData()
            r12.add(r11)
            goto L_0x0103
        L_0x00aa:
            if (r1 == 0) goto L_0x00af
            datamodels.City[] r11 = r1.cities
            goto L_0x00b0
        L_0x00af:
            r11 = 0
        L_0x00b0:
            if (r11 != 0) goto L_0x00b4
            datamodels.City[] r11 = new datamodels.City[r0]
        L_0x00b4:
            datamodels.City[] r11 = (datamodels.City[]) r11
            int r12 = r11.length
            r1 = r0
        L_0x00b8:
            if (r1 >= r12) goto L_0x0103
            r2 = r11[r1]
            datamodels.AreaExpandableListViewModel r3 = new datamodels.AreaExpandableListViewModel
            r3.<init>()
            java.lang.String r4 = r2.f13844name
            r3.setCityName(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3.setAreas(r4)
            datamodels.Area[] r4 = r10.areas
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r5 = r4.length
            r6 = r0
        L_0x00d5:
            if (r6 >= r5) goto L_0x00ec
            r7 = r4[r6]
            int r8 = r7.cityId
            int r9 = r2.f13843id
            if (r8 != r9) goto L_0x00e9
            java.util.ArrayList r8 = r3.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.add(r7)
        L_0x00e9:
            int r6 = r6 + 1
            goto L_0x00d5
        L_0x00ec:
            java.util.ArrayList r2 = r3.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0100
            java.util.ArrayList r2 = r10.getData()
            r2.add(r3)
        L_0x0100:
            int r1 = r1 + 1
            goto L_0x00b8
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fragments.DeliveryAreaFragment.loadListDeliveryAddressList(boolean, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        if (r0.isCityInAddress == true) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r2 == false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadRestaurantDeliveryAreas(boolean r11, boolean r12) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.setData(r0)
            com.talabat.configuration.ConfigurationLocalRepository r0 = r10.getConfigurationLocalRepository()
            com.talabat.configuration.location.LocationConfigurationRepository r1 = r10.getLocationConfigurationRepository()
            datamodels.Country r0 = com.talabat.helpers.TalabatUtils.getSelectedCountry(r0, r1)
            r1 = 0
            if (r11 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x001f
            boolean r11 = r0.isCityInAddress
            r2 = 1
            if (r11 != r2) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r2 = r1
        L_0x0020:
            if (r2 != 0) goto L_0x0024
        L_0x0022:
            if (r12 == 0) goto L_0x0068
        L_0x0024:
            datamodels.AreaExpandableListViewModel r11 = new datamodels.AreaExpandableListViewModel
            r11.<init>()
            java.lang.String r12 = com.talabat.helpers.GlobalDataModel.SelectedCityName
            r11.setCityName(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r11.setAreas(r12)
            datamodels.Area[] r12 = r10.areas
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            int r0 = r12.length
        L_0x003c:
            if (r1 >= r0) goto L_0x0053
            r2 = r12[r1]
            int r3 = r2.cityId
            int r4 = r10.filterCityId
            if (r3 != r4) goto L_0x0050
            java.util.ArrayList r3 = r11.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.add(r2)
        L_0x0050:
            int r1 = r1 + 1
            goto L_0x003c
        L_0x0053:
            java.util.ArrayList r12 = r11.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            int r12 = r12.size()
            if (r12 <= 0) goto L_0x00c1
            java.util.ArrayList r12 = r10.getData()
            r12.add(r11)
            goto L_0x00c1
        L_0x0068:
            if (r0 == 0) goto L_0x006d
            datamodels.City[] r11 = r0.cities
            goto L_0x006e
        L_0x006d:
            r11 = 0
        L_0x006e:
            if (r11 != 0) goto L_0x0072
            datamodels.City[] r11 = new datamodels.City[r1]
        L_0x0072:
            datamodels.City[] r11 = (datamodels.City[]) r11
            int r12 = r11.length
            r0 = r1
        L_0x0076:
            if (r0 >= r12) goto L_0x00c1
            r2 = r11[r0]
            datamodels.AreaExpandableListViewModel r3 = new datamodels.AreaExpandableListViewModel
            r3.<init>()
            java.lang.String r4 = r2.f13844name
            r3.setCityName(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3.setAreas(r4)
            datamodels.Area[] r4 = r10.areas
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r5 = r4.length
            r6 = r1
        L_0x0093:
            if (r6 >= r5) goto L_0x00aa
            r7 = r4[r6]
            int r8 = r7.cityId
            int r9 = r2.f13843id
            if (r8 != r9) goto L_0x00a7
            java.util.ArrayList r8 = r3.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.add(r7)
        L_0x00a7:
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00aa:
            java.util.ArrayList r2 = r3.getAreas()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x00be
            java.util.ArrayList r2 = r10.getData()
            r2.add(r3)
        L_0x00be:
            int r0 = r0 + 1
            goto L_0x0076
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fragments.DeliveryAreaFragment.loadRestaurantDeliveryAreas(boolean, boolean):void");
    }

    public void mapCurrentLocReceived(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public void onAreaSelected(@NotNull Area area) {
        Intrinsics.checkNotNullParameter(area, "area");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((HomeMapPlaceSearchScreen) activity).setDeliveryAreaResult(area);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.HomeMapPlaceSearchScreen");
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerDeliveryAreaFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.frag_delivery_areas, viewGroup, false);
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        this.currentLocationAvail = arguments.getBoolean("locationAvail", false);
        Bundle arguments2 = getArguments();
        Intrinsics.checkNotNull(arguments2);
        this.isFromCurrentLocationRequest = arguments2.getBoolean("isFromCurrentLocationRequest", false);
        Bundle arguments3 = getArguments();
        Intrinsics.checkNotNull(arguments3);
        this.isFromBrandOrReorder = arguments3.getBoolean(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, false);
        Bundle arguments4 = getArguments();
        Intrinsics.checkNotNull(arguments4);
        String str2 = "";
        String string = arguments4.getString(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME, str2);
        Intrinsics.checkNotNullExpressionValue(string, "arguments!!.getString(Gl…es.RE_ORDER_RES_NAME, \"\")");
        this.reOrderResName = string;
        if (this.isFromBrandOrReorder) {
            Bundle arguments5 = getArguments();
            Intrinsics.checkNotNull(arguments5);
            String string2 = arguments5.getString("areas", str2);
            if (!TalabatUtils.isNullOrEmpty(string2)) {
                Gson gson = UniversalGson.INSTANCE.gson;
                Class cls = Area[].class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(string2, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, string2, cls);
                }
                this.areas = (Area[]) obj;
                loadRestaurantDeliveryAreas(this.filterCities, this.forceFilterCities);
            } else {
                loadListDeliveryAddressList(this.filterCities, this.forceFilterCities);
            }
        } else {
            loadListDeliveryAddressList(this.filterCities, this.forceFilterCities);
        }
        setDisplayData(new ArrayList());
        getDisplayData().addAll(getData());
        View findViewById = inflate.findViewById(R.id.area_exp_list);
        if (findViewById != null) {
            this.explistView = (ExpandableListView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.gps_enable_container);
            if (findViewById2 != null) {
                this.currentLocationContainer = (RelativeLayout) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.gps_icon);
                if (findViewById3 != null) {
                    this.currentLoctionImg = (ImageView) findViewById3;
                    View findViewById4 = inflate.findViewById(R.id.current_location_title);
                    if (findViewById4 != null) {
                        this.curretnLocationTxt = (TalabatTextView) findViewById4;
                        this.enableLocationProgress = (ProgressBar) inflate.findViewById(R.id.enable_location_progress);
                        View findViewById5 = inflate.findViewById(R.id.address_title);
                        if (findViewById5 != null) {
                            this.addressTitle = (TalabatTextView) findViewById5;
                            if (this.isFromBrandOrReorder) {
                                if (!TalabatUtils.isNullOrEmpty(this.reOrderResName)) {
                                    str2 = this.reOrderResName;
                                } else {
                                    Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
                                    if (restaurant != null) {
                                        str2 = restaurant.f13873name;
                                        Intrinsics.checkNotNullExpressionValue(str2, "restaurant.name");
                                    }
                                }
                                if (TalabatUtils.isNullOrEmpty(str2)) {
                                    str = getResources().getString(R.string.rest_delivey_areas);
                                    Intrinsics.checkNotNullExpressionValue(str, "resources.getString(com.…tring.rest_delivey_areas)");
                                } else if (TalabatUtils.isRTL()) {
                                    str = getResources().getString(R.string.rest_delivey_areas) + " " + str2;
                                } else {
                                    str = str2 + " " + getResources().getString(R.string.rest_delivey_areas);
                                }
                                TalabatTextView talabatTextView = this.addressTitle;
                                if (talabatTextView != null) {
                                    talabatTextView.setText(str);
                                }
                            }
                            loadAreaAdapter(getData(), getDisplayData());
                            ExpandableListView expandableListView = this.explistView;
                            if (expandableListView != null) {
                                expandableListView.setOnTouchListener(new d(this));
                            }
                            RelativeLayout relativeLayout = this.currentLocationContainer;
                            if (relativeLayout != null) {
                                relativeLayout.setOnClickListener(new e(this));
                            }
                            return inflate;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.TalabatTextView");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.TalabatTextView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ExpandableListView");
    }

    public void onCurrentLocationReceived(@Nullable LatLng latLng, boolean z11, float f11) {
        this.currentLocationAvail = true;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            Activity activity = this.mActivity;
            if (activity == null) {
                return;
            }
            if (activity != null) {
                ((HomeMapPlaceSearchScreen) activity).setDeliveryAreaCurrentLocation(latLng2, this.currentLocationAvail);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.HomeMapPlaceSearchScreen");
        }
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull LatLng latLng, float f11) {
        Intrinsics.checkNotNullParameter(latLng, "currentLatLng");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
        onLocationDialogAccepted(z11);
    }

    public void onResume() {
        if (this.isFromCurrentLocationRequest) {
            fetchFusedCurrentLocation();
        } else {
            loadCurrentLocationView(true);
        }
        super.onResume();
    }

    public final void resetKeyBord() {
        this.keyBoardHidden = false;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setData(@NotNull ArrayList<AreaExpandableListViewModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void setDisplayData(@NotNull ArrayList<AreaExpandableListViewModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.displayData = arrayList;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }
}
