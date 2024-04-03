package com.talabat.feature.activecarts.presentation.viewmodel;

import android.app.Activity;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BasketListViewModel_Factory implements Factory<BasketListViewModel> {
    private final Provider<ActiveCartsMethodCallHandler> activeCartsMethodCallHandlerProvider;
    private final Provider<Activity> activityProvider;
    private final Provider<DarkstoresNavigator> darkstoresNavigatorProvider;
    private final Provider<Navigator> navigatorProvider;

    public BasketListViewModel_Factory(Provider<Activity> provider, Provider<ActiveCartsMethodCallHandler> provider2, Provider<DarkstoresNavigator> provider3, Provider<Navigator> provider4) {
        this.activityProvider = provider;
        this.activeCartsMethodCallHandlerProvider = provider2;
        this.darkstoresNavigatorProvider = provider3;
        this.navigatorProvider = provider4;
    }

    public static BasketListViewModel_Factory create(Provider<Activity> provider, Provider<ActiveCartsMethodCallHandler> provider2, Provider<DarkstoresNavigator> provider3, Provider<Navigator> provider4) {
        return new BasketListViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static BasketListViewModel newInstance(Activity activity, ActiveCartsMethodCallHandler activeCartsMethodCallHandler, DarkstoresNavigator darkstoresNavigator, Navigator navigator) {
        return new BasketListViewModel(activity, activeCartsMethodCallHandler, darkstoresNavigator, navigator);
    }

    public BasketListViewModel get() {
        return newInstance(this.activityProvider.get(), this.activeCartsMethodCallHandlerProvider.get(), this.darkstoresNavigatorProvider.get(), this.navigatorProvider.get());
    }
}
