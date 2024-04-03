package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CardListFragment_MembersInjector implements MembersInjector<CardListFragment> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public CardListFragment_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagRepoProvider = provider;
    }

    public static MembersInjector<CardListFragment> create(Provider<ITalabatFeatureFlag> provider) {
        return new CardListFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(CardListFragment cardListFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        cardListFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(CardListFragment cardListFragment) {
        injectFeatureFlagRepo(cardListFragment, this.featureFlagRepoProvider.get());
    }
}
