package com.huawei.agconnect.datastore.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.agconnect.datastore.annotation.ICrypto;
import java.util.Map;

public class AndroidSharedPrefUtil {
    private static AndroidSharedPrefUtil INSTANCE = new AndroidSharedPrefUtil();
    private static final String TAG = "AndroidSharedPrefUtil";
    private static Context context;

    private AndroidSharedPrefUtil() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.Object get(java.lang.String r3, java.lang.String r4, java.lang.Class<?> r5, java.lang.Object r6, java.lang.Class<?> r7) {
        /*
            java.lang.Class<com.huawei.agconnect.datastore.core.AndroidSharedPrefUtil> r0 = com.huawei.agconnect.datastore.core.AndroidSharedPrefUtil.class
            monitor-enter(r0)
            com.huawei.agconnect.datastore.annotation.ICrypto r7 = com.huawei.agconnect.datastore.core.CryptoUtil.getHelper(r7)     // Catch:{ all -> 0x0089 }
            android.content.Context r1 = context     // Catch:{ all -> 0x0089 }
            r2 = 0
            android.content.SharedPreferences r3 = r1.getSharedPreferences(r3, r2)     // Catch:{ all -> 0x0089 }
            if (r3 != 0) goto L_0x0019
            java.lang.String r3 = "AndroidSharedPrefUtil"
            java.lang.String r4 = "sp is null"
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x0089 }
            monitor-exit(r0)
            return r6
        L_0x0019:
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            boolean r1 = r1.equals(r5)     // Catch:{ ClassCastException -> 0x0070 }
            if (r1 == 0) goto L_0x002a
            int r3 = getInt(r3, r4, r7, r6)     // Catch:{ ClassCastException -> 0x0070 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ClassCastException -> 0x0070 }
            goto L_0x006e
        L_0x002a:
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            boolean r1 = r1.equals(r5)     // Catch:{ ClassCastException -> 0x0070 }
            if (r1 == 0) goto L_0x003b
            long r1 = getLong(r3, r4, r7, r6)     // Catch:{ ClassCastException -> 0x0070 }
            java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch:{ ClassCastException -> 0x0070 }
            goto L_0x006e
        L_0x003b:
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            boolean r1 = r1.equals(r5)     // Catch:{ ClassCastException -> 0x0070 }
            if (r1 == 0) goto L_0x004c
            float r3 = getFloat(r3, r4, r7, r6)     // Catch:{ ClassCastException -> 0x0070 }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ ClassCastException -> 0x0070 }
            goto L_0x006e
        L_0x004c:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            boolean r1 = r1.equals(r5)     // Catch:{ ClassCastException -> 0x0070 }
            if (r1 == 0) goto L_0x005d
            boolean r3 = getBoolean(r3, r4, r7, r6)     // Catch:{ ClassCastException -> 0x0070 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ ClassCastException -> 0x0070 }
            goto L_0x006e
        L_0x005d:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            boolean r1 = r1.equals(r5)     // Catch:{ ClassCastException -> 0x0070 }
            if (r1 == 0) goto L_0x006a
            java.lang.String r3 = getString(r3, r4, r7, r6)     // Catch:{ ClassCastException -> 0x0070 }
            goto L_0x006e
        L_0x006a:
            java.lang.Object r3 = getObject(r3, r4, r7, r6, r5)     // Catch:{ ClassCastException -> 0x0070 }
        L_0x006e:
            monitor-exit(r0)
            return r3
        L_0x0070:
            r3 = move-exception
            java.lang.String r5 = "AndroidSharedPrefUtil"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r7.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "save type error for key :"
            r7.append(r1)     // Catch:{ all -> 0x0089 }
            r7.append(r4)     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0089 }
            android.util.Log.e(r5, r4, r3)     // Catch:{ all -> 0x0089 }
            monitor-exit(r0)
            return r6
        L_0x0089:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.datastore.core.AndroidSharedPrefUtil.get(java.lang.String, java.lang.String, java.lang.Class, java.lang.Object, java.lang.Class):java.lang.Object");
    }

    public static Map<String, ?> getAll(String str) {
        return context.getSharedPreferences(str, 0).getAll();
    }

    private static boolean getBoolean(SharedPreferences sharedPreferences, String str, ICrypto iCrypto, Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (iCrypto == null) {
            return sharedPreferences.getBoolean(str, booleanValue);
        }
        try {
            return Boolean.parseBoolean(iCrypto.decrypt(sharedPreferences.getString(str, String.valueOf(booleanValue))));
        } catch (NumberFormatException unused) {
            return booleanValue;
        }
    }

    private static float getFloat(SharedPreferences sharedPreferences, String str, ICrypto iCrypto, Object obj) {
        if (obj == null) {
            obj = Float.valueOf(Float.NaN);
        }
        float floatValue = ((Float) obj).floatValue();
        if (iCrypto == null) {
            return sharedPreferences.getFloat(str, floatValue);
        }
        try {
            return Float.parseFloat(iCrypto.decrypt(sharedPreferences.getString(str, String.valueOf(floatValue))));
        } catch (NumberFormatException unused) {
            return floatValue;
        }
    }

    private static int getInt(SharedPreferences sharedPreferences, String str, ICrypto iCrypto, Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int intValue = ((Integer) obj).intValue();
        if (iCrypto == null) {
            return sharedPreferences.getInt(str, intValue);
        }
        try {
            return Integer.parseInt(iCrypto.decrypt(sharedPreferences.getString(str, String.valueOf(intValue))));
        } catch (NumberFormatException unused) {
            return intValue;
        }
    }

    private static long getLong(SharedPreferences sharedPreferences, String str, ICrypto iCrypto, Object obj) {
        if (obj == null) {
            obj = 0L;
        }
        long longValue = ((Long) obj).longValue();
        if (iCrypto == null) {
            return sharedPreferences.getLong(str, longValue);
        }
        try {
            return Long.parseLong(iCrypto.decrypt(sharedPreferences.getString(str, String.valueOf(longValue))));
        } catch (NumberFormatException unused) {
            return longValue;
        }
    }

    private static Object getObject(SharedPreferences sharedPreferences, String str, ICrypto iCrypto, Object obj, Class<?> cls) {
        String str2;
        StringBuilder sb2;
        if (!Parcelable.class.isAssignableFrom(cls)) {
            Log.e(TAG, "Only Support Parcelable Object");
            return obj;
        }
        try {
            return ParcelableSerializer.deserializeFromString(getString(sharedPreferences, str, iCrypto, (Object) null), (Parcelable.Creator) cls.getField("CREATOR").get((Object) null));
        } catch (NoSuchFieldException unused) {
            sb2 = new StringBuilder();
            str2 = "NoSuchFieldException:";
            sb2.append(str2);
            sb2.append(cls);
            Log.e(TAG, sb2.toString());
            return obj;
        } catch (IllegalAccessException unused2) {
            sb2 = new StringBuilder();
            str2 = "IllegalAccessException:";
            sb2.append(str2);
            sb2.append(cls);
            Log.e(TAG, sb2.toString());
            return obj;
        }
    }

    private static String getString(SharedPreferences sharedPreferences, String str, ICrypto iCrypto, Object obj) {
        if (obj == null) {
            obj = "";
        }
        String string = sharedPreferences.getString(str, (String) obj);
        return iCrypto != null ? iCrypto.decrypt(string) : string;
    }

    public static synchronized void init(Object obj) {
        synchronized (AndroidSharedPrefUtil.class) {
            if (obj instanceof Context) {
                Context applicationContext = ((Context) obj).getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = (Context) obj;
                }
                context = applicationContext;
            }
        }
    }

    public static synchronized void put(String str, String str2, Class<?> cls, Object obj, Class<?> cls2) {
        synchronized (AndroidSharedPrefUtil.class) {
            ICrypto helper = CryptoUtil.getHelper(cls2);
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            if (obj != null) {
                if (edit != null) {
                    if (Integer.class.equals(cls)) {
                        putInt(edit, helper, str2, ((Integer) obj).intValue());
                    } else if (Long.class.equals(cls)) {
                        putLong(edit, helper, str2, ((Long) obj).longValue());
                    } else if (Float.class.equals(cls)) {
                        putFloat(edit, helper, str2, ((Float) obj).floatValue());
                    } else if (Boolean.class.equals(cls)) {
                        putBoolean(edit, helper, str2, ((Boolean) obj).booleanValue());
                    } else if (String.class.equals(cls)) {
                        putString(edit, helper, str2, (String) obj);
                    } else {
                        putObject(edit, helper, str2, obj);
                    }
                    edit.commit();
                    return;
                }
            }
            Log.e(TAG, "value or editor is null");
        }
    }

    private static void putBoolean(SharedPreferences.Editor editor, ICrypto iCrypto, String str, boolean z11) {
        if (iCrypto != null) {
            editor.putString(str, iCrypto.encrypt(String.valueOf(z11)));
        } else {
            editor.putBoolean(str, z11);
        }
    }

    private static void putFloat(SharedPreferences.Editor editor, ICrypto iCrypto, String str, float f11) {
        if (iCrypto != null) {
            editor.putString(str, iCrypto.encrypt(String.valueOf(f11)));
        } else {
            editor.putFloat(str, f11);
        }
    }

    private static void putInt(SharedPreferences.Editor editor, ICrypto iCrypto, String str, int i11) {
        if (iCrypto != null) {
            editor.putString(str, iCrypto.encrypt(String.valueOf(i11)));
        } else {
            editor.putInt(str, i11);
        }
    }

    private static void putLong(SharedPreferences.Editor editor, ICrypto iCrypto, String str, long j11) {
        if (iCrypto != null) {
            editor.putString(str, iCrypto.encrypt(String.valueOf(j11)));
        } else {
            editor.putLong(str, j11);
        }
    }

    private static void putObject(SharedPreferences.Editor editor, ICrypto iCrypto, String str, Object obj) {
        if (!Parcelable.class.isAssignableFrom(obj.getClass())) {
            Log.e(TAG, "Only Support Parcelable Object");
            return;
        }
        String serializeToString = ParcelableSerializer.serializeToString((Parcelable) obj);
        if (iCrypto != null) {
            editor.putString(str, iCrypto.encrypt(serializeToString));
        } else {
            editor.putString(str, serializeToString);
        }
    }

    private static void putString(SharedPreferences.Editor editor, ICrypto iCrypto, String str, String str2) {
        if (iCrypto != null) {
            editor.putString(str, iCrypto.encrypt(str2));
        } else {
            editor.putString(str, str2);
        }
    }

    public static void remove(String str, String str2) {
        context.getSharedPreferences(str, 0).edit().remove(str2).commit();
    }
}
