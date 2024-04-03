package com.talabat.tracking.event.ul.users;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LoginTracker_Factory implements Factory<LoginTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public LoginTracker_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static LoginTracker_Factory create(Provider<TalabatTracker> provider) {
        return new LoginTracker_Factory(provider);
    }

    public static LoginTracker newInstance(TalabatTracker talabatTracker) {
        return new LoginTracker(talabatTracker);
    }

    public LoginTracker get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
