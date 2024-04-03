package com.talabat.feature.tpro.presentation.di;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TProVendorMovModule_ProvideIsTproUserFactory implements Factory<Boolean> {
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;

    public TProVendorMovModule_ProvideIsTproUserFactory(Provider<ISubscriptionStatusRepository> provider) {
        this.subscriptionStatusRepositoryProvider = provider;
    }

    public static TProVendorMovModule_ProvideIsTproUserFactory create(Provider<ISubscriptionStatusRepository> provider) {
        return new TProVendorMovModule_ProvideIsTproUserFactory(provider);
    }

    public static boolean provideIsTproUser(ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        return TProVendorMovModule.INSTANCE.provideIsTproUser(iSubscriptionStatusRepository);
    }

    public Boolean get() {
        return Boolean.valueOf(provideIsTproUser(this.subscriptionStatusRepositoryProvider.get()));
    }
}
