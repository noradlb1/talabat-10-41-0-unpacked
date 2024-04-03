package com.designsystem.ds_tabs_view;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/designsystem/ds_tabs_view/DSTabsView$setupAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onItemRangeInserted", "", "positionStart", "", "itemCount", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTabsView$setupAdapter$1 extends RecyclerView.AdapterDataObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DSTabsView f33065a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DSTabsViewContentAdapter<?, ?> f33066b;

    public DSTabsView$setupAdapter$1(DSTabsView dSTabsView, DSTabsViewContentAdapter<?, ?> dSTabsViewContentAdapter) {
        this.f33065a = dSTabsView;
        this.f33066b = dSTabsViewContentAdapter;
    }

    public void onItemRangeInserted(int i11, int i12) {
        this.f33065a.updateTabs(this.f33066b.getCurrentList());
        super.onItemRangeInserted(i11, i12);
    }
}
