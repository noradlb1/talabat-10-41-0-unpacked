package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemSubTotalViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSubTotalBusinessRulesKt$bindSubTitleLineTwo$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemSubTotalViewPort f60431g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSubTotalBusinessRulesKt$bindSubTitleLineTwo$1(GemSubTotalViewPort gemSubTotalViewPort) {
        super(0);
        this.f60431g = gemSubTotalViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<String> share = this.f60431g.getCurrency().share();
        Intrinsics.checkNotNullExpressionValue(share, "currency.share()");
        Observable<Double> share2 = this.f60431g.getSubTotal().share();
        Intrinsics.checkNotNullExpressionValue(share2, "subTotal.share()");
        Observable<List<GemTier>> share3 = this.f60431g.getTiers().share();
        Intrinsics.checkNotNullExpressionValue(share3, "tiers.share()");
        Observable<Triple<T1, T2, T3>> observeOn = observables.combineLatest(share, share2, share3).observeOn(this.f60431g.getScheduler());
        Intrinsics.checkNotNullExpressionValue(observeOn, "combineLatest(currency.s…    .observeOn(scheduler)");
        AnonymousClass1 r32 = new Function1<Throwable, Unit>(this.f60431g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemSubTotalViewPort gemSubTotalViewPort = this.f60431g;
        return SubscribersKt.subscribeBy$default((Observable) observeOn, (Function1) r32, (Function0) null, (Function1) new Function1<Triple<? extends String, ? extends Double, ? extends List<? extends GemTier>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Triple<String, Double, ? extends List<GemTier>>) (Triple) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Triple<String, Double, ? extends List<GemTier>> triple) {
                Object third = triple.getThird();
                Intrinsics.checkNotNullExpressionValue(third, "it.third");
                if (!GemSubTotalBusinessRulesKt.isNotValidTiers((List) third)) {
                    Double second = triple.getSecond();
                    double doubleValue = second == null ? 0.0d : second.doubleValue();
                    Intrinsics.checkNotNullExpressionValue(triple, "it");
                    GemTier nextGemTier = GemSubTotalBusinessRulesKt.nextGemTier(doubleValue, triple);
                    BehaviorSubject<SubTotalLineTwo> subTitleLineTwo = gemSubTotalViewPort.getSubTitleLineTwo();
                    String first = triple.getFirst();
                    Intrinsics.checkNotNullExpressionValue(first, "it.first");
                    String addAmount = GemSubTotalBusinessRulesKt.addAmount(nextGemTier, doubleValue);
                    Intrinsics.checkNotNullExpressionValue(addAmount, "addAmount(nextTier, subTotalAmount)");
                    String format = BusinessRulesKt.getDecimalFormat().format(BusinessRulesKt.savedAmount(nextGemTier));
                    Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat.format(nextTier.savedAmount())");
                    Object third2 = triple.getThird();
                    Intrinsics.checkNotNullExpressionValue(third2, "it.third");
                    RxKt.plusAssign(subTitleLineTwo, new SubTotalLineTwo(first, addAmount, format, GemSubTotalBusinessRulesKt.isMaximumTierReached(doubleValue, (List) third2), (String) null, 16, (DefaultConstructorMarker) null));
                }
            }
        }, 2, (Object) null);
    }
}
