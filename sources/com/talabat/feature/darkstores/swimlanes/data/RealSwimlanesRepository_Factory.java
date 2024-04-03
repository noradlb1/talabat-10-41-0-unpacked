package com.talabat.feature.darkstores.swimlanes.data;

import com.talabat.configuration.country.Country;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.darkstores.swimlanes.data.remote.SwimlanesApi;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponse;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RealSwimlanesRepository_Factory implements Factory<RealSwimlanesRepository> {
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<Country> selectedCountryProvider;
    private final Provider<SwimlanesApi> swimlanesApiProvider;
    private final Provider<ModelMapper<SwimlanesResponse, SwimlanesData>> swimlanesMapperProvider;

    public RealSwimlanesRepository_Factory(Provider<Country> provider, Provider<SwimlanesApi> provider2, Provider<RxSchedulersFactory> provider3, Provider<ModelMapper<SwimlanesResponse, SwimlanesData>> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IObservabilityManager> provider6) {
        this.selectedCountryProvider = provider;
        this.swimlanesApiProvider = provider2;
        this.rxSchedulersFactoryProvider = provider3;
        this.swimlanesMapperProvider = provider4;
        this.featureFlagProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static RealSwimlanesRepository_Factory create(Provider<Country> provider, Provider<SwimlanesApi> provider2, Provider<RxSchedulersFactory> provider3, Provider<ModelMapper<SwimlanesResponse, SwimlanesData>> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IObservabilityManager> provider6) {
        return new RealSwimlanesRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static RealSwimlanesRepository newInstance(Country country, SwimlanesApi swimlanesApi, RxSchedulersFactory rxSchedulersFactory, ModelMapper<SwimlanesResponse, SwimlanesData> modelMapper, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager) {
        return new RealSwimlanesRepository(country, swimlanesApi, rxSchedulersFactory, modelMapper, iTalabatFeatureFlag, iObservabilityManager);
    }

    public RealSwimlanesRepository get() {
        return newInstance(this.selectedCountryProvider.get(), this.swimlanesApiProvider.get(), this.rxSchedulersFactoryProvider.get(), this.swimlanesMapperProvider.get(), this.featureFlagProvider.get(), this.observabilityManagerProvider.get());
    }
}
