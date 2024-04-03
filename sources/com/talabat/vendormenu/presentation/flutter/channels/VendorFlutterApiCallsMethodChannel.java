package com.talabat.vendormenu.presentation.flutter.channels;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.core.app.NotificationCompat;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorFlutterApiCallsMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "testCaseTags", "", "isVendorBusy", "", "(Landroid/content/Context;Ljava/lang/String;Z)V", "localhostResponseForDELETECall", "localhostResponseForGETCall", "localhostResponseForPOSTCall", "localhostResponseForPUTCall", "checkCheckoutMockResponse", "url", "getCartResponse", "getJson", "path", "getVendorStatus", "handleGetRequests", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handlePostRequests", "mockResponse", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorFlutterApiCallsMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private final Context context;
    private final boolean isVendorBusy;
    @NotNull
    private final String localhostResponseForDELETECall;
    @NotNull
    private final String localhostResponseForGETCall;
    @NotNull
    private final String localhostResponseForPOSTCall;
    @NotNull
    private final String localhostResponseForPUTCall;
    @Nullable
    private final String testCaseTags;

    public VendorFlutterApiCallsMethodChannel(@NotNull Context context2, @Nullable String str, boolean z11) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.testCaseTags = str;
        this.isVendorBusy = z11;
        this.localhostResponseForGETCall = "localhostResponseForGETCall";
        this.localhostResponseForPOSTCall = "localhostResponseForPOSTCall";
        this.localhostResponseForPUTCall = "localhostResponseForPUTCall";
        this.localhostResponseForDELETECall = "localhostResponseForDELETECall";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) "@FlutterCheckout", false, 2, (java.lang.Object) null) == true) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String checkCheckoutMockResponse(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.testCaseTags
            r1 = 0
            r2 = 2
            r3 = 0
            if (r0 == 0) goto L_0x0011
            java.lang.String r4 = "@FlutterCheckout"
            boolean r0 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r4, (boolean) r3, (int) r2, (java.lang.Object) r1)
            r4 = 1
            if (r0 != r4) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r4 = r3
        L_0x0012:
            java.lang.String r0 = ""
            if (r4 == 0) goto L_0x007b
            kotlin.text.Regex r4 = com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt.getSHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT()
            boolean r4 = r4.containsMatchIn(r6)
            if (r4 == 0) goto L_0x0027
            java.lang.String r6 = "enable_checkout_bff.json"
            java.lang.String r0 = r5.getJson(r6)
            goto L_0x007b
        L_0x0027:
            kotlin.text.Regex r4 = com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt.getPAY_OPTIONS_API()
            boolean r4 = r4.containsMatchIn(r6)
            if (r4 == 0) goto L_0x0038
            java.lang.String r6 = "oe_payment_options_p0.json"
            java.lang.String r0 = r5.getJson(r6)
            goto L_0x007b
        L_0x0038:
            kotlin.text.Regex r4 = com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt.getMAKE_PAY_API()
            boolean r4 = r4.containsMatchIn(r6)
            if (r4 == 0) goto L_0x0049
            java.lang.String r6 = "oe_make_payment_p0.json"
            java.lang.String r0 = r5.getJson(r6)
            goto L_0x007b
        L_0x0049:
            kotlin.text.Regex r4 = com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt.getCHECKOUT_PLACE_ORDER_API()
            boolean r4 = r4.containsMatchIn(r6)
            if (r4 == 0) goto L_0x005a
            java.lang.String r6 = "oe_checkout_place_order_p0.json"
            java.lang.String r0 = r5.getJson(r6)
            goto L_0x007b
        L_0x005a:
            kotlin.text.Regex r4 = com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt.getCHECKOUT_API()
            boolean r6 = r4.containsMatchIn(r6)
            if (r6 == 0) goto L_0x007b
            java.lang.String r6 = r5.testCaseTags
            java.lang.String r0 = "@VoucherFlutterCart"
            boolean r6 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) r0, (boolean) r3, (int) r2, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x0075
            java.lang.String r6 = "voucher_checkout_voucher_applied.json"
            java.lang.String r0 = r5.getJson(r6)
            goto L_0x007b
        L_0x0075:
            java.lang.String r6 = "oe_checkout_p0.json"
            java.lang.String r0 = r5.getJson(r6)
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannel.checkCheckoutMockResponse(java.lang.String):java.lang.String");
    }

    private final String getCartResponse() {
        boolean z11;
        String str = this.testCaseTags;
        boolean z12 = true;
        if (str == null || !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "@VoucherFlutterCart", false, 2, (Object) null)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return getJson("voucher_flutter_cart_possible_voucher.json");
        }
        String str2 = this.testCaseTags;
        if (str2 == null || !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "@FlutterCheckoutSwimlane", false, 2, (Object) null)) {
            z12 = false;
        }
        if (z12) {
            return getJson("oe_cart_swimlane.json");
        }
        return getJson("oe_cart_p0.json");
    }

    private final String getJson(String str) {
        AssetManager assets = this.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return VendorFlutterApiCallsMethodChannelKt.readAssetsFile(assets, str);
    }

    private final String getVendorStatus() {
        if (this.isVendorBusy) {
            return getJson("oe_busy_status.json");
        }
        return "";
    }

    private final void handleGetRequests(String str, MethodChannel.Result result) {
        LogManager.debug("handleGetRequests Url: " + str);
        String mockResponse = mockResponse(str);
        LogManager.debug("handleGetRequests response: " + mockResponse);
        result.success(mockResponse);
    }

    private final void handlePostRequests(String str, MethodChannel.Result result) {
        LogManager.debug("handlePostRequests Url: " + str);
        String mockResponse = mockResponse(str);
        LogManager.debug("handlePostRequests response: " + mockResponse);
        result.success(mockResponse);
    }

    private final String mockResponse(String str) {
        boolean z11 = true;
        if (VendorFlutterApiCallsMethodChannelKt.getCART_APPLY_VOUCHER_API().containsMatchIn(str)) {
            String str2 = this.testCaseTags;
            if (str2 == null || !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "@VoucherFlutterCart", false, 2, (Object) null)) {
                z11 = false;
            }
            if (z11) {
                return getJson("voucher_flutter_cart_possible_voucher_applied.json");
            }
            return getJson("voucher_cart_possible_voucher_applied.json");
        } else if (VendorFlutterApiCallsMethodChannelKt.getREVIEW_API().containsMatchIn(str)) {
            return getJson("vendor-review-api-response.json");
        } else {
            if (VendorFlutterApiCallsMethodChannelKt.getCHOICES_API().containsMatchIn(str)) {
                return getJson("oe_choices_p0.json");
            }
            if (VendorFlutterApiCallsMethodChannelKt.getCART_API().containsMatchIn(str)) {
                return getCartResponse();
            }
            if (VendorFlutterApiCallsMethodChannelKt.getSUB_CHOICES_API().containsMatchIn(str)) {
                return getJson("oe_choices_p0_third_level.json");
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "505549/info", false, 2, (Object) null)) {
                return getJson("oe_branch_info_preorder_supported_duplicate.json");
            }
            if (VendorFlutterApiCallsMethodChannelKt.getBRANCH_INFO_API().containsMatchIn(str)) {
                return getJson("oe_branch_info_preorder_supported.json");
            }
            if (VendorFlutterApiCallsMethodChannelKt.getVEDNOR_MENU_API().containsMatchIn(str)) {
                return getJson("oe_menu_without_choice_v2.json");
            }
            if (VendorFlutterApiCallsMethodChannelKt.getVEDNOR_MENU_V4_API().containsMatchIn(str)) {
                return getJson("oe_menu_without_choice.json");
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) VendorFlutterApiCallsMethodChannelKt.VENDOR_STATUS, false, 2, (Object) null)) {
                return getVendorStatus();
            }
            if (!VendorFlutterApiCallsMethodChannelKt.getVEDNOR_CARD_BIN_OFFERS().containsMatchIn(str)) {
                if (!VendorFlutterApiCallsMethodChannelKt.getSHOULD_NAVIGATE_TO_FLUTTER_CART().containsMatchIn(str)) {
                    return checkCheckoutMockResponse(str);
                }
                String str3 = this.testCaseTags;
                if (str3 == null || !StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "@FlutterCart", false, 2, (Object) null)) {
                    z11 = false;
                }
                if (z11) {
                    return getJson("enable_cart_bff.json");
                }
            }
            return "";
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = (String) methodCall.argument("url");
        if (str == null) {
            str = "";
        }
        String str2 = methodCall.method;
        if (Intrinsics.areEqual((Object) str2, (Object) this.localhostResponseForGETCall)) {
            handleGetRequests(str, result);
        } else if (Intrinsics.areEqual((Object) str2, (Object) this.localhostResponseForPOSTCall)) {
            handlePostRequests(str, result);
        } else if (Intrinsics.areEqual((Object) str2, (Object) this.localhostResponseForPUTCall)) {
            handlePostRequests(str, result);
        } else if (Intrinsics.areEqual((Object) str2, (Object) this.localhostResponseForDELETECall)) {
            handlePostRequests(str, result);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorFlutterApiCallsMethodChannel(Context context2, String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? true : z11);
    }
}
