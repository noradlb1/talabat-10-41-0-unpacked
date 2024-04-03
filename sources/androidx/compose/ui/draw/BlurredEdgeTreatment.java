package androidx.compose.ui.draw;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "constructor-impl", "(Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "equals", "", "other", "equals-impl", "(Landroidx/compose/ui/graphics/Shape;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/ui/graphics/Shape;)I", "toString", "", "toString-impl", "(Landroidx/compose/ui/graphics/Shape;)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlurredEdgeTreatment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Shape Rectangle = m2564constructorimpl(RectangleShapeKt.getRectangleShape());
    /* access modifiers changed from: private */
    @NotNull
    public static final Shape Unbounded = m2564constructorimpl((Shape) null);
    @Nullable
    private final Shape shape;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/draw/BlurredEdgeTreatment$Companion;", "", "()V", "Rectangle", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "getRectangle---Goahg", "()Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Shape;", "Unbounded", "getUnbounded---Goahg", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: getRectangle---Goahg  reason: not valid java name */
        public final Shape m2570getRectangleGoahg() {
            return BlurredEdgeTreatment.Rectangle;
        }

        @NotNull
        /* renamed from: getUnbounded---Goahg  reason: not valid java name */
        public final Shape m2571getUnboundedGoahg() {
            return BlurredEdgeTreatment.Unbounded;
        }
    }

    private /* synthetic */ BlurredEdgeTreatment(Shape shape2) {
        this.shape = shape2;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BlurredEdgeTreatment m2563boximpl(Shape shape2) {
        return new BlurredEdgeTreatment(shape2);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Shape m2564constructorimpl(@Nullable Shape shape2) {
        return shape2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2565equalsimpl(Shape shape2, Object obj) {
        return (obj instanceof BlurredEdgeTreatment) && Intrinsics.areEqual((Object) shape2, (Object) ((BlurredEdgeTreatment) obj).m2569unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2566equalsimpl0(Shape shape2, Shape shape3) {
        return Intrinsics.areEqual((Object) shape2, (Object) shape3);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2567hashCodeimpl(Shape shape2) {
        if (shape2 == null) {
            return 0;
        }
        return shape2.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2568toStringimpl(Shape shape2) {
        return "BlurredEdgeTreatment(shape=" + shape2 + ')';
    }

    public boolean equals(Object obj) {
        return m2565equalsimpl(this.shape, obj);
    }

    @Nullable
    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return m2567hashCodeimpl(this.shape);
    }

    public String toString() {
        return m2568toStringimpl(this.shape);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Shape m2569unboximpl() {
        return this.shape;
    }
}
