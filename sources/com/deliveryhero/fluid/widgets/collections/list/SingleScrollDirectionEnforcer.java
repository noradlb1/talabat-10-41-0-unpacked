package com.deliveryhero.fluid.widgets.collections.list;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/list/SingleScrollDirectionEnforcer;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "()V", "dx", "", "dy", "initialTouchX", "initialTouchY", "scrollPointerId", "", "scrollState", "apply", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onInterceptTouchEvent", "", "rv", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onScrollStateChanged", "newState", "onTouchEvent", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleScrollDirectionEnforcer extends RecyclerView.OnScrollListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: dx  reason: collision with root package name */
    private float f30247dx;

    /* renamed from: dy  reason: collision with root package name */
    private float f30248dy;
    private float initialTouchX;
    private float initialTouchY;
    private int scrollPointerId = -1;
    private int scrollState;

    public final void apply(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.addOnItemTouchListener(this);
        recyclerView.addOnScrollListener(this);
    }

    public boolean onInterceptTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.scrollPointerId = motionEvent.getPointerId(0);
            this.initialTouchX = motionEvent.getX();
            this.initialTouchY = motionEvent.getY();
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.scrollPointerId);
            if (findPointerIndex >= 0 && this.scrollState != 1) {
                this.f30247dx = motionEvent.getX(findPointerIndex) - this.initialTouchX;
                this.f30248dy = motionEvent.getY(findPointerIndex) - this.initialTouchY;
            }
        } else if (actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            this.scrollPointerId = motionEvent.getPointerId(actionIndex);
            this.initialTouchX = motionEvent.getX(actionIndex);
            this.initialTouchY = motionEvent.getY(actionIndex);
        }
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z11) {
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int i12 = this.scrollState;
        this.scrollState = i11;
        if (i12 == 0) {
            boolean z11 = true;
            if (i11 == 1 && (layoutManager = recyclerView.getLayoutManager()) != null) {
                boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
                boolean canScrollVertically = layoutManager.canScrollVertically();
                if ((!canScrollHorizontally || Math.abs(this.f30248dy) <= Math.abs(this.f30247dx)) && (!canScrollVertically || Math.abs(this.f30247dx) <= Math.abs(this.f30248dy))) {
                    z11 = false;
                }
                if (canScrollHorizontally != canScrollVertically && z11) {
                    recyclerView.stopScroll();
                }
            }
        }
    }

    public void onTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
    }
}
