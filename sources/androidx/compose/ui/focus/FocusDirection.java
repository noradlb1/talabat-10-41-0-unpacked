package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class FocusDirection {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Down = m2598constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int Enter;
    /* access modifiers changed from: private */
    public static final int Exit;
    /* access modifiers changed from: private */
    public static final int In;
    /* access modifiers changed from: private */
    public static final int Left = m2598constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Next = m2598constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Out;
    /* access modifiers changed from: private */
    public static final int Previous = m2598constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Right = m2598constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Up = m2598constructorimpl(5);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R'\u0010\b\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0006R'\u0010\u000b\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0006R'\u0010\u000e\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0014\u0010\u0006R'\u0010\u0015\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "()V", "Down", "Landroidx/compose/ui/focus/FocusDirection;", "getDown-dhqQ-8s", "()I", "I", "Enter", "getEnter-dhqQ-8s$annotations", "getEnter-dhqQ-8s", "Exit", "getExit-dhqQ-8s$annotations", "getExit-dhqQ-8s", "In", "getIn-dhqQ-8s$annotations", "getIn-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Next", "getNext-dhqQ-8s", "Out", "getOut-dhqQ-8s$annotations", "getOut-dhqQ-8s", "Previous", "getPrevious-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2604getEnterdhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getExit-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2605getExitdhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Enter instead.", replaceWith = @ReplaceWith(expression = "Enter", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Enter"}))
        /* renamed from: getIn-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2606getIndhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Exit instead.", replaceWith = @ReplaceWith(expression = "Exit", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Exit"}))
        /* renamed from: getOut-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2607getOutdhqQ8s$annotations() {
        }

        /* renamed from: getDown-dhqQ-8s  reason: not valid java name */
        public final int m2608getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-dhqQ-8s  reason: not valid java name */
        public final int m2609getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getExit-dhqQ-8s  reason: not valid java name */
        public final int m2610getExitdhqQ8s() {
            return FocusDirection.Exit;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getIn-dhqQ-8s  reason: not valid java name */
        public final int m2611getIndhqQ8s() {
            return FocusDirection.In;
        }

        /* renamed from: getLeft-dhqQ-8s  reason: not valid java name */
        public final int m2612getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* renamed from: getNext-dhqQ-8s  reason: not valid java name */
        public final int m2613getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getOut-dhqQ-8s  reason: not valid java name */
        public final int m2614getOutdhqQ8s() {
            return FocusDirection.Out;
        }

        /* renamed from: getPrevious-dhqQ-8s  reason: not valid java name */
        public final int m2615getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* renamed from: getRight-dhqQ-8s  reason: not valid java name */
        public final int m2616getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* renamed from: getUp-dhqQ-8s  reason: not valid java name */
        public final int m2617getUpdhqQ8s() {
            return FocusDirection.Up;
        }
    }

    static {
        int r02 = m2598constructorimpl(7);
        Enter = r02;
        int r12 = m2598constructorimpl(8);
        Exit = r12;
        In = r02;
        Out = r12;
    }

    private /* synthetic */ FocusDirection(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FocusDirection m2597boximpl(int i11) {
        return new FocusDirection(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2598constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2599equalsimpl(int i11, Object obj) {
        return (obj instanceof FocusDirection) && i11 == ((FocusDirection) obj).m2603unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2600equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2601hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2602toStringimpl(int i11) {
        if (m2600equalsimpl0(i11, Next)) {
            return "Next";
        }
        if (m2600equalsimpl0(i11, Previous)) {
            return "Previous";
        }
        if (m2600equalsimpl0(i11, Left)) {
            return "Left";
        }
        if (m2600equalsimpl0(i11, Right)) {
            return "Right";
        }
        if (m2600equalsimpl0(i11, Up)) {
            return "Up";
        }
        if (m2600equalsimpl0(i11, Down)) {
            return "Down";
        }
        if (m2600equalsimpl0(i11, Enter)) {
            return "Enter";
        }
        if (m2600equalsimpl0(i11, Exit)) {
            return "Exit";
        }
        return "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return m2599equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2601hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2602toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2603unboximpl() {
        return this.value;
    }
}
