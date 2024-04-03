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
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSubTotalBusinessRulesKt$bindSubTitleLineOne$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemSubTotalViewPort f60429g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSubTotalBusinessRulesKt$bindSubTitleLineOne$1(GemSubTotalViewPort gemSubTotalViewPort) {
        super(0);
        this.f60429g = gemSubTotalViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<String> share = this.f60429g.getCurrency().share();
        Intrinsics.checkNotNullExpressionValue(share, "currency.share()");
        Observable<List<GemTier>> share2 = this.f60429g.getTiers().share();
        Intrinsics.checkNotNullExpressionValue(share2, "tiers.share()");
        Observable<Double> share3 = this.f60429g.getSubTotal().share();
        Intrinsics.checkNotNullExpressionValue(share3, "subTotal.share()");
        Observable<Triple<T1, T2, T3>> combineLatest = observables.combineLatest(share, share2, share3);
        AnonymousClass1 r62 = new Function1<Throwable, Unit>(this.f60429g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemSubTotalViewPort gemSubTotalViewPort = this.f60429g;
        return SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) r62, (Function0) null, (Function1) new Function1<Triple<? extends String, ? extends List<? extends GemTier>, ? extends Double>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Triple<String, ? extends List<GemTier>, Double>) (Triple) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Triple<String, ? extends List<GemTier>, Double> triple) {
                String str;
                Intrinsics.checkNotNullParameter(triple, "it");
                Object second = triple.getSecond();
                Intrinsics.checkNotNullExpressionValue(second, "it.second");
                Double third = triple.getThird();
                Intrinsics.checkNotNullExpressionValue(third, "it.third");
                GemTier subTotalTier = BusinessRulesKt.subTotalTier((List) second, third.doubleValue());
                BehaviorSubject<SubTotalLineOne> subTitleLineOne = gemSubTotalViewPort.getSubTitleLineOne();
                String first = triple.getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "it.first");
                String str2 = first;
                DecimalFormat decimalFormat = BusinessRulesKt.getDecimalFormat();
                Double third2 = triple.getThird();
                Intrinsics.checkNotNullExpressionValue(third2, "it.third");
                String format = decimalFormat.format(third2.doubleValue());
                Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat.format(it.third)");
                boolean z11 = subTotalTier != null;
                String color = subTotalTier != null ? subTotalTier.getColor() : null;
                if (subTotalTier != null) {
                    Double third3 = triple.getThird();
                    Intrinsics.checkNotNullExpressionValue(third3, "it.third");
                    str = GemSubTotalBusinessRulesKt.subTotalAfterDiscount(subTotalTier, third3.doubleValue());
                } else {
                    str = null;
                }
                RxKt.plusAssign(subTitleLineOne, new SubTotalLineOne(str2, format, z11, color, str));
            }
        }, 2, (Object) null);
    }
}
