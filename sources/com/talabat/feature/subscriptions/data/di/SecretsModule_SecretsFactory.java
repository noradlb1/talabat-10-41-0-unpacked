package com.talabat.feature.subscriptions.data.di;

import com.talabat.secrets.Secrets;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SecretsModule_SecretsFactory implements Factory<Secrets> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SecretsModule_SecretsFactory INSTANCE = new SecretsModule_SecretsFactory();

        private InstanceHolder() {
        }
    }

    public static SecretsModule_SecretsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Secrets secrets() {
        return (Secrets) Preconditions.checkNotNullFromProvides(SecretsModule.INSTANCE.secrets());
    }

    public Secrets get() {
        return secrets();
    }
}
