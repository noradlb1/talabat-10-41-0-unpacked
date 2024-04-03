package com.talabat.di.map;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.di.map.CustomAutoCompleteFragmentComponent;
import com.talabat.fragments.CustomAutoCompleteFragment;
import com.talabat.fragments.CustomAutoCompleteFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerCustomAutoCompleteFragmentComponent {

    public static final class CustomAutoCompleteFragmentComponentImpl implements CustomAutoCompleteFragmentComponent {
        private final CustomAutoCompleteFragmentComponentImpl customAutoCompleteFragmentComponentImpl;
        private final SecretCoreLibApi secretCoreLibApi;

        private CustomAutoCompleteFragmentComponentImpl(SecretCoreLibApi secretCoreLibApi2) {
            this.customAutoCompleteFragmentComponentImpl = this;
            this.secretCoreLibApi = secretCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private CustomAutoCompleteFragment injectCustomAutoCompleteFragment(CustomAutoCompleteFragment customAutoCompleteFragment) {
            CustomAutoCompleteFragment_MembersInjector.injectSecretProvider(customAutoCompleteFragment, (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider()));
            return customAutoCompleteFragment;
        }

        public void inject(CustomAutoCompleteFragment customAutoCompleteFragment) {
            injectCustomAutoCompleteFragment(customAutoCompleteFragment);
        }
    }

    public static final class Factory implements CustomAutoCompleteFragmentComponent.Factory {
        private Factory() {
        }

        public CustomAutoCompleteFragmentComponent create(SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(secretCoreLibApi);
            return new CustomAutoCompleteFragmentComponentImpl(secretCoreLibApi);
        }
    }

    private DaggerCustomAutoCompleteFragmentComponent() {
    }

    public static CustomAutoCompleteFragmentComponent.Factory factory() {
        return new Factory();
    }
}
