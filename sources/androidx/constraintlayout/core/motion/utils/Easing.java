package androidx.constraintlayout.core.motion.utils;

import com.newrelic.agent.android.util.Constants;
import java.io.PrintStream;
import java.util.Arrays;

public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";

    /* renamed from: b  reason: collision with root package name */
    public static Easing f10546b = new Easing();

    /* renamed from: a  reason: collision with root package name */
    public String f10547a = Constants.Network.ContentType.IDENTITY;

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals(ANTICIPATE_NAME)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(LINEAR_NAME)) {
                    c11 = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals(OVERSHOOT_NAME)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(STANDARD_NAME)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new CubicEasing(ACCELERATE);
            case 1:
                return new CubicEasing(DECELERATE);
            case 2:
                return new CubicEasing(ANTICIPATE);
            case 3:
                return new CubicEasing(LINEAR);
            case 4:
                return new CubicEasing(OVERSHOOT);
            case 5:
                return new CubicEasing(STANDARD);
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return f10546b;
        }
    }

    public double get(double d11) {
        return d11;
    }

    public double getDiff(double d11) {
        return 1.0d;
    }

    public String toString() {
        return this.f10547a;
    }

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: c  reason: collision with root package name */
        public double f10548c;

        /* renamed from: d  reason: collision with root package name */
        public double f10549d;

        /* renamed from: e  reason: collision with root package name */
        public double f10550e;

        /* renamed from: f  reason: collision with root package name */
        public double f10551f;

        public CubicEasing(String str) {
            this.f10547a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f10548c = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i11 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i11);
            this.f10549d = Double.parseDouble(str.substring(i11, indexOf3).trim());
            int i12 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i12);
            this.f10550e = Double.parseDouble(str.substring(i12, indexOf4).trim());
            int i13 = indexOf4 + 1;
            this.f10551f = Double.parseDouble(str.substring(i13, str.indexOf(41, i13)).trim());
        }

        private double getDiffX(double d11) {
            double d12 = 1.0d - d11;
            double d13 = this.f10548c;
            double d14 = this.f10550e;
            return (d12 * 3.0d * d12 * d13) + (d12 * 6.0d * d11 * (d14 - d13)) + (3.0d * d11 * d11 * (1.0d - d14));
        }

        private double getDiffY(double d11) {
            double d12 = 1.0d - d11;
            double d13 = this.f10549d;
            double d14 = this.f10551f;
            return (d12 * 3.0d * d12 * d13) + (d12 * 6.0d * d11 * (d14 - d13)) + (3.0d * d11 * d11 * (1.0d - d14));
        }

        private double getX(double d11) {
            double d12 = 1.0d - d11;
            double d13 = 3.0d * d12;
            return (this.f10548c * d12 * d13 * d11) + (this.f10550e * d13 * d11 * d11) + (d11 * d11 * d11);
        }

        private double getY(double d11) {
            double d12 = 1.0d - d11;
            double d13 = 3.0d * d12;
            return (this.f10549d * d12 * d13 * d11) + (this.f10551f * d13 * d11 * d11) + (d11 * d11 * d11);
        }

        public void a(double d11, double d12, double d13, double d14) {
            this.f10548c = d11;
            this.f10549d = d12;
            this.f10550e = d13;
            this.f10551f = d14;
        }

        public double get(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double d12 = 0.5d;
            double d13 = 0.5d;
            while (d12 > error) {
                d12 *= 0.5d;
                if (getX(d13) < d11) {
                    d13 += d12;
                } else {
                    d13 -= d12;
                }
            }
            double d14 = d13 - d12;
            double x11 = getX(d14);
            double d15 = d13 + d12;
            double x12 = getX(d15);
            double y11 = getY(d14);
            return (((getY(d15) - y11) * (d11 - x11)) / (x12 - x11)) + y11;
        }

        public double getDiff(double d11) {
            double d12 = 0.5d;
            double d13 = 0.5d;
            while (d12 > d_error) {
                d12 *= 0.5d;
                if (getX(d13) < d11) {
                    d13 += d12;
                } else {
                    d13 -= d12;
                }
            }
            double d14 = d13 - d12;
            double x11 = getX(d14);
            double d15 = d13 + d12;
            return (getY(d15) - getY(d14)) / (getX(d15) - x11);
        }

        public CubicEasing(double d11, double d12, double d13, double d14) {
            a(d11, d12, d13, d14);
        }
    }
}
