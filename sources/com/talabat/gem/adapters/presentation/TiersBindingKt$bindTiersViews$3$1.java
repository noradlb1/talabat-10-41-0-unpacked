package com.talabat.gem.adapters.presentation;

import android.app.Activity;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
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
public final class TiersBindingKt$bindTiersViews$3$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemTiersViewPort f59894g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f59895h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiersBindingKt$bindTiersViews$3$1(GemTiersViewPort gemTiersViewPort, Activity activity) {
        super(0);
        this.f59894g = gemTiersViewPort;
        this.f59895h = activity;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<Boolean> staticTiersMode = this.f59894g.getStaticTiersMode();
        final Activity activity = this.f59895h;
        return RxKt.invoke(staticTiersMode, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                final Activity activity = activity;
                on2.next(new Function1<Boolean, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Boolean) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Boolean bool) {
                        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.staticTiersLayout);
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "staticTiersLayout");
                        ViewKt.get(linearLayout, bool, 8);
                        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.dynamicTiersRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(recyclerView, "dynamicTiersRecyclerView");
                        ViewKt.get(recyclerView, Boolean.valueOf(!bool.booleanValue()), 8);
                    }
                });
            }
        });
    }
}
