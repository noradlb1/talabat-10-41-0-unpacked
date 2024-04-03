package com.baseflow.permissionhandler;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class PermissionManager implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    @Nullable
    private Activity activity;
    private boolean ongoing = false;
    private Map<Integer, Integer> requestResults;
    @Nullable
    private RequestPermissionsSuccessCallback successCallback;

    @FunctionalInterface
    public interface CheckPermissionsSuccessCallback {
        void onSuccess(int i11);
    }

    @FunctionalInterface
    public interface RequestPermissionsSuccessCallback {
        void onSuccess(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    public interface ShouldShowRequestPermissionRationaleSuccessCallback {
        void onSuccess(boolean z11);
    }

    private int checkBluetoothPermissionStatus(Context context) {
        boolean z11;
        List<String> a11 = PermissionUtils.a(context, 21);
        if (a11 == null || a11.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0;
        }
        return 1;
    }

    private int checkNotificationPermissionStatus(Context context) {
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return 1;
        }
        return 0;
    }

    private int determinePermissionStatus(int i11, Context context) {
        boolean z11;
        if (i11 == 17) {
            return checkNotificationPermissionStatus(context);
        }
        if (i11 == 21) {
            return checkBluetoothPermissionStatus(context);
        }
        if ((i11 == 30 || i11 == 28 || i11 == 29) && Build.VERSION.SDK_INT < 31) {
            return checkBluetoothPermissionStatus(context);
        }
        List<String> a11 = PermissionUtils.a(context, i11);
        if (a11 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No android specific permissions needed for: ");
            sb2.append(i11);
            return 1;
        } else if (a11.size() == 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("No permissions found in manifest for: ");
            sb3.append(a11);
            sb3.append(i11);
            if (i11 != 22 || Build.VERSION.SDK_INT >= 30) {
                return 0;
            }
            return 2;
        } else {
            if (context.getApplicationInfo().targetSdkVersion >= 23) {
                z11 = true;
            } else {
                z11 = false;
            }
            for (String next : a11) {
                if (z11) {
                    if (i11 == 16) {
                        String packageName = context.getPackageName();
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                            return 0;
                        }
                        return 1;
                    } else if (i11 == 22) {
                        if (Build.VERSION.SDK_INT < 30) {
                            return 2;
                        }
                        return Environment.isExternalStorageManager() ? 1 : 0;
                    } else if (i11 == 23) {
                        return Settings.canDrawOverlays(context) ? 1 : 0;
                    } else {
                        if (i11 == 24 && Build.VERSION.SDK_INT >= 26) {
                            return context.getPackageManager().canRequestPackageInstalls() ? 1 : 0;
                        }
                        if (i11 == 27) {
                            return ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).isNotificationPolicyAccessGranted() ? 1 : 0;
                        }
                        if (ContextCompat.checkSelfPermission(context, next) != 0) {
                            return 0;
                        }
                    }
                }
            }
            return 1;
        }
    }

    private void executeIntent(String str, int i11) {
        String packageName = this.activity.getPackageName();
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setData(Uri.parse("package:" + packageName));
        this.activity.startActivityForResult(intent, i11);
    }

    private void executeSimpleIntent(String str, int i11) {
        this.activity.startActivityForResult(new Intent(str), i11);
    }

    public void a(int i11, Context context, CheckPermissionsSuccessCallback checkPermissionsSuccessCallback) {
        checkPermissionsSuccessCallback.onSuccess(determinePermissionStatus(i11, context));
    }

    public void b(List<Integer> list, Activity activity2, RequestPermissionsSuccessCallback requestPermissionsSuccessCallback, ErrorCallback errorCallback) {
        if (this.ongoing) {
            errorCallback.onError("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
        } else if (activity2 == null) {
            errorCallback.onError("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
        } else {
            this.successCallback = requestPermissionsSuccessCallback;
            this.activity = activity2;
            this.requestResults = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Integer next : list) {
                if (determinePermissionStatus(next.intValue(), activity2) != 1) {
                    List<String> a11 = PermissionUtils.a(activity2, next.intValue());
                    if (a11 != null && !a11.isEmpty()) {
                        int i11 = Build.VERSION.SDK_INT;
                        if (next.intValue() == 16) {
                            executeIntent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", 209);
                        } else if (i11 >= 30 && next.intValue() == 22) {
                            executeIntent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", 210);
                        } else if (next.intValue() == 23) {
                            executeIntent("android.settings.action.MANAGE_OVERLAY_PERMISSION", 211);
                        } else if (i11 >= 26 && next.intValue() == 24) {
                            executeIntent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", 212);
                        } else if (next.intValue() == 27) {
                            executeSimpleIntent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", 213);
                        } else {
                            arrayList.addAll(a11);
                        }
                    } else if (!this.requestResults.containsKey(next)) {
                        int intValue = next.intValue();
                        this.requestResults.put(next, 0);
                        if (next.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                            this.requestResults.put(next, 0);
                        } else {
                            this.requestResults.put(next, 2);
                        }
                    }
                } else if (!this.requestResults.containsKey(next)) {
                    this.requestResults.put(next, 1);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            if (arrayList.size() > 0) {
                this.ongoing = true;
                ActivityCompat.requestPermissions(activity2, strArr, 24);
                return;
            }
            this.ongoing = false;
            if (this.requestResults.size() > 0) {
                requestPermissionsSuccessCallback.onSuccess(this.requestResults);
            }
        }
    }

    public void c(int i11, Activity activity2, ShouldShowRequestPermissionRationaleSuccessCallback shouldShowRequestPermissionRationaleSuccessCallback, ErrorCallback errorCallback) {
        if (activity2 == null) {
            errorCallback.onError("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> a11 = PermissionUtils.a(activity2, i11);
        if (a11 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No android specific permissions needed for: ");
            sb2.append(i11);
            shouldShowRequestPermissionRationaleSuccessCallback.onSuccess(false);
        } else if (a11.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("No permissions found in manifest for: ");
            sb3.append(i11);
            sb3.append(" no need to show request rationale");
            shouldShowRequestPermissionRationaleSuccessCallback.onSuccess(false);
        } else {
            shouldShowRequestPermissionRationaleSuccessCallback.onSuccess(ActivityCompat.shouldShowRequestPermissionRationale(activity2, a11.get(0)));
        }
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        boolean z11;
        int i13;
        if (i11 != 209 && i11 != 210 && i11 != 211 && i11 != 212 && i11 != 213) {
            return false;
        }
        if (i12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i11 == 209) {
            i13 = 16;
        } else if (i11 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            z11 = Environment.isExternalStorageManager();
            i13 = 22;
        } else if (i11 == 211) {
            z11 = Settings.canDrawOverlays(this.activity);
            i13 = 23;
        } else if (i11 == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            z11 = this.activity.getPackageManager().canRequestPackageInstalls();
            i13 = 24;
        } else if (i11 != 213) {
            return false;
        } else {
            z11 = ((NotificationManager) this.activity.getSystemService(RemoteMessageConst.NOTIFICATION)).isNotificationPolicyAccessGranted();
            i13 = 27;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i13), Integer.valueOf(z11 ? 1 : 0));
        this.successCallback.onSuccess(hashMap);
        return true;
    }

    public boolean onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        if (i11 != 24) {
            this.ongoing = false;
            return false;
        } else if (this.requestResults == null) {
            return false;
        } else {
            for (int i12 = 0; i12 < strArr.length; i12++) {
                String str = strArr[i12];
                int c11 = PermissionUtils.c(str);
                if (c11 != 20) {
                    int i13 = iArr[i12];
                    if (c11 == 7) {
                        if (!this.requestResults.containsKey(7)) {
                            this.requestResults.put(7, Integer.valueOf(PermissionUtils.d(this.activity, str, i13)));
                        }
                        if (!this.requestResults.containsKey(14)) {
                            this.requestResults.put(14, Integer.valueOf(PermissionUtils.d(this.activity, str, i13)));
                        }
                    } else if (c11 == 4) {
                        int d11 = PermissionUtils.d(this.activity, str, i13);
                        if (!this.requestResults.containsKey(4)) {
                            this.requestResults.put(4, Integer.valueOf(d11));
                        }
                    } else if (c11 == 3) {
                        int d12 = PermissionUtils.d(this.activity, str, i13);
                        if (Build.VERSION.SDK_INT < 29 && !this.requestResults.containsKey(4)) {
                            this.requestResults.put(4, Integer.valueOf(d12));
                        }
                        if (!this.requestResults.containsKey(5)) {
                            this.requestResults.put(5, Integer.valueOf(d12));
                        }
                        this.requestResults.put(Integer.valueOf(c11), Integer.valueOf(d12));
                    } else if (!this.requestResults.containsKey(Integer.valueOf(c11))) {
                        this.requestResults.put(Integer.valueOf(c11), Integer.valueOf(PermissionUtils.d(this.activity, str, i13)));
                    }
                    PermissionUtils.e(this.activity, c11);
                }
            }
            this.successCallback.onSuccess(this.requestResults);
            this.ongoing = false;
            return true;
        }
    }
}
