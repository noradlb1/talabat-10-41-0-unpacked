package com.talabat.talabatcore.viewmodel;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcore/viewmodel/CreateCustomViewViewModel;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "setContext", "createViewModel", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "initializer", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "scanForActivity", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CreateCustomViewViewModel {
    @NotNull
    private final Lazy activity$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new CreateCustomViewViewModel$activity$2(this));
    @NotNull
    private Context context;

    public CreateCustomViewViewModel(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final /* synthetic */ <T extends ViewModel> T createViewModel(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        ViewModelProvider of2 = ViewModelProviders.of(getActivity(), (ViewModelProvider.Factory) new CreateCustomViewViewModel$createViewModel$factory$1(function0));
        Intrinsics.reifiedOperationMarker(4, "T");
        T t11 = of2.get(str, ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t11, "of(activity, factory).get(key, T::class.java)");
        return t11;
    }

    @NotNull
    public final FragmentActivity getActivity() {
        return (FragmentActivity) this.activity$delegate.getValue();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final FragmentActivity scanForActivity(@Nullable Context context2) {
        if (context2 instanceof FragmentActivity) {
            return (FragmentActivity) context2;
        }
        if (context2 instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context2).getBaseContext());
        }
        throw new IllegalArgumentException("Context must be a FragmentActivity!");
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }
}
