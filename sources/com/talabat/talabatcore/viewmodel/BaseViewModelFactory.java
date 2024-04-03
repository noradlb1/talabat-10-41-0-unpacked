package com.talabat.talabatcore.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J%\u0010\b\u001a\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000bH\u0016¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "T", "Landroidx/lifecycle/ViewModelProvider$Factory;", "creator", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getCreator", "()Lkotlin/jvm/functions/Function0;", "create", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseViewModelFactory<T> implements ViewModelProvider.Factory {
    @NotNull
    private final Function0<T> creator;

    public BaseViewModelFactory(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "creator");
        this.creator = function0;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T invoke = this.creator.invoke();
        if (invoke != null) {
            return (ViewModel) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.talabat.talabatcore.viewmodel.BaseViewModelFactory.create");
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }

    @NotNull
    public final Function0<T> getCreator() {
        return this.creator;
    }
}
