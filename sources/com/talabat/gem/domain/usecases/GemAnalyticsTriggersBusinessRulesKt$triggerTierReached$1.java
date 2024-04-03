package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.analytics.GemAnalyticsTriggersPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
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
public final class GemAnalyticsTriggersBusinessRulesKt$triggerTierReached$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalyticsTriggersPort f60366g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalyticsTriggersBusinessRulesKt$triggerTierReached$1(GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        super(0);
        this.f60366g = gemAnalyticsTriggersPort;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final boolean m10548invoke$lambda0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return GemAnalyticsTriggersBusinessRulesKt.isGemRestaurantSelected();
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<GemOffer> share = this.f60366g.getOffer().share();
        Intrinsics.checkNotNullExpressionValue(share, "offer.share()");
        Observable<Double> share2 = this.f60366g.getSubTotal().share();
        Intrinsics.checkNotNullExpressionValue(share2, "subTotal.share()");
        Observable<Pair<T1, T2>> filter = observables.combineLatest(share, share2).observeOn(this.f60366g.getScheduler()).filter(new e());
        Intrinsics.checkNotNullExpressionValue(filter, "Observables.combineLates…GemRestaurantSelected() }");
        AnonymousClass2 r32 = new Function1<Throwable, Unit>(this.f60366g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemAnalyticsTriggersPort gemAnalyticsTriggersPort = this.f60366g;
        return SubscribersKt.subscribeBy$default((Observable) filter, (Function1) r32, (Function0) null, (Function1) new Function1<Pair<? extends GemOffer, ? extends Double>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<GemOffer, Double>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<GemOffer, Double> pair) {
                List<GemTier> tiers = pair.getFirst().getTiers();
                if (tiers != null) {
                    Double second = pair.getSecond();
                    Intrinsics.checkNotNullExpressionValue(second, "it.second");
                    GemTier subTotalTier = BusinessRulesKt.subTotalTier(tiers, second.doubleValue());
                    if (subTotalTier != null) {
                        com.talabat.talabatcommon.extentions.Nullable nullable = (com.talabat.talabatcommon.extentions.Nullable) RxKt.invoke(gemAnalyticsTriggersPort.getLastTierReached());
                        if (!Intrinsics.areEqual((Object) subTotalTier, (Object) nullable != null ? (GemTier) nullable.getValue() : null)) {
                            IntegrationKt.getAnalytics().onGemTierReached();
                        }
                        RxKt.plusAssign(gemAnalyticsTriggersPort.getLastTierReached(), new com.talabat.talabatcommon.extentions.Nullable(subTotalTier));
                    }
                }
            }
        }, 2, (Object) null);
    }
}
