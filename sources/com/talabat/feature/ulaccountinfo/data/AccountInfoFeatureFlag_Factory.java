package com.talabat.feature.ulaccountinfo.data;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AccountInfoFeatureFlag_Factory implements Factory<AccountInfoFeatureFlag> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public AccountInfoFeatureFlag_Factory(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static AccountInfoFeatureFlag_Factory create(Provider<ITalabatFeatureFlag> provider) {
        return new AccountInfoFeatureFlag_Factory(provider);
    }

    public static AccountInfoFeatureFlag newInstance(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new AccountInfoFeatureFlag(iTalabatFeatureFlag);
    }

    public AccountInfoFeatureFlag get() {
        return newInstance(this.talabatFeatureFlagProvider.get());
    }
}
