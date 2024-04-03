package com.talabat.talabatnavigation.walletSquad;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/walletSquad/WalletNavigatorActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletNavigatorActions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_ORIGIN_BNPL_DASHBOARD_ACCOUNT = "side_menu";
    @NotNull
    public static final String EVENT_ORIGIN_BNPL_DASHBOARD_DEEPLINK = "notifications";
    @NotNull
    public static final String EVENT_ORIGIN_BNPL_DASHBOARD_MANAGE_CARDS = "manage_cards";
    @NotNull
    public static final String EXTRA_BIN_NUMBER = "binNumber";
    @NotNull
    public static final String EXTRA_CARD_4_DIGITS = "card4Digits";
    @NotNull
    public static final String EXTRA_CARD_TYPE = "cardType";
    @NotNull
    public static final String EXTRA_DASHBOARD_TO_DETAILS = "bNPLDashboardToDetailExtras";
    @NotNull
    public static final String EXTRA_DEFAULT_CARD_TO_CARD_LIST_BOTTOM_SHEET = "defaultCard";
    @NotNull
    public static final String EXTRA_DESTINATION = "destination";
    @NotNull
    public static final String EXTRA_DISABLE_OPENING_HOME_ON_BACK_PRESS = "disableOpeningHomeOnBackPress";
    @NotNull
    public static final String EXTRA_EVENT_ORIGIN_BNPL_DASHBOARD = "bnplDashboardEventOrigin";
    @NotNull
    public static final String EXTRA_FROM = "from";
    @NotNull
    public static final String EXTRA_IS_CARD_SUCCESSFULLY_ADDED = "isCardSuccessfullyAdded";
    @NotNull
    public static final String EXTRA_IS_NAVIGATION_FROM_SIDE_MENU = "isNavigationFromSideMenu";
    @NotNull
    public static final String EXTRA_IS_PAYMENT_NAVIGATION_FROM_BOTTOM_SHEET = "isNavigationFromBottomSheet";
    @NotNull
    public static final String EXTRA_IS_SUBSCRIPTION_DEFAULT_CARD_AVAILABLE = "isSubscriptionDefaultCardAvailable";
    @NotNull
    public static final String EXTRA_IS_TOP_UP_FROM_DIALOG_FRAGMENT = "is_to_up_from_dialog_fragment";
    @NotNull
    public static final String EXTRA_ORDER_DETAIL_STATUS = "statusBoolean";
    @NotNull
    public static final String EXTRA_QR_SCANNER_SELECTED_OFFER = "selectedOffer";
    @NotNull
    public static final String EXTRA_REFUND_BOTTOM_SHEET = "WalletTransactionDetailRefundBottomSheet";
    @NotNull
    public static final String EXTRA_SHOULD_HIDE_BACK_ICON = "hideBackIcon";
    @NotNull
    public static final String EXTRA_SHOULD_IGNORE_BOTTOM_SHEET_CARD_LIST_DEFAULT_CARD = "setDefaultCard";
    @NotNull
    public static final String EXTRA_SHOULD_IGNORE_TOP_UP_VERIFICATION = "shouldIgnoreTopUpVerification";
    @NotNull
    public static final String EXTRA_SUBSCRIPTION_MEMBER_ID = "subscriptionMemberId";
    @NotNull
    public static final String EXTRA_SUBSCRIPTION_PLANS = "subscriptionPlans";
    @NotNull
    public static final String EXTRA_THREE_DS_TRANSACTION_ID = "transactionId";
    @NotNull
    public static final String EXTRA_TOKEN_ID = "tokenId";
    @NotNull
    public static final String EXTRA_TOP_SCREEN_TOP_UP_STATUS = "status";
    @NotNull
    public static final String EXTRA_TOP_UP_SCREEN_AMOUNT = "amount";
    @NotNull
    public static final String EXTRA_TOP_UP_SCREEN_ERROR_MESSAGE = "message";
    @NotNull
    public static final String EXTRA_TOP_UP_SCREEN_ERROR_TYPE = "errorType";
    @NotNull
    public static final String EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE = "isCampaignAvailable";
    @NotNull
    public static final String EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT = "cashBack";
    @NotNull
    public static final String EXTRA_UPDATE_WALLET_CARD_LIST = "updateCardList";
    @NotNull
    public static final String EXTRA_VALUE_FAILURE = "failure";
    @NotNull
    public static final String EXTRA_VALUE_SUCCESS = "success";
    @NotNull
    public static final String EXTRA_WALLET_ADD_CARD_ERROR = "add_card_error";
    @NotNull
    public static final String EXTRA_WALLET_ADD_CARD_SOURCE = "source";
    @NotNull
    public static final String EXTRA_WALLET_CARD_LIST = "walletCardList";
    @NotNull
    public static final String EXTRA_WALLET_DASHBOARD_TRANSACTION_ID = "transactionId";
    @NotNull
    public static final String EXTRA_WALLET_DASHBOARD_TRANSACTION_TYPE = "transactionType";
    @NotNull
    public static final String EXTRA_WEB_VIEW_URL = "webViewUrl";
    @NotNull
    public static final String OPEN_BNPL_ORDER_DETAIL = "talabat.action.Wallet.BNPLOrderDetailActivity";
    @NotNull
    public static final String OPEN_FLUTTER_BNPL_DASHBOARD_ACTIVITY = "talabat.action.bnpl.BNPLDashboardFlutterActivity";
    @NotNull
    public static final String OPEN_HELP_CENTER_SCREEN = "talabat.action.GlobalHelpCenterScreen";
    @NotNull
    public static final String OPEN_MIGRATED_CARD_MANAGEMENT_SCREEN = "talabat.action.Wallet.WalletCardManagementActivity";
    @NotNull
    public static final String OPEN_MIGRATED_WALLET_TOP_UP_CARD_LIST_ACTIVITY = "talabat.action.Wallet.walletTopUpCardList";
    @NotNull
    public static final String OPEN_ORDER_DETAIL_SCREEN = "talabat.action.OrderDetailsScreen";
    @NotNull
    public static final String OPEN_SUBSCRIPTION_DETAIL_SCREEN = "talabat.action.Wallet.SubscriptionDetailActivity";
    @NotNull
    public static final String OPEN_SUBSCRIPTION_MANAGEMENT_SCREEN = "talabat.action.Wallet.SubscriptionManagementActivity";
    @NotNull
    public static final String OPEN_TLIFE_SUBSUBCRIPTION_ACTIVITY = "talabat.action.talabat.life.on.boarding";
    @NotNull
    public static final String OPEN_WALLET_ADD_CARD_ACTIVITY = "talabat.action.Wallet.addcard";
    @NotNull
    public static final String OPEN_WALLET_ADD_CARD_WEB_VIEW = "talabat.action.Wallet.CheckoutWebView";
    @NotNull
    public static final String OPEN_WALLET_CARD_MANAGEMENT_ACTIVITY = "talabat.action.Wallet.WalletManageCreditCardsScreen";
    @NotNull
    public static final String OPEN_WALLET_DASHBOARD_ACTIVITY = "talabat.action.Wallet.walletDashboard";
    @NotNull
    public static final String OPEN_WALLET_FLUTTER_ADD_CARD_ACTIVITY = "talabat.action.Wallet.WalletFlutterAddCardActivity";
    @NotNull
    public static final String OPEN_WALLET_MIGRATED_DETAIL_ACTIVITY = "talabat.action.Wallet.WalletTransactionDetailActivity";
    @NotNull
    public static final String OPEN_WALLET_NAVIGATE_TO_WALLET = "talabat.action.Wallet.NavigateToWallet";
    @NotNull
    public static final String OPEN_WALLET_QR_CODE_SCANNER_ACTIVITY = "talabat.action.Wallet.qrCodeScanner";
    @NotNull
    public static final String OPEN_WALLET_SEND_GIFT_SCREEN = "talabat.action.giftVoucherList";
    @NotNull
    public static final String OPEN_WALLET_SUBSCRIPTION_DETAIL_SCREEN = "talabat.action.Wallet.SubscriptionDetailActivity";
    @NotNull
    public static final String OPEN_WALLET_SUBSCRIPTION_PLAN_SCREEN = "talabat.action.Wallet.SubscriptionPlanActivity";
    @NotNull
    public static final String OPEN_WALLET_THREE_DS_SCREEN = "talabat.action.Wallet.walletPaymentThreeDs";
    @NotNull
    public static final String OPEN_WALLET_TOP_UP_CARD_LIST_ACTIVITY = "talabat.action.Wallet.topupCardListScreen";
    @NotNull
    public static final String OPEN_WALLET_TOP_UP_RESPONSE_SCREEN = "talabat.action.Wallet.walletTopUpResponseScreen";
    @NotNull
    public static final String OPEN_WALLET_TOP_UP_SCREEN = "talabat.action.Wallet.walletTopUpScreen";
    @NotNull
    public static final String OPEN_WALLET_TRANSACTION_DETAIL_ACTIVITY = "talabat.action.Wallet.WalletTransactionDetailScreen";
    @NotNull
    public static final String OPEN_WALLET_WEB_VIEW = "talabat.action.Wallet.WalletWebViewActivity";
    @NotNull
    public static final String TRACKER_TOP_UP_FAILURE_SCREEN = "Wallet Topup fail screen";
    @NotNull
    public static final String TRACKER_TOP_UP_SCREEN = "Wallet Topup screen";
    @NotNull
    public static final String TRACKER_TOP_UP_SUCCESS_SCREEN = "Wallet Topup success screen";
    @NotNull
    public static final String TRACKER_WALLET_SCREEN = "wallet";
    @NotNull
    public static final String WALLET_ADD_CARD_ACTIVITY = "talabat.action.Wallet.WalletAddCardActivity";
    @NotNull
    public static final String WALLET_DASHBOARD_SCREEN = "Wallet Dashboard screen";
    @NotNull
    public static final String WALLET_PAYMENT_ERROR_SCREEN_KEY = "error_screen_action";
    @NotNull
    public static final String WALLET_PAYMENT_SUCCESS_SCREEN_KEY = "success_screen_action";
    @NotNull
    public static final String WALLET_THREE_DS_URL_KEY = "threeDsUrl";
    @NotNull
    public static final String WALLET_TOP_UP_CARD_LIST_SCREEN = "wallet top up card list";
    @NotNull
    public static final String WALLET_TOP_UP_RESPONSE_ACTION = "talabat.action.Wallet.topUpResponseScreen";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bO\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020VJ\u000e\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u0004J\u0016\u0010Z\u001a\u00020T2\u0006\u0010[\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020VJ\u0016\u0010]\u001a\u00020T2\u0006\u0010^\u001a\u00020\u00042\u0006\u0010W\u001a\u00020VJ\u0006\u0010_\u001a\u00020TJ\u0006\u0010`\u001a\u00020TJ\u000e\u0010a\u001a\u00020T2\u0006\u0010b\u001a\u00020\u0004J\u0006\u0010c\u001a\u00020TJ\u0006\u0010d\u001a\u00020TJ\u000e\u0010e\u001a\u00020T2\u0006\u0010f\u001a\u00020\u0004J(\u0010g\u001a\u00020T2\u0006\u0010h\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u00042\b\b\u0002\u0010i\u001a\u00020VR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/talabat/talabatnavigation/walletSquad/WalletNavigatorActions$Companion;", "", "()V", "EVENT_ORIGIN_BNPL_DASHBOARD_ACCOUNT", "", "EVENT_ORIGIN_BNPL_DASHBOARD_DEEPLINK", "EVENT_ORIGIN_BNPL_DASHBOARD_MANAGE_CARDS", "EXTRA_BIN_NUMBER", "EXTRA_CARD_4_DIGITS", "EXTRA_CARD_TYPE", "EXTRA_DASHBOARD_TO_DETAILS", "EXTRA_DEFAULT_CARD_TO_CARD_LIST_BOTTOM_SHEET", "EXTRA_DESTINATION", "EXTRA_DISABLE_OPENING_HOME_ON_BACK_PRESS", "EXTRA_EVENT_ORIGIN_BNPL_DASHBOARD", "EXTRA_FROM", "EXTRA_IS_CARD_SUCCESSFULLY_ADDED", "EXTRA_IS_NAVIGATION_FROM_SIDE_MENU", "EXTRA_IS_PAYMENT_NAVIGATION_FROM_BOTTOM_SHEET", "EXTRA_IS_SUBSCRIPTION_DEFAULT_CARD_AVAILABLE", "EXTRA_IS_TOP_UP_FROM_DIALOG_FRAGMENT", "EXTRA_ORDER_DETAIL_STATUS", "EXTRA_QR_SCANNER_SELECTED_OFFER", "EXTRA_REFUND_BOTTOM_SHEET", "EXTRA_SHOULD_HIDE_BACK_ICON", "EXTRA_SHOULD_IGNORE_BOTTOM_SHEET_CARD_LIST_DEFAULT_CARD", "EXTRA_SHOULD_IGNORE_TOP_UP_VERIFICATION", "EXTRA_SUBSCRIPTION_MEMBER_ID", "EXTRA_SUBSCRIPTION_PLANS", "EXTRA_THREE_DS_TRANSACTION_ID", "EXTRA_TOKEN_ID", "EXTRA_TOP_SCREEN_TOP_UP_STATUS", "EXTRA_TOP_UP_SCREEN_AMOUNT", "EXTRA_TOP_UP_SCREEN_ERROR_MESSAGE", "EXTRA_TOP_UP_SCREEN_ERROR_TYPE", "EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE", "EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT", "EXTRA_UPDATE_WALLET_CARD_LIST", "EXTRA_VALUE_FAILURE", "EXTRA_VALUE_SUCCESS", "EXTRA_WALLET_ADD_CARD_ERROR", "EXTRA_WALLET_ADD_CARD_SOURCE", "EXTRA_WALLET_CARD_LIST", "EXTRA_WALLET_DASHBOARD_TRANSACTION_ID", "EXTRA_WALLET_DASHBOARD_TRANSACTION_TYPE", "EXTRA_WEB_VIEW_URL", "OPEN_BNPL_ORDER_DETAIL", "OPEN_FLUTTER_BNPL_DASHBOARD_ACTIVITY", "OPEN_HELP_CENTER_SCREEN", "OPEN_MIGRATED_CARD_MANAGEMENT_SCREEN", "OPEN_MIGRATED_WALLET_TOP_UP_CARD_LIST_ACTIVITY", "OPEN_ORDER_DETAIL_SCREEN", "OPEN_SUBSCRIPTION_DETAIL_SCREEN", "OPEN_SUBSCRIPTION_MANAGEMENT_SCREEN", "OPEN_TLIFE_SUBSUBCRIPTION_ACTIVITY", "OPEN_WALLET_ADD_CARD_ACTIVITY", "OPEN_WALLET_ADD_CARD_WEB_VIEW", "OPEN_WALLET_CARD_MANAGEMENT_ACTIVITY", "OPEN_WALLET_DASHBOARD_ACTIVITY", "OPEN_WALLET_FLUTTER_ADD_CARD_ACTIVITY", "OPEN_WALLET_MIGRATED_DETAIL_ACTIVITY", "OPEN_WALLET_NAVIGATE_TO_WALLET", "OPEN_WALLET_QR_CODE_SCANNER_ACTIVITY", "OPEN_WALLET_SEND_GIFT_SCREEN", "OPEN_WALLET_SUBSCRIPTION_DETAIL_SCREEN", "OPEN_WALLET_SUBSCRIPTION_PLAN_SCREEN", "OPEN_WALLET_THREE_DS_SCREEN", "OPEN_WALLET_TOP_UP_CARD_LIST_ACTIVITY", "OPEN_WALLET_TOP_UP_RESPONSE_SCREEN", "OPEN_WALLET_TOP_UP_SCREEN", "OPEN_WALLET_TRANSACTION_DETAIL_ACTIVITY", "OPEN_WALLET_WEB_VIEW", "TRACKER_TOP_UP_FAILURE_SCREEN", "TRACKER_TOP_UP_SCREEN", "TRACKER_TOP_UP_SUCCESS_SCREEN", "TRACKER_WALLET_SCREEN", "WALLET_ADD_CARD_ACTIVITY", "WALLET_DASHBOARD_SCREEN", "WALLET_PAYMENT_ERROR_SCREEN_KEY", "WALLET_PAYMENT_SUCCESS_SCREEN_KEY", "WALLET_THREE_DS_URL_KEY", "WALLET_TOP_UP_CARD_LIST_SCREEN", "WALLET_TOP_UP_RESPONSE_ACTION", "createBNPLDashboardDeepLinkNavigation", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "isUserLoggedIn", "", "isBnplDashboardFlutterScreenEnabled", "createNavigationToAction", "destination", "createNavigationToAddCardFromSource", "source", "isWalletAddCardFlutterScreenEnabled", "createNavigationToBNPLDashboard", "eventOrigin", "createNavigationToHelpCenter", "createNavigationToHomeScreen", "createNavigationToScreen", "action", "createNavigationToWalletAddCard", "createNavigationToWalletDashBoard", "createNavigationToWalletWebView", "webUrl", "createSubscriptionDetailNavigation", "subscriptionMemberId", "isCardSuccessfullyAdded", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavigatorModel createSubscriptionDetailNavigation$default(Companion companion, String str, String str2, String str3, boolean z11, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            return companion.createSubscriptionDetailNavigation(str, str2, str3, z11);
        }

        @NotNull
        public final NavigatorModel createBNPLDashboardDeepLinkNavigation(boolean z11, boolean z12) {
            if (z11) {
                return createNavigationToBNPLDashboard("notifications", z12);
            }
            return createNavigationToHomeScreen();
        }

        @NotNull
        public final NavigatorModel createNavigationToAction(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "destination");
            Bundle bundle = new Bundle();
            bundle.putBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED, true);
            return new NavigatorModel(str, bundle, WalletNavigatorActions$Companion$createNavigationToAction$2.INSTANCE);
        }

        @NotNull
        public final NavigatorModel createNavigationToAddCardFromSource(@NotNull String str, boolean z11) {
            String str2;
            Intrinsics.checkNotNullParameter(str, "source");
            if (z11) {
                str2 = WalletNavigatorActions.OPEN_WALLET_FLUTTER_ADD_CARD_ACTIVITY;
            } else {
                str2 = WalletNavigatorActions.WALLET_ADD_CARD_ACTIVITY;
            }
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            return new NavigatorModel(str2, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToBNPLDashboard(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "eventOrigin");
            Bundle bundle = new Bundle();
            bundle.putString(WalletNavigatorActions.EXTRA_EVENT_ORIGIN_BNPL_DASHBOARD, str);
            return new NavigatorModel(WalletNavigatorActions.OPEN_FLUTTER_BNPL_DASHBOARD_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToHelpCenter() {
            return new NavigatorModel(WalletNavigatorActions.OPEN_HELP_CENTER_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToHomeScreen() {
            return new NavigatorModel("talabat.action.homeScreen", (Bundle) null, WalletNavigatorActions$Companion$createNavigationToHomeScreen$1.INSTANCE, 2, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToScreen(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            return new NavigatorModel(str, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToWalletAddCard() {
            Bundle bundle = new Bundle();
            bundle.putString("source", "talabat.action.homeScreen");
            return new NavigatorModel("talabat.action.Wallet.addcard", bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToWalletDashBoard() {
            return new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_DASHBOARD_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigationToWalletWebView(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "webUrl");
            Bundle bundle = new Bundle();
            bundle.putString(WalletNavigatorActions.EXTRA_WEB_VIEW_URL, str);
            return new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_WEB_VIEW, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createSubscriptionDetailNavigation(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
            Intrinsics.checkNotNullParameter(str2, "source");
            Intrinsics.checkNotNullParameter(str3, "destination");
            Bundle bundle = new Bundle();
            bundle.putString("source", str2);
            bundle.putString("subscriptionMemberId", str);
            bundle.putBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED, z11);
            return new NavigatorModel(str3, bundle, WalletNavigatorActions$Companion$createSubscriptionDetailNavigation$2.INSTANCE);
        }
    }
}
