package com.talabat.talabatcommon.lifecycle;

import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/talabat/talabatcommon/lifecycle/AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1 implements AutoDisposable {
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        AutoDisposable.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public void onCleared() {
        AutoDisposable.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        AutoDisposable.DefaultImpls.onClearedImplementation(this);
    }
}
