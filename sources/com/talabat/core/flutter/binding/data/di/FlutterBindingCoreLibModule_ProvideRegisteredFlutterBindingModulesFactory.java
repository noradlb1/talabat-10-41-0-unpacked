package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.apicallmocks.ApiCallMocksFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.cart.CartFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.config.ConfigFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.gem.GemFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.legacydeeplink.LegacyDeeplinkNavigationFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.menu.MenuFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.ordertrackingdependencies.OrderTrackingDependenciesFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.search.SearchFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.sharedprefs.SharedPreferencesFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendor.VendorFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendorlist.InlineAdsFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendormenuinfo.VendorMenuInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.binding.domain.address.IAddressInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.dynamictrackingcache.IDynamicTrackingCacheFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.home.IHomeFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.useraccount.IUserAccountFlutterEngineBinding;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingCoreLibModule_ProvideRegisteredFlutterBindingModulesFactory implements Factory<Set<EngineBinding>> {
    private final Provider<IAddressInfoFlutterEngineBinding> addressInfoFlutterEngineBindingProvider;
    private final Provider<CartFlutterEngineBinding> cartFlutterEngineBindingProvider;
    private final Provider<ConfigFlutterEngineBinding> configFlutterEngineBindingProvider;
    private final Provider<IDynamicTrackingCacheFlutterEngineBinding> dynamicTrackingCacheFlutterEngineBindingProvider;
    private final Provider<GemFlutterEngineBinding> gemFlutterEngineBindingProvider;
    private final Provider<IHomeFlutterEngineBinding> homeFlutterEngineBindingProvider;
    private final Provider<InlineAdsFlutterEngineBinding> inlineAdsFlutterEngineBindingProvider;
    private final Provider<LegacyDeeplinkNavigationFlutterEngineBinding> legacyDeeplinkNavigationFlutterEngineBindingProvider;
    private final Provider<MenuFlutterEngineBinding> menuFlutterEngineBindingProvider;
    private final Provider<ApiCallMocksFlutterEngineBinding> mocksFlutterEngineBindingProvider;
    private final Provider<OrderTrackingDependenciesFlutterEngineBinding> orderTrackingDependenciesFlutterEngineBindingProvider;
    private final Provider<SearchFlutterEngineBinding> searchFlutterEngineBindingProvider;
    private final Provider<SharedPreferencesFlutterEngineBinding> sharedPreferencesFlutterEngineBindingProvider;
    private final Provider<IUserAccountFlutterEngineBinding> userAccountFlutterEngineBindingProvider;
    private final Provider<VendorFlutterEngineBinding> vendorFlutterEngineBindingProvider;
    private final Provider<VendorMenuInfoFlutterEngineBinding> vendorMenuInfoFlutterEngineBindingProvider;

    public FlutterBindingCoreLibModule_ProvideRegisteredFlutterBindingModulesFactory(Provider<ConfigFlutterEngineBinding> provider, Provider<CartFlutterEngineBinding> provider2, Provider<GemFlutterEngineBinding> provider3, Provider<SearchFlutterEngineBinding> provider4, Provider<MenuFlutterEngineBinding> provider5, Provider<VendorFlutterEngineBinding> provider6, Provider<VendorMenuInfoFlutterEngineBinding> provider7, Provider<IAddressInfoFlutterEngineBinding> provider8, Provider<IHomeFlutterEngineBinding> provider9, Provider<IUserAccountFlutterEngineBinding> provider10, Provider<IDynamicTrackingCacheFlutterEngineBinding> provider11, Provider<ApiCallMocksFlutterEngineBinding> provider12, Provider<OrderTrackingDependenciesFlutterEngineBinding> provider13, Provider<InlineAdsFlutterEngineBinding> provider14, Provider<LegacyDeeplinkNavigationFlutterEngineBinding> provider15, Provider<SharedPreferencesFlutterEngineBinding> provider16) {
        this.configFlutterEngineBindingProvider = provider;
        this.cartFlutterEngineBindingProvider = provider2;
        this.gemFlutterEngineBindingProvider = provider3;
        this.searchFlutterEngineBindingProvider = provider4;
        this.menuFlutterEngineBindingProvider = provider5;
        this.vendorFlutterEngineBindingProvider = provider6;
        this.vendorMenuInfoFlutterEngineBindingProvider = provider7;
        this.addressInfoFlutterEngineBindingProvider = provider8;
        this.homeFlutterEngineBindingProvider = provider9;
        this.userAccountFlutterEngineBindingProvider = provider10;
        this.dynamicTrackingCacheFlutterEngineBindingProvider = provider11;
        this.mocksFlutterEngineBindingProvider = provider12;
        this.orderTrackingDependenciesFlutterEngineBindingProvider = provider13;
        this.inlineAdsFlutterEngineBindingProvider = provider14;
        this.legacyDeeplinkNavigationFlutterEngineBindingProvider = provider15;
        this.sharedPreferencesFlutterEngineBindingProvider = provider16;
    }

    public static FlutterBindingCoreLibModule_ProvideRegisteredFlutterBindingModulesFactory create(Provider<ConfigFlutterEngineBinding> provider, Provider<CartFlutterEngineBinding> provider2, Provider<GemFlutterEngineBinding> provider3, Provider<SearchFlutterEngineBinding> provider4, Provider<MenuFlutterEngineBinding> provider5, Provider<VendorFlutterEngineBinding> provider6, Provider<VendorMenuInfoFlutterEngineBinding> provider7, Provider<IAddressInfoFlutterEngineBinding> provider8, Provider<IHomeFlutterEngineBinding> provider9, Provider<IUserAccountFlutterEngineBinding> provider10, Provider<IDynamicTrackingCacheFlutterEngineBinding> provider11, Provider<ApiCallMocksFlutterEngineBinding> provider12, Provider<OrderTrackingDependenciesFlutterEngineBinding> provider13, Provider<InlineAdsFlutterEngineBinding> provider14, Provider<LegacyDeeplinkNavigationFlutterEngineBinding> provider15, Provider<SharedPreferencesFlutterEngineBinding> provider16) {
        return new FlutterBindingCoreLibModule_ProvideRegisteredFlutterBindingModulesFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static Set<EngineBinding> provideRegisteredFlutterBindingModules(ConfigFlutterEngineBinding configFlutterEngineBinding, CartFlutterEngineBinding cartFlutterEngineBinding, GemFlutterEngineBinding gemFlutterEngineBinding, SearchFlutterEngineBinding searchFlutterEngineBinding, MenuFlutterEngineBinding menuFlutterEngineBinding, VendorFlutterEngineBinding vendorFlutterEngineBinding, VendorMenuInfoFlutterEngineBinding vendorMenuInfoFlutterEngineBinding, IAddressInfoFlutterEngineBinding iAddressInfoFlutterEngineBinding, IHomeFlutterEngineBinding iHomeFlutterEngineBinding, IUserAccountFlutterEngineBinding iUserAccountFlutterEngineBinding, IDynamicTrackingCacheFlutterEngineBinding iDynamicTrackingCacheFlutterEngineBinding, ApiCallMocksFlutterEngineBinding apiCallMocksFlutterEngineBinding, OrderTrackingDependenciesFlutterEngineBinding orderTrackingDependenciesFlutterEngineBinding, InlineAdsFlutterEngineBinding inlineAdsFlutterEngineBinding, LegacyDeeplinkNavigationFlutterEngineBinding legacyDeeplinkNavigationFlutterEngineBinding, SharedPreferencesFlutterEngineBinding sharedPreferencesFlutterEngineBinding) {
        return (Set) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideRegisteredFlutterBindingModules(configFlutterEngineBinding, cartFlutterEngineBinding, gemFlutterEngineBinding, searchFlutterEngineBinding, menuFlutterEngineBinding, vendorFlutterEngineBinding, vendorMenuInfoFlutterEngineBinding, iAddressInfoFlutterEngineBinding, iHomeFlutterEngineBinding, iUserAccountFlutterEngineBinding, iDynamicTrackingCacheFlutterEngineBinding, apiCallMocksFlutterEngineBinding, orderTrackingDependenciesFlutterEngineBinding, inlineAdsFlutterEngineBinding, legacyDeeplinkNavigationFlutterEngineBinding, sharedPreferencesFlutterEngineBinding));
    }

    public Set<EngineBinding> get() {
        return provideRegisteredFlutterBindingModules(this.configFlutterEngineBindingProvider.get(), this.cartFlutterEngineBindingProvider.get(), this.gemFlutterEngineBindingProvider.get(), this.searchFlutterEngineBindingProvider.get(), this.menuFlutterEngineBindingProvider.get(), this.vendorFlutterEngineBindingProvider.get(), this.vendorMenuInfoFlutterEngineBindingProvider.get(), this.addressInfoFlutterEngineBindingProvider.get(), this.homeFlutterEngineBindingProvider.get(), this.userAccountFlutterEngineBindingProvider.get(), this.dynamicTrackingCacheFlutterEngineBindingProvider.get(), this.mocksFlutterEngineBindingProvider.get(), this.orderTrackingDependenciesFlutterEngineBindingProvider.get(), this.inlineAdsFlutterEngineBindingProvider.get(), this.legacyDeeplinkNavigationFlutterEngineBindingProvider.get(), this.sharedPreferencesFlutterEngineBindingProvider.get());
    }
}
