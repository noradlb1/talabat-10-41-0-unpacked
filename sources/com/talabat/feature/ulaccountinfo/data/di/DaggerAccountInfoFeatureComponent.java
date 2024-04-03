package com.talabat.feature.ulaccountinfo.data.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.ulaccountinfo.data.AccountInfoFeatureFlag;
import com.talabat.feature.ulaccountinfo.data.AccountInfoFeatureFlag_Factory;
import com.talabat.feature.ulaccountinfo.data.di.AccountInfoFeatureComponent;
import com.talabat.feature.ulaccountinfo.domain.IAccountInfoFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerAccountInfoFeatureComponent {

    public static final class AccountInfoFeatureComponentImpl implements AccountInfoFeatureComponent {
        private final AccountInfoFeatureComponentImpl accountInfoFeatureComponentImpl;
        private Provider<AccountInfoFeatureFlag> accountInfoFeatureFlagProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<IAccountInfoFeatureFlag> provideFeatureFlagProvider;

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        private AccountInfoFeatureComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            this.accountInfoFeatureComponentImpl = this;
            initialize(featureFlagCoreLibApi);
        }

        private void initialize(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            AccountInfoFeatureFlag_Factory create = AccountInfoFeatureFlag_Factory.create(getTalabatFeatureFlagProvider2);
            this.accountInfoFeatureFlagProvider = create;
            this.provideFeatureFlagProvider = SingleCheck.provider(create);
        }

        public IAccountInfoFeatureFlag getIAccountInfoFeatureFlag() {
            return this.provideFeatureFlagProvider.get();
        }
    }

    public static final class Factory implements AccountInfoFeatureComponent.Factory {
        private Factory() {
        }

        public AccountInfoFeatureComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new AccountInfoFeatureComponentImpl(featureFlagCoreLibApi);
        }
    }

    private DaggerAccountInfoFeatureComponent() {
    }

    public static AccountInfoFeatureComponent.Factory factory() {
        return new Factory();
    }
}
