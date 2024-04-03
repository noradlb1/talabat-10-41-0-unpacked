package com.talabat.configuration.di.flutter;

import com.talabat.configuration.di.WalletConfigQualifier;
import com.talabat.core.di.Api;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/configuration/di/flutter/ConfigurationRemoteCoreLibFlutterApi;", "Lcom/talabat/core/di/Api;", "walletConfigFlutterChannel", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getWalletConfigFlutterChannel", "()Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ConfigurationRemoteCoreLibFlutterApi extends Api {
    @NotNull
    @WalletConfigQualifier
    MethodChannel.MethodCallHandler getWalletConfigFlutterChannel();
}
