package com.talabat.core.pinless.checkout.data;

import android.content.Context;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PinlessCheckoutRepository_Factory implements Factory<PinlessCheckoutRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public PinlessCheckoutRepository_Factory(Provider<Context> provider, Provider<TalabatTracker> provider2) {
        this.contextProvider = provider;
        this.talabatTrackerProvider = provider2;
    }

    public static PinlessCheckoutRepository_Factory create(Provider<Context> provider, Provider<TalabatTracker> provider2) {
        return new PinlessCheckoutRepository_Factory(provider, provider2);
    }

    public static PinlessCheckoutRepository newInstance(Context context, TalabatTracker talabatTracker) {
        return new PinlessCheckoutRepository(context, talabatTracker);
    }

    public PinlessCheckoutRepository get() {
        return newInstance(this.contextProvider.get(), this.talabatTrackerProvider.get());
    }
}
