package com.talabat.gem.adapters.presentation.restaurants;

import android.widget.TextView;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcommon.extension.ViewKt;
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
public final class GemFloatingView$initialize$1$1$3 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60297g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60298h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$1$3(GemFloatingViewModel gemFloatingViewModel, GemFloatingView gemFloatingView) {
        super(0);
        this.f60297g = gemFloatingViewModel;
        this.f60298h = gemFloatingView;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<String> counter = this.f60297g.getCounter();
        final GemFloatingView gemFloatingView = this.f60298h;
        return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                final GemFloatingView gemFloatingView = gemFloatingView;
                on2.next(new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        TextView textView = (TextView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingCounterTextView);
                        Intrinsics.checkNotNullExpressionValue(textView, "gemFloatingCounterTextView");
                        ViewKt.plusAssign(textView, str);
                    }
                });
            }
        });
    }
}
