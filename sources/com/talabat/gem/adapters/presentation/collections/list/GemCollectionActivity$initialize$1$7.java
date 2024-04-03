package com.talabat.gem.adapters.presentation.collections.list;

import android.widget.TextView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.offer.GemOfferViewModel;
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
public final class GemCollectionActivity$initialize$1$7 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60045g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCollectionActivity f60046h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionActivity$initialize$1$7(GemOfferViewModel gemOfferViewModel, GemCollectionActivity gemCollectionActivity) {
        super(0);
        this.f60045g = gemOfferViewModel;
        this.f60046h = gemCollectionActivity;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<String> counter = this.f60045g.getCounter();
        final GemCollectionActivity gemCollectionActivity = this.f60046h;
        return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                final GemCollectionActivity gemCollectionActivity = gemCollectionActivity;
                on2.next(new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        TextView textView = (TextView) gemCollectionActivity._$_findCachedViewById(R.id.counterTextView);
                        Intrinsics.checkNotNullExpressionValue(textView, "counterTextView");
                        ViewKt.plusAssign(textView, str);
                        TextView textView2 = (TextView) gemCollectionActivity._$_findCachedViewById(R.id.counterTextView_toolbar);
                        Intrinsics.checkNotNullExpressionValue(textView2, "counterTextView_toolbar");
                        ViewKt.plusAssign(textView2, str);
                    }
                });
            }
        });
    }
}
