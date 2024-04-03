package com.huawei.hms.common.parcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class ParcelWrite {

    /* renamed from: a  reason: collision with root package name */
    private static final int f48205a = 65262;

    /* renamed from: b  reason: collision with root package name */
    private Parcel f48206b;

    public ParcelWrite(Parcel parcel) {
        this.f48206b = parcel;
    }

    private int a(int i11) {
        this.f48206b.writeInt(i11 | -65536);
        this.f48206b.writeInt(0);
        return this.f48206b.dataPosition();
    }

    private void a(int i11, int i12) {
        if (i12 >= 65535) {
            this.f48206b.writeInt(i11 | -65536);
            this.f48206b.writeInt(i12);
            return;
        }
        this.f48206b.writeInt(i11 | (i12 << 16));
    }

    private <T extends Parcelable> void a(T t11, int i11) {
        int dataPosition = this.f48206b.dataPosition();
        this.f48206b.writeInt(1);
        int dataPosition2 = this.f48206b.dataPosition();
        t11.writeToParcel(this.f48206b, i11);
        int dataPosition3 = this.f48206b.dataPosition();
        this.f48206b.setDataPosition(dataPosition);
        this.f48206b.writeInt(dataPosition3 - dataPosition2);
        this.f48206b.setDataPosition(dataPosition3);
    }

    private void b(int i11) {
        int dataPosition = this.f48206b.dataPosition();
        this.f48206b.setDataPosition(i11 - 4);
        this.f48206b.writeInt(dataPosition - i11);
        this.f48206b.setDataPosition(dataPosition);
    }

    public int beginObjectHeader() {
        return a(f48205a);
    }

    public void finishObjectHeader(int i11) {
        b(i11);
    }

    public void writeBigDecimal(int i11, BigDecimal bigDecimal, boolean z11) {
        if (bigDecimal != null) {
            int a11 = a(i11);
            this.f48206b.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.f48206b.writeInt(bigDecimal.scale());
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBigDecimalArray(int i11, BigDecimal[] bigDecimalArr, boolean z11) {
        if (bigDecimalArr != null) {
            int a11 = a(i11);
            int length = bigDecimalArr.length;
            this.f48206b.writeInt(length);
            for (int i12 = 0; i12 < length; i12++) {
                this.f48206b.writeByteArray(bigDecimalArr[i12].unscaledValue().toByteArray());
                this.f48206b.writeInt(bigDecimalArr[i12].scale());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBigInteger(int i11, BigInteger bigInteger, boolean z11) {
        if (bigInteger != null) {
            int a11 = a(i11);
            this.f48206b.writeByteArray(bigInteger.toByteArray());
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBigIntegerArray(int i11, BigInteger[] bigIntegerArr, boolean z11) {
        if (bigIntegerArr != null) {
            int a11 = a(i11);
            this.f48206b.writeInt(r6);
            for (BigInteger byteArray : bigIntegerArr) {
                this.f48206b.writeByteArray(byteArray.toByteArray());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBoolean(int i11, boolean z11) {
        a(i11, 4);
        this.f48206b.writeInt(z11 ? 1 : 0);
    }

    public void writeBooleanArray(int i11, boolean[] zArr, boolean z11) {
        if (zArr != null) {
            int a11 = a(i11);
            this.f48206b.writeBooleanArray(zArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBooleanList(int i11, List<Boolean> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(list.get(i12).booleanValue() ? 1 : 0);
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBooleanObject(int i11, Boolean bool) {
        writeBooleanObject(i11, bool, false);
    }

    public void writeBooleanObject(int i11, Boolean bool, boolean z11) {
        if (bool != null) {
            a(i11, 4);
            this.f48206b.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeBundle(int i11, Bundle bundle, boolean z11) {
        if (bundle != null) {
            int a11 = a(i11);
            this.f48206b.writeBundle(bundle);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeByte(int i11, byte b11) {
        a(i11, 4);
        this.f48206b.writeInt(b11);
    }

    public void writeByteArray(int i11, byte[] bArr, boolean z11) {
        if (bArr != null) {
            int a11 = a(i11);
            this.f48206b.writeByteArray(bArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeByteArrayArray(int i11, byte[][] bArr, boolean z11) {
        if (bArr != null) {
            int a11 = a(i11);
            this.f48206b.writeInt(r6);
            for (byte[] writeByteArray : bArr) {
                this.f48206b.writeByteArray(writeByteArray);
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeByteArraySparseArray(int i11, SparseArray<byte[]> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                this.f48206b.writeByteArray(sparseArray.valueAt(i12));
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeChar(int i11, char c11) {
        a(i11, 4);
        this.f48206b.writeInt(c11);
    }

    public void writeCharArray(int i11, char[] cArr, boolean z11) {
        if (cArr != null) {
            int a11 = a(i11);
            this.f48206b.writeCharArray(cArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeDouble(int i11, double d11) {
        a(i11, 8);
        this.f48206b.writeDouble(d11);
    }

    public void writeDoubleArray(int i11, double[] dArr, boolean z11) {
        if (dArr != null) {
            int a11 = a(i11);
            this.f48206b.writeDoubleArray(dArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeDoubleList(int i11, List<Double> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeDouble(list.get(i12).doubleValue());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeDoubleObject(int i11, Double d11, boolean z11) {
        if (d11 != null) {
            a(i11, 8);
            this.f48206b.writeDouble(d11.doubleValue());
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeDoubleSparseArray(int i11, SparseArray<Double> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                this.f48206b.writeDouble(sparseArray.valueAt(i12).doubleValue());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeFloat(int i11, float f11) {
        a(i11, 4);
        this.f48206b.writeFloat(f11);
    }

    public void writeFloatArray(int i11, float[] fArr, boolean z11) {
        if (fArr != null) {
            int a11 = a(i11);
            this.f48206b.writeFloatArray(fArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeFloatList(int i11, List<Float> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeFloat(list.get(i12).floatValue());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeFloatObject(int i11, Float f11, boolean z11) {
        if (f11 != null) {
            a(i11, 4);
            this.f48206b.writeFloat(f11.floatValue());
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeFloatSparseArray(int i11, SparseArray<Float> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                this.f48206b.writeFloat(sparseArray.valueAt(i12).floatValue());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeIBinder(int i11, IBinder iBinder, boolean z11) {
        if (iBinder != null) {
            int a11 = a(i11);
            this.f48206b.writeStrongBinder(iBinder);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeIBinderArray(int i11, IBinder[] iBinderArr, boolean z11) {
        if (iBinderArr != null) {
            int a11 = a(i11);
            this.f48206b.writeBinderArray(iBinderArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeIBinderList(int i11, List<IBinder> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            this.f48206b.writeBinderList(list);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeIBinderSparseArray(int i11, SparseArray<IBinder> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                this.f48206b.writeStrongBinder(sparseArray.valueAt(i12));
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeInt(int i11, int i12) {
        a(i11, 4);
        this.f48206b.writeInt(i12);
    }

    public void writeIntArray(int i11, int[] iArr, boolean z11) {
        if (iArr != null) {
            int a11 = a(i11);
            this.f48206b.writeIntArray(iArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeIntegerList(int i11, List<Integer> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(list.get(i12).intValue());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeIntegerObject(int i11, Integer num, boolean z11) {
        if (num != null) {
            a(i11, 4);
            this.f48206b.writeInt(num.intValue());
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeList(int i11, List list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            this.f48206b.writeList(list);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeLong(int i11, long j11) {
        a(i11, 8);
        this.f48206b.writeLong(j11);
    }

    public void writeLongArray(int i11, long[] jArr, boolean z11) {
        if (jArr != null) {
            int a11 = a(i11);
            this.f48206b.writeLongArray(jArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeLongList(int i11, List<Long> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeLong(list.get(i12).longValue());
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeLongObject(int i11, Long l11, boolean z11) {
        if (l11 != null) {
            a(i11, 8);
            this.f48206b.writeLong(l11.longValue());
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeParcel(int i11, Parcel parcel, boolean z11) {
        if (parcel != null) {
            int a11 = a(i11);
            this.f48206b.appendFrom(parcel, 0, parcel.dataSize());
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeParcelArray(int i11, Parcel[] parcelArr, boolean z11) {
        if (parcelArr != null) {
            int a11 = a(i11);
            this.f48206b.writeInt(r8);
            for (Parcel parcel : parcelArr) {
                if (parcel != null) {
                    this.f48206b.writeInt(parcel.dataSize());
                    this.f48206b.appendFrom(parcel, 0, parcel.dataSize());
                } else {
                    this.f48206b.writeInt(0);
                }
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeParcelList(int i11, List<Parcel> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                Parcel parcel = list.get(i12);
                if (parcel != null) {
                    this.f48206b.writeInt(parcel.dataSize());
                    this.f48206b.appendFrom(parcel, 0, parcel.dataSize());
                } else {
                    this.f48206b.writeInt(0);
                }
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeParcelSparseArray(int i11, SparseArray<Parcel> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                Parcel valueAt = sparseArray.valueAt(i12);
                if (valueAt != null) {
                    this.f48206b.writeInt(valueAt.dataSize());
                    this.f48206b.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    this.f48206b.writeInt(0);
                }
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeParcelable(int i11, Parcelable parcelable, int i12, boolean z11) {
        if (parcelable != null) {
            int a11 = a(i11);
            parcelable.writeToParcel(this.f48206b, i12);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeShort(int i11, short s11) {
        a(i11, 4);
        this.f48206b.writeInt(s11);
    }

    public void writeSparseBooleanArray(int i11, SparseBooleanArray sparseBooleanArray, boolean z11) {
        if (sparseBooleanArray != null) {
            int a11 = a(i11);
            this.f48206b.writeSparseBooleanArray(sparseBooleanArray);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeSparseIntArray(int i11, SparseIntArray sparseIntArray, boolean z11) {
        if (sparseIntArray != null) {
            int a11 = a(i11);
            int size = sparseIntArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseIntArray.keyAt(i12));
                this.f48206b.writeInt(sparseIntArray.valueAt(i12));
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeSparseLongArray(int i11, SparseLongArray sparseLongArray, boolean z11) {
        if (sparseLongArray != null) {
            int a11 = a(i11);
            int size = sparseLongArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseLongArray.keyAt(i12));
                this.f48206b.writeLong(sparseLongArray.valueAt(i12));
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeString(int i11, String str, boolean z11) {
        if (str != null) {
            int a11 = a(i11);
            this.f48206b.writeString(str);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeStringArray(int i11, String[] strArr, boolean z11) {
        if (strArr != null) {
            int a11 = a(i11);
            this.f48206b.writeStringArray(strArr);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeStringList(int i11, List<String> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            this.f48206b.writeStringList(list);
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public void writeStringSparseArray(int i11, SparseArray<String> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                this.f48206b.writeString(sparseArray.valueAt(i12));
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public <T extends Parcelable> void writeTypedArray(int i11, T[] tArr, int i12, boolean z11) {
        if (tArr != null) {
            int a11 = a(i11);
            this.f48206b.writeInt(r7);
            for (T t11 : tArr) {
                if (t11 == null) {
                    this.f48206b.writeInt(0);
                } else {
                    a(t11, i12);
                }
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public <T extends Parcelable> void writeTypedList(int i11, List<T> list, boolean z11) {
        if (list != null) {
            int a11 = a(i11);
            int size = list.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                Parcelable parcelable = (Parcelable) list.get(i12);
                if (parcelable == null) {
                    this.f48206b.writeInt(0);
                } else {
                    a(parcelable, 0);
                }
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i11, SparseArray<T> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int a11 = a(i11);
            int size = sparseArray.size();
            this.f48206b.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                this.f48206b.writeInt(sparseArray.keyAt(i12));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i12);
                if (parcelable == null) {
                    this.f48206b.writeInt(0);
                } else {
                    a(parcelable, 0);
                }
            }
            b(a11);
        } else if (z11) {
            a(i11, 0);
        }
    }
}
