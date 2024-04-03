package com.talabat.darkstores.common.view;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/darkstores/common/view/ExpandCollapseTextView$drawWithSpanIfNeeded$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpandCollapseTextView$drawWithSpanIfNeeded$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandCollapseTextView f56174b;

    public ExpandCollapseTextView$drawWithSpanIfNeeded$1(ExpandCollapseTextView expandCollapseTextView) {
        this.f56174b = expandCollapseTextView;
    }

    public void onGlobalLayout() {
        this.f56174b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.f56174b.getLineCount() > this.f56174b.getLinesLimit()) {
            this.f56174b.showCollapsedTextWithMore();
        }
    }
}
