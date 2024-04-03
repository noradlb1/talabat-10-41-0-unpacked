package com.talabat.feature.rating.presentation.ui;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$4"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RatingDeliveryFragment$special$$inlined$activityViewModels$default$1 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f58699g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingDeliveryFragment$special$$inlined$activityViewModels$default$1(Fragment fragment) {
        super(0);
        this.f58699g = fragment;
    }

    @NotNull
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.f58699g.requireActivity().getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
