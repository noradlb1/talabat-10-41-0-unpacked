package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DefaultCardView_MembersInjector implements MembersInjector<DefaultCardView> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public DefaultCardView_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagRepoProvider = provider;
    }

    public static MembersInjector<DefaultCardView> create(Provider<ITalabatFeatureFlag> provider) {
        return new DefaultCardView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView.featureFlagRepo")
    public static void injectFeatureFlagRepo(DefaultCardView defaultCardView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        defaultCardView.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(DefaultCardView defaultCardView) {
        injectFeatureFlagRepo(defaultCardView, this.featureFlagRepoProvider.get());
    }
}
