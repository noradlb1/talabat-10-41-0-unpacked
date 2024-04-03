package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.walletBalance.GetWalletBalanceUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetDebitWalletUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetTopUpWalletUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetVerifyWalletQRCodeUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetVerifyWalletTransactionUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetWalletTopUpSuggestionAmountUseCase;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletVerifyQRCodeRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentOptionViewConfigUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentWidgetUpdateUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.WalletPaymentWidgetDisplayModelParam;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.VerifyWalletTransactionDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletSuggestionButtonsDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletThreeDSURLRedirectionState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpAmountSuggestionDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpButtonDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpCtaState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpResponseScreenState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpSuggestionsAndLimitsDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletVerifyQRCodeDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.logger.LogManager;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010P\u001a\u00020Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0002J\u0010\u0010U\u001a\u00020Q2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010V\u001a\u00020QH\u0016J\b\u0010W\u001a\u00020QH\u0016J\u0010\u0010=\u001a\u00020Q2\u0006\u0010X\u001a\u000204H\u0016J\u0010\u0010Y\u001a\u00020Q2\u0006\u0010X\u001a\u000204H\u0016J\u0010\u0010Z\u001a\u00020Q2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010]\u001a\u00020Q2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020Q2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020Q2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010j\u001a\u00020Q2\u0006\u0010k\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020QH\u0016J \u0010n\u001a\u00020Q2\u0006\u0010o\u001a\u00020\"2\u0006\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020\"H\u0016J\u0018\u0010r\u001a\u00020Q2\u0006\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020\"H\u0016J\u0018\u0010s\u001a\u00020Q2\u0006\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020\"H\u0016J\u0018\u0010t\u001a\u00020Q2\u0006\u0010u\u001a\u00020\u00152\u0006\u0010v\u001a\u00020\"H\u0016J\u0010\u0010w\u001a\u00020Q2\u0006\u0010x\u001a\u00020\u0015H\u0016J\u001a\u0010y\u001a\u00020Q2\b\u0010z\u001a\u0004\u0018\u00010\u00152\u0006\u0010{\u001a\u00020\u0015H\u0016J\u0010\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020.H\u0016J\u0011\u0010~\u001a\u00020Q2\u0007\u0010\u001a\u00030\u0001H\u0016J,\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\"H\u0016J\u0012\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\"H\u0016J\u001a\u0010\u0001\u001a\u00020Q2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00020Q2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016JC\u0010\u0001\u001a\u00020Q2\u0006\u0010<\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u00162\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\"H\u0016R6\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010(\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010*\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006\u0001"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModelImpl;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "walletBalanceUseCase", "Lcom/talabat/talabatcommon/feature/walletBalance/GetWalletBalanceUseCase;", "walletPaymentOptionViewConfigUseCase", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentOptionViewConfigUseCase;", "walletPaymentWidgetUpdateUseCase", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentWidgetUpdateUseCase;", "topUpWalletUseCase", "Lcom/talabat/talabatcommon/feature/walletPayment/GetTopUpWalletUseCase;", "verifyWalletTransactionUseCase", "Lcom/talabat/talabatcommon/feature/walletPayment/GetVerifyWalletTransactionUseCase;", "debitWalletUseCase", "Lcom/talabat/talabatcommon/feature/walletPayment/GetDebitWalletUseCase;", "verifyQRCodeUseCase", "Lcom/talabat/talabatcommon/feature/walletPayment/GetVerifyWalletQRCodeUseCase;", "walletTopUpSuggestionsAndLimitsUseCase", "Lcom/talabat/talabatcommon/feature/walletPayment/GetWalletTopUpSuggestionAmountUseCase;", "(Lcom/talabat/talabatcommon/feature/walletBalance/GetWalletBalanceUseCase;Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentOptionViewConfigUseCase;Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentWidgetUpdateUseCase;Lcom/talabat/talabatcommon/feature/walletPayment/GetTopUpWalletUseCase;Lcom/talabat/talabatcommon/feature/walletPayment/GetVerifyWalletTransactionUseCase;Lcom/talabat/talabatcommon/feature/walletPayment/GetDebitWalletUseCase;Lcom/talabat/talabatcommon/feature/walletPayment/GetVerifyWalletQRCodeUseCase;Lcom/talabat/talabatcommon/feature/walletPayment/GetWalletTopUpSuggestionAmountUseCase;)V", "amountCashBackMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getAmountCashBackMap", "()Ljava/util/HashMap;", "setAmountCashBackMap", "(Ljava/util/HashMap;)V", "amountToBalanceFromCard", "getAmountToBalanceFromCard", "()F", "setAmountToBalanceFromCard", "(F)V", "isCardAvailable", "", "()Z", "setCardAvailable", "(Z)V", "isCashEnabled", "setCashEnabled", "isWalletEnabled", "setWalletEnabled", "mAmount", "getMAmount", "setMAmount", "selectedPaymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "getSelectedPaymentMethod", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "setSelectedPaymentMethod", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;)V", "topUpMaximumAmount", "", "getTopUpMaximumAmount", "()I", "setTopUpMaximumAmount", "(I)V", "topUpMinimumAmount", "getTopUpMinimumAmount", "setTopUpMinimumAmount", "walletBalance", "getWalletBalance", "setWalletBalance", "walletDebitRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "getWalletDebitRequestModel", "()Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "setWalletDebitRequestModel", "(Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;)V", "walletTransactionId", "getWalletTransactionId", "()Ljava/lang/String;", "setWalletTransactionId", "(Ljava/lang/String;)V", "walletWidgetDisplayViewModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "getWalletWidgetDisplayViewModel", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "setWalletWidgetDisplayViewModel", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;)V", "addAmountAndCashBackToMap", "", "list", "", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpAmountSuggestionDisplayModel;", "debitWallet", "disAblePaymentButton", "enablePaymentButton", "country", "getWalletTopUpSuggestionsAndLimits", "handleDebitWalletSuccess", "walletPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "handleVerifyQRCodeServiceSuccess", "walletVerifyQRCodeDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletVerifyQRCodeDisplayModel;", "handleVerifyWalletTransactionServiceSuccess", "verifyWalletTransactionDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/VerifyWalletTransactionDisplayModel;", "handleWalletBalanceServiceSuccess", "walletBalanceDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "handleWalletPaymentServiceSuccess", "handleWalletTopUpSuggestionsAndLimitsFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "handleWalletTopUpSuggestionsAndLimitsSuccess", "walletTopUpSuggestionsAndLimitsDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;", "onIgnoreTopUpVerification", "onNavigateToResponseScreen", "isTransactionSuccessful", "isTopUpFromBottomSheet", "isTopUpFromDialogFragment", "onNavigateToSuccessScreen", "onRedirectToErrorScreen", "onThreeDSURLCheck", "threeDSUrl", "shouldIgnoreVerification", "onTopUpAmountChanged", "topUpAmount", "setFailureMessage", "message", "defaultMessage", "setPaymentMethod", "paymentMethod", "topUpWallet", "walletTopUpRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletTopUpRequestModel;", "updatePaymentMethod", "isChecked", "amount", "isCardSupported", "updateThreeDSVerificationForBottomSheet", "isSuccessful", "updateWalletBalance", "balance", "(Ljava/lang/Float;)V", "verifyQRCode", "walletVerifyQRCodeRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletVerifyQRCodeRequestModel;", "verifyWalletTransaction", "transactionId", "walletPaymentMode", "cardListLoadingStatus", "Landroidx/lifecycle/MutableLiveData;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentOptionViewModelImpl extends WalletPaymentOptionViewModel {
    @NotNull
    private HashMap<String, Float> amountCashBackMap = new HashMap<>();
    private float amountToBalanceFromCard;
    @NotNull
    private final GetDebitWalletUseCase debitWalletUseCase;
    private boolean isCardAvailable;
    private boolean isCashEnabled;
    private boolean isWalletEnabled = true;
    private float mAmount;
    @NotNull
    private PaymentMethod selectedPaymentMethod = PaymentMethod.NONE;
    private int topUpMaximumAmount = Integer.MAX_VALUE;
    private int topUpMinimumAmount;
    @NotNull
    private final GetTopUpWalletUseCase topUpWalletUseCase;
    @NotNull
    private final GetVerifyWalletQRCodeUseCase verifyQRCodeUseCase;
    @NotNull
    private final GetVerifyWalletTransactionUseCase verifyWalletTransactionUseCase;
    private float walletBalance;
    @NotNull
    private final GetWalletBalanceUseCase walletBalanceUseCase;
    @NotNull
    private WalletDebitRequestModel walletDebitRequestModel = new WalletDebitRequestModel(0.0f, (Integer) null, 0, 0, 0, (String) null, (String) null, 0, (String) null, 0, (String) null, 2047, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletPaymentOptionViewConfigUseCase walletPaymentOptionViewConfigUseCase;
    @NotNull
    private final GetWalletPaymentWidgetUpdateUseCase walletPaymentWidgetUpdateUseCase;
    @NotNull
    private final GetWalletTopUpSuggestionAmountUseCase walletTopUpSuggestionsAndLimitsUseCase;
    @Nullable
    private String walletTransactionId;
    @NotNull
    private WalletPaymentWidgetDisplayModel walletWidgetDisplayViewModel = new WalletPaymentWidgetDisplayModel();

    public WalletPaymentOptionViewModelImpl(@NotNull GetWalletBalanceUseCase getWalletBalanceUseCase, @NotNull GetWalletPaymentOptionViewConfigUseCase getWalletPaymentOptionViewConfigUseCase, @NotNull GetWalletPaymentWidgetUpdateUseCase getWalletPaymentWidgetUpdateUseCase, @NotNull GetTopUpWalletUseCase getTopUpWalletUseCase, @NotNull GetVerifyWalletTransactionUseCase getVerifyWalletTransactionUseCase, @NotNull GetDebitWalletUseCase getDebitWalletUseCase, @NotNull GetVerifyWalletQRCodeUseCase getVerifyWalletQRCodeUseCase, @NotNull GetWalletTopUpSuggestionAmountUseCase getWalletTopUpSuggestionAmountUseCase) {
        GetWalletBalanceUseCase getWalletBalanceUseCase2 = getWalletBalanceUseCase;
        GetWalletPaymentOptionViewConfigUseCase getWalletPaymentOptionViewConfigUseCase2 = getWalletPaymentOptionViewConfigUseCase;
        GetWalletPaymentWidgetUpdateUseCase getWalletPaymentWidgetUpdateUseCase2 = getWalletPaymentWidgetUpdateUseCase;
        GetTopUpWalletUseCase getTopUpWalletUseCase2 = getTopUpWalletUseCase;
        GetVerifyWalletTransactionUseCase getVerifyWalletTransactionUseCase2 = getVerifyWalletTransactionUseCase;
        GetDebitWalletUseCase getDebitWalletUseCase2 = getDebitWalletUseCase;
        GetVerifyWalletQRCodeUseCase getVerifyWalletQRCodeUseCase2 = getVerifyWalletQRCodeUseCase;
        GetWalletTopUpSuggestionAmountUseCase getWalletTopUpSuggestionAmountUseCase2 = getWalletTopUpSuggestionAmountUseCase;
        Intrinsics.checkNotNullParameter(getWalletBalanceUseCase2, "walletBalanceUseCase");
        Intrinsics.checkNotNullParameter(getWalletPaymentOptionViewConfigUseCase2, "walletPaymentOptionViewConfigUseCase");
        Intrinsics.checkNotNullParameter(getWalletPaymentWidgetUpdateUseCase2, "walletPaymentWidgetUpdateUseCase");
        Intrinsics.checkNotNullParameter(getTopUpWalletUseCase2, "topUpWalletUseCase");
        Intrinsics.checkNotNullParameter(getVerifyWalletTransactionUseCase2, "verifyWalletTransactionUseCase");
        Intrinsics.checkNotNullParameter(getDebitWalletUseCase2, "debitWalletUseCase");
        Intrinsics.checkNotNullParameter(getVerifyWalletQRCodeUseCase2, "verifyQRCodeUseCase");
        Intrinsics.checkNotNullParameter(getWalletTopUpSuggestionAmountUseCase2, "walletTopUpSuggestionsAndLimitsUseCase");
        this.walletBalanceUseCase = getWalletBalanceUseCase2;
        this.walletPaymentOptionViewConfigUseCase = getWalletPaymentOptionViewConfigUseCase2;
        this.walletPaymentWidgetUpdateUseCase = getWalletPaymentWidgetUpdateUseCase2;
        this.topUpWalletUseCase = getTopUpWalletUseCase2;
        this.verifyWalletTransactionUseCase = getVerifyWalletTransactionUseCase2;
        this.debitWalletUseCase = getDebitWalletUseCase2;
        this.verifyQRCodeUseCase = getVerifyWalletQRCodeUseCase2;
        this.walletTopUpSuggestionsAndLimitsUseCase = getWalletTopUpSuggestionAmountUseCase2;
    }

    private final void addAmountAndCashBackToMap(List<WalletTopUpAmountSuggestionDisplayModel> list) {
        for (WalletTopUpAmountSuggestionDisplayModel next : list) {
            getAmountCashBackMap().put(String.valueOf((int) next.getAmount()), Float.valueOf(next.getCashBack()));
        }
    }

    /* access modifiers changed from: private */
    public final void handleDebitWalletSuccess(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        getWalletDebitData().setValue(walletPaymentDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVerifyQRCodeServiceSuccess(WalletVerifyQRCodeDisplayModel walletVerifyQRCodeDisplayModel) {
        getWalletVerifyQRCodeData().setValue(walletVerifyQRCodeDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVerifyWalletTransactionServiceSuccess(VerifyWalletTransactionDisplayModel verifyWalletTransactionDisplayModel) {
        getVerifyWalletTransactionData().setValue(verifyWalletTransactionDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleWalletBalanceServiceSuccess(WalletBalanceDisplayModel walletBalanceDisplayModel) {
        setWalletBalance(walletBalanceDisplayModel.getWalletBalance());
        getWalletBalanceData().setValue(walletBalanceDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleWalletPaymentServiceSuccess(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        getWalletTopUpData().setValue(walletPaymentDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleWalletTopUpSuggestionsAndLimitsFailure(Failure failure) {
        LogManager.debug("wallet top up suggestions and limits failure");
    }

    /* access modifiers changed from: private */
    public final void handleWalletTopUpSuggestionsAndLimitsSuccess(WalletTopUpSuggestionsAndLimitsDisplayModel walletTopUpSuggestionsAndLimitsDisplayModel) {
        addAmountAndCashBackToMap(walletTopUpSuggestionsAndLimitsDisplayModel.getSuggestionsList());
        getWalletTopUpSuggestionAndLimitsData().setValue(walletTopUpSuggestionsAndLimitsDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void updateWalletBalance(Float f11) {
        if (!isWalletEnabled()) {
            setWalletBalance(-1.0f);
        } else {
            setWalletBalance(FloatKt.orZero(f11));
        }
    }

    public void debitWallet(@NotNull WalletDebitRequestModel walletDebitRequestModel2) {
        Intrinsics.checkNotNullParameter(walletDebitRequestModel2, "walletDebitRequestModel");
        this.debitWalletUseCase.invoke(walletDebitRequestModel2, new WalletPaymentOptionViewModelImpl$debitWallet$1(this));
    }

    public void disAblePaymentButton() {
        WalletPaymentWidgetDisplayModel value = getWalletWidgetConfigData().getValue();
        if (value != null) {
            value.setShouldEnablePaymentButton(false);
        } else {
            value = null;
        }
        getWalletWidgetConfigData().setValue(value);
    }

    public void enablePaymentButton() {
        WalletPaymentWidgetDisplayModel value = getWalletWidgetConfigData().getValue();
        if (value != null) {
            value.setShouldEnablePaymentButton(true);
        } else {
            value = null;
        }
        getWalletWidgetConfigData().setValue(value);
    }

    @NotNull
    public HashMap<String, Float> getAmountCashBackMap() {
        return this.amountCashBackMap;
    }

    public float getAmountToBalanceFromCard() {
        return this.amountToBalanceFromCard;
    }

    public float getMAmount() {
        return this.mAmount;
    }

    @NotNull
    public PaymentMethod getSelectedPaymentMethod() {
        return this.selectedPaymentMethod;
    }

    public int getTopUpMaximumAmount() {
        return this.topUpMaximumAmount;
    }

    public int getTopUpMinimumAmount() {
        return this.topUpMinimumAmount;
    }

    public float getWalletBalance() {
        return this.walletBalance;
    }

    @NotNull
    public WalletDebitRequestModel getWalletDebitRequestModel() {
        return this.walletDebitRequestModel;
    }

    public void getWalletTopUpSuggestionsAndLimits(int i11) {
        this.walletTopUpSuggestionsAndLimitsUseCase.invoke(Integer.valueOf(i11), new WalletPaymentOptionViewModelImpl$getWalletTopUpSuggestionsAndLimits$1(this));
    }

    @Nullable
    public String getWalletTransactionId() {
        return this.walletTransactionId;
    }

    @NotNull
    public WalletPaymentWidgetDisplayModel getWalletWidgetDisplayViewModel() {
        return this.walletWidgetDisplayViewModel;
    }

    public boolean isCardAvailable() {
        return this.isCardAvailable;
    }

    public boolean isCashEnabled() {
        return this.isCashEnabled;
    }

    public boolean isWalletEnabled() {
        return this.isWalletEnabled;
    }

    public void onIgnoreTopUpVerification() {
        MutableLiveData<VerifyWalletTransactionDisplayModel> verifyWalletTransactionData = getVerifyWalletTransactionData();
        VerifyWalletTransactionDisplayModel verifyWalletTransactionDisplayModel = new VerifyWalletTransactionDisplayModel();
        verifyWalletTransactionDisplayModel.setTransactionSuccessful(true);
        verifyWalletTransactionData.setValue(verifyWalletTransactionDisplayModel);
    }

    public void onNavigateToResponseScreen(boolean z11, boolean z12, boolean z13) {
        if (z11) {
            onNavigateToSuccessScreen(z12, z13);
        } else {
            onRedirectToErrorScreen(z12, z13);
        }
    }

    public void onNavigateToSuccessScreen(boolean z11, boolean z12) {
        if (z11) {
            getWalletTopUpResponseScreenStateData().setValue(WalletTopUpResponseScreenState.BottomSheetSuccess.INSTANCE);
        } else if (z12) {
            getWalletTopUpResponseScreenStateData().setValue(WalletTopUpResponseScreenState.DialogFragmentSuccess.INSTANCE);
        } else {
            getWalletTopUpResponseScreenStateData().setValue(WalletTopUpResponseScreenState.MigratedFullScreenSuccess.INSTANCE);
        }
    }

    public void onRedirectToErrorScreen(boolean z11, boolean z12) {
        if (z11) {
            getWalletTopUpResponseScreenStateData().setValue(WalletTopUpResponseScreenState.BottomSheetFailure.INSTANCE);
        } else if (z12) {
            getWalletTopUpResponseScreenStateData().setValue(WalletTopUpResponseScreenState.DialogFragmentFailure.INSTANCE);
        } else {
            getWalletTopUpResponseScreenStateData().setValue(WalletTopUpResponseScreenState.MigratedFullScreenFailure.INSTANCE);
        }
    }

    public void onThreeDSURLCheck(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "threeDSUrl");
        if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "ThankYou", true) && z11) {
            getWalletThreeDSURLRedirectionData().setValue(WalletThreeDSURLRedirectionState.SuccessWithoutTopUpVerification.INSTANCE);
        } else if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "ThankYou", true)) {
            getWalletThreeDSURLRedirectionData().setValue(WalletThreeDSURLRedirectionState.SuccessWithTopUpVerification.INSTANCE);
        } else if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "error", true)) {
            getWalletThreeDSURLRedirectionData().setValue(WalletThreeDSURLRedirectionState.RedirectionFailure.INSTANCE);
        } else {
            getWalletThreeDSURLRedirectionData().setValue(WalletThreeDSURLRedirectionState.Default.INSTANCE);
        }
    }

    public void onTopUpAmountChanged(@NotNull String str) {
        boolean z11;
        WalletTopUpButtonDisplayModel walletTopUpButtonDisplayModel;
        WalletTopUpButtonDisplayModel walletTopUpButtonDisplayModel2;
        Intrinsics.checkNotNullParameter(str, "topUpAmount");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            getWalletTopUpButtonData().setValue(new WalletTopUpButtonDisplayModel(WalletTopUpCtaState.Clear.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null));
            return;
        }
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        MutableLiveData<WalletTopUpButtonDisplayModel> walletTopUpButtonData = getWalletTopUpButtonData();
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            if (intValue < getTopUpMinimumAmount() || intValue > getTopUpMaximumAmount()) {
                walletTopUpButtonDisplayModel2 = new WalletTopUpButtonDisplayModel(WalletTopUpCtaState.Disabled.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
            } else {
                walletTopUpButtonDisplayModel = new WalletTopUpButtonDisplayModel(WalletTopUpCtaState.Enabled.INSTANCE, str);
                walletTopUpButtonData.setValue(walletTopUpButtonDisplayModel);
                getWalletSuggestionButtonsData().setValue(new WalletSuggestionButtonsDisplayModel(!getAmountCashBackMap().containsKey(str)));
            }
        } else {
            walletTopUpButtonDisplayModel2 = new WalletTopUpButtonDisplayModel(WalletTopUpCtaState.Disabled.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        }
        walletTopUpButtonDisplayModel = walletTopUpButtonDisplayModel2;
        walletTopUpButtonData.setValue(walletTopUpButtonDisplayModel);
        getWalletSuggestionButtonsData().setValue(new WalletSuggestionButtonsDisplayModel(!getAmountCashBackMap().containsKey(str)));
    }

    public void setAmountCashBackMap(@NotNull HashMap<String, Float> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.amountCashBackMap = hashMap;
    }

    public void setAmountToBalanceFromCard(float f11) {
        this.amountToBalanceFromCard = f11;
    }

    public void setCardAvailable(boolean z11) {
        this.isCardAvailable = z11;
    }

    public void setCashEnabled(boolean z11) {
        this.isCashEnabled = z11;
    }

    public void setFailureMessage(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "defaultMessage");
        MutableLiveData<WalletPaymentDisplayModel> walletDebitData = getWalletDebitData();
        WalletPaymentDisplayModel walletPaymentDisplayModel = new WalletPaymentDisplayModel();
        walletPaymentDisplayModel.setWalletTransactionStatus(WalletPaymentTransactionStatus.FAIL);
        if (str == null) {
            str = str2;
        }
        walletPaymentDisplayModel.setErrorMessage(str);
        walletDebitData.setValue(walletPaymentDisplayModel);
    }

    public void setMAmount(float f11) {
        this.mAmount = f11;
    }

    public void setPaymentMethod(@NotNull PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        setSelectedPaymentMethod(paymentMethod);
    }

    public void setSelectedPaymentMethod(@NotNull PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "<set-?>");
        this.selectedPaymentMethod = paymentMethod;
    }

    public void setTopUpMaximumAmount(int i11) {
        this.topUpMaximumAmount = i11;
    }

    public void setTopUpMinimumAmount(int i11) {
        this.topUpMinimumAmount = i11;
    }

    public void setWalletBalance(float f11) {
        this.walletBalance = f11;
    }

    public void setWalletDebitRequestModel(@NotNull WalletDebitRequestModel walletDebitRequestModel2) {
        Intrinsics.checkNotNullParameter(walletDebitRequestModel2, "<set-?>");
        this.walletDebitRequestModel = walletDebitRequestModel2;
    }

    public void setWalletEnabled(boolean z11) {
        this.isWalletEnabled = z11;
    }

    public void setWalletTransactionId(@Nullable String str) {
        this.walletTransactionId = str;
    }

    public void setWalletWidgetDisplayViewModel(@NotNull WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        Intrinsics.checkNotNullParameter(walletPaymentWidgetDisplayModel, "<set-?>");
        this.walletWidgetDisplayViewModel = walletPaymentWidgetDisplayModel;
    }

    public void topUpWallet(@NotNull WalletTopUpRequestModel walletTopUpRequestModel) {
        Intrinsics.checkNotNullParameter(walletTopUpRequestModel, "walletTopUpRequestModel");
        this.topUpWalletUseCase.invoke(walletTopUpRequestModel, new WalletPaymentOptionViewModelImpl$topUpWallet$1(this));
    }

    public void updatePaymentMethod(boolean z11, float f11, boolean z12, boolean z13) {
        setWalletWidgetDisplayViewModel(this.walletPaymentWidgetUpdateUseCase.invoke(new WalletPaymentWidgetDisplayModelParam(getWalletWidgetDisplayViewModel(), getWalletBalance(), z12, z13, f11, (Boolean) null, (Boolean) null, Boolean.valueOf(z11))));
        getWalletWidgetConfigData().setValue(getWalletWidgetDisplayViewModel());
    }

    public void updateThreeDSVerificationForBottomSheet(boolean z11) {
        getWalletThreeDSValidationData().setValue(Boolean.valueOf(z11));
    }

    public void verifyQRCode(@NotNull WalletVerifyQRCodeRequestModel walletVerifyQRCodeRequestModel) {
        Intrinsics.checkNotNullParameter(walletVerifyQRCodeRequestModel, "walletVerifyQRCodeRequestModel");
        this.verifyQRCodeUseCase.invoke(walletVerifyQRCodeRequestModel, new WalletPaymentOptionViewModelImpl$verifyQRCode$1(this));
    }

    public void verifyWalletTransaction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        this.verifyWalletTransactionUseCase.invoke(str, new WalletPaymentOptionViewModelImpl$verifyWalletTransaction$1(this));
    }

    public void walletPaymentMode(float f11, float f12, @NotNull MutableLiveData<Boolean> mutableLiveData, boolean z11, boolean z12, boolean z13) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(mutableLiveData, "cardListLoadingStatus");
        WalletBalanceDisplayModel value = getWalletBalanceData().getValue();
        if (value != null) {
            bool = Boolean.valueOf(value.isWalletBalanceLoaded());
        } else {
            bool = null;
        }
        SafeLetKt.safeLet(bool, mutableLiveData.getValue(), new WalletPaymentOptionViewModelImpl$walletPaymentMode$1(this, f11, mutableLiveData, z11, z13, f12));
    }

    public void getWalletBalance(int i11) {
        this.walletBalanceUseCase.invoke(String.valueOf(i11), new WalletPaymentOptionViewModelImpl$getWalletBalance$1(this));
    }
}
