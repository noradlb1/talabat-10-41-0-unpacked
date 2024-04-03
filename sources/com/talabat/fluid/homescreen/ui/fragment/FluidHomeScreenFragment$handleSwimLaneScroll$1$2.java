package com.talabat.fluid.homescreen.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenFragment$handleSwimLaneScroll$1$2 extends Lambda implements Function1<RecyclerView, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f59740g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ListCell f59741h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenFragment$handleSwimLaneScroll$1$2(FluidHomeScreenFragment fluidHomeScreenFragment, ListCell listCell) {
        super(1);
        this.f59740g = fluidHomeScreenFragment;
        this.f59741h = listCell;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecyclerView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "it");
        this.f59740g.trackImpression(recyclerView, this.f59741h);
    }
}
