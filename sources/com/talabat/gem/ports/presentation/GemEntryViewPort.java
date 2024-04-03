package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemEntryViewPort;", "Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "bindSaveUpToAmountText", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindSaveUpToAmountText", "()Lkotlin/Unit;", "saveUpToAmountText", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "getSaveUpToAmountText", "()Lio/reactivex/subjects/BehaviorSubject;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemEntryViewPort extends GemCounterViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemEntryViewPort gemEntryViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemCounterViewPort.DefaultImpls.autoDispose(gemEntryViewPort, function0);
        }

        public static void onCleared(@NotNull GemEntryViewPort gemEntryViewPort) {
            GemCounterViewPort.DefaultImpls.onCleared(gemEntryViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemEntryViewPort gemEntryViewPort) {
            GemCounterViewPort.DefaultImpls.onClearedImplementation(gemEntryViewPort);
        }
    }

    @NotNull
    Unit getBindSaveUpToAmountText();

    @NotNull
    BehaviorSubject<SaveUpToAmountText> getSaveUpToAmountText();
}
