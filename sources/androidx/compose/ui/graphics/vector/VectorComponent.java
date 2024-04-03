package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00102\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020\u001cH\u0016J\f\u00104\u001a\u00020\b*\u00020\u0007H\u0016J\u001c\u00104\u001a\u00020\b*\u00020\u00072\u0006\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0004¢\u0006\u0002\n\u0000R/\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8@@@X\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0019\u0010\"\u001a\u00020#X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020)@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020)@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "", "viewportHeight", "getViewportHeight", "()F", "setViewportHeight", "(F)V", "viewportWidth", "getViewportWidth", "setViewportWidth", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VectorComponent extends VNode {
    @NotNull
    private final DrawCache cacheDrawScope = new DrawCache();
    @NotNull
    private final Function1<DrawScope, Unit> drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    @NotNull
    private final MutableState intrinsicColorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private Function0<Unit> invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
    private boolean isDirty = true;
    private long previousDrawSize = Size.Companion.m2753getUnspecifiedNHjbRc();
    @NotNull
    private final GroupComponent root;
    private float viewportHeight;
    private float viewportWidth;

    public VectorComponent() {
        super((DefaultConstructorMarker) null);
        GroupComponent groupComponent = new GroupComponent();
        groupComponent.setPivotX(0.0f);
        groupComponent.setPivotY(0.0f);
        groupComponent.setInvalidateListener$ui_release(new VectorComponent$root$1$1(this));
        this.root = groupComponent;
    }

    /* access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final void draw(@NotNull DrawScope drawScope, float f11, @Nullable ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (colorFilter == null) {
            colorFilter = getIntrinsicColorFilter$ui_release();
        }
        if (this.isDirty || !Size.m2741equalsimpl0(this.previousDrawSize, drawScope.m3425getSizeNHjbRc())) {
            this.root.setScaleX(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) / this.viewportWidth);
            this.root.setScaleY(Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) / this.viewportHeight);
            this.cacheDrawScope.m3517drawCachedImageCJJARo(IntSizeKt.IntSize((int) ((float) Math.ceil((double) Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()))), (int) ((float) Math.ceil((double) Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc())))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.m3425getSizeNHjbRc();
        }
        this.cacheDrawScope.drawInto(drawScope, f11, colorFilter);
    }

    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter$delegate.getValue();
    }

    @NotNull
    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    @NotNull
    public final String getName() {
        return this.root.getName();
    }

    @NotNull
    public final GroupComponent getRoot() {
        return this.root;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.intrinsicColorFilter$delegate.setValue(colorFilter);
    }

    public final void setInvalidateCallback$ui_release(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.invalidateCallback = function0;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.root.setName(str);
    }

    public final void setViewportHeight(float f11) {
        boolean z11;
        if (this.viewportHeight == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.viewportHeight = f11;
            doInvalidate();
        }
    }

    public final void setViewportWidth(float f11) {
        boolean z11;
        if (this.viewportWidth == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.viewportWidth = f11;
            doInvalidate();
        }
    }

    @NotNull
    public String toString() {
        String str = "Params: " + "\tname: " + getName() + StringUtils.LF + "\tviewportWidth: " + this.viewportWidth + StringUtils.LF + "\tviewportHeight: " + this.viewportHeight + StringUtils.LF;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    public void draw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        draw(drawScope, 1.0f, (ColorFilter) null);
    }
}
