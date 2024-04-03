package com.talabat.gem.adapters.presentation.checkout;

import android.widget.LinearLayout;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
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
public final class GemCheckoutFooterView$initialize$1$1$3 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterViewModel f59960g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterView f59961h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutFooterView$initialize$1$1$3(GemCheckoutFooterViewModel gemCheckoutFooterViewModel, GemCheckoutFooterView gemCheckoutFooterView) {
        super(0);
        this.f59960g = gemCheckoutFooterViewModel;
        this.f59961h = gemCheckoutFooterView;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<Boolean> visibilityPerRestaurant = this.f59960g.getVisibilityPerRestaurant();
        final GemCheckoutFooterView gemCheckoutFooterView = this.f59961h;
        return RxKt.invoke(visibilityPerRestaurant, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                final GemCheckoutFooterView gemCheckoutFooterView = gemCheckoutFooterView;
                on2.next(new Function1<Boolean, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Boolean) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Boolean bool) {
                        SingleAccess access$getOnDisabledAction$p;
                        Function0 function0;
                        SingleAccess access$getOnEnabledAction$p;
                        Function0 function02;
                        LinearLayout linearLayout = (LinearLayout) gemCheckoutFooterView._$_findCachedViewById(R.id.timerContainer);
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "timerContainer");
                        ViewKt.get(linearLayout, bool, 8);
                        Intrinsics.checkNotNullExpressionValue(bool, "it");
                        if (!(!bool.booleanValue() || (access$getOnEnabledAction$p = gemCheckoutFooterView.onEnabledAction) == null || (function02 = (Function0) access$getOnEnabledAction$p.getValue()) == null)) {
                            function02.invoke();
                        }
                        if (!bool.booleanValue() && (access$getOnDisabledAction$p = gemCheckoutFooterView.onDisabledAction) != null && (function0 = (Function0) access$getOnDisabledAction$p.getValue()) != null) {
                            function0.invoke();
                        }
                    }
                });
            }
        });
    }
}
