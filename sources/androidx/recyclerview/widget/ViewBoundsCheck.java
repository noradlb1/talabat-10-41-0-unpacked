package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags = new BoundFlags();
    final Callback mCallback;

    public static class BoundFlags {
        int mBoundFlags = 0;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        public void addFlags(int i11) {
            this.mBoundFlags = i11 | this.mBoundFlags;
        }

        public boolean boundsMatch() {
            int i11 = this.mBoundFlags;
            if ((i11 & 7) != 0 && (i11 & (compare(this.mChildStart, this.mRvStart) << 0)) == 0) {
                return false;
            }
            int i12 = this.mBoundFlags;
            if ((i12 & 112) != 0 && (i12 & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            int i13 = this.mBoundFlags;
            if ((i13 & 1792) != 0 && (i13 & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            int i14 = this.mBoundFlags;
            if ((i14 & 28672) == 0 || (i14 & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0) {
                return true;
            }
            return false;
        }

        public int compare(int i11, int i12) {
            if (i11 > i12) {
                return 1;
            }
            return i11 == i12 ? 2 : 4;
        }

        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        public void setBounds(int i11, int i12, int i13, int i14) {
            this.mRvStart = i11;
            this.mRvEnd = i12;
            this.mChildStart = i13;
            this.mChildEnd = i14;
        }
    }

    public interface Callback {
        View getChildAt(int i11);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    public View findOneViewWithinBoundFlags(int i11, int i12, int i13, int i14) {
        int i15;
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        if (i12 > i11) {
            i15 = 1;
        } else {
            i15 = -1;
        }
        View view = null;
        while (i11 != i12) {
            View childAt = this.mCallback.getChildAt(i11);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i13 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i13);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i14 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i14);
                if (this.mBoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i11 += i15;
        }
        return view;
    }

    public boolean isViewWithinBoundFlags(View view, int i11) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i11 == 0) {
            return false;
        }
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(i11);
        return this.mBoundFlags.boundsMatch();
    }
}
