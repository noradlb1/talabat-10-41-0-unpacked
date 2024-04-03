package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0005J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000bJ!\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000bJ!\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/DataIndex;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "compareTo", "other", "compareTo-ZjPyQlc", "(II)I", "dec", "dec-jQJCoq8", "equals", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "inc", "inc-jQJCoq8", "minus", "i", "minus-yUvdeeg", "minus-PBKCTt8", "plus", "plus-PBKCTt8", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class DataIndex {
    private final int value;

    private /* synthetic */ DataIndex(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DataIndex m610boximpl(int i11) {
        return new DataIndex(i11);
    }

    /* renamed from: compareTo-ZjPyQlc  reason: not valid java name */
    public static final int m611compareToZjPyQlc(int i11, int i12) {
        return i11 - i12;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m612constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: dec-jQJCoq8  reason: not valid java name */
    public static final int m613decjQJCoq8(int i11) {
        return m612constructorimpl(i11 - 1);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m614equalsimpl(int i11, Object obj) {
        return (obj instanceof DataIndex) && i11 == ((DataIndex) obj).m622unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m615equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m616hashCodeimpl(int i11) {
        return i11;
    }

    /* renamed from: inc-jQJCoq8  reason: not valid java name */
    public static final int m617incjQJCoq8(int i11) {
        return m612constructorimpl(i11 + 1);
    }

    /* renamed from: minus-PBKCTt8  reason: not valid java name */
    public static final int m618minusPBKCTt8(int i11, int i12) {
        return m612constructorimpl(i11 - i12);
    }

    /* renamed from: minus-yUvdeeg  reason: not valid java name */
    public static final int m619minusyUvdeeg(int i11, int i12) {
        return m612constructorimpl(i11 - i12);
    }

    /* renamed from: plus-PBKCTt8  reason: not valid java name */
    public static final int m620plusPBKCTt8(int i11, int i12) {
        return m612constructorimpl(i11 + i12);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m621toStringimpl(int i11) {
        return "DataIndex(value=" + i11 + ')';
    }

    public boolean equals(Object obj) {
        return m614equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m616hashCodeimpl(this.value);
    }

    public String toString() {
        return m621toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m622unboximpl() {
        return this.value;
    }
}
