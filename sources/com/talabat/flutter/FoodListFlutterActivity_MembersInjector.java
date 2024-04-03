package com.talabat.flutter;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.navigation.domain.Navigator;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class FoodListFlutterActivity_MembersInjector implements MembersInjector<FoodListFlutterActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<Navigator> navigatorProvider;

    public FoodListFlutterActivity_MembersInjector(Provider<Navigator> provider, Provider<DeepLinkNavigator> provider2) {
        this.navigatorProvider = provider;
        this.deepLinkNavigatorProvider = provider2;
    }

    public static MembersInjector<FoodListFlutterActivity> create(Provider<Navigator> provider, Provider<DeepLinkNavigator> provider2) {
        return new FoodListFlutterActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.flutter.FoodListFlutterActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(FoodListFlutterActivity foodListFlutterActivity, DeepLinkNavigator deepLinkNavigator) {
        foodListFlutterActivity.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.flutter.FoodListFlutterActivity.navigator")
    public static void injectNavigator(FoodListFlutterActivity foodListFlutterActivity, Navigator navigator) {
        foodListFlutterActivity.navigator = navigator;
    }

    public void injectMembers(FoodListFlutterActivity foodListFlutterActivity) {
        injectNavigator(foodListFlutterActivity, this.navigatorProvider.get());
        injectDeepLinkNavigator(foodListFlutterActivity, this.deepLinkNavigatorProvider.get());
    }
}
