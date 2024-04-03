package com.talabat.gem.adapters.presentation.offer;

import android.widget.ImageView;
import com.talabat.gem.adapters.R;
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
public final class GemOfferMainActivity$initialize$1$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferViewModel f60237g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemOfferMainActivity f60238h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferMainActivity$initialize$1$2(GemOfferViewModel gemOfferViewModel, GemOfferMainActivity gemOfferMainActivity) {
        super(0);
        this.f60237g = gemOfferViewModel;
        this.f60238h = gemOfferMainActivity;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<Boolean> visibility = this.f60237g.getVisibility();
        final GemOfferMainActivity gemOfferMainActivity = this.f60238h;
        return RxKt.invoke(visibility, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                final GemOfferMainActivity gemOfferMainActivity = gemOfferMainActivity;
                on2.next(new Function1<Boolean, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Boolean) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Boolean bool) {
                        if (!bool.booleanValue()) {
                            ((ImageView) gemOfferMainActivity._$_findCachedViewById(R.id.backImageView)).performClick();
                        }
                    }
                });
            }
        });
    }
}
