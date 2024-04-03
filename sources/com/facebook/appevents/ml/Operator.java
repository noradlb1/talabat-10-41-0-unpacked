package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "()V", "addmv", "", "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", "", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", "", "seqLength", "", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class Operator {
    @NotNull
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    @JvmStatic
    public static final void addmv(@NotNull MTensor mTensor, @NotNull MTensor mTensor2) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        Intrinsics.checkNotNullParameter(mTensor2, "b");
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        int shape3 = mTensor.getShape(2);
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        if (shape > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (shape2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        if (shape3 > 0) {
                            int i15 = 0;
                            while (true) {
                                int i16 = i15 + 1;
                                int i17 = (i11 * shape2 * shape3) + (i13 * shape3) + i15;
                                data[i17] = data[i17] + data2[i15];
                                if (i16 >= shape3) {
                                    break;
                                }
                                i15 = i16;
                            }
                        }
                        if (i14 >= shape2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (i12 < shape) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor concatenate(@NotNull MTensor[] mTensorArr) {
        int i11;
        Intrinsics.checkNotNullParameter(mTensorArr, "tensors");
        int shape = mTensorArr[0].getShape(0);
        int length = mTensorArr.length - 1;
        if (length >= 0) {
            int i12 = 0;
            i11 = 0;
            while (true) {
                int i13 = i12 + 1;
                i11 += mTensorArr[i12].getShape(1);
                if (i13 > length) {
                    break;
                }
                i12 = i13;
            }
        } else {
            i11 = 0;
        }
        MTensor mTensor = new MTensor(new int[]{shape, i11});
        float[] data = mTensor.getData();
        if (shape > 0) {
            int i14 = 0;
            while (true) {
                int i15 = i14 + 1;
                int i16 = i14 * i11;
                int length2 = mTensorArr.length - 1;
                if (length2 >= 0) {
                    int i17 = 0;
                    while (true) {
                        int i18 = i17 + 1;
                        float[] data2 = mTensorArr[i17].getData();
                        int shape2 = mTensorArr[i17].getShape(1);
                        System.arraycopy(data2, i14 * shape2, data, i16, shape2);
                        i16 += shape2;
                        if (i18 > length2) {
                            break;
                        }
                        i17 = i18;
                    }
                }
                if (i15 >= shape) {
                    break;
                }
                i14 = i15;
            }
        }
        return mTensor;
    }

    @JvmStatic
    @NotNull
    public static final MTensor conv1D(@NotNull MTensor mTensor, @NotNull MTensor mTensor2) {
        MTensor mTensor3;
        int i11;
        int i12;
        MTensor mTensor4 = mTensor;
        MTensor mTensor5 = mTensor2;
        Intrinsics.checkNotNullParameter(mTensor4, Param.X);
        Intrinsics.checkNotNullParameter(mTensor5, "w");
        int i13 = 0;
        int shape = mTensor4.getShape(0);
        int shape2 = mTensor4.getShape(1);
        int shape3 = mTensor4.getShape(2);
        int shape4 = mTensor5.getShape(0);
        int i14 = (shape2 - shape4) + 1;
        int shape5 = mTensor5.getShape(2);
        MTensor mTensor6 = new MTensor(new int[]{shape, i14, shape5});
        float[] data = mTensor.getData();
        float[] data2 = mTensor6.getData();
        float[] data3 = mTensor2.getData();
        if (shape <= 0) {
            return mTensor6;
        }
        int i15 = 0;
        while (true) {
            int i16 = i15 + 1;
            if (shape5 > 0) {
                int i17 = i13;
                while (true) {
                    int i18 = i17 + 1;
                    if (i14 > 0) {
                        int i19 = i13;
                        while (true) {
                            int i21 = i19 + 1;
                            float f11 = 0.0f;
                            if (shape4 > 0) {
                                int i22 = 0;
                                while (true) {
                                    mTensor3 = mTensor6;
                                    int i23 = i22 + 1;
                                    if (shape3 > 0) {
                                        int i24 = 0;
                                        while (true) {
                                            i12 = shape;
                                            int i25 = i24 + 1;
                                            f11 += data[(shape2 * shape3 * i15) + ((i22 + i19) * shape3) + i24] * data3[(((i22 * shape3) + i24) * shape5) + i17];
                                            if (i25 >= shape3) {
                                                break;
                                            }
                                            i24 = i25;
                                            shape = i12;
                                        }
                                    } else {
                                        i12 = shape;
                                    }
                                    if (i23 >= shape4) {
                                        break;
                                    }
                                    i22 = i23;
                                    mTensor6 = mTensor3;
                                    shape = i12;
                                }
                            } else {
                                i12 = shape;
                                mTensor3 = mTensor6;
                            }
                            data2[(i14 * shape5 * i15) + (i19 * shape5) + i17] = f11;
                            if (i21 >= i14) {
                                break;
                            }
                            i19 = i21;
                            mTensor6 = mTensor3;
                            shape = i12;
                        }
                    } else {
                        i12 = shape;
                        mTensor3 = mTensor6;
                    }
                    if (i18 >= shape5) {
                        break;
                    }
                    i17 = i18;
                    mTensor6 = mTensor3;
                    shape = i12;
                    i13 = 0;
                }
                i11 = i12;
            } else {
                mTensor3 = mTensor6;
                i11 = shape;
            }
            if (i16 >= i11) {
                return mTensor3;
            }
            shape = i11;
            i15 = i16;
            mTensor6 = mTensor3;
            i13 = 0;
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor dense(@NotNull MTensor mTensor, @NotNull MTensor mTensor2, @NotNull MTensor mTensor3) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        Intrinsics.checkNotNullParameter(mTensor2, "w");
        Intrinsics.checkNotNullParameter(mTensor3, "b");
        int shape = mTensor.getShape(0);
        int shape2 = mTensor3.getShape(0);
        MTensor mul = mul(mTensor, mTensor2);
        float[] data = mTensor3.getData();
        float[] data2 = mul.getData();
        if (shape > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (shape2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        int i15 = (i11 * shape2) + i13;
                        data2[i15] = data2[i15] + data[i13];
                        if (i14 >= shape2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (i12 >= shape) {
                    break;
                }
                i11 = i12;
            }
        }
        return mul;
    }

    @JvmStatic
    @NotNull
    public static final MTensor embedding(@NotNull String[] strArr, int i11, @NotNull MTensor mTensor) {
        Intrinsics.checkNotNullParameter(strArr, "texts");
        Intrinsics.checkNotNullParameter(mTensor, "w");
        int length = strArr.length;
        int shape = mTensor.getShape(1);
        MTensor mTensor2 = new MTensor(new int[]{length, i11, shape});
        float[] data = mTensor2.getData();
        float[] data2 = mTensor.getData();
        if (length > 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                int[] vectorize = Utils.INSTANCE.vectorize(strArr[i12], i11);
                if (i11 > 0) {
                    int i14 = 0;
                    while (true) {
                        int i15 = i14 + 1;
                        System.arraycopy(data2, vectorize[i14] * shape, data, (shape * i11 * i12) + (i14 * shape), shape);
                        if (i15 >= i11) {
                            break;
                        }
                        i14 = i15;
                    }
                }
                if (i13 >= length) {
                    break;
                }
                i12 = i13;
            }
        }
        return mTensor2;
    }

    @JvmStatic
    public static final void flatten(@NotNull MTensor mTensor, int i11) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        if (i11 < mTensor.getShapeSize()) {
            int shapeSize = mTensor.getShapeSize();
            int i12 = 1;
            if (i11 < shapeSize) {
                int i13 = i11;
                while (true) {
                    int i14 = i13 + 1;
                    i12 *= mTensor.getShape(i13);
                    if (i14 >= shapeSize) {
                        break;
                    }
                    i13 = i14;
                }
            }
            int[] iArr = new int[(i11 + 1)];
            if (i11 > 0) {
                int i15 = 0;
                while (true) {
                    int i16 = i15 + 1;
                    iArr[i15] = mTensor.getShape(i15);
                    if (i16 >= i11) {
                        break;
                    }
                    i15 = i16;
                }
            }
            iArr[i11] = i12;
            mTensor.reshape(iArr);
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor maxPool1D(@NotNull MTensor mTensor, int i11) {
        int i12;
        MTensor mTensor2 = mTensor;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(mTensor2, Param.X);
        int i14 = 0;
        int shape = mTensor2.getShape(0);
        int shape2 = mTensor2.getShape(1);
        int shape3 = mTensor2.getShape(2);
        int i15 = (shape2 - i13) + 1;
        MTensor mTensor3 = new MTensor(new int[]{shape, i15, shape3});
        float[] data = mTensor.getData();
        float[] data2 = mTensor3.getData();
        if (shape > 0) {
            int i16 = 0;
            while (true) {
                int i17 = i16 + 1;
                if (shape3 > 0) {
                    int i18 = i14;
                    while (true) {
                        int i19 = i18 + 1;
                        if (i15 > 0) {
                            int i21 = i14;
                            while (true) {
                                int i22 = i21 + 1;
                                int i23 = i21 * shape3;
                                int i24 = (i16 * i15 * shape3) + i23 + i18;
                                int i25 = (i16 * shape2 * shape3) + i23 + i18;
                                data2[i24] = Float.MIN_VALUE;
                                if (i13 > 0) {
                                    int i26 = i14;
                                    while (true) {
                                        int i27 = i26 + 1;
                                        i12 = shape2;
                                        data2[i24] = Math.max(data2[i24], data[i25 + (i26 * shape3)]);
                                        if (i27 >= i13) {
                                            break;
                                        }
                                        i26 = i27;
                                        shape2 = i12;
                                    }
                                } else {
                                    i12 = shape2;
                                }
                                if (i22 >= i15) {
                                    break;
                                }
                                i21 = i22;
                                shape2 = i12;
                                i14 = 0;
                            }
                        } else {
                            i12 = shape2;
                        }
                        if (i19 >= shape3) {
                            break;
                        }
                        i18 = i19;
                        shape2 = i12;
                        i14 = 0;
                    }
                } else {
                    i12 = shape2;
                }
                if (i17 >= shape) {
                    break;
                }
                i16 = i17;
                shape2 = i12;
                i14 = 0;
            }
        }
        return mTensor3;
    }

    @JvmStatic
    @NotNull
    public static final MTensor mul(@NotNull MTensor mTensor, @NotNull MTensor mTensor2) {
        MTensor mTensor3 = mTensor;
        MTensor mTensor4 = mTensor2;
        Intrinsics.checkNotNullParameter(mTensor3, Param.X);
        Intrinsics.checkNotNullParameter(mTensor4, "w");
        int shape = mTensor3.getShape(0);
        int shape2 = mTensor4.getShape(0);
        int shape3 = mTensor4.getShape(1);
        MTensor mTensor5 = new MTensor(new int[]{shape, shape3});
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        float[] data3 = mTensor5.getData();
        if (shape > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (shape3 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        int i15 = (i11 * shape3) + i13;
                        data3[i15] = 0.0f;
                        if (shape2 > 0) {
                            int i16 = 0;
                            while (true) {
                                int i17 = i16 + 1;
                                data3[i15] = data3[i15] + (data[(i11 * shape2) + i16] * data2[(i16 * shape3) + i13]);
                                if (i17 >= shape2) {
                                    break;
                                }
                                i16 = i17;
                            }
                        }
                        if (i14 >= shape3) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (i12 >= shape) {
                    break;
                }
                i11 = i12;
            }
        }
        return mTensor5;
    }

    @JvmStatic
    public static final void relu(@NotNull MTensor mTensor) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        float[] data = mTensor.getData();
        int length = data.length - 1;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (data[i11] < 0.0f) {
                    data[i11] = 0.0f;
                }
                if (i12 <= length) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    @JvmStatic
    public static final void softmax(@NotNull MTensor mTensor) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        int i11 = 0;
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        float[] data = mTensor.getData();
        if (shape > 0) {
            while (true) {
                int i12 = i11 + 1;
                int i13 = i11 * shape2;
                int i14 = i13 + shape2;
                float f11 = Float.MIN_VALUE;
                if (i13 < i14) {
                    int i15 = i13;
                    while (true) {
                        int i16 = i15 + 1;
                        float f12 = data[i15];
                        if (f12 > f11) {
                            f11 = f12;
                        }
                        if (i16 >= i14) {
                            break;
                        }
                        i15 = i16;
                    }
                }
                float f13 = 0.0f;
                if (i13 < i14) {
                    int i17 = i13;
                    while (true) {
                        int i18 = i17 + 1;
                        float exp = (float) Math.exp((double) (data[i17] - f11));
                        data[i17] = exp;
                        f13 += exp;
                        if (i18 >= i14) {
                            break;
                        }
                        i17 = i18;
                    }
                }
                if (i13 < i14) {
                    while (true) {
                        int i19 = i13 + 1;
                        data[i13] = data[i13] / f13;
                        if (i19 >= i14) {
                            break;
                        }
                        i13 = i19;
                    }
                }
                if (i12 < shape) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final MTensor transpose2D(@NotNull MTensor mTensor) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        MTensor mTensor2 = new MTensor(new int[]{shape2, shape});
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        if (shape > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (shape2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        data2[(i13 * shape) + i11] = data[(i11 * shape2) + i13];
                        if (i14 >= shape2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (i12 >= shape) {
                    break;
                }
                i11 = i12;
            }
        }
        return mTensor2;
    }

    @JvmStatic
    @NotNull
    public static final MTensor transpose3D(@NotNull MTensor mTensor) {
        Intrinsics.checkNotNullParameter(mTensor, Param.X);
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        int shape3 = mTensor.getShape(2);
        MTensor mTensor2 = new MTensor(new int[]{shape3, shape2, shape});
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        if (shape > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (shape2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        if (shape3 > 0) {
                            int i15 = 0;
                            while (true) {
                                int i16 = i15 + 1;
                                data2[(i15 * shape * shape2) + (i13 * shape) + i11] = data[(i11 * shape2 * shape3) + (i13 * shape3) + i15];
                                if (i16 >= shape3) {
                                    break;
                                }
                                i15 = i16;
                            }
                        }
                        if (i14 >= shape2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (i12 >= shape) {
                    break;
                }
                i11 = i12;
            }
        }
        return mTensor2;
    }
}
