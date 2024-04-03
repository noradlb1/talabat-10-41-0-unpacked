package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService;
import java.io.IOException;

@Keep
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";
    private static final String TAG = "AdvertisingIdClient";

    @Keep
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z11) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z11;
        }

        @Keep
        public String getId() {
            return this.advertisingId;
        }

        @Keep
        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (!TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c"))) {
                    Info a11 = b.a(context);
                    return a11 != null ? a11 : requestAdvertisingIdInfo(context);
                }
                String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable th2) {
                Log.w("AdIdClient", "get Id err: " + th2.getClass().getSimpleName());
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    private static Info getIdInfoViaAIDL(Context context) throws IOException {
        try {
            context.getPackageManager().getPackageInfo(c.a(context), 128);
            a aVar = new a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(c.a(context));
            if (context.bindService(intent, aVar, 1)) {
                try {
                    OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(aVar.a());
                    Info info = new Info(asInterface.getOaid(), asInterface.isOaidTrackLimited());
                    try {
                        context.unbindService(aVar);
                    } catch (Throwable th2) {
                        Log.w("AdIdClient", "unbind " + th2.getClass().getSimpleName());
                    }
                    return info;
                } catch (InterruptedException unused) {
                    throw new IOException("bind hms service InterruptedException");
                } catch (RemoteException unused2) {
                    throw new IOException("bind hms service RemoteException");
                } catch (Throwable th3) {
                    Log.w("AdIdClient", "unbind " + th3.getClass().getSimpleName());
                }
            } else {
                throw new IOException("bind failed");
            }
            throw th;
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        } catch (Exception unused4) {
            throw new IOException("Service not found: Exception");
        }
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo(c.a(context), 128);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(c.a(context));
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) throws IOException {
        if (b.c(context)) {
            Log.i(TAG, "requestAdvertisingIdInfo via provider");
            return b.b(context);
        }
        Log.i(TAG, "requestAdvertisingIdInfo via aidl");
        return getIdInfoViaAIDL(context);
    }

    private static void updateAdvertisingIdInfo(final Context context) {
        e.f47853a.execute(new Runnable() {
            public void run() {
                try {
                    Info unused = AdvertisingIdClient.requestAdvertisingIdInfo(context);
                } catch (Throwable th2) {
                    Log.w("AdIdClient", "update Id err: " + th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z11) throws AdIdVerifyException {
        try {
            Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            if (requestAdvertisingIdInfo != null) {
                return TextUtils.equals(str, requestAdvertisingIdInfo.getId()) && z11 == requestAdvertisingIdInfo.isLimitAdTrackingEnabled();
            }
            Log.w("AdIdClient", "info is null");
            return false;
        } catch (Throwable unused) {
            throw new AdIdVerifyException("Something wrong with verification, please try later.");
        }
    }
}
