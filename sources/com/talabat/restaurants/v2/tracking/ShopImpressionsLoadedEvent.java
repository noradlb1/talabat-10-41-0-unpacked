package com.talabat.restaurants.v2.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.gem.adapters.analytics.GemApiCallEvent;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import datamodels.FeaturedProductItem;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.RestaurantsEventsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0012\u001a\u00020\tHÂ\u0003J=\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/restaurants/v2/tracking/ShopImpressionsLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "user", "", "", "position", "", "featuredProductQuantity", "featuredProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "(Ljava/util/Map;IILcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "featureName", "hashCode", "name", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopImpressionsLoadedEvent extends TalabatEvent {
    @NotNull
    private final FeatureProductDisplayModel featuredProduct;
    private final int featuredProductQuantity;
    private final int position;
    @NotNull
    private final Map<String, String> user;

    public ShopImpressionsLoadedEvent(@NotNull Map<String, String> map, int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featuredProduct");
        this.user = map;
        this.position = i11;
        this.featuredProductQuantity = i12;
        this.featuredProduct = featureProductDisplayModel;
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

    private final FeatureProductDisplayModel component4() {
        return this.featuredProduct;
    }

    public static /* synthetic */ ShopImpressionsLoadedEvent copy$default(ShopImpressionsLoadedEvent shopImpressionsLoadedEvent, Map<String, String> map, int i11, int i12, FeatureProductDisplayModel featureProductDisplayModel, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            map = shopImpressionsLoadedEvent.user;
        }
        if ((i13 & 2) != 0) {
            i11 = shopImpressionsLoadedEvent.position;
        }
        if ((i13 & 4) != 0) {
            i12 = shopImpressionsLoadedEvent.featuredProductQuantity;
        }
        if ((i13 & 8) != 0) {
            featureProductDisplayModel = shopImpressionsLoadedEvent.featuredProduct;
        }
        return shopImpressionsLoadedEvent.copy(map, i11, i12, featureProductDisplayModel);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[15];
        pairArr[0] = TuplesKt.to("screenName", "restaurants list");
        pairArr[1] = TuplesKt.to("screenType", "shop_list");
        pairArr[2] = TuplesKt.to("productSku", String.valueOf(this.featuredProduct.getItemId()));
        pairArr[3] = TuplesKt.to("chainId", String.valueOf(this.featuredProduct.getVendor().f13872id));
        pairArr[4] = TuplesKt.to(ProductTrackingProvider.PRICE, this.featuredProduct.getPrice());
        pairArr[5] = TuplesKt.to(ProductTrackingProvider.SALE_PRICE, ShopImpressionLoadedEventKt.unitSalePrice(this.featuredProduct));
        pairArr[6] = TuplesKt.to(ProductTrackingProvider.NAME, this.featuredProduct.getItemName());
        FeaturedProductItem item = this.featuredProduct.getItem();
        if (item != null) {
            str = item.getMenuSectionName();
        } else {
            str = null;
        }
        pairArr[7] = TuplesKt.to("productCategory", str);
        pairArr[8] = TuplesKt.to("shopType", StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        pairArr[9] = TuplesKt.to("shopId", String.valueOf(this.featuredProduct.getVendor().branchId));
        pairArr[10] = TuplesKt.to("shopName", this.featuredProduct.getVendor().nameSlug);
        pairArr[11] = TuplesKt.to("vendorSponsoringPlacement", "shop_list:swimlane_item");
        pairArr[12] = TuplesKt.to("shopSponsoring", RestaurantsEventsKt.sponsoringData(this.featuredProduct.getVendor()));
        pairArr[13] = TuplesKt.to("shopPosition", String.valueOf(this.position));
        pairArr[14] = TuplesKt.to("featuredProductQuantity", String.valueOf(this.featuredProductQuantity));
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        hashMapOf.putAll(this.user);
        return hashMapOf;
    }

    @NotNull
    public final ShopImpressionsLoadedEvent copy(@NotNull Map<String, String> map, int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featuredProduct");
        return new ShopImpressionsLoadedEvent(map, i11, i12, featureProductDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopImpressionsLoadedEvent)) {
            return false;
        }
        ShopImpressionsLoadedEvent shopImpressionsLoadedEvent = (ShopImpressionsLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) shopImpressionsLoadedEvent.user) && this.position == shopImpressionsLoadedEvent.position && this.featuredProductQuantity == shopImpressionsLoadedEvent.featuredProductQuantity && Intrinsics.areEqual((Object) this.featuredProduct, (Object) shopImpressionsLoadedEvent.featuredProduct);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GemApiCallEvent.FEATURE_NAME;
    }

    public int hashCode() {
        return (((((this.user.hashCode() * 31) + this.position) * 31) + this.featuredProductQuantity) * 31) + this.featuredProduct.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "shop_impressions_loaded";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.user;
        int i11 = this.position;
        int i12 = this.featuredProductQuantity;
        FeatureProductDisplayModel featureProductDisplayModel = this.featuredProduct;
        return "ShopImpressionsLoadedEvent(user=" + map + ", position=" + i11 + ", featuredProductQuantity=" + i12 + ", featuredProduct=" + featureProductDisplayModel + ")";
    }
}
