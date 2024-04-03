package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingFeatureLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibApi;
import com.talabat.core.flutter.channels.domain.di.QCommerceMethodChannelFeatureLibImplApi;
import com.talabat.domain.address.di.AddressFeatureApi;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
import com.talabat.feature.darkstores.vendorlanding.domain.VendorLandingFeatureApi;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.incentiveautoapplydiscounts.domain.di.IncentiveAutoApplyDiscountsFeatureApi;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.ridertips.domain.RiderTipFeatureApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
import com.talabat.feature.uladdressform.domain.AddressFormFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.features.swimlanevoucherslist.domain.di.CustomerVouchersSwimLaneFeaturesApi;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H'J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H'J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020 H'J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H'J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H'J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H'J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H'J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H'J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H'J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H'J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H'J\u0010\u00101\u001a\u00020\u00032\u0006\u00101\u001a\u000202H'J\u0010\u00103\u001a\u00020\u00032\u0006\u00103\u001a\u000204H'J\u0010\u00105\u001a\u00020\u00032\u0006\u00105\u001a\u000206H'J\u0010\u00107\u001a\u00020\u00032\u0006\u00107\u001a\u000208H'J\u0010\u00109\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H'J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H'J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H'J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH'J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010B\u001a\u00020CH'J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020FH'J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010G\u001a\u00020HH'J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010I\u001a\u00020JH'¨\u0006K"}, d2 = {"Lcom/talabat/app/di/FeatureApiModule;", "", "accountInfoFeatureApi", "Lcom/talabat/core/di/Api;", "Lcom/talabat/feature/ulaccountinfo/domain/AccountInfoFeatureApi;", "activeCartsApi", "Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "addressFeatureApi", "Lcom/talabat/domain/address/di/AddressFeatureApi;", "addressFormFeatureApi", "feesFeatureApi", "Lcom/talabat/feature/uladdressform/domain/AddressFormFeatureApi;", "bnplCoreFeatureApi", "Lcom/talabat/feature/bnplcore/domain/BnplCoreFeatureApi;", "campaignMessagingApi", "Lcom/talabat/feature/darkstorescampaignmessage/domain/CampaignMessagingApi;", "campaignMigratorFeatureApi", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorFeatureApi;", "darkstoresCartApi", "Lcom/talabat/feature/darkstorescart/data/di/DarkstoresCartApi;", "darkstoresCartListApi", "Lcom/talabat/feature/darkstorescartlist/domain/di/DarkstoresCartListApi;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "darkstoresFlutterCartApi", "Lcom/talabat/feature/darkstoresflutter/domain/DarkstoresFlutterCartApi;", "darkstoresScheduledDeliveryFeatureApi", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/DarkstoresScheduledDeliveryFeatureApi;", "darkstoresVendorApi", "Lcom/talabat/feature/darkstoresvendor/domain/DarkstoresVendorApi;", "darkstoresVendorLandingApi", "Lcom/talabat/feature/darkstores/vendorlanding/domain/VendorLandingFeatureApi;", "Lcom/talabat/feature/fees/domain/FeesFeatureApi;", "flutterBindingFeatureLibApi", "Lcom/talabat/core/flutter/binding/domain/di/FlutterBindingFeatureLibApi;", "foodCartFeatureApi", "Lcom/talabat/feature/foodcart2/domain/di/FoodCartFeatureApi;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "incentiveAutoApplyDiscountsFeatureApi", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/di/IncentiveAutoApplyDiscountsFeatureApi;", "missionControlFeatureApi", "Lcom/talabat/feature/mission/control/domain/MissionControlFeatureApi;", "pickupFeatureApi", "Lcom/talabat/feature/pickup/domain/PickupFeatureApi;", "qCommerceFlutterFeatureApi", "Lcom/talabat/feature/nfvinvendorsearch/domain/di/QCommerceFlutterFeatureApi;", "qCommerceMethodChannelFeatureLibApi", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibApi;", "qCommerceMethodChannelFeatureLibImplApi", "Lcom/talabat/core/flutter/channels/domain/di/QCommerceMethodChannelFeatureLibImplApi;", "ratingFeatureApi", "Lcom/talabat/feature/rating/domain/RatingFeatureApi;", "referAFriendFeatureApi", "Lcom/talabat/feature/referafriend/domain/di/ReferAFriendFeatureApi;", "rewardsFeatureApi", "Lcom/talabat/feature/rewards/domain/RewardsFeatureApi;", "riderTipFeatureApi", "Lcom/talabat/feature/ridertips/domain/RiderTipFeatureApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "swimlanesFeatureApi", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesFeatureApi;", "tmartGrowthFeatureApi", "tMartGrowthFeatureApi", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthFeatureApi;", "tokenizationFeatureApi", "Lcom/talabat/feature/tokenization/domain/TokenizationFeatureApi;", "vouchersSwimLaneFeaturesApi", "customerVouchersSwimLaneFeaturesApi", "Lcom/talabat/features/swimlanevoucherslist/domain/di/CustomerVouchersSwimLaneFeaturesApi;", "walletAddCardFeatureApi", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardFeatureApi;", "walletCobrandedCcFeatureApi", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcFeatureApi;", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {FeaturesModule.class})
public interface FeatureApiModule {
    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(AccountInfoFeatureApi.class)
    @Reusable
    Api accountInfoFeatureApi(@NotNull AccountInfoFeatureApi accountInfoFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(ActiveCartsApi.class)
    @Reusable
    Api activeCartsApi(@NotNull ActiveCartsApi activeCartsApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(AddressFeatureApi.class)
    @Reusable
    Api addressFeatureApi(@NotNull AddressFeatureApi addressFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(AddressFormFeatureApi.class)
    @Reusable
    Api addressFormFeatureApi(@NotNull AddressFormFeatureApi addressFormFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(BnplCoreFeatureApi.class)
    @Reusable
    Api bnplCoreFeatureApi(@NotNull BnplCoreFeatureApi bnplCoreFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(CampaignMessagingApi.class)
    @Reusable
    Api campaignMessagingApi(@NotNull CampaignMessagingApi campaignMessagingApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(CampaignMigratorFeatureApi.class)
    @Reusable
    Api campaignMigratorFeatureApi(@NotNull CampaignMigratorFeatureApi campaignMigratorFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(DarkstoresCartApi.class)
    @Reusable
    Api darkstoresCartApi(@NotNull DarkstoresCartApi darkstoresCartApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(DarkstoresCartListApi.class)
    @Reusable
    Api darkstoresCartListApi(@NotNull DarkstoresCartListApi darkstoresCartListApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(DarkstoresFeatureApi.class)
    @Reusable
    Api darkstoresFeatureApi(@NotNull DarkstoresFeatureApi darkstoresFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(DarkstoresFlutterCartApi.class)
    @Reusable
    Api darkstoresFlutterCartApi(@NotNull DarkstoresFlutterCartApi darkstoresFlutterCartApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(DarkstoresScheduledDeliveryFeatureApi.class)
    @Reusable
    Api darkstoresScheduledDeliveryFeatureApi(@NotNull DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(DarkstoresVendorApi.class)
    @Reusable
    Api darkstoresVendorApi(@NotNull DarkstoresVendorApi darkstoresVendorApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(VendorLandingFeatureApi.class)
    @Reusable
    Api darkstoresVendorLandingApi(@NotNull VendorLandingFeatureApi vendorLandingFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(FeesFeatureApi.class)
    @Reusable
    Api feesFeatureApi(@NotNull FeesFeatureApi feesFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(FlutterBindingFeatureLibApi.class)
    @Reusable
    Api flutterBindingFeatureLibApi(@NotNull FlutterBindingFeatureLibApi flutterBindingFeatureLibApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(FoodCartFeatureApi.class)
    @Reusable
    Api foodCartFeatureApi(@NotNull FoodCartFeatureApi foodCartFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(HelpCenterFeatureApi.class)
    @Reusable
    Api helpCenterFeatureApi(@NotNull HelpCenterFeatureApi helpCenterFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(IncentiveAutoApplyDiscountsFeatureApi.class)
    @Reusable
    Api incentiveAutoApplyDiscountsFeatureApi(@NotNull IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(MissionControlFeatureApi.class)
    @Reusable
    Api missionControlFeatureApi(@NotNull MissionControlFeatureApi missionControlFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(PickupFeatureApi.class)
    @Reusable
    Api pickupFeatureApi(@NotNull PickupFeatureApi pickupFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(QCommerceFlutterFeatureApi.class)
    @Reusable
    Api qCommerceFlutterFeatureApi(@NotNull QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(QCommerceMethodChannelFeatureLibApi.class)
    @Reusable
    Api qCommerceMethodChannelFeatureLibApi(@NotNull QCommerceMethodChannelFeatureLibApi qCommerceMethodChannelFeatureLibApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(QCommerceMethodChannelFeatureLibImplApi.class)
    @Reusable
    Api qCommerceMethodChannelFeatureLibImplApi(@NotNull QCommerceMethodChannelFeatureLibImplApi qCommerceMethodChannelFeatureLibImplApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(RatingFeatureApi.class)
    @Reusable
    Api ratingFeatureApi(@NotNull RatingFeatureApi ratingFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(ReferAFriendFeatureApi.class)
    @Reusable
    Api referAFriendFeatureApi(@NotNull ReferAFriendFeatureApi referAFriendFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(RewardsFeatureApi.class)
    @Reusable
    Api rewardsFeatureApi(@NotNull RewardsFeatureApi rewardsFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(RiderTipFeatureApi.class)
    @Reusable
    Api riderTipFeatureApi(@NotNull RiderTipFeatureApi riderTipFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(SubscriptionsFeatureApi.class)
    @Reusable
    Api subscriptionsFeatureApi(@NotNull SubscriptionsFeatureApi subscriptionsFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(SwimlanesFeatureApi.class)
    @Reusable
    Api swimlanesFeatureApi(@NotNull SwimlanesFeatureApi swimlanesFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(TMartGrowthFeatureApi.class)
    @Reusable
    Api tmartGrowthFeatureApi(@NotNull TMartGrowthFeatureApi tMartGrowthFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(TokenizationFeatureApi.class)
    @Reusable
    Api tokenizationFeatureApi(@NotNull TokenizationFeatureApi tokenizationFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(CustomerVouchersSwimLaneFeaturesApi.class)
    @Reusable
    Api vouchersSwimLaneFeaturesApi(@NotNull CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(WalletAddCardFeatureApi.class)
    @Reusable
    Api walletAddCardFeatureApi(@NotNull WalletAddCardFeatureApi walletAddCardFeatureApi);

    @FeatureApis
    @Binds
    @IntoMap
    @NotNull
    @ClassKey(WalletCobrandedCcFeatureApi.class)
    @Reusable
    Api walletCobrandedCcFeatureApi(@NotNull WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi);
}
