package com.talabat.feature.darkstorestooltip.domain.usecase;

import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WasTooltipAlreadyShownImpl_Factory implements Factory<WasTooltipAlreadyShownImpl> {
    private final Provider<DarkstoresTooltipRepository> repositoryProvider;

    public WasTooltipAlreadyShownImpl_Factory(Provider<DarkstoresTooltipRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static WasTooltipAlreadyShownImpl_Factory create(Provider<DarkstoresTooltipRepository> provider) {
        return new WasTooltipAlreadyShownImpl_Factory(provider);
    }

    public static WasTooltipAlreadyShownImpl newInstance(DarkstoresTooltipRepository darkstoresTooltipRepository) {
        return new WasTooltipAlreadyShownImpl(darkstoresTooltipRepository);
    }

    public WasTooltipAlreadyShownImpl get() {
        return newInstance(this.repositoryProvider.get());
    }
}
