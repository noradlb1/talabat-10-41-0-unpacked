package com.talabat.flutter.channels;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.core.app.NotificationCompat;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/flutter/channels/HomeOfOffersFlutterApiCallsMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "localhostResponseForGETCall", "", "localhostResponseForPOSTCall", "getJson", "path", "getProtocol", "call", "Lio/flutter/plugin/common/MethodCall;", "mockResponse", "url", "onMethodCall", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeOfOffersFlutterApiCallsMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private final Context context;
    @NotNull
    private final String localhostResponseForGETCall = "localhostResponseForGETCall";
    @NotNull
    private final String localhostResponseForPOSTCall = "localhostResponseForPOSTCall";

    public HomeOfOffersFlutterApiCallsMethodChannel(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final String getJson(String str) {
        AssetManager assets = this.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return HomeOfOffersFlutterApiCallsMethodChannelKt.readAssetsFile(assets, str);
    }

    private final String getProtocol(MethodCall methodCall) {
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) this.localhostResponseForGETCall)) {
            return "handleGetRequests";
        }
        if (Intrinsics.areEqual((Object) str, (Object) this.localhostResponseForPOSTCall)) {
            return "handlePostRequests";
        }
        return "Request Protocol not handle";
    }

    private final String mockResponse(String str) {
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) HomeOfOffersFlutterApiCallsMethodChannelKt.homeOfOffersApi("25.3261372882906", "55.3872299194336"), false, 2, (Object) null)) {
            return getJson("hoo/home-of-offers-api-response_location2.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) HomeOfOffersFlutterApiCallsMethodChannelKt.homeOfOffersApi("25.1099754198083", "55.4080522432923"), false, 2, (Object) null)) {
            return getJson("hoo/home-of-offers-api-response.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) HomeOfOffersFlutterApiCallsMethodChannelKt.homeOfOffersApi("25.113106", "55.408403"), false, 2, (Object) null)) {
            return getJson("hoo/home-of-offers-api-response.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "/api/v1/home-of-offers/collection", false, 2, (Object) null)) {
            return getJson("hoo/home-of-offers-collections-api-response.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "menuapi/v2/branches/-1/menu/", false, 2, (Object) null)) {
            return getJson("hoo/branches_v2_menu_12869.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "menubff/v4/branches/-1/menu/", false, 2, (Object) null)) {
            return getJson("hoo/branches_v2_menu_12869.json");
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "/restaurantapi/v3/branch/-1/info", false, 2, (Object) null)) {
            return getJson("hoo/branch_609078_v3_info.json");
        }
        return "";
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
        LogManager.debug(protocol2 + " response: " + mockResponse);
        result.success(mockResponse);
    }
}
