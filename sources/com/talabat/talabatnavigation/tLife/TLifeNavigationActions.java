package com.talabat.talabatnavigation.tLife;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/tLife/TLifeNavigationActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeNavigationActions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_IS_EXIT_FREE_COFFEE = "isExitFreeCoffee";
    @NotNull
    public static final String EXTRA_IS_FREE_COFFEE_MODE = "isFreeCoffeeMode";
    @NotNull
    public static final String EXTRA_PLAN = "plan";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_BRAND_ID = "brandId";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_MERCHANT_AMOUNT = "amount";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_MERCHANT_DISCOUNT = "discount";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_MERCHANT_NAME = "merchantName";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_MERCHANT_TRANSACTION_ID = "merchantTransactionId";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_OFFER_SELECTION = "offerSelection";
    @NotNull
    public static final String EXTRA_REDEEM_AND_PAY_VENDOR_ID = "vendorId";
    @NotNull
    public static final String EXTRA_VENDOR_FILTER_AREA_CHOSEN = "area_id";
    @NotNull
    public static final String EXTRA_VENDOR_FILTER_CURRENT_CITY = "city_name";
    @NotNull
    public static final String EXTRA_VENDOR_FILTER_CURRENT_LATITUDE = "currentLocationLatitude";
    @NotNull
    public static final String EXTRA_VENDOR_FILTER_CURRENT_LONGITUDE = "currentLocationLongitude";
    @NotNull
    public static final String EXTRA_VENDOR_FILTER_LOCATION_LIST = "location_list";
    @NotNull
    public static final String EXTRA_VENDOR_ID = "vendorID";
    @NotNull
    public static final String EXTRA_VENDOR_OFFER_MODEL = "vendorModel";
    @NotNull
    public static final String FLUTTER_ONBOARDING_ACTIVITY = "talabat.action.flutter.life.on.boarding";
    @NotNull
    public static final String FLUTTER_ONBOARDING_DETAILS_ACTIVITY = "talabat.action.flutter.life.on.boarding.details";
    @NotNull
    public static final String OPEN_FREE_COFFEE_SUCCESS = "talabat.action.tdine.freeCoffeeSuccessActivity";
    @NotNull
    public static final String OPEN_TALABAT_LIFE_VENDORS_ACTIVITY = "talabat.action.talabat.life.vendors";
    @NotNull
    public static final String OPEN_TALABAT_LIFE_VENDOR_OFFERS_ACTIVITY = "talabat.action.talabat.life.vendors.offers";
    @NotNull
    public static final String OPEN_TALABAT_LIFE_VENDOR_PAYMENT = "talabat.action.talabat.life.vendor.payment";
    @NotNull
    public static final String OPEN_TALABAT_LIFE_VENDOR_PAYMENT_CONFIRMATION = "talabat.action.talabat.life.vendor.payment.conformation";
    @NotNull
    public static final String OPEN_TLIFE_TERMS_AND_CONDITIONS_SCREEN = "talabat.action.talabat.life.termsandconditions";
    @NotNull
    public static final String OPEN_T_LIFE_ON_BOARDING_ACTIVITY = "talabat.action.talabat.life.on.boarding";
    @NotNull
    public static final String OPEN_WALLET_ADD_CARD_ACTIVITY = "talabat.action.Wallet.addcard";
    @NotNull
    public static final String REDEEM_OFFER_SCREEN = "talabat.action.talabat.life.vendor.payment";
    @NotNull
    public static final String SOURCE = "source";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\"J\u000e\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0004J\u0012\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/talabat/talabatnavigation/tLife/TLifeNavigationActions$Companion;", "", "()V", "EXTRA_IS_EXIT_FREE_COFFEE", "", "EXTRA_IS_FREE_COFFEE_MODE", "EXTRA_PLAN", "EXTRA_REDEEM_AND_PAY_BRAND_ID", "EXTRA_REDEEM_AND_PAY_MERCHANT_AMOUNT", "EXTRA_REDEEM_AND_PAY_MERCHANT_DISCOUNT", "EXTRA_REDEEM_AND_PAY_MERCHANT_NAME", "EXTRA_REDEEM_AND_PAY_MERCHANT_TRANSACTION_ID", "EXTRA_REDEEM_AND_PAY_OFFER_SELECTION", "EXTRA_REDEEM_AND_PAY_VENDOR_ID", "EXTRA_VENDOR_FILTER_AREA_CHOSEN", "EXTRA_VENDOR_FILTER_CURRENT_CITY", "EXTRA_VENDOR_FILTER_CURRENT_LATITUDE", "EXTRA_VENDOR_FILTER_CURRENT_LONGITUDE", "EXTRA_VENDOR_FILTER_LOCATION_LIST", "EXTRA_VENDOR_ID", "EXTRA_VENDOR_OFFER_MODEL", "FLUTTER_ONBOARDING_ACTIVITY", "FLUTTER_ONBOARDING_DETAILS_ACTIVITY", "OPEN_FREE_COFFEE_SUCCESS", "OPEN_TALABAT_LIFE_VENDORS_ACTIVITY", "OPEN_TALABAT_LIFE_VENDOR_OFFERS_ACTIVITY", "OPEN_TALABAT_LIFE_VENDOR_PAYMENT", "OPEN_TALABAT_LIFE_VENDOR_PAYMENT_CONFIRMATION", "OPEN_TLIFE_TERMS_AND_CONDITIONS_SCREEN", "OPEN_T_LIFE_ON_BOARDING_ACTIVITY", "OPEN_WALLET_ADD_CARD_ACTIVITY", "REDEEM_OFFER_SCREEN", "SOURCE", "createNavigationModelForRedeemAndPay", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "redeemAndPayData", "Lcom/talabat/talabatnavigation/tLife/RedeemAndPayNavigationData;", "createNavigationToTLifeTermsAndConditions", "createNavigationToWalletAddCard", "source", "navigateToFreeCoffeeSuccess", "", "Lcom/talabat/talabatnavigation/Navigator$Companion;", "activity", "Landroid/app/Activity;", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NavigatorModel createNavigationModelForRedeemAndPay(@NotNull RedeemAndPayNavigationData redeemAndPayNavigationData) {
            Intrinsics.checkNotNullParameter(redeemAndPayNavigationData, "redeemAndPayData");
            Bundle bundle = new Bundle();
            bundle.putString(TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_MERCHANT_NAME, redeemAndPayNavigationData.getMerchantName());
            bundle.putString("merchantTransactionId", redeemAndPayNavigationData.getMerchantTransactionId());
            bundle.putFloat("amount", redeemAndPayNavigationData.getAmount());
            bundle.putFloat("discount", redeemAndPayNavigationData.getDiscount());
            bundle.putInt("brandId", redeemAndPayNavigationData.getBrandId());
            bundle.putString("vendorId", redeemAndPayNavigationData.getVendorId());
            bundle.putInt(TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_OFFER_SELECTION, redeemAndPayNavigationData.getSelectedOfferIndex());
            bundle.putBoolean(TLifeNavigationActions.EXTRA_IS_FREE_COFFEE_MODE, redeemAndPayNavigationData.isCoffeeMode());
            return new NavigatorModel("talabat.action.talabat.life.vendor.payment", bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToTLifeTermsAndConditions() {
            return new NavigatorModel(TLifeNavigationActions.OPEN_TLIFE_TERMS_AND_CONDITIONS_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToWalletAddCard(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            return new NavigatorModel("talabat.action.Wallet.addcard", bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        public final void navigateToFreeCoffeeSuccess(@NotNull Navigator.Companion companion, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(companion, "<this>");
            Intrinsics.checkNotNullParameter(activity, "activity");
            companion.navigate((Context) activity, new NavigatorModel(TLifeNavigationActions.OPEN_FREE_COFFEE_SUCCESS, new Bundle(), (Function1) null, 4, (DefaultConstructorMarker) null));
        }
    }
}
