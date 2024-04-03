package com.talabat.darkstores.common.extensions;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"smoothSnapToPosition", "", "Landroidx/recyclerview/widget/RecyclerView;", "position", "", "snapMode", "scrollSpeedMultiplier", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewExtensionsKt {
    public static final void smoothSnapToPosition(@NotNull RecyclerView recyclerView, int i11, int i12, float f11) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1 recyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1 = new RecyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1(i12, f11, recyclerView.getContext());
        recyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1.setTargetPosition(i11);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(recyclerViewExtensionsKt$smoothSnapToPosition$smoothScroller$1);
        }
    }

    public static /* synthetic */ void smoothSnapToPosition$default(RecyclerView recyclerView, int i11, int i12, float f11, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = -1;
        }
        if ((i13 & 4) != 0) {
            f11 = 1.0f;
        }
        smoothSnapToPosition(recyclerView, i11, i12, f11);
    }
}
