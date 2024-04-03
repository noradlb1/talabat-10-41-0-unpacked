package com.talabat.core.deeplink.data.di;

import com.talabat.core.deeplink.data.DefaultDeepLinkNavigator;
import com.talabat.core.deeplink.data.handler.flutter.uiless.DeepLinkFlutterNavigationChannel;
import com.talabat.core.deeplink.data.handler.flutter.uiless.UiLessFlutterEngineBinding;
import com.talabat.core.deeplink.data.parser.AppLinkParser;
import com.talabat.core.deeplink.data.parser.DeepLinkParser;
import com.talabat.core.deeplink.data.parser.LinkParser;
import com.talabat.core.deeplink.data.registry.AppLinkHandlerRegistry;
import com.talabat.core.deeplink.data.registry.DeepLinkHandlerRegistry;
import com.talabat.core.deeplink.data.registry.LinkHandlerRegistry;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H'¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/deeplink/data/di/DeepLinkCoreLibModule;", "", "provideAppLinkHandlerRigstry", "Lcom/talabat/core/deeplink/data/registry/LinkHandlerRegistry;", "realAppLinkHandler", "Lcom/talabat/core/deeplink/data/registry/AppLinkHandlerRegistry;", "provideAppLinkParser", "Lcom/talabat/core/deeplink/data/parser/LinkParser;", "realAppLinkParser", "Lcom/talabat/core/deeplink/data/parser/AppLinkParser;", "provideDeepLinkHandlerRegistry", "realDeepLinkHandler", "Lcom/talabat/core/deeplink/data/registry/DeepLinkHandlerRegistry;", "provideDeepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "Lcom/talabat/core/deeplink/data/DefaultDeepLinkNavigator;", "provideDeepLinkParser", "realDeepLinkParser", "Lcom/talabat/core/deeplink/data/parser/DeepLinkParser;", "Ext", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Ext.class})
public interface DeepLinkCoreLibModule {

    @Module
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/deeplink/data/di/DeepLinkCoreLibModule$Ext;", "", "()V", "provideUiLessFlutterEngineBinding", "Lcom/talabat/core/deeplink/data/handler/flutter/uiless/UiLessFlutterEngineBinding;", "flutterEngineProvider", "Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;", "deepLinkFlutterNavigationChannel", "Lcom/talabat/core/deeplink/data/handler/flutter/uiless/DeepLinkFlutterNavigationChannel;", "channels", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Ext {
        @NotNull
        public static final Ext INSTANCE = new Ext();

        private Ext() {
        }

        @NotNull
        @Provides
        public final UiLessFlutterEngineBinding provideUiLessFlutterEngineBinding(@NotNull IFlutterEngineProvider iFlutterEngineProvider, @NotNull DeepLinkFlutterNavigationChannel deepLinkFlutterNavigationChannel, @NotNull Map<Class<?>, Provider<PlatformChannel>> map, @NotNull IObservabilityManager iObservabilityManager) {
            PlatformChannel platformChannel;
            GlobalChannelFlutterDomain globalChannelFlutterDomain;
            PlatformChannel platformChannel2;
            ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain;
            PlatformChannel platformChannel3;
            SecretsChannelFlutterDomain secretsChannelFlutterDomain;
            PlatformChannel platformChannel4;
            TrackingChannelFlutterDomain trackingChannelFlutterDomain;
            Intrinsics.checkNotNullParameter(iFlutterEngineProvider, "flutterEngineProvider");
            Intrinsics.checkNotNullParameter(deepLinkFlutterNavigationChannel, "deepLinkFlutterNavigationChannel");
            Intrinsics.checkNotNullParameter(map, "channels");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            FlutterEngine provideUiLessEngine = iFlutterEngineProvider.provideUiLessEngine();
            Provider provider = map.get(GlobalChannelFlutterDomain.class);
            if (provider != null) {
                platformChannel = (PlatformChannel) provider.get();
            } else {
                platformChannel = null;
            }
            if (platformChannel instanceof GlobalChannelFlutterDomain) {
                globalChannelFlutterDomain = (GlobalChannelFlutterDomain) platformChannel;
            } else {
                globalChannelFlutterDomain = null;
            }
            Provider provider2 = map.get(ObservabilityChannelFlutterDomain.class);
            if (provider2 != null) {
                platformChannel2 = (PlatformChannel) provider2.get();
            } else {
                platformChannel2 = null;
            }
            if (platformChannel2 instanceof ObservabilityChannelFlutterDomain) {
                observabilityChannelFlutterDomain = (ObservabilityChannelFlutterDomain) platformChannel2;
            } else {
                observabilityChannelFlutterDomain = null;
            }
            Provider provider3 = map.get(SecretsChannelFlutterDomain.class);
            if (provider3 != null) {
                platformChannel3 = (PlatformChannel) provider3.get();
            } else {
                platformChannel3 = null;
            }
            if (platformChannel3 instanceof SecretsChannelFlutterDomain) {
                secretsChannelFlutterDomain = (SecretsChannelFlutterDomain) platformChannel3;
            } else {
                secretsChannelFlutterDomain = null;
            }
            Provider provider4 = map.get(TrackingChannelFlutterDomain.class);
            if (provider4 != null) {
                platformChannel4 = (PlatformChannel) provider4.get();
            } else {
                platformChannel4 = null;
            }
            if (platformChannel4 instanceof TrackingChannelFlutterDomain) {
                trackingChannelFlutterDomain = (TrackingChannelFlutterDomain) platformChannel4;
            } else {
                trackingChannelFlutterDomain = null;
            }
            return new UiLessFlutterEngineBinding(provideUiLessEngine, deepLinkFlutterNavigationChannel, globalChannelFlutterDomain, observabilityChannelFlutterDomain, secretsChannelFlutterDomain, trackingChannelFlutterDomain, iObservabilityManager);
        }
    }

    @AppLink
    @Binds
    @NotNull
    @Reusable
    LinkHandlerRegistry provideAppLinkHandlerRigstry(@NotNull AppLinkHandlerRegistry appLinkHandlerRegistry);

    @AppLink
    @Binds
    @NotNull
    @Reusable
    LinkParser provideAppLinkParser(@NotNull AppLinkParser appLinkParser);

    @DeepLink
    @Binds
    @NotNull
    @Reusable
    LinkHandlerRegistry provideDeepLinkHandlerRegistry(@NotNull DeepLinkHandlerRegistry deepLinkHandlerRegistry);

    @NotNull
    @Binds
    @Reusable
    DeepLinkNavigator provideDeepLinkNavigator(@NotNull DefaultDeepLinkNavigator defaultDeepLinkNavigator);

    @DeepLink
    @Binds
    @NotNull
    @Reusable
    LinkParser provideDeepLinkParser(@NotNull DeepLinkParser deepLinkParser);
}
