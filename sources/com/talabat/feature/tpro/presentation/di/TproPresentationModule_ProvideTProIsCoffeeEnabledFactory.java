package com.talabat.feature.tpro.presentation.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TproPresentationModule_ProvideTProIsCoffeeEnabledFactory implements Factory<Boolean> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TproPresentationModule_ProvideTProIsCoffeeEnabledFactory INSTANCE = new TproPresentationModule_ProvideTProIsCoffeeEnabledFactory();

        private InstanceHolder() {
        }
    }

    public static TproPresentationModule_ProvideTProIsCoffeeEnabledFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provideTProIsCoffeeEnabled() {
        return TproPresentationModule.INSTANCE.provideTProIsCoffeeEnabled();
    }

    public Boolean get() {
        return Boolean.valueOf(provideTProIsCoffeeEnabled());
    }
}
