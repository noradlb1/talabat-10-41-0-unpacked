package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter mAdapter;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void onChanged(int i11, int i12) {
        this.mAdapter.notifyItemRangeChanged(i11, i12);
    }

    public void onInserted(int i11, int i12) {
        this.mAdapter.notifyItemRangeInserted(i11, i12);
    }

    public void onMoved(int i11, int i12) {
        this.mAdapter.notifyItemMoved(i11, i12);
    }

    public void onRemoved(int i11, int i12) {
        this.mAdapter.notifyItemRangeRemoved(i11, i12);
    }

    public void onChanged(int i11, int i12, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i11, i12, obj);
    }
}
