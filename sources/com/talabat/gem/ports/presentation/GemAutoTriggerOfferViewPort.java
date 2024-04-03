package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.talabatcommon.extentions.Flag;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\bj\u0002`\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemAutoTriggerOfferViewPort;", "Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "autoTriggerOffer", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/talabatcommon/extentions/Flag;", "getAutoTriggerOffer", "()Lio/reactivex/subjects/BehaviorSubject;", "bindAutoTriggerOffer", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindAutoTriggerOffer", "()Lkotlin/Unit;", "mode", "Lcom/talabat/gem/domain/entities/GemMode;", "getMode", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemAutoTriggerOfferViewPort extends GemCounterViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemCounterViewPort.DefaultImpls.autoDispose(gemAutoTriggerOfferViewPort, function0);
        }

        public static void onCleared(@NotNull GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort) {
            GemCounterViewPort.DefaultImpls.onCleared(gemAutoTriggerOfferViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort) {
            GemCounterViewPort.DefaultImpls.onClearedImplementation(gemAutoTriggerOfferViewPort);
        }
    }

    @NotNull
    BehaviorSubject<Flag> getAutoTriggerOffer();

    @NotNull
    Unit getBindAutoTriggerOffer();

    @NotNull
    BehaviorSubject<GemMode> getMode();
}
