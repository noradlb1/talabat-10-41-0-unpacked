package com.talabat.di.grocery;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.GroceryMenuSearchActivity;
import com.talabat.GroceryMenuSearchActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.grocery.GroceryMenuSearchActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGroceryMenuSearchActivityComponent {

    public static final class Factory implements GroceryMenuSearchActivityComponent.Factory {
        private Factory() {
        }

        public GroceryMenuSearchActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new GroceryMenuSearchActivityComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class GroceryMenuSearchActivityComponentImpl implements GroceryMenuSearchActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final GroceryMenuSearchActivityComponentImpl groceryMenuSearchActivityComponentImpl;

        private GroceryMenuSearchActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.groceryMenuSearchActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private GroceryMenuSearchActivity injectGroceryMenuSearchActivity(GroceryMenuSearchActivity groceryMenuSearchActivity) {
            GroceryMenuSearchActivity_MembersInjector.injectAppVersionProvider(groceryMenuSearchActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return groceryMenuSearchActivity;
        }

        public void inject(GroceryMenuSearchActivity groceryMenuSearchActivity) {
            injectGroceryMenuSearchActivity(groceryMenuSearchActivity);
        }
    }

    private DaggerGroceryMenuSearchActivityComponent() {
    }

    public static GroceryMenuSearchActivityComponent.Factory factory() {
        return new Factory();
    }
}
