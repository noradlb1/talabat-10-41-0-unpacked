package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.presentation.GemRestaurantsViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
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
public final class GemRestaurantsBusinessRulesKt$bindRestaurants$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemRestaurantsViewPort f60425g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemRestaurantsBusinessRulesKt$bindRestaurants$1(GemRestaurantsViewPort gemRestaurantsViewPort) {
        super(0);
        this.f60425g = gemRestaurantsViewPort;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final List m10581invoke$lambda0(GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "it");
        List<GemRestaurant> restaurants = gemOffer.getRestaurants();
        if (restaurants == null) {
            return new ArrayList();
        }
        return restaurants;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<R> map = this.f60425g.getOffer().share().observeOn(this.f60425g.getScheduler()).map(new r());
        Intrinsics.checkNotNullExpressionValue(map, "offer.share()\n        .o…ants ?: mutableListOf() }");
        AnonymousClass2 r32 = new Function1<Throwable, Unit>(this.f60425g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemRestaurantsViewPort gemRestaurantsViewPort = this.f60425g;
        return SubscribersKt.subscribeBy$default((Observable) map, (Function1) r32, (Function0) null, (Function1) new Function1<List<? extends GemRestaurant>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<GemRestaurant>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<GemRestaurant> list) {
                RxKt.plusAssign(gemRestaurantsViewPort.getRestaurants(), list);
            }
        }, 2, (Object) null);
    }
}
