package library.talabat.mvp.homemap.data;

import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Llibrary/talabat/mvp/homemap/data/HomeMapCache;", "", "currentLocPlaceOrderLat", "", "getCurrentLocPlaceOrderLat", "()Ljava/lang/Double;", "setCurrentLocPlaceOrderLat", "(Ljava/lang/Double;)V", "currentLocPlaceOrderLong", "getCurrentLocPlaceOrderLong", "setCurrentLocPlaceOrderLong", "homeMapRedirectEnabled", "", "getHomeMapRedirectEnabled", "()Z", "setHomeMapRedirectEnabled", "(Z)V", "homeMapSavedLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "getHomeMapSavedLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "setHomeMapSavedLatLng", "(Lcom/google/android/gms/maps/model/LatLng;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeMapCache {
    @Nullable
    Double getCurrentLocPlaceOrderLat();

    @Nullable
    Double getCurrentLocPlaceOrderLong();

    boolean getHomeMapRedirectEnabled();

    @Nullable
    LatLng getHomeMapSavedLatLng();

    void setCurrentLocPlaceOrderLat(@Nullable Double d11);

    void setCurrentLocPlaceOrderLong(@Nullable Double d11);

    void setHomeMapRedirectEnabled(boolean z11);

    void setHomeMapSavedLatLng(@Nullable LatLng latLng);
}
