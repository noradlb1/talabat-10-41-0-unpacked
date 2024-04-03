package org.apache.commons.lang3.math;

import java.math.BigInteger;

public final class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private transient int hashCode = 0;
    private final int numerator;
    private transient String toProperString = null;
    private transient String toString = null;

    private Fraction(int i11, int i12) {
        this.numerator = i11;
        this.denominator = i12;
    }

    private static int addAndCheck(int i11, int i12) {
        long j11 = ((long) i11) + ((long) i12);
        if (j11 >= -2147483648L && j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction fraction, boolean z11) {
        BigInteger bigInteger;
        int i11;
        int i12;
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.numerator == 0) {
            if (z11) {
                return fraction;
            }
            return fraction.negate();
        } else if (fraction.numerator == 0) {
            return this;
        } else {
            int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
            if (greatestCommonDivisor == 1) {
                int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                if (z11) {
                    i12 = addAndCheck(mulAndCheck, mulAndCheck2);
                } else {
                    i12 = subAndCheck(mulAndCheck, mulAndCheck2);
                }
                return new Fraction(i12, mulPosAndCheck(this.denominator, fraction.denominator));
            }
            BigInteger multiply = BigInteger.valueOf((long) this.numerator).multiply(BigInteger.valueOf((long) (fraction.denominator / greatestCommonDivisor)));
            BigInteger multiply2 = BigInteger.valueOf((long) fraction.numerator).multiply(BigInteger.valueOf((long) (this.denominator / greatestCommonDivisor)));
            if (z11) {
                bigInteger = multiply.add(multiply2);
            } else {
                bigInteger = multiply.subtract(multiply2);
            }
            int intValue = bigInteger.mod(BigInteger.valueOf((long) greatestCommonDivisor)).intValue();
            if (intValue == 0) {
                i11 = greatestCommonDivisor;
            } else {
                i11 = greatestCommonDivisor(intValue, greatestCommonDivisor);
            }
            BigInteger divide = bigInteger.divide(BigInteger.valueOf((long) i11));
            if (divide.bitLength() <= 31) {
                return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / i11));
            }
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
    }

    public static Fraction getFraction(int i11, int i12) {
        if (i12 != 0) {
            if (i12 < 0) {
                if (i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i11 = -i11;
                i12 = -i12;
            }
            return new Fraction(i11, i12);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i11, int i12) {
        if (i12 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i11 == 0) {
            return ZERO;
        } else {
            if (i12 == Integer.MIN_VALUE && (i11 & 1) == 0) {
                i11 /= 2;
                i12 /= 2;
            }
            if (i12 < 0) {
                if (i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i11 = -i11;
                i12 = -i12;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i11, i12);
            return new Fraction(i11 / greatestCommonDivisor, i12 / greatestCommonDivisor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int greatestCommonDivisor(int r6, int r7) {
        /*
            java.lang.String r0 = "overflow: gcd is 2^31"
            if (r6 == 0) goto L_0x0056
            if (r7 != 0) goto L_0x0007
            goto L_0x0056
        L_0x0007:
            int r1 = java.lang.Math.abs(r6)
            r2 = 1
            if (r1 == r2) goto L_0x0055
            int r1 = java.lang.Math.abs(r7)
            if (r1 != r2) goto L_0x0015
            goto L_0x0055
        L_0x0015:
            if (r6 <= 0) goto L_0x0018
            int r6 = -r6
        L_0x0018:
            if (r7 <= 0) goto L_0x001b
            int r7 = -r7
        L_0x001b:
            r1 = 0
        L_0x001c:
            r3 = r6 & 1
            r4 = 31
            if (r3 != 0) goto L_0x002f
            r5 = r7 & 1
            if (r5 != 0) goto L_0x002f
            if (r1 >= r4) goto L_0x002f
            int r6 = r6 / 2
            int r7 = r7 / 2
            int r1 = r1 + 1
            goto L_0x001c
        L_0x002f:
            if (r1 == r4) goto L_0x004f
            if (r3 != r2) goto L_0x0035
            r0 = r7
            goto L_0x0038
        L_0x0035:
            int r0 = r6 / 2
            int r0 = -r0
        L_0x0038:
            r3 = r0 & 1
            if (r3 != 0) goto L_0x003f
            int r0 = r0 / 2
            goto L_0x0038
        L_0x003f:
            if (r0 <= 0) goto L_0x0043
            int r6 = -r0
            goto L_0x0044
        L_0x0043:
            r7 = r0
        L_0x0044:
            int r0 = r7 - r6
            int r0 = r0 / 2
            if (r0 != 0) goto L_0x0038
            int r6 = -r6
            int r7 = r2 << r1
            int r6 = r6 * r7
            return r6
        L_0x004f:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        L_0x0055:
            return r2
        L_0x0056:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == r1) goto L_0x0066
            if (r7 == r1) goto L_0x0066
            int r6 = java.lang.Math.abs(r6)
            int r7 = java.lang.Math.abs(r7)
            int r6 = r6 + r7
            return r6
        L_0x0066:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.Fraction.greatestCommonDivisor(int, int):int");
    }

    private static int mulAndCheck(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        if (j11 >= -2147483648L && j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("overflow: mul");
    }

    private static int mulPosAndCheck(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        if (j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i11, int i12) {
        long j11 = ((long) i11) - ((long) i12);
        if (j11 >= -2147483648L && j11 <= 2147483647L) {
            return (int) j11;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        } else {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        }
    }

    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator()) {
            return true;
        }
        return false;
    }

    public float floatValue() {
        return ((float) this.numerator) / ((float) this.denominator);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((getNumerator() + 629) * 37) + getDenominator();
        }
        return this.hashCode;
    }

    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i11 = this.numerator;
        if (i11 == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        } else if (i11 == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        } else if (i11 < 0) {
            return new Fraction(-this.denominator, -i11);
        } else {
            return new Fraction(this.denominator, i11);
        }
    }

    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction != null) {
            int i11 = this.numerator;
            if (i11 == 0 || fraction.numerator == 0) {
                return ZERO;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i11, fraction.denominator);
            int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
            return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public Fraction negate() {
        int i11 = this.numerator;
        if (i11 != Integer.MIN_VALUE) {
            return new Fraction(-i11, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i11) {
        if (i11 == 1) {
            return this;
        }
        if (i11 == 0) {
            return ONE;
        }
        if (i11 >= 0) {
            Fraction multiplyBy = multiplyBy(this);
            if (i11 % 2 == 0) {
                return multiplyBy.pow(i11 / 2);
            }
            return multiplyBy.pow(i11 / 2).multiplyBy(this);
        } else if (i11 == Integer.MIN_VALUE) {
            return invert().pow(2).pow(-(i11 / 2));
        } else {
            return invert().pow(-i11);
        }
    }

    public Fraction reduce() {
        int i11 = this.numerator;
        if (i11 == 0) {
            Fraction fraction = ZERO;
            if (equals(fraction)) {
                return this;
            }
            return fraction;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i11), this.denominator);
        if (greatestCommonDivisor == 1) {
            return this;
        }
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i11 = this.numerator;
            if (i11 == 0) {
                this.toProperString = "0";
            } else {
                int i12 = this.denominator;
                if (i11 == i12) {
                    this.toProperString = "1";
                } else if (i11 == i12 * -1) {
                    this.toProperString = "-1";
                } else {
                    if (i11 > 0) {
                        i11 = -i11;
                    }
                    if (i11 < (-i12)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            StringBuilder sb2 = new StringBuilder(32);
                            sb2.append(getProperWhole());
                            sb2.append(' ');
                            sb2.append(properNumerator);
                            sb2.append('/');
                            sb2.append(getDenominator());
                            this.toProperString = sb2.toString();
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder(32);
                        sb3.append(getNumerator());
                        sb3.append('/');
                        sb3.append(getDenominator());
                        this.toProperString = sb3.toString();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(getNumerator());
            sb2.append('/');
            sb2.append(getDenominator());
            this.toString = sb2.toString();
        }
        return this.toString;
    }

    public int compareTo(Fraction fraction) {
        int i11;
        if (this == fraction) {
            return 0;
        }
        int i12 = this.numerator;
        int i13 = fraction.numerator;
        if ((i12 == i13 && this.denominator == fraction.denominator) || ((long) i12) * ((long) fraction.denominator) == ((long) i13) * ((long) this.denominator)) {
            return 0;
        }
        return i11 < 0 ? -1 : 1;
    }

    public static Fraction getFraction(int i11, int i12, int i13) {
        if (i13 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i13 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i12 >= 0) {
            long j11 = i11 < 0 ? (((long) i11) * ((long) i13)) - ((long) i12) : (((long) i11) * ((long) i13)) + ((long) i12);
            if (j11 >= -2147483648L && j11 <= 2147483647L) {
                return new Fraction((int) j11, i13);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        } else {
            throw new ArithmeticException("The numerator must not be negative");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.lang3.math.Fraction getFraction(double r21) {
        /*
            r0 = 0
            int r0 = (r21 > r0 ? 1 : (r21 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0008
            r0 = -1
            goto L_0x0009
        L_0x0008:
            r0 = 1
        L_0x0009:
            double r2 = java.lang.Math.abs(r21)
            r4 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0084
            boolean r4 = java.lang.Double.isNaN(r2)
            if (r4 != 0) goto L_0x0084
            int r4 = (int) r2
            double r5 = (double) r4
            double r2 = r2 - r5
            int r5 = (int) r2
            double r6 = (double) r5
            double r6 = r2 - r6
            r8 = 0
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r11 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r21 = r2
            r13 = r11
            r15 = 1
            r16 = 1
            r11 = r9
            r9 = r8
            r10 = r9
            r8 = 1
        L_0x0035:
            double r1 = r11 / r6
            int r1 = (int) r1
            double r2 = (double) r1
            double r2 = r2 * r6
            double r2 = r11 - r2
            int r11 = r5 * r8
            int r11 = r11 + r9
            int r5 = r5 * r10
            int r5 = r5 + r15
            r9 = r1
            r17 = r2
            double r1 = (double) r11
            r19 = r6
            double r6 = (double) r5
            double r1 = r1 / r6
            r6 = r21
            double r2 = r6 - r1
            double r1 = java.lang.Math.abs(r2)
            r3 = 1
            int r12 = r16 + 1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            r14 = 25
            if (r13 <= 0) goto L_0x0072
            r13 = 10000(0x2710, float:1.4013E-41)
            if (r5 > r13) goto L_0x0072
            if (r5 <= 0) goto L_0x0072
            if (r12 < r14) goto L_0x0063
            goto L_0x0072
        L_0x0063:
            r13 = r1
            r21 = r6
            r15 = r10
            r16 = r12
            r6 = r17
            r10 = r5
            r5 = r9
            r9 = r8
            r8 = r11
            r11 = r19
            goto L_0x0035
        L_0x0072:
            if (r12 == r14) goto L_0x007c
            int r4 = r4 * r10
            int r8 = r8 + r4
            int r8 = r8 * r0
            org.apache.commons.lang3.math.Fraction r0 = getReducedFraction(r8, r10)
            return r0
        L_0x007c:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Unable to convert double to fraction"
            r0.<init>(r1)
            throw r0
        L_0x0084:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "The value must not be greater than Integer.MAX_VALUE or NaN"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.Fraction.getFraction(double):org.apache.commons.lang3.math.Fraction");
    }

    public static Fraction getFraction(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The string must not be null");
        } else if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        } else {
            int indexOf = str.indexOf(32);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(47);
                if (indexOf2 >= 0) {
                    return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
                }
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
        }
    }
}
