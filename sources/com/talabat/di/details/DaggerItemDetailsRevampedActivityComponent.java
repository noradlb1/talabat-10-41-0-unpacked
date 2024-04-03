package com.talabat.di.details;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ItemDetailsRevampedActivity;
import com.talabat.ItemDetailsRevampedActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.details.ItemDetailsRevampedActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerItemDetailsRevampedActivityComponent {

    public static final class Factory implements ItemDetailsRevampedActivityComponent.Factory {
        private Factory() {
        }

        public ItemDetailsRevampedActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new ItemDetailsRevampedActivityComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class ItemDetailsRevampedActivityComponentImpl implements ItemDetailsRevampedActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final ItemDetailsRevampedActivityComponentImpl itemDetailsRevampedActivityComponentImpl;

        private ItemDetailsRevampedActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.itemDetailsRevampedActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ItemDetailsRevampedActivity injectItemDetailsRevampedActivity(ItemDetailsRevampedActivity itemDetailsRevampedActivity) {
            ItemDetailsRevampedActivity_MembersInjector.injectAppVersionProvider(itemDetailsRevampedActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return itemDetailsRevampedActivity;
        }

        public void inject(ItemDetailsRevampedActivity itemDetailsRevampedActivity) {
            injectItemDetailsRevampedActivity(itemDetailsRevampedActivity);
        }
    }

    private DaggerItemDetailsRevampedActivityComponent() {
    }

    public static ItemDetailsRevampedActivityComponent.Factory factory() {
        return new Factory();
    }
}
