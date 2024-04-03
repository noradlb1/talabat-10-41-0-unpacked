package com.talabat.core.featureflag.domain.flags.pay;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001b\u001a\u00020\u0004J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001d\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/pay/PayFeatureFlagConstants;", "", "()V", "ADD_CARD", "", "ALL_WALLET_DEFAULT_FEATURES", "ANDROID_PLATFORM", "CARD_HOLDER_NAME", "CARD_MANAGEMENT", "CASHBACK", "DELETE_CARD", "ENABLED_STRING", "EXPIRING_CREDIT", "PayFlags", "Lkotlin/Function0;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getPayFlags", "()Lkotlin/jvm/functions/Function0;", "RIDER_TIP_ENABLED", "SEND_GIFT", "SET_DEFAULT_CARD", "SUBSCRIPTION", "TOP_UP", "WALLET_PROJECT", "WALLET_TIP_RIDER_ON_ORDER_CONFIRMATION_SCREEN", "getAllCountriesFlag", "feature", "getRiderTipFlags", "getWalletFeatureFwfKey", "countryId", "", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "PayFeatureFlagsWithoutCountry", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayFeatureFlagConstants {
    @NotNull
    public static final String ADD_CARD = "addcard-";
    @NotNull
    public static final String ALL_WALLET_DEFAULT_FEATURES = "";
    @NotNull
    public static final String ANDROID_PLATFORM = "-android-";
    @NotNull
    public static final String CARD_HOLDER_NAME = "addcardholdername-";
    @NotNull
    public static final String CARD_MANAGEMENT = "cardmanagement-";
    @NotNull
    public static final String CASHBACK = "cashback-";
    @NotNull
    public static final String DELETE_CARD = "deletecard-";
    @NotNull
    public static final String ENABLED_STRING = "enabled-";
    @NotNull
    public static final String EXPIRING_CREDIT = "expiringcredit-";
    @NotNull
    public static final PayFeatureFlagConstants INSTANCE = new PayFeatureFlagConstants();
    @NotNull
    private static final Function0<List<FWFKey>> PayFlags = PayFeatureFlagConstants$PayFlags$1.INSTANCE;
    @NotNull
    public static final String RIDER_TIP_ENABLED = "ridertip-andy-enabled-";
    @NotNull
    public static final String SEND_GIFT = "sendgift-";
    @NotNull
    public static final String SET_DEFAULT_CARD = "setdefaultcard-";
    @NotNull
    public static final String SUBSCRIPTION = "subscription";
    @NotNull
    public static final String TOP_UP = "topup-";
    @NotNull
    public static final String WALLET_PROJECT = "wallet";
    @NotNull
    public static final String WALLET_TIP_RIDER_ON_ORDER_CONFIRMATION_SCREEN = "ridertip-onorderconfirmation-";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/pay/PayFeatureFlagConstants$PayFeatureFlagsWithoutCountry;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "WALLET_OMANET_FORCE_CVV", "WALLET_ENABLE_KNET_STATUS_CHECK", "WALLET_ENABLE_QPAY_PAYMENT", "WALLET_BALANCE_API_ENABLED_ON_CHECKOUT_SCREEN", "WALLET_CHECKOUT_OUT_TIME_OUT_ENABLED", "WALLET_BENEFIT_BIN_DETAIL", "WALLET_PROXY_CVV_ENABLED", "WALLET_BNPL_ENABLED", "WALLET_BNPL_FAKE_DOOR_TEST", "WALLET_BNPL_V1_ENABLED", "WALLET_BNPL_CHECKOUT_BIN_VOUCHER", "PAY_BNPL_DASHBOARD_ENABLED", "PAY_QPAY_DEFLECTION_ENABLED", "PAY_BNPL_AD_HOC_ENABLED", "PAY_BNPL_TALABAT_TRACKER_ENABLED", "PAY_QPAY_ADD_CARD_DEFLECTION_ENABLED", "PAY_QPAY_SAVED_CARD_DEFLECTION_ENABLED", "PAY_QPAY_WALLET_DEFLECTION_ENABLED", "PAY_ANDROID_FLUTTER_WALLET_ADD_CARD_ENABLED", "PAY_ANDROID_FLUTTER_BNPL_DASHBOARD_ENABLED", "PAY_ANDROID_FLUTTER_BNPL_CHECKOUT_ENABLED", "PAY_QPAY_FALLBACK_ENABLED", "DESIGN_SYSTEM_CHIPS_RIDER_TIP", "PAYMENT_REPO_REAL_CARD_TOKENS", "PAYMENT_REPO_REAL_PUBLIC_KEY", "WALLET_DASHBOARD_ONBOARDING_ENABLED", "SHOULD_SHOW_WALLET_TRANSACTION_DETAILS_IN_FLUTTER", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum PayFeatureFlagsWithoutCountry implements FWFKey {
        WALLET_OMANET_FORCE_CVV("wallet-android-omannet-forcecvv", (int) null, 2, (FWFProjectName) null),
        WALLET_ENABLE_KNET_STATUS_CHECK("wallet-android-knetstatuscheck-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_ENABLE_QPAY_PAYMENT("pay-android-qpay-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_BALANCE_API_ENABLED_ON_CHECKOUT_SCREEN("wallet-android-checkout-wallet-balance-api", (int) null, 2, (FWFProjectName) null),
        WALLET_CHECKOUT_OUT_TIME_OUT_ENABLED("wallet-android-checkout-api-timeout-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_BENEFIT_BIN_DETAIL("wallet-android-benefit-bin-check-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_PROXY_CVV_ENABLED("wallet-android-send-cvv-to-proxy-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_BNPL_ENABLED("wallet-android-bnpl-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_BNPL_FAKE_DOOR_TEST("wallet-android-bnpl-fake_door_test_enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_BNPL_V1_ENABLED("wallet-android-bnpl-v1-type2-enabled", (int) null, 2, (FWFProjectName) null),
        WALLET_BNPL_CHECKOUT_BIN_VOUCHER("wallet-android-bnpl-checkout-bin-voucher-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_BNPL_DASHBOARD_ENABLED("pay-android-bnpl-sidemenu-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_QPAY_DEFLECTION_ENABLED("pay-android-qpay-deflection-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_BNPL_AD_HOC_ENABLED("pay-android-bnpl-adhoc-payment-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_BNPL_TALABAT_TRACKER_ENABLED("pay-android-bnpl-talabat-tracker-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_QPAY_ADD_CARD_DEFLECTION_ENABLED("pay-android-qpay-add-card-deflection-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_QPAY_SAVED_CARD_DEFLECTION_ENABLED("pay-android-qpay-saved-card-deflection-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_QPAY_WALLET_DEFLECTION_ENABLED("pay-android-qpay-wallet-deflection-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_ANDROID_FLUTTER_WALLET_ADD_CARD_ENABLED("pay-android-flutter-wallet-add-card-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_ANDROID_FLUTTER_BNPL_DASHBOARD_ENABLED("pay-android-flutter-bnpl-dashboard-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_ANDROID_FLUTTER_BNPL_CHECKOUT_ENABLED("pay-android-flutter-bnpl-checkout-enabled", (int) null, 2, (FWFProjectName) null),
        PAY_QPAY_FALLBACK_ENABLED("pay-android-qpay-fallback-enabled", (int) null, 2, (FWFProjectName) null),
        DESIGN_SYSTEM_CHIPS_RIDER_TIP("design-system-chips-rider-tip", (int) null, 2, (FWFProjectName) null),
        PAYMENT_REPO_REAL_CARD_TOKENS("payment_repo_real_card_tokens", (int) null, 2, (FWFProjectName) null),
        PAYMENT_REPO_REAL_PUBLIC_KEY("payment_repo_real_public_key", (int) null, 2, (FWFProjectName) null),
        WALLET_DASHBOARD_ONBOARDING_ENABLED("wallet-android-dashboard-onboarding-enabled", (int) null, 2, (FWFProjectName) null),
        SHOULD_SHOW_WALLET_TRANSACTION_DETAILS_IN_FLUTTER("ff_ecosystems_wallet_dashboard_trans_details_flutter", (int) null, 2, (FWFProjectName) null);
        
        @NotNull
        private final FWFProjectName projectName;
        @NotNull
        private final String value;

        private PayFeatureFlagsWithoutCountry(String str, FWFProjectName fWFProjectName) {
            this.value = str;
            this.projectName = fWFProjectName;
        }

        @NotNull
        public FWFProjectName getProjectName() {
            return this.projectName;
        }

        @NotNull
        public String getValue() {
            return this.value;
        }
    }

    private PayFeatureFlagConstants() {
    }

    @NotNull
    public final List<FWFKey> getAllCountriesFlag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "feature");
        ArrayList arrayList = new ArrayList();
        for (FunWithFlagFeatureCountryKey id2 : FunWithFlagFeatureCountryKey.values()) {
            arrayList.add(INSTANCE.getWalletFeatureFwfKey(Integer.valueOf(id2.getId()), str));
        }
        return arrayList;
    }

    @NotNull
    public final Function0<List<FWFKey>> getPayFlags() {
        return PayFlags;
    }

    @NotNull
    public final List<FWFKey> getRiderTipFlags() {
        FunWithFlagFeatureCountryKey[] values = FunWithFlagFeatureCountryKey.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (FunWithFlagFeatureCountryKey fwfKey : values) {
            arrayList.add(new FWFKeyObject(RIDER_TIP_ENABLED + fwfKey.getFwfKey(), (FWFProjectName) null, 2, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    @NotNull
    public final FWFKey getWalletFeatureFwfKey(@Nullable Integer num, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "feature");
        String countryKey = FunWithFlagFeatureCountryKey.Companion.getCountryKey(num);
        return new FWFKeyObject("wallet-android-" + str + ENABLED_STRING + countryKey, (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    }
}
