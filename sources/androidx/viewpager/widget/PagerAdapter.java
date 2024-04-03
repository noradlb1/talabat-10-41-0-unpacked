package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    public void destroyItem(@NonNull ViewGroup viewGroup, int i11, @NonNull Object obj) {
        destroyItem((View) viewGroup, i11, obj);
    }

    @Deprecated
    public void finishUpdate(@NonNull View view) {
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object obj) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int i11) {
        return null;
    }

    public float getPageWidth(int i11) {
        return 1.0f;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i11) {
        return instantiateItem((View) viewGroup, i11);
    }

    public abstract boolean isViewFromObject(@NonNull View view, @NonNull Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.mViewPagerObserver;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View view, int i11, @NonNull Object obj) {
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i11, @NonNull Object obj) {
        setPrimaryItem((View) viewGroup, i11, obj);
    }

    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }

    @Deprecated
    public void startUpdate(@NonNull View view) {
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    @Deprecated
    public void destroyItem(@NonNull View view, int i11, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View view, int i11) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }
}
