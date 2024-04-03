package com.talabat.gem.adapters.presentation.checkout;

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
public final class GemCheckoutFooterView$initialize$1$1$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterViewModel f59956g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterView f59957h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutFooterView$initialize$1$1$2(GemCheckoutFooterViewModel gemCheckoutFooterViewModel, GemCheckoutFooterView gemCheckoutFooterView) {
        super(0);
        this.f59956g = gemCheckoutFooterViewModel;
        this.f59957h = gemCheckoutFooterView;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<String> counter = this.f59956g.getCounter();
        final GemCheckoutFooterView gemCheckoutFooterView = this.f59957h;
        return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                final GemCheckoutFooterView gemCheckoutFooterView = gemCheckoutFooterView;
                on2.next(new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        TextView textView = (TextView) gemCheckoutFooterView._$_findCachedViewById(R.id.counterTextView);
                        Intrinsics.checkNotNullExpressionValue(textView, "counterTextView");
                        ViewKt.plusAssign(textView, str);
                    }
                });
            }
        });
    }
}
