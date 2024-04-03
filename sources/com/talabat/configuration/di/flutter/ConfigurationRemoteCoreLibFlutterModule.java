package com.talabat.configuration.di.flutter;

import com.talabat.configuration.di.WalletConfigQualifier;
import com.talabat.configuration.payment.flutter.WalletConfigFlutterChannel;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/configuration/di/flutter/ConfigurationRemoteCoreLibFlutterModule;", "", "walletConfigFlutterChannel", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "impl", "Lcom/talabat/configuration/payment/flutter/WalletConfigFlutterChannel;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface ConfigurationRemoteCoreLibFlutterModule {
    @Binds
    @NotNull
    @WalletConfigQualifier
    @Reusable
    MethodChannel.MethodCallHandler walletConfigFlutterChannel(@NotNull WalletConfigFlutterChannel walletConfigFlutterChannel);
}
