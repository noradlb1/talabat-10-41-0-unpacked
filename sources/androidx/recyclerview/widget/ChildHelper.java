package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket = new Bucket();
    final Callback mCallback;
    final List<View> mHiddenViews = new ArrayList();

    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i11) {
            if (i11 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i11 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i11);
        }

        public int countOnesBefore(int i11) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i11 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i11) - 1));
            } else if (i11 < 64) {
                return Long.bitCount(this.mData & ((1 << i11) - 1));
            } else {
                return bucket.countOnesBefore(i11 - 64) + Long.bitCount(this.mData);
            }
        }

        public boolean get(int i11) {
            if (i11 >= 64) {
                ensureNext();
                return this.mNext.get(i11 - 64);
            } else if ((this.mData & (1 << i11)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public void insert(int i11, boolean z11) {
            boolean z12;
            if (i11 >= 64) {
                ensureNext();
                this.mNext.insert(i11 - 64, z11);
                return;
            }
            long j11 = this.mData;
            if ((Long.MIN_VALUE & j11) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            long j12 = (1 << i11) - 1;
            this.mData = ((j11 & (~j12)) << 1) | (j11 & j12);
            if (z11) {
                set(i11);
            } else {
                clear(i11);
            }
            if (z12 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z12);
            }
        }

        public boolean remove(int i11) {
            boolean z11;
            if (i11 >= 64) {
                ensureNext();
                return this.mNext.remove(i11 - 64);
            }
            long j11 = 1 << i11;
            long j12 = this.mData;
            if ((j12 & j11) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long j13 = j12 & (~j11);
            this.mData = j13;
            long j14 = j11 - 1;
            this.mData = (j13 & j14) | Long.rotateRight((~j14) & j13, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z11;
        }

        public void reset() {
            this.mData = 0;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i11) {
            if (i11 >= 64) {
                ensureNext();
                this.mNext.set(i11 - 64);
                return;
            }
            this.mData |= 1 << i11;
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    public interface Callback {
        void addView(View view, int i11);

        void attachViewToParent(View view, int i11, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i11);

        View getChildAt(int i11);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i11);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i11) {
        if (i11 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i12 = i11;
        while (i12 < childCount) {
            int countOnesBefore = i11 - (i12 - this.mBucket.countOnesBefore(i12));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i12)) {
                    i12++;
                }
                return i12;
            }
            i12 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(View view, boolean z11) {
        addView(view, -1, z11);
    }

    public void attachViewToParent(View view, int i11, ViewGroup.LayoutParams layoutParams, boolean z11) {
        int i12;
        if (i11 < 0) {
            i12 = this.mCallback.getChildCount();
        } else {
            i12 = getOffset(i11);
        }
        this.mBucket.insert(i12, z11);
        if (z11) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, i12, layoutParams);
    }

    public void detachViewFromParent(int i11) {
        int offset = getOffset(i11);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i11) {
        int size = this.mHiddenViews.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.mHiddenViews.get(i12);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i11 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i11) {
        return this.mCallback.getChildAt(getOffset(i11));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i11) {
        return this.mCallback.getChildAt(i11);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild != -1 && !this.mBucket.get(indexOfChild)) {
            return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
        }
        return -1;
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.mBucket.remove(indexOfChild)) {
                unhideViewInternal(view);
            }
            this.mCallback.removeViewAt(indexOfChild);
        }
    }

    public void removeViewAt(int i11) {
        int offset = getOffset(i11);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt != null) {
            if (this.mBucket.remove(offset)) {
                unhideViewInternal(childAt);
            }
            this.mCallback.removeViewAt(offset);
        }
    }

    public boolean removeViewIfHidden(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        } else if (!this.mBucket.get(indexOfChild)) {
            return false;
        } else {
            this.mBucket.remove(indexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(indexOfChild);
            return true;
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.mBucket.get(indexOfChild)) {
            this.mBucket.clear(indexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public void addView(View view, int i11, boolean z11) {
        int i12;
        if (i11 < 0) {
            i12 = this.mCallback.getChildCount();
        } else {
            i12 = getOffset(i11);
        }
        this.mBucket.insert(i12, z11);
        if (z11) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, i12);
    }
}
