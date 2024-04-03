package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.data.navigation.DeepLinkNativeNavigationChannel;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/DeeplinkNavigationChannelCoreLibModule;", "", "()V", "provideDeeplinkNavigationNativeDomain", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationNativeDomain;", "deeplinkNavigationChannelCallback", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationChannelCallback;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DeeplinkNavigationChannelCoreLibModule {
    @NotNull
    public static final DeeplinkNavigationChannelCoreLibModule INSTANCE = new DeeplinkNavigationChannelCoreLibModule();

    private DeeplinkNavigationChannelCoreLibModule() {
    }

    @NotNull
    @Provides
    public final DeeplinkNavigationNativeDomain provideDeeplinkNavigationNativeDomain(@NotNull DeeplinkNavigationChannelCallback deeplinkNavigationChannelCallback, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(deeplinkNavigationChannelCallback, "deeplinkNavigationChannelCallback");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        return new DeepLinkNativeNavigationChannel(deeplinkNavigationChannelCallback, coroutineDispatchersFactory);
    }
}
