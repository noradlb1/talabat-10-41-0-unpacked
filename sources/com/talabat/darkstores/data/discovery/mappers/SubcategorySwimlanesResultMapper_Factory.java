package com.talabat.darkstores.data.discovery.mappers;

import com.talabat.darkstores.data.discovery.model.NetworkSortOption;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubcategorySwimlanesResultMapper_Factory implements Factory<SubcategorySwimlanesResultMapper> {
    private final Provider<ModelMapper<NetworkSortOption, SortOption>> sortOptionMapperProvider;

    public SubcategorySwimlanesResultMapper_Factory(Provider<ModelMapper<NetworkSortOption, SortOption>> provider) {
        this.sortOptionMapperProvider = provider;
    }

    public static SubcategorySwimlanesResultMapper_Factory create(Provider<ModelMapper<NetworkSortOption, SortOption>> provider) {
        return new SubcategorySwimlanesResultMapper_Factory(provider);
    }

    public static SubcategorySwimlanesResultMapper newInstance(ModelMapper<NetworkSortOption, SortOption> modelMapper) {
        return new SubcategorySwimlanesResultMapper(modelMapper);
    }

    public SubcategorySwimlanesResultMapper get() {
        return newInstance(this.sortOptionMapperProvider.get());
    }
}
