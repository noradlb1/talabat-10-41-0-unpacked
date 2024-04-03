package com.talabat.restaurants.v2.ui.viewmodels;

import JsonModels.PolygonEvents;
import android.content.Context;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.v2.tracking.FeaturedProductClickedEvent;
import com.talabat.restaurants.v2.tracking.FeaturedProductShownEvent;
import com.talabat.restaurants.v2.tracking.ShopImpressionsLoadedEvent;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import datamodels.Restaurant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.ShopClickedEvent;
import tracking.gtm.TalabatGTM;
import xq.b;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/FeatureProductTracker;", "", "userSettingsTracker", "Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;", "(Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;)V", "getFeatureProductClickEvent", "Lcom/talabat/restaurants/v2/tracking/FeaturedProductClickedEvent;", "position", "", "listSize", "shopClickOrigin", "", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "getFeatureProductShownEvent", "Lcom/talabat/restaurants/v2/tracking/FeaturedProductShownEvent;", "featuredProducts", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "getShopImpressionLoadedEvent", "Lcom/talabat/restaurants/v2/tracking/ShopImpressionsLoadedEvent;", "featuredProduct", "trackShopClickEvent", "", "context", "Landroid/content/Context;", "featureProductQuantity", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductTracker {
    @NotNull
    private final UserSettingsTracker userSettingsTracker;

    public FeatureProductTracker() {
        this((UserSettingsTracker) null, 1, (DefaultConstructorMarker) null);
    }

    public FeatureProductTracker(@NotNull UserSettingsTracker userSettingsTracker2) {
        Intrinsics.checkNotNullParameter(userSettingsTracker2, "userSettingsTracker");
        this.userSettingsTracker = userSettingsTracker2;
    }

    @NotNull
    public final FeaturedProductClickedEvent getFeatureProductClickEvent(int i11, int i12, @NotNull String str, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(str, "shopClickOrigin");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        return new FeaturedProductClickedEvent(this.userSettingsTracker.addUserSettings(), i11, i12, str, featureProductDisplayModel);
    }

    @NotNull
    public final FeaturedProductShownEvent getFeatureProductShownEvent(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "featuredProducts");
        return new FeaturedProductShownEvent(this.userSettingsTracker.addUserSettings(), featureProductListDisplayModel);
    }

    @NotNull
    public final ShopImpressionsLoadedEvent getShopImpressionLoadedEvent(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featuredProduct");
        return new ShopImpressionsLoadedEvent(this.userSettingsTracker.addUserSettings(), i11, i12, featureProductDisplayModel);
    }

    public final void trackShopClickEvent(@NotNull Context context, int i11, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        boolean z11 = featureProductDisplayModel.getVendor().isUpSelling;
        Restaurant vendor = featureProductDisplayModel.getVendor();
        String str = GlobalDataModel.ShopClickOrigin;
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("screenName", "Restaurant List Screen"));
        ShopClickedEvent.EventOriginSourceDelegate eventOriginSourceDelegate = r14;
        ShopClickedEvent.EventOriginSourceDelegate eventOriginSourceDelegate2 = new ShopClickedEvent.EventOriginSourceDelegate();
        Boolean l11 = b.l(featureProductDisplayModel.getVendor().f13872id);
        Intrinsics.checkNotNullExpressionValue(l11, "isGemRestaurant(featureProduct.vendor.id)");
        companion.restaurantClicked(context, z11, vendor, str, "", "", "", "shop_list", "", (PolygonEvents) null, "list_view", hashMapOf, eventOriginSourceDelegate, l11.booleanValue(), "shop_list:swimlane_item", Integer.valueOf(featureProductDisplayModel.getItemId()), Integer.valueOf(i11));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeatureProductTracker(UserSettingsTracker userSettingsTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new UserSettingsTracker((Function0) null, 1, (DefaultConstructorMarker) null) : userSettingsTracker2);
    }
}
