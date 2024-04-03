package com.talabat.flutter.secrets.domain.handler;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/flutter/secrets/domain/handler/SecretsMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onDetach", "com_talabat_core_flutter-secrets_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SecretsMethodCallHandler extends MethodChannel.MethodCallHandler {
    void onAttach(@NotNull BinaryMessenger binaryMessenger);

    void onDetach();
}
