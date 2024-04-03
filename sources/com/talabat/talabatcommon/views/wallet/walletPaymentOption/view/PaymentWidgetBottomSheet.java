package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.compose.DialogNavigator;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.exoplayer2.C;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragment;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202J\u001a\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u001cH\u0002J\u0018\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\u000e\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheetFragment$PaymentWidgetBottomSheetFragmentInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "model", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "mPaymentBottomSheetInterface", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;)V", "isPaymentFragmentAttached", "", "mSubscriptionPaymentFragment", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheetFragment;", "selectedPosition", "", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "addSubscriptionBundle", "Landroid/os/Bundle;", "attachCardList", "", "cardListData", "viewHeight", "attachSuccessScreen", "hideCardViewHeight", "title", "", "description", "attachToFragment", "closeBottomSheet", "closeBottomSheetFromDialog", "getCardClicked", "networkFailure", "onBackButtonClicked", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "openBottomSheet", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "paymentWidgetClosed", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "transactionId", "sendCardDetails", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "updatePaymentStatus", "bottomSheetPaymentStatusModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;", "updatePositionClicked", "position", "updateWalletCardList", "walletCardListDisplayModel", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentWidgetBottomSheet extends TalabatBaseBottomSheetDialogFragment implements AnimationHelper, PaymentWidgetBottomSheetFragment.PaymentWidgetBottomSheetFragmentInterface, CardListBottomSheet.CardListBottomSheetInterface, CardListFragment.CardListFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean isPaymentFragmentAttached;
    @NotNull
    private final PaymentBottomSheetInterface mPaymentBottomSheetInterface;
    @Nullable
    private PaymentWidgetBottomSheetFragment mSubscriptionPaymentFragment;
    @NotNull
    private final PaymentInfoDisplayModel model;
    private int selectedPosition;
    @NotNull
    private WalletCardListDisplayModel walletCardList;

    public PaymentWidgetBottomSheet(@NotNull PaymentInfoDisplayModel paymentInfoDisplayModel, @NotNull PaymentBottomSheetInterface paymentBottomSheetInterface) {
        Intrinsics.checkNotNullParameter(paymentInfoDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(paymentBottomSheetInterface, "mPaymentBottomSheetInterface");
        this.model = paymentInfoDisplayModel;
        this.mPaymentBottomSheetInterface = paymentBottomSheetInterface;
        this.walletCardList = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);
    }

    private final Bundle addSubscriptionBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TalabatCommonNavigationActions.EXTRA_BOTTOM_SHEET_DISPLAY_MODEL, this.model);
        return bundle;
    }

    private final void attachToFragment() {
        this.mSubscriptionPaymentFragment = new PaymentWidgetBottomSheetFragment(this);
        Bundle addSubscriptionBundle = addSubscriptionBundle();
        PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment = this.mSubscriptionPaymentFragment;
        if (paymentWidgetBottomSheetFragment != null) {
            paymentWidgetBottomSheetFragment.setArguments(addSubscriptionBundle);
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment2 = this.mSubscriptionPaymentFragment;
        if (paymentWidgetBottomSheetFragment2 != null) {
            beginTransaction.replace(R.id.child_fragment_container, paymentWidgetBottomSheetFragment2).commit();
        }
        this.isPaymentFragmentAttached = true;
    }

    public static /* synthetic */ void b(PaymentWidgetBottomSheet paymentWidgetBottomSheet, WalletPaymentStatus walletPaymentStatus, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = StringUtils.empty(StringCompanionObject.INSTANCE);
        }
        paymentWidgetBottomSheet.paymentWidgetClosed(walletPaymentStatus, str);
    }

    /* access modifiers changed from: private */
    public final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.container_all;
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "it.container_all");
            adjustViewHeight(linearLayout, ((LinearLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            delay(500, new PaymentWidgetBottomSheet$closeBottomSheetFromDialog$1$1(dialog));
        }
    }

    private final void paymentWidgetClosed(WalletPaymentStatus walletPaymentStatus, String str) {
        this.mPaymentBottomSheetInterface.sendPaymentWidgetClosedEvent(walletPaymentStatus, str);
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

    public void attachCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, int i11) {
        CardListFragment cardListFragment$default = DefaultCardView.Companion.getCardListFragment$default(DefaultCardView.Companion, walletCardListDisplayModel, this, (CardListFragment.CardListDefaultCardInterface) null, 4, (Object) null);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        Bundle bundle = new Bundle();
        bundle.putInt(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_HEIGHT, i11);
        Bundle arguments = cardListFragment$default.getArguments();
        if (arguments != null) {
            arguments.putBundle(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_BUNDLE_KEY, bundle);
        }
        beginTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, 17432578, 17432579);
        beginTransaction.replace(R.id.child_fragment_container, cardListFragment$default).addToBackStack(PaymentWidgetBottomSheetKt.CARD_LIST_FRAGMENT).commit();
        this.isPaymentFragmentAttached = false;
    }

    public void attachSuccessScreen(boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.isPaymentFragmentAttached = false;
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        Bundle bundle = new Bundle();
        bundle.putBoolean(TalabatCommonNavigationActions.EXTRA_WALLET_HIDE_CARD_HEIGHT, z11);
        bundle.putString(PaymentWidgetBottomSheetKt.MESSAGE_TITLE, str);
        bundle.putString(PaymentWidgetBottomSheetKt.MESSAGE_DESCRIPTION, str2);
        SuccessWidgetBottomSheetFragment successWidgetBottomSheetFragment = new SuccessWidgetBottomSheetFragment();
        successWidgetBottomSheetFragment.setArguments(bundle);
        int i11 = R.animator.enter_from_right;
        int i12 = R.animator.exit_to_left;
        beginTransaction.setCustomAnimations(i11, i12, i11, i12);
        beginTransaction.replace(R.id.child_fragment_container, successWidgetBottomSheetFragment).commit();
        delay(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, new PaymentWidgetBottomSheet$attachSuccessScreen$1(this));
    }

    public void closeBottomSheet() {
        closeBottomSheetFromDialog();
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void getCardClicked() {
        this.mPaymentBottomSheetInterface.getCardClicked();
    }

    public void networkFailure() {
    }

    public void onBackButtonClicked() {
        boolean z11;
        Bundle addSubscriptionBundle = addSubscriptionBundle();
        addSubscriptionBundle.putInt(CardListFragment.SELECTED_POSITION, this.selectedPosition);
        Collection cardList = this.walletCardList.getCardList();
        if (cardList == null || cardList.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            addSubscriptionBundle.putParcelable(WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST, this.walletCardList);
        }
        PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment = this.mSubscriptionPaymentFragment;
        if (paymentWidgetBottomSheetFragment != null) {
            paymentWidgetBottomSheetFragment.setArguments(addSubscriptionBundle);
        }
        getChildFragmentManager().popBackStack();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_container, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment;
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        if (this.isPaymentFragmentAttached && (paymentWidgetBottomSheetFragment = this.mSubscriptionPaymentFragment) != null) {
            paymentWidgetBottomSheetFragment.resetCardPosition();
        }
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachToFragment();
    }

    public final void openBottomSheet(@NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        fragmentManager.beginTransaction();
        show(fragmentManager, PaymentWidgetBottomSheetKt.PAYMENT_BOTTOM_SHEET);
    }

    public void sendCardDetails(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        this.mPaymentBottomSheetInterface.sendCardDetailsToParentScreen(walletCardDisplayModel, paymentMethod);
    }

    public final void updatePaymentStatus(@NotNull BottomSheetPaymentStatusModel bottomSheetPaymentStatusModel) {
        Intrinsics.checkNotNullParameter(bottomSheetPaymentStatusModel, "bottomSheetPaymentStatusModel");
        PaymentWidgetBottomSheetFragment paymentWidgetBottomSheetFragment = this.mSubscriptionPaymentFragment;
        if (paymentWidgetBottomSheetFragment != null) {
            paymentWidgetBottomSheetFragment.showPaymentStatus(bottomSheetPaymentStatusModel);
        }
    }

    public void updatePositionClicked(int i11) {
        this.selectedPosition = i11;
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        this.walletCardList = walletCardListDisplayModel;
    }
}
