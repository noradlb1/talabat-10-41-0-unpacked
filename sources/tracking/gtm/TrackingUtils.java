package tracking.gtm;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import buisnessmodels.Customer;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.QuickOrderInfo;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.ScreenNames;
import tracking.TalabatAdjust;

@Instrumented
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004]^_`B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u00107\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0002\u0010:J\u0017\u0010;\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0002\u0010:J \u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CJ\u0018\u0010D\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020AJ\u0018\u0010F\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020AJ\u000e\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0004J\u0012\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010>\u001a\u00020?H\u0002JÍ\u0001\u0010K\u001a\u00020L2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010M\u001a\u0004\u0018\u0001092\b\u0010N\u001a\u0004\u0018\u0001092\b\u0010O\u001a\u0004\u0018\u00010\u00042\b\u0010P\u001a\u0004\u0018\u00010\u00042\b\u0010H\u001a\u0004\u0018\u00010\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u00042\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010S\u001a\u0004\u0018\u00010\u00042\b\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010U\u001a\u0004\u0018\u00010\u00042\b\u0010V\u001a\u0004\u0018\u00010\u00042\b\u0010W\u001a\u0004\u0018\u00010\u00042\b\u0010X\u001a\u0004\u0018\u00010\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u00042\b\u0010Z\u001a\u0004\u0018\u00010\u00042\u0006\u0010E\u001a\u00020A2\b\u0010[\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\\R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u0014\u00103\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0014\u00105\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006¨\u0006a"}, d2 = {"Ltracking/gtm/TrackingUtils;", "", "()V", "addressMethodNew", "", "getAddressMethodNew", "()Ljava/lang/String;", "setAddressMethodNew", "(Ljava/lang/String;)V", "addressMethodSaved", "getAddressMethodSaved", "setAddressMethodSaved", "addressMismatch", "getAddressMismatch", "setAddressMismatch", "addressNotFoundError", "getAddressNotFoundError", "setAddressNotFoundError", "apiMethod", "getApiMethod", "setApiMethod", "appGpsDisabled", "getAppGpsDisabled", "setAppGpsDisabled", "deviceGpsDisabled", "getDeviceGpsDisabled", "setDeviceGpsDisabled", "locationMethodAutocomplete", "getLocationMethodAutocomplete", "setLocationMethodAutocomplete", "locationMethodLocate", "getLocationMethodLocate", "setLocationMethodLocate", "locationMethodMapCoordinates", "getLocationMethodMapCoordinates", "setLocationMethodMapCoordinates", "locationMethodResetPin", "getLocationMethodResetPin", "setLocationMethodResetPin", "locationMethodResetToMyLocation", "getLocationMethodResetToMyLocation", "setLocationMethodResetToMyLocation", "locationPromptType", "getLocationPromptType", "setLocationPromptType", "outOfDeliveryZone", "getOutOfDeliveryZone", "setOutOfDeliveryZone", "outOffservice", "getOutOffservice", "setOutOffservice", "resetAuthException", "getResetAuthException", "trackingDataNotAvail", "getTrackingDataNotAvail", "getArea", "area", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "getCity", "city", "getLocationAddress", "context", "Landroid/content/Context;", "ignoreAddress", "", "address", "Lcom/talabat/domain/address/Address;", "getLocationLatitude", "ignoreLoc", "getLocationLongitude", "getLoginScreenType", "screenName", "getSavedQuickOrderAddressData", "Ldatamodels/QuickOrderInfo;", "getTrackingAddressObject", "Ldatamodels/analyticstrackermodels/AddressAnalyticsTracker;", "locationCity", "locationArea", "screenType", "deliveryAddressStatus", "mapErrorMessage", "countrySelected", "apiResponse", "geolocationAccuracy", "locationDialogueAccepted", "locationDialogueType", "addressComponentType", "mapType", "journeyType", "addressCount", "locationMethod", "(Landroid/content/Context;ZLcom/talabat/domain/address/Address;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Ldatamodels/analyticstrackermodels/AddressAnalyticsTracker;", "LocationRequest", "ResetPasswordOption", "TrackAddressSnappingCases", "TrackingGpsStatus", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingUtils {
    @NotNull
    public static final TrackingUtils INSTANCE = new TrackingUtils();
    @NotNull
    private static String addressMethodNew = "New";
    @NotNull
    private static String addressMethodSaved = "Saved";
    @NotNull
    private static String addressMismatch = "address_mismatch";
    @NotNull
    private static String addressNotFoundError = "address could not be fetched";
    @NotNull
    private static String apiMethod = "reverse geocoding";
    @NotNull
    private static String appGpsDisabled = "app_gps_disabled";
    @NotNull
    private static String deviceGpsDisabled = "device_gps_disabled";
    @NotNull
    private static String locationMethodAutocomplete = "Autocomplete";
    @NotNull
    private static String locationMethodLocate = "LocateMe";
    @NotNull
    private static String locationMethodMapCoordinates = "MapCoordinates";
    @NotNull
    private static String locationMethodResetPin = "ResetPin";
    @NotNull
    private static String locationMethodResetToMyLocation = "ResetToMyLocation";
    @NotNull
    private static String locationPromptType = "Native";
    @NotNull
    private static String outOfDeliveryZone = "Outside Delivery Zone";
    @NotNull
    private static String outOffservice = "device_gps_disabled";
    @NotNull
    private static final String resetAuthException = "AuthFailureError";
    @NotNull
    private static final String trackingDataNotAvail = "N/A";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ltracking/gtm/TrackingUtils$LocationRequest;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PriorityHighAccuracy", "PriorityLow", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum LocationRequest {
        PriorityHighAccuracy("high_accuracy"),
        PriorityLow("Low_accuracy");
        
        @NotNull
        private final String value;

        private LocationRequest(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltracking/gtm/TrackingUtils$ResetPasswordOption;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Clicked", "Submitted", "Failed", "Succeeded", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ResetPasswordOption {
        Clicked("clicked"),
        Submitted("submitted"),
        Failed(TalabatGTM.FAILED),
        Succeeded("succeeded");
        
        @NotNull
        private final String value;

        private ResetPasswordOption(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltracking/gtm/TrackingUtils$TrackAddressSnappingCases;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SnapAddressWithNoGps", "SnapAddressToCurrentLocation", "SnapToSavedAddressBasedOnCurrentLocation", "SnapToCurrentLocataionNotSortedAddressFound", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum TrackAddressSnappingCases {
        SnapAddressWithNoGps(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS),
        SnapAddressToCurrentLocation("C"),
        SnapToSavedAddressBasedOnCurrentLocation("D"),
        SnapToCurrentLocataionNotSortedAddressFound(ExifInterface.LONGITUDE_EAST);
        
        @NotNull
        private final String value;

        private TrackAddressSnappingCases(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ltracking/gtm/TrackingUtils$TrackingGpsStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Disabled", "Enabled", "PermissionDenied", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum TrackingGpsStatus {
        Disabled("disabled"),
        Enabled("enabled"),
        PermissionDenied("permission_denied");
        
        @NotNull
        private final String value;

        private TrackingGpsStatus(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    private TrackingUtils() {
    }

    private final String getArea(Integer num) {
        if (num == null || num.intValue() <= 0) {
            return "N/A";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        return sb2.toString();
    }

    private final String getCity(Integer num) {
        if (num == null || num.intValue() <= 0) {
            return "N/A";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        return sb2.toString();
    }

    private final QuickOrderInfo getSavedQuickOrderAddressData(Context context) {
        Object obj;
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        int i11 = GlobalDataModel.SelectedAreaId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        if (!sharedPreferences.contains(sb2.toString())) {
            return null;
        }
        try {
            int i12 = GlobalDataModel.SelectedAreaId;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i12);
            String string = sharedPreferences.getString(sb3.toString(), "");
            Class cls = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
            Address address = quickOrderInfo.address;
            String str = address.grl;
            address.grl = "";
            if (!TalabatUtils.isNullOrEmpty(str)) {
                Address address2 = quickOrderInfo.address;
                address2.grl = TalabatUtils.decodeFromBase64(address2.grl);
            }
            return quickOrderInfo;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final String getAddressMethodNew() {
        return addressMethodNew;
    }

    @NotNull
    public final String getAddressMethodSaved() {
        return addressMethodSaved;
    }

    @NotNull
    public final String getAddressMismatch() {
        return addressMismatch;
    }

    @NotNull
    public final String getAddressNotFoundError() {
        return addressNotFoundError;
    }

    @NotNull
    public final String getApiMethod() {
        return apiMethod;
    }

    @NotNull
    public final String getAppGpsDisabled() {
        return appGpsDisabled;
    }

    @NotNull
    public final String getDeviceGpsDisabled() {
        return deviceGpsDisabled;
    }

    @NotNull
    public final String getLocationAddress(@NotNull Context context, boolean z11, @Nullable Address address) {
        Address address2;
        Address address3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (z11) {
            return "N/A";
        }
        Address address4 = new Address("", 0, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, false, (String) null, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 134217726, (DefaultConstructorMarker) null);
        Customer instance = Customer.getInstance();
        if (instance != null) {
            address2 = instance.getSelectedCustomerAddress();
        } else {
            address2 = null;
        }
        if (address2 != null) {
            address3 = instance.getSelectedCustomerAddress();
        } else {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (homeMapTemp.getTempAddress() != null) {
                address3 = homeMapTemp.getTempAddress();
                Intrinsics.checkNotNull(address3);
            } else if (address != null) {
                address3 = address;
            } else {
                QuickOrderInfo savedQuickOrderAddressData = getSavedQuickOrderAddressData(context);
                if (savedQuickOrderAddressData != null) {
                    address3 = savedQuickOrderAddressData.address;
                } else {
                    address3 = address4;
                }
            }
        }
        if (address3 == null) {
            return "N/A";
        }
        String str = address3.areaName;
        String str2 = address3.block;
        String str3 = address3.street;
        String str4 = address3.buildingNo;
        String str5 = address3.floor;
        String str6 = address3.extraDirections;
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        return str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str3 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str4 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str5 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str6 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + selectedCountryIso;
    }

    @NotNull
    public final String getLocationLatitude(@Nullable Address address, boolean z11) {
        if (z11) {
            return "N/A";
        }
        if (address != null) {
            try {
                double d11 = address.latitude;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d11);
                return sb2.toString();
            } catch (Exception unused) {
            }
        } else {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (!(homeMapTemp == null || homeMapTemp.getHomeMapSavedLatLng() == null)) {
                LatLng homeMapSavedLatLng = homeMapTemp.getHomeMapSavedLatLng();
                Intrinsics.checkNotNull(homeMapSavedLatLng);
                double d12 = homeMapSavedLatLng.latitude;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(d12);
                return sb3.toString();
            }
            return "N/A";
        }
    }

    @NotNull
    public final String getLocationLongitude(@Nullable Address address, boolean z11) {
        if (z11) {
            return "N/A";
        }
        if (address != null) {
            try {
                double d11 = address.longitude;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d11);
                return sb2.toString();
            } catch (Exception unused) {
            }
        } else {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (!(homeMapTemp == null || homeMapTemp.getHomeMapSavedLatLng() == null)) {
                LatLng homeMapSavedLatLng = homeMapTemp.getHomeMapSavedLatLng();
                Intrinsics.checkNotNull(homeMapSavedLatLng);
                double d12 = homeMapSavedLatLng.longitude;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(d12);
                return sb3.toString();
            }
            return "N/A";
        }
    }

    @NotNull
    public final String getLocationMethodAutocomplete() {
        return locationMethodAutocomplete;
    }

    @NotNull
    public final String getLocationMethodLocate() {
        return locationMethodLocate;
    }

    @NotNull
    public final String getLocationMethodMapCoordinates() {
        return locationMethodMapCoordinates;
    }

    @NotNull
    public final String getLocationMethodResetPin() {
        return locationMethodResetPin;
    }

    @NotNull
    public final String getLocationMethodResetToMyLocation() {
        return locationMethodResetToMyLocation;
    }

    @NotNull
    public final String getLocationPromptType() {
        return locationPromptType;
    }

    @NotNull
    public final String getLoginScreenType(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "screenName");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "N/A";
        }
        if (str.equals(ScreenNames.ORDERS_LIST) || str.equals(ScreenNames.REGISTRATION) || str.equals("rewards") || str.equals(ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT) || str.equals(ScreenNames.SETTINGS_SCREEN)) {
            return ScreenNames.SCREEN_TYPE_USER_ACCOUNT;
        }
        if (str.equals("Cart Screen")) {
            return "cart";
        }
        if (str.equals("Home Screen")) {
            return "home";
        }
        if (str.equals(ScreenNames.HELP_CENTER_SCREEN)) {
            return "help_center";
        }
        return "N/A";
    }

    @NotNull
    public final String getOutOfDeliveryZone() {
        return outOfDeliveryZone;
    }

    @NotNull
    public final String getOutOffservice() {
        return outOffservice;
    }

    @NotNull
    public final String getResetAuthException() {
        return resetAuthException;
    }

    @NotNull
    public final AddressAnalyticsTracker getTrackingAddressObject(@NotNull Context context, boolean z11, @Nullable Address address, @Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, boolean z12, @Nullable String str14) {
        Address address2 = address;
        boolean z13 = z12;
        String str15 = str14;
        Intrinsics.checkNotNullParameter(context, "context");
        return new AddressAnalyticsTracker(getLocationAddress(context, z11, address), getCity(num), getLocationLatitude(address2, z13), getLocationLongitude(address2, z13), getArea(num2), TalabatAdjust.getSelectedCountryIso(), str, str2, str3, str15, str4, str5, GlobalDataModel.GEO_LOCATION_TRACKING.GEO_LOCATION_API_METHOD, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    @NotNull
    public final String getTrackingDataNotAvail() {
        return trackingDataNotAvail;
    }

    public final void setAddressMethodNew(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        addressMethodNew = str;
    }

    public final void setAddressMethodSaved(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        addressMethodSaved = str;
    }

    public final void setAddressMismatch(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        addressMismatch = str;
    }

    public final void setAddressNotFoundError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        addressNotFoundError = str;
    }

    public final void setApiMethod(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        apiMethod = str;
    }

    public final void setAppGpsDisabled(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        appGpsDisabled = str;
    }

    public final void setDeviceGpsDisabled(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        deviceGpsDisabled = str;
    }

    public final void setLocationMethodAutocomplete(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationMethodAutocomplete = str;
    }

    public final void setLocationMethodLocate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationMethodLocate = str;
    }

    public final void setLocationMethodMapCoordinates(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationMethodMapCoordinates = str;
    }

    public final void setLocationMethodResetPin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationMethodResetPin = str;
    }

    public final void setLocationMethodResetToMyLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationMethodResetToMyLocation = str;
    }

    public final void setLocationPromptType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        locationPromptType = str;
    }

    public final void setOutOfDeliveryZone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        outOfDeliveryZone = str;
    }

    public final void setOutOffservice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        outOffservice = str;
    }
}
