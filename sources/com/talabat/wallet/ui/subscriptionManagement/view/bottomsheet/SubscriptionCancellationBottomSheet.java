package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.compose.DialogNavigator;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u001a\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment$SubscriptionCancellationFragmentInterface;", "subscriptionMemberId", "", "nextBillingDate", "cancellationType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;", "mSubscriptionCancellationBottomSheetInterface", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationBottomSheet$SubscriptionCancellationBottomSheetInterface;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationBottomSheet$SubscriptionCancellationBottomSheetInterface;)V", "subscriptionCancellationFragment", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment;", "attachFragment", "", "closeBottomSheetFromDialog", "onBottomSheetClosed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onRefreshSubscriptionDetailScreen", "onViewCreated", "view", "SubscriptionCancellationBottomSheetInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationBottomSheet extends TalabatBaseBottomSheetDialogFragment implements AnimationHelper, SubscriptionCancellationFragment.SubscriptionCancellationFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final SubscriptionCancellationType cancellationType;
    @Nullable
    private final SubscriptionCancellationBottomSheetInterface mSubscriptionCancellationBottomSheetInterface;
    @NotNull
    private final String nextBillingDate;
    @Nullable
    private SubscriptionCancellationFragment subscriptionCancellationFragment;
    @NotNull
    private final String subscriptionMemberId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationBottomSheet$SubscriptionCancellationBottomSheetInterface;", "", "onBottomSheetClosed", "", "onRefreshSubscriptionDetailScreen", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SubscriptionCancellationBottomSheetInterface {
        void onBottomSheetClosed();

        void onRefreshSubscriptionDetailScreen();
    }

    public SubscriptionCancellationBottomSheet(@NotNull String str, @NotNull String str2, @NotNull SubscriptionCancellationType subscriptionCancellationType, @Nullable SubscriptionCancellationBottomSheetInterface subscriptionCancellationBottomSheetInterface) {
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        Intrinsics.checkNotNullParameter(str2, "nextBillingDate");
        Intrinsics.checkNotNullParameter(subscriptionCancellationType, "cancellationType");
        this.subscriptionMemberId = str;
        this.nextBillingDate = str2;
        this.cancellationType = subscriptionCancellationType;
        this.mSubscriptionCancellationBottomSheetInterface = subscriptionCancellationBottomSheetInterface;
    }

    private final void attachFragment() {
        this.subscriptionCancellationFragment = new SubscriptionCancellationFragment(this.subscriptionMemberId, this.nextBillingDate, this.cancellationType, this);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        SubscriptionCancellationFragment subscriptionCancellationFragment2 = this.subscriptionCancellationFragment;
        if (subscriptionCancellationFragment2 != null) {
            beginTransaction.replace(R.id.child_fragment_container, subscriptionCancellationFragment2).commit();
        }
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = com.talabat.wallet.R.id.container_all;
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "it.container_all");
            adjustViewHeight(linearLayout, ((LinearLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.FAST);
            delay(350, new SubscriptionCancellationBottomSheet$closeBottomSheetFromDialog$1$1(dialog));
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

    public void onBottomSheetClosed() {
        closeBottomSheetFromDialog();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.ResizeableWindow);
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
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        super.onDismiss(dialogInterface);
        SubscriptionCancellationBottomSheetInterface subscriptionCancellationBottomSheetInterface = this.mSubscriptionCancellationBottomSheetInterface;
        if (subscriptionCancellationBottomSheetInterface != null) {
            subscriptionCancellationBottomSheetInterface.onBottomSheetClosed();
        }
    }

    public void onRefreshSubscriptionDetailScreen() {
        SubscriptionCancellationBottomSheetInterface subscriptionCancellationBottomSheetInterface = this.mSubscriptionCancellationBottomSheetInterface;
        if (subscriptionCancellationBottomSheetInterface != null) {
            subscriptionCancellationBottomSheetInterface.onRefreshSubscriptionDetailScreen();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachFragment();
    }
}
