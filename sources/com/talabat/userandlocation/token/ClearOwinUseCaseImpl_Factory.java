package com.talabat.userandlocation.token;

import android.content.Context;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ClearOwinUseCaseImpl_Factory implements Factory<ClearOwinUseCaseImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<IObservabilityManager> observabilityProvider;

    public ClearOwinUseCaseImpl_Factory(Provider<ITalabatFeatureFlag> provider, Provider<IObservabilityManager> provider2, Provider<Context> provider3) {
        this.featureFlagProvider = provider;
        this.observabilityProvider = provider2;
        this.contextProvider = provider3;
    }

    public static ClearOwinUseCaseImpl_Factory create(Provider<ITalabatFeatureFlag> provider, Provider<IObservabilityManager> provider2, Provider<Context> provider3) {
        return new ClearOwinUseCaseImpl_Factory(provider, provider2, provider3);
    }

    public static ClearOwinUseCaseImpl newInstance(ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager, Context context) {
        return new ClearOwinUseCaseImpl(iTalabatFeatureFlag, iObservabilityManager, context);
    }

    public ClearOwinUseCaseImpl get() {
        return newInstance(this.featureFlagProvider.get(), this.observabilityProvider.get(), this.contextProvider.get());
    }
}
