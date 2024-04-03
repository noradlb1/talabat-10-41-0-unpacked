package com.talabat.core.flutter.channels.impl.data.apicallmocks;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 B2\u00020\u0001:\u0001BB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\f\u0010&\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010(\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010)\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010*\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010+\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010,\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010-\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010.\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010/\u001a\u00020'*\u00020\u0006H\u0002J\f\u00100\u001a\u00020'*\u00020\u0006H\u0002J\f\u00101\u001a\u00020'*\u00020\u0006H\u0002J\f\u00102\u001a\u00020'*\u00020\u0006H\u0002J\f\u00103\u001a\u00020'*\u00020\u0006H\u0002J\f\u00104\u001a\u00020'*\u00020\u0006H\u0002J\f\u00105\u001a\u00020'*\u00020\u0006H\u0002J\f\u00106\u001a\u00020'*\u00020\u0006H\u0002J\f\u00107\u001a\u00020'*\u00020\u0006H\u0002J\f\u00108\u001a\u00020'*\u00020\u0006H\u0002J\f\u00109\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010:\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010;\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010<\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010=\u001a\u00020'*\u00020\u0006H\u0002J\f\u0010>\u001a\u00020'*\u00020\u0006H\u0002J\u0014\u0010?\u001a\u00020\u0006*\u00020@2\u0006\u0010A\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/apicallmocks/ApiCallsMockChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBranchInfoApiSupportedDuplicateResponse", "", "getBranchInfoApiSupportedResponse", "getCartApiResponse", "getCartApplyVoucherApiResponse", "getCheckoutApiResponse", "getCheckoutPlaceOrderApiResponse", "getChoicesApiResponse", "getJson", "path", "getMayPayApiResponse", "getNestedProductResponse", "getPayOptionsApiResponse", "getProductResponse", "getReferralCampaignsApiResponse", "getReferralCodeApiResponse", "getReviewApiResponse", "getSearchVendorProductsResponse", "getSearchVendorResponse", "getSubChoicesApiResponse", "getVendorMenuApiV2Response", "getVendorMenuApiV4Response", "getVendorPreSearchResponse", "getVendorV2Response", "getVendorV3Response", "handleRequest", "", "url", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "mockResponse", "shouldNavigateToFlutterCartApiResponse", "shouldNavigateToFlutterCheckoutApiResponse", "isBranchIdInfoApi", "", "isBranchInfoV3Api", "isCartApi", "isCartApplyVoucherApi", "isCheckoutApi", "isCheckoutPlaceOrderApi", "isChoicesApi", "isMakePayApi", "isNestedProductSearchApi", "isPayOptionsApi", "isProductSearchApi", "isReferralCampaignsApi", "isReferralCodeApi", "isReviewApi", "isSearchVendorApi", "isSearchVendorProductApi", "isShouldNavigateFlutterCartApi", "isShouldNavigateFlutterCheckoutApi", "isSubChoicesApi", "isVendorMenuV2Api", "isVendorMenuV4Api", "isVendorPreSearchApi", "isVendorV2SearchApi", "isVendorV3SearchApi", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApiCallsMockChannelCallbackImpl implements ApiCallsMockChannelCallback {
    @NotNull
    private static final Regex BRANCH_INFO_API = new Regex(".*/v3/branch/");
    @NotNull
    private static final Regex CART_API = new Regex(".*/cart/v1");
    @NotNull
    private static final Regex CART_APPLY_VOUCHER_API = new Regex(".*/cart/v1/(\\d+)/applyVoucher/.*");
    @NotNull
    private static final Regex CHECKOUT_API = new Regex(".*/ccx/v1/checkout/123");
    @NotNull
    private static final Regex CHECKOUT_PLACE_ORDER_API = new Regex(".*/ccx/v1/checkout/123/placeOrder");
    @NotNull
    private static final Regex CHOICES_API = new Regex(".*/v2/branches/(\\d+)/menu/(\\d+)/choices");
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FLOWER_TEST = "Flower";
    @NotNull
    private static final String FOOD_TEST = "Food";
    @NotNull
    private static final Regex MAKE_PAY_API = new Regex(".*/pay/v1/payments");
    @NotNull
    private static final String MENU_REWRITE = "MenuRewrite";
    @NotNull
    private static final String MORE_TEST = "More";
    @NotNull
    private static final String NESTED_PRODUCT_SEARCH_API = "/v2/product/aggregation";
    @NotNull
    private static final String NO_RESULTS = "No Results";
    @NotNull
    private static final Regex PAY_OPTIONS_API = new Regex(".*/pay/v2/payments*");
    @NotNull
    private static final String PHARMACY_TEST = "Pharmacy";
    @NotNull
    private static final String PRODUCT_SEARCH_API = "/v2/product";
    @NotNull
    private static final Regex RAF_CODE_API = new Regex(".*/api/v1/referrals/referral-code/");
    @NotNull
    private static final Regex RAF_CODE_CAMPAIGN_INFO_API = new Regex(".*/api/v1/referrals/campaigns/");
    @NotNull
    private static final Regex REVIEW_API = new Regex(".*/v1/branches/(\\d+)/reviews/1");
    @NotNull
    private static final String SEARCH_VENDOR_API = "qcommerce/search/api/v1/vendor";
    @NotNull
    private static final String SEARCH_VENDOR_PRODUCTS_API = "qcommerce/search/api/v1/vendor-products";
    @NotNull
    private static final Regex SHOULD_NAVIGATE_TO_FLUTTER_CART = new Regex(".*/cartRouter/v(\\d)/shouldNavigateToFlutterCart");
    @NotNull
    private static final Regex SHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT = new Regex(".*/ccx/v1/router/shouldNavigateToFlutterCheckout");
    @NotNull
    private static final Regex SUB_CHOICES_API = new Regex(".*/v2/subchoices");
    @NotNull
    private static final Regex VEDNOR_CARD_BIN_OFFERS = new Regex(".*/v1/cardbin/binOffers/");
    @NotNull
    private static final Regex VEDNOR_MENU_API = new Regex(".*/v2/branches/(\\d+)/menu/");
    @NotNull
    private static final Regex VEDNOR_MENU_V4_API = new Regex(".*/v(\\d+)/branches/(\\d+)/menu");
    @NotNull
    private static final String VENDOR_PRE_SEARCH_API = "/restaurantapi/v1/presearchrestaurants";
    @NotNull
    private static final String VENDOR_SEARCH_V2_API = "/v2/vendor";
    @NotNull
    private static final String VENDOR_SEARCH_V3_API = "/v3/vendor";
    @NotNull
    private static final String VENDOR_STATUS = "vendors/status?vendorid=505549";
    /* access modifiers changed from: private */
    @NotNull
    public static List<String> sourceTagNames = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    @NotNull
    public static String testCaseTags = "";
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/apicallmocks/ApiCallsMockChannelCallbackImpl$Companion;", "", "()V", "BRANCH_INFO_API", "Lkotlin/text/Regex;", "CART_API", "CART_APPLY_VOUCHER_API", "CHECKOUT_API", "CHECKOUT_PLACE_ORDER_API", "CHOICES_API", "FLOWER_TEST", "", "FOOD_TEST", "MAKE_PAY_API", "MENU_REWRITE", "MORE_TEST", "NESTED_PRODUCT_SEARCH_API", "NO_RESULTS", "PAY_OPTIONS_API", "PHARMACY_TEST", "PRODUCT_SEARCH_API", "RAF_CODE_API", "RAF_CODE_CAMPAIGN_INFO_API", "REVIEW_API", "SEARCH_VENDOR_API", "SEARCH_VENDOR_PRODUCTS_API", "SHOULD_NAVIGATE_TO_FLUTTER_CART", "SHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT", "SUB_CHOICES_API", "VEDNOR_CARD_BIN_OFFERS", "VEDNOR_MENU_API", "VEDNOR_MENU_V4_API", "VENDOR_PRE_SEARCH_API", "VENDOR_SEARCH_V2_API", "VENDOR_SEARCH_V3_API", "VENDOR_STATUS", "sourceTagNames", "", "getSourceTagNames", "()Ljava/util/List;", "setSourceTagNames", "(Ljava/util/List;)V", "testCaseTags", "getTestCaseTags", "()Ljava/lang/String;", "setTestCaseTags", "(Ljava/lang/String;)V", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> getSourceTagNames() {
            return ApiCallsMockChannelCallbackImpl.sourceTagNames;
        }

        @NotNull
        public final String getTestCaseTags() {
            return ApiCallsMockChannelCallbackImpl.testCaseTags;
        }

        public final void setSourceTagNames(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            ApiCallsMockChannelCallbackImpl.sourceTagNames = list;
        }

        public final void setTestCaseTags(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ApiCallsMockChannelCallbackImpl.testCaseTags = str;
        }
    }

    @Inject
    public ApiCallsMockChannelCallbackImpl(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final String getBranchInfoApiSupportedDuplicateResponse() {
        return getJson("oe_branch_info_preorder_supported_duplicate.json");
    }

    private final String getBranchInfoApiSupportedResponse() {
        return getJson("oe_branch_info_preorder_supported.json");
    }

    private final String getCartApiResponse() {
        if (StringsKt__StringsKt.contains$default((CharSequence) testCaseTags, (CharSequence) "@VoucherFlutterCart", false, 2, (Object) null)) {
            return getJson("voucher_flutter_cart_possible_voucher.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) testCaseTags, (CharSequence) "@FlutterCheckoutSwimlane", false, 2, (Object) null)) {
            return getJson("oe_cart_swimlane.json");
        }
        return getJson("oe_cart_p0.json");
    }

    private final String getCartApplyVoucherApiResponse() {
        if (StringsKt__StringsKt.contains$default((CharSequence) testCaseTags, (CharSequence) "@VoucherFlutterCart", false, 2, (Object) null)) {
            return getJson("voucher_flutter_cart_possible_voucher_applied.json");
        }
        return getJson("voucher_cart_possible_voucher_applied.json");
    }

    private final String getCheckoutApiResponse() {
        if (StringsKt__StringsKt.contains$default((CharSequence) testCaseTags, (CharSequence) "@VoucherFlutterCart", false, 2, (Object) null)) {
            return getJson("voucher_checkout_voucher_applied.json");
        }
        return getJson("oe_checkout_p0.json");
    }

    private final String getCheckoutPlaceOrderApiResponse() {
        return getJson("oe_checkout_place_order_p0.json");
    }

    private final String getChoicesApiResponse() {
        return getJson("oe_choices_p0.json");
    }

    private final String getJson(String str) {
        String simpleName = ApiCallsMockChannelCallbackImpl.class.getSimpleName();
        Log.i(simpleName, "getJson:path: " + str);
        AssetManager assets = this.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return readAssetsFile(assets, str);
    }

    private final String getMayPayApiResponse() {
        return getJson("oe_make_payment_p0.json");
    }

    private final String getNestedProductResponse() {
        return getJson("flutterSearch/groceryHomeSearch_searchNestedProducts.json");
    }

    private final String getPayOptionsApiResponse() {
        return getJson("oe_payment_options_p0.json");
    }

    private final String getProductResponse() {
        String str = testCaseTags;
        if (Intrinsics.areEqual((Object) str, (Object) "Food")) {
            return getJson("flutterSearch/homeFoodItemSearch_searchProducts.json");
        }
        if (Intrinsics.areEqual((Object) str, (Object) "No Results")) {
            return getJson("flutterSearch/homeFoodSearch_noResults.json");
        }
        return getJson("flutterSearch/homeGrocerySearch_searchProducts.json");
    }

    private final String getReferralCampaignsApiResponse() {
        return getJson("referral_campaigns.json");
    }

    private final String getReferralCodeApiResponse() {
        return getJson("referral_code.json");
    }

    private final String getReviewApiResponse() {
        return getJson("vendor-review-api-response.json");
    }

    private final String getSearchVendorProductsResponse() {
        return getJson("flutterSearch/home-grocery-search-vendor-product.json");
    }

    private final String getSearchVendorResponse() {
        return getJson("flutterSearch/home-grocery-search-vendor.json");
    }

    private final String getSubChoicesApiResponse() {
        return getJson("oe_choices_p0_third_level.json");
    }

    private final String getVendorMenuApiV2Response() {
        return getJson("oe_menu_without_choice_v2.json");
    }

    private final String getVendorMenuApiV4Response() {
        return getJson("oe_menu_without_choice.json");
    }

    private final String getVendorPreSearchResponse() {
        return getJson("flutterSearch/homeFoodSearch_presearchResults.json");
    }

    private final String getVendorV2Response() {
        String str = testCaseTags;
        switch (str.hashCode()) {
            case -1612338989:
                if (str.equals("Pharmacy")) {
                    return getJson("flutterSearch/homePharmacySearch_searchVendors.json");
                }
                break;
            case -34643187:
                if (str.equals("MenuRewrite")) {
                    return getJson("flutterSearch/homeFoodSearchMenuRewrite_searchResults.json");
                }
                break;
            case 2195582:
                if (str.equals("Food")) {
                    return getJson("flutterSearch/homeFoodSearch_searchResults.json");
                }
                break;
            case 2404213:
                if (str.equals("More")) {
                    return getJson("flutterSearch/homeMoreSearch_searchVendors.json");
                }
                break;
            case 1490421911:
                if (str.equals("No Results")) {
                    return getJson("flutterSearch/homeFoodSearch_noResults.json");
                }
                break;
            case 2107205243:
                if (str.equals("Flower")) {
                    return getJson("flutterSearch/homeFlowerSearch_searchVendors.json");
                }
                break;
        }
        return getJson("flutterSearch/homeGrocerySearch_searchVendors.json");
    }

    private final String getVendorV3Response() {
        String str = testCaseTags;
        switch (str.hashCode()) {
            case -1612338989:
                if (str.equals("Pharmacy")) {
                    return getJson("flutterSearch/vendors_v3/homePharmacySearch_searchVendors_v3.json");
                }
                break;
            case -34643187:
                if (str.equals("MenuRewrite")) {
                    return getJson("flutterSearch/vendors_v3/homeFoodSearchMenuRewrite_searchResults_v3.json");
                }
                break;
            case 2195582:
                if (str.equals("Food")) {
                    return getJson("flutterSearch/vendors_v3/homeFoodSearch_searchResults_v3.json");
                }
                break;
            case 2404213:
                if (str.equals("More")) {
                    return getJson("flutterSearch/vendors_v3/homeMoreSearch_searchVendors_v3.json");
                }
                break;
            case 1490421911:
                if (str.equals("No Results")) {
                    return getJson("flutterSearch/homeFoodSearch_noResults.json");
                }
                break;
            case 2107205243:
                if (str.equals("Flower")) {
                    return getJson("flutterSearch/vendors_v3/homeFlowerSearch_searchVendors_v3.json");
                }
                break;
        }
        return getJson("flutterSearch/vendors_v3/homeGrocerySearch_searchVendors_v3.json");
    }

    private final boolean isBranchIdInfoApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "505549/info", false, 2, (Object) null);
    }

    private final boolean isBranchInfoV3Api(String str) {
        return BRANCH_INFO_API.containsMatchIn(str);
    }

    private final boolean isCartApi(String str) {
        return CART_API.containsMatchIn(str);
    }

    private final boolean isCartApplyVoucherApi(String str) {
        return CART_APPLY_VOUCHER_API.containsMatchIn(str);
    }

    private final boolean isCheckoutApi(String str) {
        return CHECKOUT_API.containsMatchIn(str) && sourceTagNames.contains("@FlutterCheckout");
    }

    private final boolean isCheckoutPlaceOrderApi(String str) {
        return CHECKOUT_PLACE_ORDER_API.containsMatchIn(str) && sourceTagNames.contains("@FlutterCheckout");
    }

    private final boolean isChoicesApi(String str) {
        return CHOICES_API.containsMatchIn(str);
    }

    private final boolean isMakePayApi(String str) {
        return MAKE_PAY_API.containsMatchIn(str) && sourceTagNames.contains("@FlutterCheckout");
    }

    private final boolean isNestedProductSearchApi(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, NESTED_PRODUCT_SEARCH_API, false, 2, (Object) null);
    }

    private final boolean isPayOptionsApi(String str) {
        return PAY_OPTIONS_API.containsMatchIn(str);
    }

    private final boolean isProductSearchApi(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, PRODUCT_SEARCH_API, false, 2, (Object) null);
    }

    private final boolean isReferralCampaignsApi(String str) {
        return RAF_CODE_CAMPAIGN_INFO_API.containsMatchIn(str);
    }

    private final boolean isReferralCodeApi(String str) {
        return RAF_CODE_API.containsMatchIn(str);
    }

    private final boolean isReviewApi(String str) {
        return REVIEW_API.containsMatchIn(str);
    }

    private final boolean isSearchVendorApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) SEARCH_VENDOR_API, false, 2, (Object) null);
    }

    private final boolean isSearchVendorProductApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) SEARCH_VENDOR_PRODUCTS_API, false, 2, (Object) null);
    }

    private final boolean isShouldNavigateFlutterCartApi(String str) {
        return SHOULD_NAVIGATE_TO_FLUTTER_CART.containsMatchIn(str);
    }

    private final boolean isShouldNavigateFlutterCheckoutApi(String str) {
        return SHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT.containsMatchIn(str) && sourceTagNames.contains("@FlutterCheckout");
    }

    private final boolean isSubChoicesApi(String str) {
        return SUB_CHOICES_API.containsMatchIn(str);
    }

    private final boolean isVendorMenuV2Api(String str) {
        return VEDNOR_MENU_API.containsMatchIn(str);
    }

    private final boolean isVendorMenuV4Api(String str) {
        return VEDNOR_MENU_V4_API.containsMatchIn(str);
    }

    private final boolean isVendorPreSearchApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) VENDOR_PRE_SEARCH_API, false, 2, (Object) null);
    }

    private final boolean isVendorV2SearchApi(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, VENDOR_SEARCH_V2_API, false, 2, (Object) null);
    }

    private final boolean isVendorV3SearchApi(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, VENDOR_SEARCH_V3_API, false, 2, (Object) null);
    }

    private final String mockResponse(String str) {
        if (isReferralCodeApi(str)) {
            return getReferralCodeApiResponse();
        }
        if (isReferralCampaignsApi(str)) {
            return getReferralCampaignsApiResponse();
        }
        if (isPayOptionsApi(str)) {
            return getPayOptionsApiResponse();
        }
        if (isReviewApi(str)) {
            return getReviewApiResponse();
        }
        if (isChoicesApi(str)) {
            return getChoicesApiResponse();
        }
        if (isCartApi(str)) {
            return getCartApiResponse();
        }
        if (isSubChoicesApi(str)) {
            return getSubChoicesApiResponse();
        }
        if (isBranchIdInfoApi(str)) {
            return getBranchInfoApiSupportedDuplicateResponse();
        }
        if (isBranchInfoV3Api(str)) {
            return getBranchInfoApiSupportedResponse();
        }
        if (isVendorMenuV2Api(str)) {
            return getVendorMenuApiV2Response();
        }
        if (isVendorMenuV4Api(str)) {
            return getVendorMenuApiV4Response();
        }
        if (isCartApplyVoucherApi(str)) {
            return getCartApplyVoucherApiResponse();
        }
        if (isShouldNavigateFlutterCartApi(str)) {
            return shouldNavigateToFlutterCartApiResponse();
        }
        if (isShouldNavigateFlutterCheckoutApi(str)) {
            return shouldNavigateToFlutterCheckoutApiResponse();
        }
        if (isMakePayApi(str)) {
            return getMayPayApiResponse();
        }
        if (isCheckoutPlaceOrderApi(str)) {
            return getCheckoutPlaceOrderApiResponse();
        }
        if (isCheckoutApi(str)) {
            return getCheckoutApiResponse();
        }
        if (isVendorV2SearchApi(str)) {
            return getVendorV2Response();
        }
        if (isVendorV3SearchApi(str)) {
            return getVendorV3Response();
        }
        if (isProductSearchApi(str)) {
            return getProductResponse();
        }
        if (isNestedProductSearchApi(str)) {
            return getNestedProductResponse();
        }
        if (isVendorPreSearchApi(str)) {
            return getVendorPreSearchResponse();
        }
        if (isSearchVendorApi(str)) {
            return getSearchVendorResponse();
        }
        if (isSearchVendorProductApi(str)) {
            return getSearchVendorProductsResponse();
        }
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readAssetsFile(android.content.res.AssetManager r2, java.lang.String r3) {
        /*
            r1 = this;
            java.io.InputStream r2 = r2.open(r3)
            java.lang.String r3 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0017
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x001f
        L_0x0017:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x001f:
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0028 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return r2
        L_0x0028:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.apicallmocks.ApiCallsMockChannelCallbackImpl.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    private final String shouldNavigateToFlutterCartApiResponse() {
        if (sourceTagNames.contains("@FlutterCart")) {
            return getJson("enable_cart_bff.json");
        }
        return "";
    }

    private final String shouldNavigateToFlutterCheckoutApiResponse() {
        return getJson("enable_checkout_bff.json");
    }

    public void handleRequest(@NotNull String str, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        String simpleName = ApiCallsMockChannelCallbackImpl.class.getSimpleName();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("tags: %s\t tag: %s\t url: %s", Arrays.copyOf(new Object[]{sourceTagNames, testCaseTags, str}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        Log.i(simpleName, format);
        result.success(mockResponse(str));
    }
}
