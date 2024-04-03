package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.browser.R;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class BrowserActionsFallbackMenuView extends LinearLayout {
    private final int mBrowserActionsMenuMaxWidthPx = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);
    private final int mBrowserActionsMenuMinPaddingPx = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);

    public BrowserActionsFallbackMenuView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.mBrowserActionsMenuMinPaddingPx * 2), this.mBrowserActionsMenuMaxWidthPx), 1073741824), i12);
    }
}
