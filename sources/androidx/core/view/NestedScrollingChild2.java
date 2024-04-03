package androidx.core.view;

import androidx.annotation.Nullable;

public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2, int i13);

    boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15);

    boolean hasNestedScrollingParent(int i11);

    boolean startNestedScroll(int i11, int i12);

    void stopNestedScroll(int i11);
}
