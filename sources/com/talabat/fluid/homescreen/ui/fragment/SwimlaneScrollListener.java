package com.talabat.fluid.homescreen.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0002\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/fragment/SwimlaneScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "", "(Lkotlin/jvm/functions/Function1;)V", "onScrollStateChanged", "recyclerView", "newState", "", "dx", "dy", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneScrollListener extends RecyclerView.OnScrollListener {
    @NotNull
    private final Function1<RecyclerView, Unit> onScrolled;

    public SwimlaneScrollListener(@NotNull Function1<? super RecyclerView, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onScrolled");
        this.onScrolled = function1;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.onScrolled.invoke(recyclerView);
    }
}
