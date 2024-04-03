package com.talabat.restaurants.v2.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.gem.adapters.analytics.GemApiCallEvent;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.RestaurantsEventsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B9\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0014\u001a\u00020\nHÂ\u0003JG\u0010\u0015\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/restaurants/v2/tracking/FeaturedProductClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "user", "", "", "position", "", "featuredProductQuantity", "shopClickOrigin", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "(Ljava/util/Map;IILjava/lang/String;Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "featureName", "hashCode", "name", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedProductClickedEvent extends TalabatEvent {
    @NotNull
    private final FeatureProductDisplayModel featureProduct;
    private final int featuredProductQuantity;
    private final int position;
    @NotNull
    private final String shopClickOrigin;
    @NotNull
    private final Map<String, String> user;

    public FeaturedProductClickedEvent(@NotNull Map<String, String> map, int i11, int i12, @NotNull String str, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(str, "shopClickOrigin");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        this.user = map;
        this.position = i11;
        this.featuredProductQuantity = i12;
        this.shopClickOrigin = str;
        this.featureProduct = featureProductDisplayModel;
    }

    private final Map<String, String> component1() {
        return this.user;
    }

    private final int component2() {
        return this.position;
    }

    private final int component3() {
        return this.featuredProductQuantity;
    }

    private final String component4() {
        return this.shopClickOrigin;
    }

    private final FeatureProductDisplayModel component5() {
        return this.featureProduct;
    }

    public static /* synthetic */ FeaturedProductClickedEvent copy$default(FeaturedProductClickedEvent featuredProductClickedEvent, Map<String, String> map, int i11, int i12, String str, FeatureProductDisplayModel featureProductDisplayModel, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            map = featuredProductClickedEvent.user;
        }
        if ((i13 & 2) != 0) {
            i11 = featuredProductClickedEvent.position;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            i12 = featuredProductClickedEvent.featuredProductQuantity;
        }
        int i15 = i12;
        if ((i13 & 8) != 0) {
            str = featuredProductClickedEvent.shopClickOrigin;
        }
        String str2 = str;
        if ((i13 & 16) != 0) {
            featureProductDisplayModel = featuredProductClickedEvent.featureProduct;
        }
        return featuredProductClickedEvent.copy(map, i14, i15, str2, featureProductDisplayModel);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("screenName", "restaurants list"), TuplesKt.to("screenType", "shop_list"), TuplesKt.to("featuredProductPosition", String.valueOf(this.position)), TuplesKt.to("featuredProductQuantity", String.valueOf(this.featuredProductQuantity)), TuplesKt.to("productSku", String.valueOf(this.featureProduct.getItemId())), TuplesKt.to("chainId", String.valueOf(this.featureProduct.getVendor().f13872id)), TuplesKt.to(ProductTrackingProvider.PRICE, this.featureProduct.getPrice()), TuplesKt.to(ProductTrackingProvider.SALE_PRICE, FeaturedProductClickedEventKt.unitSalePrice(this.featureProduct)), TuplesKt.to(ProductTrackingProvider.NAME, this.featureProduct.getItemName()), TuplesKt.to("shopType", String.valueOf(this.featureProduct.getVendor().shopType)), TuplesKt.to("shopId", String.valueOf(this.featureProduct.getVendor().branchId)), TuplesKt.to("shopName", this.featureProduct.getVendor().nameSlug), TuplesKt.to("shopClickOrigin", this.shopClickOrigin), TuplesKt.to("vendorSponsoringPlacement", "shop_list:swimlane_item"), TuplesKt.to("shopSponsoring", RestaurantsEventsKt.sponsoringData(this.featureProduct.getVendor())));
        hashMapOf.putAll(this.user);
        return hashMapOf;
    }

    @NotNull
    public final FeaturedProductClickedEvent copy(@NotNull Map<String, String> map, int i11, int i12, @NotNull String str, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(str, "shopClickOrigin");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        return new FeaturedProductClickedEvent(map, i11, i12, str, featureProductDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeaturedProductClickedEvent)) {
            return false;
        }
        FeaturedProductClickedEvent featuredProductClickedEvent = (FeaturedProductClickedEvent) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) featuredProductClickedEvent.user) && this.position == featuredProductClickedEvent.position && this.featuredProductQuantity == featuredProductClickedEvent.featuredProductQuantity && Intrinsics.areEqual((Object) this.shopClickOrigin, (Object) featuredProductClickedEvent.shopClickOrigin) && Intrinsics.areEqual((Object) this.featureProduct, (Object) featuredProductClickedEvent.featureProduct);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GemApiCallEvent.FEATURE_NAME;
    }

    public int hashCode() {
        return (((((((this.user.hashCode() * 31) + this.position) * 31) + this.featuredProductQuantity) * 31) + this.shopClickOrigin.hashCode()) * 31) + this.featureProduct.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "featured_product_clicked";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.user;
        int i11 = this.position;
        int i12 = this.featuredProductQuantity;
        String str = this.shopClickOrigin;
        FeatureProductDisplayModel featureProductDisplayModel = this.featureProduct;
        return "FeaturedProductClickedEvent(user=" + map + ", position=" + i11 + ", featuredProductQuantity=" + i12 + ", shopClickOrigin=" + str + ", featureProduct=" + featureProductDisplayModel + ")";
    }
}
