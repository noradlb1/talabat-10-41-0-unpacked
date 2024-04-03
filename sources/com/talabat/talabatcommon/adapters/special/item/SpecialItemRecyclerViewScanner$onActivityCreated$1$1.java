package com.talabat.talabatcommon.adapters.special.item;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewScanner$onActivityCreated$1$1 extends Lambda implements Function1<ContextLifecycleEvents, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Activity f46869g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Pair<Integer, Integer> f46870h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SpecialItemRecyclerViewScanner f46871i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecialItemRecyclerViewScanner$onActivityCreated$1$1(Activity activity, Pair<Integer, Integer> pair, SpecialItemRecyclerViewScanner specialItemRecyclerViewScanner) {
        super(1);
        this.f46869g = activity;
        this.f46870h = pair;
        this.f46871i = specialItemRecyclerViewScanner;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContextLifecycleEvents) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
        Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$withLifecycleEvents");
        ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
        final Activity activity = this.f46869g;
        final Pair<Integer, Integer> pair = this.f46870h;
        final SpecialItemRecyclerViewScanner specialItemRecyclerViewScanner = this.f46871i;
        on2.create(new Function0<Unit>() {
            public final void invoke() {
                RecyclerView recyclerView = (RecyclerView) activity.findViewById(pair.getFirst().intValue());
                if (recyclerView != null) {
                    SpecialItemRecyclerViewExtensionKt.withSpecialItem(recyclerView, pair.getSecond().intValue(), specialItemRecyclerViewScanner.createSpecialItemViewHolder);
                }
            }
        });
    }
}
