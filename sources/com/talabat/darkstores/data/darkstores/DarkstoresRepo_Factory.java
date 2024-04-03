package com.talabat.darkstores.data.darkstores;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.discovery.ProductApi;
import com.talabat.darkstores.data.lookingglass.LookingGlassVoucherApi;
import com.talabat.darkstores.feature.cart.multibasket.Cart;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.features.swimlanevoucherslist.domain.LoadCustomerVouchersSwimLaneUseCase;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler", "javax.inject.Named"})
public final class DarkstoresRepo_Factory implements Factory<DarkstoresRepo> {
    private final Provider<BasketApi> basketApiProvider;
    private final Provider<ModelMapper<CartResponse, Cart>> cartResponseMapperProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<LoadCustomerVouchersSwimLaneUseCase> customerVouchersSwimLaneUseCaseProvider;
    private final Provider<DarkStoreObservabilityTracker> darkStoreObservabilityTrackerProvider;
    private final Provider<DarkstoresApi> darkstoresApiProvider;
    private final Provider<DarkstoresCartRepository> darkstoresCartRepositoryProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<LookingGlassVoucherApi> lookingGlassVoucherApiProvider;
    private final Provider<ProductApi> productApiProvider;
    private final Provider<Integer> selectedAreaIdProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;
    private final Provider<VendorRepository> vendorRepositoryProvider;

    public DarkstoresRepo_Factory(Provider<ConfigurationParameters> provider, Provider<DarkstoresApi> provider2, Provider<ProductApi> provider3, Provider<BasketApi> provider4, Provider<LookingGlassVoucherApi> provider5, Provider<DarkstoresEventTracker> provider6, Provider<VendorRepository> provider7, Provider<ConfigurationLocalRepository> provider8, Provider<DarkstoresCartRepository> provider9, Provider<ModelMapper<CartResponse, Cart>> provider10, Provider<DarkStoreObservabilityTracker> provider11, Provider<ITalabatFeatureFlag> provider12, Provider<Scheduler> provider13, Provider<LoadCustomerVouchersSwimLaneUseCase> provider14, Provider<Integer> provider15) {
        this.configurationParametersProvider = provider;
        this.darkstoresApiProvider = provider2;
        this.productApiProvider = provider3;
        this.basketApiProvider = provider4;
        this.lookingGlassVoucherApiProvider = provider5;
        this.trackerProvider = provider6;
        this.vendorRepositoryProvider = provider7;
        this.configurationLocalRepositoryProvider = provider8;
        this.darkstoresCartRepositoryProvider = provider9;
        this.cartResponseMapperProvider = provider10;
        this.darkStoreObservabilityTrackerProvider = provider11;
        this.talabatFeatureFlagProvider = provider12;
        this.ioSchedulerProvider = provider13;
        this.customerVouchersSwimLaneUseCaseProvider = provider14;
        this.selectedAreaIdProvider = provider15;
    }

    public static DarkstoresRepo_Factory create(Provider<ConfigurationParameters> provider, Provider<DarkstoresApi> provider2, Provider<ProductApi> provider3, Provider<BasketApi> provider4, Provider<LookingGlassVoucherApi> provider5, Provider<DarkstoresEventTracker> provider6, Provider<VendorRepository> provider7, Provider<ConfigurationLocalRepository> provider8, Provider<DarkstoresCartRepository> provider9, Provider<ModelMapper<CartResponse, Cart>> provider10, Provider<DarkStoreObservabilityTracker> provider11, Provider<ITalabatFeatureFlag> provider12, Provider<Scheduler> provider13, Provider<LoadCustomerVouchersSwimLaneUseCase> provider14, Provider<Integer> provider15) {
        return new DarkstoresRepo_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static DarkstoresRepo newInstance(ConfigurationParameters configurationParameters, DarkstoresApi darkstoresApi, ProductApi productApi, BasketApi basketApi, LookingGlassVoucherApi lookingGlassVoucherApi, DarkstoresEventTracker darkstoresEventTracker, VendorRepository vendorRepository, ConfigurationLocalRepository configurationLocalRepository, DarkstoresCartRepository darkstoresCartRepository, ModelMapper<CartResponse, Cart> modelMapper, DarkStoreObservabilityTracker darkStoreObservabilityTracker, ITalabatFeatureFlag iTalabatFeatureFlag, Scheduler scheduler, LoadCustomerVouchersSwimLaneUseCase loadCustomerVouchersSwimLaneUseCase, Provider<Integer> provider) {
        return new DarkstoresRepo(configurationParameters, darkstoresApi, productApi, basketApi, lookingGlassVoucherApi, darkstoresEventTracker, vendorRepository, configurationLocalRepository, darkstoresCartRepository, modelMapper, darkStoreObservabilityTracker, iTalabatFeatureFlag, scheduler, loadCustomerVouchersSwimLaneUseCase, provider);
    }

    public DarkstoresRepo get() {
        return newInstance(this.configurationParametersProvider.get(), this.darkstoresApiProvider.get(), this.productApiProvider.get(), this.basketApiProvider.get(), this.lookingGlassVoucherApiProvider.get(), this.trackerProvider.get(), this.vendorRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.darkstoresCartRepositoryProvider.get(), this.cartResponseMapperProvider.get(), this.darkStoreObservabilityTrackerProvider.get(), this.talabatFeatureFlagProvider.get(), this.ioSchedulerProvider.get(), this.customerVouchersSwimLaneUseCaseProvider.get(), this.selectedAreaIdProvider);
    }
}
