package com.talabat.gem.adapters.presentation.payment;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingKt$onInitialize$4 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewModel f60260g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferProcessingKt$onInitialize$4(GemOfferProcessingViewModel gemOfferProcessingViewModel) {
        super(0);
        this.f60260g = gemOfferProcessingViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<SingleAccess<GemOfferAcceptance>> processingResult = this.f60260g.getProcessingResult();
        final GemOfferProcessingViewModel gemOfferProcessingViewModel = this.f60260g;
        return RxKt.invoke(processingResult, new Function1<ObserverCallbacks<SingleAccess<GemOfferAcceptance>, Observable<SingleAccess<GemOfferAcceptance>>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<SingleAccess<GemOfferAcceptance>, Observable<SingleAccess<GemOfferAcceptance>>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<SingleAccess<GemOfferAcceptance>, Observable<SingleAccess<GemOfferAcceptance>>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<SingleAccess<GemOfferAcceptance>, Observable<SingleAccess<GemOfferAcceptance>>> on2 = observerCallbacks.getOn();
                final GemOfferProcessingViewModel gemOfferProcessingViewModel = gemOfferProcessingViewModel;
                on2.next(new Function1<SingleAccess<GemOfferAcceptance>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SingleAccess<GemOfferAcceptance>) (SingleAccess) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SingleAccess<GemOfferAcceptance> singleAccess) {
                        Function1 function1;
                        GemOfferAcceptance value = singleAccess.getValue();
                        if (value instanceof GemOfferAcceptance.Accepted) {
                            Function1 function12 = (Function1) RxKt.invoke(gemOfferProcessingViewModel.getOnProcessed$com_talabat_Components_gem_gem());
                            if (function12 != null) {
                                function12.invoke(value);
                            }
                        } else if (value instanceof GemOfferAcceptance.Rejected) {
                            Function1 function13 = (Function1) RxKt.invoke(gemOfferProcessingViewModel.getOnProcessed$com_talabat_Components_gem_gem());
                            if (function13 != null) {
                                function13.invoke(value);
                            }
                        } else if ((value instanceof GemOfferAcceptance.Failed) && (function1 = (Function1) RxKt.invoke(gemOfferProcessingViewModel.getOnProcessingError$com_talabat_Components_gem_gem())) != null) {
                            function1.invoke(((GemOfferAcceptance.Failed) value).getError());
                        }
                    }
                });
            }
        });
    }
}
