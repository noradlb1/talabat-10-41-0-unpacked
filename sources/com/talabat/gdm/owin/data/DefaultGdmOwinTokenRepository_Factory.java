package com.talabat.gdm.owin.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGdmOwinTokenRepository_Factory implements Factory<DefaultGdmOwinTokenRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DefaultGdmOwinTokenRepository_Factory INSTANCE = new DefaultGdmOwinTokenRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static DefaultGdmOwinTokenRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DefaultGdmOwinTokenRepository newInstance() {
        return new DefaultGdmOwinTokenRepository();
    }

    public DefaultGdmOwinTokenRepository get() {
        return newInstance();
    }
}
