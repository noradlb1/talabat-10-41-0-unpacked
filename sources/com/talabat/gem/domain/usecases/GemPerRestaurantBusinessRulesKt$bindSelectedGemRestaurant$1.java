package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemRestaurant;
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
public final class GemPerRestaurantBusinessRulesKt$bindSelectedGemRestaurant$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemPerRestaurantViewPort f60406g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPerRestaurantBusinessRulesKt$bindSelectedGemRestaurant$1(GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        super(0);
        this.f60406g = gemPerRestaurantViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<GemRestaurant> observeOnSelectedGemRestaurant = IntegrationKt.getDataSources().observeOnSelectedGemRestaurant();
        AnonymousClass1 r22 = new Function1<Throwable, Unit>(this.f60406g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemPerRestaurantViewPort gemPerRestaurantViewPort = this.f60406g;
        return SubscribersKt.subscribeBy$default((Observable) observeOnSelectedGemRestaurant, (Function1) r22, (Function0) null, (Function1) new Function1<GemRestaurant, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemRestaurant) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemRestaurant gemRestaurant) {
                Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                RxKt.plusAssign(gemPerRestaurantViewPort.getSelectedGemRestaurant(), gemRestaurant);
            }
        }, 2, (Object) null);
    }
}
