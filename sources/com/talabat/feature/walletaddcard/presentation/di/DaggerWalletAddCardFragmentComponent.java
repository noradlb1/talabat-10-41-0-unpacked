package com.talabat.feature.walletaddcard.presentation.di;

import androidx.fragment.app.Fragment;
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
import com.talabat.feature.walletaddcard.presentation.di.WalletAddCardFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@DaggerGenerated
public final class DaggerWalletAddCardFragmentComponent {

    public static final class Factory implements WalletAddCardFragmentComponent.Factory {
        private Factory() {
        }

        public WalletAddCardFragmentComponent create(CoroutineScope coroutineScope, Fragment fragment, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback, WalletAddCardFeatureApi walletAddCardFeatureApi) {
            Preconditions.checkNotNull(coroutineScope);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(walletAddCardMethodChannelCallback);
            Preconditions.checkNotNull(walletAddCardFeatureApi);
            return new WalletAddCardFragmentComponentImpl(walletAddCardFeatureApi, coroutineScope, fragment, walletAddCardMethodChannelCallback);
        }
    }

    public static final class WalletAddCardFragmentComponentImpl implements WalletAddCardFragmentComponent {
        private Provider<CoroutineScope> coroutineScopeProvider;
        private final Fragment fragment;
        private Provider<GetCardTokenUseCase> getCardTokenUseCaseProvider;
        private Provider<WalletAddCardRepository> getRepositoryProvider;
        private Provider<IsBenefitEnabledUseCase> isBenefitEnabledUseCaseProvider;
        private Provider<IsQPayEnabledUseCase> isQPayEnabledUseCaseProvider;
        private final WalletAddCardFragmentComponentImpl walletAddCardFragmentComponentImpl;
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

        private WalletAddCardFragmentComponentImpl(WalletAddCardFeatureApi walletAddCardFeatureApi, CoroutineScope coroutineScope, Fragment fragment2, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback) {
            this.walletAddCardFragmentComponentImpl = this;
            this.fragment = fragment2;
            initialize(walletAddCardFeatureApi, coroutineScope, fragment2, walletAddCardMethodChannelCallback);
        }

        private void initialize(WalletAddCardFeatureApi walletAddCardFeatureApi, CoroutineScope coroutineScope, Fragment fragment2, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback) {
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

        private WalletFlutterAddCardFragment injectWalletFlutterAddCardFragment(WalletFlutterAddCardFragment walletFlutterAddCardFragment) {
            WalletFlutterAddCardFragment_MembersInjector.injectWalletMethodCallHandler(walletFlutterAddCardFragment, this.walletMethodCallHandlerProvider.get());
            WalletFlutterAddCardFragment_MembersInjector.injectWalletAddCard3DSHandler(walletFlutterAddCardFragment, walletAddCard3DSHandler());
            return walletFlutterAddCardFragment;
        }

        private WalletAddCard3DSHandler walletAddCard3DSHandler() {
            return new WalletAddCard3DSHandler(this.walletMethodCallHandlerProvider.get(), this.fragment);
        }

        public void inject(WalletFlutterAddCardFragment walletFlutterAddCardFragment) {
            injectWalletFlutterAddCardFragment(walletFlutterAddCardFragment);
        }
    }

    private DaggerWalletAddCardFragmentComponent() {
    }

    public static WalletAddCardFragmentComponent.Factory factory() {
        return new Factory();
    }
}
