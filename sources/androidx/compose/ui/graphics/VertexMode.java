package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VertexMode {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TriangleFan = m3294constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int TriangleStrip = m3294constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Triangles = m3294constructorimpl(0);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode$Companion;", "", "()V", "TriangleFan", "Landroidx/compose/ui/graphics/VertexMode;", "getTriangleFan-c2xauaI", "()I", "I", "TriangleStrip", "getTriangleStrip-c2xauaI", "Triangles", "getTriangles-c2xauaI", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getTriangleFan-c2xauaI  reason: not valid java name */
        public final int m3300getTriangleFanc2xauaI() {
            return VertexMode.TriangleFan;
        }

        /* renamed from: getTriangleStrip-c2xauaI  reason: not valid java name */
        public final int m3301getTriangleStripc2xauaI() {
            return VertexMode.TriangleStrip;
        }

        /* renamed from: getTriangles-c2xauaI  reason: not valid java name */
        public final int m3302getTrianglesc2xauaI() {
            return VertexMode.Triangles;
        }
    }

    private /* synthetic */ VertexMode(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ VertexMode m3293boximpl(int i11) {
        return new VertexMode(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3294constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3295equalsimpl(int i11, Object obj) {
        return (obj instanceof VertexMode) && i11 == ((VertexMode) obj).m3299unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3296equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3297hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3298toStringimpl(int i11) {
        if (m3296equalsimpl0(i11, Triangles)) {
            return "Triangles";
        }
        if (m3296equalsimpl0(i11, TriangleStrip)) {
            return "TriangleStrip";
        }
        if (m3296equalsimpl0(i11, TriangleFan)) {
            return "TriangleFan";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m3295equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3297hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3298toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3299unboximpl() {
        return this.value;
    }
}
