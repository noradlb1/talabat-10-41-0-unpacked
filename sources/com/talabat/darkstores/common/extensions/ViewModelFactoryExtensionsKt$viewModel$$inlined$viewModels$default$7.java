package com.talabat.darkstores.common.extensions;

import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$7"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7 extends Lambda implements Function0<CreationExtras> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0 f56147g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Lazy f56148h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7(Function0 function0, Lazy lazy) {
        super(0);
        this.f56147g = function0;
        this.f56148h = lazy;
    }

    @NotNull
    public final CreationExtras invoke() {
        CreationExtras creationExtras;
        Function0 function0 = this.f56147g;
        if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
            return creationExtras;
        }
        ViewModelStoreOwner r02 = FragmentViewModelLazyKt.m9081viewModels$lambda1(this.f56148h);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = r02 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) r02 : null;
        CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
        return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
    }
}
