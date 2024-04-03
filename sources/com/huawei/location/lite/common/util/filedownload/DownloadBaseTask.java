package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.chain.TaskRequest;
import com.huawei.location.lite.common.log.LogConsole;

public class DownloadBaseTask implements Task {
    private static final String TAG = "DownloadBaseTask";

    /* renamed from: a  reason: collision with root package name */
    public TaskRequest f50157a;

    /* renamed from: b  reason: collision with root package name */
    public Task.Chain f50158b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadFileParam f50159c;

    public void a(int i11, String str) {
        LogConsole.e(TAG, "download  failed:" + i11 + "desc:" + str);
        this.f50157a.setResult(Result.failure(new Data.Builder().putInt(DownloadConstants.DOWONLOAD_RESULT_CODE_KEY, i11).putString(DownloadConstants.DOWONLOAD_RESULT_DESC_KEY, str).build()), this.f50158b);
    }

    public void runTask(Task.Chain chain) {
        this.f50158b = chain;
        TaskRequest request = chain.getRequest();
        this.f50157a = request;
        Parcelable parcelable = request.getInputData().getParcelable(DownloadConstants.PARAM_DOWNLOAD_FILE);
        if (!(parcelable instanceof DownloadFileParam)) {
            a(10000, "param error");
        } else {
            this.f50159c = (DownloadFileParam) parcelable;
        }
    }
}
