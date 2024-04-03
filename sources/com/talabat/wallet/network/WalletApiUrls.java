package com.talabat.wallet.network;

import com.talabat.helpers.BASEURLS;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/network/WalletApiUrls;", "", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletApiUrls {
    private static final String BASE_URL_ADD_CARD;
    private static final String BASE_URL_CASH_BACK;
    private static final String BASE_URL_FOR_CREDIT_CARD;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_ADD_CARD_URL;
    private static final String WALLET_BASE_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CALCULATE_CASH_BACK_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CASHBACK_CAMPAIGN_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CREDIT_BALANCE_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CREDIT_GET_ALL_CARDS_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_CREDIT_TRANSACTION_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_DELETE_CREDIT_CARD_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_SET_DEFAULT_CARD_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_TOP_UP_SUGGESTION_URL;
    /* access modifiers changed from: private */
    @NotNull
    public static String WALLET_TOP_UP_URL;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b+\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001a\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\fR\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\f¨\u0006/"}, d2 = {"Lcom/talabat/wallet/network/WalletApiUrls$Companion;", "", "()V", "BASE_URL_ADD_CARD", "", "kotlin.jvm.PlatformType", "BASE_URL_CASH_BACK", "BASE_URL_FOR_CREDIT_CARD", "WALLET_ADD_CARD_URL", "getWALLET_ADD_CARD_URL", "()Ljava/lang/String;", "setWALLET_ADD_CARD_URL", "(Ljava/lang/String;)V", "WALLET_BASE_URL", "WALLET_CALCULATE_CASH_BACK_URL", "getWALLET_CALCULATE_CASH_BACK_URL", "setWALLET_CALCULATE_CASH_BACK_URL", "WALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD", "getWALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD", "setWALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD", "WALLET_CASHBACK_CAMPAIGN_URL", "getWALLET_CASHBACK_CAMPAIGN_URL", "setWALLET_CASHBACK_CAMPAIGN_URL", "WALLET_CREDIT_BALANCE_URL", "getWALLET_CREDIT_BALANCE_URL", "setWALLET_CREDIT_BALANCE_URL", "WALLET_CREDIT_GET_ALL_CARDS_URL", "getWALLET_CREDIT_GET_ALL_CARDS_URL", "setWALLET_CREDIT_GET_ALL_CARDS_URL", "WALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL", "getWALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL", "setWALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL", "WALLET_CREDIT_TRANSACTION_URL", "getWALLET_CREDIT_TRANSACTION_URL", "setWALLET_CREDIT_TRANSACTION_URL", "WALLET_DELETE_CREDIT_CARD_URL", "getWALLET_DELETE_CREDIT_CARD_URL", "setWALLET_DELETE_CREDIT_CARD_URL", "WALLET_SET_DEFAULT_CARD_URL", "getWALLET_SET_DEFAULT_CARD_URL", "setWALLET_SET_DEFAULT_CARD_URL", "WALLET_TOP_UP_SUGGESTION_URL", "getWALLET_TOP_UP_SUGGESTION_URL", "setWALLET_TOP_UP_SUGGESTION_URL", "WALLET_TOP_UP_URL", "getWALLET_TOP_UP_URL", "setWALLET_TOP_UP_URL", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getWALLET_ADD_CARD_URL() {
            return WalletApiUrls.WALLET_ADD_CARD_URL;
        }

        @NotNull
        public final String getWALLET_CALCULATE_CASH_BACK_URL() {
            return WalletApiUrls.WALLET_CALCULATE_CASH_BACK_URL;
        }

        @NotNull
        public final String getWALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD() {
            return WalletApiUrls.WALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD;
        }

        @NotNull
        public final String getWALLET_CASHBACK_CAMPAIGN_URL() {
            return WalletApiUrls.WALLET_CASHBACK_CAMPAIGN_URL;
        }

        @NotNull
        public final String getWALLET_CREDIT_BALANCE_URL() {
            return WalletApiUrls.WALLET_CREDIT_BALANCE_URL;
        }

        @NotNull
        public final String getWALLET_CREDIT_GET_ALL_CARDS_URL() {
            return WalletApiUrls.WALLET_CREDIT_GET_ALL_CARDS_URL;
        }

        @NotNull
        public final String getWALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL() {
            return WalletApiUrls.WALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL;
        }

        @NotNull
        public final String getWALLET_CREDIT_TRANSACTION_URL() {
            return WalletApiUrls.WALLET_CREDIT_TRANSACTION_URL;
        }

        @NotNull
        public final String getWALLET_DELETE_CREDIT_CARD_URL() {
            return WalletApiUrls.WALLET_DELETE_CREDIT_CARD_URL;
        }

        @NotNull
        public final String getWALLET_SET_DEFAULT_CARD_URL() {
            return WalletApiUrls.WALLET_SET_DEFAULT_CARD_URL;
        }

        @NotNull
        public final String getWALLET_TOP_UP_SUGGESTION_URL() {
            return WalletApiUrls.WALLET_TOP_UP_SUGGESTION_URL;
        }

        @NotNull
        public final String getWALLET_TOP_UP_URL() {
            return WalletApiUrls.WALLET_TOP_UP_URL;
        }

        public final void setWALLET_ADD_CARD_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_ADD_CARD_URL = str;
        }

        public final void setWALLET_CALCULATE_CASH_BACK_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CALCULATE_CASH_BACK_URL = str;
        }

        public final void setWALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD = str;
        }

        public final void setWALLET_CASHBACK_CAMPAIGN_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CASHBACK_CAMPAIGN_URL = str;
        }

        public final void setWALLET_CREDIT_BALANCE_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CREDIT_BALANCE_URL = str;
        }

        public final void setWALLET_CREDIT_GET_ALL_CARDS_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CREDIT_GET_ALL_CARDS_URL = str;
        }

        public final void setWALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL = str;
        }

        public final void setWALLET_CREDIT_TRANSACTION_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_CREDIT_TRANSACTION_URL = str;
        }

        public final void setWALLET_DELETE_CREDIT_CARD_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_DELETE_CREDIT_CARD_URL = str;
        }

        public final void setWALLET_SET_DEFAULT_CARD_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_SET_DEFAULT_CARD_URL = str;
        }

        public final void setWALLET_TOP_UP_SUGGESTION_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_TOP_UP_SUGGESTION_URL = str;
        }

        public final void setWALLET_TOP_UP_URL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletApiUrls.WALLET_TOP_UP_URL = str;
        }
    }

    static {
        String buildRootUrlForWalletSquad = BASEURLS.buildRootUrlForWalletSquad("release");
        WALLET_BASE_URL = buildRootUrlForWalletSquad;
        String baseUrlForCardManagement = BASEURLS.getBaseUrlForCardManagement("release");
        BASE_URL_FOR_CREDIT_CARD = baseUrlForCardManagement;
        String buildSf = BASEURLS.buildSf("release");
        BASE_URL_ADD_CARD = buildSf;
        String buildBaseUrlForCashBack = BASEURLS.buildBaseUrlForCashBack("release");
        BASE_URL_CASH_BACK = buildBaseUrlForCashBack;
        WALLET_CREDIT_BALANCE_URL = buildRootUrlForWalletSquad + "api/v1/wallet/balance/{countryCode}";
        WALLET_CREDIT_TRANSACTION_URL = buildRootUrlForWalletSquad + "api/v2/wallet/transactionlist/{countryCode}/{skip}/{numberPerPage}?culture={selectedLanguage}";
        WALLET_CREDIT_TRANSACTION_LIST_DETAIL_URL = buildRootUrlForWalletSquad + "api/v2/wallet/transactionDetails/{transactionType}/{transactionId}";
        WALLET_TOP_UP_SUGGESTION_URL = buildRootUrlForWalletSquad + "api/v1/wallet/topupSuggestions/{countryCode}";
        WALLET_TOP_UP_URL = buildRootUrlForWalletSquad + "api/v1/wallet/topUp";
        WALLET_CALCULATE_CASH_BACK_URL = buildBaseUrlForCashBack + "api/Cashback/CalculateEstimatedCashback";
        WALLET_CASHBACK_CAMPAIGN_URL = buildBaseUrlForCashBack + "api/Cashback/campaigns/{countryCode}/{eventId}";
        WALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD = buildBaseUrlForCashBack + "api/Cashback/campaignOffer/{countryId}/{binNumber}";
        WALLET_CREDIT_GET_ALL_CARDS_URL = baseUrlForCardManagement + TalabatCommonUrlConstantsKt.WALLET_CARD_LIST_URL;
        WALLET_DELETE_CREDIT_CARD_URL = baseUrlForCardManagement + "v2/customer/delcard";
        WALLET_SET_DEFAULT_CARD_URL = baseUrlForCardManagement + "v1/customer/setcard";
        WALLET_ADD_CARD_URL = buildSf + "checkoutapi/v1/card/add";
    }
}
