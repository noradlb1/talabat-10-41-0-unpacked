package com.talabat.splash.data.repositories;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SplashCustomerInfoRepositoryImp_Factory implements Factory<SplashCustomerInfoRepositoryImp> {
    private final Provider<CustomerInfoRepository> customerInfoRepositoryProvider;
    private final Provider<CoroutineDispatcher> dispatcherIOProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public SplashCustomerInfoRepositoryImp_Factory(Provider<CustomerInfoRepository> provider, Provider<CoroutineDispatcher> provider2, Provider<ITalabatFeatureFlag> provider3) {
        this.customerInfoRepositoryProvider = provider;
        this.dispatcherIOProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
    }

    public static SplashCustomerInfoRepositoryImp_Factory create(Provider<CustomerInfoRepository> provider, Provider<CoroutineDispatcher> provider2, Provider<ITalabatFeatureFlag> provider3) {
        return new SplashCustomerInfoRepositoryImp_Factory(provider, provider2, provider3);
    }

    public static SplashCustomerInfoRepositoryImp newInstance(CustomerInfoRepository customerInfoRepository, CoroutineDispatcher coroutineDispatcher, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new SplashCustomerInfoRepositoryImp(customerInfoRepository, coroutineDispatcher, iTalabatFeatureFlag);
    }

    public SplashCustomerInfoRepositoryImp get() {
        return newInstance(this.customerInfoRepositoryProvider.get(), this.dispatcherIOProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
