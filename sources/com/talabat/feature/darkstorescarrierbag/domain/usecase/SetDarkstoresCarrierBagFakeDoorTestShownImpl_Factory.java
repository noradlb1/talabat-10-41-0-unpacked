package com.talabat.feature.darkstorescarrierbag.domain.usecase;

import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory implements Factory<SetDarkstoresCarrierBagFakeDoorTestShownImpl> {
    private final Provider<DarkstoresCarrierBagRepository> repositoryProvider;

    public SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory(Provider<DarkstoresCarrierBagRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory create(Provider<DarkstoresCarrierBagRepository> provider) {
        return new SetDarkstoresCarrierBagFakeDoorTestShownImpl_Factory(provider);
    }

    public static SetDarkstoresCarrierBagFakeDoorTestShownImpl newInstance(DarkstoresCarrierBagRepository darkstoresCarrierBagRepository) {
        return new SetDarkstoresCarrierBagFakeDoorTestShownImpl(darkstoresCarrierBagRepository);
    }

    public SetDarkstoresCarrierBagFakeDoorTestShownImpl get() {
        return newInstance(this.repositoryProvider.get());
    }
}
