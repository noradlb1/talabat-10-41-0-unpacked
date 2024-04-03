package com.talabat.talabatcommon.views.ridersTip;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RiderTipButton_MembersInjector implements MembersInjector<RiderTipButton> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public RiderTipButton_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagRepoProvider = provider;
    }

    public static MembersInjector<RiderTipButton> create(Provider<ITalabatFeatureFlag> provider) {
        return new RiderTipButton_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.ridersTip.RiderTipButton.featureFlagRepo")
    public static void injectFeatureFlagRepo(RiderTipButton riderTipButton, ITalabatFeatureFlag iTalabatFeatureFlag) {
        riderTipButton.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(RiderTipButton riderTipButton) {
        injectFeatureFlagRepo(riderTipButton, this.featureFlagRepoProvider.get());
    }
}
