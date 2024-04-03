package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.MetadataError;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataErrorResponse;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MetadataMapper_Factory implements Factory<MetadataMapper> {
    private final Provider<ModelMapper<MetadataErrorResponse, MetadataError>> metadataErrorMapperProvider;

    public MetadataMapper_Factory(Provider<ModelMapper<MetadataErrorResponse, MetadataError>> provider) {
        this.metadataErrorMapperProvider = provider;
    }

    public static MetadataMapper_Factory create(Provider<ModelMapper<MetadataErrorResponse, MetadataError>> provider) {
        return new MetadataMapper_Factory(provider);
    }

    public static MetadataMapper newInstance(ModelMapper<MetadataErrorResponse, MetadataError> modelMapper) {
        return new MetadataMapper(modelMapper);
    }

    public MetadataMapper get() {
        return newInstance(this.metadataErrorMapperProvider.get());
    }
}
