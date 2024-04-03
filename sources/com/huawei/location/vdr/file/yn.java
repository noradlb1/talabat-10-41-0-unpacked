package com.huawei.location.vdr.file;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileManager;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.filedownload.IDownloadResult;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import com.huawei.location.vdr.listener.FB;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import hb.a;
import java.io.File;

public class yn {
    private FB FB;
    private String Vw;
    /* access modifiers changed from: private */

    /* renamed from: yn  reason: collision with root package name */
    public PreferencesHelper f50293yn;

    public class Vw implements IDownloadResult {
        public Vw() {
        }

        public void onFail(int i11, String str) {
            boolean z11;
            yn ynVar;
            if (i11 == 10005) {
                yn.this.f50293yn.saveLong("libVdr_last_time", System.currentTimeMillis());
                ynVar = yn.this;
                z11 = true;
            } else {
                ynVar = yn.this;
                z11 = false;
            }
            yn.e(ynVar, z11);
            LogConsole.e("VdrFileManager", "download error errorCode:" + i11 + " errorDesc:" + str);
        }

        public void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
            if (downLoadFileBean == null) {
                yn.e(yn.this, false);
                return;
            }
            LogConsole.i("VdrFileManager", "libVdr download Success");
            yn.d(yn.this, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
        }
    }

    /* renamed from: com.huawei.location.vdr.file.yn$yn  reason: collision with other inner class name */
    public class C0093yn implements Runnable {
        public C0093yn() {
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("Loc-VDR-CheckPlugin" + hashCode());
            yn.this.yn();
        }
    }

    public static void d(yn ynVar, File file, String str, String str2) {
        ynVar.getClass();
        synchronized (yn.class) {
            boolean validateFileSHA256 = FileSHA256.validateFileSHA256(file, str);
            StringBuilder sb2 = new StringBuilder();
            String str3 = com.huawei.location.vdr.util.FB.f50297yn;
            sb2.append(str3);
            sb2.append(File.separator);
            sb2.append("libVdr.7z");
            String sb3 = sb2.toString();
            if (!validateFileSHA256) {
                LogConsole.i("VdrFileManager", "file is not integrity");
                ynVar.yn(sb3);
            } else if (!new Un7Z().doUnzip(sb3, str3)) {
                LogConsole.i("VdrFileManager", "unzip file fail!");
                ynVar.yn(sb3);
            } else {
                ynVar.yn(true);
                ynVar.f50293yn.saveString("libVdr_version_num", str2);
                ynVar.f50293yn.saveLong("libVdr_last_time", System.currentTimeMillis());
                LogConsole.i("VdrFileManager", "vdr unzip plugin success!");
                ynVar.yn(sb3);
            }
            ynVar.yn(false);
        }
    }

    public static void e(yn ynVar, boolean z11) {
        FB fb2 = ynVar.FB;
        if (fb2 != null) {
            fb2.handleLoadResult(z11);
        }
    }

    /* access modifiers changed from: private */
    public void yn() {
        synchronized (yn.class) {
            PreferencesHelper preferencesHelper = new PreferencesHelper("sp_libVdrSo_filename");
            this.f50293yn = preferencesHelper;
            long currentTimeMillis = System.currentTimeMillis() - preferencesHelper.getLong("libVdr_last_time");
            this.Vw = this.f50293yn.getString("libVdr_version_num");
            if (!Vw() || currentTimeMillis >= 604800000) {
                LogConsole.i("VdrFileManager", "libVdr file is not exists or determine whether the libVdr file needs to be updated ");
                DownloadFileParam downloadFileParam = new DownloadFileParam();
                downloadFileParam.setFileName("libVdr.7z");
                downloadFileParam.setSaveFilePath(com.huawei.location.vdr.util.FB.f50297yn);
                downloadFileParam.setServiceType("Vdr");
                downloadFileParam.setSubType("libVdr");
                new DownLoadFileManager(downloadFileParam, new a(this)).startDownloadTask(new Vw());
            } else {
                LogConsole.i("VdrFileManager", "libVdr file is exists and is not need update");
                yn(true);
            }
        }
    }

    private void yn(boolean z11) {
        FB fb2 = this.FB;
        if (fb2 != null) {
            fb2.handleLoadResult(z11);
        }
    }

    /* access modifiers changed from: private */
    public boolean yn(DownLoadFileBean downLoadFileBean) {
        boolean z11;
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        if (!Vw()) {
            return true;
        }
        String str = this.Vw;
        LogConsole.i("VdrFileManager", "versionNumFromServer is: " + version + ", versionNumSp is: " + str);
        if (version.compareTo(str) > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    private boolean yn(String str) {
        return new File(str).delete();
    }

    public boolean Vw() {
        File file = new File(com.huawei.location.vdr.util.FB.Vw);
        LogConsole.i("VdrFileManager", "the file isFileExist is " + file.exists());
        return file.exists();
    }

    public void yn(FB fb2) {
        this.FB = fb2;
        ExecutorUtil.getInstance().execute(new C0093yn());
    }
}
