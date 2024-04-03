package com.talabat.authentication.natives.di.fake;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.JwtTokenRepository;
import com.talabat.authentication.natives.di.fake.FakeJwtTokenCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFakeJwtTokenCoreLibComponent {

    public static final class Factory implements FakeJwtTokenCoreLibComponent.Factory {
        private Factory() {
        }

        public FakeJwtTokenCoreLibComponent create() {
            return new FakeJwtTokenCoreLibComponentImpl();
        }
    }

    public static final class FakeJwtTokenCoreLibComponentImpl implements FakeJwtTokenCoreLibComponent {
        private final FakeJwtTokenCoreLibComponentImpl fakeJwtTokenCoreLibComponentImpl;
        private Provider<JwtTokenManager> managerProvider;
        private Provider<JwtTokenRepository> repositoryProvider;

        private FakeJwtTokenCoreLibComponentImpl() {
            this.fakeJwtTokenCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            Provider<JwtTokenManager> provider = SingleCheck.provider(FakeJwtTokenCoreLibModule_ManagerFactory.create());
            this.managerProvider = provider;
            this.repositoryProvider = SingleCheck.provider(FakeJwtTokenCoreLibModule_RepositoryFactory.create(provider));
        }

        public JwtTokenRepository getJwtTokenRepository() {
            return this.repositoryProvider.get();
        }
    }

    private DaggerFakeJwtTokenCoreLibComponent() {
    }

    public static FakeJwtTokenCoreLibComponent create() {
        return new Factory().create();
    }

    public static FakeJwtTokenCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
