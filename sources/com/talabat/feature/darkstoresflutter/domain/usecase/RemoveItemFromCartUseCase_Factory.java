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
public final class RemoveItemFromCartUseCase_Factory implements Factory<RemoveItemFromCartUseCase> {
    private final Provider<DarkstoresCartFlutterRepository> repositoryProvider;

    public RemoveItemFromCartUseCase_Factory(Provider<DarkstoresCartFlutterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static RemoveItemFromCartUseCase_Factory create(Provider<DarkstoresCartFlutterRepository> provider) {
        return new RemoveItemFromCartUseCase_Factory(provider);
    }

    public static RemoveItemFromCartUseCase newInstance(DarkstoresCartFlutterRepository darkstoresCartFlutterRepository) {
        return new RemoveItemFromCartUseCase(darkstoresCartFlutterRepository);
    }

    public RemoveItemFromCartUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
