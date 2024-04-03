package com.talabat.sdsquad.ui.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.talabat.sdsquad.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/talabat/sdsquad/ui/customviews/LoadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "start", "", "stop", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoadingView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.view_loading, this);
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

    public final void start() {
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer1)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer2)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer3)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer4)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer5)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer6)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer7)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer8)).startShimmerAnimation();
    }

    public final void stop() {
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer1)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer2)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer3)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer4)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer5)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer6)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer7)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(R.id.shimmer8)).stopShimmerAnimation();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoadingView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
