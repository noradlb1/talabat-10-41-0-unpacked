package com.duolingo.open.rtlviewpager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class DelegatingPagerAdapter extends PagerAdapter {
    private final PagerAdapter mDelegate;

    public static class MyDataSetObserver extends DataSetObserver {

        /* renamed from: a  reason: collision with root package name */
        public final DelegatingPagerAdapter f33556a;

        private MyDataSetObserver(DelegatingPagerAdapter delegatingPagerAdapter) {
            this.f33556a = delegatingPagerAdapter;
        }

        public void onChanged() {
            DelegatingPagerAdapter delegatingPagerAdapter = this.f33556a;
            if (delegatingPagerAdapter != null) {
                delegatingPagerAdapter.superNotifyDataSetChanged();
            }
        }

        public void onInvalidated() {
            onChanged();
        }
    }

    public DelegatingPagerAdapter(@NonNull PagerAdapter pagerAdapter) {
        this.mDelegate = pagerAdapter;
        pagerAdapter.registerDataSetObserver(new MyDataSetObserver());
    }

    /* access modifiers changed from: private */
    public void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public PagerAdapter b() {
        return this.mDelegate;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i11, @NonNull Object obj) {
        this.mDelegate.destroyItem(viewGroup, i11, obj);
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        this.mDelegate.finishUpdate(viewGroup);
    }

    public int getCount() {
        return this.mDelegate.getCount();
    }

    public int getItemPosition(@NonNull Object obj) {
        return this.mDelegate.getItemPosition(obj);
    }

    public CharSequence getPageTitle(int i11) {
        return this.mDelegate.getPageTitle(i11);
    }

    public float getPageWidth(int i11) {
        return this.mDelegate.getPageWidth(i11);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i11) {
        return this.mDelegate.instantiateItem(viewGroup, i11);
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return this.mDelegate.isViewFromObject(view, obj);
    }

    public void notifyDataSetChanged() {
        this.mDelegate.notifyDataSetChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mDelegate.registerDataSetObserver(dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mDelegate.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.mDelegate.saveState();
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i11, @NonNull Object obj) {
        this.mDelegate.setPrimaryItem(viewGroup, i11, obj);
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        this.mDelegate.startUpdate(viewGroup);
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.mDelegate.unregisterDataSetObserver(dataSetObserver);
    }

    @Deprecated
    public void destroyItem(@NonNull View view, int i11, @NonNull Object obj) {
        this.mDelegate.destroyItem(view, i11, obj);
    }

    @Deprecated
    public void finishUpdate(@NonNull View view) {
        this.mDelegate.finishUpdate(view);
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View view, int i11) {
        return this.mDelegate.instantiateItem(view, i11);
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View view, int i11, @NonNull Object obj) {
        this.mDelegate.setPrimaryItem(view, i11, obj);
    }

    @Deprecated
    public void startUpdate(@NonNull View view) {
        this.mDelegate.startUpdate(view);
    }
}
