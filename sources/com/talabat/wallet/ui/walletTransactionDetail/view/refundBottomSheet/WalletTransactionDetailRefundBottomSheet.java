package com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundBottomSheetDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet.WalletTransactionDetailRefundFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundFragment$WalletTransactionDetailRefundFragmentInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "displayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundBottomSheetDisplayModel;", "listener", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundBottomSheet$RefundBottomSheetInterface;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundBottomSheetDisplayModel;Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundBottomSheet$RefundBottomSheetInterface;)V", "refundFragment", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundFragment;", "attachFragment", "", "closeBottomSheet", "closeBottomSheetDialog", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "revertRefund", "showErrorResult", "showResult", "isSuccessful", "", "showSuccessScreen", "RefundBottomSheetInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRefundBottomSheet extends TalabatBaseBottomSheetDialogFragment implements WalletTransactionDetailRefundFragment.WalletTransactionDetailRefundFragmentInterface, AnimationHelper {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final WalletRefundBottomSheetDisplayModel displayModel;
    @NotNull
    private final RefundBottomSheetInterface listener;
    @Nullable
    private WalletTransactionDetailRefundFragment refundFragment;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundBottomSheet$RefundBottomSheetInterface;", "", "revertRefundFromBottomSheet", "", "showRefundRevertedSuccessfulViews", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface RefundBottomSheetInterface {
        void revertRefundFromBottomSheet();

        void showRefundRevertedSuccessfulViews();
    }

    public WalletTransactionDetailRefundBottomSheet(@NotNull WalletRefundBottomSheetDisplayModel walletRefundBottomSheetDisplayModel, @NotNull RefundBottomSheetInterface refundBottomSheetInterface) {
        Intrinsics.checkNotNullParameter(walletRefundBottomSheetDisplayModel, "displayModel");
        Intrinsics.checkNotNullParameter(refundBottomSheetInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.displayModel = walletRefundBottomSheetDisplayModel;
        this.listener = refundBottomSheetInterface;
    }

    private final void attachFragment() {
        this.refundFragment = new WalletTransactionDetailRefundFragment(this);
        Bundle bundle = new Bundle();
        bundle.putParcelable(WalletNavigatorActions.EXTRA_REFUND_BOTTOM_SHEET, this.displayModel);
        WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment = this.refundFragment;
        if (walletTransactionDetailRefundFragment != null) {
            walletTransactionDetailRefundFragment.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment2 = this.refundFragment;
        if (walletTransactionDetailRefundFragment2 != null) {
            beginTransaction.replace(R.id.child_fragment_container, walletTransactionDetailRefundFragment2).commit();
        }
    }

    /* access modifiers changed from: private */
    public final void closeBottomSheet() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = com.talabat.wallet.R.id.container_all;
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "it.container_all");
            adjustViewHeight(linearLayout, ((LinearLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            delay(500, new WalletTransactionDetailRefundBottomSheet$closeBottomSheet$1$1(dialog));
        }
    }

    private final void showSuccessScreen() {
        this.listener.showRefundRevertedSuccessfulViews();
        WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment = this.refundFragment;
        if (walletTransactionDetailRefundFragment != null) {
            walletTransactionDetailRefundFragment.showSuccessScreen();
        }
        delay(1000, new WalletTransactionDetailRefundBottomSheet$showSuccessScreen$1(this));
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

    public void closeBottomSheetDialog() {
        closeBottomSheet();
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachFragment();
    }

    public void revertRefund() {
        this.listener.revertRefundFromBottomSheet();
    }

    public final void showErrorResult() {
        WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment = this.refundFragment;
        if (walletTransactionDetailRefundFragment != null) {
            walletTransactionDetailRefundFragment.showErrorScreen();
        }
        delay(1000, new WalletTransactionDetailRefundBottomSheet$showErrorResult$1(this));
    }

    public final void showResult(boolean z11) {
        if (z11) {
            showSuccessScreen();
        } else {
            showErrorResult();
        }
    }
}
