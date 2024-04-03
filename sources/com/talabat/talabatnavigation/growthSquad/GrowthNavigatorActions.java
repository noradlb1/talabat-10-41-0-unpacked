package com.talabat.talabatnavigation.growthSquad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/growthSquad/GrowthNavigatorActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GrowthNavigatorActions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_LOYALTY_BURN_DETAILS_TOTAL_POINTS = "BurnDetailsTotalPoints";
    @NotNull
    public static final String EXTRA_LOYALTY_Burn_OPTION_DATA = "RedeemTitle";
    @NotNull
    public static final String EXTRA_LOYALTY_CONFIRMATION_REDEMPTION_DATA = "ConfirmationRedemptionData";
    @NotNull
    public static final String EXTRA_LOYALTY_FEATURED_CATEGORY_ID = "categoryId";
    @NotNull
    public static final String EXTRA_LOYALTY_FEATURED_CATEGORY_NAME = "categoryName";
    @NotNull
    public static final String EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE = "categoryType";
    @NotNull
    public static final String EXTRA_LOYALTY_FEATURED_CHANNEL_NAME = "channelName";
    @NotNull
    public static final String EXTRA_LOYALTY_FEATURED_CHANNEL_POSITION = "channelPosition";
    @NotNull
    public static final String EXTRA_LOYALTY_HISTORY_POINTS_EXPIRY_TEXT = "PointsExpiryText";
    @NotNull
    public static final String EXTRA_LOYALTY_HISTORY_TOTAL_POINTS = "TotalPoints";
    @NotNull
    public static final String EXTRA_LOYALTY_HOW_IT_WORKS_TOTAL_POINTS = "TotalPoints";
    @NotNull
    public static final String EXTRA_LOYALTY_REMAINING_POINTS = "remainingPoints";
    @NotNull
    public static final String EXTRA_LOYALTY_VOUCHER_ID = "voucherID";
    @NotNull
    public static final String OPEN_LOYALTY_BURN_OPTIONS_REDEEM_ACTIVITY = "talabat.action.Growth.loyalty.burnOptionsRedeem";
    @NotNull
    public static final String OPEN_LOYALTY_FEATURED_LIST_ACTIVITY = "talabat.action.Growth.loyalty.featured.list";
    @NotNull
    public static final String OPEN_LOYALTY_HISTORY_ACTIVITY = "talabat.action.Growth.loyalty.history";
    @NotNull
    public static final String OPEN_LOYALTY_HOW_IT_WORKS_ACTIVITY = "talabat.action.Growth.loyalty.howItWorks";
    @NotNull
    public static final String OPEN_LOYALTY_VOUCHER_DETAILS_ACTIVITY = "talabat.action.Growth.vouchers.details";
    @NotNull
    public static final String OPEN_REFER_A_FRIEND_SENDER_ACTIVITY = "talabat.action.Growth.incentives.referfriend.sender";

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001.B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\"2\u0006\u0010&\u001a\u00020'J3\u0010*\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0007J\u0006\u0010-\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/talabat/talabatnavigation/growthSquad/GrowthNavigatorActions$Companion;", "", "()V", "EXTRA_LOYALTY_BURN_DETAILS_TOTAL_POINTS", "", "EXTRA_LOYALTY_Burn_OPTION_DATA", "EXTRA_LOYALTY_CONFIRMATION_REDEMPTION_DATA", "EXTRA_LOYALTY_FEATURED_CATEGORY_ID", "EXTRA_LOYALTY_FEATURED_CATEGORY_NAME", "EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE", "EXTRA_LOYALTY_FEATURED_CHANNEL_NAME", "EXTRA_LOYALTY_FEATURED_CHANNEL_POSITION", "EXTRA_LOYALTY_HISTORY_POINTS_EXPIRY_TEXT", "EXTRA_LOYALTY_HISTORY_TOTAL_POINTS", "EXTRA_LOYALTY_HOW_IT_WORKS_TOTAL_POINTS", "EXTRA_LOYALTY_REMAINING_POINTS", "EXTRA_LOYALTY_VOUCHER_ID", "OPEN_LOYALTY_BURN_OPTIONS_REDEEM_ACTIVITY", "OPEN_LOYALTY_FEATURED_LIST_ACTIVITY", "OPEN_LOYALTY_HISTORY_ACTIVITY", "OPEN_LOYALTY_HOW_IT_WORKS_ACTIVITY", "OPEN_LOYALTY_VOUCHER_DETAILS_ACTIVITY", "OPEN_REFER_A_FRIEND_SENDER_ACTIVITY", "createIntent", "Landroid/content/Intent;", "screen", "Lcom/talabat/core/navigation/domain/screen/Screen;", "context", "Landroid/content/Context;", "extraOptions", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createNavigatorModelForFeaturedCategoryList", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "params", "Lcom/talabat/talabatnavigation/growthSquad/GrowthNavigatorActions$Companion$FeaturedCategoryListParams;", "createNavigatorModelForLoyaltyHistory", "totalPoints", "", "expiryText", "createNavigatorModelForLoyaltyHowItWorks", "startLoyaltyDashboardActivity", "rewardsCatalogueOrigin", "Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen$RewardsCatalogueOrigin;", "startReferAFriendSenderActivity", "FeaturedCategoryListParams", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/talabat/talabatnavigation/growthSquad/GrowthNavigatorActions$Companion$FeaturedCategoryListParams;", "", "categoryId", "", "categoryName", "categoryType", "totalPoints", "", "channelName", "channelPosition", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getCategoryType", "getChannelName", "getChannelPosition", "()I", "getTotalPoints", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class FeaturedCategoryListParams {
            @NotNull
            private final String categoryId;
            @NotNull
            private final String categoryName;
            @NotNull
            private final String categoryType;
            @NotNull
            private final String channelName;
            private final int channelPosition;
            private final int totalPoints;

            public FeaturedCategoryListParams(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, @NotNull String str4, int i12) {
                Intrinsics.checkNotNullParameter(str, "categoryId");
                Intrinsics.checkNotNullParameter(str2, "categoryName");
                Intrinsics.checkNotNullParameter(str3, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE);
                Intrinsics.checkNotNullParameter(str4, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME);
                this.categoryId = str;
                this.categoryName = str2;
                this.categoryType = str3;
                this.totalPoints = i11;
                this.channelName = str4;
                this.channelPosition = i12;
            }

            public static /* synthetic */ FeaturedCategoryListParams copy$default(FeaturedCategoryListParams featuredCategoryListParams, String str, String str2, String str3, int i11, String str4, int i12, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    str = featuredCategoryListParams.categoryId;
                }
                if ((i13 & 2) != 0) {
                    str2 = featuredCategoryListParams.categoryName;
                }
                String str5 = str2;
                if ((i13 & 4) != 0) {
                    str3 = featuredCategoryListParams.categoryType;
                }
                String str6 = str3;
                if ((i13 & 8) != 0) {
                    i11 = featuredCategoryListParams.totalPoints;
                }
                int i14 = i11;
                if ((i13 & 16) != 0) {
                    str4 = featuredCategoryListParams.channelName;
                }
                String str7 = str4;
                if ((i13 & 32) != 0) {
                    i12 = featuredCategoryListParams.channelPosition;
                }
                return featuredCategoryListParams.copy(str, str5, str6, i14, str7, i12);
            }

            @NotNull
            public final String component1() {
                return this.categoryId;
            }

            @NotNull
            public final String component2() {
                return this.categoryName;
            }

            @NotNull
            public final String component3() {
                return this.categoryType;
            }

            public final int component4() {
                return this.totalPoints;
            }

            @NotNull
            public final String component5() {
                return this.channelName;
            }

            public final int component6() {
                return this.channelPosition;
            }

            @NotNull
            public final FeaturedCategoryListParams copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, @NotNull String str4, int i12) {
                Intrinsics.checkNotNullParameter(str, "categoryId");
                Intrinsics.checkNotNullParameter(str2, "categoryName");
                Intrinsics.checkNotNullParameter(str3, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE);
                Intrinsics.checkNotNullParameter(str4, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME);
                return new FeaturedCategoryListParams(str, str2, str3, i11, str4, i12);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FeaturedCategoryListParams)) {
                    return false;
                }
                FeaturedCategoryListParams featuredCategoryListParams = (FeaturedCategoryListParams) obj;
                return Intrinsics.areEqual((Object) this.categoryId, (Object) featuredCategoryListParams.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) featuredCategoryListParams.categoryName) && Intrinsics.areEqual((Object) this.categoryType, (Object) featuredCategoryListParams.categoryType) && this.totalPoints == featuredCategoryListParams.totalPoints && Intrinsics.areEqual((Object) this.channelName, (Object) featuredCategoryListParams.channelName) && this.channelPosition == featuredCategoryListParams.channelPosition;
            }

            @NotNull
            public final String getCategoryId() {
                return this.categoryId;
            }

            @NotNull
            public final String getCategoryName() {
                return this.categoryName;
            }

            @NotNull
            public final String getCategoryType() {
                return this.categoryType;
            }

            @NotNull
            public final String getChannelName() {
                return this.channelName;
            }

            public final int getChannelPosition() {
                return this.channelPosition;
            }

            public final int getTotalPoints() {
                return this.totalPoints;
            }

            public int hashCode() {
                return (((((((((this.categoryId.hashCode() * 31) + this.categoryName.hashCode()) * 31) + this.categoryType.hashCode()) * 31) + this.totalPoints) * 31) + this.channelName.hashCode()) * 31) + this.channelPosition;
            }

            @NotNull
            public String toString() {
                String str = this.categoryId;
                String str2 = this.categoryName;
                String str3 = this.categoryType;
                int i11 = this.totalPoints;
                String str4 = this.channelName;
                int i12 = this.channelPosition;
                return "FeaturedCategoryListParams(categoryId=" + str + ", categoryName=" + str2 + ", categoryType=" + str3 + ", totalPoints=" + i11 + ", channelName=" + str4 + ", channelPosition=" + i12 + ")";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [com.talabat.core.navigation.domain.screen.Screen, com.talabat.core.navigation.domain.screen.Screen<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.content.Intent createIntent(com.talabat.core.navigation.domain.screen.Screen<?> r3, android.content.Context r4, kotlin.jvm.functions.Function1<? super android.content.Intent, kotlin.Unit> r5) {
            /*
                r2 = this;
                android.content.Intent r0 = new android.content.Intent
                r0.<init>()
                java.lang.String r1 = r3.getLink()
                r0.setAction(r1)
                java.lang.String r4 = r4.getPackageName()
                r0.setPackage(r4)
                java.lang.String r4 = "navigatorData"
                android.os.Parcelable r3 = r3.getData()
                r0.putExtra(r4, r3)
                r5.invoke(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions.Companion.createIntent(com.talabat.core.navigation.domain.screen.Screen, android.content.Context, kotlin.jvm.functions.Function1):android.content.Intent");
        }

        public static /* synthetic */ void startLoyaltyDashboardActivity$default(Companion companion, Context context, LoyaltyDashboardScreen.RewardsCatalogueOrigin rewardsCatalogueOrigin, Function1 function1, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                function1 = GrowthNavigatorActions$Companion$startLoyaltyDashboardActivity$1.INSTANCE;
            }
            companion.startLoyaltyDashboardActivity(context, rewardsCatalogueOrigin, function1);
        }

        @NotNull
        public final NavigatorModel createNavigatorModelForFeaturedCategoryList(@NotNull FeaturedCategoryListParams featuredCategoryListParams) {
            Intrinsics.checkNotNullParameter(featuredCategoryListParams, NativeProtocol.WEB_DIALOG_PARAMS);
            Bundle bundle = new Bundle();
            bundle.putString("categoryId", featuredCategoryListParams.getCategoryId());
            bundle.putString("categoryName", featuredCategoryListParams.getCategoryName());
            bundle.putString(GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CATEGORY_TYPE, featuredCategoryListParams.getCategoryType());
            bundle.putInt("BurnDetailsTotalPoints", featuredCategoryListParams.getTotalPoints());
            bundle.putString(GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME, featuredCategoryListParams.getChannelName());
            bundle.putInt("channelPosition", featuredCategoryListParams.getChannelPosition());
            return new NavigatorModel(GrowthNavigatorActions.OPEN_LOYALTY_FEATURED_LIST_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigatorModelForLoyaltyHistory(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "expiryText");
            Bundle bundle = new Bundle();
            bundle.putInt("TotalPoints", i11);
            bundle.putString(GrowthNavigatorActions.EXTRA_LOYALTY_HISTORY_POINTS_EXPIRY_TEXT, str);
            return new NavigatorModel(GrowthNavigatorActions.OPEN_LOYALTY_HISTORY_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigatorModelForLoyaltyHowItWorks(int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt("TotalPoints", i11);
            return new NavigatorModel(GrowthNavigatorActions.OPEN_LOYALTY_HOW_IT_WORKS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public final void startLoyaltyDashboardActivity(@NotNull Context context, @NotNull LoyaltyDashboardScreen.RewardsCatalogueOrigin rewardsCatalogueOrigin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rewardsCatalogueOrigin, "rewardsCatalogueOrigin");
            startLoyaltyDashboardActivity$default(this, context, rewardsCatalogueOrigin, (Function1) null, 4, (Object) null);
        }

        @JvmOverloads
        public final void startLoyaltyDashboardActivity(@NotNull Context context, @NotNull LoyaltyDashboardScreen.RewardsCatalogueOrigin rewardsCatalogueOrigin, @NotNull Function1<? super Intent, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rewardsCatalogueOrigin, "rewardsCatalogueOrigin");
            Intrinsics.checkNotNullParameter(function1, "extraOptions");
            context.startActivity(createIntent(new LoyaltyDashboardScreen(new LoyaltyDashboardScreen.LoyaltyDashboardData(rewardsCatalogueOrigin.getEventOrigin())), context, function1));
        }

        @NotNull
        public final NavigatorModel startReferAFriendSenderActivity() {
            return new NavigatorModel(GrowthNavigatorActions.OPEN_REFER_A_FRIEND_SENDER_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        }
    }
}
