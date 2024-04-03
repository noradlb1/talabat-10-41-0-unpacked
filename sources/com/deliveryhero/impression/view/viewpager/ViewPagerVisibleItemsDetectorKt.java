package com.deliveryhero.impression.view.viewpager;

import android.graphics.Rect;
import androidx.viewpager.widget.ViewPager;
import com.deliveryhero.impression.ImpressionValidationRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\u0007"}, d2 = {"getViewPagerVisibilityPercentage", "", "Landroidx/viewpager/widget/ViewPager;", "viewPagerIsVisibleEnough", "", "impressionValidationRule", "Lcom/deliveryhero/impression/ImpressionValidationRule;", "impression-tracking_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerVisibleItemsDetectorKt {
    public static final int getViewPagerVisibilityPercentage(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<this>");
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        viewPager.getDrawingRect(rect);
        boolean globalVisibleRect = viewPager.getGlobalVisibleRect(rect2);
        int height = rect2.height() * rect2.width();
        int height2 = rect.height() * rect.width();
        if (globalVisibleRect) {
            return (int) ((((float) height) / ((float) height2)) * ((float) 100));
        }
        return 0;
    }

    public static final boolean viewPagerIsVisibleEnough(@NotNull ViewPager viewPager, @Nullable ImpressionValidationRule impressionValidationRule) {
        Intrinsics.checkNotNullParameter(viewPager, "<this>");
        int viewPagerVisibilityPercentage = getViewPagerVisibilityPercentage(viewPager);
        if (impressionValidationRule == null) {
            return false;
        }
        return impressionValidationRule.isVisibilitySufficient(viewPagerVisibilityPercentage);
    }
}
