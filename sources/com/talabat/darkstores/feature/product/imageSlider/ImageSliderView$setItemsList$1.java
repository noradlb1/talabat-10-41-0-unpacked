package com.talabat.darkstores.feature.product.imageSlider;

import android.widget.TextView;
import com.rd.PageIndicatorView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/talabat/darkstores/feature/product/imageSlider/ImageSliderView$setItemsList$1", "Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager$IndicatorPageChangeListener;", "onIndicatorPageChange", "", "newIndicatorPosition", "", "onIndicatorProgress", "selectingPosition", "progress", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageSliderView$setItemsList$1 implements LoopingViewPager.IndicatorPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f56505a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageSliderView f56506b;

    public ImageSliderView$setItemsList$1(boolean z11, ImageSliderView imageSliderView) {
        this.f56505a = z11;
        this.f56506b = imageSliderView;
    }

    public void onIndicatorPageChange(int i11) {
    }

    public void onIndicatorProgress(int i11, float f11) {
        if (this.f56505a) {
            int indicatorCount = ((LoopingViewPager) this.f56506b._$_findCachedViewById(R.id.viewpager)).getIndicatorCount();
            ((TextView) this.f56506b._$_findCachedViewById(R.id.pageNumberText)).setText((i11 + 1) + "/" + indicatorCount);
            return;
        }
        ((PageIndicatorView) this.f56506b._$_findCachedViewById(R.id.pageIndicatorView)).setProgress(i11, f11);
    }
}
