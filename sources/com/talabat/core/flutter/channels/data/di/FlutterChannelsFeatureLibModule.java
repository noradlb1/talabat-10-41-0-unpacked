package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.data.qcommerce.QCommerceMethodChannel;
import com.talabat.core.flutter.channels.data.tpro.TproMethodChannel;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import com.talabat.core.flutter.channels.domain.tpro.TproChannelFlutterDomain;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ>\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u00032\u001d\u0010\b\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003H'¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsFeatureLibModule;", "", "channels", "", "", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "platformChannelChannels", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FlutterChannelsFeatureLibModule {
    @NotNull
    public static final Companion Companion = Companion.f55880a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsFeatureLibModule$Companion;", "", "()V", "provideQCommerceMethodChannel", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "qCommerceChannelCallback", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "provideTproMethodChannel", "tProChannelCallback", "Lcom/talabat/core/flutter/channels/domain/tpro/TProChannelCallback;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55880a = new Companion();

        private Companion() {
        }

        @IntoMap
        @NotNull
        @ClassKey(QCommerceChannelFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideQCommerceMethodChannel(@NotNull QCommerceChannelCallback qCommerceChannelCallback) {
            Intrinsics.checkNotNullParameter(qCommerceChannelCallback, "qCommerceChannelCallback");
            return new QCommerceMethodChannel(qCommerceChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(TproChannelFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideTproMethodChannel(@NotNull TProChannelCallback tProChannelCallback, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
            Intrinsics.checkNotNullParameter(tProChannelCallback, "tProChannelCallback");
            Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
            return new TproMethodChannel(tProChannelCallback, coroutineDispatchersFactory);
        }
    }

    @NotNull
    @Binds
    Map<String, Provider<PlatformChannel>> channels(@NotNull Map<String, Provider<PlatformChannel>> map);
}
