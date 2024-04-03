package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {

    /* renamed from: com.google.common.math.ToDoubleRounder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.ToDoubleRounder.AnonymousClass1.<clinit>():void");
        }
    }

    public abstract X minus(X x11, X x12);

    public final double roundToDouble(X x11, RoundingMode roundingMode) {
        Number number;
        double d11;
        boolean z11;
        Preconditions.checkNotNull(x11, Param.X);
        Preconditions.checkNotNull(roundingMode, SessionsConfigParameter.SYNC_MODE);
        double roundToDoubleArbitrarily = roundToDoubleArbitrarily(x11);
        if (Double.isInfinite(roundToDoubleArbitrarily)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return ((double) sign(x11)) * Double.MAX_VALUE;
                case 5:
                    if (roundToDoubleArbitrarily == Double.POSITIVE_INFINITY) {
                        return Double.MAX_VALUE;
                    }
                    return Double.NEGATIVE_INFINITY;
                case 6:
                    if (roundToDoubleArbitrarily == Double.POSITIVE_INFINITY) {
                        return Double.POSITIVE_INFINITY;
                    }
                    return -1.7976931348623157E308d;
                case 7:
                    return roundToDoubleArbitrarily;
                case 8:
                    throw new ArithmeticException(x11 + " cannot be represented precisely as a double");
            }
        }
        Number x12 = toX(roundToDoubleArbitrarily, RoundingMode.UNNECESSARY);
        int compareTo = ((Comparable) x11).compareTo(x12);
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (sign(x11) >= 0) {
                    if (compareTo >= 0) {
                        return roundToDoubleArbitrarily;
                    }
                    return DoubleUtils.nextDown(roundToDoubleArbitrarily);
                } else if (compareTo <= 0) {
                    return roundToDoubleArbitrarily;
                } else {
                    return Math.nextUp(roundToDoubleArbitrarily);
                }
            case 2:
            case 3:
            case 4:
                if (compareTo >= 0) {
                    d11 = Math.nextUp(roundToDoubleArbitrarily);
                    if (d11 == Double.POSITIVE_INFINITY) {
                        return roundToDoubleArbitrarily;
                    }
                    number = toX(d11, RoundingMode.CEILING);
                } else {
                    double nextDown = DoubleUtils.nextDown(roundToDoubleArbitrarily);
                    if (nextDown == Double.NEGATIVE_INFINITY) {
                        return roundToDoubleArbitrarily;
                    }
                    Number x13 = toX(nextDown, RoundingMode.FLOOR);
                    double d12 = nextDown;
                    number = x12;
                    x12 = x13;
                    d11 = roundToDoubleArbitrarily;
                    roundToDoubleArbitrarily = d12;
                }
                int compareTo2 = ((Comparable) minus(x11, x12)).compareTo(minus(number, x11));
                if (compareTo2 < 0) {
                    return roundToDoubleArbitrarily;
                }
                if (compareTo2 > 0) {
                    return d11;
                }
                int i11 = iArr[roundingMode.ordinal()];
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            throw new AssertionError("impossible");
                        } else if (sign(x11) >= 0) {
                            return d11;
                        } else {
                            return roundToDoubleArbitrarily;
                        }
                    } else if (sign(x11) >= 0) {
                        return roundToDoubleArbitrarily;
                    } else {
                        return d11;
                    }
                } else if ((Double.doubleToRawLongBits(roundToDoubleArbitrarily) & 1) == 0) {
                    return roundToDoubleArbitrarily;
                } else {
                    return d11;
                }
            case 5:
                if (compareTo >= 0) {
                    return roundToDoubleArbitrarily;
                }
                return DoubleUtils.nextDown(roundToDoubleArbitrarily);
            case 6:
                if (compareTo <= 0) {
                    return roundToDoubleArbitrarily;
                }
                return Math.nextUp(roundToDoubleArbitrarily);
            case 7:
                if (sign(x11) >= 0) {
                    if (compareTo <= 0) {
                        return roundToDoubleArbitrarily;
                    }
                    return Math.nextUp(roundToDoubleArbitrarily);
                } else if (compareTo >= 0) {
                    return roundToDoubleArbitrarily;
                } else {
                    return DoubleUtils.nextDown(roundToDoubleArbitrarily);
                }
            case 8:
                if (compareTo == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z11);
                return roundToDoubleArbitrarily;
            default:
                throw new AssertionError("impossible");
        }
    }

    public abstract double roundToDoubleArbitrarily(X x11);

    public abstract int sign(X x11);

    public abstract X toX(double d11, RoundingMode roundingMode);
}
