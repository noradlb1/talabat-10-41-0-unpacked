package com.talabat.configuration.payment.flutter;

import androidx.core.app.NotificationCompat;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import dagger.Reusable;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/configuration/payment/flutter/WalletConfigFlutterChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "walletConfigFlutterEncoder", "Lcom/talabat/configuration/payment/flutter/WalletConfigFlutterEncoder;", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/configuration/payment/flutter/WalletConfigFlutterEncoder;)V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class WalletConfigFlutterChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String METHOD_CALL_NATIVE_CONFIGURATION_REMOTE_WALLET = "getWalletConfigFromNative";
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final WalletConfigFlutterEncoder walletConfigFlutterEncoder;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/configuration/payment/flutter/WalletConfigFlutterChannel$Companion;", "", "()V", "METHOD_CALL_NATIVE_CONFIGURATION_REMOTE_WALLET", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public WalletConfigFlutterChannel(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull WalletConfigFlutterEncoder walletConfigFlutterEncoder2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletConfigFlutterEncoder2, "walletConfigFlutterEncoder");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.walletConfigFlutterEncoder = walletConfigFlutterEncoder2;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) METHOD_CALL_NATIVE_CONFIGURATION_REMOTE_WALLET)) {
            result.success(this.walletConfigFlutterEncoder.apply(this.paymentConfigurationRepository.walletConfig()));
            return;
        }
        Object obj = methodCall.arguments;
        Timber.w("Flutter method not implemented: " + obj, new Object[0]);
    }
}
