package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayMap<String, Method> f37897a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<String, Method> f37898b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayMap<String, Class> f37899c;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f37897a = arrayMap;
        this.f37898b = arrayMap2;
        this.f37899c = arrayMap3;
    }

    private Exception createException(int i11, String str) {
        switch (i11) {
            case -9:
                return (Exception) readParcelable();
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
            default:
                return new RuntimeException("Unknown exception code: " + i11 + " msg " + str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.f37899c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f37899c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f37897a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f37897a.put(str, declaredMethod);
        return declaredMethod;
    }

    private <T> int getType(T t11) {
        if (t11 instanceof String) {
            return 4;
        }
        if (t11 instanceof Parcelable) {
            return 2;
        }
        if (t11 instanceof VersionedParcelable) {
            return 1;
        }
        if (t11 instanceof Serializable) {
            return 3;
        }
        if (t11 instanceof IBinder) {
            return 5;
        }
        if (t11 instanceof Integer) {
            return 7;
        }
        if (t11 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t11.getClass().getName() + " cannot be VersionedParcelled");
    }

    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f37898b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.f37898b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s11) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s11.add(k());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s11.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s11.add(j());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s11.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s11.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s11;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i11) {
        setOutputField(i11);
        writeCollection(collection);
    }

    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e11);
        }
    }

    public abstract VersionedParcel a();

    public <T> T[] b(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(k());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(j());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return arrayList.toArray(tArr);
    }

    public boolean[] c() {
        boolean z11;
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            if (readInt() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zArr[i11] = z11;
        }
        return zArr;
    }

    public abstract void closeField();

    public abstract CharSequence d();

    public double[] e() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            dArr[i11] = readDouble();
        }
        return dArr;
    }

    public float[] f() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            fArr[i11] = readFloat();
        }
        return fArr;
    }

    public <T extends VersionedParcelable> T g(String str, VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable) getReadMethod(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (ClassNotFoundException e14) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e14);
        }
    }

    public int[] h() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            iArr[i11] = readInt();
        }
        return iArr;
    }

    public long[] i() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            jArr[i11] = readLong();
        }
        return jArr;
    }

    public boolean isStream() {
        return false;
    }

    public Serializable j() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) {
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    if (cls != null) {
                        return cls;
                    }
                    return super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e11) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e11);
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e12);
        }
    }

    public <T extends VersionedParcelable> T k() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return g(readString, a());
    }

    public <T> void l(T[] tArr) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i11 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i11 < length) {
                    u((VersionedParcelable) tArr[i11]);
                    i11++;
                }
            } else if (type == 2) {
                while (i11 < length) {
                    writeParcelable((Parcelable) tArr[i11]);
                    i11++;
                }
            } else if (type == 3) {
                while (i11 < length) {
                    writeSerializable((Serializable) tArr[i11]);
                    i11++;
                }
            } else if (type == 4) {
                while (i11 < length) {
                    writeString((String) tArr[i11]);
                    i11++;
                }
            } else if (type == 5) {
                while (i11 < length) {
                    writeStrongBinder((IBinder) tArr[i11]);
                    i11++;
                }
            }
        }
    }

    public void m(boolean[] zArr) {
        if (zArr != null) {
            writeInt(r0);
            for (boolean z11 : zArr) {
                writeInt(z11 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public abstract void n(CharSequence charSequence);

    public void o(double[] dArr) {
        if (dArr != null) {
            writeInt(r0);
            for (double writeDouble : dArr) {
                writeDouble(writeDouble);
            }
            return;
        }
        writeInt(-1);
    }

    public void p(float[] fArr) {
        if (fArr != null) {
            writeInt(r0);
            for (float writeFloat : fArr) {
                writeFloat(writeFloat);
            }
            return;
        }
        writeInt(-1);
    }

    public void q(int[] iArr) {
        if (iArr != null) {
            writeInt(r0);
            for (int writeInt : iArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    public void r(long[] jArr) {
        if (jArr != null) {
            writeInt(r0);
            for (long writeLong : jArr) {
                writeLong(writeLong);
            }
            return;
        }
        writeInt(-1);
    }

    public <T> T[] readArray(T[] tArr, int i11) {
        if (!readField(i11)) {
            return tArr;
        }
        return b(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z11, int i11) {
        if (!readField(i11)) {
            return z11;
        }
        return readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i11) {
        if (!readField(i11)) {
            return zArr;
        }
        return c();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i11) {
        if (!readField(i11)) {
            return bundle;
        }
        return readBundle();
    }

    public byte readByte(byte b11, int i11) {
        if (!readField(i11)) {
            return b11;
        }
        return (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i11) {
        if (!readField(i11)) {
            return bArr;
        }
        return readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i11) {
        if (!readField(i11)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            cArr2[i12] = (char) readInt();
        }
        return cArr2;
    }

    public CharSequence readCharSequence(CharSequence charSequence, int i11) {
        if (!readField(i11)) {
            return charSequence;
        }
        return d();
    }

    public abstract double readDouble();

    public double readDouble(double d11, int i11) {
        if (!readField(i11)) {
            return d11;
        }
        return readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i11) {
        if (!readField(i11)) {
            return dArr;
        }
        return e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = readExceptionCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Exception readException(java.lang.Exception r1, int r2) {
        /*
            r0 = this;
            boolean r2 = r0.readField(r2)
            if (r2 != 0) goto L_0x0007
            return r1
        L_0x0007:
            int r2 = r0.readExceptionCode()
            if (r2 == 0) goto L_0x0015
            java.lang.String r1 = r0.readString()
            java.lang.Exception r1 = r0.readException((int) r2, (java.lang.String) r1)
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.versionedparcelable.VersionedParcel.readException(java.lang.Exception, int):java.lang.Exception");
    }

    public abstract boolean readField(int i11);

    public abstract float readFloat();

    public float readFloat(float f11, int i11) {
        if (!readField(i11)) {
            return f11;
        }
        return readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i11) {
        if (!readField(i11)) {
            return fArr;
        }
        return f();
    }

    public abstract int readInt();

    public int readInt(int i11, int i12) {
        if (!readField(i12)) {
            return i11;
        }
        return readInt();
    }

    public int[] readIntArray(int[] iArr, int i11) {
        if (!readField(i11)) {
            return iArr;
        }
        return h();
    }

    public <T> List<T> readList(List<T> list, int i11) {
        if (!readField(i11)) {
            return list;
        }
        return (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j11, int i11) {
        if (!readField(i11)) {
            return j11;
        }
        return readLong();
    }

    public long[] readLongArray(long[] jArr, int i11) {
        if (!readField(i11)) {
            return jArr;
        }
        return i();
    }

    public <K, V> Map<K, V> readMap(Map<K, V> map, int i11) {
        if (!readField(i11)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayMap.put(arrayList.get(i12), arrayList2.get(i12));
        }
        return arrayMap;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t11, int i11) {
        if (!readField(i11)) {
            return t11;
        }
        return readParcelable();
    }

    public <T> Set<T> readSet(Set<T> set, int i11) {
        if (!readField(i11)) {
            return set;
        }
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i11) {
        if (!readField(i11)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i11) {
        if (!readField(i11)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i11) {
        if (!readField(i11)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String str, int i11) {
        if (!readField(i11)) {
            return str;
        }
        return readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i11) {
        if (!readField(i11)) {
            return iBinder;
        }
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t11, int i11) {
        if (!readField(i11)) {
            return t11;
        }
        return k();
    }

    public void s() {
        writeInt(0);
    }

    public abstract void setOutputField(int i11);

    public void setSerializationFlags(boolean z11, boolean z12) {
    }

    public <T extends VersionedParcelable> void t(T t11, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t11.getClass()).invoke((Object) null, new Object[]{t11, versionedParcel});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (ClassNotFoundException e14) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e14);
        }
    }

    public void u(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString((String) null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel a11 = a();
        t(versionedParcelable, a11);
        a11.closeField();
    }

    public <T> void writeArray(T[] tArr, int i11) {
        setOutputField(i11);
        l(tArr);
    }

    public abstract void writeBoolean(boolean z11);

    public void writeBoolean(boolean z11, int i11) {
        setOutputField(i11);
        writeBoolean(z11);
    }

    public void writeBooleanArray(boolean[] zArr, int i11) {
        setOutputField(i11);
        m(zArr);
    }

    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i11) {
        setOutputField(i11);
        writeBundle(bundle);
    }

    public void writeByte(byte b11, int i11) {
        setOutputField(i11);
        writeInt(b11);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i11) {
        setOutputField(i11);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i11, int i12);

    public void writeCharArray(char[] cArr, int i11) {
        setOutputField(i11);
        if (cArr != null) {
            writeInt(r4);
            for (char writeInt : cArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeCharSequence(CharSequence charSequence, int i11) {
        setOutputField(i11);
        n(charSequence);
    }

    public abstract void writeDouble(double d11);

    public void writeDouble(double d11, int i11) {
        setOutputField(i11);
        writeDouble(d11);
    }

    public void writeDoubleArray(double[] dArr, int i11) {
        setOutputField(i11);
        o(dArr);
    }

    public void writeException(Exception exc, int i11) {
        int i12;
        setOutputField(i11);
        if (exc == null) {
            s();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i12 = -9;
        } else if (exc instanceof SecurityException) {
            i12 = -1;
        } else if (exc instanceof BadParcelableException) {
            i12 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i12 = -3;
        } else if (exc instanceof NullPointerException) {
            i12 = -4;
        } else if (exc instanceof IllegalStateException) {
            i12 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i12 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i12 = -7;
        } else {
            i12 = 0;
        }
        writeInt(i12);
        if (i12 != 0) {
            writeString(exc.getMessage());
            if (i12 == -9) {
                writeParcelable((Parcelable) exc);
            }
        } else if (exc instanceof RuntimeException) {
            throw ((RuntimeException) exc);
        } else {
            throw new RuntimeException(exc);
        }
    }

    public abstract void writeFloat(float f11);

    public void writeFloat(float f11, int i11) {
        setOutputField(i11);
        writeFloat(f11);
    }

    public void writeFloatArray(float[] fArr, int i11) {
        setOutputField(i11);
        p(fArr);
    }

    public abstract void writeInt(int i11);

    public void writeInt(int i11, int i12) {
        setOutputField(i12);
        writeInt(i11);
    }

    public void writeIntArray(int[] iArr, int i11) {
        setOutputField(i11);
        q(iArr);
    }

    public <T> void writeList(List<T> list, int i11) {
        writeCollection(list, i11);
    }

    public abstract void writeLong(long j11);

    public void writeLong(long j11, int i11) {
        setOutputField(i11);
        writeLong(j11);
    }

    public void writeLongArray(long[] jArr, int i11) {
        setOutputField(i11);
        r(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i11) {
        setOutputField(i11);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(next.getKey());
                arrayList2.add(next.getValue());
            }
            writeCollection(arrayList);
            writeCollection(arrayList2);
        }
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i11) {
        setOutputField(i11);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i11) {
        setOutputField(i11);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i11) {
        writeCollection(set, i11);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i11) {
        boolean z11;
        setOutputField(i11);
        if (size != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        writeBoolean(z11);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i11) {
        boolean z11;
        setOutputField(i11);
        if (sizeF != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        writeBoolean(z11);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i11) {
        setOutputField(i11);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            writeInt(sparseBooleanArray.keyAt(i12));
            writeBoolean(sparseBooleanArray.valueAt(i12));
        }
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i11) {
        setOutputField(i11);
        writeString(str);
    }

    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i11) {
        setOutputField(i11);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i11) {
        setOutputField(i11);
        writeStrongInterface(iInterface);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i11) {
        setOutputField(i11);
        u(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    for (T u11 : collection) {
                        u(u11);
                    }
                    return;
                case 2:
                    for (T writeParcelable : collection) {
                        writeParcelable(writeParcelable);
                    }
                    return;
                case 3:
                    for (T writeSerializable : collection) {
                        writeSerializable(writeSerializable);
                    }
                    return;
                case 4:
                    for (T writeString : collection) {
                        writeString(writeString);
                    }
                    return;
                case 5:
                    for (T writeStrongBinder : collection) {
                        writeStrongBinder(writeStrongBinder);
                    }
                    return;
                case 7:
                    for (T intValue : collection) {
                        writeInt(intValue.intValue());
                    }
                    return;
                case 8:
                    for (T floatValue : collection) {
                        writeFloat(floatValue.floatValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString((String) null);
            return;
        }
        String name2 = serializable.getClass().getName();
        writeString(name2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e11) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name2 + ")", e11);
        }
    }

    public void writeByteArray(byte[] bArr, int i11, int i12, int i13) {
        setOutputField(i13);
        writeByteArray(bArr, i11, i12);
    }

    private Exception readException(int i11, String str) {
        return createException(i11, str);
    }
}
