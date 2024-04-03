package com.talabat.flutter.groceryhome.presentation.activity;

import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class GroceryHomeFlutterActivity_MembersInjector implements MembersInjector<GroceryHomeFlutterActivity> {
    private final Provider<ActiveCartsMethodCallHandler> activeCartsMethodCallHandlerProvider;
    private final Provider<DarkstoresNavigator> darkstoresNavigatorProvider;
    private final Provider<GroceryHomeMethodHandlerFactory> groceryHomeMethodHandlerFactoryProvider;
    private final Provider<Navigator> navigatorProvider;

    public GroceryHomeFlutterActivity_MembersInjector(Provider<GroceryHomeMethodHandlerFactory> provider, Provider<ActiveCartsMethodCallHandler> provider2, Provider<DarkstoresNavigator> provider3, Provider<Navigator> provider4) {
        this.groceryHomeMethodHandlerFactoryProvider = provider;
        this.activeCartsMethodCallHandlerProvider = provider2;
        this.darkstoresNavigatorProvider = provider3;
        this.navigatorProvider = provider4;
    }

    public static MembersInjector<GroceryHomeFlutterActivity> create(Provider<GroceryHomeMethodHandlerFactory> provider, Provider<ActiveCartsMethodCallHandler> provider2, Provider<DarkstoresNavigator> provider3, Provider<Navigator> provider4) {
        return new GroceryHomeFlutterActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity.activeCartsMethodCallHandler")
    public static void injectActiveCartsMethodCallHandler(GroceryHomeFlutterActivity groceryHomeFlutterActivity, ActiveCartsMethodCallHandler activeCartsMethodCallHandler) {
        groceryHomeFlutterActivity.activeCartsMethodCallHandler = activeCartsMethodCallHandler;
    }

    @InjectedFieldSignature("com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity.darkstoresNavigator")
    public static void injectDarkstoresNavigator(GroceryHomeFlutterActivity groceryHomeFlutterActivity, DarkstoresNavigator darkstoresNavigator) {
        groceryHomeFlutterActivity.darkstoresNavigator = darkstoresNavigator;
    }

    @InjectedFieldSignature("com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity.groceryHomeMethodHandlerFactory")
    public static void injectGroceryHomeMethodHandlerFactory(GroceryHomeFlutterActivity groceryHomeFlutterActivity, GroceryHomeMethodHandlerFactory groceryHomeMethodHandlerFactory) {
        groceryHomeFlutterActivity.groceryHomeMethodHandlerFactory = groceryHomeMethodHandlerFactory;
    }

    @InjectedFieldSignature("com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity.navigator")
    public static void injectNavigator(GroceryHomeFlutterActivity groceryHomeFlutterActivity, Navigator navigator) {
        groceryHomeFlutterActivity.navigator = navigator;
    }

    public void injectMembers(GroceryHomeFlutterActivity groceryHomeFlutterActivity) {
        injectGroceryHomeMethodHandlerFactory(groceryHomeFlutterActivity, this.groceryHomeMethodHandlerFactoryProvider.get());
        injectActiveCartsMethodCallHandler(groceryHomeFlutterActivity, this.activeCartsMethodCallHandlerProvider.get());
        injectDarkstoresNavigator(groceryHomeFlutterActivity, this.darkstoresNavigatorProvider.get());
        injectNavigator(groceryHomeFlutterActivity, this.navigatorProvider.get());
    }
}
