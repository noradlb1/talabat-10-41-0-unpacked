package com.talabat;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/HomeMapPlaceSearchScreen$initView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapPlaceSearchScreen$initView$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeMapPlaceSearchScreen f54196a;

    public HomeMapPlaceSearchScreen$initView$1(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
        this.f54196a = homeMapPlaceSearchScreen;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (i11 == 1) {
            this.f54196a.hideKeyBoard();
        }
    }
}
