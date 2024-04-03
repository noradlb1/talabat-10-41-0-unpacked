package com.talabat.feature.pickup.presentation.di;

import com.talabat.feature.pickup.presentation.provider.CreditProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupPresentationModule_ProvideCreditBalanceFactory implements Factory<CreditProvider> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PickupPresentationModule_ProvideCreditBalanceFactory INSTANCE = new PickupPresentationModule_ProvideCreditBalanceFactory();

        private InstanceHolder() {
        }
    }

    public static PickupPresentationModule_ProvideCreditBalanceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CreditProvider provideCreditBalance() {
        return (CreditProvider) Preconditions.checkNotNullFromProvides(PickupPresentationModule.INSTANCE.provideCreditBalance());
    }

    public CreditProvider get() {
        return provideCreditBalance();
    }
}
