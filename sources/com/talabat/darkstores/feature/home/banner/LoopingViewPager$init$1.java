package com.talabat.darkstores.feature.home.banner;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.talabat.darkstores.feature.home.LoopingPagerAdapter;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"com/talabat/darkstores/feature/home/banner/LoopingViewPager$init$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "currentPosition", "", "getCurrentPosition", "()F", "setCurrentPosition", "(F)V", "calculateProgress", "position", "", "positionOffset", "onPageScrollStateChanged", "", "state", "onPageScrolled", "positionOffsetPixels", "onPageSelected", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoopingViewPager$init$1 implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoopingViewPager f56431b;
    private float currentPosition;

    public LoopingViewPager$init$1(LoopingViewPager loopingViewPager) {
        this.f56431b = loopingViewPager;
    }

    private final float calculateProgress(int i11, float f11) {
        if (this.f56431b.scrollState == 2 && Math.abs(this.f56431b.currentPagePosition - this.f56431b.previousPosition) > 1) {
            int abs = Math.abs(this.f56431b.currentPagePosition - this.f56431b.previousPosition);
            if (this.f56431b.toTheRight) {
                float f12 = (float) abs;
                return (f11 / f12) + (((float) (i11 - this.f56431b.previousPosition)) / f12);
            }
            float f13 = (float) abs;
            return (((float) (this.f56431b.previousPosition - (i11 + 1))) / f13) + ((((float) 1) - f11) / f13);
        } else if (this.f56431b.toTheRight) {
            return f11;
        } else {
            return ((float) 1) - f11;
        }
    }

    public final float getCurrentPosition() {
        return this.currentPosition;
    }

    public void onPageScrollStateChanged(int i11) {
        LoopingPagerAdapter loopingPagerAdapter;
        LoopingViewPager.IndicatorPageChangeListener access$getIndicatorPageChangeListener$p;
        if (this.f56431b.scrollState == 2 && i11 == 1 && (access$getIndicatorPageChangeListener$p = this.f56431b.indicatorPageChangeListener) != null) {
            LoopingViewPager loopingViewPager = this.f56431b;
            access$getIndicatorPageChangeListener$p.onIndicatorProgress(loopingViewPager.getSelectingIndicatorPosition(loopingViewPager.toTheRight), 1.0f);
        }
        LoopingViewPager loopingViewPager2 = this.f56431b;
        loopingViewPager2.previousScrollState = loopingViewPager2.scrollState;
        this.f56431b.scrollState = i11;
        if (i11 == 0) {
            PagerAdapter adapter = this.f56431b.getAdapter();
            if (adapter instanceof LoopingPagerAdapter) {
                loopingPagerAdapter = (LoopingPagerAdapter) adapter;
            } else {
                loopingPagerAdapter = null;
            }
            if (loopingPagerAdapter != null) {
                if (this.f56431b.infinite) {
                    int count = loopingPagerAdapter.getCount();
                    if (count >= 2) {
                        int currentItem = this.f56431b.getCurrentItem();
                        int i12 = count - 1;
                        if (currentItem == 0) {
                            this.f56431b.setCurrentItem(1, false);
                        } else if (currentItem == i12) {
                            this.f56431b.setCurrentItem(i12 - 1, false);
                        }
                    } else {
                        return;
                    }
                }
                LoopingViewPager.IndicatorPageChangeListener access$getIndicatorPageChangeListener$p2 = this.f56431b.indicatorPageChangeListener;
                if (access$getIndicatorPageChangeListener$p2 != null) {
                    access$getIndicatorPageChangeListener$p2.onIndicatorProgress(this.f56431b.getIndicatorPosition(), 1.0f);
                }
            }
        }
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        boolean z11;
        boolean z12;
        boolean z13;
        LoopingViewPager.IndicatorPageChangeListener access$getIndicatorPageChangeListener$p;
        LoopingViewPager loopingViewPager = this.f56431b;
        float f12 = (float) i11;
        boolean z14 = false;
        if (f12 + f11 >= this.currentPosition) {
            z11 = true;
        } else {
            z11 = false;
        }
        loopingViewPager.toTheRight = z11;
        if (f11 == 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            this.currentPosition = f12;
        }
        LoopingViewPager loopingViewPager2 = this.f56431b;
        int selectingIndicatorPosition = loopingViewPager2.getSelectingIndicatorPosition(loopingViewPager2.toTheRight);
        float calculateProgress = calculateProgress(i11, f11);
        if (calculateProgress == 0.0f) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13 || calculateProgress > 1.0f) {
            LoopingViewPager.IndicatorPageChangeListener access$getIndicatorPageChangeListener$p2 = this.f56431b.indicatorPageChangeListener;
            if (access$getIndicatorPageChangeListener$p2 != null) {
                access$getIndicatorPageChangeListener$p2.onIndicatorProgress(selectingIndicatorPosition, 1.0f);
                return;
            }
            return;
        }
        if ((this.f56431b.toTheRight && Math.abs(selectingIndicatorPosition - this.f56431b.currentPagePosition) == 2) || (!this.f56431b.toTheRight && selectingIndicatorPosition == this.f56431b.currentPagePosition)) {
            z14 = true;
        }
        if ((this.f56431b.scrollState != 1 || !z14) && (access$getIndicatorPageChangeListener$p = this.f56431b.indicatorPageChangeListener) != null) {
            access$getIndicatorPageChangeListener$p.onIndicatorProgress(selectingIndicatorPosition, calculateProgress);
        }
    }

    public void onPageSelected(int i11) {
        LoopingViewPager loopingViewPager = this.f56431b;
        loopingViewPager.previousPosition = loopingViewPager.currentPagePosition;
        this.f56431b.currentPagePosition = i11;
        LoopingViewPager.IndicatorPageChangeListener access$getIndicatorPageChangeListener$p = this.f56431b.indicatorPageChangeListener;
        if (access$getIndicatorPageChangeListener$p != null) {
            access$getIndicatorPageChangeListener$p.onIndicatorPageChange(this.f56431b.getIndicatorPosition());
        }
        if (this.f56431b.autoScrollResumed) {
            this.f56431b.autoScrollHandler.removeCallbacks(this.f56431b.autoScrollRunnable);
            this.f56431b.autoScrollHandler.postDelayed(this.f56431b.autoScrollRunnable, (long) this.f56431b.interval);
        }
    }

    public final void setCurrentPosition(float f11) {
        this.currentPosition = f11;
    }
}
