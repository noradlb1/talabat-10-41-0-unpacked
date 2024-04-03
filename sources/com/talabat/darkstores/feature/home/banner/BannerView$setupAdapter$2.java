package com.talabat.darkstores.feature.home.banner;

import com.rd.PageIndicatorView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.banner.LoopingViewPager;
import com.talabat.darkstores.model.Banner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/talabat/darkstores/feature/home/banner/BannerView$setupAdapter$2", "Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager$IndicatorPageChangeListener;", "onIndicatorPageChange", "", "newIndicatorPosition", "", "onIndicatorProgress", "selectingPosition", "progress", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerView$setupAdapter$2 implements LoopingViewPager.IndicatorPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerView f56429a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List<Banner> f56430b;

    public BannerView$setupAdapter$2(BannerView bannerView, List<Banner> list) {
        this.f56429a = bannerView;
        this.f56430b = list;
    }

    public void onIndicatorPageChange(int i11) {
        Function2 access$getBannerShownListener$p = this.f56429a.bannerShownListener;
        if (access$getBannerShownListener$p != null) {
            access$getBannerShownListener$p.invoke(this.f56430b.get(i11), Integer.valueOf(i11));
        }
    }

    public void onIndicatorProgress(int i11, float f11) {
        ((PageIndicatorView) this.f56429a._$_findCachedViewById(R.id.pageIndicatorView)).setProgress(i11, f11);
    }
}
