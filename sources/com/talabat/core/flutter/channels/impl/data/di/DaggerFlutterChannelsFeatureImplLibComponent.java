package com.talabat.core.flutter.channels.impl.data.di;

import com.squareup.moshi.Moshi;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import com.talabat.core.flutter.channels.impl.data.di.FlutterChannelsFeatureImplLibComponent;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceDataModule;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceDataModule_ProvideNonMigratedCartFactory;
import com.talabat.core.flutter.channels.impl.data.qcommerce.QCommerceDataModule_ProvideUniversalGsonFactory;
import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.tpro.TProDataModule;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFlutterChannelsFeatureImplLibComponent {

    public static final class Factory implements FlutterChannelsFeatureImplLibComponent.Factory {
        private Factory() {
        }

        public FlutterChannelsFeatureImplLibComponent create(NavigationCoreLibApi navigationCoreLibApi, ParserCoreLibApi parserCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi) {
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            return new FlutterChannelsFeatureImplLibComponentImpl(new QCommerceDataModule(), navigationCoreLibApi, parserCoreLibApi, subscriptionsFeatureApi);
        }
    }

    public static final class FlutterChannelsFeatureImplLibComponentImpl implements FlutterChannelsFeatureImplLibComponent {
        private final FlutterChannelsFeatureImplLibComponentImpl flutterChannelsFeatureImplLibComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final QCommerceDataModule qCommerceDataModule;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private FlutterChannelsFeatureImplLibComponentImpl(QCommerceDataModule qCommerceDataModule2, NavigationCoreLibApi navigationCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2) {
            this.flutterChannelsFeatureImplLibComponentImpl = this;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.qCommerceDataModule = qCommerceDataModule2;
            this.parserCoreLibApi = parserCoreLibApi2;
        }

        private GetTProVendorMovUseCase getTProVendorMovUseCase() {
            return new GetTProVendorMovUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()));
        }

        private ProCentralizationStatusWrapper proCentralizationStatusWrapper() {
            return new ProCentralizationStatusWrapper((GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase()), (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
        }

        private QCommerceChannelCallbackImpl qCommerceChannelCallbackImpl() {
            return new QCommerceChannelCallbackImpl((Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()), QCommerceDataModule_ProvideNonMigratedCartFactory.provideNonMigratedCart(this.qCommerceDataModule), (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()), QCommerceDataModule_ProvideUniversalGsonFactory.provideUniversalGson(this.qCommerceDataModule));
        }

        private TProChannelCallbackImpl tProChannelCallbackImpl() {
            return new TProChannelCallbackImpl(getTProVendorMovUseCase(), (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()), TProDataModule.INSTANCE.provideTProPlanMOV(), proCentralizationStatusWrapper());
        }

        public QCommerceChannelCallback getQCommerceChannelCallback() {
            return qCommerceChannelCallbackImpl();
        }

        public TProChannelCallback getTProChannelCallback() {
            return tProChannelCallbackImpl();
        }
    }

    private DaggerFlutterChannelsFeatureImplLibComponent() {
    }

    public static FlutterChannelsFeatureImplLibComponent.Factory factory() {
        return new Factory();
    }
}
