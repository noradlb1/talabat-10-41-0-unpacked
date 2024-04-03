package com.talabat.feature.ridertips.data.di;

import com.talabat.feature.ridertips.data.observability.RiderTipObservability;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RiderTipUserDataModule_ProvideRiderTipObservabilityFactory implements Factory<RiderTipObservability> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RiderTipUserDataModule_ProvideRiderTipObservabilityFactory INSTANCE = new RiderTipUserDataModule_ProvideRiderTipObservabilityFactory();

        private InstanceHolder() {
        }
    }

    public static RiderTipUserDataModule_ProvideRiderTipObservabilityFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RiderTipObservability provideRiderTipObservability() {
        return (RiderTipObservability) Preconditions.checkNotNullFromProvides(RiderTipUserDataModule.INSTANCE.provideRiderTipObservability());
    }

    public RiderTipObservability get() {
        return provideRiderTipObservability();
    }
}
