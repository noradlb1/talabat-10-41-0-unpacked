package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u001a%\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0015\u001a%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a-\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a-\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a \u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001a+\u00108\u001a\u00020\u0006*\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:H\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\"\u0010=\u001a\u00020\u0006*\u00020\u00072\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\"\u0010=\u001a\u00020\u0006*\u00020\f2\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010#\u001a\"\u0010=\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"!\u0010\u0005\u001a\u00020\u0006*\u00020\u00078FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"!\u0010\u0005\u001a\u00020\u0006*\u00020\f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\r\u001a\u0004\b\n\u0010\u000e\"!\u0010\u0005\u001a\u00020\u0006*\u00020\u000f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\"\u0010\u0012\u001a\u00020\u0013*\u00020\u00068Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"!\u0010\u0018\u001a\u00020\u0013*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"!\u0010\u001b\u001a\u00020\u0006*\u00020\u00078FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b\"!\u0010\u001b\u001a\u00020\u0006*\u00020\f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000e\"!\u0010\u001b\u001a\u00020\u0006*\u00020\u000f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0011\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "em", "Landroidx/compose/ui/unit/TextUnit;", "", "getEm$annotations", "(D)V", "getEm", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "sp", "getSp$annotations", "getSp", "TextUnit", "value", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "pack", "unitType", "v", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    @ExperimentalUnitApi
    /* renamed from: TextUnit-anM5pPY  reason: not valid java name */
    public static final long m5671TextUnitanM5pPY(float f11, long j11) {
        return pack(j11, f11);
    }

    @PublishedApi
    /* renamed from: checkArithmetic--R2X_6o  reason: not valid java name */
    public static final void m5672checkArithmeticR2X_6o(long j11) {
        if (!(!m5677isUnspecifiedR2X_6o(j11))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    @PublishedApi
    /* renamed from: checkArithmetic-NB67dxo  reason: not valid java name */
    public static final void m5673checkArithmeticNB67dxo(long j11, long j12) {
        boolean z11;
        if (m5677isUnspecifiedR2X_6o(j11) || m5677isUnspecifiedR2X_6o(j12)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        } else if (!TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j11), TextUnit.m5658getTypeUIouoOA(j12))) {
            throw new IllegalArgumentException(("Cannot perform operation for " + TextUnitType.m5689toStringimpl(TextUnit.m5658getTypeUIouoOA(j11)) + " and " + TextUnitType.m5689toStringimpl(TextUnit.m5658getTypeUIouoOA(j12))).toString());
        }
    }

    @PublishedApi
    /* renamed from: checkArithmetic-vU-0ePk  reason: not valid java name */
    public static final void m5674checkArithmeticvU0ePk(long j11, long j12, long j13) {
        boolean z11;
        boolean z12 = true;
        if (m5677isUnspecifiedR2X_6o(j11) || m5677isUnspecifiedR2X_6o(j12) || m5677isUnspecifiedR2X_6o(j13)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if (!TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j11), TextUnit.m5658getTypeUIouoOA(j12)) || !TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j12), TextUnit.m5658getTypeUIouoOA(j13))) {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalArgumentException(("Cannot perform operation for " + TextUnitType.m5689toStringimpl(TextUnit.m5658getTypeUIouoOA(j11)) + " and " + TextUnitType.m5689toStringimpl(TextUnit.m5658getTypeUIouoOA(j12))).toString());
            }
            return;
        }
        throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
    }

    public static final long getEm(float f11) {
        return pack(UNIT_TYPE_EM, f11);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(double d11) {
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(float f11) {
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(int i11) {
    }

    public static final long getSp(float f11) {
        return pack(UNIT_TYPE_SP, f11);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(double d11) {
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(float f11) {
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(int i11) {
    }

    /* renamed from: isSpecified--R2X_6o  reason: not valid java name */
    public static final boolean m5675isSpecifiedR2X_6o(long j11) {
        return !m5677isUnspecifiedR2X_6o(j11);
    }

    @Stable
    /* renamed from: isSpecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m5676isSpecifiedR2X_6o$annotations(long j11) {
    }

    /* renamed from: isUnspecified--R2X_6o  reason: not valid java name */
    public static final boolean m5677isUnspecifiedR2X_6o(long j11) {
        return TextUnit.m5657getRawTypeimpl(j11) == 0;
    }

    @Stable
    /* renamed from: isUnspecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m5678isUnspecifiedR2X_6o$annotations(long j11) {
    }

    @Stable
    /* renamed from: lerp-C3pnCVY  reason: not valid java name */
    public static final long m5679lerpC3pnCVY(long j11, long j12, float f11) {
        m5673checkArithmeticNB67dxo(j11, j12);
        return pack(TextUnit.m5657getRawTypeimpl(j11), MathHelpersKt.lerp(TextUnit.m5659getValueimpl(j11), TextUnit.m5659getValueimpl(j12), f11));
    }

    @PublishedApi
    public static final long pack(long j11, float f11) {
        return TextUnit.m5651constructorimpl(j11 | (((long) Float.floatToIntBits(f11)) & 4294967295L));
    }

    /* renamed from: takeOrElse-eAf_CNQ  reason: not valid java name */
    public static final long m5680takeOrElseeAf_CNQ(long j11, @NotNull Function0<TextUnit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!m5677isUnspecifiedR2X_6o(j11)) {
            return j11;
        }
        return function0.invoke().m5668unboximpl();
    }

    @Stable
    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m5682timesmpE4wyQ(float f11, long j11) {
        m5672checkArithmeticR2X_6o(j11);
        return pack(TextUnit.m5657getRawTypeimpl(j11), f11 * TextUnit.m5659getValueimpl(j11));
    }

    public static final long getEm(double d11) {
        return pack(UNIT_TYPE_EM, (float) d11);
    }

    public static final long getSp(double d11) {
        return pack(UNIT_TYPE_SP, (float) d11);
    }

    public static final long getEm(int i11) {
        return pack(UNIT_TYPE_EM, (float) i11);
    }

    public static final long getSp(int i11) {
        return pack(UNIT_TYPE_SP, (float) i11);
    }

    @Stable
    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m5681timesmpE4wyQ(double d11, long j11) {
        m5672checkArithmeticR2X_6o(j11);
        return pack(TextUnit.m5657getRawTypeimpl(j11), ((float) d11) * TextUnit.m5659getValueimpl(j11));
    }

    @Stable
    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m5683timesmpE4wyQ(int i11, long j11) {
        m5672checkArithmeticR2X_6o(j11);
        return pack(TextUnit.m5657getRawTypeimpl(j11), ((float) i11) * TextUnit.m5659getValueimpl(j11));
    }
}
