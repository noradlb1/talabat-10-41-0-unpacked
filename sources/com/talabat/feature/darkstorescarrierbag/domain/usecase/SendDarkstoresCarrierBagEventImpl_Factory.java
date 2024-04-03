package com.talabat.feature.darkstorescarrierbag.domain.usecase;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SendDarkstoresCarrierBagEventImpl_Factory implements Factory<SendDarkstoresCarrierBagEventImpl> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public SendDarkstoresCarrierBagEventImpl_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static SendDarkstoresCarrierBagEventImpl_Factory create(Provider<TalabatTracker> provider) {
        return new SendDarkstoresCarrierBagEventImpl_Factory(provider);
    }

    public static SendDarkstoresCarrierBagEventImpl newInstance(TalabatTracker talabatTracker) {
        return new SendDarkstoresCarrierBagEventImpl(talabatTracker);
    }

    public SendDarkstoresCarrierBagEventImpl get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
