package com.talabat.feature.pickup.data.events;

import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0000¢\u0006\u0002\b\bJ#\u0010\t\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0000¢\u0006\u0002\b\nJ#\u0010\u000b\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0000¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u001d\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/pickup/data/events/TrackerHelpers;", "", "()V", "addShopClickNotAvailableParams", "", "map", "", "", "addShopClickNotAvailableParams$com_talabat_feature_pickup_data_data", "addShopsLoadedNotAvailableParams", "addShopsLoadedNotAvailableParams$com_talabat_feature_pickup_data_data", "addShopsUpdatedNotAvailableParams", "addShopsUpdatedNotAvailableParams$com_talabat_feature_pickup_data_data", "getShopStatus", "statusType", "", "getShopStatus$com_talabat_feature_pickup_data_data", "mainCuisine", "kotlin.jvm.PlatformType", "restaurant", "Ldatamodels/Restaurant;", "mainCuisine$com_talabat_feature_pickup_data_data", "orNotAvailable", "orNotAvailable$com_talabat_feature_pickup_data_data", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackerHelpers {
    @NotNull
    public static final TrackerHelpers INSTANCE = new TrackerHelpers();

    private TrackerHelpers() {
    }

    public final void addShopClickNotAvailableParams$com_talabat_feature_pickup_data_data(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        map.put("ncrRequestToken", "N/A");
        map.put("chainShops", "N/A");
        map.put("floodValue", "N/A");
        map.put("swimlaneStrategyList", "N/A");
        map.put("floodType", "N/A");
        map.put("swimlanePosition", "N/A");
        map.put("shopOfferType", "N/A");
        map.put(ConstantsKt.CLICK_SHOP_RECOMMENDED, "N/A");
        map.put("swimlaneRequestId", "N/A");
        map.put("floodActive", "N/A");
        map.put("searchTerm", "N/A");
        map.put("swimlaneStrategy", "N/A");
        map.put("swimlaneTilesDisplayed", "N/A");
        map.put("shopArea", "N/A");
        map.put("shopCokeUpsell", "N/A");
        map.put("channelIndex", "N/A");
        map.put("swimlaneTitleList", "N/A");
        map.put(ConstantsKt.CLICK_SEARCH_STRING, "N/A");
        map.put("swimlaneTitle", "N/A");
        map.put("swimlaneTotal", "N/A");
        map.put("swimlaneLength", "N/A");
        map.put("channel", "N/A");
        map.put("floodMessage", "N/A");
        map.put(ConstantsKt.CLICK_CLICK_ORIGIN, "N/A");
        map.put("shopWithOffer", "N/A");
        map.put(ConstantsKt.CLICK_SHOP_TITLES_DISPLAYED, "N/A");
        map.put("swimlaneVariation", "N/A");
        map.put("shopCategorySelected", "N/A");
        map.put("shopSponsoring", "N/A");
    }

    public final void addShopsLoadedNotAvailableParams$com_talabat_feature_pickup_data_data(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        map.put("floodValue", "N/A");
        map.put("floodType", "N/A");
        map.put("deliveryProvider", "N/A");
        map.put("shopSortingSelected", "N/A");
        map.put(ConstantsKt.LOADED_SHOP_CLOSED_NO_PREORDER, "N/A");
        map.put("floodActive", "N/A");
        map.put("searchTerm", "N/A");
        map.put(ConstantsKt.LOADED_SHOP_ATTRIBUTES_SELECTED, "N/A");
        map.put("channelIndex", "N/A");
        map.put(ConstantsKt.LOADED_SHOPS_CLOSED_TODAY, "N/A");
        map.put(ConstantsKt.LOADED_SERVICE_AREA_DELIVERY, "N/A");
        map.put("channel", "N/A");
        map.put("shopFilteringSelected", "N/A");
        map.put("floodMessage", "N/A");
        map.put(ConstantsKt.LOADED_CHAIN_IDS, "N/A");
        map.put(ConstantsKt.LOADED_SHOP_OFFERS_SELECTED, "N/A");
        map.put("shopCategorySelected", "N/A");
    }

    public final void addShopsUpdatedNotAvailableParams$com_talabat_feature_pickup_data_data(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        map.put("floodValue", "N/A");
        map.put("floodType", "N/A");
        map.put("deliveryProvider", "N/A");
        map.put("shopSortingSelected", "N/A");
        map.put(ConstantsKt.LOADED_SHOP_CLOSED_NO_PREORDER, "N/A");
        map.put("floodActive", "N/A");
        map.put("searchTerm", "N/A");
        map.put(ConstantsKt.LOADED_SHOP_ATTRIBUTES_SELECTED, "N/A");
        map.put("channelIndex", "N/A");
        map.put(ConstantsKt.LOADED_SHOPS_CLOSED_TODAY, "N/A");
        map.put(ConstantsKt.LOADED_SERVICE_AREA_DELIVERY, "N/A");
        map.put("channel", "N/A");
        map.put("floodMessage", "N/A");
        map.put(ConstantsKt.LOADED_CHAIN_IDS, "N/A");
        map.put(ConstantsKt.LOADED_SHOP_OFFERS_SELECTED, "N/A");
        map.put("shopCategorySelected", "N/A");
    }

    @NotNull
    public final String getShopStatus$com_talabat_feature_pickup_data_data(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 5 ? "N/A" : "pre-order" : "prayer" : SDKCoreEvent.ForegroundStatus.VALUE_BUSY : "closed" : "open";
    }

    public final String mainCuisine$com_talabat_feature_pickup_data_data(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        if (restaurant.hasCusine()) {
            return restaurant.GACuisineString();
        }
        return "N/A";
    }

    @NotNull
    public final String orNotAvailable$com_talabat_feature_pickup_data_data(@Nullable String str) {
        return str == null ? "N/A" : str;
    }
}
