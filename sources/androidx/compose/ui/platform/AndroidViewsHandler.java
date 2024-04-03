package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0017J0\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0014J\u0018\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020\u0013H\u0017J\b\u0010,\u001a\u00020\u000fH\u0016R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007`\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006-"}, d2 = {"Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "holderToLayoutNode", "Ljava/util/HashMap;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/collections/HashMap;", "getHolderToLayoutNode", "()Ljava/util/HashMap;", "layoutNodeToHolder", "getLayoutNodeToHolder", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "drawView", "", "view", "canvas", "Landroid/graphics/Canvas;", "invalidateChildInParent", "", "location", "", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", "child", "Landroid/view/View;", "target", "onLayout", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewsHandler extends ViewGroup {
    @NotNull
    private final HashMap<AndroidViewHolder, LayoutNode> holderToLayoutNode = new HashMap<>();
    @NotNull
    private final HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewsHandler(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipChildren(false);
    }

    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        return true;
    }

    public final void drawView(@NotNull AndroidViewHolder androidViewHolder, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        androidViewHolder.draw(canvas);
    }

    @NotNull
    public final HashMap<AndroidViewHolder, LayoutNode> getHolderToLayoutNode() {
        return this.holderToLayoutNode;
    }

    @NotNull
    public final HashMap<LayoutNode, AndroidViewHolder> getLayoutNodeToHolder() {
        return this.layoutNodeToHolder;
    }

    @Nullable
    public Void invalidateChildInParent(@Nullable int[] iArr, @Nullable Rect rect) {
        return null;
    }

    @SuppressLint({"MissingSuperCall"})
    public void onDescendantInvalidated(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        Set<AndroidViewHolder> keySet = this.holderToLayoutNode.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "holderToLayoutNode.keys");
        for (AndroidViewHolder androidViewHolder : keySet) {
            androidViewHolder.layout(androidViewHolder.getLeft(), androidViewHolder.getTop(), androidViewHolder.getRight(), androidViewHolder.getBottom());
        }
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (View.MeasureSpec.getMode(i12) != 1073741824) {
                z12 = false;
            }
            if (z12) {
                setMeasuredDimension(View.MeasureSpec.getSize(i11), View.MeasureSpec.getSize(i12));
                Set<AndroidViewHolder> keySet = this.holderToLayoutNode.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "holderToLayoutNode.keys");
                for (AndroidViewHolder remeasure : keySet) {
                    remeasure.remeasure();
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
        cleanupLayoutState(this);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            LayoutNode layoutNode = this.holderToLayoutNode.get(childAt);
            if (childAt.isLayoutRequested() && layoutNode != null) {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, false, 1, (Object) null);
            }
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
