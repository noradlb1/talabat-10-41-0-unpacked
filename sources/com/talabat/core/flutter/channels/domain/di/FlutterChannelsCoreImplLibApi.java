package com.talabat.core.flutter.channels.domain.di;

import com.talabat.core.di.Api;
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
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000207X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020CX¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0012\u0010F\u001a\u00020GX¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0012\u0010J\u001a\u00020KX¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0012\u0010N\u001a\u00020OX¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0012\u0010R\u001a\u00020SX¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006V"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsCoreImplLibApi;", "Lcom/talabat/core/di/Api;", "addressInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "getAddressInfoChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "apiCallsMockChannelCallback", "Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;", "getApiCallsMockChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/apicallmocks/ApiCallsMockChannelCallback;", "authenticationChannelCallback", "Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelCallback;", "getAuthenticationChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/authentication/AuthenticationChannelCallback;", "cartChannelCallback", "Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "getCartChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "dynamicTrackingCacheCallback", "Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "getDynamicTrackingCacheCallback", "()Lcom/talabat/core/flutter/channels/domain/dynamictrackingcache/DynamicTrackingCacheCallback;", "experimentChannelCallback", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "getExperimentChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "featureFlagChannelCallback", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "getFeatureFlagChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "gemChannelCallback", "Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "getGemChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "globalChannelCallback", "Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "getGlobalChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/config/GlobalChannelCallback;", "homeChannelCallback", "Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;", "getHomeChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/home/HomeChannelCallback;", "inlineAdsChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendorlist/InlineAdsChannelCallback;", "getInlineAdsChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/vendorlist/InlineAdsChannelCallback;", "legacyDeeplinkNavigationChannelCallback", "Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;", "getLegacyDeeplinkNavigationChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/legacydeeplink/LegacyDeeplinkNavigationChannelCallback;", "menuChannelCallback", "Lcom/talabat/core/flutter/channels/domain/menu/MenuChannelCallback;", "getMenuChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/menu/MenuChannelCallback;", "observabilityChannelCallback", "Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "getObservabilityChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "orderTrackingDependenciesChannelCallback", "Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "getOrderTrackingDependenciesChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "searchChannelCallback", "Lcom/talabat/core/flutter/channels/domain/search/SearchChannelCallback;", "getSearchChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/search/SearchChannelCallback;", "sharedPreferencesChannelCallback", "Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;", "getSharedPreferencesChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;", "trackingChannelCallback", "Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;", "getTrackingChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/tracking/TrackingChannelCallback;", "userAccountChannelCallback", "Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallback;", "getUserAccountChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallback;", "vendorChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendor/VendorChannelCallback;", "getVendorChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/vendor/VendorChannelCallback;", "vendorMenuInfoChannelCallback", "Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "getVendorMenuInfoChannelCallback", "()Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterChannelsCoreImplLibApi extends Api {
    @NotNull
    AddressInfoChannelCallback getAddressInfoChannelCallback();

    @NotNull
    ApiCallsMockChannelCallback getApiCallsMockChannelCallback();

    @NotNull
    AuthenticationChannelCallback getAuthenticationChannelCallback();

    @NotNull
    CartChannelCallback getCartChannelCallback();

    @NotNull
    DynamicTrackingCacheCallback getDynamicTrackingCacheCallback();

    @NotNull
    ExperimentChannelCallback getExperimentChannelCallback();

    @NotNull
    FeatureFlagChannelCallback getFeatureFlagChannelCallback();

    @NotNull
    GemChannelCallback getGemChannelCallback();

    @NotNull
    GlobalChannelCallback getGlobalChannelCallback();

    @NotNull
    HomeChannelCallback getHomeChannelCallback();

    @NotNull
    InlineAdsChannelCallback getInlineAdsChannelCallback();

    @NotNull
    LegacyDeeplinkNavigationChannelCallback getLegacyDeeplinkNavigationChannelCallback();

    @NotNull
    MenuChannelCallback getMenuChannelCallback();

    @NotNull
    ObservabilityChannelCallback getObservabilityChannelCallback();

    @NotNull
    OrderTrackingDependenciesChannelCallback getOrderTrackingDependenciesChannelCallback();

    @NotNull
    SearchChannelCallback getSearchChannelCallback();

    @NotNull
    SharedPreferencesChannelCallback getSharedPreferencesChannelCallback();

    @NotNull
    TrackingChannelCallback getTrackingChannelCallback();

    @NotNull
    UserAccountChannelCallback getUserAccountChannelCallback();

    @NotNull
    VendorChannelCallback getVendorChannelCallback();

    @NotNull
    VendorMenuInfoChannelCallback getVendorMenuInfoChannelCallback();
}
