package com.talabat.di.grocery;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.GroceryDetailsViewScreen;
import com.talabat.GroceryDetailsViewScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.grocery.GroceryDetailsViewScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGroceryDetailsViewScreenComponent {

    public static final class Factory implements GroceryDetailsViewScreenComponent.Factory {
        private Factory() {
        }

        public GroceryDetailsViewScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new GroceryDetailsViewScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class GroceryDetailsViewScreenComponentImpl implements GroceryDetailsViewScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final GroceryDetailsViewScreenComponentImpl groceryDetailsViewScreenComponentImpl;

        private GroceryDetailsViewScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.groceryDetailsViewScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private GroceryDetailsViewScreen injectGroceryDetailsViewScreen(GroceryDetailsViewScreen groceryDetailsViewScreen) {
            GroceryDetailsViewScreen_MembersInjector.injectAppVersionProvider(groceryDetailsViewScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return groceryDetailsViewScreen;
        }

        public void inject(GroceryDetailsViewScreen groceryDetailsViewScreen) {
            injectGroceryDetailsViewScreen(groceryDetailsViewScreen);
        }
    }

    private DaggerGroceryDetailsViewScreenComponent() {
    }

    public static GroceryDetailsViewScreenComponent.Factory factory() {
        return new Factory();
    }
}
