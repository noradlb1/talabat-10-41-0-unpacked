package androidx.core.content;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BuildCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.ObjectsCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.api.common.CarrierType;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static final Object sSync = new Object();
    private static TypedValue sTempValue;

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        @DoNotInline
        public static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        @DoNotInline
        public static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        @DoNotInline
        public static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }

        @DoNotInline
        public static Drawable b(Context context, int i11) {
            return context.getDrawable(i11);
        }

        @DoNotInline
        public static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int a(Context context, int i11) {
            return context.getColor(i11);
        }

        @DoNotInline
        public static <T> T b(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        public static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        public static File b(Context context) {
            return context.getDataDir();
        }

        @DoNotInline
        public static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i11) {
            if ((i11 & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.obtainAndCheckReceiverPermission(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i11 & 1);
        }

        @DoNotInline
        public static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static String a(Context context) {
            return context.getAttributionTag();
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i11) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i11);
        }
    }

    public static final class LegacyServiceMapHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap<Class<?>, String> f11234a;

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            f11234a = hashMap;
            hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
            hashMap.put(UsageStatsManager.class, "usagestats");
            hashMap.put(AppWidgetManager.class, "appwidget");
            hashMap.put(BatteryManager.class, "batterymanager");
            hashMap.put(CameraManager.class, "camera");
            hashMap.put(JobScheduler.class, "jobscheduler");
            hashMap.put(LauncherApps.class, "launcherapps");
            hashMap.put(MediaProjectionManager.class, "media_projection");
            hashMap.put(MediaSessionManager.class, "media_session");
            hashMap.put(RestrictionsManager.class, "restrictions");
            hashMap.put(TelecomManager.class, "telecom");
            hashMap.put(TvInputManager.class, "tv_input");
            hashMap.put(AppOpsManager.class, "appops");
            hashMap.put(CaptioningManager.class, "captioning");
            hashMap.put(ConsumerIrManager.class, "consumer_ir");
            hashMap.put(PrintManager.class, "print");
            hashMap.put(BluetoothManager.class, CarrierType.BLUETOOTH);
            hashMap.put(DisplayManager.class, "display");
            hashMap.put(UserManager.class, "user");
            hashMap.put(InputManager.class, "input");
            hashMap.put(MediaRouter.class, "media_router");
            hashMap.put(NsdManager.class, "servicediscovery");
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            hashMap.put(AudioManager.class, MimeTypes.BASE_TYPE_AUDIO);
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, RemoteMessageConst.NOTIFICATION);
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        ObjectsCompat.requireNonNull(str, "permission must be non-null");
        if (BuildCompat.isAtLeastT() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return 0;
        }
        return -1;
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(context);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File createFilesDir(java.io.File r4) {
        /*
            java.lang.Object r0 = sSync
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x002b
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x0011:
            java.lang.String r1 = "ContextCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r2.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "Unable to create files subdir "
            r2.append(r3)     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r4.getPath()     // Catch:{ all -> 0x002d }
            r2.append(r3)     // Catch:{ all -> 0x002d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002d }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.ContextCompat.createFilesDir(java.io.File):java.io.File");
    }

    @Nullable
    public static String getAttributionTag(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(context);
        }
        return null;
    }

    @NonNull
    public static File getCodeCacheDir(@NonNull Context context) {
        return Api21Impl.a(context);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @ColorRes int i11) {
        return Api23Impl.a(context, i11);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i11) {
        return ResourcesCompat.getColorStateList(context.getResources(), i11, context.getTheme());
    }

    @Nullable
    public static File getDataDir(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i11) {
        return Api21Impl.b(context, i11);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context context) {
        return Api19Impl.a(context);
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context context, @Nullable String str) {
        return Api19Impl.b(context, str);
    }

    @NonNull
    public static Executor getMainExecutor(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(context);
        }
        return ExecutorCompat.create(new Handler(context.getMainLooper()));
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context context) {
        return Api21Impl.c(context);
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context context) {
        return Api19Impl.c(context);
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context context, @NonNull Class<T> cls) {
        return Api23Impl.b(context, cls);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context context, @NonNull Class<?> cls) {
        return Api23Impl.c(context, cls);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.c(context);
        }
        return false;
    }

    public static String obtainAndCheckReceiverPermission(Context context) {
        String str = context.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, int i11) {
        return registerReceiver(context, broadcastReceiver, intentFilter, (String) null, (Handler) null, i11);
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr) {
        return startActivities(context, intentArr, (Bundle) null);
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle bundle) {
        Api16Impl.b(context, intent, bundle);
    }

    public static void startForegroundService(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.b(context, intent);
        } else {
            context.startService(intent);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static Intent registerReceiver(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler, int i11) {
        int i12 = i11 & 1;
        if (i12 == 0 || (i11 & 4) == 0) {
            if (i12 != 0) {
                i11 |= 2;
            }
            int i13 = i11;
            int i14 = i13 & 2;
            if (i14 == 0 && (i13 & 4) == 0) {
                throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            } else if (i14 != 0 && (i13 & 4) != 0) {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            } else if (BuildCompat.isAtLeastT()) {
                return Api33Impl.a(context, broadcastReceiver, intentFilter, str, handler, i13);
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    return Api26Impl.a(context, broadcastReceiver, intentFilter, str, handler, i13);
                }
                if ((i13 & 4) == 0 || str != null) {
                    return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter, obtainAndCheckReceiverPermission(context), handler);
            }
        } else {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        Api16Impl.a(context, intentArr, bundle);
        return true;
    }
}
