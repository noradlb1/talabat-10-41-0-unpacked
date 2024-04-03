package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
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
public final class GemTiersBusinessRulesKt$bindStaticTiersMode$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemTiersViewPort f60436g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemTiersBusinessRulesKt$bindStaticTiersMode$1(GemTiersViewPort gemTiersViewPort) {
        super(0);
        this.f60436g = gemTiersViewPort;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m10583invoke$lambda0(List list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "it");
        if (list.size() == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    @Nullable
    public final Disposable invoke() {
        RxKt.plusAssign(this.f60436g.getStaticTiersMode(), Boolean.FALSE);
        Observable<R> map = this.f60436g.getTiers().share().map(new t());
        Intrinsics.checkNotNullExpressionValue(map, "tiers.share().map { it.size == STATIC_TIERS_MODE }");
        AnonymousClass2 r32 = new Function1<Throwable, Unit>(this.f60436g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemTiersViewPort gemTiersViewPort = this.f60436g;
        return SubscribersKt.subscribeBy$default((Observable) map, (Function1) r32, (Function0) null, (Function1) new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                RxKt.plusAssign(gemTiersViewPort.getStaticTiersMode(), bool);
            }
        }, 2, (Object) null);
    }
}
