package com.huawei.secure.android.common.intent;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.huawei.secure.android.common.activity.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class SafeBundle {

    /* renamed from: b  reason: collision with root package name */
    private static final String f33824b = "SafeBundle";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33825c = "";

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f33826a;

    public SafeBundle() {
        this(new Bundle());
    }

    public void clear() {
        try {
            this.f33826a.clear();
        } catch (Throwable unused) {
            a.a(f33824b, "clear exception.");
        }
    }

    public boolean containsKey(String str) {
        try {
            return this.f33826a.containsKey(str);
        } catch (Throwable unused) {
            a.a(f33824b, "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f33826a.get(str);
        } catch (Throwable th2) {
            a.a(f33824b, "get exception: " + th2.getMessage(), true);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public IBinder getBinder(@Nullable String str) {
        try {
            return this.f33826a.getBinder(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getBinder exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean[] getBooleanArray(String str) {
        try {
            return this.f33826a.getBooleanArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getBooleanArray exception: " + th2.getMessage(), true);
            return new boolean[0];
        }
    }

    public boolean[] getBooleanArrayReturnNotNull(String str) {
        try {
            boolean[] booleanArray = this.f33826a.getBooleanArray(str);
            if (booleanArray == null) {
                return new boolean[0];
            }
            return booleanArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getBooleanArray exception: " + th2.getMessage(), true);
            return new boolean[0];
        }
    }

    public Bundle getBundle() {
        return this.f33826a;
    }

    public Bundle getBundleReturnNotNull(@Nullable String str) {
        try {
            Bundle bundle = this.f33826a.getBundle(str);
            if (bundle == null) {
                return new Bundle();
            }
            return bundle;
        } catch (Throwable th2) {
            a.a(f33824b, "getBundle exception: " + th2.getMessage(), true);
            return new Bundle();
        }
    }

    public byte getByte(String str) {
        try {
            return this.f33826a.getByte(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public byte[] getByteArray(String str) {
        try {
            return this.f33826a.getByteArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getByteArray exception: " + th2.getMessage(), true);
            return new byte[0];
        }
    }

    public byte[] getByteArrayReturnNotNull(String str) {
        try {
            byte[] byteArray = this.f33826a.getByteArray(str);
            if (byteArray == null) {
                return new byte[0];
            }
            return byteArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getByteArray exception: " + th2.getMessage(), true);
            return new byte[0];
        }
    }

    public char getChar(String str) {
        try {
            return this.f33826a.getChar(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public char[] getCharArray(String str) {
        try {
            return this.f33826a.getCharArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getCharArray exception: " + th2.getMessage(), true);
            return new char[0];
        }
    }

    public char[] getCharArrayReturnNotNull(String str) {
        try {
            char[] charArray = this.f33826a.getCharArray(str);
            if (charArray == null) {
                return new char[0];
            }
            return charArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getCharArray exception: " + th2.getMessage(), true);
            return new char[0];
        }
    }

    public CharSequence getCharSequence(String str) {
        try {
            return this.f33826a.getCharSequence(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public CharSequence[] getCharSequenceArray(String str) {
        try {
            return this.f33826a.getCharSequenceArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequenceArray exception: " + th2.getMessage(), true);
            return new CharSequence[0];
        }
    }

    public ArrayList<CharSequence> getCharSequenceArrayList(String str) {
        try {
            return this.f33826a.getCharSequenceArrayList(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequenceArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public ArrayList<CharSequence> getCharSequenceArrayListReturnNotNull(String str) {
        try {
            ArrayList<CharSequence> charSequenceArrayList = this.f33826a.getCharSequenceArrayList(str);
            if (charSequenceArrayList == null) {
                return new ArrayList<>();
            }
            return charSequenceArrayList;
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequenceArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public CharSequence[] getCharSequenceArrayReturnNotNull(String str) {
        try {
            CharSequence[] charSequenceArray = this.f33826a.getCharSequenceArray(str);
            if (charSequenceArray == null) {
                return new CharSequence[0];
            }
            return charSequenceArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequenceArrayReturnNotNull exception: " + th2.getMessage(), true);
            return new CharSequence[0];
        }
    }

    public CharSequence getCharSequenceReturnNotNull(String str) {
        CharSequence charSequence;
        try {
            charSequence = this.f33826a.getCharSequence(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequenceReturnNotNull exception: " + th2.getMessage(), true);
            charSequence = "";
        }
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        return charSequence;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double[] getDoubleArray(String str) {
        try {
            return this.f33826a.getDoubleArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getDoubleArray exception: " + th2.getMessage(), true);
            return new double[0];
        }
    }

    public double[] getDoubleArrayReturnNotNull(String str) {
        try {
            double[] doubleArray = this.f33826a.getDoubleArray(str);
            if (doubleArray == null) {
                return new double[0];
            }
            return doubleArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getDoubleArray exception: " + th2.getMessage(), true);
            return new double[0];
        }
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public float[] getFloatArray(String str) {
        try {
            return this.f33826a.getFloatArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getFloatArray exception: " + th2.getMessage(), true);
            return new float[0];
        }
    }

    public float[] getFloatArrayReturnNotNull(String str) {
        try {
            float[] floatArray = this.f33826a.getFloatArray(str);
            if (floatArray == null) {
                return new float[0];
            }
            return floatArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getFloatArray exception: " + th2.getMessage(), true);
            return new float[0];
        }
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int[] getIntArray(String str) {
        try {
            return this.f33826a.getIntArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getIntArray exception: " + th2.getMessage(), true);
            return new int[0];
        }
    }

    public int[] getIntArrayReturnNotNull(String str) {
        try {
            int[] intArray = this.f33826a.getIntArray(str);
            if (intArray == null) {
                return new int[0];
            }
            return intArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getIntArray exception: " + th2.getMessage(), true);
            return new int[0];
        }
    }

    public ArrayList<Integer> getIntegerArrayList(String str) {
        try {
            return this.f33826a.getIntegerArrayList(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getIntegerArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> getIntegerArrayListReturnNotNull(String str) {
        try {
            ArrayList<Integer> integerArrayList = this.f33826a.getIntegerArrayList(str);
            if (integerArrayList == null) {
                return new ArrayList<>();
            }
            return integerArrayList;
        } catch (Throwable th2) {
            a.a(f33824b, "getIntegerArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public long[] getLongArray(String str) {
        try {
            return this.f33826a.getLongArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getLongArray exception: " + th2.getMessage(), true);
            return new long[0];
        }
    }

    public long[] getLongArrayReturnNotNull(String str) {
        try {
            long[] longArray = this.f33826a.getLongArray(str);
            if (longArray == null) {
                return new long[0];
            }
            return longArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getLongArray exception: " + th2.getMessage(), true);
            return new long[0];
        }
    }

    public <T extends Parcelable> T getParcelable(String str) {
        try {
            return this.f33826a.getParcelable(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public Parcelable[] getParcelableArray(String str) {
        try {
            return this.f33826a.getParcelableArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getParcelableArray exception: " + th2.getMessage(), true);
            return new Parcelable[0];
        }
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String str) {
        try {
            return this.f33826a.getParcelableArrayList(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getParcelableArrayList exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public Parcelable[] getParcelableArrayReturnNotNull(String str) {
        try {
            Parcelable[] parcelableArray = this.f33826a.getParcelableArray(str);
            if (parcelableArray == null) {
                return new Parcelable[0];
            }
            return parcelableArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getParcelableArray exception: " + th2.getMessage(), true);
            return new Parcelable[0];
        }
    }

    public Object getReturnNotNull(String str) {
        try {
            Object obj = this.f33826a.get(str);
            if (obj == null) {
                return new Object();
            }
            return obj;
        } catch (Throwable th2) {
            a.a(f33824b, "get exception: " + th2.getMessage(), true);
            return new Object();
        }
    }

    public Serializable getSerializable(String str) {
        try {
            return this.f33826a.getSerializable(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public short getShort(String str) {
        try {
            return this.f33826a.getShort(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public short[] getShortArray(String str) {
        try {
            return this.f33826a.getShortArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getShortArray exception: " + th2.getMessage(), true);
            return new short[0];
        }
    }

    public short[] getShortArrayReturnNotNull(String str) {
        try {
            short[] shortArray = this.f33826a.getShortArray(str);
            if (shortArray == null) {
                return new short[0];
            }
            return shortArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getShortArray exception: " + th2.getMessage(), true);
            return new short[0];
        }
    }

    public Size getSize(String str) {
        try {
            return this.f33826a.getSize(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getSize exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public SizeF getSizeF(String str) {
        try {
            return this.f33826a.getSizeF(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getSizeF exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String str) {
        try {
            return this.f33826a.getSparseParcelableArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getSparseParcelableArray exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public String getString(String str) {
        try {
            return this.f33826a.getString(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getString exception: " + th2.getMessage(), true);
            return "";
        }
    }

    public String[] getStringArray(String str) {
        try {
            return this.f33826a.getStringArray(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getStringArray exception: " + th2.getMessage(), true);
            return new String[0];
        }
    }

    public ArrayList<String> getStringArrayList(String str) {
        try {
            return this.f33826a.getStringArrayList(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getStringArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public ArrayList<String> getStringArrayListReturnNotNull(String str) {
        try {
            ArrayList<String> stringArrayList = this.f33826a.getStringArrayList(str);
            if (stringArrayList == null) {
                return new ArrayList<>();
            }
            return stringArrayList;
        } catch (Throwable th2) {
            a.a(f33824b, "getStringArrayList exception: " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public String[] getStringArrayReturnNotNull(String str) {
        try {
            String[] stringArray = this.f33826a.getStringArray(str);
            if (stringArray == null) {
                return new String[0];
            }
            return stringArray;
        } catch (Throwable th2) {
            a.a(f33824b, "getStringArray exception: " + th2.getMessage(), true);
            return new String[0];
        }
    }

    public String getStringReturnNotNull(String str) {
        String str2;
        try {
            str2 = this.f33826a.getString(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getString exception: " + th2.getMessage(), true);
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    public boolean isEmpty() {
        try {
            return this.f33826a.isEmpty();
        } catch (Throwable unused) {
            a.a(f33824b, "isEmpty exception");
            return true;
        }
    }

    public Set<String> keySet() {
        try {
            return this.f33826a.keySet();
        } catch (Throwable unused) {
            a.a(f33824b, "keySet exception.");
            return null;
        }
    }

    public SafeBundle putAll(Bundle bundle) {
        if (bundle != null) {
            try {
                this.f33826a.putAll(bundle);
            } catch (Throwable unused) {
                a.a(f33824b, "putAll exception");
            }
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    public SafeBundle putBinder(@Nullable String str, @Nullable IBinder iBinder) {
        try {
            this.f33826a.putBinder(str, iBinder);
        } catch (Throwable th2) {
            a.a(f33824b, "putBundle exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putBoolean(@Nullable String str, boolean z11) {
        try {
            this.f33826a.putBoolean(str, z11);
        } catch (Throwable th2) {
            a.a(f33824b, "putBoolean exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putBooleanArray(@Nullable String str, @Nullable boolean[] zArr) {
        try {
            this.f33826a.putBooleanArray(str, zArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putBooleanArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putBundle(@Nullable String str, @Nullable Bundle bundle) {
        try {
            this.f33826a.putBundle(str, bundle);
        } catch (Throwable th2) {
            a.a(f33824b, "putBundle exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putByte(@Nullable String str, byte b11) {
        try {
            this.f33826a.putByte(str, b11);
        } catch (Throwable th2) {
            a.a(f33824b, "putByte exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putByteArray(@Nullable String str, @Nullable byte[] bArr) {
        try {
            this.f33826a.putByteArray(str, bArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putByteArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putChar(@Nullable String str, char c11) {
        try {
            this.f33826a.putChar(str, c11);
        } catch (Throwable th2) {
            a.a(f33824b, "putChar exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putCharArray(@Nullable String str, @Nullable char[] cArr) {
        try {
            this.f33826a.putCharArray(str, cArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putCharArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putCharSequence(@Nullable String str, @Nullable CharSequence charSequence) {
        try {
            this.f33826a.putCharSequence(str, charSequence);
        } catch (Throwable th2) {
            a.a(f33824b, "putCharSequence exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putCharSequenceArray(@Nullable String str, @Nullable CharSequence[] charSequenceArr) {
        try {
            this.f33826a.putCharSequenceArray(str, charSequenceArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putCharSequenceArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putCharSequenceArrayList(@Nullable String str, @Nullable ArrayList<CharSequence> arrayList) {
        try {
            this.f33826a.putCharSequenceArrayList(str, arrayList);
        } catch (Throwable th2) {
            a.a(f33824b, "putCharSequenceArrayList exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putDouble(@Nullable String str, double d11) {
        try {
            this.f33826a.putDouble(str, d11);
        } catch (Throwable th2) {
            a.a(f33824b, "putDouble exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putDoubleArray(@Nullable String str, @Nullable double[] dArr) {
        try {
            this.f33826a.putDoubleArray(str, dArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putDoubleArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putFloat(@Nullable String str, float f11) {
        try {
            this.f33826a.putFloat(str, f11);
        } catch (Throwable th2) {
            a.a(f33824b, "putFloat exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putFloatArray(@Nullable String str, @Nullable float[] fArr) {
        try {
            this.f33826a.putFloatArray(str, fArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putFloatArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putInt(@Nullable String str, int i11) {
        try {
            this.f33826a.putInt(str, i11);
        } catch (Throwable th2) {
            a.a(f33824b, "putInt exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putIntArray(@Nullable String str, @Nullable int[] iArr) {
        try {
            this.f33826a.putIntArray(str, iArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putIntArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putIntegerArrayList(@Nullable String str, @Nullable ArrayList<Integer> arrayList) {
        try {
            this.f33826a.putIntegerArrayList(str, arrayList);
        } catch (Throwable th2) {
            a.a(f33824b, "putIntegerArrayList exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putLong(@Nullable String str, long j11) {
        try {
            this.f33826a.putLong(str, j11);
        } catch (Throwable th2) {
            a.a(f33824b, "putLong exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putLongArray(@Nullable String str, @Nullable long[] jArr) {
        try {
            this.f33826a.putLongArray(str, jArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putLongArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putParcelable(@Nullable String str, @Nullable Parcelable parcelable) {
        try {
            this.f33826a.putParcelable(str, parcelable);
        } catch (Throwable th2) {
            a.a(f33824b, "putParcelable exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putParcelableArray(@Nullable String str, @Nullable Parcelable[] parcelableArr) {
        try {
            this.f33826a.putParcelableArray(str, parcelableArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putParcelableArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putParcelableArrayList(@Nullable String str, @Nullable ArrayList<? extends Parcelable> arrayList) {
        try {
            this.f33826a.putParcelableArrayList(str, arrayList);
        } catch (Throwable th2) {
            a.a(f33824b, "putParcelableArrayList exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putSerializable(@Nullable String str, @Nullable Serializable serializable) {
        try {
            this.f33826a.putSerializable(str, serializable);
        } catch (Throwable th2) {
            a.a(f33824b, "putSerializable exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putShort(@Nullable String str, short s11) {
        try {
            this.f33826a.putShort(str, s11);
        } catch (Throwable th2) {
            a.a(f33824b, "putShort exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putShortArray(@Nullable String str, @Nullable short[] sArr) {
        try {
            this.f33826a.putShortArray(str, sArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putShortArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    @TargetApi(21)
    public SafeBundle putSize(@Nullable String str, @Nullable Size size) {
        try {
            this.f33826a.putSize(str, size);
        } catch (Throwable th2) {
            a.a(f33824b, "putSize exception: " + th2.getMessage(), true);
        }
        return this;
    }

    @TargetApi(21)
    public SafeBundle putSizeF(@Nullable String str, @Nullable SizeF sizeF) {
        try {
            this.f33826a.putSizeF(str, sizeF);
        } catch (Throwable th2) {
            a.a(f33824b, "putSizeF exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putSparseParcelableArray(@Nullable String str, @Nullable SparseArray<? extends Parcelable> sparseArray) {
        try {
            this.f33826a.putSparseParcelableArray(str, sparseArray);
        } catch (Throwable th2) {
            a.a(f33824b, "putSparseParcelableArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putString(@Nullable String str, @Nullable String str2) {
        try {
            this.f33826a.putString(str, str2);
        } catch (Throwable th2) {
            a.a(f33824b, "putString exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putStringArray(@Nullable String str, @Nullable String[] strArr) {
        try {
            this.f33826a.putStringArray(str, strArr);
        } catch (Throwable th2) {
            a.a(f33824b, "putStringArray exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putStringArrayList(@Nullable String str, @Nullable ArrayList<String> arrayList) {
        try {
            this.f33826a.putStringArrayList(str, arrayList);
        } catch (Throwable th2) {
            a.a(f33824b, "putStringArrayList exception: " + th2.getMessage(), true);
        }
        return this;
    }

    public void remove(String str) {
        try {
            this.f33826a.remove(str);
        } catch (Throwable unused) {
            a.a(f33824b, "remove exception. key:");
        }
    }

    public int size() {
        try {
            return this.f33826a.size();
        } catch (Throwable unused) {
            a.a(f33824b, "size exception");
            return 0;
        }
    }

    public String toString() {
        try {
            return this.f33826a.toString();
        } catch (Throwable unused) {
            a.a(f33824b, "toString exception.");
            return null;
        }
    }

    public SafeBundle(Bundle bundle) {
        this.f33826a = bundle == null ? new Bundle() : bundle;
    }

    public boolean getBoolean(String str, boolean z11) {
        try {
            return this.f33826a.getBoolean(str, z11);
        } catch (Throwable th2) {
            a.a(f33824b, "getBoolean exception : " + th2.getMessage(), true);
            return z11;
        }
    }

    public Bundle getBundle(@Nullable String str) {
        try {
            return this.f33826a.getBundle(str);
        } catch (Throwable th2) {
            a.a(f33824b, "getBundle exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public byte getByte(String str, byte b11) {
        try {
            return this.f33826a.getByte(str, b11).byteValue();
        } catch (Throwable th2) {
            a.a(f33824b, "getByte exception: " + th2.getMessage(), true);
            return b11;
        }
    }

    public char getChar(String str, char c11) {
        try {
            return this.f33826a.getChar(str, c11);
        } catch (Throwable th2) {
            a.a(f33824b, "getChar exception: " + th2.getMessage(), true);
            return c11;
        }
    }

    @SuppressLint({"NewApi"})
    public CharSequence getCharSequence(String str, CharSequence charSequence) {
        try {
            return this.f33826a.getCharSequence(str, charSequence);
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequence exception: " + th2.getMessage(), true);
            return charSequence;
        }
    }

    public double getDouble(String str, double d11) {
        try {
            return this.f33826a.getDouble(str, d11);
        } catch (Throwable th2) {
            a.a(f33824b, "getDouble exception: " + th2.getMessage(), true);
            return d11;
        }
    }

    public float getFloat(String str, float f11) {
        try {
            return this.f33826a.getFloat(str, f11);
        } catch (Throwable th2) {
            a.a(f33824b, "getFloat exception: " + th2.getMessage(), true);
            return f11;
        }
    }

    public int getInt(String str, int i11) {
        try {
            return this.f33826a.getInt(str, i11);
        } catch (Throwable th2) {
            a.a(f33824b, "getInt exception: " + th2.getMessage(), true);
            return i11;
        }
    }

    public long getLong(String str, long j11) {
        try {
            return this.f33826a.getLong(str, j11);
        } catch (Throwable th2) {
            a.a(f33824b, "getLong exception: " + th2.getMessage(), true);
            return j11;
        }
    }

    public short getShort(String str, short s11) {
        try {
            return this.f33826a.getShort(str, s11);
        } catch (Throwable th2) {
            a.a(f33824b, "getShort exception: " + th2.getMessage(), true);
            return s11;
        }
    }

    public <T extends Parcelable> T getParcelable(String str, Class<T> cls) {
        try {
            Parcelable parcelable = this.f33826a.getParcelable(str);
            if (cls.isInstance(parcelable)) {
                return (Parcelable) cls.cast(parcelable);
            }
            return null;
        } catch (Throwable th2) {
            a.a(f33824b, "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public <T extends Serializable> T getSerializable(String str, Class<T> cls) {
        try {
            Serializable serializable = this.f33826a.getSerializable(str);
            if (cls.isInstance(serializable)) {
                return (Serializable) cls.cast(serializable);
            }
            return null;
        } catch (Throwable th2) {
            a.a(f33824b, "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public String getString(String str, String str2) {
        try {
            return this.f33826a.getString(str, str2);
        } catch (Throwable th2) {
            a.a(f33824b, "getString exception: " + th2.getMessage(), true);
            return str2;
        }
    }

    @SuppressLint({"NewApi"})
    public CharSequence getCharSequenceReturnNotNull(String str, CharSequence charSequence) {
        try {
            CharSequence charSequence2 = this.f33826a.getCharSequence(str, charSequence);
            return charSequence2 == null ? "" : charSequence2;
        } catch (Throwable th2) {
            a.a(f33824b, "getCharSequence exception: " + th2.getMessage(), true);
            return charSequence;
        }
    }

    @SuppressLint({"NewApi"})
    public String getStringReturnNotNull(String str, String str2) {
        try {
            String string = this.f33826a.getString(str, str2);
            return string == null ? str2 : string;
        } catch (Throwable th2) {
            a.a(f33824b, "getString exception: " + th2.getMessage(), true);
            return str2;
        }
    }
}
