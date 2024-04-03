package com.talabat.gem.adapters.presentation;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.talabat.gem.adapters.R;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TiersBindingKt$bindTiersViews$3$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemTiersViewPort f59898g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f59899h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiersBindingKt$bindTiersViews$3$2(GemTiersViewPort gemTiersViewPort, Activity activity) {
        super(0);
        this.f59898g = gemTiersViewPort;
        this.f59899h = activity;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<List<GemTier>> tiers = this.f59898g.getTiers();
        final Activity activity = this.f59899h;
        return RxKt.invoke(tiers, new Function1<ObserverCallbacks<List<? extends GemTier>, Observable<List<? extends GemTier>>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<List<GemTier>, Observable<List<GemTier>>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<List<GemTier>, Observable<List<GemTier>>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<List<GemTier>, Observable<List<GemTier>>> on2 = observerCallbacks.getOn();
                final Activity activity = activity;
                on2.next(new Function1<List<? extends GemTier>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((List<GemTier>) (List) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<GemTier> list) {
                        Intrinsics.checkNotNullExpressionValue(list, "it");
                        Activity activity = activity;
                        int i11 = 0;
                        for (Object next : list) {
                            int i12 = i11 + 1;
                            if (i11 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            GemTier gemTier = (GemTier) next;
                            View childAt = ((LinearLayout) activity.findViewById(R.id.staticTiersLayout)).getChildAt(i11);
                            if (childAt != null) {
                                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                                TiersBindingKt.bindTier(childAt, gemTier);
                            }
                            i11 = i12;
                        }
                    }
                });
            }
        });
    }
}
