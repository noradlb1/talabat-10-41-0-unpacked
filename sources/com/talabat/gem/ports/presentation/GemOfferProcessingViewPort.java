package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R(\u0010\u0007\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0003j\b\u0012\u0004\u0012\u00020\t`\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/talabat/gem/ports/presentation/GemOfferProcessingViewPort;", "Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "processing", "Lio/reactivex/subjects/BehaviorSubject;", "", "getProcessing", "()Lio/reactivex/subjects/BehaviorSubject;", "processingResult", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "Lcom/talabat/talabatcommon/extentions/SingleAccessSubject;", "getProcessingResult", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemOfferProcessingViewPort extends GemPerRestaurantViewPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            GemPerRestaurantViewPort.DefaultImpls.autoDispose(gemOfferProcessingViewPort, function0);
        }

        @NotNull
        public static Unit getBindSelectedRestaurantId(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.getBindSelectedRestaurantId(gemOfferProcessingViewPort);
            return Unit.INSTANCE;
        }

        public static void onCleared(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.onCleared(gemOfferProcessingViewPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort) {
            GemPerRestaurantViewPort.DefaultImpls.onClearedImplementation(gemOfferProcessingViewPort);
        }
    }

    @NotNull
    BehaviorSubject<Boolean> getProcessing();

    @NotNull
    BehaviorSubject<SingleAccess<GemOfferAcceptance>> getProcessingResult();
}
