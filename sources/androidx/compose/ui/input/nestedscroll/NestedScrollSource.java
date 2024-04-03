package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class NestedScrollSource {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Drag = m4211constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Fling = m4211constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Relocate = m4211constructorimpl(3);
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R'\u0010\n\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", "", "()V", "Drag", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "getDrag-WNlRxjI", "()I", "I", "Fling", "getFling-WNlRxjI", "Relocate", "getRelocate-WNlRxjI$annotations", "getRelocate-WNlRxjI", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalComposeUiApi
        @Deprecated(message = "Do not use. Will be removed in the future.")
        /* renamed from: getRelocate-WNlRxjI$annotations  reason: not valid java name */
        public static /* synthetic */ void m4217getRelocateWNlRxjI$annotations() {
        }

        /* renamed from: getDrag-WNlRxjI  reason: not valid java name */
        public final int m4218getDragWNlRxjI() {
            return NestedScrollSource.Drag;
        }

        /* renamed from: getFling-WNlRxjI  reason: not valid java name */
        public final int m4219getFlingWNlRxjI() {
            return NestedScrollSource.Fling;
        }

        /* renamed from: getRelocate-WNlRxjI  reason: not valid java name */
        public final int m4220getRelocateWNlRxjI() {
            return NestedScrollSource.Relocate;
        }
    }

    private /* synthetic */ NestedScrollSource(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NestedScrollSource m4210boximpl(int i11) {
        return new NestedScrollSource(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4211constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4212equalsimpl(int i11, Object obj) {
        return (obj instanceof NestedScrollSource) && i11 == ((NestedScrollSource) obj).m4216unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4213equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4214hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4215toStringimpl(int i11) {
        if (m4213equalsimpl0(i11, Drag)) {
            return "Drag";
        }
        if (m4213equalsimpl0(i11, Fling)) {
            return "Fling";
        }
        if (m4213equalsimpl0(i11, Relocate)) {
            return "Relocate";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m4212equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4214hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4215toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4216unboximpl() {
        return this.value;
    }
}
