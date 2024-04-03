package com.talabat.restaurants.v2.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.gem.adapters.analytics.GemApiCallEvent;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import datamodels.FeaturedProductItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0006HÂ\u0003J)\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/restaurants/v2/tracking/FeaturedProductShownEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "user", "", "", "featuredProducts", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "(Ljava/util/Map;Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedProductShownEvent extends TalabatEvent {
    @NotNull
    private final FeatureProductListDisplayModel featuredProducts;
    @NotNull
    private final Map<String, String> user;

    public FeaturedProductShownEvent(@NotNull Map<String, String> map, @NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "featuredProducts");
        this.user = map;
        this.featuredProducts = featureProductListDisplayModel;
    }

    private final Map<String, String> component1() {
        return this.user;
    }

    private final FeatureProductListDisplayModel component2() {
        return this.featuredProducts;
    }

    public static /* synthetic */ FeaturedProductShownEvent copy$default(FeaturedProductShownEvent featuredProductShownEvent, Map<String, String> map, FeatureProductListDisplayModel featureProductListDisplayModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = featuredProductShownEvent.user;
        }
        if ((i11 & 2) != 0) {
            featureProductListDisplayModel = featuredProductShownEvent.featuredProducts;
        }
        return featuredProductShownEvent.copy(map, featureProductListDisplayModel);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[14];
        pairArr[0] = TuplesKt.to("screenName", "restaurants list");
        pairArr[1] = TuplesKt.to("screenType", "shop_list");
        pairArr[2] = TuplesKt.to("featuredProductQuantity", String.valueOf(this.featuredProducts.getFeatureProductDisplayModels().size()));
        pairArr[3] = TuplesKt.to("productSku", CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$1.INSTANCE, 30, (Object) null));
        pairArr[4] = TuplesKt.to("chainId", CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$2.INSTANCE, 30, (Object) null));
        pairArr[5] = TuplesKt.to(ProductTrackingProvider.PRICE, CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$3.INSTANCE, 30, (Object) null));
        pairArr[6] = TuplesKt.to(ProductTrackingProvider.SALE_PRICE, CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$4.INSTANCE, 30, (Object) null));
        pairArr[7] = TuplesKt.to(ProductTrackingProvider.NAME, CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$5.INSTANCE, 30, (Object) null));
        ArrayList arrayList = new ArrayList();
        for (FeatureProductDisplayModel item : this.featuredProducts.getFeatureProductDisplayModels()) {
            FeaturedProductItem item2 = item.getItem();
            if (item2 != null) {
                str = item2.getMenuSectionName();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        pairArr[8] = TuplesKt.to("productCategory", CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        pairArr[9] = TuplesKt.to("shopType", StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        pairArr[10] = TuplesKt.to("shopId", CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$7.INSTANCE, 30, (Object) null));
        pairArr[11] = TuplesKt.to("shopName", CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$8.INSTANCE, 30, (Object) null));
        pairArr[12] = TuplesKt.to("vendorSponsoringPlacement", "shop_list:swimlane_item");
        pairArr[13] = TuplesKt.to("shopSponsoring", CollectionsKt___CollectionsKt.joinToString$default(this.featuredProducts.getFeatureProductDisplayModels(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FeaturedProductShownEvent$attributes$9.INSTANCE, 30, (Object) null));
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        hashMapOf.putAll(this.user);
        return hashMapOf;
    }

    @NotNull
    public final FeaturedProductShownEvent copy(@NotNull Map<String, String> map, @NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "featuredProducts");
        return new FeaturedProductShownEvent(map, featureProductListDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeaturedProductShownEvent)) {
            return false;
        }
        FeaturedProductShownEvent featuredProductShownEvent = (FeaturedProductShownEvent) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) featuredProductShownEvent.user) && Intrinsics.areEqual((Object) this.featuredProducts, (Object) featuredProductShownEvent.featuredProducts);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GemApiCallEvent.FEATURE_NAME;
    }

    public int hashCode() {
        return (this.user.hashCode() * 31) + this.featuredProducts.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "featured_product_shown";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.user;
        FeatureProductListDisplayModel featureProductListDisplayModel = this.featuredProducts;
        return "FeaturedProductShownEvent(user=" + map + ", featuredProducts=" + featureProductListDisplayModel + ")";
    }
}
