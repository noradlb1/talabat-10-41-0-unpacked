package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(@NonNull Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11);
    }

    public static void writeBigDecimal(@NonNull Parcel parcel, int i11, @NonNull BigDecimal bigDecimal, boolean z11) {
        if (bigDecimal != null) {
            int zza = zza(parcel, i11);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBigDecimalArray(@NonNull Parcel parcel, int i11, @NonNull BigDecimal[] bigDecimalArr, boolean z11) {
        if (bigDecimalArr != null) {
            int zza = zza(parcel, i11);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i12 = 0; i12 < length; i12++) {
                parcel.writeByteArray(bigDecimalArr[i12].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i12].scale());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBigInteger(@NonNull Parcel parcel, int i11, @NonNull BigInteger bigInteger, boolean z11) {
        if (bigInteger != null) {
            int zza = zza(parcel, i11);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBigIntegerArray(@NonNull Parcel parcel, int i11, @NonNull BigInteger[] bigIntegerArr, boolean z11) {
        if (bigIntegerArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBoolean(@NonNull Parcel parcel, int i11, boolean z11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static void writeBooleanArray(@NonNull Parcel parcel, int i11, @NonNull boolean[] zArr, boolean z11) {
        if (zArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBooleanList(@NonNull Parcel parcel, int i11, @NonNull List<Boolean> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(list.get(i12).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBooleanObject(@NonNull Parcel parcel, int i11, @NonNull Boolean bool, boolean z11) {
        if (bool != null) {
            zzc(parcel, i11, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBundle(@NonNull Parcel parcel, int i11, @NonNull Bundle bundle, boolean z11) {
        if (bundle != null) {
            int zza = zza(parcel, i11);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeByte(@NonNull Parcel parcel, int i11, byte b11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(b11);
    }

    public static void writeByteArray(@NonNull Parcel parcel, int i11, @NonNull byte[] bArr, boolean z11) {
        if (bArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeByteArrayArray(@NonNull Parcel parcel, int i11, @NonNull byte[][] bArr, boolean z11) {
        if (bArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeByteArraySparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<byte[]> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeByteArray(sparseArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeChar(@NonNull Parcel parcel, int i11, char c11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(c11);
    }

    public static void writeCharArray(@NonNull Parcel parcel, int i11, @NonNull char[] cArr, boolean z11) {
        if (cArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDouble(@NonNull Parcel parcel, int i11, double d11) {
        zzc(parcel, i11, 8);
        parcel.writeDouble(d11);
    }

    public static void writeDoubleArray(@NonNull Parcel parcel, int i11, @NonNull double[] dArr, boolean z11) {
        if (dArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDoubleList(@NonNull Parcel parcel, int i11, @NonNull List<Double> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeDouble(list.get(i12).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDoubleObject(@NonNull Parcel parcel, int i11, @NonNull Double d11, boolean z11) {
        if (d11 != null) {
            zzc(parcel, i11, 8);
            parcel.writeDouble(d11.doubleValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDoubleSparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<Double> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeDouble(sparseArray.valueAt(i12).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloat(@NonNull Parcel parcel, int i11, float f11) {
        zzc(parcel, i11, 4);
        parcel.writeFloat(f11);
    }

    public static void writeFloatArray(@NonNull Parcel parcel, int i11, @NonNull float[] fArr, boolean z11) {
        if (fArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloatList(@NonNull Parcel parcel, int i11, @NonNull List<Float> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeFloat(list.get(i12).floatValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloatObject(@NonNull Parcel parcel, int i11, @NonNull Float f11, boolean z11) {
        if (f11 != null) {
            zzc(parcel, i11, 4);
            parcel.writeFloat(f11.floatValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloatSparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<Float> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeFloat(sparseArray.valueAt(i12).floatValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinder(@NonNull Parcel parcel, int i11, @NonNull IBinder iBinder, boolean z11) {
        if (iBinder != null) {
            int zza = zza(parcel, i11);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinderArray(@NonNull Parcel parcel, int i11, @NonNull IBinder[] iBinderArr, boolean z11) {
        if (iBinderArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinderList(@NonNull Parcel parcel, int i11, @NonNull List<IBinder> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinderSparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<IBinder> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeStrongBinder(sparseArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeInt(@NonNull Parcel parcel, int i11, int i12) {
        zzc(parcel, i11, 4);
        parcel.writeInt(i12);
    }

    public static void writeIntArray(@NonNull Parcel parcel, int i11, @NonNull int[] iArr, boolean z11) {
        if (iArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIntegerList(@NonNull Parcel parcel, int i11, @NonNull List<Integer> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(list.get(i12).intValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIntegerObject(@NonNull Parcel parcel, int i11, @NonNull Integer num, boolean z11) {
        if (num != null) {
            zzc(parcel, i11, 4);
            parcel.writeInt(num.intValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeList(@NonNull Parcel parcel, int i11, @NonNull List list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            parcel.writeList(list);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeLong(@NonNull Parcel parcel, int i11, long j11) {
        zzc(parcel, i11, 8);
        parcel.writeLong(j11);
    }

    public static void writeLongArray(@NonNull Parcel parcel, int i11, @NonNull long[] jArr, boolean z11) {
        if (jArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeLongList(@NonNull Parcel parcel, int i11, @NonNull List<Long> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeLong(list.get(i12).longValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeLongObject(@NonNull Parcel parcel, int i11, @NonNull Long l11, boolean z11) {
        if (l11 != null) {
            zzc(parcel, i11, 8);
            parcel.writeLong(l11.longValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcel(@NonNull Parcel parcel, int i11, @NonNull Parcel parcel2, boolean z11) {
        if (parcel2 != null) {
            int zza = zza(parcel, i11);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelArray(@NonNull Parcel parcel, int i11, @NonNull Parcel[] parcelArr, boolean z11) {
        if (parcelArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelList(@NonNull Parcel parcel, int i11, @NonNull List<Parcel> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                Parcel parcel2 = list.get(i12);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelSparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<Parcel> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                Parcel valueAt = sparseArray.valueAt(i12);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelable(@NonNull Parcel parcel, int i11, @NonNull Parcelable parcelable, int i12, boolean z11) {
        if (parcelable != null) {
            int zza = zza(parcel, i11);
            parcelable.writeToParcel(parcel, i12);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writePendingIntent(@NonNull Parcel parcel, int i11, @NonNull PendingIntent pendingIntent, boolean z11) {
        if (pendingIntent != null) {
            int zza = zza(parcel, i11);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeShort(@NonNull Parcel parcel, int i11, short s11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(s11);
    }

    public static void writeSparseBooleanArray(@NonNull Parcel parcel, int i11, @NonNull SparseBooleanArray sparseBooleanArray, boolean z11) {
        if (sparseBooleanArray != null) {
            int zza = zza(parcel, i11);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeSparseIntArray(@NonNull Parcel parcel, int i11, @NonNull SparseIntArray sparseIntArray, boolean z11) {
        if (sparseIntArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseIntArray.keyAt(i12));
                parcel.writeInt(sparseIntArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeSparseLongArray(@NonNull Parcel parcel, int i11, @NonNull SparseLongArray sparseLongArray, boolean z11) {
        if (sparseLongArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseLongArray.keyAt(i12));
                parcel.writeLong(sparseLongArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeString(@NonNull Parcel parcel, int i11, @NonNull String str, boolean z11) {
        if (str != null) {
            int zza = zza(parcel, i11);
            parcel.writeString(str);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeStringArray(@NonNull Parcel parcel, int i11, @NonNull String[] strArr, boolean z11) {
        if (strArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeStringList(@NonNull Parcel parcel, int i11, @NonNull List<String> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeStringSparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<String> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeString(sparseArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel parcel, int i11, @NonNull T[] tArr, int i12, boolean z11) {
        if (tArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r7);
            for (T t11 : tArr) {
                if (t11 == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, t11, i12);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(@NonNull Parcel parcel, int i11, @NonNull List<T> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                Parcelable parcelable = (Parcelable) list.get(i12);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel parcel, int i11, @NonNull SparseArray<T> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i12);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    private static int zza(Parcel parcel, int i11) {
        parcel.writeInt(i11 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i11) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i11 - 4);
        parcel.writeInt(dataPosition - i11);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i11, int i12) {
        parcel.writeInt(i11 | (i12 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i11) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i11);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
