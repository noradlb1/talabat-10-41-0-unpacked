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
public final class ClearCartUseCase_Factory implements Factory<ClearCartUseCase> {
    private final Provider<DarkstoresCartFlutterRepository> repositoryProvider;

    public ClearCartUseCase_Factory(Provider<DarkstoresCartFlutterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static ClearCartUseCase_Factory create(Provider<DarkstoresCartFlutterRepository> provider) {
        return new ClearCartUseCase_Factory(provider);
    }

    public static ClearCartUseCase newInstance(DarkstoresCartFlutterRepository darkstoresCartFlutterRepository) {
        return new ClearCartUseCase(darkstoresCartFlutterRepository);
    }

    public ClearCartUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
