package com.talabat.core.flutter.channels.data.cart;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import com.talabat.core.flutter.channels.domain.cart.CartChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/talabat/core/flutter/channels/data/cart/CartMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/cart/CartChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartMethodChannel implements MethodChannel.MethodCallHandler, CartChannelFlutterDomain {
    @NotNull
    private static final String ADD_T0_CART = "addToCart";
    @NotNull
    private static final String APPLY_VOUCHER = "applyVoucher";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_CART = "getCartInfo";
    @NotNull
    private static final String REMOVE_APPLIED_VOUCHER = "removeAppliedVoucher";
    @NotNull
    private static final String RESET_CART = "resetCart";
    @NotNull
    private static final String UPDATE_CUTLERY = "updateCutlery";
    @NotNull
    private static final String UPDATE_DELIVERY_TIME = "updateDeliveryTime";
    @NotNull
    private static final String UPDATE_ITEM_FROM_CART = "updateItemFromCart";
    @NotNull
    private static final String UPDATE_QUANTITY = "updateItemQuantity";
    @NotNull
    private static final String UPDATE_SELECTED_MENU_DISCOUNT = "updateSelectedMenuDiscountRequest";
    @NotNull
    private static final String UPDATE_SPECIAL_REQUEST = "updateSpecialRequest";
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final CartChannelCallback callback;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/cart/CartMethodChannel$Companion;", "", "()V", "ADD_T0_CART", "", "APPLY_VOUCHER", "GET_CART", "REMOVE_APPLIED_VOUCHER", "RESET_CART", "UPDATE_CUTLERY", "UPDATE_DELIVERY_TIME", "UPDATE_ITEM_FROM_CART", "UPDATE_QUANTITY", "UPDATE_SELECTED_MENU_DISCOUNT", "UPDATE_SPECIAL_REQUEST", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CartMethodChannel(@NotNull CartChannelCallback cartChannelCallback) {
        Intrinsics.checkNotNullParameter(cartChannelCallback, "callback");
        this.callback = cartChannelCallback;
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/vendor-cart");
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
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1628100569:
                    if (str.equals(UPDATE_QUANTITY)) {
                        WeakReference<Activity> weakReference = this.activity;
                        if (weakReference != null && (activity2 = weakReference.get()) != null) {
                            this.callback.updateQuantity(methodCall.arguments, activity2);
                            result.success(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    break;
                case -1588271738:
                    if (str.equals(UPDATE_ITEM_FROM_CART)) {
                        WeakReference<Activity> weakReference2 = this.activity;
                        if (!(weakReference2 == null || (activity3 = weakReference2.get()) == null)) {
                            this.callback.updateItemFromCart(methodCall.arguments, activity3);
                        }
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -472176449:
                    if (str.equals(UPDATE_SPECIAL_REQUEST)) {
                        this.callback.updateSpecialRequest(methodCall.arguments);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -367342151:
                    if (str.equals(UPDATE_CUTLERY)) {
                        this.callback.updateCutlery(methodCall.arguments);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -289574838:
                    if (str.equals(UPDATE_DELIVERY_TIME)) {
                        this.callback.updateDeliveryTimeValue(methodCall.arguments);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 23457852:
                    if (str.equals(ADD_T0_CART)) {
                        WeakReference<Activity> weakReference3 = this.activity;
                        if (weakReference3 != null && (activity4 = weakReference3.get()) != null) {
                            this.callback.addToCart(methodCall.arguments, activity4);
                            result.success(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    break;
                case 304639253:
                    if (str.equals(REMOVE_APPLIED_VOUCHER)) {
                        this.callback.removeAppliedVoucher();
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 506301280:
                    if (str.equals(APPLY_VOUCHER)) {
                        WeakReference<Activity> weakReference4 = this.activity;
                        if (!(weakReference4 == null || (activity5 = weakReference4.get()) == null)) {
                            this.callback.applyVoucher(methodCall.arguments, activity5);
                        }
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 1175260555:
                    if (str.equals(UPDATE_SELECTED_MENU_DISCOUNT)) {
                        this.callback.updateSelectedMenuDiscount(methodCall.arguments);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 2023279887:
                    if (str.equals(RESET_CART)) {
                        WeakReference<Activity> weakReference5 = this.activity;
                        if (weakReference5 != null && (activity6 = weakReference5.get()) != null) {
                            this.callback.resetCart(activity6);
                            result.success(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    break;
                case 2084110692:
                    if (str.equals(GET_CART)) {
                        result.success(this.callback.getCartInformation());
                        return;
                    }
                    break;
            }
        }
        Reflection.getOrCreateKotlinClass(CartMethodChannel.class).getSimpleName();
        result.notImplemented();
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
