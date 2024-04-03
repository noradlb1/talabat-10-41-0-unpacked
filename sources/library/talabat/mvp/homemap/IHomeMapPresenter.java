package library.talabat.mvp.homemap;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ9\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0013H&J*\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0011H&J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001bH&J0\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0013H&J\u001a\u0010*\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0013H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0013H&J\u001a\u00101\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u0013H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u000205H&J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0013H&J \u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0011H&¨\u0006<"}, d2 = {"Llibrary/talabat/mvp/homemap/IHomeMapPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "FromCurrentLocationClick", "", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "mZoomLevel", "", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Float;)V", "LocationReceived", "currentLatLng", "userSavedTempLocation", "userSavedTempZoomLevel", "AreaCenterLatLng", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Float;Lcom/google/android/gms/maps/model/LatLng;)V", "brandDeliverHereDecisionHandler", "restBranchId", "", "franchiseRes", "", "cameraAnimationFinished", "isCameraAnimFinished", "mMainLatLng", "fromBrandOrReorder", "changeCountryPrompt", "mapCameraFinished", "selectedCountryName", "", "countryId", "changeUserCountry", "convertLocationToArea", "loadCountryPolygon", "context", "Landroid/content/Context;", "loadReOrderDeliveryArea", "orderId", "mapDecesionHandler", "booleanExtra", "userSelectedAddress", "userSelectedAdressAreaId", "selectedAreaCenterCordinate", "IsIgnoreSaveLoc", "outofService", "resetGpsStatusTracker", "isGpsStatusTrigger", "resetIgnoreCurrentLocation", "isIgnoreCurrentLocation", "resetPreLocation", "isPrelocationFetch", "reverseGeoAdressConvert", "showGeoAddLoading", "updateAddress", "userSelectedAddressCp", "Lcom/talabat/domain/address/Address;", "updateMapCameraMoved", "b", "updateResInfoFromReOrder", "fromReOrder", "reorderId", "reorderResId", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IHomeMapPresenter extends IGlobalPresenter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void LocationReceived$default(IHomeMapPresenter iHomeMapPresenter, LatLng latLng, LatLng latLng2, Float f11, LatLng latLng3, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    latLng = null;
                }
                if ((i11 & 2) != 0) {
                    latLng2 = null;
                }
                iHomeMapPresenter.LocationReceived(latLng, latLng2, f11, latLng3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: LocationReceived");
        }
    }

    void FromCurrentLocationClick(@NotNull LatLng latLng, @Nullable Float f11);

    void LocationReceived(@Nullable LatLng latLng, @Nullable LatLng latLng2, @Nullable Float f11, @Nullable LatLng latLng3);

    void brandDeliverHereDecisionHandler(int i11, boolean z11);

    void cameraAnimationFinished(boolean z11, @Nullable LatLng latLng, boolean z12);

    void changeCountryPrompt(boolean z11, @Nullable LatLng latLng, @NotNull String str, int i11);

    void changeUserCountry(int i11);

    void convertLocationToArea(@Nullable LatLng latLng);

    void loadCountryPolygon(@NotNull Context context);

    void loadReOrderDeliveryArea(@NotNull String str);

    void mapDecesionHandler(boolean z11, @NotNull String str, int i11, @NotNull String str2, boolean z12);

    void outofService(boolean z11, @Nullable LatLng latLng);

    void resetGpsStatusTracker(boolean z11);

    void resetIgnoreCurrentLocation(boolean z11);

    void resetPreLocation(boolean z11);

    void reverseGeoAdressConvert(@Nullable LatLng latLng, boolean z11);

    void updateAddress(@NotNull Address address);

    void updateMapCameraMoved(boolean z11);

    void updateResInfoFromReOrder(boolean z11, @NotNull String str, int i11);
}
