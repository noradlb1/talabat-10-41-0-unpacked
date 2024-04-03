package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.exception.LifecycleOwnerNotFoundException;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import com.talabat.talabatcommon.listeners.DebounceQueryTextListener;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardErrorState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardFormatter;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardNumberValidationErrorState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardValidator;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardCVVState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardNumberState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateExpiryDateState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di.DaggerAddCardCustomViewComponent;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.viewmodel.CreateCustomViewViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zv.a;
import zv.b;
import zv.c;
import zv.d;
import zv.e;
import zv.f;
import zv.g;
import zv.h;
import zv.i;
import zv.j;

@Metadata(d1 = {"\u0000ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0019\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020ZH\u0002J\b\u0010\\\u001a\u00020ZH\u0002J\b\u0010]\u001a\u00020ZH\u0002J\u0006\u0010^\u001a\u00020ZJ\b\u0010_\u001a\u00020ZH\u0002J\b\u0010`\u001a\u00020ZH\u0002J\u0010\u0010a\u001a\u00020Z2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020ZH\u0002J\u0010\u0010e\u001a\u00020Z2\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u00020ZH\u0002J\u0012\u0010i\u001a\u00020Z2\b\u0010j\u001a\u0004\u0018\u00010kH\u0002J\u0010\u0010l\u001a\u00020Z2\u0006\u0010m\u001a\u00020<H\u0002J\u0010\u0010n\u001a\u00020Z2\u0006\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020ZH\u0002J\u0012\u0010r\u001a\u00020Z2\b\u0010s\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010t\u001a\u00020Z2\u0006\u0010u\u001a\u00020<H\u0002J\b\u0010v\u001a\u00020ZH\u0014J\b\u0010w\u001a\u00020ZH\u0014J\u0010\u0010x\u001a\u00020Z2\u0006\u0010y\u001a\u00020gH\u0002J\b\u0010z\u001a\u00020ZH\u0002J\u0006\u0010{\u001a\u00020ZJ\u0010\u0010|\u001a\u00020Z2\b\u0010+\u001a\u0004\u0018\u00010,J\b\u0010}\u001a\u00020ZH\u0002J\b\u0010~\u001a\u00020ZH\u0002J\u0019\u0010\u001a\u00020Z2\u0007\u0010\u0001\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020gH\u0002J\u0019\u0010\u0001\u001a\u00020N2\u0006\u0010#\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002J\u0012\u0010\u0001\u001a\u00020Z2\u0007\u0010s\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020ZH\u0002J\u0013\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020ZH\u0002J\u001a\u0010\u0001\u001a\u00020Z2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u00020Z2\t\u0010\u0001\u001a\u0004\u0018\u00010HH\u0002J\u0014\u0010\u0001\u001a\u00020Z2\t\u0010\u0001\u001a\u0004\u0018\u00010JH\u0002J\u0014\u0010\u0001\u001a\u00020Z2\t\u0010\u0001\u001a\u0004\u0018\u00010LH\u0002J\u0014\u0010\u0001\u001a\u00020Z2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u0019\u0010\u0001\u001a\u00020N2\u0006\u0010#\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020B8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006\u0001"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardCustomView;", "Landroid/widget/LinearLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addCardToWalletDataObserver", "Landroidx/lifecycle/Observer;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "cardFieldsValidationDataObserver", "", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "coroutineScope", "com/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardCustomView$coroutineScope$1", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardCustomView$coroutineScope$1;", "debitCardBinVerificationDataObserver", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinVerificationDisplayModel;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "getGenerateCardTokenUseCase", "()Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "setGenerateCardTokenUseCase", "(Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;)V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "listener", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardCustomView$AddCardCustomViewInterface;", "mCreateCustomViewViewModel", "Lcom/talabat/talabatcore/viewmodel/CreateCustomViewViewModel;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "validateCardCVVDataObserver", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "validateCardExpiryDateDataObserver", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "validateCardNumberDataObserver", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "viewModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "getViewModel", "()Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "walletCardManagementApi", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "getWalletCardManagementApi", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "setWalletCardManagementApi", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;)V", "addCVVOnFocusChangeListener", "", "addCVVTextChangeListener", "addCardNumberOnFocusChangeListener", "addCardNumberTextChangedListener", "addCardToWallet", "addExpiryDateOnFocusChangeListener", "addExpiryDateTextChangeListener", "addObservers", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "disAbleSearchButtonOnAllEditText", "disAbleSearchButtonOnKeyboard", "editText", "Landroid/widget/EditText;", "displayCardNumberNumberSuccessValidationViews", "formatCardNumber", "editable", "Landroid/text/Editable;", "formatExpiryDate", "expiryDate", "hideKeyBoard", "view", "Landroid/view/View;", "navigateToAddCardSuccess", "navigateToDesiredScreen", "walletAddCardState", "navigateToThreeDSScreen", "redirectUrl", "onAttachedToWindow", "onDetachedFromWindow", "requestCardExpiryDateFocus", "cardExpiryDate", "resetAllCardNumberValidationViews", "resetObservers", "setAddCardCustomViewListener", "setCVVFieldLength", "setCardNumberFieldLength", "setLengthForField", "length", "setupCardManagementViewModel", "showAddCardErrorMessages", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$ErrorWalletAddCard;", "showCVVErrorMessages", "cardCVVState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$FailureValidateCVVState;", "showCardIcon", "showCardNumberErrorMessage", "validateCardNumberState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$FailureValidateCardNumber;", "showValidExpiryDateViews", "toggleAddCardStatus", "shouldEnableButton", "(Ljava/lang/Boolean;)V", "updateCardCVVValidationResults", "updateCardExpiryValidationResults", "expiryDateState", "updateCardNumberValidationResults", "updateDebitCardDeflection", "displayModel", "viewModelBuilder", "AddCardCustomViewInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddCardCustomView extends LinearLayout implements LifecycleObserver, CreditCardHelperInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Observer<WalletAddCardDisplayModelState> addCardToWalletDataObserver;
    @NotNull
    private final Observer<Boolean> cardFieldsValidationDataObserver;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private AddCardCustomView$coroutineScope$1 coroutineScope;
    @NotNull
    private final Observer<DebitCardBinVerificationDisplayModel> debitCardBinVerificationDataObserver;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GenerateCardTokenUseCase generateCardTokenUseCase;
    private Lifecycle lifecycle;
    @Nullable
    private AddCardCustomViewInterface listener;
    @NotNull
    private CreateCustomViewViewModel mCreateCustomViewViewModel;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private String source;
    @Inject
    public TalabatTracker tracker;
    @NotNull
    private final Observer<WalletValidateCardCVVState> validateCardCVVDataObserver;
    @NotNull
    private final Observer<WalletValidateExpiryDateState> validateCardExpiryDateDataObserver;
    @NotNull
    private final Observer<WalletValidateCardNumberState> validateCardNumberDataObserver;
    @NotNull
    private final Lazy viewModel$delegate;
    @Inject
    public WalletCardManagementApi walletCardManagementApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardCustomView$AddCardCustomViewInterface;", "", "navigateToAddCardSuccessScreen", "", "navigateToThreeDSScreen", "redirectUrl", "", "showInvalidCardInputMessage", "showServiceErrorMessage", "toggleAddCardButton", "buttonEnableStatus", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AddCardCustomViewInterface {
        void navigateToAddCardSuccessScreen();

        void navigateToThreeDSScreen(@NotNull String str);

        void showInvalidCardInputMessage();

        void showServiceErrorMessage();

        void toggleAddCardButton(boolean z11);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[WalletAddCardErrorState.values().length];
            iArr[WalletAddCardErrorState.INVALID_INPUT.ordinal()] = 1;
            iArr[WalletAddCardErrorState.API_SERVICE_ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WalletCardNumberValidationErrorState.values().length];
            iArr2[WalletCardNumberValidationErrorState.INVALID_CARD.ordinal()] = 1;
            iArr2[WalletCardNumberValidationErrorState.INVALID_CARD_LENGTH.ordinal()] = 2;
            iArr2[WalletCardNumberValidationErrorState.QPAY_ERROR.ordinal()] = 3;
            iArr2[WalletCardNumberValidationErrorState.BAHRAIN_BENEFIT_ERROR.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddCardCustomView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new AddCardCustomView$viewModel$2(this));
        this.source = "walletPaymentBottomSheet";
        this.coroutineScope = new AddCardCustomView$coroutineScope$1();
        DaggerAddCardCustomViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DispatcherCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class), (NetworkCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(NetworkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ObservabilityCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class), (TokenizationFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TokenizationFeatureApi.class)).inject(this);
        this.validateCardNumberDataObserver = new b(this);
        this.validateCardExpiryDateDataObserver = new c(this);
        this.validateCardCVVDataObserver = new d(this);
        this.cardFieldsValidationDataObserver = new e(this);
        this.addCardToWalletDataObserver = new f(this);
        this.debitCardBinVerificationDataObserver = new g(this);
        View.inflate(getContext(), R.layout.view_wallet_add_card, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
    }

    private final void addCVVOnFocusChangeListener() {
        ((EditText) _$_findCachedViewById(R.id.security_code)).setOnFocusChangeListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCVVOnFocusChangeListener$lambda-8  reason: not valid java name */
    public static final void m5795addCVVOnFocusChangeListener$lambda8(AddCardCustomView addCardCustomView, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!z11) {
            addCardCustomView.getViewModel().onCardCVVInput(((EditText) addCardCustomView._$_findCachedViewById(R.id.security_code)).getEditableText().toString(), true);
        }
    }

    private final void addCVVTextChangeListener() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.security_code);
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
            lifecycle2 = null;
        }
        editText.addTextChangedListener(new DebounceQueryTextListener(1, (Function1) null, lifecycle2, AddCardCustomView$addCVVTextChangeListener$1.INSTANCE, new AddCardCustomView$addCVVTextChangeListener$2(this), 2, (DefaultConstructorMarker) null));
    }

    private final void addCardNumberOnFocusChangeListener() {
        ((EditText) _$_findCachedViewById(R.id.card_number_edit_text)).setOnFocusChangeListener(new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardNumberOnFocusChangeListener$lambda-7  reason: not valid java name */
    public static final void m5796addCardNumberOnFocusChangeListener$lambda7(AddCardCustomView addCardCustomView, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!z11) {
            addCardCustomView.getViewModel().onCardNumberInput(((EditText) addCardCustomView._$_findCachedViewById(R.id.card_number_edit_text)).getEditableText().toString(), true, addCardCustomView.source);
        }
    }

    private final void addCardNumberTextChangedListener() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
            lifecycle2 = null;
        }
        editText.addTextChangedListener(new DebounceQueryTextListener(1, (Function1) null, lifecycle2, AddCardCustomView$addCardNumberTextChangedListener$1.INSTANCE, new AddCardCustomView$addCardNumberTextChangedListener$2(this), 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardToWalletDataObserver$lambda-4  reason: not valid java name */
    public static final void m5797addCardToWalletDataObserver$lambda4(AddCardCustomView addCardCustomView, WalletAddCardDisplayModelState walletAddCardDisplayModelState) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        addCardCustomView.navigateToDesiredScreen(walletAddCardDisplayModelState);
    }

    private final void addExpiryDateOnFocusChangeListener() {
        ((EditText) _$_findCachedViewById(R.id.card_expiry_date)).setOnFocusChangeListener(new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addExpiryDateOnFocusChangeListener$lambda-9  reason: not valid java name */
    public static final void m5798addExpiryDateOnFocusChangeListener$lambda9(AddCardCustomView addCardCustomView, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!z11) {
            addCardCustomView.getViewModel().onCardExpiryDateInput(((EditText) addCardCustomView._$_findCachedViewById(R.id.card_expiry_date)).getEditableText().toString(), true);
        }
    }

    private final void addExpiryDateTextChangeListener() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
            lifecycle2 = null;
        }
        editText.addTextChangedListener(new DebounceQueryTextListener(1, (Function1) null, lifecycle2, AddCardCustomView$addExpiryDateTextChangeListener$1.INSTANCE, new AddCardCustomView$addExpiryDateTextChangeListener$2(this), 2, (DefaultConstructorMarker) null));
    }

    private final void addObservers(LifecycleOwner lifecycleOwner) {
        getViewModel().getValidateCardNumberData().observe(lifecycleOwner, this.validateCardNumberDataObserver);
        getViewModel().getValidateCardExpiryDateData().observe(lifecycleOwner, this.validateCardExpiryDateDataObserver);
        getViewModel().getValidateCardCVVData().observe(lifecycleOwner, this.validateCardCVVDataObserver);
        getViewModel().getCardFieldsValidationData().observe(lifecycleOwner, this.cardFieldsValidationDataObserver);
        getViewModel().getAddCardToWalletData().observe(lifecycleOwner, this.addCardToWalletDataObserver);
        getViewModel().getDebitCardBinVerificationData().observe(lifecycleOwner, this.debitCardBinVerificationDataObserver);
    }

    /* access modifiers changed from: private */
    /* renamed from: cardFieldsValidationDataObserver$lambda-3  reason: not valid java name */
    public static final void m5799cardFieldsValidationDataObserver$lambda3(AddCardCustomView addCardCustomView, Boolean bool) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        addCardCustomView.toggleAddCardStatus(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: debitCardBinVerificationDataObserver$lambda-5  reason: not valid java name */
    public static final void m5800debitCardBinVerificationDataObserver$lambda5(AddCardCustomView addCardCustomView, DebitCardBinVerificationDisplayModel debitCardBinVerificationDisplayModel) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        addCardCustomView.updateDebitCardDeflection(debitCardBinVerificationDisplayModel);
    }

    private final void disAbleSearchButtonOnAllEditText() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
        Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
        disAbleSearchButtonOnKeyboard(editText);
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(editText2, "card_expiry_date");
        disAbleSearchButtonOnKeyboard(editText2);
        EditText editText3 = (EditText) _$_findCachedViewById(R.id.security_code);
        Intrinsics.checkNotNullExpressionValue(editText3, "security_code");
        disAbleSearchButtonOnKeyboard(editText3);
    }

    private final void disAbleSearchButtonOnKeyboard(EditText editText) {
        editText.setOnEditorActionListener(new h());
    }

    /* access modifiers changed from: private */
    /* renamed from: disAbleSearchButtonOnKeyboard$lambda-12  reason: not valid java name */
    public static final boolean m5801disAbleSearchButtonOnKeyboard$lambda12(TextView textView, int i11, KeyEvent keyEvent) {
        return i11 == 3;
    }

    private final void displayCardNumberNumberSuccessValidationViews() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(editText, "card_expiry_date");
        requestCardExpiryDateFocus(editText);
        ((ImageView) _$_findCachedViewById(R.id.credit_card_logo)).setVisibility(0);
        if (getViewModel().getDebitCardBinVerificationData().getValue() instanceof DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void formatCardNumber(Editable editable) {
        if (editable != null) {
            WalletCardFormatter.INSTANCE.formatCardNumber(editable);
        }
    }

    /* access modifiers changed from: private */
    public final void formatExpiryDate(String str) {
        WalletCardFormatter walletCardFormatter = WalletCardFormatter.INSTANCE;
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(editText, "card_expiry_date");
        walletCardFormatter.formatExpiryDate(editText, AddCardCustomViewKt.lastExpiryDateInput, str);
        AddCardCustomViewKt.lastExpiryDateInput = str;
    }

    /* access modifiers changed from: private */
    public final WalletCardManagementViewModel getViewModel() {
        return (WalletCardManagementViewModel) this.viewModel$delegate.getValue();
    }

    private final void hideKeyBoard(View view) {
        Object systemService = getContext().getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void navigateToAddCardSuccess() {
        AddCardCustomViewInterface addCardCustomViewInterface = this.listener;
        if (addCardCustomViewInterface != null) {
            addCardCustomViewInterface.navigateToAddCardSuccessScreen();
        }
    }

    private final void navigateToDesiredScreen(WalletAddCardDisplayModelState walletAddCardDisplayModelState) {
        if (walletAddCardDisplayModelState instanceof WalletAddCardDisplayModelState.SuccessWalletAddCardNonThreeDS) {
            navigateToAddCardSuccess();
        } else if (walletAddCardDisplayModelState instanceof WalletAddCardDisplayModelState.SuccessWalletAddCardThreeDS) {
            navigateToThreeDSScreen(((WalletAddCardDisplayModelState.SuccessWalletAddCardThreeDS) walletAddCardDisplayModelState).getRedirectUrl());
        } else if (walletAddCardDisplayModelState instanceof WalletAddCardDisplayModelState.ErrorWalletAddCard) {
            showAddCardErrorMessages((WalletAddCardDisplayModelState.ErrorWalletAddCard) walletAddCardDisplayModelState);
        }
    }

    private final void navigateToThreeDSScreen(String str) {
        AddCardCustomViewInterface addCardCustomViewInterface = this.listener;
        if (addCardCustomViewInterface != null) {
            addCardCustomViewInterface.navigateToThreeDSScreen(str);
        }
    }

    private final void requestCardExpiryDateFocus(EditText editText) {
        editText.requestFocus();
    }

    private final void resetAllCardNumberValidationViews() {
        ((ImageView) _$_findCachedViewById(R.id.credit_card_logo)).setVisibility(4);
        if (getViewModel().getDebitCardBinVerificationData().getValue() instanceof DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void setCVVFieldLength() {
        int cvvLength = getViewModel().getWalletCardType().getCvvLength();
        EditText editText = (EditText) _$_findCachedViewById(R.id.security_code);
        Intrinsics.checkNotNullExpressionValue(editText, "security_code");
        setLengthForField(cvvLength, editText);
    }

    /* access modifiers changed from: private */
    public final void setCardNumberFieldLength() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
        Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
        setLengthForField(getViewModel().getWalletCardType().getCardNumberLength() + 3, editText);
    }

    private final void setLengthForField(int i11, EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i11)});
    }

    /* access modifiers changed from: private */
    public final WalletCardManagementViewModel setupCardManagementViewModel(GenerateCardTokenUseCase generateCardTokenUseCase2, PaymentConfigurationRepository paymentConfigurationRepository2) {
        CreateCustomViewViewModel createCustomViewViewModel = this.mCreateCustomViewViewModel;
        ViewModel viewModel = ViewModelProviders.of(createCustomViewViewModel.getActivity(), (ViewModelProvider.Factory) new AddCardCustomView$setupCardManagementViewModel$$inlined$createViewModel$1(this, generateCardTokenUseCase2, paymentConfigurationRepository2)).get(String.valueOf(R.layout.view_wallet_add_card), WalletCardManagementViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(activity, factory).get(key, T::class.java)");
        return (WalletCardManagementViewModel) viewModel;
    }

    private final void showAddCardErrorMessages(WalletAddCardDisplayModelState.ErrorWalletAddCard errorWalletAddCard) {
        AddCardCustomViewInterface addCardCustomViewInterface;
        int i11 = WhenMappings.$EnumSwitchMapping$0[errorWalletAddCard.getErrorState().ordinal()];
        if (i11 == 1) {
            AddCardCustomViewInterface addCardCustomViewInterface2 = this.listener;
            if (addCardCustomViewInterface2 != null) {
                addCardCustomViewInterface2.showInvalidCardInputMessage();
            }
        } else if (i11 == 2 && (addCardCustomViewInterface = this.listener) != null) {
            addCardCustomViewInterface.showServiceErrorMessage();
        }
    }

    private final void showCVVErrorMessages(WalletValidateCardCVVState.FailureValidateCVVState failureValidateCVVState) {
        ((TextView) _$_findCachedViewById(R.id.security_code_error)).setText(getContext().getString(com.talabat.localization.R.string.security_code_length_error, new Object[]{String.valueOf(getViewModel().getWalletCardType().getCvvLength())}));
    }

    private final void showCardIcon() {
        int i11 = R.id.credit_card_logo;
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i11)).setImageResource(WalletCardType.Companion.getCardTypeFromCardName(getViewModel().getWalletCardType().getCardName()).getIconResource());
    }

    private final void showCardNumberErrorMessage(WalletValidateCardNumberState.FailureValidateCardNumber failureValidateCardNumber) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[failureValidateCardNumber.getErrorState().ordinal()];
        if (i11 == 1) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setText(getContext().getString(com.talabat.localization.R.string.invalid_card_message));
        } else if (i11 == 2) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setText(getResources().getString(com.talabat.localization.R.string.card_number_length_error, new Object[]{String.valueOf(getViewModel().getWalletCardType().getCardNumberLength())}));
        } else if (i11 == 3) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setText(getContext().getString(R.string.qpay_deflection_message_wallet_add_card));
        } else if (i11 != 4) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setText(getContext().getString(com.talabat.localization.R.string.card_not_surported));
        } else {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setText(getContext().getString(R.string.bahrain_benefit_deflection_message_wallet_add_card));
        }
        ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R.id.credit_card_logo)).setVisibility(4);
    }

    private final void showValidExpiryDateViews() {
        ((TextView) _$_findCachedViewById(R.id.expiry_date_error)).setVisibility(4);
        ((EditText) _$_findCachedViewById(R.id.security_code)).requestFocus();
    }

    private final void toggleAddCardStatus(Boolean bool) {
        boolean z11;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            boolean z12 = getViewModel().getDebitCardBinVerificationData().getValue() instanceof DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews;
            AddCardCustomViewInterface addCardCustomViewInterface = this.listener;
            if (addCardCustomViewInterface != null) {
                if (!booleanValue || !z12) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                addCardCustomViewInterface.toggleAddCardButton(z11);
            }
        }
    }

    private final void updateCardCVVValidationResults(WalletValidateCardCVVState walletValidateCardCVVState) {
        if (walletValidateCardCVVState instanceof WalletValidateCardCVVState.DefaultValidateCVVState) {
            ((TextView) _$_findCachedViewById(R.id.security_code_error)).setVisibility(4);
        } else if (walletValidateCardCVVState instanceof WalletValidateCardCVVState.SuccessValidateCVVState) {
            ((TextView) _$_findCachedViewById(R.id.security_code_error)).setVisibility(4);
        } else if (walletValidateCardCVVState instanceof WalletValidateCardCVVState.FailureValidateCVVState) {
            showCVVErrorMessages((WalletValidateCardCVVState.FailureValidateCVVState) walletValidateCardCVVState);
        }
    }

    private final void updateCardExpiryValidationResults(WalletValidateExpiryDateState walletValidateExpiryDateState) {
        if (walletValidateExpiryDateState instanceof WalletValidateExpiryDateState.DefaultValidateExpiryDate) {
            ((TextView) _$_findCachedViewById(R.id.expiry_date_error)).setVisibility(4);
        } else if (walletValidateExpiryDateState instanceof WalletValidateExpiryDateState.SuccessValidateExpiryDate) {
            showValidExpiryDateViews();
        } else if (walletValidateExpiryDateState instanceof WalletValidateExpiryDateState.FailureValidateExpiryDate) {
            int i11 = R.id.expiry_date_error;
            ((TextView) _$_findCachedViewById(i11)).setText(getContext().getString(com.talabat.localization.R.string.invalid_expiry_date));
            ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    private final void updateCardNumberValidationResults(WalletValidateCardNumberState walletValidateCardNumberState) {
        if (walletValidateCardNumberState instanceof WalletValidateCardNumberState.DefaultValidateCardNumber) {
            resetAllCardNumberValidationViews();
        } else if (walletValidateCardNumberState instanceof WalletValidateCardNumberState.SuccessValidateCardNumber) {
            displayCardNumberNumberSuccessValidationViews();
        } else if (walletValidateCardNumberState instanceof WalletValidateCardNumberState.ShowCardIcon) {
            showCardIcon();
        } else if (walletValidateCardNumberState instanceof WalletValidateCardNumberState.FailureValidateCardNumber) {
            showCardNumberErrorMessage((WalletValidateCardNumberState.FailureValidateCardNumber) walletValidateCardNumberState);
        }
    }

    private final void updateDebitCardDeflection(DebitCardBinVerificationDisplayModel debitCardBinVerificationDisplayModel) {
        if (debitCardBinVerificationDisplayModel instanceof DebitCardBinVerificationDisplayModel.ShowQPayAddCardDeflection) {
            showCardNumberErrorMessage(new WalletValidateCardNumberState.FailureValidateCardNumber(WalletCardNumberValidationErrorState.QPAY_ERROR));
        } else if (debitCardBinVerificationDisplayModel instanceof DebitCardBinVerificationDisplayModel.ShowBenefitAddCardDeflection) {
            showCardNumberErrorMessage(new WalletValidateCardNumberState.FailureValidateCardNumber(WalletCardNumberValidationErrorState.BAHRAIN_BENEFIT_ERROR));
        } else if (debitCardBinVerificationDisplayModel instanceof DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews) {
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: validateCardCVVDataObserver$lambda-2  reason: not valid java name */
    public static final void m5802validateCardCVVDataObserver$lambda2(AddCardCustomView addCardCustomView, WalletValidateCardCVVState walletValidateCardCVVState) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        addCardCustomView.updateCardCVVValidationResults(walletValidateCardCVVState);
    }

    /* access modifiers changed from: private */
    /* renamed from: validateCardExpiryDateDataObserver$lambda-1  reason: not valid java name */
    public static final void m5803validateCardExpiryDateDataObserver$lambda1(AddCardCustomView addCardCustomView, WalletValidateExpiryDateState walletValidateExpiryDateState) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        addCardCustomView.updateCardExpiryValidationResults(walletValidateExpiryDateState);
    }

    /* access modifiers changed from: private */
    /* renamed from: validateCardNumberDataObserver$lambda-0  reason: not valid java name */
    public static final void m5804validateCardNumberDataObserver$lambda0(AddCardCustomView addCardCustomView, WalletValidateCardNumberState walletValidateCardNumberState) {
        Intrinsics.checkNotNullParameter(addCardCustomView, "this$0");
        addCardCustomView.updateCardNumberValidationResults(walletValidateCardNumberState);
    }

    /* access modifiers changed from: private */
    public final WalletCardManagementViewModel viewModelBuilder(GenerateCardTokenUseCase generateCardTokenUseCase2, PaymentConfigurationRepository paymentConfigurationRepository2) {
        WalletCardManagementViewModelBuilder.Companion companion = WalletCardManagementViewModelBuilder.Companion;
        Context applicationContext = getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return companion.getWalletCardManagementViewModel(applicationContext, this.coroutineScope, getFeatureFlagRepo(), generateCardTokenUseCase2, paymentConfigurationRepository2, getObservabilityManager(), getWalletCardManagementApi(), getTracker(), getCoroutineDispatchersFactory());
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void addCardToWallet() {
        String str;
        String str2;
        Editable text;
        Editable text2;
        Editable text3;
        getViewModel().onLoadFeatureFlags();
        int i11 = R.id.security_code;
        EditText editText = (EditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText, "security_code");
        hideKeyBoard(editText);
        WalletCardValidator walletCardValidator = WalletCardValidator.INSTANCE;
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
        String str3 = null;
        if (editText2 == null || (text3 = editText2.getText()) == null) {
            str = null;
        } else {
            str = text3.toString();
        }
        EditText editText3 = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        if (editText3 == null || (text2 = editText3.getText()) == null) {
            str2 = null;
        } else {
            str2 = text2.toString();
        }
        EditText editText4 = (EditText) _$_findCachedViewById(i11);
        if (!(editText4 == null || (text = editText4.getText()) == null)) {
            str3 = text.toString();
        }
        getViewModel().onAddCardToWallet(walletCardValidator.getFilledCard(str, str2, str3, getViewModel().isCardHolderNameFlagEnabled()));
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
    }

    @NotNull
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public final GenerateCardTokenUseCase getGenerateCardTokenUseCase() {
        GenerateCardTokenUseCase generateCardTokenUseCase2 = this.generateCardTokenUseCase;
        if (generateCardTokenUseCase2 != null) {
            return generateCardTokenUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("generateCardTokenUseCase");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final PaymentConfigurationRepository getPaymentConfigurationRepository() {
        PaymentConfigurationRepository paymentConfigurationRepository2 = this.paymentConfigurationRepository;
        if (paymentConfigurationRepository2 != null) {
            return paymentConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentConfigurationRepository");
        return null;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public final TalabatTracker getTracker() {
        TalabatTracker talabatTracker = this.tracker;
        if (talabatTracker != null) {
            return talabatTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    @NotNull
    public final WalletCardManagementApi getWalletCardManagementApi() {
        WalletCardManagementApi walletCardManagementApi2 = this.walletCardManagementApi;
        if (walletCardManagementApi2 != null) {
            return walletCardManagementApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("walletCardManagementApi");
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FragmentActivity scanForActivity = this.mCreateCustomViewViewModel.scanForActivity(getContext());
        if (!(scanForActivity instanceof LifecycleOwner)) {
            scanForActivity = null;
        }
        if (scanForActivity != null) {
            scanForActivity.getLifecycle().addObserver(this);
            Lifecycle lifecycle2 = scanForActivity.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle2, "lifecycleOwner.lifecycle");
            this.lifecycle = lifecycle2;
            addObservers(scanForActivity);
            Lifecycle lifecycle3 = scanForActivity.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle3, "lifecycleOwner.lifecycle");
            this.lifecycle = lifecycle3;
            addCardNumberTextChangedListener();
            addCardNumberOnFocusChangeListener();
            addExpiryDateTextChangeListener();
            addExpiryDateOnFocusChangeListener();
            addCVVTextChangeListener();
            addCVVOnFocusChangeListener();
            disAbleSearchButtonOnAllEditText();
            int i11 = R.id.card_number_edit_text;
            ((EditText) _$_findCachedViewById(i11)).requestFocus();
            TalabatBugReportManager talabatBugReportManager = TalabatBugReportManager.INSTANCE;
            EditText editText = (EditText) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
            EditText editText2 = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
            Intrinsics.checkNotNullExpressionValue(editText2, "card_expiry_date");
            EditText editText3 = (EditText) _$_findCachedViewById(R.id.security_code);
            Intrinsics.checkNotNullExpressionValue(editText3, "security_code");
            talabatBugReportManager.blockViewsRecording(editText, editText2, editText3);
            return;
        }
        throw new LifecycleOwnerNotFoundException();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewModel().getValidateCardNumberData().removeObserver(this.validateCardNumberDataObserver);
        getViewModel().getValidateCardExpiryDateData().removeObserver(this.validateCardExpiryDateDataObserver);
        getViewModel().getValidateCardCVVData().removeObserver(this.validateCardCVVDataObserver);
        getViewModel().getCardFieldsValidationData().removeObserver(this.cardFieldsValidationDataObserver);
        getViewModel().getAddCardToWalletData().removeObserver(this.addCardToWalletDataObserver);
        getViewModel().getDebitCardBinVerificationData().removeObserver(this.debitCardBinVerificationDataObserver);
        TalabatBugReportManager talabatBugReportManager = TalabatBugReportManager.INSTANCE;
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
        Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(editText2, "card_expiry_date");
        EditText editText3 = (EditText) _$_findCachedViewById(R.id.security_code);
        Intrinsics.checkNotNullExpressionValue(editText3, "security_code");
        talabatBugReportManager.removeViewBlocking(editText, editText2, editText3);
    }

    public final void resetObservers() {
        getViewModel().getAddCardToWalletData().setValue(null);
        getViewModel().getCardFieldsValidationData().setValue(null);
    }

    public final void setAddCardCustomViewListener(@Nullable AddCardCustomViewInterface addCardCustomViewInterface) {
        this.listener = addCardCustomViewInterface;
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGenerateCardTokenUseCase(@NotNull GenerateCardTokenUseCase generateCardTokenUseCase2) {
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "<set-?>");
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    public final void setSource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.source = str;
    }

    public final void setTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "<set-?>");
        this.tracker = talabatTracker;
    }

    public final void setWalletCardManagementApi(@NotNull WalletCardManagementApi walletCardManagementApi2) {
        Intrinsics.checkNotNullParameter(walletCardManagementApi2, "<set-?>");
        this.walletCardManagementApi = walletCardManagementApi2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddCardCustomView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new AddCardCustomView$viewModel$2(this));
        this.source = "walletPaymentBottomSheet";
        this.coroutineScope = new AddCardCustomView$coroutineScope$1();
        DaggerAddCardCustomViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DispatcherCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class), (NetworkCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(NetworkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ObservabilityCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class), (TokenizationFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TokenizationFeatureApi.class)).inject(this);
        this.validateCardNumberDataObserver = new b(this);
        this.validateCardExpiryDateDataObserver = new c(this);
        this.validateCardCVVDataObserver = new d(this);
        this.cardFieldsValidationDataObserver = new e(this);
        this.addCardToWalletDataObserver = new f(this);
        this.debitCardBinVerificationDataObserver = new g(this);
        View.inflate(getContext(), R.layout.view_wallet_add_card, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddCardCustomView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new AddCardCustomView$viewModel$2(this));
        this.source = "walletPaymentBottomSheet";
        this.coroutineScope = new AddCardCustomView$coroutineScope$1();
        DaggerAddCardCustomViewComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(DispatcherCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class), (NetworkCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(NetworkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ObservabilityCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TrackingCoreLibApi.class), (TokenizationFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TokenizationFeatureApi.class)).inject(this);
        this.validateCardNumberDataObserver = new b(this);
        this.validateCardExpiryDateDataObserver = new c(this);
        this.validateCardCVVDataObserver = new d(this);
        this.cardFieldsValidationDataObserver = new e(this);
        this.addCardToWalletDataObserver = new f(this);
        this.debitCardBinVerificationDataObserver = new g(this);
        View.inflate(getContext(), R.layout.view_wallet_add_card, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mCreateCustomViewViewModel = new CreateCustomViewViewModel(context2);
    }
}
