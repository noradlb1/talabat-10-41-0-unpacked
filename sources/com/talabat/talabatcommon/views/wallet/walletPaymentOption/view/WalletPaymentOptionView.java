package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bw.c;
import bw.d;
import bw.e;
import bw.f;
import bw.g;
import bw.h;
import bw.i;
import bw.j;
import bw.k;
import bw.l;
import bw.m;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardNavigationUtility;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardDialogFragment;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsDialogFragment;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelBuilder;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0001B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u001fJ3\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u0014¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010,\u001a\u00020\u001f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0006\u0010/\u001a\u00020\u001fJ\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\u0012\u00102\u001a\u00020\u001f2\b\u00103\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u00104\u001a\u00020\u0014J\u0006\u00105\u001a\u00020\u001fJ\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001407J\n\u00108\u001a\u0004\u0018\u00010.H\u0002J\u0012\u00109\u001a\u00020:2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010;\u001a\u00020\u0014J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=07J\u0006\u0010>\u001a\u00020?J\r\u0010@\u001a\u0004\u0018\u00010:¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020CH\u0016J\b\u0010D\u001a\u00020\u001fH\u0002J\u0006\u0010E\u001a\u00020\u001fJ\b\u0010F\u001a\u00020\u001fH\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010H\u001a\u00020\u001fH\u0016J\b\u0010I\u001a\u00020\u001fH\u0016J\b\u0010J\u001a\u00020\u001fH\u0016J\b\u0010K\u001a\u00020\u001fH\u0014J\b\u0010L\u001a\u00020\u001fH\u0016J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010N\u001a\u00020\u001fH\u0016J\u0018\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010P\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010Q\u001a\u00020\u001fH\u0016J\"\u0010R\u001a\u00020\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010S\u001a\u00020T2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002J2\u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010X\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010Y\u001a\u00020\u001fJ\u0006\u0010Z\u001a\u00020\u001fJ\u0010\u0010[\u001a\u00020\u001f2\b\u0010\\\u001a\u0004\u0018\u00010\rJ\"\u0010]\u001a\u00020\u001f2\b\u0010\\\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u00142\b\b\u0002\u0010`\u001a\u00020\u0014J\"\u0010a\u001a\u00020\u001f2\b\u0010\\\u001a\u0004\u0018\u00010b2\u0006\u0010_\u001a\u00020\u00142\b\b\u0002\u0010`\u001a\u00020\u0014J\u000e\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020=J\b\u0010e\u001a\u00020\u001fH\u0002J\b\u0010f\u001a\u00020\u001fH\u0002J\b\u0010g\u001a\u00020\u001fH\u0002J\b\u0010h\u001a\u00020\u001fH\u0002J\b\u0010i\u001a\u00020\u001fH\u0002J\b\u0010j\u001a\u00020\u001fH\u0002J\b\u0010k\u001a\u00020\u001fH\u0002J\b\u0010l\u001a\u00020\u001fH\u0002J\b\u0010m\u001a\u00020\u001fH\u0002J\b\u0010n\u001a\u00020\u001fH\u0002J\b\u0010o\u001a\u00020\u001fH\u0002J\b\u0010p\u001a\u00020\u001fH\u0002J\b\u0010q\u001a\u00020\u001fH\u0002J\b\u0010r\u001a\u00020\u001fH\u0002J\b\u0010s\u001a\u00020\u001fH\u0002J\b\u0010t\u001a\u00020\u001fH\u0002J\b\u0010u\u001a\u00020\u001fH\u0002J\b\u0010v\u001a\u00020\u001fH\u0002J \u0010w\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010x\u001a\u00020.2\u0006\u0010S\u001a\u00020TH\u0002J\u000e\u0010y\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&J\u0010\u0010z\u001a\u00020\u001f2\u0006\u0010{\u001a\u00020\u0014H\u0002J\u0017\u0010|\u001a\u00020\u001f2\b\u0010}\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010~J\u000f\u0010\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020:J\u0014\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001aH\u0002J\u0013\u0010\u0001\u001a\u00020\u001f2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J\u0013\u0010\u0001\u001a\u00020\u001f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\t\u0010\u0001\u001a\u00020\u0002H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentOptionView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsDialogFragment$WalletPaymentThreeDsDialogFragmentInterface;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addCardListener", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentOptionView$AddCardInterface;", "failureObserver", "Landroidx/lifecycle/Observer;", "Lcom/talabat/talabatcore/exception/Failure;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "isUpdatePaymentStatusShown", "", "shouldIgnoreTopUpVerification", "useMarshmallowLayout", "walletBalanceDataObserver", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "walletDebitDataObserver", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "walletTopUpDataObserver", "walletWidgetConfigDataObserver", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "addAddCardListener", "", "addCardObservers", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "addDefaultCard", "addPaymentMethodView", "amount", "", "isCardEnabledFromParent", "isCashEnabledFromParent", "isWalletEnabled", "(Ljava/lang/Float;ZZZ)V", "addWalletBalanceObserver", "debitWallet", "walletTransactionId", "", "disAblePaymentButton", "displayActualAmountToBeChargedFromCard", "enablePaymentButton", "failureHere", "failure", "getCardAvailabilityStatus", "getCardList", "getCardLoadingStatus", "Landroidx/lifecycle/MutableLiveData;", "getClassName", "getLayoutId", "", "getPaymentButtonStatus", "getSelectedCard", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "getSelectedPaymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "getSelectedPosition", "()Ljava/lang/Integer;", "getViewModelClass", "Ljava/lang/Class;", "hideAddCard", "hideCardContainer", "hideWalletView", "observatory", "onAddCardSuccess", "onBottomSheetTopUpFailure", "onBottomSheetTopUpSuccessful", "onDetachedFromWindow", "onDialogBackPressed", "onLifecycleOwnerAttached", "onTopUpFailure", "errorMessage", "onTopUpSuccessWithoutThreeDs", "onTopUpSuccessful", "payAmountThroughWallet", "walletDebitRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "payThroughWalletWithoutTopUp", "redirectToThreeDsScreen", "redirectUrl", "isNavigationFromBottomSheet", "resetObservers", "resetSelectedPosition", "setAddCardListener", "listener", "setDefaultCardViewBottomScreenListener", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewBottomScreenInterface;", "shouldShowChangeCard", "isCashAllowed", "setDefaultCardViewFullScreenListener", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewFullScreenInterface;", "setSelectedCard", "cardModel", "setUpCardFirst", "setUpCashView", "setUpCashWithDisabledWallet", "setUpDisabledWalletView", "setUpOnlyCardPaymentModeView", "setUpOnlyWallet", "setUpSinglePaymentModeView", "setUpWalletWithAddCard", "setupMixedPaymentModeView", "setupView", "shouldHideWalletView", "showAddCardDialog", "showAddCardForCashOnly", "showAddCardView", "showCardAmountToBeCharged", "showCashPaymentMessage", "showNoChargeAmountMessage", "showWalletBalance", "topUpWallet", "externalPaymentId", "updateAmount", "updateCardContainer", "isCardAvailable", "updateCashMessage", "cashAmountMessageStatus", "(Ljava/lang/Boolean;)V", "updateClickedPositionData", "position", "updatePaymentStatus", "walletPaymentDisplayModel", "updatePaymentViewType", "view", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel$PaymentOptionViewType;", "updateTopUpMessage", "showTopUpUI", "updateWalletBalance", "walletBalanceDisplayModel", "updateWalletCardListData", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "viewModelBuilder", "AddCardInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WalletPaymentOptionView extends MvvmLinearLayout<WalletPaymentOptionViewModel> implements CreditCardHelperInterface, AnimationHelper, WalletPaymentThreeDsDialogFragment.WalletPaymentThreeDsDialogFragmentInterface, WalletAddCardDialogFragment.WalletAddCardDialogFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private AddCardInterface addCardListener;
    @NotNull
    private final Observer<Failure> failureObserver;
    @Nullable
    private FragmentManager fragmentManager;
    private boolean isUpdatePaymentStatusShown;
    private boolean shouldIgnoreTopUpVerification;
    private boolean useMarshmallowLayout;
    @NotNull
    private final Observer<WalletBalanceDisplayModel> walletBalanceDataObserver;
    @NotNull
    private final Observer<WalletPaymentDisplayModel> walletDebitDataObserver;
    @NotNull
    private final Observer<WalletPaymentDisplayModel> walletTopUpDataObserver;
    @NotNull
    private final Observer<WalletPaymentWidgetDisplayModel> walletWidgetConfigDataObserver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentOptionView$AddCardInterface;", "", "onAddCardClicked", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AddCardInterface {
        void onAddCardClicked();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[WalletPaymentOptionViewModel.PaymentOptionViewType.values().length];
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYCARD.ordinal()] = 1;
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.WALLETANDCARD.ordinal()] = 2;
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.SINGLE.ordinal()] = 3;
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYWALLET.ordinal()] = 4;
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.ONLYCASH.ordinal()] = 5;
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.CASHWITHDISABLEDWALLET.ordinal()] = 6;
            iArr[WalletPaymentOptionViewModel.PaymentOptionViewType.DISABLEDWALLETONLY.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PaymentMethod.values().length];
            iArr2[PaymentMethod.CARD.ordinal()] = 1;
            iArr2[PaymentMethod.MIXED.ordinal()] = 2;
            iArr2[PaymentMethod.WALLET.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[WalletPaymentTransactionStatus.values().length];
            iArr3[WalletPaymentTransactionStatus.FAIL.ordinal()] = 1;
            iArr3[WalletPaymentTransactionStatus.SUCCESS.ordinal()] = 2;
            iArr3[WalletPaymentTransactionStatus.THREE_DS.ordinal()] = 3;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletPaymentOptionView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        this.walletTopUpDataObserver = new j(this);
        this.walletBalanceDataObserver = new k(this);
        this.walletWidgetConfigDataObserver = new l(this);
        this.failureObserver = new m();
        this.walletDebitDataObserver = new d();
    }

    private final void addAddCardListener() {
        _$_findCachedViewById(R.id.add_new_card_view).setOnClickListener(new g(this));
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container))._$_findCachedViewById(R.id.no_card_view).setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addAddCardListener$lambda-12  reason: not valid java name */
    public static final void m5810addAddCardListener$lambda12(WalletPaymentOptionView walletPaymentOptionView, View view) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.showAddCardDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: addAddCardListener$lambda-13  reason: not valid java name */
    public static final void m5811addAddCardListener$lambda13(WalletPaymentOptionView walletPaymentOptionView, View view) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.showAddCardDialog();
    }

    private final void addCardObservers(LifecycleOwner lifecycleOwner) {
        int i11 = R.id.card_container;
        ((CardViewWidgetsViewModel) ((DefaultCardView) _$_findCachedViewById(i11)).getViewModel()).getCardChangedData().observe(lifecycleOwner, new c(this));
        ((DefaultCardView) _$_findCachedViewById(i11)).getCardLoadingStatus().observe(lifecycleOwner, new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardObservers$lambda-7  reason: not valid java name */
    public static final void m5812addCardObservers$lambda7(WalletPaymentOptionView walletPaymentOptionView, Boolean bool) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.updateAmount(((WalletPaymentOptionViewModel) walletPaymentOptionView.getViewModel()).getMAmount());
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardObservers$lambda-8  reason: not valid java name */
    public static final void m5813addCardObservers$lambda8(WalletPaymentOptionView walletPaymentOptionView, Boolean bool) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        walletPaymentOptionView.updateCardContainer(bool.booleanValue());
    }

    public static /* synthetic */ void addPaymentMethodView$default(WalletPaymentOptionView walletPaymentOptionView, Float f11, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = true;
            }
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            if ((i11 & 8) != 0) {
                z13 = true;
            }
            walletPaymentOptionView.addPaymentMethodView(f11, z11, z12, z13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPaymentMethodView");
    }

    private final void addWalletBalanceObserver(LifecycleOwner lifecycleOwner) {
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData().observe(lifecycleOwner, new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addWalletBalanceObserver$lambda-9  reason: not valid java name */
    public static final void m5814addWalletBalanceObserver$lambda9(WalletPaymentOptionView walletPaymentOptionView, WalletBalanceDisplayModel walletBalanceDisplayModel) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.updateWalletBalance(walletBalanceDisplayModel);
    }

    private final void debitWallet(String str) {
        WalletDebitRequestModel walletDebitRequestModel = ((WalletPaymentOptionViewModel) getViewModel()).getWalletDebitRequestModel();
        if (str != null) {
            ((WalletPaymentOptionViewModel) getViewModel()).getWalletDebitRequestModel().setTransId(str);
        }
        ((WalletPaymentOptionViewModel) getViewModel()).debitWallet(walletDebitRequestModel);
    }

    private final void displayActualAmountToBeChargedFromCard() {
        String str;
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
        DefaultCardView defaultCardView = (DefaultCardView) _$_findCachedViewById(R.id.card_container);
        Resources resources = getResources();
        int i11 = com.talabat.localization.R.string.wallet_top_up_message;
        Object[] objArr = new Object[2];
        WalletBalanceDisplayModel value = ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData().getValue();
        if (value != null) {
            str = value.getAmountCurrency();
        } else {
            str = null;
        }
        objArr[0] = str;
        objArr[1] = CurrencyFormatter.Companion.formatAmount$default(CurrencyFormatter.Companion, locationConfigurationRepository, ((WalletPaymentOptionViewModel) getViewModel()).getWalletWidgetDisplayViewModel().getAmountToBalanceFromCard(), false, 4, (Object) null);
        String string = resources.getString(i11, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …          )\n            )");
        defaultCardView.showDefaultCardInformation(string);
    }

    private final void enablePaymentButton() {
        ((WalletPaymentOptionViewModel) getViewModel()).enablePaymentButton();
    }

    /* access modifiers changed from: private */
    /* renamed from: failureObserver$lambda-3  reason: not valid java name */
    public static final void m5815failureObserver$lambda3(Failure failure) {
    }

    private final String getClassName() {
        return Reflection.getOrCreateKotlinClass(WalletPaymentOptionView.class).getSimpleName();
    }

    private final void hideAddCard() {
        _$_findCachedViewById(R.id.add_new_card_view).setVisibility(8);
    }

    private final void hideWalletView() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_payment_container)).setVisibility(8);
    }

    public static /* synthetic */ void l(WalletPaymentOptionView walletPaymentOptionView, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            walletPaymentOptionView.debitWallet(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debitWallet");
    }

    private final void onTopUpFailure(String str, String str2) {
        this.isUpdatePaymentStatusShown = true;
        ((WalletPaymentOptionViewModel) getViewModel()).setWalletTransactionId(str2);
        ((WalletPaymentOptionViewModel) getViewModel()).setFailureMessage(str, ViewKt.getString(this, com.talabat.localization.R.string.failure_server_error));
    }

    private final void onTopUpSuccessWithoutThreeDs(String str) {
        this.isUpdatePaymentStatusShown = true;
        ((WalletPaymentOptionViewModel) getViewModel()).setWalletTransactionId(str);
        debitWallet(str);
    }

    public static /* synthetic */ void payAmountThroughWallet$default(WalletPaymentOptionView walletPaymentOptionView, FragmentManager fragmentManager2, WalletDebitRequestModel walletDebitRequestModel, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            walletPaymentOptionView.payAmountThroughWallet(fragmentManager2, walletDebitRequestModel, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payAmountThroughWallet");
    }

    private final void payThroughWalletWithoutTopUp(float f11) {
        l(this, (String) null, 1, (Object) null);
    }

    public static /* synthetic */ void redirectToThreeDsScreen$default(WalletPaymentOptionView walletPaymentOptionView, String str, String str2, FragmentManager fragmentManager2, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            walletPaymentOptionView.redirectToThreeDsScreen(str, str2, fragmentManager2, z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redirectToThreeDsScreen");
    }

    public static /* synthetic */ void setDefaultCardViewBottomScreenListener$default(WalletPaymentOptionView walletPaymentOptionView, DefaultCardView.DefaultCardViewBottomScreenInterface defaultCardViewBottomScreenInterface, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            walletPaymentOptionView.setDefaultCardViewBottomScreenListener(defaultCardViewBottomScreenInterface, z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCardViewBottomScreenListener");
    }

    public static /* synthetic */ void setDefaultCardViewFullScreenListener$default(WalletPaymentOptionView walletPaymentOptionView, DefaultCardView.DefaultCardViewFullScreenInterface defaultCardViewFullScreenInterface, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            walletPaymentOptionView.setDefaultCardViewFullScreenListener(defaultCardViewFullScreenInterface, z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCardViewFullScreenListener");
    }

    private final void setUpCardFirst() {
        Switch switchR = (Switch) _$_findCachedViewById(R.id.payment_choice_switch);
        if (switchR != null) {
            switchR.setChecked(false);
        }
        ((TextView) _$_findCachedViewById(R.id.payment_mode_string_switch)).setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.CARD);
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        showCardAmountToBeCharged();
    }

    private final void setUpCashView() {
        int i11 = R.id.payment_mode_string_switch;
        TextView textView = (TextView) _$_findCachedViewById(i11);
        if (textView != null) {
            textView.setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(i11);
        if (textView2 != null) {
            textView2.setAlpha(0.2f);
        }
        int i12 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i12);
        if (switchR != null) {
            switchR.setChecked(false);
        }
        Switch switchR2 = (Switch) _$_findCachedViewById(i12);
        if (switchR2 != null) {
            switchR2.setClickable(false);
        }
        showCashPaymentMessage();
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.CASH);
        ((TextView) ((DefaultCardView) _$_findCachedViewById(R.id.card_container))._$_findCachedViewById(R.id.card_name)).setText(getResources().getString(com.talabat.localization.R.string.pay_restaurant_directly));
        showAddCardView();
    }

    private final void setUpCashWithDisabledWallet() {
        int i11 = R.id.payment_mode_string_switch;
        TextView textView = (TextView) _$_findCachedViewById(i11);
        if (textView != null) {
            textView.setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        }
        showCashPaymentMessage();
        TextView textView2 = (TextView) _$_findCachedViewById(i11);
        if (textView2 != null) {
            textView2.setAlpha(0.2f);
        }
        int i12 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i12);
        if (switchR != null) {
            switchR.setChecked(false);
        }
        Switch switchR2 = (Switch) _$_findCachedViewById(i12);
        if (switchR2 != null) {
            switchR2.setClickable(false);
        }
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.CASH);
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        hideAddCard();
    }

    private final void setUpDisabledWalletView() {
        int i11 = R.id.payment_mode_string_switch;
        TextView textView = (TextView) _$_findCachedViewById(i11);
        if (textView != null) {
            textView.setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        }
        showCashPaymentMessage();
        TextView textView2 = (TextView) _$_findCachedViewById(i11);
        if (textView2 != null) {
            textView2.setAlpha(0.2f);
        }
        int i12 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i12);
        if (switchR != null) {
            switchR.setChecked(false);
        }
        Switch switchR2 = (Switch) _$_findCachedViewById(i12);
        if (switchR2 != null) {
            switchR2.setClickable(false);
        }
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.NONE);
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        hideAddCard();
    }

    private final void setUpOnlyCardPaymentModeView() {
        ((TextView) _$_findCachedViewById(R.id.payment_mode_string_switch)).setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        int i11 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i11);
        if (switchR != null) {
            switchR.setChecked(false);
        }
        Switch switchR2 = (Switch) _$_findCachedViewById(i11);
        if (switchR2 != null) {
            switchR2.setClickable(false);
        }
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.CARD);
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        showCardAmountToBeCharged();
        hideAddCard();
    }

    private final void setUpOnlyWallet() {
        int i11 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i11);
        if (switchR != null) {
            switchR.setChecked(true);
        }
        Switch switchR2 = (Switch) _$_findCachedViewById(i11);
        if (switchR2 != null) {
            switchR2.setClickable(false);
        }
        int i12 = R.id.payment_mode_string_switch;
        ((TextView) _$_findCachedViewById(i12)).setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        TextView textView = (TextView) _$_findCachedViewById(i12);
        if (textView != null) {
            textView.setAlpha(1.0f);
        }
        String string = getResources().getString(com.talabat.localization.R.string.no_amount_charged);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…string.no_amount_charged)");
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).showDefaultCardInformation(string);
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.WALLET);
        showNoChargeAmountMessage();
        hideAddCard();
    }

    private final void setUpSinglePaymentModeView() {
        PaymentMethod paymentMethod;
        int i11 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i11);
        if (switchR != null) {
            switchR.setClickable(true);
        }
        WalletPaymentWidgetDisplayModel value = ((WalletPaymentOptionViewModel) getViewModel()).getWalletWidgetConfigData().getValue();
        if (value != null) {
            paymentMethod = value.getSelectedPaymentMethod();
        } else {
            paymentMethod = null;
        }
        if (paymentMethod == PaymentMethod.CARD) {
            Switch switchR2 = (Switch) _$_findCachedViewById(i11);
            if (switchR2 != null) {
                switchR2.setChecked(false);
            }
            showCardAmountToBeCharged();
        } else {
            Switch switchR3 = (Switch) _$_findCachedViewById(i11);
            if (switchR3 != null) {
                switchR3.setChecked(true);
            }
            showNoChargeAmountMessage();
        }
        ((TextView) _$_findCachedViewById(R.id.payment_mode_string_switch)).setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        hideAddCard();
    }

    private final void setUpWalletWithAddCard() {
        int i11 = R.id.payment_choice_switch;
        Switch switchR = (Switch) _$_findCachedViewById(i11);
        if (switchR != null) {
            switchR.setChecked(false);
        }
        Switch switchR2 = (Switch) _$_findCachedViewById(i11);
        if (switchR2 != null) {
            switchR2.setClickable(false);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.payment_mode_string_switch);
        if (textView != null) {
            textView.setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        }
        showCardAmountToBeCharged();
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        hideAddCard();
    }

    private final void setupMixedPaymentModeView() {
        Switch switchR = (Switch) _$_findCachedViewById(R.id.payment_choice_switch);
        if (switchR != null) {
            switchR.setClickable(true);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.payment_mode_string_switch);
        if (textView != null) {
            textView.setText(ViewKt.getString(this, com.talabat.localization.R.string.use_balance_first));
        }
        showCardAmountToBeCharged();
        ((WalletPaymentOptionViewModel) getViewModel()).setPaymentMethod(PaymentMethod.MIXED);
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(0);
        hideAddCard();
    }

    private final void setupView() {
        ((Switch) _$_findCachedViewById(R.id.payment_choice_switch)).setOnCheckedChangeListener(new f(this));
        int i11 = R.id.card_container;
        ((TextView) ((DefaultCardView) _$_findCachedViewById(i11))._$_findCachedViewById(R.id.subtitle)).setTextSize(2, 12.0f);
        _$_findCachedViewById(R.id.add_new_card_view).setClickable(true);
        ((DefaultCardView) _$_findCachedViewById(i11))._$_findCachedViewById(R.id.no_card_view).setClickable(true);
        addAddCardListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-11  reason: not valid java name */
    public static final void m5816setupView$lambda11(WalletPaymentOptionView walletPaymentOptionView, CompoundButton compoundButton, boolean z11) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        if (((WalletPaymentOptionViewModel) walletPaymentOptionView.getViewModel()).getWalletBalanceData().getValue() != null) {
            float mAmount = ((WalletPaymentOptionViewModel) walletPaymentOptionView.getViewModel()).getMAmount();
            int i11 = R.id.card_container;
            ((WalletPaymentOptionViewModel) walletPaymentOptionView.getViewModel()).updatePaymentMethod(z11, mAmount, ((DefaultCardView) walletPaymentOptionView._$_findCachedViewById(i11)).getCardAvailabilityStatus(), ((DefaultCardView) walletPaymentOptionView._$_findCachedViewById(i11)).isCardSupported());
        }
    }

    private final void shouldHideWalletView() {
        if (!((WalletPaymentOptionViewModel) getViewModel()).isWalletEnabled()) {
            hideWalletView();
        }
    }

    private final void showAddCardDialog() {
        FragmentManager fragmentManager2;
        try {
            if (getContext() instanceof TalabatFlutterFragmentActivity) {
                Context context = getContext();
                if (context != null) {
                    fragmentManager2 = ((TalabatFlutterFragmentActivity) context).getSupportFragmentManager();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity");
                }
            } else {
                Context context2 = getContext();
                if (context2 != null) {
                    fragmentManager2 = ((AppCompatActivity) context2).getSupportFragmentManager();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
            }
            Intrinsics.checkNotNullExpressionValue(fragmentManager2, "if (context is TalabatFl…mentManager\n            }");
            AddCardNavigationUtility.INSTANCE.showAddCardDialogFragment(fragmentManager2, this, "walletPaymentBottomSheet");
        } catch (ClassCastException unused) {
            LogManager.error$default((Throwable) null, "Can't get fragment manager", 1, (Object) null);
        }
    }

    private final void showAddCardForCashOnly() {
        if (((DefaultCardView) _$_findCachedViewById(R.id.card_container)).isOnlyCashAvailable()) {
            showAddCardView();
        }
    }

    private final void showAddCardView() {
        _$_findCachedViewById(R.id.add_new_card_view).setVisibility(0);
    }

    private final void showCardAmountToBeCharged() {
        boolean z11;
        if (((WalletPaymentOptionViewModel) getViewModel()).getWalletWidgetDisplayViewModel().getAmountToBalanceFromCard() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            showNoChargeAmountMessage();
        } else {
            displayActualAmountToBeChargedFromCard();
        }
    }

    private final void showCashPaymentMessage() {
        String string = getResources().getString(com.talabat.localization.R.string.no_amount_to_pay);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.….string.no_amount_to_pay)");
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).showDefaultCardInformation(string);
    }

    private final void showNoChargeAmountMessage() {
        String string = getResources().getString(com.talabat.localization.R.string.no_amount_charged);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…string.no_amount_charged)");
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).showDefaultCardInformation(string);
    }

    private final void showWalletBalance() {
        Float f11;
        LocationConfigurationRepository locationConfigurationRepository = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
        WalletBalanceDisplayModel value = ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData().getValue();
        String str = null;
        if (value != null) {
            f11 = Float.valueOf(value.getWalletBalance());
        } else {
            f11 = null;
        }
        WalletBalanceDisplayModel value2 = ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData().getValue();
        if (value2 != null) {
            str = value2.getAmountCurrency();
        }
        SafeLetKt.safeLet(f11, str, new WalletPaymentOptionView$showWalletBalance$1(this, locationConfigurationRepository));
    }

    private final void topUpWallet(float f11, String str, WalletDebitRequestModel walletDebitRequestModel) {
        WalletCardDisplayModel selectedCard = ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).getSelectedCard();
        if (selectedCard != null) {
            ((WalletPaymentOptionViewModel) getViewModel()).topUpWallet(new WalletTopUpRequestModel(f11, IntegrationGlobalDataModel.Companion.selectedCountryCode(), selectedCard.getTokenId(), StringsKt___StringsKt.takeLast(selectedCard.getCardNumber(), 4), selectedCard.getCardType(), PaymentMethod.CARD.getValue(), IntKt.orZero(StringsKt__StringNumberConversionsKt.toIntOrNull(selectedCard.getBinNumber())), walletDebitRequestModel.getFeature(), str));
        }
    }

    private final void updateCardContainer(boolean z11) {
        int i11 = R.id.card_container;
        ((WalletPaymentOptionViewModel) getViewModel()).setCashEnabled(((DefaultCardView) _$_findCachedViewById(i11)).getCahEnabledStatus());
        ((WalletPaymentOptionViewModel) getViewModel()).walletPaymentMode(((WalletPaymentOptionViewModel) getViewModel()).getWalletBalance(), ((WalletPaymentOptionViewModel) getViewModel()).getMAmount(), ((DefaultCardView) _$_findCachedViewById(i11)).getCardLoadingStatus(), ((DefaultCardView) _$_findCachedViewById(i11)).getCardAvailabilityStatus(), ((WalletPaymentOptionViewModel) getViewModel()).isWalletEnabled(), ((DefaultCardView) _$_findCachedViewById(i11)).isCardSupported());
    }

    private final void updateCashMessage(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            showCashPaymentMessage();
        }
    }

    private final void updatePaymentStatus(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        if (walletPaymentDisplayModel != null && !this.isUpdatePaymentStatusShown) {
            int i11 = WhenMappings.$EnumSwitchMapping$2[walletPaymentDisplayModel.getWalletTransactionStatus().ordinal()];
            if (i11 == 1) {
                onTopUpFailure(walletPaymentDisplayModel.getErrorMessage(), walletPaymentDisplayModel.getWalletTransactionId());
            } else if (i11 == 2) {
                onTopUpSuccessWithoutThreeDs(walletPaymentDisplayModel.getWalletTransactionId());
            } else if (i11 != 3) {
                LogManager.debug("unexpected transaction type");
            } else {
                redirectToThreeDsScreen$default(this, walletPaymentDisplayModel.getRedirectUrl(), walletPaymentDisplayModel.getWalletTransactionId(), this.fragmentManager, false, this.shouldIgnoreTopUpVerification, 8, (Object) null);
            }
            this.isUpdatePaymentStatusShown = true;
        }
    }

    private final void updatePaymentViewType(WalletPaymentOptionViewModel.PaymentOptionViewType paymentOptionViewType) {
        ((LinearLayout) _$_findCachedViewById(R.id.payment_view)).setVisibility(0);
        switch (WhenMappings.$EnumSwitchMapping$0[paymentOptionViewType.ordinal()]) {
            case 1:
                setUpOnlyCardPaymentModeView();
                break;
            case 2:
                setupMixedPaymentModeView();
                break;
            case 3:
                setUpSinglePaymentModeView();
                break;
            case 4:
                setUpOnlyWallet();
                break;
            case 5:
                setUpCashView();
                break;
            case 6:
                setUpCashWithDisabledWallet();
                break;
            case 7:
                setUpDisabledWalletView();
                break;
            default:
                LogManager.debug("unsupported view type");
                break;
        }
        showAddCardForCashOnly();
        shouldHideWalletView();
        showWalletBalance();
    }

    private final void updateTopUpMessage(boolean z11) {
        if (z11) {
            showCardAmountToBeCharged();
        } else {
            showNoChargeAmountMessage();
        }
    }

    private final void updateWalletBalance(WalletBalanceDisplayModel walletBalanceDisplayModel) {
        if (walletBalanceDisplayModel != null) {
            walletBalanceDisplayModel.getWalletBalance();
            float walletBalance = ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalance();
            float mAmount = ((WalletPaymentOptionViewModel) getViewModel()).getMAmount();
            int i11 = R.id.card_container;
            ((WalletPaymentOptionViewModel) getViewModel()).walletPaymentMode(walletBalance, mAmount, ((DefaultCardView) _$_findCachedViewById(i11)).getCardLoadingStatus(), ((DefaultCardView) _$_findCachedViewById(i11)).getCardAvailabilityStatus(), ((WalletPaymentOptionViewModel) getViewModel()).isWalletEnabled(), ((DefaultCardView) _$_findCachedViewById(i11)).isCardSupported());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: walletBalanceDataObserver$lambda-1  reason: not valid java name */
    public static final void m5817walletBalanceDataObserver$lambda1(WalletPaymentOptionView walletPaymentOptionView, WalletBalanceDisplayModel walletBalanceDisplayModel) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.updateWalletBalance(walletBalanceDisplayModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: walletDebitDataObserver$lambda-4  reason: not valid java name */
    public static final void m5818walletDebitDataObserver$lambda4(WalletPaymentDisplayModel walletPaymentDisplayModel) {
    }

    /* access modifiers changed from: private */
    /* renamed from: walletTopUpDataObserver$lambda-0  reason: not valid java name */
    public static final void m5819walletTopUpDataObserver$lambda0(WalletPaymentOptionView walletPaymentOptionView, WalletPaymentDisplayModel walletPaymentDisplayModel) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.updatePaymentStatus(walletPaymentDisplayModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: walletWidgetConfigDataObserver$lambda-2  reason: not valid java name */
    public static final void m5820walletWidgetConfigDataObserver$lambda2(WalletPaymentOptionView walletPaymentOptionView, WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        Intrinsics.checkNotNullParameter(walletPaymentOptionView, "this$0");
        walletPaymentOptionView.updateTopUpMessage(walletPaymentWidgetDisplayModel.getShouldShowCardTopUpMessage());
        walletPaymentOptionView.updateCashMessage(Boolean.valueOf(walletPaymentWidgetDisplayModel.getShouldShowCashToPayMessage()));
        walletPaymentOptionView.updatePaymentViewType(walletPaymentWidgetDisplayModel.getDisplayViewType());
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

    public final void addDefaultCard() {
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).addDefaultCard();
    }

    public final void addPaymentMethodView(@Nullable Float f11, boolean z11, boolean z12, boolean z13) {
        if (f11 != null) {
            float floatValue = f11.floatValue();
            ((WalletPaymentOptionViewModel) getViewModel()).setWalletEnabled(z13);
            int i11 = R.id.card_container;
            ((CardViewWidgetsViewModel) ((DefaultCardView) _$_findCachedViewById(i11)).getViewModel()).setCardEnabledFromParent(z11);
            ((CardViewWidgetsViewModel) ((DefaultCardView) _$_findCachedViewById(i11)).getViewModel()).setCashEnabledFromParent(z12);
            ((WalletPaymentOptionViewModel) getViewModel()).setMAmount(floatValue);
            ((DefaultCardView) _$_findCachedViewById(i11)).addDefaultCard();
            WalletPaymentOptionViewModel.getWalletBalance$default((WalletPaymentOptionViewModel) getViewModel(), 0, 1, (Object) null);
        }
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public final void disAblePaymentButton() {
        ((WalletPaymentOptionViewModel) getViewModel()).disAblePaymentButton();
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    public final boolean getCardAvailabilityStatus() {
        return ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).getCardAvailabilityStatus();
    }

    public final void getCardList() {
        CardViewWidgetsViewModel.getCardList$default((CardViewWidgetsViewModel) ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).getViewModel(), 0, 0, 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<Boolean> getCardLoadingStatus() {
        return ((CardViewWidgetsViewModel) ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).getViewModel()).getLoadingCardStatus();
    }

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.styleable.WalletPaymentOptionView;
        Intrinsics.checkNotNullExpressionValue(iArr, "WalletPaymentOptionView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.useMarshmallowLayout = obtainStyledAttributes.getBoolean(R.styleable.WalletPaymentOptionView_useMarshmallowLayout, false);
        obtainStyledAttributes.recycle();
        if (this.useMarshmallowLayout) {
            return R.layout.view_wallet_payment_option_marshmallow;
        }
        return R.layout.view_wallet_payment_option;
    }

    public final boolean getPaymentButtonStatus() {
        return BooleanKt.orFalse(((WalletPaymentOptionViewModel) getViewModel()).getShouldEnablePaymentButton().getValue());
    }

    @NotNull
    public final MutableLiveData<WalletCardDisplayModel> getSelectedCard() {
        return ((CardViewWidgetsViewModel) ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).getViewModel()).getSelectedCard();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getSelectedPaymentMethod();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod getSelectedPaymentMethod() {
        /*
            r1 = this;
            com.talabat.talabatcore.viewmodel.BaseViewModel r0 = r1.getViewModel()
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel r0 = (com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel) r0
            androidx.lifecycle.MutableLiveData r0 = r0.getWalletWidgetConfigData()
            java.lang.Object r0 = r0.getValue()
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel r0 = (com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel) r0
            if (r0 == 0) goto L_0x0018
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r0 = r0.getSelectedPaymentMethod()
            if (r0 != 0) goto L_0x001a
        L_0x0018:
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r0 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.NONE
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView.getSelectedPaymentMethod():com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod");
    }

    @Nullable
    public final Integer getSelectedPosition() {
        CardViewWidgetsViewModel cardViewWidgetsViewModel;
        MutableLiveData<WalletCardListDisplayModel> walletCardListData;
        WalletCardListDisplayModel value;
        DefaultCardView defaultCardView = (DefaultCardView) _$_findCachedViewById(R.id.card_container);
        if (defaultCardView == null || (cardViewWidgetsViewModel = (CardViewWidgetsViewModel) defaultCardView.getViewModel()) == null || (walletCardListData = cardViewWidgetsViewModel.getWalletCardListData()) == null || (value = walletCardListData.getValue()) == null) {
            return null;
        }
        return Integer.valueOf(value.getSelectedPosition());
    }

    @NotNull
    public Class<WalletPaymentOptionViewModel> getViewModelClass() {
        return WalletPaymentOptionViewModel.class;
    }

    public final void hideCardContainer() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.card_payment_container)).setVisibility(8);
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        setupView();
        addWalletBalanceObserver(lifecycleOwner);
        addCardObservers(lifecycleOwner);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletWidgetConfigData().observe(lifecycleOwner, this.walletWidgetConfigDataObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletTopUpData().observe(lifecycleOwner, this.walletTopUpDataObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getFailureData().observe(lifecycleOwner, this.failureObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletDebitData().observe(lifecycleOwner, this.walletDebitDataObserver);
    }

    public void onAddCardSuccess() {
        getCardList();
    }

    public void onBottomSheetTopUpFailure() {
        ((WalletPaymentOptionViewModel) getViewModel()).updateThreeDSVerificationForBottomSheet(false);
    }

    public void onBottomSheetTopUpSuccessful() {
        ((WalletPaymentOptionViewModel) getViewModel()).updateThreeDSVerificationForBottomSheet(true);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletTopUpData().removeObserver(this.walletTopUpDataObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletWidgetConfigData().removeObserver(this.walletWidgetConfigDataObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletDebitData().removeObserver(this.walletDebitDataObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getFailureData().removeObserver(this.failureObserver);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData().removeObserver(this.walletBalanceDataObserver);
    }

    public void onDialogBackPressed() {
        enablePaymentButton();
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
    }

    public void onTopUpSuccessful() {
        this.isUpdatePaymentStatusShown = true;
        debitWallet(((WalletPaymentOptionViewModel) getViewModel()).getWalletTransactionId());
    }

    public final void payAmountThroughWallet(@Nullable FragmentManager fragmentManager2, @NotNull WalletDebitRequestModel walletDebitRequestModel, boolean z11) {
        Intrinsics.checkNotNullParameter(walletDebitRequestModel, "walletDebitRequestModel");
        this.isUpdatePaymentStatusShown = false;
        this.fragmentManager = fragmentManager2;
        this.shouldIgnoreTopUpVerification = z11;
        ((WalletPaymentOptionViewModel) getViewModel()).setWalletDebitRequestModel(walletDebitRequestModel);
        int i11 = WhenMappings.$EnumSwitchMapping$1[getSelectedPaymentMethod().ordinal()];
        if (i11 == 1) {
            topUpWallet(walletDebitRequestModel.getAmount(), walletDebitRequestModel.getRequestorTransactionId(), walletDebitRequestModel);
        } else if (i11 == 2) {
            topUpWallet(walletDebitRequestModel.getAmount() - ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalance(), walletDebitRequestModel.getRequestorTransactionId(), walletDebitRequestModel);
        } else if (i11 != 3) {
            LogManager.debug("unsupported payment method");
        } else {
            payThroughWalletWithoutTopUp(walletDebitRequestModel.getAmount());
        }
    }

    public final void redirectToThreeDsScreen(@NotNull String str, @NotNull String str2, @Nullable FragmentManager fragmentManager2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "redirectUrl");
        Intrinsics.checkNotNullParameter(str2, "walletTransactionId");
        this.isUpdatePaymentStatusShown = true;
        WalletPaymentThreeDsDialogFragment walletPaymentThreeDsDialogFragment = new WalletPaymentThreeDsDialogFragment(this);
        Bundle bundle = new Bundle();
        bundle.putString(WalletNavigatorActions.WALLET_THREE_DS_URL_KEY, str);
        bundle.putBoolean(WalletNavigatorActions.EXTRA_IS_TOP_UP_FROM_DIALOG_FRAGMENT, true);
        bundle.putString("transactionId", str2);
        bundle.putBoolean(WalletNavigatorActions.EXTRA_IS_PAYMENT_NAVIGATION_FROM_BOTTOM_SHEET, z11);
        bundle.putBoolean(WalletNavigatorActions.EXTRA_SHOULD_IGNORE_TOP_UP_VERIFICATION, z12);
        walletPaymentThreeDsDialogFragment.setArguments(bundle);
        ((WalletPaymentOptionViewModel) getViewModel()).setWalletTransactionId(str2);
        if (fragmentManager2 != null) {
            walletPaymentThreeDsDialogFragment.show(fragmentManager2, "");
        }
    }

    public final void resetObservers() {
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletDebitData().setValue(null);
        ((WalletPaymentOptionViewModel) getViewModel()).getWalletTopUpData().setValue(null);
        ((WalletPaymentOptionViewModel) getViewModel()).getFailureData().setValue(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r0.getViewModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void resetSelectedPosition() {
        /*
            r2 = this;
            int r0 = com.talabat.talabatcommon.R.id.card_container
            android.view.View r0 = r2._$_findCachedViewById(r0)
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r0 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView) r0
            r1 = 0
            if (r0 == 0) goto L_0x0018
            com.talabat.talabatcore.viewmodel.BaseViewModel r0 = r0.getViewModel()
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel r0 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r0
            if (r0 == 0) goto L_0x0018
            androidx.lifecycle.MutableLiveData r0 = r0.getWalletCardListData()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            if (r0 != 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            r0.setValue(r1)
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView.resetSelectedPosition():void");
    }

    public final void setAddCardListener(@Nullable AddCardInterface addCardInterface) {
        this.addCardListener = addCardInterface;
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setDefaultCardViewBottomScreenListener(@Nullable DefaultCardView.DefaultCardViewBottomScreenInterface defaultCardViewBottomScreenInterface, boolean z11, boolean z12) {
        DefaultCardView defaultCardView = (DefaultCardView) _$_findCachedViewById(R.id.card_container);
        Intrinsics.checkNotNullExpressionValue(defaultCardView, "card_container");
        DefaultCardView.setDefaultCardViewBottomScreenListener$default(defaultCardView, defaultCardViewBottomScreenInterface, z11, z12, false, 8, (Object) null);
    }

    public final void setDefaultCardViewFullScreenListener(@Nullable DefaultCardView.DefaultCardViewFullScreenInterface defaultCardViewFullScreenInterface, boolean z11, boolean z12) {
        DefaultCardView defaultCardView = (DefaultCardView) _$_findCachedViewById(R.id.card_container);
        Intrinsics.checkNotNullExpressionValue(defaultCardView, "card_container");
        DefaultCardView.setDefaultCardViewFullScreenListener$default(defaultCardView, defaultCardViewFullScreenInterface, z11, z12, false, 8, (Object) null);
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
    }

    public final void setSelectedCard(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "cardModel");
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).setSelectedCard(walletCardDisplayModel);
    }

    public final void updateAmount(float f11) {
        try {
            ((WalletPaymentOptionViewModel) getViewModel()).setMAmount(f11);
            boolean isChecked = ((Switch) _$_findCachedViewById(R.id.payment_choice_switch)).isChecked();
            if (((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData().getValue() != null) {
                float walletBalance = ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalance();
                float mAmount = ((WalletPaymentOptionViewModel) getViewModel()).getMAmount();
                int i11 = R.id.card_container;
                ((WalletPaymentOptionViewModel) getViewModel()).walletPaymentMode(walletBalance, mAmount, ((DefaultCardView) _$_findCachedViewById(i11)).getCardLoadingStatus(), ((DefaultCardView) _$_findCachedViewById(i11)).getCardAvailabilityStatus(), ((WalletPaymentOptionViewModel) getViewModel()).isWalletEnabled(), ((DefaultCardView) _$_findCachedViewById(i11)).isCardSupported());
                ((WalletPaymentOptionViewModel) getViewModel()).updatePaymentMethod(isChecked, ((WalletPaymentOptionViewModel) getViewModel()).getMAmount(), ((DefaultCardView) _$_findCachedViewById(i11)).getCardAvailabilityStatus(), ((DefaultCardView) _$_findCachedViewById(i11)).isCardSupported());
            }
        } catch (Exception e11) {
            getClassName();
            e11.getLocalizedMessage();
        }
    }

    public final void updateClickedPositionData(int i11) {
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).updateClickedPositionData(i11);
    }

    public final void updateWalletCardListData(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((DefaultCardView) _$_findCachedViewById(R.id.card_container)).updateWalletCardList(walletCardListDisplayModel);
    }

    @NotNull
    public WalletPaymentOptionViewModel viewModelBuilder() {
        WalletPaymentOptionViewModelBuilder.Companion companion = WalletPaymentOptionViewModelBuilder.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getWalletPaymentOptionViewModel(context, getCoroutineScope());
    }

    public void onTopUpFailure() {
        this.isUpdatePaymentStatusShown = true;
        WalletPaymentOptionViewModel.setFailureMessage$default((WalletPaymentOptionViewModel) getViewModel(), (String) null, ViewKt.getString(this, com.talabat.localization.R.string.failure_server_error), 1, (Object) null);
    }
}
