package com.talabat.darkstores.common.customScrollingViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/common/customScrollingViews/CustomVerticalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mGestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "YScrollDetector", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomVerticalRecyclerView extends RecyclerView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final GestureDetectorCompat mGestureDetector;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/common/customScrollingViews/CustomVerticalRecyclerView$YScrollDetector;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/talabat/darkstores/common/customScrollingViews/CustomVerticalRecyclerView;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "onScroll", "distanceX", "distanceY", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        public YScrollDetector() {
        }

        public boolean onFling(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f11, float f12) {
            Intrinsics.checkNotNullParameter(motionEvent, "e1");
            Intrinsics.checkNotNullParameter(motionEvent2, "e2");
            if (Math.abs(f12) > Math.abs(f11)) {
                return true;
            }
            return false;
        }

        public boolean onScroll(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f11, float f12) {
            Intrinsics.checkNotNullParameter(motionEvent, "e1");
            Intrinsics.checkNotNullParameter(motionEvent2, "e2");
            if (Math.abs(f12) > Math.abs(f11)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomVerticalRecyclerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomVerticalRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomVerticalRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mGestureDetector = new GestureDetectorCompat(context, new YScrollDetector());
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

    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        return this.mGestureDetector.onTouchEvent(motionEvent) & super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomVerticalRecyclerView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
