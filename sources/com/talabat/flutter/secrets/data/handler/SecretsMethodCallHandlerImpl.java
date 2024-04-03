package com.talabat.flutter.secrets.data.handler;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0017\u001a\u00020\r*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R*\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/flutter/secrets/data/handler/SecretsMethodCallHandlerImpl;", "Lcom/talabat/flutter/secrets/domain/handler/SecretsMethodCallHandler;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "(Lcom/talabat/authentication/aaa/secrets/SecretProvider;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "getSecret", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onDetach", "onMethodCall", "dispatchError", "errorMessage", "", "com_talabat_core_flutter-secrets_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SecretsMethodCallHandlerImpl implements SecretsMethodCallHandler {
    @Nullable
    private MethodChannel channel;
    @NotNull
    private final SecretProvider secretProvider;

    @Inject
    public SecretsMethodCallHandlerImpl(@NotNull SecretProvider secretProvider2) {
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        this.secretProvider = secretProvider2;
    }

    private final void dispatchError(MethodChannel.Result result, String str) {
        result.error("SecretNotFound", str, (Object) null);
    }

    private final void getSecret(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        Unit unit = null;
        if (str != null) {
            String key = this.secretProvider.getKey(str);
            if (key != null) {
                result.success(key);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                dispatchError(result, "Secret for " + str + " not found");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            dispatchError(result, "Argument key not found");
        }
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/secrets");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "getSecretValue")) {
            getSecret(methodCall, result);
        } else {
            result.notImplemented();
        }
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
