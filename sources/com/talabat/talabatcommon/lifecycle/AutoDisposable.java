package com.talabat.talabatcommon.lifecycle;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0017J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0017R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables$annotations", "()V", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "autoDispose", "", "block", "Lkotlin/Function0;", "Lio/reactivex/disposables/Disposable;", "onCleared", "onClearedImplementation", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AutoDisposable {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull AutoDisposable autoDisposable, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            Disposable disposable = (Disposable) function0.invoke();
            if (disposable != null) {
                autoDisposable.getDisposables().add(disposable);
            }
        }

        @AutoDisposableDsl
        public static /* synthetic */ void getDisposables$annotations() {
        }

        public static void onCleared(@NotNull AutoDisposable autoDisposable) {
            autoDisposable.onClearedImplementation();
            autoDisposable.getDisposables().clear();
            AutoDisposableKt.closeSubjects$default(autoDisposable, (Function0) null, 1, (Object) null);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull AutoDisposable autoDisposable) {
        }
    }

    @AutoDisposableDsl
    void autoDispose(@NotNull Function0<? extends Disposable> function0);

    @NotNull
    CompositeDisposable getDisposables();

    void onCleared();

    @AutoDisposableDsl
    void onClearedImplementation();
}
