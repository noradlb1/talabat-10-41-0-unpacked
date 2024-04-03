package com.talabat.talabatlife.ui.onBoarding;

import androidx.core.app.NotificationCompat;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/PaymentMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "paymentMethodChannelInterface", "Lcom/talabat/talabatlife/ui/onBoarding/IPaymentMethodChannel;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setPaymentMethodChannelInterface", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String OPEN_PAYMENT_WIDGET_METHOD_CALL = "openSubscriptionPaymentBottomSheet";
    @NotNull
    public static final String PAYMENT_WIDGET_CLOSED_METHOD_CALL = "paymentWidgetClosed";
    @NotNull
    public static final String SEND_CARD_DETAILS_CALL = "sendCardDetails";
    @NotNull
    private static final String UPDATE_PAYMENT_STATUS_METHOD_CALL = "updatePaymentStatus";
    private IPaymentMethodChannel paymentMethodChannelInterface;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/PaymentMethodChannel$Companion;", "", "()V", "OPEN_PAYMENT_WIDGET_METHOD_CALL", "", "PAYMENT_WIDGET_CLOSED_METHOD_CALL", "SEND_CARD_DETAILS_CALL", "UPDATE_PAYMENT_STATUS_METHOD_CALL", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (Intrinsics.areEqual((Object) methodCall.method, (Object) OPEN_PAYMENT_WIDGET_METHOD_CALL)) {
                Object obj2 = methodCall.arguments;
                LogManager.debug(OPEN_PAYMENT_WIDGET_METHOD_CALL + obj2);
                IPaymentMethodChannel iPaymentMethodChannel = this.paymentMethodChannelInterface;
                if (iPaymentMethodChannel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentMethodChannelInterface");
                    iPaymentMethodChannel = null;
                }
                iPaymentMethodChannel.openPaymentWidget(PaymentMethodChannelKt.toPaymentDisplayModel(hashMap));
                return;
            }
            Object obj3 = methodCall.arguments;
            LogManager.debug("Not Implemented" + obj3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    public final void setPaymentMethodChannelInterface(@NotNull IPaymentMethodChannel iPaymentMethodChannel) {
        Intrinsics.checkNotNullParameter(iPaymentMethodChannel, "paymentMethodChannelInterface");
        this.paymentMethodChannelInterface = iPaymentMethodChannel;
    }
}
