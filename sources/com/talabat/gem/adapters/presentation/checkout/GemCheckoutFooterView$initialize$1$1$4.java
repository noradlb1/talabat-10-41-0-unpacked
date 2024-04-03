package com.talabat.gem.adapters.presentation.checkout;

import android.content.Context;
import com.talabat.gem.adapters.presentation.expiration.GemExpiredViewKt;
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
public final class GemCheckoutFooterView$initialize$1$1$4 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterViewModel f59964g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f59965h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutFooterView$initialize$1$1$4(GemCheckoutFooterViewModel gemCheckoutFooterViewModel, Context context) {
        super(0);
        this.f59964g = gemCheckoutFooterViewModel;
        this.f59965h = context;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<Function0<Boolean>> triggerExpirationAlert = this.f59964g.getTriggerExpirationAlert();
        final Context context = this.f59965h;
        return RxKt.invoke(triggerExpirationAlert, new Function1<ObserverCallbacks<Function0<? extends Boolean>, Observable<Function0<? extends Boolean>>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<Function0<Boolean>, Observable<Function0<Boolean>>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<Function0<Boolean>, Observable<Function0<Boolean>>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<Function0<Boolean>, Observable<Function0<Boolean>>> on2 = observerCallbacks.getOn();
                final Context context = context;
                on2.next(new Function1<Function0<? extends Boolean>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Function0<Boolean>) (Function0) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function0<Boolean> function0) {
                        Context context = context;
                        Intrinsics.checkNotNullExpressionValue(function0, "it");
                        GemExpiredViewKt.showGemExpiredView$default(context, function0, (Function0) null, false, 6, (Object) null);
                    }
                });
            }
        });
    }
}
