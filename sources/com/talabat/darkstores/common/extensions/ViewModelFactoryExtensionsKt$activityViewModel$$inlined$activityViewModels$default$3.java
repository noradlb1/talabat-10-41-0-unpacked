package com.talabat.darkstores.common.extensions;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$6"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$3 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f56139g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$3(Fragment fragment) {
        super(0);
        this.f56139g = fragment;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f56139g.requireActivity().getDefaultViewModelProviderFactory();
        Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
