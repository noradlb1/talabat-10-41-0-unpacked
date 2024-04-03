package com.huawei.secure.android.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

@Deprecated
public class SafeIntent extends Intent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    public String getAction() {
        try {
            return super.getAction();
        } catch (Exception unused) {
            return "";
        }
    }

    @Deprecated
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Exception unused) {
            return new boolean[0];
        }
    }

    @Deprecated
    public boolean getBooleanExtra(String str, boolean z11) {
        try {
            return super.getBooleanExtra(str, z11);
        } catch (Exception unused) {
            return z11;
        }
    }

    @Deprecated
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Deprecated
    public byte getByteExtra(String str, byte b11) {
        try {
            return super.getByteExtra(str, b11);
        } catch (Exception unused) {
            return b11;
        }
    }

    @Deprecated
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Exception unused) {
            return new char[0];
        }
    }

    @Deprecated
    public char getCharExtra(String str, char c11) {
        try {
            return super.getCharExtra(str, c11);
        } catch (Exception unused) {
            return c11;
        }
    }

    @Deprecated
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Exception unused) {
            return new CharSequence[0];
        }
    }

    @Deprecated
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Exception unused) {
            return new double[0];
        }
    }

    @Deprecated
    public double getDoubleExtra(String str, double d11) {
        try {
            return super.getDoubleExtra(str, d11);
        } catch (Exception unused) {
            return d11;
        }
    }

    @Deprecated
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Exception unused) {
            return new float[0];
        }
    }

    @Deprecated
    public float getFloatExtra(String str, float f11) {
        try {
            return super.getFloatExtra(str, f11);
        } catch (Exception unused) {
            return f11;
        }
    }

    @Deprecated
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Exception unused) {
            return new int[0];
        }
    }

    @Deprecated
    public int getIntExtra(String str, int i11) {
        try {
            return super.getIntExtra(str, i11);
        } catch (Exception unused) {
            return i11;
        }
    }

    @Deprecated
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Exception unused) {
            return new long[0];
        }
    }

    @Deprecated
    public long getLongExtra(String str, long j11) {
        try {
            return super.getLongExtra(str, j11);
        } catch (Exception unused) {
            return j11;
        }
    }

    @Deprecated
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Exception unused) {
            return new Parcelable[0];
        }
    }

    @Deprecated
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return super.getParcelableExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Exception unused) {
            return new short[0];
        }
    }

    @Deprecated
    public short getShortExtra(String str, short s11) {
        try {
            return super.getShortExtra(str, s11);
        } catch (Exception unused) {
            return s11;
        }
    }

    @Deprecated
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Exception unused) {
            return new String[0];
        }
    }

    @Deprecated
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Exception unused) {
            return false;
        }
    }
}
