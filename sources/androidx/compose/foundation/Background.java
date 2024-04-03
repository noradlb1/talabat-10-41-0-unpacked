package androidx.compose.foundation;

import a0.a;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.LayoutDirection;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\f\u0010\u001f\u001a\u00020\u000e*\u00020 H\u0016J\f\u0010!\u001a\u00020\u000e*\u00020 H\u0002J\f\u0010\"\u001a\u00020\u000e*\u00020 H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/foundation/Background;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "equals", "", "other", "", "hashCode", "", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class Background extends InspectorValueInfo implements DrawModifier {
    private final float alpha;
    @Nullable
    private final Brush brush;
    @Nullable
    private final Color color;
    @Nullable
    private LayoutDirection lastLayoutDirection;
    @Nullable
    private Outline lastOutline;
    @Nullable
    private Size lastSize;
    @NotNull
    private final Shape shape;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Background(Color color2, Brush brush2, float f11, Shape shape2, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : color2, (i11 & 2) != 0 ? null : brush2, (i11 & 4) != 0 ? 1.0f : f11, shape2, function1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ Background(Color color2, Brush brush2, float f11, Shape shape2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(color2, brush2, f11, shape2, function1);
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline outline;
        if (!Size.m2740equalsimpl(contentDrawScope.m3425getSizeNHjbRc(), this.lastSize) || contentDrawScope.getLayoutDirection() != this.lastLayoutDirection) {
            outline = this.shape.m3232createOutlinePq9zytI(contentDrawScope.m3425getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        } else {
            outline = this.lastOutline;
            Intrinsics.checkNotNull(outline);
        }
        Color color2 = this.color;
        if (color2 != null) {
            color2.m2929unboximpl();
            OutlineKt.m3128drawOutlinewDX37Ww$default(contentDrawScope, outline, this.color.m2929unboximpl(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            OutlineKt.m3126drawOutlinehn5TExg$default(contentDrawScope, outline, brush2, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
        this.lastOutline = outline;
        this.lastSize = Size.m2733boximpl(contentDrawScope.m3425getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        Color color2 = this.color;
        if (color2 != null) {
            b.K(contentDrawScope, color2.m2929unboximpl(), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            b.J(contentDrawScope, brush2, 0, 0, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
        }
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return a0.b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return a0.b.b(this, function1);
    }

    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        Background background;
        boolean z11;
        if (obj instanceof Background) {
            background = (Background) obj;
        } else {
            background = null;
        }
        if (background == null || !Intrinsics.areEqual((Object) this.color, (Object) background.color) || !Intrinsics.areEqual((Object) this.brush, (Object) background.brush)) {
            return false;
        }
        if (this.alpha == background.alpha) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !Intrinsics.areEqual((Object) this.shape, (Object) background.shape)) {
            return false;
        }
        return true;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return a0.b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return a0.b.d(this, obj, function2);
    }

    public int hashCode() {
        int i11;
        Color color2 = this.color;
        int i12 = 0;
        if (color2 != null) {
            i11 = Color.m2926hashCodeimpl(color2.m2929unboximpl());
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        Brush brush2 = this.brush;
        if (brush2 != null) {
            i12 = brush2.hashCode();
        }
        return ((((i13 + i12) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.shape.hashCode();
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "Background(color=" + this.color + ", brush=" + this.brush + ", alpha = " + this.alpha + ", shape=" + this.shape + ')';
    }

    private Background(Color color2, Brush brush2, float f11, Shape shape2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.color = color2;
        this.brush = brush2;
        this.alpha = f11;
        this.shape = shape2;
    }
}
