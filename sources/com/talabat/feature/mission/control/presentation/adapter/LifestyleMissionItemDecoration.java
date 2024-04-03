package com.talabat.feature.mission.control.presentation.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/adapter/LifestyleMissionItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "isRTL", "", "(Landroid/content/Context;Z)V", "horizontalSpacingBetween", "", "horizontalSpacingSide", "()Z", "addSpacingAfterEachItemExceptLast", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "addSpacingAfterLastItem", "addSpacingBeforeFirstItem", "getItemOffsets", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionItemDecoration extends RecyclerView.ItemDecoration {
    private final int horizontalSpacingBetween;
    private final int horizontalSpacingSide;
    private final boolean isRTL;

    public LifestyleMissionItemDecoration(@NotNull Context context, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.isRTL = z11;
        this.horizontalSpacingBetween = context.getResources().getDimensionPixelOffset(R.dimen.ds_xs);
        this.horizontalSpacingSide = context.getResources().getDimensionPixelOffset(R.dimen.ds_s);
    }

    private final void addSpacingAfterEachItemExceptLast(RecyclerView recyclerView, View view, Rect rect) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        if (childAdapterPosition == adapter.getItemCount() - 1) {
            return;
        }
        if (this.isRTL) {
            rect.left = this.horizontalSpacingBetween;
        } else {
            rect.right = this.horizontalSpacingBetween;
        }
    }

    private final void addSpacingAfterLastItem(RecyclerView recyclerView, View view, Rect rect) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        if (childAdapterPosition != adapter.getItemCount() - 1) {
            return;
        }
        if (this.isRTL) {
            rect.left = this.horizontalSpacingSide;
        } else {
            rect.right = this.horizontalSpacingSide;
        }
    }

    private final void addSpacingBeforeFirstItem(RecyclerView recyclerView, View view, Rect rect) {
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            return;
        }
        if (this.isRTL) {
            rect.right = this.horizontalSpacingSide;
        } else {
            rect.left = this.horizontalSpacingSide;
        }
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        addSpacingAfterEachItemExceptLast(recyclerView, view, rect);
        addSpacingBeforeFirstItem(recyclerView, view, rect);
        addSpacingAfterLastItem(recyclerView, view, rect);
    }

    public final boolean isRTL() {
        return this.isRTL;
    }
}
