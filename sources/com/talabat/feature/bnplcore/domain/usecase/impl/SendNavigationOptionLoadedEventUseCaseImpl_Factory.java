package com.talabat.feature.bnplcore.domain.usecase.impl;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SendNavigationOptionLoadedEventUseCaseImpl_Factory implements Factory<SendNavigationOptionLoadedEventUseCaseImpl> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public SendNavigationOptionLoadedEventUseCaseImpl_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static SendNavigationOptionLoadedEventUseCaseImpl_Factory create(Provider<TalabatTracker> provider) {
        return new SendNavigationOptionLoadedEventUseCaseImpl_Factory(provider);
    }

    public static SendNavigationOptionLoadedEventUseCaseImpl newInstance(TalabatTracker talabatTracker) {
        return new SendNavigationOptionLoadedEventUseCaseImpl(talabatTracker);
    }

    public SendNavigationOptionLoadedEventUseCaseImpl get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
