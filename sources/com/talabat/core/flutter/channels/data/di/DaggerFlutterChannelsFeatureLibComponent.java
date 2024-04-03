package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.data.di.FlutterChannelsFeatureLibComponent;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureImplLibApi;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import com.talabat.core.flutter.channels.domain.tpro.TproChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFlutterChannelsFeatureLibComponent {

    public static final class Factory implements FlutterChannelsFeatureLibComponent.Factory {
        private Factory() {
        }

        public FlutterChannelsFeatureLibComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(flutterChannelsFeatureImplLibApi);
            return new FlutterChannelsFeatureLibComponentImpl(dispatcherCoreLibApi, flutterChannelsFeatureImplLibApi);
        }
    }

    public static final class FlutterChannelsFeatureLibComponentImpl implements FlutterChannelsFeatureLibComponent {
        private final FlutterChannelsFeatureLibComponentImpl flutterChannelsFeatureLibComponentImpl;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<QCommerceChannelCallback> getQCommerceChannelCallbackProvider;
        private Provider<TProChannelCallback> getTProChannelCallbackProvider;
        private Provider<PlatformChannel> provideQCommerceMethodChannelProvider;
        private Provider<PlatformChannel> provideTproMethodChannelProvider;

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        public static final class GetQCommerceChannelCallbackProvider implements Provider<QCommerceChannelCallback> {
            private final FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi;

            public GetQCommerceChannelCallbackProvider(FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi2) {
                this.flutterChannelsFeatureImplLibApi = flutterChannelsFeatureImplLibApi2;
            }

            public QCommerceChannelCallback get() {
                return (QCommerceChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsFeatureImplLibApi.getQCommerceChannelCallback());
            }
        }

        public static final class GetTProChannelCallbackProvider implements Provider<TProChannelCallback> {
            private final FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi;

            public GetTProChannelCallbackProvider(FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi2) {
                this.flutterChannelsFeatureImplLibApi = flutterChannelsFeatureImplLibApi2;
            }

            public TProChannelCallback get() {
                return (TProChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsFeatureImplLibApi.getTProChannelCallback());
            }
        }

        private FlutterChannelsFeatureLibComponentImpl(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi) {
            this.flutterChannelsFeatureLibComponentImpl = this;
            initialize(dispatcherCoreLibApi, flutterChannelsFeatureImplLibApi);
        }

        private void initialize(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi) {
            this.getTProChannelCallbackProvider = new GetTProChannelCallbackProvider(flutterChannelsFeatureImplLibApi);
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            this.provideTproMethodChannelProvider = SingleCheck.provider(FlutterChannelsFeatureLibModule_Companion_ProvideTproMethodChannelFactory.create(this.getTProChannelCallbackProvider, getCoroutineDispatchersFactoryProvider2));
            GetQCommerceChannelCallbackProvider getQCommerceChannelCallbackProvider2 = new GetQCommerceChannelCallbackProvider(flutterChannelsFeatureImplLibApi);
            this.getQCommerceChannelCallbackProvider = getQCommerceChannelCallbackProvider2;
            this.provideQCommerceMethodChannelProvider = SingleCheck.provider(FlutterChannelsFeatureLibModule_Companion_ProvideQCommerceMethodChannelFactory.create(getQCommerceChannelCallbackProvider2));
        }

        public Map<Class<?>, Provider<PlatformChannel>> getChannels() {
            return MapBuilder.newMapBuilder(2).put(TproChannelFlutterDomain.class, this.provideTproMethodChannelProvider).put(QCommerceChannelFlutterDomain.class, this.provideQCommerceMethodChannelProvider).build();
        }
    }

    private DaggerFlutterChannelsFeatureLibComponent() {
    }

    public static FlutterChannelsFeatureLibComponent.Factory factory() {
        return new Factory();
    }
}
