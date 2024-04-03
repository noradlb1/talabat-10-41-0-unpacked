package com.talabat.darkstores.common.extensions;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\bø\u0001\u0000\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\bø\u0001\u0000\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\b2\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"activityViewModel", "Lkotlin/Lazy;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "provider", "Lkotlin/Function0;", "viewModel", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewModelFactoryExtensionsKt {
    public static final /* synthetic */ <T extends ViewModel> Lazy<T> activityViewModel(Fragment fragment, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "provider");
        ViewModelFactoryExtensionsKt$activityViewModel$1 viewModelFactoryExtensionsKt$activityViewModel$1 = new ViewModelFactoryExtensionsKt$activityViewModel$1(function0);
        Intrinsics.reifiedOperationMarker(4, "T");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$1(fragment), new ViewModelFactoryExtensionsKt$activityViewModel$$inlined$activityViewModels$default$2((Function0) null, fragment), viewModelFactoryExtensionsKt$activityViewModel$1);
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> viewModel(FragmentActivity fragmentActivity, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function0, "provider");
        ViewModelFactoryExtensionsKt$viewModel$1 viewModelFactoryExtensionsKt$viewModel$1 = new ViewModelFactoryExtensionsKt$viewModel$1(function0);
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$2(fragmentActivity), viewModelFactoryExtensionsKt$viewModel$1, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$3((Function0) null, fragmentActivity));
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> viewModel(Fragment fragment, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "provider");
        ViewModelFactoryExtensionsKt$viewModel$2 viewModelFactoryExtensionsKt$viewModel$2 = new ViewModelFactoryExtensionsKt$viewModel$2(function0);
        Lazy lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(fragment)));
        Intrinsics.reifiedOperationMarker(4, "T");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), viewModelFactoryExtensionsKt$viewModel$2);
    }
}
