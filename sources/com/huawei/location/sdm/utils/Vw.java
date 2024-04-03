package com.huawei.location.sdm.utils;

import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.IDownloadSupport;

class Vw implements IDownloadSupport {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ yn f50229a;

    public Vw(yn ynVar) {
        this.f50229a = ynVar;
    }

    public boolean isSupportDownloadFile(DownLoadFileBean downLoadFileBean) {
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        if (this.f50229a.Vw()) {
            yn ynVar = this.f50229a;
            return yn.e(ynVar, version, ynVar.Vw);
        }
    }
}
