package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ItemMapper_Factory implements Factory<ItemMapper> {
    private final Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> swimlaneProductMapperProvider;

    public ItemMapper_Factory(Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> provider) {
        this.swimlaneProductMapperProvider = provider;
    }

    public static ItemMapper_Factory create(Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> provider) {
        return new ItemMapper_Factory(provider);
    }

    public static ItemMapper newInstance(ModelMapper<SwimlaneProductResponse, SwimlaneProduct> modelMapper) {
        return new ItemMapper(modelMapper);
    }

    public ItemMapper get() {
        return newInstance(this.swimlaneProductMapperProvider.get());
    }
}
