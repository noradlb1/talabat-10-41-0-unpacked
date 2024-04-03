package com.talabat.homescreen.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.homescreen.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/homescreen/widget/BaseHomeHorizontalRecyclerViewLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "snapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "applyAttributes", "", "handleListSubmit", "isListEmpty", "", "showBig", "isDividerShown", "isVisible", "setTitle", "title", "", "setupRecyclerView", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseHomeHorizontalRecyclerViewLayout extends ConstraintLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final PagerSnapHelper snapHelper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseHomeHorizontalRecyclerViewLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.snapHelper = new PagerSnapHelper();
        View.inflate(getContext(), R.layout.layout_base_horizontal_recycler_view, this);
        setupRecyclerView();
    }

    private final void applyAttributes(AttributeSet attributeSet) {
        int i11;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BaseHomeHorizontalRecyclerViewLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yclerViewLayout\n        )");
        String string = obtainStyledAttributes.getString(R.styleable.BaseHomeHorizontalRecyclerViewLayout_recyclerViewTitle);
        if (string != null) {
            ((TextView) _$_findCachedViewById(R.id.tvHomeBaseHorizontalTitle)).setText(string);
        }
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.BaseHomeHorizontalRecyclerViewLayout_showRightArrow, false);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivHomeBaseHorizontalArrow);
        Intrinsics.checkNotNullExpressionValue(imageView, "ivHomeBaseHorizontalArrow");
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        if (obtainStyledAttributes.getBoolean(R.styleable.BaseHomeHorizontalRecyclerViewLayout_withSnapHelper, false)) {
            this.snapHelper.attachToRecyclerView((RecyclerView) _$_findCachedViewById(R.id.rvHomeBaseHorizontal));
        }
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void handleListSubmit$default(BaseHomeHorizontalRecyclerViewLayout baseHomeHorizontalRecyclerViewLayout, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        baseHomeHorizontalRecyclerViewLayout.handleListSubmit(z11, z12);
    }

    private final void setupRecyclerView() {
        ((RecyclerView) _$_findCachedViewById(R.id.rvHomeBaseHorizontal)).setNestedScrollingEnabled(false);
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

    public final void handleListSubmit(boolean z11, boolean z12) {
        int i11;
        int i12;
        int i13;
        boolean z13;
        int i14;
        ShimmerLayout shimmerLayout = (ShimmerLayout) _$_findCachedViewById(R.id.verticalsShimmer);
        Intrinsics.checkNotNullExpressionValue(shimmerLayout, "verticalsShimmer");
        int i15 = 8;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        shimmerLayout.setVisibility(i11);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.titleLayout);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "titleLayout");
        if (!z11) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        linearLayout.setVisibility(i12);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvHomeBaseHorizontal);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvHomeBaseHorizontal");
        if (!z11) {
            i13 = 0;
        } else {
            i13 = 8;
        }
        recyclerView.setVisibility(i13);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.shimmerLayoutBaseHorizontalSmall);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "shimmerLayoutBaseHorizontalSmall");
        boolean z14 = true;
        if (z12 || !z11) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            i14 = 0;
        } else {
            i14 = 8;
        }
        _$_findCachedViewById.setVisibility(i14);
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.shimmerLayoutBaseHorizontalBig);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById2, "shimmerLayoutBaseHorizontalBig");
        if (!z12 || !z11) {
            z14 = false;
        }
        if (z14) {
            i15 = 0;
        }
        _$_findCachedViewById2.setVisibility(i15);
    }

    public final void isDividerShown(boolean z11) {
        int i11;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.bottomDivider);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "bottomDivider");
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        _$_findCachedViewById.setVisibility(i11);
    }

    public final void setTitle(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "title");
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ((TextView) _$_findCachedViewById(R.id.tvHomeBaseHorizontalTitle)).setText(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseHomeHorizontalRecyclerViewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.snapHelper = new PagerSnapHelper();
        View.inflate(getContext(), R.layout.layout_base_horizontal_recycler_view, this);
        setupRecyclerView();
        applyAttributes(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseHomeHorizontalRecyclerViewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.snapHelper = new PagerSnapHelper();
        View.inflate(getContext(), R.layout.layout_base_horizontal_recycler_view, this);
        setupRecyclerView();
        applyAttributes(attributeSet);
    }
}
