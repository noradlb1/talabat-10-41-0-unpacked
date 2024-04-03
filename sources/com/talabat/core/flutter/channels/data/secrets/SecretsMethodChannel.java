package com.talabat.core.flutter.channels.data.secrets;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u001d\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/flutter/channels/data/secrets/SecretsMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/secrets/SecretsChannelFlutterDomain;", "callback", "Lcom/talabat/flutter/secrets/domain/handler/SecretsMethodCallHandler;", "(Lcom/talabat/flutter/secrets/domain/handler/SecretsMethodCallHandler;)V", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onDetach", "onMethodCall", "p0", "Lio/flutter/plugin/common/MethodCall;", "p1", "Lio/flutter/plugin/common/MethodChannel$Result;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SecretsMethodChannel implements MethodChannel.MethodCallHandler, SecretsChannelFlutterDomain {
    @NotNull
    private final SecretsMethodCallHandler callback;

    public SecretsMethodChannel(@NotNull SecretsMethodCallHandler secretsMethodCallHandler) {
        Intrinsics.checkNotNullParameter(secretsMethodCallHandler, "callback");
        this.callback = secretsMethodCallHandler;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        this.callback.onAttach(binaryMessenger);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
        SecretsChannelFlutterDomain.DefaultImpls.onAttachWithActivity(this, binaryMessenger, activity, bundle);
    }

    public void onDetach() {
        this.callback.onDetach();
    }

    @UiThread
    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "p0");
        Intrinsics.checkNotNullParameter(result, "p1");
        this.callback.onMethodCall(methodCall, result);
    }
}
