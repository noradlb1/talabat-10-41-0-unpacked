package com.talabat.darkstores.feature.tracking.data;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.TrackingUtilKt;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/BannerStoreClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "locationTrackingProvider", "Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "screenName", "", "nmrAdData", "", "eventOrigin", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "(Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;Ljava/lang/String;Ljava/util/Map;Lcom/talabat/darkstores/feature/tracking/EventOriginType;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerStoreClickedEvent extends TalabatEvent {
    @NotNull
    private static final String BANNER_STORE_CLICKED = "banner_store_clicked";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DARKSTORES = "darkstores";
    @NotNull
    private final EventOriginType eventOrigin;
    @NotNull
    private final LocationTrackingProvider locationTrackingProvider;
    @NotNull
    private final Map<String, String> nmrAdData;
    @Nullable
    private final String screenName;
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/BannerStoreClickedEvent$Companion;", "", "()V", "BANNER_STORE_CLICKED", "", "DARKSTORES", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BannerStoreClickedEvent(@NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2, @NotNull LocationTrackingProvider locationTrackingProvider2, @Nullable String str, @NotNull Map<String, String> map, @NotNull EventOriginType eventOriginType) {
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider2, "locationTrackingProvider");
        Intrinsics.checkNotNullParameter(map, "nmrAdData");
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOrigin");
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
        this.locationTrackingProvider = locationTrackingProvider2;
        this.screenName = str;
        this.nmrAdData = map;
        this.eventOrigin = eventOriginType;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[9];
        String str = this.nmrAdData.get("bannerId");
        String str2 = "N/A";
        if (str == null) {
            str = str2;
        }
        pairArr[0] = TuplesKt.to("bannerId", str);
        String str3 = this.nmrAdData.get("bannerName");
        if (str3 == null) {
            str3 = str2;
        }
        pairArr[1] = TuplesKt.to("bannerName", str3);
        String str4 = this.nmrAdData.get("screenName");
        if (str4 == null) {
            str4 = str2;
        }
        pairArr[2] = TuplesKt.to("screenName", str4);
        String str5 = this.nmrAdData.get("bannerType");
        if (str5 == null) {
            str5 = str2;
        }
        pairArr[3] = TuplesKt.to("bannerType", str5);
        String str6 = this.nmrAdData.get("bannerPosition");
        if (str6 == null) {
            str6 = str2;
        }
        pairArr[4] = TuplesKt.to("bannerPosition", str6);
        String str7 = this.nmrAdData.get(ProductTrackingProvider.NMR_AD_ID);
        if (str7 == null) {
            str7 = str2;
        }
        pairArr[5] = TuplesKt.to(ProductTrackingProvider.NMR_AD_ID, str7);
        String str8 = this.nmrAdData.get("shopSponsoring");
        if (str8 != null) {
            str2 = str8;
        }
        pairArr[6] = TuplesKt.to("shopSponsoring", str2);
        pairArr[7] = TuplesKt.to("screenType", ScreenNames.getScreenType(this.screenName));
        pairArr[8] = TuplesKt.to("eventOrigin", this.eventOrigin.getTrackingName());
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pairArr), (Map) TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams())), (Map) TrackingUtilKt.toMapOfStrings(this.locationTrackingProvider.getLocationParams()));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return BANNER_STORE_CLICKED;
    }
}
