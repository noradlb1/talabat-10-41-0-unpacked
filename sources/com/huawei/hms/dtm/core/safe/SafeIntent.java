package com.huawei.hms.dtm.core.safe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent extends Intent {
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

    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
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

    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
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

    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
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

    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
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

    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
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

    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
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

    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
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

    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Deprecated
    public String toURI() {
        try {
            return super.toURI();
        } catch (Throwable th2) {
            Logger.error("SafeIntent", "toURI: throwable " + th2.getMessage());
            return "";
        }
    }

    @Deprecated
    public String toURIReturnNotNull() {
        String str;
        try {
            str = super.toURI();
        } catch (Throwable th2) {
            Logger.error("SafeIntent", "toURI: throwable " + th2.getMessage());
            str = "";
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public String toUri(int i11) {
        try {
            return super.toUri(i11);
        } catch (Throwable th2) {
            Logger.error("SafeIntent", "toUri: " + th2.getMessage());
            return "";
        }
    }
}
