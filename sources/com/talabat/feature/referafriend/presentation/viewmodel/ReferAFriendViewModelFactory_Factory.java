package com.talabat.feature.referafriend.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ReferAFriendViewModelFactory_Factory implements Factory<ReferAFriendViewModelFactory> {
    private final Provider<ReferAFriendViewModel> providerProvider;

    public ReferAFriendViewModelFactory_Factory(Provider<ReferAFriendViewModel> provider) {
        this.providerProvider = provider;
    }

    public static ReferAFriendViewModelFactory_Factory create(Provider<ReferAFriendViewModel> provider) {
        return new ReferAFriendViewModelFactory_Factory(provider);
    }

    public static ReferAFriendViewModelFactory newInstance(Provider<ReferAFriendViewModel> provider) {
        return new ReferAFriendViewModelFactory(provider);
    }

    public ReferAFriendViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
