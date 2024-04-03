package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.data.qcommerce.QCommerceMethodChannel;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/QCommerceMethodChannelFeatureLibModule;", "", "()V", "provideDeeplinkNavigationNativeDomain", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelFlutterDomain;", "qCommerceChannelCallback", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class QCommerceMethodChannelFeatureLibModule {
    @NotNull
    public static final QCommerceMethodChannelFeatureLibModule INSTANCE = new QCommerceMethodChannelFeatureLibModule();

    private QCommerceMethodChannelFeatureLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final QCommerceChannelFlutterDomain provideDeeplinkNavigationNativeDomain(@NotNull QCommerceChannelCallback qCommerceChannelCallback) {
        Intrinsics.checkNotNullParameter(qCommerceChannelCallback, "qCommerceChannelCallback");
        return new QCommerceMethodChannel(qCommerceChannelCallback);
    }
}
