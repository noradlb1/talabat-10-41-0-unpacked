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
public final class NavigateToCheckoutUseCase_Factory implements Factory<NavigateToCheckoutUseCase> {
    private final Provider<DarkstoresCartFlutterRepository> repositoryProvider;

    public NavigateToCheckoutUseCase_Factory(Provider<DarkstoresCartFlutterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static NavigateToCheckoutUseCase_Factory create(Provider<DarkstoresCartFlutterRepository> provider) {
        return new NavigateToCheckoutUseCase_Factory(provider);
    }

    public static NavigateToCheckoutUseCase newInstance(DarkstoresCartFlutterRepository darkstoresCartFlutterRepository) {
        return new NavigateToCheckoutUseCase(darkstoresCartFlutterRepository);
    }

    public NavigateToCheckoutUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
