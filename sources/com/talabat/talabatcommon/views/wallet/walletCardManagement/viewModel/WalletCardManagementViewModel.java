package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.CardDeleteEventConstants;
import com.talabat.talabatcommon.feature.walletCardManagement.GetAddCardToWalletUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetSetWalletDefaultCardUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetWalletCardManagementFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeleteClickedEventUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.IsWalletAddCardFlutterScreenEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.IconStateDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardValidator;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletDeleteCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletSetDefaultCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardCVVState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardNumberState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateExpiryDateState;
import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010j\u001a\u00020g2\u0006\u0010k\u001a\u00020ZH\u0002J\u000e\u0010l\u001a\u00020g2\u0006\u0010m\u001a\u00020nJ\u0016\u0010o\u001a\u00020g2\u0006\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020%J\u0016\u0010r\u001a\u00020g2\u0006\u0010s\u001a\u00020H2\u0006\u0010q\u001a\u00020%J\u001e\u0010t\u001a\u00020g2\u0006\u0010u\u001a\u00020H2\u0006\u0010q\u001a\u00020%2\u0006\u0010v\u001a\u00020HJ\u0006\u0010w\u001a\u00020gJ\u000e\u0010x\u001a\u00020g2\u0006\u0010y\u001a\u00020zJ\u0006\u0010{\u001a\u00020gJ\u000e\u0010|\u001a\u00020g2\u0006\u0010}\u001a\u00020~J\u0010\u0010\u001a\u00020g2\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020gJ\u0007\u0010\u0001\u001a\u00020gJ\u0013\u0010\u0001\u001a\u00020g2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020gJ\u0019\u0010\u0001\u001a\u00020g2\u0006\u0010u\u001a\u00020H2\u0006\u0010v\u001a\u00020HH\u0007R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR \u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u00100\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001a\u00109\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001a\u0010;\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001a\u0010=\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00104\"\u0004\b>\u00106R\u001a\u0010?\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u001a\u0010A\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R \u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001d\"\u0004\bP\u0010\u001fR \u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001d\"\u0004\bT\u0010\u001fR \u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001d\"\u0004\bX\u0010\u001fR \u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u001d\"\u0004\b\\\u0010\u001fR \u0010]\u001a\b\u0012\u0004\u0012\u00020%0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u001d\"\u0004\b_\u0010\u001fR\u001a\u0010`\u001a\u00020aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006\u0001"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "Landroidx/lifecycle/ViewModel;", "setWalletDefaultCardUseCase", "Lcom/talabat/talabatcommon/feature/walletCardManagement/GetSetWalletDefaultCardUseCase;", "deleteWalletCardUseCase", "Lcom/talabat/talabatcommon/feature/walletCardManagement/GetDeleteWalletCardUseCase;", "addCardToWalletUseCase", "Lcom/talabat/talabatcommon/feature/walletCardManagement/GetAddCardToWalletUseCase;", "getWalletCardListUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "getWalletCardManagementFeatureEnabled", "Lcom/talabat/talabatcommon/feature/walletCardManagement/GetWalletCardManagementFeatureEnabledUseCase;", "debitCardDeflectionUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;", "isWalletAddCardFlutterScreenEnabledUseCase", "Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;", "sendCardDeleteClickedEventUseCase", "Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeleteClickedEventUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/GetSetWalletDefaultCardUseCase;Lcom/talabat/talabatcommon/feature/walletCardManagement/GetDeleteWalletCardUseCase;Lcom/talabat/talabatcommon/feature/walletCardManagement/GetAddCardToWalletUseCase;Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;Lcom/talabat/talabatcommon/feature/walletCardManagement/GetWalletCardManagementFeatureEnabledUseCase;Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeleteClickedEventUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "addCardIconData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/IconStateDisplayModel;", "getAddCardIconData", "()Landroidx/lifecycle/MutableLiveData;", "setAddCardIconData", "(Landroidx/lifecycle/MutableLiveData;)V", "addCardToWalletData", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "getAddCardToWalletData", "setAddCardToWalletData", "cardFieldsValidationData", "", "getCardFieldsValidationData", "setCardFieldsValidationData", "debitCardBinVerificationData", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinVerificationDisplayModel;", "getDebitCardBinVerificationData", "setDebitCardBinVerificationData", "deleteCardData", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "getDeleteCardData", "setDeleteCardData", "editCardListIconData", "getEditCardListIconData", "setEditCardListIconData", "isAddCardEnabled", "()Z", "setAddCardEnabled", "(Z)V", "isCardHolderNameFlagEnabled", "setCardHolderNameFlagEnabled", "isDebitCardBinAPICalled", "setDebitCardBinAPICalled", "isDeleteCardEnabled", "setDeleteCardEnabled", "isEditMode", "setEditMode", "isSetDefaultCardEnabled", "setSetDefaultCardEnabled", "isWalletAddCardFlutterScreenEnabled", "setWalletAddCardFlutterScreenEnabled", "setDefaultCardData", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "getSetDefaultCardData", "setSetDefaultCardData", "tokenId", "", "getTokenId", "()Ljava/lang/String;", "setTokenId", "(Ljava/lang/String;)V", "validateCardCVVData", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "getValidateCardCVVData", "setValidateCardCVVData", "validateCardExpiryDateData", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "getValidateCardExpiryDateData", "setValidateCardExpiryDateData", "validateCardNumberData", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "getValidateCardNumberData", "setValidateCardNumberData", "walletCardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getWalletCardListData", "setWalletCardListData", "walletCardListErrorData", "getWalletCardListErrorData", "setWalletCardListErrorData", "walletCardType", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "getWalletCardType", "()Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "setWalletCardType", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;)V", "handleFailure", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "handleGetWalletCards", "walletCardListDisplayModel", "onAddCardToWallet", "walletCardModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardModel;", "onCardCVVInput", "cvv", "isCursorRemoved", "onCardExpiryDateInput", "expiryDate", "onCardNumberInput", "cardNumber", "source", "onDeleteButtonClicked", "onLoadDeleteCard", "walletDeleteCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "onLoadFeatureFlags", "onLoadSetDefaultCard", "walletSetDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;", "onLoadWalletCardList", "countryId", "", "onShowAddCardButton", "toggleEditCardsListActionButton", "trackUnExpectedScenario", "throwable", "", "validateCardFields", "validateQPayBinNumber", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<IconStateDisplayModel> addCardIconData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletAddCardDisplayModelState> addCardToWalletData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetAddCardToWalletUseCase addCardToWalletUseCase;
    @NotNull
    private MutableLiveData<Boolean> cardFieldsValidationData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<DebitCardBinVerificationDisplayModel> debitCardBinVerificationData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final DebitCardDeflectionUseCase debitCardDeflectionUseCase;
    @NotNull
    private MutableLiveData<WalletDeleteCardDisplayModelState> deleteCardData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetDeleteWalletCardUseCase deleteWalletCardUseCase;
    @NotNull
    private MutableLiveData<IconStateDisplayModel> editCardListIconData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GenerateCardTokenUseCase generateCardTokenUseCase;
    @NotNull
    private final GetCardListUseCase getWalletCardListUseCase;
    @NotNull
    private final GetWalletCardManagementFeatureEnabledUseCase getWalletCardManagementFeatureEnabled;
    private boolean isAddCardEnabled;
    private boolean isCardHolderNameFlagEnabled;
    private boolean isDebitCardBinAPICalled;
    private boolean isDeleteCardEnabled;
    private boolean isEditMode;
    private boolean isSetDefaultCardEnabled;
    private boolean isWalletAddCardFlutterScreenEnabled;
    @NotNull
    private final IsWalletAddCardFlutterScreenEnabledUseCase isWalletAddCardFlutterScreenEnabledUseCase;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final SendCardDeleteClickedEventUseCase sendCardDeleteClickedEventUseCase;
    @NotNull
    private MutableLiveData<WalletSetDefaultCardDisplayModelState> setDefaultCardData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetSetWalletDefaultCardUseCase setWalletDefaultCardUseCase;
    @NotNull
    private String tokenId = StringUtils.empty(StringCompanionObject.INSTANCE);
    @NotNull
    private MutableLiveData<WalletValidateCardCVVState> validateCardCVVData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletValidateExpiryDateState> validateCardExpiryDateData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletValidateCardNumberState> validateCardNumberData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCardListDisplayModel> walletCardListData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> walletCardListErrorData = new MutableLiveData<>();
    @NotNull
    private WalletCardType walletCardType = WalletCardType.DEAFULT;

    public WalletCardManagementViewModel(@NotNull GetSetWalletDefaultCardUseCase getSetWalletDefaultCardUseCase, @NotNull GetDeleteWalletCardUseCase getDeleteWalletCardUseCase, @NotNull GetAddCardToWalletUseCase getAddCardToWalletUseCase, @NotNull GetCardListUseCase getCardListUseCase, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull GenerateCardTokenUseCase generateCardTokenUseCase2, @NotNull GetWalletCardManagementFeatureEnabledUseCase getWalletCardManagementFeatureEnabledUseCase, @NotNull DebitCardDeflectionUseCase debitCardDeflectionUseCase2, @NotNull IsWalletAddCardFlutterScreenEnabledUseCase isWalletAddCardFlutterScreenEnabledUseCase2, @NotNull SendCardDeleteClickedEventUseCase sendCardDeleteClickedEventUseCase2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(getSetWalletDefaultCardUseCase, "setWalletDefaultCardUseCase");
        Intrinsics.checkNotNullParameter(getDeleteWalletCardUseCase, "deleteWalletCardUseCase");
        Intrinsics.checkNotNullParameter(getAddCardToWalletUseCase, "addCardToWalletUseCase");
        Intrinsics.checkNotNullParameter(getCardListUseCase, "getWalletCardListUseCase");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "generateCardTokenUseCase");
        Intrinsics.checkNotNullParameter(getWalletCardManagementFeatureEnabledUseCase, "getWalletCardManagementFeatureEnabled");
        Intrinsics.checkNotNullParameter(debitCardDeflectionUseCase2, "debitCardDeflectionUseCase");
        Intrinsics.checkNotNullParameter(isWalletAddCardFlutterScreenEnabledUseCase2, "isWalletAddCardFlutterScreenEnabledUseCase");
        Intrinsics.checkNotNullParameter(sendCardDeleteClickedEventUseCase2, "sendCardDeleteClickedEventUseCase");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.setWalletDefaultCardUseCase = getSetWalletDefaultCardUseCase;
        this.deleteWalletCardUseCase = getDeleteWalletCardUseCase;
        this.addCardToWalletUseCase = getAddCardToWalletUseCase;
        this.getWalletCardListUseCase = getCardListUseCase;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
        this.getWalletCardManagementFeatureEnabled = getWalletCardManagementFeatureEnabledUseCase;
        this.debitCardDeflectionUseCase = debitCardDeflectionUseCase2;
        this.isWalletAddCardFlutterScreenEnabledUseCase = isWalletAddCardFlutterScreenEnabledUseCase2;
        this.sendCardDeleteClickedEventUseCase = sendCardDeleteClickedEventUseCase2;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    public final void handleFailure(Failure failure) {
        this.walletCardListErrorData.setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void handleGetWalletCards(WalletCardListDisplayModel walletCardListDisplayModel) {
        this.tokenId = StringUtils.empty(StringCompanionObject.INSTANCE);
        this.walletCardListData.setValue(walletCardListDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void trackUnExpectedScenario(Throwable th2) {
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        this.observabilityManager.trackUnExpectedScenario(CardDeleteEventConstants.CARD_DELETION_EXCEPTION, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    @NotNull
    public final MutableLiveData<IconStateDisplayModel> getAddCardIconData() {
        return this.addCardIconData;
    }

    @NotNull
    public final MutableLiveData<WalletAddCardDisplayModelState> getAddCardToWalletData() {
        return this.addCardToWalletData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getCardFieldsValidationData() {
        return this.cardFieldsValidationData;
    }

    @NotNull
    public final MutableLiveData<DebitCardBinVerificationDisplayModel> getDebitCardBinVerificationData() {
        return this.debitCardBinVerificationData;
    }

    @NotNull
    public final MutableLiveData<WalletDeleteCardDisplayModelState> getDeleteCardData() {
        return this.deleteCardData;
    }

    @NotNull
    public final MutableLiveData<IconStateDisplayModel> getEditCardListIconData() {
        return this.editCardListIconData;
    }

    @NotNull
    public final MutableLiveData<WalletSetDefaultCardDisplayModelState> getSetDefaultCardData() {
        return this.setDefaultCardData;
    }

    @NotNull
    public final String getTokenId() {
        return this.tokenId;
    }

    @NotNull
    public final MutableLiveData<WalletValidateCardCVVState> getValidateCardCVVData() {
        return this.validateCardCVVData;
    }

    @NotNull
    public final MutableLiveData<WalletValidateExpiryDateState> getValidateCardExpiryDateData() {
        return this.validateCardExpiryDateData;
    }

    @NotNull
    public final MutableLiveData<WalletValidateCardNumberState> getValidateCardNumberData() {
        return this.validateCardNumberData;
    }

    @NotNull
    public final MutableLiveData<WalletCardListDisplayModel> getWalletCardListData() {
        return this.walletCardListData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getWalletCardListErrorData() {
        return this.walletCardListErrorData;
    }

    @NotNull
    public final WalletCardType getWalletCardType() {
        return this.walletCardType;
    }

    public final boolean isAddCardEnabled() {
        return this.isAddCardEnabled;
    }

    public final boolean isCardHolderNameFlagEnabled() {
        return this.isCardHolderNameFlagEnabled;
    }

    public final boolean isDebitCardBinAPICalled() {
        return this.isDebitCardBinAPICalled;
    }

    public final boolean isDeleteCardEnabled() {
        return this.isDeleteCardEnabled;
    }

    public final boolean isEditMode() {
        return this.isEditMode;
    }

    public final boolean isSetDefaultCardEnabled() {
        return this.isSetDefaultCardEnabled;
    }

    public final boolean isWalletAddCardFlutterScreenEnabled() {
        return this.isWalletAddCardFlutterScreenEnabled;
    }

    public final void onAddCardToWallet(@NotNull WalletCardModel walletCardModel) {
        Intrinsics.checkNotNullParameter(walletCardModel, "walletCardModel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletCardManagementViewModel$onAddCardToWallet$1(this, walletCardModel, (Continuation<? super WalletCardManagementViewModel$onAddCardToWallet$1>) null), 3, (Object) null);
    }

    public final void onCardCVVInput(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_CVV_KEY);
        this.validateCardCVVData.setValue(WalletCardValidator.INSTANCE.validateCVV(this.walletCardType, str, z11));
        validateCardFields();
    }

    public final void onCardExpiryDateInput(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "expiryDate");
        this.validateCardExpiryDateData.setValue(WalletCardValidator.INSTANCE.validateCardExpiryDate(str, z11));
        validateCardFields();
    }

    public final void onCardNumberInput(@NotNull String str, boolean z11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "source");
        WalletCardValidator walletCardValidator = WalletCardValidator.INSTANCE;
        String removeWhiteSpaces = walletCardValidator.removeWhiteSpaces(str);
        this.walletCardType = walletCardValidator.getCardType(removeWhiteSpaces, this.paymentConfigurationRepository.walletConfig().isAmexAvailable());
        this.validateCardNumberData.setValue(walletCardValidator.validateCardNumber(removeWhiteSpaces, z11, this.paymentConfigurationRepository.walletConfig().isAmexAvailable()));
        validateCardFields();
        validateQPayBinNumber(StringsKt__StringsJVMKt.replace$default(str, " ", "", false, 4, (Object) null), str2);
    }

    public final void onDeleteButtonClicked() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletCardManagementViewModel$onDeleteButtonClicked$1(this, (Continuation<? super WalletCardManagementViewModel$onDeleteButtonClicked$1>) null), 3, (Object) null);
    }

    public final void onLoadDeleteCard(@NotNull WalletDeleteCardRequestModel walletDeleteCardRequestModel) {
        Intrinsics.checkNotNullParameter(walletDeleteCardRequestModel, "walletDeleteCardRequestModel");
        this.deleteCardData.setValue(WalletDeleteCardDisplayModelState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletCardManagementViewModel$onLoadDeleteCard$1(this, walletDeleteCardRequestModel, (Continuation<? super WalletCardManagementViewModel$onLoadDeleteCard$1>) null), 3, (Object) null);
    }

    public final void onLoadFeatureFlags() {
        this.isAddCardEnabled = this.getWalletCardManagementFeatureEnabled.invoke(PayFeatureFlagConstants.ADD_CARD);
        this.isDeleteCardEnabled = this.getWalletCardManagementFeatureEnabled.invoke(PayFeatureFlagConstants.DELETE_CARD);
        this.isSetDefaultCardEnabled = this.getWalletCardManagementFeatureEnabled.invoke(PayFeatureFlagConstants.SET_DEFAULT_CARD);
        this.isCardHolderNameFlagEnabled = this.getWalletCardManagementFeatureEnabled.invoke(PayFeatureFlagConstants.CARD_HOLDER_NAME);
        this.isWalletAddCardFlutterScreenEnabled = this.isWalletAddCardFlutterScreenEnabledUseCase.invoke();
    }

    public final void onLoadSetDefaultCard(@NotNull WalletSetDefaultCardRequestModel walletSetDefaultCardRequestModel) {
        Intrinsics.checkNotNullParameter(walletSetDefaultCardRequestModel, "walletSetDefaultCardRequestModel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletCardManagementViewModel$onLoadSetDefaultCard$1(this, walletSetDefaultCardRequestModel, (Continuation<? super WalletCardManagementViewModel$onLoadSetDefaultCard$1>) null), 3, (Object) null);
    }

    public final void onLoadWalletCardList(int i11) {
        this.getWalletCardListUseCase.invoke(Integer.valueOf(i11), new WalletCardManagementViewModel$onLoadWalletCardList$1(this));
    }

    public final void onShowAddCardButton() {
        if (this.isAddCardEnabled) {
            this.addCardIconData.postValue(IconStateDisplayModel.ShowIcon.INSTANCE);
        } else {
            this.addCardIconData.postValue(IconStateDisplayModel.HideIcon.INSTANCE);
        }
    }

    public final void setAddCardEnabled(boolean z11) {
        this.isAddCardEnabled = z11;
    }

    public final void setAddCardIconData(@NotNull MutableLiveData<IconStateDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addCardIconData = mutableLiveData;
    }

    public final void setAddCardToWalletData(@NotNull MutableLiveData<WalletAddCardDisplayModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addCardToWalletData = mutableLiveData;
    }

    public final void setCardFieldsValidationData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.cardFieldsValidationData = mutableLiveData;
    }

    public final void setCardHolderNameFlagEnabled(boolean z11) {
        this.isCardHolderNameFlagEnabled = z11;
    }

    public final void setDebitCardBinAPICalled(boolean z11) {
        this.isDebitCardBinAPICalled = z11;
    }

    public final void setDebitCardBinVerificationData(@NotNull MutableLiveData<DebitCardBinVerificationDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.debitCardBinVerificationData = mutableLiveData;
    }

    public final void setDeleteCardData(@NotNull MutableLiveData<WalletDeleteCardDisplayModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.deleteCardData = mutableLiveData;
    }

    public final void setDeleteCardEnabled(boolean z11) {
        this.isDeleteCardEnabled = z11;
    }

    public final void setEditCardListIconData(@NotNull MutableLiveData<IconStateDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.editCardListIconData = mutableLiveData;
    }

    public final void setEditMode(boolean z11) {
        this.isEditMode = z11;
    }

    public final void setSetDefaultCardData(@NotNull MutableLiveData<WalletSetDefaultCardDisplayModelState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.setDefaultCardData = mutableLiveData;
    }

    public final void setSetDefaultCardEnabled(boolean z11) {
        this.isSetDefaultCardEnabled = z11;
    }

    public final void setTokenId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tokenId = str;
    }

    public final void setValidateCardCVVData(@NotNull MutableLiveData<WalletValidateCardCVVState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.validateCardCVVData = mutableLiveData;
    }

    public final void setValidateCardExpiryDateData(@NotNull MutableLiveData<WalletValidateExpiryDateState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.validateCardExpiryDateData = mutableLiveData;
    }

    public final void setValidateCardNumberData(@NotNull MutableLiveData<WalletValidateCardNumberState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.validateCardNumberData = mutableLiveData;
    }

    public final void setWalletAddCardFlutterScreenEnabled(boolean z11) {
        this.isWalletAddCardFlutterScreenEnabled = z11;
    }

    public final void setWalletCardListData(@NotNull MutableLiveData<WalletCardListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletCardListData = mutableLiveData;
    }

    public final void setWalletCardListErrorData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletCardListErrorData = mutableLiveData;
    }

    public final void setWalletCardType(@NotNull WalletCardType walletCardType2) {
        Intrinsics.checkNotNullParameter(walletCardType2, "<set-?>");
        this.walletCardType = walletCardType2;
    }

    public final void toggleEditCardsListActionButton() {
        if (this.isDeleteCardEnabled || this.isSetDefaultCardEnabled) {
            this.editCardListIconData.postValue(IconStateDisplayModel.ShowIcon.INSTANCE);
        } else {
            this.editCardListIconData.postValue(IconStateDisplayModel.HideIcon.INSTANCE);
        }
    }

    public final void validateCardFields() {
        boolean z11;
        MutableLiveData<Boolean> mutableLiveData = this.cardFieldsValidationData;
        if (!(this.validateCardNumberData.getValue() instanceof WalletValidateCardNumberState.SuccessValidateCardNumber) || !(this.validateCardExpiryDateData.getValue() instanceof WalletValidateExpiryDateState.SuccessValidateExpiryDate) || !(this.validateCardCVVData.getValue() instanceof WalletValidateCardCVVState.SuccessValidateCVVState)) {
            z11 = false;
        } else {
            z11 = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z11));
    }

    @VisibleForTesting
    public final void validateQPayBinNumber(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(str2, "source");
        if (Intrinsics.areEqual((Object) str2, (Object) "tpro")) {
            this.debitCardBinVerificationData.postValue(DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews.INSTANCE);
        } else if (str.length() >= 6 && !this.isDebitCardBinAPICalled) {
            this.isDebitCardBinAPICalled = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletCardManagementViewModel$validateQPayBinNumber$1(this, str, (Continuation<? super WalletCardManagementViewModel$validateQPayBinNumber$1>) null), 3, (Object) null);
        } else if (IntKt.orZero(Integer.valueOf(str.length())) < 6) {
            this.debitCardBinVerificationData.postValue(DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews.INSTANCE);
            this.isDebitCardBinAPICalled = false;
        }
    }
}
