package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.ports.presentation.GemRefreshableViewPort;
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
public final class GemRefreshableBusinessRulesKt$bindLocalizationHistory$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemRefreshableViewPort f60413g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f60414h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemRefreshableBusinessRulesKt$bindLocalizationHistory$2(GemRefreshableViewPort gemRefreshableViewPort, Function0<Unit> function0) {
        super(0);
        this.f60413g = gemRefreshableViewPort;
        this.f60414h = function0;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<String> distinctUntilChanged = IntegrationKt.getDataSources().observeOnLocalization().observeOn(this.f60413g.getScheduler()).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "DataSources.observeOnLoc…  .distinctUntilChanged()");
        AnonymousClass1 r22 = new Function1<Throwable, Unit>(this.f60413g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemRefreshableViewPort gemRefreshableViewPort = this.f60413g;
        final Function0<Unit> function0 = this.f60414h;
        return SubscribersKt.subscribeBy$default((Observable) distinctUntilChanged, (Function1) r22, (Function0) null, (Function1) new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                gemRefreshableViewPort.getLocalizationHistory().onNext(str);
                function0.invoke();
            }
        }, 2, (Object) null);
    }
}
