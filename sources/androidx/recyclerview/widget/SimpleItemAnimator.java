package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.ViewHolder viewHolder);

    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11;
        int i12;
        if (itemHolderInfo == null || ((i11 = itemHolderInfo.left) == (i12 = itemHolderInfo2.left) && itemHolderInfo.top == itemHolderInfo2.top)) {
            return animateAdd(viewHolder);
        }
        return animateMove(viewHolder, i11, itemHolderInfo.top, i12, itemHolderInfo2.top);
    }

    public abstract boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i11, int i12, int i13, int i14);

    public boolean animateChange(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11;
        int i12;
        int i13 = itemHolderInfo.left;
        int i14 = itemHolderInfo.top;
        if (viewHolder2.shouldIgnore()) {
            int i15 = itemHolderInfo.left;
            i11 = itemHolderInfo.top;
            i12 = i15;
        } else {
            i12 = itemHolderInfo2.left;
            i11 = itemHolderInfo2.top;
        }
        return animateChange(viewHolder, viewHolder2, i13, i14, i12, i11);
    }

    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11;
        int i12;
        int i13 = itemHolderInfo.left;
        int i14 = itemHolderInfo.top;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            i11 = view.getLeft();
        } else {
            i11 = itemHolderInfo2.left;
        }
        int i15 = i11;
        if (itemHolderInfo2 == null) {
            i12 = view.getTop();
        } else {
            i12 = itemHolderInfo2.top;
        }
        int i16 = i12;
        if (viewHolder.isRemoved() || (i13 == i15 && i14 == i16)) {
            return animateRemove(viewHolder);
        }
        view.layout(i15, i16, view.getWidth() + i15, view.getHeight() + i16);
        return animateMove(viewHolder, i13, i14, i15, i16);
    }

    public abstract boolean animateMove(RecyclerView.ViewHolder viewHolder, int i11, int i12, int i13, int i14);

    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i11 = itemHolderInfo.left;
        int i12 = itemHolderInfo2.left;
        if (i11 == i12 && itemHolderInfo.top == itemHolderInfo2.top) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        return animateMove(viewHolder, i11, itemHolderInfo.top, i12, itemHolderInfo2.top);
    }

    public abstract boolean animateRemove(RecyclerView.ViewHolder viewHolder);

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder) {
        return !this.mSupportsChangeAnimations || viewHolder.isInvalid();
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder viewHolder) {
        onAddFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder viewHolder) {
        onAddStarting(viewHolder);
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z11) {
        onChangeFinished(viewHolder, z11);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z11) {
        onChangeStarting(viewHolder, z11);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder viewHolder) {
        onMoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder viewHolder) {
        onMoveStarting(viewHolder);
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        onRemoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        onRemoveStarting(viewHolder);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onAddStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z11) {
    }

    public void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z11) {
    }

    public void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void setSupportsChangeAnimations(boolean z11) {
        this.mSupportsChangeAnimations = z11;
    }
}
