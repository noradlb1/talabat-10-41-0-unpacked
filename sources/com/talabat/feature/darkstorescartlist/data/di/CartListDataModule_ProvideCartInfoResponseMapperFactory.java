package com.talabat.feature.darkstorescartlist.data.di;

import com.talabat.feature.darkstorescartlist.data.mapper.CartInfoResponseMapper;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartListDataModule_ProvideCartInfoResponseMapperFactory implements Factory<ModelMapper<CartInfoResponse, CartInfo>> {
    private final Provider<CartInfoResponseMapper> mapperProvider;
    private final CartListDataModule module;

    public CartListDataModule_ProvideCartInfoResponseMapperFactory(CartListDataModule cartListDataModule, Provider<CartInfoResponseMapper> provider) {
        this.module = cartListDataModule;
        this.mapperProvider = provider;
    }

    public static CartListDataModule_ProvideCartInfoResponseMapperFactory create(CartListDataModule cartListDataModule, Provider<CartInfoResponseMapper> provider) {
        return new CartListDataModule_ProvideCartInfoResponseMapperFactory(cartListDataModule, provider);
    }

    public static ModelMapper<CartInfoResponse, CartInfo> provideCartInfoResponseMapper(CartListDataModule cartListDataModule, CartInfoResponseMapper cartInfoResponseMapper) {
        return (ModelMapper) Preconditions.checkNotNullFromProvides(cartListDataModule.provideCartInfoResponseMapper(cartInfoResponseMapper));
    }

    public ModelMapper<CartInfoResponse, CartInfo> get() {
        return provideCartInfoResponseMapper(this.module, this.mapperProvider.get());
    }
}
