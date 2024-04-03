package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
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
public final class GemViewBusinessRulesKt$bindOffer$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferRequester f60444g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemViewPort f60445h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<GemOffer, Unit> f60446i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemViewBusinessRulesKt$bindOffer$1(GemOfferRequester gemOfferRequester, GemViewPort gemViewPort, Function1<? super GemOffer, Unit> function1) {
        super(0);
        this.f60444g = gemOfferRequester;
        this.f60445h = gemViewPort;
        this.f60446i = function1;
    }

    @Nullable
    public final Disposable invoke() {
        Single observeOn = ((Single) this.f60444g.invoke()).subscribeOn(this.f60445h.getScheduler()).observeOn(this.f60445h.getScheduler());
        Intrinsics.checkNotNullExpressionValue(observeOn, "requester()\n        .sub…    .observeOn(scheduler)");
        AnonymousClass1 r12 = new Function1<Throwable, Unit>(this.f60445h.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemViewPort gemViewPort = this.f60445h;
        final Function1<GemOffer, Unit> function1 = this.f60446i;
        return SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) r12, new Function1<GemOffer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOffer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GemOffer gemOffer) {
                RxKt.plusAssign(gemViewPort.getOffer(), gemOffer);
                Function1<GemOffer, Unit> function1 = function1;
                if (function1 != null) {
                    Intrinsics.checkNotNullExpressionValue(gemOffer, "it");
                    function1.invoke(gemOffer);
                }
            }
        });
    }
}
