package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;

    /* renamed from: a  reason: collision with root package name */
    public Arc[] f10525a;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];

        /* renamed from: a  reason: collision with root package name */
        public double[] f10526a;

        /* renamed from: b  reason: collision with root package name */
        public double f10527b;

        /* renamed from: c  reason: collision with root package name */
        public double f10528c;

        /* renamed from: d  reason: collision with root package name */
        public double f10529d;

        /* renamed from: e  reason: collision with root package name */
        public double f10530e;

        /* renamed from: f  reason: collision with root package name */
        public double f10531f;

        /* renamed from: g  reason: collision with root package name */
        public double f10532g;

        /* renamed from: h  reason: collision with root package name */
        public double f10533h;

        /* renamed from: i  reason: collision with root package name */
        public double f10534i;

        /* renamed from: j  reason: collision with root package name */
        public double f10535j;

        /* renamed from: k  reason: collision with root package name */
        public double f10536k;

        /* renamed from: l  reason: collision with root package name */
        public double f10537l;

        /* renamed from: m  reason: collision with root package name */
        public double f10538m;

        /* renamed from: n  reason: collision with root package name */
        public double f10539n;

        /* renamed from: o  reason: collision with root package name */
        public double f10540o;

        /* renamed from: p  reason: collision with root package name */
        public double f10541p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f10542q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f10543r = false;

        public Arc(int i11, double d11, double d12, double d13, double d14, double d15, double d16) {
            int i12;
            double d17;
            double d18;
            int i13 = i11;
            double d19 = d11;
            double d21 = d12;
            double d22 = d13;
            double d23 = d14;
            double d24 = d15;
            double d25 = d16;
            boolean z11 = false;
            int i14 = 1;
            this.f10542q = i13 == 1 ? true : z11;
            this.f10528c = d19;
            this.f10529d = d21;
            this.f10534i = 1.0d / (d21 - d19);
            if (3 == i13) {
                this.f10543r = true;
            }
            double d26 = d24 - d22;
            double d27 = d25 - d23;
            if (this.f10543r || Math.abs(d26) < EPSILON || Math.abs(d27) < EPSILON) {
                this.f10543r = true;
                this.f10530e = d22;
                this.f10531f = d24;
                this.f10532g = d23;
                this.f10533h = d16;
                double hypot = Math.hypot(d27, d26);
                this.f10527b = hypot;
                this.f10539n = hypot * this.f10534i;
                double d28 = this.f10529d;
                double d29 = this.f10528c;
                this.f10537l = d26 / (d28 - d29);
                this.f10538m = d27 / (d28 - d29);
                return;
            }
            this.f10526a = new double[101];
            boolean z12 = this.f10542q;
            if (z12) {
                i12 = -1;
            } else {
                i12 = 1;
            }
            this.f10535j = d26 * ((double) i12);
            this.f10536k = d27 * ((double) (!z12 ? -1 : i14));
            if (z12) {
                d17 = d24;
            } else {
                d17 = d22;
            }
            this.f10537l = d17;
            if (z12) {
                d18 = d23;
            } else {
                d18 = d16;
            }
            this.f10538m = d18;
            buildTable(d13, d14, d15, d16);
            this.f10539n = this.f10527b * this.f10534i;
        }

        private void buildTable(double d11, double d12, double d13, double d14) {
            double d15;
            double d16 = d13 - d11;
            double d17 = d12 - d14;
            int i11 = 0;
            double d18 = 0.0d;
            double d19 = 0.0d;
            double d21 = 0.0d;
            while (true) {
                double[] dArr = ourPercent;
                if (i11 >= dArr.length) {
                    break;
                }
                double d22 = d18;
                double radians = Math.toRadians((((double) i11) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d16;
                double cos = Math.cos(radians) * d17;
                if (i11 > 0) {
                    d15 = Math.hypot(sin - d19, cos - d21) + d22;
                    ourPercent[i11] = d15;
                } else {
                    d15 = d22;
                }
                i11++;
                d21 = cos;
                double d23 = sin;
                d18 = d15;
                d19 = d23;
            }
            double d24 = d18;
            this.f10527b = d24;
            int i12 = 0;
            while (true) {
                double[] dArr2 = ourPercent;
                if (i12 >= dArr2.length) {
                    break;
                }
                dArr2[i12] = dArr2[i12] / d24;
                i12++;
            }
            int i13 = 0;
            while (true) {
                double[] dArr3 = this.f10526a;
                if (i13 < dArr3.length) {
                    double length = ((double) i13) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.f10526a[i13] = ((double) binarySearch) / ((double) (ourPercent.length - 1));
                    } else if (binarySearch == -1) {
                        this.f10526a[i13] = 0.0d;
                    } else {
                        int i14 = -binarySearch;
                        int i15 = i14 - 2;
                        double[] dArr4 = ourPercent;
                        double d25 = dArr4[i15];
                        this.f10526a[i13] = (((double) i15) + ((length - d25) / (dArr4[i14 - 1] - d25))) / ((double) (dArr4.length - 1));
                    }
                    i13++;
                } else {
                    return;
                }
            }
        }

        public double a() {
            double d11 = this.f10535j * this.f10541p;
            double hypot = this.f10539n / Math.hypot(d11, (-this.f10536k) * this.f10540o);
            if (this.f10542q) {
                d11 = -d11;
            }
            return d11 * hypot;
        }

        public double b() {
            double d11 = this.f10535j * this.f10541p;
            double d12 = (-this.f10536k) * this.f10540o;
            double hypot = this.f10539n / Math.hypot(d11, d12);
            if (this.f10542q) {
                return (-d12) * hypot;
            }
            return d12 * hypot;
        }

        public double c() {
            return this.f10537l + (this.f10535j * this.f10540o);
        }

        public double d() {
            return this.f10538m + (this.f10536k * this.f10541p);
        }

        public double e(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f10526a;
            double length = d11 * ((double) (dArr.length - 1));
            int i11 = (int) length;
            double d12 = length - ((double) i11);
            double d13 = dArr[i11];
            return d13 + (d12 * (dArr[i11 + 1] - d13));
        }

        public void f(double d11) {
            double d12;
            if (this.f10542q) {
                d12 = this.f10529d - d11;
            } else {
                d12 = d11 - this.f10528c;
            }
            double e11 = e(d12 * this.f10534i) * 1.5707963267948966d;
            this.f10540o = Math.sin(e11);
            this.f10541p = Math.cos(e11);
        }

        public double getLinearDX(double d11) {
            return this.f10537l;
        }

        public double getLinearDY(double d11) {
            return this.f10538m;
        }

        public double getLinearX(double d11) {
            double d12 = (d11 - this.f10528c) * this.f10534i;
            double d13 = this.f10530e;
            return d13 + (d12 * (this.f10531f - d13));
        }

        public double getLinearY(double d11) {
            double d12 = (d11 - this.f10528c) * this.f10534i;
            double d13 = this.f10532g;
            return d13 + (d12 * (this.f10533h - d13));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r5 == 1) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArcCurveFit(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r2 = 1
            r0.mExtrapolate = r2
            r0.mTime = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.f10525a = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L_0x0016:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.f10525a
            int r8 = r7.length
            if (r4 >= r8) goto L_0x004f
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L_0x002f
            if (r8 == r2) goto L_0x002c
            r10 = 2
            if (r8 == r10) goto L_0x002a
            if (r8 == r9) goto L_0x0028
            goto L_0x0030
        L_0x0028:
            if (r5 != r2) goto L_0x002c
        L_0x002a:
            r5 = r10
            goto L_0x002d
        L_0x002c:
            r5 = r2
        L_0x002d:
            r6 = r5
            goto L_0x0030
        L_0x002f:
            r6 = r9
        L_0x0030:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r22 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r3]
            r16 = r8[r2]
            r8 = r27[r23]
            r18 = r8[r3]
            r20 = r8[r2]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L_0x0016
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    public void getPos(double d11, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.f10525a;
            Arc arc = arcArr[0];
            double d12 = arc.f10528c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (arc.f10543r) {
                    dArr[0] = arc.getLinearX(d12) + (this.f10525a[0].getLinearDX(d12) * d13);
                    dArr[1] = this.f10525a[0].getLinearY(d12) + (d13 * this.f10525a[0].getLinearDY(d12));
                    return;
                }
                arc.f(d12);
                dArr[0] = this.f10525a[0].c() + (this.f10525a[0].a() * d13);
                dArr[1] = this.f10525a[0].d() + (d13 * this.f10525a[0].b());
                return;
            } else if (d11 > arcArr[arcArr.length - 1].f10529d) {
                double d14 = arcArr[arcArr.length - 1].f10529d;
                double d15 = d11 - d14;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.f10543r) {
                    dArr[0] = arc2.getLinearX(d14) + (this.f10525a[length].getLinearDX(d14) * d15);
                    dArr[1] = this.f10525a[length].getLinearY(d14) + (d15 * this.f10525a[length].getLinearDY(d14));
                    return;
                }
                arc2.f(d11);
                dArr[0] = this.f10525a[length].c() + (this.f10525a[length].a() * d15);
                dArr[1] = this.f10525a[length].d() + (d15 * this.f10525a[length].b());
                return;
            }
        } else {
            Arc[] arcArr2 = this.f10525a;
            double d16 = arcArr2[0].f10528c;
            if (d11 < d16) {
                d11 = d16;
            }
            if (d11 > arcArr2[arcArr2.length - 1].f10529d) {
                d11 = arcArr2[arcArr2.length - 1].f10529d;
            }
        }
        int i11 = 0;
        while (true) {
            Arc[] arcArr3 = this.f10525a;
            if (i11 < arcArr3.length) {
                Arc arc3 = arcArr3[i11];
                if (d11 > arc3.f10529d) {
                    i11++;
                } else if (arc3.f10543r) {
                    dArr[0] = arc3.getLinearX(d11);
                    dArr[1] = this.f10525a[i11].getLinearY(d11);
                    return;
                } else {
                    arc3.f(d11);
                    dArr[0] = this.f10525a[i11].c();
                    dArr[1] = this.f10525a[i11].d();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void getSlope(double d11, double[] dArr) {
        Arc[] arcArr = this.f10525a;
        double d12 = arcArr[0].f10528c;
        if (d11 < d12) {
            d11 = d12;
        } else if (d11 > arcArr[arcArr.length - 1].f10529d) {
            d11 = arcArr[arcArr.length - 1].f10529d;
        }
        int i11 = 0;
        while (true) {
            Arc[] arcArr2 = this.f10525a;
            if (i11 < arcArr2.length) {
                Arc arc = arcArr2[i11];
                if (d11 > arc.f10529d) {
                    i11++;
                } else if (arc.f10543r) {
                    dArr[0] = arc.getLinearDX(d11);
                    dArr[1] = this.f10525a[i11].getLinearDY(d11);
                    return;
                } else {
                    arc.f(d11);
                    dArr[0] = this.f10525a[i11].a();
                    dArr[1] = this.f10525a[i11].b();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }

    public double getSlope(double d11, int i11) {
        Arc[] arcArr = this.f10525a;
        int i12 = 0;
        double d12 = arcArr[0].f10528c;
        if (d11 < d12) {
            d11 = d12;
        }
        if (d11 > arcArr[arcArr.length - 1].f10529d) {
            d11 = arcArr[arcArr.length - 1].f10529d;
        }
        while (true) {
            Arc[] arcArr2 = this.f10525a;
            if (i12 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i12];
            if (d11 > arc.f10529d) {
                i12++;
            } else if (!arc.f10543r) {
                arc.f(d11);
                if (i11 == 0) {
                    return this.f10525a[i12].a();
                }
                return this.f10525a[i12].b();
            } else if (i11 == 0) {
                return arc.getLinearDX(d11);
            } else {
                return arc.getLinearDY(d11);
            }
        }
    }

    public void getPos(double d11, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.f10525a;
            Arc arc = arcArr[0];
            double d12 = arc.f10528c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (arc.f10543r) {
                    fArr[0] = (float) (arc.getLinearX(d12) + (this.f10525a[0].getLinearDX(d12) * d13));
                    fArr[1] = (float) (this.f10525a[0].getLinearY(d12) + (d13 * this.f10525a[0].getLinearDY(d12)));
                    return;
                }
                arc.f(d12);
                fArr[0] = (float) (this.f10525a[0].c() + (this.f10525a[0].a() * d13));
                fArr[1] = (float) (this.f10525a[0].d() + (d13 * this.f10525a[0].b()));
                return;
            } else if (d11 > arcArr[arcArr.length - 1].f10529d) {
                double d14 = arcArr[arcArr.length - 1].f10529d;
                double d15 = d11 - d14;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.f10543r) {
                    fArr[0] = (float) (arc2.getLinearX(d14) + (this.f10525a[length].getLinearDX(d14) * d15));
                    fArr[1] = (float) (this.f10525a[length].getLinearY(d14) + (d15 * this.f10525a[length].getLinearDY(d14)));
                    return;
                }
                arc2.f(d11);
                fArr[0] = (float) this.f10525a[length].c();
                fArr[1] = (float) this.f10525a[length].d();
                return;
            }
        } else {
            Arc[] arcArr2 = this.f10525a;
            double d16 = arcArr2[0].f10528c;
            if (d11 < d16) {
                d11 = d16;
            } else if (d11 > arcArr2[arcArr2.length - 1].f10529d) {
                d11 = arcArr2[arcArr2.length - 1].f10529d;
            }
        }
        int i11 = 0;
        while (true) {
            Arc[] arcArr3 = this.f10525a;
            if (i11 < arcArr3.length) {
                Arc arc3 = arcArr3[i11];
                if (d11 > arc3.f10529d) {
                    i11++;
                } else if (arc3.f10543r) {
                    fArr[0] = (float) arc3.getLinearX(d11);
                    fArr[1] = (float) this.f10525a[i11].getLinearY(d11);
                    return;
                } else {
                    arc3.f(d11);
                    fArr[0] = (float) this.f10525a[i11].c();
                    fArr[1] = (float) this.f10525a[i11].d();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double getPos(double d11, int i11) {
        double linearY;
        double linearDY;
        double d12;
        double b11;
        double linearY2;
        double linearDY2;
        int i12 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.f10525a;
            Arc arc = arcArr[0];
            double d13 = arc.f10528c;
            if (d11 < d13) {
                double d14 = d11 - d13;
                if (arc.f10543r) {
                    if (i11 == 0) {
                        linearY2 = arc.getLinearX(d13);
                        linearDY2 = this.f10525a[0].getLinearDX(d13);
                    } else {
                        linearY2 = arc.getLinearY(d13);
                        linearDY2 = this.f10525a[0].getLinearDY(d13);
                    }
                    return linearY2 + (d14 * linearDY2);
                }
                arc.f(d13);
                if (i11 == 0) {
                    d12 = this.f10525a[0].c();
                    b11 = this.f10525a[0].a();
                } else {
                    d12 = this.f10525a[0].d();
                    b11 = this.f10525a[0].b();
                }
                return d12 + (d14 * b11);
            } else if (d11 > arcArr[arcArr.length - 1].f10529d) {
                double d15 = arcArr[arcArr.length - 1].f10529d;
                double d16 = d11 - d15;
                int length = arcArr.length - 1;
                if (i11 == 0) {
                    linearY = arcArr[length].getLinearX(d15);
                    linearDY = this.f10525a[length].getLinearDX(d15);
                } else {
                    linearY = arcArr[length].getLinearY(d15);
                    linearDY = this.f10525a[length].getLinearDY(d15);
                }
                return linearY + (d16 * linearDY);
            }
        } else {
            Arc[] arcArr2 = this.f10525a;
            double d17 = arcArr2[0].f10528c;
            if (d11 < d17) {
                d11 = d17;
            } else if (d11 > arcArr2[arcArr2.length - 1].f10529d) {
                d11 = arcArr2[arcArr2.length - 1].f10529d;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.f10525a;
            if (i12 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i12];
            if (d11 > arc2.f10529d) {
                i12++;
            } else if (!arc2.f10543r) {
                arc2.f(d11);
                if (i11 == 0) {
                    return this.f10525a[i12].c();
                }
                return this.f10525a[i12].d();
            } else if (i11 == 0) {
                return arc2.getLinearX(d11);
            } else {
                return arc2.getLinearY(d11);
            }
        }
    }
}
