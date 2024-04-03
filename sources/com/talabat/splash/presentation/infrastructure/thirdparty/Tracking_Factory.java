package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.content.Context;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class Tracking_Factory implements Factory<Tracking> {
    private final Provider<Context> contextProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;

    public Tracking_Factory(Provider<Context> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.contextProvider = provider;
        this.featureFlagProvider = provider2;
    }

    public static Tracking_Factory create(Provider<Context> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new Tracking_Factory(provider, provider2);
    }

    public static Tracking newInstance(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new Tracking(context, iTalabatFeatureFlag);
    }

    public Tracking get() {
        return newInstance(this.contextProvider.get(), this.featureFlagProvider.get());
    }
}
