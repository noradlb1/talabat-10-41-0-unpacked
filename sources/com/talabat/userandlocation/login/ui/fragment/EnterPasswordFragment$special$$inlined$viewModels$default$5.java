package com.talabat.userandlocation.login.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$8"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordFragment$special$$inlined$viewModels$default$5 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f12416g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Lazy f12417h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$special$$inlined$viewModels$default$5(Fragment fragment, Lazy lazy) {
        super(0);
        this.f12416g = fragment;
        this.f12417h = lazy;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory factory;
        ViewModelStoreOwner r02 = FragmentViewModelLazyKt.m9081viewModels$lambda1(this.f12417h);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = r02 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) r02 : null;
        if (hasDefaultViewModelProviderFactory == null || (factory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
            factory = this.f12416g.getDefaultViewModelProviderFactory();
        }
        Intrinsics.checkNotNullExpressionValue(factory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
        return factory;
    }
}
