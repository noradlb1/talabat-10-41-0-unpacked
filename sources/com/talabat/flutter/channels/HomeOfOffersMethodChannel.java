package com.talabat.flutter.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/flutter/channels/HomeOfOffersMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/flutter/channels/IHomeOfOffersMethodChannel;", "handleGetVendors", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "setCallback", "homeOfOffersCallBack", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class HomeOfOffersMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_VENDORS_OFFERS = "getVendors";
    private IHomeOfOffersMethodChannel callback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/flutter/channels/HomeOfOffersMethodChannel$Companion;", "", "()V", "GET_VENDORS_OFFERS", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleGetVendors(MethodChannel.Result result) {
        LogManager.debug("Native method:getVendors");
        IHomeOfOffersMethodChannel iHomeOfOffersMethodChannel = this.callback;
        if (iHomeOfOffersMethodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            iHomeOfOffersMethodChannel = null;
        }
        result.success(iHomeOfOffersMethodChannel.getVendorsOffers());
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) GET_VENDORS_OFFERS)) {
            handleGetVendors(result);
        } else {
            result.notImplemented();
        }
    }

    public final void setCallback(@NotNull IHomeOfOffersMethodChannel iHomeOfOffersMethodChannel) {
        Intrinsics.checkNotNullParameter(iHomeOfOffersMethodChannel, "homeOfOffersCallBack");
        this.callback = iHomeOfOffersMethodChannel;
    }
}
