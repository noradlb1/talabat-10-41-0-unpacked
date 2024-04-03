package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.Location;
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
public final class GemRefreshableBusinessRulesKt$bindLocationsHistory$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemRefreshableViewPort f60418g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f60419h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemRefreshableBusinessRulesKt$bindLocationsHistory$2(GemRefreshableViewPort gemRefreshableViewPort, Function0<Unit> function0) {
        super(0);
        this.f60418g = gemRefreshableViewPort;
        this.f60419h = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final boolean m10580invoke$lambda0(Location location) {
        Intrinsics.checkNotNullParameter(location, "it");
        if (location.getLatitude() == null || location.getLongitude() == null) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<Location> distinctUntilChanged = IntegrationKt.getDataSources().observeOnUserLocation().observeOn(this.f60418g.getScheduler()).filter(new q()).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "DataSources.observeOnUse…  .distinctUntilChanged()");
        AnonymousClass2 r22 = new Function1<Throwable, Unit>(this.f60418g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemRefreshableViewPort gemRefreshableViewPort = this.f60418g;
        final Function0<Unit> function0 = this.f60419h;
        return SubscribersKt.subscribeBy$default((Observable) distinctUntilChanged, (Function1) r22, (Function0) null, (Function1) new Function1<Location, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Location) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Location location) {
                gemRefreshableViewPort.getLocationsHistory().onNext(location);
                function0.invoke();
            }
        }, 2, (Object) null);
    }
}
