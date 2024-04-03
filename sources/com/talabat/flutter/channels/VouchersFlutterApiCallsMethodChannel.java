package com.talabat.flutter.channels;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.core.app.NotificationCompat;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.vendormenu.presentation.flutter.channels.VendorFlutterApiCallsMethodChannelKt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/flutter/channels/VouchersFlutterApiCallsMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "testCaseTags", "", "(Landroid/content/Context;Ljava/lang/String;)V", "localhostResponseForDELETECall", "localhostResponseForGETCall", "localhostResponseForPOSTCall", "localhostResponseForPUTCall", "checkCheckoutMockResponse", "url", "getJson", "path", "getProtocol", "call", "Lio/flutter/plugin/common/MethodCall;", "mockResponse", "onMethodCall", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersFlutterApiCallsMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private final Context context;
    @NotNull
    private final String localhostResponseForDELETECall = "localhostResponseForDELETECall";
    @NotNull
    private final String localhostResponseForGETCall = "localhostResponseForGETCall";
    @NotNull
    private final String localhostResponseForPOSTCall = "localhostResponseForPOSTCall";
    @NotNull
    private final String localhostResponseForPUTCall = "localhostResponseForPUTCall";
    @NotNull
    private final String testCaseTags;

    public VouchersFlutterApiCallsMethodChannel(@NotNull Context context2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "testCaseTags");
        this.context = context2;
        this.testCaseTags = str;
    }

    private final String checkCheckoutMockResponse(String str) {
        if (!StringsKt__StringsKt.contains$default((CharSequence) this.testCaseTags, (CharSequence) "@FlutterCheckout", false, 2, (Object) null)) {
            return "";
        }
        if (VendorFlutterApiCallsMethodChannelKt.getSHOULD_NAVIGATE_TO_FLUTTER_CHECKOUT().containsMatchIn(str)) {
            return getJson("enable_checkout_bff.json");
        }
        if (VendorFlutterApiCallsMethodChannelKt.getPAY_OPTIONS_API().containsMatchIn(str)) {
            return getJson("oe_payment_options_p0.json");
        }
        if (VendorFlutterApiCallsMethodChannelKt.getMAKE_PAY_API().containsMatchIn(str)) {
            return getJson("oe_make_payment_p0.json");
        }
        if (VendorFlutterApiCallsMethodChannelKt.getCHECKOUT_PLACE_ORDER_API().containsMatchIn(str)) {
            return getJson("oe_checkout_place_order_p0.json");
        }
        if (VendorFlutterApiCallsMethodChannelKt.getCHECKOUT_API().containsMatchIn(str)) {
            return getJson("oe_checkout_p0.json");
        }
        return "";
    }

    private final String getJson(String str) {
        AssetManager assets = this.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return VouchersFlutterApiCallsMethodChannelKt.readAssetsFile(assets, str);
    }

    private final String getProtocol(MethodCall methodCall) {
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) this.localhostResponseForGETCall)) {
            return "handleGetRequests";
        }
        if (Intrinsics.areEqual((Object) str, (Object) this.localhostResponseForPOSTCall)) {
            return "handlePostRequests";
        }
        if (Intrinsics.areEqual((Object) str, (Object) this.localhostResponseForPUTCall)) {
            return "handlePutRequests";
        }
        if (Intrinsics.areEqual((Object) str, (Object) this.localhostResponseForDELETECall)) {
            return "handleDeleteRequests";
        }
        return "Request Protocol not handle";
    }

    private final String mockResponse(String str) {
        if (VendorFlutterApiCallsMethodChannelKt.getREVIEW_API().containsMatchIn(str)) {
            return getJson("vendor-review-api-response.json");
        }
        if (VendorFlutterApiCallsMethodChannelKt.getCHOICES_API().containsMatchIn(str)) {
            return getJson("oe_choices_p0.json");
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
        if (VendorFlutterApiCallsMethodChannelKt.getVEDNOR_CARD_BIN_OFFERS().containsMatchIn(str)) {
            return "";
        }
        if (VouchersFlutterApiCallsMethodChannelKt.getCART_APPLY_VOUCHER_API().containsMatchIn(str)) {
            return getJson("voucher_cart_possible_voucher_applied.json");
        }
        if (VendorFlutterApiCallsMethodChannelKt.getCART_API().containsMatchIn(str)) {
            if (StringsKt__StringsKt.contains$default((CharSequence) this.testCaseTags, (CharSequence) "@PickupVoucher", false, 2, (Object) null)) {
                return getJson("voucher_cart_pickup_voucher.json");
            }
            return getJson("voucher_cart_possible_voucher.json");
        } else if (VendorFlutterApiCallsMethodChannelKt.getSHOULD_NAVIGATE_TO_FLUTTER_CART().containsMatchIn(str)) {
            return getJson("enable_cart_bff.json");
        } else {
            return checkCheckoutMockResponse(str);
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = (String) methodCall.argument("url");
        if (str == null) {
            str = "";
        }
        String protocol = getProtocol(methodCall);
        LogManager.debug(protocol + " Url: " + str);
        String mockResponse = mockResponse(str);
        String protocol2 = getProtocol(methodCall);
        LogManager.debug(protocol2 + " mock response: " + mockResponse);
        result.success(mockResponse);
    }
}
