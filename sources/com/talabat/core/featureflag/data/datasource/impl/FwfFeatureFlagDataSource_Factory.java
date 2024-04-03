package com.talabat.core.featureflag.data.datasource.impl;

import com.talabat.core.fwf.domain.IFunWithFlags;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FwfFeatureFlagDataSource_Factory implements Factory<FwfFeatureFlagDataSource> {
    private final Provider<IFunWithFlags> funWithFlagsProvider;

    public FwfFeatureFlagDataSource_Factory(Provider<IFunWithFlags> provider) {
        this.funWithFlagsProvider = provider;
    }

    public static FwfFeatureFlagDataSource_Factory create(Provider<IFunWithFlags> provider) {
        return new FwfFeatureFlagDataSource_Factory(provider);
    }

    public static FwfFeatureFlagDataSource newInstance(IFunWithFlags iFunWithFlags) {
        return new FwfFeatureFlagDataSource(iFunWithFlags);
    }

    public FwfFeatureFlagDataSource get() {
        return newInstance(this.funWithFlagsProvider.get());
    }
}
