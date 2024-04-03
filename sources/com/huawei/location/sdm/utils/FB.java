package com.huawei.location.sdm.utils;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.IDownloadResult;
import java.io.File;

class FB implements IDownloadResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ yn f50228a;

    public FB(yn ynVar) {
        this.f50228a = ynVar;
    }

    public void onFail(int i11, String str) {
        if (i11 == 10005) {
            this.f50228a.f50230yn.saveLong("libSdm_last_time", System.currentTimeMillis());
        }
        LogConsole.e("SdmFileManager", "download error errorCode:" + i11 + " errorDesc:" + str);
    }

    public void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
        if (downLoadFileBean != null) {
            yn.d(this.f50228a, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
        }
    }
}
