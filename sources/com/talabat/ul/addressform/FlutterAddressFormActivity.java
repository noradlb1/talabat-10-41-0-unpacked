package com.talabat.ul.addressform;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.talabat.AddAddressScreen2;
import com.talabat.R;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.uladdressform.domain.AddressFormFeatureApi;
import com.talabat.maps.domain.model.LatLng;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/talabat/ul/addressform/FlutterAddressFormActivity;", "Lcom/talabat/AddAddressScreen2;", "", "setOrientation", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "refreshFragment", "", "u0", "", "latitude", "longitude", "isAccurate", "isAutomatic", "flutterOnRedirectToMapScreen", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroy", "Lcom/talabat/ul/addressform/FlutterAddressFormFragment;", "flutterAddressFormFragment", "Lcom/talabat/ul/addressform/FlutterAddressFormFragment;", "refreshLocation", "Z", "getRefreshLocation", "()Z", "setRefreshLocation", "(Z)V", "<init>", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public final class FlutterAddressFormActivity extends AddAddressScreen2 {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private FlutterAddressFormFragment flutterAddressFormFragment;
    private boolean refreshLocation;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/ul/addressform/FlutterAddressFormActivity$Companion;", "", "()V", "getAddressFormActivityIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "screenNames", "", "getAddressFormActivityIntentEditMode", "latlngNotAvailabe", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent getAddressFormActivityIntent(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenNames");
            if (((AddressFormFeatureApi) AndroidComponentsKt.apiContainer(context).getFeature(AddressFormFeatureApi.class)).getAddressFormRouteUseCase().flutterAddressFormEnable(str)) {
                return new Intent(context, FlutterAddressFormActivity.class);
            }
            return new Intent(context, AddAddressScreen2.class);
        }

        @JvmStatic
        @NotNull
        public final Intent getAddressFormActivityIntentEditMode(@NotNull Context context, @NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenNames");
            if (z11) {
                return getAddressFormActivityIntent(context, str);
            }
            return new Intent(context, AddAddressScreen2.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent getAddressFormActivityIntent(@NotNull Context context, @NotNull String str) {
        return Companion.getAddressFormActivityIntent(context, str);
    }

    @JvmStatic
    @NotNull
    public static final Intent getAddressFormActivityIntentEditMode(@NotNull Context context, @NotNull String str, boolean z11) {
        return Companion.getAddressFormActivityIntentEditMode(context, str, z11);
    }

    private final void setOrientation() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
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

    public final void flutterOnRedirectToMapScreen(double d11, double d12, boolean z11, boolean z12) {
        onRedirectToMapScreen(this.f53505q.createLatLng(d11, d12), z11, z12);
    }

    public final boolean getRefreshLocation() {
        return this.refreshLocation;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (i11 == 99 || i11 == 100) {
            FlutterAddressFormFragment flutterAddressFormFragment2 = this.flutterAddressFormFragment;
            if (flutterAddressFormFragment2 != null) {
                flutterAddressFormFragment2.setRefreshingLocation(true);
            }
            this.refreshLocation = true;
        }
        super.onActivityResult(i11, i12, intent);
        refreshFragment();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setOrientation();
        ((RelativeLayout) findViewById(R.id.parent_view)).setVisibility(4);
        refreshFragment();
    }

    public void onDestroy() {
        super.onDestroy();
        this.flutterAddressFormFragment = null;
    }

    public final void refreshFragment() {
        Unit unit;
        FlutterAddressFormFragment flutterAddressFormFragment2 = new FlutterAddressFormFragment();
        this.flutterAddressFormFragment = flutterAddressFormFragment2;
        LatLng latLng = this.f53510v;
        if (latLng != null) {
            flutterAddressFormFragment2.setArguments(FlutterAddressFormFragment.Companion.bundle(latLng.getLatitude(), latLng.getLongitude(), this.f53508t, addressFlowOrigin().getTrackerStringValue(), this.refreshLocation));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LatLng defaultLatLang = defaultLatLang();
            if (defaultLatLang == null) {
                defaultLatLang = t0();
            }
            Intrinsics.checkNotNullExpressionValue(defaultLatLang, "defaultLatLang() ?: defaultKuwaitLanLng()");
            FlutterAddressFormFragment flutterAddressFormFragment3 = this.flutterAddressFormFragment;
            if (flutterAddressFormFragment3 != null) {
                flutterAddressFormFragment3.setArguments(FlutterAddressFormFragment.Companion.bundle(defaultLatLang.getLatitude(), defaultLatLang.getLongitude(), this.f53508t, addressFlowOrigin().getTrackerStringValue(), this.refreshLocation));
            }
        }
        FlutterAddressFormFragment flutterAddressFormFragment4 = this.flutterAddressFormFragment;
        if (flutterAddressFormFragment4 != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.addressFormContainer, flutterAddressFormFragment4).commit();
        }
    }

    public final void setRefreshLocation(boolean z11) {
        this.refreshLocation = z11;
    }

    public boolean u0() {
        this.refreshLocation = true;
        return true;
    }

    public final void flutterOnRedirectToMapScreen(boolean z11, boolean z12) {
        onRedirectToMapScreen(defaultLatLang(), z11, z12);
    }
}
