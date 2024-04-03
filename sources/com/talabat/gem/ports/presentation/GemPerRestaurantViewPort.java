package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.BusinessRules;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048VX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "bindSelectedGemRestaurant", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindSelectedGemRestaurant$annotations", "()V", "getBindSelectedGemRestaurant", "()Lkotlin/Unit;", "bindSelectedRestaurantId", "getBindSelectedRestaurantId$annotations", "getBindSelectedRestaurantId", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant$annotations", "getBindVisibilityPerRestaurant", "selectedGemRestaurant", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "()Lio/reactivex/subjects/BehaviorSubject;", "selectedRestaurantId", "", "getSelectedRestaurantId", "visibilityPerRestaurant", "", "getVisibilityPerRestaurant", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemPerRestaurantViewPort extends GemCounterViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemCounterViewPort.DefaultImpls.autoDispose(gemPerRestaurantViewPort, function0);
        }

        @BusinessRules
        public static /* synthetic */ void getBindSelectedGemRestaurant$annotations() {
        }

        @NotNull
        public static Unit getBindSelectedRestaurantId(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort) {
            return Unit.INSTANCE;
        }

        @BusinessRules
        public static /* synthetic */ void getBindSelectedRestaurantId$annotations() {
        }

        @BusinessRules
        public static /* synthetic */ void getBindVisibilityPerRestaurant$annotations() {
        }

        public static void onCleared(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort) {
            GemCounterViewPort.DefaultImpls.onCleared(gemPerRestaurantViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort) {
            GemCounterViewPort.DefaultImpls.onClearedImplementation(gemPerRestaurantViewPort);
        }
    }

    @NotNull
    Unit getBindSelectedGemRestaurant();

    @NotNull
    Unit getBindSelectedRestaurantId();

    @NotNull
    Unit getBindVisibilityPerRestaurant();

    @NotNull
    BehaviorSubject<GemRestaurant> getSelectedGemRestaurant();

    @NotNull
    BehaviorSubject<Integer> getSelectedRestaurantId();

    @NotNull
    BehaviorSubject<Boolean> getVisibilityPerRestaurant();
}
