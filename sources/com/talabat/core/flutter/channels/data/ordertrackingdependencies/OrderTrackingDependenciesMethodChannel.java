package com.talabat.core.flutter.channels.data.ordertrackingdependencies;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0011H\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/talabat/core/flutter/channels/data/ordertrackingdependencies/OrderTrackingDependenciesMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "handleNotImplemented", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handleOpenProPaymentScreen", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "handleOpenRiderChat", "call", "handleOpenRiderTip", "handleOpenRiderTipInfo", "handleQCommerceDeeplink", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "refreshOrderTrackingScreen", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingDependenciesMethodChannel implements MethodChannel.MethodCallHandler, OrderTrackingDependenciesFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
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
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final OrderTrackingDependenciesChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/ordertrackingdependencies/OrderTrackingDependenciesMethodChannel$Companion;", "", "()V", "OPEN_PAYMENT_PRO", "", "OPEN_QCOMMERCE_DEEPLINK", "OPEN_RIDER_CHAT", "OPEN_RIDER_TIP", "OPEN_RIDER_TIP_INFO", "getQueryParam", "Ljava/net/URI;", "key", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getQueryParam(URI uri, String str) {
            List<String> list;
            String query = uri.getQuery();
            if (query == null || (list = StringsKt__StringsKt.split$default((CharSequence) query, new char[]{Typography.amp}, false, 0, 6, (Object) null)) == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            for (String split$default : list) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default, new char[]{SignatureVisitor.INSTANCEOF}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2 && Intrinsics.areEqual(split$default2.get(0), (Object) str)) {
                    return (String) split$default2.get(1);
                }
            }
            return null;
        }
    }

    public OrderTrackingDependenciesMethodChannel(@NotNull OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback) {
        Intrinsics.checkNotNullParameter(orderTrackingDependenciesChannelCallback, "callback");
        this.callback = orderTrackingDependenciesChannelCallback;
    }

    private final void handleNotImplemented(MethodChannel.Result result) {
        Reflection.getOrCreateKotlinClass(OrderTrackingDependenciesFlutterDomain.class).getSimpleName();
        result.notImplemented();
    }

    private final void handleOpenProPaymentScreen(MethodCall methodCall, MethodChannel.Result result) {
        WeakReference<Activity> weakReference;
        Activity activity2;
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (!(!hashMap.containsKey("deepLink") || (weakReference = this.activity) == null || (activity2 = weakReference.get()) == null)) {
                OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback = this.callback;
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingDependenciesChannelCallback.openProPaymentScreen((String) obj2, activity2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    private final void handleOpenRiderChat(MethodCall methodCall, MethodChannel.Result result) {
        Activity activity2;
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("deepLink")) {
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    Companion companion = Companion;
                    URI create = URI.create((String) obj2);
                    Intrinsics.checkNotNullExpressionValue(create, "create(deeplink)");
                    String access$getQueryParam = companion.getQueryParam(create, "orderId");
                    if (access$getQueryParam == null) {
                        access$getQueryParam = "";
                    }
                    WeakReference<Activity> weakReference = this.activity;
                    if (!(weakReference == null || (activity2 = weakReference.get()) == null)) {
                        this.callback.openRiderChat(access$getQueryParam, activity2);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
    }

    private final void handleOpenRiderTip(MethodCall methodCall, MethodChannel.Result result) {
        WeakReference<Activity> weakReference;
        Activity activity2;
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (!(!hashMap.containsKey("deepLink") || (weakReference = this.activity) == null || (activity2 = weakReference.get()) == null)) {
                OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback = this.callback;
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingDependenciesChannelCallback.openRiderTip((String) obj2, activity2, new OrderTrackingDependenciesMethodChannel$handleOpenRiderTip$1$1(this));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
    }

    private final void handleOpenRiderTipInfo(MethodCall methodCall, MethodChannel.Result result) {
        WeakReference<Activity> weakReference;
        Activity activity2;
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (!(!hashMap.containsKey("deepLink") || (weakReference = this.activity) == null || (activity2 = weakReference.get()) == null)) {
                OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback = this.callback;
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingDependenciesChannelCallback.openRiderTipInfo((String) obj2, activity2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
    }

    private final void handleQCommerceDeeplink(MethodCall methodCall, MethodChannel.Result result) {
        WeakReference<Activity> weakReference;
        Activity activity2;
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (!(!hashMap.containsKey("deepLink") || (weakReference = this.activity) == null || (activity2 = weakReference.get()) == null)) {
                OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback = this.callback;
                Object obj2 = hashMap.get("deepLink");
                if (obj2 != null) {
                    orderTrackingDependenciesChannelCallback.openQCommerceDeeplink((String) obj2, activity2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            result.success((Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    /* access modifiers changed from: private */
    public final void refreshOrderTrackingScreen() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshOtp", "");
        }
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/order_tracking");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = new WeakReference<>(activity2);
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        this.activity = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -2101693575:
                    if (str.equals("openRiderTipInfo")) {
                        handleOpenRiderTipInfo(methodCall, result);
                        return;
                    }
                    break;
                case -1800055089:
                    if (str.equals("openProPaymentScreen")) {
                        handleOpenProPaymentScreen(methodCall, result);
                        return;
                    }
                    break;
                case -196649528:
                    if (str.equals("openRiderChat")) {
                        handleOpenRiderChat(methodCall, result);
                        return;
                    }
                    break;
                case 503321672:
                    if (str.equals("openQCommerceDeeplink")) {
                        handleQCommerceDeeplink(methodCall, result);
                        return;
                    }
                    break;
                case 963504171:
                    if (str.equals("openRiderTip")) {
                        handleOpenRiderTip(methodCall, result);
                        return;
                    }
                    break;
            }
        }
        handleNotImplemented(result);
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
