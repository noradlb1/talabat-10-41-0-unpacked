package com.talabat.fluid.homescreen.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J \u0010\u0002\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016R$\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/fragment/ScreenScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "Lkotlin/Function2;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/talabat/fluid/homescreen/ui/fragment/ScrollOffset;", "", "(Lkotlin/jvm/functions/Function2;)V", "onScrollStateChanged", "recyclerView", "newState", "dx", "dy", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenScrollListener extends RecyclerView.OnScrollListener {
    @NotNull
    private final Function2<RecyclerView, Integer, Unit> onScrolled;

    public ScreenScrollListener(@NotNull Function2<? super RecyclerView, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onScrolled");
        this.onScrolled = function2;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.onScrolled.invoke(recyclerView, Integer.valueOf(recyclerView.computeVerticalScrollOffset()));
    }
}
