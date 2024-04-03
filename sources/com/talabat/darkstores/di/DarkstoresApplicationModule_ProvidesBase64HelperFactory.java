package com.talabat.darkstores.di;

import com.talabat.darkstores.common.helpers.Base64Helper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvidesBase64HelperFactory implements Factory<Base64Helper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApplicationModule_ProvidesBase64HelperFactory INSTANCE = new DarkstoresApplicationModule_ProvidesBase64HelperFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApplicationModule_ProvidesBase64HelperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Base64Helper providesBase64Helper() {
        return (Base64Helper) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.providesBase64Helper());
    }

    public Base64Helper get() {
        return providesBase64Helper();
    }
}
