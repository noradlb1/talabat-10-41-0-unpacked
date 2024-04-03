package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.GiftVoucherList;
import com.talabat.GiftVoucherList_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.GiftVoucherListComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGiftVoucherListComponent {

    public static final class Factory implements GiftVoucherListComponent.Factory {
        private Factory() {
        }

        public GiftVoucherListComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new GiftVoucherListComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class GiftVoucherListComponentImpl implements GiftVoucherListComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final GiftVoucherListComponentImpl giftVoucherListComponentImpl;

        private GiftVoucherListComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.giftVoucherListComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private GiftVoucherList injectGiftVoucherList(GiftVoucherList giftVoucherList) {
            GiftVoucherList_MembersInjector.injectAppVersionProvider(giftVoucherList, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            GiftVoucherList_MembersInjector.injectConfigurationLocalRepository(giftVoucherList, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return giftVoucherList;
        }

        public void inject(GiftVoucherList giftVoucherList) {
            injectGiftVoucherList(giftVoucherList);
        }
    }

    private DaggerGiftVoucherListComponent() {
    }

    public static GiftVoucherListComponent.Factory factory() {
        return new Factory();
    }
}
