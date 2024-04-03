package com.talabat.darkstores.data.discovery;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class DiscoveryRepo_Factory implements Factory<DiscoveryRepo> {
    private final Provider<BasketApi> basketApiProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryApi> discoveryApiProvider;
    private final Provider<FeedApi> feedApiProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<ProductApi> productApiProvider;
    private final Provider<SearchTracker> searchTrackerProvider;
    private final Provider<ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse>> subcategoryResultMapperProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public DiscoveryRepo_Factory(Provider<ConfigurationParameters> provider, Provider<DarkstoresRepo> provider2, Provider<DiscoveryApi> provider3, Provider<BasketApi> provider4, Provider<FeedApi> provider5, Provider<ProductApi> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<Scheduler> provider8, Provider<SearchTracker> provider9, Provider<ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse>> provider10) {
        this.configurationParametersProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.discoveryApiProvider = provider3;
        this.basketApiProvider = provider4;
        this.feedApiProvider = provider5;
        this.productApiProvider = provider6;
        this.talabatFeatureFlagProvider = provider7;
        this.ioSchedulerProvider = provider8;
        this.searchTrackerProvider = provider9;
        this.subcategoryResultMapperProvider = provider10;
    }

    public static DiscoveryRepo_Factory create(Provider<ConfigurationParameters> provider, Provider<DarkstoresRepo> provider2, Provider<DiscoveryApi> provider3, Provider<BasketApi> provider4, Provider<FeedApi> provider5, Provider<ProductApi> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<Scheduler> provider8, Provider<SearchTracker> provider9, Provider<ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse>> provider10) {
        return new DiscoveryRepo_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static DiscoveryRepo newInstance(ConfigurationParameters configurationParameters, DarkstoresRepo darkstoresRepo, DiscoveryApi discoveryApi, BasketApi basketApi, FeedApi feedApi, ProductApi productApi, ITalabatFeatureFlag iTalabatFeatureFlag, Scheduler scheduler, SearchTracker searchTracker, ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse> modelMapper) {
        return new DiscoveryRepo(configurationParameters, darkstoresRepo, discoveryApi, basketApi, feedApi, productApi, iTalabatFeatureFlag, scheduler, searchTracker, modelMapper);
    }

    public DiscoveryRepo get() {
        return newInstance(this.configurationParametersProvider.get(), this.darkstoresRepoProvider.get(), this.discoveryApiProvider.get(), this.basketApiProvider.get(), this.feedApiProvider.get(), this.productApiProvider.get(), this.talabatFeatureFlagProvider.get(), this.ioSchedulerProvider.get(), this.searchTrackerProvider.get(), this.subcategoryResultMapperProvider.get());
    }
}
