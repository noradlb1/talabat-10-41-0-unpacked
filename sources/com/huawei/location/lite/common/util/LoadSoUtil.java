package com.huawei.location.lite.common.util;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.unzip.AssetUnZipManager;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LoadSoUtil {
    private static final String CPU_ARM_32_BIT = "armeabi-v7a";
    private static final String CPU_ARM_64_BIT = "arm64-v8a";
    private static final String JNI_DIR_PREFIX = "jniLibs";
    public static final String SP_UNZIP_SO_RESULT = "sp_unzip_so_result";
    private static final String TAG = "LoadSoUtil";
    private static boolean isLoadSuccess = false;

    public static String getCurrentCpuAbi(Context context) {
        return Process.is64Bit() ? CPU_ARM_64_BIT : CPU_ARM_32_BIT;
    }

    public static String getFilePath(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getFilesDir().getPath();
    }

    public static synchronized void initLoadSo() {
        synchronized (LoadSoUtil.class) {
            PreferencesHelper preferencesHelper = new PreferencesHelper(SP_UNZIP_SO_RESULT);
            String valueOf = String.valueOf(APKUtil.getAppVersionCode(ContextUtil.getContext()));
            if (preferencesHelper.getBoolean(valueOf)) {
                LogConsole.e(TAG, "load so have init success");
                isLoadSuccess = true;
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getFilePath(SDKComponentType.getComponentType() == 200 ? ContextUtil.getHMSContext() : ContextUtil.getContext()));
            String str = File.separator;
            sb2.append(str);
            sb2.append("kits");
            sb2.append(str);
            sb2.append(ContextUtil.getContext().getPackageName());
            sb2.append(str);
            sb2.append(valueOf);
            sb2.append(str);
            sb2.append("lib");
            String sb3 = sb2.toString();
            String currentCpuAbi = getCurrentCpuAbi(ContextUtil.getContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add(currentCpuAbi);
            AssetUnZipManager assetUnZipManager = new AssetUnZipManager(JNI_DIR_PREFIX, new Un7Z());
            assetUnZipManager.setFilterZipDirs(arrayList);
            boolean copyZipFileFromAssets = assetUnZipManager.copyZipFileFromAssets(sb3);
            isLoadSuccess = copyZipFileFromAssets;
            preferencesHelper.saveBoolean(valueOf, copyZipFileFromAssets);
        }
    }

    public static synchronized boolean loadLocalSo(String str) {
        synchronized (LoadSoUtil.class) {
            if (!isLoadSuccess) {
                LogConsole.e(TAG, "init load so fail");
                return false;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(".so")) {
                    String currentCpuAbi = getCurrentCpuAbi(ContextUtil.getContext());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(getFilePath(SDKComponentType.getComponentType() == 200 ? ContextUtil.getHMSContext() : ContextUtil.getContext()));
                    String str2 = File.separator;
                    sb2.append(str2);
                    sb2.append("kits");
                    sb2.append(str2);
                    sb2.append(ContextUtil.getContext().getPackageName());
                    sb2.append(str2);
                    sb2.append(APKUtil.getAppVersionCode(ContextUtil.getContext()));
                    sb2.append(str2);
                    sb2.append("lib");
                    sb2.append(str2);
                    sb2.append(currentCpuAbi);
                    sb2.append(str2);
                    sb2.append(str);
                    String sb3 = sb2.toString();
                    if (!new File(sb3).exists()) {
                        LogConsole.e(TAG, "load Local so error because of so file not exist");
                        return false;
                    }
                    System.load(sb3);
                    return true;
                }
            }
            LogConsole.e(TAG, "so name not valid");
            return false;
        }
    }

    public static boolean loadSo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str2 + File.separator + str);
            if (file.exists()) {
                if (file.length() > 0) {
                    System.load(file.getCanonicalPath());
                    return true;
                }
            }
            return false;
        } catch (IOException unused) {
            LogConsole.d(TAG, "loadSo exception:Invalid file path");
            return false;
        }
    }
}
