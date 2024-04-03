package com.huawei.location.activity;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.activity.util.JniUtils;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LoadSoUtil;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileManager;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import com.huawei.location.lite.common.util.filedownload.IDownloadResult;
import com.huawei.location.lite.common.util.filedownload.IDownloadSupport;
import com.huawei.location.lite.common.util.unzip.Un7Z;
import com.huawei.secure.android.common.encrypt.hash.FileSHA256;
import java.io.File;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private static boolean f49996yn = false;
    /* access modifiers changed from: private */
    public PreferencesHelper FB;
    private com.huawei.location.activity.callback.yn LW;
    private int Vw = 0;

    public class Vw implements IDownloadResult {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49997a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49998b;

        public Vw(String str, String str2) {
            this.f49997a = str;
            this.f49998b = str2;
        }

        public void onFail(int i11, String str) {
            LogConsole.e("ModelFileManager", "download error errorCode:" + i11 + " errorDesc:" + str);
            if (i11 == 10005) {
                LogConsole.i("ModelFileManager", "download fail update the request time");
                yn.this.FB.saveLong(this.f49998b, System.currentTimeMillis());
            }
            yn.b(yn.this, this.f49997a);
        }

        public void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
            LogConsole.i("ModelFileManager", "download success:");
            if (downLoadFileBean == null || file == null) {
                LogConsole.e("ModelFileManager", "file or downLoadFileBean is null");
                yn.b(yn.this, this.f49997a);
                return;
            }
            LogConsole.i("ModelFileManager", "file and downLoadFileBean is not null begin downLoadSuccessDeal");
            yn.c(yn.this, this.f49997a, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
        }
    }

    /* renamed from: com.huawei.location.activity.yn$yn  reason: collision with other inner class name */
    public class C0075yn implements IDownloadSupport {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50001b;

        public C0075yn(String str, String str2) {
            this.f50000a = str;
            this.f50001b = str2;
        }

        public boolean isSupportDownloadFile(DownLoadFileBean downLoadFileBean) {
            LogConsole.i("ModelFileManager", "is Support DownloadFile");
            return !yn.this.yn(ContextUtil.getContext(), this.f50001b) || yn.e(yn.this, downLoadFileBean.getFileAccessInfo().getVersion(), yn.this.FB.getString(this.f50000a));
        }
    }

    private void FB() {
        throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
    }

    private void Vw() {
        if (this.Vw < 3) {
            if (!f49996yn) {
                f49996yn = LoadSoUtil.loadSo("libml.so", Vw.Vw);
                LogConsole.i("ModelFileManager", "loadLocalSo result:" + f49996yn);
            }
            if (f49996yn) {
                LogConsole.i("ModelFileManager", "hasLoadSo is true prepareLoadModelFile:");
                PreferencesHelper preferencesHelper = new PreferencesHelper("spModelFileName");
                this.FB = preferencesHelper;
                long j11 = preferencesHelper.getLong("spModelLastTime");
                LogConsole.i("ModelFileManager", "sp--lastTimeMillis:" + j11);
                if (System.currentTimeMillis() - j11 >= 604800000 || !yn(ContextUtil.getContext(), "Ml_Location.net")) {
                    LogConsole.i("ModelFileManager", "model file is not exists or determine whether the model file needs to be updated ");
                    yn("Ml_Location.net", "activitityRecognition", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "spModelVersionNum", "spModelLastTime");
                    return;
                }
                LogConsole.i("ModelFileManager", "model file is exists and is not need update");
                yn();
                return;
            }
            LogConsole.e("ModelFileManager", "hasLoadSo is false");
            this.Vw++;
            Vw();
            return;
        }
        LogConsole.e("ModelFileManager", "maxTryTime failed, LoadSo is false");
        FB();
        throw null;
    }

    public static void b(yn ynVar, String str) {
        ynVar.getClass();
        if (str.equals("activity.7z") && ynVar.yn(ContextUtil.getContext(), str)) {
            LogConsole.i("ModelFileManager", "so file is exists");
            ynVar.Vw();
        } else if (!str.equals("Ml_Location.net") || !ynVar.yn(ContextUtil.getContext(), "Ml_Location.net")) {
            LogConsole.e("ModelFileManager", "model or so file is not exists");
            ynVar.FB();
            throw null;
        } else {
            LogConsole.i("ModelFileManager", "model file is exists");
            ynVar.yn();
        }
    }

    public static void c(yn ynVar, String str, File file, String str2, String str3) {
        ynVar.getClass();
        boolean validateFileSHA256 = FileSHA256.validateFileSHA256(file, str2);
        StringBuilder sb2 = new StringBuilder();
        String str4 = Vw.f49988yn;
        sb2.append(str4);
        sb2.append(str);
        String sb3 = sb2.toString();
        if (str.equals("activity.7z")) {
            if (!validateFileSHA256) {
                LogConsole.e("ModelFileManager", "so file is not integrity");
                ynVar.FB.saveString("spSoVersionNum", "-1");
                ynVar.FB.saveLong("spSoLastTime", System.currentTimeMillis() - 604800000);
                ynVar.FB();
                throw null;
            } else if (new Un7Z().doUnzip(sb3, str4)) {
                ynVar.FB.saveString("spSoVersionNum", str3);
                ynVar.FB.saveLong("spSoLastTime", System.currentTimeMillis());
                LogConsole.i("ModelFileManager", "unzip file success!");
                ynVar.yn(sb3);
                ynVar.Vw();
            } else {
                LogConsole.i("ModelFileManager", "unzip file fail!");
                ynVar.FB();
                throw null;
            }
        } else if (validateFileSHA256) {
            LogConsole.i("ModelFileManager", "file is integrity");
            LogConsole.i("ModelFileManager", "save file success");
            ynVar.FB.saveString("spModelVersionNum", str3);
            ynVar.FB.saveLong("spModelLastTime", System.currentTimeMillis());
            ynVar.yn();
        } else {
            LogConsole.e("ModelFileManager", "model file is not integrity");
            ynVar.FB.saveString("spModelVersionNum", "-1");
            ynVar.FB.saveLong("spModelLastTime", System.currentTimeMillis() - 604800000);
            ynVar.FB();
            throw null;
        }
    }

    public static boolean e(yn ynVar, String str, String str2) {
        ynVar.getClass();
        LogConsole.i("ModelFileManager", "versionNumFromServer is: " + str + ", versionNumSp is: " + str2);
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.compareTo(str2) > 0;
    }

    private void yn() {
        StringBuilder sb2;
        try {
            int loadModelByAssets = JniUtils.loadModelByAssets(ContextUtil.getContext().getAssets(), Vw.f49988yn + "Ml_Location.net");
            if (loadModelByAssets == 0) {
                sb2.append("Load ModelFile success resultCode:");
                sb2.append(loadModelByAssets);
                LogConsole.i("ModelFileManager", sb2.toString());
                com.huawei.location.activity.callback.yn ynVar = this.LW;
                if (ynVar != null) {
                    ynVar.modelFileLoadSuccess();
                    return;
                }
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("Load ModelFile fail resultCode:");
            sb2.append(loadModelByAssets);
            LogConsole.i("ModelFileManager", sb2.toString());
            this.FB.saveString("spModelVersionNum", "-1");
            this.FB.saveLong("spModelLastTime", System.currentTimeMillis() - 604800000);
            FB();
            throw null;
        } catch (Throwable unused) {
            throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
        }
    }

    private void yn(String str, String str2, String str3, String str4, String str5) {
        DownloadFileParam downloadFileParam = new DownloadFileParam();
        downloadFileParam.setFileName(str);
        downloadFileParam.setSaveFilePath(Vw.f49988yn);
        downloadFileParam.setServiceType(str2);
        downloadFileParam.setSubType(str3);
        new DownLoadFileManager(downloadFileParam, new C0075yn(str4, str)).startDownloadTask(new Vw(str, str5));
    }

    /* access modifiers changed from: private */
    public boolean yn(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            LogConsole.e("ModelFileManager", "file is empty");
            return false;
        }
        LogConsole.d("ModelFileManager", "judgement the file exists");
        if (str.equals("activity.7z")) {
            file = new File(Vw.Vw + File.separator + "libml.so");
        } else {
            file = new File(com.huawei.location.activity.model.Vw.yn(context) + File.separator + str);
        }
        LogConsole.i("ModelFileManager", "file is not empty");
        return file.exists();
    }

    private boolean yn(String str) {
        return new File(str).delete();
    }

    public void yn(com.huawei.location.activity.callback.yn ynVar) {
        this.LW = ynVar;
        PreferencesHelper preferencesHelper = new PreferencesHelper("spSoFileName");
        this.FB = preferencesHelper;
        long j11 = preferencesHelper.getLong("spSoLastTime");
        LogConsole.i("ModelFileManager", "sp--lastTimeMillis:" + j11);
        if (System.currentTimeMillis() - j11 >= 604800000 || !yn(ContextUtil.getContext(), "activity.7z")) {
            LogConsole.i("ModelFileManager", "so file is not exists or determine whether the model file needs to be updated ");
            yn("activity.7z", "activityRecognitionSo", "mlso", "spSoVersionNum", "spSoLastTime");
            return;
        }
        LogConsole.i("ModelFileManager", "so file is exists and is not need update");
        Vw();
    }
}
