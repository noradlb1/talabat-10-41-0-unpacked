package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.d;
import java.io.Closeable;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f47832a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f47833b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    public static AdvertisingIdClient.Info a(final Context context) {
        if (context == null || !a(context, f47832a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        final d.a a11 = d.a.a(context);
        String a12 = a11.a();
        if (TextUtils.isEmpty(a12)) {
            e.f47853a.execute(new Runnable() {
                public void run() {
                    if (!a11.c()) {
                        a11.b();
                        a11.a(b.e(context));
                    }
                }
            });
            if (a11.e()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            a11.d();
            return null;
        }
        String a13 = d.a(string, a12);
        if (!TextUtils.isEmpty(a13)) {
            return new AdvertisingIdClient.Info(a13, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(a13));
        }
        e.f47853a.execute(new Runnable() {
            public void run() {
                a11.a(b.e(context));
            }
        });
        return null;
    }

    private static boolean a(Context context, Uri uri) {
        Integer b11;
        if (context == null || uri == null || (b11 = e.b(context)) == null || 30462100 > b11.intValue()) {
            return false;
        }
        return e.a(context, uri);
    }

    /* JADX INFO: finally extract failed */
    public static AdvertisingIdClient.Info b(Context context) {
        if (context == null || !c(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(f47833b, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("oaid");
                    int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("limit_track");
                    String string = cursor.getString(columnIndexOrThrow);
                    AdvertisingIdClient.Info info = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursor.getString(columnIndexOrThrow2)).booleanValue());
                    e.a((Closeable) cursor);
                    return info;
                }
            }
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            e.a((Closeable) cursor);
            return info2;
        } catch (Throwable th2) {
            e.a((Closeable) cursor);
            throw th2;
        }
    }

    public static boolean c(Context context) {
        return a(context, f47833b);
    }

    /* access modifiers changed from: private */
    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(f47832a, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("op_wk"));
                    e.a((Closeable) cursor);
                    return string;
                }
            }
            return "";
        } catch (Throwable th2) {
            Log.w("InfoProviderUtil", "get remote key ex: " + th2.getClass().getSimpleName());
            return "";
        } finally {
            e.a(cursor);
        }
    }
}
