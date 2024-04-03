package kotlin.math;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b8\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\b\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\b\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\b\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\b\u001a\u0019\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\b\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\b\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\b\u001a\u0019\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\b\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\b\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\b\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\b\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\f\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006D"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "cbrt", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/math/MathKt")
class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double IEEErem(double d11, double d12) {
        return Math.IEEEremainder(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double abs(double d11) {
        return Math.abs(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double acos(double d11) {
        return Math.acos(d11);
    }

    @SinceKotlin(version = "1.2")
    public static final double acosh(double d11) {
        if (d11 < 1.0d) {
            return Double.NaN;
        }
        if (d11 > Constants.upper_taylor_2_bound) {
            return Math.log(d11) + Constants.LN2;
        }
        double d12 = (double) 1;
        double d13 = d11 - d12;
        if (d13 >= Constants.taylor_n_bound) {
            return Math.log(d11 + Math.sqrt((d11 * d11) - d12));
        }
        double sqrt = Math.sqrt(d13);
        if (sqrt >= Constants.taylor_2_bound) {
            sqrt -= ((sqrt * sqrt) * sqrt) / ((double) 12);
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double asin(double d11) {
        return Math.asin(d11);
    }

    @SinceKotlin(version = "1.2")
    public static final double asinh(double d11) {
        double d12 = Constants.taylor_n_bound;
        if (d11 >= d12) {
            if (d11 <= Constants.upper_taylor_n_bound) {
                return Math.log(d11 + Math.sqrt((d11 * d11) + ((double) 1)));
            }
            if (d11 > Constants.upper_taylor_2_bound) {
                return Math.log(d11) + Constants.LN2;
            }
            double d13 = d11 * ((double) 2);
            return Math.log(d13 + (((double) 1) / d13));
        } else if (d11 <= (-d12)) {
            return -asinh(-d11);
        } else {
            return Math.abs(d11) >= Constants.taylor_2_bound ? d11 - (((d11 * d11) * d11) / ((double) 6)) : d11;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan(double d11) {
        return Math.atan(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan2(double d11, double d12) {
        return Math.atan2(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    public static final double atanh(double d11) {
        if (Math.abs(d11) < Constants.taylor_n_bound) {
            return Math.abs(d11) > Constants.taylor_2_bound ? d11 + (((d11 * d11) * d11) / ((double) 3)) : d11;
        }
        double d12 = (double) 1;
        return Math.log((d12 + d11) / (d12 - d11)) / ((double) 2);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final double cbrt(double d11) {
        return Math.cbrt(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ceil(double d11) {
        return Math.ceil(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cos(double d11) {
        return Math.cos(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cosh(double d11) {
        return Math.cosh(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double exp(double d11) {
        return Math.exp(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double expm1(double d11) {
        return Math.expm1(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double floor(double d11) {
        return Math.floor(d11);
    }

    private static final double getAbsoluteValue(double d11) {
        return Math.abs(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d11) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f11) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i11) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j11) {
    }

    private static final double getSign(double d11) {
        return Math.signum(d11);
    }

    public static int getSign(int i11) {
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    public static int getSign(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d11) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f11) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i11) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j11) {
    }

    private static final double getUlp(double d11) {
        return Math.ulp(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d11) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f11) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double hypot(double d11, double d12) {
        return Math.hypot(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln(double d11) {
        return Math.log(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln1p(double d11) {
        return Math.log1p(d11);
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double d11, double d12) {
        if (d12 <= 0.0d) {
            return Double.NaN;
        }
        if (d12 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d11) / Math.log(d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double log10(double d11) {
        return Math.log10(d11);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double d11) {
        return Math.log(d11) / Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double max(double d11, double d12) {
        return Math.max(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double min(double d11, double d12) {
        return Math.min(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextDown(double d11) {
        return Math.nextAfter(d11, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextTowards(double d11, double d12) {
        return Math.nextAfter(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextUp(double d11) {
        return Math.nextUp(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double d11, double d12) {
        return Math.pow(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double round(double d11) {
        return Math.rint(d11);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(double d11) {
        if (Double.isNaN(d11)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d11 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if (d11 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d11);
        }
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(double d11) {
        if (!Double.isNaN(d11)) {
            return Math.round(d11);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sign(double d11) {
        return Math.signum(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sin(double d11) {
        return Math.sin(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sinh(double d11) {
        return Math.sinh(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sqrt(double d11) {
        return Math.sqrt(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tan(double d11) {
        return Math.tan(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tanh(double d11) {
        return Math.tanh(d11);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double d11) {
        if (Double.isNaN(d11) || Double.isInfinite(d11)) {
            return d11;
        }
        if (d11 > 0.0d) {
            return Math.floor(d11);
        }
        return Math.ceil(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double d11, double d12) {
        return Math.copySign(d11, d12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float IEEErem(float f11, float f12) {
        return (float) Math.IEEEremainder((double) f11, (double) f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float abs(float f11) {
        return Math.abs(f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acos(float f11) {
        return (float) Math.acos((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asin(float f11) {
        return (float) Math.asin((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan(float f11) {
        return (float) Math.atan((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan2(float f11, float f12) {
        return (float) Math.atan2((double) f11, (double) f12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final float cbrt(float f11) {
        return (float) Math.cbrt((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ceil(float f11) {
        return (float) Math.ceil((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cos(float f11) {
        return (float) Math.cos((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cosh(float f11) {
        return (float) Math.cosh((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float exp(float f11) {
        return (float) Math.exp((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float expm1(float f11) {
        return (float) Math.expm1((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float floor(float f11) {
        return (float) Math.floor((double) f11);
    }

    private static final float getAbsoluteValue(float f11) {
        return Math.abs(f11);
    }

    private static final float getSign(float f11) {
        return Math.signum(f11);
    }

    private static final float getUlp(float f11) {
        return Math.ulp(f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float hypot(float f11, float f12) {
        return (float) Math.hypot((double) f11, (double) f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln(float f11) {
        return (float) Math.log((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln1p(float f11) {
        return (float) Math.log1p((double) f11);
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float f11, float f12) {
        if (f12 <= 0.0f) {
            return Float.NaN;
        }
        if (f12 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log((double) f11) / Math.log((double) f12));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float log10(float f11) {
        return (float) Math.log10((double) f11);
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float f11) {
        return (float) (Math.log((double) f11) / Constants.LN2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float max(float f11, float f12) {
        return Math.max(f11, f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float min(float f11, float f12) {
        return Math.min(f11, f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextDown(float f11) {
        return Math.nextAfter(f11, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextTowards(float f11, float f12) {
        return Math.nextAfter(f11, (double) f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextUp(float f11) {
        return Math.nextUp(f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double d11, int i11) {
        return Math.pow(d11, (double) i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float round(float f11) {
        return (float) Math.rint((double) f11);
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(float f11) {
        return roundToLong((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sign(float f11) {
        return Math.signum(f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sin(float f11) {
        return (float) Math.sin((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sinh(float f11) {
        return (float) Math.sinh((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sqrt(float f11) {
        return (float) Math.sqrt((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tan(float f11) {
        return (float) Math.tan((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tanh(float f11) {
        return (float) Math.tanh((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double d11, int i11) {
        return Math.copySign(d11, (double) i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int abs(int i11) {
        return Math.abs(i11);
    }

    private static final int getAbsoluteValue(int i11) {
        return Math.abs(i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int max(int i11, int i12) {
        return Math.max(i11, i12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int min(int i11, int i12) {
        return Math.min(i11, i12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float f11, float f12) {
        return (float) Math.pow((double) f11, (double) f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float f11, float f12) {
        return Math.copySign(f11, f12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long abs(long j11) {
        return Math.abs(j11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atanh(float f11) {
        return (float) atanh((double) f11);
    }

    private static final long getAbsoluteValue(long j11) {
        return Math.abs(j11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long max(long j11, long j12) {
        return Math.max(j11, j12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long min(long j11, long j12) {
        return Math.min(j11, j12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float f11, int i11) {
        return (float) Math.pow((double) f11, (double) i11);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(float f11) {
        if (!Float.isNaN(f11)) {
            return Math.round(f11);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float f11) {
        double d11;
        if (Float.isNaN(f11) || Float.isInfinite(f11)) {
            return f11;
        }
        if (f11 > 0.0f) {
            d11 = Math.floor((double) f11);
        } else {
            d11 = Math.ceil((double) f11);
        }
        return (float) d11;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float f11, int i11) {
        return Math.copySign(f11, (float) i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acosh(float f11) {
        return (float) acosh((double) f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asinh(float f11) {
        return (float) asinh((double) f11);
    }
}
