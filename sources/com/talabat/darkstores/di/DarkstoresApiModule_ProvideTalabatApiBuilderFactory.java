package com.talabat.darkstores.di;

import com.talabat.core.network.network.TalabatAPIBuilder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApiModule_ProvideTalabatApiBuilderFactory implements Factory<TalabatAPIBuilder> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApiModule_ProvideTalabatApiBuilderFactory INSTANCE = new DarkstoresApiModule_ProvideTalabatApiBuilderFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApiModule_ProvideTalabatApiBuilderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TalabatAPIBuilder provideTalabatApiBuilder() {
        return (TalabatAPIBuilder) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideTalabatApiBuilder());
    }

    public TalabatAPIBuilder get() {
        return provideTalabatApiBuilder();
    }
}
