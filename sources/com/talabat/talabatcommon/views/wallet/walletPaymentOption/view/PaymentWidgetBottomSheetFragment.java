package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import bw.a;
import bw.b;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.paymentBottonSheet.PaymentBottomSheetViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.paymentBottonSheet.PaymentBottomSheetViewModelBuilder;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001GB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\u0012\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u001a\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0006\u00101\u001a\u00020\u0010J\b\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\nH\u0002J\u000e\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00102\u0006\u00104\u001a\u00020\nH\u0002J\u0012\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u001fH\u0002J\u0017\u0010<\u001a\u00020\u00102\b\u0010=\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020>H\u0002J\u0017\u0010B\u001a\u00020\u00102\b\u0010C\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010?J\u0010\u0010D\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010*J\b\u0010F\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006H"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheetFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/paymentBottonSheet/PaymentBottomSheetViewModel;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentOptionView$AddCardInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewBottomScreenInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "mPaymentWidgetBottomSheetFragmentInterface", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheetFragment$PaymentWidgetBottomSheetFragmentInterface;", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheetFragment$PaymentWidgetBottomSheetFragmentInterface;)V", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;", "getPaymentStatus", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;", "setPaymentStatus", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;)V", "addPaymentAction", "", "displayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "addPaymentListener", "addWalletPaymentWidget", "addWalletPaymentWidgetListeners", "disableSubscriptionButton", "enableSubscriptionButton", "extractBundleToViewModel", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "makePayment", "navigateToAddCard", "navigateToThreeDS", "url", "", "transactionId", "observatory", "onAddCardClicked", "onChangeClickedInBottomSheet", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "resetCardPosition", "sendCardDetailsToBottomSheet", "showFailureUpdate", "paymentStatusModel", "showPaymentStatus", "showSuccessUpdates", "updateButton", "walletPaymentWidgetDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentWidgetDisplayModel;", "updateDefaultCard", "selectedPosition", "updatePaymentBottomSheetUI", "isCardViewLoaded", "", "(Ljava/lang/Boolean;)V", "updateSubscriptionButton", "shouldEnablePaymentButton", "updateThreeDSVerificationStatus", "isVerificationSuccessful", "updateWalletCardList", "walletCardListDisplayModel", "viewModelBuilder", "PaymentWidgetBottomSheetFragmentInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentWidgetBottomSheetFragment extends BaseFragment implements WalletPaymentOptionView.AddCardInterface, DefaultCardView.DefaultCardViewBottomScreenInterface, AnimationHelper {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final PaymentWidgetBottomSheetFragmentInterface mPaymentWidgetBottomSheetFragmentInterface;
    @NotNull
    private BottomSheetPaymentStatusModel paymentStatus;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheetFragment$PaymentWidgetBottomSheetFragmentInterface;", "", "attachCardList", "", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "viewHeight", "", "attachSuccessScreen", "hideCardViewHeight", "", "title", "", "description", "closeBottomSheet", "getCardClicked", "networkFailure", "sendCardDetails", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface PaymentWidgetBottomSheetFragmentInterface {
        void attachCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, int i11);

        void attachSuccessScreen(boolean z11, @NotNull String str, @NotNull String str2);

        void closeBottomSheet();

        void getCardClicked();

        void networkFailure();

        void sendCardDetails(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[WalletBottomSheetPaymentMode.values().length];
            iArr[WalletBottomSheetPaymentMode.CARDDETAIL.ordinal()] = 1;
            iArr[WalletBottomSheetPaymentMode.PAYMENT.ordinal()] = 2;
            iArr[WalletBottomSheetPaymentMode.THREEDS.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WalletPaymentStatus.values().length];
            iArr2[WalletPaymentStatus.SUCCESS.ordinal()] = 1;
            iArr2[WalletPaymentStatus.FAILURE.ordinal()] = 2;
            iArr2[WalletPaymentStatus.THREE_DS.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public PaymentWidgetBottomSheetFragment(@NotNull PaymentWidgetBottomSheetFragmentInterface paymentWidgetBottomSheetFragmentInterface) {
        Intrinsics.checkNotNullParameter(paymentWidgetBottomSheetFragmentInterface, "mPaymentWidgetBottomSheetFragmentInterface");
        this.mPaymentWidgetBottomSheetFragmentInterface = paymentWidgetBottomSheetFragmentInterface;
        this.paymentStatus = new BottomSheetPaymentStatusModel((WalletPaymentStatus) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    private final void addPaymentAction(PaymentInfoDisplayModel paymentInfoDisplayModel) {
        showProgress();
        int i11 = WhenMappings.$EnumSwitchMapping$0[paymentInfoDisplayModel.getMode().ordinal()];
        if (i11 == 1) {
            this.mPaymentWidgetBottomSheetFragmentInterface.getCardClicked();
            sendCardDetailsToBottomSheet();
        } else if (i11 == 2) {
            makePayment();
        } else if (i11 != 3) {
            LogManager.debug("unsupported mode");
        } else {
            navigateToThreeDS(paymentInfoDisplayModel.getThreeDSUrl(), paymentInfoDisplayModel.getTransactionId());
        }
    }

    private final void addPaymentListener() {
        ((LinearLayout) _$_findCachedViewById(R.id.action_button)).setOnClickListener(new a(this));
        ((ImageButton) _$_findCachedViewById(R.id.cancel_subscription_button)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addPaymentListener$lambda-0  reason: not valid java name */
    public static final void m5808addPaymentListener$lambda0(PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(paymentWidgetBottomSheetFragment, "this$0");
        paymentWidgetBottomSheetFragment.addPaymentAction(((PaymentBottomSheetViewModel) paymentWidgetBottomSheetFragment.getViewModel()).getPaymentInfoDisplayModel());
    }

    /* access modifiers changed from: private */
    /* renamed from: addPaymentListener$lambda-1  reason: not valid java name */
    public static final void m5809addPaymentListener$lambda1(PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(paymentWidgetBottomSheetFragment, "this$0");
        paymentWidgetBottomSheetFragment.mPaymentWidgetBottomSheetFragmentInterface.closeBottomSheet();
    }

    private final void addWalletPaymentWidget() {
        WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget);
        Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "wallet_payment_widget");
        WalletPaymentOptionView.addPaymentMethodView$default(walletPaymentOptionView, Float.valueOf(((PaymentBottomSheetViewModel) getViewModel()).getPaymentInfoDisplayModel().getPlanAmount()), false, false, false, 6, (Object) null);
    }

    private final void addWalletPaymentWidgetListeners() {
        WalletCardListDisplayModel walletCardListDisplayModel;
        int i11;
        int i12 = R.id.wallet_payment_widget;
        WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(walletPaymentOptionView, "wallet_payment_widget");
        WalletPaymentOptionView.setDefaultCardViewBottomScreenListener$default(walletPaymentOptionView, this, true, false, 4, (Object) null);
        ((WalletPaymentOptionView) _$_findCachedViewById(i12)).setAddCardListener(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            walletCardListDisplayModel = (WalletCardListDisplayModel) arguments.getParcelable(WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST);
        } else {
            walletCardListDisplayModel = null;
        }
        updateWalletCardList(walletCardListDisplayModel);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i11 = arguments2.getInt(CardListFragment.SELECTED_POSITION);
        } else {
            i11 = 0;
        }
        updateDefaultCard(i11);
    }

    private final void disableSubscriptionButton() {
        int i11 = R.id.action_button;
        ((LinearLayout) _$_findCachedViewById(i11)).setEnabled(false);
        ((LinearLayout) _$_findCachedViewById(i11)).setAlpha(0.5f);
    }

    private final void enableSubscriptionButton() {
        int i11 = R.id.action_button;
        ((LinearLayout) _$_findCachedViewById(i11)).setEnabled(true);
        ((LinearLayout) _$_findCachedViewById(i11)).setAlpha(1.0f);
        hideProgress();
    }

    private final void extractBundleToViewModel() {
        PaymentInfoDisplayModel paymentInfoDisplayModel;
        PaymentBottomSheetViewModel paymentBottomSheetViewModel = (PaymentBottomSheetViewModel) getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            paymentInfoDisplayModel = (PaymentInfoDisplayModel) arguments.getParcelable(TalabatCommonNavigationActions.EXTRA_BOTTOM_SHEET_DISPLAY_MODEL);
        } else {
            paymentInfoDisplayModel = null;
        }
        if (paymentInfoDisplayModel == null) {
            paymentInfoDisplayModel = new PaymentInfoDisplayModel((String) null, (String) null, (String) null, 0, false, (String) null, (String) null, 0.0f, (WalletBottomSheetPaymentMode) null, (String) null, (String) null, (WalletPaymentFeature) null, (String) null, false, (String) null, 0.0f, (String) null, 131071, (DefaultConstructorMarker) null);
        }
        paymentBottomSheetViewModel.setPaymentInfoDisplayModel(paymentInfoDisplayModel);
    }

    private final void makePayment() {
        FragmentManager fragmentManager = getFragmentManager();
        WalletDebitRequestModel walletDebitRequestModel = r3;
        WalletDebitRequestModel walletDebitRequestModel2 = new WalletDebitRequestModel(0.0f, (Integer) null, 0, 0, 0, (String) null, (String) null, 0, (String) null, 0, (String) null, 2047, (DefaultConstructorMarker) null);
        WalletDebitRequestModel walletDebitRequestModel3 = walletDebitRequestModel;
        ((WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget)).payAmountThroughWallet(fragmentManager, walletDebitRequestModel3, ((PaymentBottomSheetViewModel) getViewModel()).getPaymentInfoDisplayModel().getShouldIgnoreTopUpVerification());
    }

    private final void navigateToAddCard() {
        WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget);
        if (walletPaymentOptionView != null) {
            walletPaymentOptionView.resetSelectedPosition();
        }
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, TalabatCommonNavigationActions.Companion.createNavigationToWalletAddCard("walletPaymentBottomSheet"));
        }
    }

    private final void navigateToThreeDS(String str, String str2) {
        ((WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget)).redirectToThreeDsScreen(str, str2, getFragmentManager(), true, ((PaymentBottomSheetViewModel) getViewModel()).getPaymentInfoDisplayModel().getShouldIgnoreTopUpVerification());
    }

    private final void sendCardDetailsToBottomSheet() {
        disableSubscriptionButton();
        WalletCardDisplayModel selectedCard = ((DefaultCardView) ((WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget))._$_findCachedViewById(R.id.card_container)).getSelectedCard();
        if (selectedCard != null) {
            this.mPaymentWidgetBottomSheetFragmentInterface.sendCardDetails(selectedCard, PaymentMethod.CARD);
        }
    }

    private final void showFailureUpdate(BottomSheetPaymentStatusModel bottomSheetPaymentStatusModel) {
        String string = getString(com.talabat.localization.R.string.failure_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.failure_server_error)");
        Status.Companion.notify$default(Status.Companion, getActivity(), (LinearLayout) _$_findCachedViewById(R.id.errorNotifyLinearLayout), string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
        enableSubscriptionButton();
    }

    private final void showSuccessUpdates(BottomSheetPaymentStatusModel bottomSheetPaymentStatusModel) {
        this.mPaymentWidgetBottomSheetFragmentInterface.attachSuccessScreen(false, bottomSheetPaymentStatusModel.getTitle(), bottomSheetPaymentStatusModel.getDescription());
    }

    /* access modifiers changed from: private */
    public final void updateButton(WalletPaymentWidgetDisplayModel walletPaymentWidgetDisplayModel) {
        if (walletPaymentWidgetDisplayModel != null) {
            updateSubscriptionButton(walletPaymentWidgetDisplayModel.getShouldEnablePaymentButton());
        }
    }

    private final void updateDefaultCard(int i11) {
        ((WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget)).updateClickedPositionData(i11);
    }

    /* access modifiers changed from: private */
    public final void updatePaymentBottomSheetUI(Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
            hideProgress();
            ((ConstraintLayout) _$_findCachedViewById(R.id.subscription_view_container)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.subscription_amount_text)).setText(((PaymentBottomSheetViewModel) getViewModel()).getPaymentInfoDisplayModel().getPlanTitle());
            ((TextView) _$_findCachedViewById(R.id.action_button_text)).setText(((PaymentBottomSheetViewModel) getViewModel()).getPaymentInfoDisplayModel().getActionText());
            ((TextView) _$_findCachedViewById(R.id.next_charge_date_header)).setText(((PaymentBottomSheetViewModel) getViewModel()).getPaymentInfoDisplayModel().getDescription());
        }
    }

    private final void updateSubscriptionButton(boolean z11) {
        if (z11) {
            enableSubscriptionButton();
        } else {
            disableSubscriptionButton();
        }
    }

    /* access modifiers changed from: private */
    public final void updateThreeDSVerificationStatus(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            showSuccessUpdates(this.paymentStatus);
        } else if (Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE)) {
            showFailureUpdate(this.paymentStatus);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public final BottomSheetPaymentStatusModel getPaymentStatus() {
        return this.paymentStatus;
    }

    @NotNull
    public Class<PaymentBottomSheetViewModel> getViewModelClass() {
        return PaymentBottomSheetViewModel.class;
    }

    public int layoutId() {
        return R.layout.fragment_payment_widget_bottom_sheet;
    }

    public void observatory() {
        int i11 = R.id.wallet_payment_widget;
        LifecycleKt.observe(this, ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getCardLoadingStatus(), new PaymentWidgetBottomSheetFragment$observatory$1(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getViewModel()).getWalletWidgetConfigData(), new PaymentWidgetBottomSheetFragment$observatory$2(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getViewModel()).getWalletThreeDSValidationData(), new PaymentWidgetBottomSheetFragment$observatory$3(this));
    }

    public void onAddCardClicked() {
        navigateToAddCard();
    }

    public void onChangeClickedInBottomSheet(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        this.mPaymentWidgetBottomSheetFragmentInterface.attachCardList(walletCardListDisplayModel, ((ConstraintLayout) _$_findCachedViewById(R.id.container)).getHeight());
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        int i11 = R.id.wallet_payment_widget;
        if (((WalletPaymentOptionView) _$_findCachedViewById(i11)).getSelectedPosition() == null) {
            ((WalletPaymentOptionView) _$_findCachedViewById(i11)).getCardList();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        showProgress();
        int i11 = R.id.striked_amount;
        ((TextView) _$_findCachedViewById(i11)).setPaintFlags(((TextView) _$_findCachedViewById(i11)).getPaintFlags() | 16);
        addWalletPaymentWidgetListeners();
        extractBundleToViewModel();
        addPaymentListener();
        if (((WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget)).getSelectedPosition() == null) {
            addWalletPaymentWidget();
        }
    }

    public final void resetCardPosition() {
        WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget);
        if (walletPaymentOptionView != null) {
            walletPaymentOptionView.resetSelectedPosition();
        }
    }

    public final void setPaymentStatus(@NotNull BottomSheetPaymentStatusModel bottomSheetPaymentStatusModel) {
        Intrinsics.checkNotNullParameter(bottomSheetPaymentStatusModel, "<set-?>");
        this.paymentStatus = bottomSheetPaymentStatusModel;
    }

    public final void showPaymentStatus(@NotNull BottomSheetPaymentStatusModel bottomSheetPaymentStatusModel) {
        Intrinsics.checkNotNullParameter(bottomSheetPaymentStatusModel, "paymentStatusModel");
        this.paymentStatus = bottomSheetPaymentStatusModel;
        int i11 = WhenMappings.$EnumSwitchMapping$1[bottomSheetPaymentStatusModel.getPaymentStatus().ordinal()];
        if (i11 == 1) {
            showSuccessUpdates(bottomSheetPaymentStatusModel);
            LogManager.debug("success from flutter");
        } else if (i11 == 2) {
            showFailureUpdate(bottomSheetPaymentStatusModel);
            LogManager.debug("failure from flutter");
        } else if (i11 != 3) {
            LogManager.debug("unsupported mode");
        } else {
            navigateToThreeDS(bottomSheetPaymentStatusModel.getThreeDSUrl(), bottomSheetPaymentStatusModel.getTransactionId());
        }
    }

    public final void updateWalletCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        ((WalletPaymentOptionView) _$_findCachedViewById(R.id.wallet_payment_widget)).updateWalletCardListData(walletCardListDisplayModel);
    }

    @NotNull
    public PaymentBottomSheetViewModel viewModelBuilder() {
        PaymentBottomSheetViewModelBuilder.Companion companion = PaymentBottomSheetViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getPaymentBottomSheetViewModel(requireContext, getCoroutineScope());
    }
}
