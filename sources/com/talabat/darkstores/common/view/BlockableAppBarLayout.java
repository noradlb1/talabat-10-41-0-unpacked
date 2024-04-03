package com.talabat.darkstores.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\b\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/common/view/BlockableAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dragCallback", "com/talabat/darkstores/common/view/BlockableAppBarLayout$dragCallback$1", "Lcom/talabat/darkstores/common/view/BlockableAppBarLayout$dragCallback$1;", "isScrollingEnabled", "", "()Z", "setScrollingEnabled", "(Z)V", "onLayout", "", "changed", "l", "", "t", "r", "b", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlockableAppBarLayout extends AppBarLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final BlockableAppBarLayout$dragCallback$1 dragCallback;
    private boolean isScrollingEnabled;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BlockableAppBarLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BlockableAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.isScrollingEnabled = true;
        this.dragCallback = new BlockableAppBarLayout$dragCallback$1(this);
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

    public final boolean isScrollingEnabled() {
        return this.isScrollingEnabled;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        CoordinatorLayout.LayoutParams layoutParams;
        CoordinatorLayout.Behavior behavior;
        super.onLayout(z11, i11, i12, i13, i14);
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        AppBarLayout.Behavior behavior2 = null;
        if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
            layoutParams = (CoordinatorLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            behavior = layoutParams.getBehavior();
        } else {
            behavior = null;
        }
        if (behavior instanceof AppBarLayout.Behavior) {
            behavior2 = (AppBarLayout.Behavior) behavior;
        }
        if (behavior2 != null) {
            behavior2.setDragCallback(this.dragCallback);
        } else {
            Timber.d("Cannot set drag callback. AppBarLayout will ignore isScrollingEnabled flag.", new Object[0]);
        }
    }

    public final void setScrollingEnabled(boolean z11) {
        this.isScrollingEnabled = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlockableAppBarLayout(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }
}
