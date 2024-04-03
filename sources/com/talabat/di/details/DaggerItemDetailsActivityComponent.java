package com.talabat.di.details;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ItemDetailsActivity;
import com.talabat.ItemDetailsActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.details.ItemDetailsActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerItemDetailsActivityComponent {

    public static final class Factory implements ItemDetailsActivityComponent.Factory {
        private Factory() {
        }

        public ItemDetailsActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new ItemDetailsActivityComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class ItemDetailsActivityComponentImpl implements ItemDetailsActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final ItemDetailsActivityComponentImpl itemDetailsActivityComponentImpl;

        private ItemDetailsActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.itemDetailsActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ItemDetailsActivity injectItemDetailsActivity(ItemDetailsActivity itemDetailsActivity) {
            ItemDetailsActivity_MembersInjector.injectAppVersionProvider(itemDetailsActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return itemDetailsActivity;
        }

        public void inject(ItemDetailsActivity itemDetailsActivity) {
            injectItemDetailsActivity(itemDetailsActivity);
        }
    }

    private DaggerItemDetailsActivityComponent() {
    }

    public static ItemDetailsActivityComponent.Factory factory() {
        return new Factory();
    }
}
