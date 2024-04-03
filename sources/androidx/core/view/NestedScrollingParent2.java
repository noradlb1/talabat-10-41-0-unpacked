package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i11, int i12, @NonNull int[] iArr, int i13);

    void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11, int i12);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11, int i12);

    void onStopNestedScroll(@NonNull View view, int i11);
}
