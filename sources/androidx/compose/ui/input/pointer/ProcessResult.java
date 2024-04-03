package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/input/pointer/ProcessResult;", "", "value", "", "constructor-impl", "(I)I", "anyMovementConsumed", "", "getAnyMovementConsumed-impl", "(I)Z", "dispatchedToAPointerInputModifier", "getDispatchedToAPointerInputModifier-impl", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class ProcessResult {
    private final int value;

    private /* synthetic */ ProcessResult(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ProcessResult m4376boximpl(int i11) {
        return new ProcessResult(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4377constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4378equalsimpl(int i11, Object obj) {
        return (obj instanceof ProcessResult) && i11 == ((ProcessResult) obj).m4384unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4379equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: getAnyMovementConsumed-impl  reason: not valid java name */
    public static final boolean m4380getAnyMovementConsumedimpl(int i11) {
        return (i11 & 2) != 0;
    }

    /* renamed from: getDispatchedToAPointerInputModifier-impl  reason: not valid java name */
    public static final boolean m4381getDispatchedToAPointerInputModifierimpl(int i11) {
        return (i11 & 1) != 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4382hashCodeimpl(int i11) {
        return i11;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4383toStringimpl(int i11) {
        return "ProcessResult(value=" + i11 + ')';
    }

    public boolean equals(Object obj) {
        return m4378equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4382hashCodeimpl(this.value);
    }

    public String toString() {
        return m4383toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4384unboximpl() {
        return this.value;
    }
}
