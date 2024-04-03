package com.talabat.core.featureflag.data.di;

import com.talabat.core.fwf.domain.IFunWithFlags;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FunWithFlagsModule_ProvideFunWithFlagsFactory implements Factory<IFunWithFlags> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FunWithFlagsModule_ProvideFunWithFlagsFactory INSTANCE = new FunWithFlagsModule_ProvideFunWithFlagsFactory();

        private InstanceHolder() {
        }
    }

    public static FunWithFlagsModule_ProvideFunWithFlagsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IFunWithFlags provideFunWithFlags() {
        return (IFunWithFlags) Preconditions.checkNotNullFromProvides(FunWithFlagsModule.INSTANCE.provideFunWithFlags());
    }

    public IFunWithFlags get() {
        return provideFunWithFlags();
    }
}
