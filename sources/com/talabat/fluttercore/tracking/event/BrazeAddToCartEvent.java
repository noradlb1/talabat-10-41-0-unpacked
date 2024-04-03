package com.talabat.fluttercore.tracking.event;

import com.adyen.checkout.core.model.Address;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.helpers.GlobalDataModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/fluttercore/tracking/event/BrazeAddToCartEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "name", "", "featureName", "attributes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "platforms", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeAddToCartEvent extends TalabatEvent {
    @NotNull
    private final Map<String, Object> attributes;
    @NotNull
    private final String featureName;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f59793name;

    public BrazeAddToCartEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.f59793name = str;
        this.featureName = str2;
        this.attributes = map;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[13];
        boolean z11 = false;
        pairArr[0] = TuplesKt.to("area", String.valueOf(GlobalDataModel.SelectedAreaId));
        pairArr[1] = TuplesKt.to("chain_id", this.attributes.get("chainId"));
        String str2 = GlobalDataModel.SelectedCityName;
        if (str2 == null || str2.length() == 0) {
            z11 = true;
        }
        if (z11) {
            str = "N/A";
        } else {
            str = GlobalDataModel.SelectedCityName;
        }
        pairArr[2] = TuplesKt.to(Address.KEY_CITY, str);
        pairArr[3] = TuplesKt.to("country", TalabatAdjust.getSelectedCountryIso());
        pairArr[4] = TuplesKt.to("delivery_provider", this.attributes.get("deliveryProvider"));
        pairArr[5] = TuplesKt.to("vendor_id", this.attributes.get("shopId"));
        pairArr[6] = TuplesKt.to("vendor_listing_page_type", this.attributes.get("listingPageType"));
        pairArr[7] = TuplesKt.to(ShopDetailsLoadedEvent.VENDOR_NAME, this.attributes.get("shopName"));
        pairArr[8] = TuplesKt.to("vendor_type", this.attributes.get("shopType"));
        pairArr[9] = TuplesKt.to("vendor_main_cuisine", this.attributes.get("shopMainCuisine"));
        pairArr[10] = TuplesKt.to("is_migrated_menu", Boolean.FALSE);
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        pairArr[11] = TuplesKt.to("vendor_location_lat", companion.getLocationLatitude());
        pairArr[12] = TuplesKt.to("vendor_location_lon", companion.getLocationLongitude());
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.featureName;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.f59793name;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.BRAZE);
    }
}
