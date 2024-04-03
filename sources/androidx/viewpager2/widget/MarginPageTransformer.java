package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int i11) {
        Preconditions.checkArgumentNonnegative(i11, "Margin must be non-negative");
        this.mMarginPx = i11;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    public void transformPage(@NonNull View view, float f11) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float f12 = ((float) this.mMarginPx) * f11;
        if (requireViewPager.getOrientation() == 0) {
            if (requireViewPager.isRtl()) {
                f12 = -f12;
            }
            view.setTranslationX(f12);
            return;
        }
        view.setTranslationY(f12);
    }
}
