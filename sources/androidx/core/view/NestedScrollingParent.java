package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z11);

    boolean onNestedPreFling(@NonNull View view, float f11, float f12);

    void onNestedPreScroll(@NonNull View view, int i11, int i12, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11);

    void onStopNestedScroll(@NonNull View view);
}
