package com.talabat.hms.maps.data.di;

import com.talabat.secrets.Secrets;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HmsMapsModule_Companion_SecretsFactory implements Factory<Secrets> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HmsMapsModule_Companion_SecretsFactory INSTANCE = new HmsMapsModule_Companion_SecretsFactory();

        private InstanceHolder() {
        }
    }

    public static HmsMapsModule_Companion_SecretsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Secrets secrets() {
        return (Secrets) Preconditions.checkNotNullFromProvides(HmsMapsModule.Companion.secrets());
    }

    public Secrets get() {
        return secrets();
    }
}
