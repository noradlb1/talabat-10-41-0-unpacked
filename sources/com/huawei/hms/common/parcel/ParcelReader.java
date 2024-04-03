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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParcelReader {

    /* renamed from: a  reason: collision with root package name */
    private static final int f48199a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f48200b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f48201c = 65262;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Integer, Integer[]> f48202d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Parcel f48203e;

    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.f48203e = parcel;
        a();
    }

    private int a(int i11) {
        if (i11 < 0) {
            return 0;
        }
        if (i11 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i11;
    }

    private void a() {
        int readInt = this.f48203e.readInt();
        int i11 = readInt & 65535;
        int readInt2 = (readInt & -65536) != -65536 ? (readInt >> 16) & 65535 : this.f48203e.readInt();
        if (i11 == f48201c) {
            int dataPosition = this.f48203e.dataPosition();
            int i12 = readInt2 + dataPosition;
            if (i12 < dataPosition || i12 > this.f48203e.dataSize()) {
                throw new ParseException("invalid size, start=" + dataPosition + " end=" + i12, this.f48203e);
            }
            while (this.f48203e.dataPosition() < i12) {
                int readInt3 = this.f48203e.readInt();
                int i13 = readInt3 & 65535;
                int readInt4 = (readInt3 & -65536) != -65536 ? (readInt3 >> 16) & 65535 : this.f48203e.readInt();
                int dataPosition2 = this.f48203e.dataPosition();
                this.f48202d.put(Integer.valueOf(i13), new Integer[]{Integer.valueOf(dataPosition2), Integer.valueOf(readInt4)});
                this.f48203e.setDataPosition(dataPosition2 + readInt4);
            }
            if (this.f48203e.dataPosition() != i12) {
                throw new ParseException("the dataPosition is not" + i12, this.f48203e);
            }
            return;
        }
        String hexString = Integer.toHexString(i11);
        throw new ParseException("Parse header error, not 65262. Got 0x" + hexString, this.f48203e);
    }

    private void a(int i11, int i12) {
        Integer[] numArr = this.f48202d.get(Integer.valueOf(i11));
        if (numArr != null) {
            int intValue = numArr[1].intValue();
            if (intValue != i12) {
                String hexString = Integer.toHexString(intValue);
                throw new ParseException("the field size is not " + i12 + " got " + intValue + " (0x" + hexString + ")", this.f48203e);
            }
            return;
        }
        throw new ParseException("Field is null:" + numArr, this.f48203e);
    }

    private int b(int i11) {
        Integer[] numArr = this.f48202d.get(Integer.valueOf(i11));
        if (numArr != null) {
            this.f48203e.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:" + numArr, this.f48203e);
    }

    private int b(int i11, int i12) {
        Integer[] numArr = this.f48202d.get(Integer.valueOf(i11));
        if (numArr != null) {
            this.f48203e.setDataPosition(numArr[0].intValue());
            a(i11, i12);
            return i12;
        }
        throw new ParseException("Field is null:" + numArr, this.f48203e);
    }

    public BigDecimal createBigDecimal(int i11, BigDecimal bigDecimal) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bigDecimal;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        byte[] createByteArray = this.f48203e.createByteArray();
        int readInt = this.f48203e.readInt();
        this.f48203e.setDataPosition(dataPosition + b11);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public BigDecimal[] createBigDecimalArray(int i11, BigDecimal[] bigDecimalArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bigDecimalArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[a11];
        for (int i12 = 0; i12 < a11; i12++) {
            byte[] createByteArray = this.f48203e.createByteArray();
            bigDecimalArr2[i12] = new BigDecimal(new BigInteger(createByteArray), this.f48203e.readInt());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i11, BigInteger bigInteger) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bigInteger;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        byte[] createByteArray = this.f48203e.createByteArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return new BigInteger(createByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i11, BigInteger[] bigIntegerArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bigIntegerArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[a11];
        for (int i12 = 0; i12 < a11; i12++) {
            bigIntegerArr2[i12] = new BigInteger(this.f48203e.createByteArray());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i11, boolean[] zArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return zArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        boolean[] createBooleanArray = this.f48203e.createBooleanArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i11, ArrayList<Boolean> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            arrayList2.add(Boolean.valueOf(this.f48203e.readInt() != 0));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return arrayList2;
    }

    public byte[] createByteArray(int i11, byte[] bArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        byte[] createByteArray = this.f48203e.createByteArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createByteArray;
    }

    public byte[][] createByteArrayArray(int i11, byte[][] bArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        byte[][] bArr2 = new byte[a11][];
        for (int i12 = 0; i12 < a11; i12++) {
            bArr2[i12] = this.f48203e.createByteArray();
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i11, SparseArray<byte[]> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(a11);
        for (int i12 = 0; i12 < a11; i12++) {
            sparseArray2.append(this.f48203e.readInt(), this.f48203e.createByteArray());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public char[] createCharArray(int i11, char[] cArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return cArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        char[] createCharArray = this.f48203e.createCharArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createCharArray;
    }

    public double[] createDoubleArray(int i11, double[] dArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return dArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        double[] createDoubleArray = this.f48203e.createDoubleArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i11, ArrayList<Double> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            arrayList2.add(Double.valueOf(this.f48203e.readDouble()));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i11, SparseArray<Double> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            sparseArray2.append(this.f48203e.readInt(), Double.valueOf(this.f48203e.readDouble()));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public float[] createFloatArray(int i11, float[] fArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return fArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        float[] createFloatArray = this.f48203e.createFloatArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createFloatArray;
    }

    public ArrayList<Float> createFloatList(int i11, ArrayList<Float> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            arrayList2.add(Float.valueOf(this.f48203e.readFloat()));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i11, SparseArray<Float> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            sparseArray2.append(this.f48203e.readInt(), Float.valueOf(this.f48203e.readFloat()));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i11, IBinder[] iBinderArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return iBinderArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        IBinder[] createBinderArray = this.f48203e.createBinderArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i11, ArrayList<IBinder> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<IBinder> createBinderArrayList = this.f48203e.createBinderArrayList();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i11, SparseArray<IBinder> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(a11);
        for (int i12 = 0; i12 < a11; i12++) {
            sparseArray2.append(this.f48203e.readInt(), this.f48203e.readStrongBinder());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public int[] createIntArray(int i11, int[] iArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return iArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int[] createIntArray = this.f48203e.createIntArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i11, ArrayList<Integer> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            arrayList2.add(Integer.valueOf(this.f48203e.readInt()));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return arrayList2;
    }

    public long[] createLongArray(int i11, long[] jArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return jArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        long[] createLongArray = this.f48203e.createLongArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createLongArray;
    }

    public ArrayList<Long> createLongList(int i11, ArrayList<Long> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            arrayList2.add(Long.valueOf(this.f48203e.readLong()));
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return arrayList2;
    }

    public Parcel createParcel(int i11, Parcel parcel) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return parcel;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(this.f48203e, dataPosition, b11);
        this.f48203e.setDataPosition(dataPosition + b11);
        return obtain;
    }

    public Parcel[] createParcelArray(int i11, Parcel[] parcelArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return parcelArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        Parcel[] parcelArr2 = new Parcel[a11];
        for (int i12 = 0; i12 < a11; i12++) {
            int readInt = this.f48203e.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.f48203e.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f48203e, dataPosition2, readInt);
                parcelArr2[i12] = obtain;
                this.f48203e.setDataPosition(dataPosition2 + readInt);
            } else {
                parcelArr2[i12] = null;
            }
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i11, ArrayList<Parcel> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i12 = 0; i12 < a11; i12++) {
            int readInt = this.f48203e.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.f48203e.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f48203e, dataPosition2, readInt);
                arrayList2.add(obtain);
                this.f48203e.setDataPosition(dataPosition2 + readInt);
            } else {
                arrayList2.add((Object) null);
            }
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i11, SparseArray<Parcel> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i12 = 0; i12 < a11; i12++) {
            int readInt = this.f48203e.readInt();
            int readInt2 = this.f48203e.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = this.f48203e.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f48203e, dataPosition2, readInt2);
                sparseArray2.append(readInt, obtain);
                this.f48203e.setDataPosition(dataPosition2 + readInt2);
            } else {
                sparseArray2.append(readInt, (Object) null);
            }
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i11, SparseBooleanArray sparseBooleanArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseBooleanArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        SparseBooleanArray readSparseBooleanArray = this.f48203e.readSparseBooleanArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return readSparseBooleanArray;
    }

    public SparseIntArray createSparseIntArray(int i11, SparseIntArray sparseIntArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseIntArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            sparseIntArray2.append(this.f48203e.readInt(), this.f48203e.readInt());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i11, SparseLongArray sparseLongArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseLongArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            sparseLongArray2.append(this.f48203e.readInt(), this.f48203e.readLong());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseLongArray2;
    }

    public String createString(int i11, String str) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return str;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        String readString = this.f48203e.readString();
        this.f48203e.setDataPosition(dataPosition + b11);
        return readString;
    }

    public String[] createStringArray(int i11, String[] strArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return strArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        String[] createStringArray = this.f48203e.createStringArray();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createStringArray;
    }

    public ArrayList<String> createStringList(int i11, ArrayList<String> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<String> createStringArrayList = this.f48203e.createStringArrayList();
        this.f48203e.setDataPosition(dataPosition + b11);
        return createStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i11, SparseArray<String> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int a11 = a(this.f48203e.readInt());
        for (int i12 = 0; i12 < a11; i12++) {
            sparseArray2.append(this.f48203e.readInt(), this.f48203e.readString());
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i11, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return tArr;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        T[] createTypedArray = this.f48203e.createTypedArray(creator);
        this.f48203e.setDataPosition(dataPosition + b11);
        return createTypedArray;
    }

    public <T> ArrayList<T> createTypedList(int i11, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return arrayList;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        ArrayList<T> createTypedArrayList = this.f48203e.createTypedArrayList(creator);
        this.f48203e.setDataPosition(dataPosition + b11);
        return createTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i11, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return sparseArray;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        int a11 = a(this.f48203e.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i12 = 0; i12 < a11; i12++) {
            sparseArray2.append(this.f48203e.readInt(), this.f48203e.readInt() != 0 ? creator.createFromParcel(this.f48203e) : null);
        }
        this.f48203e.setDataPosition(dataPosition + b11);
        return sparseArray2;
    }

    public boolean readBoolean(int i11, boolean z11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return z11;
        }
        b(i11, 4);
        return this.f48203e.readInt() != 0;
    }

    public Boolean readBooleanObject(int i11, Boolean bool) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bool;
        }
        if (b(i11) == 0) {
            return null;
        }
        a(i11, 4);
        int readInt = this.f48203e.readInt();
        if (readInt == 0) {
            return Boolean.FALSE;
        }
        if (readInt != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i11, Bundle bundle) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return bundle;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        Bundle readBundle = this.f48203e.readBundle();
        this.f48203e.setDataPosition(dataPosition + b11);
        return readBundle;
    }

    public byte readByte(int i11, byte b11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return b11;
        }
        b(i11, 4);
        return (byte) this.f48203e.readInt();
    }

    public char readChar(int i11, char c11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return c11;
        }
        b(i11, 4);
        return (char) this.f48203e.readInt();
    }

    public double readDouble(int i11, double d11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return d11;
        }
        b(i11, 8);
        return this.f48203e.readDouble();
    }

    public Double readDoubleObject(int i11, Double d11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return d11;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        a(b11, 8);
        return Double.valueOf(this.f48203e.readDouble());
    }

    public float readFloat(int i11, float f11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return f11;
        }
        b(i11, 4);
        return this.f48203e.readFloat();
    }

    public Float readFloatObject(int i11, Float f11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return f11;
        }
        if (b(i11) == 0) {
            return null;
        }
        a(i11, 4);
        return Float.valueOf(this.f48203e.readFloat());
    }

    public IBinder readIBinder(int i11, IBinder iBinder) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return iBinder;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        IBinder readStrongBinder = this.f48203e.readStrongBinder();
        this.f48203e.setDataPosition(dataPosition + b11);
        return readStrongBinder;
    }

    public int readInt(int i11, int i12) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return i12;
        }
        b(i11, 4);
        return this.f48203e.readInt();
    }

    public Integer readIntegerObject(int i11, Integer num) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return num;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        a(b11, 4);
        return Integer.valueOf(this.f48203e.readInt());
    }

    public void readList(int i11, List list, ClassLoader classLoader) {
        if (this.f48202d.containsKey(Integer.valueOf(i11))) {
            int b11 = b(i11);
            int dataPosition = this.f48203e.dataPosition();
            if (b11 != 0) {
                this.f48203e.readList(list, classLoader);
                this.f48203e.setDataPosition(dataPosition + b11);
            }
        }
    }

    public long readLong(int i11, long j11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return j11;
        }
        b(i11, 8);
        return this.f48203e.readLong();
    }

    public Long readLongObject(int i11, Long l11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return l11;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        a(b11, 8);
        return Long.valueOf(this.f48203e.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i11, Parcelable.Creator<T> creator, T t11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return t11;
        }
        int b11 = b(i11);
        if (b11 == 0) {
            return null;
        }
        int dataPosition = this.f48203e.dataPosition();
        T t12 = (Parcelable) creator.createFromParcel(this.f48203e);
        this.f48203e.setDataPosition(dataPosition + b11);
        return t12;
    }

    public short readShort(int i11, short s11) {
        if (!this.f48202d.containsKey(Integer.valueOf(i11))) {
            return s11;
        }
        b(i11, 4);
        return (short) this.f48203e.readInt();
    }
}
