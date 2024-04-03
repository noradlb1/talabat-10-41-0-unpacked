package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver = new RecyclerView.AdapterDataObserver() {
        public void onChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount = nestedAdapterWrapper.adapter.getItemCount();
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            nestedAdapterWrapper2.mCallback.onChanged(nestedAdapterWrapper2);
        }

        public void onItemRangeChanged(int i11, int i12) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i11, i12, (Object) null);
        }

        public void onItemRangeInserted(int i11, int i12) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount += i12;
            nestedAdapterWrapper.mCallback.onItemRangeInserted(nestedAdapterWrapper, i11, i12);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.mCachedItemCount > 0 && nestedAdapterWrapper2.adapter.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
                nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
            }
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            boolean z11 = true;
            if (i13 != 1) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "moving more than 1 item is not supported in RecyclerView");
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeMoved(nestedAdapterWrapper, i11, i12);
        }

        public void onItemRangeRemoved(int i11, int i12) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount -= i12;
            nestedAdapterWrapper.mCallback.onItemRangeRemoved(nestedAdapterWrapper, i11, i12);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.mCachedItemCount < 1 && nestedAdapterWrapper2.adapter.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
                nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
            }
        }

        public void onStateRestorationPolicyChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper);
        }

        public void onItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i11, i12, obj);
        }
    };
    int mCachedItemCount;
    final Callback mCallback;
    @NonNull
    private final StableIdStorage.StableIdLookup mStableIdLookup;
    @NonNull
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    public interface Callback {
        void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i11, int i12);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i11, int i12, @Nullable Object obj);

        void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i11, int i12);

        void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i11, int i12);

        void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i11, int i12);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper);
    }

    public NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter2, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.adapter = adapter2;
        this.mCallback = callback;
        this.mViewTypeLookup = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdLookup;
        this.mCachedItemCount = adapter2.getItemCount();
        adapter2.registerAdapterDataObserver(this.mAdapterObserver);
    }

    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int i11) {
        return this.mStableIdLookup.localToGlobal(this.adapter.getItemId(i11));
    }

    public int getItemViewType(int i11) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(i11));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        this.adapter.bindViewHolder(viewHolder, i11);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return this.adapter.onCreateViewHolder(viewGroup, this.mViewTypeLookup.globalToLocal(i11));
    }
}
