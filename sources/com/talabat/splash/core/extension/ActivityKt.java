package com.talabat.splash.core.extension;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"viewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/FragmentActivity;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "body", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/ViewModel;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityKt {
    public static final /* synthetic */ <T extends ViewModel> T viewModel(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(function1, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) fragmentActivity, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t11 = viewModelProvider.get(ViewModel.class);
        function1.invoke(t11);
        return t11;
    }
}
