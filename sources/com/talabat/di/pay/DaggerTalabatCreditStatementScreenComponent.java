package com.talabat.di.pay;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.TalabatCreditStatementScreen;
import com.talabat.TalabatCreditStatementScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.pay.TalabatCreditStatementScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerTalabatCreditStatementScreenComponent {

    public static final class Factory implements TalabatCreditStatementScreenComponent.Factory {
        private Factory() {
        }

        public TalabatCreditStatementScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new TalabatCreditStatementScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class TalabatCreditStatementScreenComponentImpl implements TalabatCreditStatementScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final TalabatCreditStatementScreenComponentImpl talabatCreditStatementScreenComponentImpl;

        private TalabatCreditStatementScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.talabatCreditStatementScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private TalabatCreditStatementScreen injectTalabatCreditStatementScreen(TalabatCreditStatementScreen talabatCreditStatementScreen) {
            TalabatCreditStatementScreen_MembersInjector.injectAppVersionProvider(talabatCreditStatementScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return talabatCreditStatementScreen;
        }

        public void inject(TalabatCreditStatementScreen talabatCreditStatementScreen) {
            injectTalabatCreditStatementScreen(talabatCreditStatementScreen);
        }
    }

    private DaggerTalabatCreditStatementScreenComponent() {
    }

    public static TalabatCreditStatementScreenComponent.Factory factory() {
        return new Factory();
    }
}
