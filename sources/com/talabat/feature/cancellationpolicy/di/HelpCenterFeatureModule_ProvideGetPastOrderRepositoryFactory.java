package com.talabat.feature.cancellationpolicy.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class HelpCenterFeatureModule_ProvideGetPastOrderRepositoryFactory implements Factory<ICancellationPolicyRepository> {
    private final Provider<ICancellationPolicyMapper> cancellationPolicyMapperProvider;
    private final Provider<CancellationPolicyService> cancellationPolicyServiceProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<Integer> countryIdProvider;
    private final Provider<Integer> verticalTypeProvider;

    public HelpCenterFeatureModule_ProvideGetPastOrderRepositoryFactory(Provider<CoroutineDispatchersFactory> provider, Provider<CancellationPolicyService> provider2, Provider<ICancellationPolicyMapper> provider3, Provider<Integer> provider4, Provider<Integer> provider5) {
        this.coroutineDispatchersFactoryProvider = provider;
        this.cancellationPolicyServiceProvider = provider2;
        this.cancellationPolicyMapperProvider = provider3;
        this.countryIdProvider = provider4;
        this.verticalTypeProvider = provider5;
    }

    public static HelpCenterFeatureModule_ProvideGetPastOrderRepositoryFactory create(Provider<CoroutineDispatchersFactory> provider, Provider<CancellationPolicyService> provider2, Provider<ICancellationPolicyMapper> provider3, Provider<Integer> provider4, Provider<Integer> provider5) {
        return new HelpCenterFeatureModule_ProvideGetPastOrderRepositoryFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ICancellationPolicyRepository provideGetPastOrderRepository(CoroutineDispatchersFactory coroutineDispatchersFactory, CancellationPolicyService cancellationPolicyService, ICancellationPolicyMapper iCancellationPolicyMapper, int i11, int i12) {
        return (ICancellationPolicyRepository) Preconditions.checkNotNullFromProvides(HelpCenterFeatureModule.INSTANCE.provideGetPastOrderRepository(coroutineDispatchersFactory, cancellationPolicyService, iCancellationPolicyMapper, i11, i12));
    }

    public ICancellationPolicyRepository get() {
        return provideGetPastOrderRepository(this.coroutineDispatchersFactoryProvider.get(), this.cancellationPolicyServiceProvider.get(), this.cancellationPolicyMapperProvider.get(), this.countryIdProvider.get().intValue(), this.verticalTypeProvider.get().intValue());
    }
}
