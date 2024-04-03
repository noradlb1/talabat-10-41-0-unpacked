package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;", "Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "bindCollectionTriggerExpirationAlert", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindCollectionTriggerExpirationAlert", "()Lkotlin/Unit;", "bindExpiredOffer", "getBindExpiredOffer", "bindTriggerExpirationAlert", "getBindTriggerExpirationAlert", "expiredOffer", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemOffer;", "getExpiredOffer", "()Lio/reactivex/subjects/BehaviorSubject;", "triggerExpirationAlert", "Lkotlin/Function0;", "", "getTriggerExpirationAlert", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemExpiredViewPort extends GemPerRestaurantViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemExpiredViewPort gemExpiredViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemPerRestaurantViewPort.DefaultImpls.autoDispose(gemExpiredViewPort, function0);
        }

        @NotNull
        public static Unit getBindSelectedRestaurantId(@NotNull GemExpiredViewPort gemExpiredViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.getBindSelectedRestaurantId(gemExpiredViewPort);
            return Unit.INSTANCE;
        }

        public static void onCleared(@NotNull GemExpiredViewPort gemExpiredViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.onCleared(gemExpiredViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemExpiredViewPort gemExpiredViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.onClearedImplementation(gemExpiredViewPort);
        }
    }

    @NotNull
    Unit getBindCollectionTriggerExpirationAlert();

    @NotNull
    Unit getBindExpiredOffer();

    @NotNull
    Unit getBindTriggerExpirationAlert();

    @NotNull
    BehaviorSubject<GemOffer> getExpiredOffer();

    @NotNull
    BehaviorSubject<Function0<Boolean>> getTriggerExpirationAlert();
}
