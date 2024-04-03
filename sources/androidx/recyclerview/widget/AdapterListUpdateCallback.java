package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void onChanged(int i11, int i12, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i11, i12, obj);
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
}
