package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemRestaurantsViewPort;", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "bindRestaurants", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindRestaurants", "()Lkotlin/Unit;", "restaurants", "Lio/reactivex/subjects/BehaviorSubject;", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "getRestaurants", "()Lio/reactivex/subjects/BehaviorSubject;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemRestaurantsViewPort extends GemViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemRestaurantsViewPort gemRestaurantsViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemViewPort.DefaultImpls.autoDispose(gemRestaurantsViewPort, function0);
        }

        public static void onCleared(@NotNull GemRestaurantsViewPort gemRestaurantsViewPort) {
            GemViewPort.DefaultImpls.onCleared(gemRestaurantsViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemRestaurantsViewPort gemRestaurantsViewPort) {
            GemViewPort.DefaultImpls.onClearedImplementation(gemRestaurantsViewPort);
        }
    }

    @NotNull
    Unit getBindRestaurants();

    @NotNull
    BehaviorSubject<List<GemRestaurant>> getRestaurants();
}
