package com.talabat.feature.activecarts.domain.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.checkout.tracking.ScheduledDeliveryEventConstantsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÂ\u0003JO\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 H\u0016J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/feature/activecarts/domain/tracking/CartLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "screenType", "cartCount", "", "eventOrigin", "chainIds", "shopTypes", "cartIds", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartLoadedEvent extends TalabatEvent {
    private final int cartCount;
    @NotNull
    private final String cartIds;
    @NotNull
    private final String chainIds;
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String shopTypes;

    public CartLoadedEvent(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        Intrinsics.checkNotNullParameter(str4, ConstantsKt.LOADED_CHAIN_IDS);
        Intrinsics.checkNotNullParameter(str5, "shopTypes");
        Intrinsics.checkNotNullParameter(str6, "cartIds");
        this.screenName = str;
        this.screenType = str2;
        this.cartCount = i11;
        this.eventOrigin = str3;
        this.chainIds = str4;
        this.shopTypes = str5;
        this.cartIds = str6;
    }

    private final String component1() {
        return this.screenName;
    }

    private final String component2() {
        return this.screenType;
    }

    private final int component3() {
        return this.cartCount;
    }

    private final String component4() {
        return this.eventOrigin;
    }

    private final String component5() {
        return this.chainIds;
    }

    private final String component6() {
        return this.shopTypes;
    }

    private final String component7() {
        return this.cartIds;
    }

    public static /* synthetic */ CartLoadedEvent copy$default(CartLoadedEvent cartLoadedEvent, String str, String str2, int i11, String str3, String str4, String str5, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = cartLoadedEvent.screenName;
        }
        if ((i12 & 2) != 0) {
            str2 = cartLoadedEvent.screenType;
        }
        String str7 = str2;
        if ((i12 & 4) != 0) {
            i11 = cartLoadedEvent.cartCount;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            str3 = cartLoadedEvent.eventOrigin;
        }
        String str8 = str3;
        if ((i12 & 16) != 0) {
            str4 = cartLoadedEvent.chainIds;
        }
        String str9 = str4;
        if ((i12 & 32) != 0) {
            str5 = cartLoadedEvent.shopTypes;
        }
        String str10 = str5;
        if ((i12 & 64) != 0) {
            str6 = cartLoadedEvent.cartIds;
        }
        return cartLoadedEvent.copy(str, str7, i13, str8, str9, str10, str6);
    }

    @NotNull
    public Map<String, String> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", this.screenName), TuplesKt.to("screenType", this.screenType), TuplesKt.to(ScheduledDeliveryEventConstantsKt.ATTRIBUTE_EVENT_LABEL, String.valueOf(this.cartCount)), TuplesKt.to("eventOrigin", this.eventOrigin), TuplesKt.to("chainId", this.chainIds), TuplesKt.to("shopType", this.shopTypes), TuplesKt.to("cartIds", this.cartIds));
    }

    @NotNull
    public final CartLoadedEvent copy(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        Intrinsics.checkNotNullParameter(str4, ConstantsKt.LOADED_CHAIN_IDS);
        Intrinsics.checkNotNullParameter(str5, "shopTypes");
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, "cartIds");
        return new CartLoadedEvent(str, str2, i11, str3, str4, str5, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartLoadedEvent)) {
            return false;
        }
        CartLoadedEvent cartLoadedEvent = (CartLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) cartLoadedEvent.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) cartLoadedEvent.screenType) && this.cartCount == cartLoadedEvent.cartCount && Intrinsics.areEqual((Object) this.eventOrigin, (Object) cartLoadedEvent.eventOrigin) && Intrinsics.areEqual((Object) this.chainIds, (Object) cartLoadedEvent.chainIds) && Intrinsics.areEqual((Object) this.shopTypes, (Object) cartLoadedEvent.shopTypes) && Intrinsics.areEqual((Object) this.cartIds, (Object) cartLoadedEvent.cartIds);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "basket-list";
    }

    public int hashCode() {
        return (((((((((((this.screenName.hashCode() * 31) + this.screenType.hashCode()) * 31) + this.cartCount) * 31) + this.eventOrigin.hashCode()) * 31) + this.chainIds.hashCode()) * 31) + this.shopTypes.hashCode()) * 31) + this.cartIds.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "cart_icon_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        String str2 = this.screenType;
        int i11 = this.cartCount;
        String str3 = this.eventOrigin;
        String str4 = this.chainIds;
        String str5 = this.shopTypes;
        String str6 = this.cartIds;
        return "CartLoadedEvent(screenName=" + str + ", screenType=" + str2 + ", cartCount=" + i11 + ", eventOrigin=" + str3 + ", chainIds=" + str4 + ", shopTypes=" + str5 + ", cartIds=" + str6 + ")";
    }
}
