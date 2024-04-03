package com.adjust.sdk;

import android.content.Context;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import com.adjust.sdk.GooglePlayServicesClient;
import java.util.Date;
import java.util.Locale;

public final class a {
    public String A;
    public String B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public String f39966a;

    /* renamed from: b  reason: collision with root package name */
    public String f39967b;

    /* renamed from: c  reason: collision with root package name */
    public int f39968c = -1;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f39969d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39970e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f39971f;

    /* renamed from: g  reason: collision with root package name */
    public String f39972g;

    /* renamed from: h  reason: collision with root package name */
    public String f39973h;

    /* renamed from: i  reason: collision with root package name */
    public String f39974i;

    /* renamed from: j  reason: collision with root package name */
    public String f39975j;

    /* renamed from: k  reason: collision with root package name */
    public String f39976k;

    /* renamed from: l  reason: collision with root package name */
    public String f39977l;

    /* renamed from: m  reason: collision with root package name */
    public String f39978m;

    /* renamed from: n  reason: collision with root package name */
    public String f39979n;

    /* renamed from: o  reason: collision with root package name */
    public String f39980o;

    /* renamed from: p  reason: collision with root package name */
    public String f39981p;

    /* renamed from: q  reason: collision with root package name */
    public String f39982q;

    /* renamed from: r  reason: collision with root package name */
    public String f39983r;

    /* renamed from: s  reason: collision with root package name */
    public String f39984s;

    /* renamed from: t  reason: collision with root package name */
    public String f39985t;

    /* renamed from: u  reason: collision with root package name */
    public String f39986u;

    /* renamed from: v  reason: collision with root package name */
    public String f39987v;

    /* renamed from: w  reason: collision with root package name */
    public String f39988w;

    /* renamed from: x  reason: collision with root package name */
    public String f39989x;

    /* renamed from: y  reason: collision with root package name */
    public String f39990y;

    /* renamed from: z  reason: collision with root package name */
    public String f39991z;

    public a(Context context, String str) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale locale = Util.getLocale(configuration);
        int i11 = configuration.screenLayout;
        this.f39974i = e(context);
        this.f39975j = c(context);
        this.f39976k = a(configuration);
        e();
        this.f39977l = Build.MODEL;
        d();
        this.f39978m = Build.MANUFACTURER;
        this.f39979n = "android";
        g();
        this.f39980o = Build.VERSION.RELEASE;
        this.f39981p = b();
        this.f39982q = b(locale);
        this.f39983r = a(locale);
        this.f39984s = b(i11);
        this.f39985t = a(i11);
        this.f39986u = c(displayMetrics);
        this.f39987v = b(displayMetrics);
        this.f39988w = a(displayMetrics);
        this.f39973h = a(str);
        this.f39972g = d(context);
        f();
        this.f39989x = Build.DISPLAY;
        this.f39990y = a();
        this.f39991z = c();
        this.A = a(context);
        this.B = b(context);
        this.C = b(configuration);
    }

    public final String a() {
        String[] supportedAbis = Util.getSupportedAbis();
        return (supportedAbis == null || supportedAbis.length == 0) ? Util.getCpuAbi() : supportedAbis[0];
    }

    public final String a(int i11) {
        int i12 = i11 & 48;
        if (i12 == 16) {
            return "normal";
        }
        if (i12 != 32) {
            return null;
        }
        return Constants.LONG;
    }

    public final String a(Context context) {
        try {
            return Util.dateFormatter.format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).firstInstallTime));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String a(Configuration configuration) {
        if ((configuration.uiMode & 15) == 4) {
            return "tv";
        }
        int i11 = configuration.screenLayout & 15;
        if (i11 == 1 || i11 == 2) {
            return "phone";
        }
        if (i11 == 3 || i11 == 4) {
            return "tablet";
        }
        return null;
    }

    public final String a(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.heightPixels);
    }

    public final String a(String str) {
        if (str == null) {
            return Constants.CLIENT_SDK;
        }
        return Util.formatString("%s@%s", str, Constants.CLIENT_SDK);
    }

    public final String a(Locale locale) {
        return locale.getCountry();
    }

    public final void a(AdjustConfig adjustConfig) {
        if (Util.canReadNonPlayIds(adjustConfig) && !this.f39970e) {
            this.f39971f = Util.getAndroidId(adjustConfig.context);
            this.f39970e = true;
        }
    }

    public final int b(Configuration configuration) {
        return configuration.uiMode & 15;
    }

    public final String b() {
        return "" + Build.VERSION.SDK_INT;
    }

    public final String b(int i11) {
        int i12 = i11 & 15;
        if (i12 == 1) {
            return Constants.SMALL;
        }
        if (i12 == 2) {
            return "normal";
        }
        if (i12 == 3) {
            return Constants.LARGE;
        }
        if (i12 != 4) {
            return null;
        }
        return Constants.XLARGE;
    }

    public final String b(Context context) {
        try {
            return Util.dateFormatter.format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).lastUpdateTime));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String b(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.widthPixels);
    }

    public final String b(Locale locale) {
        return locale.getLanguage();
    }

    public final void b(AdjustConfig adjustConfig) {
        if (Util.canReadPlayIds(adjustConfig)) {
            Context context = adjustConfig.context;
            String str = this.f39966a;
            Boolean bool = this.f39969d;
            this.f39966a = null;
            this.f39969d = null;
            this.f39967b = null;
            this.f39968c = -1;
            for (int i11 = 1; i11 <= 3; i11++) {
                try {
                    GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, (long) (i11 * 3000));
                    if (this.f39966a == null) {
                        this.f39966a = googlePlayServicesInfo.getGpsAdid();
                    }
                    if (this.f39969d == null) {
                        this.f39969d = googlePlayServicesInfo.isTrackingEnabled();
                    }
                    if (!(this.f39966a == null || this.f39969d == null)) {
                        this.f39967b = "service";
                        this.f39968c = i11;
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            for (int i12 = 1; i12 <= 3; i12++) {
                Object advertisingInfoObject = Util.getAdvertisingInfoObject(context, 11000);
                if (advertisingInfoObject != null) {
                    if (this.f39966a == null) {
                        this.f39966a = Util.getPlayAdId(context, advertisingInfoObject, 1000);
                    }
                    if (this.f39969d == null) {
                        this.f39969d = Util.isPlayTrackingEnabled(context, advertisingInfoObject, 1000);
                    }
                    if (!(this.f39966a == null || this.f39969d == null)) {
                        this.f39967b = "library";
                        this.f39968c = i12;
                        return;
                    }
                }
            }
            if (this.f39966a == null) {
                this.f39966a = str;
            }
            if (this.f39969d == null) {
                this.f39969d = bool;
            }
        }
    }

    public final String c() {
        return Build.ID;
    }

    public final String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String c(DisplayMetrics displayMetrics) {
        int i11 = displayMetrics.densityDpi;
        if (i11 == 0) {
            return null;
        }
        return i11 < 140 ? Constants.LOW : i11 > 200 ? Constants.HIGH : "medium";
    }

    public final String d(Context context) {
        Cursor query;
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.facebook.katana", 64).signatures;
            if (signatureArr != null) {
                if (signatureArr.length == 1) {
                    if (!"30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(signatureArr[0].toCharsString()) || (query = context.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[]{"aid"}, (String) null, (String[]) null, (String) null)) == null) {
                        return null;
                    }
                    if (!query.moveToFirst()) {
                        query.close();
                        return null;
                    }
                    String string = query.getString(query.getColumnIndex("aid"));
                    query.close();
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void d() {
        String str = Build.MANUFACTURER;
    }

    public final String e(Context context) {
        return context.getPackageName();
    }

    public final void e() {
        String str = Build.MODEL;
    }

    public final void f() {
        String str = Build.DISPLAY;
    }

    public final void g() {
        String str = Build.VERSION.RELEASE;
    }
}
