package com.talabat.wallet.debitcarddeflection.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.wallet.debitcarddeflection.ui.BenefitBinInfoFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/ui/DebitCardBinInfoBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/wallet/debitcarddeflection/ui/BenefitBinInfoFragment$DebitCardBinInfoFragmentInterface;", "expiryDate", "", "debitCardBinInfoBottomSheetInterface", "Lcom/talabat/wallet/debitcarddeflection/ui/DebitCardBinInfoBottomSheetInterface;", "(Ljava/lang/String;Lcom/talabat/wallet/debitcarddeflection/ui/DebitCardBinInfoBottomSheetInterface;)V", "attachFragment", "", "closeBottomSheet", "closeBottomSheetFromDialog", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "placeOrderWithBenefit", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebitCardBinInfoBottomSheet extends TalabatBaseBottomSheetDialogFragment implements AnimationHelper, BenefitBinInfoFragment.DebitCardBinInfoFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final DebitCardBinInfoBottomSheetInterface debitCardBinInfoBottomSheetInterface;
    @NotNull
    private final String expiryDate;

    public DebitCardBinInfoBottomSheet(@NotNull String str, @NotNull DebitCardBinInfoBottomSheetInterface debitCardBinInfoBottomSheetInterface2) {
        Intrinsics.checkNotNullParameter(str, "expiryDate");
        Intrinsics.checkNotNullParameter(debitCardBinInfoBottomSheetInterface2, "debitCardBinInfoBottomSheetInterface");
        this.expiryDate = str;
        this.debitCardBinInfoBottomSheetInterface = debitCardBinInfoBottomSheetInterface2;
    }

    private final void attachFragment() {
        BenefitBinInfoFragment benefitBinInfoFragment = new BenefitBinInfoFragment(this.expiryDate, this);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.child_fragment_container, benefitBinInfoFragment).commit();
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = com.talabat.wallet.R.id.container_all;
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "it.container_all");
            adjustViewHeight(linearLayout, ((LinearLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.FAST);
            delay(350, new DebitCardBinInfoBottomSheet$closeBottomSheetFromDialog$1$1(dialog));
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

    public void closeBottomSheet() {
        closeBottomSheetFromDialog();
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

    public void placeOrderWithBenefit() {
        closeBottomSheetFromDialog();
        delay(350, new DebitCardBinInfoBottomSheet$placeOrderWithBenefit$1(this));
    }
}
