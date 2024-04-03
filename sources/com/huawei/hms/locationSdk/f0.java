package com.huawei.hms.locationSdk;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.logwrite.DateUtil;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.huawei.location.lite.common.log.logwrite.LogWriteParam;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.io.File;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class f0 {
    public static LogWriteParam a(LogConfig logConfig) {
        LogWriteParam logWriteParam = new LogWriteParam();
        logWriteParam.setFileExpiredTime(logConfig.getFileExpiredTime());
        logWriteParam.setFileNum(logConfig.getFileNum());
        logWriteParam.setFileSize(logConfig.getFileSize());
        logWriteParam.setLogPath(logConfig.getLogPath());
        return logWriteParam;
    }

    private static String a() {
        return DateUtil.formate(Calendar.getInstance().getTime(), "yy-MM-dd HH:mm:ss.SSS");
    }

    public static String a(Context context) {
        StringBuilder sb2 = new StringBuilder();
        String packageName = context.getPackageName();
        String valueOf = String.valueOf(APKUtil.getThirdAppVersionCode(context.getPackageName()));
        String valueOf2 = String.valueOf(60700300);
        String valueOf3 = String.valueOf(APKUtil.getThirdAppVersionCode("com.huawei.hwid"));
        sb2.append(packageName);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(valueOf);
        sb2.append(",");
        sb2.append("locationSdkVersion");
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(valueOf2);
        sb2.append(",");
        sb2.append("com.huawei.hwid");
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(valueOf3);
        return sb2.toString();
    }

    public static String a(String str, LocationResult locationResult) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t");
        sb2.append(a());
        sb2.append(",");
        sb2.append(str);
        sb2.append(",");
        Location location = locationResult.getLocations().get(0);
        if (location != null) {
            sb2.append(location.getProvider());
            sb2.append(",");
            sb2.append("\t");
            sb2.append(location.getLatitude());
            sb2.append(",");
            sb2.append("\t");
            sb2.append(location.getLongitude());
            sb2.append(",");
            sb2.append(location.getAccuracy());
            sb2.append(",");
            sb2.append("\t");
            sb2.append(location.getTime());
            sb2.append(",");
            sb2.append(location.getSpeed());
            sb2.append(",");
            Bundle extras = location.getExtras();
            SafeBundle safeBundle = new SafeBundle(extras);
            if (extras != null) {
                sb2.append(safeBundle.getString("session_id"));
                sb2.append(",");
                int i11 = safeBundle.getInt("SourceType", Integer.MIN_VALUE);
                if (i11 == Integer.MIN_VALUE) {
                    sb2.append("null");
                } else {
                    sb2.append(i11);
                }
                sb2.append(",");
                sb2.append(safeBundle.getString(LogWriteConstants.LOCATE_TYPE));
                sb2.append(",");
                sb2.append(safeBundle.getInt(LogWriteConstants.VENDOR_TYPE));
                sb2.append(",");
                sb2.append(safeBundle.getString("src"));
                sb2.append(",");
                sb2.append(safeBundle.getInt(LogWriteConstants.SWITCH_HD));
                sb2.append(",");
                sb2.append(safeBundle.getInt(LogWriteConstants.FLOOR));
                sb2.append(",");
                sb2.append(safeBundle.getInt(LogWriteConstants.FLOOR_ACC));
                sb2.append(",");
                sb2.append(safeBundle.getString(LogWriteConstants.BUILDING_ID));
            }
        }
        return sb2.toString();
    }

    public static void a(Context context, String str, String str2) throws ApiException {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(LogWriteConstants.INNER_PATH_DATA_USER1) || str.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA1) || str.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA) || str.startsWith(LogWriteConstants.INNER_PATH_DATA_USER)) {
                str3 = "setLogConfig internal storage - read and write permissions not need to be verified";
            } else {
                HMSLocationLog.i("WriteLocationResultUtil", str2, "setLogConfig Non-internal storage - read and write permissions need to be verified");
                ContextUtil.setContext(context);
                if (!PermissionUtil.checkSelfPermission(context, PermissionUtil.READ_EXTERNAL_PERMISSION)) {
                    throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
                } else if (PermissionUtil.checkSelfPermission(context, PermissionUtil.WRITE_EXTERNAL_PERMISSION)) {
                    str3 = "setLogConfig Permission check pass";
                } else {
                    throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
                }
            }
            HMSLocationLog.i("WriteLocationResultUtil", str2, str3);
            return;
        }
        throw new ApiException(new Status(10100, LocationStatusCode.getStatusCodeString(10100)));
    }

    public static void a(String str, String str2) throws ApiException {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA) && !str.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA1) && !str.startsWith(LogWriteConstants.INNER_PATH_DATA_USER1) && !str.startsWith(LogWriteConstants.INNER_PATH_DATA_USER) && !str.startsWith(LogWriteConstants.OUTTER_PATH_STORAGE_EMULATED1) && !str.startsWith(LogWriteConstants.OUTTER_PATH_STORAGE_EMULATED) && !str.startsWith(LogWriteConstants.OUTTER_PATH_STORAGE_B3E41) && !str.startsWith(LogWriteConstants.OUTTER_PATH_STORAGE_B3E4) && !str.startsWith(LogWriteConstants.OUTTER_PATH_STORAGE_SD1) && !str.startsWith(LogWriteConstants.OUTTER_PATH_STORAGE_SD) && !str.startsWith(LogWriteConstants.OUTTER_PATH_MNT_SD1) && !str.startsWith(LogWriteConstants.OUTTER_PATH_MNT_SD)) {
                throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
            } else if (!a(str)) {
                File file = new File(str);
                try {
                    if (file.exists()) {
                        return;
                    }
                    if (file.mkdirs()) {
                        HMSLocationLog.i("WriteLocationResultUtil", str2, "createFolder success");
                    } else {
                        HMSLocationLog.e("WriteLocationResultUtil", str2, "createFolder fail");
                        throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
                    }
                } catch (SecurityException e11) {
                    HMSLocationLog.e("WriteLocationResultUtil", str2, "createFolder SecurityException:" + e11.getMessage());
                }
            } else {
                throw new ApiException(new Status(10101, LocationStatusCode.getStatusCodeString(10101)));
            }
        } else {
            throw new ApiException(new Status(10100, LocationStatusCode.getStatusCodeString(10100)));
        }
    }

    public static boolean a(String str) throws PatternSyntaxException {
        return !Pattern.compile("^[-a-zA-Z0-9_/.]+$").matcher(str).find();
    }

    public static boolean b() {
        return false;
    }
}
