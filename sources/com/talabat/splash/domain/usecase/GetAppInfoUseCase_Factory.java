package com.talabat.splash.domain.usecase;

import android.content.Context;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import com.talabat.splash.data.repositories.AppInfoRepository;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepository;
import com.talabat.splash.domain.model.AppInfoGlobalConstantsWrapper;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import library.talabat.mvp.login.domain.repository.CustomerRepository;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class GetAppInfoUseCase_Factory implements Factory<GetAppInfoUseCase> {
    private final Provider<AppInfoGlobalConstantsWrapper> appInfoGlobalConstantsWrapperProvider;
    private final Provider<AppInfoRepository> appInfoRepositoryProvider;
    private final Provider<BrazeUserMigrator> brazeMigratorProvider;
    private final Provider<Context> contextProvider;
    private final Provider<CustomerInfoRepository> customerInfoRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;
    private final Provider<RetrieveAndCacheCustomerAddressesUseCase> retrieveAndCacheCustomerAddressesUseCaseProvider;
    private final Provider<SplashCustomerInfoRepository> splashCustomerInfoRepositoryProvider;
    private final Provider<UserStatusRepository> userStatusRepositoryProvider;

    public GetAppInfoUseCase_Factory(Provider<AppInfoRepository> provider, Provider<Context> provider2, Provider<AppInfoGlobalConstantsWrapper> provider3, Provider<RetrieveAndCacheCustomerAddressesUseCase> provider4, Provider<UserStatusRepository> provider5, Provider<CustomerInfoRepository> provider6, Provider<CustomerRepository> provider7, Provider<LocationConfigurationRepository> provider8, Provider<SplashCustomerInfoRepository> provider9, Provider<BrazeUserMigrator> provider10) {
        this.appInfoRepositoryProvider = provider;
        this.contextProvider = provider2;
        this.appInfoGlobalConstantsWrapperProvider = provider3;
        this.retrieveAndCacheCustomerAddressesUseCaseProvider = provider4;
        this.userStatusRepositoryProvider = provider5;
        this.customerInfoRepositoryProvider = provider6;
        this.customerRepositoryProvider = provider7;
        this.locationConfigRepositoryProvider = provider8;
        this.splashCustomerInfoRepositoryProvider = provider9;
        this.brazeMigratorProvider = provider10;
    }

    public static GetAppInfoUseCase_Factory create(Provider<AppInfoRepository> provider, Provider<Context> provider2, Provider<AppInfoGlobalConstantsWrapper> provider3, Provider<RetrieveAndCacheCustomerAddressesUseCase> provider4, Provider<UserStatusRepository> provider5, Provider<CustomerInfoRepository> provider6, Provider<CustomerRepository> provider7, Provider<LocationConfigurationRepository> provider8, Provider<SplashCustomerInfoRepository> provider9, Provider<BrazeUserMigrator> provider10) {
        return new GetAppInfoUseCase_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static GetAppInfoUseCase newInstance(AppInfoRepository appInfoRepository, Context context, AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper, RetrieveAndCacheCustomerAddressesUseCase retrieveAndCacheCustomerAddressesUseCase, UserStatusRepository userStatusRepository, CustomerInfoRepository customerInfoRepository, CustomerRepository customerRepository, LocationConfigurationRepository locationConfigurationRepository, SplashCustomerInfoRepository splashCustomerInfoRepository, BrazeUserMigrator brazeUserMigrator) {
        return new GetAppInfoUseCase(appInfoRepository, context, appInfoGlobalConstantsWrapper, retrieveAndCacheCustomerAddressesUseCase, userStatusRepository, customerInfoRepository, customerRepository, locationConfigurationRepository, splashCustomerInfoRepository, brazeUserMigrator);
    }

    public GetAppInfoUseCase get() {
        return newInstance(this.appInfoRepositoryProvider.get(), this.contextProvider.get(), this.appInfoGlobalConstantsWrapperProvider.get(), this.retrieveAndCacheCustomerAddressesUseCaseProvider.get(), this.userStatusRepositoryProvider.get(), this.customerInfoRepositoryProvider.get(), this.customerRepositoryProvider.get(), this.locationConfigRepositoryProvider.get(), this.splashCustomerInfoRepositoryProvider.get(), this.brazeMigratorProvider.get());
    }
}
