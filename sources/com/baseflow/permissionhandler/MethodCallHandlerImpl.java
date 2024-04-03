package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Objects;

final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    @Nullable
    private Activity activity;
    private final AppSettingsManager appSettingsManager;
    private final Context applicationContext;
    private final PermissionManager permissionManager;
    private final ServiceManager serviceManager;

    public MethodCallHandlerImpl(Context context, AppSettingsManager appSettingsManager2, PermissionManager permissionManager2, ServiceManager serviceManager2) {
        this.applicationContext = context;
        this.appSettingsManager = appSettingsManager2;
        this.permissionManager = permissionManager2;
        this.serviceManager = serviceManager2;
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    c11 = 1;
                    break;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    c11 = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                int parseInt = Integer.parseInt(methodCall.arguments.toString());
                ServiceManager serviceManager2 = this.serviceManager;
                Context context = this.applicationContext;
                Objects.requireNonNull(result);
                serviceManager2.a(parseInt, context, new a(result), new b(result));
                return;
            case 1:
                int parseInt2 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager2 = this.permissionManager;
                Activity activity2 = this.activity;
                Objects.requireNonNull(result);
                permissionManager2.c(parseInt2, activity2, new f(result), new g(result));
                return;
            case 2:
                int parseInt3 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager3 = this.permissionManager;
                Context context2 = this.applicationContext;
                Objects.requireNonNull(result);
                permissionManager3.a(parseInt3, context2, new c(result));
                return;
            case 3:
                AppSettingsManager appSettingsManager2 = this.appSettingsManager;
                Context context3 = this.applicationContext;
                Objects.requireNonNull(result);
                appSettingsManager2.a(context3, new h(result), new i(result));
                return;
            case 4:
                PermissionManager permissionManager4 = this.permissionManager;
                Activity activity3 = this.activity;
                Objects.requireNonNull(result);
                permissionManager4.b((List) methodCall.arguments(), activity3, new d(result), new e(result));
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }
}
