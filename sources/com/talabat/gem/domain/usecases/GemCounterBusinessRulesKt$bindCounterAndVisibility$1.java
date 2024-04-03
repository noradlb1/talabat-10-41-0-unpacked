package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
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
public final class GemCounterBusinessRulesKt$bindCounterAndVisibility$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f60370g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Long f60371h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCounterBusinessRulesKt$bindCounterAndVisibility$1(GemCounterViewPort gemCounterViewPort, Long l11) {
        super(0);
        this.f60370g = gemCounterViewPort;
        this.f60371h = l11;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final String m10558invoke$lambda0(GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "it");
        return gemOffer.getId();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m10559invoke$lambda1(GemCounterViewPort gemCounterViewPort, Throwable th2) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "$this_bindCounterAndVisibility");
        RxKt.plusAssign(gemCounterViewPort.getVisibility(), Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m10560invoke$lambda2(GemCounterViewPort gemCounterViewPort) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "$this_bindCounterAndVisibility");
        RxKt.plusAssign(gemCounterViewPort.getVisibility(), Boolean.FALSE);
    }

    @Nullable
    public final Disposable invoke() {
        Observable<GemOffer> doOnComplete = this.f60370g.getOffer().share().distinct(new f()).observeOn(this.f60370g.getScheduler()).doOnError(new g(this.f60370g)).doOnComplete(new h(this.f60370g));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "offer.share()\n          …e { visibility += false }");
        AnonymousClass4 r42 = new Function1<Throwable, Unit>(this.f60370g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemCounterViewPort gemCounterViewPort = this.f60370g;
        final Long l11 = this.f60371h;
        return SubscribersKt.subscribeBy$default((Observable) doOnComplete, (Function1) r42, (Function0) null, (Function1) new Function1<GemOffer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOffer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GemOffer gemOffer) {
                Disposable disposable = (Disposable) RxKt.invoke(gemCounterViewPort.getCounterSubscription());
                if (disposable != null) {
                    if (disposable.isDisposed()) {
                        disposable = null;
                    }
                    if (disposable != null) {
                        disposable.dispose();
                    }
                }
                BehaviorSubject<Disposable> counterSubscription = gemCounterViewPort.getCounterSubscription();
                GemCounterViewPort gemCounterViewPort = gemCounterViewPort;
                Intrinsics.checkNotNullExpressionValue(gemOffer, "offer");
                RxKt.plusAssign(counterSubscription, GemCounterBusinessRulesKt.countdownTimerSubscription(gemCounterViewPort, gemOffer, l11));
            }
        }, 2, (Object) null);
    }
}
