package com.talabat.feature.bnpldashboard.presentation.di;

import androidx.fragment.app.Fragment;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment;
import com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment_MembersInjector;
import com.talabat.feature.bnpldashboard.presentation.di.BNPLDashboardFlutterFragmentComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase_Factory;
import com.talabat.feature.walletaddcard.domain.usecase.IsBenefitEnabledUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.IsBenefitEnabledUseCase_Factory;
import com.talabat.feature.walletaddcard.domain.usecase.IsQPayEnabledUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.IsQPayEnabledUseCase_Factory;
import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@DaggerGenerated
public final class DaggerBNPLDashboardFlutterFragmentComponent {

    public static final class BNPLDashboardFlutterFragmentComponentImpl implements BNPLDashboardFlutterFragmentComponent {
        private final BNPLDashboardFlutterFragmentComponentImpl bNPLDashboardFlutterFragmentComponentImpl;
        private Provider<CoroutineScope> coroutineScopeProvider;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final Fragment fragment;
        private Provider<GetCardTokenUseCase> getCardTokenUseCaseProvider;
        private Provider<WalletAddCardRepository> getRepositoryProvider;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private Provider<IsBenefitEnabledUseCase> isBenefitEnabledUseCaseProvider;
        private Provider<IsQPayEnabledUseCase> isQPayEnabledUseCaseProvider;
        private Provider<WalletMethodCallHandler.WalletAddCardMethodChannelCallback> walletAddCardMethodChannelCallbackProvider;
        private Provider<WalletMethodCallHandler> walletMethodCallHandlerProvider;

        public static final class GetRepositoryProvider implements Provider<WalletAddCardRepository> {
            private final WalletAddCardFeatureApi walletAddCardFeatureApi;

            public GetRepositoryProvider(WalletAddCardFeatureApi walletAddCardFeatureApi2) {
                this.walletAddCardFeatureApi = walletAddCardFeatureApi2;
            }

            public WalletAddCardRepository get() {
                return (WalletAddCardRepository) Preconditions.checkNotNullFromComponent(this.walletAddCardFeatureApi.getRepository());
            }
        }

        private BNPLDashboardFlutterFragmentComponentImpl(WalletAddCardFeatureApi walletAddCardFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, CoroutineScope coroutineScope, Fragment fragment2, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback) {
            this.bNPLDashboardFlutterFragmentComponentImpl = this;
            this.fragment = fragment2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            initialize(walletAddCardFeatureApi, deepLinkCoreLibApi2, helpCenterFeatureApi2, coroutineScope, fragment2, walletAddCardMethodChannelCallback);
        }

        private void initialize(WalletAddCardFeatureApi walletAddCardFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, CoroutineScope coroutineScope, Fragment fragment2, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback) {
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(walletAddCardFeatureApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.getCardTokenUseCaseProvider = GetCardTokenUseCase_Factory.create(getRepositoryProvider2);
            this.isQPayEnabledUseCaseProvider = IsQPayEnabledUseCase_Factory.create(this.getRepositoryProvider);
            this.isBenefitEnabledUseCaseProvider = IsBenefitEnabledUseCase_Factory.create(this.getRepositoryProvider);
            this.coroutineScopeProvider = InstanceFactory.create(coroutineScope);
            dagger.internal.Factory create = InstanceFactory.create(walletAddCardMethodChannelCallback);
            this.walletAddCardMethodChannelCallbackProvider = create;
            this.walletMethodCallHandlerProvider = SingleCheck.provider(WalletMethodCallHandler_Factory.create(this.getCardTokenUseCaseProvider, this.isQPayEnabledUseCaseProvider, this.isBenefitEnabledUseCaseProvider, this.coroutineScopeProvider, create));
        }

        private BNPLDashboardFlutterFragment injectBNPLDashboardFlutterFragment(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment) {
            BNPLDashboardFlutterFragment_MembersInjector.injectWalletMethodCallHandler(bNPLDashboardFlutterFragment, this.walletMethodCallHandlerProvider.get());
            BNPLDashboardFlutterFragment_MembersInjector.injectWalletAddCard3DSHandler(bNPLDashboardFlutterFragment, walletAddCard3DSHandler());
            BNPLDashboardFlutterFragment_MembersInjector.injectHelpCenterDeeplinkBuilder(bNPLDashboardFlutterFragment, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            BNPLDashboardFlutterFragment_MembersInjector.injectDeepLinkNavigator(bNPLDashboardFlutterFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return bNPLDashboardFlutterFragment;
        }

        private WalletAddCard3DSHandler walletAddCard3DSHandler() {
            return new WalletAddCard3DSHandler(this.walletMethodCallHandlerProvider.get(), this.fragment);
        }

        public void inject(BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment) {
            injectBNPLDashboardFlutterFragment(bNPLDashboardFlutterFragment);
        }
    }

    public static final class Factory implements BNPLDashboardFlutterFragmentComponent.Factory {
        private Factory() {
        }

        public BNPLDashboardFlutterFragmentComponent create(CoroutineScope coroutineScope, Fragment fragment, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback, WalletAddCardFeatureApi walletAddCardFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi) {
            Preconditions.checkNotNull(coroutineScope);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(walletAddCardMethodChannelCallback);
            Preconditions.checkNotNull(walletAddCardFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            return new BNPLDashboardFlutterFragmentComponentImpl(walletAddCardFeatureApi, deepLinkCoreLibApi, helpCenterFeatureApi, coroutineScope, fragment, walletAddCardMethodChannelCallback);
        }
    }

    private DaggerBNPLDashboardFlutterFragmentComponent() {
    }

    public static BNPLDashboardFlutterFragmentComponent.Factory factory() {
        return new Factory();
    }
}
