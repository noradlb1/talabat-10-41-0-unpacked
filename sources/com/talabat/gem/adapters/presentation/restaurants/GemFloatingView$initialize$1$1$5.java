package com.talabat.gem.adapters.presentation.restaurants;

import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.integration.Gem;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFloatingView$initialize$1$1$5 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60305g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60306h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$1$5(GemFloatingViewModel gemFloatingViewModel, GemFloatingView gemFloatingView) {
        super(0);
        this.f60305g = gemFloatingViewModel;
        this.f60306h = gemFloatingView;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<GemMode> mode = this.f60305g.getMode();
        final GemFloatingViewModel gemFloatingViewModel = this.f60305g;
        final GemFloatingView gemFloatingView = this.f60306h;
        return RxKt.invoke(mode, new Function1<ObserverCallbacks<GemMode, Observable<GemMode>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<GemMode, Observable<GemMode>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final ObserverCallbacks<GemMode, Observable<GemMode>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<GemMode, Observable<GemMode>> on2 = observerCallbacks.getOn();
                final GemFloatingViewModel gemFloatingViewModel = gemFloatingViewModel;
                final GemFloatingView gemFloatingView = gemFloatingView;
                on2.next(new Function1<GemMode, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemMode) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GemMode gemMode) {
                        ObserverCallbacks<GemMode, Observable<GemMode>> observerCallbacks = observerCallbacks;
                        GemFloatingViewModel gemFloatingViewModel = gemFloatingViewModel;
                        if (!(Intrinsics.areEqual(RxKt.invoke(gemFloatingViewModel.getVisibility()), (Object) Boolean.TRUE) && RxKt.invoke(gemFloatingViewModel.getMode()) != GemMode.DISABLED && Intrinsics.areEqual((Object) Gem.isGemFloatingButtonEnabled().invoke(), (Object) "Control") && Intrinsics.areEqual((Object) Gem.getShowGemPopupChecker().invoke(), (Object) "Control"))) {
                            observerCallbacks = null;
                        }
                        if (observerCallbacks != null) {
                            GemFloatingView gemFloatingView = gemFloatingView;
                            gemFloatingView.openOffers(gemFloatingView);
                        }
                    }
                });
            }
        });
    }
}
