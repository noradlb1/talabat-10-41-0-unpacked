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
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    @NonNull
    public static BigDecimal createBigDecimal(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + readSize);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    @NonNull
    public static BigDecimal[] createBigDecimalArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i12] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigDecimalArr;
    }

    @NonNull
    public static BigInteger createBigInteger(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return new BigInteger(createByteArray);
    }

    @NonNull
    public static BigInteger[] createBigIntegerArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigIntegerArr;
    }

    @NonNull
    public static boolean[] createBooleanArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createBooleanArray;
    }

    @NonNull
    public static ArrayList<Boolean> createBooleanList(@NonNull Parcel parcel, int i11) {
        boolean z11;
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            if (parcel.readInt() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            arrayList.add(Boolean.valueOf(z11));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @NonNull
    public static Bundle createBundle(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + readSize);
        return readBundle;
    }

    @NonNull
    public static byte[] createByteArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createByteArray;
    }

    @NonNull
    public static byte[][] createByteArrayArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i12 = 0; i12 < readInt; i12++) {
            bArr[i12] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bArr;
    }

    @NonNull
    public static SparseArray<byte[]> createByteArraySparseArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @NonNull
    public static char[] createCharArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createCharArray;
    }

    @NonNull
    public static double[] createDoubleArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createDoubleArray;
    }

    @NonNull
    public static ArrayList<Double> createDoubleList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @NonNull
    public static SparseArray<Double> createDoubleSparseArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @NonNull
    public static float[] createFloatArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createFloatArray;
    }

    @NonNull
    public static ArrayList<Float> createFloatList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @NonNull
    public static SparseArray<Float> createFloatSparseArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @NonNull
    public static IBinder[] createIBinderArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createBinderArray;
    }

    @NonNull
    public static ArrayList<IBinder> createIBinderList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(dataPosition + readSize);
        return createBinderArrayList;
    }

    @NonNull
    public static SparseArray<IBinder> createIBinderSparseArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @NonNull
    public static int[] createIntArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createIntArray;
    }

    @NonNull
    public static ArrayList<Integer> createIntegerList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @NonNull
    public static long[] createLongArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createLongArray;
    }

    @NonNull
    public static ArrayList<Long> createLongList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @NonNull
    public static Parcel createParcel(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(dataPosition + readSize);
        return obtain;
    }

    @NonNull
    public static Parcel[] createParcelArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i12] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i12] = null;
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return parcelArr;
    }

    @NonNull
    public static ArrayList<Parcel> createParcelList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                arrayList.add((Object) null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @NonNull
    public static SparseArray<Parcel> createParcelSparseArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray.append(readInt2, (Object) null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @NonNull
    public static <T extends Parcelable> T createParcelable(@NonNull Parcel parcel, int i11, @NonNull Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T t11 = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return t11;
    }

    @NonNull
    public static SparseBooleanArray createSparseBooleanArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(dataPosition + readSize);
        return readSparseBooleanArray;
    }

    @NonNull
    public static SparseIntArray createSparseIntArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseIntArray;
    }

    @NonNull
    public static SparseLongArray createSparseLongArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseLongArray;
    }

    @NonNull
    public static String createString(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    @NonNull
    public static String[] createStringArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArray;
    }

    @NonNull
    public static ArrayList<String> createStringList(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArrayList;
    }

    @NonNull
    public static SparseArray<String> createStringSparseArray(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @NonNull
    public static <T> T[] createTypedArray(@NonNull Parcel parcel, int i11, @NonNull Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArray;
    }

    @NonNull
    public static <T> ArrayList<T> createTypedList(@NonNull Parcel parcel, int i11, @NonNull Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArrayList;
    }

    @NonNull
    public static <T> SparseArray<T> createTypedSparseArray(@NonNull Parcel parcel, int i11, @NonNull Parcelable.Creator<T> creator) {
        T t11;
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<T> sparseArray = new SparseArray<>();
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            if (parcel.readInt() != 0) {
                t11 = creator.createFromParcel(parcel);
            } else {
                t11 = null;
            }
            sparseArray.append(readInt2, t11);
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static void ensureAtEnd(@NonNull Parcel parcel, int i11) {
        if (parcel.dataPosition() != i11) {
            throw new ParseException("Overread allowed size end=" + i11, parcel);
        }
    }

    public static int getFieldId(int i11) {
        return (char) i11;
    }

    public static boolean readBoolean(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Boolean readBooleanObject(@NonNull Parcel parcel, int i11) {
        boolean z11;
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i11, readSize, 4);
        if (parcel.readInt() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public static byte readByte(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 4);
        return (byte) parcel.readInt();
    }

    public static char readChar(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 4);
        return (char) parcel.readInt();
    }

    public static double readDouble(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 8);
        return parcel.readDouble();
    }

    @NonNull
    public static Double readDoubleObject(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i11, readSize, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 4);
        return parcel.readFloat();
    }

    @NonNull
    public static Float readFloatObject(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i11, readSize, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(@NonNull Parcel parcel) {
        return parcel.readInt();
    }

    @NonNull
    public static IBinder readIBinder(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + readSize);
        return readStrongBinder;
    }

    public static int readInt(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 4);
        return parcel.readInt();
    }

    @NonNull
    public static Integer readIntegerObject(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i11, readSize, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void readList(@NonNull Parcel parcel, int i11, @NonNull List list, @NonNull ClassLoader classLoader) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(dataPosition + readSize);
        }
    }

    public static long readLong(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 8);
        return parcel.readLong();
    }

    @NonNull
    public static Long readLongObject(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i11, readSize, 8);
        return Long.valueOf(parcel.readLong());
    }

    @NonNull
    public static PendingIntent readPendingIntent(@NonNull Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        PendingIntent readPendingIntentOrNullFromParcel = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return readPendingIntentOrNullFromParcel;
    }

    public static short readShort(@NonNull Parcel parcel, int i11) {
        zzb(parcel, i11, 4);
        return (short) parcel.readInt();
    }

    public static int readSize(@NonNull Parcel parcel, int i11) {
        return (i11 & -65536) != -65536 ? (char) (i11 >> 16) : parcel.readInt();
    }

    public static void skipUnknownField(@NonNull Parcel parcel, int i11) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i11));
    }

    public static int validateObjectHeader(@NonNull Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int fieldId = getFieldId(readHeader);
        int dataPosition = parcel.dataPosition();
        if (fieldId == 20293) {
            int i11 = readSize + dataPosition;
            if (i11 >= dataPosition && i11 <= parcel.dataSize()) {
                return i11;
            }
            throw new ParseException("Size read is invalid start=" + dataPosition + " end=" + i11, parcel);
        }
        throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readHeader))), parcel);
    }

    private static void zza(Parcel parcel, int i11, int i12, int i13) {
        if (i12 != i13) {
            String hexString = Integer.toHexString(i12);
            throw new ParseException("Expected size " + i13 + " got " + i12 + " (0x" + hexString + ")", parcel);
        }
    }

    private static void zzb(Parcel parcel, int i11, int i12) {
        int readSize = readSize(parcel, i11);
        if (readSize != i12) {
            String hexString = Integer.toHexString(readSize);
            throw new ParseException("Expected size " + i12 + " got " + readSize + " (0x" + hexString + ")", parcel);
        }
    }
}
