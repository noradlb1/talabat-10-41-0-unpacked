package com.talabat.app.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.di.Api;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.flutter.binding.data.di.DaggerFlutterBindingFeatureLibComponent;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingFeatureLibApi;
import com.talabat.core.flutter.channels.data.di.DaggerFlutterChannelsFeatureLibComponent;
import com.talabat.core.flutter.channels.data.di.DaggerQCommerceMethodChannelFeatureLibComponent;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureImplLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsFeatureLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibImplApi;
import com.talabat.core.flutter.channels.impl.data.di.DaggerFlutterChannelsFeatureImplLibComponent;
import com.talabat.core.flutter.channels.impl.data.di.DaggerQCommerceMethodChannelFeatureLibImplComponent;
import com.talabat.core.flutter.channels.impl.data.di.FlutterChannelsFeatureImplLibComponent;
import com.talabat.core.flutter.channels.impl.data.di.QCommerceMethodChannelFeatureLibImplComponent;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.common.helpers.DarkstoresUtils;
import com.talabat.darkstores.data.Environment;
import com.talabat.darkstores.di.shared.DaggerDarkstoresFeatureComponent;
import com.talabat.darkstores.di.shared.DarkstoresFeatureComponent;
import com.talabat.domain.address.di.AddressFeatureApi;
import com.talabat.feature.activecarts.data.di.ActiveCartsComponent;
import com.talabat.feature.activecarts.data.di.DaggerActiveCartsComponent;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.address.data.di.AddressFeatureComponent;
import com.talabat.feature.address.data.di.DaggerAddressFeatureComponent;
import com.talabat.feature.bnplcore.data.di.BnplCoreFeatureComponent;
import com.talabat.feature.bnplcore.data.di.DaggerBnplCoreFeatureComponent;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.cancellationpolicy.di.DaggerHelpCenterFeatureComponent;
import com.talabat.feature.cancellationpolicy.di.HelpCenterFeatureComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.swimlanes.data.di.DaggerSwimlanesFeatureComponent;
import com.talabat.feature.darkstores.swimlanes.data.di.SwimlanesFeatureComponent;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
import com.talabat.feature.darkstores.vendorlanding.domain.VendorLandingFeatureApi;
import com.talabat.feature.darkstores.vendorslanding.data.di.DaggerVendorsLandingFeatureComponent;
import com.talabat.feature.darkstores.vendorslanding.data.di.VendorsLandingFeatureComponent;
import com.talabat.feature.darkstorescampaignmessage.data.di.DaggerDarkstoresCampaignMessageComponent;
import com.talabat.feature.darkstorescampaignmessage.data.di.DarkstoresCampaignMessageComponent;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
import com.talabat.feature.darkstorescart.data.di.DaggerDarkstoresCartComponent;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartComponent;
import com.talabat.feature.darkstorescartlist.data.di.DaggerDarkstoresCartListComponent;
import com.talabat.feature.darkstorescartlist.data.di.DarkstoresCartListComponent;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import com.talabat.feature.darkstoresflutter.data.di.DaggerDarkstoresFlutterCartComponent;
import com.talabat.feature.darkstoresflutter.data.di.DarkstoresFlutterCartComponent;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresscheduleddelivery.data.di.DaggerDarkstoresScheduledDeliveryComponent;
import com.talabat.feature.darkstoresscheduleddelivery.data.di.DarkstoresScheduledDeliveryComponent;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
import com.talabat.feature.darkstoresvendor.data.di.DaggerDarkstoresVendorComponent;
import com.talabat.feature.darkstoresvendor.data.di.DarkstoresVendorComponent;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.fees.data.di.DaggerFeesFeatureComponent;
import com.talabat.feature.fees.data.di.FeesFeatureComponent;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.foodcart2.data.di.DaggerFoodCartFeatureComponent;
import com.talabat.feature.foodcart2.data.di.FoodCartFeatureComponent;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.incentiveautoapplydiscounts.data.di.DaggerIncentiveAutoApplyDiscountsComponent;
import com.talabat.feature.incentiveautoapplydiscounts.data.di.IncentiveAutoApplyDiscountsComponent;
import com.talabat.feature.incentiveautoapplydiscounts.domain.di.IncentiveAutoApplyDiscountsFeatureApi;
import com.talabat.feature.mission.control.data.di.DaggerMissionControlFeatureComponent;
import com.talabat.feature.mission.control.data.di.MissionControlFeatureComponent;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.nfvinvendorsearch.data.di.DaggerQCommerceFlutterFeatureComponent;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
import com.talabat.feature.pickup.data.di.DaggerPickupFeatureComponent;
import com.talabat.feature.pickup.data.di.PickupFeatureComponent;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.rating.data.di.DaggerRatingFeatureComponent;
import com.talabat.feature.rating.data.di.RatingFeatureComponent;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.referafriend.data.di.DaggerReferAFriendFeatureComponent;
import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
import com.talabat.feature.rewards.data.di.DaggerRewardsFeatureComponent;
import com.talabat.feature.rewards.data.di.RewardsFeatureComponent;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.ridertips.data.di.DaggerRiderTipFeatureComponent;
import com.talabat.feature.ridertips.data.di.RiderTipFeatureComponent;
import com.talabat.feature.ridertips.domain.RiderTipFeatureApi;
import com.talabat.feature.subscriptions.data.di.DaggerSubscriptionsFeatureComponent;
import com.talabat.feature.subscriptions.data.di.SubscriptionsFeatureComponent;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.swimlanevoucherslist.data.di.CustomerVouchersSwimLaneComponent;
import com.talabat.feature.swimlanevoucherslist.data.di.DaggerCustomerVouchersSwimLaneComponent;
import com.talabat.feature.tmart.growth.data.di.DaggerTMartGrowthFeatureComponent;
import com.talabat.feature.tmart.growth.data.di.TMartGrowthFeatureComponent;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import com.talabat.feature.tokenization.data.di.DaggerTokenizationFeatureComponent;
import com.talabat.feature.tokenization.data.di.TokenizationFeatureComponent;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.ulaccountinfo.data.di.AccountInfoFeatureComponent;
import com.talabat.feature.ulaccountinfo.data.di.DaggerAccountInfoFeatureComponent;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
import com.talabat.feature.uladdressform.data.di.AddressFormFeatureComponent;
import com.talabat.feature.uladdressform.data.di.DaggerAddressFormFeatureComponent;
import com.talabat.feature.uladdressform.domain.AddressFormFeatureApi;
import com.talabat.feature.ulcampaign.data.di.CampaignMigratorFeatureComponent;
import com.talabat.feature.ulcampaign.data.di.DaggerCampaignMigratorFeatureComponent;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.walletaddcard.data.di.DaggerWalletAddCardFeatureComponent;
import com.talabat.feature.walletaddcard.data.di.WalletAddCardFeatureComponent;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletcobrandedcc.data.di.DaggerWalletCobrandedCcFeatureComponent;
import com.talabat.feature.walletcobrandedcc.data.di.WalletCobrandedCcFeatureComponent;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.features.swimlanevoucherslist.domain.di.CustomerVouchersSwimLaneFeaturesApi;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J7\u0010\n\u001a\u00020\u000b2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J'\u0010\u0010\u001a\u00020\u00112\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u0012\u001a\u00020\u00132\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u0014\u001a\u00020\u00152\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u0016\u001a\u00020\u00172\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u0018\u001a\u00020\u00192\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u001a\u001a\u00020\u001b2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u001c\u001a\u00020\u001d2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\u001e\u001a\u00020\u001f2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010\f\u001a\u00020\r2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J/\u0010\u000e\u001a\u00020\u000f2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J/\u0010 \u001a\u00020!2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J'\u0010\"\u001a\u00020#2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010$\u001a\u00020%2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010&\u001a\u00020'2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J/\u0010,\u001a\u00020-2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u00062\u0006\u0010.\u001a\u00020/H\u0007J\u0018\u0010*\u001a\u00020+2\u0006\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0007J'\u00102\u001a\u0002032\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u00104\u001a\u0002052\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u00106\u001a\u0002072\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u00108\u001a\u0002092\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010:\u001a\u00020;2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010<\u001a\u00020=2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0007J'\u0010@\u001a\u00020A2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010B\u001a\u00020C2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010D\u001a\u00020E2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010F\u001a\u00020G2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010H\u001a\u00020I2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010.\u001a\u00020/2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010J\u001a\u00020K2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010L\u001a\u00020M2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J'\u0010N\u001a\u00020O2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007J/\u0010P\u001a\u00020Q2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u00062\u0006\u0010N\u001a\u00020OH\u0007J'\u0010R\u001a\u00020S2\u001d\b\u0001\u0010\u0005\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0006H\u0007¨\u0006T"}, d2 = {"Lcom/talabat/app/di/FeaturesModule;", "", "()V", "accountInfoFeatureApi", "Lcom/talabat/feature/ulaccountinfo/domain/AccountInfoFeatureApi;", "coreApis", "", "Ljava/lang/Class;", "Lcom/talabat/core/di/Api;", "Lkotlin/jvm/JvmSuppressWildcards;", "activeCartsApi", "Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "darkstoresCartListApi", "Lcom/talabat/feature/darkstorescartlist/domain/di/DarkstoresCartListApi;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "addressFeatureApi", "Lcom/talabat/domain/address/di/AddressFeatureApi;", "addressFormFeatureApi", "Lcom/talabat/feature/uladdressform/domain/AddressFormFeatureApi;", "bnplCoreFeatureApi", "Lcom/talabat/feature/bnplcore/domain/BnplCoreFeatureApi;", "campaignMigratorFeatureApi", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorFeatureApi;", "customerVouchersSwimLaneFeaturesApi", "Lcom/talabat/features/swimlanevoucherslist/domain/di/CustomerVouchersSwimLaneFeaturesApi;", "darkstoreVandorLandingApi", "Lcom/talabat/feature/darkstores/vendorlanding/domain/VendorLandingFeatureApi;", "darkstoresCampaignMessage", "Lcom/talabat/feature/darkstorescampaignmessage/domain/CampaignMessagingApi;", "darkstoresCartApi", "Lcom/talabat/feature/darkstorescart/data/di/DarkstoresCartApi;", "darkstoresFlutterCartApi", "Lcom/talabat/feature/darkstoresflutter/domain/DarkstoresFlutterCartApi;", "darkstoresScheduledDeliveryFeatureApi", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/DarkstoresScheduledDeliveryFeatureApi;", "darkstoresVendorApi", "Lcom/talabat/feature/darkstoresvendor/domain/DarkstoresVendorApi;", "feesFeatureApi", "Lcom/talabat/feature/fees/domain/FeesFeatureApi;", "flutterBindingFeatureLibApi", "Lcom/talabat/core/flutter/binding/domain/di/FlutterBindingFeatureLibApi;", "flutterChannelsFeatureLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsFeatureLibApi;", "flutterChannelsFeatureImplLibApi", "Lcom/talabat/core/flutter/channels/domain/di/FlutterChannelsFeatureImplLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "foodCartFeatureApi", "Lcom/talabat/feature/foodcart2/domain/di/FoodCartFeatureApi;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "incentiveAutoApplyDiscountsFeatureApi", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/di/IncentiveAutoApplyDiscountsFeatureApi;", "missionControlFeatureApi", "Lcom/talabat/feature/mission/control/domain/MissionControlFeatureApi;", "pickupFeatureApi", "Lcom/talabat/feature/pickup/domain/PickupFeatureApi;", "qCommerceFlutterFeatureApi", "Lcom/talabat/feature/nfvinvendorsearch/domain/di/QCommerceFlutterFeatureApi;", "qCommerceMethodChannelFeatureLibApi", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibApi;", "qCommerceMethodChannelFeatureLibImplApi", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibImplApi;", "ratingFeatureApi", "Lcom/talabat/feature/rating/domain/RatingFeatureApi;", "referAFriendFeatureApi", "Lcom/talabat/feature/referafriend/domain/di/ReferAFriendFeatureApi;", "rewardsFeatureApi", "Lcom/talabat/feature/rewards/domain/RewardsFeatureApi;", "riderTipFeatureApi", "Lcom/talabat/feature/ridertips/domain/RiderTipFeatureApi;", "swimlanesFeatureApi", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesFeatureApi;", "tmartGrowthFeatureApi", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthFeatureApi;", "tokenizationFeatureApi", "Lcom/talabat/feature/tokenization/domain/TokenizationFeatureApi;", "walletAddCardFeatureApi", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardFeatureApi;", "walletCobrandedCcFeatureApi", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcFeatureApi;", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FeaturesModule {
    @NotNull
    public static final FeaturesModule INSTANCE = new FeaturesModule();

    private FeaturesModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final AccountInfoFeatureApi accountInfoFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        AccountInfoFeatureComponent.Factory factory = DaggerAccountInfoFeatureComponent.factory();
        Api api = map.get(FeatureFlagCoreLibApi.class);
        if (api != null) {
            return factory.create((FeatureFlagCoreLibApi) api);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final ActiveCartsApi activeCartsApi(@NotNull @CoreApis Map<Class<?>, Api> map, @NotNull DarkstoresCartListApi darkstoresCartListApi, @NotNull DarkstoresFeatureApi darkstoresFeatureApi) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        Intrinsics.checkNotNullParameter(darkstoresCartListApi, "darkstoresCartListApi");
        Intrinsics.checkNotNullParameter(darkstoresFeatureApi, "darkstoresFeatureApi");
        ActiveCartsComponent.Factory factory = DaggerActiveCartsComponent.factory();
        Api api = map.get(DispatcherCoreLibApi.class);
        if (api != null) {
            DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api;
            Api api2 = map.get(ExperimentCoreLibApi.class);
            if (api2 != null) {
                ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api2;
                Api api3 = map.get(TrackingCoreLibApi.class);
                if (api3 != null) {
                    return factory.create(darkstoresCartListApi, darkstoresFeatureApi, dispatcherCoreLibApi, experimentCoreLibApi, (TrackingCoreLibApi) api3);
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final AddressFeatureApi addressFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        AddressFeatureComponent.Factory factory = DaggerAddressFeatureComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(DispatcherCoreLibApi.class);
            if (api2 != null) {
                DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api2;
                Api api3 = map.get(FeatureFlagCoreLibApi.class);
                if (api3 != null) {
                    FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(ParserCoreLibApi.class);
                        if (api5 != null) {
                            ParserCoreLibApi parserCoreLibApi = (ParserCoreLibApi) api5;
                            Api api6 = map.get(TokenCoreLibApi.class);
                            if (api6 != null) {
                                return factory.create(contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, parserCoreLibApi, (TokenCoreLibApi) api6);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.token.domain.TokenCoreLibApi");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.parser.domain.ParserCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final AddressFormFeatureApi addressFormFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        AddressFormFeatureComponent.Factory factory = DaggerAddressFormFeatureComponent.factory();
        Api api = map.get(ExperimentCoreLibApi.class);
        if (api != null) {
            ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api;
            Api api2 = map.get(FeatureFlagCoreLibApi.class);
            if (api2 != null) {
                return factory.create(experimentCoreLibApi, (FeatureFlagCoreLibApi) api2);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final BnplCoreFeatureApi bnplCoreFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        BnplCoreFeatureComponent.Factory factory = DaggerBnplCoreFeatureComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(FeatureFlagCoreLibApi.class);
            if (api2 != null) {
                FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(TrackingCoreLibApi.class);
                    if (api4 != null) {
                        TrackingCoreLibApi trackingCoreLibApi = (TrackingCoreLibApi) api4;
                        Api api5 = map.get(FlutterEngineCoreLibApi.class);
                        if (api5 != null) {
                            FlutterEngineCoreLibApi flutterEngineCoreLibApi = (FlutterEngineCoreLibApi) api5;
                            Api api6 = map.get(FlutterChannelsCoreLibApi.class);
                            if (api6 != null) {
                                return factory.create(contextCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, trackingCoreLibApi, flutterEngineCoreLibApi, (FlutterChannelsCoreLibApi) api6);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final CampaignMigratorFeatureApi campaignMigratorFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        CampaignMigratorFeatureComponent.Factory factory = DaggerCampaignMigratorFeatureComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(ObservabilityCoreLibApi.class);
            if (api2 != null) {
                return factory.create(contextCoreLibApi, (ObservabilityCoreLibApi) api2);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        CustomerVouchersSwimLaneComponent.Factory factory = DaggerCustomerVouchersSwimLaneComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(NetworkCoreLibApi.class);
            if (api2 != null) {
                NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api2;
                Api api3 = map.get(ExperimentCoreLibApi.class);
                if (api3 != null) {
                    ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api3;
                    Api api4 = map.get(TrackingCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(configurationLocalCoreLibApi, experimentCoreLibApi, networkCoreLibApi, (TrackingCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final VendorLandingFeatureApi darkstoreVandorLandingApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        VendorsLandingFeatureComponent.Factory factory = DaggerVendorsLandingFeatureComponent.factory();
        Api api = map.get(DispatcherCoreLibApi.class);
        if (api != null) {
            DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api;
            Api api2 = map.get(FeatureFlagCoreLibApi.class);
            if (api2 != null) {
                FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(SecretCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, (SecretCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.aaa.di.SecretCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final CampaignMessagingApi darkstoresCampaignMessage(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        DarkstoresCampaignMessageComponent.Factory factory = DaggerDarkstoresCampaignMessageComponent.factory();
        Api api = map.get(DispatcherCoreLibApi.class);
        if (api != null) {
            DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api;
            Api api2 = map.get(FeatureFlagCoreLibApi.class);
            if (api2 != null) {
                FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(SecretCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, (SecretCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.aaa.di.SecretCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresCartApi darkstoresCartApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        DarkstoresCartComponent.Factory factory = DaggerDarkstoresCartComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(DispatcherCoreLibApi.class);
            if (api2 != null) {
                return factory.create(contextCoreLibApi, (DispatcherCoreLibApi) api2);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresCartListApi darkstoresCartListApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        DarkstoresCartListComponent.Factory factory = DaggerDarkstoresCartListComponent.factory();
        Api api = map.get(ConfigurationRemoteCoreLibApi.class);
        if (api != null) {
            ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) api;
            Api api2 = map.get(ContextCoreLibApi.class);
            if (api2 != null) {
                ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api2;
                Api api3 = map.get(ExperimentCoreLibApi.class);
                if (api3 != null) {
                    ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(ObservabilityCoreLibApi.class);
                        if (api5 != null) {
                            ObservabilityCoreLibApi observabilityCoreLibApi = (ObservabilityCoreLibApi) api5;
                            Api api6 = map.get(ParserCoreLibApi.class);
                            if (api6 != null) {
                                ParserCoreLibApi parserCoreLibApi = (ParserCoreLibApi) api6;
                                Api api7 = map.get(SecretCoreLibApi.class);
                                if (api7 != null) {
                                    return factory.create(configurationRemoteCoreLibApi, contextCoreLibApi, experimentCoreLibApi, networkCoreLibApi, observabilityCoreLibApi, parserCoreLibApi, (SecretCoreLibApi) api7);
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.aaa.di.SecretCoreLibApi");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.parser.domain.ParserCoreLibApi");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationRemoteCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresFeatureApi darkstoresFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map, @NotNull DarkstoresCartApi darkstoresCartApi) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        Intrinsics.checkNotNullParameter(darkstoresCartApi, "darkstoresCartApi");
        DarkstoresFeatureComponent.Factory factory = DaggerDarkstoresFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ConfigurationRemoteCoreLibApi.class);
            if (api2 != null) {
                ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) api2;
                Api api3 = map.get(ContextCoreLibApi.class);
                if (api3 != null) {
                    ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api3;
                    Api api4 = map.get(DeepLinkCoreLibApi.class);
                    if (api4 != null) {
                        DeepLinkCoreLibApi deepLinkCoreLibApi = (DeepLinkCoreLibApi) api4;
                        Api api5 = map.get(DispatcherCoreLibApi.class);
                        if (api5 != null) {
                            DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api5;
                            Api api6 = map.get(NavigationCoreLibApi.class);
                            if (api6 != null) {
                                NavigationCoreLibApi navigationCoreLibApi = (NavigationCoreLibApi) api6;
                                Environment environment$default = DarkstoresUtils.getEnvironment$default(DarkstoresUtils.INSTANCE, (String) null, (String) null, 3, (Object) null);
                                Api api7 = map.get(ParserCoreLibApi.class);
                                if (api7 != null) {
                                    return factory.create(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, darkstoresCartApi, deepLinkCoreLibApi, dispatcherCoreLibApi, navigationCoreLibApi, environment$default, (ParserCoreLibApi) api7);
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.parser.domain.ParserCoreLibApi");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.navigation.domain.NavigationCoreLibApi");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.deeplink.domain.DeepLinkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationRemoteCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresFlutterCartApi darkstoresFlutterCartApi(@NotNull @CoreApis Map<Class<?>, Api> map, @NotNull DarkstoresCartApi darkstoresCartApi) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        Intrinsics.checkNotNullParameter(darkstoresCartApi, "darkstoresCartApi");
        DarkstoresFlutterCartComponent.Factory factory = DaggerDarkstoresFlutterCartComponent.factory();
        Api api = map.get(DispatcherCoreLibApi.class);
        if (api != null) {
            DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api;
            Api api2 = map.get(ParserCoreLibApi.class);
            if (api2 != null) {
                return factory.create(darkstoresCartApi, dispatcherCoreLibApi, (ParserCoreLibApi) api2);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.parser.domain.ParserCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        DarkstoresScheduledDeliveryComponent.Factory factory = DaggerDarkstoresScheduledDeliveryComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(DispatcherCoreLibApi.class);
            if (api2 != null) {
                DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api2;
                Api api3 = map.get(ExperimentCoreLibApi.class);
                if (api3 != null) {
                    ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(configurationLocalCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, (NetworkCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresVendorApi darkstoresVendorApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        DarkstoresVendorComponent.Factory factory = DaggerDarkstoresVendorComponent.factory();
        Api api = map.get(DispatcherCoreLibApi.class);
        if (api != null) {
            DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api;
            Api api2 = map.get(FeatureFlagCoreLibApi.class);
            if (api2 != null) {
                FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(SecretCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, (SecretCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.aaa.di.SecretCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final FeesFeatureApi feesFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        FeesFeatureComponent.Factory factory = DaggerFeesFeatureComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(ConfigurationLocalCoreLibApi.class);
            if (api2 != null) {
                ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api2;
                Api api3 = map.get(FeatureFlagCoreLibApi.class);
                if (api3 != null) {
                    FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(TrackingCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(networkCoreLibApi, configurationLocalCoreLibApi, (TrackingCoreLibApi) api5, featureFlagCoreLibApi, contextCoreLibApi);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterBindingFeatureLibApi flutterBindingFeatureLibApi(@NotNull FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi) {
        Intrinsics.checkNotNullParameter(flutterChannelsFeatureLibApi, "flutterChannelsFeatureLibApi");
        return DaggerFlutterBindingFeatureLibComponent.factory().create(flutterChannelsFeatureLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi(@NotNull @CoreApis Map<Class<?>, Api> map, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        Intrinsics.checkNotNullParameter(subscriptionsFeatureApi, "subscriptionsFeatureApi");
        FlutterChannelsFeatureImplLibComponent.Factory factory = DaggerFlutterChannelsFeatureImplLibComponent.factory();
        Api api = map.get(NavigationCoreLibApi.class);
        if (api != null) {
            NavigationCoreLibApi navigationCoreLibApi = (NavigationCoreLibApi) api;
            Api api2 = map.get(ParserCoreLibApi.class);
            if (api2 != null) {
                return factory.create(navigationCoreLibApi, (ParserCoreLibApi) api2, subscriptionsFeatureApi);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.parser.domain.ParserCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.navigation.domain.NavigationCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final FlutterChannelsFeatureLibApi flutterChannelsFeatureLibApi(@NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FlutterChannelsFeatureImplLibApi flutterChannelsFeatureImplLibApi) {
        Intrinsics.checkNotNullParameter(dispatcherCoreLibApi, "dispatcherCoreLibApi");
        Intrinsics.checkNotNullParameter(flutterChannelsFeatureImplLibApi, "flutterChannelsFeatureImplLibApi");
        return DaggerFlutterChannelsFeatureLibComponent.factory().create(dispatcherCoreLibApi, flutterChannelsFeatureImplLibApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final FoodCartFeatureApi foodCartFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        FoodCartFeatureComponent.Factory factory = DaggerFoodCartFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ConfigurationRemoteCoreLibApi.class);
            if (api2 != null) {
                ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) api2;
                Api api3 = map.get(ContextCoreLibApi.class);
                if (api3 != null) {
                    ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api3;
                    Api api4 = map.get(ObservabilityCoreLibApi.class);
                    if (api4 != null) {
                        ObservabilityCoreLibApi observabilityCoreLibApi = (ObservabilityCoreLibApi) api4;
                        Api api5 = map.get(ExperimentCoreLibApi.class);
                        if (api5 != null) {
                            ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api5;
                            Api api6 = map.get(FeatureFlagCoreLibApi.class);
                            if (api6 != null) {
                                return factory.create(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, observabilityCoreLibApi, experimentCoreLibApi, (FeatureFlagCoreLibApi) api6);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationRemoteCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final HelpCenterFeatureApi helpCenterFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        HelpCenterFeatureComponent.Factory factory = DaggerHelpCenterFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(NetworkCoreLibApi.class);
            if (api2 != null) {
                NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api2;
                Api api3 = map.get(TrackingCoreLibApi.class);
                if (api3 != null) {
                    TrackingCoreLibApi trackingCoreLibApi = (TrackingCoreLibApi) api3;
                    Api api4 = map.get(FeatureFlagCoreLibApi.class);
                    if (api4 != null) {
                        FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api4;
                        Api api5 = map.get(DispatcherCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(networkCoreLibApi, configurationLocalCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, (DispatcherCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        IncentiveAutoApplyDiscountsComponent.Factory factory = DaggerIncentiveAutoApplyDiscountsComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(ConfigurationLocalCoreLibApi.class);
            if (api2 != null) {
                ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api2;
                Api api3 = map.get(FeatureFlagCoreLibApi.class);
                if (api3 != null) {
                    FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(configurationLocalCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, (NetworkCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final MissionControlFeatureApi missionControlFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        MissionControlFeatureComponent.Factory factory = DaggerMissionControlFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ExperimentCoreLibApi.class);
            if (api2 != null) {
                ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api2;
                Api api3 = map.get(FeatureFlagCoreLibApi.class);
                if (api3 != null) {
                    FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(ObservabilityCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(configurationLocalCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, (ObservabilityCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final PickupFeatureApi pickupFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        PickupFeatureComponent.Factory factory = DaggerPickupFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ContextCoreLibApi.class);
            if (api2 != null) {
                ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api2;
                Api api3 = map.get(DispatcherCoreLibApi.class);
                if (api3 != null) {
                    DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(TrackingCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(configurationLocalCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi, (TrackingCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        return DaggerQCommerceFlutterFeatureComponent.factory().create();
    }

    @NotNull
    @Reusable
    @Provides
    public final QCommerceMethodChannelFeatureLibApi qCommerceMethodChannelFeatureLibApi(@NotNull QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi) {
        Intrinsics.checkNotNullParameter(qCommerceMethodChannelFeatureLibImplApi, "qCommerceMethodChannelFeatureLibImplApi");
        return DaggerQCommerceMethodChannelFeatureLibComponent.factory().create(qCommerceMethodChannelFeatureLibImplApi);
    }

    @NotNull
    @Reusable
    @Provides
    public final QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        QCommerceMethodChannelFeatureLibImplComponent.Factory factory = DaggerQCommerceMethodChannelFeatureLibImplComponent.factory();
        Api api = map.get(NavigationCoreLibApi.class);
        if (api != null) {
            NavigationCoreLibApi navigationCoreLibApi = (NavigationCoreLibApi) api;
            Api api2 = map.get(ParserCoreLibApi.class);
            if (api2 != null) {
                return factory.create(navigationCoreLibApi, (ParserCoreLibApi) api2);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.parser.domain.ParserCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.navigation.domain.NavigationCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final RatingFeatureApi ratingFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        RatingFeatureComponent.Factory factory = DaggerRatingFeatureComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(ConfigurationLocalCoreLibApi.class);
            if (api2 != null) {
                ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(TokenCoreLibApi.class);
                    if (api4 != null) {
                        TokenCoreLibApi tokenCoreLibApi = (TokenCoreLibApi) api4;
                        Api api5 = map.get(TrackingCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(contextCoreLibApi, configurationLocalCoreLibApi, networkCoreLibApi, tokenCoreLibApi, (TrackingCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.token.domain.TokenCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final ReferAFriendFeatureApi referAFriendFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        return DaggerReferAFriendFeatureComponent.factory().create();
    }

    @NotNull
    @Reusable
    @Provides
    public final RewardsFeatureApi rewardsFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        RewardsFeatureComponent.Factory factory = DaggerRewardsFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(NetworkCoreLibApi.class);
            if (api2 != null) {
                NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api2;
                Api api3 = map.get(TrackingCoreLibApi.class);
                if (api3 != null) {
                    return factory.create(configurationLocalCoreLibApi, networkCoreLibApi, (TrackingCoreLibApi) api3);
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final RiderTipFeatureApi riderTipFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        RiderTipFeatureComponent.Factory factory = DaggerRiderTipFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ContextCoreLibApi.class);
            if (api2 != null) {
                ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(TrackingCoreLibApi.class);
                    if (api4 != null) {
                        TrackingCoreLibApi trackingCoreLibApi = (TrackingCoreLibApi) api4;
                        Api api5 = map.get(ExperimentCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(contextCoreLibApi, networkCoreLibApi, configurationLocalCoreLibApi, trackingCoreLibApi, (ExperimentCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final SubscriptionsFeatureApi subscriptionsFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        SubscriptionsFeatureComponent.Factory factory = DaggerSubscriptionsFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ContextCoreLibApi.class);
            if (api2 != null) {
                ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api2;
                Api api3 = map.get(DispatcherCoreLibApi.class);
                if (api3 != null) {
                    DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(TrackingCoreLibApi.class);
                        if (api5 != null) {
                            TrackingCoreLibApi trackingCoreLibApi = (TrackingCoreLibApi) api5;
                            Api api6 = map.get(FeatureFlagCoreLibApi.class);
                            if (api6 != null) {
                                FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api6;
                                Api api7 = map.get(ExperimentCoreLibApi.class);
                                if (api7 != null) {
                                    ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) api7;
                                    Api api8 = map.get(SecretCoreLibApi.class);
                                    if (api8 != null) {
                                        return factory.create(configurationLocalCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, experimentCoreLibApi, (SecretCoreLibApi) api8);
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.aaa.di.SecretCoreLibApi");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.experiment.domain.ExperimentCoreLibApi");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.tracking.domain.TrackingCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final SwimlanesFeatureApi swimlanesFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        SwimlanesFeatureComponent.Factory factory = DaggerSwimlanesFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(DispatcherCoreLibApi.class);
            if (api2 != null) {
                DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api2;
                Api api3 = map.get(FeatureFlagCoreLibApi.class);
                if (api3 != null) {
                    FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api3;
                    Api api4 = map.get(NetworkCoreLibApi.class);
                    if (api4 != null) {
                        NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api4;
                        Api api5 = map.get(ObservabilityCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(configurationLocalCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, (ObservabilityCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final TMartGrowthFeatureApi tmartGrowthFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        TMartGrowthFeatureComponent.Factory factory = DaggerTMartGrowthFeatureComponent.factory();
        Api api = map.get(ContextCoreLibApi.class);
        if (api != null) {
            ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api;
            Api api2 = map.get(DispatcherCoreLibApi.class);
            if (api2 != null) {
                DispatcherCoreLibApi dispatcherCoreLibApi = (DispatcherCoreLibApi) api2;
                Api api3 = map.get(NetworkCoreLibApi.class);
                if (api3 != null) {
                    NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api3;
                    Api api4 = map.get(SecretCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create((SecretCoreLibApi) api4, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.authentication.aaa.di.SecretCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.dispatcher.domain.DispatcherCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final TokenizationFeatureApi tokenizationFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        TokenizationFeatureComponent.Factory factory = DaggerTokenizationFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ConfigurationRemoteCoreLibApi.class);
            if (api2 != null) {
                ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) api2;
                Api api3 = map.get(ContextCoreLibApi.class);
                if (api3 != null) {
                    ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api3;
                    Api api4 = map.get(FeatureFlagCoreLibApi.class);
                    if (api4 != null) {
                        FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api4;
                        Api api5 = map.get(NetworkCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, (NetworkCoreLibApi) api5);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationRemoteCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final WalletAddCardFeatureApi walletAddCardFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map, @NotNull TokenizationFeatureApi tokenizationFeatureApi) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        Intrinsics.checkNotNullParameter(tokenizationFeatureApi, "tokenizationFeatureApi");
        WalletAddCardFeatureComponent.Factory factory = DaggerWalletAddCardFeatureComponent.factory();
        Api api = map.get(ConfigurationLocalCoreLibApi.class);
        if (api != null) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) api;
            Api api2 = map.get(ConfigurationRemoteCoreLibApi.class);
            if (api2 != null) {
                ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) api2;
                Api api3 = map.get(ContextCoreLibApi.class);
                if (api3 != null) {
                    ContextCoreLibApi contextCoreLibApi = (ContextCoreLibApi) api3;
                    Api api4 = map.get(FeatureFlagCoreLibApi.class);
                    if (api4 != null) {
                        FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) api4;
                        Api api5 = map.get(ObservabilityCoreLibApi.class);
                        if (api5 != null) {
                            return factory.create(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, (ObservabilityCoreLibApi) api5, tokenizationFeatureApi);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.context.domain.ContextCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationRemoteCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationLocalCoreLibApi");
    }

    @NotNull
    @Reusable
    @Provides
    public final WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi(@NotNull @CoreApis Map<Class<?>, Api> map) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        WalletCobrandedCcFeatureComponent.Factory factory = DaggerWalletCobrandedCcFeatureComponent.factory();
        Api api = map.get(ConfigurationRemoteCoreLibApi.class);
        if (api != null) {
            ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) api;
            Api api2 = map.get(NetworkCoreLibApi.class);
            if (api2 != null) {
                NetworkCoreLibApi networkCoreLibApi = (NetworkCoreLibApi) api2;
                Api api3 = map.get(ObservabilityCoreLibApi.class);
                if (api3 != null) {
                    ObservabilityCoreLibApi observabilityCoreLibApi = (ObservabilityCoreLibApi) api3;
                    Api api4 = map.get(CustomerCoreLibApi.class);
                    if (api4 != null) {
                        return factory.create(configurationRemoteCoreLibApi, observabilityCoreLibApi, networkCoreLibApi, (CustomerCoreLibApi) api4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.customer.domain.di.CustomerCoreLibApi");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.network.domain.NetworkCoreLibApi");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.configuration.di.ConfigurationRemoteCoreLibApi");
    }
}
