package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletVerifyQRCodeRequestModel;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.VerifyWalletTransactionDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletSuggestionButtonsDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletThreeDSURLRedirectionState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpButtonDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpResponseScreenState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpSuggestionsAndLimitsDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletVerifyQRCodeDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0002¤\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010}\u001a\u00020~2\u0006\u0010G\u001a\u00020HH&J\b\u0010\u001a\u00020~H&J\t\u0010\u0001\u001a\u00020~H&J\u0013\u0010=\u001a\u00020~2\t\b\u0002\u0010\u0001\u001a\u000200H&J\u0014\u0010\u0001\u001a\u00020~2\t\b\u0002\u0010\u0001\u001a\u000200H&J\t\u0010\u0001\u001a\u00020~H&J$\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H&J\u001b\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H&J\u001b\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H&J\u001b\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0012H&J\u0012\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u0005H&J\u001f\u0010\u0001\u001a\u00020~2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0001\u001a\u00020\u0005H&J\u0012\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u001eH&J\u0013\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u0001H&J,\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H&J\u0012\u0010\u0001\u001a\u00020~2\u0007\u0010\u0001\u001a\u00020\u0012H&J\u0013\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u0001H&J\u0012\u0010 \u0001\u001a\u00020~2\u0007\u0010¡\u0001\u001a\u00020\u0005H&JB\u0010¢\u0001\u001a\u00020~2\u0006\u0010<\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H&R4\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0018\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u0018\u0010\u001a\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u0018\u0010\u001d\u001a\u00020\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u0018\u0010/\u001a\u000200X¦\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00105\u001a\u000200X¦\u000e¢\u0006\f\u001a\u0004\b6\u00102\"\u0004\b7\u00104R \u00108\u001a\b\u0012\u0004\u0012\u0002090$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u0018\u0010<\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R \u0010?\u001a\b\u0012\u0004\u0012\u00020@0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R \u0010C\u001a\b\u0012\u0004\u0012\u00020D0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010&\"\u0004\bF\u0010(R\u0018\u0010G\u001a\u00020HX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010M\u001a\b\u0012\u0004\u0012\u00020N0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010&\"\u0004\bP\u0010(R \u0010Q\u001a\b\u0012\u0004\u0012\u00020R0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010&\"\u0004\bT\u0010(R \u0010U\u001a\b\u0012\u0004\u0012\u00020V0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010&\"\u0004\bX\u0010(R \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010&\"\u0004\b[\u0010(R \u0010\\\u001a\b\u0012\u0004\u0012\u00020]0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010&\"\u0004\b_\u0010(R \u0010`\u001a\b\u0012\u0004\u0012\u00020D0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010&\"\u0004\bb\u0010(R \u0010c\u001a\b\u0012\u0004\u0012\u00020d0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010&\"\u0004\bf\u0010(R \u0010g\u001a\b\u0012\u0004\u0012\u00020h0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010&\"\u0004\bj\u0010(R\u001a\u0010k\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR \u0010p\u001a\b\u0012\u0004\u0012\u00020q0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010&\"\u0004\bs\u0010(R \u0010t\u001a\b\u0012\u0004\u0012\u00020u0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010&\"\u0004\bw\u0010(R\u0018\u0010x\u001a\u00020uX¦\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|¨\u0006¥\u0001"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "amountCashBackMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getAmountCashBackMap", "()Ljava/util/HashMap;", "setAmountCashBackMap", "(Ljava/util/HashMap;)V", "amountToBalanceFromCard", "getAmountToBalanceFromCard", "()F", "setAmountToBalanceFromCard", "(F)V", "isCardAvailable", "", "()Z", "setCardAvailable", "(Z)V", "isCashEnabled", "setCashEnabled", "isWalletEnabled", "setWalletEnabled", "mAmount", "getMAmount", "setMAmount", "selectedPaymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "getSelectedPaymentMethod", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "setSelectedPaymentMethod", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;)V", "shouldEnablePaymentButton", "Landroidx/lifecycle/MutableLiveData;", "getShouldEnablePaymentButton", "()Landroidx/lifecycle/MutableLiveData;", "setShouldEnablePaymentButton", "(Landroidx/lifecycle/MutableLiveData;)V", "showCashMessage", "getShowCashMessage", "setShowCashMessage", "showTopUpMessage", "getShowTopUpMessage", "setShowTopUpMessage", "topUpMaximumAmount", "", "getTopUpMaximumAmount", "()I", "setTopUpMaximumAmount", "(I)V", "topUpMinimumAmount", "getTopUpMinimumAmount", "setTopUpMinimumAmount", "verifyWalletTransactionData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/VerifyWalletTransactionDisplayModel;", "getVerifyWalletTransactionData", "setVerifyWalletTransactionData", "walletBalance", "getWalletBalance", "setWalletBalance", "walletBalanceData", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "getWalletBalanceData", "setWalletBalanceData", "walletDebitData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "getWalletDebitData", "setWalletDebitData", "walletDebitRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "getWalletDebitRequestModel", "()Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "setWalletDebitRequestModel", "(Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;)V", "walletPaymentDisplayViewModeData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel$PaymentOptionViewType;", "getWalletPaymentDisplayViewModeData", "setWalletPaymentDisplayViewModeData", "walletSuggestionButtonsData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletSuggestionButtonsDisplayModel;", "getWalletSuggestionButtonsData", "setWalletSuggestionButtonsData", "walletThreeDSURLRedirectionData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "getWalletThreeDSURLRedirectionData", "setWalletThreeDSURLRedirectionData", "walletThreeDSValidationData", "getWalletThreeDSValidationData", "setWalletThreeDSValidationData", "walletTopUpButtonData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpButtonDisplayModel;", "getWalletTopUpButtonData", "setWalletTopUpButtonData", "walletTopUpData", "getWalletTopUpData", "setWalletTopUpData", "walletTopUpResponseScreenStateData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpResponseScreenState;", "getWalletTopUpResponseScreenStateData", "setWalletTopUpResponseScreenStateData", "walletTopUpSuggestionAndLimitsData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;", "getWalletTopUpSuggestionAndLimitsData", "setWalletTopUpSuggestionAndLimitsData", "walletTransactionId", "getWalletTransactionId", "()Ljava/lang/String;", "setWalletTransactionId", "(Ljava/lang/String;)V", "walletVerifyQRCodeData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletVerifyQRCodeDisplayModel;", "getWalletVerifyQRCodeData", "setWalletVerifyQRCodeData", "walletWidgetConfigData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "getWalletWidgetConfigData", "setWalletWidgetConfigData", "walletWidgetDisplayViewModel", "getWalletWidgetDisplayViewModel", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "setWalletWidgetDisplayViewModel", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;)V", "debitWallet", "", "disAblePaymentButton", "enablePaymentButton", "country", "getWalletTopUpSuggestionsAndLimits", "onIgnoreTopUpVerification", "onNavigateToResponseScreen", "isTransactionSuccessful", "isTopUpFromBottomSheet", "isTopUpFromDialogFragment", "onNavigateToSuccessScreen", "onRedirectToErrorScreen", "onThreeDSURLCheck", "threeDSUrl", "shouldIgnoreVerification", "onTopUpAmountChanged", "topUpAmount", "setFailureMessage", "message", "defaultMessage", "setPaymentMethod", "paymentMethod", "topUpWallet", "walletTopUpRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletTopUpRequestModel;", "updatePaymentMethod", "isChecked", "amount", "isCardSupported", "updateThreeDSVerificationForBottomSheet", "isSuccessful", "verifyQRCode", "walletVerifyQRCodeRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletVerifyQRCodeRequestModel;", "verifyWalletTransaction", "transactionId", "walletPaymentMode", "cardListLoadingStatus", "PaymentOptionViewType", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletPaymentOptionViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<Boolean> shouldEnablePaymentButton = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showCashMessage = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showTopUpMessage = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VerifyWalletTransactionDisplayModel> verifyWalletTransactionData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletBalanceDisplayModel> walletBalanceData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletPaymentDisplayModel> walletDebitData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<PaymentOptionViewType> walletPaymentDisplayViewModeData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletSuggestionButtonsDisplayModel> walletSuggestionButtonsData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletThreeDSURLRedirectionState> walletThreeDSURLRedirectionData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> walletThreeDSValidationData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletTopUpButtonDisplayModel> walletTopUpButtonData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletPaymentDisplayModel> walletTopUpData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletTopUpResponseScreenState> walletTopUpResponseScreenStateData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletTopUpSuggestionsAndLimitsDisplayModel> walletTopUpSuggestionAndLimitsData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletVerifyQRCodeDisplayModel> walletVerifyQRCodeData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletPaymentWidgetDisplayModel> walletWidgetConfigData = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel$PaymentOptionViewType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SINGLE", "WALLETANDCARD", "ONLYCARD", "ONLYWALLET", "ONLYCASH", "CASHWITHDISABLEDWALLET", "WALLETWITHADDCARD", "DISABLEDWALLETONLY", "NONE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum PaymentOptionViewType {
        SINGLE(0),
        WALLETANDCARD(1),
        ONLYCARD(2),
        ONLYWALLET(3),
        ONLYCASH(4),
        CASHWITHDISABLEDWALLET(5),
        WALLETWITHADDCARD(6),
        DISABLEDWALLETONLY(7),
        NONE(8);
        
        private final int value;

        private PaymentOptionViewType(int i11) {
            this.value = i11;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static /* synthetic */ void getWalletBalance$default(WalletPaymentOptionViewModel walletPaymentOptionViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            walletPaymentOptionViewModel.getWalletBalance(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletBalance");
    }

    public static /* synthetic */ void getWalletTopUpSuggestionsAndLimits$default(WalletPaymentOptionViewModel walletPaymentOptionViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            walletPaymentOptionViewModel.getWalletTopUpSuggestionsAndLimits(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletTopUpSuggestionsAndLimits");
    }

    public static /* synthetic */ void setFailureMessage$default(WalletPaymentOptionViewModel walletPaymentOptionViewModel, String str, String str2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            walletPaymentOptionViewModel.setFailureMessage(str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFailureMessage");
    }

    public abstract void debitWallet(@NotNull WalletDebitRequestModel walletDebitRequestModel);

    public abstract void disAblePaymentButton();

    public abstract void enablePaymentButton();

    @NotNull
    public abstract HashMap<String, Float> getAmountCashBackMap();

    public abstract float getAmountToBalanceFromCard();

    public abstract float getMAmount();

    @NotNull
    public abstract PaymentMethod getSelectedPaymentMethod();

    @NotNull
    public final MutableLiveData<Boolean> getShouldEnablePaymentButton() {
        return this.shouldEnablePaymentButton;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowCashMessage() {
        return this.showCashMessage;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowTopUpMessage() {
        return this.showTopUpMessage;
    }

    public abstract int getTopUpMaximumAmount();

    public abstract int getTopUpMinimumAmount();

    @NotNull
    public final MutableLiveData<VerifyWalletTransactionDisplayModel> getVerifyWalletTransactionData() {
        return this.verifyWalletTransactionData;
    }

    public abstract float getWalletBalance();

    public abstract void getWalletBalance(int i11);

    @NotNull
    public final MutableLiveData<WalletBalanceDisplayModel> getWalletBalanceData() {
        return this.walletBalanceData;
    }

    @NotNull
    public final MutableLiveData<WalletPaymentDisplayModel> getWalletDebitData() {
        return this.walletDebitData;
    }

    @NotNull
    public abstract WalletDebitRequestModel getWalletDebitRequestModel();

    @NotNull
    public final MutableLiveData<PaymentOptionViewType> getWalletPaymentDisplayViewModeData() {
        return this.walletPaymentDisplayViewModeData;
    }

    @NotNull
    public final MutableLiveData<WalletSuggestionButtonsDisplayModel> getWalletSuggestionButtonsData() {
        return this.walletSuggestionButtonsData;
    }

    @NotNull
    public final MutableLiveData<WalletThreeDSURLRedirectionState> getWalletThreeDSURLRedirectionData() {
        return this.walletThreeDSURLRedirectionData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getWalletThreeDSValidationData() {
        return this.walletThreeDSValidationData;
    }

    @NotNull
    public final MutableLiveData<WalletTopUpButtonDisplayModel> getWalletTopUpButtonData() {
        return this.walletTopUpButtonData;
    }

    @NotNull
    public final MutableLiveData<WalletPaymentDisplayModel> getWalletTopUpData() {
        return this.walletTopUpData;
    }

    @NotNull
    public final MutableLiveData<WalletTopUpResponseScreenState> getWalletTopUpResponseScreenStateData() {
        return this.walletTopUpResponseScreenStateData;
    }

    @NotNull
    public final MutableLiveData<WalletTopUpSuggestionsAndLimitsDisplayModel> getWalletTopUpSuggestionAndLimitsData() {
        return this.walletTopUpSuggestionAndLimitsData;
    }

    public abstract void getWalletTopUpSuggestionsAndLimits(int i11);

    @Nullable
    public abstract String getWalletTransactionId();

    @NotNull
    public final MutableLiveData<WalletVerifyQRCodeDisplayModel> getWalletVerifyQRCodeData() {
        return this.walletVerifyQRCodeData;
    }

    @NotNull
    public final MutableLiveData<WalletPaymentWidgetDisplayModel> getWalletWidgetConfigData() {
        return this.walletWidgetConfigData;
    }

    @NotNull
    public abstract WalletPaymentWidgetDisplayModel getWalletWidgetDisplayViewModel();

    public abstract boolean isCardAvailable();

    public abstract boolean isCashEnabled();

    public abstract boolean isWalletEnabled();

    public abstract void onIgnoreTopUpVerification();

    public abstract void onNavigateToResponseScreen(boolean z11, boolean z12, boolean z13);

    public abstract void onNavigateToSuccessScreen(boolean z11, boolean z12);

    public abstract void onRedirectToErrorScreen(boolean z11, boolean z12);

    public abstract void onThreeDSURLCheck(@NotNull String str, boolean z11);

    public abstract void onTopUpAmountChanged(@NotNull String str);

    public abstract void setAmountCashBackMap(@NotNull HashMap<String, Float> hashMap);

    public abstract void setAmountToBalanceFromCard(float f11);

    public abstract void setCardAvailable(boolean z11);

    public abstract void setCashEnabled(boolean z11);

    public abstract void setFailureMessage(@Nullable String str, @NotNull String str2);

    public abstract void setMAmount(float f11);

    public abstract void setPaymentMethod(@NotNull PaymentMethod paymentMethod);

    public abstract void setSelectedPaymentMethod(@NotNull PaymentMethod paymentMethod);

    public final void setShouldEnablePaymentButton(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.shouldEnablePaymentButton = mutableLiveData;
    }

    public final void setShowCashMessage(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.showCashMessage = mutableLiveData;
    }

    public final void setShowTopUpMessage(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.showTopUpMessage = mutableLiveData;
    }

    public abstract void setTopUpMaximumAmount(int i11);

    public abstract void setTopUpMinimumAmount(int i11);

    public final void setVerifyWalletTransactionData(@NotNull MutableLiveData<VerifyWalletTransactionDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.verifyWalletTransactionData = mutableLiveData;
    }

    public abstract void setWalletBalance(float f11);

    public final void setWalletBalanceData(@NotNull MutableLiveData<WalletBalanceDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletBalanceData = mutableLiveData;
    }

    public final void setWalletDebitData(@NotNull MutableLiveData<WalletPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletDebitData = mutableLiveData;
    }

    public abstract void setWalletDebitRequestModel(@NotNull WalletDebitRequestModel walletDebitRequestModel);

    public abstract void setWalletEnabled(boolean z11);

    public final void setWalletPaymentDisplayViewModeData(@NotNull MutableLiveData<PaymentOptionViewType> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletPaymentDisplayViewModeData = mutableLiveData;
    }

    public final void setWalletSuggestionButtonsData(@NotNull MutableLiveData<WalletSuggestionButtonsDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletSuggestionButtonsData = mutableLiveData;
    }

    public final void setWalletThreeDSURLRedirectionData(@NotNull MutableLiveData<WalletThreeDSURLRedirectionState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletThreeDSURLRedirectionData = mutableLiveData;
    }

    public final void setWalletThreeDSValidationData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletThreeDSValidationData = mutableLiveData;
    }

    public final void setWalletTopUpButtonData(@NotNull MutableLiveData<WalletTopUpButtonDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTopUpButtonData = mutableLiveData;
    }

    public final void setWalletTopUpData(@NotNull MutableLiveData<WalletPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTopUpData = mutableLiveData;
    }

    public final void setWalletTopUpResponseScreenStateData(@NotNull MutableLiveData<WalletTopUpResponseScreenState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTopUpResponseScreenStateData = mutableLiveData;
    }

    public final void setWalletTopUpSuggestionAndLimitsData(@NotNull MutableLiveData<WalletTopUpSuggestionsAndLimitsDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTopUpSuggestionAndLimitsData = mutableLiveData;
    }

    public abstract void setWalletTransactionId(@Nullable String str);

    public final void setWalletVerifyQRCodeData(@NotNull MutableLiveData<WalletVerifyQRCodeDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletVerifyQRCodeData = mutableLiveData;
    }

    public final void setWalletWidgetConfigData(@NotNull MutableLiveData<WalletPaymentWidgetDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletWidgetConfigData = mutableLiveData;
    }

    public abstract void setWalletWidgetDisplayViewModel(@NotNull WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel);

    public abstract void topUpWallet(@NotNull WalletTopUpRequestModel walletTopUpRequestModel);

    public abstract void updatePaymentMethod(boolean z11, float f11, boolean z12, boolean z13);

    public abstract void updateThreeDSVerificationForBottomSheet(boolean z11);

    public abstract void verifyQRCode(@NotNull WalletVerifyQRCodeRequestModel walletVerifyQRCodeRequestModel);

    public abstract void verifyWalletTransaction(@NotNull String str);

    public abstract void walletPaymentMode(float f11, float f12, @NotNull MutableLiveData<Boolean> mutableLiveData, boolean z11, boolean z12, boolean z13);
}
