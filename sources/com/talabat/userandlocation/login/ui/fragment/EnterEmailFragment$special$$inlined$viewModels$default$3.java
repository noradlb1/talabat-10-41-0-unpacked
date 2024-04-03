package com.talabat.userandlocation.login.ui.fragment;

import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$6"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailFragment$special$$inlined$viewModels$default$3 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Lazy f12400g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterEmailFragment$special$$inlined$viewModels$default$3(Lazy lazy) {
        super(0);
        this.f12400g = lazy;
    }

    @NotNull
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = FragmentViewModelLazyKt.m9081viewModels$lambda1(this.f12400g).getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
        return viewModelStore;
    }
}
