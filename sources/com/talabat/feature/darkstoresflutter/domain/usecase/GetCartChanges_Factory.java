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
public final class GetCartChanges_Factory implements Factory<GetCartChanges> {
    private final Provider<DarkstoresCartFlutterRepository> repositoryProvider;

    public GetCartChanges_Factory(Provider<DarkstoresCartFlutterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetCartChanges_Factory create(Provider<DarkstoresCartFlutterRepository> provider) {
        return new GetCartChanges_Factory(provider);
    }

    public static GetCartChanges newInstance(DarkstoresCartFlutterRepository darkstoresCartFlutterRepository) {
        return new GetCartChanges(darkstoresCartFlutterRepository);
    }

    public GetCartChanges get() {
        return newInstance(this.repositoryProvider.get());
    }
}
