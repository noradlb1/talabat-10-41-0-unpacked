package com.talabat.core.tracking.common.events;

import JsonModels.PolygonEvents;
import com.talabat.core.tracking.common.helpers.EventDataHelper;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.helpers.GlobalDataModel;
import datamodels.MenuSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AdjustTokens;
import tracking.TalabatAdjust;
import tracking.gtm.RestaurantsEventsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001eH\u0002J&\u0010\u001f\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J&\u0010 \u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J&\u0010!\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020$0)H\u0016J\u0013\u0010*\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b+R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/talabat/core/tracking/common/events/ShopDetailsLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "isDarkStore", "", "restaurant", "Ldatamodels/Restaurant;", "extraRestaurant", "", "screenName", "emptyCart", "hasIcon", "menuSectionNamesForGA", "menuSections", "Ljava/util/ArrayList;", "Ldatamodels/MenuSection;", "Lkotlin/collections/ArrayList;", "countOfItemsWithImages", "", "itemsCount", "searchTerm", "dataHelper", "Lcom/talabat/core/tracking/common/helpers/EventDataHelper;", "(ZLdatamodels/Restaurant;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/ArrayList;IILjava/lang/String;Lcom/talabat/core/tracking/common/helpers/EventDataHelper;)V", "addAdjustAttributes", "", "", "addGoogleAnalyticsAttributes", "addPolygonAttributes", "", "attributesMap", "", "addRemainingAttributes", "addScreenAttributes", "addShopAttributes", "attributes", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "getRestaurant", "name", "platforms", "", "value", "value$com_talabat_core_tracking_common_common", "Companion", "com_talabat_core_tracking_common_common"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopDetailsLoadedEvent extends TalabatEvent {
    @NotNull
    public static final String ADJUST_CHAIN_ID = "chain_id";
    @NotNull
    public static final String CART_EMPTY = "cartEmpty";
    @NotNull
    public static final String CHAIN_ID = "chainId";
    @NotNull
    public static final String CHAIN_NAME = "chainName";
    @NotNull
    public static final String CHAIN_SHOPS = "chainShops";
    @NotNull
    public static final String CUISINE_NAMES = "cuisine_names";
    @NotNull
    public static final String CURRENCY_CODE = "currencyCode";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEAL = "deal";
    @NotNull
    public static final String DELIVERY_PROVIDER = "deliveryProvider";
    @NotNull
    public static final String EVENT_NAME = "shop_details_loaded";
    @NotNull
    public static final String FB_CONTENT = "fb_content";
    @NotNull
    public static final String FB_CONTENT_ID = "fb_content_id";
    @NotNull
    public static final String FB_CONTENT_TYPE = "fb_content_type";
    @NotNull
    public static final String FLOOD_ACTIVE = "floodActive";
    @NotNull
    public static final String FLOOD_MESSAGE = "floodMessage";
    @NotNull
    public static final String FLOOD_TYPE = "floodType";
    @NotNull
    public static final String FLOOD_VALUE = "floodValue";
    @NotNull
    public static final String ITEMS_NUMBER = "itemsNumber";
    @NotNull
    public static final String ITEMS_PICTURE_NUMBER = "itemsPictureNumber";
    @NotNull
    public static final String LISTING_PAGE_TYPE = "listingPageType";
    @NotNull
    public static final String MENU_CATEGORY_NUMBER = "menuCategoryNumber";
    @NotNull
    public static final String OFFER_CAMPAIGN_ID = "offerCampaignId";
    @NotNull
    public static final String OWN_DELIVERY = "own_delivery";
    @NotNull
    public static final String RATING_QUANTITY = "rating_quantity";
    @NotNull
    public static final String RATING_SCORE = "rating_score";
    @NotNull
    public static final String SCREEN_NAME = "screenName";
    @NotNull
    public static final String SCREEN_TYPE = "screenType";
    @NotNull
    public static final String SEARCH_TERM = "searchTerm";
    @NotNull
    public static final String SHOP_AREA = "shopArea";
    @NotNull
    public static final String SHOP_CATEGORY_LIST = "shopCategoryList";
    @NotNull
    public static final String SHOP_CATEGORY_SELECTED = "shopCategorySelected";
    @NotNull
    public static final String SHOP_CLICK_ORIGIN = "shopClickOrigin";
    @NotNull
    public static final String SHOP_CLOSE_PREORDER = "shopClosePreorder";
    @NotNull
    public static final String SHOP_COKE_UPSELL = "shopCokeUpsell";
    @NotNull
    public static final String SHOP_COORDINATES = "shopCoordinates";
    @NotNull
    public static final String SHOP_DELIVERY_FEE = "shopDeliveryFee";
    @NotNull
    public static final String SHOP_DELIVERY_TIME = "shopDeliveryTime";
    @NotNull
    public static final String SHOP_ID = "shopId";
    @NotNull
    public static final String SHOP_MAIN_CUISINE = "shopMainCuisine";
    @NotNull
    public static final String SHOP_MINIMUM_ORDER_VALUE = "shopMinimumOrderValue";
    @NotNull
    public static final String SHOP_NAME = "shopName";
    @NotNull
    public static final String SHOP_OFFER_TYPE = "shopOfferType";
    @NotNull
    public static final String SHOP_OPEN = "shopOpen";
    @NotNull
    public static final String SHOP_PAYMENT_METHODS = "shopPaymentMethods";
    @NotNull
    public static final String SHOP_RATING_QUALITY = "shopRatingQuality";
    @NotNull
    public static final String SHOP_RATING_QUANTITY = "shopRatingQuantity";
    @NotNull
    public static final String SHOP_SPONSORING = "shopSponsoring";
    @NotNull
    public static final String SHOP_STATUS = "shopStatus";
    @NotNull
    public static final String SHOP_TYPE = "shopType";
    @NotNull
    public static final String SHOP_WITH_IMAGES = "shopWithImages";
    @NotNull
    public static final String SHOP_WITH_OFFER = "shopWithOffer";
    @NotNull
    public static final String USER_ONLINE_PAYMENT_METHODS = "userOnlinePaymentMethods";
    @NotNull
    public static final String VALUE_NOT_AVAILABLE = "N/A";
    @NotNull
    public static final String VENDOR_ID = "vendor_id";
    @NotNull
    public static final String VENDOR_NAME = "vendor_name";
    private final int countOfItemsWithImages;
    @NotNull
    private final EventDataHelper dataHelper;
    private final boolean emptyCart;
    @Nullable
    private final String extraRestaurant;
    private final boolean hasIcon;
    private final boolean isDarkStore;
    private final int itemsCount;
    @Nullable
    private final String menuSectionNamesForGA;
    @Nullable
    private final ArrayList<MenuSection> menuSections;
    @Nullable
    private final Restaurant restaurant;
    @NotNull
    private final String screenName;
    @Nullable
    private final String searchTerm;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b7\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/talabat/core/tracking/common/events/ShopDetailsLoadedEvent$Companion;", "", "()V", "ADJUST_CHAIN_ID", "", "CART_EMPTY", "CHAIN_ID", "CHAIN_NAME", "CHAIN_SHOPS", "CUISINE_NAMES", "CURRENCY_CODE", "DEAL", "DELIVERY_PROVIDER", "EVENT_NAME", "FB_CONTENT", "FB_CONTENT_ID", "FB_CONTENT_TYPE", "FLOOD_ACTIVE", "FLOOD_MESSAGE", "FLOOD_TYPE", "FLOOD_VALUE", "ITEMS_NUMBER", "ITEMS_PICTURE_NUMBER", "LISTING_PAGE_TYPE", "MENU_CATEGORY_NUMBER", "OFFER_CAMPAIGN_ID", "OWN_DELIVERY", "RATING_QUANTITY", "RATING_SCORE", "SCREEN_NAME", "SCREEN_TYPE", "SEARCH_TERM", "SHOP_AREA", "SHOP_CATEGORY_LIST", "SHOP_CATEGORY_SELECTED", "SHOP_CLICK_ORIGIN", "SHOP_CLOSE_PREORDER", "SHOP_COKE_UPSELL", "SHOP_COORDINATES", "SHOP_DELIVERY_FEE", "SHOP_DELIVERY_TIME", "SHOP_ID", "SHOP_MAIN_CUISINE", "SHOP_MINIMUM_ORDER_VALUE", "SHOP_NAME", "SHOP_OFFER_TYPE", "SHOP_OPEN", "SHOP_PAYMENT_METHODS", "SHOP_RATING_QUALITY", "SHOP_RATING_QUANTITY", "SHOP_SPONSORING", "SHOP_STATUS", "SHOP_TYPE", "SHOP_WITH_IMAGES", "SHOP_WITH_OFFER", "USER_ONLINE_PAYMENT_METHODS", "VALUE_NOT_AVAILABLE", "VENDOR_ID", "VENDOR_NAME", "com_talabat_core_tracking_common_common"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlatformName.values().length];
            iArr[PlatformName.ADJUST.ordinal()] = 1;
            iArr[PlatformName.GOOGLE_ANALYTICS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopDetailsLoadedEvent(boolean r17, datamodels.Restaurant r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22, java.lang.String r23, java.util.ArrayList r24, int r25, int r26, java.lang.String r27, com.talabat.core.tracking.common.helpers.EventDataHelper r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r17
        L_0x000b:
            r1 = r0 & 2
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r5 = r3
            goto L_0x0014
        L_0x0012:
            r5 = r18
        L_0x0014:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001a
            r6 = r3
            goto L_0x001c
        L_0x001a:
            r6 = r19
        L_0x001c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0022
            r8 = r2
            goto L_0x0024
        L_0x0022:
            r8 = r21
        L_0x0024:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002a
            r9 = r2
            goto L_0x002c
        L_0x002a:
            r9 = r22
        L_0x002c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0032
            r10 = r3
            goto L_0x0034
        L_0x0032:
            r10 = r23
        L_0x0034:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            r11 = r3
            goto L_0x003c
        L_0x003a:
            r11 = r24
        L_0x003c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0042
            r12 = r2
            goto L_0x0044
        L_0x0042:
            r12 = r25
        L_0x0044:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004a
            r13 = r2
            goto L_0x004c
        L_0x004a:
            r13 = r26
        L_0x004c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r14 = r3
            goto L_0x0054
        L_0x0052:
            r14 = r27
        L_0x0054:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005f
            com.talabat.core.tracking.common.helpers.EventDataHelper r0 = new com.talabat.core.tracking.common.helpers.EventDataHelper
            r0.<init>()
            r15 = r0
            goto L_0x0061
        L_0x005f:
            r15 = r28
        L_0x0061:
            r3 = r16
            r7 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent.<init>(boolean, datamodels.Restaurant, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.util.ArrayList, int, int, java.lang.String, com.talabat.core.tracking.common.helpers.EventDataHelper, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final Map<String, Object> addAdjustAttributes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            linkedHashMap.put(VENDOR_NAME, restaurant2.getName());
            linkedHashMap.put("vendor_id", String.valueOf(restaurant2.branchId));
            linkedHashMap.put(RATING_SCORE, String.valueOf(restaurant2.rating));
            linkedHashMap.put(RATING_QUANTITY, restaurant2.totalRating.toString());
            linkedHashMap.put("fb_content_id", String.valueOf(restaurant2.branchId));
            linkedHashMap.put("fb_content", TalabatAdjust.getFBContent(restaurant2.branchId));
            linkedHashMap.put("fb_content_type", TalabatAdjust.getFBContentType());
            linkedHashMap.put("chain_id", String.valueOf(restaurant2.f13872id));
            boolean z11 = true;
            linkedHashMap.put(OWN_DELIVERY, String.valueOf(!restaurant2.isTalabatGo));
            linkedHashMap.put(CUISINE_NAMES, TalabatAdjust.getCuisines(restaurant2.getCuisines()));
            if (!restaurant2.isMealDealAvailable && !restaurant2.isCouponAvailable) {
                z11 = false;
            }
            linkedHashMap.put(DEAL, String.valueOf(z11));
        }
        return linkedHashMap;
    }

    private final Map<String, Object> addGoogleAnalyticsAttributes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Restaurant restaurant2 = getRestaurant();
        if (restaurant2 != null) {
            addPolygonAttributes(linkedHashMap);
            addScreenAttributes(linkedHashMap, restaurant2);
            addShopAttributes(linkedHashMap, restaurant2);
            addRemainingAttributes(linkedHashMap, restaurant2);
        }
        return linkedHashMap;
    }

    private final void addPolygonAttributes(Map<String, Object> map) {
        PolygonEvents polygonEvents = GlobalDataModel.POLYGON_TRACKING.polygonEvents;
        if (polygonEvents == null || this.isDarkStore) {
            map.put("floodActive", "N/A");
            map.put("floodType", "N/A");
            map.put("floodMessage", "N/A");
            map.put("floodValue", "N/A");
            return;
        }
        map.put("floodActive", Boolean.valueOf(polygonEvents.isActive));
        map.put("floodType", polygonEvents.eventType);
        map.put("floodMessage", polygonEvents.eventMsg);
        map.put("floodValue", Integer.valueOf(polygonEvents.eventValue));
    }

    private final void addRemainingAttributes(Map<String, Object> map, Restaurant restaurant2) {
        String str;
        String str2;
        map.put("listingPageType", this.dataHelper.listingType(restaurant2));
        map.put("deliveryProvider", this.dataHelper.restaurantType(restaurant2));
        map.put("currencyCode", TalabatAdjust.getSelectedCurrencyCode());
        String str3 = this.searchTerm;
        String str4 = "N/A";
        if (str3 == null) {
            str3 = str4;
        }
        map.put("searchTerm", str3);
        map.put(CART_EMPTY, String.valueOf(this.emptyCart));
        String talabatCreditBalance = this.dataHelper.getTalabatCreditBalance();
        map.put("userOnlinePaymentMethods", "credit:" + talabatCreditBalance);
        if (this.isDarkStore) {
            str = str4;
        } else {
            str = String.valueOf(this.countOfItemsWithImages);
        }
        map.put(ITEMS_PICTURE_NUMBER, str);
        ArrayList<MenuSection> arrayList = this.menuSections;
        if (arrayList == null || arrayList.size() <= 0 || this.isDarkStore) {
            str2 = "0";
        } else {
            str2 = String.valueOf(this.menuSections.size());
        }
        map.put(MENU_CATEGORY_NUMBER, str2);
        if (!this.isDarkStore) {
            str4 = String.valueOf(this.itemsCount);
        }
        map.put("itemsNumber", str4);
        if (!this.isDarkStore) {
            map.put(OFFER_CAMPAIGN_ID, this.dataHelper.getCampaignIds());
        }
    }

    private final void addScreenAttributes(Map<String, Object> map, Restaurant restaurant2) {
        map.put("screenType", "shop_details");
        if (this.isDarkStore) {
            map.put("screenName", value$com_talabat_core_tracking_common_common(this.screenName));
        } else {
            map.put("screenName", this.dataHelper.getScreenName(restaurant2.shopType, "Menu Screen"));
        }
    }

    private final void addShopAttributes(Map<String, Object> map, Restaurant restaurant2) {
        String str;
        String str2;
        String str3;
        boolean z11;
        map.put("shopStatus", this.dataHelper.getShopStatus(restaurant2.statusType));
        map.put("shopPaymentMethods", this.dataHelper.getPaymentMethods(restaurant2));
        if (this.isDarkStore) {
            str = RestaurantsEventsKt.sponsoringData(restaurant2);
        } else {
            str = RestaurantsEventsKt.sponsoringData(GlobalDataModel.SELECTED.getRestaurant());
        }
        map.put("shopSponsoring", str);
        map.put("chainName", value$com_talabat_core_tracking_common_common(restaurant2.f13873name));
        int i11 = restaurant2.f13872id;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        map.put("chainId", sb2.toString());
        String str4 = "N/A";
        map.put("chainShops", str4);
        if (this.isDarkStore) {
            str2 = str4;
        } else {
            str2 = value$com_talabat_core_tracking_common_common(this.menuSectionNamesForGA);
        }
        map.put("shopCategoryList", str2);
        map.put("shopName", value$com_talabat_core_tracking_common_common(restaurant2.branchName));
        int i12 = restaurant2.branchId;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i12);
        map.put("shopId", sb3.toString());
        double latitude = restaurant2.getRestaurantLocation().getLatitude();
        double longitude = restaurant2.getRestaurantLocation().getLongitude();
        map.put(SHOP_COORDINATES, latitude + "," + longitude);
        map.put("shopArea", value$com_talabat_core_tracking_common_common(restaurant2.areaName));
        if (this.isDarkStore) {
            str3 = str4;
        } else {
            str3 = String.valueOf(this.hasIcon);
        }
        map.put(SHOP_WITH_IMAGES, str3);
        map.put("shopCategorySelected", str4);
        map.put("shopWithOffer", this.dataHelper.getShopOffer(restaurant2));
        map.put("shopClickOrigin", value$com_talabat_core_tracking_common_common(GlobalDataModel.ShopClickOrigin));
        map.put("shopOfferType", this.dataHelper.getOfferType(restaurant2));
        map.put("shopType", this.dataHelper.listingType(restaurant2));
        map.put("shopCokeUpsell", String.valueOf(restaurant2.isUpSelling));
        map.put(SHOP_RATING_QUALITY, String.valueOf(restaurant2.getRating()));
        map.put(SHOP_RATING_QUANTITY, value$com_talabat_core_tracking_common_common(restaurant2.getTotalRating()));
        if (restaurant2.statusType == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        map.put(SHOP_OPEN, String.valueOf(z11));
        map.put(SHOP_CLOSE_PREORDER, str4);
        map.put(SHOP_MINIMUM_ORDER_VALUE, String.valueOf(restaurant2.getMinimumAmount()));
        map.put("shopDeliveryTime", value$com_talabat_core_tracking_common_common(restaurant2.deliveryTimeInteger));
        map.put("shopDeliveryFee", String.valueOf(restaurant2.deliveryCharges));
        if (restaurant2.hasCusine()) {
            str4 = restaurant2.GACuisineString();
        }
        map.put("shopMainCuisine", str4);
    }

    private final Restaurant getRestaurant() {
        if (this.isDarkStore) {
            return this.dataHelper.getRestaurantForDarkstores(this.extraRestaurant);
        }
        return this.restaurant;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        int i11 = WhenMappings.$EnumSwitchMapping$0[platformName.ordinal()];
        if (i11 == 1) {
            return addAdjustAttributes();
        }
        if (i11 != 2) {
            return MapsKt__MapsKt.emptyMap();
        }
        return addGoogleAnalyticsAttributes();
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.screenName;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        if (WhenMappings.$EnumSwitchMapping$0[platformName.ordinal()] != 1) {
            return EVENT_NAME;
        }
        String viewRestaurant = AdjustTokens.viewRestaurant();
        Intrinsics.checkNotNullExpressionValue(viewRestaurant, "viewRestaurant()");
        return viewRestaurant;
    }

    @NotNull
    public List<PlatformName> platforms() {
        if (this.isDarkStore) {
            return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
        }
        return CollectionsKt__CollectionsKt.listOf(PlatformName.GOOGLE_ANALYTICS, PlatformName.ADJUST);
    }

    @NotNull
    public final String value$com_talabat_core_tracking_common_common(@Nullable String str) {
        return str == null || str.length() == 0 ? "N/A" : str;
    }

    public ShopDetailsLoadedEvent(boolean z11, @Nullable Restaurant restaurant2, @Nullable String str, @NotNull String str2, boolean z12, boolean z13, @Nullable String str3, @Nullable ArrayList<MenuSection> arrayList, int i11, int i12, @Nullable String str4, @NotNull EventDataHelper eventDataHelper) {
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(eventDataHelper, "dataHelper");
        this.isDarkStore = z11;
        this.restaurant = restaurant2;
        this.extraRestaurant = str;
        this.screenName = str2;
        this.emptyCart = z12;
        this.hasIcon = z13;
        this.menuSectionNamesForGA = str3;
        this.menuSections = arrayList;
        this.countOfItemsWithImages = i11;
        this.itemsCount = i12;
        this.searchTerm = str4;
        this.dataHelper = eventDataHelper;
    }
}
