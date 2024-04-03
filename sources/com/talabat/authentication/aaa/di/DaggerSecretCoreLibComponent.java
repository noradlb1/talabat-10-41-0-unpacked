package com.talabat.authentication.aaa.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerSecretCoreLibComponent {

    public static final class Builder {
        private Builder() {
        }

        public SecretCoreLibComponent build() {
            return new SecretCoreLibComponentImpl();
        }

        @Deprecated
        public Builder secretProviderModule(SecretProviderModule secretProviderModule) {
            Preconditions.checkNotNull(secretProviderModule);
            return this;
        }

        @Deprecated
        public Builder secretsModule(SecretsModule secretsModule) {
            Preconditions.checkNotNull(secretsModule);
            return this;
        }
    }

    public static final class SecretCoreLibComponentImpl implements SecretCoreLibComponent {
        private final SecretCoreLibComponentImpl secretCoreLibComponentImpl;
        private Provider<SecretProvider> secretProvider;

        private SecretCoreLibComponentImpl() {
            this.secretCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.secretProvider = SingleCheck.provider(SecretProviderModule_SecretProviderFactory.create(SecretsModule_SecretsFactory.create()));
        }

        public SecretProvider getSecretProvider() {
            return this.secretProvider.get();
        }
    }

    private DaggerSecretCoreLibComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SecretCoreLibComponent create() {
        return new Builder().build();
    }
}
