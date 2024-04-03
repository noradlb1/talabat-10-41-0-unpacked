package com.talabat.splash.core.extension;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.talabat.splash.core.platform.BaseFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002¢\u0006\u0002\u0010\u0007\u001a)\u0010\b\u001a\u00020\u0006*\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a)\u0010\u000e\u001a\u00020\u000f*\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a&\u0010\u0010\u001a\u0002H\u0011\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\b¢\u0006\u0002\u0010\u0016\u001aB\u0010\u0010\u001a\u0002H\u0011\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"appContext", "Landroid/content/Context;", "Lcom/talabat/splash/core/platform/BaseFragment;", "getAppContext", "(Lcom/talabat/splash/core/platform/BaseFragment;)Landroid/content/Context;", "close", "", "(Lcom/talabat/splash/core/platform/BaseFragment;)Lkotlin/Unit;", "doTransaction", "Landroidx/fragment/app/FragmentManager;", "func", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "inTransaction", "", "viewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "body", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/ViewModel;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentKt {
    @Nullable
    public static final Unit close(@NotNull BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        FragmentManager fragmentManager = baseFragment.getFragmentManager();
        if (fragmentManager == null) {
            return null;
        }
        fragmentManager.popBackStack();
        return Unit.INSTANCE;
    }

    public static final void doTransaction(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super FragmentTransaction, ? extends FragmentTransaction> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        ((FragmentTransaction) function1.invoke(beginTransaction)).commitNowAllowingStateLoss();
    }

    @NotNull
    public static final Context getAppContext(@NotNull BaseFragment baseFragment) {
        Context context;
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        FragmentActivity activity = baseFragment.getActivity();
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = null;
        }
        Intrinsics.checkNotNull(context);
        return context;
    }

    public static final int inTransaction(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super FragmentTransaction, ? extends FragmentTransaction> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        return ((FragmentTransaction) function1.invoke(beginTransaction)).commit();
    }

    public static final /* synthetic */ <T extends ViewModel> T viewModel(Fragment fragment, ViewModelProvider.Factory factory, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(function1, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t11 = viewModelProvider.get(ViewModel.class);
        function1.invoke(t11);
        return t11;
    }

    public static final /* synthetic */ <T extends ViewModel> T viewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        return viewModelProvider.get(ViewModel.class);
    }
}
