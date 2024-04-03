package com.huawei.location.sdm.utils;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileManager;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import com.huawei.location.sdm.constant.FB;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import java.io.File;

public class yn {
    /* access modifiers changed from: private */
    public String Vw;
    /* access modifiers changed from: private */

    /* renamed from: yn  reason: collision with root package name */
    public PreferencesHelper f50230yn;

    /* renamed from: com.huawei.location.sdm.utils.yn$yn  reason: collision with other inner class name */
    public class C0089yn implements Runnable {
        public C0089yn() {
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("Loc-SDM-CheckPlugin" + hashCode());
            yn.c(yn.this);
        }
    }

    public static void c(yn ynVar) {
        ynVar.getClass();
        synchronized (yn.class) {
            PreferencesHelper preferencesHelper = new PreferencesHelper("sp_libSdmSo_filename");
            ynVar.f50230yn = preferencesHelper;
            long currentTimeMillis = System.currentTimeMillis() - preferencesHelper.getLong("libSdm_last_time");
            ynVar.Vw = ynVar.f50230yn.getString("libSdm_version_num");
            if (!ynVar.Vw() || currentTimeMillis >= 604800000) {
                LogConsole.i("SdmFileManager", "libSdm file is not exists or determine whether the libSdm file needs to be updated ");
                DownloadFileParam downloadFileParam = new DownloadFileParam();
                downloadFileParam.setFileName("libSdm.7z");
                downloadFileParam.setSaveFilePath(FB.f50225yn);
                downloadFileParam.setServiceType("Sdm");
                downloadFileParam.setSubType("libSdm");
                new DownLoadFileManager(downloadFileParam, new Vw(ynVar)).startDownloadTask(new FB(ynVar));
            } else {
                LogConsole.i("SdmFileManager", "libSdm file is exists and is not need update");
            }
        }
    }

    public static void d(yn ynVar, File file, String str, String str2) {
        ynVar.getClass();
        synchronized (yn.class) {
            boolean validateFileSHA256 = FileSHA256.validateFileSHA256(file, str);
            StringBuilder sb2 = new StringBuilder();
            String str3 = FB.f50225yn;
            sb2.append(str3);
            sb2.append(File.separator);
            sb2.append("libSdm.7z");
            String sb3 = sb2.toString();
            if (!validateFileSHA256) {
                LogConsole.i("SdmFileManager", "file is not integrity");
            } else if (!new Un7Z().doUnzip(sb3, str3)) {
                LogConsole.i("SdmFileManager", "unzip file fail!");
            } else {
                ynVar.f50230yn.saveString("libSdm_version_num", str2);
                ynVar.f50230yn.saveLong("libSdm_last_time", System.currentTimeMillis());
                LogConsole.i("SdmFileManager", "unzip plugin success!");
            }
            ynVar.yn(sb3);
        }
    }

    public static boolean e(yn ynVar, String str, String str2) {
        ynVar.getClass();
        LogConsole.i("SdmFileManager", "versionNumFromServer is: " + str + ", versionNumSp is: " + str2);
        return str.compareTo(str2) > 0;
    }

    private boolean yn(String str) {
        return new File(str).delete();
    }

    public boolean Vw() {
        File file = new File(FB.Vw);
        LogConsole.i("SdmFileManager", "the file isFileExist is " + file.exists());
        return file.exists();
    }

    public void yn() {
        ExecutorUtil.getInstance().execute(new C0089yn());
    }
}
