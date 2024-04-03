package d5;

import androidx.viewpager2.widget.ViewPager2;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorWidget;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public final /* synthetic */ class a implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PagerDotsIndicatorWidget f34411a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f34412b;

    public /* synthetic */ a(PagerDotsIndicatorWidget pagerDotsIndicatorWidget, ViewPager2 viewPager2) {
        this.f34411a = pagerDotsIndicatorWidget;
        this.f34412b = viewPager2;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        PagerDotsIndicatorWidget.m8218init$lambda1(this.f34411a, this.f34412b, tab, i11);
    }
}
