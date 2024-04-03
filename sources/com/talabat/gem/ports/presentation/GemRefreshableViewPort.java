package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemRefreshableViewPort;", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "bindLocalizationHistory", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindLocalizationHistory", "()Lkotlin/Unit;", "bindLocationsHistory", "getBindLocationsHistory", "localizationHistory", "Lio/reactivex/subjects/ReplaySubject;", "", "getLocalizationHistory", "()Lio/reactivex/subjects/ReplaySubject;", "locationsHistory", "Lcom/talabat/gem/domain/entities/Location;", "getLocationsHistory", "refreshedLocation", "Lio/reactivex/subjects/BehaviorSubject;", "getRefreshedLocation", "()Lio/reactivex/subjects/BehaviorSubject;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemRefreshableViewPort extends GemViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemRefreshableViewPort gemRefreshableViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemViewPort.DefaultImpls.autoDispose(gemRefreshableViewPort, function0);
        }

        public static void onCleared(@NotNull GemRefreshableViewPort gemRefreshableViewPort) {
            GemViewPort.DefaultImpls.onCleared(gemRefreshableViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemRefreshableViewPort gemRefreshableViewPort) {
            GemViewPort.DefaultImpls.onClearedImplementation(gemRefreshableViewPort);
        }
    }

    @NotNull
    Unit getBindLocalizationHistory();

    @NotNull
    Unit getBindLocationsHistory();

    @NotNull
    ReplaySubject<String> getLocalizationHistory();

    @NotNull
    ReplaySubject<Location> getLocationsHistory();

    @NotNull
    BehaviorSubject<Location> getRefreshedLocation();
}
