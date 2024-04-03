package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.qcommerce.QCommerceFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.tpro.TproFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tpro.TproChannelFlutterDomain;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ElementsIntoSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J+\u0010\u0011\u001a\u00020\u000f2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/flutter/binding/data/di/FlutterBindingFeatureLibModule;", "", "()V", "provideQCommerceFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/qcommerce/QCommerceFlutterEngineBinding;", "channels", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideRegisteredFlutterBindingFeatureModules", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "tProFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/tpro/TproFlutterEngineBinding;", "qCommerceFlutterEngineBinding", "provideTproFlutterBinding", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FlutterBindingFeatureLibModule {
    @NotNull
    public static final FlutterBindingFeatureLibModule INSTANCE = new FlutterBindingFeatureLibModule();

    private FlutterBindingFeatureLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final QCommerceFlutterEngineBinding provideQCommerceFlutterEngineBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(QCommerceChannelFlutterDomain.class);
        QCommerceChannelFlutterDomain qCommerceChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof QCommerceChannelFlutterDomain) {
            qCommerceChannelFlutterDomain = (QCommerceChannelFlutterDomain) platformChannel;
        }
        return new QCommerceFlutterEngineBinding(qCommerceChannelFlutterDomain);
    }

    @ElementsIntoSet
    @NotNull
    @Provides
    public final Set<EngineBinding> provideRegisteredFlutterBindingFeatureModules(@NotNull TproFlutterEngineBinding tproFlutterEngineBinding, @NotNull QCommerceFlutterEngineBinding qCommerceFlutterEngineBinding) {
        Intrinsics.checkNotNullParameter(tproFlutterEngineBinding, "tProFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(qCommerceFlutterEngineBinding, "qCommerceFlutterEngineBinding");
        return SetsKt__SetsKt.setOf(tproFlutterEngineBinding, qCommerceFlutterEngineBinding);
    }

    @NotNull
    @Reusable
    @Provides
    public final TproFlutterEngineBinding provideTproFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(TproChannelFlutterDomain.class);
        TproChannelFlutterDomain tproChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof TproChannelFlutterDomain) {
            tproChannelFlutterDomain = (TproChannelFlutterDomain) platformChannel;
        }
        return new TproFlutterEngineBinding(tproChannelFlutterDomain);
    }
}
