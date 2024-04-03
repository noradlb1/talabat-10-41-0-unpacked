package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
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
public final class GemViewBusinessRulesKt$bindOfferAsObserver$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemViewPort f60449g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemViewBusinessRulesKt$bindOfferAsObserver$1(GemViewPort gemViewPort) {
        super(0);
        this.f60449g = gemViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<GemOffer> observeOn = IntegrationKt.getDataSources().observeOnGemOffer().share().subscribeOn(this.f60449g.getScheduler()).observeOn(this.f60449g.getScheduler());
        Intrinsics.checkNotNullExpressionValue(observeOn, "DataSources.observeOnGem…    .observeOn(scheduler)");
        AnonymousClass1 r32 = new Function1<Throwable, Unit>(this.f60449g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemViewPort gemViewPort = this.f60449g;
        return SubscribersKt.subscribeBy$default((Observable) observeOn, (Function1) r32, (Function0) null, (Function1) new Function1<GemOffer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOffer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GemOffer gemOffer) {
                RxKt.plusAssign(gemViewPort.getOffer(), gemOffer);
            }
        }, 2, (Object) null);
    }
}
