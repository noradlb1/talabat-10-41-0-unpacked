package androidx.compose.ui.graphics;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.text.Regex;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@JvmInline
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b@\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0007B\u0012\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\nJ\u0016\u0010\u0015\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b.\u0010(J\u0016\u0010/\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\nJ\r\u00101\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\bL\u0010@J\u0016\u0010M\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\nJ\u001b\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0001\bø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Float16 implements Comparable<Float16> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final short Epsilon = m3014constructorimpl(5120);
    private static final int FP16_COMBINED = 32767;
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_MASK = 31;
    private static final int FP16_EXPONENT_MAX = 31744;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGNIFICAND_MASK = 1023;
    private static final int FP16_SIGN_MASK = 32768;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final float FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    private static final int FP32_DENORMAL_MAGIC = 1056964608;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_MASK = 255;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_QNAN_MASK = 4194304;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    /* access modifiers changed from: private */
    public static final short LowestValue = m3014constructorimpl(-1025);
    public static final int MaxExponent = 15;
    /* access modifiers changed from: private */
    public static final short MaxValue = m3014constructorimpl(31743);
    public static final int MinExponent = -14;
    /* access modifiers changed from: private */
    public static final short MinNormal = m3014constructorimpl((short) SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL);
    /* access modifiers changed from: private */
    public static final short MinValue = m3014constructorimpl(1);
    /* access modifiers changed from: private */
    public static final short NaN = m3014constructorimpl(32256);
    /* access modifiers changed from: private */
    public static final short NegativeInfinity = m3014constructorimpl(-1024);
    private static final short NegativeOne = m3013constructorimpl(-1.0f);
    /* access modifiers changed from: private */
    public static final short NegativeZero = m3014constructorimpl((short) ShortCompanionObject.MIN_VALUE);
    private static final short One = m3013constructorimpl(1.0f);
    /* access modifiers changed from: private */
    public static final short PositiveInfinity = m3014constructorimpl(31744);
    /* access modifiers changed from: private */
    public static final short PositiveZero = m3014constructorimpl(0);
    public static final int Size = 16;
    private final short halfValue;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\n\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020\t2\u0006\u00105\u001a\u000202H\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u000e\u0010\u001c\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001e\u0010\u0006R\u000e\u0010\u001f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010)\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b*\u0010\u0006R\u0019\u0010+\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u000e\u00100\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "FP16_COMBINED", "", "FP16_EXPONENT_BIAS", "FP16_EXPONENT_MASK", "FP16_EXPONENT_MAX", "FP16_EXPONENT_SHIFT", "FP16_SIGNIFICAND_MASK", "FP16_SIGN_MASK", "FP16_SIGN_SHIFT", "FP32_DENORMAL_FLOAT", "", "FP32_DENORMAL_MAGIC", "FP32_EXPONENT_BIAS", "FP32_EXPONENT_MASK", "FP32_EXPONENT_SHIFT", "FP32_QNAN_MASK", "FP32_SIGNIFICAND_MASK", "FP32_SIGN_SHIFT", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeOne", "NegativeZero", "getNegativeZero-slo4al4", "One", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "floatToHalf", "", "f", "toCompareValue", "value", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final short floatToHalf(float f11) {
            int i11;
            int i12;
            int floatToRawIntBits = Float.floatToRawIntBits(f11);
            int i13 = floatToRawIntBits >>> 31;
            int i14 = (floatToRawIntBits >>> 23) & 255;
            int i15 = floatToRawIntBits & Float16.FP32_SIGNIFICAND_MASK;
            int i16 = 31;
            int i17 = 0;
            if (i14 == 255) {
                if (i15 != 0) {
                    i12 = 512;
                }
                i11 = (i13 << 15) | (i16 << 10) | i17;
                return (short) i11;
            }
            int i18 = (i14 - 127) + 15;
            if (i18 >= 31) {
                i16 = 49;
            } else if (i18 > 0) {
                i17 = i15 >> 13;
                if ((i15 & 4096) != 0) {
                    i11 = (((i18 << 10) | i17) + 1) | (i13 << 15);
                    return (short) i11;
                }
                i16 = i18;
            } else if (i18 >= -10) {
                int i19 = (i15 | 8388608) >> (1 - i18);
                if ((i19 & 4096) != 0) {
                    i19 += 8192;
                }
                i12 = i19 >> 13;
                i16 = 0;
            } else {
                i16 = 0;
            }
            i11 = (i13 << 15) | (i16 << 10) | i17;
            return (short) i11;
            i17 = i12;
            i11 = (i13 << 15) | (i16 << 10) | i17;
            return (short) i11;
        }

        /* access modifiers changed from: private */
        public final int toCompareValue(short s11) {
            return (s11 & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s11 & UShort.MAX_VALUE) : s11 & UShort.MAX_VALUE;
        }

        /* renamed from: getEpsilon-slo4al4  reason: not valid java name */
        public final short m3041getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4  reason: not valid java name */
        public final short m3042getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4  reason: not valid java name */
        public final short m3043getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4  reason: not valid java name */
        public final short m3044getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4  reason: not valid java name */
        public final short m3045getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4  reason: not valid java name */
        public final short m3046getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4  reason: not valid java name */
        public final short m3047getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4  reason: not valid java name */
        public final short m3048getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4  reason: not valid java name */
        public final short m3049getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4  reason: not valid java name */
        public final short m3050getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }
    }

    static {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
    }

    private /* synthetic */ Float16(short s11) {
        this.halfValue = s11;
    }

    /* renamed from: absoluteValue-slo4al4  reason: not valid java name */
    public static final short m3008absoluteValueslo4al4(short s11) {
        return m3014constructorimpl((short) (s11 & ShortCompanionObject.MAX_VALUE));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Float16 m3009boximpl(short s11) {
        return new Float16(s11);
    }

    /* renamed from: ceil-slo4al4  reason: not valid java name */
    public static final short m3010ceilslo4al4(short s11) {
        short s12 = s11 & UShort.MAX_VALUE;
        short s13 = s12 & ShortCompanionObject.MAX_VALUE;
        int i11 = 1;
        if (s13 < 15360) {
            short s14 = 32768 & s12;
            int i12 = ~(s12 >> 15);
            if (s13 == 0) {
                i11 = 0;
            }
            s12 = ((-(i12 & i11)) & 15360) | s14;
        } else if (s13 < 25600) {
            int i13 = (1 << (25 - (s13 >> 10))) - 1;
            s12 = (s12 + (i13 & ((s12 >> 15) - 1))) & (~i13);
        }
        return m3014constructorimpl((short) s12);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3013constructorimpl(float f11) {
        return m3014constructorimpl(Companion.floatToHalf(f11));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3014constructorimpl(short s11) {
        return s11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3015equalsimpl(short s11, Object obj) {
        return (obj instanceof Float16) && s11 == ((Float16) obj).m3040unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3016equalsimpl0(short s11, short s12) {
        return s11 == s12;
    }

    /* renamed from: floor-slo4al4  reason: not valid java name */
    public static final short m3017floorslo4al4(short s11) {
        short s12 = UShort.MAX_VALUE;
        short s13 = s11 & UShort.MAX_VALUE;
        short s14 = s13 & ShortCompanionObject.MAX_VALUE;
        if (s14 < 15360) {
            short s15 = s13 & ShortCompanionObject.MIN_VALUE;
            if (s13 <= 32768) {
                s12 = 0;
            }
            s13 = (s12 & 15360) | s15;
        } else if (s14 < 25600) {
            int i11 = (1 << (25 - (s14 >> 10))) - 1;
            s13 = (s13 + ((-(s13 >> 15)) & i11)) & (~i11);
        }
        return m3014constructorimpl((short) s13);
    }

    /* renamed from: getExponent-impl  reason: not valid java name */
    public static final int m3018getExponentimpl(short s11) {
        return ((s11 >>> 10) & 31) - 15;
    }

    /* renamed from: getSign-slo4al4  reason: not valid java name */
    public static final short m3019getSignslo4al4(short s11) {
        if (m3024isNaNimpl(s11)) {
            return NaN;
        }
        if (m3011compareTo41bOqos(s11, NegativeZero) < 0) {
            return NegativeOne;
        }
        if (m3011compareTo41bOqos(s11, PositiveZero) > 0) {
            return One;
        }
        return s11;
    }

    /* renamed from: getSignificand-impl  reason: not valid java name */
    public static final int m3020getSignificandimpl(short s11) {
        return s11 & 1023;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3021hashCodeimpl(short s11) {
        return s11;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m3022isFiniteimpl(short s11) {
        return (s11 & ShortCompanionObject.MAX_VALUE) != FP16_EXPONENT_MAX;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m3023isInfiniteimpl(short s11) {
        return (s11 & ShortCompanionObject.MAX_VALUE) == FP16_EXPONENT_MAX;
    }

    /* renamed from: isNaN-impl  reason: not valid java name */
    public static final boolean m3024isNaNimpl(short s11) {
        return (s11 & ShortCompanionObject.MAX_VALUE) > FP16_EXPONENT_MAX;
    }

    /* renamed from: isNormalized-impl  reason: not valid java name */
    public static final boolean m3025isNormalizedimpl(short s11) {
        short s12 = s11 & FP16_EXPONENT_MAX;
        return (s12 == 0 || s12 == FP16_EXPONENT_MAX) ? false : true;
    }

    /* renamed from: round-slo4al4  reason: not valid java name */
    public static final short m3026roundslo4al4(short s11) {
        short s12 = UShort.MAX_VALUE;
        short s13 = s11 & UShort.MAX_VALUE;
        short s14 = s13 & ShortCompanionObject.MAX_VALUE;
        if (s14 < 15360) {
            short s15 = s13 & ShortCompanionObject.MIN_VALUE;
            if (s14 < 14336) {
                s12 = 0;
            }
            s13 = s15 | (s12 & 15360);
        } else if (s14 < 25600) {
            int i11 = 25 - (s14 >> 10);
            s13 = (s13 + (1 << (i11 - 1))) & (~((1 << i11) - 1));
        }
        return m3014constructorimpl((short) s13);
    }

    /* renamed from: toBits-impl  reason: not valid java name */
    public static final int m3027toBitsimpl(short s11) {
        if (m3024isNaNimpl(s11)) {
            return NaN;
        }
        return s11 & UShort.MAX_VALUE;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m3028toByteimpl(short s11) {
        return (byte) ((int) m3030toFloatimpl(s11));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m3029toDoubleimpl(short s11) {
        return (double) m3030toFloatimpl(s11);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m3030toFloatimpl(short s11) {
        int i11;
        int i12;
        int i13;
        short s12 = s11 & UShort.MAX_VALUE;
        short s13 = 32768 & s12;
        int i14 = (s12 >>> 10) & 31;
        short s14 = s12 & 1023;
        if (i14 != 0) {
            int i15 = s14 << 13;
            if (i14 == 31) {
                i13 = 255;
                if (i15 != 0) {
                    i15 |= 4194304;
                }
            } else {
                i13 = (i14 - 15) + 127;
            }
            int i16 = i13;
            i12 = i15;
            i11 = i16;
        } else if (s14 != 0) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            float intBitsToFloat = Float.intBitsToFloat(s14 + FP32_DENORMAL_MAGIC) - FP32_DENORMAL_FLOAT;
            if (s13 == 0) {
                return intBitsToFloat;
            }
            return -intBitsToFloat;
        } else {
            i11 = 0;
            i12 = 0;
        }
        int i17 = i11 << 23;
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(i17 | (s13 << 16) | i12);
    }

    @NotNull
    /* renamed from: toHexString-impl  reason: not valid java name */
    public static final String m3031toHexStringimpl(short s11) {
        StringBuilder sb2 = new StringBuilder();
        short s12 = s11 & UShort.MAX_VALUE;
        int i11 = s12 >>> 15;
        int i12 = (s12 >>> 10) & 31;
        short s13 = s12 & 1023;
        if (i12 != 31) {
            if (i11 == 1) {
                sb2.append(SignatureVisitor.SUPER);
            }
            if (i12 != 0) {
                sb2.append("0x1.");
                String num = Integer.toString(s13, CharsKt__CharJVMKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                sb2.append(new Regex("0{2,}$").replaceFirst(num, ""));
                sb2.append(Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL);
                sb2.append(String.valueOf(i12 - 15));
            } else if (s13 == 0) {
                sb2.append("0x0.0p0");
            } else {
                sb2.append("0x0.");
                String num2 = Integer.toString(s13, CharsKt__CharJVMKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
                sb2.append(new Regex("0{2,}$").replaceFirst(num2, ""));
                sb2.append("p-14");
            }
        } else if (s13 == 0) {
            if (i11 != 0) {
                sb2.append(SignatureVisitor.SUPER);
            }
            sb2.append("Infinity");
        } else {
            sb2.append("NaN");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "o.toString()");
        return sb3;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m3032toIntimpl(short s11) {
        return (int) m3030toFloatimpl(s11);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m3033toLongimpl(short s11) {
        return (long) m3030toFloatimpl(s11);
    }

    /* renamed from: toRawBits-impl  reason: not valid java name */
    public static final int m3034toRawBitsimpl(short s11) {
        return s11 & UShort.MAX_VALUE;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m3035toShortimpl(short s11) {
        return (short) ((int) m3030toFloatimpl(s11));
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3036toStringimpl(short s11) {
        return String.valueOf(m3030toFloatimpl(s11));
    }

    /* renamed from: trunc-slo4al4  reason: not valid java name */
    public static final short m3037truncslo4al4(short s11) {
        int i11;
        short s12 = s11 & UShort.MAX_VALUE;
        short s13 = s12 & ShortCompanionObject.MAX_VALUE;
        if (s13 < 15360) {
            i11 = 32768;
        } else {
            if (s13 < 25600) {
                i11 = ~((1 << (25 - (s13 >> 10))) - 1);
            }
            return m3014constructorimpl((short) s12);
        }
        s12 &= i11;
        return m3014constructorimpl((short) s12);
    }

    /* renamed from: withSign-qCeQghg  reason: not valid java name */
    public static final short m3038withSignqCeQghg(short s11, short s12) {
        return m3014constructorimpl((short) ((s11 & ShortCompanionObject.MAX_VALUE) | (s12 & ShortCompanionObject.MIN_VALUE)));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m3039compareTo41bOqos(((Float16) obj).m3040unboximpl());
    }

    /* renamed from: compareTo-41bOqos  reason: not valid java name */
    public int m3039compareTo41bOqos(short s11) {
        return m3011compareTo41bOqos(this.halfValue, s11);
    }

    public boolean equals(Object obj) {
        return m3015equalsimpl(this.halfValue, obj);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m3021hashCodeimpl(this.halfValue);
    }

    @NotNull
    public String toString() {
        return m3036toStringimpl(this.halfValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m3040unboximpl() {
        return this.halfValue;
    }

    /* renamed from: compareTo-41bOqos  reason: not valid java name */
    public static int m3011compareTo41bOqos(short s11, short s12) {
        if (m3024isNaNimpl(s11)) {
            return m3024isNaNimpl(s12) ^ true ? 1 : 0;
        }
        if (m3024isNaNimpl(s12)) {
            return -1;
        }
        Companion companion = Companion;
        return Intrinsics.compare(companion.toCompareValue(s11), companion.toCompareValue(s12));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3012constructorimpl(double d11) {
        return m3013constructorimpl((float) d11);
    }
}
