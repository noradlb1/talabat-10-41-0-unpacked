package com.deliveryhero.fluid.widgets.collections;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.widgets.collections.VisibilityObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J!\u0010\f\u001a\u00020\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000fH\u0002J)\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/ChildVisibilityNotifier;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "visibilityObserver", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver;", "Landroid/view/View;", "getVisibilityObserver", "(Landroid/view/View;)Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver;", "apply", "", "notifyOnAllVisibleChildViews", "func", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "notifyToAllChildViewsOf", "view", "Landroid/view/ViewGroup;", "onChildViewAttachedToWindow", "onChildViewDetachedFromWindow", "onRootVisibilityChanged", "visibility", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChildVisibilityNotifier implements RecyclerView.OnChildAttachStateChangeListener {
    private RecyclerView recyclerView;

    private final VisibilityObserver getVisibilityObserver(View view) {
        if (view instanceof VisibilityObserver) {
            return (VisibilityObserver) view;
        }
        return null;
    }

    private final void notifyOnAllVisibleChildViews(Function1<? super VisibilityObserver, Unit> function1) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        View view;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null && (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) <= (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
                while (true) {
                    RecyclerView recyclerView3 = this.recyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView3 = null;
                    }
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView3.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                    if (findViewHolderForAdapterPosition != null) {
                        view = findViewHolderForAdapterPosition.itemView;
                    } else {
                        view = null;
                    }
                    VisibilityObserver visibilityObserver = getVisibilityObserver(view);
                    if (visibilityObserver != null) {
                        function1.invoke(visibilityObserver);
                    }
                    if (view instanceof ViewGroup) {
                        notifyToAllChildViewsOf((ViewGroup) view, function1);
                    }
                    if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                        findFirstVisibleItemPosition++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void notifyToAllChildViewsOf(ViewGroup viewGroup, Function1<? super VisibilityObserver, Unit> function1) {
        int childCount = viewGroup.getChildCount();
        if (childCount >= 0) {
            int i11 = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i11);
                VisibilityObserver visibilityObserver = getVisibilityObserver(childAt);
                if (visibilityObserver != null) {
                    function1.invoke(visibilityObserver);
                }
                if (childAt instanceof ViewGroup) {
                    notifyToAllChildViewsOf((ViewGroup) childAt, function1);
                }
                if (i11 != childCount) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public final void apply(@NotNull RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        recyclerView2.addOnChildAttachStateChangeListener(this);
        this.recyclerView = recyclerView2;
    }

    public void onChildViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VisibilityObserver visibilityObserver = getVisibilityObserver(view);
        if (visibilityObserver != null) {
            visibilityObserver.onViewAppearedOnScreen(VisibilityObserver.Reason.ScrollEvent);
        }
        if (view instanceof ViewGroup) {
            notifyToAllChildViewsOf((ViewGroup) view, ChildVisibilityNotifier$onChildViewAttachedToWindow$1.INSTANCE);
        }
    }

    public void onChildViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VisibilityObserver visibilityObserver = getVisibilityObserver(view);
        if (visibilityObserver != null) {
            visibilityObserver.onViewDisappearedFromScreen(VisibilityObserver.Reason.ScrollEvent);
        }
        if (view instanceof ViewGroup) {
            notifyToAllChildViewsOf((ViewGroup) view, ChildVisibilityNotifier$onChildViewDetachedFromWindow$1.INSTANCE);
        }
    }

    public final void onRootVisibilityChanged(int i11) {
        if (i11 == 0) {
            notifyOnAllVisibleChildViews(ChildVisibilityNotifier$onRootVisibilityChanged$2.INSTANCE);
        } else if (i11 == 8) {
            notifyOnAllVisibleChildViews(ChildVisibilityNotifier$onRootVisibilityChanged$1.INSTANCE);
        }
    }
}
