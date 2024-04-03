package com.deliveryhero.impression.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/deliveryhero/impression/view/recyclerview/RecyclerViewTracker$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecyclerViewTracker$dataObserver$1 extends RecyclerView.AdapterDataObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewTracker f30336a;

    public RecyclerViewTracker$dataObserver$1(RecyclerViewTracker recyclerViewTracker) {
        this.f30336a = recyclerViewTracker;
    }

    public void onChanged() {
        super.onChanged();
        RecyclerView access$getRecyclerView$p = this.f30336a.recyclerView;
        if (access$getRecyclerView$p != null) {
            access$getRecyclerView$p.addOnLayoutChangeListener(new RecyclerViewTracker$dataObserver$1$onChanged$$inlined$doOnNextLayout$1(this.f30336a));
        }
    }

    public void onItemRangeInserted(int i11, int i12) {
        super.onItemRangeInserted(i11, i12);
        RecyclerView access$getRecyclerView$p = this.f30336a.recyclerView;
        if (access$getRecyclerView$p != null) {
            access$getRecyclerView$p.addOnLayoutChangeListener(new RecyclerViewTracker$dataObserver$1$onItemRangeInserted$$inlined$doOnNextLayout$1(this.f30336a));
        }
    }
}
