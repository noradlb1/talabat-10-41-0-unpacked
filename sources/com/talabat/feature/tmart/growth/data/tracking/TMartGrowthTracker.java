package com.talabat.feature.tmart.growth.data.tracking;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import com.talabat.feature.tmart.growth.domain.TMartGrowthSelectedPreference;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.gtm.ITalabatFirebase;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0011\"\u00020\nH\u0002¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010\u001e\u001a\u00020\u001c*\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010!J\u0018\u0010\u001e\u001a\u00020\u001c*\u0004\u0018\u00010\u001c2\b\b\u0002\u0010 \u001a\u00020\u001cH\u0002J\f\u0010\"\u001a\u00020\u001c*\u00020\u000eH\u0002J\f\u0010#\u001a\u00020\n*\u00020\u000eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/tracking/TMartGrowthTracker;", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "context", "Landroid/content/Context;", "talabatFirebase", "Ltracking/gtm/ITalabatFirebase;", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "(Landroid/content/Context;Ltracking/gtm/ITalabatFirebase;Lcom/integration/IntegrationGlobalDataModel$Companion;)V", "baseBundle", "Landroid/os/Bundle;", "claimClicked", "", "trackingInfo", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "combine", "bundles", "", "([Landroid/os/Bundle;)Landroid/os/Bundle;", "homeWidgetLoaded", "openTMartClicked", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "preferenceSelected", "selectedPreference", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthSelectedPreference;", "reminderWidgetLoaded", "title", "", "shopNowClicked", "orDefault", "", "default", "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "shopType", "toBundle", "Companion", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthTracker implements ITMartGrowthTracker {
    @NotNull
    @Deprecated
    public static final String CLICK_ORIGIN_BANNER = "banner";
    @NotNull
    @Deprecated
    public static final String CLICK_ORIGIN_HOME = "home";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String EVENT_ORIGIN_BANNER = "hero_banner_clicked";
    @NotNull
    @Deprecated
    public static final String GROWTH_WIDGET_TYPE = "tmart_growth_widget";
    @NotNull
    @Deprecated
    public static final String KEY_BANNER_ID = "bannerId";
    @NotNull
    @Deprecated
    public static final String KEY_BANNER_NAME = "bannerName";
    @NotNull
    @Deprecated
    public static final String KEY_CHAIN_ID = "chainId";
    @NotNull
    @Deprecated
    public static final String KEY_CHAIN_NAME = "chainName";
    @NotNull
    @Deprecated
    public static final String KEY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_ADDRESS = "locationAddress";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_AREA = "locationArea";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_CITY = "locationCity";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_COUNTRY = "locationCountry";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_LAT = "locationLat";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_LON = "locationLon";
    @NotNull
    @Deprecated
    public static final String KEY_SCREEN_NAME = "screenName";
    @NotNull
    @Deprecated
    public static final String KEY_SCREEN_TYPE = "screenType";
    @NotNull
    @Deprecated
    public static final String KEY_SELECTED_PREFERENCE = "userPreferences";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_CATEGORY_LIST = "shopCategoryList";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_CLICK_ORIGIN = "shopClickOrigin";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_DELIVERY_TIME = "shopDeliveryTime";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_ID = "shopId";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_STATUS = "shopStatus";
    @NotNull
    @Deprecated
    public static final String KEY_SHOP_TYPE = "shopType";
    @NotNull
    @Deprecated
    public static final String KEY_USER_ID = "userId";
    @NotNull
    @Deprecated
    public static final String KEY_WIDGET_NAME = "widgetName";
    @NotNull
    @Deprecated
    public static final String KEY_WIDGET_TYPE = "widgetType";
    @NotNull
    @Deprecated
    public static final String NOT_AVAILABLE = "N/A";
    @NotNull
    @Deprecated
    public static final String OPEN_TMART_CLICKED = "shop_clicked";
    @NotNull
    @Deprecated
    public static final String REMINDER_WIDGET_LOADED = "widget_shown";
    @NotNull
    @Deprecated
    public static final String SCREEN_NAME_HOME = "Home Screen";
    @NotNull
    @Deprecated
    public static final String SCREEN_NAME_REMINDER = "voucher_reminder";
    @NotNull
    @Deprecated
    public static final String UNCLAIMED_WIDGET_LOADED = "hero_banner_loaded";
    @NotNull
    @Deprecated
    public static final String UPDATE_PREFERENCE = "order_preference_updated";
    @NotNull
    @Deprecated
    public static final String WIDGET_CLAIMED = "hero_banner_clicked";
    @NotNull
    private final Bundle baseBundle;
    @NotNull
    private final Context context;
    @NotNull
    private final ITalabatFirebase talabatFirebase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/tracking/TMartGrowthTracker$Companion;", "", "()V", "CLICK_ORIGIN_BANNER", "", "CLICK_ORIGIN_HOME", "EVENT_ORIGIN_BANNER", "GROWTH_WIDGET_TYPE", "KEY_BANNER_ID", "KEY_BANNER_NAME", "KEY_CHAIN_ID", "KEY_CHAIN_NAME", "KEY_EVENT_ORIGIN", "KEY_LOCATION_ADDRESS", "KEY_LOCATION_AREA", "KEY_LOCATION_CITY", "KEY_LOCATION_COUNTRY", "KEY_LOCATION_LAT", "KEY_LOCATION_LON", "KEY_SCREEN_NAME", "KEY_SCREEN_TYPE", "KEY_SELECTED_PREFERENCE", "KEY_SHOP_CATEGORY_LIST", "KEY_SHOP_CLICK_ORIGIN", "KEY_SHOP_DELIVERY_TIME", "KEY_SHOP_ID", "KEY_SHOP_STATUS", "KEY_SHOP_TYPE", "KEY_USER_ID", "KEY_WIDGET_NAME", "KEY_WIDGET_TYPE", "NOT_AVAILABLE", "OPEN_TMART_CLICKED", "REMINDER_WIDGET_LOADED", "SCREEN_NAME_HOME", "SCREEN_NAME_REMINDER", "UNCLAIMED_WIDGET_LOADED", "UPDATE_PREFERENCE", "WIDGET_CLAIMED", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TMartGrowthTracker(@NotNull @ApplicationContext Context context2, @NotNull ITalabatFirebase iTalabatFirebase, @NotNull IntegrationGlobalDataModel.Companion companion) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFirebase, "talabatFirebase");
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        this.context = context2;
        this.talabatFirebase = iTalabatFirebase;
        this.baseBundle = BundleKt.bundleOf(TuplesKt.to("userId", b(this, companion.customerID(), (String) null, 1, (Object) null)), TuplesKt.to("locationCity", b(this, companion.getSelectedCityName(), (String) null, 1, (Object) null)), TuplesKt.to("locationArea", Integer.valueOf(companion.getSelectedAreaId())), TuplesKt.to("locationCountry", companion.selectedCountryIsoCode()), TuplesKt.to("locationLat", a(this, Double.valueOf(companion.selectedLocationLatitude()), (String) null, 1, (Object) null)), TuplesKt.to("locationLon", a(this, Double.valueOf(companion.selectedLocationLongitude()), (String) null, 1, (Object) null)), TuplesKt.to("locationAddress", b(this, companion.getCustomerAddressDescription(), (String) null, 1, (Object) null)));
    }

    public static /* synthetic */ String a(TMartGrowthTracker tMartGrowthTracker, Double d11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "N/A";
        }
        return tMartGrowthTracker.orDefault(d11, str);
    }

    public static /* synthetic */ String b(TMartGrowthTracker tMartGrowthTracker, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "N/A";
        }
        return tMartGrowthTracker.orDefault(str, str2);
    }

    private final Bundle combine(Bundle... bundleArr) {
        int i11 = 0;
        for (Bundle size : bundleArr) {
            i11 += size.size();
        }
        Bundle bundle = new Bundle(i11);
        for (Bundle putAll : bundleArr) {
            bundle.putAll(putAll);
        }
        return bundle;
    }

    private final String orDefault(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
            str = null;
        }
        return str == null ? str2 : str;
    }

    private final String shopType(TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        if (tMartGrowthTrackingInfo.isDarkstore()) {
            return "darkstores";
        }
        switch (tMartGrowthTrackingInfo.getVerticalType()) {
            case 0:
                return StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT;
            case 1:
                return "groceries";
            case 2:
                return StoreInfoTrackingProvider.SHOP_TYPE_PHARMACY;
            case 3:
                return StoreInfoTrackingProvider.SHOP_TYPE_FLOWERS;
            case 4:
                return StoreInfoTrackingProvider.SHOP_TYPE_ELECTRONICS;
            case 5:
                return StoreInfoTrackingProvider.SHOP_TYPE_PET_SHOP;
            case 6:
                return StoreInfoTrackingProvider.SHOP_TYPE_COSMETIC;
            default:
                return "N/A";
        }
    }

    private final Bundle toBundle(TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        return BundleKt.bundleOf(TuplesKt.to("chainId", tMartGrowthTrackingInfo.getBranchId()), TuplesKt.to("shopType", shopType(tMartGrowthTrackingInfo)), TuplesKt.to("shopId", tMartGrowthTrackingInfo.getVendorId()), TuplesKt.to("shopStatus", tMartGrowthTrackingInfo.getVendorStatusType()), TuplesKt.to("shopCategoryList", CollectionsKt___CollectionsKt.joinToString$default(tMartGrowthTrackingInfo.getCuisines(), IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)), TuplesKt.to("shopDeliveryTime", tMartGrowthTrackingInfo.getDeliveryTime()), TuplesKt.to("chainName", tMartGrowthTrackingInfo.getBranchName()));
    }

    public void claimClicked(@NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfo, NavigationMethodChannel.SEARCH_TRACKING);
        this.talabatFirebase.dispatchEvent(this.context, "hero_banner_clicked", combine(this.baseBundle, toBundle(tMartGrowthTrackingInfo), BundleKt.bundleOf(TuplesKt.to("bannerId", tMartGrowthTrackingInfo.getVoucherId()), TuplesKt.to("bannerName", tMartGrowthTrackingInfo.getTitle()), TuplesKt.to("screenType", TMartGrowthScreenType.HOME.getTrackingEventName()), TuplesKt.to("screenName", "Home Screen"))));
    }

    public void homeWidgetLoaded(@NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfo, NavigationMethodChannel.SEARCH_TRACKING);
        this.talabatFirebase.dispatchEvent(this.context, UNCLAIMED_WIDGET_LOADED, combine(this.baseBundle, toBundle(tMartGrowthTrackingInfo), BundleKt.bundleOf(TuplesKt.to("bannerId", tMartGrowthTrackingInfo.getVoucherId()), TuplesKt.to("bannerName", tMartGrowthTrackingInfo.getTitle()), TuplesKt.to("screenType", TMartGrowthScreenType.HOME.getTrackingEventName()), TuplesKt.to("screenName", "Home Screen"))));
    }

    public void openTMartClicked(@NotNull TMartGrowthScreenType tMartGrowthScreenType, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        Intrinsics.checkNotNullParameter(tMartGrowthScreenType, "screenType");
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfo, NavigationMethodChannel.SEARCH_TRACKING);
        this.talabatFirebase.dispatchEvent(this.context, "shop_clicked", combine(this.baseBundle, toBundle(tMartGrowthTrackingInfo), BundleKt.bundleOf(TuplesKt.to("screenType", tMartGrowthScreenType.getTrackingEventName()), TuplesKt.to("eventOrigin", tMartGrowthTrackingInfo.getTitle()), TuplesKt.to("shopClickOrigin", "banner"))));
    }

    public void preferenceSelected(@NotNull TMartGrowthSelectedPreference tMartGrowthSelectedPreference, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        Intrinsics.checkNotNullParameter(tMartGrowthSelectedPreference, "selectedPreference");
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfo, NavigationMethodChannel.SEARCH_TRACKING);
        this.talabatFirebase.dispatchEvent(this.context, UPDATE_PREFERENCE, combine(this.baseBundle, toBundle(tMartGrowthTrackingInfo), BundleKt.bundleOf(TuplesKt.to("screenType", TMartGrowthScreenType.HOME.getTrackingEventName()), TuplesKt.to("userPreferences", tMartGrowthSelectedPreference.getTrackingEventName()), TuplesKt.to("screenName", "Home Screen"), TuplesKt.to("eventOrigin", "hero_banner_clicked"))));
    }

    public void reminderWidgetLoaded(@NotNull String str, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfo, NavigationMethodChannel.SEARCH_TRACKING);
        this.talabatFirebase.dispatchEvent(this.context, "widget_shown", combine(this.baseBundle, toBundle(tMartGrowthTrackingInfo), BundleKt.bundleOf(TuplesKt.to("screenName", SCREEN_NAME_REMINDER), TuplesKt.to("screenType", TMartGrowthScreenType.ORDER_CONFIRMATION.getTrackingEventName()), TuplesKt.to("widgetType", "tmart_growth_widget"), TuplesKt.to("widgetName", str))));
    }

    public void shopNowClicked(@NotNull TMartGrowthScreenType tMartGrowthScreenType, @NotNull TMartGrowthTrackingInfo tMartGrowthTrackingInfo) {
        Intrinsics.checkNotNullParameter(tMartGrowthScreenType, "screenType");
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfo, NavigationMethodChannel.SEARCH_TRACKING);
        this.talabatFirebase.dispatchEvent(this.context, "shop_clicked", combine(this.baseBundle, toBundle(tMartGrowthTrackingInfo), BundleKt.bundleOf(TuplesKt.to("screenType", tMartGrowthScreenType.getTrackingEventName()), TuplesKt.to("eventOrigin", tMartGrowthTrackingInfo.getTitle()), TuplesKt.to("shopClickOrigin", "home"))));
    }

    private final String orDefault(Double d11, String str) {
        return orDefault(d11 != null ? d11.toString() : null, str);
    }
}
