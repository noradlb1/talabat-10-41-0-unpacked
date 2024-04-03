package com.talabat.authentication.aaa.di;

import com.talabat.authentication.aaa.AaaApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerAaaCoreLibComponent {

    public static final class AaaCoreLibComponentImpl implements AaaCoreLibComponent {
        private Provider<AaaApi> aaaApiProvider;
        private final AaaCoreLibComponentImpl aaaCoreLibComponentImpl;

        private AaaCoreLibComponentImpl() {
            this.aaaCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.aaaApiProvider = SingleCheck.provider(AaaModule_AaaApiFactory.create());
        }

        public AaaApi getAaaApi() {
            return this.aaaApiProvider.get();
        }
    }

    public static final class Builder {
        private Builder() {
        }

        @Deprecated
        public Builder aaaModule(AaaModule aaaModule) {
            Preconditions.checkNotNull(aaaModule);
            return this;
        }

        public AaaCoreLibComponent build() {
            return new AaaCoreLibComponentImpl();
        }
    }

    private DaggerAaaCoreLibComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AaaCoreLibComponent create() {
        return new Builder().build();
    }
}
