package com.talabat.fluid.homescreen.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollOffset", "", "Lcom/talabat/fluid/homescreen/ui/fragment/ScrollOffset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenFragment$addScrollHandling$2 extends Lambda implements Function2<RecyclerView, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f59736g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<ListCell> f59737h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenFragment$addScrollHandling$2(FluidHomeScreenFragment fluidHomeScreenFragment, List<ListCell> list) {
        super(2);
        this.f59736g = fluidHomeScreenFragment;
        this.f59737h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((RecyclerView) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f59736g.getViewModel().onScreenScrolled(i11);
        if (i11 != 0) {
            this.f59736g.handleSecondaryBannerScroll(this.f59737h, recyclerView);
        }
        this.f59736g.handleSwimLaneScroll(this.f59737h, recyclerView);
        this.f59736g.handleGroceryCategoryWidgetScroll(this.f59737h, recyclerView);
    }
}
