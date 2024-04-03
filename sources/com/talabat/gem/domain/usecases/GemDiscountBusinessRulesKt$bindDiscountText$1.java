package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemDiscountViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemDiscountBusinessRulesKt$bindDiscountText$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemDiscountViewPort f60388g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemDiscountBusinessRulesKt$bindDiscountText$1(GemDiscountViewPort gemDiscountViewPort) {
        super(0);
        this.f60388g = gemDiscountViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<Double> share = this.f60388g.getDiscountAmount().share();
        Intrinsics.checkNotNullExpressionValue(share, "discountAmount.share()");
        Observable<String> share2 = this.f60388g.getCurrency().share();
        Intrinsics.checkNotNullExpressionValue(share2, "currency.share()");
        Observable<Pair<T1, T2>> combineLatest = observables.combineLatest(share, share2);
        AnonymousClass1 r52 = new Function1<Throwable, Unit>(this.f60388g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemDiscountViewPort gemDiscountViewPort = this.f60388g;
        return SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) r52, (Function0) null, (Function1) new Function1<Pair<? extends Double, ? extends String>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<Double, String>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Pair<Double, String> pair) {
                Intrinsics.checkNotNullParameter(pair, "it");
                BehaviorSubject<String> discountText = gemDiscountViewPort.getDiscountText();
                Double first = pair.getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "it.first");
                double doubleValue = first.doubleValue();
                String second = pair.getSecond();
                Intrinsics.checkNotNullExpressionValue(second, "it.second");
                RxKt.plusAssign(discountText, GemDiscountBusinessRulesKt.formatDiscountText(doubleValue, second));
            }
        }, 2, (Object) null);
    }
}
