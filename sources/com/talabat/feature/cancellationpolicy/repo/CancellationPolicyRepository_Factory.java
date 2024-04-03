package com.talabat.feature.cancellationpolicy.repo;

import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyRepository_Factory implements Factory<CancellationPolicyRepository> {
    private final Provider<ICancellationPolicyMapper> cancellationPolicyMapperProvider;
    private final Provider<CancellationPolicyService> cancellationPolicyServiceProvider;
    private final Provider<String> countryIdProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<String> verticalTypeProvider;

    public CancellationPolicyRepository_Factory(Provider<CancellationPolicyService> provider, Provider<ICancellationPolicyMapper> provider2, Provider<CoroutineDispatcher> provider3, Provider<String> provider4, Provider<String> provider5) {
        this.cancellationPolicyServiceProvider = provider;
        this.cancellationPolicyMapperProvider = provider2;
        this.ioDispatcherProvider = provider3;
        this.countryIdProvider = provider4;
        this.verticalTypeProvider = provider5;
    }

    public static CancellationPolicyRepository_Factory create(Provider<CancellationPolicyService> provider, Provider<ICancellationPolicyMapper> provider2, Provider<CoroutineDispatcher> provider3, Provider<String> provider4, Provider<String> provider5) {
        return new CancellationPolicyRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CancellationPolicyRepository newInstance(CancellationPolicyService cancellationPolicyService, ICancellationPolicyMapper iCancellationPolicyMapper, CoroutineDispatcher coroutineDispatcher, String str, String str2) {
        return new CancellationPolicyRepository(cancellationPolicyService, iCancellationPolicyMapper, coroutineDispatcher, str, str2);
    }

    public CancellationPolicyRepository get() {
        return newInstance(this.cancellationPolicyServiceProvider.get(), this.cancellationPolicyMapperProvider.get(), this.ioDispatcherProvider.get(), this.countryIdProvider.get(), this.verticalTypeProvider.get());
    }
}
