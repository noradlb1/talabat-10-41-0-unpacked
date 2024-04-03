package library.talabat.mvp.addressV2;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Llibrary/talabat/mvp/addressV2/UserAddressEvents;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "event", "", "screenName", "Llibrary/talabat/mvp/addressV2/SupportedScreens;", "userLocationAddress", "Llibrary/talabat/mvp/addressV2/UserLocationAddress;", "readableAddress", "eventOrigin", "Llibrary/talabat/mvp/addressV2/SaveAddressEventsOrigin;", "extraAttributes", "", "addressId", "(Ljava/lang/String;Llibrary/talabat/mvp/addressV2/SupportedScreens;Llibrary/talabat/mvp/addressV2/UserLocationAddress;Ljava/lang/String;Llibrary/talabat/mvp/addressV2/SaveAddressEventsOrigin;Ljava/util/Map;Ljava/lang/String;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class UserAddressEvents extends TalabatEvent {
    @Nullable
    private final String addressId;
    @NotNull
    private final String event;
    @NotNull
    private final SaveAddressEventsOrigin eventOrigin;
    @Nullable
    private final Map<String, String> extraAttributes;
    @Nullable
    private final String readableAddress;
    @NotNull
    private final SupportedScreens screenName;
    @NotNull
    private final UserLocationAddress userLocationAddress;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserAddressEvents(String str, SupportedScreens supportedScreens, UserLocationAddress userLocationAddress2, String str2, SaveAddressEventsOrigin saveAddressEventsOrigin, Map map, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, supportedScreens, userLocationAddress2, str2, saveAddressEventsOrigin, (i11 & 32) != 0 ? null : map, (i11 & 64) != 0 ? null : str3);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        boolean z13 = false;
        Map<String, Object> mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", ScreenNames.SCREEN_TYPE_USER_ACCOUNT), TuplesKt.to("screenName", this.screenName.getScreenName()), TuplesKt.to("locationCity", Integer.valueOf(this.userLocationAddress.getCityId())), TuplesKt.to("locationArea", Integer.valueOf(this.userLocationAddress.getAreaId())), TuplesKt.to("locationCountry", this.userLocationAddress.getCountry().getThreeLetterCode()), TuplesKt.to("locationLat", Double.valueOf(this.userLocationAddress.getLatLng().getLatitude())), TuplesKt.to("locationLon", Double.valueOf(this.userLocationAddress.getLatLng().getLongitude())), TuplesKt.to("formType", this.screenName.formType()), TuplesKt.to("locationMethod", "Manual"), TuplesKt.to("eventOrigin", this.eventOrigin.getTrackerStringValue()));
        String str = this.readableAddress;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str2 = null;
        if (!(!z11)) {
            str = null;
        }
        if (str != null) {
            mutableMapOf.put("locationAddress", str);
        }
        Map<String, String> map = this.extraAttributes;
        if (map == null || map.isEmpty()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!(!z12)) {
            map = null;
        }
        if (map != null) {
            mutableMapOf.putAll(map);
        }
        String str3 = this.addressId;
        if (str3 == null || str3.length() == 0) {
            z13 = true;
        }
        if (!z13) {
            str2 = str3;
        }
        if (str2 != null) {
            mutableMapOf.put("addressId", str2);
        }
        return mutableMapOf;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "save_address";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.event;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public UserAddressEvents(@NotNull String str, @NotNull SupportedScreens supportedScreens, @NotNull UserLocationAddress userLocationAddress2, @Nullable String str2, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, @Nullable Map<String, String> map, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(supportedScreens, "screenName");
        Intrinsics.checkNotNullParameter(userLocationAddress2, "userLocationAddress");
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        this.event = str;
        this.screenName = supportedScreens;
        this.userLocationAddress = userLocationAddress2;
        this.readableAddress = str2;
        this.eventOrigin = saveAddressEventsOrigin;
        this.extraAttributes = map;
        this.addressId = str3;
    }
}
