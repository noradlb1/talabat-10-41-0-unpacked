package com.integration.tLife;

import buisnessmodels.FilterEngine;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.GTMTLife;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/integration/tLife/IntegrationAppTrackerTLife;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationAppTrackerTLife {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJF\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0004JF\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006JN\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006JN\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006JV\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006¨\u0006!"}, d2 = {"Lcom/integration/tLife/IntegrationAppTrackerTLife$Companion;", "", "()V", "onTLifeCheckoutLoaded", "", "vendorName", "", "branchId", "offersSize", "offerName", "payAmount", "shopOffersSelected", "onTLifeListLoaded", "shopQuantityTotal", "", "onTLifeOfferDetailsLoaded", "cuisineString", "branches", "rating", "ratingCount", "onTLifeScanQRClickedFromHome", "onTLifeScanQRClickedFromOfferDetails", "onTLifeScanQRFailed", "screenName", "errorMessage", "onTLifeScanQRSuccessful", "onTLifeTransactionClicked", "orderPaymentMethod", "coupon", "couponValue", "onTLifeTransactionFailed", "onTLifeTransactionSuccess", "transactionRevenue", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onTLifeCheckoutLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            String str7 = str;
            Intrinsics.checkNotNullParameter(str7, "vendorName");
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str8, "branchId");
            String str9 = str3;
            Intrinsics.checkNotNullParameter(str9, "offersSize");
            String str10 = str4;
            Intrinsics.checkNotNullParameter(str10, "offerName");
            String str11 = str5;
            Intrinsics.checkNotNullParameter(str11, "payAmount");
            String str12 = str6;
            Intrinsics.checkNotNullParameter(str12, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            GTMTLife.Companion.onTLifeCheckoutLoaded("N/A", str7, str8, "N/A", "N/A", "N/A", str9, str10, "N/A", "N/A", str11, "N/A", "N/A", str12);
        }

        public final void onTLifeListLoaded(int i11) {
            GTMTLife.Companion.onTLifeListLoaded(i11);
        }

        public final void onTLifeOfferDetailsLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "cuisineString");
            Intrinsics.checkNotNullParameter(str2, "vendorName");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            Intrinsics.checkNotNullParameter(str4, "branches");
            Intrinsics.checkNotNullParameter(str5, FilterEngine.DEEPLINKSORT.RATING);
            String str9 = str6;
            Intrinsics.checkNotNullParameter(str9, "ratingCount");
            String str10 = str7;
            Intrinsics.checkNotNullParameter(str10, "offersSize");
            String str11 = str8;
            Intrinsics.checkNotNullParameter(str11, "offerName");
            GTMTLife.Companion.onTLifeOfferDetailsLoaded(str, str2, str3, str4, str5, str9, str10, str11);
        }

        public final void onTLifeScanQRClickedFromHome() {
            GTMTLife.Companion.onTLifeScanQRClickedFromHome("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A");
        }

        public final void onTLifeScanQRClickedFromOfferDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "cuisineString");
            Intrinsics.checkNotNullParameter(str2, "vendorName");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            Intrinsics.checkNotNullParameter(str4, "branches");
            Intrinsics.checkNotNullParameter(str5, FilterEngine.DEEPLINKSORT.RATING);
            String str9 = str6;
            Intrinsics.checkNotNullParameter(str9, "ratingCount");
            String str10 = str7;
            Intrinsics.checkNotNullParameter(str10, "offersSize");
            String str11 = str8;
            Intrinsics.checkNotNullParameter(str11, "offerName");
            GTMTLife.Companion.onTLifeScanQRClickedFromOfferDetails(str, str2, str3, str4, str5, str9, str10, str11);
        }

        public final void onTLifeScanQRFailed(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "errorMessage");
            GTMTLife.Companion.onTLifeScanQRFailed(str, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", str2);
        }

        public final void onTLifeScanQRSuccessful(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "vendorName");
            Intrinsics.checkNotNullParameter(str3, "branchId");
            GTMTLife.Companion.onTLifeScanQRSuccessful(str, "N/A", str2, str3, "N/A", "N/A", "N/A", "N/A", "N/A");
        }

        public final void onTLifeTransactionClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            String str10 = str;
            Intrinsics.checkNotNullParameter(str10, "vendorName");
            String str11 = str2;
            Intrinsics.checkNotNullParameter(str11, "branchId");
            String str12 = str3;
            Intrinsics.checkNotNullParameter(str12, "offersSize");
            String str13 = str4;
            Intrinsics.checkNotNullParameter(str13, "offerName");
            String str14 = str5;
            Intrinsics.checkNotNullParameter(str14, "orderPaymentMethod");
            String str15 = str6;
            Intrinsics.checkNotNullParameter(str15, "payAmount");
            String str16 = str7;
            Intrinsics.checkNotNullParameter(str16, "coupon");
            String str17 = str8;
            Intrinsics.checkNotNullParameter(str17, GrowthTrackerConstants.COUPON_VALUE);
            String str18 = str9;
            Intrinsics.checkNotNullParameter(str18, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            GTMTLife.Companion.onTLifeTransactionClicked("N/A", str10, str11, "N/A", "N/A", "N/A", str12, str13, "N/A", str14, str15, str16, str17, str18);
        }

        public final void onTLifeTransactionFailed(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            String str10 = str;
            Intrinsics.checkNotNullParameter(str10, "vendorName");
            String str11 = str2;
            Intrinsics.checkNotNullParameter(str11, "branchId");
            String str12 = str3;
            Intrinsics.checkNotNullParameter(str12, "offersSize");
            String str13 = str4;
            Intrinsics.checkNotNullParameter(str13, "offerName");
            String str14 = str5;
            Intrinsics.checkNotNullParameter(str14, "orderPaymentMethod");
            String str15 = str6;
            Intrinsics.checkNotNullParameter(str15, "payAmount");
            String str16 = str7;
            Intrinsics.checkNotNullParameter(str16, "coupon");
            String str17 = str8;
            Intrinsics.checkNotNullParameter(str17, GrowthTrackerConstants.COUPON_VALUE);
            String str18 = str9;
            Intrinsics.checkNotNullParameter(str18, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            GTMTLife.Companion.onTLifeTransactionFailed("N/A", str10, str11, "N/A", "N/A", "N/A", str12, str13, "N/A", str14, str15, str16, str17, str18);
        }

        public final void onTLifeTransactionSuccess(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10) {
            Intrinsics.checkNotNullParameter(str, "vendorName");
            Intrinsics.checkNotNullParameter(str2, "branchId");
            Intrinsics.checkNotNullParameter(str3, "offersSize");
            Intrinsics.checkNotNullParameter(str4, "offerName");
            Intrinsics.checkNotNullParameter(str5, "orderPaymentMethod");
            Intrinsics.checkNotNullParameter(str6, "payAmount");
            Intrinsics.checkNotNullParameter(str7, "coupon");
            Intrinsics.checkNotNullParameter(str8, GrowthTrackerConstants.COUPON_VALUE);
            Intrinsics.checkNotNullParameter(str9, ConstantsKt.LOADED_SHOP_OFFERS_SELECTED);
            Intrinsics.checkNotNullParameter(str10, "transactionRevenue");
            GTMTLife.Companion.onTLifeTransactionSuccess("N/A", str, str2, "N/A", "N/A", "N/A", str3, str4, "N/A", str5, str6, str7, str8, str9, str10, "N/A");
        }
    }
}
