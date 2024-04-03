package com.talabat.gem.ports.presentation;

import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.gem.ports.presentation.GemSubTotalViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0016\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00060\u0004j\u0002`\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00060\u0004j\u0002`\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemDiscountViewPort;", "Lcom/talabat/gem/ports/presentation/GemSubTotalViewPort;", "Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "bindDiscountAmount", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindDiscountAmount", "()Lkotlin/Unit;", "bindDiscountText", "getBindDiscountText", "bindDiscountVisibility", "getBindDiscountVisibility", "discountAmount", "Lio/reactivex/subjects/BehaviorSubject;", "", "getDiscountAmount", "()Lio/reactivex/subjects/BehaviorSubject;", "discountText", "", "getDiscountText", "discountVisibility", "", "getDiscountVisibility", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemDiscountViewPort extends GemSubTotalViewPort, GemPerRestaurantViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemDiscountViewPort gemDiscountViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemSubTotalViewPort.DefaultImpls.autoDispose(gemDiscountViewPort, function0);
        }

        @NotNull
        public static Unit getBindSelectedRestaurantId(@NotNull GemDiscountViewPort gemDiscountViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.getBindSelectedRestaurantId(gemDiscountViewPort);
            return Unit.INSTANCE;
        }

        public static void onCleared(@NotNull GemDiscountViewPort gemDiscountViewPort) {
            GemSubTotalViewPort.DefaultImpls.onCleared(gemDiscountViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemDiscountViewPort gemDiscountViewPort) {
            GemSubTotalViewPort.DefaultImpls.onClearedImplementation(gemDiscountViewPort);
        }
    }

    @NotNull
    Unit getBindDiscountAmount();

    @NotNull
    Unit getBindDiscountText();

    @NotNull
    Unit getBindDiscountVisibility();

    @NotNull
    BehaviorSubject<Double> getDiscountAmount();

    @NotNull
    BehaviorSubject<String> getDiscountText();

    @NotNull
    BehaviorSubject<Boolean> getDiscountVisibility();
}
