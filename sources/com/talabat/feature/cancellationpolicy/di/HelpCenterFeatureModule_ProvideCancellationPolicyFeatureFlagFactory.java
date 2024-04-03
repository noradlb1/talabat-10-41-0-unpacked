package com.talabat.feature.cancellationpolicy.di;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HelpCenterFeatureModule_ProvideCancellationPolicyFeatureFlagFactory implements Factory<ICancellationPolicyFlag> {
    private final Provider<ITalabatFeatureFlag> iTalabatFeatureFlagProvider;

    public HelpCenterFeatureModule_ProvideCancellationPolicyFeatureFlagFactory(Provider<ITalabatFeatureFlag> provider) {
        this.iTalabatFeatureFlagProvider = provider;
    }

    public static HelpCenterFeatureModule_ProvideCancellationPolicyFeatureFlagFactory create(Provider<ITalabatFeatureFlag> provider) {
        return new HelpCenterFeatureModule_ProvideCancellationPolicyFeatureFlagFactory(provider);
    }

    public static ICancellationPolicyFlag provideCancellationPolicyFeatureFlag(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return (ICancellationPolicyFlag) Preconditions.checkNotNullFromProvides(HelpCenterFeatureModule.INSTANCE.provideCancellationPolicyFeatureFlag(iTalabatFeatureFlag));
    }

    public ICancellationPolicyFlag get() {
        return provideCancellationPolicyFeatureFlag(this.iTalabatFeatureFlagProvider.get());
    }
}
