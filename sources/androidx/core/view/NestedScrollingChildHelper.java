package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @Nullable int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i16;
        int i17;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i15)) == null) {
            return false;
        }
        if (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.mView.getLocationInWindow(iArr4);
            i17 = iArr4[0];
            i16 = iArr4[1];
        } else {
            i17 = 0;
            i16 = 0;
        }
        if (iArr2 == null) {
            int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
            tempNestedScrollConsumed[0] = 0;
            tempNestedScrollConsumed[1] = 0;
            iArr3 = tempNestedScrollConsumed;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i11, i12, i13, i14, i15, iArr3);
        if (iArr4 != null) {
            this.mView.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i17;
            iArr4[1] = iArr4[1] - i16;
        }
        return true;
    }

    private ViewParent getNestedScrollingParentForType(int i11) {
        if (i11 == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i11 != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i11, ViewParent viewParent) {
        if (i11 == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else if (i11 == 1) {
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i11, i12, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i11, i12, i13, i14, iArr, 0, (int[]) null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z11) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z11;
    }

    public boolean startNestedScroll(int i11) {
        return startNestedScroll(i11, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2, int i13) {
        ViewParent nestedScrollingParentForType;
        int i14;
        int i15;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i13)) == null) {
            return false;
        }
        if (i11 != 0 || i12 != 0) {
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                i15 = iArr2[0];
                i14 = iArr2[1];
            } else {
                i15 = 0;
                i14 = 0;
            }
            if (iArr == null) {
                iArr = getTempNestedScrollConsumed();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i11, i12, iArr, i13);
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i15;
                iArr2[1] = iArr2[1] - i14;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15) {
        return dispatchNestedScrollInternal(i11, i12, i13, i14, iArr, i15, (int[]) null);
    }

    public boolean hasNestedScrollingParent(int i11) {
        return getNestedScrollingParentForType(i11) != null;
    }

    public boolean startNestedScroll(int i11, int i12) {
        if (hasNestedScrollingParent(i12)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i11, i12)) {
                setNestedScrollingParentForType(i12, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i11, i12);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i11) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i11);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i11);
            setNestedScrollingParentForType(i11, (ViewParent) null);
        }
    }

    public void dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i11, i12, i13, i14, iArr, i15, iArr2);
    }
}
