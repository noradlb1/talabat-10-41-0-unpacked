package com.designsystem.ds_bottom_sheet_v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/designsystem/ds_bottom_sheet_v2/MaxHeightFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MaxHeightFrameLayout extends FrameLayout {
    private boolean isFullScreen;
    private int maxHeight;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MaxHeightFrameLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MaxHeightFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(View.MeasureSpec.getSize(i12), this.maxHeight);
        if (this.isFullScreen) {
            i13 = View.MeasureSpec.makeMeasureSpec(coerceAtMost, 1073741824);
        } else {
            i13 = View.MeasureSpec.makeMeasureSpec(coerceAtMost, Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i13);
    }

    public final void setFullScreen(boolean z11) {
        this.isFullScreen = z11;
    }

    public final void setMaxHeight(int i11) {
        this.maxHeight = i11;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MaxHeightFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFullScreen = true;
    }
}
