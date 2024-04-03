package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemTier;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "bindStaticTiersMode", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindStaticTiersMode", "()Lkotlin/Unit;", "bindTiers", "getBindTiers", "staticTiersMode", "Lio/reactivex/subjects/BehaviorSubject;", "", "getStaticTiersMode", "()Lio/reactivex/subjects/BehaviorSubject;", "tiers", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "getTiers", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemTiersViewPort extends GemViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemTiersViewPort gemTiersViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemViewPort.DefaultImpls.autoDispose(gemTiersViewPort, function0);
        }

        public static void onCleared(@NotNull GemTiersViewPort gemTiersViewPort) {
            GemViewPort.DefaultImpls.onCleared(gemTiersViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemTiersViewPort gemTiersViewPort) {
            GemViewPort.DefaultImpls.onClearedImplementation(gemTiersViewPort);
        }
    }

    @NotNull
    Unit getBindStaticTiersMode();

    @NotNull
    Unit getBindTiers();

    @NotNull
    BehaviorSubject<Boolean> getStaticTiersMode();

    @NotNull
    BehaviorSubject<List<GemTier>> getTiers();
}
