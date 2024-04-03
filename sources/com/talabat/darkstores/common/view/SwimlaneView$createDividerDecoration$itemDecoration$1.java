package com.talabat.darkstores.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/talabat/darkstores/common/view/SwimlaneView$createDividerDecoration$itemDecoration$1", "Landroidx/recyclerview/widget/DividerItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneView$createDividerDecoration$itemDecoration$1 extends DividerItemDecoration {
    public SwimlaneView$createDividerDecoration$itemDecoration$1(Context context) {
        super(context, 0);
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i11;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int itemCount = state.getItemCount();
            boolean z11 = true;
            if (childAdapterPosition != itemCount - 1) {
                z11 = false;
            }
            if (z11) {
                i11 = 0;
            } else {
                i11 = drawable.getIntrinsicWidth();
            }
            if (TalabatUtils.isRTL()) {
                rect.set(i11, 0, 0, 0);
            } else {
                rect.set(0, 0, i11, 0);
            }
        } else {
            super.getItemOffsets(rect, view, recyclerView, state);
        }
    }
}
