package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemDiscountViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
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
public final class GemDiscountBusinessRulesKt$bindDiscountAmount$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemDiscountViewPort f60386g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemDiscountBusinessRulesKt$bindDiscountAmount$1(GemDiscountViewPort gemDiscountViewPort) {
        super(0);
        this.f60386g = gemDiscountViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<List<GemTier>> share = this.f60386g.getTiers().share();
        Intrinsics.checkNotNullExpressionValue(share, "tiers.share()");
        Observable<Double> share2 = this.f60386g.getSubTotal().share();
        Intrinsics.checkNotNullExpressionValue(share2, "subTotal.share()");
        Observable<Pair<T1, T2>> combineLatest = observables.combineLatest(share, share2);
        AnonymousClass1 r52 = new Function1<Throwable, Unit>(this.f60386g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemDiscountViewPort gemDiscountViewPort = this.f60386g;
        return SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) r52, (Function0) null, (Function1) new Function1<Pair<? extends List<? extends GemTier>, ? extends Double>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<? extends List<GemTier>, Double>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Pair<? extends List<GemTier>, Double> pair) {
                double d11;
                Intrinsics.checkNotNullParameter(pair, "it");
                if (((Boolean) RxKt.get(gemDiscountViewPort.getVisibilityPerRestaurant(), Boolean.FALSE)).booleanValue()) {
                    BehaviorSubject<Double> discountAmount = gemDiscountViewPort.getDiscountAmount();
                    Object first = pair.getFirst();
                    Intrinsics.checkNotNullExpressionValue(first, "it.first");
                    Double second = pair.getSecond();
                    Intrinsics.checkNotNullExpressionValue(second, "it.second");
                    GemTier subTotalTier = BusinessRulesKt.subTotalTier((List) first, second.doubleValue());
                    if (subTotalTier != null) {
                        Double second2 = pair.getSecond();
                        Intrinsics.checkNotNullExpressionValue(second2, "it.second");
                        Double savedAmount = GemDiscountBusinessRulesKt.toSavedAmount(subTotalTier, second2.doubleValue());
                        if (savedAmount != null) {
                            d11 = savedAmount.doubleValue();
                            RxKt.plusAssign(discountAmount, Double.valueOf(d11));
                        }
                    }
                    d11 = 0.0d;
                    RxKt.plusAssign(discountAmount, Double.valueOf(d11));
                }
            }
        }, 2, (Object) null);
    }
}
