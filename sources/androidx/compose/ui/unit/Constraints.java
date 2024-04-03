package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;

@Immutable
@JvmInline
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 02\u00020\u0001:\u00010B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J>\u0010#\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0012\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Constraints {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FocusMask = 3;
    @NotNull
    private static final int[] HeightMask = {32767, MaxNonFocusMask, 65535, MaxFocusMask};
    public static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxFocusBits = 18;
    private static final long MaxFocusHeight = 3;
    private static final int MaxFocusMask = 262143;
    private static final long MaxFocusWidth = 1;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final long MinFocusHeight = 2;
    private static final int MinFocusMask = 65535;
    private static final long MinFocusWidth = 0;
    /* access modifiers changed from: private */
    @NotNull
    public static final int[] MinHeightOffsets = {18, 20, 17, 15};
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;
    @NotNull
    private static final int[] WidthMask = {65535, MaxFocusMask, 32767, MaxNonFocusMask};
    private final long value;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J8\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 J(\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b$\u0010%J \u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b'\u0010(J \u0010)\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b*\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "FocusMask", "", "HeightMask", "", "Infinity", "", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinHeightOffsets", "MinNonFocusBits", "MinNonFocusMask", "WidthMask", "bitsNeedForSize", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "createConstraints-Zbe2FdA$ui_unit_release", "(IIII)J", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int bitsNeedForSize(int i11) {
            if (i11 < Constraints.MaxNonFocusMask) {
                return 13;
            }
            if (i11 < 32767) {
                return 15;
            }
            if (i11 < 65535) {
                return 16;
            }
            if (i11 < Constraints.MaxFocusMask) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + i11 + " in Constraints");
        }

        /* renamed from: createConstraints-Zbe2FdA$ui_unit_release  reason: not valid java name */
        public final long m5429createConstraintsZbe2FdA$ui_unit_release(int i11, int i12, int i13, int i14) {
            int i15;
            int i16;
            long j11;
            int i17;
            if (i14 == Integer.MAX_VALUE) {
                i15 = i13;
            } else {
                i15 = i14;
            }
            int bitsNeedForSize = bitsNeedForSize(i15);
            if (i12 == Integer.MAX_VALUE) {
                i16 = i11;
            } else {
                i16 = i12;
            }
            int bitsNeedForSize2 = bitsNeedForSize(i16);
            if (bitsNeedForSize + bitsNeedForSize2 <= 31) {
                if (bitsNeedForSize2 == 13) {
                    j11 = 3;
                } else if (bitsNeedForSize2 == 18) {
                    j11 = 1;
                } else if (bitsNeedForSize2 == 15) {
                    j11 = 2;
                } else if (bitsNeedForSize2 == 16) {
                    j11 = 0;
                } else {
                    throw new IllegalStateException("Should only have the provided constants.");
                }
                int i18 = 0;
                if (i12 == Integer.MAX_VALUE) {
                    i17 = 0;
                } else {
                    i17 = i12 + 1;
                }
                if (i14 != Integer.MAX_VALUE) {
                    i18 = i14 + 1;
                }
                int i19 = Constraints.MinHeightOffsets[(int) j11];
                return Constraints.m5411constructorimpl((((long) i17) << 33) | j11 | (((long) i11) << 2) | (((long) i13) << i19) | (((long) i18) << (i19 + 31)));
            }
            throw new IllegalArgumentException("Can't represent a width of " + i16 + " and height of " + i15 + " in Constraints");
        }

        @Stable
        /* renamed from: fixed-JhjzzOo  reason: not valid java name */
        public final long m5430fixedJhjzzOo(int i11, int i12) {
            boolean z11;
            if (i11 < 0 || i12 < 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return m5429createConstraintsZbe2FdA$ui_unit_release(i11, i11, i12, i12);
            }
            throw new IllegalArgumentException(("width(" + i11 + ") and height(" + i12 + ") must be >= 0").toString());
        }

        @Stable
        /* renamed from: fixedHeight-OenEA2s  reason: not valid java name */
        public final long m5431fixedHeightOenEA2s(int i11) {
            boolean z11;
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return m5429createConstraintsZbe2FdA$ui_unit_release(0, Integer.MAX_VALUE, i11, i11);
            }
            throw new IllegalArgumentException(("height(" + i11 + ") must be >= 0").toString());
        }

        @Stable
        /* renamed from: fixedWidth-OenEA2s  reason: not valid java name */
        public final long m5432fixedWidthOenEA2s(int i11) {
            boolean z11;
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return m5429createConstraintsZbe2FdA$ui_unit_release(i11, i11, 0, Integer.MAX_VALUE);
            }
            throw new IllegalArgumentException(("width(" + i11 + ") must be >= 0").toString());
        }
    }

    private /* synthetic */ Constraints(long j11) {
        this.value = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Constraints m5410boximpl(long j11) {
        return new Constraints(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5411constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: copy-Zbe2FdA  reason: not valid java name */
    public static final long m5412copyZbe2FdA(long j11, int i11, int i12, int i13, int i14) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (i13 < 0 || i11 < 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if (i12 >= i11 || i12 == Integer.MAX_VALUE) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i14 < i13 && i14 != Integer.MAX_VALUE) {
                    z13 = false;
                }
                if (z13) {
                    return Companion.m5429createConstraintsZbe2FdA$ui_unit_release(i11, i12, i13, i14);
                }
                throw new IllegalArgumentException(("maxHeight(" + i14 + ") must be >= minHeight(" + i13 + ')').toString());
            }
            throw new IllegalArgumentException(("maxWidth(" + i12 + ") must be >= minWidth(" + i11 + ')').toString());
        }
        throw new IllegalArgumentException(("minHeight(" + i13 + ") and minWidth(" + i11 + ") must be >= 0").toString());
    }

    /* renamed from: copy-Zbe2FdA$default  reason: not valid java name */
    public static /* synthetic */ long m5413copyZbe2FdA$default(long j11, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = m5424getMinWidthimpl(j11);
        }
        int i16 = i11;
        if ((i15 & 2) != 0) {
            i12 = m5422getMaxWidthimpl(j11);
        }
        int i17 = i12;
        if ((i15 & 4) != 0) {
            i13 = m5423getMinHeightimpl(j11);
        }
        int i18 = i13;
        if ((i15 & 8) != 0) {
            i14 = m5421getMaxHeightimpl(j11);
        }
        return m5412copyZbe2FdA(j11, i16, i17, i18, i14);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5414equalsimpl(long j11, Object obj) {
        return (obj instanceof Constraints) && j11 == ((Constraints) obj).m5428unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5415equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: getFocusIndex-impl  reason: not valid java name */
    private static final int m5416getFocusIndeximpl(long j11) {
        return (int) (j11 & 3);
    }

    /* renamed from: getHasBoundedHeight-impl  reason: not valid java name */
    public static final boolean m5417getHasBoundedHeightimpl(long j11) {
        int r02 = m5416getFocusIndeximpl(j11);
        if ((((int) (j11 >> (MinHeightOffsets[r02] + 31))) & HeightMask[r02]) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: getHasBoundedWidth-impl  reason: not valid java name */
    public static final boolean m5418getHasBoundedWidthimpl(long j11) {
        return (((int) (j11 >> 33)) & WidthMask[m5416getFocusIndeximpl(j11)]) != 0;
    }

    @Stable
    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    /* renamed from: getHasFixedHeight-impl  reason: not valid java name */
    public static final boolean m5419getHasFixedHeightimpl(long j11) {
        return m5421getMaxHeightimpl(j11) == m5423getMinHeightimpl(j11);
    }

    @Stable
    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    /* renamed from: getHasFixedWidth-impl  reason: not valid java name */
    public static final boolean m5420getHasFixedWidthimpl(long j11) {
        return m5422getMaxWidthimpl(j11) == m5424getMinWidthimpl(j11);
    }

    /* renamed from: getMaxHeight-impl  reason: not valid java name */
    public static final int m5421getMaxHeightimpl(long j11) {
        int r02 = m5416getFocusIndeximpl(j11);
        int i11 = ((int) (j11 >> (MinHeightOffsets[r02] + 31))) & HeightMask[r02];
        if (i11 == 0) {
            return Integer.MAX_VALUE;
        }
        return i11 - 1;
    }

    /* renamed from: getMaxWidth-impl  reason: not valid java name */
    public static final int m5422getMaxWidthimpl(long j11) {
        int i11 = ((int) (j11 >> 33)) & WidthMask[m5416getFocusIndeximpl(j11)];
        if (i11 == 0) {
            return Integer.MAX_VALUE;
        }
        return i11 - 1;
    }

    /* renamed from: getMinHeight-impl  reason: not valid java name */
    public static final int m5423getMinHeightimpl(long j11) {
        int r02 = m5416getFocusIndeximpl(j11);
        return ((int) (j11 >> MinHeightOffsets[r02])) & HeightMask[r02];
    }

    /* renamed from: getMinWidth-impl  reason: not valid java name */
    public static final int m5424getMinWidthimpl(long j11) {
        return ((int) (j11 >> 2)) & WidthMask[m5416getFocusIndeximpl(j11)];
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5425hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @Stable
    public static /* synthetic */ void isZero$annotations() {
    }

    /* renamed from: isZero-impl  reason: not valid java name */
    public static final boolean m5426isZeroimpl(long j11) {
        return m5422getMaxWidthimpl(j11) == 0 || m5421getMaxHeightimpl(j11) == 0;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5427toStringimpl(long j11) {
        String str;
        int r02 = m5422getMaxWidthimpl(j11);
        String str2 = "Infinity";
        if (r02 == Integer.MAX_VALUE) {
            str = str2;
        } else {
            str = String.valueOf(r02);
        }
        int r32 = m5421getMaxHeightimpl(j11);
        if (r32 != Integer.MAX_VALUE) {
            str2 = String.valueOf(r32);
        }
        return "Constraints(minWidth = " + m5424getMinWidthimpl(j11) + ", maxWidth = " + str + ", minHeight = " + m5423getMinHeightimpl(j11) + ", maxHeight = " + str2 + ')';
    }

    public boolean equals(Object obj) {
        return m5414equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5425hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5427toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5428unboximpl() {
        return this.value;
    }
}
