package com.talabat.core.flutter.channels.impl.data.di;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.application.device.id.data.impl.DeviceIdProviderImpl;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelCallback;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import com.talabat.core.flutter.channels.domain.search.SearchChannelCallback;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallback;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelCallback;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelCallback;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.apicallmocks.ApiCallsMockChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.authentication.AuthenticationMethodChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.cart.CartChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.config.GlobalChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.dynamictrackingcache.DynamicTrackingCacheCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.experiment.ExperimentChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.featureflags.FeatureFlagChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.home.HomeChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.legacydeeplink.LegacyDeeplinkNavigationChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.menu.MenuChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.observability.ObservabilityChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.ordertrackingdependencies.OrderTrackingDependenciesChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.search.SearchChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.sharedprefs.SharedPreferencesChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.tracking.AnalyticsMethodChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.tracking.TrackingChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.useraccount.UserAccountChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.vendor.VendorChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.vendorlist.InlineAdsChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.vendormenuinfo.VendorMenuInfoChannelCallbackImpl;
import com.talabat.data.googleclientid.GoogleClientIdLocalStorage;
import com.talabat.data.googleclientid.GoogleClientIdProvider;
import com.talabat.fluttercore.channels.AnalyticsMethodChannelCallback;
import com.talabat.location.SelectedLocationProvider;
import com.talabat.location.SelectedLocationProviderImpl;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 Y2\u00020\u0001:\u0001YJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H'J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H'J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H'J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H'J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H'J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H'J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H'J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H'J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H'J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H'J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH'J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH'J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH'J\u0010\u0010J\u001a\u00020K2\u0006\u0010<\u001a\u00020LH'J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH'J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH'J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH'¨\u0006Z"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/FlutterChannelsCoreImplLibModule;", "", "addressInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "addressInfoChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/address/AddressInfoChannelCallbackImpl;", "authenticationCallback", "Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelCallback;", "authenticationMethodChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/authentication/AuthenticationMethodChannelCallbackImpl;", "cartChannelCallback", "Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "cartChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/cart/CartChannelCallbackImpl;", "dynamicTrackingCacheChannelCallback", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "dynamicTrackingCacheCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/dynamictrackingcache/DynamicTrackingCacheCallbackImpl;", "experimentChannelCallback", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "experimentChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/experiment/ExperimentChannelCallbackImpl;", "featureFlagChannelCallback", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "featureFlagChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/featureflags/FeatureFlagChannelCallbackImpl;", "globalChannelCallback", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "globalChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/config/GlobalChannelCallbackImpl;", "helpCenterChannelCallback", "Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "helpCenterChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/ordertrackingdependencies/OrderTrackingDependenciesChannelCallbackImpl;", "homeChannelCallback", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;", "homeChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/home/HomeChannelCallbackImpl;", "inlineAdsChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendorlist/InlineAdsChannelCallback;", "inlineAdsChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/vendorlist/InlineAdsChannelCallbackImpl;", "legacyDeeplinkNavigationChannelCallback", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;", "legacyDeeplinkNavigationChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/legacydeeplink/LegacyDeeplinkNavigationChannelCallbackImpl;", "menuChannelCallback", "Lcom/talabat/core/flutter/channels/domain/menu/MenuChannelCallback;", "menuChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/menu/MenuChannelCallbackImpl;", "mockApisChannelCallback", "Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;", "apiCallsMockChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/apicallmocks/ApiCallsMockChannelCallbackImpl;", "observabilityChannelCallback", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "observabilityChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/observability/ObservabilityChannelCallbackImpl;", "provideAnalyticsMethodChannelCallback", "Lcom/talabat/fluttercore/channels/AnalyticsMethodChannelCallback;", "impl", "Lcom/talabat/core/flutter/channels/impl/data/tracking/AnalyticsMethodChannelCallbackImpl;", "provideGemChannelCallback", "Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "gemChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/gem/GemChannelCallbackImpl;", "provideSearchChannelCallback", "Lcom/talabat/core/flutter/channels/domain/search/SearchChannelCallback;", "searchChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/search/SearchChannelCallbackImpl;", "provideSharedPreferencesCallbackImpl", "Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;", "sharedPreferencesChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/sharedprefs/SharedPreferencesChannelCallbackImpl;", "provideTrackingChannelCallback", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;", "Lcom/talabat/core/flutter/channels/impl/data/tracking/TrackingChannelCallbackImpl;", "userAccountChannelCallback", "Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallback;", "userAccountChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/useraccount/UserAccountChannelCallbackImpl;", "vendorChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendor/VendorChannelCallback;", "vendorChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/vendor/VendorChannelCallbackImpl;", "vendorMenuInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "vendorMenuInfoChannelCallbackImpl", "Lcom/talabat/core/flutter/channels/impl/data/vendormenuinfo/VendorMenuInfoChannelCallbackImpl;", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FlutterChannelsCoreImplLibModule {
    @NotNull
    public static final Companion Companion = Companion.f55914a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/di/FlutterChannelsCoreImplLibModule$Companion;", "", "()V", "provideDeviceIdProviderImpl", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "context", "Landroid/content/Context;", "provideGoogleClientIdLocalStorage", "Lcom/talabat/data/googleclientid/GoogleClientIdProvider;", "provideRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "provideSelectedLocationProviderImpl", "Lcom/talabat/location/SelectedLocationProvider;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55914a = new Companion();

        private Companion() {
        }

        @NotNull
        @Reusable
        @Provides
        public final DeviceIdProvider provideDeviceIdProviderImpl(@NotNull @ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new DeviceIdProviderImpl(context);
        }

        @NotNull
        @Reusable
        @Provides
        public final GoogleClientIdProvider provideGoogleClientIdLocalStorage() {
            return GoogleClientIdLocalStorage.INSTANCE;
        }

        @NotNull
        @Reusable
        @Provides
        public final RemoteConfiguration provideRemoteConfiguration() {
            return RemoteConfiguration.INSTANCE;
        }

        @NotNull
        @Reusable
        @Provides
        public final SelectedLocationProvider provideSelectedLocationProviderImpl() {
            Customer instance = Customer.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            return new SelectedLocationProviderImpl(instance);
        }
    }

    @NotNull
    @Binds
    AddressInfoChannelCallback addressInfoChannelCallback(@NotNull AddressInfoChannelCallbackImpl addressInfoChannelCallbackImpl);

    @NotNull
    @Binds
    AuthenticationChannelCallback authenticationCallback(@NotNull AuthenticationMethodChannelCallbackImpl authenticationMethodChannelCallbackImpl);

    @NotNull
    @Binds
    CartChannelCallback cartChannelCallback(@NotNull CartChannelCallbackImpl cartChannelCallbackImpl);

    @NotNull
    @Binds
    DynamicTrackingCacheCallback dynamicTrackingCacheChannelCallback(@NotNull DynamicTrackingCacheCallbackImpl dynamicTrackingCacheCallbackImpl);

    @NotNull
    @Binds
    ExperimentChannelCallback experimentChannelCallback(@NotNull ExperimentChannelCallbackImpl experimentChannelCallbackImpl);

    @NotNull
    @Binds
    FeatureFlagChannelCallback featureFlagChannelCallback(@NotNull FeatureFlagChannelCallbackImpl featureFlagChannelCallbackImpl);

    @NotNull
    @Binds
    GlobalChannelCallback globalChannelCallback(@NotNull GlobalChannelCallbackImpl globalChannelCallbackImpl);

    @NotNull
    @Binds
    OrderTrackingDependenciesChannelCallback helpCenterChannelCallback(@NotNull OrderTrackingDependenciesChannelCallbackImpl orderTrackingDependenciesChannelCallbackImpl);

    @NotNull
    @Binds
    HomeChannelCallback homeChannelCallback(@NotNull HomeChannelCallbackImpl homeChannelCallbackImpl);

    @NotNull
    @Binds
    InlineAdsChannelCallback inlineAdsChannelCallback(@NotNull InlineAdsChannelCallbackImpl inlineAdsChannelCallbackImpl);

    @NotNull
    @Binds
    LegacyDeeplinkNavigationChannelCallback legacyDeeplinkNavigationChannelCallback(@NotNull LegacyDeeplinkNavigationChannelCallbackImpl legacyDeeplinkNavigationChannelCallbackImpl);

    @NotNull
    @Binds
    MenuChannelCallback menuChannelCallback(@NotNull MenuChannelCallbackImpl menuChannelCallbackImpl);

    @NotNull
    @Binds
    ApiCallsMockChannelCallback mockApisChannelCallback(@NotNull ApiCallsMockChannelCallbackImpl apiCallsMockChannelCallbackImpl);

    @NotNull
    @Binds
    ObservabilityChannelCallback observabilityChannelCallback(@NotNull ObservabilityChannelCallbackImpl observabilityChannelCallbackImpl);

    @NotNull
    @Binds
    AnalyticsMethodChannelCallback provideAnalyticsMethodChannelCallback(@NotNull AnalyticsMethodChannelCallbackImpl analyticsMethodChannelCallbackImpl);

    @NotNull
    @Binds
    @Reusable
    GemChannelCallback provideGemChannelCallback(@NotNull GemChannelCallbackImpl gemChannelCallbackImpl);

    @NotNull
    @Binds
    SearchChannelCallback provideSearchChannelCallback(@NotNull SearchChannelCallbackImpl searchChannelCallbackImpl);

    @NotNull
    @Binds
    SharedPreferencesChannelCallback provideSharedPreferencesCallbackImpl(@NotNull SharedPreferencesChannelCallbackImpl sharedPreferencesChannelCallbackImpl);

    @NotNull
    @Binds
    TrackingChannelCallback provideTrackingChannelCallback(@NotNull TrackingChannelCallbackImpl trackingChannelCallbackImpl);

    @NotNull
    @Binds
    UserAccountChannelCallback userAccountChannelCallback(@NotNull UserAccountChannelCallbackImpl userAccountChannelCallbackImpl);

    @NotNull
    @Binds
    VendorChannelCallback vendorChannelCallback(@NotNull VendorChannelCallbackImpl vendorChannelCallbackImpl);

    @NotNull
    @Binds
    VendorMenuInfoChannelCallback vendorMenuInfoChannelCallback(@NotNull VendorMenuInfoChannelCallbackImpl vendorMenuInfoChannelCallbackImpl);
}
