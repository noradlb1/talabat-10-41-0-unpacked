package library.talabat.mvp.homemap.data;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00118V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u00178V@VX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Llibrary/talabat/mvp/homemap/data/HomeMapCacheImpl;", "Llibrary/talabat/mvp/homemap/data/HomeMapCache;", "context", "Landroid/content/Context;", "homeMapTemp", "Llibrary/talabat/mvp/homemap/HomeMapTemp;", "(Landroid/content/Context;Llibrary/talabat/mvp/homemap/HomeMapTemp;)V", "value", "", "currentLocPlaceOrderLat", "getCurrentLocPlaceOrderLat", "()Ljava/lang/Double;", "setCurrentLocPlaceOrderLat", "(Ljava/lang/Double;)V", "currentLocPlaceOrderLong", "getCurrentLocPlaceOrderLong", "setCurrentLocPlaceOrderLong", "", "homeMapRedirectEnabled", "getHomeMapRedirectEnabled", "()Z", "setHomeMapRedirectEnabled", "(Z)V", "Lcom/google/android/gms/maps/model/LatLng;", "homeMapSavedLatLng", "getHomeMapSavedLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "setHomeMapSavedLatLng", "(Lcom/google/android/gms/maps/model/LatLng;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapCacheImpl implements HomeMapCache {
    @NotNull
    private final Context context;
    @NotNull
    private final HomeMapTemp homeMapTemp;

    public HomeMapCacheImpl(@NotNull Context context2, @NotNull HomeMapTemp homeMapTemp2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(homeMapTemp2, "homeMapTemp");
        this.context = context2;
        this.homeMapTemp = homeMapTemp2;
    }

    @Nullable
    public Double getCurrentLocPlaceOrderLat() {
        return this.homeMapTemp.getCurrentLocPlaceOrderLat();
    }

    @Nullable
    public Double getCurrentLocPlaceOrderLong() {
        return this.homeMapTemp.getCurrentLocPlaceOrderLong();
    }

    public boolean getHomeMapRedirectEnabled() {
        return this.homeMapTemp.getEnabledHomeMapRedirectEnabled();
    }

    @Nullable
    public LatLng getHomeMapSavedLatLng() {
        return this.homeMapTemp.getHomeMapSavedLatLng();
    }

    public void setCurrentLocPlaceOrderLat(@Nullable Double d11) {
        this.homeMapTemp.setCurrentLocPlaceOrderLat(d11);
    }

    public void setCurrentLocPlaceOrderLong(@Nullable Double d11) {
        this.homeMapTemp.setCurrentLocPlaceOrderLong(d11);
    }

    public void setHomeMapRedirectEnabled(boolean z11) {
        this.homeMapTemp.setHomeMapRedirect(z11, this.context);
    }

    public void setHomeMapSavedLatLng(@Nullable LatLng latLng) {
        this.homeMapTemp.setHomeMapSavedLatLng(latLng);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeMapCacheImpl(Context context2, HomeMapTemp homeMapTemp2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? HomeMapTemp.INSTANCE : homeMapTemp2);
    }
}
