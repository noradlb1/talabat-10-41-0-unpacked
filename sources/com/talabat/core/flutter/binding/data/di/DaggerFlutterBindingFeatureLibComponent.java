package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.di.FlutterBindingFeatureLibComponent;
import com.talabat.core.flutter.binding.data.qcommerce.QCommerceFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.tpro.TproFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SingleCheck;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFlutterBindingFeatureLibComponent {

    public static final class Factory implements FlutterBindingFeatureLibComponent.Factory {
        private Factory() {
        }

        public FlutterBindingFeatureLibComponent create(FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi) {
            Preconditions.checkNotNull(flutterChannelsFeatureLibApi);
            return new FlutterBindingFeatureLibComponentImpl(flutterChannelsFeatureLibApi);
        }
    }

    public static final class FlutterBindingFeatureLibComponentImpl implements FlutterBindingFeatureLibComponent {
        private final FlutterBindingFeatureLibComponentImpl flutterBindingFeatureLibComponentImpl;
        private Provider<Map<Class<?>, Provider<PlatformChannel>>> getChannelsProvider;
        private Provider<QCommerceFlutterEngineBinding> provideQCommerceFlutterEngineBindingProvider;
        private Provider<TproFlutterEngineBinding> provideTproFlutterBindingProvider;

        public static final class GetChannelsProvider implements Provider<Map<Class<?>, Provider<PlatformChannel>>> {
            private final FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi;

            public GetChannelsProvider(FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi2) {
                this.flutterChannelsFeatureLibApi = flutterChannelsFeatureLibApi2;
            }

            public Map<Class<?>, Provider<PlatformChannel>> get() {
                return (Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsFeatureLibApi.getChannels());
            }
        }

        private FlutterBindingFeatureLibComponentImpl(FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi) {
            this.flutterBindingFeatureLibComponentImpl = this;
            initialize(flutterChannelsFeatureLibApi);
        }

        private void initialize(FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi) {
            GetChannelsProvider getChannelsProvider2 = new GetChannelsProvider(flutterChannelsFeatureLibApi);
            this.getChannelsProvider = getChannelsProvider2;
            this.provideTproFlutterBindingProvider = SingleCheck.provider(FlutterBindingFeatureLibModule_ProvideTproFlutterBindingFactory.create(getChannelsProvider2));
            this.provideQCommerceFlutterEngineBindingProvider = SingleCheck.provider(FlutterBindingFeatureLibModule_ProvideQCommerceFlutterEngineBindingFactory.create(this.getChannelsProvider));
        }

        private Set<EngineBinding> provideRegisteredFlutterBindingFeatureModules() {
            return FlutterBindingFeatureLibModule_ProvideRegisteredFlutterBindingFeatureModulesFactory.provideRegisteredFlutterBindingFeatureModules(this.provideTproFlutterBindingProvider.get(), this.provideQCommerceFlutterEngineBindingProvider.get());
        }

        public Set<EngineBinding> getRegisteredFlutterBindingFeatureModules() {
            return SetBuilder.newSetBuilder(1).addAll(provideRegisteredFlutterBindingFeatureModules()).build();
        }
    }

    private DaggerFlutterBindingFeatureLibComponent() {
    }

    public static FlutterBindingFeatureLibComponent.Factory factory() {
        return new Factory();
    }
}
