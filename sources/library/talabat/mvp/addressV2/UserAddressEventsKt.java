package library.talabat.mvp.addressV2;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.configuration.country.Country;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.feature.pickup.data.events.PopupClicked;
import com.talabat.feature.pickup.data.events.PopupLoaded;
import com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImplKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a0\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a8\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0000\u001a0\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a0\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001ah\u0010\u0012\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f\u001a\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006\u001a@\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a@\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a@\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a&\u0010%\u001a\u00020&*\u00020'2\u0006\u0010(\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010*H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"addressScreenLoaded", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "cityId", "", "areaId", "country", "Lcom/talabat/configuration/country/Country;", "latLng", "Lcom/talabat/domain/location/GeoCoordinate;", "eventOrigin", "Llibrary/talabat/mvp/addressV2/SaveAddressEventsOrigin;", "isEdit", "", "deleteAddressClicked", "deleteAddressPopupClicked", "popupButtonYesClicked", "deleteAddressPopupShown", "deleteAddressSuccess", "eventOriginFromAddressScreenState", "", "isOrderFlow", "isAddressFromCartOrderFlow", "isNewAddressFromCartFlow", "isMapFromSideMenu", "isEditAddressFromSideMenu", "isFromCheckout", "isEditAddressFromCheckoutScreen", "isAddAddressFromCheckout", "isGlrEnableAddNewAddress", "isNewAddressCreationGlrFlow", "isFromMcdAddressFlow", "getAddressForTracking", "selectedCustomerAddress", "Lcom/talabat/domain/address/Address;", "saveAddressClickedEvent", "saveAddressError", "saveAddressSuccess", "trackSafely", "", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "debugInfo", "block", "Lkotlin/Function0;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UserAddressEventsKt {
    @NotNull
    public static final TalabatEvent addressScreenLoaded(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, boolean z11) {
        SupportedScreens supportedScreens;
        Country country2 = country;
        GeoCoordinate geoCoordinate2 = geoCoordinate;
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate2, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        if (z11) {
            supportedScreens = SupportedScreens.EDIT_ADDRESS;
        } else {
            supportedScreens = SupportedScreens.ADD_ADDRESS;
        }
        SupportedScreens supportedScreens2 = supportedScreens;
        int i13 = i11;
        int i14 = i12;
        return new UserAddressEvents("address_form_shown", supportedScreens2, new UserLocationAddress(i11, i12, country, geoCoordinate2), (String) null, saveAddressEventsOrigin, (Map) null, (String) null, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final TalabatEvent deleteAddressClicked(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        return new UserAddressEvents("address_deleted_clicked", SupportedScreens.EDIT_ADDRESS, new UserLocationAddress(i11, i12, country, geoCoordinate), (String) null, saveAddressEventsOrigin, (Map) null, (String) null, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final TalabatEvent deleteAddressPopupClicked(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, boolean z11) {
        String str;
        Country country2 = country;
        GeoCoordinate geoCoordinate2 = geoCoordinate;
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate2, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        SupportedScreens supportedScreens = SupportedScreens.EDIT_ADDRESS;
        int i13 = i11;
        int i14 = i12;
        UserLocationAddress userLocationAddress = new UserLocationAddress(i11, i12, country, geoCoordinate2);
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(ConstantsKt.POPUP_TYPE, "address_delete_confirmation");
        if (z11) {
            str = UserStatusRepositoryImplKt.KEY_CALL_INVOKED;
        } else {
            str = "no";
        }
        pairArr[1] = TuplesKt.to(ConstantsKt.POPUP_BUTTON, str);
        return new UserAddressEvents(PopupClicked.EVENT_NAME, supportedScreens, userLocationAddress, (String) null, saveAddressEventsOrigin, MapsKt__MapsKt.mapOf(pairArr), (String) null, 64, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final TalabatEvent deleteAddressPopupShown(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        return new UserAddressEvents(PopupLoaded.EVENT_NAME, SupportedScreens.EDIT_ADDRESS, new UserLocationAddress(i11, i12, country, geoCoordinate), (String) null, saveAddressEventsOrigin, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(ConstantsKt.POPUP_TYPE, "address_delete_confirmation")), (String) null, 64, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final TalabatEvent deleteAddressSuccess(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        return new UserAddressEvents("address_deleted", SupportedScreens.EDIT_ADDRESS, new UserLocationAddress(i11, i12, country, geoCoordinate), (String) null, saveAddressEventsOrigin, (Map) null, (String) null, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final SaveAddressEventsOrigin eventOriginFromAddressScreenState(@Nullable String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, boolean z22) {
        if (Intrinsics.areEqual((Object) str, (Object) "flutter_cart")) {
            return SaveAddressEventsOrigin.FROM_FLUTTER_CART;
        }
        if (z16 || z18 || z17) {
            return SaveAddressEventsOrigin.FROM_CHECKOUT;
        }
        if (z12 || z13) {
            return SaveAddressEventsOrigin.FROM_CART;
        }
        if (z14 || z15) {
            return SaveAddressEventsOrigin.FROM_ACCOUNT_MENU;
        }
        if (z11) {
            return SaveAddressEventsOrigin.FROM_ORDER_FLOW;
        }
        if (z22) {
            return SaveAddressEventsOrigin.FROM_MCD_ADDRESS_FLOW;
        }
        if (z19 || z21) {
            return SaveAddressEventsOrigin.FROM_GRL_FLOW;
        }
        return SaveAddressEventsOrigin.UNKNOWN;
    }

    @NotNull
    public static final String getAddressForTracking(@NotNull Address address, @NotNull Country country) {
        Intrinsics.checkNotNullParameter(address, "selectedCustomerAddress");
        Intrinsics.checkNotNullParameter(country, "country");
        String str = address.areaName;
        String str2 = address.block;
        String str3 = address.street;
        String str4 = address.buildingNo;
        String str5 = address.floor;
        String str6 = address.extraDirections;
        String threeLetterCode = country.getThreeLetterCode();
        return str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str3 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str4 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str5 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str6 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + threeLetterCode;
    }

    @NotNull
    public static final TalabatEvent saveAddressClickedEvent(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, @NotNull Address address, boolean z11) {
        SupportedScreens supportedScreens;
        Country country2 = country;
        GeoCoordinate geoCoordinate2 = geoCoordinate;
        Address address2 = address;
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate2, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        Intrinsics.checkNotNullParameter(address2, "selectedCustomerAddress");
        if (z11) {
            supportedScreens = SupportedScreens.EDIT_ADDRESS;
        } else {
            supportedScreens = SupportedScreens.ADD_ADDRESS;
        }
        SupportedScreens supportedScreens2 = supportedScreens;
        int i13 = i11;
        int i14 = i12;
        return new UserAddressEvents("save_address_clicked", supportedScreens2, new UserLocationAddress(i11, i12, country2, geoCoordinate2), getAddressForTracking(address2, country2), saveAddressEventsOrigin, (Map) null, (String) null, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final TalabatEvent saveAddressError(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, @NotNull Address address, boolean z11) {
        SupportedScreens supportedScreens;
        Country country2 = country;
        GeoCoordinate geoCoordinate2 = geoCoordinate;
        Address address2 = address;
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate2, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        Intrinsics.checkNotNullParameter(address2, "selectedCustomerAddress");
        if (z11) {
            supportedScreens = SupportedScreens.EDIT_ADDRESS;
        } else {
            supportedScreens = SupportedScreens.ADD_ADDRESS;
        }
        SupportedScreens supportedScreens2 = supportedScreens;
        int i13 = i11;
        int i14 = i12;
        return new UserAddressEvents("save_address_error", supportedScreens2, new UserLocationAddress(i11, i12, country2, geoCoordinate2), getAddressForTracking(address2, country2), saveAddressEventsOrigin, (Map) null, (String) null, 96, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final TalabatEvent saveAddressSuccess(int i11, int i12, @NotNull Country country, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, @NotNull Address address, boolean z11) {
        SupportedScreens supportedScreens;
        Country country2 = country;
        GeoCoordinate geoCoordinate2 = geoCoordinate;
        Address address2 = address;
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate2, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        Intrinsics.checkNotNullParameter(address2, "selectedCustomerAddress");
        if (z11) {
            supportedScreens = SupportedScreens.EDIT_ADDRESS;
        } else {
            supportedScreens = SupportedScreens.ADD_ADDRESS;
        }
        SupportedScreens supportedScreens2 = supportedScreens;
        int i13 = i11;
        int i14 = i12;
        return new UserAddressEvents("save_address_succeeded", supportedScreens2, new UserLocationAddress(i11, i12, country2, geoCoordinate2), getAddressForTracking(address2, country2), saveAddressEventsOrigin, (Map) null, address2.f58343id, 32, (DefaultConstructorMarker) null);
    }

    public static final void trackSafely(@NotNull TalabatTracker talabatTracker, @NotNull String str, @NotNull Function0<? extends TalabatEvent> function0) {
        Intrinsics.checkNotNullParameter(talabatTracker, "<this>");
        Intrinsics.checkNotNullParameter(str, "debugInfo");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            talabatTracker.track((TalabatEvent) function0.invoke());
        } catch (Throwable th2) {
            talabatTracker.track(new UserAddressExceptionEvents(th2, str));
        }
    }
}
