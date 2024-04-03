package com.talabat.vendormenu.presentation.flutter.channels;

import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\"\u001a\u00020!*\u00020#2\u0006\u0010$\u001a\u00020!H\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0003\"\u000e\u0010 \u001a\u00020!XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"BRANCH_INFO_API", "Lkotlin/text/Regex;", "getBRANCH_INFO_API", "()Lkotlin/text/Regex;", "CART_API", "getCART_API", "CART_APPLY_VOUCHER_API", "getCART_APPLY_VOUCHER_API", "CHECKOUT_API", "getCHECKOUT_API", "CHECKOUT_PLACE_ORDER_API", "getCHECKOUT_PLACE_ORDER_API", "CHOICES_API", "getCHOICES_API", "MAKE_PAY_API", "getMAKE_PAY_API", "PAY_OPTIONS_API", "getPAY_OPTIONS_API", "REVIEW_API", "getREVIEW_API", "SHOULD_NAVIGATE_TO_FLUTTER_CART", "getSHOULD_NAVIGATE_TO_FLUTTER_CART", "SHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT", "getSHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT", "SUB_CHOICES_API", "getSUB_CHOICES_API", "VEDNOR_CARD_BIN_OFFERS", "getVEDNOR_CARD_BIN_OFFERS", "VEDNOR_MENU_API", "getVEDNOR_MENU_API", "VEDNOR_MENU_V4_API", "getVEDNOR_MENU_V4_API", "VENDOR_STATUS", "", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VendorFlutterApiCallsMethodChannelKt {
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
    private static final Regex MAKE_PAY_API = new Regex(".*/pay/v1/payments");
    @NotNull
    private static final Regex PAY_OPTIONS_API = new Regex(".*/pay/v2/payments*");
    @NotNull
    private static final Regex REVIEW_API = new Regex(".*/v1/branches/(\\d+)/reviews/1");
    @NotNull
    private static final Regex SHOULD_NAVIGATE_TO_FLUTTER_CART = new Regex(".*/cartRouter/v(\\d)/shouldNavigateToFlutterCart");
    @NotNull
    private static final Regex SHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT = new Regex(".*/ccx/v1/router/shouldNavigateToFlutterCheckout");
    @NotNull
    private static final Regex SUB_CHOICES_API = new Regex(".*/v2/subchoices");
    @NotNull
    private static final Regex VEDNOR_CARD_BIN_OFFERS = new Regex(".*/v1/cardbin/binOffers/");
    @NotNull
    private static final Regex VEDNOR_MENU_API = new Regex(".*/v2/branches/(\\d+)/menu");
    @NotNull
    private static final Regex VEDNOR_MENU_V4_API = new Regex(".*/v(\\d+)/branches/(\\d+)/menu");
    @NotNull
    public static final String VENDOR_STATUS = "vendors/status?vendorid=505550";

    @NotNull
    public static final Regex getBRANCH_INFO_API() {
        return BRANCH_INFO_API;
    }

    @NotNull
    public static final Regex getCART_API() {
        return CART_API;
    }

    @NotNull
    public static final Regex getCART_APPLY_VOUCHER_API() {
        return CART_APPLY_VOUCHER_API;
    }

    @NotNull
    public static final Regex getCHECKOUT_API() {
        return CHECKOUT_API;
    }

    @NotNull
    public static final Regex getCHECKOUT_PLACE_ORDER_API() {
        return CHECKOUT_PLACE_ORDER_API;
    }

    @NotNull
    public static final Regex getCHOICES_API() {
        return CHOICES_API;
    }

    @NotNull
    public static final Regex getMAKE_PAY_API() {
        return MAKE_PAY_API;
    }

    @NotNull
    public static final Regex getPAY_OPTIONS_API() {
        return PAY_OPTIONS_API;
    }

    @NotNull
    public static final Regex getREVIEW_API() {
        return REVIEW_API;
    }

    @NotNull
    public static final Regex getSHOULD_NAVIGATE_TO_FLUTTER_CART() {
        return SHOULD_NAVIGATE_TO_FLUTTER_CART;
    }

    @NotNull
    public static final Regex getSHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT() {
        return SHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT;
    }

    @NotNull
    public static final Regex getSUB_CHOICES_API() {
        return SUB_CHOICES_API;
    }

    @NotNull
    public static final Regex getVEDNOR_CARD_BIN_OFFERS() {
        return VEDNOR_CARD_BIN_OFFERS;
    }

    @NotNull
    public static final Regex getVEDNOR_MENU_API() {
        return VEDNOR_MENU_API;
    }

    @NotNull
    public static final Regex getVEDNOR_MENU_V4_API() {
        return VEDNOR_MENU_V4_API;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readAssetsFile(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0017
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x001f
        L_0x0017:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x001f:
            java.lang.String r1 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0028 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return r1
        L_0x0028:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002a }
        L_0x002a:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }
}
