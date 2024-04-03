package com.duolingo.open.rtlviewpager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;

public class RtlViewPager extends ViewPager {
    private int mLayoutDirection = 0;
    private final HashMap<ViewPager.OnPageChangeListener, ReversingOnPageChangeListener> mPageChangeListeners = new HashMap<>();

    public class ReversingOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final ViewPager.OnPageChangeListener mListener;

        public ReversingOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
            this.mListener = onPageChangeListener;
        }

        public void onPageScrollStateChanged(int i11) {
            this.mListener.onPageScrollStateChanged(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            int width = RtlViewPager.this.getWidth();
            PagerAdapter b11 = RtlViewPager.super.getAdapter();
            if (RtlViewPager.this.isRtl() && b11 != null) {
                int count = b11.getCount();
                float f12 = (float) width;
                int pageWidth = ((int) ((1.0f - b11.getPageWidth(i11)) * f12)) + i12;
                while (i11 < count && pageWidth > 0) {
                    i11++;
                    pageWidth -= (int) (b11.getPageWidth(i11) * f12);
                }
                i11 = (count - i11) - 1;
                i12 = -pageWidth;
                f11 = ((float) i12) / (f12 * b11.getPageWidth(i11));
            }
            this.mListener.onPageScrolled(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            PagerAdapter c11 = RtlViewPager.super.getAdapter();
            if (RtlViewPager.this.isRtl() && c11 != null) {
                i11 = (c11.getCount() - i11) - 1;
            }
            this.mListener.onPageSelected(i11);
        }
    }

    public RtlViewPager(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public boolean isRtl() {
        return this.mLayoutDirection == 1;
    }

    public void addOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        ReversingOnPageChangeListener reversingOnPageChangeListener = new ReversingOnPageChangeListener(onPageChangeListener);
        this.mPageChangeListeners.put(onPageChangeListener, reversingOnPageChangeListener);
        super.addOnPageChangeListener(reversingOnPageChangeListener);
    }

    public void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
        this.mPageChangeListeners.clear();
    }

    public PagerAdapter getAdapter() {
        ReversingAdapter reversingAdapter = (ReversingAdapter) super.getAdapter();
        if (reversingAdapter == null) {
            return null;
        }
        return reversingAdapter.b();
    }

    public int getCurrentItem() {
        int currentItem = super.getCurrentItem();
        PagerAdapter adapter = super.getAdapter();
        if (adapter == null || !isRtl()) {
            return currentItem;
        }
        return (adapter.getCount() - currentItem) - 1;
    }

    public void onMeasure(int i11, int i12) {
        if (View.MeasureSpec.getMode(i12) == 0) {
            int i13 = 0;
            for (int i14 = 0; i14 < getChildCount(); i14++) {
                View childAt = getChildAt(i14);
                childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i13) {
                    i13 = measuredHeight;
                }
            }
            i12 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mLayoutDirection = savedState.mLayoutDirection;
        super.onRestoreInstanceState(savedState.mViewPagerSavedState);
    }

    public void onRtlPropertiesChanged(int i11) {
        super.onRtlPropertiesChanged(i11);
        int i12 = 0;
        int i13 = 1;
        if (i11 != 1) {
            i13 = 0;
        }
        if (i13 != this.mLayoutDirection) {
            PagerAdapter adapter = super.getAdapter();
            if (adapter != null) {
                i12 = getCurrentItem();
            }
            this.mLayoutDirection = i13;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                setCurrentItem(i12);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mLayoutDirection);
    }

    public void removeOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        ReversingOnPageChangeListener remove = this.mPageChangeListeners.remove(onPageChangeListener);
        if (remove != null) {
            super.removeOnPageChangeListener(remove);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (pagerAdapter != null) {
            pagerAdapter = new ReversingAdapter(pagerAdapter);
        }
        super.setAdapter(pagerAdapter);
        setCurrentItem(0);
    }

    public void setCurrentItem(int i11, boolean z11) {
        PagerAdapter adapter = super.getAdapter();
        if (adapter != null && isRtl()) {
            i11 = (adapter.getCount() - i11) - 1;
        }
        super.setCurrentItem(i11, z11);
    }

    @Deprecated
    public void setOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        super.setOnPageChangeListener(new ReversingOnPageChangeListener(onPageChangeListener));
    }

    public class ReversingAdapter extends DelegatingPagerAdapter {
        public ReversingAdapter(@NonNull PagerAdapter pagerAdapter) {
            super(pagerAdapter);
        }

        public void destroyItem(@NonNull ViewGroup viewGroup, int i11, @NonNull Object obj) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            super.destroyItem(viewGroup, i11, obj);
        }

        public int getItemPosition(@NonNull Object obj) {
            int itemPosition = super.getItemPosition(obj);
            if (!RtlViewPager.this.isRtl()) {
                return itemPosition;
            }
            if (itemPosition == -1 || itemPosition == -2) {
                return -2;
            }
            return (getCount() - itemPosition) - 1;
        }

        public CharSequence getPageTitle(int i11) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            return super.getPageTitle(i11);
        }

        public float getPageWidth(int i11) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            return super.getPageWidth(i11);
        }

        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i11) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            return super.instantiateItem(viewGroup, i11);
        }

        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i11, @NonNull Object obj) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            super.setPrimaryItem(viewGroup, i11, obj);
        }

        @Deprecated
        public void destroyItem(@NonNull View view, int i11, @NonNull Object obj) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            super.destroyItem(view, i11, obj);
        }

        @NonNull
        @Deprecated
        public Object instantiateItem(@NonNull View view, int i11) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            return super.instantiateItem(view, i11);
        }

        @Deprecated
        public void setPrimaryItem(@NonNull View view, int i11, @NonNull Object obj) {
            if (RtlViewPager.this.isRtl()) {
                i11 = (getCount() - i11) - 1;
            }
            super.setPrimaryItem(view, i11, obj);
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        };
        /* access modifiers changed from: private */
        public final int mLayoutDirection;
        /* access modifiers changed from: private */
        public final Parcelable mViewPagerSavedState;

        private SavedState(Parcelable parcelable, int i11) {
            this.mViewPagerSavedState = parcelable;
            this.mLayoutDirection = i11;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeParcelable(this.mViewPagerSavedState, i11);
            parcel.writeInt(this.mLayoutDirection);
        }

        private SavedState(Parcel parcel, ClassLoader classLoader) {
            this.mViewPagerSavedState = parcel.readParcelable(classLoader == null ? getClass().getClassLoader() : classLoader);
            this.mLayoutDirection = parcel.readInt();
        }
    }

    public RtlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentItem(int i11) {
        PagerAdapter adapter = super.getAdapter();
        if (adapter != null && isRtl()) {
            i11 = (adapter.getCount() - i11) - 1;
        }
        super.setCurrentItem(i11);
    }
}
