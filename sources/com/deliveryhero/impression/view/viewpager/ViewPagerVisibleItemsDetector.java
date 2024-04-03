package com.deliveryhero.impression.view.viewpager;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.deliveryhero.impression.view.ItemVisibleArea;
import com.deliveryhero.impression.view.ViewVisibleItemDetector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/deliveryhero/impression/view/viewpager/ViewPagerVisibleItemsDetector;", "Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;", "Landroidx/viewpager/widget/ViewPager;", "()V", "getVisibleItems", "", "Lcom/deliveryhero/impression/view/ItemVisibleArea;", "viewGroup", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerVisibleItemsDetector implements ViewVisibleItemDetector<ViewPager> {
    @NotNull
    public static final ViewPagerVisibleItemsDetector INSTANCE = new ViewPagerVisibleItemsDetector();

    private ViewPagerVisibleItemsDetector() {
    }

    @NotNull
    public List<ItemVisibleArea> getVisibleItems(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewGroup");
        return CollectionsKt__CollectionsJVMKt.listOf(new ItemVisibleArea(viewPager.getCurrentItem(), (View) null, ViewPagerVisibleItemsDetectorKt.getViewPagerVisibilityPercentage(viewPager)));
    }
}
