package com.talabat.gem.adapters.presentation.restaurants;

import android.widget.TextView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
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
public final class GemFloatingView$initialize$1$1$4 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60301g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60302h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$1$4(GemFloatingViewModel gemFloatingViewModel, GemFloatingView gemFloatingView) {
        super(0);
        this.f60301g = gemFloatingViewModel;
        this.f60302h = gemFloatingView;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<SaveUpToAmountText> saveUpToAmountText = this.f60301g.getSaveUpToAmountText();
        final GemFloatingView gemFloatingView = this.f60302h;
        return RxKt.invoke(saveUpToAmountText, new Function1<ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>> on2 = observerCallbacks.getOn();
                final GemFloatingView gemFloatingView = gemFloatingView;
                on2.next(new Function1<SaveUpToAmountText, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SaveUpToAmountText) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SaveUpToAmountText saveUpToAmountText) {
                        TextView textView = (TextView) gemFloatingView._$_findCachedViewById(R.id.saveUpToTextView);
                        Intrinsics.checkNotNullExpressionValue(textView, "saveUpToTextView");
                        Intrinsics.checkNotNullExpressionValue(saveUpToAmountText, "it");
                        ViewKt.plusAssign(textView, GemEntryBusinessRulesKt.getTitle(saveUpToAmountText));
                    }
                });
            }
        });
    }
}
