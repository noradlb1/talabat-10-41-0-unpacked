package com.talabat.darkstores.common.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yh.a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u0004H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H$R\u001b\u0010\u0018\u001a\u00020\u00138@X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/common/base/BaseBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "setupBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "disableCornerAnimation", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "", "i0", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "cartFragmentViewModel$delegate", "Lkotlin/Lazy;", "getCartFragmentViewModel$com_talabat_NewArchi_darkstores_darkstores", "()Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "cartFragmentViewModel", "", "getContentViewId", "()I", "contentViewId", "<init>", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class BaseBottomSheet extends BottomSheetDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Lazy cartFragmentViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CartFragmentViewModel.class), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1(this), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2((Function0) null, this), new BaseBottomSheet$special$$inlined$activityViewModel$1());

    private final void disableCornerAnimation(BottomSheetBehavior<?> bottomSheetBehavior) {
        bottomSheetBehavior.disableShapeAnimations();
    }

    private final void setupBehavior() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new a(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBehavior$lambda-2  reason: not valid java name */
    public static final void m9631setupBehavior$lambda2(BaseBottomSheet baseBottomSheet, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(baseBottomSheet, "this$0");
        if (dialogInterface != null) {
            BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialogInterface).getBehavior();
            Intrinsics.checkNotNullExpressionValue(behavior, "");
            baseBottomSheet.disableCornerAnimation(behavior);
            behavior.setSkipCollapsed(true);
            behavior.setState(3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
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

    @NotNull
    public final CartFragmentViewModel getCartFragmentViewModel$com_talabat_NewArchi_darkstores_darkstores() {
        return (CartFragmentViewModel) this.cartFragmentViewModel$delegate.getValue();
    }

    public abstract int getContentViewId();

    @NotNull
    public abstract String i0();

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(getContentViewId(), viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        CartFragmentViewModel.trackScreenOpened$default(getCartFragmentViewModel$com_talabat_NewArchi_darkstores_darkstores(), i0(), (EventOriginType) null, 2, (Object) null);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        setupBehavior();
        super.onViewCreated(view, bundle);
    }
}
