package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class PointerEventType {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Enter = m4256constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Exit = m4256constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int Move = m4256constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Press = m4256constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Release = m4256constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Scroll = m4256constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int Unknown = m4256constructorimpl(0);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType$Companion;", "", "()V", "Enter", "Landroidx/compose/ui/input/pointer/PointerEventType;", "getEnter-7fucELk", "()I", "I", "Exit", "getExit-7fucELk", "Move", "getMove-7fucELk", "Press", "getPress-7fucELk", "Release", "getRelease-7fucELk", "Scroll", "getScroll-7fucELk", "Unknown", "getUnknown-7fucELk", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEnter-7fucELk  reason: not valid java name */
        public final int m4262getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* renamed from: getExit-7fucELk  reason: not valid java name */
        public final int m4263getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* renamed from: getMove-7fucELk  reason: not valid java name */
        public final int m4264getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* renamed from: getPress-7fucELk  reason: not valid java name */
        public final int m4265getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* renamed from: getRelease-7fucELk  reason: not valid java name */
        public final int m4266getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* renamed from: getScroll-7fucELk  reason: not valid java name */
        public final int m4267getScroll7fucELk() {
            return PointerEventType.Scroll;
        }

        /* renamed from: getUnknown-7fucELk  reason: not valid java name */
        public final int m4268getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }
    }

    private /* synthetic */ PointerEventType(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointerEventType m4255boximpl(int i11) {
        return new PointerEventType(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m4256constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4257equalsimpl(int i11, Object obj) {
        return (obj instanceof PointerEventType) && i11 == ((PointerEventType) obj).m4261unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4258equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4259hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4260toStringimpl(int i11) {
        if (m4258equalsimpl0(i11, Press)) {
            return "Press";
        }
        if (m4258equalsimpl0(i11, Release)) {
            return "Release";
        }
        if (m4258equalsimpl0(i11, Move)) {
            return "Move";
        }
        if (m4258equalsimpl0(i11, Enter)) {
            return "Enter";
        }
        if (m4258equalsimpl0(i11, Exit)) {
            return "Exit";
        }
        if (m4258equalsimpl0(i11, Scroll)) {
            return "Scroll";
        }
        return "Unknown";
    }

    public boolean equals(Object obj) {
        return m4257equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4259hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4260toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4261unboximpl() {
        return this.value;
    }
}
