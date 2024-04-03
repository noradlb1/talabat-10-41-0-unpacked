package com.talabat.helpers;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class AnimatorAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    private static final String ALPHA = "alpha";

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f60774i;
    private RecyclerView.Adapter<T> mAdapter;
    @Nullable
    private ViewAnimator mViewAnimator;

    public AnimatorAdapter(RecyclerView.Adapter<T> adapter, RecyclerView recyclerView) {
        this.mAdapter = adapter;
        this.mViewAnimator = new ViewAnimator(recyclerView);
        this.f60774i = recyclerView;
    }

    private void animateView(View view, int i11) {
        this.mViewAnimator.animateViewIfNecessary(i11, view, AnimatorUtil.concatAnimators(getAnimators(view), ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f})));
    }

    @NonNull
    public abstract Animator[] getAnimators(@NonNull View view);

    public int getItemCount() {
        return this.mAdapter.getItemCount();
    }

    public long getItemId(int i11) {
        return this.mAdapter.getItemId(i11);
    }

    public int getItemViewType(int i11) {
        return this.mAdapter.getItemViewType(i11);
    }

    @Nullable
    public ViewAnimator getViewAnimator() {
        return this.mViewAnimator;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(T t11, int i11) {
        this.mAdapter.onBindViewHolder(t11, i11);
        this.mViewAnimator.cancelExistingAnimation(t11.itemView);
        animateView(t11.itemView, i11);
    }

    public T onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return this.mAdapter.onCreateViewHolder(viewGroup, i11);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mAdapter.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean onFailedToRecycleView(T t11) {
        return this.mAdapter.onFailedToRecycleView(t11);
    }

    public void onViewAttachedToWindow(T t11) {
        this.mAdapter.onViewAttachedToWindow(t11);
    }

    public void onViewDetachedFromWindow(T t11) {
        this.mAdapter.onViewDetachedFromWindow(t11);
    }

    public void onViewRecycled(T t11) {
        this.mAdapter.onViewRecycled(t11);
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
    }

    public void setHasStableIds(boolean z11) {
        this.mAdapter.setHasStableIds(z11);
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
