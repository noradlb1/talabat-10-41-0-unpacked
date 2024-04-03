package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemExpiredBusinessRulesKt$bindCollectionTriggerExpirationAlert$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemExpiredViewPort f60394g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemExpiredBusinessRulesKt$bindCollectionTriggerExpirationAlert$1(GemExpiredViewPort gemExpiredViewPort) {
        super(0);
        this.f60394g = gemExpiredViewPort;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final boolean m10564invoke$lambda0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return GemExpiredBusinessRulesKt.isSameRestaurant((Triple) pair.getSecond());
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<GemOffer> share = this.f60394g.getExpiredOffer().share();
        Intrinsics.checkNotNullExpressionValue(share, "expiredOffer.share()");
        Observable<Pair<T1, T2>> filter = observables.combineLatest(share, GemExpiredBusinessRulesKt.expiredOfferAndRestaurants(this.f60394g)).share().filter(new k());
        Intrinsics.checkNotNullExpressionValue(filter, "Observables.combineLates…meRestaurant(it.second) }");
        AnonymousClass2 r32 = new Function1<Throwable, Unit>(this.f60394g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemExpiredViewPort gemExpiredViewPort = this.f60394g;
        return SubscribersKt.subscribeBy$default((Observable) filter, (Function1) r32, (Function0) null, (Function1) new Function1<Pair<? extends GemOffer, ? extends Triple<? extends GemOffer, ? extends Integer, ? extends GemRestaurant>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<GemOffer, Triple<GemOffer, Integer, GemRestaurant>>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<GemOffer, Triple<GemOffer, Integer, GemRestaurant>> pair) {
                if (!IntegrationKt.getDataSources().isExpirationAlertShown()) {
                    RxKt.plusAssign(gemExpiredViewPort.getTriggerExpirationAlert(), IntegrationKt.getDataSources().loadTriggerExpirationAlertFlag());
                }
            }
        }, 2, (Object) null);
    }
}
