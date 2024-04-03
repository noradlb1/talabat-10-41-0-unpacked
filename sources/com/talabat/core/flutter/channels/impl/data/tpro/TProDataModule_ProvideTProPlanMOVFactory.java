package com.talabat.core.flutter.channels.impl.data.tpro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TProDataModule_ProvideTProPlanMOVFactory implements Factory<Float> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TProDataModule_ProvideTProPlanMOVFactory INSTANCE = new TProDataModule_ProvideTProPlanMOVFactory();

        private InstanceHolder() {
        }
    }

    public static TProDataModule_ProvideTProPlanMOVFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static float provideTProPlanMOV() {
        return TProDataModule.INSTANCE.provideTProPlanMOV();
    }

    public Float get() {
        return Float.valueOf(provideTProPlanMOV());
    }
}
