package com.talabat.feature.subscriptions.data.remote;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsDataSource_Factory implements Factory<SubscriptionsDataSource> {
    private final Provider<ProApi> proApiProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<SubscriptionsApi> subscriptionApiProvider;

    public SubscriptionsDataSource_Factory(Provider<SubscriptionsApi> provider, Provider<ProApi> provider2, Provider<SecretProvider> provider3) {
        this.subscriptionApiProvider = provider;
        this.proApiProvider = provider2;
        this.secretProvider = provider3;
    }

    public static SubscriptionsDataSource_Factory create(Provider<SubscriptionsApi> provider, Provider<ProApi> provider2, Provider<SecretProvider> provider3) {
        return new SubscriptionsDataSource_Factory(provider, provider2, provider3);
    }

    public static SubscriptionsDataSource newInstance(SubscriptionsApi subscriptionsApi, ProApi proApi, SecretProvider secretProvider2) {
        return new SubscriptionsDataSource(subscriptionsApi, proApi, secretProvider2);
    }

    public SubscriptionsDataSource get() {
        return newInstance(this.subscriptionApiProvider.get(), this.proApiProvider.get(), this.secretProvider.get());
    }
}
