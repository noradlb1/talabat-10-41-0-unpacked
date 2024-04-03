package com.talabat.feature.tpro.presentation.di;

import buisnessmodels.TalabatFormatter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproPresentationModule_ProvideTalabatFormatterFactory implements Factory<TalabatFormatter> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TproPresentationModule_ProvideTalabatFormatterFactory INSTANCE = new TproPresentationModule_ProvideTalabatFormatterFactory();

        private InstanceHolder() {
        }
    }

    public static TproPresentationModule_ProvideTalabatFormatterFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TalabatFormatter provideTalabatFormatter() {
        return (TalabatFormatter) Preconditions.checkNotNullFromProvides(TproPresentationModule.INSTANCE.provideTalabatFormatter());
    }

    public TalabatFormatter get() {
        return provideTalabatFormatter();
    }
}
