package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0000H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hasAny", "sides", "hasAny-bkgdKaI$foundation_layout_release", "(II)Z", "hashCode", "hashCode-impl", "plus", "plus-gK_yJZ4", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class WindowInsetsSides {
    /* access modifiers changed from: private */
    public static final int AllowLeftInLtr;
    /* access modifiers changed from: private */
    public static final int AllowLeftInRtl;
    /* access modifiers changed from: private */
    public static final int AllowRightInLtr;
    /* access modifiers changed from: private */
    public static final int AllowRightInRtl;
    /* access modifiers changed from: private */
    public static final int Bottom;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int End;
    /* access modifiers changed from: private */
    public static final int Horizontal;
    /* access modifiers changed from: private */
    public static final int Left;
    /* access modifiers changed from: private */
    public static final int Right;
    /* access modifiers changed from: private */
    public static final int Start;
    /* access modifiers changed from: private */
    public static final int Top;
    /* access modifiers changed from: private */
    public static final int Vertical;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001f\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001f\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout_release", "()I", "I", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout_release", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout_release", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout_release", "Bottom", "getBottom-JoeWqyM", "End", "getEnd-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Start", "getStart-JoeWqyM", "Top", "getTop-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m597getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m598getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m599getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m600getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* renamed from: getBottom-JoeWqyM  reason: not valid java name */
        public final int m601getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* renamed from: getEnd-JoeWqyM  reason: not valid java name */
        public final int m602getEndJoeWqyM() {
            return WindowInsetsSides.End;
        }

        /* renamed from: getHorizontal-JoeWqyM  reason: not valid java name */
        public final int m603getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* renamed from: getLeft-JoeWqyM  reason: not valid java name */
        public final int m604getLeftJoeWqyM() {
            return WindowInsetsSides.Left;
        }

        /* renamed from: getRight-JoeWqyM  reason: not valid java name */
        public final int m605getRightJoeWqyM() {
            return WindowInsetsSides.Right;
        }

        /* renamed from: getStart-JoeWqyM  reason: not valid java name */
        public final int m606getStartJoeWqyM() {
            return WindowInsetsSides.Start;
        }

        /* renamed from: getTop-JoeWqyM  reason: not valid java name */
        public final int m607getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* renamed from: getVertical-JoeWqyM  reason: not valid java name */
        public final int m608getVerticalJoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }

    static {
        int r02 = m587constructorimpl(8);
        AllowLeftInLtr = r02;
        int r12 = m587constructorimpl(4);
        AllowRightInLtr = r12;
        int r22 = m587constructorimpl(2);
        AllowLeftInRtl = r22;
        int r32 = m587constructorimpl(1);
        AllowRightInRtl = r32;
        Start = m592plusgK_yJZ4(r02, r32);
        End = m592plusgK_yJZ4(r12, r22);
        int r42 = m587constructorimpl(16);
        Top = r42;
        int r52 = m587constructorimpl(32);
        Bottom = r52;
        int r03 = m592plusgK_yJZ4(r02, r22);
        Left = r03;
        int r13 = m592plusgK_yJZ4(r12, r32);
        Right = r13;
        Horizontal = m592plusgK_yJZ4(r03, r13);
        Vertical = m592plusgK_yJZ4(r42, r52);
    }

    private /* synthetic */ WindowInsetsSides(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m586boximpl(int i11) {
        return new WindowInsetsSides(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m587constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m588equalsimpl(int i11, Object obj) {
        return (obj instanceof WindowInsetsSides) && i11 == ((WindowInsetsSides) obj).m596unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m589equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hasAny-bkgdKaI$foundation_layout_release  reason: not valid java name */
    public static final boolean m590hasAnybkgdKaI$foundation_layout_release(int i11, int i12) {
        return (i11 & i12) != 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m591hashCodeimpl(int i11) {
        return i11;
    }

    /* renamed from: plus-gK_yJZ4  reason: not valid java name */
    public static final int m592plusgK_yJZ4(int i11, int i12) {
        return m587constructorimpl(i11 | i12);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m593toStringimpl(int i11) {
        return "WindowInsetsSides(" + m594valueToStringimpl(i11) + ')';
    }

    /* renamed from: valueToString-impl  reason: not valid java name */
    private static final String m594valueToStringimpl(int i11) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = Start;
        if ((i11 & i12) == i12) {
            m595valueToString_impl$lambda0$appendPlus(sb2, "Start");
        }
        int i13 = Left;
        if ((i11 & i13) == i13) {
            m595valueToString_impl$lambda0$appendPlus(sb2, "Left");
        }
        int i14 = Top;
        if ((i11 & i14) == i14) {
            m595valueToString_impl$lambda0$appendPlus(sb2, "Top");
        }
        int i15 = End;
        if ((i11 & i15) == i15) {
            m595valueToString_impl$lambda0$appendPlus(sb2, "End");
        }
        int i16 = Right;
        if ((i11 & i16) == i16) {
            m595valueToString_impl$lambda0$appendPlus(sb2, "Right");
        }
        int i17 = Bottom;
        if ((i11 & i17) == i17) {
            m595valueToString_impl$lambda0$appendPlus(sb2, "Bottom");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    /* renamed from: valueToString_impl$lambda-0$appendPlus  reason: not valid java name */
    private static final void m595valueToString_impl$lambda0$appendPlus(StringBuilder sb2, String str) {
        boolean z11;
        if (sb2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            sb2.append(SignatureVisitor.EXTENDS);
        }
        sb2.append(str);
    }

    public boolean equals(Object obj) {
        return m588equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m591hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m593toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m596unboximpl() {
        return this.value;
    }
}
