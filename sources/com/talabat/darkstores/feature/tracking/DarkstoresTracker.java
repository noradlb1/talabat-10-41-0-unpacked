package com.talabat.darkstores.feature.tracking;

import android.content.Context;
import com.integration.IntegrationAppTracker;
import com.models.ProductTrackingModel;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.common.helpers.EventDataHelper;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.TrackingUtilKt;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTrackerKt;
import com.talabat.darkstores.feature.tracking.data.BannerStoreClickedEvent;
import com.talabat.darkstores.feature.tracking.data.CategoryLoadedEvent;
import com.talabat.darkstores.feature.tracking.data.CollectionClickedEvent;
import com.talabat.darkstores.feature.tracking.data.DarkstoreDetails;
import com.talabat.darkstores.feature.tracking.data.PreCheckoutAlertEvent;
import com.talabat.darkstores.feature.tracking.data.ProductDetails;
import com.talabat.darkstores.feature.tracking.data.ShopDetails;
import com.talabat.darkstores.feature.tracking.data.VendorVisitDetails;
import com.talabat.darkstores.feature.tracking.data.VendorVisitEvent;
import com.talabat.darkstores.model.Banner;
import com.talabat.feature.swimlanevoucherslist.data.tracking.VoucherProductDetailsOpenedEvent;
import com.talabat.feature.swimlanevoucherslist.data.tracking.VoucherSwimLaneClickedEvent;
import com.talabat.feature.swimlanevoucherslist.data.tracking.VoucherSwimLaneLoadedEvent;
import com.talabat.flutter.VendorListSearchFlutterActivity;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001bH\u0016J \u0010#\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001bH\u0016J0\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0(2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0016J0\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020\u000e2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010(H\u0016J0\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000eH\u0016J\u001a\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010<\u001a\u00020\u0015H\u0016J\"\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010?\u001a\u00020\u000eH\u0016J\"\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010\u000e2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020\u0015H\u0016J\u001a\u0010F\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010\u000eH\u0016J0\u0010G\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020D2\b\u0010B\u001a\u0004\u0018\u00010\u000e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000e0(H\u0016J<\u0010I\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010\u000e2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00192\b\u0010N\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010O\u001a\u00020\u00152\b\u0010P\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\"\u0010Q\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\u001bH\u0016J(\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u0019H\u0016J\u0010\u0010Y\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020[H\u0016J\u0018\u0010\\\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u000eH\u0016J\u001e\u0010^\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u000e2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u000e0(H\u0016J \u0010`\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020\u000eH\u0016J\u0018\u0010c\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/DarkstoresTracker;", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "context", "Landroid/content/Context;", "appTracker", "Lcom/integration/IntegrationAppTracker$Companion;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "locationTrackingProvider", "Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "(Landroid/content/Context;Lcom/integration/IntegrationAppTracker$Companion;Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;)V", "defaultScreenName", "", "lastEventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "lastOpenedScreen", "restaurant", "getScreenName", "onAddCartClicked", "", "productDetails", "Lcom/talabat/darkstores/feature/tracking/data/ProductDetails;", "isAdd", "", "ageVerification", "", "searchRequestId", "eventOriginType", "onBannerClicked", "banner", "Lcom/talabat/darkstores/model/Banner;", "type", "position", "onBannerShown", "onCategoryClicked", "name", "id", "subcategories", "", "onCategoryLoaded", "event", "Lcom/talabat/darkstores/feature/tracking/data/CategoryLoadedEvent;", "onCategoryUpdated", "categoryName", "categoryId", "selectedItem", "products", "Lcom/models/ProductTrackingModel;", "onCollectionClicked", "chainId", "branchId", "isDarkstore", "collectionId", "collectionName", "onDarkstoreLoaded", "darkstoreDetails", "Lcom/talabat/darkstores/feature/tracking/data/DarkstoreDetails;", "extra", "onDarkstoresAgeVerificationShown", "onDarkstoresAllButtonClicked", "shopCategory", "originType", "onDarkstoresEmptySearchResult", "query", "requestId", "screenType", "Lcom/talabat/darkstores/feature/tracking/SearchResultScreenType;", "onDarkstoresSearchBarClicked", "onDarkstoresSearchResultClicked", "onDarkstoresSearchResultsLoaded", "productSkus", "onProductOpened", "description", "price", "", "isFavorite", "cartegoryId", "onScreenOpened", "screenName", "onSearchClosed", "itemCount", "onShopDetailsLoaded", "shopDetails", "Lcom/talabat/darkstores/feature/tracking/data/ShopDetails;", "emptyCart", "searchTerm", "isNewTrackerEnabled", "onVendorVisit", "vendorVisitDetails", "Lcom/talabat/darkstores/feature/tracking/data/VendorVisitDetails;", "sendNavigateToVoucherProductDetails", "eventOrigin", "sendSwimLaneLoadedEvent", "voucherTitles", "sendSwimLaneVoucherClickedEvent", "voucherPosition", "voucherName", "trackPreCheckoutAlertVisibility", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresTracker implements DarkstoresEventTracker {
    @NotNull
    private final IntegrationAppTracker.Companion appTracker;
    @NotNull
    private final Context context;
    @NotNull
    private final String defaultScreenName = "Dark Store";
    @NotNull
    private EventOriginType lastEventOriginType = EventOriginType.None;
    @Nullable
    private String lastOpenedScreen = "";
    @NotNull
    private final LocationTrackingProvider locationTrackingProvider;
    @Nullable
    private String restaurant = "";
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final TalabatTracker talabatTracker;

    public DarkstoresTracker(@NotNull Context context2, @NotNull IntegrationAppTracker.Companion companion, @NotNull TalabatTracker talabatTracker2, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2, @NotNull LocationTrackingProvider locationTrackingProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(companion, "appTracker");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider2, "locationTrackingProvider");
        this.context = context2;
        this.appTracker = companion;
        this.talabatTracker = talabatTracker2;
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
        this.locationTrackingProvider = locationTrackingProvider2;
    }

    @Nullable
    public String getScreenName() {
        return this.lastOpenedScreen;
    }

    public void onAddCartClicked(@NotNull ProductDetails productDetails, boolean z11, int i11, @Nullable String str, @Nullable EventOriginType eventOriginType) {
        String str2;
        String str3;
        Integer num;
        Intrinsics.checkNotNullParameter(productDetails, ProductTrackingProvider.DESCRIPTION);
        IntegrationAppTracker.Companion companion = this.appTracker;
        Context context2 = this.context;
        String str4 = this.restaurant;
        String categoryId = productDetails.getCategoryId();
        String description = productDetails.getDescription();
        String id2 = productDetails.getId();
        String name2 = productDetails.getName();
        float price = productDetails.getPrice();
        int quantity = productDetails.getQuantity();
        boolean isFavorite = productDetails.isFavorite();
        String str5 = this.lastOpenedScreen;
        if (eventOriginType == null || (str2 = eventOriginType.getTrackingName()) == null) {
            str2 = this.lastEventOriginType.getTrackingName();
        }
        String str6 = str2;
        SwimlaneTrackingData swimlaneTrackingData = productDetails.getSwimlaneTrackingData();
        if (swimlaneTrackingData != null) {
            str3 = swimlaneTrackingData.getSwimlaneTitle();
        } else {
            str3 = null;
        }
        SwimlaneTrackingData swimlaneTrackingData2 = productDetails.getSwimlaneTrackingData();
        if (swimlaneTrackingData2 != null) {
            num = swimlaneTrackingData2.getSwimlaneLength();
        } else {
            num = null;
        }
        companion.onDarkstoresAddToCartClicked(context2, str4, categoryId, description, id2, name2, price, quantity, isFavorite, z11, str5, str6, str3, num, i11, str, productDetails.getListPosition());
    }

    public void onBannerClicked(@NotNull Banner banner, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(str, "type");
        this.talabatTracker.track(new BannerStoreClickedEvent(this.storeInfoTrackingProvider, this.locationTrackingProvider, this.lastOpenedScreen, ProductImpressionTrackerKt.nmrAdClickEventData(banner, i11, str), this.lastEventOriginType));
    }

    public void onBannerShown(@NotNull Banner banner, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(str, "type");
        this.appTracker.onDarkstoresBannerShown(this.context, this.restaurant, banner.getGlobalId(), banner.getName(), this.lastOpenedScreen, str, i11);
    }

    public void onCategoryClicked(@NotNull String str, @Nullable String str2, @NotNull List<String> list, int i11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "subcategories");
        this.appTracker.onDarkstoresCategoryClicked(this.context, str, str2, list, i11, this.restaurant, this.lastOpenedScreen);
    }

    public void onCategoryLoaded(@NotNull CategoryLoadedEvent categoryLoadedEvent) {
        Intrinsics.checkNotNullParameter(categoryLoadedEvent, "event");
        this.appTracker.onDarkstoresCategoryLoaded(this.context, categoryLoadedEvent.getName(), categoryLoadedEvent.getCategoryId(), categoryLoadedEvent.getSubcategories(), this.restaurant, categoryLoadedEvent.getProducts(), this.lastOpenedScreen, categoryLoadedEvent.getExpanded(), categoryLoadedEvent.getEventOrigin());
    }

    public void onCategoryUpdated(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull List<ProductTrackingModel> list) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(str3, "selectedItem");
        Intrinsics.checkNotNullParameter(list, "products");
        this.appTracker.onDarkstoresCategoryUpdated(this.context, this.restaurant, str, str2, str3, list);
    }

    public void onCollectionClicked(int i11, int i12, boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, VendorListSearchFlutterActivity.COLLECTION_ID_KEY);
        Intrinsics.checkNotNullParameter(str2, "collectionName");
        this.talabatTracker.track(new CollectionClickedEvent(i11, i12, z11, str, str2));
    }

    public void onDarkstoreLoaded(@NotNull DarkstoreDetails darkstoreDetails, @Nullable String str) {
        Intrinsics.checkNotNullParameter(darkstoreDetails, "darkstoreDetails");
        this.restaurant = str;
        IntegrationAppTracker.Companion.onDarkstoresLoaded(this.context, str, this.lastOpenedScreen);
    }

    public void onDarkstoresAgeVerificationShown() {
        this.appTracker.onDarkstoresAgeVerificationShown(this.context, this.restaurant, this.lastOpenedScreen);
    }

    public void onDarkstoresAllButtonClicked(@NotNull String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "shopCategory");
        Intrinsics.checkNotNullParameter(str3, "originType");
        this.appTracker.onDarkstoresAllButtonClicked(this.context, this.restaurant, this.lastOpenedScreen, str, str2, str3);
    }

    public void onDarkstoresEmptySearchResult(@NotNull String str, @Nullable String str2, @NotNull SearchResultScreenType searchResultScreenType) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(searchResultScreenType, "screenType");
        this.appTracker.onDarkstoresEmptySearchResults(this.context, str, this.lastOpenedScreen, searchResultScreenType.getScreenType(), str2);
    }

    public void onDarkstoresSearchBarClicked() {
        this.appTracker.onDarkstoresSearchBarClicked(this.context, this.restaurant, this.lastOpenedScreen);
    }

    public void onDarkstoresSearchResultClicked(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        this.appTracker.onDarkstoresSearchResultsClicked(this.context, this.lastOpenedScreen, str, str2);
    }

    public void onDarkstoresSearchResultsLoaded(@NotNull String str, @NotNull SearchResultScreenType searchResultScreenType, @Nullable String str2, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(searchResultScreenType, "screenType");
        Intrinsics.checkNotNullParameter(list, "productSkus");
        this.appTracker.onDarkstoresSearchResultsLoaded(this.context, this.restaurant, searchResultScreenType.getScreenType(), str, str2, list);
    }

    public void onProductOpened(@NotNull String str, @NotNull String str2, @Nullable String str3, float f11, boolean z11, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.appTracker.onDarkstoresProductOpened(this.context, str, str2, str3, f11, z11, str4, this.restaurant, this.lastOpenedScreen);
    }

    public void onScreenOpened(@Nullable String str, @NotNull EventOriginType eventOriginType) {
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOriginType");
        this.lastOpenedScreen = str;
        this.lastEventOriginType = eventOriginType;
    }

    public void onSearchClosed(@NotNull String str, @Nullable String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "query");
        this.appTracker.onSearchClosed(this.context, this.restaurant, str, str2, i11);
    }

    public void onShopDetailsLoaded(@NotNull ShopDetails shopDetails, boolean z11, @NotNull String str, boolean z12) {
        Intrinsics.checkNotNullParameter(shopDetails, "shopDetails");
        Intrinsics.checkNotNullParameter(str, "searchTerm");
        if (z12) {
            TalabatTracker talabatTracker2 = this.talabatTracker;
            String str2 = this.restaurant;
            String str3 = this.lastOpenedScreen;
            if (str3 == null) {
                str3 = this.defaultScreenName;
            }
            ShopDetailsLoadedEvent shopDetailsLoadedEvent = r2;
            ShopDetailsLoadedEvent shopDetailsLoadedEvent2 = new ShopDetailsLoadedEvent(true, (Restaurant) null, str2, str3, z11, false, (String) null, (ArrayList) null, 0, 0, str, (EventDataHelper) null, 3042, (DefaultConstructorMarker) null);
            talabatTracker2.track(shopDetailsLoadedEvent);
            return;
        }
        this.appTracker.onDarkstoresShopDetailsLoaded(this.context, this.restaurant, this.lastOpenedScreen, z11, str);
    }

    public void onVendorVisit(@NotNull VendorVisitDetails vendorVisitDetails) {
        Intrinsics.checkNotNullParameter(vendorVisitDetails, "vendorVisitDetails");
        this.talabatTracker.track(new VendorVisitEvent(vendorVisitDetails));
    }

    public void sendNavigateToVoucherProductDetails(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        this.talabatTracker.track(new VoucherProductDetailsOpenedEvent(TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams()), str, str2));
    }

    public void sendSwimLaneLoadedEvent(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(list, "voucherTitles");
        this.talabatTracker.track(new VoucherSwimLaneLoadedEvent(TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams()), str, list));
    }

    public void sendSwimLaneVoucherClickedEvent(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "voucherName");
        this.talabatTracker.track(new VoucherSwimLaneClickedEvent(TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams()), str, i11, str2));
    }

    public void trackPreCheckoutAlertVisibility(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        this.talabatTracker.track(new PreCheckoutAlertEvent(str, str2));
    }
}
