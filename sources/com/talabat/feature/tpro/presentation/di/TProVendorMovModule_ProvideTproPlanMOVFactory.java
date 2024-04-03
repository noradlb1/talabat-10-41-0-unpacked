package com.talabat.feature.tpro.presentation.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TProVendorMovModule_ProvideTproPlanMOVFactory implements Factory<Float> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TProVendorMovModule_ProvideTproPlanMOVFactory INSTANCE = new TProVendorMovModule_ProvideTproPlanMOVFactory();

        private InstanceHolder() {
        }
    }

    public static TProVendorMovModule_ProvideTproPlanMOVFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static float provideTproPlanMOV() {
        return TProVendorMovModule.INSTANCE.provideTproPlanMOV();
    }

    public Float get() {
        return Float.valueOf(provideTproPlanMOV());
    }
}
