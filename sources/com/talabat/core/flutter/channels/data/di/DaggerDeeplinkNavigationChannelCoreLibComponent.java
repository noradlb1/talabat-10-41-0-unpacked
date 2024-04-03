package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.data.di.DeeplinkNavigationChannelCoreLibComponent;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDeeplinkNavigationChannelCoreLibComponent {

    public static final class DeeplinkNavigationChannelCoreLibComponentImpl implements DeeplinkNavigationChannelCoreLibComponent {
        private final DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi;
        private final DeeplinkNavigationChannelCoreLibComponentImpl deeplinkNavigationChannelCoreLibComponentImpl;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;

        private DeeplinkNavigationChannelCoreLibComponentImpl(DispatcherCoreLibApi dispatcherCoreLibApi2, DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi2) {
            this.deeplinkNavigationChannelCoreLibComponentImpl = this;
            this.deeplinkNavigationChannelCoreImplLibApi = deeplinkNavigationChannelCoreImplLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
        }

        public DeeplinkNavigationNativeDomain getDeeplinkNavigationNativeDomain() {
            return DeeplinkNavigationChannelCoreLibModule_ProvideDeeplinkNavigationNativeDomainFactory.provideDeeplinkNavigationNativeDomain((DeeplinkNavigationChannelCallback) Preconditions.checkNotNullFromComponent(this.deeplinkNavigationChannelCoreImplLibApi.getDeeplinkNavigationChannelCallback()), (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
        }
    }

    public static final class Factory implements DeeplinkNavigationChannelCoreLibComponent.Factory {
        private Factory() {
        }

        public DeeplinkNavigationChannelCoreLibComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, DeeplinkNavigationChannelCoreImplLibApi deeplinkNavigationChannelCoreImplLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(deeplinkNavigationChannelCoreImplLibApi);
            return new DeeplinkNavigationChannelCoreLibComponentImpl(dispatcherCoreLibApi, deeplinkNavigationChannelCoreImplLibApi);
        }
    }

    private DaggerDeeplinkNavigationChannelCoreLibComponent() {
    }

    public static DeeplinkNavigationChannelCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
