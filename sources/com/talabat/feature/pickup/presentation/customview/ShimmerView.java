package com.talabat.feature.pickup.presentation.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/pickup/presentation/customview/ShimmerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "filtersShimmer", "Lcom/talabat/talabatcommon/views/ShimmerLayout;", "shimmer1", "shimmer2", "shimmer3", "shimmer4", "shimmer5", "shimmer6", "swimlanesShimmer", "valuePropShimmer", "animate", "", "shouldStart", "", "showSwimlanesBanner", "show", "showValuePropBanner", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShimmerView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ShimmerLayout filtersShimmer;
    @NotNull
    private final ShimmerLayout shimmer1;
    @NotNull
    private final ShimmerLayout shimmer2;
    @NotNull
    private final ShimmerLayout shimmer3;
    @NotNull
    private final ShimmerLayout shimmer4;
    @NotNull
    private final ShimmerLayout shimmer5;
    @NotNull
    private final ShimmerLayout shimmer6;
    @NotNull
    private final ShimmerLayout swimlanesShimmer;
    @NotNull
    private final ShimmerLayout valuePropShimmer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShimmerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShimmerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShimmerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.view_shimmer, this);
        View findViewById = findViewById(R.id.shimmer1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.shimmer1)");
        this.shimmer1 = (ShimmerLayout) findViewById;
        View findViewById2 = findViewById(R.id.shimmer2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.shimmer2)");
        this.shimmer2 = (ShimmerLayout) findViewById2;
        View findViewById3 = findViewById(R.id.shimmer3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.shimmer3)");
        this.shimmer3 = (ShimmerLayout) findViewById3;
        View findViewById4 = findViewById(R.id.shimmer4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.shimmer4)");
        this.shimmer4 = (ShimmerLayout) findViewById4;
        View findViewById5 = findViewById(R.id.shimmer5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.shimmer5)");
        this.shimmer5 = (ShimmerLayout) findViewById5;
        View findViewById6 = findViewById(R.id.shimmer6);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.shimmer6)");
        this.shimmer6 = (ShimmerLayout) findViewById6;
        View findViewById7 = findViewById(R.id.valuePropShimmer);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.valuePropShimmer)");
        this.valuePropShimmer = (ShimmerLayout) findViewById7;
        View findViewById8 = findViewById(R.id.filtersShimmer);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.filtersShimmer)");
        this.filtersShimmer = (ShimmerLayout) findViewById8;
        View findViewById9 = findViewById(R.id.swimlanesShimmer);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.swimlanesShimmer)");
        this.swimlanesShimmer = (ShimmerLayout) findViewById9;
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

    public final void animate(boolean z11) {
        if (z11) {
            this.valuePropShimmer.startShimmerAnimation();
            this.filtersShimmer.startShimmerAnimation();
            this.swimlanesShimmer.startShimmerAnimation();
            this.shimmer1.startShimmerAnimation();
            this.shimmer2.startShimmerAnimation();
            this.shimmer3.startShimmerAnimation();
            this.shimmer4.startShimmerAnimation();
            this.shimmer5.startShimmerAnimation();
            this.shimmer6.startShimmerAnimation();
            return;
        }
        this.valuePropShimmer.stopShimmerAnimation();
        this.filtersShimmer.stopShimmerAnimation();
        this.swimlanesShimmer.stopShimmerAnimation();
        this.shimmer1.stopShimmerAnimation();
        this.shimmer2.stopShimmerAnimation();
        this.shimmer3.stopShimmerAnimation();
        this.shimmer4.stopShimmerAnimation();
        this.shimmer5.stopShimmerAnimation();
        this.shimmer6.stopShimmerAnimation();
    }

    public final void showSwimlanesBanner(boolean z11) {
        int i11;
        ShimmerLayout shimmerLayout = this.swimlanesShimmer;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        shimmerLayout.setVisibility(i11);
    }

    public final void showValuePropBanner(boolean z11) {
        int i11;
        ShimmerLayout shimmerLayout = this.valuePropShimmer;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        shimmerLayout.setVisibility(i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShimmerView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
