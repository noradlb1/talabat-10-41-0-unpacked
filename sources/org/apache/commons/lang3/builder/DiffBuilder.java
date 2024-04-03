package org.apache.commons.lang3.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class DiffBuilder implements Builder<DiffResult> {
    private final List<Diff<?>> diffs;
    private final Object left;
    private final boolean objectsTriviallyEqual;
    private final Object right;
    private final ToStringStyle style;

    public DiffBuilder(Object obj, Object obj2, ToStringStyle toStringStyle) {
        boolean z11;
        if (obj == null) {
            throw new IllegalArgumentException("lhs cannot be null");
        } else if (obj2 != null) {
            this.diffs = new ArrayList();
            this.left = obj;
            this.right = obj2;
            this.style = toStringStyle;
            if (obj == obj2 || obj.equals(obj2)) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.objectsTriviallyEqual = z11;
        } else {
            throw new IllegalArgumentException("rhs cannot be null");
        }
    }

    public DiffBuilder append(String str, final boolean z11, final boolean z12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && z11 != z12) {
                this.diffs.add(new Diff<Boolean>(str) {
                    private static final long serialVersionUID = 1;

                    public Boolean getLeft() {
                        return Boolean.valueOf(z11);
                    }

                    public Boolean getRight() {
                        return Boolean.valueOf(z12);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffResult build() {
        return new DiffResult(this.left, this.right, this.diffs, this.style);
    }

    public DiffBuilder append(String str, final boolean[] zArr, final boolean[] zArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(zArr, zArr2)) {
                this.diffs.add(new Diff<Boolean[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Boolean[] getLeft() {
                        return ArrayUtils.toObject(zArr);
                    }

                    public Boolean[] getRight() {
                        return ArrayUtils.toObject(zArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final byte b11, final byte b12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && b11 != b12) {
                this.diffs.add(new Diff<Byte>(str) {
                    private static final long serialVersionUID = 1;

                    public Byte getLeft() {
                        return Byte.valueOf(b11);
                    }

                    public Byte getRight() {
                        return Byte.valueOf(b12);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final byte[] bArr, final byte[] bArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(bArr, bArr2)) {
                this.diffs.add(new Diff<Byte[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Byte[] getLeft() {
                        return ArrayUtils.toObject(bArr);
                    }

                    public Byte[] getRight() {
                        return ArrayUtils.toObject(bArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final char c11, final char c12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && c11 != c12) {
                this.diffs.add(new Diff<Character>(str) {
                    private static final long serialVersionUID = 1;

                    public Character getLeft() {
                        return Character.valueOf(c11);
                    }

                    public Character getRight() {
                        return Character.valueOf(c12);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final char[] cArr, final char[] cArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(cArr, cArr2)) {
                this.diffs.add(new Diff<Character[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Character[] getLeft() {
                        return ArrayUtils.toObject(cArr);
                    }

                    public Character[] getRight() {
                        return ArrayUtils.toObject(cArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, double d11, double d12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && Double.doubleToLongBits(d11) != Double.doubleToLongBits(d12)) {
                final double d13 = d11;
                final double d14 = d12;
                this.diffs.add(new Diff<Double>(str) {
                    private static final long serialVersionUID = 1;

                    public Double getLeft() {
                        return Double.valueOf(d13);
                    }

                    public Double getRight() {
                        return Double.valueOf(d14);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final double[] dArr, final double[] dArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(dArr, dArr2)) {
                this.diffs.add(new Diff<Double[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Double[] getLeft() {
                        return ArrayUtils.toObject(dArr);
                    }

                    public Double[] getRight() {
                        return ArrayUtils.toObject(dArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final float f11, final float f12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && Float.floatToIntBits(f11) != Float.floatToIntBits(f12)) {
                this.diffs.add(new Diff<Float>(str) {
                    private static final long serialVersionUID = 1;

                    public Float getLeft() {
                        return Float.valueOf(f11);
                    }

                    public Float getRight() {
                        return Float.valueOf(f12);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final float[] fArr, final float[] fArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(fArr, fArr2)) {
                this.diffs.add(new Diff<Float[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Float[] getLeft() {
                        return ArrayUtils.toObject(fArr);
                    }

                    public Float[] getRight() {
                        return ArrayUtils.toObject(fArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final int i11, final int i12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && i11 != i12) {
                this.diffs.add(new Diff<Integer>(str) {
                    private static final long serialVersionUID = 1;

                    public Integer getLeft() {
                        return Integer.valueOf(i11);
                    }

                    public Integer getRight() {
                        return Integer.valueOf(i12);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final int[] iArr, final int[] iArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(iArr, iArr2)) {
                this.diffs.add(new Diff<Integer[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Integer[] getLeft() {
                        return ArrayUtils.toObject(iArr);
                    }

                    public Integer[] getRight() {
                        return ArrayUtils.toObject(iArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, long j11, long j12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && j11 != j12) {
                final long j13 = j11;
                final long j14 = j12;
                this.diffs.add(new Diff<Long>(str) {
                    private static final long serialVersionUID = 1;

                    public Long getLeft() {
                        return Long.valueOf(j13);
                    }

                    public Long getRight() {
                        return Long.valueOf(j14);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final long[] jArr, final long[] jArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(jArr, jArr2)) {
                this.diffs.add(new Diff<Long[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Long[] getLeft() {
                        return ArrayUtils.toObject(jArr);
                    }

                    public Long[] getRight() {
                        return ArrayUtils.toObject(jArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final short s11, final short s12) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && s11 != s12) {
                this.diffs.add(new Diff<Short>(str) {
                    private static final long serialVersionUID = 1;

                    public Short getLeft() {
                        return Short.valueOf(s11);
                    }

                    public Short getRight() {
                        return Short.valueOf(s12);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final short[] sArr, final short[] sArr2) {
        if (str != null) {
            if (!this.objectsTriviallyEqual && !Arrays.equals(sArr, sArr2)) {
                this.diffs.add(new Diff<Short[]>(str) {
                    private static final long serialVersionUID = 1;

                    public Short[] getLeft() {
                        return ArrayUtils.toObject(sArr);
                    }

                    public Short[] getRight() {
                        return ArrayUtils.toObject(sArr2);
                    }
                });
            }
            return this;
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public DiffBuilder append(String str, final Object obj, final Object obj2) {
        if (this.objectsTriviallyEqual || obj == obj2) {
            return this;
        }
        Object obj3 = obj != null ? obj : obj2;
        if (!obj3.getClass().isArray()) {
            this.diffs.add(new Diff<Object>(str) {
                private static final long serialVersionUID = 1;

                public Object getLeft() {
                    return obj;
                }

                public Object getRight() {
                    return obj2;
                }
            });
            return this;
        } else if (obj3 instanceof boolean[]) {
            return append(str, (boolean[]) obj, (boolean[]) obj2);
        } else {
            if (obj3 instanceof byte[]) {
                return append(str, (byte[]) obj, (byte[]) obj2);
            }
            if (obj3 instanceof char[]) {
                return append(str, (char[]) obj, (char[]) obj2);
            }
            if (obj3 instanceof double[]) {
                return append(str, (double[]) obj, (double[]) obj2);
            }
            if (obj3 instanceof float[]) {
                return append(str, (float[]) obj, (float[]) obj2);
            }
            if (obj3 instanceof int[]) {
                return append(str, (int[]) obj, (int[]) obj2);
            }
            if (obj3 instanceof long[]) {
                return append(str, (long[]) obj, (long[]) obj2);
            }
            if (obj3 instanceof short[]) {
                return append(str, (short[]) obj, (short[]) obj2);
            }
            return append(str, (Object[]) obj, (Object[]) obj2);
        }
    }

    public DiffBuilder append(String str, final Object[] objArr, final Object[] objArr2) {
        if (!this.objectsTriviallyEqual && !Arrays.equals(objArr, objArr2)) {
            this.diffs.add(new Diff<Object[]>(str) {
                private static final long serialVersionUID = 1;

                public Object[] getLeft() {
                    return objArr;
                }

                public Object[] getRight() {
                    return objArr2;
                }
            });
        }
        return this;
    }
}
