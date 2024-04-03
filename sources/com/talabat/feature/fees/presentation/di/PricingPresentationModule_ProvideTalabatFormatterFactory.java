package com.talabat.feature.fees.presentation.di;

import buisnessmodels.TalabatFormatter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PricingPresentationModule_ProvideTalabatFormatterFactory implements Factory<TalabatFormatter> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PricingPresentationModule_ProvideTalabatFormatterFactory INSTANCE = new PricingPresentationModule_ProvideTalabatFormatterFactory();

        private InstanceHolder() {
        }
    }

    public static PricingPresentationModule_ProvideTalabatFormatterFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TalabatFormatter provideTalabatFormatter() {
        return (TalabatFormatter) Preconditions.checkNotNullFromProvides(PricingPresentationModule.INSTANCE.provideTalabatFormatter());
    }

    public TalabatFormatter get() {
        return provideTalabatFormatter();
    }
}
