package library.talabat.mvp.homemap;

import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Customer;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAppBoy;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u00105\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\r\u00106\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000e\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u00020:J\u000e\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?J\u001a\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010B\u001a\u00020:2\b\u0010>\u001a\u0004\u0018\u00010?J\u0018\u0010C\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\u0006\u0010>\u001a\u00020?J\u001e\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?J\u0018\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010?J\u0015\u0010J\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010$J\u001a\u0010L\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\u0006\u0010>\u001a\u00020?H\u0002J\u000e\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020\u0014J\u000e\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020'J\u0015\u0010Q\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010$J\u000e\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020'J\u000e\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020\u0014J\u001f\u0010V\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u00020:2\b\u0010Y\u001a\u0004\u0018\u00010-J\u000e\u00102\u001a\u00020:2\u0006\u0010Z\u001a\u00020\u000eR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012¨\u0006["}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapTemp;", "", "()V", "currentLocPlaceOrderLat", "", "getCurrentLocPlaceOrderLat", "()Ljava/lang/Double;", "setCurrentLocPlaceOrderLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "currentLocPlaceOrderLong", "getCurrentLocPlaceOrderLong", "setCurrentLocPlaceOrderLong", "enabledHomeMapRedirectEnabled", "", "getEnabledHomeMapRedirectEnabled", "()Z", "setEnabledHomeMapRedirectEnabled", "(Z)V", "homeMapAreaId", "", "getHomeMapAreaId", "()I", "setHomeMapAreaId", "(I)V", "homeMapSavedLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "getHomeMapSavedLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "setHomeMapSavedLatLng", "(Lcom/google/android/gms/maps/model/LatLng;)V", "homeMapSavedZooLevel", "", "getHomeMapSavedZooLevel", "()Ljava/lang/Float;", "setHomeMapSavedZooLevel", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "homeMapStreetName", "", "getHomeMapStreetName", "()Ljava/lang/String;", "setHomeMapStreetName", "(Ljava/lang/String;)V", "tempAddress", "Lcom/talabat/domain/address/Address;", "getTempAddress", "()Lcom/talabat/domain/address/Address;", "setTempAddress", "(Lcom/talabat/domain/address/Address;)V", "updateAddressNotSaved", "getUpdateAddressNotSaved", "setUpdateAddressNotSaved", "getPlaceOrderLatitude", "getPlaceOrderLongitude", "homeMapSavedZooLevelOrDefault", "defValue", "mapFirstUpdateOption", "", "Option", "recentRecentLocation", "resetPref", "context", "Landroid/content/Context;", "saveHomeMapRedirect", "isRedirect", "setHomeEnabledHomeMapRedirectEnabled", "setHomeMapLatLng", "latlng", "setHomeMapLatLngFromFlutter", "latitude", "longitude", "setHomeMapRedirect", "isHomeMapRedirectEnabled", "setHomeMapZoomeLevel", "zoomLevel", "setLastSearchLocation", "setPrefAreaId", "areaId", "setPrefLocation", "location", "setPrefZoom", "setStreetName", "selectedStreetName", "setTempAreaId", "AreaId", "setUserCurrentLocation", "(Ljava/lang/Double;Ljava/lang/Double;)V", "settempAddress", "googleAddress", "isSaved", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapTemp {
    @NotNull
    public static final HomeMapTemp INSTANCE = new HomeMapTemp();
    @Nullable
    private static Double currentLocPlaceOrderLat;
    @Nullable
    private static Double currentLocPlaceOrderLong;
    private static boolean enabledHomeMapRedirectEnabled;
    private static int homeMapAreaId;
    @Nullable
    private static LatLng homeMapSavedLatLng;
    @Nullable
    private static Float homeMapSavedZooLevel;
    @Nullable
    private static String homeMapStreetName = "";
    @Nullable
    private static Address tempAddress;
    private static boolean updateAddressNotSaved;

    private HomeMapTemp() {
    }

    private final void saveHomeMapRedirect(boolean z11, Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor = null;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        } else {
            sharedPreferences = null;
        }
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        }
        if (editor != null) {
            editor.putBoolean(GlobalConstants.PrefsConstants.HOME_MAP_REDIRECT, z11);
        }
        if (editor != null) {
            editor.apply();
        }
    }

    private final void setLastSearchLocation(LatLng latLng, Context context) {
        try {
            Intrinsics.checkNotNull(latLng);
            TalabatAppBoy.onLastSearchedLocation(context, latLng.latitude, latLng.longitude);
        } catch (Exception unused) {
        }
    }

    @Nullable
    public final Double getCurrentLocPlaceOrderLat() {
        return currentLocPlaceOrderLat;
    }

    @Nullable
    public final Double getCurrentLocPlaceOrderLong() {
        return currentLocPlaceOrderLong;
    }

    public final boolean getEnabledHomeMapRedirectEnabled() {
        return enabledHomeMapRedirectEnabled;
    }

    public final int getHomeMapAreaId() {
        return homeMapAreaId;
    }

    @Nullable
    public final LatLng getHomeMapSavedLatLng() {
        return homeMapSavedLatLng;
    }

    @Nullable
    public final Float getHomeMapSavedZooLevel() {
        return homeMapSavedZooLevel;
    }

    @Nullable
    public final String getHomeMapStreetName() {
        return homeMapStreetName;
    }

    @Nullable
    public final Double getPlaceOrderLatitude() {
        return currentLocPlaceOrderLat;
    }

    @Nullable
    public final Double getPlaceOrderLongitude() {
        return currentLocPlaceOrderLong;
    }

    @Nullable
    public final Address getTempAddress() {
        return tempAddress;
    }

    public final boolean getUpdateAddressNotSaved() {
        return updateAddressNotSaved;
    }

    public final float homeMapSavedZooLevelOrDefault(float f11) {
        Float f12 = homeMapSavedZooLevel;
        return f12 != null ? f12.floatValue() : f11;
    }

    public final void mapFirstUpdateOption(int i11) {
        GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION = i11;
    }

    public final void recentRecentLocation() {
        homeMapStreetName = "";
        GlobalDataModel.RECENT_LATLONG.latitude = 0.0d;
        GlobalDataModel.RECENT_LATLONG.longitude = 0.0d;
    }

    public final void resetPref(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        homeMapAreaId = 0;
        homeMapSavedLatLng = null;
        homeMapSavedZooLevel = null;
        enabledHomeMapRedirectEnabled = false;
        GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION = 0;
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.remove(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION);
        edit.remove(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM);
        edit.remove(GlobalConstants.PrefsConstants.HOME_MAP_PREF_AREAID);
        edit.remove(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME);
        edit.remove(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS);
        edit.remove(GlobalConstants.PrefsConstants.HOME_MAP_REDIRECT);
        edit.commit();
    }

    public final void setCurrentLocPlaceOrderLat(@Nullable Double d11) {
        currentLocPlaceOrderLat = d11;
    }

    public final void setCurrentLocPlaceOrderLong(@Nullable Double d11) {
        currentLocPlaceOrderLong = d11;
    }

    public final void setEnabledHomeMapRedirectEnabled(boolean z11) {
        enabledHomeMapRedirectEnabled = z11;
    }

    public final void setHomeEnabledHomeMapRedirectEnabled(@Nullable Context context) {
        Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
        if (selectedCustomerAddress != null) {
            if (selectedCustomerAddress.latitude > 0.0d && selectedCustomerAddress.longitude > 0.0d) {
                setHomeMapRedirect(false, context);
            }
        } else if (homeMapSavedLatLng != null) {
            setHomeMapRedirect(true, context);
        }
    }

    public final void setHomeMapAreaId(int i11) {
        homeMapAreaId = i11;
    }

    public final void setHomeMapLatLng(@Nullable LatLng latLng, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        homeMapSavedLatLng = latLng;
        setLastSearchLocation(latLng, context);
    }

    public final void setHomeMapLatLngFromFlutter(double d11, double d12, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LatLng latLng = new LatLng(d11, d12);
        homeMapSavedLatLng = latLng;
        setLastSearchLocation(latLng, context);
    }

    public final void setHomeMapRedirect(boolean z11, @Nullable Context context) {
        enabledHomeMapRedirectEnabled = z11;
        saveHomeMapRedirect(z11, context);
    }

    public final void setHomeMapSavedLatLng(@Nullable LatLng latLng) {
        homeMapSavedLatLng = latLng;
    }

    public final void setHomeMapSavedZooLevel(@Nullable Float f11) {
        homeMapSavedZooLevel = f11;
    }

    public final void setHomeMapStreetName(@Nullable String str) {
        homeMapStreetName = str;
    }

    public final void setHomeMapZoomeLevel(@Nullable Float f11) {
        homeMapSavedZooLevel = f11;
    }

    public final void setPrefAreaId(int i11) {
        homeMapAreaId = i11;
    }

    public final void setPrefLocation(@NotNull String str) {
        boolean z11;
        List list;
        boolean z12;
        Intrinsics.checkNotNullParameter(str, "location");
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "null", true)) {
            List<String> split = new Regex(",").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                    if (!z12) {
                        list = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                Object[] array = list.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                homeMapSavedLatLng = new LatLng(Double.parseDouble(strArr[0]), Double.parseDouble(strArr[1]));
            }
            list = CollectionsKt__CollectionsKt.emptyList();
            Object[] array2 = list.toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            homeMapSavedLatLng = new LatLng(Double.parseDouble(strArr2[0]), Double.parseDouble(strArr2[1]));
        }
    }

    public final void setPrefZoom(@Nullable Float f11) {
        homeMapSavedZooLevel = f11;
    }

    public final void setStreetName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "selectedStreetName");
        homeMapStreetName = str;
    }

    public final void setTempAddress(@Nullable Address address) {
        tempAddress = address;
    }

    public final void setTempAreaId(int i11) {
        homeMapAreaId = i11;
    }

    public final void setUpdateAddressNotSaved(boolean z11) {
        updateAddressNotSaved = z11;
    }

    public final void setUserCurrentLocation(@Nullable Double d11, @Nullable Double d12) {
        currentLocPlaceOrderLat = d11;
        currentLocPlaceOrderLong = d12;
    }

    public final void settempAddress(@Nullable Address address) {
        tempAddress = address;
    }

    public final void updateAddressNotSaved(boolean z11) {
        updateAddressNotSaved = z11;
    }
}
