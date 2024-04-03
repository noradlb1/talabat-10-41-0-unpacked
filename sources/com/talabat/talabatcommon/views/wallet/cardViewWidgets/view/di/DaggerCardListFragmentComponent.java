package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment_MembersInjector;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.di.CardListFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerCardListFragmentComponent {

    public static final class CardListFragmentComponentImpl implements CardListFragmentComponent {
        private final CardListFragmentComponentImpl cardListFragmentComponentImpl;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

        private CardListFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.cardListFragmentComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private CardListFragment injectCardListFragment(CardListFragment cardListFragment) {
            CardListFragment_MembersInjector.injectFeatureFlagRepo(cardListFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return cardListFragment;
        }

        public void inject(CardListFragment cardListFragment) {
            injectCardListFragment(cardListFragment);
        }
    }

    public static final class Factory implements CardListFragmentComponent.Factory {
        private Factory() {
        }

        public CardListFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new CardListFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    private DaggerCardListFragmentComponent() {
    }

    public static CardListFragmentComponent.Factory factory() {
        return new Factory();
    }
}
