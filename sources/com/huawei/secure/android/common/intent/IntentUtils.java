package com.huawei.secure.android.common.intent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.secure.android.common.activity.a;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class IntentUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33822a = "IntentUtils";

    /* renamed from: b  reason: collision with root package name */
    private static final int f33823b = 750000;

    @SuppressLint({"NewApi"})
    public static void filterIntent(Intent intent) {
        if (intent != null) {
            intent.addCategory("android.intent.category.BROWSABLE").setComponent((ComponentName) null).setSelector((Intent) null);
        }
    }

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(Intent intent, String str) {
        try {
            return intent.getParcelableArrayListExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getParcelableArrayListExtra failed on intent " + th2.getMessage(), true);
            return null;
        }
    }

    public static int getParceledIntentSize(Intent intent) {
        Parcel obtain = Parcel.obtain();
        intent.writeToParcel(obtain, 0);
        int dataSize = obtain.dataSize();
        obtain.recycle();
        return dataSize;
    }

    @SuppressLint({"NewApi"})
    public static Uri getReferrer(Activity activity) {
        try {
            return activity.getReferrer();
        } catch (Throwable th2) {
            a.a(f33822a, "getReferrer: " + th2.getMessage(), true);
            return null;
        }
    }

    public static boolean hasIntentBomb(Intent intent) {
        boolean z11 = true;
        if (intent == null) {
            a.a(f33822a, "intent is null");
        } else if (intent instanceof SafeIntent) {
            a.b(f33822a, "safe intent");
            z11 = ((SafeIntent) intent).hasIntentBomb();
        } else {
            try {
                intent.getStringExtra("ANYTHING");
                z11 = false;
            } catch (Throwable unused) {
            }
        }
        if (z11) {
            a.a(f33822a, "hasIntentBomb");
        }
        return z11;
    }

    public static boolean isIntentTooLarge(Intent intent) {
        return getParceledIntentSize(intent) > f33823b;
    }

    public static boolean safeGetBoolean(Bundle bundle, String str) {
        return safeGetBoolean(bundle, str, false);
    }

    public static boolean safeGetBooleanExtra(Intent intent, String str, boolean z11) {
        try {
            return intent.getBooleanExtra(str, z11);
        } catch (Throwable th2) {
            a.a(f33822a, "getBooleanExtra failed on intent " + th2.getMessage(), true);
            return z11;
        }
    }

    public static Bundle safeGetBundle(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getBundle failed on bundle " + th2.getMessage(), true);
            return new Bundle();
        }
    }

    public static Bundle safeGetBundleExtra(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getBundleExtra failed on intent " + th2.getMessage(), true);
            return new Bundle();
        }
    }

    public static byte[] safeGetByteArrayExtra(Intent intent, String str) {
        try {
            return intent.getByteArrayExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getByteArrayExtra failed on intent " + th2.getMessage(), true);
            return new byte[0];
        }
    }

    public static int safeGetInt(Bundle bundle, String str, int i11) {
        try {
            return bundle.getInt(str, i11);
        } catch (Throwable th2) {
            a.a(f33822a, "getInt failed on bundle " + th2.getMessage(), true);
            return i11;
        }
    }

    public static int[] safeGetIntArray(Bundle bundle, String str) {
        try {
            return bundle.getIntArray(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getIntArray failed on bundle " + th2.getMessage(), true);
            return new int[0];
        }
    }

    public static int[] safeGetIntArrayExtra(Intent intent, String str) {
        try {
            return intent.getIntArrayExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getIntArrayExtra failed on intent " + th2.getMessage(), true);
            return new int[0];
        }
    }

    public static int safeGetIntExtra(Intent intent, String str, int i11) {
        try {
            return intent.getIntExtra(str, i11);
        } catch (Throwable th2) {
            a.a(f33822a, "getIntExtra failed on intent " + th2.getMessage(), true);
            return i11;
        }
    }

    public static long safeGetLongExtra(Intent intent, String str, long j11) {
        try {
            return intent.getLongExtra(str, j11);
        } catch (Throwable th2) {
            a.a(f33822a, "getLongExtra failed on intent " + th2.getMessage(), true);
            return j11;
        }
    }

    @Deprecated
    public static <T extends Parcelable> T safeGetParcelable(Bundle bundle, String str) {
        try {
            return bundle.getParcelable(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getParcelable failed on bundle " + th2.getMessage(), true);
            return null;
        }
    }

    public static Parcelable[] safeGetParcelableArrayExtra(Intent intent, String str) {
        try {
            return intent.getParcelableArrayExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getParcelableArrayExtra failed on intent " + th2.getMessage(), true);
            return new Parcelable[0];
        }
    }

    @Deprecated
    public static <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str) {
        try {
            return intent.getParcelableExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getParcelableExtra failed on intent " + th2.getMessage(), true);
            return null;
        }
    }

    public static <T extends Serializable> T safeGetSerializable(Bundle bundle, String str, Class<T> cls) {
        try {
            Serializable serializable = bundle.getSerializable(str);
            if (cls.isInstance(serializable)) {
                return (Serializable) cls.cast(serializable);
            }
            return null;
        } catch (Throwable th2) {
            a.a(f33822a, "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    @Deprecated
    public static <T extends Serializable> T safeGetSerializableExtra(Intent intent, String str) {
        try {
            return intent.getSerializableExtra(str);
        } catch (ClassCastException e11) {
            a.a(f33822a, "Invalide class for Serializable: " + e11.getMessage(), true);
            return null;
        } catch (Throwable th2) {
            a.a(f33822a, "getSerializableExtra failed on intent " + th2.getMessage(), true);
            return null;
        }
    }

    public static String safeGetString(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getString failed on bundle " + th2.getMessage(), true);
            return "";
        }
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent intent, String str) {
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getStringArrayListExtra failed on intent " + th2.getMessage(), true);
            return new ArrayList<>();
        }
    }

    public static String safeGetStringExtra(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "getStringExtra failed on intent " + th2.getMessage(), true);
            return "";
        }
    }

    public static boolean safeHasExtra(Intent intent, String str) {
        try {
            return intent.hasExtra(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Intent safeParseUri(String str, int i11) throws URISyntaxException {
        if (str == null) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i11);
        filterIntent(parseUri);
        return parseUri;
    }

    public static void safeRemoveExtra(Intent intent, String str) {
        try {
            intent.removeExtra(str);
        } catch (Throwable th2) {
            a.a(f33822a, "removeExtra failed on intent " + th2.getMessage(), true);
        }
    }

    public static boolean safeStartActivity(Context context, Intent intent) {
        return safeStartActivity(context, intent, (Bundle) null);
    }

    public static boolean safeStartActivityForResultStatic(Activity activity, Intent intent, int i11) {
        try {
            activity.startActivityForResult(intent, i11);
            return true;
        } catch (ActivityNotFoundException e11) {
            a.a(f33822a, "safeStartActivityForResult: ActivityNotFoundException ", (Throwable) e11);
            return false;
        } catch (Exception e12) {
            a.a(f33822a, "safeStartActivityForResult: Exception ", (Throwable) e12);
            return false;
        } catch (Throwable th2) {
            a.a(f33822a, "safeStartActivityForResult: throwable ", th2);
            return false;
        }
    }

    @Deprecated
    public boolean safeStartActivityForResult(Activity activity, Intent intent, int i11) {
        try {
            activity.startActivityForResult(intent, i11);
            return true;
        } catch (ActivityNotFoundException e11) {
            a.a(f33822a, "safeStartActivityForResult: ActivityNotFoundException ", (Throwable) e11);
            return false;
        } catch (Exception e12) {
            a.a(f33822a, "safeStartActivityForResult: Exception ", (Throwable) e12);
            return false;
        } catch (Throwable th2) {
            a.a(f33822a, "safeStartActivityForResult: throwable ", th2);
            return false;
        }
    }

    public static boolean safeGetBoolean(Bundle bundle, String str, boolean z11) {
        try {
            return bundle.getBoolean(str, z11);
        } catch (Throwable th2) {
            a.a(f33822a, "getBoolean failed with throwable: " + th2.getMessage());
            return z11;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean safeStartActivity(Context context, Intent intent, Bundle bundle) {
        try {
            context.startActivity(intent, bundle);
            return true;
        } catch (ActivityNotFoundException e11) {
            a.a(f33822a, "safeStartActivity: ActivityNotFoundException ", (Throwable) e11);
            return false;
        } catch (Exception unused) {
            a.a(f33822a, "safeStartActivityForResult: Exception");
            return false;
        } catch (Throwable unused2) {
            a.a(f33822a, "safeStartActivityForResult: throwable");
            return false;
        }
    }

    public static <T extends Parcelable> T safeGetParcelable(Bundle bundle, String str, Class<T> cls) {
        try {
            Parcelable parcelable = bundle.getParcelable(str);
            if (cls.isInstance(parcelable)) {
                return (Parcelable) cls.cast(parcelable);
            }
            return null;
        } catch (Throwable th2) {
            a.a(f33822a, "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str, Class<T> cls) {
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra(str);
            if (cls.isInstance(parcelableExtra)) {
                return (Parcelable) cls.cast(parcelableExtra);
            }
            return null;
        } catch (Throwable th2) {
            a.a(f33822a, "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    public static <T extends Serializable> T safeGetSerializableExtra(Intent intent, String str, Class<T> cls) {
        try {
            Serializable serializableExtra = intent.getSerializableExtra(str);
            if (cls.isInstance(serializableExtra)) {
                return (Serializable) cls.cast(serializableExtra);
            }
            return null;
        } catch (Throwable th2) {
            a.a(f33822a, "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean safeStartActivityForResultStatic(Activity activity, Intent intent, int i11, Bundle bundle) {
        try {
            activity.startActivityForResult(intent, i11, bundle);
            return true;
        } catch (ActivityNotFoundException e11) {
            a.a(f33822a, "safeStartActivityForResult: ActivityNotFoundException ", (Throwable) e11);
            return false;
        } catch (Exception unused) {
            a.a(f33822a, "safeStartActivityForResult: Exception");
            return false;
        } catch (Throwable unused2) {
            a.a(f33822a, "safeStartActivityForResult: throwable");
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    public boolean safeStartActivityForResult(Activity activity, Intent intent, int i11, Bundle bundle) {
        try {
            activity.startActivityForResult(intent, i11, bundle);
            return true;
        } catch (ActivityNotFoundException e11) {
            a.a(f33822a, "safeStartActivityForResult: ActivityNotFoundException ", (Throwable) e11);
            return false;
        } catch (Exception unused) {
            a.a(f33822a, "safeStartActivityForResult: Exception");
            return false;
        } catch (Throwable unused2) {
            a.a(f33822a, "safeStartActivityForResult: throwable");
            return false;
        }
    }
}
