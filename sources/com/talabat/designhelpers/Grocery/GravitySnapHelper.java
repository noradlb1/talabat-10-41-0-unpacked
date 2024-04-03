package com.talabat.designhelpers.Grocery;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class GravitySnapHelper extends LinearSnapHelper {
    private GravityDelegate delegate;

    public interface SnapListener {
        void onSnap(int i11);
    }

    public GravitySnapHelper(int i11, boolean z11) {
        this(i11, z11, (SnapListener) null);
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        this.delegate.attachToRecyclerView(recyclerView);
        super.attachToRecyclerView(recyclerView);
    }

    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        return this.delegate.calculateDistanceToFinalSnap(layoutManager, view);
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return this.delegate.findSnapView(layoutManager);
    }

    public GravitySnapHelper(int i11, boolean z11, SnapListener snapListener) {
        this.delegate = new GravityDelegate(i11, z11, snapListener);
    }
}
