package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class PointerType {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Eraser = m4363constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Mouse = m4363constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Stylus = m4363constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Touch = m4363constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Unknown = m4363constructorimpl(0);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerType$Companion;", "", "()V", "Eraser", "Landroidx/compose/ui/input/pointer/PointerType;", "getEraser-T8wyACA", "()I", "I", "Mouse", "getMouse-T8wyACA", "Stylus", "getStylus-T8wyACA", "Touch", "getTouch-T8wyACA", "Unknown", "getUnknown-T8wyACA", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEraser-T8wyACA  reason: not valid java name */
        public final int m4369getEraserT8wyACA() {
            return PointerType.Eraser;
        }

        /* renamed from: getMouse-T8wyACA  reason: not valid java name */
        public final int m4370getMouseT8wyACA() {
            return PointerType.Mouse;
        }

        /* renamed from: getStylus-T8wyACA  reason: not valid java name */
        public final int m4371getStylusT8wyACA() {
            return PointerType.Stylus;
        }

        /* renamed from: getTouch-T8wyACA  reason: not valid java name */
        public final int m4372getTouchT8wyACA() {
            return PointerType.Touch;
        }

        /* renamed from: getUnknown-T8wyACA  reason: not valid java name */
        public final int m4373getUnknownT8wyACA() {
            return PointerType.Unknown;
        }
    }

    private /* synthetic */ PointerType(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointerType m4362boximpl(int i11) {
        return new PointerType(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m4363constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4364equalsimpl(int i11, Object obj) {
        return (obj instanceof PointerType) && i11 == ((PointerType) obj).m4368unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4365equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4366hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4367toStringimpl(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }

    public boolean equals(Object obj) {
        return m4364equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4366hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4367toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4368unboximpl() {
        return this.value;
    }
}
