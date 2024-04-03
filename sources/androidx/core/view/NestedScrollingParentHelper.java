package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11, int i12) {
        if (i12 == 1) {
            this.mNestedScrollAxesNonTouch = i11;
        } else {
            this.mNestedScrollAxesTouch = i11;
        }
    }

    public void onStopNestedScroll(@NonNull View view, int i11) {
        if (i11 == 1) {
            this.mNestedScrollAxesNonTouch = 0;
        } else {
            this.mNestedScrollAxesTouch = 0;
        }
    }
}
