package androidx.compose.foundation;

import a0.a;
import a0.b;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(29)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/ExcludeFromSystemGestureModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "view", "Landroid/view/View;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getExclusion", "()Lkotlin/jvm/functions/Function1;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getView", "()Landroid/view/View;", "calcBounds", "layoutCoordinates", "findRoot", "onGloballyPositioned", "", "coordinates", "removeRect", "replaceRect", "newRect", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ExcludeFromSystemGestureModifier implements OnGloballyPositionedModifier {
    @Nullable
    private final Function1<LayoutCoordinates, Rect> exclusion;
    @Nullable
    private android.graphics.Rect rect;
    @NotNull
    private final View view;

    public ExcludeFromSystemGestureModifier(@NotNull View view2, @Nullable Function1<? super LayoutCoordinates, Rect> function1) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        this.exclusion = function1;
    }

    private final android.graphics.Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect2) {
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        LayoutCoordinates findRoot = findRoot(layoutCoordinates);
        long r22 = findRoot.m4474localPositionOfR5De75A(layoutCoordinates2, rect2.m2711getTopLeftF1C5BW0());
        long r42 = findRoot.m4474localPositionOfR5De75A(layoutCoordinates2, rect2.m2712getTopRightF1C5BW0());
        long r62 = findRoot.m4474localPositionOfR5De75A(layoutCoordinates2, rect2.m2704getBottomLeftF1C5BW0());
        long r02 = findRoot.m4474localPositionOfR5De75A(layoutCoordinates2, rect2.m2705getBottomRightF1C5BW0());
        return new android.graphics.Rect(MathKt__MathJVMKt.roundToInt(ComparisonsKt___ComparisonsJvmKt.minOf(Offset.m2676getXimpl(r22), Offset.m2676getXimpl(r42), Offset.m2676getXimpl(r62), Offset.m2676getXimpl(r02))), MathKt__MathJVMKt.roundToInt(ComparisonsKt___ComparisonsJvmKt.minOf(Offset.m2677getYimpl(r22), Offset.m2677getYimpl(r42), Offset.m2677getYimpl(r62), Offset.m2677getYimpl(r02))), MathKt__MathJVMKt.roundToInt(ComparisonsKt___ComparisonsJvmKt.maxOf(Offset.m2676getXimpl(r22), Offset.m2676getXimpl(r42), Offset.m2676getXimpl(r62), Offset.m2676getXimpl(r02))), MathKt__MathJVMKt.roundToInt(ComparisonsKt___ComparisonsJvmKt.maxOf(Offset.m2677getYimpl(r22), Offset.m2677getYimpl(r42), Offset.m2677getYimpl(r62), Offset.m2677getYimpl(r02))));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates2 = parentLayoutCoordinates;
            LayoutCoordinates layoutCoordinates3 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates2;
            if (layoutCoordinates == null) {
                return layoutCoordinates3;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @Nullable
    public final Function1<LayoutCoordinates, Rect> getExclusion() {
        return this.exclusion;
    }

    @Nullable
    public final android.graphics.Rect getRect() {
        return this.rect;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates) {
        android.graphics.Rect rect2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Function1<LayoutCoordinates, Rect> function1 = this.exclusion;
        if (function1 == null) {
            rect2 = RectHelper_androidKt.toAndroidRect(LayoutCoordinatesKt.boundsInRoot(layoutCoordinates));
        } else {
            rect2 = calcBounds(layoutCoordinates, function1.invoke(layoutCoordinates));
        }
        replaceRect(rect2);
    }

    public final void removeRect() {
        replaceRect((android.graphics.Rect) null);
    }

    public final void replaceRect(@Nullable android.graphics.Rect rect2) {
        boolean z11 = false;
        MutableVector mutableVector = new MutableVector(new android.graphics.Rect[16], 0);
        List a11 = this.view.getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(a11, "view.systemGestureExclusionRects");
        mutableVector.addAll(mutableVector.getSize(), a11);
        android.graphics.Rect rect3 = this.rect;
        if (rect3 != null) {
            mutableVector.remove(rect3);
        }
        if (rect2 != null && !rect2.isEmpty()) {
            z11 = true;
        }
        if (z11) {
            mutableVector.add(rect2);
        }
        this.view.setSystemGestureExclusionRects(mutableVector.asMutableList());
        this.rect = rect2;
    }

    public final void setRect(@Nullable android.graphics.Rect rect2) {
        this.rect = rect2;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
