package com.deliveryhero.performance.core.tapresponse;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.deliveryhero.performance.core.tapresponse.AndroidComponentViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t5.b;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/OnViewUpdateRunner;", "", "viewContainer", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "(Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;)V", "runOnViewsUpdated", "", "block", "Lkotlin/Function1;", "Landroid/view/View;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnViewUpdateRunner {
    @NotNull
    private final AndroidComponentViewContainer viewContainer;

    public OnViewUpdateRunner(@NotNull AndroidComponentViewContainer androidComponentViewContainer) {
        Intrinsics.checkNotNullParameter(androidComponentViewContainer, "viewContainer");
        this.viewContainer = androidComponentViewContainer;
    }

    /* access modifiers changed from: private */
    /* renamed from: runOnViewsUpdated$lambda-0  reason: not valid java name */
    public static final void m8239runOnViewsUpdated$lambda0(Fragment fragment, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(function1, "$block");
        if (fragment.getView() == null) {
            Log.w("onViewUpdateRunner", "fragment null");
            return;
        }
        View requireView = fragment.requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "fragment.requireView()");
        function1.invoke(requireView);
    }

    public final void runOnViewsUpdated(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        AndroidComponentViewContainer androidComponentViewContainer = this.viewContainer;
        if (androidComponentViewContainer instanceof AndroidComponentViewContainer.ActivityContainer) {
            View findViewById = ((AndroidComponentViewContainer.ActivityContainer) androidComponentViewContainer).getActivity().findViewById(16908290);
            if (findViewById == null) {
                findViewById = ((AndroidComponentViewContainer.ActivityContainer) this.viewContainer).getActivity().getWindow().findViewById(16908290);
                Intrinsics.checkNotNullExpressionValue(findViewById, "viewContainer.activity.g…yId(android.R.id.content)");
            }
            function1.invoke(findViewById);
        } else if (androidComponentViewContainer instanceof AndroidComponentViewContainer.FragmentContainer) {
            Fragment fragment = ((AndroidComponentViewContainer.FragmentContainer) androidComponentViewContainer).getFragment();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
            beginTransaction.runOnCommit(new b(fragment, function1)).commitAllowingStateLoss();
        }
    }
}
