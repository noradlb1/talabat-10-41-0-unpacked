package com.talabat.feature.tpro.presentation.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import org.jetbrains.annotations.Nullable;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TproPresentationModule_ProvideTProMultiPlanDurationsFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TproPresentationModule_ProvideTProMultiPlanDurationsFactory INSTANCE = new TproPresentationModule_ProvideTProMultiPlanDurationsFactory();

        private InstanceHolder() {
        }
    }

    public static TproPresentationModule_ProvideTProMultiPlanDurationsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    @Nullable
    public static String provideTProMultiPlanDurations() {
        return TproPresentationModule.INSTANCE.provideTProMultiPlanDurations();
    }

    @Nullable
    public String get() {
        return provideTProMultiPlanDurations();
    }
}
