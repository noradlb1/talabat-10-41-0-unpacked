package com.talabat.darkstores.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.talabat.darkstores.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/common/view/GridSwimlaneView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "snapHelper", "Lcom/github/rubensousa/gravitysnaphelper/GravitySnapHelper;", "getSnapHelper", "()Lcom/github/rubensousa/gravitysnaphelper/GravitySnapHelper;", "getTitle", "", "setTitle", "", "title", "setupRecyclerView", "spanCount", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridSwimlaneView extends ConstraintLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INITIAL_PREFETCH_ITEM_COUNT = 4;
    private static final float MAX_FLING_SIZE_FRACTION = 0.5f;
    private static final float SCROLL_MS_PER_INCH = 25.0f;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final GravitySnapHelper snapHelper;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/common/view/GridSwimlaneView$Companion;", "", "()V", "INITIAL_PREFETCH_ITEM_COUNT", "", "MAX_FLING_SIZE_FRACTION", "", "SCROLL_MS_PER_INCH", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GridSwimlaneView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GridSwimlaneView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GridSwimlaneView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(17);
        gravitySnapHelper.setScrollMsPerInch(SCROLL_MS_PER_INCH);
        gravitySnapHelper.setMaxFlingSizeFraction(0.5f);
        this.snapHelper = gravitySnapHelper;
        View.inflate(context, R.layout.darkstores_grid_swimlane, this);
        setClipChildren(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridSwimlaneView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.GridSwimlaneView)");
        ((TextView) _$_findCachedViewById(R.id.tvTitle)).setText(obtainStyledAttributes.getString(R.styleable.GridSwimlaneView_grid_title));
        int integer = obtainStyledAttributes.getInteger(R.styleable.GridSwimlaneView_span_count, 3);
        obtainStyledAttributes.recycle();
        setupRecyclerView(integer);
    }

    private final void setupRecyclerView(int i11) {
        int i12 = R.id.recyclerView;
        ((RecyclerView) _$_findCachedViewById(i12)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i12);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), i11));
        this.snapHelper.attachToRecyclerView((RecyclerView) _$_findCachedViewById(i12));
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

    @NotNull
    public final GravitySnapHelper getSnapHelper() {
        return this.snapHelper;
    }

    @NotNull
    public final String getTitle() {
        return ((TextView) _$_findCachedViewById(R.id.tvTitle)).getText().toString();
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        ((TextView) _$_findCachedViewById(R.id.tvTitle)).setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridSwimlaneView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
