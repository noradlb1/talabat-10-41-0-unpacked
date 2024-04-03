package com.talabat.userandlocation.login.ui.fragment.di;

import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment_MembersInjector;
import com.talabat.userandlocation.login.ui.fragment.di.EnterEmailFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerEnterEmailFragmentComponent {

    public static final class EnterEmailFragmentComponentImpl implements EnterEmailFragmentComponent {
        private final EnterEmailFragmentComponentImpl enterEmailFragmentComponentImpl;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final TokenCoreLibDataApi tokenCoreLibDataApi;

        private EnterEmailFragmentComponentImpl(ObservabilityCoreLibApi observabilityCoreLibApi2, TokenCoreLibDataApi tokenCoreLibDataApi2) {
            this.enterEmailFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.tokenCoreLibDataApi = tokenCoreLibDataApi2;
        }

        private EnterEmailFragment injectEnterEmailFragment(EnterEmailFragment enterEmailFragment) {
            EnterEmailFragment_MembersInjector.injectObservabilityManager(enterEmailFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            EnterEmailFragment_MembersInjector.injectTokenRepository(enterEmailFragment, (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getTokenRepository()));
            return enterEmailFragment;
        }

        public void inject(EnterEmailFragment enterEmailFragment) {
            injectEnterEmailFragment(enterEmailFragment);
        }
    }

    public static final class Factory implements EnterEmailFragmentComponent.Factory {
        private Factory() {
        }

        public EnterEmailFragmentComponent create(ObservabilityCoreLibApi observabilityCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibDataApi);
            return new EnterEmailFragmentComponentImpl(observabilityCoreLibApi, tokenCoreLibDataApi);
        }
    }

    private DaggerEnterEmailFragmentComponent() {
    }

    public static EnterEmailFragmentComponent.Factory factory() {
        return new Factory();
    }
}
