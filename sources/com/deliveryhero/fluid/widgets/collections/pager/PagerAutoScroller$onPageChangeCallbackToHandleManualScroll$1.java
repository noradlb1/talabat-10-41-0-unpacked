package com.deliveryhero.fluid.widgets.collections.pager;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"com/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "didDrag", "", "onPageScrollStateChanged", "", "state", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1 extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PagerAutoScroller f30258a;
    private boolean didDrag;

    public PagerAutoScroller$onPageChangeCallbackToHandleManualScroll$1(PagerAutoScroller pagerAutoScroller) {
        this.f30258a = pagerAutoScroller;
    }

    public void onPageScrollStateChanged(int i11) {
        if (i11 == 1) {
            this.didDrag = true;
            this.f30258a.stopScrolling();
        } else if (this.didDrag && i11 == 0) {
            this.f30258a.startScrolling();
        }
    }
}
