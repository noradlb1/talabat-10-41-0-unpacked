package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemViewPort;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "bindOffer", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindOffer", "()Lkotlin/Unit;", "errors", "Lio/reactivex/subjects/Subject;", "", "getErrors", "()Lio/reactivex/subjects/Subject;", "offer", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "()Lio/reactivex/subjects/BehaviorSubject;", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemViewPort extends AutoDisposable {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemViewPort gemViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            AutoDisposable.DefaultImpls.autoDispose(gemViewPort, function0);
        }

        public static void onCleared(@NotNull GemViewPort gemViewPort) {
            AutoDisposable.DefaultImpls.onCleared(gemViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemViewPort gemViewPort) {
            AutoDisposable.DefaultImpls.onClearedImplementation(gemViewPort);
        }
    }

    @NotNull
    Unit getBindOffer();

    @NotNull
    Subject<Throwable> getErrors();

    @NotNull
    BehaviorSubject<GemOffer> getOffer();

    @NotNull
    Scheduler getScheduler();
}
