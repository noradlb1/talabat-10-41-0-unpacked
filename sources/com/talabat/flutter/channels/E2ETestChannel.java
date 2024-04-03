package com.talabat.flutter.channels;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.core.app.NotificationCompat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010\u001c\u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010\u001d\u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010\u001e\u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010\u001f\u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010 \u001a\u00020\u001a*\u00020\u0003H\u0002J\f\u0010!\u001a\u00020\u001a*\u00020\u0003H\u0002J\u0014\u0010\"\u001a\u00020\u0003*\u00020#2\u0006\u0010$\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/flutter/channels/E2ETestChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "testName", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "getJson", "path", "getMockResponse", "url", "getNestedProductResponse", "getProductResponse", "getVendorPreSearchResponse", "getVendorV2Response", "getVendorV3Response", "handleGetRequests", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handlePostRequests", "handleRequest", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "isNestedProductSearch", "", "isProductSearch", "isSearchAutoCompleteApi", "isSearchVendorApi", "isSearchVendorProductApi", "isVendorPreSearch", "isVendorV2Search", "isVendorV3Search", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class E2ETestChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String FLOWER_TEST = "Flower";
    @NotNull
    public static final String FOOD_TEST = "Food";
    @NotNull
    public static final String GROCERY_HOME_SEARCH_TEST_NAME = "GroceryHomeSearch";
    @NotNull
    public static final String MENU_REWRITE = "MenuRewrite";
    @NotNull
    public static final String MORE_TEST = "More";
    @NotNull
    public static final String NO_RESULTS = "No Results";
    @NotNull
    public static final String PHARMACY_TEST = "Pharmacy";
    @NotNull
    private final Context context;
    @NotNull
    private final String testName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/flutter/channels/E2ETestChannel$Companion;", "", "()V", "FLOWER_TEST", "", "FOOD_TEST", "GROCERY_HOME_SEARCH_TEST_NAME", "MENU_REWRITE", "MORE_TEST", "NO_RESULTS", "PHARMACY_TEST", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public E2ETestChannel(@NotNull String str, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(str, "testName");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.testName = str;
        this.context = context2;
    }

    private final String getJson(String str) {
        AssetManager assets = this.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return readAssetsFile(assets, str);
    }

    private final String getMockResponse(String str) {
        if (isVendorV2Search(str)) {
            return getVendorV2Response();
        }
        if (isVendorV3Search(str)) {
            return getVendorV3Response();
        }
        if (isProductSearch(str)) {
            return getProductResponse();
        }
        if (isNestedProductSearch(str)) {
            return getNestedProductResponse();
        }
        if (isVendorPreSearch(str)) {
            return getVendorPreSearchResponse();
        }
        if (isSearchAutoCompleteApi(str)) {
            return "flutterSearch/home-grocery-search-autocomplete.json";
        }
        if (isSearchVendorApi(str)) {
            return "flutterSearch/home-grocery-search-vendor.json";
        }
        if (isSearchVendorProductApi(str)) {
            return "flutterSearch/home-grocery-search-vendor-product.json";
        }
        return null;
    }

    private final String getNestedProductResponse() {
        return "flutterSearch/groceryHomeSearch_searchNestedProducts.json";
    }

    private final String getProductResponse() {
        String str = this.testName;
        if (Intrinsics.areEqual((Object) str, (Object) FOOD_TEST)) {
            return "flutterSearch/homeFoodItemSearch_searchProducts.json";
        }
        if (Intrinsics.areEqual((Object) str, (Object) NO_RESULTS)) {
            return "flutterSearch/homeFoodSearch_noResults.json";
        }
        return "flutterSearch/homeGrocerySearch_searchProducts.json";
    }

    private final String getVendorPreSearchResponse() {
        return "flutterSearch/homeFoodSearch_presearchResults.json";
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getVendorV2Response() {
        /*
            r2 = this;
            java.lang.String r0 = r2.testName
            int r1 = r0.hashCode()
            switch(r1) {
                case -1612338989: goto L_0x0045;
                case -34643187: goto L_0x0039;
                case 2195582: goto L_0x002e;
                case 2404213: goto L_0x0022;
                case 1490421911: goto L_0x0016;
                case 2107205243: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0051
        L_0x000a:
            java.lang.String r1 = "Flower"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0013
            goto L_0x0051
        L_0x0013:
            java.lang.String r0 = "flutterSearch/homeFlowerSearch_searchVendors.json"
            goto L_0x0053
        L_0x0016:
            java.lang.String r1 = "No Results"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001f
            goto L_0x0051
        L_0x001f:
            java.lang.String r0 = "flutterSearch/homeFoodSearch_noResults.json"
            goto L_0x0053
        L_0x0022:
            java.lang.String r1 = "More"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002b
            goto L_0x0051
        L_0x002b:
            java.lang.String r0 = "flutterSearch/homeMoreSearch_searchVendors.json"
            goto L_0x0053
        L_0x002e:
            java.lang.String r1 = "Food"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = "flutterSearch/homeFoodSearch_searchResults.json"
            goto L_0x0053
        L_0x0039:
            java.lang.String r1 = "MenuRewrite"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0051
        L_0x0042:
            java.lang.String r0 = "flutterSearch/homeFoodSearchMenuRewrite_searchResults.json"
            goto L_0x0053
        L_0x0045:
            java.lang.String r1 = "Pharmacy"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            java.lang.String r0 = "flutterSearch/homePharmacySearch_searchVendors.json"
            goto L_0x0053
        L_0x0051:
            java.lang.String r0 = "flutterSearch/homeGrocerySearch_searchVendors.json"
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.flutter.channels.E2ETestChannel.getVendorV2Response():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getVendorV3Response() {
        /*
            r2 = this;
            java.lang.String r0 = r2.testName
            int r1 = r0.hashCode()
            switch(r1) {
                case -1612338989: goto L_0x0045;
                case -34643187: goto L_0x0039;
                case 2195582: goto L_0x002e;
                case 2404213: goto L_0x0022;
                case 1490421911: goto L_0x0016;
                case 2107205243: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0051
        L_0x000a:
            java.lang.String r1 = "Flower"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0013
            goto L_0x0051
        L_0x0013:
            java.lang.String r0 = "flutterSearch/vendors_v3/homeFlowerSearch_searchVendors_v3.json"
            goto L_0x0053
        L_0x0016:
            java.lang.String r1 = "No Results"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001f
            goto L_0x0051
        L_0x001f:
            java.lang.String r0 = "flutterSearch/homeFoodSearch_noResults.json"
            goto L_0x0053
        L_0x0022:
            java.lang.String r1 = "More"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002b
            goto L_0x0051
        L_0x002b:
            java.lang.String r0 = "flutterSearch/vendors_v3/homeMoreSearch_searchVendors_v3.json"
            goto L_0x0053
        L_0x002e:
            java.lang.String r1 = "Food"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = "flutterSearch/vendors_v3/homeFoodSearch_searchResults_v3.json"
            goto L_0x0053
        L_0x0039:
            java.lang.String r1 = "MenuRewrite"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0051
        L_0x0042:
            java.lang.String r0 = "flutterSearch/vendors_v3/homeFoodSearchMenuRewrite_searchResults_v3.json"
            goto L_0x0053
        L_0x0045:
            java.lang.String r1 = "Pharmacy"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            java.lang.String r0 = "flutterSearch/vendors_v3/homePharmacySearch_searchVendors_v3.json"
            goto L_0x0053
        L_0x0051:
            java.lang.String r0 = "flutterSearch/vendors_v3/homeGrocerySearch_searchVendors_v3.json"
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.flutter.channels.E2ETestChannel.getVendorV3Response():java.lang.String");
    }

    private final void handleGetRequests(String str, MethodChannel.Result result) {
        handleRequest(str, result);
    }

    private final void handlePostRequests(String str, MethodChannel.Result result) {
        handleRequest(str, result);
    }

    private final void handleRequest(String str, MethodChannel.Result result) {
        Unit unit;
        String mockResponse = getMockResponse(str);
        if (mockResponse != null) {
            result.success(getJson(mockResponse));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            result.error("404", "Not handled url: " + str, "");
        }
    }

    private final boolean isNestedProductSearch(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, "/v2/product/aggregation", false, 2, (Object) null);
    }

    private final boolean isProductSearch(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, "/v2/product", false, 2, (Object) null);
    }

    private final boolean isSearchAutoCompleteApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "api/v3/autocomplete", false, 2, (Object) null);
    }

    private final boolean isSearchVendorApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "qcommerce/search/api/v1/vendor", false, 2, (Object) null);
    }

    private final boolean isSearchVendorProductApi(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "qcommerce/search/api/v1/vendor-products", false, 2, (Object) null);
    }

    private final boolean isVendorPreSearch(String str) {
        return StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "/restaurantapi/v1/presearchrestaurants", false, 2, (Object) null);
    }

    private final boolean isVendorV2Search(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, "/v2/vendor", false, 2, (Object) null);
    }

    private final boolean isVendorV3Search(String str) {
        return StringsKt__StringsJVMKt.endsWith$default(str, "/v3/vendor", false, 2, (Object) null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.flutter.channels.E2ETestChannel.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = (String) methodCall.argument("url");
        if (str != null) {
            String str2 = methodCall.method;
            if (Intrinsics.areEqual((Object) str2, (Object) "localhostResponseForGETCall")) {
                handleGetRequests(str, result);
            } else if (Intrinsics.areEqual((Object) str2, (Object) "localhostResponseForPOSTCall")) {
                handlePostRequests(str, result);
            }
        }
    }
}
