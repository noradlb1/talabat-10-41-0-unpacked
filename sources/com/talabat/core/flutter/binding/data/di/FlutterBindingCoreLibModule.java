package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.address.AddressInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.apicallmocks.ApiCallMocksFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.cart.CartFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.config.ConfigFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.dynamictrackingcache.DynamicTrackingCacheFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.gem.GemFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.home.HomeFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.legacydeeplink.LegacyDeeplinkNavigationFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.menu.MenuFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.ordertrackingdependencies.OrderTrackingDependenciesFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.search.SearchFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.sharedprefs.SharedPreferencesFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.useraccount.UserAccountFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendor.VendorFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendorlist.InlineAdsFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendormenuinfo.VendorMenuInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.binding.domain.address.IAddressInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.dynamictrackingcache.IDynamicTrackingCacheFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.home.IHomeFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.useraccount.IUserAccountFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallbackDomain;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.cart.CartChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.gem.GemChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.home.HomeChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationFlutterDomain;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesFlutterDomain;
import com.talabat.core.flutter.channels.domain.search.SearchChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelFlutterDomain;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ElementsIntoSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010\u000b\u001a\u00020\f2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010\r\u001a\u00020\u000e2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J3\u0010\u000f\u001a\u00020\u00102!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007JF\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b\n0\u00182!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010\u001a\u001a\u00020\u001b2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010\u001c\u001a\u00020\u001d2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010\u001e\u001a\u00020\u001f2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010 \u001a\u00020!2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010\"\u001a\u00020#2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010$\u001a\u00020%2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0007J+\u0010=\u001a\u00020+2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010>\u001a\u00020<2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010?\u001a\u0002042!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010@\u001a\u00020.2!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010A\u001a\u0002092!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007J+\u0010B\u001a\u0002002!\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0006H\u0007¨\u0006C"}, d2 = {"Lcom/talabat/core/flutter/binding/data/di/FlutterBindingCoreLibModule;", "", "()V", "provideAddressInfoFlutterBinding", "Lcom/talabat/core/flutter/binding/domain/address/IAddressInfoFlutterEngineBinding;", "channels", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideApiMocksFlutterBinding", "Lcom/talabat/core/flutter/binding/data/apicallmocks/ApiCallMocksFlutterEngineBinding;", "provideCartFlutterBinding", "Lcom/talabat/core/flutter/binding/data/cart/CartFlutterEngineBinding;", "provideConfigFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/config/ConfigFlutterEngineBinding;", "deeplinkNavigationNativeDomain", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationNativeDomain;", "provideDeeplinkEngineBindingRegistry", "Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "flutterEngineProvider", "Lcom/talabat/core/flutter/engine/domain/IFlutterEngineProvider;", "registeredFlutterBindingModules", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "provideDynamicTrackingCacheFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/domain/dynamictrackingcache/IDynamicTrackingCacheFlutterEngineBinding;", "provideGemFlutterBinding", "Lcom/talabat/core/flutter/binding/data/gem/GemFlutterEngineBinding;", "provideHomeFlutterBinding", "Lcom/talabat/core/flutter/binding/domain/home/IHomeFlutterEngineBinding;", "provideLegacyDeeplinkNavigationFlutterBinding", "Lcom/talabat/core/flutter/binding/data/legacydeeplink/LegacyDeeplinkNavigationFlutterEngineBinding;", "provideMenuFlutterBinding", "Lcom/talabat/core/flutter/binding/data/menu/MenuFlutterEngineBinding;", "provideOrderTrackingDependenciesFlutterBinding", "Lcom/talabat/core/flutter/binding/data/ordertrackingdependencies/OrderTrackingDependenciesFlutterEngineBinding;", "provideRegisteredFlutterBindingModules", "configFlutterEngineBinding", "cartFlutterEngineBinding", "gemFlutterEngineBinding", "searchFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/search/SearchFlutterEngineBinding;", "menuFlutterEngineBinding", "vendorFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/vendor/VendorFlutterEngineBinding;", "vendorMenuInfoFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/vendormenuinfo/VendorMenuInfoFlutterEngineBinding;", "addressInfoFlutterEngineBinding", "homeFlutterEngineBinding", "userAccountFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/domain/useraccount/IUserAccountFlutterEngineBinding;", "dynamicTrackingCacheFlutterEngineBinding", "mocksFlutterEngineBinding", "orderTrackingDependenciesFlutterEngineBinding", "inlineAdsFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/vendorlist/InlineAdsFlutterEngineBinding;", "legacyDeeplinkNavigationFlutterEngineBinding", "sharedPreferencesFlutterEngineBinding", "Lcom/talabat/core/flutter/binding/data/sharedprefs/SharedPreferencesFlutterEngineBinding;", "provideSearchFlutterBinding", "provideSharedPreferencesFlutterBinding", "provideUserAccountFlutterBinding", "provideVendorFlutterBinding", "provideVendorListFlutterBinding", "provideVendorMenuInfoFlutterBinding", "com_talabat_core_flutter-binding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FlutterBindingCoreLibModule {
    @NotNull
    public static final FlutterBindingCoreLibModule INSTANCE = new FlutterBindingCoreLibModule();

    private FlutterBindingCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final IAddressInfoFlutterEngineBinding provideAddressInfoFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(AddressInfoChannelFlutterDomain.class);
        AddressInfoChannelFlutterDomain addressInfoChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof AddressInfoChannelFlutterDomain) {
            addressInfoChannelFlutterDomain = (AddressInfoChannelFlutterDomain) platformChannel;
        }
        return new AddressInfoFlutterEngineBinding(addressInfoChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final ApiCallMocksFlutterEngineBinding provideApiMocksFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(ApiCallsMockChannelCallbackDomain.class);
        ApiCallsMockChannelCallbackDomain apiCallsMockChannelCallbackDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof ApiCallsMockChannelCallbackDomain) {
            apiCallsMockChannelCallbackDomain = (ApiCallsMockChannelCallbackDomain) platformChannel;
        }
        return new ApiCallMocksFlutterEngineBinding(apiCallsMockChannelCallbackDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final CartFlutterEngineBinding provideCartFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(CartChannelFlutterDomain.class);
        CartChannelFlutterDomain cartChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof CartChannelFlutterDomain) {
            cartChannelFlutterDomain = (CartChannelFlutterDomain) platformChannel;
        }
        return new CartFlutterEngineBinding(cartChannelFlutterDomain);
    }

    @NotNull
    @Provides
    public final ConfigFlutterEngineBinding provideConfigFlutterEngineBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map, @NotNull DeeplinkNavigationNativeDomain deeplinkNavigationNativeDomain) {
        PlatformChannel platformChannel;
        GlobalChannelFlutterDomain globalChannelFlutterDomain;
        PlatformChannel platformChannel2;
        FeatureFlagChannelFlutterDomain featureFlagChannelFlutterDomain;
        PlatformChannel platformChannel3;
        ExperimentChannelFlutterDomain experimentChannelFlutterDomain;
        PlatformChannel platformChannel4;
        ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain;
        PlatformChannel platformChannel5;
        AuthenticationChannelFlutterDomain authenticationChannelFlutterDomain;
        Intrinsics.checkNotNullParameter(map, "channels");
        Intrinsics.checkNotNullParameter(deeplinkNavigationNativeDomain, "deeplinkNavigationNativeDomain");
        Provider provider = map.get(GlobalChannelFlutterDomain.class);
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof GlobalChannelFlutterDomain) {
            globalChannelFlutterDomain = (GlobalChannelFlutterDomain) platformChannel;
        } else {
            globalChannelFlutterDomain = null;
        }
        Provider provider2 = map.get(FeatureFlagChannelFlutterDomain.class);
        if (provider2 != null) {
            platformChannel2 = (PlatformChannel) provider2.get();
        } else {
            platformChannel2 = null;
        }
        if (platformChannel2 instanceof FeatureFlagChannelFlutterDomain) {
            featureFlagChannelFlutterDomain = (FeatureFlagChannelFlutterDomain) platformChannel2;
        } else {
            featureFlagChannelFlutterDomain = null;
        }
        Provider provider3 = map.get(ExperimentChannelFlutterDomain.class);
        if (provider3 != null) {
            platformChannel3 = (PlatformChannel) provider3.get();
        } else {
            platformChannel3 = null;
        }
        if (platformChannel3 instanceof ExperimentChannelFlutterDomain) {
            experimentChannelFlutterDomain = (ExperimentChannelFlutterDomain) platformChannel3;
        } else {
            experimentChannelFlutterDomain = null;
        }
        Provider provider4 = map.get(ObservabilityChannelFlutterDomain.class);
        if (provider4 != null) {
            platformChannel4 = (PlatformChannel) provider4.get();
        } else {
            platformChannel4 = null;
        }
        if (platformChannel4 instanceof ObservabilityChannelFlutterDomain) {
            observabilityChannelFlutterDomain = (ObservabilityChannelFlutterDomain) platformChannel4;
        } else {
            observabilityChannelFlutterDomain = null;
        }
        Provider provider5 = map.get(AuthenticationChannelFlutterDomain.class);
        if (provider5 != null) {
            platformChannel5 = (PlatformChannel) provider5.get();
        } else {
            platformChannel5 = null;
        }
        if (platformChannel5 instanceof AuthenticationChannelFlutterDomain) {
            authenticationChannelFlutterDomain = (AuthenticationChannelFlutterDomain) platformChannel5;
        } else {
            authenticationChannelFlutterDomain = null;
        }
        return new ConfigFlutterEngineBinding(deeplinkNavigationNativeDomain, globalChannelFlutterDomain, featureFlagChannelFlutterDomain, experimentChannelFlutterDomain, observabilityChannelFlutterDomain, authenticationChannelFlutterDomain);
    }

    @NotNull
    @Provides
    public final DeeplinkEngineBindingRegistry provideDeeplinkEngineBindingRegistry(@NotNull IFlutterEngineProvider iFlutterEngineProvider, @NotNull Set<EngineBinding> set, @NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain;
        PlatformChannel platformChannel2;
        SecretsChannelFlutterDomain secretsChannelFlutterDomain;
        PlatformChannel platformChannel3;
        TrackingChannelFlutterDomain trackingChannelFlutterDomain;
        Intrinsics.checkNotNullParameter(iFlutterEngineProvider, "flutterEngineProvider");
        Intrinsics.checkNotNullParameter(set, "registeredFlutterBindingModules");
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(ObservabilityChannelFlutterDomain.class);
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof ObservabilityChannelFlutterDomain) {
            observabilityChannelFlutterDomain = (ObservabilityChannelFlutterDomain) platformChannel;
        } else {
            observabilityChannelFlutterDomain = null;
        }
        Provider provider2 = map.get(SecretsChannelFlutterDomain.class);
        if (provider2 != null) {
            platformChannel2 = (PlatformChannel) provider2.get();
        } else {
            platformChannel2 = null;
        }
        if (platformChannel2 instanceof SecretsChannelFlutterDomain) {
            secretsChannelFlutterDomain = (SecretsChannelFlutterDomain) platformChannel2;
        } else {
            secretsChannelFlutterDomain = null;
        }
        Provider provider3 = map.get(TrackingChannelFlutterDomain.class);
        if (provider3 != null) {
            platformChannel3 = (PlatformChannel) provider3.get();
        } else {
            platformChannel3 = null;
        }
        if (platformChannel3 instanceof TrackingChannelFlutterDomain) {
            trackingChannelFlutterDomain = (TrackingChannelFlutterDomain) platformChannel3;
        } else {
            trackingChannelFlutterDomain = null;
        }
        return new DeeplinkEngineBindingRegistry(iFlutterEngineProvider, set, observabilityChannelFlutterDomain, secretsChannelFlutterDomain, trackingChannelFlutterDomain);
    }

    @NotNull
    @Provides
    public final IDynamicTrackingCacheFlutterEngineBinding provideDynamicTrackingCacheFlutterEngineBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(DynamicTrackingCacheFlutterDomain.class);
        DynamicTrackingCacheFlutterDomain dynamicTrackingCacheFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof DynamicTrackingCacheFlutterDomain) {
            dynamicTrackingCacheFlutterDomain = (DynamicTrackingCacheFlutterDomain) platformChannel;
        }
        return new DynamicTrackingCacheFlutterEngineBinding(dynamicTrackingCacheFlutterDomain);
    }

    @NotNull
    @Provides
    public final GemFlutterEngineBinding provideGemFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(GemChannelFlutterDomain.class);
        GemChannelFlutterDomain gemChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof GemChannelFlutterDomain) {
            gemChannelFlutterDomain = (GemChannelFlutterDomain) platformChannel;
        }
        return new GemFlutterEngineBinding(gemChannelFlutterDomain);
    }

    @NotNull
    @Provides
    public final IHomeFlutterEngineBinding provideHomeFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(HomeChannelFlutterDomain.class);
        HomeChannelFlutterDomain homeChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof HomeChannelFlutterDomain) {
            homeChannelFlutterDomain = (HomeChannelFlutterDomain) platformChannel;
        }
        return new HomeFlutterEngineBinding(homeChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final LegacyDeeplinkNavigationFlutterEngineBinding provideLegacyDeeplinkNavigationFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(LegacyDeeplinkNavigationFlutterDomain.class);
        LegacyDeeplinkNavigationFlutterDomain legacyDeeplinkNavigationFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof LegacyDeeplinkNavigationFlutterDomain) {
            legacyDeeplinkNavigationFlutterDomain = (LegacyDeeplinkNavigationFlutterDomain) platformChannel;
        }
        return new LegacyDeeplinkNavigationFlutterEngineBinding(legacyDeeplinkNavigationFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final MenuFlutterEngineBinding provideMenuFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(MenuChannelFlutterDomain.class);
        MenuChannelFlutterDomain menuChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof MenuChannelFlutterDomain) {
            menuChannelFlutterDomain = (MenuChannelFlutterDomain) platformChannel;
        }
        return new MenuFlutterEngineBinding(menuChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final OrderTrackingDependenciesFlutterEngineBinding provideOrderTrackingDependenciesFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(OrderTrackingDependenciesFlutterDomain.class);
        OrderTrackingDependenciesFlutterDomain orderTrackingDependenciesFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof OrderTrackingDependenciesFlutterDomain) {
            orderTrackingDependenciesFlutterDomain = (OrderTrackingDependenciesFlutterDomain) platformChannel;
        }
        return new OrderTrackingDependenciesFlutterEngineBinding(orderTrackingDependenciesFlutterDomain);
    }

    @ElementsIntoSet
    @NotNull
    @Provides
    public final Set<EngineBinding> provideRegisteredFlutterBindingModules(@NotNull ConfigFlutterEngineBinding configFlutterEngineBinding, @NotNull CartFlutterEngineBinding cartFlutterEngineBinding, @NotNull GemFlutterEngineBinding gemFlutterEngineBinding, @NotNull SearchFlutterEngineBinding searchFlutterEngineBinding, @NotNull MenuFlutterEngineBinding menuFlutterEngineBinding, @NotNull VendorFlutterEngineBinding vendorFlutterEngineBinding, @NotNull VendorMenuInfoFlutterEngineBinding vendorMenuInfoFlutterEngineBinding, @NotNull IAddressInfoFlutterEngineBinding iAddressInfoFlutterEngineBinding, @NotNull IHomeFlutterEngineBinding iHomeFlutterEngineBinding, @NotNull IUserAccountFlutterEngineBinding iUserAccountFlutterEngineBinding, @NotNull IDynamicTrackingCacheFlutterEngineBinding iDynamicTrackingCacheFlutterEngineBinding, @NotNull ApiCallMocksFlutterEngineBinding apiCallMocksFlutterEngineBinding, @NotNull OrderTrackingDependenciesFlutterEngineBinding orderTrackingDependenciesFlutterEngineBinding, @NotNull InlineAdsFlutterEngineBinding inlineAdsFlutterEngineBinding, @NotNull LegacyDeeplinkNavigationFlutterEngineBinding legacyDeeplinkNavigationFlutterEngineBinding, @NotNull SharedPreferencesFlutterEngineBinding sharedPreferencesFlutterEngineBinding) {
        ConfigFlutterEngineBinding configFlutterEngineBinding2 = configFlutterEngineBinding;
        CartFlutterEngineBinding cartFlutterEngineBinding2 = cartFlutterEngineBinding;
        GemFlutterEngineBinding gemFlutterEngineBinding2 = gemFlutterEngineBinding;
        SearchFlutterEngineBinding searchFlutterEngineBinding2 = searchFlutterEngineBinding;
        MenuFlutterEngineBinding menuFlutterEngineBinding2 = menuFlutterEngineBinding;
        VendorFlutterEngineBinding vendorFlutterEngineBinding2 = vendorFlutterEngineBinding;
        VendorMenuInfoFlutterEngineBinding vendorMenuInfoFlutterEngineBinding2 = vendorMenuInfoFlutterEngineBinding;
        IAddressInfoFlutterEngineBinding iAddressInfoFlutterEngineBinding2 = iAddressInfoFlutterEngineBinding;
        IHomeFlutterEngineBinding iHomeFlutterEngineBinding2 = iHomeFlutterEngineBinding;
        IUserAccountFlutterEngineBinding iUserAccountFlutterEngineBinding2 = iUserAccountFlutterEngineBinding;
        IDynamicTrackingCacheFlutterEngineBinding iDynamicTrackingCacheFlutterEngineBinding2 = iDynamicTrackingCacheFlutterEngineBinding;
        ApiCallMocksFlutterEngineBinding apiCallMocksFlutterEngineBinding2 = apiCallMocksFlutterEngineBinding;
        OrderTrackingDependenciesFlutterEngineBinding orderTrackingDependenciesFlutterEngineBinding2 = orderTrackingDependenciesFlutterEngineBinding;
        InlineAdsFlutterEngineBinding inlineAdsFlutterEngineBinding2 = inlineAdsFlutterEngineBinding;
        Intrinsics.checkNotNullParameter(configFlutterEngineBinding2, "configFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(cartFlutterEngineBinding2, "cartFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(gemFlutterEngineBinding2, "gemFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(searchFlutterEngineBinding2, "searchFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(menuFlutterEngineBinding2, "menuFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(vendorFlutterEngineBinding2, "vendorFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(vendorMenuInfoFlutterEngineBinding2, "vendorMenuInfoFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(iAddressInfoFlutterEngineBinding2, "addressInfoFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(iHomeFlutterEngineBinding2, "homeFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(iUserAccountFlutterEngineBinding2, "userAccountFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(iDynamicTrackingCacheFlutterEngineBinding2, "dynamicTrackingCacheFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(apiCallMocksFlutterEngineBinding2, "mocksFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(orderTrackingDependenciesFlutterEngineBinding2, "orderTrackingDependenciesFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(inlineAdsFlutterEngineBinding2, "inlineAdsFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(legacyDeeplinkNavigationFlutterEngineBinding, "legacyDeeplinkNavigationFlutterEngineBinding");
        Intrinsics.checkNotNullParameter(sharedPreferencesFlutterEngineBinding, "sharedPreferencesFlutterEngineBinding");
        return SetsKt__SetsKt.setOf(configFlutterEngineBinding2, cartFlutterEngineBinding2, gemFlutterEngineBinding2, searchFlutterEngineBinding2, vendorMenuInfoFlutterEngineBinding2, iAddressInfoFlutterEngineBinding2, vendorFlutterEngineBinding2, menuFlutterEngineBinding2, iHomeFlutterEngineBinding2, iUserAccountFlutterEngineBinding2, iDynamicTrackingCacheFlutterEngineBinding2, apiCallMocksFlutterEngineBinding2, orderTrackingDependenciesFlutterEngineBinding2, inlineAdsFlutterEngineBinding2, legacyDeeplinkNavigationFlutterEngineBinding, sharedPreferencesFlutterEngineBinding);
    }

    @NotNull
    @Provides
    public final SearchFlutterEngineBinding provideSearchFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(SearchChannelFlutterDomain.class);
        SearchChannelFlutterDomain searchChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof SearchChannelFlutterDomain) {
            searchChannelFlutterDomain = (SearchChannelFlutterDomain) platformChannel;
        }
        return new SearchFlutterEngineBinding(searchChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final SharedPreferencesFlutterEngineBinding provideSharedPreferencesFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(SharedPreferencesChannelFlutterDomain.class);
        SharedPreferencesChannelFlutterDomain sharedPreferencesChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof SharedPreferencesChannelFlutterDomain) {
            sharedPreferencesChannelFlutterDomain = (SharedPreferencesChannelFlutterDomain) platformChannel;
        }
        return new SharedPreferencesFlutterEngineBinding(sharedPreferencesChannelFlutterDomain);
    }

    @NotNull
    @Provides
    public final IUserAccountFlutterEngineBinding provideUserAccountFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(UserAccountChannelFlutterDomain.class);
        UserAccountChannelFlutterDomain userAccountChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof UserAccountChannelFlutterDomain) {
            userAccountChannelFlutterDomain = (UserAccountChannelFlutterDomain) platformChannel;
        }
        return new UserAccountFlutterEngineBinding(userAccountChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final VendorFlutterEngineBinding provideVendorFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(VendorChannelFlutterDomain.class);
        VendorChannelFlutterDomain vendorChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof VendorChannelFlutterDomain) {
            vendorChannelFlutterDomain = (VendorChannelFlutterDomain) platformChannel;
        }
        return new VendorFlutterEngineBinding(vendorChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final InlineAdsFlutterEngineBinding provideVendorListFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(InlineAdsChannelFlutterDomain.class);
        InlineAdsChannelFlutterDomain inlineAdsChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof InlineAdsChannelFlutterDomain) {
            inlineAdsChannelFlutterDomain = (InlineAdsChannelFlutterDomain) platformChannel;
        }
        return new InlineAdsFlutterEngineBinding(inlineAdsChannelFlutterDomain);
    }

    @NotNull
    @Reusable
    @Provides
    public final VendorMenuInfoFlutterEngineBinding provideVendorMenuInfoFlutterBinding(@NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(VendorMenuInfoChannelFlutterDomain.class);
        VendorMenuInfoChannelFlutterDomain vendorMenuInfoChannelFlutterDomain = null;
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof VendorMenuInfoChannelFlutterDomain) {
            vendorMenuInfoChannelFlutterDomain = (VendorMenuInfoChannelFlutterDomain) platformChannel;
        }
        return new VendorMenuInfoFlutterEngineBinding(vendorMenuInfoChannelFlutterDomain);
    }
}
