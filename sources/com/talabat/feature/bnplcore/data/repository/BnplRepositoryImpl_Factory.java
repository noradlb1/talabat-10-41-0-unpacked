package com.talabat.feature.bnplcore.data.repository;

import com.talabat.feature.bnplcore.data.remote.BnplApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BnplRepositoryImpl_Factory implements Factory<BnplRepositoryImpl> {
    private final Provider<BnplApi> clientProvider;

    public BnplRepositoryImpl_Factory(Provider<BnplApi> provider) {
        this.clientProvider = provider;
    }

    public static BnplRepositoryImpl_Factory create(Provider<BnplApi> provider) {
        return new BnplRepositoryImpl_Factory(provider);
    }

    public static BnplRepositoryImpl newInstance(BnplApi bnplApi) {
        return new BnplRepositoryImpl(bnplApi);
    }

    public BnplRepositoryImpl get() {
        return newInstance(this.clientProvider.get());
    }
}
