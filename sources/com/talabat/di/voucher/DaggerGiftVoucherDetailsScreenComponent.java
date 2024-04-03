package com.talabat.di.voucher;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.GiftVoucherDetailsScreen;
import com.talabat.GiftVoucherDetailsScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.di.voucher.GiftVoucherDetailsScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGiftVoucherDetailsScreenComponent {

    public static final class Factory implements GiftVoucherDetailsScreenComponent.Factory {
        private Factory() {
        }

        public GiftVoucherDetailsScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new GiftVoucherDetailsScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class GiftVoucherDetailsScreenComponentImpl implements GiftVoucherDetailsScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final GiftVoucherDetailsScreenComponentImpl giftVoucherDetailsScreenComponentImpl;

        private GiftVoucherDetailsScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.giftVoucherDetailsScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private GiftVoucherDetailsScreen injectGiftVoucherDetailsScreen(GiftVoucherDetailsScreen giftVoucherDetailsScreen) {
            GiftVoucherDetailsScreen_MembersInjector.injectAppVersionProvider(giftVoucherDetailsScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            GiftVoucherDetailsScreen_MembersInjector.injectTermsAndConditionsConfigurationRepository(giftVoucherDetailsScreen, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            return giftVoucherDetailsScreen;
        }

        public void inject(GiftVoucherDetailsScreen giftVoucherDetailsScreen) {
            injectGiftVoucherDetailsScreen(giftVoucherDetailsScreen);
        }
    }

    private DaggerGiftVoucherDetailsScreenComponent() {
    }

    public static GiftVoucherDetailsScreenComponent.Factory factory() {
        return new Factory();
    }
}
