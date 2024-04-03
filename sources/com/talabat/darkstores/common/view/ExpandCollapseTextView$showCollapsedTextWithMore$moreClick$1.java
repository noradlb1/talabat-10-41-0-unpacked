package com.talabat.darkstores.common.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/talabat/darkstores/common/view/ExpandCollapseTextView$showCollapsedTextWithMore$moreClick$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "textView", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpandCollapseTextView$showCollapsedTextWithMore$moreClick$1 extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandCollapseTextView f56175b;

    public ExpandCollapseTextView$showCollapsedTextWithMore$moreClick$1(ExpandCollapseTextView expandCollapseTextView) {
        this.f56175b = expandCollapseTextView;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "textView");
        this.f56175b.setLinesLimit(100);
        ExpandCollapseTextView expandCollapseTextView = this.f56175b;
        expandCollapseTextView.setText(expandCollapseTextView.getTag().toString());
        this.f56175b.showExpandedTextWithLess();
        this.f56175b.invalidate();
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
