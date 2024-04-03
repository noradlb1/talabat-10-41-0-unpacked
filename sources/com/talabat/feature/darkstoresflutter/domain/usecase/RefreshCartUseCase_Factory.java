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
public final class RefreshCartUseCase_Factory implements Factory<RefreshCartUseCase> {
    private final Provider<DarkstoresCartFlutterRepository> repositoryProvider;

    public RefreshCartUseCase_Factory(Provider<DarkstoresCartFlutterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static RefreshCartUseCase_Factory create(Provider<DarkstoresCartFlutterRepository> provider) {
        return new RefreshCartUseCase_Factory(provider);
    }

    public static RefreshCartUseCase newInstance(DarkstoresCartFlutterRepository darkstoresCartFlutterRepository) {
        return new RefreshCartUseCase(darkstoresCartFlutterRepository);
    }

    public RefreshCartUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
