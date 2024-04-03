package com.adyen.checkout.ui.internal.common.util.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SimpleDiffCallback.Comparable;
import java.util.List;

public class SimpleDiffCallback<T extends Comparable<T>> extends DiffUtil.Callback {
    private List<T> mNewItems;
    private List<T> mOldItems;

    public interface Comparable<T> {
        boolean isSameContent(@NonNull T t11);

        boolean isSameItem(@NonNull T t11);
    }

    public SimpleDiffCallback(@NonNull List<T> list, @NonNull List<T> list2) {
        this.mOldItems = list;
        this.mNewItems = list2;
    }

    public boolean areContentsTheSame(int i11, int i12) {
        return ((Comparable) this.mOldItems.get(i11)).isSameContent(this.mNewItems.get(i12));
    }

    public boolean areItemsTheSame(int i11, int i12) {
        return ((Comparable) this.mOldItems.get(i11)).isSameItem(this.mNewItems.get(i12));
    }

    public int getNewListSize() {
        return this.mNewItems.size();
    }

    public int getOldListSize() {
        return this.mOldItems.size();
    }
}
