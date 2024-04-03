package com.talabat.gem.adapters.presentation.collections.list;

import android.widget.TextView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.offer.GemOfferViewModel;
import com.talabat.gem.ports.presentation.GemOfferTitleViewPortKt;
import com.talabat.gem.ports.presentation.TitleData;
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
public final class GemCollectionActivity$initialize$1$4 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60028g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCollectionActivity f60029h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionActivity$initialize$1$4(GemOfferViewModel gemOfferViewModel, GemCollectionActivity gemCollectionActivity) {
        super(0);
        this.f60028g = gemOfferViewModel;
        this.f60029h = gemCollectionActivity;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<TitleData> titleData = this.f60028g.getTitleData();
        final GemCollectionActivity gemCollectionActivity = this.f60029h;
        return RxKt.invoke(titleData, new Function1<ObserverCallbacks<TitleData, Observable<TitleData>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<TitleData, Observable<TitleData>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<TitleData, Observable<TitleData>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<TitleData, Observable<TitleData>> on2 = observerCallbacks.getOn();
                final GemCollectionActivity gemCollectionActivity = gemCollectionActivity;
                on2.next(new Function1<TitleData, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((TitleData) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(TitleData titleData) {
                        Intrinsics.checkNotNullExpressionValue(titleData, "it");
                        ((CollapsingToolbarLayout) gemCollectionActivity._$_findCachedViewById(R.id.collapsingToolbar)).setTitle(GemOfferTitleViewPortKt.getTitle(titleData));
                        TextView textView = (TextView) gemCollectionActivity._$_findCachedViewById(R.id.subTitleTextView);
                        Intrinsics.checkNotNullExpressionValue(textView, "subTitleTextView");
                        ViewKt.plusAssign(textView, GemOfferTitleViewPortKt.getSubTitle(titleData));
                    }
                });
            }
        });
    }
}
