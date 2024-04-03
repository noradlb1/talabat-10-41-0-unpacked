package androidx.constraintlayout.core.motion.utils;

public class Schlick extends Easing {
    private static final boolean DEBUG = false;

    /* renamed from: c  reason: collision with root package name */
    public double f10604c;

    /* renamed from: d  reason: collision with root package name */
    public double f10605d;

    public Schlick(String str) {
        this.f10547a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.f10604c = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i11 = indexOf2 + 1;
        this.f10605d = Double.parseDouble(str.substring(i11, str.indexOf(44, i11)).trim());
    }

    private double dfunc(double d11) {
        double d12 = this.f10605d;
        if (d11 < d12) {
            double d13 = this.f10604c;
            return ((d13 * d12) * d12) / ((((d12 - d11) * d13) + d11) * ((d13 * (d12 - d11)) + d11));
        }
        double d14 = this.f10604c;
        return (((d12 - 1.0d) * d14) * (d12 - 1.0d)) / (((((-d14) * (d12 - d11)) - d11) + 1.0d) * ((((-d14) * (d12 - d11)) - d11) + 1.0d));
    }

    private double func(double d11) {
        double d12 = this.f10605d;
        if (d11 < d12) {
            return (d12 * d11) / (d11 + (this.f10604c * (d12 - d11)));
        }
        return ((1.0d - d12) * (d11 - 1.0d)) / ((1.0d - d11) - (this.f10604c * (d12 - d11)));
    }

    public double get(double d11) {
        return func(d11);
    }

    public double getDiff(double d11) {
        return dfunc(d11);
    }
}
