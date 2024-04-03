package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.ports.presentation.GemAutoTriggerOfferViewPort;
import com.talabat.talabatcommon.extentions.Flag;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
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
public final class GemAutoTriggerOfferBusinessRulesKt$bindAutoTriggerOffer$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAutoTriggerOfferViewPort f60368g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAutoTriggerOfferBusinessRulesKt$bindAutoTriggerOffer$1(GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort) {
        super(0);
        this.f60368g = gemAutoTriggerOfferViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<GemMode> share = this.f60368g.getMode().share();
        Intrinsics.checkNotNullExpressionValue(share, "mode.share()");
        Observable<String> share2 = this.f60368g.getCounter().share();
        Intrinsics.checkNotNullExpressionValue(share2, "counter.share()");
        Observable<Pair<T1, T2>> combineLatest = observables.combineLatest(share, share2);
        AnonymousClass1 r52 = new Function1<Throwable, Unit>(this.f60368g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemAutoTriggerOfferViewPort gemAutoTriggerOfferViewPort = this.f60368g;
        return SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) r52, (Function0) null, (Function1) new Function1<Pair<? extends GemMode, ? extends String>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<? extends GemMode, String>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Pair<? extends GemMode, String> pair) {
                Intrinsics.checkNotNullParameter(pair, "it");
                if (pair.getFirst() != GemMode.DISABLED && !IntegrationKt.getDataSources().isOfferAutoTriggered()) {
                    RxKt.plusAssign(gemAutoTriggerOfferViewPort.getAutoTriggerOffer(), new Flag(true));
                    IntegrationKt.getDataSources().saveOfferAutoTriggered(true);
                }
            }
        }, 2, (Object) null);
    }
}
