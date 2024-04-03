package com.talabat.core.safety.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.DebugValue"})
public final class IdentifiersModule_DebugValueFactory implements Factory<Boolean> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IdentifiersModule_DebugValueFactory INSTANCE = new IdentifiersModule_DebugValueFactory();

        private InstanceHolder() {
        }
    }

    public static IdentifiersModule_DebugValueFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean debugValue() {
        return IdentifiersModule.INSTANCE.debugValue();
    }

    public Boolean get() {
        return Boolean.valueOf(debugValue());
    }
}
