package com.talabat.gem.adapters.presentation.restaurants;

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
public final class GemFloatingView$initialize$1$1$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60291g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60292h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$1$2(GemFloatingViewModel gemFloatingViewModel, GemFloatingView gemFloatingView) {
        super(0);
        this.f60291g = gemFloatingViewModel;
        this.f60292h = gemFloatingView;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<Boolean> visibility = this.f60291g.getVisibility();
        final GemFloatingView gemFloatingView = this.f60292h;
        final GemFloatingViewModel gemFloatingViewModel = this.f60291g;
        return RxKt.invoke(visibility, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                final GemFloatingView gemFloatingView = gemFloatingView;
                final GemFloatingViewModel gemFloatingViewModel = gemFloatingViewModel;
                on2.next(new Function1<Boolean, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Boolean) obj);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void invoke(java.lang.Boolean r5) {
                        /*
                            r4 = this;
                            com.talabat.gem.adapters.presentation.restaurants.GemFloatingView r0 = r1
                            int r1 = com.talabat.gem.adapters.R.id.gemFloatingLayout
                            android.view.View r0 = r0._$_findCachedViewById(r1)
                            androidx.cardview.widget.CardView r0 = (androidx.cardview.widget.CardView) r0
                            java.lang.String r1 = "gemFloatingLayout"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                            com.talabat.gem.adapters.presentation.restaurants.GemFloatingViewModel r1 = r2
                            io.reactivex.subjects.BehaviorSubject r1 = r1.getMode()
                            java.lang.Object r1 = com.talabat.talabatcommon.extentions.RxKt.invoke(r1)
                            com.talabat.gem.domain.entities.GemMode r2 = com.talabat.gem.domain.entities.GemMode.DISABLED
                            java.lang.String r3 = "it"
                            if (r1 == r2) goto L_0x003a
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
                            boolean r1 = r5.booleanValue()
                            if (r1 == 0) goto L_0x003a
                            kotlin.jvm.functions.Function0 r1 = com.talabat.gem.integration.Gem.isGemFloatingButtonEnabled()
                            java.lang.Object r1 = r1.invoke()
                            java.lang.String r2 = "Control"
                            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                            if (r1 == 0) goto L_0x003a
                            r1 = 1
                            goto L_0x003b
                        L_0x003a:
                            r1 = 0
                        L_0x003b:
                            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                            r2 = 8
                            com.talabat.talabatcommon.extension.ViewKt.get(r0, r1, r2)
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
                            boolean r0 = r5.booleanValue()
                            if (r0 == 0) goto L_0x0060
                            com.talabat.gem.adapters.presentation.restaurants.GemFloatingView r0 = r1
                            com.talabat.talabatcommon.extentions.SingleAccess r0 = r0.onEnabledAction
                            if (r0 == 0) goto L_0x0060
                            java.lang.Object r0 = r0.getValue()
                            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
                            if (r0 == 0) goto L_0x0060
                            r0.invoke()
                        L_0x0060:
                            boolean r5 = r5.booleanValue()
                            if (r5 != 0) goto L_0x0079
                            com.talabat.gem.adapters.presentation.restaurants.GemFloatingView r5 = r1
                            com.talabat.talabatcommon.extentions.SingleAccess r5 = r5.onDisabledAction
                            if (r5 == 0) goto L_0x0079
                            java.lang.Object r5 = r5.getValue()
                            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                            if (r5 == 0) goto L_0x0079
                            r5.invoke()
                        L_0x0079:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.presentation.restaurants.GemFloatingView$initialize$1$1$2.AnonymousClass1.AnonymousClass1.invoke(java.lang.Boolean):void");
                    }
                });
            }
        });
    }
}
