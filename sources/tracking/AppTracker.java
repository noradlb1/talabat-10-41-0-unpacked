package tracking;

import JsonModels.PolygonEvents;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.FilterEngine;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.RegistrationStatus;
import com.talabat.observability.common.UserAction;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import datamodels.CartMenuItem;
import datamodels.Country;
import datamodels.CustomerInfo;
import datamodels.MenuSection;
import datamodels.OffersDisplayModel;
import datamodels.QuickRestaurant;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;
import tracking.deeplink.DeepLinkParser;
import tracking.deeplink.DeepLinkResult;
import tracking.gtm.GTMLoyaltyEXTKt;
import tracking.gtm.ITalabatGTM;
import tracking.gtm.TalabatGTM;
import tracking.models.ProductTracking;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;
import tracking.perseus.TalabatPerseus;

@Deprecated
public class AppTracker implements IAppTracker {
    public static String AdvertingId = "";
    public static final String LOGIN_TYPE_EMAIL_STRING = "email";
    public static final int LOGIN_TYPE_FACEBOOK = 100;
    public static final int LOGIN_TYPE_GOOGLE = 300;
    public static final int LOGIN_TYPE_MOBILE = 500;
    public static final String LOGIN_TYPE_MOBILE_STRING = "mobile_number";
    public static final int LOGIN_TYPE_NORMAL = 200;
    public static final String LOGIN_TYPE_NORMAL_STRING = "normal";
    public static final int LOGIN_TYPE_WALLET = 400;
    public static String NotAvail = "N/A";
    public static double latitude;
    public static double longitude;
    public static Purchase purchase;
    private ITalabatGTM talabatGTM;

    public AppTracker(ITalabatGTM iTalabatGTM) {
        this.talabatGTM = iTalabatGTM;
    }

    public static void OngGeoLocationClickedFromLanding(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        TalabatGTM.Companion.geoLocationClickedFromLanding(context, str, str2, str3, str4, str5, str6);
    }

    public static void appLaunch(Context context, String str, String str2, int i11, String str3, boolean z11, String str4) {
        GlobalDataModel.setDeepLinksQuery(str2);
        TalabatAdjust.appLanuch(context);
        TalabatGTM.Companion.launch(context, str, str2, i11, str3, z11, str4);
    }

    public static void backToCheckout(Context context) {
        TalabatGTM.Companion.backToCheckout(context);
    }

    public static void connectionLostClosed(Context context, String str) {
        TalabatGTM.Companion.connectionLostClosed(context, str);
    }

    public static void connectionLostShown(Context context, String str, String str2) {
        TalabatGTM.Companion.connectionLostShown(context, str, str2);
    }

    public static void geolocationDialogueAccepted(Context context, String str, String str2, String str3, String str4, String str5) {
        TalabatGTM.Companion.geolocationDialogueAccepted(context, str, str2, str3, str4, str5);
    }

    public static String getPaymentType(int i11) {
        return i11 == 4 ? "card_on_delivery" : i11 == 0 ? "cash" : i11 == 2 ? WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD : i11 == 1 ? "debit_card" : i11 == 3 ? "talabat_credit" : i11 == 50 ? "visa_checkout" : i11 == 11 ? "BNPL" : "";
    }

    public static Purchase getPurchase() {
        return purchase;
    }

    public static int getRestaurantId(Restaurant restaurant) {
        return restaurant.getId();
    }

    public static String getRestaurantName(Restaurant restaurant) {
        return restaurant.getName();
    }

    public static void gpsStatus(Context context, boolean z11, boolean z12, String str) {
        TalabatGTM.Companion.onGpsPopupStatus(context, z11, z12, str);
    }

    public static void groceryCollectionLoaded(Context context) {
        TalabatAppBoy.groceryCollectionLoaded(context);
    }

    public static void homePagerBannerClicked(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        TalabatGTM.Companion.homeBannerClicked(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
    }

    public static void homePagerBannerImpression(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        TalabatGTM.Companion.homeBannerImpression(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
    }

    public static void homeScreenLoaded(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        TalabatGTM.Companion.homeScreenLoaded(context, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public static void mobileVerificationFailed(Context context, String str) {
        TalabatGTM.Companion.onMobileNumberVerificationFailed(context, str);
    }

    public static void observeAppLaunchEvent(String str, boolean z11, String str2) {
        boolean z12;
        DeepLinkResult deepLinkResult;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (str == null || str.isEmpty()) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            deepLinkResult = DeepLinkParser.parse(str);
        } else {
            deepLinkResult = new DeepLinkResult();
        }
        HashMap hashMap = new HashMap();
        if (z12) {
            str3 = "campaign";
        } else {
            str3 = "organic";
        }
        hashMap.put("appLaunchType", str3);
        if (deepLinkResult.source.isEmpty()) {
            str4 = NotAvail;
        } else {
            str4 = deepLinkResult.source;
        }
        hashMap.put("source", str4);
        if (deepLinkResult.medium.isEmpty()) {
            str5 = NotAvail;
        } else {
            str5 = deepLinkResult.medium;
        }
        hashMap.put("medium", str5);
        if (!z12) {
            str = NotAvail;
        }
        hashMap.put("deeplink", str);
        String str8 = "false";
        if (GlobalDataModel.SelectedCountryId > 0) {
            str6 = str8;
        } else {
            str6 = "true";
        }
        hashMap.put("isFirstTimeUser", str6);
        if (GlobalDataModel.ADJUST_DEEPLINK.DIFFERED_DEEPLINK == null) {
            str7 = str8;
        } else {
            str7 = "true";
        }
        hashMap.put("isAdjustCampaign", str7);
        hashMap.put("isFromPush", "");
        hashMap.put(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY, FunWithFlags.FLUTTER_MIGRATION_VERIFY_VALUE);
        if (z11) {
            str8 = "true";
        }
        hashMap.put("isFWFSDKinFlutter", str8);
        ObservabilityManager.trackEvent("screen", str2, UserAction.APP_OPEN, (Map<String, String>) hashMap);
    }

    public static void onAccountUpdated(Context context, CustomerInfo customerInfo) {
        TalabatAppBoy.sendCustomerInfo(context);
    }

    public static void onActionSheetAddressSelected(Context context, Address address) {
        TalabatGTM.Companion.onActionSheetAddressSelected(context, address);
    }

    public static void onActionSheetDifferentLocationClicked(Context context) {
        TalabatGTM.Companion.onActionSheetDifferentLocationClicked(context);
    }

    public static void onActionSheetShown(Context context, int i11) {
        TalabatGTM.Companion.onActionSheetShown(context, i11);
    }

    public static void onAddMoreItemClicked(Context context, int i11) {
        TalabatGTM.Companion.addMoreItemsClicked(context, i11);
    }

    public static void onAddressErrorShown(Context context, AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatGTM.Companion.addressErrorShown(context, addressAnalyticsTracker);
    }

    public static void onAddressModificationShown(Context context) {
        TalabatGTM.Companion.addressModificationShown(context);
    }

    public static void onAddressSubmitted(Context context, String str, String str2, AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatAppBoy.areaSelected(context, str, str2);
        TalabatGTM.Companion.addressSubmitted(context, addressAnalyticsTracker);
    }

    public static void onAlertCloseClicked(@NotNull Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onAlertCloseClicked(context, str, str2, str3);
    }

    public static void onAlertReadMoreClicked(@NotNull Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onAlertReadmoreClicked(context, str, str2, str3);
    }

    public static void onAlertShown(@NotNull Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onAlertShown(context, str, str2, str3);
    }

    public static void onAppInstalled(Context context, AdjustAttribution adjustAttribution) {
        String str;
        String str2;
        String str3;
        String str4;
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        String str5 = adjustAttribution.adid;
        if (str5 != null) {
            str = str5;
        } else {
            str = "N/A";
        }
        String str6 = adjustAttribution.network;
        if (str6 != null) {
            str2 = str6;
        } else {
            str2 = "N/A";
        }
        String str7 = adjustAttribution.adgroup;
        if (str7 != null) {
            str3 = str7;
        } else {
            str3 = "N/A";
        }
        String str8 = adjustAttribution.campaign;
        if (str8 != null) {
            str4 = str8;
        } else {
            str4 = "N/A";
        }
        String str9 = adjustAttribution.creative;
        if (str9 == null) {
            str9 = "N/A";
        }
        companion.app_installed(context, str, str2, str3, str4, str9);
    }

    public static void onAreaModificationShown(Context context) {
        TalabatGTM.Companion.areaModificationShown(context);
    }

    public static void onAreaSelected(Context context, String str, String str2) {
        TalabatGTM.Companion.addressSelected(context, str2);
    }

    public static void onAttributionChanged(Context context) {
        TalabatGTM.Companion.onAttributionChanged(context);
    }

    public static void onBannerEnterButtonClicked(Context context) {
        TalabatGTM.Companion.bannerEnterButtonClicked(context);
    }

    public static void onBannerStoreShown(Context context, String str, String str2, String str3, String str4, String str5) {
        TalabatGTM.Companion.onBannerStoreShown(context, str, str2, str3, str4, str5);
    }

    public static void onBhMcdMapResultReturned(Context context, boolean z11, boolean z12) {
        TalabatGTM.Companion.onMcdMapResultReturned(context, z11, z12);
    }

    public static void onBinDiscountApplied(Context context, String str, String str2) {
        TalabatGTM.Companion.onBinDiscountApplied(context, str, str2);
    }

    public static void onBinDiscountExcluded(Context context, float f11) {
        TalabatGTM.Companion.onBinDiscountExcluded(context, f11);
    }

    public static void onBinNotificationShown(Context context, String str) {
        TalabatGTM.Companion.onBinNotificationShown(context, str);
    }

    public static void onBrandPageLoaded(Context context, String str, int i11) {
        TalabatGTM.Companion.brandPageLoaded(context, str, i11);
    }

    public static void onBusyBottomSheetClosed(Context context, Restaurant restaurant, String str, String str2) {
        TalabatGTM.Companion.onBusyBottomSheetClosed(context, restaurant, str, str2);
    }

    public static void onBusyBottomSheetOpened(Context context, Restaurant restaurant, String str, String str2) {
        TalabatGTM.Companion.onBusyBottomSheetOpened(context, restaurant, str, str2);
    }

    public static void onBusyBottomSheetRecommendedRestaurantClicked(Context context, Restaurant restaurant, String str, String str2) {
        TalabatGTM.Companion.onBusyBottomSheetRecommendedRestaurantClicked(context, restaurant, str, str2);
    }

    public static void onBusyBottomSheetViewAllClicked(Context context, Restaurant restaurant, String str, String str2) {
        TalabatGTM.Companion.onBusyBottomSheetViewAllClicked(context, restaurant, str, str2);
    }

    public static void onCartClicked(Context context, String str) {
        TalabatGTM.Companion.cartClicked(context, str);
    }

    public static void onCartPageLoaded(Context context, Restaurant restaurant) {
        TalabatGTM.Companion.cartLoaded(context, restaurant);
    }

    public static void onCartQuantityIncreased(Context context, Restaurant restaurant, CartMenuItem cartMenuItem, int i11, String str, String str2, String str3, int i12, int i13, String str4, String str5) {
        TalabatGTM.Companion.pushAddToCart(context, cartMenuItem, i11, str, restaurant, str2, str3, i12, i13, str4, str5);
    }

    public static void onCategoryDetailsLoaded(Context context, Restaurant restaurant, MenuSection menuSection, String str, String str2) {
        TalabatGTM.Companion.onCategoryDetailsLoaded(context, restaurant, menuSection, str, str2);
    }

    public static void onCategoryDetailsUpdated(Context context, Restaurant restaurant, @NotNull String str, MenuSection menuSection) {
        TalabatGTM.Companion.onCategoryDetailsUpdated(context, restaurant, str, menuSection);
    }

    public static void onCategorySelected(Context context, String str) {
        TalabatGTM.Companion.onCategorySelected(context, str);
    }

    public static void onCategorySelectorClosed(Context context) {
        TalabatGTM.Companion.onCategorySelectorClosed(context);
    }

    public static void onCategorySelectorOpened(Context context) {
        TalabatGTM.Companion.onCategorySelectorOpened(context);
    }

    public static void onChangeArea(Context context) {
        TalabatGTM.Companion.onChangeAreaClicked(context);
    }

    public static void onChangeCountryConfirmed(Context context) {
        TalabatGTM.Companion.onChangeCountryConfirmed(context);
    }

    public static void onChangeCountrySelected(@NotNull Context context, @NotNull AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatGTM.Companion.onChangeCountrySelected(context, addressAnalyticsTracker);
    }

    public static void onChangeCountryShown(Context context) {
        TalabatGTM.Companion.onChangeCountryShown(context);
    }

    public static void onChannelClicked(Context context, String str) {
        TalabatGTM.Companion.channelClicked(context, str);
    }

    public static void onCheckoutClicked(Context context, Cart cart, int i11, int i12, String str, String str2) {
        TalabatGTM.Companion.checkout_clicked(context, i11, i12, cart.getRestaurant(), str, str2);
        TalabatAdjust.proceedToCheckout(getRestaurantId(cart.getRestaurant()), cart.getRestaurant(), getRestaurantName(cart.getRestaurant()));
    }

    public static void onClosedAfterMapError(Context context, String str) {
        TalabatGTM.Companion.closedAfterMapError(context, str);
    }

    public static void onComplianceContinueToCheckout(Context context) {
        TalabatGTM.Companion.onComplianceContinueToCheckout(context);
    }

    public static void onComplianceUserBlocked(Context context, String str) {
        TalabatGTM.Companion.onComplianceUserBlocked(context, str);
    }

    public static void onContinuedAfterMapError(Context context, double d11, double d12, String str) {
        TalabatGTM.Companion.continuedAfterMapError(context, d11, d12, str);
    }

    public static void onCountrySelected(Context context) {
        TalabatAppBoy.countrySelected(context);
        TalabatGTM.Companion.changeCountry(context);
    }

    public static void onCreditRedeemCompleted(Context context, String str, String str2, float f11) {
        TalabatGTM.Companion.pushSuccessfulCreditRedeemCompleted(context, str, str2, Float.valueOf(f11));
    }

    public static void onCreditRedeemFailed(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.pushCreditRedeemFailed(context, str, str2, str3);
    }

    public static void onCuisineButtonClicked(Context context, boolean z11) {
        TalabatGTM.Companion.onCuisineButtonClicked(context, z11);
    }

    public static void onCuisineChanged(Context context, String str) {
        TalabatGTM.Companion.cuisineSelectedUpdated(context, str);
    }

    public static void onDarkStoresShown(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.darkStoresShown(context, str, restaurant);
    }

    public static void onDarkstoresAgeVerificationShown(Context context, @Nullable String str, @Nullable String str2) {
        TalabatGTM.Companion.onDarkstoresAgeVerificationShown(context, str, str2);
    }

    public static void onDarkstoresAllButtonClicked(Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        TalabatGTM.Companion.onDarkstoresAllButtonClicked(context, str, str2, str3, str4, str5);
    }

    public static void onDarkstoresBannerShown(@NotNull Context context, String str, String str2, String str3, String str4, String str5, int i11) {
        TalabatGTM.Companion.onDarkstoresBannerShown(context, str, str2, str3, str4, str5, i11);
    }

    public static void onDarkstoresCategoryClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable List<String> list, int i11, @Nullable String str3, @Nullable String str4) {
        TalabatGTM.Companion.onDarkstoresCategoryClicked(context, str3, str, str2, list, i11, str4);
    }

    public static void onDarkstoresCategoryLoaded(@NotNull Context context, @Nullable String str, String str2, @Nullable String str3, List<String> list, List<ProductTracking> list2, String str4, Boolean bool, @Nullable String str5) {
        TalabatGTM.Companion.onDarkstoresCategoryLoaded(context, str, str2, str3, list, list2, str4, bool.booleanValue(), str5);
    }

    public static void onDarkstoresCategoryUpdated(@NotNull Context context, @Nullable String str, String str2, @Nullable String str3, String str4, List<ProductTracking> list) {
        TalabatGTM.Companion.onDarkstoresCategoryUpdated(context, str, str2, str3, str4, list);
    }

    public static void onDarkstoresComponentClicked(Context context, @Nullable String str, String str2, String str3) {
        TalabatGTM.Companion.onDarkstoresComponentClicked(context, str, str2, str3);
    }

    public static void onDarkstoresLoaded(@NotNull Context context, String str, String str2) {
        TalabatGTM.Companion.onDarkstoresLoaded(context, str, str2);
        if (Cart.getInstance().getRestaurant() != null) {
            TalabatAdjust.viewRestaurant(Cart.getInstance().getRestaurant());
        }
    }

    public static void onDarkstoresLookingGlassClicked(Context context, @Nullable String str) {
        TalabatGTM.Companion.onDarkstoresLookingGlassClicked(context, str);
    }

    public static void onDarkstoresLookingGlassShown(Context context, @Nullable String str) {
        TalabatGTM.Companion.onDarkstoresLookingGlassShown(context, str);
    }

    public static void onDarkstoresProductOpened(Context context, @NotNull String str, @NotNull String str2, @Nullable String str3, float f11, boolean z11, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        TalabatGTM.Companion.onDarkstoresProductOpened(context, str, str2, str3, f11, z11, str4, str5, str6);
    }

    public static void onDarkstoresSearchBarClicked(Context context, @Nullable String str, @Nullable String str2) {
        TalabatGTM.Companion.onDarkstoresSearchBarClicked(context, str, str2);
    }

    public static void onDeliverHereClicked(Context context, LatLng latLng) {
        TalabatGTM.Companion.onDeliverHereClicked(context, latLng);
    }

    public static void onDuplicateOrderPopupClosed(Context context) {
        TalabatGTM.Companion.onDuplicateOrderPopupClosed(context);
    }

    public static void onDuplicateOrderPopupConfirmClicked(Context context, String str) {
        TalabatGTM.Companion.onDuplicateOrderPopupConfirmClicked(context, str);
    }

    public static void onDuplicateOrderPopupShown(Context context) {
        TalabatGTM.Companion.onDuplicateOrderPopupShown(context);
    }

    public static void onExperimentRunForApptimize(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onExperimentRunForApptimize(context, str, str2, str3);
    }

    public static void onExperssCheckoutClicked(Context context, int i11, int i12, Restaurant restaurant) {
        TalabatGTM.Companion.experssCheckoutClicked(context, i11, i12, restaurant);
    }

    public static void onFilterApplyClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.onFilterScreenApplySelection(context, str, str2);
    }

    public static void onFilterButtonClicked(Context context) {
        TalabatGTM.Companion.onFilterButtonClicked(context);
    }

    public static void onFilterClearClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.onFilterScreenClearSelection(context, str, str2);
    }

    public static void onFilterOptionsClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.onFilterOptionSelected(context, str, str2);
    }

    public static void onFilterViewLoaded(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onFilterViewLoaded(context, str, str2, str3);
    }

    @Deprecated
    public static void onGemFloatingButtonShown(Context context) {
        TalabatGTM.Companion.gemFloatingButtonShown(context);
    }

    public static void onGeoLocationButtonClicked(Context context) {
        TalabatGTM.Companion.geoLocationClicked(context);
    }

    public static void onGeoLocationClicked(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onGeoLocationClicked(context, str, str2, str3);
    }

    public static void onGeoLocationDialogAccepted(@NotNull Context context, @NotNull AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatGTM.Companion.onGeolocationDialogueAccepted(context, addressAnalyticsTracker);
    }

    public static void onGeoLocationRecieved(Context context, int i11, boolean z11) {
        TalabatGTM.Companion.geoLocationRecieved(context, i11, z11);
    }

    public static void onGeoLocationRecievedHomeMap(Context context, LatLng latLng) {
        TalabatGTM.Companion.onGeoLocationRecievedHomeMap(context, latLng);
    }

    public static void onGeolocationRequested(Context context, AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatGTM.Companion.onGeolocationRequested(context, addressAnalyticsTracker);
    }

    public static void onGetCodeClicked(Context context) {
        TalabatGTM.Companion.getCodeClicked(context);
    }

    public static void onGoGreenSelected(Context context, boolean z11) {
        TalabatGTM.Companion.onGoGreenSelected(context, z11);
    }

    public static void onGpsInfoReceived(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        TalabatGTM.Companion.onGpsInfoReceived(context, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public static void onInformapAreaMismatchShown(Context context) {
        TalabatGTM.Companion.onInformapAreaMismatchShown(context);
    }

    public static void onIsRealAcquisition(Context context, boolean z11) {
        TalabatAppBoy.isRealAcquisition(context, z11);
    }

    public static void onItemAddedToCart(Context context, Restaurant restaurant, CartMenuItem cartMenuItem, int i11, String str, String str2, String str3, int i12, int i13, String str4, String str5) {
        TalabatAppBoy.add_toCart(context);
        TalabatGTM.Companion.pushAddToCart(context, cartMenuItem, i11, str, restaurant, str2, str3, i12, i13, str4, str5);
        TalabatAdjust.addToCart(restaurant, cartMenuItem);
    }

    public static void onItemQuantityIncreased(Context context, CartMenuItem cartMenuItem) {
        TalabatGTM.Companion.increaseItemQuantity(context, cartMenuItem);
    }

    public static void onItemRemovedFromCart(Context context, Restaurant restaurant, CartMenuItem cartMenuItem, String str, String str2, String str3) {
        TalabatGTM.Companion.removeFromCart(context, cartMenuItem, getRestaurantId(restaurant), getRestaurantName(restaurant), restaurant, str, str2, str3);
    }

    @Deprecated
    public static void onJokerCheckoutLoaded(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.onJokerCheckoutLoaded(context, str, restaurant);
    }

    @Deprecated
    public static void onJokerLightboxShown(Context context) {
        TalabatGTM.Companion.onJokerLightboxShown(context);
    }

    @Deprecated
    public static void onJokerModalShown(Context context) {
        TalabatGTM.Companion.onJokerModalShown(context);
    }

    @Deprecated
    public static void onJokerOrderComplete(Context context, String str, Restaurant restaurant, String str2, String str3) {
        TalabatGTM.Companion.onJokerOrderComplete(context, str, restaurant, str2, str3);
    }

    public static void onJokerResumeAccepted(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.onJokerResumeAccepted(context, str, restaurant);
    }

    public static void onJokerResumeRejected(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.onJokerResumeRejected(context, str, restaurant);
    }

    public static void onJokerResumeShown(Context context, Restaurant restaurant, String str) {
        TalabatGTM.Companion.onJokerResumeShown(context, restaurant, str);
    }

    public static void onJokerShopAbandonCompleted(Context context, String str, Restaurant restaurant, String str2) {
        TalabatGTM.Companion.onJokerShopAbandonCompleted(context, str, restaurant, str2);
    }

    public static void onJokerShopAbandonStarted(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.onJokerShopAbandonStarted(context, str, restaurant);
    }

    @Deprecated
    public static void onJokerShopLoaded(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.onJokerShopLoaded(context, str, restaurant);
    }

    @Deprecated
    public static void onJokerTierReached(Context context, String str, String str2, String str3, Restaurant restaurant) {
        TalabatGTM.Companion.onJokerTierReached(context, str, str2, str3, restaurant);
    }

    @Deprecated
    public static void onJokerTimeOut(Context context, String str) {
        TalabatGTM.Companion.onJokerTimeOut(context, str);
    }

    public static void onKNETFailureLghtboxClosed(Context context) {
        TalabatGTM.Companion.onKNETFailureLghtboxClosed(context);
    }

    public static void onKNETFailureLghtboxShown(Context context) {
        TalabatGTM.Companion.onKNETFailureLghtboxShown(context);
    }

    public static void onLanguageChanged(Context context) {
        TalabatGTM.Companion.changeLanguage(context);
    }

    public static void onLocationAttempted(@NotNull Context context, @NotNull AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatGTM.Companion.onLocationAttempted(context, addressAnalyticsTracker);
    }

    public static void onLocationMismatch(Context context, String str) {
        TalabatGTM.Companion.locationMismatch(context, str);
    }

    public static void onLogin(Context context, CustomerInfo customerInfo, int i11, boolean z11, String str, String str2) {
        if (z11) {
            TalabatAppBoy.sendCustomerInfo(context);
            TalabatGTM.Companion.login(context, "succeeded", customerInfo.encgid, i11, "", str2);
            if (i11 == 100 || i11 == 300) {
                TalabatAdjust.socialLogin(i11);
            } else {
                TalabatAdjust.login();
            }
        } else {
            TalabatGTM.Companion.login(context, TalabatGTM.FAILED, "", i11, str, str2);
        }
    }

    public static void onLoginEmailUnregistered(Context context, String str) {
        TalabatGTM.Companion.onLoginEmailUnregistered(context, str);
    }

    public static void onLogout(Context context) {
        TalabatGTM.Companion.logout(context);
    }

    public static void onMapBlockUpdated(Context context) {
        TalabatGTM.Companion.onMapBlockUpdated(context);
    }

    public static void onMapClosed(Context context, String str) {
        TalabatGTM.Companion.mapClosed(context, str);
    }

    public static void onMapConfirmed(Context context, String str) {
        TalabatGTM.Companion.mapConfirmed(context, str);
    }

    public static void onMapLoaded(@NotNull Context context, @NotNull AddressAnalyticsTracker addressAnalyticsTracker) {
        TalabatGTM.Companion.onMapLoaded(context, addressAnalyticsTracker);
    }

    public static void onMapLocateMeClicked(Context context, String str) {
        TalabatGTM.Companion.onMapLocateMeClicked(context, str);
    }

    public static void onMapSearchComplete(Context context, String str) {
        TalabatGTM.Companion.onMapSearchComplete(context, str);
    }

    public static void onMapSearchStarted(Context context) {
        TalabatGTM.Companion.onMapSearchStarted(context);
    }

    public static void onMapShown(Context context, String str, LatLng latLng, String str2) {
        TalabatGTM.Companion.mapShown(context, str, latLng, str2);
    }

    public static void onMapSkipped(Context context) {
        TalabatGTM.Companion.mapSkipped(context);
    }

    public static void onMapStreetUpdated(Context context) {
        TalabatGTM.Companion.onMapStreetUpdated(context);
    }

    public static void onMapUserGuideDismissed(Context context) {
        TalabatGTM.Companion.onMapUserGuideDismissed(context);
    }

    public static void onMapViewChanged(Context context, String str, String str2) {
        TalabatGTM.Companion.onMapViewChanged(context, str, str2);
    }

    public static void onMcdAddressPopupShown(Context context) {
        TalabatGTM.Companion.onMcdAddressPopupShown(context);
    }

    public static void onMcdBlockSelectionShown(Context context) {
        TalabatGTM.Companion.onMcdBlockSelectionShown(context);
    }

    public static void onMcdCloseClicked(Context context) {
        TalabatGTM.Companion.onMcdCloseClicked(context);
    }

    public static void onMcdEditLocationClicked(Context context) {
        TalabatGTM.Companion.onMcdEditLocationClicked(context);
    }

    public static void onMcdMapClosed(Context context) {
        TalabatGTM.Companion.onMcdMapClosed(context);
    }

    public static void onMcdMapConfirmClicked(Context context) {
        TalabatGTM.Companion.onMcdMapConfirmClicked(context);
    }

    public static void onMcdMapResultReturned(Context context, boolean z11) {
        TalabatGTM.Companion.onMcdMapResultReturned(context, z11);
    }

    public static void onMcdMapShown(Context context) {
        TalabatGTM.Companion.onMcdMapShown(context);
    }

    public static void onMcdNewAddressClicked(Context context) {
        TalabatGTM.Companion.onMcdNewAddressClicked(context);
    }

    public static void onMcdProceedClicked(Context context, boolean z11, boolean z12) {
        TalabatGTM.Companion.onMcdProceedClicked(context, z11, z12);
    }

    public static void onMcdStreetProceedClicked(Context context, boolean z11, boolean z12) {
        TalabatGTM.Companion.onMcdProceedStreetClicked(context, z11, z12);
    }

    public static void onMcdUpdateaAddressClicked(Context context) {
        TalabatGTM.Companion.onMcdUpdateaAddressClicked(context);
    }

    public static void onMobileNumberVerificationValidated(Context context, String str) {
        TalabatGTM.Companion.onMobileNumberVerificationValidated(context, str);
    }

    public static void onNewMenuOpened(Context context, boolean z11) {
        TalabatGTM.Companion.newMenuShown(context, z11);
    }

    public static void onNewProductChoiceOpened(Context context, CartMenuItem cartMenuItem, Restaurant restaurant, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.newMenuItemDetailsScreenOpened(context, cartMenuItem, restaurant, str, str2, str3, str4);
    }

    public static void onNumberUpdationFailed(Context context) {
        TalabatGTM.Companion.numberUpdationFailed(context);
    }

    public static void onNumberUpdationSuccessful(Context context) {
        TalabatGTM.Companion.numberUpdationSuccessful(context);
    }

    public static void onOfferlistListLoaded(Context context, ArrayList<OffersDisplayModel> arrayList) {
        TalabatAdjust.restaurantOfferScreenOpened(arrayList);
    }

    public static void onOrderRated(Context context, RateOrderReq rateOrderReq, String str, int i11, int i12, boolean z11) {
        TalabatAppBoy.order_rated(context, rateOrderReq, str);
        TalabatAdjust.rateOrder(rateOrderReq, i11, i12, z11);
        TalabatGTM.Companion.rateorderSubmitted(context, rateOrderReq.ordId);
    }

    public static void onOrderRatingClicked(Context context, String str) {
        TalabatGTM.Companion.rateorderClicked(context, str);
    }

    public static void onOtherLocationClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.onOtherLocationClicked(context, str, str2);
    }

    public static void onOtherVerificationOptionSelected(Context context, String str) {
        TalabatGTM.Companion.otherVerificationOptionSelected(context, str);
    }

    public static void onPArallelBinMoreClicked(Context context, String str) {
        TalabatGTM.Companion.onPArallelBinMoreClicked(context, str);
    }

    public static void onPageOpen(Context context, String str, @Nullable Country country, @Nullable CustomerInfo customerInfo) {
        TalabatGTM.Companion.pushOpenScreenEvent(context, str, country, customerInfo);
        Adjust.onResume();
    }

    public static void onPasswordResetSelection(@NotNull Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onPasswordResetSelection(context, str2, str, str3);
    }

    public static void onPasswordResetSubmit(@NotNull Context context, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.onPasswordResetSubmit(context, str2, str, str3, str4);
    }

    public static void onPaymentMethodSelected(Context context, int i11, int i12, String str, int i13, Restaurant restaurant) {
        TalabatGTM.Companion.paymentMethodChoosed(context, i11, getPaymentType(i12), str, i13, restaurant);
    }

    public static void onProductChoiceOpened(Context context, CartMenuItem cartMenuItem, Restaurant restaurant) {
        TalabatGTM.Companion.choiceScreenOpened(context, cartMenuItem, restaurant);
    }

    public static void onProductClicked(Context context, CartMenuItem cartMenuItem, String str) {
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        companion.itemClick(context, cartMenuItem, "" + cartMenuItem.menuSectionId, str);
    }

    public static void onProductImageClicked(Context context, CartMenuItem cartMenuItem) {
        TalabatGTM.Companion.onProductImageClicked(context, cartMenuItem);
    }

    public static void onProductSearchClicked(Context context) {
        TalabatGTM.Companion.productSearchClicked(context);
    }

    public static void onProductView(Context context, CartMenuItem cartMenuItem, String str) {
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        companion.itemDetailsView(context, cartMenuItem, "" + cartMenuItem.menuSectionId, str);
    }

    public static void onPurchase(Context context, Purchase purchase2, CustomerInfo customerInfo, String str, String str2, boolean z11, int i11) {
        String str3;
        String str4;
        CustomerInfo customerInfo2 = customerInfo;
        if (!purchase2.isPurchaseEventsEnabled()) {
            TalabatAdjust.orderCompleted(purchase2);
            if (purchase2.isFirstOrderFromApp()) {
                TalabatAdjust.firstorderInApp(purchase2);
            }
            if (purchase2.isFirstOrder()) {
                TalabatAdjust.firstOrder(purchase2);
            }
            if (purchase2.isVoucherApplied()) {
                TalabatAdjust.orderWithVoucher(purchase2);
            }
            if (purchase2.getCart() == null || customerInfo2 == null) {
                str4 = "";
                str3 = str4;
            } else {
                String str5 = customerInfo2.firstName;
                if (str5 == null) {
                    str5 = "";
                }
                String str6 = customerInfo2.lastName;
                if (str6 != null) {
                    str3 = str6;
                    str4 = str5;
                } else {
                    str4 = str5;
                    str3 = "";
                }
            }
            TalabatAppBoy.completeTransaction(context, getRestaurantId(purchase2.getRestaurant()), getRestaurantName(purchase2.getRestaurant()), purchase2.getAddress(), str2, purchase2.getRestaurant().getType(), purchase2.getPaymentMethod(), purchase2.getRestaurant().getShopType(), purchase2.getRestaurant().isDarkStore);
            TalabatAppBoy.purchase(context, purchase2, str4, str3, str, "", purchase2.getCart().size());
            TalabatGTM.Companion.pushOrderComplete(context, purchase2, getRestaurantName(purchase2.getRestaurant()), purchase2.getRestaurant(), z11, i11, Double.valueOf(purchase2.getRiderTip()));
        }
    }

    public static void onPurchaseInitialised(Context context, int i11, int i12, Restaurant restaurant, boolean z11, String str, double d11) {
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        companion.purchaseInitialised(context, "" + i11, getPaymentType(i12), restaurant, z11, str, Double.valueOf(d11));
    }

    public static void onRedeemPageOpen(Context context, String str, CustomerInfo customerInfo, String str2) {
        GTMLoyaltyEXTKt.redeemOpenScreenEvent(TalabatGTM.Companion, context, str, customerInfo, str2);
        Adjust.onResume();
    }

    public static void onRegistrationFailed(Context context, String str, String str2, boolean z11) {
        TalabatGTM.Companion.register(context, "normal", TalabatGTM.FAILED, str, str2, z11);
    }

    public static void onRegistrationStarted(Context context, String str, boolean z11) {
        TalabatGTM.Companion.register(context, "normal", "started", str, "", z11);
        TalabatAppBoy.registrationStarted(context, str);
    }

    public static void onRegistrationSuccess(Context context, CustomerInfo customerInfo, String str, boolean z11, boolean z12) {
        String str2;
        RegistrationStatus registrationStatus = RegistrationStatus.Success;
        ObservabilityManager.trackRegistration(registrationStatus, "start tracking", Collections.singletonMap("loginType", str));
        if (str.equals("normal")) {
            str2 = "email";
        } else {
            str2 = str;
        }
        TalabatAppBoy.registrationFinishedTalabat(context, customerInfo, str2);
        if (!z11) {
            TalabatAppBoy.sendCustomerInfo(context);
            ObservabilityManager.trackRegistration(registrationStatus, "Braze User Information Tracking", Collections.singletonMap("quickUser", String.valueOf(z11)));
        }
        TalabatGTM.Companion.register(context, "normal", TalabatGTM.COMPLETED, str, "", z12);
        ObservabilityManager.trackRegistration(registrationStatus, "GA Tracking", Collections.singletonMap("loginType", str));
        TalabatAdjust.signUp();
    }

    public static void onReorderClicked(Context context, Restaurant restaurant) {
        TalabatGTM.Companion.reorderClicked(context, restaurant);
    }

    public static void onRestaurantClicked(Context context, String str, Restaurant restaurant) {
        TalabatGTM.Companion.restaurantClicked(context, str, restaurant);
    }

    public static void onRestaurantListLoaded(Context context, ArrayList<Restaurant> arrayList, String str, String str2, String str3, String str4, boolean z11, int i11, int i12, String str5, PolygonEvents polygonEvents, String str6, HashMap<String, String> hashMap, String str7, Boolean bool) {
        String str8;
        String str9;
        String str10;
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine != null) {
            str10 = filterEngine.getFilterByForTracking();
            str9 = GlobalDataModel.filterEngine.getSortByForTracking();
            str8 = GlobalDataModel.filterEngine.getCuisineForTracking();
        } else {
            str10 = "";
            str9 = str10;
            str8 = TtmlNode.COMBINE_ALL;
        }
        if (str9 == null || str9.equals("")) {
            str9 = "recommended";
        }
        FilterEngine filterEngine2 = GlobalDataModel.filterEngine;
        boolean z12 = (filterEngine2 == null || filterEngine2.selectedCuisines == null || str8.equalsIgnoreCase(TtmlNode.COMBINE_ALL)) ? false : true;
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        ShopClickedEvent.EventOriginSourceDelegate eventOriginSourceDelegate = r1;
        ShopClickedEvent.EventOriginSourceDelegate eventOriginSourceDelegate2 = new ShopClickedEvent.EventOriginSourceDelegate();
        companion.shopListLoaded(context, arrayList, str10, str9, str8, z12, str, str2, str3, str4, z11, i11, i12, str5, polygonEvents, str6, hashMap, str7, eventOriginSourceDelegate, (Boolean) null, (Boolean) null, bool.booleanValue());
        TalabatAdjust.restaurantListScreenOpened(arrayList, str8, str9, str10);
    }

    public static void onRestaurantListUpdated(Context context, ArrayList<Restaurant> arrayList, String str, String str2, String str3, String str4, boolean z11, int i11, int i12, boolean z12, String str5, PolygonEvents polygonEvents, String str6, HashMap<String, String> hashMap, ShopClickedEvent.EventOriginSource eventOriginSource, String str7) {
        String str8;
        String str9;
        String str10;
        if (z12) {
            FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
            if (filterEngine != null) {
                str10 = filterEngine.getFilterByForTracking();
                str9 = GlobalDataModel.collectionFilterEngine.getSortByForTracking();
                str8 = GlobalDataModel.collectionFilterEngine.getCuisineForTracking();
                TalabatGTM.Companion.shopListLoaded(context, arrayList, str10, str9, str8, true, str, str2, str3, str4, z11, i11, i12, str5, polygonEvents, str6, hashMap, str7, eventOriginSource, (Boolean) null, (Boolean) null, false);
                TalabatAdjust.restaurantListScreenOpened(arrayList, str8, str9, str10);
            }
        } else {
            FilterEngine filterEngine2 = GlobalDataModel.filterEngine;
            if (filterEngine2 != null) {
                str10 = filterEngine2.getFilterByForTracking();
                str9 = GlobalDataModel.filterEngine.getSortByForTracking();
                str8 = GlobalDataModel.filterEngine.getCuisineForTracking();
                TalabatGTM.Companion.shopListLoaded(context, arrayList, str10, str9, str8, true, str, str2, str3, str4, z11, i11, i12, str5, polygonEvents, str6, hashMap, str7, eventOriginSource, (Boolean) null, (Boolean) null, false);
                TalabatAdjust.restaurantListScreenOpened(arrayList, str8, str9, str10);
            }
        }
        str10 = "";
        str8 = "All";
        str9 = str10;
        TalabatGTM.Companion.shopListLoaded(context, arrayList, str10, str9, str8, true, str, str2, str3, str4, z11, i11, i12, str5, polygonEvents, str6, hashMap, str7, eventOriginSource, (Boolean) null, (Boolean) null, false);
        TalabatAdjust.restaurantListScreenOpened(arrayList, str8, str9, str10);
    }

    public static void onRestaurantSearched(Context context, String str, String str2, ArrayList<QuickRestaurant> arrayList) {
        TalabatGTM.Companion.onSearchResultsDisplayed(context, str, str2, arrayList);
    }

    public static void onRestaurantsClicked(Context context, Restaurant restaurant, String str, String str2, String str3, String str4, String str5, String str6, PolygonEvents polygonEvents, String str7, HashMap<String, String> hashMap, ShopClickedEvent.EventOriginSource eventOriginSource, boolean z11, String str8) {
        Context context2 = context;
        TalabatAppBoy.restaurantSelected(context2, getRestaurantId(restaurant), getRestaurantName(restaurant));
        Context context3 = context2;
        TalabatGTM.Companion.restaurantClicked(context3, restaurant.isUpSelling, restaurant, str, str2, str3, str4, str5, str6, polygonEvents, str7, hashMap, eventOriginSource, z11, str8, (Integer) null, (Integer) null);
    }

    public static void onRestaurantsCuisineApply(Context context, String str, boolean z11) {
        TalabatGTM.Companion.onCuisineScreenApplySelection(context, str, z11);
    }

    public static void onRestaurantsCuisineClear(Context context, String str) {
        TalabatGTM.Companion.onCuisineScreenClearSelection(context, str);
    }

    public static void onRestaurantsCuisineSelection(Context context, String str, boolean z11) {
        TalabatGTM.Companion.onCuisineScreenSelectCuisine(context, str, z11);
    }

    public static void onSaveMapFirstLastOrderLatLng(Context context, double d11, double d12) {
        TalabatAppBoy.saveMapFirstLastOrderLatLng(context, d11, d12);
    }

    public static void onSearchBarClicked(Context context, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.onSearchBarClicked(context, str, str2, str3, str4);
    }

    public static void onSearchButtonClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.onSearchButtonClicked(context, str, str2);
    }

    public static void onSearchClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.searchClicked(context, str, str2);
    }

    public static void onSearchErrorShown(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.onSearchErrorShown(context, str, str2, str3);
    }

    public static void onSearchRestaurantClicked(Context context, String str, String str2, QuickRestaurant quickRestaurant, int i11) {
        TalabatGTM.Companion.onSearchRestaurantClicked(context, str, str2, quickRestaurant, i11);
    }

    public static void onSideMenuButtonClicked(Context context, String str) {
        TalabatGTM.Companion.sideMenuOpened(context, str);
    }

    public static void onSideMenuOptionSelected(Context context, String str) {
        TalabatGTM.Companion.sideMenuOptionSelected(context, str);
    }

    public static void onSnappingGpsInfo(Context context, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.onSnappingGpsInfo(context, str, str2, str3, str4);
    }

    public static void onTabInfoClicked(Context context, Restaurant restaurant) {
        TalabatGTM.Companion.onTabInfoClicked(context, restaurant);
    }

    public static void onTabReviewsClicked(Context context, Restaurant restaurant) {
        TalabatGTM.Companion.onTabReviewsClicked(context, restaurant);
    }

    public static void onTalabatCreditUpdated(Context context, String str) {
        TalabatAppBoy.updateRemainingTalabatCredit(context, str);
    }

    public static void onTipRiderClicked(Context context, String str, String str2, String str3, String str4, String str5) {
        TalabatGTM.Companion.pushTipRiderClicked(context, str, str2, str3, str4, str5);
    }

    public static void onTipRiderCompleted(Context context, String str, String str2, String str3, String str4, String str5) {
        TalabatGTM.Companion.pushTipRiderCompleted(context, str, str2, str3, str4, str5);
    }

    public static void onTipRiderFailure(Context context, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.pushTipRiderFailure(context, str, str2, str3, str4);
    }

    public static void onTipRiderOpened(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.pushTipRiderOpen(context, str, str2, str3);
    }

    public static void onTokenRemoved(Context context) {
        TalabatGTM.Companion.tokenRemoved(context);
    }

    public static void onTransactionFailed(Context context, int i11, String str, String str2, String str3, Restaurant restaurant, boolean z11, String str4, String str5, int i12, double d11) {
        TalabatGTM.Companion.transactionFailed(context, getPaymentType(i11), str, str2, str3, restaurant, z11, str4, str5, i12, Double.valueOf(d11));
    }

    public static void onUpSellingSliderShown(Context context) {
        TalabatGTM.Companion.upSellingSliderShown(context);
    }

    public static void onUpdateAddressSelected(Context context, String str) {
        TalabatGTM.Companion.onUpdateAddressSelected(context, str);
    }

    public static void onUpdateAddressShown(Context context) {
        TalabatGTM.Companion.onUpdateAddressShown(context);
    }

    public static void onVerificationChangeSelected(Context context) {
        TalabatGTM.Companion.verificationChangeSelected(context);
    }

    public static void onVerificationFailed(Context context) {
        TalabatGTM.Companion.verificationFailed(context);
    }

    public static void onVerificationPopupShown(Context context, String str) {
        TalabatGTM.Companion.verificationPopupShown(context, str);
    }

    public static void onVerificationSuccessful(Context context, boolean z11) {
        TalabatGTM.Companion.verificationSuccessful(context, z11);
    }

    public static void onVerifyClicked(Context context) {
        TalabatGTM.Companion.verifyClicked(context);
    }

    @Deprecated
    public static void onVoucherRedeemFailed(Context context, int i11, Cart cart, String str, String str2, String str3) {
        TalabatGTM.Companion.voucherRedeemFailed(context, str, str2, str3, cart.getRestaurant(), LoyaltyVoucherResult.VOUCHER_CODE_VOUCHER_OPTION_TYPE);
        TalabatAdjust.voucherRejected(cart.getCartItems(), cart.getRestaurant(), str, str3);
    }

    @Deprecated
    public static void onVoucherRedeemed(Context context, int i11, int i12, String str, String str2, Restaurant restaurant) {
        TalabatGTM.Companion.voucherRedeemSuccess(context, str, str2, restaurant, LoyaltyVoucherResult.VOUCHER_CODE_VOUCHER_OPTION_TYPE);
    }

    public static void onWalletTopupAttempted(Context context, String str, String str2, String str3) {
        TalabatGTM.Companion.pushWalletTopupAttempted(context, str, str2, str3);
    }

    public static void onWalletTopupClicked(Context context, String str, String str2) {
        TalabatGTM.Companion.pushWalletTopupClicked(context, str, str2);
    }

    public static void onWalletTopupFailed(Context context, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.pushWalletTopupFailed(context, str, str2, str3, str4);
    }

    public static void onWalletTopupSuccess(Context context, String str, String str2, String str3, String str4) {
        TalabatGTM.Companion.pushWalletTopupSuccess(context, str, str2, str3, str4);
    }

    public static void paymentErrorClosed(Context context, int i11) {
        TalabatGTM.Companion.paymentErrorClosed(context, getPaymentType(i11));
    }

    public static void paymentErrorShown(Context context, int i11, String str, String str2) {
        TalabatGTM.Companion.paymentErrorShown(context, getPaymentType(i11), str, str2);
    }

    public static void paymentFailedClosed(Context context, String str) {
        TalabatGTM.Companion.paymentFailedClosed(context, str);
    }

    public static void paymentFailedShown(Context context, String str) {
        TalabatGTM.Companion.paymentFailedShown(context, str);
    }

    public static void retryConnectClicked(Context context) {
        TalabatGTM.Companion.retryConnectClicked(context);
    }

    public static void savePurchase(Purchase purchase2) {
        purchase = purchase2;
    }

    public static void setGoogleAdvertId(Context context, String str) {
        TalabatPerseus.setAdvertisingId(str);
        TalabatAppBoy.googleAdvertId(context, str);
    }

    public static void termsAndConditionsClicked(Context context, String str) {
        TalabatGTM.Companion.termsAndConditionClicked(context, str);
    }

    public static void termsAndConditionsClosed(Context context, String str) {
        TalabatGTM.Companion.termsAndConditionClosed(context, str);
    }

    public static void upsellCokeItemAddClicked(Context context, String str) {
        TalabatGTM.Companion.upsellCokeItemAddClicked(context, str);
    }

    public static void upsellCokeSliderNavigated(Context context) {
        TalabatGTM.Companion.upsellCokeSliderNavigated(context);
    }

    public void onDarkstoresAddToCartClicked(@NotNull Context context, String str, String str2, String str3, String str4, String str5, float f11, int i11, boolean z11, boolean z12, String str6, String str7, @Nullable String str8, @Nullable Integer num, int i12, @Nullable String str9, Integer num2) {
        this.talabatGTM.onDarkstoresAddToCartClicked(context, str, str2, str3, str4, str5, f11, i11, z11, z12, str6, str7, str8, num, i12, str9, num2);
        if (z12) {
            TalabatAppBoy.add_toCart(context);
            if (Cart.getInstance().getRestaurant() != null) {
                TalabatAdjust.addToCart(Cart.getInstance().getRestaurant(), str4, i11, f11);
            }
        }
    }

    public void onDarkstoresSearchResultsClicked(Context context, String str, String str2, String str3) {
        this.talabatGTM.onDarkstoresSearchResultsClicked(context, str, str2, str3);
    }

    public void onDarkstoresSearchResultsLoaded(Context context, @Nullable String str, String str2, String str3, String str4, List<String> list) {
        this.talabatGTM.onDarkstoresSearchResultsLoaded(context, str, str2, str3, str4, list);
    }

    public void onDarkstoresShopDetailsLoaded(@NotNull Context context, String str, String str2, boolean z11, String str3) {
        this.talabatGTM.onDarkstoresShopDetailsLoaded(context, str, str2, z11, str3);
    }

    public void onOfferingRestaurantListUpdated(Context context, ArrayList<Restaurant> arrayList, String str, String str2, String str3, String str4, boolean z11, int i11, int i12, boolean z12, String str5, PolygonEvents polygonEvents, String str6, HashMap<String, String> hashMap, ShopClickedEvent.EventOriginSource eventOriginSource, String str7, Boolean bool, Boolean bool2) {
        String str8 = "";
        String str9 = "";
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        companion.shopListLoaded(context, arrayList, str8, str9, "All", true, str, str2, str3, str4, z11, i11, i12, str5, polygonEvents, str6, hashMap, str7, eventOriginSource, bool, bool2, false);
        TalabatAdjust.restaurantListScreenOpened(arrayList, "All", "", "");
    }

    public void onOfferingRestaurantsClicked(Context context, Restaurant restaurant, String str, String str2, String str3, String str4, String str5, String str6, PolygonEvents polygonEvents, String str7, HashMap<String, String> hashMap, ShopClickedEvent.EventOriginSource eventOriginSource, boolean z11) {
        TalabatAppBoy.restaurantSelected(context, getRestaurantId(restaurant), getRestaurantName(restaurant));
        TalabatGTM.Companion.restaurantClicked(context, restaurant.isUpSelling, restaurant, str, str2, str3, str4, str5, str6, polygonEvents, str7, hashMap, eventOriginSource, z11, (String) null, (Integer) null, (Integer) null);
    }

    public void onOrderRating(Context context, RateOrderReq rateOrderReq, String str, int i11, int i12, boolean z11) {
        TalabatAdjust.rateOrder(rateOrderReq, i11, i12, z11);
        TalabatAppBoy.order_rated(context, rateOrderReq, str);
        TalabatGTM.Companion.rateorderSubmitted(context, rateOrderReq.ordId);
    }

    public void onPushBNPLError(Context context, String str, String str2, String str3) {
        this.talabatGTM.pushBNPLError(context, str, str2, str3);
    }

    public void onPushBNPLFakeTestSubmitted(Context context, boolean z11, boolean z12) {
        this.talabatGTM.pushBNPLFakeTestSubmitted(context, z11, z12);
    }

    public void onPushBNPLOrderPaymentFailureEvent(Context context, BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel) {
        this.talabatGTM.pushBNPLOrderPaymentFailureEvent(context, bNPLOrderPaymentFailureTrackingModel);
    }

    public void onPushBNPLValidationLoaded(Context context, String str, String str2) {
        this.talabatGTM.pushBNPLLoaded(context, str, str2);
    }

    public void onPushBeginCheckoutEvent(Context context, Cart cart, String str, Boolean bool, Boolean bool2, Boolean bool3) {
        this.talabatGTM.pushBeginCheckoutEvent(context, cart, str, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue());
    }

    public void onPushPaymentMethodChanged(Context context, String str, String str2) {
        this.talabatGTM.pushPaymentMethodChanged(context, str, str2);
    }

    public void onPushPlaceFakeOrder(Context context, String str) {
        this.talabatGTM.pushBNPLPlaceFakeOrder(context, str);
    }

    public void onRestaurantInfoLoaded(Context context, Restaurant restaurant, boolean z11, String str, ArrayList<MenuSection> arrayList, int i11, int i12, String str2) {
        this.talabatGTM.pushRestaurantView(context, restaurant, z11, str, arrayList, i11, i12, str2);
        TalabatAdjust.viewRestaurant(restaurant);
    }

    public void onSearchClosed(Context context, @Nullable String str, String str2, @Nullable String str3, int i11) {
        this.talabatGTM.onSearchClosed(context, str, str2, str3, i11);
    }

    public void onSubscriptionVerificationCancelled(Context context, String str, String str2, String str3, String str4) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_cancelled", str, str2, str3, str4, (String) null, (String) null, (String) null);
    }

    public void onSubscriptionVerificationClicked(Context context, String str, String str2, String str3, String str4) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_clicked", str, str2, str3, str4, (String) null, (String) null, (String) null);
    }

    public void onSubscriptionVerificationCodeExpired(Context context, String str, String str2, String str3, String str4, String str5) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_code_expired", str, str2, str3, str4, str5, (String) null, (String) null);
    }

    public void onSubscriptionVerificationCodeResend(Context context, String str, String str2, String str3, String str4, String str5) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_resend", str, str2, str3, str4, str5, (String) null, (String) null);
    }

    public void onSubscriptionVerificationContinued(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_continued", str, str2, str3, str4, str5, (String) null, str6);
    }

    public void onSubscriptionVerificationErrorShown(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_error_shown", str, str2, str3, str4, str5, str6, (String) null);
    }

    public void onSubscriptionVerificationStarted(Context context, String str, String str2, String str3, String str4, String str5) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_started", str, str2, str3, str4, str5, (String) null, (String) null);
    }

    public void onSubscriptionVerificationValidated(Context context, String str, String str2, String str3, String str4, String str5) {
        this.talabatGTM.subscriptionVerificationEvent(context, "mobile_verification_validated", str, str2, str3, str4, str5, (String) null, (String) null);
    }

    public static void onReorderClicked(Context context, int i11, String str, String str2) {
        TalabatGTM.Companion.reorderClicked(context, i11, str, str2);
    }

    public static void onSearchClicked(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        TalabatGTM.Companion.onSearchClicked(context, str, str2, str3, str4, str5, str6);
    }

    public void onSearchErrorShown(Context context, String str, String str2, String str3, String str4) {
        this.talabatGTM.onSearchErrorShown(context, str, str2, str3, str4);
    }
}
