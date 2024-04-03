package com.talabat.core.navigation.data.di;

import com.talabat.core.navigation.data.ActivityNavigator_Factory;
import com.talabat.core.navigation.data.di.NavigationCoreLibComponent;
import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerNavigationCoreLibComponent {

    public static final class Factory implements NavigationCoreLibComponent.Factory {
        private Factory() {
        }

        public NavigationCoreLibComponent create() {
            return new NavigationCoreLibComponentImpl();
        }
    }

    public static final class NavigationCoreLibComponentImpl implements NavigationCoreLibComponent {
        private final NavigationCoreLibComponentImpl navigationCoreLibComponentImpl;
        private Provider<Navigator> provideNavigatorProvider;

        private NavigationCoreLibComponentImpl() {
            this.navigationCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.provideNavigatorProvider = SingleCheck.provider(ActivityNavigator_Factory.create());
        }

        public Navigator getNavigator() {
            return this.provideNavigatorProvider.get();
        }
    }

    private DaggerNavigationCoreLibComponent() {
    }

    public static NavigationCoreLibComponent create() {
        return new Factory().create();
    }

    public static NavigationCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
