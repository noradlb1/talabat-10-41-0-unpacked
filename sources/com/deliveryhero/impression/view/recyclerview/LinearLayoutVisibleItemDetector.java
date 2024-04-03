package com.deliveryhero.impression.view.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.impression.view.ItemVisibleArea;
import com.deliveryhero.impression.view.ViewVisibleItemDetector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/impression/view/recyclerview/LinearLayoutVisibleItemDetector;", "Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;", "Landroidx/recyclerview/widget/RecyclerView;", "()V", "bounds", "Landroid/graphics/Rect;", "getVisibleItems", "", "Lcom/deliveryhero/impression/view/ItemVisibleArea;", "viewGroup", "getItemVisibleArea", "", "itemView", "Landroid/view/View;", "getView", "position", "getVisiblePositions", "Lkotlin/ranges/IntRange;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LinearLayoutVisibleItemDetector implements ViewVisibleItemDetector<RecyclerView> {
    @NotNull
    public static final LinearLayoutVisibleItemDetector INSTANCE = new LinearLayoutVisibleItemDetector();
    @NotNull
    private static final Rect bounds = new Rect();

    private LinearLayoutVisibleItemDetector() {
    }

    private final int getItemVisibleArea(RecyclerView recyclerView, View view) {
        int i11;
        int i12;
        int i13;
        float f11;
        boolean z11 = false;
        if (view.getHeight() == 0 || view.getWidth() == 0) {
            return 0;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 1) {
                z11 = true;
            }
            Rect rect = bounds;
            recyclerView.getDrawingRect(rect);
            if (z11) {
                i11 = rect.top;
            } else {
                i11 = rect.left;
            }
            if (z11) {
                i12 = rect.bottom;
            } else {
                i12 = rect.right;
            }
            if (z11) {
                i13 = view.getHeight();
            } else {
                i13 = view.getWidth();
            }
            if (z11) {
                f11 = view.getY();
            } else {
                f11 = view.getX();
            }
            float f12 = (float) i13;
            return (int) ((((f12 - Math.max(((float) i11) - f11, 0.0f)) - Math.max((f11 + f12) - ((float) i12), 0.0f)) / f12) * 100.0f);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    private final View getView(RecyclerView recyclerView, int i11) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return null;
        }
        return layoutManager.findViewByPosition(i11);
    }

    private final IntRange getVisiblePositions(LinearLayoutManager linearLayoutManager) {
        return new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition());
    }

    @NotNull
    public List<ItemVisibleArea> getVisibleItems(@NotNull RecyclerView recyclerView) {
        ItemVisibleArea itemVisibleArea;
        Intrinsics.checkNotNullParameter(recyclerView, "viewGroup");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        ArrayList arrayList = null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            IntRange visiblePositions = getVisiblePositions(linearLayoutManager);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = visiblePositions.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                LinearLayoutVisibleItemDetector linearLayoutVisibleItemDetector = INSTANCE;
                View view = linearLayoutVisibleItemDetector.getView(recyclerView, nextInt);
                if (view == null) {
                    itemVisibleArea = null;
                } else {
                    itemVisibleArea = new ItemVisibleArea(nextInt, view, linearLayoutVisibleItemDetector.getItemVisibleArea(recyclerView, view));
                }
                if (itemVisibleArea != null) {
                    arrayList2.add(itemVisibleArea);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt__CollectionsKt.emptyList() : arrayList;
    }
}
