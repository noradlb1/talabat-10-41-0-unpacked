package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TLifeOnBoardingFragment_MembersInjector implements MembersInjector<TLifeOnBoardingFragment> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public TLifeOnBoardingFragment_MembersInjector(Provider<ConfigurationLocalCoreLibApi> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.configurationLocalCoreLibApiProvider = provider;
        this.featureFlagRepoProvider = provider2;
    }

    public static MembersInjector<TLifeOnBoardingFragment> create(Provider<ConfigurationLocalCoreLibApi> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new TLifeOnBoardingFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingFragment.configurationLocalCoreLibApi")
    public static void injectConfigurationLocalCoreLibApi(TLifeOnBoardingFragment tLifeOnBoardingFragment, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        tLifeOnBoardingFragment.configurationLocalCoreLibApi = configurationLocalCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(TLifeOnBoardingFragment tLifeOnBoardingFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        tLifeOnBoardingFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(TLifeOnBoardingFragment tLifeOnBoardingFragment) {
        injectConfigurationLocalCoreLibApi(tLifeOnBoardingFragment, this.configurationLocalCoreLibApiProvider.get());
        injectFeatureFlagRepo(tLifeOnBoardingFragment, this.featureFlagRepoProvider.get());
    }
}
