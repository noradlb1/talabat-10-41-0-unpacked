package com.huawei.secure.android.common.intent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.huawei.secure.android.common.activity.a;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent extends Intent {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33827a = "";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33828b = "SafeIntent";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    public String getAction() {
        try {
            return super.getAction();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String getActionReturnNotNull() {
        try {
            String action = super.getAction();
            if (action == null) {
                return "";
            }
            return action;
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Throwable unused) {
            return new boolean[0];
        }
    }

    public boolean[] getBooleanArrayExtraReturnNotNull(String str) {
        try {
            boolean[] booleanArrayExtra = super.getBooleanArrayExtra(str);
            return booleanArrayExtra == null ? new boolean[0] : booleanArrayExtra;
        } catch (Throwable unused) {
            return new boolean[0];
        }
    }

    public boolean getBooleanExtra(String str, boolean z11) {
        try {
            return super.getBooleanExtra(str, z11);
        } catch (Throwable unused) {
            return z11;
        }
    }

    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public Bundle getBundleExtraReturnNotNull(String str) {
        try {
            Bundle bundleExtra = super.getBundleExtra(str);
            if (bundleExtra == null) {
                return new Bundle();
            }
            return bundleExtra;
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public byte[] getByteArrayExtraReturnNotNull(String str) {
        try {
            byte[] byteArrayExtra = super.getByteArrayExtra(str);
            return byteArrayExtra == null ? new byte[0] : byteArrayExtra;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public byte getByteExtra(String str, byte b11) {
        try {
            return super.getByteExtra(str, b11);
        } catch (Throwable unused) {
            return b11;
        }
    }

    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Throwable unused) {
            return new char[0];
        }
    }

    public char[] getCharArrayExtraReturnNotNull(String str) {
        try {
            char[] charArrayExtra = super.getCharArrayExtra(str);
            return charArrayExtra == null ? new char[0] : charArrayExtra;
        } catch (Throwable unused) {
            return new char[0];
        }
    }

    public char getCharExtra(String str, char c11) {
        try {
            return super.getCharExtra(str, c11);
        } catch (Throwable unused) {
            return c11;
        }
    }

    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Throwable unused) {
            return new CharSequence[0];
        }
    }

    public CharSequence[] getCharSequenceArrayExtraReturnNotNull(String str) {
        try {
            CharSequence[] charSequenceArrayExtra = super.getCharSequenceArrayExtra(str);
            return charSequenceArrayExtra == null ? new CharSequence[0] : charSequenceArrayExtra;
        } catch (Throwable unused) {
            return new CharSequence[0];
        }
    }

    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public ArrayList<CharSequence> getCharSequenceArrayListExtraReturnNotNull(String str) {
        try {
            ArrayList<CharSequence> charSequenceArrayListExtra = super.getCharSequenceArrayListExtra(str);
            if (charSequenceArrayListExtra == null) {
                return new ArrayList<>();
            }
            return charSequenceArrayListExtra;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public CharSequence getCharSequenceExtraReturnNotNull(String str) {
        try {
            CharSequence charSequenceExtra = super.getCharSequenceExtra(str);
            if (charSequenceExtra == null) {
                return "";
            }
            return charSequenceExtra;
        } catch (Throwable unused) {
            return "";
        }
    }

    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Throwable unused) {
            return new double[0];
        }
    }

    public double[] getDoubleArrayExtraReturnNotNull(String str) {
        try {
            double[] doubleArrayExtra = super.getDoubleArrayExtra(str);
            return doubleArrayExtra == null ? new double[0] : doubleArrayExtra;
        } catch (Throwable unused) {
            return new double[0];
        }
    }

    public double getDoubleExtra(String str, double d11) {
        try {
            return super.getDoubleExtra(str, d11);
        } catch (Throwable unused) {
            return d11;
        }
    }

    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public Bundle getExtrasReturnNotNull() {
        try {
            Bundle extras = super.getExtras();
            if (extras == null) {
                return new Bundle();
            }
            return extras;
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Throwable unused) {
            return new float[0];
        }
    }

    public float[] getFloatArrayExtraReturnNotNull(String str) {
        try {
            float[] floatArrayExtra = super.getFloatArrayExtra(str);
            return floatArrayExtra == null ? new float[0] : floatArrayExtra;
        } catch (Throwable unused) {
            return new float[0];
        }
    }

    public float getFloatExtra(String str, float f11) {
        try {
            return super.getFloatExtra(str, f11);
        } catch (Throwable unused) {
            return f11;
        }
    }

    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public int[] getIntArrayExtraReturnNotNull(String str) {
        try {
            int[] intArrayExtra = super.getIntArrayExtra(str);
            return intArrayExtra == null ? new int[0] : intArrayExtra;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public int getIntExtra(String str, int i11) {
        try {
            return super.getIntExtra(str, i11);
        } catch (Throwable unused) {
            return i11;
        }
    }

    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> getIntegerArrayListExtraReturnNotNull(String str) {
        try {
            ArrayList<Integer> integerArrayListExtra = super.getIntegerArrayListExtra(str);
            if (integerArrayListExtra == null) {
                return new ArrayList<>();
            }
            return integerArrayListExtra;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Throwable unused) {
            return new long[0];
        }
    }

    public long[] getLongArrayExtraReturnNotNull(String str) {
        try {
            long[] longArrayExtra = super.getLongArrayExtra(str);
            return longArrayExtra == null ? new long[0] : longArrayExtra;
        } catch (Throwable unused) {
            return new long[0];
        }
    }

    public long getLongExtra(String str, long j11) {
        try {
            return super.getLongExtra(str, j11);
        } catch (Throwable unused) {
            return j11;
        }
    }

    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Throwable unused) {
            return new Parcelable[0];
        }
    }

    public Parcelable[] getParcelableArrayExtraReturnNotNull(String str) {
        try {
            Parcelable[] parcelableArrayExtra = super.getParcelableArrayExtra(str);
            return parcelableArrayExtra == null ? new Parcelable[0] : parcelableArrayExtra;
        } catch (Throwable unused) {
            return new Parcelable[0];
        }
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return super.getParcelableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Throwable unused) {
            return new short[0];
        }
    }

    public short[] getShortArrayExtraReturnNotNull(String str) {
        try {
            short[] shortArrayExtra = super.getShortArrayExtra(str);
            return shortArrayExtra == null ? new short[0] : shortArrayExtra;
        } catch (Throwable unused) {
            return new short[0];
        }
    }

    public short getShortExtra(String str, short s11) {
        try {
            return super.getShortExtra(str, s11);
        } catch (Throwable unused) {
            return s11;
        }
    }

    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Throwable unused) {
            return new String[0];
        }
    }

    public String[] getStringArrayExtraReturnNotNull(String str) {
        try {
            String[] stringArrayExtra = super.getStringArrayExtra(str);
            return stringArrayExtra == null ? new String[0] : stringArrayExtra;
        } catch (Throwable unused) {
            return new String[0];
        }
    }

    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public ArrayList<String> getStringArrayListExtraReturnNotNull(String str) {
        try {
            ArrayList<String> stringArrayListExtra = super.getStringArrayListExtra(str);
            if (stringArrayListExtra == null) {
                return new ArrayList<>();
            }
            return stringArrayListExtra;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public String getStringExtraReturnNotNull(String str) {
        try {
            String stringExtra = super.getStringExtra(str);
            if (stringExtra == null) {
                return "";
            }
            return stringExtra;
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean hasIntentBomb() {
        boolean z11;
        try {
            super.getStringExtra("ANYTHING");
            z11 = false;
        } catch (Throwable unused) {
            z11 = true;
        }
        if (z11) {
            a.a(f33828b, "hasIntentBomb");
        }
        return z11;
    }

    public Intent putExtra(String str, Parcelable parcelable) {
        try {
            return super.putExtra(str, parcelable);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtras(Intent intent) {
        try {
            return super.putExtras(intent);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        try {
            return super.putParcelableArrayListExtra(str, arrayList);
        } catch (Throwable unused) {
            return this;
        }
    }

    public void removeExtra(String str) {
        try {
            super.removeExtra(str);
        } catch (Throwable th2) {
            String str2 = f33828b;
            a.a(str2, "removeExtra: " + th2.getMessage(), true);
        }
    }

    public Intent setAction(@Nullable String str) {
        try {
            return super.setAction(str);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent setPackage(@Nullable String str) {
        try {
            return super.setPackage(str);
        } catch (Throwable unused) {
            return this;
        }
    }

    public void setSelector(@Nullable Intent intent) {
        try {
            super.setSelector(intent);
        } catch (Throwable th2) {
            String str = f33828b;
            a.a(str, "setSelector: " + th2.getMessage(), true);
        }
    }

    @Deprecated
    public String toURI() {
        try {
            return super.toURI();
        } catch (Throwable th2) {
            String str = f33828b;
            a.a(str, "toURI: exception " + th2.getMessage(), true);
            return "";
        }
    }

    @Deprecated
    public String toURIReturnNotNull() {
        String str;
        try {
            str = super.toURI();
        } catch (Throwable th2) {
            String str2 = f33828b;
            a.a(str2, "toURI: exception " + th2.getMessage(), true);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public String toUri(int i11) {
        try {
            return super.toUri(i11);
        } catch (Throwable th2) {
            String str = f33828b;
            a.a(str, "toUri: " + th2.getMessage(), true);
            return "";
        }
    }

    public String toUriReturnNotNull(int i11) {
        String str;
        try {
            str = super.toUri(i11);
        } catch (Throwable th2) {
            String str2 = f33828b;
            a.a(str2, "toUri: " + th2.getMessage(), true);
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public <T extends Parcelable> T getParcelableExtra(String str, Class<T> cls) {
        try {
            Parcelable parcelableExtra = super.getParcelableExtra(str);
            if (cls.isInstance(parcelableExtra)) {
                return (Parcelable) cls.cast(parcelableExtra);
            }
            return null;
        } catch (Throwable th2) {
            String str2 = f33828b;
            a.a(str2, "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public <T extends Serializable> T getSerializableExtra(String str, Class<T> cls) {
        try {
            Serializable serializableExtra = super.getSerializableExtra(str);
            if (cls.isInstance(serializableExtra)) {
                return (Serializable) cls.cast(serializableExtra);
            }
            return null;
        } catch (Throwable th2) {
            String str2 = f33828b;
            a.a(str2, "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        try {
            return super.putExtra(str, parcelableArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, Serializable serializable) {
        try {
            return super.putExtra(str, serializable);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, int i11) {
        try {
            return super.putExtra(str, i11);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, String str2) {
        try {
            return super.putExtra(str, str2);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, String[] strArr) {
        try {
            return super.putExtra(str, strArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, CharSequence charSequence) {
        try {
            return super.putExtra(str, charSequence);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, CharSequence[] charSequenceArr) {
        try {
            return super.putExtra(str, charSequenceArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, Bundle bundle) {
        try {
            return super.putExtra(str, bundle);
        } catch (Throwable unused) {
            return this;
        }
    }
}
