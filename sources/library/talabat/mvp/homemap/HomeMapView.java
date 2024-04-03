package library.talabat.mvp.homemap;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import datamodels.Area;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0001\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J$\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0010H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0010H&J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H&J\b\u0010 \u001a\u00020!H&J\n\u0010\"\u001a\u0004\u0018\u00010\u0005H&J\b\u0010#\u001a\u00020\u0003H&J.\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fH&J*\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0010H&J\u0012\u0010)\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\fH&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0010H&J\u0017\u0010,\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u0010H&J\b\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u0003H&J\b\u00104\u001a\u00020\u0003H&J\u001c\u00105\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u000108H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u000eH&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0010H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u000eH&J!\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u00052\b\u0010A\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\b¨\u0006B"}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapView;", "Lcom/talabat/helpers/Talabat;", "animateMapCammera", "", "mapPinLatLang", "Lcom/google/android/gms/maps/model/LatLng;", "mapZoomLevel", "", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Float;)V", "changecountryPrompt", "mMainLatLng", "selectedCountryName", "", "countryId", "", "checkPermission", "", "clearCartchangeLocation", "geoAddress", "Lcom/talabat/domain/address/Address;", "area", "Ldatamodels/Area;", "userSelectedAddress", "countryPolygonLoaded", "detectingLocationProgress", "deviceGpsStatus", "enableDeliverHereButton", "isEnableDeliverHere", "geocodingReceived", "isGeoLccationAvail", "showLoading", "address", "getContext", "Landroid/content/Context;", "getMainLatLng", "hideMapTutorial", "loadRestaurantListScreen", "msg", "loadRestaurantMenuScreen", "restBranchId", "franchiseRes", "locationError", "mapAnimatedtoLocation", "isAlreadyAnimated", "onCountryDataLoaded", "(Ljava/lang/Integer;)V", "outofService", "preLocationLocationContainer", "isPreGeolocationAvail", "isShowPreloading", "requestForUserCurrentLocation", "showGeoAddressLoading", "showLinaerLoading", "updateAreaLocation", "areCenterPoint", "nothing", "", "updateBranchId", "branchId", "updateIsFrachiseRestaurant", "isFranchiseRest", "updateRestGrpId", "restGrpId", "updateUserSavedTempLocation", "homeMapSavedLatLng", "homeMapSavedZooLevel", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeMapView extends Talabat {
    void animateMapCammera(@Nullable LatLng latLng, @Nullable Float f11);

    void changecountryPrompt(@Nullable LatLng latLng, @NotNull String str, int i11);

    boolean checkPermission();

    void clearCartchangeLocation(@Nullable Address address, @Nullable Area area, @NotNull String str);

    void countryPolygonLoaded();

    void detectingLocationProgress();

    boolean deviceGpsStatus();

    void enableDeliverHereButton(boolean z11);

    void geocodingReceived(boolean z11, boolean z12, @Nullable Address address);

    @NotNull
    Context getContext();

    @Nullable
    LatLng getMainLatLng();

    void hideMapTutorial();

    void loadRestaurantListScreen(@Nullable String str, @Nullable Address address, @Nullable Area area, @NotNull String str2);

    void loadRestaurantMenuScreen(int i11, @Nullable Address address, @NotNull String str, boolean z11);

    void locationError(@Nullable String str);

    void mapAnimatedtoLocation(boolean z11);

    void onCountryDataLoaded(@Nullable Integer num);

    void outofService(@Nullable LatLng latLng);

    void preLocationLocationContainer(boolean z11, boolean z12);

    void requestForUserCurrentLocation();

    void showGeoAddressLoading();

    void showLinaerLoading();

    void updateAreaLocation(@Nullable LatLng latLng, @Nullable Void voidR);

    void updateBranchId(int i11);

    void updateIsFrachiseRestaurant(boolean z11);

    void updateRestGrpId(int i11);

    void updateUserSavedTempLocation(@Nullable LatLng latLng, @Nullable Float f11);
}
