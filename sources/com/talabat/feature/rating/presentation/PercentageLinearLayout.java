package com.talabat.feature.rating.presentation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0014J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/rating/presentation/PercentageLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "percentage", "", "getPercentage", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setPercentage", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PercentageLinearLayout extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private int percentage;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PercentageLinearLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PercentageLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PercentageLayout, 0, 0);
        try {
            this.percentage = obtainStyledAttributes.getInt(R.styleable.PercentageLayout_percentage, 90);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final int getPercentage() {
        return this.percentage;
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMinimumHeight((getResources().getDisplayMetrics().heightPixels / 90) * this.percentage);
    }

    public final void setPercentage(int i11) {
        this.percentage = i11;
        invalidate();
        requestLayout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PercentageLinearLayout(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }
}
