package androidx.appcompat.widget;

class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRelative = false;
    private boolean mIsRtl = false;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i11, int i12) {
        this.mIsRelative = false;
        if (i11 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i11;
            this.mLeft = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.mExplicitRight = i12;
            this.mRight = i12;
        }
    }

    public void setDirection(boolean z11) {
        if (z11 != this.mIsRtl) {
            this.mIsRtl = z11;
            if (!this.mIsRelative) {
                this.mLeft = this.mExplicitLeft;
                this.mRight = this.mExplicitRight;
            } else if (z11) {
                int i11 = this.mEnd;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.mExplicitLeft;
                }
                this.mLeft = i11;
                int i12 = this.mStart;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = this.mExplicitRight;
                }
                this.mRight = i12;
            } else {
                int i13 = this.mStart;
                if (i13 == Integer.MIN_VALUE) {
                    i13 = this.mExplicitLeft;
                }
                this.mLeft = i13;
                int i14 = this.mEnd;
                if (i14 == Integer.MIN_VALUE) {
                    i14 = this.mExplicitRight;
                }
                this.mRight = i14;
            }
        }
    }

    public void setRelative(int i11, int i12) {
        this.mStart = i11;
        this.mEnd = i12;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i12 != Integer.MIN_VALUE) {
                this.mLeft = i12;
            }
            if (i11 != Integer.MIN_VALUE) {
                this.mRight = i11;
                return;
            }
            return;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.mLeft = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.mRight = i12;
        }
    }
}
