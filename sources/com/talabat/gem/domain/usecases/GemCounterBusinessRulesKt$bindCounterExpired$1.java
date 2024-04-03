package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
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
public final class GemCounterBusinessRulesKt$bindCounterExpired$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f60374g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCounterBusinessRulesKt$bindCounterExpired$1(GemCounterViewPort gemCounterViewPort) {
        super(0);
        this.f60374g = gemCounterViewPort;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final boolean m10561invoke$lambda0(GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "it");
        return !Intrinsics.areEqual((Object) gemOffer, (Object) BusinessRulesKt.getNullGemOffer());
    }

    @Nullable
    public final Disposable invoke() {
        RxKt.plusAssign(this.f60374g.getCounterExpired(), Boolean.FALSE);
        Observable<GemOffer> filter = IntegrationKt.getDataSources().observeOnExpiredOffer().share().filter(new i());
        Intrinsics.checkNotNullExpressionValue(filter, "DataSources.observeOnExp…er { it != NullGemOffer }");
        AnonymousClass2 r32 = new Function1<Throwable, Unit>(this.f60374g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemCounterViewPort gemCounterViewPort = this.f60374g;
        return SubscribersKt.subscribeBy$default((Observable) filter, (Function1) r32, (Function0) null, (Function1) new Function1<GemOffer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOffer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GemOffer gemOffer) {
                RxKt.plusAssign(gemCounterViewPort.getCounterExpired(), Boolean.TRUE);
            }
        }, 2, (Object) null);
    }
}
