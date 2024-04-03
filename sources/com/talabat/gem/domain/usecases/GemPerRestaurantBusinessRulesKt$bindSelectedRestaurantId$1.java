package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemPerRestaurantBusinessRulesKt$bindSelectedRestaurantId$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemPerRestaurantViewPort f60408g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPerRestaurantBusinessRulesKt$bindSelectedRestaurantId$1(GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        super(0);
        this.f60408g = gemPerRestaurantViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<Integer> share = IntegrationKt.getDataSources().observeOnSelectedRestaurantId().share();
        Intrinsics.checkNotNullExpressionValue(share, "DataSources.observeOnSel…tedRestaurantId().share()");
        AnonymousClass1 r22 = new Function1<Throwable, Unit>(this.f60408g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemPerRestaurantViewPort gemPerRestaurantViewPort = this.f60408g;
        return SubscribersKt.subscribeBy$default((Observable) share, (Function1) r22, (Function0) null, (Function1) new Function1<Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                RxKt.plusAssign(gemPerRestaurantViewPort.getSelectedRestaurantId(), num);
            }
        }, 2, (Object) null);
    }
}
