package com.talabat.splash.presentation.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.splash.core.platform.BaseFragment;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.domain.model.location.LocationRequestWrapper;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import com.talabat.talabatcommon.views.TalabatFillButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xu.a;
import xu.b;
import xu.c;
import xu.d;
import xu.e;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J+\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0017¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/splash/presentation/ui/LocationFetchFragment;", "Lcom/talabat/splash/core/platform/BaseFragment;", "Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModelInjectable;", "()V", "isOnboardingExpEnabled", "", "mLocationRequestType", "", "splashActivitySharedViewModel", "Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModel;", "allowLocation", "", "currentLocationObserve", "initView", "inject", "invokeCurrentLocationFetch", "invokeCurrentLocationStatusDenied", "layoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showViewsBasedOnExperiment", "isEnabled", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationFetchFragment extends BaseFragment implements SplashActivitySharedViewModelInjectable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int GPS_REQUEST = 101;
    private static final int LOCATION_REQUEST = 100;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean isOnboardingExpEnabled;
    private int mLocationRequestType;
    @Nullable
    private SplashActivitySharedViewModel splashActivitySharedViewModel;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/splash/presentation/ui/LocationFetchFragment$Companion;", "", "()V", "GPS_REQUEST", "", "LOCATION_REQUEST", "newInstance", "Lcom/talabat/splash/presentation/ui/LocationFetchFragment;", "param1", "isOnboardingExperiementEnabled", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final LocationFetchFragment newInstance(int i11, boolean z11) {
            LocationFetchFragment locationFetchFragment = new LocationFetchFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("param1", i11);
            bundle.putBoolean("is_onboarding_exp_enabled", z11);
            locationFetchFragment.setArguments(bundle);
            return locationFetchFragment;
        }
    }

    private final void allowLocation() {
        MutableLiveData<GpsStatus> gpsStatus;
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null && (gpsStatus = splashActivitySharedViewModel2.getGpsStatus()) != null) {
            gpsStatus.observe(getViewLifecycleOwner(), new c(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: allowLocation$lambda-3  reason: not valid java name */
    public static final void m10912allowLocation$lambda3(LocationFetchFragment locationFetchFragment, GpsStatus gpsStatus) {
        Intrinsics.checkNotNullParameter(locationFetchFragment, "this$0");
        if (gpsStatus instanceof GpsStatus.Enabled) {
            locationFetchFragment.currentLocationObserve();
        } else if (gpsStatus instanceof GpsStatus.GpsDenyFailure) {
            locationFetchFragment.startIntentSenderForResult(((GpsStatus.GpsDenyFailure) gpsStatus).getRae().getResolution().getIntentSender(), 101, (Intent) null, 0, 0, 0, (Bundle) null);
        }
    }

    private final void currentLocationObserve() {
        MutableLiveData<PermissionStatus> locationPerMissionStatus;
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null && (locationPerMissionStatus = splashActivitySharedViewModel2.getLocationPerMissionStatus()) != null) {
            locationPerMissionStatus.observe(getViewLifecycleOwner(), new d(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: currentLocationObserve$lambda-4  reason: not valid java name */
    public static final void m10913currentLocationObserve$lambda4(LocationFetchFragment locationFetchFragment, PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(locationFetchFragment, "this$0");
        if (permissionStatus instanceof PermissionStatus.Granted) {
            locationFetchFragment.invokeCurrentLocationFetch();
        } else if (permissionStatus instanceof PermissionStatus.Denied) {
            locationFetchFragment.invokeCurrentLocationStatusDenied();
        }
    }

    private final void initView() {
        ((TalabatFillButton) _$_findCachedViewById(R.id.allow_location)).setOnClickListener(new a(this));
        ((TalabatButton) _$_findCachedViewById(R.id.skip_now)).setOnClickListener(new b(this));
        showViewsBasedOnExperiment(this.isOnboardingExpEnabled);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m10914initView$lambda1(LocationFetchFragment locationFetchFragment, View view) {
        Intrinsics.checkNotNullParameter(locationFetchFragment, "this$0");
        locationFetchFragment.allowLocation();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m10915initView$lambda2(LocationFetchFragment locationFetchFragment, View view) {
        Intrinsics.checkNotNullParameter(locationFetchFragment, "this$0");
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = locationFetchFragment.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null) {
            splashActivitySharedViewModel2.showLoadingPopup();
        }
        SplashActivitySharedViewModel splashActivitySharedViewModel3 = locationFetchFragment.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel3 != null) {
            splashActivitySharedViewModel3.onDenyLocationRequest(new LocationRequestWrapper.LocationRequestDeny(false, SplashDataUtils.INSTANCE.getLOCATION_SKIP()));
        }
    }

    private final void invokeCurrentLocationFetch() {
        MutableLiveData<CurrentLocationWrapper> locationData;
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(R.id.allow_location);
        if (talabatFillButton != null) {
            talabatFillButton.setText(getString(R.string.fetching_current_loc));
        }
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null && (locationData = splashActivitySharedViewModel2.getLocationData(SplashDataUtils.INSTANCE.getLOCATION_RECEIVE_REQUEST())) != null) {
            locationData.observe(getViewLifecycleOwner(), new e(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeCurrentLocationFetch$lambda-5  reason: not valid java name */
    public static final void m10916invokeCurrentLocationFetch$lambda5(LocationFetchFragment locationFetchFragment, CurrentLocationWrapper currentLocationWrapper) {
        Intrinsics.checkNotNullParameter(locationFetchFragment, "this$0");
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = locationFetchFragment.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null) {
            Intrinsics.checkNotNullExpressionValue(currentLocationWrapper, "it");
            splashActivitySharedViewModel2.onLocationReceived(currentLocationWrapper);
        }
    }

    private final void invokeCurrentLocationStatusDenied() {
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 100);
    }

    @JvmStatic
    @NotNull
    public static final LocationFetchFragment newInstance(int i11, boolean z11) {
        return Companion.newInstance(i11, z11);
    }

    private final void showViewsBasedOnExperiment(boolean z11) {
        if (z11) {
            ((TalabatButton) _$_findCachedViewById(R.id.skip_now)).setVisibility(8);
            ((TalabatFillButton) _$_findCachedViewById(R.id.allow_location)).setText(getString(R.string.continue_with_permission));
            ((TalabatTextView) _$_findCachedViewById(R.id.location_msg_txt)).setText(getString(R.string.location_permission_reason));
            return;
        }
        ((TalabatButton) _$_findCachedViewById(R.id.skip_now)).setVisibility(0);
        ((TalabatFillButton) _$_findCachedViewById(R.id.allow_location)).setText(getString(R.string.welcome_allow_btn_text));
        ((TalabatTextView) _$_findCachedViewById(R.id.location_msg_txt)).setText(getString(R.string.welcome_msg_text));
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

    public void inject(@NotNull SplashActivitySharedViewModel splashActivitySharedViewModel2) {
        Intrinsics.checkNotNullParameter(splashActivitySharedViewModel2, "splashActivitySharedViewModel");
        this.splashActivitySharedViewModel = splashActivitySharedViewModel2;
    }

    public int layoutId() {
        return R.layout.fragment_current_location_fetch;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        SplashActivitySharedViewModel splashActivitySharedViewModel2;
        super.onActivityResult(i11, i12, intent);
        if (i11 != 101) {
            return;
        }
        if (i12 == -1) {
            currentLocationObserve();
        } else if (i12 == 0 && (splashActivitySharedViewModel2 = this.splashActivitySharedViewModel) != null) {
            splashActivitySharedViewModel2.onDenyLocationRequest(new LocationRequestWrapper.LocationRequestDeny(false, SplashDataUtils.INSTANCE.getLOCATION_GPS_DENY()));
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @SuppressLint({"MissingPermission"})
    public void onRequestPermissionsResult(int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (i11 == 100) {
            if (iArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!(!z11) || iArr[0] != 0) {
                SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivitySharedViewModel;
                if (splashActivitySharedViewModel2 != null) {
                    splashActivitySharedViewModel2.onDenyLocationRequest(new LocationRequestWrapper.LocationRequestDeny(false, SplashDataUtils.INSTANCE.getLOCATION_PERMISSION_DENY()));
                    return;
                }
                return;
            }
            invokeCurrentLocationFetch();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        if (!(arguments == null || getArguments() == null)) {
            this.mLocationRequestType = arguments.getInt("param1", 0);
            this.isOnboardingExpEnabled = arguments.getBoolean("is_onboarding_exp_enabled", false);
        }
        initView();
    }
}
