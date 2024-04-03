package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingBusinessRulesKt$onProcessOffer$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewPort f60400g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferProcessingBusinessRulesKt$onProcessOffer$1(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        super(0);
        this.f60400g = gemOfferProcessingViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Single<GemOfferAcceptance> processGemOffer = GemOfferProcessingBusinessRulesKt.processGemOffer(this.f60400g);
        AnonymousClass1 r12 = new Function1<Throwable, Unit>(this.f60400g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemOfferProcessingViewPort gemOfferProcessingViewPort = this.f60400g;
        return SubscribersKt.subscribeBy(processGemOffer, (Function1<? super Throwable, Unit>) r12, new Function1<GemOfferAcceptance, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOfferAcceptance) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GemOfferAcceptance gemOfferAcceptance) {
                BehaviorSubject<SingleAccess<GemOfferAcceptance>> processingResult = gemOfferProcessingViewPort.getProcessingResult();
                Intrinsics.checkNotNullExpressionValue(gemOfferAcceptance, "it");
                RxKt.plusAssign(processingResult, gemOfferAcceptance);
            }
        });
    }
}
