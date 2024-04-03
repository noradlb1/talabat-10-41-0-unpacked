package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemSubTotalViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSubTotalBusinessRulesKt$bindCurrency$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemSubTotalViewPort f60427g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSubTotalBusinessRulesKt$bindCurrency$1(GemSubTotalViewPort gemSubTotalViewPort) {
        super(0);
        this.f60427g = gemSubTotalViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<List<GemTier>> share = this.f60427g.getTiers().share();
        Intrinsics.checkNotNullExpressionValue(share, "tiers.share()");
        AnonymousClass1 r22 = new Function1<Throwable, Unit>(this.f60427g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemSubTotalViewPort gemSubTotalViewPort = this.f60427g;
        return SubscribersKt.subscribeBy$default((Observable) share, (Function1) r22, (Function0) null, (Function1) new Function1<List<? extends GemTier>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<GemTier>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<GemTier> list) {
                BehaviorSubject<String> currency = gemSubTotalViewPort.getCurrency();
                Intrinsics.checkNotNullExpressionValue(list, "it");
                RxKt.plusAssign(currency, GemSubTotalBusinessRulesKt.toCurrency(list));
            }
        }, 2, (Object) null);
    }
}
