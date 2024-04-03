package com.talabat.core.safety.data.repository.protection.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LocalProtectionRepository_Factory implements Factory<LocalProtectionRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LocalProtectionRepository_Factory INSTANCE = new LocalProtectionRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static LocalProtectionRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocalProtectionRepository newInstance() {
        return new LocalProtectionRepository();
    }

    public LocalProtectionRepository get() {
        return newInstance();
    }
}
