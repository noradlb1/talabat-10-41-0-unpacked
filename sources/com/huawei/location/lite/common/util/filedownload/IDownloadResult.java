package com.huawei.location.lite.common.util.filedownload;

import java.io.File;

public interface IDownloadResult {
    void onFail(int i11, String str);

    void onSuccess(DownLoadFileBean downLoadFileBean, File file);
}
