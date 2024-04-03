package com.talabat.feature.activecarts.presentation.di;

import android.app.Activity;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.activecarts.presentation.BasketListActivity;
import com.talabat.feature.activecarts.presentation.BasketListActivity_MembersInjector;
import com.talabat.feature.activecarts.presentation.di.BasketListPresentationComponent;
import com.talabat.feature.activecarts.presentation.viewmodel.BasketListViewModel;
import com.talabat.feature.activecarts.presentation.viewmodel.BasketListViewModelFactory;
import com.talabat.feature.activecarts.presentation.viewmodel.BasketListViewModel_Factory;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerBasketListPresentationComponent {

    public static final class BasketListPresentationComponentImpl implements BasketListPresentationComponent {
        private Provider<ActiveCartsMethodCallHandler> activeCartsMethodCallHandlerProvider;
        private Provider<Activity> activityProvider;
        private final BasketListPresentationComponentImpl basketListPresentationComponentImpl;
        private Provider<BasketListViewModel> basketListViewModelProvider;
        private Provider<DarkstoresNavigator> darkstoresNavigatorProvider;
        private Provider<Navigator> getNavigatorProvider;

        public static final class ActiveCartsMethodCallHandlerProvider implements Provider<ActiveCartsMethodCallHandler> {
            private final ActiveCartsApi activeCartsApi;

            public ActiveCartsMethodCallHandlerProvider(ActiveCartsApi activeCartsApi2) {
                this.activeCartsApi = activeCartsApi2;
            }

            public ActiveCartsMethodCallHandler get() {
                return (ActiveCartsMethodCallHandler) Preconditions.checkNotNullFromComponent(this.activeCartsApi.activeCartsMethodCallHandler());
            }
        }

        public static final class DarkstoresNavigatorProvider implements Provider<DarkstoresNavigator> {
            private final DarkstoresFeatureApi darkstoresFeatureApi;

            public DarkstoresNavigatorProvider(DarkstoresFeatureApi darkstoresFeatureApi2) {
                this.darkstoresFeatureApi = darkstoresFeatureApi2;
            }

            public DarkstoresNavigator get() {
                return (DarkstoresNavigator) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresNavigator());
            }
        }

        public static final class GetNavigatorProvider implements Provider<Navigator> {
            private final NavigationCoreLibApi navigationCoreLibApi;

            public GetNavigatorProvider(NavigationCoreLibApi navigationCoreLibApi2) {
                this.navigationCoreLibApi = navigationCoreLibApi2;
            }

            public Navigator get() {
                return (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator());
            }
        }

        private BasketListPresentationComponentImpl(ActiveCartsApi activeCartsApi, DarkstoresFeatureApi darkstoresFeatureApi, NavigationCoreLibApi navigationCoreLibApi, Activity activity) {
            this.basketListPresentationComponentImpl = this;
            initialize(activeCartsApi, darkstoresFeatureApi, navigationCoreLibApi, activity);
        }

        private BasketListViewModelFactory basketListViewModelFactory() {
            return new BasketListViewModelFactory(this.basketListViewModelProvider);
        }

        private void initialize(ActiveCartsApi activeCartsApi, DarkstoresFeatureApi darkstoresFeatureApi, NavigationCoreLibApi navigationCoreLibApi, Activity activity) {
            this.activityProvider = InstanceFactory.create(activity);
            this.activeCartsMethodCallHandlerProvider = new ActiveCartsMethodCallHandlerProvider(activeCartsApi);
            this.darkstoresNavigatorProvider = new DarkstoresNavigatorProvider(darkstoresFeatureApi);
            GetNavigatorProvider getNavigatorProvider2 = new GetNavigatorProvider(navigationCoreLibApi);
            this.getNavigatorProvider = getNavigatorProvider2;
            this.basketListViewModelProvider = BasketListViewModel_Factory.create(this.activityProvider, this.activeCartsMethodCallHandlerProvider, this.darkstoresNavigatorProvider, getNavigatorProvider2);
        }

        private BasketListActivity injectBasketListActivity(BasketListActivity basketListActivity) {
            BasketListActivity_MembersInjector.injectViewModelFactory(basketListActivity, basketListViewModelFactory());
            return basketListActivity;
        }

        public void inject(BasketListActivity basketListActivity) {
            injectBasketListActivity(basketListActivity);
        }
    }

    public static final class Factory implements BasketListPresentationComponent.Factory {
        private Factory() {
        }

        public BasketListPresentationComponent create(ActiveCartsApi activeCartsApi, DarkstoresFeatureApi darkstoresFeatureApi, NavigationCoreLibApi navigationCoreLibApi, Activity activity) {
            Preconditions.checkNotNull(activeCartsApi);
            Preconditions.checkNotNull(darkstoresFeatureApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(activity);
            return new BasketListPresentationComponentImpl(activeCartsApi, darkstoresFeatureApi, navigationCoreLibApi, activity);
        }
    }

    private DaggerBasketListPresentationComponent() {
    }

    public static BasketListPresentationComponent.Factory factory() {
        return new Factory();
    }
}
