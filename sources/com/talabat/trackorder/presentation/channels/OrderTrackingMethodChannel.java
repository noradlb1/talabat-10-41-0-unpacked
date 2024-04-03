package com.talabat.trackorder.presentation.channels;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/trackorder/presentation/channels/OrderTrackingMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/trackorder/presentation/channels/OrderTrackingMethodChannelCallback;", "handleCloseOrderTracking", "", "handleMenuScreen", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "handleOpenGhc", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handleOpenRiderChat", "handleOpenRiderTip", "handleOpenRiderTipInfo", "handleQCommerceDeeplink", "onMethodCall", "openProPaymentScreen", "setCallback", "Companion", "com_talabat_feature_trackorder_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final String CLOSE_ORDER_TRACKING = "closeOrderTracking";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEEP_LINK = "deepLink";
    @NotNull
    public static final String OPEN_GHC = "openGhc";
    @NotNull
    public static final String OPEN_MENU_SCREEN = "openMenuScreen";
    @NotNull
    public static final String OPEN_PAYMENT_PRO = "openProPaymentScreen";
    @NotNull
    public static final String OPEN_QCOMMERCE_DEEPLINK = "openQCommerceDeeplink";
    @NotNull
    public static final String OPEN_RIDER_CHAT = "openRiderChat";
    @NotNull
    public static final String OPEN_RIDER_TIP = "openRiderTip";
    @NotNull
    public static final String OPEN_RIDER_TIP_INFO = "openRiderTipInfo";
    private OrderTrackingMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/trackorder/presentation/channels/OrderTrackingMethodChannel$Companion;", "", "()V", "CLOSE_ORDER_TRACKING", "", "DEEP_LINK", "OPEN_GHC", "OPEN_MENU_SCREEN", "OPEN_PAYMENT_PRO", "OPEN_QCOMMERCE_DEEPLINK", "OPEN_RIDER_CHAT", "OPEN_RIDER_TIP", "OPEN_RIDER_TIP_INFO", "com_talabat_feature_trackorder_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleCloseOrderTracking() {
        OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = this.callback;
        if (orderTrackingMethodChannelCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            orderTrackingMethodChannelCallback = null;
        }
        orderTrackingMethodChannelCallback.closeOrderTracking();
    }

    private final void handleMenuScreen(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = this.callback;
                if (orderTrackingMethodChannelCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    orderTrackingMethodChannelCallback = null;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openMenu((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void handleOpenGhc(MethodCall methodCall, MethodChannel.Result result) {
        OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = null;
        result.success((Object) null);
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback2 = this.callback;
                if (orderTrackingMethodChannelCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                } else {
                    orderTrackingMethodChannelCallback = orderTrackingMethodChannelCallback2;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openGhc((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void handleOpenRiderChat(MethodCall methodCall, MethodChannel.Result result) {
        OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = null;
        result.success((Object) null);
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback2 = this.callback;
                if (orderTrackingMethodChannelCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                } else {
                    orderTrackingMethodChannelCallback = orderTrackingMethodChannelCallback2;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openRiderChat((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void handleOpenRiderTip(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = this.callback;
                if (orderTrackingMethodChannelCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    orderTrackingMethodChannelCallback = null;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openRiderTip((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void handleOpenRiderTipInfo(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = this.callback;
                if (orderTrackingMethodChannelCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    orderTrackingMethodChannelCallback = null;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openRiderTipInfo((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void handleQCommerceDeeplink(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = this.callback;
                if (orderTrackingMethodChannelCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    orderTrackingMethodChannelCallback = null;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openQCommerceDeeplink((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void openProPaymentScreen(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback = this.callback;
                if (orderTrackingMethodChannelCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    orderTrackingMethodChannelCallback = null;
                }
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingMethodChannelCallback.openProPaymentScreen((String) obj2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -2101693575:
                    if (str.equals("openRiderTipInfo")) {
                        handleOpenRiderTipInfo(methodCall);
                        return;
                    }
                    return;
                case -1800055089:
                    if (str.equals("openProPaymentScreen")) {
                        openProPaymentScreen(methodCall, result);
                        return;
                    }
                    return;
                case -1472975723:
                    if (str.equals(OPEN_MENU_SCREEN)) {
                        handleMenuScreen(methodCall);
                        return;
                    }
                    return;
                case -1263217416:
                    if (str.equals(OPEN_GHC)) {
                        handleOpenGhc(methodCall, result);
                        return;
                    }
                    return;
                case -196649528:
                    if (str.equals("openRiderChat")) {
                        handleOpenRiderChat(methodCall, result);
                        return;
                    }
                    return;
                case 503321672:
                    if (str.equals("openQCommerceDeeplink")) {
                        handleQCommerceDeeplink(methodCall);
                        return;
                    }
                    return;
                case 963504171:
                    if (str.equals("openRiderTip")) {
                        handleOpenRiderTip(methodCall);
                        return;
                    }
                    return;
                case 1011654925:
                    if (str.equals(CLOSE_ORDER_TRACKING)) {
                        handleCloseOrderTracking();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void setCallback(@NotNull OrderTrackingMethodChannelCallback orderTrackingMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(orderTrackingMethodChannelCallback, "callback");
        this.callback = orderTrackingMethodChannelCallback;
    }
}
