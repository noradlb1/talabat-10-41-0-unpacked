package com.talabat.darkstores.common.base;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/common/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "a", "()Lio/reactivex/disposables/CompositeDisposable;", "<init>", "(Lio/reactivex/disposables/CompositeDisposable;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class BaseViewModel extends ViewModel {
    @NotNull
    private final CompositeDisposable compositeDisposable;

    public BaseViewModel(@NotNull CompositeDisposable compositeDisposable2) {
        Intrinsics.checkNotNullParameter(compositeDisposable2, "compositeDisposable");
        this.compositeDisposable = compositeDisposable2;
    }

    @NotNull
    public final CompositeDisposable a() {
        return this.compositeDisposable;
    }

    @VisibleForTesting(otherwise = 4)
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }
}
