package com.talabat.flutter.secrets.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.flutter.secrets.data.di.FlutterSecretsCoreLibComponent;
import com.talabat.flutter.secrets.data.handler.SecretsMethodCallHandlerImpl;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFlutterSecretsCoreLibComponent {

    public static final class Factory implements FlutterSecretsCoreLibComponent.Factory {
        private Factory() {
        }

        public FlutterSecretsCoreLibComponent create(SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(secretCoreLibApi);
            return new FlutterSecretsCoreLibComponentImpl(secretCoreLibApi);
        }
    }

    public static final class FlutterSecretsCoreLibComponentImpl implements FlutterSecretsCoreLibComponent {
        private final FlutterSecretsCoreLibComponentImpl flutterSecretsCoreLibComponentImpl;
        private final SecretCoreLibApi secretCoreLibApi;

        private FlutterSecretsCoreLibComponentImpl(SecretCoreLibApi secretCoreLibApi2) {
            this.flutterSecretsCoreLibComponentImpl = this;
            this.secretCoreLibApi = secretCoreLibApi2;
        }

        private SecretsMethodCallHandlerImpl secretsMethodCallHandlerImpl() {
            return new SecretsMethodCallHandlerImpl((SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider()));
        }

        public SecretsMethodCallHandler secretsMethodCallHandler() {
            return secretsMethodCallHandlerImpl();
        }
    }

    private DaggerFlutterSecretsCoreLibComponent() {
    }

    public static FlutterSecretsCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
