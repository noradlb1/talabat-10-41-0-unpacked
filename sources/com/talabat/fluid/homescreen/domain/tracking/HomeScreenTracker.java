package com.talabat.fluid.homescreen.domain.tracking;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u0000 +2\u00020\u0001:\u0001+J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J.\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J.\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&JF\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001a\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u001a\u0012\b\u0012\u00060\u0005j\u0002`\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH&J>\u0010\u001f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001a\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u001a\u0012\b\u0012\u00060\u0005j\u0002`\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u0005H&J.\u0010 \u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010\"\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010#\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010$\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010%\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J$\u0010&\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010&\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010'\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010(\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010)\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J.\u0010*\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&¨\u0006,"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "", "onRewardsClicked", "", "userId", "", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "onShorCutsClicked", "params", "", "onShorCutsSwiped", "onShortCutsLoaded", "trackBannerClick", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "trackBannerLoad", "trackEntryPointClicked", "trackGroceryCategoriesSwiped", "trackGroceryCategoryClicked", "trackHeroBannerClick", "trackHeroBannerLoad", "trackHeroBannerShown", "trackOrderStatusWidgetClicked", "chain", "Lkotlin/Pair;", "Lcom/talabat/fluid/homescreen/domain/tracking/ChainId;", "Lcom/talabat/fluid/homescreen/domain/tracking/ChainName;", "transactionId", "isPickupOrder", "", "trackOrderStatusWidgetShown", "trackSecondaryBannerClicked", "trackSecondaryBannerLoaded", "trackSecondaryBannerShown", "trackShopClicked", "trackSwimLaneItemClicked", "trackSwimLaneLoaded", "trackSwimLaneSwiped", "trackTProSubscriptionBannerClicked", "trackTProSubscriptionBannerLoaded", "trackVoucherCodeEntryClicked", "trackVoucherCodeEntryLoaded", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeScreenTracker {
    @NotNull
    public static final Companion Companion = Companion.f59718a;
    @NotNull
    public static final String KEY_BANNER_ID = "bannerId";
    @NotNull
    public static final String KEY_BANNER_LIST = "bannerList";
    @NotNull
    public static final String KEY_BANNER_NAME = "bannerName";
    @NotNull
    public static final String KEY_BANNER_POSITION = "bannerPosition";
    @NotNull
    public static final String KEY_BANNER_TOTAL = "bannerTotal";
    @NotNull
    public static final String KEY_BANNER_TYPE = "bannerType";
    @NotNull
    public static final String KEY_BANNER_ZONE = "bannerZone";
    @NotNull
    public static final String KEY_CAMPAIGN = "campaign";
    @NotNull
    public static final String KEY_CATEGORY_ID = "categoryId";
    @NotNull
    public static final String KEY_CHAIN_ID = "chainId";
    @NotNull
    public static final String KEY_CHAIN_NAME = "chainName";
    @NotNull
    public static final String KEY_CHANNEL = "channel";
    @NotNull
    public static final String KEY_CHANNEL_INDEX = "channelIndex";
    @NotNull
    public static final String KEY_CHANNEL_POSITION = "channelPosition";
    @NotNull
    public static final String KEY_COLLECTIONS_ITEMS = "collections_items";
    @NotNull
    public static final String KEY_COLLECTION_NAME = "channel";
    @NotNull
    public static final String KEY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    public static final String KEY_IS_PICKUP_ORDER = "orderPickup";
    @NotNull
    public static final String KEY_ITEM_POSITION = "position";
    @NotNull
    public static final String KEY_LISTING_PAGE_TYPE = "listingPageType";
    @NotNull
    public static final String KEY_LOCATION_ADDRESS = "locationAddress";
    @NotNull
    public static final String KEY_LOCATION_AREA = "locationArea";
    @NotNull
    public static final String KEY_LOCATION_CITY = "locationCity";
    @NotNull
    public static final String KEY_LOCATION_COUNTRY = "locationCountry";
    @NotNull
    public static final String KEY_LOCATION_LATITUDE = "locationLat";
    @NotNull
    public static final String KEY_LOCATION_LONGITUDE = "locationLon";
    @NotNull
    public static final String KEY_NAVIGATION_OPTION = "navigationOption";
    @NotNull
    public static final String KEY_NCR_REQUEST_TOKEN = "ncrRequestToken";
    @NotNull
    public static final String KEY_OFFER_VOUCHER_ID = "offerVoucherId";
    @NotNull
    public static final String KEY_PLATFORM = "platform";
    @NotNull
    public static final String KEY_SCREEN_NAME = "screenName";
    @NotNull
    public static final String KEY_SCREEN_TYPE = "screenType";
    @NotNull
    public static final String KEY_SHOP_AREA = "shopArea";
    @NotNull
    public static final String KEY_SHOP_CLICK_ORIGIN = "shopClickOrigin";
    @NotNull
    public static final String KEY_SHOP_COKE_UP_SELL = "shopCokeUpsell";
    @NotNull
    public static final String KEY_SHOP_DELIVERY_PROVIDER = "deliveryProvider";
    @NotNull
    public static final String KEY_SHOP_DELIVERY_TIME = "shopDeliveryTime";
    @NotNull
    public static final String KEY_SHOP_ID = "shopId";
    @NotNull
    public static final String KEY_SHOP_MAIN_CUISINE = "shopMainCuisine";
    @NotNull
    public static final String KEY_SHOP_NAME = "shopName";
    @NotNull
    public static final String KEY_SHOP_PAYMENT_METHODS = "shopPaymentMethods";
    @NotNull
    public static final String KEY_SHOP_POSITION = "shopPosition";
    @NotNull
    public static final String KEY_SHOP_SPONSORING = "shopSponsoring";
    @NotNull
    public static final String KEY_SHOP_STATUS = "shopStatus";
    @NotNull
    public static final String KEY_SHOP_TYPE = "shopType";
    @NotNull
    public static final String KEY_SPONSORED_CATEGORY = "sponsoredCategory";
    @NotNull
    public static final String KEY_SPONSORED_TOKEN = "sponsoredToken";
    @NotNull
    public static final String KEY_SPONSORED_TYPE = "sponsoredType";
    @NotNull
    public static final String KEY_SWIM_LANE_LENGTH = "swimlaneLength";
    @NotNull
    public static final String KEY_SWIM_LANE_POSITION = "position";
    @NotNull
    public static final String KEY_SWIM_LANE_REQUEST_ID = "swimlaneRequestId";
    @NotNull
    public static final String KEY_SWIM_LANE_SHOPS_IDS = "shopsIds";
    @NotNull
    public static final String KEY_SWIM_LANE_STRATEGY = "swimlaneStrategy";
    @NotNull
    public static final String KEY_SWIM_LANE_STRATEGY_LIST = "swimlaneStrategyList";
    @NotNull
    public static final String KEY_SWIM_LANE_TILES_DISPLAYED = "swimlaneTilesDisplayed";
    @NotNull
    public static final String KEY_SWIM_LANE_TITLE = "swimlaneTitle";
    @NotNull
    public static final String KEY_SWIM_LANE_TITLE_LIST = "swimlaneTitleList";
    @NotNull
    public static final String KEY_SWIM_LANE_TOTAL = "swimlaneTotal";
    @NotNull
    public static final String KEY_TRANSACTION_ID = "transactionId";
    @NotNull
    public static final String KEY_USER_ID = "userId";
    @NotNull
    public static final String KEY_USER_LOGGED_IN = "userLoggedIn";
    @NotNull
    public static final String KEY_USER_PREFERENCES = "userPreferences";
    @NotNull
    public static final String KEY_VENDOR_SPONSORING_PLACEMENT = "vendorSponsoringPlacement";
    @NotNull
    public static final String KEY_VERTICAL_NAME = "verticalName";
    @NotNull
    public static final String KEY_VERTICAL_POSITION = "verticalPosition";
    @NotNull
    public static final String KEY_WIDGET_NAME = "widgetName";
    @NotNull
    public static final String KEY_WIDGET_POSITION = "widgetPosition";
    @NotNull
    public static final String KEY_WIDGET_TYPE = "widgetType";
    @NotNull
    public static final String USER_TIME_STAMP = "userTimeStamp";
    @NotNull
    public static final String VALUE_HERO_BANNER_NAME = "tmart";
    @NotNull
    public static final String VALUE_NOT_AVAILABLE = "N/A";
    @NotNull
    public static final String VALUE_NOT_SPONSORED = "false";
    @NotNull
    public static final String VALUE_PLATFORM = "Android";
    @NotNull
    public static final String VALUE_SCREEN_NAME = "Home Screen";
    @NotNull
    public static final String VALUE_SCREEN_TYPE = "home";
    @NotNull
    public static final String VALUE_SPONSORED_PREFIX = "True: ";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bL\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker$Companion;", "", "()V", "KEY_BANNER_ID", "", "KEY_BANNER_LIST", "KEY_BANNER_NAME", "KEY_BANNER_POSITION", "KEY_BANNER_TOTAL", "KEY_BANNER_TYPE", "KEY_BANNER_ZONE", "KEY_CAMPAIGN", "KEY_CATEGORY_ID", "KEY_CHAIN_ID", "KEY_CHAIN_NAME", "KEY_CHANNEL", "KEY_CHANNEL_INDEX", "KEY_CHANNEL_POSITION", "KEY_COLLECTIONS_ITEMS", "KEY_COLLECTION_NAME", "KEY_EVENT_ORIGIN", "KEY_IS_PICKUP_ORDER", "KEY_ITEM_POSITION", "KEY_LISTING_PAGE_TYPE", "KEY_LOCATION_ADDRESS", "KEY_LOCATION_AREA", "KEY_LOCATION_CITY", "KEY_LOCATION_COUNTRY", "KEY_LOCATION_LATITUDE", "KEY_LOCATION_LONGITUDE", "KEY_NAVIGATION_OPTION", "KEY_NCR_REQUEST_TOKEN", "KEY_OFFER_VOUCHER_ID", "KEY_PLATFORM", "KEY_SCREEN_NAME", "KEY_SCREEN_TYPE", "KEY_SHOP_AREA", "KEY_SHOP_CLICK_ORIGIN", "KEY_SHOP_COKE_UP_SELL", "KEY_SHOP_DELIVERY_PROVIDER", "KEY_SHOP_DELIVERY_TIME", "KEY_SHOP_ID", "KEY_SHOP_MAIN_CUISINE", "KEY_SHOP_NAME", "KEY_SHOP_PAYMENT_METHODS", "KEY_SHOP_POSITION", "KEY_SHOP_SPONSORING", "KEY_SHOP_STATUS", "KEY_SHOP_TYPE", "KEY_SPONSORED_CATEGORY", "KEY_SPONSORED_TOKEN", "KEY_SPONSORED_TYPE", "KEY_SWIM_LANE_LENGTH", "KEY_SWIM_LANE_POSITION", "KEY_SWIM_LANE_REQUEST_ID", "KEY_SWIM_LANE_SHOPS_IDS", "KEY_SWIM_LANE_STRATEGY", "KEY_SWIM_LANE_STRATEGY_LIST", "KEY_SWIM_LANE_TILES_DISPLAYED", "KEY_SWIM_LANE_TITLE", "KEY_SWIM_LANE_TITLE_LIST", "KEY_SWIM_LANE_TOTAL", "KEY_TRANSACTION_ID", "KEY_USER_ID", "KEY_USER_LOGGED_IN", "KEY_USER_PREFERENCES", "KEY_VENDOR_SPONSORING_PLACEMENT", "KEY_VERTICAL_NAME", "KEY_VERTICAL_POSITION", "KEY_WIDGET_NAME", "KEY_WIDGET_POSITION", "KEY_WIDGET_TYPE", "USER_TIME_STAMP", "VALUE_HERO_BANNER_NAME", "VALUE_NOT_AVAILABLE", "VALUE_NOT_SPONSORED", "VALUE_PLATFORM", "VALUE_SCREEN_NAME", "VALUE_SCREEN_TYPE", "VALUE_SPONSORED_PREFIX", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String KEY_BANNER_ID = "bannerId";
        @NotNull
        public static final String KEY_BANNER_LIST = "bannerList";
        @NotNull
        public static final String KEY_BANNER_NAME = "bannerName";
        @NotNull
        public static final String KEY_BANNER_POSITION = "bannerPosition";
        @NotNull
        public static final String KEY_BANNER_TOTAL = "bannerTotal";
        @NotNull
        public static final String KEY_BANNER_TYPE = "bannerType";
        @NotNull
        public static final String KEY_BANNER_ZONE = "bannerZone";
        @NotNull
        public static final String KEY_CAMPAIGN = "campaign";
        @NotNull
        public static final String KEY_CATEGORY_ID = "categoryId";
        @NotNull
        public static final String KEY_CHAIN_ID = "chainId";
        @NotNull
        public static final String KEY_CHAIN_NAME = "chainName";
        @NotNull
        public static final String KEY_CHANNEL = "channel";
        @NotNull
        public static final String KEY_CHANNEL_INDEX = "channelIndex";
        @NotNull
        public static final String KEY_CHANNEL_POSITION = "channelPosition";
        @NotNull
        public static final String KEY_COLLECTIONS_ITEMS = "collections_items";
        @NotNull
        public static final String KEY_COLLECTION_NAME = "channel";
        @NotNull
        public static final String KEY_EVENT_ORIGIN = "eventOrigin";
        @NotNull
        public static final String KEY_IS_PICKUP_ORDER = "orderPickup";
        @NotNull
        public static final String KEY_ITEM_POSITION = "position";
        @NotNull
        public static final String KEY_LISTING_PAGE_TYPE = "listingPageType";
        @NotNull
        public static final String KEY_LOCATION_ADDRESS = "locationAddress";
        @NotNull
        public static final String KEY_LOCATION_AREA = "locationArea";
        @NotNull
        public static final String KEY_LOCATION_CITY = "locationCity";
        @NotNull
        public static final String KEY_LOCATION_COUNTRY = "locationCountry";
        @NotNull
        public static final String KEY_LOCATION_LATITUDE = "locationLat";
        @NotNull
        public static final String KEY_LOCATION_LONGITUDE = "locationLon";
        @NotNull
        public static final String KEY_NAVIGATION_OPTION = "navigationOption";
        @NotNull
        public static final String KEY_NCR_REQUEST_TOKEN = "ncrRequestToken";
        @NotNull
        public static final String KEY_OFFER_VOUCHER_ID = "offerVoucherId";
        @NotNull
        public static final String KEY_PLATFORM = "platform";
        @NotNull
        public static final String KEY_SCREEN_NAME = "screenName";
        @NotNull
        public static final String KEY_SCREEN_TYPE = "screenType";
        @NotNull
        public static final String KEY_SHOP_AREA = "shopArea";
        @NotNull
        public static final String KEY_SHOP_CLICK_ORIGIN = "shopClickOrigin";
        @NotNull
        public static final String KEY_SHOP_COKE_UP_SELL = "shopCokeUpsell";
        @NotNull
        public static final String KEY_SHOP_DELIVERY_PROVIDER = "deliveryProvider";
        @NotNull
        public static final String KEY_SHOP_DELIVERY_TIME = "shopDeliveryTime";
        @NotNull
        public static final String KEY_SHOP_ID = "shopId";
        @NotNull
        public static final String KEY_SHOP_MAIN_CUISINE = "shopMainCuisine";
        @NotNull
        public static final String KEY_SHOP_NAME = "shopName";
        @NotNull
        public static final String KEY_SHOP_PAYMENT_METHODS = "shopPaymentMethods";
        @NotNull
        public static final String KEY_SHOP_POSITION = "shopPosition";
        @NotNull
        public static final String KEY_SHOP_SPONSORING = "shopSponsoring";
        @NotNull
        public static final String KEY_SHOP_STATUS = "shopStatus";
        @NotNull
        public static final String KEY_SHOP_TYPE = "shopType";
        @NotNull
        public static final String KEY_SPONSORED_CATEGORY = "sponsoredCategory";
        @NotNull
        public static final String KEY_SPONSORED_TOKEN = "sponsoredToken";
        @NotNull
        public static final String KEY_SPONSORED_TYPE = "sponsoredType";
        @NotNull
        public static final String KEY_SWIM_LANE_LENGTH = "swimlaneLength";
        @NotNull
        public static final String KEY_SWIM_LANE_POSITION = "position";
        @NotNull
        public static final String KEY_SWIM_LANE_REQUEST_ID = "swimlaneRequestId";
        @NotNull
        public static final String KEY_SWIM_LANE_SHOPS_IDS = "shopsIds";
        @NotNull
        public static final String KEY_SWIM_LANE_STRATEGY = "swimlaneStrategy";
        @NotNull
        public static final String KEY_SWIM_LANE_STRATEGY_LIST = "swimlaneStrategyList";
        @NotNull
        public static final String KEY_SWIM_LANE_TILES_DISPLAYED = "swimlaneTilesDisplayed";
        @NotNull
        public static final String KEY_SWIM_LANE_TITLE = "swimlaneTitle";
        @NotNull
        public static final String KEY_SWIM_LANE_TITLE_LIST = "swimlaneTitleList";
        @NotNull
        public static final String KEY_SWIM_LANE_TOTAL = "swimlaneTotal";
        @NotNull
        public static final String KEY_TRANSACTION_ID = "transactionId";
        @NotNull
        public static final String KEY_USER_ID = "userId";
        @NotNull
        public static final String KEY_USER_LOGGED_IN = "userLoggedIn";
        @NotNull
        public static final String KEY_USER_PREFERENCES = "userPreferences";
        @NotNull
        public static final String KEY_VENDOR_SPONSORING_PLACEMENT = "vendorSponsoringPlacement";
        @NotNull
        public static final String KEY_VERTICAL_NAME = "verticalName";
        @NotNull
        public static final String KEY_VERTICAL_POSITION = "verticalPosition";
        @NotNull
        public static final String KEY_WIDGET_NAME = "widgetName";
        @NotNull
        public static final String KEY_WIDGET_POSITION = "widgetPosition";
        @NotNull
        public static final String KEY_WIDGET_TYPE = "widgetType";
        @NotNull
        public static final String USER_TIME_STAMP = "userTimeStamp";
        @NotNull
        public static final String VALUE_HERO_BANNER_NAME = "tmart";
        @NotNull
        public static final String VALUE_NOT_AVAILABLE = "N/A";
        @NotNull
        public static final String VALUE_NOT_SPONSORED = "false";
        @NotNull
        public static final String VALUE_PLATFORM = "Android";
        @NotNull
        public static final String VALUE_SCREEN_NAME = "Home Screen";
        @NotNull
        public static final String VALUE_SCREEN_TYPE = "home";
        @NotNull
        public static final String VALUE_SPONSORED_PREFIX = "True: ";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f59718a = new Companion();

        private Companion() {
        }
    }

    void onRewardsClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData);

    void onShorCutsClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void onShorCutsSwiped(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void onShortCutsLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackBannerClick(@NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map, @NotNull IObservabilityManager iObservabilityManager);

    void trackBannerLoad(@NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map, @NotNull IObservabilityManager iObservabilityManager);

    void trackEntryPointClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackGroceryCategoriesSwiped(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackGroceryCategoryClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackHeroBannerClick(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackHeroBannerLoad(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackHeroBannerShown(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackOrderStatusWidgetClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Pair<String, String> pair, @NotNull String str2, boolean z11);

    void trackOrderStatusWidgetShown(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Pair<String, String> pair, @NotNull String str2);

    void trackSecondaryBannerClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackSecondaryBannerLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackSecondaryBannerShown(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackShopClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackSwimLaneItemClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackSwimLaneLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackSwimLaneSwiped(@NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackSwimLaneSwiped(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackTProSubscriptionBannerClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackTProSubscriptionBannerLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackVoucherCodeEntryClicked(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);

    void trackVoucherCodeEntryLoaded(@Nullable String str, @NotNull LocationDataFactory.LocationData locationData, @NotNull Map<String, String> map);
}
