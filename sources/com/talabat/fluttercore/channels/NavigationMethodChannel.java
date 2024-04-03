package com.talabat.fluttercore.channels;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.voucherlist.VouchersListDeeplinkBuilder;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.fluttercore.domain.entities.RestaurantKt;
import com.talabat.fluttercore.domain.entities.SearchFlutterTrackingInfo;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.checkout.CheckoutNavigationActions;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.talabatnavigation.tpro.TproNavigatorActionsKt;
import datamodels.Restaurant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.Purchase;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0007J\u001c\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001c\u0010!\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u001c\u0010#\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\u001c\u0010%\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001c\u0010&\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001c\u0010'\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001c\u0010(\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\nH\u0016J\u001c\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u00103\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u00065"}, d2 = {"Lcom/talabat/fluttercore/channels/NavigationMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "navigationResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "getNavigationResult", "()Lio/flutter/plugin/common/MethodChannel$Result;", "setNavigationResult", "(Lio/flutter/plugin/common/MethodChannel$Result;)V", "generatePurchaseObj", "Ltracking/Purchase;", "firstOrder", "", "selectedPaymentMethod", "", "addToPayMethod", "transactionId", "", "isPurchaseEventsEnabled", "handleNavigation", "", "arguments", "", "", "isCardViewMenu", "restaurant", "Ldatamodels/Restaurant;", "navigateToAddressListScreen", "navigateToCheckoutScreen", "navigateToItemDetailsScreen", "navigateToLoginScreen", "navigateToMenuCartScreen", "navigateToMenuScreen", "navigateToOrderTrackingScreen", "navigateToTDineOfferDetailsScreen", "navigateToTproBenefits", "navigateToVendorList", "navigateToVouchersListScreen", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "searchFlutterTrackingInfo", "Lcom/talabat/fluttercore/domain/entities/SearchFlutterTrackingInfo;", "data", "setCallback", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final String ADDRESS_LIST = "addressList";
    @NotNull
    public static final String ADD_TO_PAY_METHOD = "addToPayMethod";
    @NotNull
    public static final String ARG_EVENT_ORIGIN = "searchEventOrigin";
    @NotNull
    private static final String BACK_NAVIGATION_METHOD_CALL = "backNavigation";
    public static final int CASH_PAYMENT_METHOD = 0;
    @NotNull
    public static final String CHECKOUT = "checkout";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DATA = "data";
    @NotNull
    public static final String ENCRYPTED_ORDER_ID = "encryptedOrderId";
    @NotNull
    private static final String FROM = "from";
    @NotNull
    public static final String ID = "id";
    @NotNull
    public static final String IS_FIRST_ORDER = "isFirstOrder";
    @NotNull
    public static final String IS_PURCHASED_EVENTS_ENABLED = "isPurchaseEventsEnabled";
    @NotNull
    public static final String IS_VENDOR_LIST = "isVendorList";
    @NotNull
    public static final String ITEMDETAILS = "ItemDetails";
    @NotNull
    public static final String LOGIN_SCREEN = "login-screen";
    public static final int LOGIN_SCREEN_REQUEST_RESULT = 2000;
    @NotNull
    public static final String MENU_CART = "menuCart";
    @NotNull
    private static final String NAME = "name";
    @NotNull
    private static final String NAVIGATE_TO_FLUTTER_METHOD_CALL = "navigateToFlutter";
    @NotNull
    public static final String NAVIGATE_TO_NATIVE_METHOD_CALL = "navigateToNative";
    @NotNull
    private static final String NEWSEARCH = "SEARCH_SCREEN";
    @NotNull
    public static final String OPEN_ADDRESS_LIST = "talabat.action.AddressListScreen";
    @NotNull
    public static final String ORDER_TRACKING = "orderTracking";
    @NotNull
    public static final String SCREENNAME = "screenName";
    @NotNull
    public static final String SEARCH = "search";
    @NotNull
    private static final String SEARCH_TERM = "searchTerm";
    @NotNull
    public static final String SEARCH_TRACKING = "trackingInfo";
    @NotNull
    public static final String SELECTED_PAYMENT_METHOD = "selectedPaymentMethod";
    @NotNull
    public static final String SHOW_ADD_ADDRESS_BUTTON = "shouldShowAddAddress";
    @NotNull
    public static final String TDINE_OFFER_DETAILS = "tDineOfferDetails";
    @NotNull
    public static final String TOSCREEN = "toScreen";
    @NotNull
    public static final String TPRO_BENEFITS = "tProSubscriptionOnboarding";
    @NotNull
    public static final String TRANSACTION_ID = "transId";
    @NotNull
    public static final String VENDORINFO = "vandorInfo";
    @NotNull
    public static final String VENDORPRODUCTDETAILS = "VendorProductDetails";
    @NotNull
    public static final String VENDOR_LIST = "VendorList";
    public static final int VISA_CHECKOUT = 1;
    @NotNull
    public static final String VOUCHERS_LIST = "vouchersList";
    @Nullable
    private Activity activity;
    @Nullable
    private MethodChannel.Result navigationResult;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/fluttercore/channels/NavigationMethodChannel$Companion;", "", "()V", "ADDRESS_LIST", "", "ADD_TO_PAY_METHOD", "ARG_EVENT_ORIGIN", "BACK_NAVIGATION_METHOD_CALL", "CASH_PAYMENT_METHOD", "", "CHECKOUT", "DATA", "ENCRYPTED_ORDER_ID", "FROM", "ID", "IS_FIRST_ORDER", "IS_PURCHASED_EVENTS_ENABLED", "IS_VENDOR_LIST", "ITEMDETAILS", "LOGIN_SCREEN", "LOGIN_SCREEN_REQUEST_RESULT", "MENU_CART", "NAME", "NAVIGATE_TO_FLUTTER_METHOD_CALL", "NAVIGATE_TO_NATIVE_METHOD_CALL", "NEWSEARCH", "OPEN_ADDRESS_LIST", "ORDER_TRACKING", "SCREENNAME", "SEARCH", "SEARCH_TERM", "SEARCH_TRACKING", "SELECTED_PAYMENT_METHOD", "SHOW_ADD_ADDRESS_BUTTON", "TDINE_OFFER_DETAILS", "TOSCREEN", "TPRO_BENEFITS", "TRANSACTION_ID", "VENDORINFO", "VENDORPRODUCTDETAILS", "VENDOR_LIST", "VISA_CHECKOUT", "VOUCHERS_LIST", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleNavigation(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get("screenName");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -1607417306:
                    if (str.equals(VENDOR_LIST)) {
                        navigateToVendorList();
                        return;
                    }
                    break;
                case -1596406960:
                    if (str.equals(LOGIN_SCREEN)) {
                        navigateToLoginScreen();
                        return;
                    }
                    break;
                case -1377524046:
                    if (str.equals(ADDRESS_LIST)) {
                        navigateToAddressListScreen(map);
                        return;
                    }
                    break;
                case -1308302319:
                    if (str.equals(TPRO_BENEFITS)) {
                        navigateToTproBenefits();
                        return;
                    }
                    break;
                case -1203184603:
                    if (str.equals("orderTracking")) {
                        navigateToOrderTrackingScreen(map);
                        return;
                    }
                    break;
                case -658839077:
                    if (str.equals(VENDORPRODUCTDETAILS)) {
                        navigateToItemDetailsScreen(map);
                        return;
                    }
                    break;
                case -604291809:
                    if (str.equals(MENU_CART)) {
                        navigateToMenuCartScreen(map);
                        return;
                    }
                    break;
                case -228318781:
                    if (str.equals(VOUCHERS_LIST)) {
                        navigateToVouchersListScreen();
                        return;
                    }
                    break;
                case 54522870:
                    if (str.equals(TDINE_OFFER_DETAILS)) {
                        navigateToTDineOfferDetailsScreen(map);
                        return;
                    }
                    break;
                case 1536904518:
                    if (str.equals("checkout")) {
                        navigateToCheckoutScreen();
                        return;
                    }
                    break;
            }
        }
        navigateToMenuScreen(map);
    }

    private final boolean isCardViewMenu(Restaurant restaurant) {
        return restaurant.getMenuType() == 2 && !restaurant.isMigrated;
    }

    private final void navigateToAddressListScreen(Map<String, ? extends Object> map) {
        Boolean bool;
        boolean z11;
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Object obj = map.get("data");
            if (obj != null) {
                Object obj2 = ((Map) obj).get(SHOW_ADD_ADDRESS_BUTTON);
                if (obj2 instanceof Boolean) {
                    bool = (Boolean) obj2;
                } else {
                    bool = null;
                }
                if (bool != null) {
                    z11 = bool.booleanValue();
                } else {
                    z11 = true;
                }
                Navigator.Companion.navigate((Context) activity2, (NavigatorModel) new NavigatorModelForResult(OPEN_ADDRESS_LIST, (Bundle) null, new NavigationMethodChannel$navigateToAddressListScreen$1$1(z11), 0, 10, (DefaultConstructorMarker) null));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
    }

    private final void navigateToCheckoutScreen() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Navigator.Companion.navigate((Context) activity2, (NavigatorModel) new NavigatorModelForResult(LegacyTalabatActions.OPEN_CHECKOUT, (Bundle) null, (Function1) null, 0, 14, (DefaultConstructorMarker) null));
        }
    }

    private final void navigateToItemDetailsScreen(Map<String, ? extends Object> map) {
        Restaurant restaurant;
        if (map.get("data") != null) {
            Object obj = map.get("data");
            if (obj != null) {
                Map map2 = (Map) obj;
                Map map3 = (Map) map2.get(VENDORINFO);
                if (map3 != null) {
                    restaurant = RestaurantKt.toRestaurant(map3);
                } else {
                    restaurant = null;
                }
                SearchFlutterTrackingInfo searchFlutterTrackingInfo = searchFlutterTrackingInfo(map2);
                GlobalDataModel.ShopClickOrigin = searchFlutterTrackingInfo.getEventOrigin();
                GlobalDataModel.SELECTED.updateRestaurant(restaurant);
                String str = (String) map2.get("id");
                String str2 = (String) map2.get("name");
                Bundle bundle = new Bundle();
                bundle.putString(OPNavigatorActions.ARG_SEARCH_TERM, searchFlutterTrackingInfo.getSearchTerm());
                bundle.putString(ARG_EVENT_ORIGIN, searchFlutterTrackingInfo.getEventOrigin());
                bundle.putString("from", NEWSEARCH);
                if (restaurant != null && str != null) {
                    if (isCardViewMenu(restaurant)) {
                        bundle.putString(TOSCREEN, "search");
                        bundle.putString("searchTerm", str2);
                    } else {
                        bundle.putString(TOSCREEN, ITEMDETAILS);
                    }
                    Activity activity2 = this.activity;
                    if (activity2 != null) {
                        Navigator.Companion companion = Navigator.Companion;
                        OPNavigatorActions.Companion companion2 = OPNavigatorActions.Companion;
                        int i11 = restaurant.branchId;
                        int i12 = restaurant.shopType;
                        boolean z11 = restaurant.isGlrEnabled;
                        boolean z12 = restaurant.isDarkStore;
                        boolean z13 = restaurant.isMigrated;
                        Boolean isPickup = restaurant.isPickup();
                        Intrinsics.checkNotNullExpressionValue(isPickup, "restaurant.isPickup");
                        companion.navigate(activity2, companion2.createNavigatorModelForResultForMenuBridgeActivity(i11, i12, z11, z12, z13, true, str, bundle, isPickup.booleanValue()));
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
    }

    private final void navigateToLoginScreen() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Navigator.Companion.navigate((Context) activity2, (NavigatorModel) new NavigatorModelForResult(LegacyTalabatActions.OPEN_LOGIN_SCREEN_ACTIVITY, (Bundle) null, NavigationMethodChannel$navigateToLoginScreen$1$1.INSTANCE, 2000, 2, (DefaultConstructorMarker) null));
        }
    }

    private final void navigateToMenuCartScreen(Map<String, ? extends Object> map) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (map.get("data") != null) {
            Object obj = map.get("data");
            if (obj != null) {
                Object obj2 = ((Map) obj).get(IS_VENDOR_LIST);
                if (obj2 != null) {
                    booleanRef.element = ((Boolean) obj2).booleanValue();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            }
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Navigator.Companion.navigate((Context) activity2, (NavigatorModel) new NavigatorModelForResult(LegacyTalabatActions.OPEN_CART, (Bundle) null, new NavigationMethodChannel$navigateToMenuCartScreen$1$1(booleanRef), 0, 10, (DefaultConstructorMarker) null));
        }
    }

    private final void navigateToMenuScreen(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get("data");
        if (obj != null) {
            Map map2 = (Map) obj;
            Restaurant restaurant = RestaurantKt.toRestaurant(map2);
            SearchFlutterTrackingInfo searchFlutterTrackingInfo = searchFlutterTrackingInfo(map2);
            GlobalDataModel.ShopClickOrigin = searchFlutterTrackingInfo.getEventOrigin();
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            Bundle bundle = new Bundle();
            bundle.putString(OPNavigatorActions.ARG_SEARCH_TERM, searchFlutterTrackingInfo.getSearchTerm());
            Activity activity2 = this.activity;
            if (activity2 != null) {
                Navigator.Companion companion = Navigator.Companion;
                OPNavigatorActions.Companion companion2 = OPNavigatorActions.Companion;
                int i11 = restaurant.branchId;
                int i12 = restaurant.shopType;
                boolean z11 = restaurant.isGlrEnabled;
                boolean z12 = restaurant.isDarkStore;
                boolean z13 = restaurant.isMigrated;
                if (z12) {
                    str = "";
                } else {
                    str = "-1";
                }
                Boolean isPickup = restaurant.isPickup();
                Intrinsics.checkNotNullExpressionValue(isPickup, "restaurant.isPickup");
                companion.navigate(activity2, companion2.createNavigatorModelForResultForMenuBridgeActivity(i11, i12, z11, z12, z13, true, str, bundle, isPickup.booleanValue()));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    private final void navigateToOrderTrackingScreen(Map<String, ? extends Object> map) {
        if (map.get("data") != null) {
            Object obj = map.get("data");
            if (obj != null) {
                Map map2 = (Map) obj;
                Object obj2 = map2.get("encryptedOrderId");
                if (obj2 != null) {
                    String str = (String) obj2;
                    Object obj3 = map2.get("transId");
                    if (obj3 != null) {
                        String str2 = (String) obj3;
                        Object obj4 = map2.get(IS_FIRST_ORDER);
                        if (obj4 == null) {
                            obj4 = Boolean.FALSE;
                        }
                        boolean booleanValue = ((Boolean) obj4).booleanValue();
                        Object obj5 = map2.get(IS_PURCHASED_EVENTS_ENABLED);
                        if (obj5 == null) {
                            obj5 = Boolean.FALSE;
                        }
                        boolean booleanValue2 = ((Boolean) obj5).booleanValue();
                        int i11 = map2.get(SELECTED_PAYMENT_METHOD);
                        if (i11 == null) {
                            i11 = 0;
                        }
                        int intValue = ((Integer) i11).intValue();
                        int i12 = map2.get(ADD_TO_PAY_METHOD);
                        if (i12 == null) {
                            i12 = 0;
                        }
                        AppTracker.savePurchase(generatePurchaseObj(booleanValue, intValue, ((Integer) i12).intValue(), str2, booleanValue2));
                        Activity activity2 = this.activity;
                        if (activity2 != null) {
                            Navigator.Companion.navigate((Context) activity2, CheckoutNavigationActions.INSTANCE.createNavigationModelToOrderTracking(str, str2));
                            activity2.finish();
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        }
    }

    private final void navigateToTDineOfferDetailsScreen(Map<String, ? extends Object> map) {
        Object obj = map.get("data");
        if (obj != null) {
            Map map2 = (Map) obj;
            Integer num = (Integer) map2.get("vendorId");
            String str = (String) map2.get(BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
            String str2 = (String) map2.get("planTitle");
            Double d11 = (Double) map2.get("planAmount");
            String str3 = (String) map2.get("actionText");
            String str4 = (String) map2.get("freeTrialTitle");
            Boolean bool = (Boolean) map2.get("freeTrialEligible");
            String str5 = (String) map2.get("onBoardingTitle");
            String str6 = (String) map2.get("onBoardingSubTitle");
            String str7 = (String) map2.get("nextBillingText");
            String str8 = (String) map2.get("subscriptionPaymentDate");
            if (num != null) {
                int intValue = num.intValue();
                Bundle bundle = new Bundle();
                bundle.putString("vendorID", String.valueOf(intValue));
                Activity activity2 = this.activity;
                if (activity2 != null) {
                    Navigator.Companion.navigate((Context) activity2, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDOR_OFFERS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    private final void navigateToTproBenefits() {
        Boolean bool;
        Activity activity2;
        ApiContainer apiContainer;
        CustomerCoreLibApi customerCoreLibApi;
        CustomerRepository repository;
        Activity activity3 = this.activity;
        if (activity3 == null || (apiContainer = AndroidComponentsKt.apiContainer(activity3)) == null || (customerCoreLibApi = (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class)) == null || (repository = customerCoreLibApi.getRepository()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(repository.isTPro());
        }
        boolean z11 = false;
        if (bool != null && !bool.booleanValue()) {
            z11 = true;
        }
        if (z11 && (activity2 = this.activity) != null) {
            TproNavigatorActionsKt.navigateToBenefitsActivity(Navigator.Companion, activity2);
        }
    }

    private final void navigateToVendorList() {
        Integer num;
        ApiContainer apiContainer;
        ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        ConfigurationLocalRepository repository;
        Country selectedCountry;
        Activity activity2 = this.activity;
        if (activity2 == null || (apiContainer = AndroidComponentsKt.apiContainer(activity2)) == null || (configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class)) == null || (repository = configurationLocalCoreLibApi.getRepository()) == null || (selectedCountry = repository.selectedCountry()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(selectedCountry.getCountryId());
        }
        Activity activity3 = this.activity;
        if (activity3 != null) {
            Navigator.Companion companion = Navigator.Companion;
            SdSquadActions.Companion companion2 = SdSquadActions.Companion;
            String valueOf = String.valueOf(GlobalDataModel.RECENT_LATLONG.latitude);
            String valueOf2 = String.valueOf(GlobalDataModel.RECENT_LATLONG.longitude);
            int i11 = GlobalDataModel.SelectedAreaId;
            int i12 = GlobalDataModel.SelectedCityId;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            String str = GlobalDataModel.SelectedAreaName;
            Intrinsics.checkNotNullExpressionValue(str, "SelectedAreaName");
            companion.navigate((Context) activity3, companion2.createNavigatorModelForListingScreen(valueOf, valueOf2, i11, i12, intValue, str));
        }
    }

    private final void navigateToVouchersListScreen() {
        com.talabat.core.navigation.domain.Navigator navigator;
        ApiContainer apiContainer;
        NavigationCoreLibApi navigationCoreLibApi;
        Activity activity2 = this.activity;
        if (activity2 == null || (apiContainer = AndroidComponentsKt.apiContainer(activity2)) == null || (navigationCoreLibApi = (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class)) == null) {
            navigator = null;
        } else {
            navigator = navigationCoreLibApi.getNavigator();
        }
        com.talabat.core.navigation.domain.Navigator navigator2 = navigator;
        Activity activity3 = this.activity;
        if (activity3 != null && navigator2 != null) {
            Navigator.DefaultImpls.navigateTo$default(navigator2, activity3, new FlutterScreen(new FlutterScreen.FlutterScreenData(VouchersListDeeplinkBuilder.build$default(new VouchersListDeeplinkBuilder(), (String) null, (String) null, (String) null, false, false, 31, (Object) null))), (Function1) null, 4, (Object) null);
        }
    }

    private final SearchFlutterTrackingInfo searchFlutterTrackingInfo(Map<String, ? extends Object> map) {
        if (map.get(SEARCH_TRACKING) == null) {
            return new SearchFlutterTrackingInfo((String) null, (String) null, (String) null, 0, 15, (DefaultConstructorMarker) null);
        }
        Object obj = map.get(SEARCH_TRACKING);
        if (obj != null) {
            return RestaurantKt.toSearchTrackingInfo((Map) obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }

    @NotNull
    @VisibleForTesting
    public final Purchase generatePurchaseObj(boolean z11, int i11, int i12, @NotNull String str, boolean z12) {
        boolean z13;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Purchase purchase = new Purchase();
        purchase.setFirstOrder(z11);
        purchase.setPurchaseEventsEnabled(z12);
        purchase.setCart(Cart.getInstance().getCartItems());
        float cartTotalPrice = Cart.getInstance().getCartTotalPrice();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cartTotalPrice);
        purchase.setTotal(sb2.toString());
        purchase.setTouristTax(Cart.getInstance().getTouristTax());
        purchase.setMunciplityTax(Cart.getInstance().getMuncipalityTax());
        float deliveryCharges = Cart.getInstance().getDeliveryCharges();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(deliveryCharges);
        purchase.setDelCharges(sb3.toString());
        purchase.setRestaurant(Cart.getInstance().getRestaurant());
        purchase.setRiderTip(Cart.getInstance().getRiderTip());
        boolean z14 = false;
        if (i12 == 1) {
            z13 = true;
        } else {
            z13 = false;
        }
        purchase.setPaymentMethod(i11, z13, -1);
        purchase.setEncyptedTransactionId(str);
        if (Customer.getInstance().getSelectedCustomerAddress() != null) {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            Intrinsics.checkNotNull(selectedCustomerAddress);
            if (GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
                z14 = true;
            }
            purchase.setAddress(AddressesKt.description(selectedCustomerAddress, z14));
        }
        if (Cart.getInstance().hasVoucherApplied()) {
            String voucherCode = Cart.getInstance().getVoucherCode();
            float f11 = Cart.getInstance().voucherDiscount;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(f11);
            purchase.setVoucher(voucherCode, sb4.toString());
            if (Cart.getInstance().getRestaurantCampaignVoucher() != null) {
                str3 = Cart.getInstance().getRestaurantCampaignVoucher().getVoucherTypeForTracking();
            } else {
                str3 = "normal";
            }
            purchase.setVoucherType(str3);
        }
        if (!(!Cart.getInstance().isLoyaltyAvailable() || Cart.getInstance().getLoyaltyVoucher() == null || Cart.getInstance().getLoyaltyVoucher().result == null)) {
            LoyaltyVoucherResult loyaltyVoucherResult = Cart.getInstance().getLoyaltyVoucher().result;
            Intrinsics.checkNotNull(loyaltyVoucherResult);
            purchase.setOfferVoucherId(loyaltyVoucherResult.f476id);
        }
        try {
            String str4 = "";
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                Address selectedCustomerAddress2 = Customer.getInstance().getSelectedCustomerAddress();
                Intrinsics.checkNotNull(selectedCustomerAddress2);
                str2 = selectedCustomerAddress2.mobileNumber;
            } else {
                str2 = str4;
            }
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                Address selectedCustomerAddress3 = Customer.getInstance().getSelectedCustomerAddress();
                Intrinsics.checkNotNull(selectedCustomerAddress3);
                str4 = selectedCustomerAddress3.mobilNumberCountryCode;
            }
            purchase.setMobileCountryCode(str4);
            purchase.setMobileNumber(str2);
        } catch (Exception unused) {
        }
        return purchase;
    }

    @Nullable
    public final Activity getActivity() {
        return this.activity;
    }

    @Nullable
    public final MethodChannel.Result getNavigationResult() {
        return this.navigationResult;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -788743504) {
                if (hashCode != -240241061) {
                    if (hashCode == 747580163 && str.equals(NAVIGATE_TO_NATIVE_METHOD_CALL)) {
                        this.navigationResult = result;
                        Object obj = methodCall.arguments;
                        LogManager.debug(NAVIGATE_TO_NATIVE_METHOD_CALL + obj);
                        Object obj2 = methodCall.arguments;
                        if (obj2 != null) {
                            handleNavigation((Map) obj2);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                } else if (str.equals(BACK_NAVIGATION_METHOD_CALL)) {
                    Object obj3 = methodCall.arguments;
                    LogManager.debug(BACK_NAVIGATION_METHOD_CALL + obj3);
                    return;
                }
            } else if (str.equals(NAVIGATE_TO_FLUTTER_METHOD_CALL)) {
                Object obj4 = methodCall.arguments;
                LogManager.debug(NAVIGATE_TO_FLUTTER_METHOD_CALL + obj4);
                return;
            }
        }
        LogManager.debug("Not Implemented");
    }

    public final void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    public final void setCallback(@Nullable Activity activity2) {
        this.activity = activity2;
    }

    public final void setNavigationResult(@Nullable MethodChannel.Result result) {
        this.navigationResult = result;
    }
}
