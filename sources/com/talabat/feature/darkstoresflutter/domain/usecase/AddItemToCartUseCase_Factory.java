package com.talabat.feature.darkstoresflutter.domain.usecase;

import com.talabat.feature.darkstoresflutter.domain.repository.DarkstoresCartFlutterRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddItemToCartUseCase_Factory implements Factory<AddItemToCartUseCase> {
    private final Provider<DarkstoresCartFlutterRepository> repositoryProvider;

    public AddItemToCartUseCase_Factory(Provider<DarkstoresCartFlutterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static AddItemToCartUseCase_Factory create(Provider<DarkstoresCartFlutterRepository> provider) {
        return new AddItemToCartUseCase_Factory(provider);
    }

    public static AddItemToCartUseCase newInstance(DarkstoresCartFlutterRepository darkstoresCartFlutterRepository) {
        return new AddItemToCartUseCase(darkstoresCartFlutterRepository);
    }

    public AddItemToCartUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
