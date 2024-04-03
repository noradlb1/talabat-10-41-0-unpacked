package com.talabat.feature.darkstorescarrierbag.presentation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$1"}, k = 3, mv = {1, 6, 0})
public final class DarkstoresCarrierBagManager$special$$inlined$activityViewModels$1 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f58451g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresCarrierBagManager$special$$inlined$activityViewModels$1(Fragment fragment) {
        super(0);
        this.f58451g = fragment;
    }

    @NotNull
    public final ViewModelStore invoke() {
        FragmentActivity requireActivity = this.f58451g.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModelStore viewModelStore = requireActivity.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
