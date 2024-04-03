package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.data.address.AddressInfoMethodChannel;
import com.talabat.core.flutter.channels.data.apicallmocks.ApiCallMocksMethodChannel;
import com.talabat.core.flutter.channels.data.authentication.AuthenticationMethodChannel;
import com.talabat.core.flutter.channels.data.cart.CartMethodChannel;
import com.talabat.core.flutter.channels.data.config.GlobalMethodChannel;
import com.talabat.core.flutter.channels.data.dynamictrackingcache.DynamicTrackingCacheMethodChannel;
import com.talabat.core.flutter.channels.data.experiment.ExperimentMethodChannel;
import com.talabat.core.flutter.channels.data.featureflags.FeatureFlagMethodChannel;
import com.talabat.core.flutter.channels.data.gem.GemMethodChannel;
import com.talabat.core.flutter.channels.data.home.HomeMethodChannel;
import com.talabat.core.flutter.channels.data.legacydeeplink.LegacyDeeplinkNavigationMethodChannel;
import com.talabat.core.flutter.channels.data.menu.MenuMethodChannel;
import com.talabat.core.flutter.channels.data.observability.ObservabilityMethodChannel;
import com.talabat.core.flutter.channels.data.ordertrackingdependencies.OrderTrackingDependenciesMethodChannel;
import com.talabat.core.flutter.channels.data.search.SearchMethodChannel;
import com.talabat.core.flutter.channels.data.secrets.SecretsMethodChannel;
import com.talabat.core.flutter.channels.data.sharedprefs.SharedPreferencesMethodChannel;
import com.talabat.core.flutter.channels.data.tracking.TrackingMethodChannel;
import com.talabat.core.flutter.channels.data.useraccount.UserAccountMethodChannel;
import com.talabat.core.flutter.channels.data.vendor.VendorMethodChannel;
import com.talabat.core.flutter.channels.data.vendorlist.InlineAdsMethodChannel;
import com.talabat.core.flutter.channels.data.vendormenuinfo.VendorMenuInfoMethodChannel;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallbackDomain;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import com.talabat.core.flutter.channels.domain.cart.CartChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import com.talabat.core.flutter.channels.domain.gem.GemChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import com.talabat.core.flutter.channels.domain.home.HomeChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationFlutterDomain;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelCallback;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesFlutterDomain;
import com.talabat.core.flutter.channels.domain.search.SearchChannelCallback;
import com.talabat.core.flutter.channels.domain.search.SearchChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallback;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelCallback;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelCallback;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelFlutterDomain;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ>\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u00032\u001d\u0010\b\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003H'¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsCoreLibModule;", "", "channels", "", "", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "platformChannelChannels", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FlutterChannelsCoreLibModule {
    @NotNull
    public static final Companion Companion = Companion.f55879a;

    @Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u000201H\u0007J\u0010\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u000207H\u0007J\u0010\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020:H\u0007J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=H\u0007J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020@H\u0007J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0007J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020FH\u0007J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020IH\u0007¨\u0006J"}, d2 = {"Lcom/talabat/core/flutter/channels/data/di/FlutterChannelsCoreLibModule$Companion;", "", "()V", "provideAddressInfoMethodChannel", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "addressInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "provideApiCallsMockChannel", "apiMockChannelCallback", "Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;", "provideAuthenticationMethodChannel", "authenticationChannelCallback", "Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelCallback;", "provideCartMethodChannel", "cartChannelCallback", "Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "provideDynamicTrackingCacheMethodChannel", "dynamicTrackingCacheCallback", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "provideExperimentMethodChannel", "experimentChannelCallback", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "provideFeatureFlagMethodChannel", "featureFlagChannelCallback", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "provideGemMethodChannel", "gemChannelCallback", "Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "provideGlobalMethodChannel", "globalChannelCallback", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "provideHelpCenterMethodChannel", "orderTrackingDependenciesChannelCallback", "Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "provideHomeMethodChannel", "homeChannelCallback", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;", "provideInlineAdsMethodChannel", "inlineAdsChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendorlist/InlineAdsChannelCallback;", "provideLegacyDeepLinkNavigationMethodChannel", "legacyDeeplinkNavigationChannelCallback", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;", "provideMenuMethodChannel", "menuChannelCallback", "Lcom/talabat/core/flutter/channels/domain/menu/MenuChannelCallback;", "provideObservabilityMethodChannel", "observabilityChannelCallback", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "provideSearchMethodChannel", "searchChannelCallback", "Lcom/talabat/core/flutter/channels/domain/search/SearchChannelCallback;", "provideSecretsMethodChannel", "secretsChannelCallback", "Lcom/talabat/flutter/secrets/domain/handler/SecretsMethodCallHandler;", "provideSharedPreferencesMethodChannel", "sharedPreferencesChannelCallback", "Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;", "provideTrackingMethodChannel", "trackingChannelCallback", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;", "provideUserAccountMethodChannel", "userAccountChannelCallback", "Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallback;", "provideVendorMenuInfoMethodChannel", "vendorMenuInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "provideVendorMethodChannel", "vendorChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendor/VendorChannelCallback;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55879a = new Companion();

        private Companion() {
        }

        @IntoMap
        @NotNull
        @ClassKey(AddressInfoChannelFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideAddressInfoMethodChannel(@NotNull AddressInfoChannelCallback addressInfoChannelCallback, @NotNull IObservabilityManager iObservabilityManager, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
            Intrinsics.checkNotNullParameter(addressInfoChannelCallback, "addressInfoChannelCallback");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
            return new AddressInfoMethodChannel(addressInfoChannelCallback, iObservabilityManager, coroutineDispatchersFactory);
        }

        @IntoMap
        @NotNull
        @ClassKey(ApiCallsMockChannelCallbackDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideApiCallsMockChannel(@NotNull ApiCallsMockChannelCallback apiCallsMockChannelCallback) {
            Intrinsics.checkNotNullParameter(apiCallsMockChannelCallback, "apiMockChannelCallback");
            return new ApiCallMocksMethodChannel(apiCallsMockChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(AuthenticationChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideAuthenticationMethodChannel(@NotNull AuthenticationChannelCallback authenticationChannelCallback) {
            Intrinsics.checkNotNullParameter(authenticationChannelCallback, "authenticationChannelCallback");
            return new AuthenticationMethodChannel(authenticationChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(CartChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideCartMethodChannel(@NotNull CartChannelCallback cartChannelCallback) {
            Intrinsics.checkNotNullParameter(cartChannelCallback, "cartChannelCallback");
            return new CartMethodChannel(cartChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(DynamicTrackingCacheFlutterDomain.class)
        @Provides
        public final PlatformChannel provideDynamicTrackingCacheMethodChannel(@NotNull DynamicTrackingCacheCallback dynamicTrackingCacheCallback) {
            Intrinsics.checkNotNullParameter(dynamicTrackingCacheCallback, "dynamicTrackingCacheCallback");
            return new DynamicTrackingCacheMethodChannel(dynamicTrackingCacheCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(ExperimentChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideExperimentMethodChannel(@NotNull ExperimentChannelCallback experimentChannelCallback) {
            Intrinsics.checkNotNullParameter(experimentChannelCallback, "experimentChannelCallback");
            return new ExperimentMethodChannel(experimentChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(FeatureFlagChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideFeatureFlagMethodChannel(@NotNull FeatureFlagChannelCallback featureFlagChannelCallback) {
            Intrinsics.checkNotNullParameter(featureFlagChannelCallback, "featureFlagChannelCallback");
            return new FeatureFlagMethodChannel(featureFlagChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(GemChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideGemMethodChannel(@NotNull GemChannelCallback gemChannelCallback) {
            Intrinsics.checkNotNullParameter(gemChannelCallback, "gemChannelCallback");
            return new GemMethodChannel(gemChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(GlobalChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideGlobalMethodChannel(@NotNull GlobalChannelCallback globalChannelCallback, @NotNull IObservabilityManager iObservabilityManager) {
            Intrinsics.checkNotNullParameter(globalChannelCallback, "globalChannelCallback");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            return new GlobalMethodChannel(globalChannelCallback, iObservabilityManager);
        }

        @IntoMap
        @NotNull
        @ClassKey(OrderTrackingDependenciesFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideHelpCenterMethodChannel(@NotNull OrderTrackingDependenciesChannelCallback orderTrackingDependenciesChannelCallback) {
            Intrinsics.checkNotNullParameter(orderTrackingDependenciesChannelCallback, "orderTrackingDependenciesChannelCallback");
            return new OrderTrackingDependenciesMethodChannel(orderTrackingDependenciesChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(HomeChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideHomeMethodChannel(@NotNull HomeChannelCallback homeChannelCallback) {
            Intrinsics.checkNotNullParameter(homeChannelCallback, "homeChannelCallback");
            return new HomeMethodChannel(homeChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(InlineAdsChannelFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideInlineAdsMethodChannel(@NotNull InlineAdsChannelCallback inlineAdsChannelCallback) {
            Intrinsics.checkNotNullParameter(inlineAdsChannelCallback, "inlineAdsChannelCallback");
            return new InlineAdsMethodChannel(inlineAdsChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(LegacyDeeplinkNavigationFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideLegacyDeepLinkNavigationMethodChannel(@NotNull LegacyDeeplinkNavigationChannelCallback legacyDeeplinkNavigationChannelCallback) {
            Intrinsics.checkNotNullParameter(legacyDeeplinkNavigationChannelCallback, "legacyDeeplinkNavigationChannelCallback");
            return new LegacyDeeplinkNavigationMethodChannel(legacyDeeplinkNavigationChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(MenuChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideMenuMethodChannel(@NotNull MenuChannelCallback menuChannelCallback) {
            Intrinsics.checkNotNullParameter(menuChannelCallback, "menuChannelCallback");
            return new MenuMethodChannel(menuChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(ObservabilityChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideObservabilityMethodChannel(@NotNull ObservabilityChannelCallback observabilityChannelCallback) {
            Intrinsics.checkNotNullParameter(observabilityChannelCallback, "observabilityChannelCallback");
            return new ObservabilityMethodChannel(observabilityChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(SearchChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideSearchMethodChannel(@NotNull SearchChannelCallback searchChannelCallback) {
            Intrinsics.checkNotNullParameter(searchChannelCallback, "searchChannelCallback");
            return new SearchMethodChannel(searchChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(SecretsChannelFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideSecretsMethodChannel(@NotNull SecretsMethodCallHandler secretsMethodCallHandler) {
            Intrinsics.checkNotNullParameter(secretsMethodCallHandler, "secretsChannelCallback");
            return new SecretsMethodChannel(secretsMethodCallHandler);
        }

        @IntoMap
        @NotNull
        @ClassKey(SharedPreferencesChannelFlutterDomain.class)
        @Reusable
        @Provides
        public final PlatformChannel provideSharedPreferencesMethodChannel(@NotNull SharedPreferencesChannelCallback sharedPreferencesChannelCallback) {
            Intrinsics.checkNotNullParameter(sharedPreferencesChannelCallback, "sharedPreferencesChannelCallback");
            return new SharedPreferencesMethodChannel(sharedPreferencesChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(TrackingChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideTrackingMethodChannel(@NotNull TrackingChannelCallback trackingChannelCallback) {
            Intrinsics.checkNotNullParameter(trackingChannelCallback, "trackingChannelCallback");
            return new TrackingMethodChannel(trackingChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(UserAccountChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideUserAccountMethodChannel(@NotNull UserAccountChannelCallback userAccountChannelCallback) {
            Intrinsics.checkNotNullParameter(userAccountChannelCallback, "userAccountChannelCallback");
            return new UserAccountMethodChannel(userAccountChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(VendorMenuInfoChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideVendorMenuInfoMethodChannel(@NotNull VendorMenuInfoChannelCallback vendorMenuInfoChannelCallback) {
            Intrinsics.checkNotNullParameter(vendorMenuInfoChannelCallback, "vendorMenuInfoChannelCallback");
            return new VendorMenuInfoMethodChannel(vendorMenuInfoChannelCallback);
        }

        @IntoMap
        @NotNull
        @ClassKey(VendorChannelFlutterDomain.class)
        @Provides
        public final PlatformChannel provideVendorMethodChannel(@NotNull VendorChannelCallback vendorChannelCallback) {
            Intrinsics.checkNotNullParameter(vendorChannelCallback, "vendorChannelCallback");
            return new VendorMethodChannel(vendorChannelCallback);
        }
    }

    @NotNull
    @Binds
    Map<String, Provider<PlatformChannel>> channels(@NotNull Map<String, Provider<PlatformChannel>> map);
}
