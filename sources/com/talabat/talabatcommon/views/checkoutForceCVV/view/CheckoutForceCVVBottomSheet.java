package com.talabat.talabatcommon.views.checkoutForceCVV.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVFragment;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVFragment$CheckoutForceCVVFragmentInterface;", "cardNumber", "", "checkoutForceCVVBottomSheetInterface", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVBottomSheet$CheckoutForceCVVBottomSheetInterface;", "(Ljava/lang/String;Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVBottomSheet$CheckoutForceCVVBottomSheetInterface;)V", "attachFragment", "", "closeBottomSheet", "closeBottomSheetFromDialog", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "sendCVVToParentScreen", "cvv", "CheckoutForceCVVBottomSheetInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVBottomSheet extends TalabatBaseBottomSheetDialogFragment implements AnimationHelper, CheckoutForceCVVFragment.CheckoutForceCVVFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final String cardNumber;
    @NotNull
    private final CheckoutForceCVVBottomSheetInterface checkoutForceCVVBottomSheetInterface;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVBottomSheet$CheckoutForceCVVBottomSheetInterface;", "", "sendCVVToCheckoutScreen", "", "cvv", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CheckoutForceCVVBottomSheetInterface {
        void sendCVVToCheckoutScreen(@NotNull String str);
    }

    public CheckoutForceCVVBottomSheet(@NotNull String str, @NotNull CheckoutForceCVVBottomSheetInterface checkoutForceCVVBottomSheetInterface2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(checkoutForceCVVBottomSheetInterface2, "checkoutForceCVVBottomSheetInterface");
        this.cardNumber = str;
        this.checkoutForceCVVBottomSheetInterface = checkoutForceCVVBottomSheetInterface2;
    }

    private final void attachFragment() {
        CheckoutForceCVVFragment checkoutForceCVVFragment = new CheckoutForceCVVFragment(this.cardNumber, this);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.child_fragment_container, checkoutForceCVVFragment).commit();
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.root_view;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "it.root_view");
            adjustViewHeight(coordinatorLayout, ((CoordinatorLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.FAST);
            delay(350, new CheckoutForceCVVBottomSheet$closeBottomSheetFromDialog$1$1(dialog));
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachFragment();
    }

    public void sendCVVToParentScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_CVV_KEY);
        this.checkoutForceCVVBottomSheetInterface.sendCVVToCheckoutScreen(str);
    }
}
