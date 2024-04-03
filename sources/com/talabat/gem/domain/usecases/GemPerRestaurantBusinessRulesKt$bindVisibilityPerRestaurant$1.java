package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.Subject;
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
public final class GemPerRestaurantBusinessRulesKt$bindVisibilityPerRestaurant$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemPerRestaurantViewPort f60410g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPerRestaurantBusinessRulesKt$bindVisibilityPerRestaurant$1(GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        super(0);
        this.f60410g = gemPerRestaurantViewPort;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m10578invoke$lambda0(Triple triple) {
        Intrinsics.checkNotNullParameter(triple, "it");
        return Boolean.valueOf(GemPerRestaurantBusinessRulesKt.isVisibleAndSameRestaurant(triple));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m10579invoke$lambda1(GemPerRestaurantViewPort gemPerRestaurantViewPort, Throwable th2) {
        Intrinsics.checkNotNullParameter(gemPerRestaurantViewPort, "$this_bindVisibilityPerRestaurant");
        RxKt.plusAssign(gemPerRestaurantViewPort.getVisibilityPerRestaurant(), Boolean.FALSE);
    }

    @Nullable
    public final Disposable invoke() {
        RxKt.plusAssign(this.f60410g.getVisibilityPerRestaurant(), Boolean.FALSE);
        Observable doOnError = GemPerRestaurantBusinessRulesKt.visibilityObservables(this.f60410g).map(new o()).doOnError(new p(this.f60410g));
        Intrinsics.checkNotNullExpressionValue(doOnError, "visibilityObservables()\n…yPerRestaurant += false }");
        AnonymousClass3 r42 = new Function1<Throwable, Unit>(this.f60410g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemPerRestaurantViewPort gemPerRestaurantViewPort = this.f60410g;
        return SubscribersKt.subscribeBy$default(doOnError, (Function1) r42, (Function0) null, (Function1) new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                RxKt.plusAssign(gemPerRestaurantViewPort.getVisibilityPerRestaurant(), bool);
            }
        }, 2, (Object) null);
    }
}
