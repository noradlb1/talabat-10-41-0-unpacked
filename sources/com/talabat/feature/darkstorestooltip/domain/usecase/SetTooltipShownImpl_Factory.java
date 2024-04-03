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
public final class SetTooltipShownImpl_Factory implements Factory<SetTooltipShownImpl> {
    private final Provider<DarkstoresTooltipRepository> repositoryProvider;

    public SetTooltipShownImpl_Factory(Provider<DarkstoresTooltipRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static SetTooltipShownImpl_Factory create(Provider<DarkstoresTooltipRepository> provider) {
        return new SetTooltipShownImpl_Factory(provider);
    }

    public static SetTooltipShownImpl newInstance(DarkstoresTooltipRepository darkstoresTooltipRepository) {
        return new SetTooltipShownImpl(darkstoresTooltipRepository);
    }

    public SetTooltipShownImpl get() {
        return newInstance(this.repositoryProvider.get());
    }
}
