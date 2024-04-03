package com.huawei.hms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;
import java.util.Map;

public class mab {
    public static IBinder a(IBinder iBinder, String str, int i11, IBinder iBinder2) {
        return a(iBinder, str, i11, iBinder2, (Parcelable) null, 1);
    }

    public static IBinder a(IBinder iBinder, String str, int i11, IBinder iBinder2, Parcelable parcelable) {
        return a(iBinder, str, i11, iBinder2, parcelable, 2);
    }

    private static IBinder a(IBinder iBinder, String str, int i11, IBinder iBinder2, Parcelable parcelable, int i12) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            if (i12 == 1 || i12 == 2) {
                obtain.writeStrongBinder(iBinder2);
            }
            if (i12 == 2 || i12 == 3) {
                if (parcelable != null) {
                    obtain.writeInt(1);
                    parcelable.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
            }
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static IBinder a(IBinder iBinder, String str, int i11, Parcelable parcelable) {
        return a(iBinder, str, i11, (IBinder) null, parcelable, 3);
    }

    /* JADX INFO: finally extract failed */
    public static Number a(IBinder iBinder, String str, int i11, int i12, Parcelable... parcelableArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable != null) {
                    obtain.writeInt(1);
                    parcelable.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
            }
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            if (i12 == 0) {
                Integer valueOf = Integer.valueOf(obtain2.readInt());
                obtain2.recycle();
                obtain.recycle();
                return valueOf;
            } else if (i12 == 1) {
                Float valueOf2 = Float.valueOf(obtain2.readFloat());
                obtain2.recycle();
                obtain.recycle();
                return valueOf2;
            } else if (i12 == 2) {
                Double valueOf3 = Double.valueOf(obtain2.readDouble());
                obtain2.recycle();
                obtain.recycle();
                return valueOf3;
            } else if (i12 != 3) {
                Log.e("DelegateUtil", "read number from parcel error , with not support type." + i12);
                obtain2.recycle();
                obtain.recycle();
                return null;
            } else {
                Byte valueOf4 = Byte.valueOf(obtain2.readByte());
                obtain2.recycle();
                obtain.recycle();
                return valueOf4;
            }
        } catch (Throwable th2) {
            obtain2.recycle();
            obtain.recycle();
            throw th2;
        }
    }

    public static void a(IBinder iBinder, IBinder iBinder2, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            obtain.writeStrongBinder(iBinder);
            iBinder2.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(IBinder iBinder, String str, int i11, Number number, Parcelable... parcelableArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable != null) {
                    obtain.writeInt(1);
                    parcelable.writeToParcel(obtain, 0);
                } else {
                    obtain.writeInt(0);
                }
            }
            if (number != null) {
                a(obtain, number);
            }
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(IBinder iBinder, String str, int i11, IBinder... iBinderArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            for (IBinder writeStrongBinder : iBinderArr) {
                obtain.writeStrongBinder(writeStrongBinder);
            }
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(IBinder iBinder, String str, int i11, Parcelable... parcelableArr) {
        a(iBinder, str, i11, (Number) null, parcelableArr);
    }

    public static void a(IBinder iBinder, String str, int i11, Float... fArr) {
        a(iBinder, str, i11, (Number[]) fArr);
    }

    public static void a(IBinder iBinder, String str, int i11, Integer... numArr) {
        a(iBinder, str, i11, (Number[]) numArr);
    }

    public static void a(IBinder iBinder, String str, int i11, Number... numberArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            for (Number a11 : numberArr) {
                a(obtain, a11);
            }
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(IBinder iBinder, String str, int i11, String... strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            for (String writeString : strArr) {
                obtain.writeString(writeString);
            }
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    private static void a(Parcel parcel, Number number) {
        if (number instanceof Integer) {
            parcel.writeInt(number.intValue());
        } else if (number instanceof Float) {
            parcel.writeFloat(number.floatValue());
        } else if (number instanceof Double) {
            parcel.writeDouble(number.doubleValue());
        } else if (number instanceof Byte) {
            parcel.writeByte(number.byteValue());
        } else {
            Log.e("DelegateUtil", "setNumber with not support type." + number.toString());
        }
    }

    public static void a(String str, IBinder iBinder, String str2, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str2);
            obtain.writeString(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(List<LatLng> list, IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            obtain.writeTypedList(list);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(Map map, IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            obtain.writeMap(map);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void a(boolean z11, IBinder iBinder, String str, int i11) {
        a(iBinder, str, i11, Integer.valueOf(z11 ? 1 : 0));
    }

    public static boolean a(IBinder iBinder, String str, int i11) {
        return b(iBinder, str, i11) != 0;
    }

    public static boolean a(IBinder iBinder, String str, int i11, boolean z11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            obtain.writeInt(z11 ? 1 : 0);
            boolean z12 = false;
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z12 = true;
            }
            return z12;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static boolean a(IInterface iInterface, IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            obtain.writeStrongBinder(iInterface != null ? iInterface.asBinder() : null);
            boolean z11 = false;
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z11 = true;
            }
            return z11;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static int b(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void b(List<PatternItem> list, IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            obtain.writeTypedList(list);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static float c(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readFloat();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static String d(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static LatLng e(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static LatLngBounds f(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static List<LatLng> g(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(LatLng.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static List<PatternItem> h(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(PatternItem.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static void i(IBinder iBinder, String str, int i11) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(str);
            iBinder.transact(i11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static IBinder j(IBinder iBinder, String str, int i11) {
        return a(iBinder, str, i11, (IBinder) null, (Parcelable) null, 0);
    }
}
