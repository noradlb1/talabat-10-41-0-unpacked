package datamodels;

import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.impressions.ImpressionsItem;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RestaurantListItemModel implements ImpressionsItem {
    public static final int TYPE_AD = 7;
    public static final int TYPE_CARD_VIEW = 13;
    public static final int TYPE_FEATURE_PRODUCT = 14;
    public static final int TYPE_FLUTTER_COLLECTIONS = 15;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_HERO_RECOMMENDATION_RESTAURANTS = 5;
    public static final int TYPE_ITEM = 2;
    public static final int TYPE_RECOMMENDATION_RESTAURANTS = 4;
    public static final int TYPE_REORDER_RESTAURANTS = 6;
    public static final int TYPE_REWARDS_MISSION = 16;
    public static final int TYPE_SWIMALNE = 12;
    public static final int TYPE_TALABAT_GO_HEADER = 3;
    public static final int TYPE_TALABAT_GO_WITHOUT_LOGO = 8;
    public static final int TYPE_TALABAT_GO_WITH_NEW_STYLE = 9;
    public static final int TYPE_TOP_ITEMS_RESTAURANTS = 10;
    public AdsWrapper adsWrapper;
    public Object data;
    public Restaurant restaurant;
    public int type;

    public RestaurantListItemModel() {
    }

    public RestaurantListItemModel(int i11, Object obj) {
        this.type = i11;
        this.data = obj;
    }

    @NotNull
    public static RestaurantListItemModel fromAd(@NotNull AdsWrapper adsWrapper2) {
        RestaurantListItemModel restaurantListItemModel = new RestaurantListItemModel();
        restaurantListItemModel.type = 7;
        restaurantListItemModel.adsWrapper = adsWrapper2;
        return restaurantListItemModel;
    }

    public static RestaurantListItemModel fromFlutterCollections() {
        RestaurantListItemModel restaurantListItemModel = new RestaurantListItemModel();
        restaurantListItemModel.type = 15;
        return restaurantListItemModel;
    }

    public static RestaurantListItemModel fromHeader() {
        RestaurantListItemModel restaurantListItemModel = new RestaurantListItemModel();
        restaurantListItemModel.type = 1;
        return restaurantListItemModel;
    }

    @NotNull
    public static RestaurantListItemModel fromRewardsMission(@NotNull Mission mission) {
        RestaurantListItemModel restaurantListItemModel = new RestaurantListItemModel();
        restaurantListItemModel.type = 16;
        restaurantListItemModel.data = mission;
        return restaurantListItemModel;
    }

    public static RestaurantListItemModel fromVendor(Restaurant restaurant2) {
        RestaurantListItemModel restaurantListItemModel = new RestaurantListItemModel();
        restaurantListItemModel.type = 2;
        restaurantListItemModel.restaurant = restaurant2;
        return restaurantListItemModel;
    }

    @NotNull
    public static RestaurantListItemModel fromVendorSwimlane(@NotNull Swimlane swimlane) {
        RestaurantListItemModel restaurantListItemModel = new RestaurantListItemModel();
        restaurantListItemModel.type = 12;
        restaurantListItemModel.data = swimlane;
        return restaurantListItemModel;
    }

    @Nullable
    public Integer getId() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return Integer.valueOf(restaurant2.f13872id);
        }
        return null;
    }

    public RestaurantListItemModel(int i11, Restaurant restaurant2, AdsWrapper adsWrapper2) {
        this.type = i11;
        this.restaurant = restaurant2;
        this.adsWrapper = adsWrapper2;
    }
}
