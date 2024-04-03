package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.data.di.QCommerceMethodChannelFeatureLibComponent;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibImplApi;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerQCommerceMethodChannelFeatureLibComponent {

    public static final class Factory implements QCommerceMethodChannelFeatureLibComponent.Factory {
        private Factory() {
        }

        public QCommerceMethodChannelFeatureLibComponent create(QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi) {
            Preconditions.checkNotNull(qCommerceMethodChannelFeatureLibImplApi);
            return new QCommerceMethodChannelFeatureLibComponentImpl(qCommerceMethodChannelFeatureLibImplApi);
        }
    }

    public static final class QCommerceMethodChannelFeatureLibComponentImpl implements QCommerceMethodChannelFeatureLibComponent {
        private Provider<QCommerceChannelCallback> getQCommerceChannelCallbackProvider;
        private Provider<QCommerceChannelFlutterDomain> provideDeeplinkNavigationNativeDomainProvider;
        private final QCommerceMethodChannelFeatureLibComponentImpl qCommerceMethodChannelFeatureLibComponentImpl;

        public static final class GetQCommerceChannelCallbackProvider implements Provider<QCommerceChannelCallback> {
            private final QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi;

            public GetQCommerceChannelCallbackProvider(QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi2) {
                this.qCommerceMethodChannelFeatureLibImplApi = qCommerceMethodChannelFeatureLibImplApi2;
            }

            public QCommerceChannelCallback get() {
                return (QCommerceChannelCallback) Preconditions.checkNotNullFromComponent(this.qCommerceMethodChannelFeatureLibImplApi.getQCommerceChannelCallback());
            }
        }

        private QCommerceMethodChannelFeatureLibComponentImpl(QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi) {
            this.qCommerceMethodChannelFeatureLibComponentImpl = this;
            initialize(qCommerceMethodChannelFeatureLibImplApi);
        }

        private void initialize(QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi) {
            GetQCommerceChannelCallbackProvider getQCommerceChannelCallbackProvider2 = new GetQCommerceChannelCallbackProvider(qCommerceMethodChannelFeatureLibImplApi);
            this.getQCommerceChannelCallbackProvider = getQCommerceChannelCallbackProvider2;
            this.provideDeeplinkNavigationNativeDomainProvider = SingleCheck.provider(QCommerceMethodChannelFeatureLibModule_ProvideDeeplinkNavigationNativeDomainFactory.create(getQCommerceChannelCallbackProvider2));
        }

        public QCommerceChannelFlutterDomain getQCommerceChannelFlutterDomain() {
            return this.provideDeeplinkNavigationNativeDomainProvider.get();
        }
    }

    private DaggerQCommerceMethodChannelFeatureLibComponent() {
    }

    public static QCommerceMethodChannelFeatureLibComponent.Factory factory() {
        return new Factory();
    }
}
