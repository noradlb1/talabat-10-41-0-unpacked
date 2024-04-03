package com.talabat.gem.ports.presentation;

import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "bindCounterAndVisibility", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "remainingSeconds", "", "getRemainingSeconds", "visibility", "getVisibility", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemCounterViewPort extends GemViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemCounterViewPort gemCounterViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemViewPort.DefaultImpls.autoDispose(gemCounterViewPort, function0);
        }

        public static void onCleared(@NotNull GemCounterViewPort gemCounterViewPort) {
            GemViewPort.DefaultImpls.onCleared(gemCounterViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemCounterViewPort gemCounterViewPort) {
            GemViewPort.DefaultImpls.onClearedImplementation(gemCounterViewPort);
        }
    }

    @NotNull
    Unit getBindCounterAndVisibility();

    @NotNull
    Unit getBindCounterExpired();

    @NotNull
    BehaviorSubject<String> getCounter();

    @NotNull
    BehaviorSubject<Boolean> getCounterExpired();

    @NotNull
    BehaviorSubject<Disposable> getCounterSubscription();

    @NotNull
    BehaviorSubject<Long> getRemainingSeconds();

    @NotNull
    BehaviorSubject<Boolean> getVisibility();
}
